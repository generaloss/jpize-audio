package jpize.audio.util;

import jpize.audio.al.buffer.AlFormat;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AlAudioStreamerQueued extends AlAudioStreamer {

    private final Queue<byte[]> dataQueue;

    public AlAudioStreamerQueued(AlFormat format, int sampleRate, int buffersNum, int bufferSize) {
        super(format, sampleRate, buffersNum, bufferSize);
        this.dataQueue = new ConcurrentLinkedQueue<>();
    }

    @Override
    protected int read(byte[] buffer) {
        final byte[] data = dataQueue.poll();
        if(data == null)
            return -1;

        System.arraycopy(data, 0, buffer, 0, Math.min(data.length, buffer.length));
        return data.length;
    }

    public Queue<byte[]> getDataQueue() {
        return dataQueue;
    }

    public void queueData(byte[] data) {
        dataQueue.add(data);
    }

}

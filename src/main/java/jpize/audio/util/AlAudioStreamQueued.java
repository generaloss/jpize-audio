package jpize.audio.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AlAudioStreamQueued extends AlAudioStream {

    private final Queue<byte[]> dataQueue;

    public AlAudioStreamQueued(int buffersNum, int bufferSize) {
        super(buffersNum, bufferSize);
        this.dataQueue = new ConcurrentLinkedQueue<>();
    }

    @Override
    protected int read(byte[] buffer) {
        final byte[] frame = dataQueue.poll();
        if(frame == null)
            return 0;

        final int length = Math.min(frame.length, buffer.length);
        System.arraycopy(frame, 0, buffer, 0, length);
        return length;
    }

    @Override
    protected void reset() { }

    public Queue<byte[]> getDataQueue() {
        return dataQueue;
    }

    public void queueData(byte[] data) {
        dataQueue.add(data);
    }

}

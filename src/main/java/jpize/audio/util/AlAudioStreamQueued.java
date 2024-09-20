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
        final byte[] data = dataQueue.poll();
        if(data == null)
            return 0;

        System.arraycopy(data, 0, buffer, 0, Math.min(data.length, buffer.length));
        return data.length;
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

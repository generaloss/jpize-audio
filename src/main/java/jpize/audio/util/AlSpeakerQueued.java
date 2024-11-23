package jpize.audio.util;

import jpize.audio.al.buffer.AlFormat;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AlSpeakerQueued extends AlSpeakerStream {

    private final Queue<byte[]> dataQueue;

    public AlSpeakerQueued(int buffersNum, int bufferSize) {
        super(buffersNum, bufferSize);
        this.dataQueue = new ConcurrentLinkedQueue<>();
    }

    public AlSpeakerQueued(int buffersNum, int bufferSize, AlFormat format, int sampleRate) {
        this(buffersNum, bufferSize);
        this.setFormat(format);
        this.setSampleRate(sampleRate);
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

    public Queue<byte[]> getQueue() {
        return dataQueue;
    }

    public void queueData(byte[] data) {
        dataQueue.add(data);
    }

}

package jpize.audio.util;

import jpize.audio.al.buffer.AlFormat;
import jpize.audio.al.source.AlSource;
import jpize.audio.al.source.AlSourceState;
import org.lwjgl.openal.AL11;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

public class AlSpeaker extends AlSource {

    private final int[] buffers;
    private int bufferIndex;

    private AlFormat format;
    private int sampleRate;

    public AlSpeaker(int buffersNum) {
        this.buffers = new int[buffersNum];
        AL11.alGenBuffers(buffers);
    }

    public AlSpeaker(int buffersNum, AlFormat format, int sampleRate) {
        this(buffersNum);
        this.setFormat(format);
        this.setSampleRate(sampleRate);
    }

    public AlSpeaker setFormat(AlFormat format) {
        this.format = format;
        return this;
    }

    public AlSpeaker setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
        return this;
    }


    public boolean play(byte[] data) {
        if(format == null)
            throw new IllegalStateException("First call setup(format, sampleRate).");

        this.unqueueProcessedBuffers();
        return this.fillFreeBuffer(data);
    }

    private void unqueueProcessedBuffers() {
        int processed = super.getBuffersProcessed();
        for(; processed > 0; processed--)
            super.unqueueBuffers();
    }

    private boolean fillFreeBuffer(byte[] data) {
        // check available buffers
        if((buffers.length - super.getBuffersQueued()) < 1)
            return false;

        // available bufferID
        final int bufferID = buffers[bufferIndex];
        bufferIndex = (bufferIndex + 1) % buffers.length;

        // data
        final ByteBuffer byteBuffer = MemoryUtil.memCalloc(data.length);
        byteBuffer.put(data, 0, data.length);
        byteBuffer.flip();
        AL11.alBufferData(bufferID, format.value, byteBuffer, sampleRate);
        MemoryUtil.memFree(byteBuffer);

        // queue
        super.queueBuffers(bufferID);

        // play
        if(super.getState() != AlSourceState.PLAYING)
            super.play();
        return true;
    }

    @Override
    public void dispose() {
        super.dispose();
        for(int buffer: buffers)
            AL11.alDeleteBuffers(buffer);
    }

}

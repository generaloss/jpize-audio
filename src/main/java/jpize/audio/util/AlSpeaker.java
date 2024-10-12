package jpize.audio.util;

import jpize.audio.al.buffer.AlFormat;
import jpize.audio.al.source.AlSource;
import jpize.audio.al.source.AlSourceState;
import jpize.util.Disposable;
import org.lwjgl.openal.AL11;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

public class AlSpeaker implements Disposable {

    private final AlSource source;
    private final int[] buffers;
    private int bufferIndex;

    private final AlFormat format;
    private final int sampleRate;

    public AlSpeaker(int buffersNum, AlFormat format, int sampleRate) {
        this.source = new AlSource();
        this.buffers = new int[buffersNum];
        AL11.alGenBuffers(buffers);

        this.format = format;
        this.sampleRate = sampleRate;
    }

    public AlSource getSource() {
        return source;
    }

    public boolean isPlaying() {
        return source.isPlaying();
    }

    public boolean play(byte[] data) {
        if(format == null)
            throw new IllegalStateException("First call setup(format, sampleRate).");

        unqueueProcessedBuffers();
        return fillFreeBuffer(data);
    }

    private void unqueueProcessedBuffers() {
        int processed = source.getBuffersProcessed();
        for(; processed > 0; processed--)
            source.unqueueBuffers(); //!D System.out.println("unqueue #" + );
    }

    private boolean fillFreeBuffer(byte[] data) {
        // check available buffers
        if((buffers.length - source.getBuffersQueued()) < 1)
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
        source.queueBuffers(bufferID);

        // play
        if(source.getState() != AlSourceState.PLAYING)
            source.play();
        return true;
    }

    @Override
    public void dispose() {
        source.dispose();
        for(int buffer: buffers)
            AL11.alDeleteBuffers(buffer);
    }

}

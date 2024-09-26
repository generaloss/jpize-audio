package jpize.audio.util;

import jpize.audio.al.buffer.AlFormat;
import jpize.audio.al.source.AlSource;
import jpize.audio.al.source.AlSourceState;
import org.lwjgl.openal.AL11;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

public abstract class AlSpeakerStream extends AlSource {

    private final int[] buffers;
    private int bufferIndex;

    private final byte[] readBuffer;
    private AlSourceState state;
    private boolean looping;

    private AlFormat format;
    private int sampleRate;
    private Runnable onComplete;

    public AlSpeakerStream(int buffersNum, int bufferSize) {
        this.buffers = new int[buffersNum];
        AL11.alGenBuffers(buffers);

        this.readBuffer = new byte[bufferSize];
        this.state = AlSourceState.INITIAL;
    }

    public AlSpeakerStream setup(AlFormat format, int sampleRate) {
        this.format = format;
        this.sampleRate = sampleRate;
        return this;
    }

    abstract int read(byte[] buffer);

    abstract void reset();

    @Override
    public AlSourceState getState() {
        return state;
    }

    public AlSpeakerStream setOnComplete(Runnable onComplete) {
        this.onComplete = onComplete;
        return this;
    }

    @Override
    public AlSpeakerStream play() {
        if(format == null)
            throw new IllegalStateException("First call setup(format, sampleRate).");
        if(this.isPlaying())
            return this;

        if(super.getBuffersQueued() != 0) super.play(); // after pause
        state = AlSourceState.PLAYING;
        return this;
    }

    @Override
    public AlSpeakerStream pause() {
        super.pause();
        state = AlSourceState.PAUSED;
        return this;
    }

    @Override
    public AlSpeakerStream stop() {
        super.stop();
        state = AlSourceState.STOPPED;
        return this;
    }

    @Override
    public boolean isLooping() {
        return looping;
    }

    @Override
    public AlSpeakerStream setLooping(boolean looping) {
        this.looping = looping;
        return this;
    }

    public void update() {
        if(!this.isPlaying())
            return;

        this.unqueueProcessedBuffers();
        this.queueFreeBuffers();
    }

    private void unqueueProcessedBuffers() {
        int processed = super.getBuffersProcessed();
        for(; processed > 0; processed--)
            super.unqueueBuffers(); //!D System.out.println("unqueue #" + );
    }

    private boolean queueFreeBuffers() {
        int count = (buffers.length - super.getBuffersQueued());
        if(count < 1)
            return false;

        for(; count > 0; count--){
            final int bufferID = buffers[bufferIndex];
            if(!fillAndQueue(bufferID))
                return false;
            //!D System.out.println("queue #" + bufferID);
            bufferIndex = (bufferIndex + 1) % buffers.length;
        }

        if(super.getState() != AlSourceState.PLAYING)
            super.play();

        return true;
    }

    private boolean fillAndQueue(int bufferID) {
        int length = this.read(readBuffer);
        if(length == 0){
            return false;

        }else if(length == -1){
            if(looping){
                this.reset();
                length = this.read(readBuffer);
            }else{
                state = AlSourceState.STOPPED;
                if(onComplete != null)
                    onComplete.run();
                return false;
            }
        }

        final ByteBuffer byteBuffer = MemoryUtil.memCalloc(length);
        byteBuffer.put(readBuffer, 0, length);
        byteBuffer.flip();

        AL11.alBufferData(bufferID, format.value, byteBuffer, sampleRate);
        MemoryUtil.memFree(byteBuffer);

        super.queueBuffers(bufferID);
        return true;
    }

}

package jpize.audio.util;

import jpize.audio.al.buffer.AlFormat;
import jpize.audio.al.source.AlSource;
import jpize.audio.al.source.AlSourceState;
import jpize.util.array.IntList;
import org.lwjgl.openal.AL11;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

public abstract class AlAudioStream extends AlSource {

    private final int[] buffers;
    private final IntList freeBuffers;
    private int nextFreeBuffer;

    private final byte[] readBuffer;
    private AlSourceState state;
    private boolean looping;

    private AlFormat format;
    private int sampleRate;
    private Runnable onComplete;

    public AlAudioStream(int buffersNum, int bufferSize) {
        this.buffers = new int[buffersNum];
        AL11.alGenBuffers(buffers);
        this.freeBuffers = new IntList().add(buffers).trim();

        this.readBuffer = new byte[bufferSize];
        this.state = AlSourceState.INITIAL;
    }

    public AlAudioStream setup(AlFormat format, int sampleRate) {
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

    public AlAudioStream setOnComplete(Runnable onComplete) {
        this.onComplete = onComplete;
        return this;
    }

    @Override
    public AlAudioStream play() {
        if(format == null)
            throw new IllegalStateException("First call setup(format, sampleRate).");
        if(this.isPlaying())
            return this;

        this.queueFreeBuffers();
        super.play();

        state = AlSourceState.PLAYING;
        return this;
    }

    @Override
    public AlAudioStream pause() {
        super.pause();
        state = AlSourceState.PAUSED;
        return this;
    }

    @Override
    public AlAudioStream stop() {
        super.stop();
        state = AlSourceState.STOPPED;
        return this;
    }

    @Override
    public boolean isLooping() {
        return looping;
    }

    @Override
    public AlAudioStream setLooping(boolean looping) {
        this.looping = looping;
        return this;
    }

    public void update() {
        if(!this.isPlaying())
            return;

        this.unqueueProcessedBuffers();
        final boolean filled = this.queueFreeBuffers();
        if(filled && super.getState() != AlSourceState.PLAYING){
            super.play();
            System.out.println("play");
        }
    }

    private void unqueueProcessedBuffers() {
        int processed = super.getBuffersProcessed();
        while(processed > 0){
            processed--;
            // unqueue buffer
            final int bufferID = super.unqueueBuffers();
            if(bufferID == 0)
                continue;

            freeBuffers.add(bufferID);
            System.out.println("unqueue " + bufferID);
        }
    }

    private boolean queueFreeBuffers() {
        boolean filled = false;
        while(freeBuffers.isNotEmpty()){
            final int bufferID = buffers[nextFreeBuffer];
            if(!freeBuffers.contains(bufferID))
                break;

            if(!fillAndQueue(bufferID))
                break;

            System.out.println("queue " + bufferID);
            freeBuffers.removeFirst(bufferID);

            nextFreeBuffer++;
            nextFreeBuffer %= buffers.length;

            filled = true;
        }
        return filled;
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

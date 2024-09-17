package jpize.audio.util;

import jpize.audio.al.buffer.AlFormat;
import jpize.audio.al.source.AlSource;
import jpize.util.array.IntList;
import org.lwjgl.openal.AL11;

import java.nio.ByteBuffer;

public abstract class AlAudioStreamer extends AlSource {

    private final AlFormat format;
    private final int sampleRate;

    private final int[] buffers;

    private final byte[] byteArray;
    private final ByteBuffer byteBuffer;
    private final IntList freeBuffers;

    private boolean playing;

    public AlAudioStreamer(AlFormat format, int sampleRate, int buffersNum, int bufferSize) {
        this.format = format;
        this.sampleRate = sampleRate;

        this.buffers = new int[buffersNum];
        AL11.alGenBuffers(buffers);

        this.byteArray = new byte[bufferSize];
        this.byteBuffer = ByteBuffer.allocateDirect(byteArray.length);
        this.freeBuffers = new IntList().add(buffers);
    }

    abstract int read(byte[] buffer);


    public boolean isPlaying() {
        return playing;
    }

    @Override
    public AlAudioStreamer play() {
        if(playing)
            return this;

        playing = true;
        for(int bufferID: buffers)
            if(!fillAndQueue(bufferID))
                break;
        super.play();

        return this;
    }

    @Override
    public AlAudioStreamer pause() {
        throw new UnsupportedOperationException();
    }

    private boolean fillAndQueue(int bufferID) {
        final int length = this.read(byteArray);
        if(length < 1){
            playing = false;
            return false;
        }

        freeBuffers.removeFirst(bufferID);

        byteBuffer.clear();
        byteBuffer.put(byteArray, 0, Math.min(byteArray.length, length));
        byteBuffer.flip();

        AL11.alBufferData(bufferID, format.value, byteBuffer, sampleRate);
        super.queueBuffers(bufferID);

        return true;
    }

    public void update() {
        if(!playing) return;

        boolean filled = false;

        int processed = super.getBuffersProcessed();
        while(processed > 0){
            processed--;
            // unqueue buffer
            final int bufferID = super.unqueueBuffers();
            if(bufferID == 0)
                break;

            freeBuffers.add(bufferID);
        }

        while(freeBuffers.isNotEmpty()){
            final int bufferID = freeBuffers.get(0);
            if(!fillAndQueue(bufferID))
                break;

            filled = true;
        }

        if(filled && !super.isPlaying() && super.getBuffersQueued() != 0){
            super.play();
        }
    }

}

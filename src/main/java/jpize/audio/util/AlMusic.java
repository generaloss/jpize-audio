package jpize.audio.util;

import jpize.audio.io.*;
import jpize.util.res.Resource;

import java.util.function.Supplier;

public class AlMusic extends AlSpeakerStream {

    private final Supplier<AudioInputStream> inputSupplier;
    private AudioInputStream input;

    public AlMusic(Supplier<AudioInputStream> inputSupplier, int buffersNum, int bufferSize) {
        super(buffersNum, bufferSize);
        this.inputSupplier = inputSupplier;
        this.input = inputSupplier.get();
        super.setup(input.getAlFormat(), input.getSampleRate());
    }

    public AlMusic(Resource res, int buffersNum, int bufferSize) {
        this(() -> AudioInputStream.createByFormat(res.extension(), res.inStream()), buffersNum, bufferSize);
    }

    public AlMusic(Resource res) {
        this(res, 3, 40960);
    }

    public AlMusic(String internalPath) {
        this(Resource.internal(internalPath));
    }


    @Override
    protected int read(byte[] buffer) {
        return input.read(buffer);
    }

    @Override
    protected void reset() {
        input.close();
        input = inputSupplier.get();
    }

    @Override
    public void dispose() {
        super.dispose();
        input.close();
    }

}

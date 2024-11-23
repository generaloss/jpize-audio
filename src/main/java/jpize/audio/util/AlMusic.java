package jpize.audio.util;

import jpize.audio.io.*;
import jpize.util.res.Resource;

import java.util.function.Supplier;

public class AlMusic extends AlSpeakerStream {

    private Supplier<AudioInputStream> inputSupplier;
    private AudioInputStream input;

    public AlMusic(int buffersNum, int bufferSize) {
        super(buffersNum, bufferSize);
    }

    public AlMusic() {
        this(3, 40960);
    }

    public AlMusic(Supplier<AudioInputStream> inputSupplier, int buffersNum, int bufferSize) {
        this(buffersNum, bufferSize);
        this.load(inputSupplier);
    }

    public AlMusic(Resource res, int buffersNum, int bufferSize) {
        this(buffersNum, bufferSize);
        this.load(inputSupplier);
    }

    public AlMusic(String internalPath, int buffersNum, int bufferSize) {
        this(buffersNum, bufferSize);
        this.load(internalPath);
    }

    public AlMusic(Supplier<AudioInputStream> inputSupplier) {
        this();
        this.load(inputSupplier);
    }

    public AlMusic(Resource res) {
        this();
        this.load(res);
    }

    public AlMusic(String internalPath) {
        this();
        this.load(internalPath);
    }


    public AlMusic load(Supplier<AudioInputStream> inputSupplier) {
        this.inputSupplier = inputSupplier;
        this.reset();
        super.setFormat(input.getAlFormat());
        super.setSampleRate(input.getSampleRate());
        return this;
    }

    public AlMusic load(Resource res) {
        return this.load(() -> AudioInputStream.createByFormat(res.extension(), res.inStream()));
    }

    public AlMusic load(String internalPath) {
        return this.load(Resource.internal(internalPath));
    }


    @Override
    protected int read(byte[] buffer) {
        if(input != null)
            return input.read(buffer);
        return -1;
    }

    @Override
    protected void reset() {
        if(input != null)
            input.close();
        input = inputSupplier.get();
    }

    @Override
    public void dispose() {
        super.dispose();
        if(input != null)
            input.close();
    }

}

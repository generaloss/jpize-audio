package jpize.audio.util;

import jpize.audio.io.*;
import jpize.util.res.Resource;

public class Music extends AlAudioStreamer {

    private final AudioInputStream input;

    public Music(AudioInputStream input, int buffersNum, int bufferSize) {
        super(input.getAlFormat(), input.getSampleRate(), buffersNum, bufferSize);
        this.input = input;
    }

    public Music(Resource res) {
        this(AudioInputStream.createByFormat(res.extension(), res.inStream()), 2, 20480);
    }

    public Music(String internalPath) {
        this(Resource.internal(internalPath));
    }

    @Override
    protected int read(byte[] buffer) {
        return input.read(buffer);
    }

}

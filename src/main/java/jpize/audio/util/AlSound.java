package jpize.audio.util;

import jpize.audio.al.buffer.AlBuffer;
import jpize.audio.al.buffer.AlFormat;
import jpize.audio.al.buffer.UnsupportedAlFormatException;
import jpize.audio.al.source.AlSource;
import jpize.audio.io.AudioInputStream;
import jpize.util.res.Resource;

import java.io.InputStream;
import java.nio.ByteBuffer;

public class AlSound extends AlSource {

    private final AlBuffer buffer;

    public AlSound() {
        this.buffer = new AlBuffer();
    }

    public AlSound(Resource res) {
        this.buffer = new AlBuffer().load(res);
        super.setBuffer(buffer);
    }

    public AlSound(String filepath) {
        this(Resource.internal(filepath));
    }

    public AlSound(ByteBuffer data, AlFormat format, int frequency) {
        this.buffer = new AlBuffer();
        try{
            buffer.data(data, format, frequency);
            super.setBuffer(buffer);

        }catch(UnsupportedAlFormatException e){
            System.err.println(e.getLocalizedMessage());
        }
    }

    public AlSound(ByteBuffer data, int bits, int channels, int frequency) {
        this(data, AlFormat.by(channels, bits), frequency);
    }


    public AlSound load(AudioInputStream input) {
        buffer.load(input);
        super.setBuffer(buffer);
        return this;
    }

    public AlSound load(String format, InputStream stream) {
        buffer.load(format, stream);
        super.setBuffer(buffer);
        return this;
    }

    public AlSound load(Resource res) {
        buffer.load(res);
        super.setBuffer(buffer);
        return this;
    }

    public AlSound load(String path) {
        buffer.load(path);
        super.setBuffer(buffer);
        return this;
    }


    public AlBuffer getBuffer() {
        return buffer;
    }

    @Override
    public void dispose() {
        buffer.dispose();
        super.dispose();
    }

}

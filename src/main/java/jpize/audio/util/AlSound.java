package jpize.audio.util;

import jpize.audio.al.buffer.AlBuffer;
import jpize.audio.al.buffer.AlFormat;
import jpize.audio.al.buffer.UnsupportedAlFormatException;
import jpize.audio.al.source.AlSource;
import jpize.util.res.Resource;

import java.nio.ByteBuffer;

public class AlSound extends AlSource {

    private final AlBuffer buffer;

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


    public AlBuffer getBuffer() {
        return buffer;
    }

    @Override
    public void dispose() {
        buffer.dispose();
        super.dispose();
    }

}

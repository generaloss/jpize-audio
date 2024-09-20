package jpize.audio.io;

import jpize.util.Utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class AudioInputStream extends AudioData implements Closeable {

    protected final InputStream in;

    public AudioInputStream(InputStream input) {
        this.in = input;
    }

    public InputStream getInputStream() {
        return in;
    }

    abstract public boolean atEnd();

    abstract public int read(byte[] buffer);

    public byte[] readFully() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream(16384);
        final byte[] tempBuffer = new byte[16384];
        while(!atEnd()){
            int length = this.read(tempBuffer);
            if(length == -1)
                break;
            output.write(tempBuffer, 0, length);
        }
        return output.toByteArray();
    }

    @Override
    public void close() {
        Utils.close(in);
    }


    public interface Factory {
        AudioInputStream create(InputStream stream);
    }

    private static final Map<String, Factory> FACTORY_BY_FORMAT = new HashMap<>(){{{
        put("OGG", OggInputStream::new);
        put("MP3", Mp3InputStream::new);
        put("WAV", WavInputStream::new);
    }}};

    public static void register(String format, Factory factory) {
        FACTORY_BY_FORMAT.put(format.toUpperCase(), factory);
    }

    public static AudioInputStream createByFormat(String format, InputStream stream) {
        final Factory factory = FACTORY_BY_FORMAT.get(format.toUpperCase());
        if(factory == null)
            throw new Error("Audio format '" + format.toUpperCase() + "' is not supported.");
        return factory.create(stream);
    }

}

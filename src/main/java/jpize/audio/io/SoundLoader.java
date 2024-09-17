package jpize.audio.io;

import jpize.audio.al.buffer.AlBuffer;
import jpize.util.res.Resource;
import org.lwjgl.BufferUtils;

import java.nio.ByteBuffer;

public class SoundLoader {

    public static void loadStream(AlBuffer alBuffer, AudioInputStream input) {
        if(alBuffer == null)
            return;

        final byte[] data = input.readFully();
        final ByteBuffer buffer = BufferUtils.createByteBuffer(data.length);
        buffer.put(data).flip();
        alBuffer.data(buffer, input.getAlFormat(), input.getSampleRate());
    }

    public static void load(AlBuffer alBuffer, Resource res) {
        loadStream(alBuffer, AudioInputStream.createByFormat(res.extension(), res.inStream()));
    }

}

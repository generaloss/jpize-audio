package jpize.audio.io;

import jpize.util.Disposable;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.TargetDataLine;

public class JavaAudioRecorder implements Disposable {

    private final TargetDataLine line;
    private byte[] buffer;

    public JavaAudioRecorder(int samplingRate, boolean isStereo) {
        this.buffer = new byte[4096];

        final int channels = (isStereo ? 2 : 1);
        final AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
        final AudioFormat format = new AudioFormat(encoding, samplingRate, 16, channels, channels * 2, samplingRate, false);

        try{
            this.line = AudioSystem.getTargetDataLine(format);
            this.line.open(format, buffer.length);
            this.line.start();
        }catch(Exception ex){
            throw new RuntimeException("Error creating JavaSoundAudioRecorder.", ex);
        }
    }


    public int read(byte[] buf, int length, int offset) {
        return line.read(buf, length, offset);
    }

    public void read(short[] buf, int samples, int offset) {
        final int length = (samples * 2);
        if(buffer.length < length)
            buffer = new byte[length];

        int toRead = length;
        while(toRead > 0)
            toRead -= read(buffer, length, 0);

        for(int i = 0; i < samples; i++)
            buf[offset + i] = (short) ((buffer[i * 2] & 0xFF) | (buffer[i * 2 + 1] << 8));
    }

    @Override
    public void dispose() {
        line.close();
    }

}
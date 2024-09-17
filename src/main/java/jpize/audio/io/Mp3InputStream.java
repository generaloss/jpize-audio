package jpize.audio.io;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.SampleBuffer;
import java.io.InputStream;

public class Mp3InputStream extends AudioInputStream {

    private final Decoder decoder;
    private final Bitstream bitstream;
    private SampleBuffer sampleBuffer;
    private byte[] lastFrame;
    private int frameBytesAvailable;

    public Mp3InputStream(InputStream input) {
        super(input);

        this.decoder = new Decoder();
        this.bitstream = new Bitstream(in);

        readFrame();
        super.setup(sampleBuffer.getChannelCount(), 16, sampleBuffer.getSampleFrequency());
    }

    private void readFrame() {
        try{
            final Header header = bitstream.readFrame();
            if(header == null){
                frameBytesAvailable = -1;
                return;
            }

            sampleBuffer = (SampleBuffer) decoder.decodeFrame(header, bitstream);
            bitstream.closeFrame();
            final short[] samples = sampleBuffer.getBuffer();

            lastFrame = new byte[samples.length * 2];
            for(int i = 0; i < lastFrame.length; i += 2){
                final short sample = samples[i / 2];
                lastFrame[i    ] = (byte) (sample & 0xFF);
                lastFrame[i + 1] = (byte) ((sample >> 8) & 0xFF);
            }

            frameBytesAvailable = lastFrame.length;

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean atEnd() {
        return frameBytesAvailable == -1;
    }

    @Override
    public int read(byte[] buffer) {
        if(frameBytesAvailable == 0)
            readFrame();
        if(atEnd())
            return -1;

        final int offset = (lastFrame.length - frameBytesAvailable);
        final int length = Math.min(buffer.length, frameBytesAvailable);
        System.arraycopy(lastFrame, offset, buffer, 0, length);
        frameBytesAvailable -= length;
        return length;
    }

}

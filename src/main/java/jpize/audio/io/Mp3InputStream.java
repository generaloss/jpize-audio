package jpize.audio.io;

import javazoom.jl.decoder.*;

import java.io.InputStream;

public class Mp3InputStream extends AudioInputStream {

    private final Decoder decoder;
    private final Bitstream bitstream;
    private Header header;
    private final SampleBuffer buffer;

    private int frameSize;
    private int framePosition;
    private boolean endOfStream;

    public Mp3InputStream(InputStream input) {
        super(input);
        this.decoder = new Decoder();
        this.bitstream = new Bitstream(input);

        try{
            this.header = bitstream.readFrame();
            if(header == null){
                this.close();
                throw new RuntimeException("Failed to read MP3 header.");
            }

            this.channels = (header.mode() == Header.SINGLE_CHANNEL ? 1 : 2);
            this.sampleRate = header.frequency();
            this.bits = 16;

            this.buffer = new SampleBuffer(sampleRate, channels);
            this.decoder.setOutputBuffer(buffer);
            this.decoder.decodeFrame(header, bitstream);

            this.frameSize = buffer.getBufferLength() * 2;
            this.bitstream.closeFrame();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private boolean readFrame() throws Exception {
        header = bitstream.readFrame();
        if(header == null){
            buffer.clear_buffer();
            endOfStream = true;
            return false;
        }
        buffer.clear_buffer();
        decoder.decodeFrame(header, bitstream);
        frameSize = buffer.getBufferLength() * 2;
        bitstream.closeFrame();
        framePosition = 0;
        return true;
    }

    public int read() {
        if(atEnd())
            return -1;

        try{
            while(framePosition >= frameSize)
                if(!readFrame())
                    return -1;

            int value = buffer.getBuffer()[framePosition / 2];
            if(++framePosition % 2 == 0)
                value >>= 8;

            return value & 0xFF;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public int read(byte[] bytes, int offset, int length) {
        for(int i = 0; i < length; i++){
            final int value = read();
            if(value == -1)
                return (i == 0) ? -1 : i;

            bytes[i] = (byte) value;
        }
        return length;
    }

    @Override
    public int read(byte[] bytes) {
        return read(bytes, 0, bytes.length);
    }

    @Override
    public boolean atEnd() {
        return endOfStream;
    }

    @Override
    public void close() {
        try{
            bitstream.close();
        }catch(BitstreamException ignored){ }
    }

}

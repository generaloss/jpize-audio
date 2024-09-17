package jpize.audio.io;

import java.io.*;

public class WavInputStream extends AudioInputStream {

    private int availableBytes;

    public WavInputStream(InputStream input) {
        super(input);

        try{
            // Header
            if(in.read() != 'R' || in.read() != 'I' || in.read() != 'F' || in.read() != 'F')
                throw new RuntimeException("RIFF header not found");

            this.skipFully(4);

            if(in.read() != 'W' || in.read() != 'A' || in.read() != 'V' || in.read() != 'E')
                throw new RuntimeException("Invalid wave file header");

            final int fmtChunkLength = seekToChunk('f', 'm', 't', ' ');

            // Audio Format
            final int format = in.read() & 0xFF | (in.read() & 0xFF) << 8;
            if(format != 1) // PCM audio format code = 1
                throw new RuntimeException("Unsupported format, WAV files must be PCM");

            // Num Channels
            super.channels = in.read() & 0xFF | (in.read() & 0xFF) << 8;
            if(channels != 1 && channels != 2)
                throw new RuntimeException("WAV files must have 1 or 2 channels: " + channels);

            // Sample Rate
            super.sampleRate = (in.read() & 0xFF | (in.read() & 0xFF) << 8 | (in.read() & 0xFF) << 16 | (in.read() & 0xFF) << 24);

            this.skipFully(6);

            // Bits Per Sample
            super.bits = in.read() & 0xFF | (in.read() & 0xFF) << 8;
            if(super.bits != 16)
                throw new RuntimeException("WAV files must have 16 bits per sample: " + bits);

            // Skip to Data Chunk
            this.skipFully(fmtChunkLength - 16);

            this.availableBytes = seekToChunk('d', 'a', 't', 'a');
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }


    public int read(byte[] buffer) {
        try{
            if(availableBytes == 0)
                return -1;

            int offset = 0;
            do{
                int length = Math.min(in.read(buffer, offset, buffer.length - offset), availableBytes);
                if(length == -1){
                    if(offset > 0)
                        return offset;
                    return -1;
                }
                offset += length;
                availableBytes -= length;
            }
            while(offset < buffer.length);

            return offset;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private void skipFully(long count) throws IOException {
        while(count > 0){
            final long skipped = in.skip(count);
            if(skipped <= 0)
                throw new EOFException("Unable to skip");

            count -= skipped;
        }
    }

    private int seekToChunk(char c1, char c2, char c3, char c4) throws IOException {
        while(true){
            boolean found = in.read() == c1;
            found &= in.read() == c2;
            found &= in.read() == c3;
            found &= in.read() == c4;

            final int chunkLength = in.read() & 0xFF | (in.read() & 0xFF) << 8 | (in.read() & 0xFF) << 16 | (in.read() & 0xFF) << 24;
            if(chunkLength == -1)
                throw new IOException("Chunk not found: " + c1 + c2 + c3 + c4);

            if(found)
                return chunkLength;

            skipFully(chunkLength);
        }
    }

    @Override
    public byte[] readFully() {
        try{
            return in.readAllBytes();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean atEnd() {
        return availableBytes == 0;
    }

    public int available() {
        return availableBytes;
    }

}
package jpize.audio.io;

import jpize.audio.al.buffer.AlFormat;

public class AudioData {

    protected int channels;
    protected int bits;
    protected int sampleRate;

    public AudioData() { }

    public AudioData(int channels, int bits, int sampleRate) {
        this.setup(channels, bits, sampleRate);
    }

    public void setup(int channels, int bits, int sampleRate) {
        this.channels = channels;
        this.bits = bits;
        this.sampleRate = sampleRate;
    }


    public AlFormat getAlFormat() {
        return AlFormat.by(channels, bits);
    }


    public int getChannels() {
        return channels;
    }

    public int getBits() {
        return bits;
    }

    public int getSampleRate() {
        return sampleRate;
    }


    @Override
    public String toString() {
        return channels + "ch " + bits + "bit " + sampleRate + "hz";
    }

}

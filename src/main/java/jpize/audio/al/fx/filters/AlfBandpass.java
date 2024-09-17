package jpize.audio.al.fx.filters;

import jpize.audio.al.fx.AlFilter;
import jpize.audio.al.fx.AlFilterType;

import static org.lwjgl.openal.EXTEfx.*;

public class AlfBandpass extends AlFilter {

    public AlfBandpass() {
        super(AlFilterType.BANDPASS);
    }

    // [0.0, 1.0], default 1.0
    public AlfBandpass setGain(float value) {
        super.setFloat(AL_BANDPASS_GAIN, value);
        return this;
    }

    public float getGain() {
        return super.getFloat(AL_BANDPASS_GAIN);
    }


    // [0.0, 1.0], default 1.0
    public AlfBandpass setGainLF(float value) {
        super.setFloat(AL_BANDPASS_GAINLF, value);
        return this;
    }

    public float getGainLF() {
        return super.getFloat(AL_BANDPASS_GAINLF);
    }


    // [0.0, 1.0], default 1.0
    public AlfBandpass setGainHF(float value) {
        super.setFloat(AL_BANDPASS_GAINHF, value);
        return this;
    }

    public float getGainHF() {
        return super.getFloat(AL_BANDPASS_GAINHF);
    }


}

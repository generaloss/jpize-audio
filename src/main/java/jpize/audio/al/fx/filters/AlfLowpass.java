package jpize.audio.al.fx.filters;

import jpize.audio.al.fx.AlFilter;
import jpize.audio.al.fx.AlFilterType;

import static org.lwjgl.openal.EXTEfx.*;

public class AlfLowpass extends AlFilter {

    public AlfLowpass() {
        super(AlFilterType.LOWPASS);
    }

    // [0.0, 1.0], default 1.0
    public AlfLowpass setGain(float value) {
        super.setFloat(AL_LOWPASS_GAIN, value);
        return this;
    }

    public float getGain() {
        return super.getFloat(AL_LOWPASS_GAIN);
    }


    // [0.0, 1.0], default 1.0
    public AlfLowpass setGainHF(float value) {
        super.setFloat(AL_LOWPASS_GAINHF, value);
        return this;
    }

    public float getGainHF() {
        return super.getFloat(AL_LOWPASS_GAINHF);
    }


}
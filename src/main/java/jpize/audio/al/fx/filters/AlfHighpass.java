package jpize.audio.al.fx.filters;

import jpize.audio.al.fx.AlFilter;
import jpize.audio.al.fx.AlFilterType;

import static org.lwjgl.openal.EXTEfx.*;

public class AlfHighpass extends AlFilter {

    public AlfHighpass() {
        super(AlFilterType.HIGHPASS);
    }

    // [0.0, 1.0], default 1.0
    public AlfHighpass setGain(float value) {
        super.setFloat(AL_HIGHPASS_GAIN, value);
        return this;
    }

    public float getGain() {
        return super.getFloat(AL_HIGHPASS_GAIN);
    }


    // [0.0, 1.0], default 1.0
    public AlfHighpass setGainLF(float value) {
        super.setFloat(AL_HIGHPASS_GAINLF, value);
        return this;
    }

    public float getGainLF() {
        return super.getFloat(AL_HIGHPASS_GAINLF);
    }


}

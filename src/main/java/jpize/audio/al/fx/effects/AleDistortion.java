package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleDistortion extends AlEffect {

    public AleDistortion() {
        super(AlEffectType.DISTORTION);
    }


    // [0.0 ... 1.0], default 0.2
    public AleDistortion setEdge(float value) {
        super.setFloat(AL_DISTORTION_EDGE, value);
        return this;
    }

    public float getEdge() {
        return super.getFloat(AL_DISTORTION_EDGE);
    }


    // [0.01 ... 1.0], default 0.05
    public AleDistortion setGain(float value) {
        super.setFloat(AL_DISTORTION_GAIN, value);
        return this;
    }

    public float getGain() {
        return super.getFloat(AL_DISTORTION_GAIN);
    }


    // [80.0 ... 24000], default 8000
    public AleDistortion setLowpassCutouff(float hz) {
        super.setFloat(AL_DISTORTION_LOWPASS_CUTOFF, hz);
        return this;
    }

    public float getLowpassCutouff() {
        return super.getFloat(AL_DISTORTION_LOWPASS_CUTOFF);
    }


    // [80.0 ... 24000], default 3600
    public AleDistortion setEqCenter(float hz) {
        super.setFloat(AL_DISTORTION_EQCENTER, hz);
        return this;
    }

    public float getEqCenter() {
        return super.getFloat(AL_DISTORTION_EQCENTER);
    }


    // [80.0 ... 24000], default 3600
    public AleDistortion setEqBandWidth(float hz) {
        super.setFloat(AL_DISTORTION_EQBANDWIDTH, hz);
        return this;
    }

    public float getEqBandWidth() {
        return super.getFloat(AL_DISTORTION_EQBANDWIDTH);
    }

}

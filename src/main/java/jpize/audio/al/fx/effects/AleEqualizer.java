package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleEqualizer extends AlEffect {

    public AleEqualizer() {
        super(AlEffectType.EQUALIZER);
    }


    // [0.126 ... 7.943], default 1.0
    public AleEqualizer setLowGain(float value) {
        super.setFloat(AL_EQUALIZER_LOW_GAIN, value);
        return this;
    }

    public float getLowGain() {
        return super.getFloat(AL_EQUALIZER_LOW_GAIN);
    }


    // [50.0 ... 800.0], default 200.0
    public AleEqualizer setLowCutoff(float hz) {
        super.setFloat(AL_EQUALIZER_LOW_CUTOFF, hz);
        return this;
    }

    public float getLowCutoff() {
        return super.getFloat(AL_EQUALIZER_LOW_CUTOFF);
    }


    // [0.126 ... 7.943], default 1.0
    public AleEqualizer setMid1Gain(float value) {
        super.setFloat(AL_EQUALIZER_MID1_GAIN, value);
        return this;
    }

    public float getMid1Gain() {
        return super.getFloat(AL_EQUALIZER_MID1_GAIN);
    }


    // [200.0 ... 3000.0], default 500.0
    public AleEqualizer setMid1Center(float hz) {
        super.setFloat(AL_EQUALIZER_MID1_CENTER, hz);
        return this;
    }

    public float getMid1Center() {
        return super.getFloat(AL_EQUALIZER_MID1_CENTER);
    }


    // [0.01 ... 1.0], default 1.0
    public AleEqualizer setMid1Width(float value) {
        super.setFloat(AL_EQUALIZER_MID1_WIDTH, value);
        return this;
    }

    public float getMid1Width() {
        return super.getFloat(AL_EQUALIZER_MID1_WIDTH);
    }


    // [0.126 ... 7.943], default 1.0
    public AleEqualizer setMid2Gain(float value) {
        super.setFloat(AL_EQUALIZER_MID2_GAIN, value);
        return this;
    }

    public float getMid2Gain() {
        return super.getFloat(AL_EQUALIZER_MID2_GAIN);
    }


    // [1000.0 ... 8000.0], default 3000.0
    public AleEqualizer setMid2Center(float value) {
        super.setFloat(AL_EQUALIZER_MID2_CENTER, value);
        return this;
    }

    public float getMid2Center() {
        return super.getFloat(AL_EQUALIZER_MID2_CENTER);
    }


    // [0.01 ... 1.0], default 1.0
    public AleEqualizer setMid2Width(float value) {
        super.setFloat(AL_EQUALIZER_MID2_WIDTH, value);
        return this;
    }

    public float getMid2Width() {
        return super.getFloat(AL_EQUALIZER_MID2_WIDTH);
    }


    // [0.126 ... 7.943], default 1.0
    public AleEqualizer setHighGain(float value) {
        super.setFloat(AL_EQUALIZER_HIGH_GAIN, value);
        return this;
    }

    public float getHighGain() {
        return super.getFloat(AL_EQUALIZER_HIGH_GAIN);
    }


    // [4000.0 ... 16000.0], default 6000.0
    public AleEqualizer setHighCutoff(float hz) {
        super.setFloat(AL_EQUALIZER_HIGH_CUTOFF, hz);
        return this;
    }

    public float getHighCutoff() {
        return super.getFloat(AL_EQUALIZER_HIGH_CUTOFF);
    }

}

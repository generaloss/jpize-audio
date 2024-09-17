package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleAutowah extends AlEffect {

    public AleAutowah() {
        super(AlEffectType.AUTOWAH);
    }


    // [0.0001 ... 1.0], default 0.06
    public AleAutowah setAttackTime(float seconds) {
        super.setFloat(AL_AUTOWAH_ATTACK_TIME, seconds);
        return this;
    }

    public float getAttackTime() {
        return super.getFloat(AL_AUTOWAH_ATTACK_TIME);
    }


    // [0.0001 ... 1.0], default 0.06
    public AleAutowah setReleaseTime(float seconds) {
        super.setFloat(AL_AUTOWAH_RELEASE_TIME, seconds);
        return this;
    }

    public float getReleaseTime() {
        return super.getFloat(AL_AUTOWAH_RELEASE_TIME);
    }


    // [2.0 ... 1000.0], default 1000.0
    public AleAutowah setResonance(float value) {
        super.setFloat(AL_AUTOWAH_RESONANCE, value);
        return this;
    }

    public float getResonance() {
        return super.getFloat(AL_AUTOWAH_RESONANCE);
    }


    // [0.00003 ... 31621.0], default 11.22
    public AleAutowah setPeakGain(float value) {
        super.setFloat(AL_AUTOWAH_PEAK_GAIN, value);
        return this;
    }

    public float getPeakGain() {
        return super.getFloat(AL_AUTOWAH_PEAK_GAIN);
    }

}
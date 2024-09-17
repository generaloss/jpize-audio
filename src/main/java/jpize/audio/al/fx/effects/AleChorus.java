package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleChorus extends AlEffect {

    public AleChorus() {
        super(AlEffectType.CHORUS);
    }


    // [SINUSOID, TRIANGLE], default TRIANGLE
    public AleChorus setWaveform(AlChorusWaveform value) {
        super.setInt(AL_CHORUS_WAVEFORM, value.value);
        return this;
    }

    public AlChorusWaveform getWaveform() {
        return AlChorusWaveform.byValue(super.getInt(AL_CHORUS_WAVEFORM));
    }


    // [-180 ... 180], default 90
    public AleChorus setPhase(int degrees) {
        super.setInt(AL_CHORUS_PHASE, degrees);
        return this;
    }

    public int getPhase() {
        return super.getInt(AL_CHORUS_PHASE);
    }


    // [0.0 ... 10.0], default 1.1
    public AleChorus setRate(float hz) {
        super.setFloat(AL_CHORUS_RATE, hz);
        return this;
    }

    public float getRate() {
        return super.getFloat(AL_CHORUS_RATE);
    }


    // [0.0 ... 1.0], default 0.1
    public AleChorus setDepth(float value) {
        super.setFloat(AL_CHORUS_DEPTH, value);
        return this;
    }

    public float getDepth() {
        return super.getFloat(AL_CHORUS_DEPTH);
    }


    // [-1.0 ... 1.0], default 0.25
    public AleChorus setFeedback(float value) {
        super.setFloat(AL_CHORUS_FEEDBACK, value);
        return this;
    }

    public float getFeedback() {
        return super.getFloat(AL_CHORUS_FEEDBACK);
    }


    // [0.0 ... 0.016], default 0.016
    public AleChorus setDelay(float seconds) {
        super.setFloat(AL_CHORUS_DELAY, seconds);
        return this;
    }

    public float getDelay() {
        return super.getFloat(AL_CHORUS_DELAY);
    }

}
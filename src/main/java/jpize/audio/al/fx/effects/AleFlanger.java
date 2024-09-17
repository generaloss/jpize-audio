package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleFlanger extends AlEffect {

    public AleFlanger() {
        super(AlEffectType.FLANGER);
    }


    // [SINUSOID, TRIANGLE], default TRIANGLE
    public AleFlanger setWaveform(AlFlangerWaveform value) {
        super.setInt(AL_FLANGER_WAVEFORM, value.value);
        return this;
    }

    public AlFlangerWaveform getWaveform() {
        return AlFlangerWaveform.byValue(super.getInt(AL_FLANGER_WAVEFORM));
    }


    // [-180 ... 180], default 0
    public AleFlanger setPhase(int value) {
        super.setInt(AL_FLANGER_PHASE, value);
        return this;
    }

    public int getPhase() {
        return super.getInt(AL_FLANGER_PHASE);
    }


    // [0.0 ... 10.0], default 0.27
    public AleFlanger setRate(float value) {
        super.setFloat(AL_FLANGER_RATE, value);
        return this;
    }

    public float getRate() {
        return super.getFloat(AL_FLANGER_RATE);
    }


    // [0.0 ... 1.0], default 1.0
    public AleFlanger setDepth(float value) {
        super.setFloat(AL_FLANGER_DEPTH, value);
        return this;
    }

    public float getDepth() {
        return super.getFloat(AL_FLANGER_DEPTH);
    }


    // [-1.0 ... 1.0], default -0.5
    public AleFlanger setFeedback(float value) {
        super.setFloat(AL_FLANGER_FEEDBACK, value);
        return this;
    }

    public float getFeedback() {
        return super.getFloat(AL_FLANGER_FEEDBACK);
    }


    // [0.0 ... 0.004], default 0.002
    public AleFlanger setDelay(float seconds) {
        super.setFloat(AL_FLANGER_DELAY, seconds);
        return this;
    }

    public float getDelay() {
        return super.getFloat(AL_FLANGER_DELAY);
    }


}

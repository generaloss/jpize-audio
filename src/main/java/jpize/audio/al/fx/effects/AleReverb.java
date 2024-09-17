package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleReverb extends AlEffect {

    public AleReverb() {
        super(AlEffectType.REVERB);
    }


    // [0.0 ... 1.0], default 1.0
    public AleReverb setDensity(float value) {
        super.setFloat(AL_REVERB_DENSITY, value);
        return this;
    }

    public float getDensity() {
        return super.getFloat(AL_REVERB_DENSITY);
    }


    // [0.0 ... 1.0], default 1.0
    public AleReverb setDiffusion(float value) {
        super.setFloat(AL_REVERB_DIFFUSION, value);
        return this;
    }

    public float getDiffusion() {
        return super.getFloat(AL_REVERB_DIFFUSION);
    }


    // [0.0 ... 1.0], default 0.32
    public AleReverb setGain(float value) {
        super.setFloat(AL_REVERB_GAIN, value);
        return this;
    }

    public float getGain() {
        return super.getFloat(AL_REVERB_GAIN);
    }


    // [0.0 ... 1.0], default 0.89
    public AleReverb setGainHF(float value) {
        super.setFloat(AL_REVERB_GAINHF, value);
        return this;
    }

    public float getGainHF() {
        return super.getFloat(AL_REVERB_GAINHF);
    }


    // [0.1 ... 20], default 1.49
    public AleReverb setDecayTime(float seconds) {
        super.setFloat(AL_REVERB_DECAY_TIME, seconds);
        return this;
    }

    public float getDecayTime() {
        return super.getFloat(AL_REVERB_DECAY_TIME);
    }


    // [0.1 ... 2.0], default 0.83
    public AleReverb setDecayHFRatio(float value) {
        super.setFloat(AL_REVERB_DECAY_HFRATIO, value);
        return this;
    }

    public float getDecayHFRatio() {
        return super.getFloat(AL_REVERB_DECAY_HFRATIO);
    }


    // [0.0 ... 3.16], default 0.05
    public AleReverb setReflectionsGain(float value) {
        super.setFloat(AL_REVERB_REFLECTIONS_GAIN, value);
        return this;
    }

    public float getReflectionsGain() {
        return super.getFloat(AL_REVERB_REFLECTIONS_GAIN);
    }


    // [0.0 ... 0.3], default 0.007
    public AleReverb setReflectionsDecay(float seconds) {
        super.setFloat(AL_REVERB_REFLECTIONS_DELAY, seconds);
        return this;
    }

    public float getReflectionsDecay() {
        return super.getFloat(AL_REVERB_REFLECTIONS_DELAY);
    }


    // [0.0 ... 10.0], default 1.26
    public AleReverb setLateReverbGain(float value) {
        super.setFloat(AL_REVERB_LATE_REVERB_GAIN, value);
        return this;
    }

    public float getLateReverbGain() {
        return super.getFloat(AL_REVERB_LATE_REVERB_GAIN);
    }


    // [0.0 ... 0.1], default 0.011
    public AleReverb setLateReverbDelay(float seconds) {
        super.setFloat(AL_REVERB_LATE_REVERB_DELAY, seconds);
        return this;
    }

    public float getLateReverbDelay() {
        return super.getFloat(AL_REVERB_LATE_REVERB_DELAY);
    }


    // [0.892 ... 1.0], default 0.994
    public AleReverb setAirAbsorptionGainHF(float value) {
        super.setFloat(AL_REVERB_AIR_ABSORPTION_GAINHF, value);
        return this;
    }

    public float getAirAbsorptionGainHF() {
        return super.getFloat(AL_REVERB_AIR_ABSORPTION_GAINHF);
    }


    // [0.0 ... 10.0], default 0.0
    public AleReverb setRoomRolloffFactor(float value) {
        super.setFloat(AL_REVERB_ROOM_ROLLOFF_FACTOR, value);
        return this;
    }

    public float getRoomRolloffFactor() {
        return super.getFloat(AL_REVERB_ROOM_ROLLOFF_FACTOR);
    }


    // [false, true], default true
    public AleReverb setHFLimitOnOff(boolean value) {
        super.setInt(AL_REVERB_DECAY_HFLIMIT, value ? 1 : 0);
        return this;
    }

    public boolean getHFLimitOnOff() {
        return super.getInt(AL_REVERB_DECAY_HFLIMIT) == 1;
    }



}

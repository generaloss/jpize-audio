package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleEaxReverb extends AlEffect {

    public AleEaxReverb() {
        super(AlEffectType.EAXREVERB);
    }


    // [0.0 ... 1.0], default 1.0
    public AleEaxReverb setDensity(float value) {
        super.setFloat(AL_EAXREVERB_DENSITY, value);
        return this;
    }

    public float getDensity() {
        return super.getFloat(AL_EAXREVERB_DENSITY);
    }


    // [0.0 ... 1.0], default 1.0
    public AleEaxReverb setDiffusion(float value) {
        super.setFloat(AL_EAXREVERB_DIFFUSION, value);
        return this;
    }

    public float getDiffusion() {
        return super.getFloat(AL_EAXREVERB_DIFFUSION);
    }


    // [0.0 ... 1.0], default 0.32
    public AleEaxReverb setGain(float value) {
        super.setFloat(AL_EAXREVERB_GAIN, value);
        return this;
    }

    public float getGain() {
        return super.getFloat(AL_EAXREVERB_GAIN);
    }


    // [0.0 ... 1.0], default 0.89
    public AleEaxReverb setGainHF(float value) {
        super.setFloat(AL_EAXREVERB_GAINHF, value);
        return this;
    }

    public float getGainHF() {
        return super.getFloat(AL_EAXREVERB_GAINHF);
    }


    // [0.0 ... 1.0], default 0.0
    public AleEaxReverb setGainLF(float value) {
        super.setFloat(AL_EAXREVERB_GAINLF, value);
        return this;
    }

    public float getGainLF() {
        return super.getFloat(AL_EAXREVERB_GAINLF);
    }


    // [0.1 ... 20], default 1.49
    public AleEaxReverb setDecayTime(float seconds) {
        super.setFloat(AL_EAXREVERB_DECAY_TIME, seconds);
        return this;
    }

    public float getDecayTime() {
        return super.getFloat(AL_EAXREVERB_DECAY_TIME);
    }


    // [0.1 ... 2.0], default 0.83
    public AleEaxReverb setDecayHFRatio(float value) {
        super.setFloat(AL_EAXREVERB_DECAY_HFRATIO, value);
        return this;
    }

    public float getDecayHFRatio() {
        return super.getFloat(AL_EAXREVERB_DECAY_HFRATIO);
    }


    // [0.1 ... 2.0], default 1.0
    public AleEaxReverb setDecayLFRatio(float value) {
        super.setFloat(AL_EAXREVERB_DECAY_LFRATIO, value);
        return this;
    }

    public float getDecayLFRatio() {
        return super.getFloat(AL_EAXREVERB_DECAY_LFRATIO);
    }


    // [0.0 ... 3.16], default 0.05
    public AleEaxReverb setReflectionsGain(float value) {
        super.setFloat(AL_EAXREVERB_REFLECTIONS_GAIN, value);
        return this;
    }

    public float getReflectionsGain() {
        return super.getFloat(AL_EAXREVERB_REFLECTIONS_GAIN);
    }


    // [0.0 ... 0.3], default 0.007
    public AleEaxReverb setReflectionsDelay(float seconds) {
        super.setFloat(AL_EAXREVERB_REFLECTIONS_DELAY, seconds);
        return this;
    }

    public float getReflectionsDelay() {
        return super.getFloat(AL_EAXREVERB_REFLECTIONS_DELAY);
    }


    // [[-1.0, -1.0, -1.0] ... [1.0, 1.0, 1.0]], default [0.0, 0.0, 0.0]
    public AleEaxReverb setReflectionsPan(float x, float y, float z) {
        super.setFloat(AL_EAXREVERB_REFLECTIONS_PAN, x, y, z);
        return this;
    }

    public float[] getReflectionsPan() {
        final float[] values = new float[3];
        super.getFloat(AL_EAXREVERB_REFLECTIONS_PAN, values);
        return values;
    }


    // [0.0 ... 10.0], default 1.26
    public AleEaxReverb setLateReverbGain(float value) {
        super.setFloat(AL_EAXREVERB_LATE_REVERB_GAIN, value);
        return this;
    }

    public float getLateReverbGain() {
        return super.getFloat(AL_EAXREVERB_LATE_REVERB_GAIN);
    }


    // [0.0 ... 0.1], default 0.011
    public AleEaxReverb setLateReverbDelay(float seconds) {
        super.setFloat(AL_EAXREVERB_LATE_REVERB_DELAY, seconds);
        return this;
    }

    public float getLateReverbDelay() {
        return super.getFloat(AL_EAXREVERB_LATE_REVERB_DELAY);
    }


    // [[-1.0, -1.0, -1.0] ... [1.0, 1.0, 1.0]], default [0.0, 0.0, 0.0]
    public AleEaxReverb setLateReverbPan(float x, float y, float z) {
        super.setFloat(AL_EAXREVERB_LATE_REVERB_PAN, x, y, z);
        return this;
    }

    public float[] getLateReverbPan() {
        final float[] values = new float[3];
        super.getFloat(AL_EAXREVERB_LATE_REVERB_PAN, values);
        return values;
    }


    // [0.075 ... 0.25], default 0.25
    public AleEaxReverb setEchoTime(float value) {
        super.setFloat(AL_EAXREVERB_ECHO_TIME, value);
        return this;
    }

    public float getEchoTime() {
        return super.getFloat(AL_EAXREVERB_ECHO_TIME);
    }


    // [0.0 ... 1.0], default 0.0
    public AleEaxReverb setEchoDepth(float value) {
        super.setFloat(AL_EAXREVERB_ECHO_DEPTH, value);
        return this;
    }

    public float getEchoDepth() {
        return super.getFloat(AL_EAXREVERB_ECHO_DEPTH);
    }


    // [0.04 ... 4.0], default 0.25
    public AleEaxReverb setModulationTime(float value) {
        super.setFloat(AL_EAXREVERB_MODULATION_TIME, value);
        return this;
    }

    public float getModulationTime() {
        return super.getFloat(AL_EAXREVERB_MODULATION_TIME);
    }


    // [0.0 ... 1.0], default 0.0
    public AleEaxReverb setModulationDepth(float value) {
        super.setFloat(AL_EAXREVERB_MODULATION_DEPTH, value);
        return this;
    }

    public float getModulationDepth() {
        return super.getFloat(AL_EAXREVERB_MODULATION_DEPTH);
    }


    // [0.892 ... 1.0], default 0.994
    public AleEaxReverb setAirAbsorptionGainHF(float value) {
        super.setFloat(AL_EAXREVERB_AIR_ABSORPTION_GAINHF, value);
        return this;
    }

    public float getAirAbsorptionGainHF() {
        return super.getFloat(AL_EAXREVERB_AIR_ABSORPTION_GAINHF);
    }


    // [1000.0 ... 20000.0], default 5000.0
    public AleEaxReverb setHFReference(float hz) {
        super.setFloat(AL_EAXREVERB_HFREFERENCE, hz);
        return this;
    }

    public float getHFReference() {
        return super.getFloat(AL_EAXREVERB_HFREFERENCE);
    }


    // [20.0 ... 1000.0], default 250.0
    public AleEaxReverb setLFReference(float hz) {
        super.setFloat(AL_EAXREVERB_LFREFERENCE, hz);
        return this;
    }

    public float getLFReference() {
        return super.getFloat(AL_EAXREVERB_LFREFERENCE);
    }


    // [0.0 ... 10.0], default 0.0
    public AleEaxReverb setRoomRolloffFactor(float value) {
        super.setFloat(AL_EAXREVERB_ROOM_ROLLOFF_FACTOR, value);
        return this;
    }

    public float getRoomRolloffFactor() {
        return super.getFloat(AL_EAXREVERB_ROOM_ROLLOFF_FACTOR);
    }


    // [false, true], default true
    public AleEaxReverb setHFLimitOnOff(boolean value) {
        super.setInt(AL_EAXREVERB_DECAY_HFLIMIT, value ? 1 : 0);
        return this;
    }

    public boolean getHFLimitOnOff() {
        return super.getInt(AL_EAXREVERB_DECAY_HFLIMIT) == 1;
    }

}

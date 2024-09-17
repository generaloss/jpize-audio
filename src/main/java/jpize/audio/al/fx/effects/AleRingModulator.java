package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleRingModulator extends AlEffect {

    public AleRingModulator() {
        super(AlEffectType.RING_MODULATOR);
    }


    // [0.0 ... 8000.0], default 440.0
    public AleRingModulator setFrequency(float hz) {
        super.setFloat(AL_RING_MODULATOR_FREQUENCY, hz);
        return this;
    }

    public float getFrequency() {
        return super.getFloat(AL_RING_MODULATOR_FREQUENCY);
    }


    // [0.0 ... 24000.0], default 800.0
    public AleRingModulator setHighpassCutoff(float hz) {
        super.setFloat(AL_RING_MODULATOR_HIGHPASS_CUTOFF, hz);
        return this;
    }

    public float getHighpassCutoff() {
        return super.getFloat(AL_RING_MODULATOR_HIGHPASS_CUTOFF);
    }


    // [SINUSOID, SAWTOOTH, SQUARE], default SINUSOID
    public AleRingModulator setWaveform(AlRingWaveform value) {
        super.setInt(AL_RING_MODULATOR_WAVEFORM, value.value);
        return this;
    }

    public AlRingWaveform getWaveform() {
        return AlRingWaveform.byValue(super.getInt(AL_RING_MODULATOR_WAVEFORM));
    }

}
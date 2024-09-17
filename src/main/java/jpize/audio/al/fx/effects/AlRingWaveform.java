package jpize.audio.al.fx.effects;


import static org.lwjgl.openal.EXTEfx.AL_RING_MODULATOR_SINUSOID;
import static org.lwjgl.openal.EXTEfx.AL_RING_MODULATOR_SAWTOOTH;
import static org.lwjgl.openal.EXTEfx.AL_RING_MODULATOR_SQUARE;

public enum AlRingWaveform {

    SINUSOID (AL_RING_MODULATOR_SINUSOID), // 0
    SAWTOOTH (AL_RING_MODULATOR_SAWTOOTH), // 1
    SQUARE   (AL_RING_MODULATOR_SQUARE  ); // 2

    public final int value;

    AlRingWaveform(int value) {
        this.value = value;
    }

    public static AlRingWaveform byValue(int value) {
        return values()[value];
    }

}

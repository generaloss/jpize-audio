package jpize.audio.al.fx.effects;

import static org.lwjgl.openal.EXTEfx.AL_VOCAL_MORPHER_WAVEFORM_SINUSOID;
import static org.lwjgl.openal.EXTEfx.AL_VOCAL_MORPHER_WAVEFORM_TRIANGLE;
import static org.lwjgl.openal.EXTEfx.AL_VOCAL_MORPHER_WAVEFORM_SAWTOOTH;

public enum AlMorpherWaveform {

    SINUSOID (AL_VOCAL_MORPHER_WAVEFORM_SINUSOID), // 0
    TRIANGLE (AL_VOCAL_MORPHER_WAVEFORM_TRIANGLE), // 1
    SAWTOOTH (AL_VOCAL_MORPHER_WAVEFORM_SAWTOOTH); // 2

    public final int value;

    AlMorpherWaveform(int value) {
        this.value = value;
    }

    public static AlMorpherWaveform byValue(int value) {
        return values()[value];
    }

}

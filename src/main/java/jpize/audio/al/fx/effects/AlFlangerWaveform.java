package jpize.audio.al.fx.effects;

import static org.lwjgl.openal.EXTEfx.AL_FLANGER_WAVEFORM_SINUSOID;
import static org.lwjgl.openal.EXTEfx.AL_FLANGER_WAVEFORM_TRIANGLE;

public enum AlFlangerWaveform {

    SINUSOID (AL_FLANGER_WAVEFORM_SINUSOID), // 0
    TRIANGLE (AL_FLANGER_WAVEFORM_TRIANGLE); // 1

    public final int value;

    AlFlangerWaveform(int value) {
        this.value = value;
    }

    public static AlFlangerWaveform byValue(int value) {
        return values()[value];
    }

}

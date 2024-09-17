package jpize.audio.al.fx.effects;

import static org.lwjgl.openal.EXTEfx.AL_CHORUS_WAVEFORM_SINUSOID;
import static org.lwjgl.openal.EXTEfx.AL_CHORUS_WAVEFORM_TRIANGLE;

public enum AlChorusWaveform {

    SINUSOID (AL_CHORUS_WAVEFORM_SINUSOID), // 0
    TRIANGLE (AL_CHORUS_WAVEFORM_TRIANGLE); // 1

    public final int value;

    AlChorusWaveform(int value) {
        this.value = value;
    }

    public static AlChorusWaveform byValue(int value) {
        return values()[value];
    }

}

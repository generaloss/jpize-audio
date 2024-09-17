package jpize.audio.al.fx;

import static org.lwjgl.openal.EXTEfx.*;

public enum AlFilterType {

    NULL     (AL_FILTER_NULL    ),
    LOWPASS  (AL_FILTER_LOWPASS ),
    HIGHPASS (AL_FILTER_HIGHPASS),
    BANDPASS (AL_FILTER_BANDPASS);

    public final int value;

    AlFilterType(int value) {
        this.value = value;
    }

    public static AlFilterType byValue(int value) {
        return values()[value];
    }

}

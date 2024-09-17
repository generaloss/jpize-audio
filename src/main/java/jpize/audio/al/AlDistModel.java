package jpize.audio.al;

import static org.lwjgl.openal.AL11.*;

public enum AlDistModel {

    NONE             (AL_NONE                     ), // 0
    INVERSE          (AL_INVERSE_DISTANCE         ), // 532_49
    INVERSE_CLAMPED  (AL_INVERSE_DISTANCE_CLAMPED ), // 532_50
    LINEAR           (AL_LINEAR_DISTANCE          ), // 532_51
    LINEAR_CLAMPED   (AL_LINEAR_DISTANCE_CLAMPED  ), // 532_52
    EXPONENT         (AL_EXPONENT_DISTANCE        ), // 532_53
    EXPONENT_CLAMPED (AL_EXPONENT_DISTANCE_CLAMPED); // 532_54

    public final int value;

    AlDistModel(int value) {
        this.value = value;
    }


    public static AlDistModel byValue(int value) {
        return values()[value - INVERSE.value + 1];
    }

}

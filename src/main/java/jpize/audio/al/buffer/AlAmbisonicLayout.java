package jpize.audio.al.buffer;

import static org.lwjgl.openal.SOFTBformatEx.AL_ACN_SOFT;
import static org.lwjgl.openal.SOFTBformatEx.AL_FUMA_SOFT;

public enum AlAmbisonicLayout {

    FUMA (AL_FUMA_SOFT), // 0
    ACN  (AL_ACN_SOFT ); // 1

    public final int value;

    AlAmbisonicLayout(int value) {
        this.value = value;
    }

    public static AlAmbisonicLayout byValue(int value) {
        return values()[value];
    }

}

package jpize.audio.al.source;

import static org.lwjgl.openal.SOFTUHJ.AL_NORMAL_SOFT;
import static org.lwjgl.openal.SOFTUHJ.AL_SUPER_STEREO_SOFT;

// SOFT_UHJ extension.
public enum StereoMode {

    NORMAL       (AL_NORMAL_SOFT      ), // 0
    SUPER_STEREO (AL_SUPER_STEREO_SOFT); // 1

    public final int value;

    StereoMode(int value) {
        this.value = value;
    }

    public static StereoMode byValue(int value) {
        return values()[value];
    }

}

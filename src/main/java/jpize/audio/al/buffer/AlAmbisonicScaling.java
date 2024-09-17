package jpize.audio.al.buffer;

import static org.lwjgl.openal.SOFTBformatEx.AL_FUMA_SOFT;
import static org.lwjgl.openal.SOFTBformatEx.AL_N3D_SOFT;
import static org.lwjgl.openal.SOFTBformatEx.AL_SN3D_SOFT;

public enum AlAmbisonicScaling {

    FUMA (AL_FUMA_SOFT), // 0
    SN3D (AL_SN3D_SOFT), // 1
    N3D  (AL_N3D_SOFT ); // 2

    public final int value;

    AlAmbisonicScaling(int value) {
        this.value = value;
    }

    public static AlAmbisonicScaling byValue(int value) {
        return values()[value];
    }

}

package jpize.audio.al.context;

import static org.lwjgl.openal.SOFTLoopback.*;

// SOFT_loopback extension.
public enum AlFormatChannels {

    S51    (ALC_5POINT1_SOFT),
    S61    (ALC_6POINT1_SOFT),
    S71    (ALC_7POINT1_SOFT),
    MONO   (ALC_MONO_SOFT   ),
    QUAD   (ALC_QUAD_SOFT   ),
    STEREO (ALC_STEREO_SOFT );

    public final int value;

    AlFormatChannels(int value) {
        this.value = value;
    }

}

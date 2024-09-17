package jpize.audio.al.device;

import static org.lwjgl.openal.ALC11.*;
import static org.lwjgl.openal.SOFTOutputLimiter.ALC_OUTPUT_LIMITER_SOFT;
import static org.lwjgl.openal.SOFTOutputMode.ALC_OUTPUT_MODE_SOFT;
import static org.lwjgl.openal.SOFTLoopback.*;

public enum AlProperty {

    FREQUENCY            (ALC_FREQUENCY           ), // int
    REFRESH              (ALC_REFRESH             ), // int
    SYNC                 (ALC_SYNC                ), // bool
    MONO_SOURCES         (ALC_MONO_SOURCES        ), // int
    STEREO_SOURCES       (ALC_STEREO_SOURCES      ), // int
    // SOFT_output_limiter extension.
    OUTPUT_LIMITER_SOFT  (ALC_OUTPUT_LIMITER_SOFT ), // bool
    // SOFT_output_mode extension.
    OUTPUT_MODE_SOFT     (ALC_OUTPUT_MODE_SOFT    ), // AlOutputMode
    // SOFT_loopback extension.
    FORMAT_CHANNELS_SOFT (ALC_FORMAT_CHANNELS_SOFT), // AlFormatChannels
    FORMAT_TYPE_SOFT     (ALC_FORMAT_TYPE_SOFT    ); // AlFormatType


    public final int value;

    AlProperty(int value) {
        this.value = value;
    }

}

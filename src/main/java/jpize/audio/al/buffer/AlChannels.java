package jpize.audio.al.buffer;

import static org.lwjgl.openal.SOFTBufferSamples.*;

public enum AlChannels {

    SURROUND_5_1 (AL_5POINT1_SOFT, 5),
    SURROUND_6_1 (AL_6POINT1_SOFT, 6),
    SURROUND_7_1 (AL_7POINT1_SOFT, 7),
    MONO         (AL_MONO_SOFT   , 1),
    QUAD         (AL_QUAD_SOFT   , 4),
    REAR         (AL_REAR_SOFT   , 4),
    STEREO       (AL_STEREO_SOFT , 2);

    public final int value;

    AlChannels(int value, int channels) {
        this.value = value;
    }

}

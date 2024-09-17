package jpize.audio.al.buffer;

import static org.lwjgl.openal.SOFTBufferSamples.*;

// Accepted by the internalformat parameter of alBufferSamplesSOFT (values are shared with standard OpenAL, EXT_FLOAT32, EXT_MCFORMATS).
public enum AlInternalFormat {

    SURROUND_5_1_16  (AL_5POINT1_16_SOFT , 16, AlChannels.SURROUND_5_1),
    SURROUND_5_1_32F (AL_5POINT1_32F_SOFT, 32, AlChannels.SURROUND_5_1),
    SURROUND_5_1_8   (AL_5POINT1_8_SOFT  , 8 , AlChannels.SURROUND_5_1),
    SURROUND_6_1_16  (AL_6POINT1_16_SOFT , 16, AlChannels.SURROUND_6_1),
    SURROUND_6_1_32F (AL_6POINT1_32F_SOFT, 32, AlChannels.SURROUND_6_1),
    SURROUND_6_1_8   (AL_6POINT1_8_SOFT  , 8 , AlChannels.SURROUND_6_1),
    SURROUND_7_1_16  (AL_7POINT1_16_SOFT , 16, AlChannels.SURROUND_7_1),
    SURROUND_7_1_32F (AL_7POINT1_32F_SOFT, 32, AlChannels.SURROUND_7_1),
    SURROUND_7_1_8   (AL_7POINT1_8_SOFT  , 8 , AlChannels.SURROUND_7_1),
    MONO_16          (AL_MONO16_SOFT     , 16, AlChannels.MONO        ),
    MONO_32F         (AL_MONO32F_SOFT    , 32, AlChannels.MONO        ),
    MONO_8           (AL_MONO8_SOFT      , 8 , AlChannels.MONO        ),
    QUAD_16          (AL_QUAD16_SOFT     , 16, AlChannels.QUAD        ),
    QUAD_32F         (AL_QUAD32F_SOFT    , 32, AlChannels.QUAD        ),
    QUAD_8           (AL_QUAD8_SOFT      , 8 , AlChannels.QUAD        ),
    REAR_16          (AL_REAR16_SOFT     , 16, AlChannels.REAR        ),
    REAR_32F         (AL_REAR32F_SOFT    , 32, AlChannels.REAR        ),
    REAR_8           (AL_REAR8_SOFT      , 8 , AlChannels.REAR        ),
    STEREO_16        (AL_STEREO16_SOFT   , 16, AlChannels.STEREO      ),
    STEREO_32F       (AL_STEREO32F_SOFT  , 32, AlChannels.STEREO      ),
    STEREO_8         (AL_STEREO8_SOFT    , 8 , AlChannels.STEREO      );

    public final int value;
    public final int bits;
    public final AlChannels channels;

    AlInternalFormat(int value, int bits, AlChannels channels) {
        this.value = value;
        this.bits = bits;
        this.channels = channels;
    }

}

package jpize.audio.al.buffer;

import static org.lwjgl.openal.SOFTBufferSamples.*;

// Accepted by the type parameter of alBufferSamplesSOFT, alBufferSubSamplesSOFT, alGetBufferSamplesSOFT
public enum AlType {

    BYTE           (AL_BYTE_SOFT          ),
    BYTE3          (AL_BYTE3_SOFT         ),
    DOUBLE         (AL_DOUBLE_SOFT        ),
    FLOAT          (AL_FLOAT_SOFT         ),
    INT            (AL_INT_SOFT           ),
    SHORT          (AL_SHORT_SOFT         ),
    UNSIGNED_BYTE  (AL_UNSIGNED_BYTE_SOFT ),
    UNSIGNED_BYTE3 (AL_UNSIGNED_BYTE3_SOFT),
    UNSIGNED_INT   (AL_UNSIGNED_INT_SOFT  ),
    UNSIGNED_SHORT (AL_UNSIGNED_SHORT_SOFT);

    public final int value;

    AlType(int value) {
        this.value = value;
    }

}

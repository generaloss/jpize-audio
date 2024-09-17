package jpize.audio.al.buffer;

import static org.lwjgl.openal.AL11.*;

public enum AlBufProperty {

    FREQUENCY (AL_FREQUENCY), // 819_3
    BITS      (AL_BITS     ), // 819_4
    CHANNELS  (AL_CHANNELS ), // 819_5
    SIZE      (AL_SIZE     ); // 819_6

    public final int value;

    AlBufProperty(int value) {
        this.value = value;
    }

}

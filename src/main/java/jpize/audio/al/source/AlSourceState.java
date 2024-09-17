package jpize.audio.al.source;

import static org.lwjgl.openal.AL11.*;

public enum AlSourceState {

    INITIAL (AL_INITIAL), // 411_3
    PLAYING (AL_PLAYING), // 411_4
    PAUSED  (AL_PAUSED ), // 411_5
    STOPPED (AL_STOPPED), // 411_6

    NONE    (AL_NONE   );

    public final int value;

    AlSourceState(int value) {
        this.value = value;
    }

    public static AlSourceState byValue(int value) {
        if(value == 0) return NONE;
        return values()[value - AL_INITIAL];
    }

}

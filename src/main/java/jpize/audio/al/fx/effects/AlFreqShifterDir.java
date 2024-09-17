package jpize.audio.al.fx.effects;

import static org.lwjgl.openal.EXTEfx.AL_FREQUENCY_SHIFTER_DIRECTION_DOWN;
import static org.lwjgl.openal.EXTEfx.AL_FREQUENCY_SHIFTER_DIRECTION_UP;
import static org.lwjgl.openal.EXTEfx.AL_FREQUENCY_SHIFTER_DIRECTION_OFF;

public enum AlFreqShifterDir {

    DOWN (AL_FREQUENCY_SHIFTER_DIRECTION_DOWN), // 0
    UP   (AL_FREQUENCY_SHIFTER_DIRECTION_UP  ), // 1
    OFF  (AL_FREQUENCY_SHIFTER_DIRECTION_OFF ); // 2

    public final int value;

    AlFreqShifterDir(int value) {
        this.value = value;
    }

    public static AlFreqShifterDir byValue(int value) {
        return values()[value];
    }

}

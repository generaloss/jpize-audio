package jpize.audio.al.source;

import static org.lwjgl.openal.AL11.*;

public enum AlSourceType {

    STATIC       (AL_STATIC      ), // 41_36;
    STREAMING    (AL_STREAMING   ), // 41_37;
    UNDETERMINED (AL_UNDETERMINED); // 41_44;

    public final int value;

    AlSourceType(int value) {
        this.value = value;
    }

    public static AlSourceType byAlConst(int value) {
        return switch(value){
            case AL_STATIC -> STATIC;
            case AL_STREAMING -> STREAMING;
            default -> UNDETERMINED;
        };
    }

}

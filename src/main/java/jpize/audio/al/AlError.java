package jpize.audio.al;

import static org.lwjgl.openal.AL11.*;

public enum AlError {

    INVALID_NAME      (AL_INVALID_NAME     , "Invalid Name"     ),
    INVALID_ENUM      (AL_INVALID_ENUM     , "Invalid Enum"     ),
    INVALID_VALUE     (AL_INVALID_VALUE    , "Invalid Value"    ),
    INVALID_OPERATION (AL_INVALID_OPERATION, "Invalid Operation"),
    OUT_OF_MEMORY     (AL_OUT_OF_MEMORY    , "Out of Memory"    ),
    NO_ERROR          (AL_NO_ERROR         , "No Error"         );


    public final int value;
    public final String message;

    AlError(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public boolean noErrors() {
        return this == NO_ERROR;
    }

    public boolean hasError() {
        return this != NO_ERROR;
    }

    @Override
    public String toString() {
        return message;
    }


    public static AlError byValue(int value) {
        if(value == 0)
            return NO_ERROR;
        return values()[value - INVALID_NAME.value];
    }

}

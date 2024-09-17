package jpize.audio.al;

import static org.lwjgl.openal.ALC11.*;

public enum AlcError {

    INVALID_DEVICE  (ALC_INVALID_DEVICE , "Invalid Device" ), // 4096_1
    INVALID_CONTEXT (ALC_INVALID_CONTEXT, "Invalid Context"), // 4096_2
    INVALID_ENUM    (ALC_INVALID_ENUM   , "Invalid Enum"   ), // 4096_3
    INVALID_VALUE   (ALC_INVALID_VALUE  , "Invalid Value"  ), // 4096_4
    OUT_OF_MEMORY   (ALC_OUT_OF_MEMORY  , "Out of Memory"  ), // 4096_5
    NO_ERROR        (ALC_NO_ERROR       , "No Error"       ); // 0


    public final int value;
    public final String message;

    AlcError(int value, String message) {
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


    public static AlcError byValue(int value) {
        if(value == 0)
            return NO_ERROR;
        return values()[value - INVALID_DEVICE.value];
    }

}

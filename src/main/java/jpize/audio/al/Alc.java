package jpize.audio.al;

import jpize.audio.al.device.AlAbstractDevice;
import jpize.util.Utils;
import org.lwjgl.openal.ALC11;

import static org.lwjgl.openal.ALC10.*;
import static org.lwjgl.openal.ALC11.*;

public class Alc {

    public static AlcError getError(long device) {
        return AlcError.byValue(ALC11.alcGetError(device));
    }

    public static AlcError getError(AlAbstractDevice device) {
        return getError(device.getID());
    }

    public static AlcError getError() {
        return getError(0);
    }

    public static boolean checkError(long device) {
        final AlcError error = getError(device);
        if(error.noErrors())
            return false;
        System.err.println("[ALC]: " + error + ". Check error at: " + Utils.getStackTrace(4));
        return true;
    }

    public static boolean checkError(AlAbstractDevice device) {
        return checkError(device.getID());
    }

    public static boolean checkError() {
        return checkError(0);
    }


    public static boolean canEnumerate() {
        return alcIsExtensionPresent(0L, "ALC_ENUMERATE_ALL_EXT");
    }


    public static String getCaptureDeviceSpecifier() {
        return alcGetString(0, ALC_CAPTURE_DEVICE_SPECIFIER);
    }

    public static String getSystemCaptureDeviceSpecifier() {
        return alcGetString(0, ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER);
    }

    public static String getSystemDeviceSpecifier() {
        return alcGetString(0, ALC_DEFAULT_ALL_DEVICES_SPECIFIER);
    }

    public static String getDeviceSpecifier() {
        return alcGetString(0, ALC_DEVICE_SPECIFIER);
    }

    public static String getDefaultDeviceSpecifier() {
        return alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER);
    }


    public static long getCurrentContextID() {
        return alcGetCurrentContext();
    }

}

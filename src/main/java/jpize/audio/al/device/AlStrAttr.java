package jpize.audio.al.device;

import static org.lwjgl.openal.ALC11.*;

public enum AlStrAttr {

    DEFAULT_DEVICE_SPECIFIER         (ALC_DEFAULT_DEVICE_SPECIFIER        ), // 410_0
    DEVICE_SPECIFIER                 (ALC_DEVICE_SPECIFIER                ), // 410_1
    EXTENSIONS                       (ALC_EXTENSIONS                      ), // 410_2
    CAPTURE_DEVICE_SPECIFIER         (ALC_CAPTURE_DEVICE_SPECIFIER        ), // 78_4
    CAPTURE_DEFAULT_DEVICE_SPECIFIER (ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER); // 78_5

    public final int value;

    AlStrAttr(int value) {
        this.value = value;
    }

}

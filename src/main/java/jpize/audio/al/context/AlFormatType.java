package jpize.audio.al.context;

import jpize.util.Utils;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.openal.SOFTLoopback.*;

// SOFT_loopback extension.
public enum AlFormatType {

    BYTE           (ALC_BYTE_SOFT          ),
    FLOAT          (ALC_FLOAT_SOFT         ),
    INT            (ALC_INT_SOFT           ),
    SHORT          (ALC_SHORT_SOFT         ),
    UNSIGNED_BYTE  (ALC_UNSIGNED_BYTE_SOFT ),
    UNSIGNED_INT   (ALC_UNSIGNED_INT_SOFT  ),
    UNSIGNED_SHORT (ALC_UNSIGNED_SHORT_SOFT);

    public final int value;

    AlFormatType(int value) {
        this.value = value;
    }


    private static final Map<Integer, AlFormatType> BY_VALUE = Utils.make(new HashMap<>(), map -> {
        for(AlFormatType e: values())
            map.put(e.value, e);
    });

    public static AlFormatType byValue(int value) {
        return BY_VALUE.get(value);
    }

}

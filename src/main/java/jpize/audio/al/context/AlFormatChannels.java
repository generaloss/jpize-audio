package jpize.audio.al.context;

import jpize.util.Utils;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.openal.SOFTLoopback.*;

// SOFT_loopback extension.
public enum AlFormatChannels {

    S51    (ALC_5POINT1_SOFT),
    S61    (ALC_6POINT1_SOFT),
    S71    (ALC_7POINT1_SOFT),
    MONO   (ALC_MONO_SOFT   ),
    QUAD   (ALC_QUAD_SOFT   ),
    STEREO (ALC_STEREO_SOFT );

    public final int value;

    AlFormatChannels(int value) {
        this.value = value;
    }


    private static final Map<Integer, AlFormatChannels> BY_VALUE = Utils.make(new HashMap<>(), map -> {
        for(AlFormatChannels e: values())
            map.put(e.value, e);
    });

    public static AlFormatChannels byValue(int value) {
        return BY_VALUE.get(value);
    }

}

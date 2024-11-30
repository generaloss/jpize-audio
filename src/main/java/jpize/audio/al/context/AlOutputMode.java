package jpize.audio.al.context;

import jpize.util.Utils;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.openal.SOFTOutputMode.*;

// SOFT_output_mode extension.
public enum AlOutputMode {

    ANY          (ALC_ANY_SOFT         ), // 657_3
    STEREO_BASIC (ALC_STEREO_BASIC_SOFT), // 657_4
    STEREO_UHJ   (ALC_STEREO_UHJ_SOFT  ), // 657_5
    STEREO_HRTF  (ALC_STEREO_HRTF_SOFT ), // 657_8
    MONO         (ALC_MONO_SOFT        ), // 53_76
    STEREO       (ALC_STEREO_SOFT      ), // 53_77
    QUAD         (ALC_QUAD_SOFT        ), // 53_79
    SURROUND_5_1 (ALC_SURROUND_5_1_SOFT), // 53_80
    SURROUND_6_1 (ALC_SURROUND_6_1_SOFT), // 53_81
    SURROUND_7_1 (ALC_SURROUND_7_1_SOFT); // 53_82

    public final int value;

    AlOutputMode(int value) {
        this.value = value;
    }


    private static final Map<Integer, AlOutputMode> BY_VALUE = Utils.make(new HashMap<>(), map -> {
        for(AlOutputMode e: values())
            map.put(e.value, e);
    });

    public static AlOutputMode byValue(int value) {
        return BY_VALUE.get(value);
    }

}

package jpize.audio.al.fx;

import jpize.util.Utils;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.openal.EXTEfx.*;

public enum AlEffectType {

    AUTOWAH           (AL_EFFECT_AUTOWAH          ),
    CHORUS            (AL_EFFECT_CHORUS           ),
    COMPRESSOR        (AL_EFFECT_COMPRESSOR       ),
    DISTORTION        (AL_EFFECT_DISTORTION       ),
    EAXREVERB         (AL_EFFECT_EAXREVERB        ),
    ECHO              (AL_EFFECT_ECHO             ),
    EQUALIZER         (AL_EFFECT_EQUALIZER        ),
    FLANGER           (AL_EFFECT_FLANGER          ),
    FREQUENCY_SHIFTER (AL_EFFECT_FREQUENCY_SHIFTER),
    PITCH_SHIFTER     (AL_EFFECT_PITCH_SHIFTER    ),
    REVERB            (AL_EFFECT_REVERB           ),
    RING_MODULATOR    (AL_EFFECT_RING_MODULATOR   ),
    VOCAL_MORPHER     (AL_EFFECT_VOCAL_MORPHER    ),
    NULL              (AL_EFFECT_NULL             );

    public final int value;

    AlEffectType(int value) {
        this.value = value;
    }


    private static final Map<Integer, AlEffectType> BY_VALUE = Utils.make(new HashMap<>(), map -> {
        for(AlEffectType e: values())
            map.put(e.value, e);
    });

    public static AlEffectType byValue(int value) {
        return BY_VALUE.get(value);
    }

}

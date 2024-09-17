package jpize.audio.al.fx.effects;

import static org.lwjgl.openal.EXTEfx.*;

public enum AlPhoneme {

    A  (AL_VOCAL_MORPHER_PHONEME_A ), // 0
    E  (AL_VOCAL_MORPHER_PHONEME_E ), // 1
    I  (AL_VOCAL_MORPHER_PHONEME_I ), // 2
    O  (AL_VOCAL_MORPHER_PHONEME_O ), // 3
    U  (AL_VOCAL_MORPHER_PHONEME_U ), // 4
    AA (AL_VOCAL_MORPHER_PHONEME_AA), // 5
    AE (AL_VOCAL_MORPHER_PHONEME_AE), // 6
    AH (AL_VOCAL_MORPHER_PHONEME_AH), // 7
    AO (AL_VOCAL_MORPHER_PHONEME_AO), // 8
    EH (AL_VOCAL_MORPHER_PHONEME_EH), // 9
    ER (AL_VOCAL_MORPHER_PHONEME_ER), // 10
    IH (AL_VOCAL_MORPHER_PHONEME_IH), // 11
    IY (AL_VOCAL_MORPHER_PHONEME_IY), // 12
    UH (AL_VOCAL_MORPHER_PHONEME_UH), // 13
    UW (AL_VOCAL_MORPHER_PHONEME_UW), // 14
    B  (AL_VOCAL_MORPHER_PHONEME_B ), // 15
    D  (AL_VOCAL_MORPHER_PHONEME_D ), // 16
    F  (AL_VOCAL_MORPHER_PHONEME_F ), // 17
    G  (AL_VOCAL_MORPHER_PHONEME_G ), // 18
    J  (AL_VOCAL_MORPHER_PHONEME_J ), // 19
    K  (AL_VOCAL_MORPHER_PHONEME_K ), // 20
    L  (AL_VOCAL_MORPHER_PHONEME_L ), // 21
    M  (AL_VOCAL_MORPHER_PHONEME_M ), // 22
    N  (AL_VOCAL_MORPHER_PHONEME_N ), // 23
    P  (AL_VOCAL_MORPHER_PHONEME_P ), // 24
    R  (AL_VOCAL_MORPHER_PHONEME_R ), // 25
    S  (AL_VOCAL_MORPHER_PHONEME_S ), // 26
    T  (AL_VOCAL_MORPHER_PHONEME_T ), // 27
    V  (AL_VOCAL_MORPHER_PHONEME_V ), // 28
    Z  (AL_VOCAL_MORPHER_PHONEME_Z ); // 29

    public final int value;

    AlPhoneme(int value) {
        this.value = value;
    }

    public static AlPhoneme byValue(int value) {
        return values()[value];
    }

}

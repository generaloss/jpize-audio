package jpize.audio.al.buffer;

import jpize.util.Utils;

import javax.sound.sampled.AudioFormat;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.openal.AL11.*;
import static org.lwjgl.openal.EXTAlaw.*;
import static org.lwjgl.openal.EXTBFormat.*;
import static org.lwjgl.openal.EXTDouble.*;
import static org.lwjgl.openal.EXTFloat32.*;
import static org.lwjgl.openal.EXTIma4.*;
import static org.lwjgl.openal.EXTMCFormats.*;
import static org.lwjgl.openal.EXTMulaw.*;
import static org.lwjgl.openal.EXTMulawBFormat.*;
import static org.lwjgl.openal.EXTMulawMCFormats.*;
import static org.lwjgl.openal.EXTVorbis.*;
import static org.lwjgl.openal.LOKIIMAADPCM.*;
import static org.lwjgl.openal.LOKIQuadriphonic.*;
import static org.lwjgl.openal.LOKIWAVEFormat.*;
import static org.lwjgl.openal.SOFTMSADPCM.*;
import static org.lwjgl.openal.SOFTUHJ.*;
import static org.lwjgl.openal.SOFTUHJEx.*;

public enum AlFormat {

    // AL10
    MONO8    (AL_FORMAT_MONO8   , 1, 8 ), // 435_2
    MONO16   (AL_FORMAT_MONO16  , 1, 16), // 435_3
    STEREO8  (AL_FORMAT_STEREO8 , 2, 8 ), // 435_4
    STEREO16 (AL_FORMAT_STEREO16, 2, 16), // 435_5

    // AL_EXT_ALAW
    MONO_ALAW   (AL_FORMAT_MONO_ALAW_EXT  , 1, -1), // 6555_8
    STEREO_ALAW (AL_FORMAT_STEREO_ALAW_EXT, 2, -1), // 6555_9

    // AL_EXT_BFORMAT
    //   This extension indicates support for the buffer formats. These provide 2D (WXY) and 3D (WXYZ) 8bit int, 16bit
    // int and ALfloat support for Ambisonic three- or four-channel B-Format (using W X Y Z channel ordering, encoded
    // as the first three or four channels of Furse-Malham higher order Ambisonics). Use of these formats indicate that
    // sources are Ambisonic sources. Such sources can be oriented via Sourcefv using the ORIENTATION tag, which takes
    // the same parameters as alListenerfv(AL_ORIENTATION,...). Such sources DO support SOURCE_RELATIVE and the
    // soundfield will rotate to reflect the listener's orientation if this is off (the default). Other behaviour is as
    // for stereo or multichannel assets.
    //   Note that Ambisonics orients X, Y and Z axes in a different way to OpenAL. For clarity, we ignore the Ambisonic
    // coordinate system in the API and stick to the OpenAL one, making sure that the Front of the Ambisonic soundfield
    // (actually Ambisonic +X) matches the Front of the OpenAL coordinate system (-Z by default) etc. For instance, if
    // the orientation of the source is set so that the "at" vector is to the left, then the front of the B-Format
    // soundfield will be presented to the left.
    BFORMAT2D_8       (AL_FORMAT_BFORMAT2D_8      , 2, 8 ), // 1311_05
    BFORMAT2D_16      (AL_FORMAT_BFORMAT2D_16     , 2, 16), // 1311_06
    BFORMAT2D_FLOAT32 (AL_FORMAT_BFORMAT2D_FLOAT32, 2, 32), // 1311_07
    BFORMAT3D_8       (AL_FORMAT_BFORMAT3D_8      , 2, 8 ), // 1311_21
    BFORMAT3D_16      (AL_FORMAT_BFORMAT3D_16     , 2, 16), // 1311_22
    BFORMAT3D_FLOAT32 (AL_FORMAT_BFORMAT3D_FLOAT32, 2, 32), // 1311_23

    // AL_EXT_DOUBLE
    MONO_DOUBLE    (AL_FORMAT_MONO_DOUBLE_EXT  , 1, 64), // 6555_4
    STEREO_DOUBLE  (AL_FORMAT_STEREO_DOUBLE_EXT, 2, 64), // 6555_5

    // AL_EXT_FLOAT32
    MONO_FLOAT32   (AL_FORMAT_MONO_FLOAT32     , 1, 32), // 6555_2
    STEREO_FLOAT32 (AL_FORMAT_STEREO_FLOAT32   , 2, 32), // 6555_3

    // AL_EXT_IMA4
    MONO_IMA4   (AL_FORMAT_MONO_IMA4  , 1, -1), // 486_4
    STEREO_IMA4 (AL_FORMAT_STEREO_IMA4, 2, -1), // 486_5

    // AL_EXT_MCFORMATS
    MC_QUAD8   (AL_FORMAT_QUAD8  , -1, 8 ), // 46_12
    MC_QUAD16  (AL_FORMAT_QUAD16 , -1, 16), // 46_13
    MC_QUAD32  (AL_FORMAT_QUAD32 , -1, 32), // 46_14
    MC_REAR8   (AL_FORMAT_REAR8  , -1, 8 ), // 46_15
    MC_REAR16  (AL_FORMAT_REAR16 , -1, 16), // 46_16
    MC_REAR32  (AL_FORMAT_REAR32 , -1, 32), // 46_17
    MC_51CHN8  (AL_FORMAT_51CHN8 , -1, 8 ), // 46_18
    MC_51CHN16 (AL_FORMAT_51CHN16, -1, 16), // 46_19
    MC_51CHN32 (AL_FORMAT_51CHN32, -1, 32), // 46_20
    MC_61CHN8  (AL_FORMAT_61CHN8 , -1, 8 ), // 46_21
    MC_61CHN16 (AL_FORMAT_61CHN16, -1, 16), // 46_22
    MC_61CHN32 (AL_FORMAT_61CHN32, -1, 32), // 46_23
    MC_71CHN8  (AL_FORMAT_71CHN8 , -1, 8 ), // 46_24
    MC_71CHN16 (AL_FORMAT_71CHN16, -1, 16), // 46_25
    MC_71CHN32 (AL_FORMAT_71CHN32, -1, 32), // 46_26
    
    // AL_EXT_MULAW
    MONO_MULAW   (AL_FORMAT_MONO_MULAW_EXT  , 1, 8), // 6555_6
    STEREO_MULAW (AL_FORMAT_STEREO_MULAW_EXT, 2, 8), // 6555_7

    // AL_EXT_MULAW_BFORMAT
    //   This extension implies two MULAW formats are available, based on 2D and 3D Ambisonic B-Format.
    BFORMAT2D_MULAW (AL_FORMAT_BFORMAT2D_MULAW, 2, 8), // 6558_5
    BFORMAT3D_MULAW (AL_FORMAT_BFORMAT3D_MULAW, 2, 8), // 6558_6

    // AL_EXT_MULAW_MCFORMATS
    MC_MONO_MULAW   (AL_FORMAT_MONO_MULAW  ,  1, 8), // 655_56
    MC_STEREO_MULAW (AL_FORMAT_STEREO_MULAW,  2, 8), // 655_57
    MC_QUAD_MULAW   (AL_FORMAT_QUAD_MULAW  , -1, 8), // 655_69
    MC_REAR_MULAW   (AL_FORMAT_REAR_MULAW  , -1, 8), // 655_70
    MC_51CHN_MULAW  (AL_FORMAT_51CHN_MULAW , -1, 8), // 655_71
    MC_61CHN_MULAW  (AL_FORMAT_61CHN_MULAW , -1, 8), // 655_72
    MC_71CHN_MULAW  (AL_FORMAT_71CHN_MULAW , -1, 8), // 655_73

    // AL_EXT_vorbis
    VORBIS (AL_FORMAT_VORBIS_EXT, -1, -1), // 65539

    // AL_LOKI_IMA_ADPCM
    IMA_ADPCM_MONO16   (AL_FORMAT_IMA_ADPCM_MONO16_EXT  , 1, 16), // 6553_6
    IMA_ADPCM_STEREO16 (AL_FORMAT_IMA_ADPCM_STEREO16_EXT, 2, 16), // 6553_7

    // AL_LOKI_quadriphonic
    QUAD16_LOKI (AL_FORMAT_QUAD16_LOKI, 1, 16), // 6554_0
    QUAD8_LOKI  (AL_FORMAT_QUAD8_LOKI , 1, 8 ), // 6554_1

    // AL_LOKI_WAVE_format
    WAVE (AL_FORMAT_WAVE_EXT, -1, 16), // 65538

    // SOFT_MSADPCM
    //   This extension adds support for MSADPCM compressed sample formats.
    MONO_MSADPCM   (AL_FORMAT_MONO_MSADPCM_SOFT  , 1, -1), // 486_6
    STEREO_MSADPCM (AL_FORMAT_STEREO_MSADPCM_SOFT, 2, -1), // 486_7

    // SOFT_UHJ
    //   This extension adds support for UHJ channel formats and a Super Stereo (a.k.a. Stereo Enhance) processor.
    UHJ2CHN8        (AL_FORMAT_UHJ2CHN8_SOFT       , -1, 8 ), // 65_62
    UHJ2CHN16       (AL_FORMAT_UHJ2CHN16_SOFT      , -1, 16), // 65_63
    UHJ2CHN_FLOAT32 (AL_FORMAT_UHJ2CHN_FLOAT32_SOFT, -1, 32), // 65_64
    UHJ3CHN8        (AL_FORMAT_UHJ3CHN8_SOFT       , -1, 8 ), // 65_65
    UHJ3CHN16       (AL_FORMAT_UHJ3CHN16_SOFT      , -1, 16), // 65_66
    UHJ3CHN_FLOAT32 (AL_FORMAT_UHJ3CHN_FLOAT32_SOFT, -1, 32), // 65_67
    UHJ4CHN8        (AL_FORMAT_UHJ4CHN8_SOFT       , -1, 8 ), // 65_68
    UHJ4CHN16       (AL_FORMAT_UHJ4CHN16_SOFT      , -1, 16), // 65_69
    UHJ4CHN_FLOAT32 (AL_FORMAT_UHJ4CHN_FLOAT32_SOFT, -1, 32), // 65_70

    // SOFT_UHJ_ex
    //   This extension supplements AL_SOFT_UHJ by adding muLaw, aLaw, IMA4, and MSADPCM sample types to UHJ formats.
    // The base AL_SOFT_UHJ extension could already use these formats (when available) for Super Stereo processing,
    // and this extension allows them to be used for UHJ itself too.
    //   Requires SOFT_UHJ and one or more of EXT_MULAW, EXT_ALAW, EXT_IMA4, and SOFT_MSADPCM.
    UHJ2CHN_MULAW   (AL_FORMAT_UHJ2CHN_MULAW_SOFT  , -1, -1), // 65_79
    UHJ3CHN_MULAW   (AL_FORMAT_UHJ3CHN_MULAW_SOFT  , -1, -1), // 65_83
    UHJ4CHN_MULAW   (AL_FORMAT_UHJ4CHN_MULAW_SOFT  , -1, -1), // 65_85
    UHJ2CHN_ALAW    (AL_FORMAT_UHJ2CHN_ALAW_SOFT   , -1, -1), // 65_80
    UHJ3CHN_ALAW    (AL_FORMAT_UHJ3CHN_ALAW_SOFT   , -1, -1), // 65_84
    UHJ4CHN_ALAW    (AL_FORMAT_UHJ4CHN_ALAW_SOFT   , -1, -1), // 65_86
    UHJ2CHN_IMA4    (AL_FORMAT_UHJ2CHN_IMA4_SOFT   , -1, -1), // 65_81
    UHJ2CHN_MSADPCM (AL_FORMAT_UHJ2CHN_MSADPCM_SOFT, -1, -1), // 65_82

    // SOFT_UHJ
    //   This extension adds support for UHJ channel formats and a Super Stereo (a.k.a. Stereo Enhance) processor.
    // UHJ is a method of encoding surround sound from a first-order B-Format signal into a stereo-compatible signal.
    //   Such signals can be played as normal stereo (with more stable and wider stereo imaging than pan-pot mixing)
    // or decoded back to surround sound, which makes it a decent choice where 3+ channel surround sound isn't available
    // or desirable. When decoded, a UHJ signal behaves like B-Format, which allows it to be rotated through
    // AL_EXT_BFORMAT's source orientation property as with B-Format formats.
    UHJ2CHN_FLOAT32_SOFT (AL_FORMAT_UHJ2CHN_FLOAT32_SOFT, 2, 32),
    UHJ2CHN16_SOFT       (AL_FORMAT_UHJ2CHN16_SOFT      , 2, 16),
    UHJ2CHN8_SOFT        (AL_FORMAT_UHJ2CHN8_SOFT       , 2, 8 ),
    UHJ3CHN_FLOAT32_SOFT (AL_FORMAT_UHJ3CHN_FLOAT32_SOFT, 3, 32),
    UHJ3CHN16_SOFT       (AL_FORMAT_UHJ3CHN16_SOFT      , 3, 16),
    UHJ3CHN8_SOFT        (AL_FORMAT_UHJ3CHN8_SOFT       , 3, 8 ),
    UHJ4CHN_FLOAT32_SOFT (AL_FORMAT_UHJ4CHN_FLOAT32_SOFT, 4, 32),
    UHJ4CHN16_SOFT       (AL_FORMAT_UHJ4CHN16_SOFT      , 4, 16),
    UHJ4CHN8_SOFT        (AL_FORMAT_UHJ4CHN8_SOFT       , 4, 8 );


    public final int value;
    public final int channels;
    public final int bits;

    AlFormat(int value, int channels, int bits) {
        this.value = value;
        this.channels = channels;
        this.bits = bits;
    }

    public int getSampleSizeInBits() {
        return bits * channels;
    }


    private static final Map<Integer, AlFormat> BY_VALUE = Utils.make(new HashMap<>(), map -> {
        for(AlFormat e: values())
            map.put(e.value, e);
    });

    public static AlFormat byValue(int value) {
        return BY_VALUE.get(value);
    }


    public static AlFormat by(int channels, int bits) {
        return values()[channels * 2 + (bits >> 4) - 2]; // 0..3
    }

    public static AlFormat by(AudioFormat format) {
        return by(format.getChannels(), format.getSampleSizeInBits());
    }

}

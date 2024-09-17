package jpize.audio.al;

public enum AlExtensions {

    EXT_ALAW                   ("AL_EXT_ALAW"                  ),
    EXT_BFORMAT                ("AL_EXT_BFORMAT"               ),
    EXT_DOUBLE                 ("AL_EXT_DOUBLE"                ),
    EXT_EXPONENT_DISTANCE      ("AL_EXT_EXPONENT_DISTANCE"     ),
    EXT_FLOAT32                ("AL_EXT_FLOAT32"               ),
    EXT_IMA4                   ("AL_EXT_IMA4"                  ),
    EXT_LINEAR_DISTANCE        ("AL_EXT_LINEAR_DISTANCE"       ),
    EXT_MCFORMATS              ("AL_EXT_MCFORMATS"             ),
    EXT_MULAW                  ("AL_EXT_MULAW"                 ),
    EXT_MULAW_BFORMAT          ("AL_EXT_MULAW_BFORMAT"         ),
    EXT_MULAW_MCFORMATS        ("AL_EXT_MULAW_MCFORMATS"       ),
    EXT_OFFSET                 ("AL_EXT_OFFSET"                ),
    EXT_SOURCE_DISTANCE_MODEL  ("AL_EXT_SOURCE_DISTANCE_MODEL" ),
    EXT_SOURCE_RADIUS          ("AL_EXT_SOURCE_RADIUS"         ),
    EXT_STATIC_BUFFER          ("AL_EXT_STATIC_BUFFER"         ),
    EXT_STEREO_ANGLES          ("AL_EXT_STEREO_ANGLES"         ),
    EXT_SOURCE_NOTIFICATIONS   ("AL_EXT_SOURCE_NOTIFICATIONS"  ), //
    EXT_SOURCE_SPATIALIZATION  ("AL_EXT_SOURCE_SPATIALIZATION" ), //
    EXT_BUFFER_SUB_DATA        ("AL_EXT_BUFFER_SUB_DATA"       ), //
    EXT_SAMPLE_BUFFER_OBJECT   ("AL_EXT_SAMPLE_BUFFER_OBJECT"  ), //
    EXT_VORBIS                 ("AL_EXT_VORBIS"                ), //

    LOKI_QUADRIPHONIC          ("AL_LOKI_QUADRIPHONIC"         ),
    LOKI_IMA_ADPCM_FORMAT      ("AL_LOKI_IMA_ADPCM_FORMAT"     ), //
    LOKI_WAVE_FORMAT           ("AL_LOKI_WAVE_FORMAT"          ), //

    SOFT_BFORMAT_EX            ("AL_SOFT_BFORMAT_EX"           ),
    SOFTX_BFORMAT_HOA          ("AL_SOFTX_BFORMAT_HOA"         ),
    SOFT_BLOCK_ALIGNMENT       ("AL_SOFT_BLOCK_ALIGNMENT"      ),
    SOFT_BUFFER_LENGTH_QUERY   ("AL_SOFT_BUFFER_LENGTH_QUERY"  ),
    SOFT_CALLBACK_BUFFER       ("AL_SOFT_CALLBACK_BUFFER"      ),
    SOFTX_CONVOLUTION_REVERB   ("AL_SOFTX_CONVOLUTION_REVERB"  ),
    SOFT_DEFERRED_UPDATES      ("AL_SOFT_DEFERRED_UPDATES"     ),
    SOFT_DIRECT_CHANNELS       ("AL_SOFT_DIRECT_CHANNELS"      ),
    SOFT_DIRECT_CHANNELS_REMIX ("AL_SOFT_DIRECT_CHANNELS_REMIX"),
    SOFT_EFFECT_TARGET         ("AL_SOFT_EFFECT_TARGET"        ),
    SOFT_EVENTS                ("AL_SOFT_EVENTS"               ),
    SOFT_GAIN_CLAMP_EX         ("AL_SOFT_GAIN_CLAMP_EX"        ),
    SOFTX_HOLD_ON_DISCONNECT   ("AL_SOFTX_HOLD_ON_DISCONNECT"  ),
    SOFT_LOOP_POINTS           ("AL_SOFT_LOOP_POINTS"          ),
    SOFTX_MAP_BUFFER           ("AL_SOFTX_MAP_BUFFER"          ),
    SOFT_MSADPCM               ("AL_SOFT_MSADPCM"              ),
    SOFT_SOURCE_LATENCY        ("AL_SOFT_SOURCE_LATENCY"       ),
    SOFT_SOURCE_LENGTH         ("AL_SOFT_SOURCE_LENGTH"        ),
    SOFT_SOURCE_RESAMPLER      ("AL_SOFT_SOURCE_RESAMPLER"     ),
    SOFT_SOURCE_SPATIALIZE     ("AL_SOFT_SOURCE_SPATIALIZE"    ),
    SOFT_SOURCE_START_DELAY    ("AL_SOFT_SOURCE_START_DELAY"   ),
    SOFT_UHJ                   ("AL_SOFT_UHJ"                  ),
    SOFT_UHJ_EX                ("AL_SOFT_UHJ_EX"               ),
    SOFT_BUFFER_SAMPLES        ("AL_SOFT_BUFFER_SAMPLES"       ), //
    SOFT_BUFFER_SUB_DATA       ("AL_SOFT_BUFFER_SUB_DATA"      ); //
    

    public final String value;

    AlExtensions(String value) {
        this.value = value;
    }

    public boolean isPresent() {
        return Al.isExtensionPresent(value);
    }
    
    
    public static String all() {
        return Al.getExtensions();
    }

}

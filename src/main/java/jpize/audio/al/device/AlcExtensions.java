package jpize.audio.al.device;

import jpize.audio.AlDevices;

import java.util.Objects;

public enum AlcExtensions {

    EXT_CAPTURE                       ("ALC_EXT_CAPTURE"                      ),
    EXT_DEDICATED                     ("ALC_EXT_DEDICATED"                    ),
    EXT_DISCONNECT                    ("ALC_EXT_DISCONNECT"                   ),
    EXT_EFX                           ("ALC_EXT_EFX"                          ),
    EXT_THREAD_LOCAL_CONTEXT          ("ALC_EXT_THREAD_LOCAL_CONTEXT"         ),
    EXT_ASA                           ("ALC_EXT_ASA"                          ), //
    EXT_ASA_DISTORTION                ("ALC_EXT_ASA_DISTORTION"               ), //
    EXT_ASA_ROGER_BEEP                ("ALC_EXT_ASA_ROGER_BEEP"               ), //
    EXT_MAC_OSX                       ("ALC_EXT_MAC_OSX"                      ), //
    EXT_OUTPUT_CAPTURER               ("ALC_EXT_OUTPUT_CAPTURER"              ), //
    SOFT_DEVICE_CLOCK                 ("ALC_SOFT_DEVICE_CLOCK"                ),
    SOFT_HRTF                         ("ALC_SOFT_HRTF"                        ),
    SOFT_LOOPBACK                     ("ALC_SOFT_LOOPBACK"                    ),
    SOFT_LOOPBACK_BFORMAT             ("ALC_SOFT_LOOPBACK_BFORMAT"            ),
    SOFT_OUTPUT_LIMITER               ("ALC_SOFT_OUTPUT_LIMITER"              ),
    SOFT_OUTPUT_MODE                  ("ALC_SOFT_OUTPUT_MODE"                 ),
    SOFT_PAUSE_DEVICE                 ("ALC_SOFT_PAUSE_DEVICE"                ),
    SOFT_REOPEN_DEVICE                ("ALC_SOFT_REOPEN_DEVICE"               ),

    ENUMERATE_ALL_EXT                 ("ALC_ENUMERATE_ALL_EXT"                ),
    ENUMERATION_EXT                   ("ALC_ENUMERATION_EXT"                  ),
    LOKI_AUDIO_CHANNEL                ("ALC_LOKI_AUDIO_CHANNEL"               ), //
    MAC_OSX_CONVERT_DATA_UPON_LOADING ("ALC_MAC_OSX_CONVERT_DATA_UPON_LOADING"); //


    public final String value;

    AlcExtensions(String value) {
        this.value = value;
    }

    public boolean isPresent(AlAbstractDevice device) {
        return device.isExtensionPresent(value);
    }

    public boolean isPresent() {
        return this.isPresent(Objects.requireNonNull(AlDevices.getCurrentDevice()));
    }


    public static String all(AlAbstractDevice device) {
        return device.getAttributeExtensions();
    }

    public static String all() {
        return all(Objects.requireNonNull(AlDevices.getCurrentDevice()));
    }

}

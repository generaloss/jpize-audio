package jpize.audio.al;

import static org.lwjgl.openal.EXTSourceDistanceModel.AL_SOURCE_DISTANCE_MODEL;
import static org.lwjgl.openal.SOFTXHoldOnDisconnect.AL_STOP_SOURCES_ON_DISCONNECT_SOFT;

public enum AlTarget {

    // EXT_source_distance_model extension.
    DISTANCE_MODEL (AL_SOURCE_DISTANCE_MODEL),

    // SOFTX_hold_on_disconnect extension.
    //   (LWJGL: This extension is experimental.)
    STOP_SOURCES_ON_DISCONNECT (AL_STOP_SOURCES_ON_DISCONNECT_SOFT);


    public final int value;

    AlTarget(int value) {
        this.value = value;
    }

}

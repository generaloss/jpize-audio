package jpize.audio.al.callback;

import static org.lwjgl.openal.SOFTEvents.AL_EVENT_TYPE_BUFFER_COMPLETED_SOFT;
import static org.lwjgl.openal.SOFTEvents.AL_EVENT_TYPE_DISCONNECTED_SOFT;
import static org.lwjgl.openal.SOFTEvents.AL_EVENT_TYPE_SOURCE_STATE_CHANGED_SOFT;

public enum AlEventType {

    BUFFER_COMPLETED     (AL_EVENT_TYPE_BUFFER_COMPLETED_SOFT    ), // 656_4 // element in the types parameter of alEventControlSOFT, and provided as the eventType parameter of ALEVENTPROCSOFT callback functions.
    SOURCE_STATE_CHANGED (AL_EVENT_TYPE_SOURCE_STATE_CHANGED_SOFT), // 656_5 // element in the types parameter of alEventControlSOFT, and provided as the eventType parameter of ALEVENTPROCSOFT callback functions.
    DISCONNECTED         (AL_EVENT_TYPE_DISCONNECTED_SOFT        ); // 656_6 // element in the types parameter of alEventControlSOFT, and provided as the eventType parameter of ALEVENTPROCSOFT callback functions.

    public final int value;

    AlEventType(int value) {
        this.value = value;
    }

    public static AlEventType byValue(int value) {
        return values()[value - BUFFER_COMPLETED.value];
    }

}

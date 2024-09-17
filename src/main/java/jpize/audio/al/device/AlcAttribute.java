package jpize.audio.al.device;

import static org.lwjgl.openal.ALC11.*;

public enum AlcAttribute {

    MAJOR_VERSION   (ALC_MAJOR_VERSION  ), // 409_6;
    MINOR_VERSION   (ALC_MINOR_VERSION  ), // 409_7;
    ATTRIBUTES_SIZE (ALC_ATTRIBUTES_SIZE), // 409_8;
    ALL_ATTRIBUTES  (ALC_ALL_ATTRIBUTES ); // 409_9;

    public final int value;

    AlcAttribute(int value) {
        this.value = value;
    }

}

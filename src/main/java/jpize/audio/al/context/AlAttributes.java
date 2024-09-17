package jpize.audio.al.context;

import jpize.audio.al.device.AlProperty;
import jpize.util.array.IntList;

public class AlAttributes {

    private final IntList list;

    public AlAttributes() {
        this.list = new IntList();
    }

    public int[] makeArray() {
        final IntList list = this.list.copy();
        list.add(0);
        list.trim();
        return list.array();
    }

    protected AlAttributes setProperty(AlProperty property, int value) {
        list.add(property.value);
        list.add(value);
        return this;
    }


    public AlAttributes setFrequency(int hertz) {
        return setProperty(AlProperty.FREQUENCY, hertz);
    }

    public AlAttributes setRefresh(int hertz) {
        return setProperty(AlProperty.REFRESH, hertz);
    }

    public AlAttributes setSync(boolean value) {
        return setProperty(AlProperty.SYNC, value ? 1 : 0);
    }

    public AlAttributes setMonoSources(int value) {
        return setProperty(AlProperty.MONO_SOURCES, value);
    }

    public AlAttributes setStereoSources(int value) {
        return setProperty(AlProperty.STEREO_SOURCES, value);
    }

    public AlAttributes setOutputLimiter(boolean value) {
        return setProperty(AlProperty.OUTPUT_LIMITER_SOFT, value ? 1 : 0);
    }

    public AlAttributes setOutputMode(AlOutputMode mode) {
        return setProperty(AlProperty.OUTPUT_MODE_SOFT, mode.value);
    }

    public AlAttributes setFormatChannels(AlFormatChannels value) {
        return setProperty(AlProperty.FORMAT_CHANNELS_SOFT, value.value);
    }

    public AlAttributes setFormatType(AlFormatType value) {
        return setProperty(AlProperty.FORMAT_TYPE_SOFT, value.value);
    }

}

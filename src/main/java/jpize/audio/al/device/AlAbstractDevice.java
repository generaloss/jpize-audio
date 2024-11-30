package jpize.audio.al.device;

import jpize.audio.al.AlcError;
import jpize.audio.al.AlObjectLong;
import jpize.audio.al.context.AlAttributes;
import jpize.audio.al.context.AlFormatChannels;
import jpize.audio.al.context.AlFormatType;
import jpize.audio.al.context.AlOutputMode;
import org.lwjgl.openal.*;

import java.nio.IntBuffer;

import static org.lwjgl.openal.ALC10.*;
import static org.lwjgl.openal.ALC11.*;

public abstract class AlAbstractDevice extends AlObjectLong {

    public AlAbstractDevice(long ID) {
        super(ID);
        if(ID == 0)
            throw new IllegalArgumentException("Invalid device handle.");
    }


    public String getAttribute(AlStrAttr attribute) {
        return alcGetString(ID, attribute.value);
    }

    public void getAttribute(AlcAttribute attribute, int[] dest) {
        alcGetIntegerv(ID, attribute.value, dest);
    }

    public void getAttribute(AlcAttribute attribute, IntBuffer dest) {
        alcGetIntegerv(ID, attribute.value, dest);
    }

    public String getAttributeDefaultSpecifier() {
        return this.getAttribute(AlStrAttr.DEFAULT_DEVICE_SPECIFIER);
    }

    public String getAttributeSpecifier() {
        return this.getAttribute(AlStrAttr.DEVICE_SPECIFIER);
    }

    public String getAttributeExtensions() {
        return this.getAttribute(AlStrAttr.EXTENSIONS);
    }

    public String getAttributeCaptureSpecifier() {
        return this.getAttribute(AlStrAttr.CAPTURE_DEVICE_SPECIFIER);
    }

    public String getAttributeCaptureDefaultSpecifier() {
        return this.getAttribute(AlStrAttr.CAPTURE_DEFAULT_DEVICE_SPECIFIER);
    }


    public boolean isExtensionPresent(CharSequence extension) {
        return alcIsExtensionPresent(ID, extension);
    }


    public String getSpecifier() {
        return alcGetString(ID, ALC_ALL_DEVICES_SPECIFIER);
    }


    public int getProperty(AlProperty property) {
        return alcGetInteger(ID, property.value);
    }

    public int getPropertyFrequency() {
        return this.getProperty(AlProperty.FREQUENCY);
    }

    public int getPropertyRefresh() {
        return this.getProperty(AlProperty.REFRESH);
    }

    public boolean getPropertySync() {
        return this.getProperty(AlProperty.SYNC) == 1;
    }

    public int getPropertyMonoSources() {
        return this.getProperty(AlProperty.MONO_SOURCES);
    }

    public int getPropertyStereoSources() {
        return this.getProperty(AlProperty.STEREO_SOURCES);
    }

    public boolean getPropertyOutputLimiter() {
        return this.getProperty(AlProperty.OUTPUT_LIMITER_SOFT) == 1;
    }

    public AlOutputMode getPropertyOutputMode() {
        return AlOutputMode.byValue(this.getProperty(AlProperty.OUTPUT_MODE_SOFT));
    }

    public AlFormatChannels getPropertyFormatChannels() {
        return AlFormatChannels.byValue(this.getProperty(AlProperty.FORMAT_CHANNELS_SOFT));
    }

    public AlFormatType getPropertyFormatType() {
        return AlFormatType.byValue(this.getProperty(AlProperty.FORMAT_TYPE_SOFT));
    }


    public AlcError getError() {
        return AlcError.byValue(alcGetError(ID));
    }


    public long getProcAddress(CharSequence funcName) {
        return alcGetProcAddress(ID, funcName);
    }

    public int getEnumValue(CharSequence enumName) {
        return alcGetEnumValue(ID, enumName);
    }


    // ALC_EXT_EFX extension.
    // default 2
    public int getMaxAuxSends() {
        return alcGetInteger(ID, EXTEfx.ALC_MAX_AUXILIARY_SENDS);
    }

    public int getEfxMajorVersion() {
        return alcGetInteger(ID, EXTEfx.ALC_EFX_MAJOR_VERSION);
    }

    public int getEfxMinorVersion() {
        return alcGetInteger(ID, EXTEfx.ALC_EFX_MINOR_VERSION);
    }


    // SOFT_output_mode extension.
    //   This extension provides a method for applications to request a particular output mode for playback devices,
    // and query what's in use. With standard OpenAL, the output mode is at the sole discretion of the library, with
    // the application having no way to know what's being used. While this works fine most of the time (typically the
    // library will be able to query the system configuration and auto-select a mode to match, and the app handles
    // sounds as being in 3D space), this is sometimes not possible or the most ideal option for all use-cases.
    // There are also cases where a desirable output mode isn't distinguishable by the device configuration, for
    // example with stereo vs UHJ vs HRTF.

    public AlOutputMode getOutputMode() {
        return AlOutputMode.byValue(alcGetInteger(ID, SOFTOutputMode.ALC_OUTPUT_MODE_SOFT));
    }


    // ALC_EXT_DEFAULT_FILTER_ORDER extension.
    //   This extension allows the default filter order (i.e. slope) to be selected at context creation time.
    // Attibute DEFAULT_FILTER_ORDER can be used with a value of 1 (for -6dB/oct) or 2 (for -12dB/oct).
    public void getDefalutFilterOrder(IntBuffer dest) {
        alcGetIntegerv(ID, EXTDefaultFilterOrder.ALC_DEFAULT_FILTER_ORDER, dest);
    }

    public void getDefalutFilterOrder(int[] dest) {
        alcGetIntegerv(ID, EXTDefaultFilterOrder.ALC_DEFAULT_FILTER_ORDER, dest);
    }


    // ALC_EXT_disconnect extension.
    //   This extension strives to give the application a means to discover and deal with total device failure.
    public void getConnected(IntBuffer dest) {
        alcGetIntegerv(ID, EXTDisconnect.ALC_CONNECTED, dest);
    }

    public void getConnected(int[] dest) {
        alcGetIntegerv(ID, EXTDisconnect.ALC_CONNECTED, dest);
    }


    // SOFT_pause_device extension.
    //   This extension allows applications to pause a playback device. The main purpose of this is to silence output,
    // stop processing, and allow the audio hardware to go into a low-power mode. On a mobile device, for instance,
    // apps may want to silence output and not waste battery life with unneeded processing when in the background.
    public void pause() {
        SOFTPauseDevice.alcDevicePauseSOFT(ID);
    }

    public void resume() {
        SOFTPauseDevice.alcDeviceResumeSOFT(ID);
    }


    // SOFT_reopen_device extension.
    //   This extension provides a mechanism for applications to move the output of a device from one endpoint to another.
    // Standard OpenAL devices are associated with an output on the system upon being opened, but if the endpoint
    // should no longer be the desired output, there is no method for the application to easily change it.
    // The only option for the application is to delete all AL objects, destroy the context, close the device handle,
    // open a new device, and reload/recreate the necessary resources. A method to more simply move the device with
    // its existing resources to a different output is easier, requiring less management from the application.
    public void reopen(CharSequence deviceName, int... attributes) {
        SOFTReopenDevice.alcReopenDeviceSOFT(ID, deviceName, attributes);
    }

    public void reopen(CharSequence deviceName, IntBuffer attributes) {
        SOFTReopenDevice.alcReopenDeviceSOFT(ID, deviceName, attributes);
    }


    // SOFT_device_clock extension.
    public long getSampleOffsetClock() {
        return SOFTDeviceClock.alcGetInteger64vSOFT(ID, SOFTDeviceClock.AL_SAMPLE_OFFSET_CLOCK_SOFT);
    }

    public long getSecOffsetClock() {
        return SOFTDeviceClock.alcGetInteger64vSOFT(ID, SOFTDeviceClock.AL_SEC_OFFSET_CLOCK_SOFT);
    }

    public long getClockLatency() {
        return SOFTDeviceClock.alcGetInteger64vSOFT(ID, SOFTDeviceClock.ALC_DEVICE_CLOCK_LATENCY_SOFT);
    }

    public long getClock() {
        return SOFTDeviceClock.alcGetInteger64vSOFT(ID, SOFTDeviceClock.ALC_DEVICE_CLOCK_SOFT);
    }

    public long getLatency() {
        return SOFTDeviceClock.alcGetInteger64vSOFT(ID, SOFTDeviceClock.ALC_DEVICE_LATENCY_SOFT);
    }


    // SOFT_HRTF extension.
    public void reset(AlAttributes attributes) {
        SOFTHRTF.alcResetDeviceSOFT(ID, attributes.makeArray());
    }

    public String getHrtfSpecifier(int index) {
        return SOFTHRTF.alcGetStringiSOFT(ID, SOFTHRTF.ALC_HRTF_SPECIFIER_SOFT, index);
    }


    @Override
    public String toString() {
        return this.getSpecifier();
    }

}

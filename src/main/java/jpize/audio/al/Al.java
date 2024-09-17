package jpize.audio.al;

import jpize.audio.al.buffer.AlFormat;
import jpize.audio.al.callback.AlBufferCompletedCallback;
import jpize.audio.al.callback.AlDisconnectedCallback;
import jpize.audio.al.callback.AlSourceStateChangedCallback;
import jpize.audio.al.callback.AlEventType;
import jpize.audio.al.source.AlSourceState;
import jpize.util.Utils;
import org.lwjgl.openal.*;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.openal.AL11.*;

public class Al {

    public static int NONE = AL_NONE;


    public static AlError getError() {
        return AlError.byValue(alGetError());
    }

    public static boolean checkError() {
        final AlError error = getError();
        if(error.noErrors())
            return false;
        System.err.println("[AL Error]: " + error + ". Check: " + Utils.getStackTrace(4));
        return true;
    }


    public static String getAlVendor() {
        return alGetString(AL_VENDOR);
    }

    public static String getAlVersion() {
        return alGetString(AL_VERSION);
    }

    public static String getAlRenderer() {
        return alGetString(AL_RENDERER);
    }


    public static String getExtensions() {
        return alGetString(AL_EXTENSIONS);
    }

    public static boolean isExtensionPresent(CharSequence extension) {
        return alIsExtensionPresent(extension);
    }


    public static float getSpeedOfSound() {
        return alGetFloat(AL_SPEED_OF_SOUND);
    }

    public static void speedOfSound(float speedOfSound) {
        alSpeedOfSound(speedOfSound);
    }


    public static float getDopplerFactor() {
        return alGetFloat(AL_DOPPLER_FACTOR);
    }

    public static void dopplerFactor(float dopplerFactor) {
        alDopplerFactor(dopplerFactor);
    }


    public static void dopplerVelocity(float dopplerVelocity) {
        alDopplerVelocity(dopplerVelocity);
    }


    public static AlDistModel getDistanceModel() {
        return AlDistModel.byValue(alGetInteger(AL_DISTANCE_MODEL));
    }

    public static void distanceModel(AlDistModel distanceModel) {
        alDistanceModel(distanceModel.value);
    }


    public static boolean isEnabled(AlTarget target) {
        return alIsEnabled(target.value);
    }

    public static void enable(AlTarget target) {
        alEnable(target.value);
    }

    public static void disable(AlTarget target) {
        alDisable(target.value);
    }


    public long getProcAddress(CharSequence funcName) {
        return alGetProcAddress(funcName);
    }


    // SOFT_buffer_samples
    public boolean isFormatSupported(AlFormat format) {
        return SOFTBufferSamples.alIsBufferFormatSupportedSOFT(format.value);
    }

    // SOFT_deferred_updates extension.
    public void deferUpdates() {
        SOFTDeferredUpdates.alDeferUpdatesSOFT();
    }

    public void processUpdates() {
        SOFTDeferredUpdates.alProcessUpdatesSOFT();
    }

    public boolean isDefferedUpdates() {
        return alGetBoolean(SOFTDeferredUpdates.AL_DEFERRED_UPDATES_SOFT);
    }


    // SOFT_events extension.
    public static void setEventCallbackNull() {
        SOFTEvents.nalEventCallbackSOFT(0L, 0L);
    }
    public static void setEventCallback(AlSourceStateChangedCallback stateChangedCallback, AlBufferCompletedCallback bufferCompletedCallback, AlDisconnectedCallback disconnectedCallback) {
        SOFTEvents.alEventCallbackSOFT((int alEventType, int uint1, int uint2, int size, long charsPointer, long voidPointer) -> {
            final AlEventType type = AlEventType.byValue(alEventType);
            final String chars = MemoryUtil.memUTF8(charsPointer, size);
            System.out.println(type + ":  " + uint1 + ", " + uint2 + "  <<" + chars + ">>");

            switch(type) {
                case SOURCE_STATE_CHANGED -> {
                    if(stateChangedCallback == null)
                        return;

                    final AlSourceState state = AlSourceState.byValue(uint2);
                    stateChangedCallback.invoke(uint1, state);
                }
                case BUFFER_COMPLETED -> {
                    if(bufferCompletedCallback == null)
                        return;

                    bufferCompletedCallback.invoke(uint1, uint2);
                }
                case DISCONNECTED -> {
                    if(disconnectedCallback == null)
                        return;

                    disconnectedCallback.invoke();
                }
            }
        }, null);
    }

    public static void setEventControl(boolean enable, AlEventType... types) {
        final int[] typesInt = new int[types.length];
        for(int i = 0; i < types.length; i++)
            typesInt[i] = types[i].value;
        SOFTEvents.alEventControlSOFT(typesInt, enable);
    }

    public static void setEventControlAll(boolean enable) {
        setEventControl(enable, AlEventType.values());
    }


    // SOFT_gain_clamp_ex extension. AL_GAIN_LIMIT_SOFT
    public static float getGainLimit() {
        return alGetFloat(SOFTGainClampEx.AL_GAIN_LIMIT_SOFT);
    }


    // SOFT_HRTF extension.
    public static int getHrtfStatus() {
        return alGetInteger(SOFTHRTF.ALC_HRTF_STATUS_SOFT);
    }


    // SOFT_source_resampler extension.
    public static String getResamplerName(int index) {
        return SOFTSourceResampler.alGetStringiSOFT(SOFTSourceResampler.AL_RESAMPLER_NAME_SOFT, index);
    }

    public static int getDefaultResampler() {
        return alGetInteger(SOFTSourceResampler.AL_DEFAULT_RESAMPLER_SOFT);
    }

    public static int getNumResamplers() {
        return alGetInteger(SOFTSourceResampler.AL_NUM_RESAMPLERS_SOFT);
    }


}
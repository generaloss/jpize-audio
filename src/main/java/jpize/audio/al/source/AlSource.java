package jpize.audio.al.source;

import jpize.audio.Audio;
import jpize.audio.al.buffer.AlBuffer;
import jpize.audio.al.AlObjectInt;
import jpize.audio.al.fx.AlEffectSlot;
import jpize.audio.al.fx.AlFilter;
import jpize.util.math.Mathc;
import jpize.util.math.Maths;
import jpize.util.math.vector.Vec3f;
import jpize.util.time.TimeUtils;
import org.lwjgl.openal.*;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Objects;

import static org.lwjgl.openal.AL10.alGetSourcef;
import static org.lwjgl.openal.AL11.*;

public class AlSource extends AlObjectInt {

    public AlSource(int ID) {
        super(ID);
    }

    public AlSource() {
        super(alGenSources());
    }


    public int getBufferID() {
        return alGetSourcei(ID, AL_BUFFER);
    }

    public AlBuffer getBuffer() {
        return new AlBuffer(getBufferID());
    }

    public AlSource setBuffer(int bufferID) {
        alSourcei(ID, AL_BUFFER, bufferID);
        return this;
    }

    public AlSource setBuffer(AlBuffer buffer) {
        if(buffer != null)
            setBuffer(buffer.getID());
        return this;
    }

    public AlSource setBufferNull() {
        alSourcei(ID, AL_BUFFER, 0);
        return this;
    }


    public boolean isLooping() {
        return alGetSourcei(ID, AL_LOOPING) == AL_TRUE;
    }

    public AlSource setLooping(boolean looping) {
        alSourcei(ID, AL_LOOPING, looping ? AL_TRUE : AL_FALSE);
        return this;
    }


    public float getGain() {
        return alGetSourcef(ID, AL_GAIN);
    }

    public AlSource setGain(float gain) {
        alSourcef(ID, AL_GAIN, gain);
        return this;
    }

    public AlSource setGain(double gain) {
        return this.setGain((float) gain);
    }


    public float getMaxGain() {
        return alGetSourcef(ID, AL_MAX_GAIN);
    }

    public AlSource setMaxGain(float maxGain) {
        alSourcef(ID, AL_MAX_GAIN, maxGain);
        return this;
    }

    public AlSource setMaxGain(double maxGain) {
        return this.setMaxGain((float) maxGain);
    }


    public float getMinGain() {
        return alGetSourcef(ID, AL_MIN_GAIN);
    }

    public AlSource setMinGain(float minGain) {
        alSourcef(ID, AL_MIN_GAIN, minGain);
        return this;
    }

    public AlSource setMinGain(double minGain) {
        return this.setMinGain((float) minGain);
    }


    public float getConeOuterGain() {
        return alGetSourcef(ID, AL_CONE_OUTER_GAIN);
    }

    public AlSource setConeOuterGain(float coneOuterGain) {
        alSourcef(ID, AL_CONE_OUTER_GAIN, coneOuterGain);
        return this;
    }

    public AlSource setConeOuterGain(double coneOuterGain) {
        return this.setConeOuterGain((float) coneOuterGain);
    }


    public float getConeInnerAngle() {
        return alGetSourcef(ID, AL_CONE_INNER_ANGLE);
    }

    public AlSource setConeInnerAngle(float coneInnerAngle) {
        alSourcef(ID, AL_CONE_INNER_ANGLE, coneInnerAngle);
        return this;
    }

    public AlSource setConeInnerAngle(double coneInnerAngle) {
        return this.setConeInnerAngle((float) coneInnerAngle);
    }


    public float getConeOuterAngle() {
        return alGetSourcef(ID, AL_CONE_OUTER_ANGLE);
    }

    public AlSource setConeOuterAngle(float coneOuterAngle) {
        alSourcef(ID, AL_CONE_OUTER_ANGLE, coneOuterAngle);
        return this;
    }

    public AlSource setConeOuterAngle(double coneOuterAngle) {
        return this.setConeOuterAngle((float) coneOuterAngle);
    }


    public float getPitch() {
        return alGetSourcef(ID, AL_PITCH);
    }

    public AlSource setPitch(float pitch) {
        alSourcef(ID, AL_PITCH, pitch);
        return this;
    }

    public AlSource setPitch(double pitch) {
        return this.setPitch((float) pitch);
    }


    public float getSecOffset() {
        return alGetSourcef(ID, AL_SEC_OFFSET);
    }

    public AlSource setSecOffset(float seconds) {
        alSourcef(ID, AL_SEC_OFFSET, seconds);
        return this;
    }

    public AlSource setSecOffset(double seconds) {
        return this.setSecOffset((float) seconds);
    }


    public float getSampleOffset() {
        return alGetSourcef(ID, AL_SAMPLE_OFFSET);
    }

    public AlSource setSampleOffset(float samples) {
        alSourcef(ID, AL_SAMPLE_OFFSET, samples);
        return this;
    }

    public AlSource setSampleOffset(double samples) {
        return this.setSampleOffset((float) samples);
    }


    public float getByteOffset() {
        return alGetSourcef(ID, AL_BYTE_OFFSET);
    }

    public AlSource setByteOffset(float bytes) {
        alSourcef(ID, AL_BYTE_OFFSET, bytes);
        return this;
    }

    public AlSource setByteOffset(double bytes) {
        return this.setByteOffset((float) bytes);
    }


    public boolean isRelative(boolean relative) {
        return alGetSourcei(ID, AL_SOURCE_RELATIVE) == AL_TRUE;
    }

    public AlSource setRelative(boolean relative) {
        alSourcei(ID, AL_SOURCE_RELATIVE, relative ? AL_TRUE : AL_FALSE);
        return this;
    }


    private Vec3f getVec3f(int param) {
        final FloatBuffer bufX = MemoryUtil.memAllocFloat(1);
        final FloatBuffer bufY = MemoryUtil.memAllocFloat(1);
        final FloatBuffer bufZ = MemoryUtil.memAllocFloat(1);
        alGetSource3f(ID, param, bufX, bufY, bufZ);
        final Vec3f result = new Vec3f(bufX.get(), bufY.get(), bufZ.get());
        MemoryUtil.memFree(bufX);
        MemoryUtil.memFree(bufY);
        MemoryUtil.memFree(bufZ);
        return result;
    }


    public Vec3f getPosition() {
        return getVec3f(AL_POSITION);
    }

    public AlSource setPosition(float x, float y, float z) {
        alSource3f(ID, AL_POSITION, x, y, z);
        return this;
    }

    public AlSource setPosition(Vec3f position) {
        return this.setPosition(position.x, position.y, position.z);
    }

    public AlSource setPosition(double x, double y, double z) {
        return this.setPosition((float) x, (float) y, (float) z);
    }

    public AlSource setPan(double pan) {
        return this.setPosition(Mathc.cos((pan - 1) * Maths.halfPI), 0, Mathc.sin((pan + 1) * Maths.halfPI));
    }


    public Vec3f getVelocity() {
        return getVec3f(AL_VELOCITY);
    }

    public AlSource setVelocity(float x, float y, float z) {
        alSource3f(ID, AL_VELOCITY, x, y, z);
        return this;
    }

    public AlSource setVelocity(Vec3f velocity) {
        return this.setVelocity(velocity.x, velocity.y, velocity.z);
    }

    public AlSource setVelocity(double x, double y, double z) {
        return this.setVelocity((float) x, (float) y, (float) z);
    }


    public Vec3f getDirection() {
        return getVec3f(AL_DIRECTION);
    }

    public AlSource setDirection(float x, float y, float z) {
        alSource3f(ID, AL_DIRECTION, x, y, z);
        return this;
    }

    public AlSource setDirection(Vec3f direction) {
        return this.setVelocity(direction.x, direction.y, direction.z);
    }

    public AlSource setDirection(double x, double y, double z) {
        return this.setDirection((float) x, (float) y, (float) z);
    }


    public float getRolloffFactor() {
        return alGetSourcef(ID, AL_ROLLOFF_FACTOR);
    }

    public AlSource setRolloffFactor(float rolloffFactor) {
        alSourcef(ID, AL_ROLLOFF_FACTOR, rolloffFactor);
        return this;
    }

    public AlSource setRolloffFactor(double rolloffFactor) {
        return this.setRolloffFactor((float) rolloffFactor);
    }


    public float getMaxDistance() {
        return alGetSourcef(ID, AL_MAX_DISTANCE);
    }

    public AlSource setMaxDistance(float maxDistance) {
        alSourcef(ID, AL_MAX_DISTANCE, maxDistance);
        return this;
    }

    public AlSource setMaxDistance(double maxDistance) {
        return this.setMaxDistance((float) maxDistance);
    }


    public float getReferenceDistance() {
        return alGetSourcef(ID, AL_REFERENCE_DISTANCE);
    }

    public AlSource setReferenceDistance(float referenceDistance) {
        alSourcef(ID, AL_REFERENCE_DISTANCE, referenceDistance);
        return this;
    }

    public AlSource setReferenceDistance(double referenceDistance) {
        return this.setReferenceDistance((float) referenceDistance);
    }


    public AlSourceType getType() {
        return AlSourceType.byAlConst(alGetSourcei(ID, AL_SOURCE_TYPE));
    }

    public AlSource setType(AlSourceType type) {
        alSourcei(ID, AL_SOURCE_TYPE, type.value);
        return this;
    }


    public AlSourceState getState() {
        return AlSourceState.byValue(alGetSourcei(ID, AL_SOURCE_STATE));
    }

    public boolean isPlaying() {
        return getState() == AlSourceState.PLAYING;
    }

    public boolean isPaused() {
        return getState() == AlSourceState.PAUSED;
    }

    public boolean isStopped() {
        return getState() == AlSourceState.STOPPED;
    }

    public boolean isInitial() {
        return getState() == AlSourceState.INITIAL;
    }


    public AlSource play() {
        alSourcePlay(ID);
        return this;
    }

    public AlSource pause() {
        alSourcePause(ID);
        return this;
    }

    public AlSource stop() {
        alSourceStop(ID);
        return this;
    }

    public AlSource rewind() {
        alSourceRewind(ID);
        return this;
    }


    public AlSource waitForPlay() {
        TimeUtils.waitFor(this::isPlaying);
        return this;
    }

    public AlSource waitForPause() {
        TimeUtils.waitFor(this::isPaused);
        return this;
    }

    public AlSource waitForStop() {
        TimeUtils.waitFor(this::isStopped);
        return this;
    }


    public int getBuffersQueued() {
        return alGetSourcei(ID, AL_BUFFERS_QUEUED);
    }

    public int getBuffersProcessed() {
        return alGetSourcei(ID, AL_BUFFERS_PROCESSED);
    }


    public AlSource queueBuffers(int bufferID) {
        alSourceQueueBuffers(ID, bufferID);
        return this;
    }

    public AlSource queueBuffers(int... bufferIDs) {
        alSourceQueueBuffers(ID, bufferIDs);
        return this;
    }

    public AlSource queueBuffers(IntBuffer bufferIDs) {
        alSourceQueueBuffers(ID, bufferIDs);
        return this;
    }

    public AlSource queueBuffers(AlBuffer buffer) {
        return queueBuffers(buffer.getID());
    }

    public AlSource queueBuffers(AlBuffer... buffers) {
        return queueBuffers(AlBuffer.makeArray(buffers));
    }

    public AlSource unqueueBuffers(int bufferID) {
        alSourceUnqueueBuffers(ID, new int[]{ bufferID });
        return this;
    }

    public AlSource unqueueBuffers(int... bufferIDs) {
        alSourceUnqueueBuffers(ID, bufferIDs);
        return this;
    }

    public AlSource unqueueBuffers(IntBuffer bufferIDs) {
        alSourceUnqueueBuffers(ID, bufferIDs);
        return this;
    }

    public AlSource unqueueBuffers(AlBuffer buffer) {
        return unqueueBuffers(buffer.getID());
    }

    public AlSource unqueueBuffers(AlBuffer... buffers) {
        return unqueueBuffers(AlBuffer.makeArray(buffers));
    }

    public int unqueueBuffers() {
        return alSourceUnqueueBuffers(ID);
    }


    public int getByteRwOffsets() {
        return alGetSourcei(ID, SOFTBufferSubData.AL_BYTE_RW_OFFSETS_SOFT);
    }

    public int getSampleRwOffsets() {
        return alGetSourcei(ID, SOFTBufferSubData.AL_SAMPLE_RW_OFFSETS_SOFT);
    }


    // AL_EXT_SOURCE_RADIUS extension.
    //   This extension allows any mono source to be changed to be a "large" source with a radius. The source has a
    // raised cosine shape.
    //   Units are consistent with the coordinate system in use. The value must be at least zero. Use a value of zero
    // to reset to a point source.
    public AlSource setRadius(float radius) {
        alSourcef(ID, EXTSourceRadius.AL_SOURCE_RADIUS, radius);
        return this;
    }

    public AlSource getRadius(float radius) {
        alGetSourcef(ID, EXTSourceRadius.AL_SOURCE_RADIUS);
        return this;
    }

    // AL_EXT_STEREO_ANGLES extension.
    //   This extension allows any stereo source to be "steered" by setting the angles at which the left and right
    // channels should play.
    public AlSource setStereoAngles(float... angles) {
        alSourcefv(ID, EXTStereoAngles.AL_STEREO_ANGLES, angles);
        return this;
    }

    public AlSource setStereoAngles(FloatBuffer angles) {
        alSourcefv(ID, EXTStereoAngles.AL_STEREO_ANGLES, angles);
        return this;
    }


    // SOFT_buffer_samples
    public AlSource getByteRwOffsets(float[] values) {
        alGetSourcefv(ID, SOFTBufferSamples.AL_BYTE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlSource getByteRwOffsets(FloatBuffer values) {
        alGetSourcefv(ID, SOFTBufferSamples.AL_BYTE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlSource getByteRwOffsets(int[] values) {
        alGetSourceiv(ID, SOFTBufferSamples.AL_BYTE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlSource getByteRwOffsets(IntBuffer values) {
        alGetSourceiv(ID, SOFTBufferSamples.AL_BYTE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlSource getSampleRwOffsets(float[] values) {
        alGetSourcefv(ID, SOFTBufferSamples.AL_SAMPLE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlSource getSampleRwOffsets(FloatBuffer values) {
        alGetSourcefv(ID, SOFTBufferSamples.AL_SAMPLE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlSource getSampleRwOffsets(int[] values) {
        alGetSourceiv(ID, SOFTBufferSamples.AL_SAMPLE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlSource getSampleRwOffsets(IntBuffer values) {
        alGetSourceiv(ID, SOFTBufferSamples.AL_SAMPLE_RW_OFFSETS_SOFT, values);
        return this;
    }


    // ALC_EXT_EFX extension.
    //   The Effects Extension is designed to provide a generic, cross-platform
    // framework for adding advanced DSP effects to OpenAL.
    public AlSource setDirectFilter(AlFilter filter) {
        final int filterID = (filter == null ? EXTEfx.AL_FILTER_NULL : filter.getID());
        alSourcei(ID, EXTEfx.AL_DIRECT_FILTER, filterID);
        return this;
    }

    public AlSource setAuxSendFilter(AlEffectSlot slot, int send, AlFilter filter) {
        final int filterID = (filter == null ? EXTEfx.AL_FILTER_NULL : filter.getID());
        final int slotID = (slot == null ? EXTEfx.AL_EFFECT_NULL : slot.getID());
        alSource3i(ID, EXTEfx.AL_AUXILIARY_SEND_FILTER, slotID, send, filterID);
        return this;
    }

    // [0 ... 10], default 0
    public AlSource setAirAbsorptionFactor(int value) {
        alSourcei(ID, EXTEfx.AL_AIR_ABSORPTION_FACTOR, value);
        return this;
    }

    // [0 ... 10], default 0
    public AlSource setRoomRolloffFactor(int value) {
        alSourcei(ID, EXTEfx.AL_ROOM_ROLLOFF_FACTOR, value);
        return this;
    }

    public AlSource setConeOuterGainHF(float value) {
        alSourcef(ID, EXTEfx.AL_CONE_OUTER_GAINHF, value);
        return this;
    }

    public AlSource setDirectFilterGainHFAuto(boolean value) {
        alSourcei(ID, EXTEfx.AL_DIRECT_FILTER_GAINHF_AUTO, value ? 1 : 0);
        return this;
    }

    public AlSource setAuxSendFilterGainAuto(boolean value) {
        alSourcei(ID, EXTEfx.AL_AUXILIARY_SEND_FILTER_GAIN_AUTO, value ? 1 : 0);
        return this;
    }

    public AlSource setAuxSendFilterGainHFAuto(boolean value) {
        alSourcei(ID, EXTEfx.AL_AUXILIARY_SEND_FILTER_GAINHF_AUTO, value ? 1 : 0);
        return this;
    }


    // SOFT_direct_channels extension.
    public AlSource setDirectChannels(boolean enable) {
        alSourcei(ID, SOFTDirectChannels.AL_DIRECT_CHANNELS_SOFT, enable ? 1 : 0);
        return this;
    }

    public AlSource setDirectChannels(boolean... enabled) {
        final int[] values = new int[enabled.length];
        for(int i = 0; i < values.length; i++)
            values[i] = enabled[i] ? 1 : 0;
        alSourceiv(ID, SOFTDirectChannels.AL_DIRECT_CHANNELS_SOFT, values);
        return this;
    }


    public boolean getDirectChannels(boolean enable) {
        return alGetSourcei(ID, SOFTDirectChannels.AL_DIRECT_CHANNELS_SOFT) == 1;
    }

    public AlSource getDirectChannels(boolean... enabled) {
        final int[] values = new int[enabled.length];
        for(int i = 0; i < values.length; i++)
            values[i] = enabled[i] ? 1 : 0;
        alSourceiv(ID, SOFTDirectChannels.AL_DIRECT_CHANNELS_SOFT, values);
        return this;
    }


    // SOFT_source_length extension.
    public int getByteLength() {
        return alGetSourcei(ID, SOFTSourceLength.AL_BYTE_LENGTH_SOFT);
    }

    public int getSampleLength() {
        return alGetSourcei(ID, SOFTSourceLength.AL_SAMPLE_LENGTH_SOFT);
    }

    public float getSecLength() {
        return alGetSourcef(ID, SOFTSourceLength.AL_SEC_LENGTH_SOFT);
    }


    // SOFT_source_resampler extension.
    public AlSource setResampler(int value) {
        alSourcei(ID, SOFTSourceResampler.AL_SOURCE_RESAMPLER_SOFT, value);
        return this;
    }

    public int getResampler() {
        return alGetSourcei(ID, SOFTSourceResampler.AL_SOURCE_RESAMPLER_SOFT);
    }


    // SOFT_source_start_delay extension.
    /**
     * <source>AlExtensions.SOFT_SOURCE_START_DELAY</source>
     *  */
    public AlSource playAtTime(long startTime) {
        SOFTSourceStartDelay.alSourcePlayAtTimeSOFT(ID, startTime);
        return this;
    }

    public static void playAtTime(long startTime, int... sources) {
        SOFTSourceStartDelay.alSourcePlayAtTimevSOFT(sources, startTime);
    }

    public static void playAtTime(long startTime, AlSource... sources) {
        playAtTime(startTime, AlBuffer.makeArray(sources));
    }


    public AlSource playDelayedn(long nanos) {
        final long startTime = (nanos + Objects.requireNonNull(Audio.getCurrentDevice()).getClock());
        return playAtTime(startTime);
    }

    public static void playDelayedn(long nanos, int... sources) {
        final long startTime = (nanos + Objects.requireNonNull(Audio.getCurrentDevice()).getClock());
        playAtTime(startTime, sources);
    }

    public static void playDelayedn(long nanos, AlSource... sources) {
        playDelayedn(nanos, AlBuffer.makeArray(sources));
    }

    public AlSource playDelayedm(long millis) {
        return playDelayedn(millis * Maths.nanosInMsi);
    }

    public static void playDelayedm(long millis, int... sources) {
        playDelayedn(millis * Maths.nanosInMsi, sources);
    }

    public static void playDelayedm(long millis, AlSource... sources) {
        playDelayedm(millis, AlBuffer.makeArray(sources));
    }

    public AlSource playDelayed(double seconds) {
        return playDelayedm((int) (seconds * Maths.msInSeci));
    }

    public static void playDelayed(double seconds, int... sources) {
        playDelayedm((int) (seconds * Maths.msInSeci), sources);
    }

    public static void playDelayed(double seconds, AlSource... sources) {
        playDelayed(seconds, AlBuffer.makeArray(sources));
    }

    // SOFT_UHJ extension.
    public AlSource setStereoMode(StereoMode mode) {
        alSourcei(ID, SOFTUHJ.AL_STEREO_MODE_SOFT, mode.value);
        return this;
    }

    public StereoMode getStereoMode() {
        return StereoMode.byValue(alGetSourcei(ID, SOFTUHJ.AL_STEREO_MODE_SOFT));
    }

    public AlSource setSuperStereoWidth(float value) {
        alSourcef(ID, SOFTUHJ.AL_SUPER_STEREO_WIDTH_SOFT, value);
        return this;
    }

    public float setSuperStereoWidth() {
        return alGetSourcef(ID, SOFTUHJ.AL_SUPER_STEREO_WIDTH_SOFT);
    }


    // SOFT_direct_channels_remix extension.

    // SOFTDirectChannelsRemix.AL_DROP_UNMATCHED_SOFT  // parameter of Sourcei and Sourceiv for the SOFTDirectChannelsRemix.AL_DIRECT_CHANNELS_SOFT property.
    // SOFTDirectChannelsRemix.AL_REMIX_UNMATCHED_SOFT // parameter of Sourcei and Sourceiv for the SOFTDirectChannelsRemix.AL_DIRECT_CHANNELS_SOFT property.



    public AlSource copy() {
        return new AlSource(ID);
    }

    @Override
    public void dispose() {
        alDeleteSources(ID);
    }

}

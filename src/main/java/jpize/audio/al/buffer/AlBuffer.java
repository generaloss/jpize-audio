package jpize.audio.al.buffer;

import jpize.audio.al.AlObjectInt;
import jpize.audio.io.AudioInputStream;
import jpize.util.res.Resource;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.*;

import java.io.InputStream;
import java.nio.*;

import static org.lwjgl.openal.AL11.*;

public class AlBuffer extends AlObjectInt {

    public AlBuffer(int ID) {
        super(ID);
    }

    public AlBuffer() {
        this(alGenBuffers());
    }


    public AlBuffer load(AudioInputStream input) {
        final byte[] data = input.readFully();
        final ByteBuffer buffer = BufferUtils.createByteBuffer(data.length);
        buffer.put(data).flip();
        this.data(buffer, input.getAlFormat(), input.getSampleRate());
        return this;
    }

    public AlBuffer load(String format, InputStream stream) {
        return this.load(AudioInputStream.createByFormat(format, stream));
    }

    public AlBuffer load(Resource res) {
        return this.load(res.extension(), res.inStream());
    }

    public AlBuffer load(String path) {
        return this.load(Resource.internal(path));
    }


    public int getProperty(AlBufProperty property) {
        return alGetBufferi(ID, property.value);
    }

    public int getFrequency() {
        return getProperty(AlBufProperty.FREQUENCY);
    }

    public int getBits() {
        return getProperty(AlBufProperty.BITS);
    }

    public int getChannels() {
        return getProperty(AlBufProperty.CHANNELS);
    }

    public int getSize() {
        return getProperty(AlBufProperty.SIZE);
    }


    public int getSampleBits() {
        return getBits() * getChannels();
    }


    public AlBuffer data(ByteBuffer data, AlFormat format, int frequency) {
        alBufferData(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer data(ShortBuffer data, AlFormat format, int frequency) {
        alBufferData(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer data(IntBuffer data, AlFormat format, int frequency) {
        alBufferData(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer data(FloatBuffer data, AlFormat format, int frequency) {
        alBufferData(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer data(short[] data, AlFormat format, int frequency) {
        alBufferData(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer data(int[] data, AlFormat format, int frequency) {
        alBufferData(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer data(float[] data, AlFormat format, int frequency) {
        alBufferData(ID, format.value, data, frequency);
        return this;
    }


    // AL_EXT_STATIC_BUFFER extension.
    //   This extension provides a means for the caller to avoid the overhead associated with the BufferData call which
    // performs a physical copy of the data provided by the caller to internal buffers. When using the AL_EXT_STATIC_BUFFER
    // extension, OpenAL's internal buffers use the data pointer provided by the caller for all data access.
    public AlBuffer dataStatic(ByteBuffer data, AlFormat format, int frequency) {
        EXTStaticBuffer.alBufferDataStatic(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer dataStatic(ShortBuffer data, AlFormat format, int frequency) {
        EXTStaticBuffer.alBufferDataStatic(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer dataStatic(IntBuffer data, AlFormat format, int frequency) {
        EXTStaticBuffer.alBufferDataStatic(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer dataStatic(FloatBuffer data, AlFormat format, int frequency) {
        EXTStaticBuffer.alBufferDataStatic(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer dataStatic(short[] data, AlFormat format, int frequency) {
        EXTStaticBuffer.alBufferDataStatic(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer dataStatic(int[] data, AlFormat format, int frequency) {
        EXTStaticBuffer.alBufferDataStatic(ID, format.value, data, frequency);
        return this;
    }

    public AlBuffer dataStatic(float[] data, AlFormat format, int frequency) {
        EXTStaticBuffer.alBufferDataStatic(ID, format.value, data, frequency);
        return this;
    }


    // SOFT_buffer_sub_data
    //   This extension allows an application to modify a section of buffered sample data while the buffer is in use.
    public AlBuffer subData(ByteBuffer data, AlFormat format, int offset) {
        SOFTBufferSubData.alBufferSubDataSOFT(ID, format.value, data, offset);
        return this;
    }

    public AlBuffer subData(ShortBuffer data, AlFormat format, int offset) {
        SOFTBufferSubData.alBufferSubDataSOFT(ID, format.value, data, offset);
        return this;
    }

    public AlBuffer subData(IntBuffer data, AlFormat format, int offset) {
        SOFTBufferSubData.alBufferSubDataSOFT(ID, format.value, data, offset);
        return this;
    }

    public AlBuffer subData(FloatBuffer data, AlFormat format, int offset) {
        SOFTBufferSubData.alBufferSubDataSOFT(ID, format.value, data, offset);
        return this;
    }

    public AlBuffer subData(short[] data, AlFormat format, int offset) {
        SOFTBufferSubData.alBufferSubDataSOFT(ID, format.value, data, offset);
        return this;
    }

    public AlBuffer subData(int[] data, AlFormat format, int offset) {
        SOFTBufferSubData.alBufferSubDataSOFT(ID, format.value, data, offset);
        return this;
    }

    public AlBuffer subData(float[] data, AlFormat format, int offset) {
        SOFTBufferSubData.alBufferSubDataSOFT(ID, format.value, data, offset);
        return this;
    }


    public AlBuffer getByteRwOffsets(IntBuffer values) {
        alGetSourceiv(ID, SOFTBufferSubData.AL_BYTE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlBuffer getByteRwOffsets(int[] values) {
        alGetSourceiv(ID, SOFTBufferSubData.AL_BYTE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlBuffer getSampleRwOffsets(IntBuffer values) {
        alGetSourceiv(ID, SOFTBufferSubData.AL_SAMPLE_RW_OFFSETS_SOFT, values);
        return this;
    }

    public AlBuffer getSampleRwOffsets(int[] values) {
        alGetSourceiv(ID, SOFTBufferSubData.AL_SAMPLE_RW_OFFSETS_SOFT, values);
        return this;
    }

    // SOFT_buffer_length_query
    //   This extension adds buffer queries to get the length in bytes, samples, and seconds.
    //   Standard OpenAL only has queries for a buffer's storage size, the bits per sample, channel count, and sample
    // rate, where the application needs to calculate what it wants from those. While this works alright for standard
    // formats and most extension formats, it won't work for certain compressed formats like ADPCM. These extra queries
    // ensure the application can get information about the buffer it may need.
    public int getByteLengthQuery() {
        return alGetBufferi(ID, SOFTBufferLengthQuery.AL_BYTE_LENGTH_SOFT);
    }

    public int getSampleLengthQuery() {
        return alGetBufferi(ID, SOFTBufferLengthQuery.AL_SAMPLE_LENGTH_SOFT);
    }

    public float getSecLengthQuery() {
        return alGetBufferf(ID, SOFTBufferLengthQuery.AL_SEC_LENGTH_SOFT);
    }

    // SOFT_buffer_samples
    //   This extension provides a more flexible mechanism for loading buffer data, as well as a method to retrieve
    // buffer data. Unextended OpenAL only provides a method to specify a single buffer format when loading data,
    // which defines the data given by the application. The AL is given leeway in converting the data, so that it is
    // possible or more efficient to use internally. However, there are some drawbacks to this approach:
    //   The conversion done by the implementation is hidden from the app. This makes it difficult for the app to know
    // what kind of precision it will have, and impossible to request a storage precision.
    //   Conversion is not guaranteed, so the application can be restricted in the formats that can be loaded depending
    // on the implementation.
    //   If the application could specify the internal storage format, as well as use a separate format to specify the
    // incoming data's format, it would allow to add more input formats (signed 8-bit, 32-bit int, and float, for
    // example), with no undue burden placed on the implementation beyond needing some conversion routines.
    // The application can then be assured that many different formats can be loaded, even if storage is restricted to
    // a comparatively small subset.
    //   In addition, unextended OpenAL does not have any methods for updating only a portion of a buffer, nor a method
    // to retrieve the data from a buffer.

    public int getByteLength() {
        return alGetBufferi(ID, SOFTBufferSamples.AL_BYTE_LENGTH_SOFT);
    }

    public int getSampleLength() {
        return alGetBufferi(ID, SOFTBufferSamples.AL_SAMPLE_LENGTH_SOFT);
    }

    public float getSecLength() {
        return alGetBufferf(ID, SOFTBufferSamples.AL_SEC_LENGTH_SOFT);
    }

    public int getInternalFormat() {
        return alGetBufferi(ID, SOFTBufferSamples.AL_INTERNAL_FORMAT_SOFT);
    }


    public AlBuffer samples(int sampleRate, AlInternalFormat internalFormat, int samples, int channels, AlType type, double[] data) {
        SOFTBufferSamples.alBufferSamplesSOFT(ID, sampleRate, internalFormat.bits, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer samples(int sampleRate, AlInternalFormat internalFormat, int samples, int channels, AlType type, float[] data) {
        SOFTBufferSamples.alBufferSamplesSOFT(ID, sampleRate, internalFormat.bits, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer samples(int sampleRate, AlInternalFormat internalFormat, int samples, int channels, AlType type, int[] data) {
        SOFTBufferSamples.alBufferSamplesSOFT(ID, sampleRate, internalFormat.bits, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer samples(int sampleRate, AlInternalFormat internalFormat, int samples, int channels, AlType type, short[] data) {
        SOFTBufferSamples.alBufferSamplesSOFT(ID, sampleRate, internalFormat.bits, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer samples(int sampleRate, AlInternalFormat internalFormat, int samples, int channels, AlType type, ByteBuffer data) {
        SOFTBufferSamples.alBufferSamplesSOFT(ID, sampleRate, internalFormat.bits, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer samples(int sampleRate, AlInternalFormat internalFormat, int samples, int channels, AlType type, DoubleBuffer data) {
        SOFTBufferSamples.alBufferSamplesSOFT(ID, sampleRate, internalFormat.bits, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer samples(int sampleRate, AlInternalFormat internalFormat, int samples, int channels, AlType type, FloatBuffer data) {
        SOFTBufferSamples.alBufferSamplesSOFT(ID, sampleRate, internalFormat.bits, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer samples(int sampleRate, AlInternalFormat internalFormat, int samples, int channels, AlType type, IntBuffer data) {
        SOFTBufferSamples.alBufferSamplesSOFT(ID, sampleRate, internalFormat.bits, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer samples(int sampleRate, AlInternalFormat internalFormat, int samples, int channels, AlType type, ShortBuffer data) {
        SOFTBufferSamples.alBufferSamplesSOFT(ID, sampleRate, internalFormat.bits, samples, channels, type.value, data);
        return this;
    }


    public AlBuffer subSamples(int offset, int samples, int channels, AlType type, double[] data) {
        SOFTBufferSamples.alBufferSubSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer subSamples(int offset, int samples, int channels, AlType type, float[] data) {
        SOFTBufferSamples.alBufferSubSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer subSamples(int offset, int samples, int channels, AlType type, int[] data) {
        SOFTBufferSamples.alBufferSubSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer subSamples(int offset, int samples, int channels, AlType type, short[] data) {
        SOFTBufferSamples.alBufferSubSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer subSamples(int offset, int samples, int channels, AlType type, ByteBuffer data) {
        SOFTBufferSamples.alBufferSubSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer subSamples(int offset, int samples, int channels, AlType type, DoubleBuffer data) {
        SOFTBufferSamples.alBufferSubSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer subSamples(int offset, int samples, int channels, AlType type, FloatBuffer data) {
        SOFTBufferSamples.alBufferSubSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer subSamples(int offset, int samples, int channels, AlType type, IntBuffer data) {
        SOFTBufferSamples.alBufferSubSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer subSamples(int offset, int samples, int channels, AlType type, ShortBuffer data) {
        SOFTBufferSamples.alBufferSubSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }


    public AlBuffer getSamples(int offset, int samples, int channels, AlType type, double[] data) {
        SOFTBufferSamples.alGetBufferSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer getSamples(int offset, int samples, int channels, AlType type, float[] data) {
        SOFTBufferSamples.alGetBufferSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer getSamples(int offset, int samples, int channels, AlType type, int[] data) {
        SOFTBufferSamples.alGetBufferSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer getSamples(int offset, int samples, int channels, AlType type, short[] data) {
        SOFTBufferSamples.alGetBufferSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer getSamples(int offset, int samples, int channels, AlType type, ByteBuffer data) {
        SOFTBufferSamples.alGetBufferSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer getSamples(int offset, int samples, int channels, AlType type, DoubleBuffer data) {
        SOFTBufferSamples.alGetBufferSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer getSamples(int offset, int samples, int channels, AlType type, FloatBuffer data) {
        SOFTBufferSamples.alGetBufferSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer getSamples(int offset, int samples, int channels, AlType type, IntBuffer data) {
        SOFTBufferSamples.alGetBufferSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }

    public AlBuffer getSamples(int offset, int samples, int channels, AlType type, ShortBuffer data) {
        SOFTBufferSamples.alGetBufferSamplesSOFT(ID, offset, samples, channels, type.value, data);
        return this;
    }


    // SOFT_block_alignment extension.
    public AlBuffer setPackBlockAlignment(int value) {
        alBufferi(ID, SOFTBlockAlignment.AL_PACK_BLOCK_ALIGNMENT_SOFT, value);
        return this;
    }

    public AlBuffer setUnpackBlockAlignment(int value) {
        alBufferi(ID, SOFTBlockAlignment.AL_UNPACK_BLOCK_ALIGNMENT_SOFT, value);
        return this;
    }

    public int getPackBlockAlignment() {
        return alGetBufferi(ID, SOFTBlockAlignment.AL_PACK_BLOCK_ALIGNMENT_SOFT);
    }

    public int getUnpackBlockAlignment() {
        return alGetBufferi(ID, SOFTBlockAlignment.AL_UNPACK_BLOCK_ALIGNMENT_SOFT);
    }


    // SOFT_bformat_ex extension.
    public AlBuffer setAmbisonicLayout(AlAmbisonicLayout value) {
        alBufferi(ID, SOFTBformatEx.AL_AMBISONIC_LAYOUT_SOFT, value.value);
        return this;
    }

    public AlBuffer setAmbisonicScaling(AlAmbisonicScaling value) {
        alBufferi(ID, SOFTBformatEx.AL_AMBISONIC_SCALING_SOFT, value.value);
        return this;
    }

    public AlAmbisonicLayout getAmbisonicLayout() {
        return AlAmbisonicLayout.byValue(alGetBufferi(ID, SOFTBformatEx.AL_AMBISONIC_LAYOUT_SOFT));
    }

    public AlAmbisonicScaling getAmbisonicScaling() {
        return AlAmbisonicScaling.byValue(alGetBufferi(ID, SOFTBformatEx.AL_AMBISONIC_SCALING_SOFT));
    }


    // SOFT_loop_points extension.
    public AlBuffer setLoopPoints(int A, int B) {
        alBufferiv(ID, SOFTLoopPoints.AL_LOOP_POINTS_SOFT, new int[] { A, B });
        return this;
    }

    public int[] getLoopPoints() {
        final int[] points = new int[2];
        alGetBufferiv(ID, SOFTLoopPoints.AL_LOOP_POINTS_SOFT, points);
        return points;
    }


    public AlBuffer copy() {
        return new AlBuffer(ID);
    }

    @Override
    public void dispose() {
        alDeleteBuffers(ID);
    }

}

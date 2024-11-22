package jpize.audio.al.device;

import jpize.audio.al.Alc;
import jpize.audio.al.buffer.AlFormat;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import static org.lwjgl.openal.ALC11.*;

public class AlCaptureDevice extends AlAbstractDevice {

    public AlCaptureDevice(CharSequence deviceSpecifier, int frequency, AlFormat format, int samples) {
        super(alcCaptureOpenDevice(deviceSpecifier, frequency, format.value, samples));
    }

    public AlCaptureDevice(int frequency, AlFormat format, int samples) {
        this(Alc.getSystemCaptureDeviceSpecifier(), frequency, format, samples);
    }


    public void start() {
        alcCaptureStart(ID);
    }

    public void stop() {
        alcCaptureStop(ID);
    }


    public int getCaptureSamples() {
        return alcGetInteger(ID, ALC_CAPTURE_SAMPLES);
    }


    public void getSamples(short[] buffer, int samples) {
        alcCaptureSamples(ID, buffer, samples);
    }

    public void getSamples(int[] buffer, int samples) {
        alcCaptureSamples(ID, buffer, samples);
    }

    public void getSamples(float[] buffer, int samples) {
        alcCaptureSamples(ID, buffer, samples);
    }

    public void getSamples(ByteBuffer buffer, int samples) {
        alcCaptureSamples(ID, buffer, samples);
    }

    public void getSamples(ShortBuffer buffer, int samples) {
        alcCaptureSamples(ID, buffer, samples);
    }

    public void getSamples(IntBuffer buffer, int samples) {
        alcCaptureSamples(ID, buffer, samples);
    }

    public void getSamples(FloatBuffer buffer, int samples) {
        alcCaptureSamples(ID, buffer, samples);
    }


    public void getSamples(short[] buffer) {
        getSamples(buffer, getCaptureSamples());
    }

    public void getSamples(int[] buffer) {
        getSamples(buffer, getCaptureSamples());
    }

    public void getSamples(float[] buffer) {
        getSamples(buffer, getCaptureSamples());
    }

    public void getSamples(ByteBuffer buffer) {
        getSamples(buffer, getCaptureSamples());
    }

    public void getSamples(ShortBuffer buffer) {
        getSamples(buffer, getCaptureSamples());
    }

    public void getSamples(IntBuffer buffer) {
        getSamples(buffer, getCaptureSamples());
    }

    public void getSamples(FloatBuffer buffer) {
        getSamples(buffer, getCaptureSamples());
    }


    @Override
    public void dispose() {
        alcCaptureCloseDevice(ID);
    }

}

package jpize.audio;

import jpize.audio.al.Alc;
import jpize.audio.al.buffer.AlFormat;
import jpize.audio.al.context.AlAttributes;
import jpize.audio.al.context.AlContext;
import jpize.audio.al.device.AlAbstractDevice;
import jpize.audio.al.device.AlCaptureDevice;
import jpize.audio.al.device.AlDevice;
import org.lwjgl.openal.ALC;

import java.util.*;

import static org.lwjgl.openal.ALC11.*;

public class Audio {

    private static Map<String, AlDevice> devices;
    private static Map<String, AlCaptureDevice> captureDevices;

    public static void init() {
        devices = new HashMap<>();
        captureDevices = new HashMap<>();
    }


    public static AlDevice openDevice(String specifier, AlAttributes attributes) {
        if(devices.containsKey(specifier))
            throw new RuntimeException("AlDevice '" + specifier + "' already exists");
        final AlDevice device = new AlDevice(specifier, attributes);
        devices.put(specifier, device);
        return device;
    }

    public static AlDevice openDevice(String specifier) {
        return openDevice(specifier, new AlAttributes());
    }

    public static AlDevice openDevice() {
        return openDevice(Alc.getSystemDeviceSpecifier());
    }


    public static AlCaptureDevice openCaptureDevice(String specifier, int frequency, AlFormat format, int samples) {
        if(captureDevices.containsKey(specifier))
            throw new RuntimeException("AlCaptureDevice '" + specifier + "' already exists");
        final AlCaptureDevice device = new AlCaptureDevice(specifier, frequency, format, samples);
        captureDevices.put(specifier, device);
        return device;
    }

    public static AlCaptureDevice openCaptureDevice(int frequency, AlFormat format, int samples) {
        return openCaptureDevice(Alc.getSystemCaptureDeviceSpecifier(), frequency, format, samples);
    }


    public static AlDevice getDevice(String specifier) {
        if(!devices.containsKey(specifier))
            openDevice(specifier);
        return devices.get(specifier);
    }

    public static AlDevice getDevice() {
        return getDevice(Alc.getSystemDeviceSpecifier());
    }

    public static AlCaptureDevice getCaptureDevice(String specifier, int frequency, AlFormat format, int samples) {
        if(!captureDevices.containsKey(specifier))
            openCaptureDevice(specifier, frequency, format, samples);
        return captureDevices.get(specifier);
    }

    public static AlCaptureDevice getCaptureDevice(int frequency, AlFormat format, int samples) {
        return getCaptureDevice(Alc.getCaptureDeviceSpecifier(), frequency, format, samples);
    }


    public static AlDevice getDevice(long ID) {
        for(AlDevice device: devices.values())
            if(device.getID() == ID)
                return device;
        return null;
    }

    public static AlCaptureDevice getCaptureDevice(long ID) {
        for(AlCaptureDevice device: captureDevices.values())
            if(device.getID() == ID)
                return device;
        return null;
    }


    public static AlAbstractDevice getCurrentDevice() {
        final long ID = Alc.getCurrentContextID();

        for(AlDevice device: devices.values())
            if(device.getContext().getID() == ID)
                return device;

        return null;
    }

    public static AlContext getCurrentContext() {
        final long ID = Alc.getCurrentContextID();

        for(AlDevice device: devices.values())
            if(device.getContext().getID() == ID)
                return device.getContext();

        return null;
    }


    public static void dispose() {
        devices.values().forEach(AlDevice::dispose);
        captureDevices.values().forEach(AlCaptureDevice::dispose);
        alcMakeContextCurrent(0);
        ALC.destroy();
    }

}

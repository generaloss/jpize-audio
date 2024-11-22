package jpize.audio.al.context;

import jpize.audio.AlDevices;
import jpize.audio.al.device.AlAbstractDevice;
import jpize.audio.al.device.AlDevice;
import jpize.audio.al.AlObjectLong;
import jpize.util.Disposable;
import org.lwjgl.openal.*;

import static org.lwjgl.openal.ALC11.*;

public class AlContext extends AlObjectLong implements Disposable {

    public AlContext(AlAbstractDevice device, AlAttributes attributes) {
        super(alcCreateContext(device.getID(), attributes.makeArray()));
        if(ID == 0)
            throw new IllegalArgumentException("Invalid context handle.");
    }

    public AlContext(AlAbstractDevice device) {
        this(device, new AlAttributes());
    }


    public boolean makeCurrent() {
        return alcMakeContextCurrent(ID);
    }

    public void makeCurrentAndCheck() {
        if(!makeCurrent())
            throw new IllegalStateException("Failed to make context current.");
    }

    public void process() {
        alcProcessContext(ID);
    }

    public void suspend() {
        alcSuspendContext(ID);
    }


    public long getDeviceID() {
        return alcGetContextsDevice(ID);
    }

    public AlDevice getDevice() {
        return AlDevices.getDevice(getDeviceID());
    }


    // EXT_thread_local_context extension.
    //   This extension introduces the concept of a current thread-local context, with each thread able to have its own
    // current context. The current context is what the al- functions work on, effectively allowing multiple threads
    // to independently drive separate OpenAL playback contexts.
    public boolean setThreadContext() {
        return EXTThreadLocalContext.alcSetThreadContext(ID);
    }

    public static long getThreadContext() {
        return EXTThreadLocalContext.alcGetThreadContext();
    }


    @Override
    public void dispose() {
        alcDestroyContext(ID);
    }


}

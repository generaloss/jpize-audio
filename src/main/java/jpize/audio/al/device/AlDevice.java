package jpize.audio.al.device;

import jpize.audio.al.context.AlAttributes;
import jpize.audio.al.context.AlContext;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;

import static org.lwjgl.openal.ALC11.alcCloseDevice;
import static org.lwjgl.openal.ALC11.alcOpenDevice;

public class AlDevice extends AlAbstractDevice {

    private final AlContext context;

    public AlDevice(CharSequence specifier, AlAttributes attributes) {
        super(alcOpenDevice(specifier));
        try{
            this.context = new AlContext(this, attributes);
        }catch(Exception ignored){
            alcCloseDevice(ID);
            throw new RuntimeException("Unable to create context for loopback device.");
        }
        this.context.makeCurrentAndCheck();
        this.context.process();
        AL.createCapabilities(ALC.createCapabilities(ID));
    }

    public AlDevice(CharSequence specifier) {
        this(specifier, new AlAttributes());
    }

    public AlContext getContext() {
        return context;
    }

    @Override
    public void dispose() {
        context.dispose();
        alcCloseDevice(ID);
    }

}

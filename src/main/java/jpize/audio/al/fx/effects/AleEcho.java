package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleEcho extends AlEffect {

    public AleEcho() {
        super(AlEffectType.ECHO);
    }


    // [ 0.0 ... 0.207], default 0.1
    public AleEcho setDelay(float seconds) {
        super.setFloat(AL_ECHO_DELAY, seconds);
        return this;
    }

    public float getDelay() {
        return super.getFloat(AL_ECHO_DELAY);
    }


    // [0.0 ... 0.404], default 0.1
    public AleEcho setLRDelay(float seconds) {
        super.setFloat(AL_ECHO_LRDELAY, seconds);
        return this;
    }

    public float getLRDelay() {
        return super.getFloat(AL_ECHO_LRDELAY);
    }


    // [0.0 ... 0.99], default 0.5
    public AleEcho setDamping(float value) {
        super.setFloat(AL_ECHO_DAMPING, value);
        return this;
    }

    public float getDamping() {
        return super.getFloat(AL_ECHO_DAMPING);
    }


    // [0.0 ... 1.0], default 0.5
    public AleEcho setFeedback(float value) {
        super.setFloat(AL_ECHO_FEEDBACK, value);
        return this;
    }

    public float getFeedback() {
        return super.getFloat(AL_ECHO_FEEDBACK);
    }


    // [-1.0 ... 1.0], default -1.0
    public AleEcho setSpread(float value) {
        super.setFloat(AL_ECHO_FEEDBACK, value);
        return this;
    }

    public float getSpread() {
        return super.getFloat(AL_ECHO_FEEDBACK);
    }

}

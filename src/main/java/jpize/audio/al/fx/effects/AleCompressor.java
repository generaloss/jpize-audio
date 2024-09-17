package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleCompressor extends AlEffect {

    public AleCompressor() {
        super(AlEffectType.COMPRESSOR);
    }


    // [false, true], default true
    public AleCompressor setOnOff(boolean value) {
        super.setFloat(AL_COMPRESSOR_ONOFF, value ? 1 : 0);
        return this;
    }

    public boolean getOnOff() {
        return super.getFloat(AL_COMPRESSOR_ONOFF) == 1;
    }

}
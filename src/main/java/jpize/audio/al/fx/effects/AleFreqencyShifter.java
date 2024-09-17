package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AleFreqencyShifter extends AlEffect {

    public AleFreqencyShifter() {
        super(AlEffectType.FREQUENCY_SHIFTER);
    }


    // [0.0 ... 24000.0], default 0.0
    public AleFreqencyShifter setFrequency(float hz) {
        super.setFloat(AL_FREQUENCY_SHIFTER_FREQUENCY, hz);
        return this;
    }

    public float getFrequency() {
        return super.getFloat(AL_FREQUENCY_SHIFTER_FREQUENCY);
    }


    // [DOWN, UP, OFF], default DOWN
    public AleFreqencyShifter setLeftDirection(AlFreqShifterDir value) {
        super.setInt(AL_FREQUENCY_SHIFTER_LEFT_DIRECTION, value.value);
        return this;
    }

    public AlFreqShifterDir getLeftDirection() {
        return AlFreqShifterDir.byValue(super.getInt(AL_FREQUENCY_SHIFTER_LEFT_DIRECTION));
    }


    // [DOWN, UP, OFF], default DOWN
    public AleFreqencyShifter setRightDirection(AlFreqShifterDir value) {
        super.setInt(AL_FREQUENCY_SHIFTER_RIGHT_DIRECTION, value.value);
        return this;
    }

    public AlFreqShifterDir getRightDirection() {
        return AlFreqShifterDir.byValue(super.getInt(AL_FREQUENCY_SHIFTER_RIGHT_DIRECTION));
    }

}
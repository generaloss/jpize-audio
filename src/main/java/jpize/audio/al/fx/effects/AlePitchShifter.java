package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

import static org.lwjgl.openal.EXTEfx.*;

public class AlePitchShifter extends AlEffect {

    public AlePitchShifter() {
        super(AlEffectType.PITCH_SHIFTER);
    }


    // [-12 ... 12], default 12
    public AlePitchShifter setCoarseTune(int semitones) {
        super.setInt(AL_PITCH_SHIFTER_COARSE_TUNE, semitones);
        return this;
    }

    public int getCoarseTune() {
        return super.getInt(AL_PITCH_SHIFTER_COARSE_TUNE);
    }


    // [-50 ... 50], default 0
    public AlePitchShifter setFineTune(int cents) {
        super.setInt(AL_PITCH_SHIFTER_FINE_TUNE, cents);
        return this;
    }

    public int getFineTune() {
        return super.getInt(AL_PITCH_SHIFTER_FINE_TUNE);
    }

}
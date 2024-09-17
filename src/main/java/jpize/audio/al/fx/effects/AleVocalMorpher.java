package jpize.audio.al.fx.effects;

import jpize.audio.al.fx.AlEffect;
import jpize.audio.al.fx.AlEffectType;

public class AleVocalMorpher extends AlEffect {

    public static final int AL_VOCAL_MORPHER_PHONEMEA = 1;
    public static final int AL_VOCAL_MORPHER_PHONEMEA_COARSE_TUNING = 2;
    public static final int AL_VOCAL_MORPHER_PHONEMEB = 3;
    public static final int AL_VOCAL_MORPHER_PHONEMEB_COARSE_TUNING = 4;
    public static final int AL_VOCAL_MORPHER_RATE = 6;
    public static final int AL_VOCAL_MORPHER_WAVEFORM = 5;

    public AleVocalMorpher() {
        super(AlEffectType.VOCAL_MORPHER);
    }


    // [0 ... 29], default A
    public AleVocalMorpher setPhonemeA(AlPhoneme phoneme) {
        super.setInt(AL_VOCAL_MORPHER_PHONEMEA, phoneme.value);
        return this;
    }

    public AlPhoneme getPhonemeA() {
        return AlPhoneme.byValue(super.getInt(AL_VOCAL_MORPHER_PHONEMEA));
    }


    // [0 ... 29], default ER
    public AleVocalMorpher setPhonemeB(AlPhoneme phoneme) {
        super.setInt(AL_VOCAL_MORPHER_PHONEMEB, phoneme.value);
        return this;
    }

    public AlPhoneme getPhonemeB() {
        return AlPhoneme.byValue(super.getInt(AL_VOCAL_MORPHER_PHONEMEB));
    }


    // AL_VOCAL_MORPHER_PHONEMEA_COARSE_TUNING, Semitones         , [-24 ... 24]  , 0
    public AleVocalMorpher setPhonemeACoarseTuning(int semitones) {
        super.setInt(AL_VOCAL_MORPHER_PHONEMEA_COARSE_TUNING, semitones);
        return this;
    }

    public int getPhonemeACoarseTuning() {
        return super.getInt(AL_VOCAL_MORPHER_PHONEMEA_COARSE_TUNING);
    }


    // [-24 ... 24], default 0
    public AleVocalMorpher setPhonemeBCoarseTuning(int semitones) {
        super.setInt(AL_VOCAL_MORPHER_PHONEMEB_COARSE_TUNING, semitones);
        return this;
    }

    public float getPhonemeBCoarseTuning() {
        return super.getInt(AL_VOCAL_MORPHER_PHONEMEB_COARSE_TUNING);
    }


    // [SINUSOID, TRIANGLE, SAWTOOTH], default SINUSOID
    public AleVocalMorpher setWaveform(AlMorpherWaveform value) {
        super.setInt(AL_VOCAL_MORPHER_WAVEFORM, value.value);
        return this;
    }

    public AlMorpherWaveform getWaveform() {
        return AlMorpherWaveform.byValue(super.getInt(AL_VOCAL_MORPHER_WAVEFORM));
    }


    // [0.0 ... 10.0], default 1.41
    public AleVocalMorpher setRate(float hz) {
        super.setFloat(AL_VOCAL_MORPHER_RATE, hz);
        return this;
    }

    public float getRate() {
        return super.getFloat(AL_VOCAL_MORPHER_RATE);
    }


}
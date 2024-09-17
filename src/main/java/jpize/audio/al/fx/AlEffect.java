package jpize.audio.al.fx;

import jpize.audio.al.AlObjectInt;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.openal.EXTEfx.*;

// ALC_EXT_EFX extension.
//   The Effects Extension is designed to provide a generic, cross-platform
// framework for adding advanced DSP effects to OpenAL.
public abstract class AlEffect extends AlObjectInt {

    public AlEffect(int ID) {
        super(ID);
    }

    public AlEffect(AlEffectType type) {
        this(alGenEffects());
        this.setInt(AL_EFFECT_TYPE, type.value);
    }

    public AlEffectType getType() {
        return AlEffectType.byValue(getInt(AL_EFFECT_TYPE));
    }

    public boolean isEffect() {
        return alIsEffect(ID);
    }


    protected void setFloat(int param, float value) {
        alEffectf(ID, param, value);
    }

    protected void setFloat(int param, float... values) {
        alEffectfv(ID, param, values);
    }

    protected void setFloat(int param, FloatBuffer values) {
        alEffectfv(ID, param, values);
    }

    protected void setInt(int param, int value) {
        alEffecti(ID, param, value);
    }

    protected void setInt(int param, int... values) {
        alEffectiv(ID, param, values);
    }

    protected void setInt(int param, IntBuffer values) {
        alEffectiv(ID, param, values);
    }


    protected float getFloat(int param) {
        return alGetEffectf(ID, param);
    }

    protected void getFloat(int param, float... values) {
        alGetEffectfv(ID, param, values);
    }

    protected void getFloat(int param, FloatBuffer values) {
        alGetEffectfv(ID, param, values);
    }

    protected int getInt(int param) {
        return alGetEffecti(ID, param);
    }

    protected void getInt(int param, int... values) {
        alGetEffectiv(ID, param, values);
    }

    protected void getInt(int param, IntBuffer values) {
        alGetEffectiv(ID, param, values);
    }


    @Override
    public void dispose() {
        alDeleteEffects(ID);
    }

}

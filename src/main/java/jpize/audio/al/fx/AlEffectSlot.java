package jpize.audio.al.fx;

import jpize.audio.al.AlObjectInt;
import org.lwjgl.openal.SOFTEffectTarget;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.openal.EXTEfx.*;

public class AlEffectSlot extends AlObjectInt {

    public AlEffectSlot(int ID) {
        super(ID);
    }

    public AlEffectSlot() {
        this(alGenAuxiliaryEffectSlots());
    }


    public boolean isEffectSlot() {
        return alIsAuxiliaryEffectSlot(ID);
    }


    // derault null
    public AlEffectSlot setEffect(AlEffect effect) {
        final int effectID = (effect == null ? AL_EFFECT_NULL : effect.getID());
        setInt(AL_EFFECTSLOT_EFFECT, effectID);
        return this;
    }

    public int getEffect() {
        return getInt(AL_EFFECTSLOT_EFFECT);
    }


    // default 1.0
    public AlEffectSlot setGain(float gain) {
        setFloat(AL_EFFECTSLOT_GAIN, gain);
        return this;
    }

    public float getGain() {
        return getFloat(AL_EFFECTSLOT_GAIN);
    }


    // default true
    public AlEffectSlot setSendAuto(boolean value) {
        setInt(AL_EFFECTSLOT_AUXILIARY_SEND_AUTO, value ? 1 : 0);
        return this;
    }

    public boolean getSendAuto() {
        return getInt(AL_EFFECTSLOT_AUXILIARY_SEND_AUTO) == 1;
    }


    // SOFT_effect_target extension.
    public void setTarget(AlEffectSlot value) {
        setInt(SOFTEffectTarget.AL_EFFECTSLOT_TARGET_SOFT, value.getID());
    }


    private void setFloat(int param, float value) {
        alAuxiliaryEffectSlotf(ID, param, value);
    }

    private void setFloat(int param, float... values) {
        alAuxiliaryEffectSlotfv(ID, param, values);
    }

    private void setFloat(int param, FloatBuffer values) {
        alAuxiliaryEffectSlotfv(ID, param, values);
    }

    private void setInt(int param, int value) {
        alAuxiliaryEffectSloti(ID, param, value);
    }

    private void setInt(int param, int... values) {
        alAuxiliaryEffectSlotiv(ID, param, values);
    }

    private void setInt(int param, IntBuffer values) {
        alAuxiliaryEffectSlotiv(ID, param, values);
    }


    private float getFloat(int param) {
        return alGetAuxiliaryEffectSlotf(ID, param);
    }

    private void getFloat(int param, float... values) {
        alGetAuxiliaryEffectSlotfv(ID, param, values);
    }

    private void getFloat(int param, FloatBuffer values) {
        alGetAuxiliaryEffectSlotfv(ID, param, values);
    }

    private int getInt(int param) {
        return alGetAuxiliaryEffectSloti(ID, param);
    }

    private void getInt(int param, int... values) {
        alGetAuxiliaryEffectSlotiv(ID, param, values);
    }

    private void getInt(int param, IntBuffer values) {
        alGetAuxiliaryEffectSlotiv(ID, param, values);
    }


    @Override
    public void dispose() {
        alDeleteAuxiliaryEffectSlots(ID);
    }

}

package jpize.audio.al.fx;

import jpize.audio.al.AlObjectInt;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.openal.EXTEfx.*;

public abstract class AlFilter extends AlObjectInt {

    public AlFilter(int ID) {
        super(ID);
    }

    public AlFilter(AlFilterType type) {
        this(alGenFilters());
        this.setInt(AL_FILTER_TYPE, type.value);
    }

    public AlFilterType getType() {
        return AlFilterType.byValue(getInt(AL_FILTER_TYPE));
    }

    public boolean isFilter() {
        return alIsFilter(ID);
    }


    protected void setFloat(int param, float value) {
        alFilterf(ID, param, value);
    }

    protected void setFloat(int param, float... values) {
        alFilterfv(ID, param, values);
    }

    protected void setFloat(int param, FloatBuffer values) {
        alFilterfv(ID, param, values);
    }

    protected void setInt(int param, int value) {
        alFilteri(ID, param, value);
    }

    protected void setInt(int param, int... values) {
        alFilteriv(ID, param, values);
    }

    protected void setInt(int param, IntBuffer values) {
        alFilteriv(ID, param, values);
    }


    protected float getFloat(int param) {
        return alGetFilterf(ID, param);
    }

    protected void getFloat(int param, float... values) {
        alGetFilterfv(ID, param, values);
    }

    protected void getFloat(int param, FloatBuffer values) {
        alGetFilterfv(ID, param, values);
    }

    protected int getInt(int param) {
        return alGetFilteri(ID, param);
    }

    protected void getInt(int param, int... values) {
        alGetFilteriv(ID, param, values);
    }

    protected void getInt(int param, IntBuffer values) {
        alGetFilteriv(ID, param, values);
    }


    @Override
    public void dispose() {
        alDeleteFilters(ID);
    }

}

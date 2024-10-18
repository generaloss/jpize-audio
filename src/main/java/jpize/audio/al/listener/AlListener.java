package jpize.audio.al.listener;

import jpize.util.math.vector.Vec3f;
import org.lwjgl.openal.EXTEfx;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

import static org.lwjgl.openal.AL11.*;

public class AlListener {

    public static float getGain() {
        return alGetListenerf(AL_GAIN);
    }

    public static void setGain(float gain) {
        alListenerf(AL_GAIN, gain);
    }


    private static Vec3f getVec3f(int paramName) {
        final FloatBuffer bufX = MemoryUtil.memAllocFloat(1);
        final FloatBuffer bufY = MemoryUtil.memAllocFloat(1);
        final FloatBuffer bufZ = MemoryUtil.memAllocFloat(1);
        alGetListener3f(paramName, bufX, bufY, bufZ);
        final Vec3f result = new Vec3f(bufX.get(), bufY.get(), bufZ.get());
        MemoryUtil.memFree(bufX);
        MemoryUtil.memFree(bufY);
        MemoryUtil.memFree(bufZ);
        return result;
    }

    public static Vec3f getVelocity() {
        return getVec3f(AL_VELOCITY);
    }

    public static void setVelocity(float x, float y, float z) {
        alListener3f(AL_VELOCITY, x, y, z);
    }

    public static void setVelocity(Vec3f velocity) {
        alListener3f(AL_VELOCITY, velocity.x, velocity.y, velocity.z);
    }


    public static Vec3f getPosition() {
        return getVec3f(AL_POSITION);
    }

    public static void setPosition(float x, float y, float z) {
        alListener3f(AL_POSITION, x, y, z);
    }

    public static void setPosition(Vec3f position) {
        alListener3f(AL_POSITION, position.x, position.y, position.z);
    }


    public static void setOrientation(float atX, float atY, float atZ, float upX, float upY, float upZ) {
        alListenerfv(AL_ORIENTATION, new float[]{ atX, atY, atZ, upX, upY, upZ });
    }

    public static void setOrientation(float atX, float atY, float atZ) {
        setOrientation(atX, atY, atZ, 0F, 1F, 0F);
    }

    public static void setOrientation(Vec3f at, Vec3f up) {
        setOrientation(at.x, at.y, at.z, up.x, up.y, up.z);
    }

    public static void setOrientation(Vec3f at) {
        setOrientation(at.x, at.y, at.z);
    }


    // ALC_EXT_EFX extension.
    public static void setMetersPerUnit(float value) {
        alListenerf(EXTEfx.AL_METERS_PER_UNIT, value);
    }


}

package jpize.test;

import jpize.audio.al.Alc;
import jpize.audio.al.AlcError;
import org.lwjgl.openal.*;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryUtil;

import java.nio.ShortBuffer;

import static org.lwjgl.openal.ALC10.*;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC11.ALC_CAPTURE_DEVICE_SPECIFIER;
import static org.lwjgl.openal.SOFTLoopback.alcLoopbackOpenDeviceSOFT;

public class MainTest {

    public static void main(String[] args) {
        // Открытие loopback устройства
        long loopbackDevice = alcLoopbackOpenDeviceSOFT((String) null);
        if (loopbackDevice == 0L) {
            System.err.println("Failed to open loopback device.");
            return;
        }

        String loopbackDeviceSpecifier = alcGetString(0, ALC_CAPTURE_DEVICE_SPECIFIER);
        System.out.println("Available loopback devices: " + loopbackDeviceSpecifier);

        // Проверка поддержки расширения SOFT_loopback
        if (!alcIsExtensionPresent(loopbackDevice, "ALC_SOFT_loopback")) {
            System.err.println("SOFT_loopback extension is not supported on this device.");
            alcCloseDevice(loopbackDevice);
            return;
        }

        // Создание контекста с минимальными атрибутами
        int[] contextAttribs = {
            ALC_FREQUENCY, 44100,  // Частота дискретизации
            0
        }; // Пустые атрибуты, для теста
        final long context = alcCreateContext(loopbackDevice, (int[] )null);
        if (context == 0L) {
            int errorCode = alcGetError(loopbackDevice);
            System.err.println("Error creating context with null attributes: " + errorCode);
            throw new RuntimeException("Failed to create context.");
        }

        // Сделать контекст текущим
        if (!alcMakeContextCurrent(context)) {
            System.err.println("Failed to make context current.");
            alcDestroyContext(context);
            alcCloseDevice(loopbackDevice);
            return;
        }

        System.out.println("Loopback context successfully created.");

        // Завершение работы
        alcDestroyContext(context);
        alcCloseDevice(loopbackDevice);
    }

}
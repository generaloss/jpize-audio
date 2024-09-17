package jpize.test;

import jpize.audio.Audio;
import jpize.audio.al.Al;
import jpize.audio.al.AlExtensions;
import jpize.audio.al.Alc;
import jpize.audio.al.device.AlDevice;
import jpize.audio.al.device.AlcExtensions;
import jpize.audio.al.fx.AlEffectSlot;
import jpize.audio.al.fx.effects.AleAutowah;
import jpize.audio.al.fx.effects.AleEcho;
import jpize.audio.al.fx.effects.AleReverb;
import jpize.audio.util.Music;
import jpize.audio.util.Sound;
import jpize.util.res.Resource;
import jpize.util.time.Stopwatch;
import jpize.util.time.TimeUtils;

public class AudioTest {

    public static void main(String[] args) {
        long pid = ProcessHandle.current().pid();

        Audio.init();
        AlDevice device1 = Audio.openDevice();

        System.out.println("AL Extensions: (" + AlExtensions.all().split(" ").length + ") " + AlExtensions.all());
        System.out.println("AL Ext present: " + AlExtensions.SOFT_SOURCE_START_DELAY.isPresent());
        System.out.println("ALC Extensions: (" + AlcExtensions.all().split(" ").length + ") " + AlcExtensions.all());
        System.out.println("ALC Ext present: " + AlcExtensions.EXT_EFX.isPresent());
        System.out.println("Devices: " + Alc.getDeviceSpecifiers());

        System.out.println("Gain limit: " + Al.getGainLimit());

        Stopwatch s = new Stopwatch().start();

        Al.checkError();
        final Music music = new Music("/music.ogg");
        System.out.println("Load time: " + s.getMillis() + "ms");
        music.play();

        while(!Thread.interrupted()){
            TimeUtils.sleepMillis(100);
            music.update();
        }

        TimeUtils.waitFor(() -> !music.isPlaying());
        Audio.dispose();
    }

}

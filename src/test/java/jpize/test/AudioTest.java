package jpize.test;

import jpize.audio.AlDevices;
import jpize.audio.al.Al;
import jpize.audio.al.AlExtensions;
import jpize.audio.al.Alc;
import jpize.audio.al.device.AlDevice;
import jpize.audio.al.device.AlcExtensions;
import jpize.audio.util.AlMusic;
import jpize.util.time.TimeUtils;

public class AudioTest {

    public static void main(String[] args) {
        final AlDevice device1 = AlDevices.openDevice();

        System.out.println("AL Extensions: (" + AlExtensions.all().split(" ").length + ") " + AlExtensions.all());
        System.out.println("AL Ext present: " + AlExtensions.SOFT_SOURCE_START_DELAY.isPresent());
        System.out.println("ALC Extensions: (" + AlcExtensions.all().split(" ").length + ") " + AlcExtensions.all());
        System.out.println("ALC Ext present: " + AlcExtensions.EXT_EFX.isPresent());
        System.out.println("Devices: " + Alc.getDeviceSpecifiers());

        System.out.println("Gain limit: " + Al.getGainLimit());
        Al.checkError();

        AlMusic sound = new AlMusic();
        sound.load("/music.mp3");
        sound.play();

        // Stopwatch s = new Stopwatch().start();
        // final AlMusic music = new AlMusic("/music-loop.ogg");
        // System.out.println("Load time: " + s.getMillis() + "ms");
        // music.setLooping(true);
        // music.play();

        // boolean paused = false;
        while(!Thread.interrupted()){
            sound.update();
            TimeUtils.sleepMillis(200);

            // if(s.getSeconds() > 4 && s.getSeconds() < 8 && !paused){
            //     paused = true;
            //     //music.pause();
            //     //System.out.println("--===PAUSE===--");
            // }else if(s.getSeconds() > 8 && paused){
            //     paused = false;
            //     //music.play();
            //     //System.out.println("--===RESUME===--");
            // }
        }

        // final AlSound sound = new AlSound("/music-loop.mp3");
        // sound.setLooping(true).play();
        TimeUtils.waitFor(() -> !sound.isPlaying());

        // music.stop();
        AlDevices.dispose();
    }

}

# [Audio Module](https://github.com/generaloss/jpize-audio)
![logo](logo.svg)

[![Maven Central](https://img.shields.io/maven-central/v/io.github.generaloss/jpize-audio.svg)](https://mvnrepository.com/artifact/io.github.generaloss/jpize-audio)

---

Allows loading audio files (ogg, mp3, wav) and playing them with OpenAL.

Provides most OpenAL extensions.

---

## Examples

#### Simple sound example
``` java
public static void main(String[] args) {
    AlDevices.openDevice();
    
    AlSound sound = new AlSound("/sound.mp3");
    sound.setGain(0.5);
    sound.play();
    
    TimeUtils.waitFor(sound::isStopped);
    
    AlDevices.dispose();
}
```

#### Open devices
``` java
// device attributes (optional)
AlAttributes attributes = new AlAttributes()
    .setFormatChannels(AlFormatChannels)
    .setFormatType(AlFormatType)
    .setFrequency(int)
    .setMonoSources(int)
    .setOutputLimiter(boolean)
    .setOutputMode(AlOutputMode)
    .setRefresh(int)
    .setStereoSources(int)
    .setSync(boolean);

// open speaker device
AlDevice device = AlDevices.openDevice(String specifier, attributes);
AlDevice device = AlDevices.openDevice(String specifier); // no custom attributes
AlDevice device = AlDevices.openDevice(attributes);       // default specifier
AlDevice device = AlDevices.openDevice();                 // default specifier & no attributes

// open capture device
AlCaptureDevice device = AlDevices.openCaptureDevice(String specifier, int frequency, AlFormat format, int samples);
AlCaptureDevice device = AlDevices.openCaptureDevice(int frequency, AlFormat format, int samples); // default specifier

// close devices
AlDevices.dispose();
```

``` java
// open all devices
for(String specifier: AlDevices.getDeviceSpecifiers()){
    AlDevices.openDevice(specifier);
    System.out.println("Opened device: " + specifier);
}
// open all capture devices
for(String specifier: AlDevices.getCaptureDeviceSpecifiers()){
    AlDevices.openCaptureDevice(specifier, 44100, AlFormat.MONO16, 128);
    System.out.println("Opened capture device: " + specifier);
}
// make current
AlDevices.getDevice("Your Device Specifier").makeContextCurrent();
System.out.println(AlDevices.getCurrentDevice()); // "Your Device Specifier"
```

#### Music
The AlMusic class does not load the entire file (which can take a long time), 
it loads the file piece by piece as it plays.
``` java
AlMusic music = new AlMusic(String internalPath);
AlMusic music = new AlMusic(Resource res);
AlMusic music = new AlMusic(int buffersNum, int bufferSize);
AlMusic music = new AlMusic().load(...);

// play
music.setGain(0.5);
music.play();

void loop() {
    sound.update(); // need to be updated in loop
}

// free resources
music.dispose();
```

#### Sound
The AlSound class loads the file into a buffer and plays it.
``` java
AlSound sound = new AlSound(String internalPath);
AlSound sound = new AlSound(Resource resource);
AlSound sound = new AlSound(ByteBuffer data, AlFormat format, int frequency);
AlSound sound = new AlSound(ByteBuffer data, int bits, int channels, int frequency);
AlSound sound = new AlSound().load(...);

// play
sound.setGain(0.5); // there are many more methods inherited from AlSource
sound.play();

// free sound
sound.dispose();
```

#### Buffers & Sources
``` java
AlBuffer buffer = new AlBuffer()
    .load("/sound.mp3");

AlSource source = new AlSource()
    .setBuffer(buffer)
    .setGain(0.5)
    .play();
    
// free resources
buffer.dispose();
source.dispose();
```

#### Sources Pool
``` java
AlSourcePool pool = new AlSourcePool(int count);

// play with a specific gain & pitch
pool.play(AlBuffer buffer, double gain, double pitch);
pool.play(AlBuffer buffer, double gain);
pool.play(AlBuffer buffer);

// find free source
AlSource source = pool.findFreeSource();
if(source != null) {
    // play with a gain and more
    source.setBuffer(AlBuffer buffer);
    source.setGain(double gain);
    source.play();
}

// free sources
pool.dispose();
```

#### Effects

``` java
// create echo effect
AleEcho effect = new AleEcho() // or any other effect
    .setDelay(0.207F);
    
// create effect slot
AlEffectSlot effectSlot = new AlEffectSlot()
    .setEffect(effect);

// play
AlSource source; // or any AlSource inheritor (AlSound, AlMusic, AlSpeaker, ...)
source.setAuxSendFilter(effectSlot, 0, null);
source.play();

// free resources
effect.dispose();
effectSlot.dispose();
```

#### Filters

``` java
// create filter
AlfHighpass filter = new AlfHighpass() // or any other filter
    .setGainLF(0.3F);

AlSource source; // or any AlSource inheritor (AlSound, AlMusic, AlSpeaker, ...)
source.setDirectFilter(filter);
source.play();

// free resources
filter.dispose();
```

#### Speaker
``` java
AlSpeaker speaker = new AlSpeaker(int buffersNum, AlFormat format, int sampleRate);
AlSpeaker speaker = new AlSpeaker(int buffersNum);

// setup
speaker.setFormat(AlFormat format);
speaker.setSampleRate(int sampleRate);

// play samples
speaker.play(byte[] data);

// free resources
speaker.dispose();
```

#### Queued Speaker
``` java
AlSpeakerQueued speaker = new AlSpeakerQueued(int buffersNum, int bufferSize, AlFormat format, int sampleRate) { ... }
AlSpeakerQueued speaker = new AlSpeakerQueued(int buffersNum, int bufferSize);

// queue samples to play
speaker.play();
speaker.queueData(byte[] data);

void loop() {
    speaker.update(); // need to be updated in loop
}

// free resources
speaker.dispose();
```


---

## Used libs:
* *[lwjgl3](https://github.com/LWJGL/lwjgl3)*
* *[joribs](https://github.com/ymnk/jorbis)*
* *[jlayer](https://github.com/umjammer/jlayer)*
* *[jpize-utils](https://github.com/generaloss/jpize-utils)*

---

## Bugs and Feedback
For bugs, questions and discussions please use the [GitHub Issues](https://github.com/generaloss/jpize-audio/issues).

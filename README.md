# [Audio Module](https://github.com/generaloss/jpize-audio)
![logo](logo.svg)

[![Maven Central](https://img.shields.io/maven-central/v/io.github.generaloss/jpize-audio.svg)](https://mvnrepository.com/artifact/io.github.generaloss/jpize-audio)

---

Allows loading audio files (ogg, mp3, wav) and playing them with OpenAL.

Provides most OpenAL extensions.

---

## Example
``` java
AlDevices.openDevice();

AlSound sound = new AlSound("/sound.mp3")
    .setGain(0.5)
    .play();
    
AlMusic sound = new AlMusic("/music.mp3")
    .setGain(0.5)
    .play();

AlDevices.dispose();
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
# [Audio Module](https://github.com/generaloss/jpize-audio)
![logo](logo.svg)

Allows loading audio files (ogg, mp3, wav) and playing them with OpenAL.

Provides most OpenAL extensions.

---

## Getting Started

### Maven
```xml
<!-- jpize-audio -->
<dependency>
    <groupId>io.github.generaloss</groupId>
    <artifactId>jpize-audio</artifactId>
    <version>24.11.1</version>
</dependency>
```
### Gradle (Kotlin)
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.generaloss:jpize-audio:24.11.1")
}
```

---

## Example
``` java
Audio.init();
Audio.openDevice();

AlSound sound = new AlSound("/sound.mp3")
    .setGain(0.5)
    .play();
    
AlMusic sound = new AlMusic("/music.mp3")
    .setGain(0.5)
    .play();

Audio.dispose();
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
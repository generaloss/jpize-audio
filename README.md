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
    <version>24.7.1</version>
</dependency>
```
### Gradle (Kotlin)
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.generaloss:jpize-audio:24.7.1")
}
```

---

## Example
``` java
// sound
Audio.init();
Audio.openDevice();

Sound sound = new Sound("/sound.mp3")
    .setGain(0.5)
    .play();
    
Music sound = new Music("/music.mp3")
    .setGain(0.5)
    .play();

Audio.dispose();
```

---

## Used libs:
* *[LWJGL3](https://github.com/LWJGL/lwjgl3)*
* *[Joribs](https://github.com/ymnk/jorbis)*
* *[JLayer](https://github.com/umjammer/jlayer)*
* *[Jpize-Utils](https://github.com/generaloss/jpize-utils)*

---

## Bugs and Feedback
For bugs, questions and discussions please use the [GitHub Issues](https://github.com/generaloss/jpize-audio/issues).
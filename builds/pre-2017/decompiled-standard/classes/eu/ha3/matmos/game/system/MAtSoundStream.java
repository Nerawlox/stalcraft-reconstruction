/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.system;

import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.game.system.MAtSoundManagerChild;
import java.net.URL;
import paulscode.sound.SoundSystem;

public class MAtSoundStream {
    private final String SOURCE_PREFIX = "MATMOS_SRM_";
    private final int number;
    private MAtSoundManagerChild refer;
    private final String sourceName;
    private String path;
    private float volume;
    private float pitch;
    private boolean isInitialized;
    private boolean loopingIsSet;
    private boolean isPaused;
    private URL poolURL;
    private boolean isValid;
    private float playbackVolume;

    public MAtSoundStream(int n, MAtSoundManagerChild mAtSoundManagerChild) {
        this.number = n;
        this.refer = mAtSoundManagerChild;
        this.sourceName = this.SOURCE_PREFIX + this.number;
        this.poolURL = null;
    }

    public void startStreaming(float f, int n) {
        this.ensureInitialized();
        if (!this.isValid) {
            return;
        }
        SoundSystem soundSystem = this.refer.getSoundSystem();
        if (soundSystem == null) {
            this.invalidSoundSystem();
            return;
        }
        if (!this.loopingIsSet) {
            if (n == 0) {
                soundSystem.setLooping(this.sourceName, true);
            } else {
                soundSystem.setLooping(this.sourceName, false);
            }
            this.loopingIsSet = true;
        }
        this.evaluateAndApplyVolume();
        if (f == 0.0f) {
            if (this.isPaused) {
                soundSystem.play(this.sourceName);
            } else {
                soundSystem.play(this.sourceName);
                soundSystem.fadeOutIn(this.sourceName, this.poolURL, this.path, 1L, 1L);
            }
        } else {
            soundSystem.play(this.sourceName);
            soundSystem.fadeOutIn(this.sourceName, this.poolURL, this.path, 1L, (long)f * 1000L);
        }
    }

    private void ensureInitialized() {
        if (this.isInitialized) {
            return;
        }
        MAtmosConvLogger.info("Initializing source: " + this.sourceName + " (" + this.path + ")");
        SoundSystem soundSystem = this.refer.getSoundSystem();
        xavs xavs2 = this.refer.getSoundPoolEntryOf(this.path);
        if (soundSystem != null && xavs2 != null) {
            this.poolURL = xavs2._b();
            this.path = xavs2._a();
            MAtmosConvLogger.info("Source: " + this.sourceName + " is being initialized with URL: " + xavs2._b().toString());
            soundSystem.newStreamingSource(true, this.sourceName, this.poolURL, this.path, true, 0.0f, 0.0f, 0.0f, 0, 0.0f);
            soundSystem.setTemporary(this.sourceName, false);
            soundSystem.setPitch(this.sourceName, this.pitch);
            soundSystem.setLooping(this.sourceName, true);
            soundSystem.activate(this.sourceName);
            this.isValid = true;
        } else if (soundSystem == null) {
            this.invalidSoundSystem();
        }
        this.isInitialized = true;
    }

    public void setWeakPath(String string) {
        this.path = string;
    }

    public void setVolume(float f) {
        this.volume = f;
    }

    public void setPitch(float f) {
        this.pitch = f;
    }

    public void setPlaybackVolumeMod(float f) {
        this.playbackVolume = f;
        if (this.isInitialized) {
            this.evaluateAndApplyVolume();
        }
    }

    private void evaluateAndApplyVolume() {
        if (!this.isInitialized) {
            return;
        }
        if (!this.isValid) {
            return;
        }
        float f = this.playbackVolume * this.volume;
        SoundSystem soundSystem = this.refer.getSoundSystem();
        if (soundSystem == null) {
            this.invalidSoundSystem();
            return;
        }
        soundSystem.setVolume(this.sourceName, f);
    }

    public void stopStreaming(float f) {
        if (!this.isValid) {
            return;
        }
        SoundSystem soundSystem = this.refer.getSoundSystem();
        if (soundSystem == null) {
            this.invalidSoundSystem();
            return;
        }
        if (f <= 0.0f) {
            soundSystem.stop(this.sourceName);
        } else {
            soundSystem.fadeOut(this.sourceName, null, (long)f * 1000L);
        }
    }

    public void pauseStreaming() {
        if (!this.isValid) {
            return;
        }
        SoundSystem soundSystem = this.refer.getSoundSystem();
        if (soundSystem == null) {
            this.invalidSoundSystem();
            return;
        }
        soundSystem.pause(this.sourceName);
        this.isPaused = true;
    }

    public void unallocate() {
        if (!this.isInitialized) {
            return;
        }
        if (!this.isValid) {
            return;
        }
        SoundSystem soundSystem = this.refer.getSoundSystem();
        if (soundSystem == null) {
            this.invalidSoundSystem();
            return;
        }
        soundSystem.stop(this.sourceName);
        soundSystem.removeSource(this.sourceName);
    }

    private void invalidSoundSystem() {
        MAtmosConvLogger.warning("Tried to perform an operation on null SoundSystem");
        Thread.dumpStack();
    }
}


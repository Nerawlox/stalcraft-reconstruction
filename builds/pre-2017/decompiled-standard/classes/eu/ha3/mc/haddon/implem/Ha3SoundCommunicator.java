/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon.implem;

import eu.ha3.mc.haddon.Haddon;
import eu.ha3.mc.haddon.PrivateAccessException;
import net.minecraft.client.xpzm;
import paulscode.sound.SoundSystem;

public class Ha3SoundCommunicator {
    private Haddon mod;
    private String prefix;
    private int maxIDs;
    private int lastSoundID;

    public Ha3SoundCommunicator(Haddon haddon, String string) {
        this.mod = haddon;
        this.prefix = string;
        this.maxIDs = 256;
    }

    public void setMaxIDs(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.maxIDs = n;
    }

    public SoundSystem getSoundSystem() {
        try {
            return (SoundSystem)this.mod.getUtility().getPrivate(this.getSoundManager(), "sndSystem");
        }
        catch (PrivateAccessException privateAccessException) {
            privateAccessException.printStackTrace();
            return null;
        }
    }

    public jzqf getSoundManager() {
        return xpzm._E()._N;
    }

    public void playSoundViaManager(String string, float f, float f2, float f3, float f4, float f5) {
        this.getSoundManager()._a(string, f, f2, f3, f4, f5);
    }

    public void playSound(String string, float f, float f2, float f3, float f4, float f5) {
        try {
            float f6 = xpzm._E()._M.field_74340_b;
            if (f6 == 0.0f) {
                return;
            }
            xavs xavs2 = ((uiog)this.mod.getUtility().getPrivate(this.getSoundManager(), "soundPoolSounds"))._c(string);
            if (xavs2 != null && f4 > 0.0f) {
                SoundSystem soundSystem = this.getSoundSystem();
                this.lastSoundID = (this.lastSoundID + 1) % this.maxIDs;
                String string2 = this.prefix + this.lastSoundID;
                float f7 = 16.0f;
                if (f4 > 1.0f) {
                    f7 *= f4;
                }
                soundSystem.newSource(f4 > 1.0f, string2, xavs2._b(), xavs2._a(), false, f, f2, f3, 2, f7);
                soundSystem.setPitch(string2, f5);
                if (f4 > 1.0f) {
                    f4 = 1.0f;
                }
                soundSystem.setVolume(string2, f4 * f6);
                soundSystem.play(string2);
            }
        }
        catch (PrivateAccessException privateAccessException) {
            // empty catch block
        }
    }

    public void playSound(String string, float f, float f2, float f3, float f4, float f5, int n, float f6) {
        jzqf jzqf2 = this.getSoundManager();
        SoundSystem soundSystem = this.getSoundSystem();
        try {
            float f7 = xpzm._E()._M.field_74340_b;
            if (f7 == 0.0f) {
                return;
            }
            xavs xavs2 = ((uiog)this.mod.getUtility().getPrivate(this.getSoundManager(), "soundPoolSounds"))._c(string);
            if (xavs2 != null && f4 > 0.0f) {
                this.lastSoundID = (this.lastSoundID + 1) % this.maxIDs;
                String string2 = this.prefix + this.lastSoundID;
                soundSystem.newSource(f4 > 1.0f, string2, xavs2._b(), xavs2._a(), false, f, f2, f3, n, f6);
                soundSystem.setPitch(string2, f5);
                if (f4 > 1.0f) {
                    f4 = 1.0f;
                }
                soundSystem.setVolume(string2, f4 * f7);
                soundSystem.play(string2);
            }
        }
        catch (PrivateAccessException privateAccessException) {
            privateAccessException.printStackTrace();
        }
    }
}


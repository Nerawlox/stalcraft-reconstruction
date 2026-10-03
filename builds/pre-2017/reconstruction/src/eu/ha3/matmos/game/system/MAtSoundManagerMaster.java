/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.system;

import eu.ha3.matmos.conv.CustomVolume;
import eu.ha3.matmos.conv.ReplicableSoundRelay;
import eu.ha3.matmos.game.data.MAtAccessors;
import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.matmos.game.system.MAtSoundManagerChild;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.Minecraft;
import paulscode.sound.SoundSystem;

public class MAtSoundManagerMaster
implements CustomVolume,
ReplicableSoundRelay {
    private MAtMod mod;
    private float volume;
    private int nbTokens;
    private Map<String, String> soundequivalences;
    private float settingsVolume;
    private Random random;

    public MAtSoundManagerMaster(MAtMod mAtMod) {
        this.mod = mAtMod;
        this.volume = 1.0f;
        this.nbTokens = 0;
        this.soundequivalences = new HashMap<String, String>();
        this.settingsVolume = 0.0f;
        this.random = new Random();
    }

    public SoundSystem sndSystem() {
        return this.mod.getSoundCommunicator().getSoundSystem();
    }

    @Override
    public float getVolume() {
        return this.volume;
    }

    @Override
    public void routine() {
        this.updateSettingsVolume();
    }

    @Override
    public void cacheSound(String string) {
        this.getSound(string);
    }

    public String getSound(String string) {
        if (this.soundequivalences.containsKey(string)) {
            return this.soundequivalences.get(string);
        }
        String string2 = string.substring(0, string.indexOf("."));
        String string3 = string2.replaceAll("/", ".");
        while (Character.isDigit(string.charAt(string3.length() - 1))) {
            string3 = string3.substring(0, string3.length() - 1);
        }
        this.soundequivalences.put(string, string3);
        return string3;
    }

    @Override
    public void playSound(String string, float f, float f2, int n) {
        Minecraft minecraft = Minecraft._E();
        float f3 = (float)minecraft._t.posX;
        float f4 = (float)minecraft._t.posY;
        float f5 = (float)minecraft._t.posZ;
        String string2 = this.getSound(string);
        float f6 = this.getVolume() * f;
        if (f6 <= 0.0f) {
            return;
        }
        if (n > 0) {
            double d = (double)(this.random.nextFloat() * 2.0f) * Math.PI;
            f4 = f4 + this.random.nextFloat() * (float)n * 0.2f - (float)n * 0.01f;
            this.mod.getSoundCommunicator().playSound(string2, f3 += (float)(Math.cos(d) * (double)n), f4, f5 += (float)(Math.sin(d) * (double)n), f6, f2, 0, 0.0f);
        } else {
            this.mod.getSoundCommunicator().playSound(string2, f3, f4 += 2048.0f, f5, f6, f2, 0, 0.0f);
        }
    }

    @Override
    public synchronized int getNewStreamingToken() {
        int n = this.nbTokens++;
        return n;
    }

    @Override
    public synchronized boolean setupStreamingToken(int n, String string, float f, float f2) {
        return true;
    }

    @Override
    public synchronized void startStreaming(int n, float f, int n2) {
    }

    @Override
    public synchronized void stopStreaming(int n, float f) {
    }

    @Override
    public synchronized void pauseStreaming(int n, float f) {
    }

    @Override
    public synchronized void eraseStreamingToken(int n) {
    }

    @Override
    public void setVolume(float f) {
        this.volume = f;
    }

    private void updateSettingsVolume() {
        Minecraft minecraft = Minecraft._E();
        if (this.settingsVolume != minecraft._M.soundVolume) {
            this.settingsVolume = minecraft._M.soundVolume;
        }
    }

    public float getSettingsVolume() {
        return this.settingsVolume;
    }

    public xavs getSoundPoolEntryOf(String string) {
        return MAtAccessors.getSoundPoolSounds(this.mod.util())._c(this.getSound(string));
    }

    public SoundSystem getSoundSystem() {
        return this.mod.getSoundCommunicator().getSoundSystem();
    }

    @Override
    public MAtSoundManagerChild createChild() {
        return new MAtSoundManagerChild(this);
    }
}


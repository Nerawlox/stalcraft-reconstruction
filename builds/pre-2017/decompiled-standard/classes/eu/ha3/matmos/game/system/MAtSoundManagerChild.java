/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.system;

import eu.ha3.matmos.conv.CustomVolume;
import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.engine.interfaces.SoundRelay;
import eu.ha3.matmos.game.system.MAtSoundManagerMaster;
import eu.ha3.matmos.game.system.MAtSoundStream;
import java.util.HashMap;
import java.util.Map;
import paulscode.sound.SoundSystem;

public class MAtSoundManagerChild
implements CustomVolume,
SoundRelay {
    private MAtSoundManagerMaster master;
    private float managerVolume;
    private Map<Integer, MAtSoundStream> tokens;
    private float masterVolumeCheck;
    private float settingsVolumeCheck;

    public MAtSoundManagerChild(MAtSoundManagerMaster mAtSoundManagerMaster) {
        this.master = mAtSoundManagerMaster;
        this.managerVolume = 1.0f;
        this.tokens = new HashMap<Integer, MAtSoundStream>();
        this.masterVolumeCheck = -1.0f;
    }

    private MAtSoundManagerMaster getMaster() {
        return this.master;
    }

    @Override
    public void setVolume(float f) {
        this.managerVolume = f;
        this.propagateVolume();
    }

    @Override
    public float getVolume() {
        return this.managerVolume;
    }

    @Override
    public void routine() {
        if (this.masterVolumeCheck != this.getMaster().getVolume() || this.settingsVolumeCheck != this.getMaster().getSettingsVolume()) {
            this.propagateVolume();
            this.masterVolumeCheck = this.getMaster().getVolume();
            this.settingsVolumeCheck = this.getMaster().getSettingsVolume();
        }
    }

    private void propagateVolume() {
        float f = this.computePlaybackVolume();
        for (MAtSoundStream mAtSoundStream : this.tokens.values()) {
            mAtSoundStream.setPlaybackVolumeMod(f);
        }
    }

    private float computePlaybackVolume() {
        return this.getMaster().getVolume() * this.managerVolume * this.getMaster().getSettingsVolume();
    }

    @Override
    public void cacheSound(String string) {
        this.getMaster().cacheSound(string);
    }

    @Override
    public void playSound(String string, float f, float f2, int n) {
        this.master.playSound(string, this.managerVolume * f, f2, n);
    }

    @Override
    public int getNewStreamingToken() {
        int n = this.getMaster().getNewStreamingToken();
        this.tokens.put(n, new MAtSoundStream(n, this));
        return n;
    }

    @Override
    public boolean setupStreamingToken(int n, String string, float f, float f2) {
        this.cacheSound(string);
        MAtSoundStream mAtSoundStream = this.tokens.get(n);
        mAtSoundStream.setWeakPath(string);
        mAtSoundStream.setVolume(f);
        mAtSoundStream.setPitch(f2);
        mAtSoundStream.setPlaybackVolumeMod(this.computePlaybackVolume());
        return true;
    }

    @Override
    public void startStreaming(int n, float f, int n2) {
        this.tokens.get(n).startStreaming(f, n2);
    }

    @Override
    public void stopStreaming(int n, float f) {
        this.tokens.get(n).stopStreaming(f);
    }

    @Override
    public void pauseStreaming(int n, float f) {
        this.tokens.get(n).pauseStreaming();
    }

    @Override
    public void eraseStreamingToken(int n) {
        MAtmosConvLogger.info("Erasing token #" + n);
        MAtSoundStream mAtSoundStream = this.tokens.get(n);
        mAtSoundStream.unallocate();
        this.tokens.remove(n);
    }

    public xavs getSoundPoolEntryOf(String string) {
        return this.master.getSoundPoolEntryOf(string);
    }

    public SoundSystem getSoundSystem() {
        return this.master.getSoundSystem();
    }

    public void finalize() {
        MAtmosConvLogger.info("Calling finalizer of SMC");
        try {
            for (MAtSoundStream mAtSoundStream : this.tokens.values()) {
                try {
                    mAtSoundStream.unallocate();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}


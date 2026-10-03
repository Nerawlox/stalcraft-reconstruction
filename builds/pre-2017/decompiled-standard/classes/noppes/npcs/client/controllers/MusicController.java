/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mods.sound.SoundMod;
import net.minecraft.client.xpzm;
import noppes.npcs.client.AssetsBrowser;
import org.apache.commons.io.FileUtils;

public class MusicController {
    public static final boolean ENABLE_SOUND_CACHE = Boolean.parseBoolean(System.getProperty("CustomNpcsSoundCache"));
    public static MusicController Instance;
    public String playing = "";
    private uiog musicPool;
    public List<String> soundList = new ArrayList<String>();
    private int soundID = 0;

    public MusicController() {
        Instance = this;
        this.musicPool = new uiog(xpzm._E()._S(), "music", false);
        this.loadSounds();
    }

    private void loadSounds() {
        System.out.println("Loading custZoneomnpc sounds...");
        long l = System.currentTimeMillis();
        this.loadSounds(xpzm._E()._N._e, "customsounds.txt", "/customnpcs/sound/", "customnpcs:", false);
        this.loadSounds(this.musicPool, "custommusic.txt", "/customnpcs/music/", "customnpcs:", true);
        System.out.println("Sounds loaded in " + (System.currentTimeMillis() - l) + " ms");
    }

    private void loadSounds(uiog uiog2, String string, String string2, String string3, boolean bl) {
        boolean bl2;
        ArrayList<String> arrayList = new ArrayList();
        boolean bl3 = bl2 = !ENABLE_SOUND_CACHE;
        if (ENABLE_SOUND_CACHE) {
            try {
                arrayList = FileUtils.readLines(new File(string), "UTF-8");
                System.out.println("Found sound cache: " + string);
            }
            catch (IOException iOException) {
                bl2 = true;
            }
        }
        if (bl2) {
            System.out.println("Sound cache not found: " + string);
            arrayList = new ArrayList();
            this.checkFolder(arrayList, string2, string3);
            if (ENABLE_SOUND_CACHE) {
                try {
                    FileUtils.writeLines(new File(string), "UTF-8", arrayList, "\n");
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
        if (bl) {
            this.soundList.addAll(arrayList);
        }
        for (String string4 : arrayList) {
            uiog2._a(string4);
        }
    }

    private void checkFolder(List<String> list, String string, String string2) {
        String string3 = "/assets" + string;
        List<String> list2 = AssetsBrowser.allFilenames;
        for (String string4 : list2) {
            boolean bl;
            boolean bl2 = string4.startsWith(string3);
            boolean bl3 = bl = string4.endsWith(".wav") || string4.endsWith(".ogg");
            if (!bl2 || !bl) continue;
            String string5 = string4.substring(string3.length());
            list.add(string2 + string5);
        }
    }

    public void stopMusic() {
        jzqf jzqf2 = xpzm._E()._N;
        if (jzqf2 != null) {
            if (jzqf2._c.playing("streaming")) {
                jzqf2._c.stop("streaming");
            }
            if (jzqf2._c.playing("BgMusic")) {
                jzqf2._c.stop("BgMusic");
            }
            this.playing = "";
        }
    }

    public void playStreaming(String string, float f, float f2, float f3) {
        xavs xavs2;
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._M.field_74340_b != 0.0f && string != null && (xavs2 = this.musicPool._c(string)) != null) {
            this.playing = string;
            jzqf jzqf2 = xpzm2._N;
            jzqf2._f();
            SoundMod.starterThread.addTask(() -> {
                jzqf2._c.newStreamingSource(true, "streaming", xavs2._b(), xavs2._a(), false, f, f2, f3, 2, 64.0f);
                jzqf2._c.setVolume("streaming", 0.5f * xpzm2._M.field_74340_b);
                jzqf2._c.play("streaming");
            });
        }
    }

    public void playMusic(String string) {
        this.playMusic(string, "streaming");
    }

    public void playMusic(String string, String string2) {
        xavs xavs2;
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._M.field_74340_b != 0.0f && string != null && (xavs2 = this.musicPool._c(string)) != null) {
            this.playing = string;
            jzqf jzqf2 = xpzm2._N;
            jzqf2._f();
            SoundMod.starterThread.addTask(() -> {
                jzqf2._c.backgroundMusic(string2, xavs2._b(), xavs2._a(), false);
                jzqf2._c.setVolume(string2, 0.5f * xpzm2._M.field_74340_b);
                jzqf2._c.play(string2);
            });
        }
    }

    public boolean isStreaming() {
        jzqf jzqf2 = xpzm._E()._N;
        return jzqf2._c != null ? jzqf2._c.playing("streaming") : false;
    }

    public boolean isPlaying(String string) {
        return this.isStreaming() && string.equals(this.playing);
    }

    public void playSound(String string, float f, float f2, float f3) {
        xavs xavs2;
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._M.field_74340_b != 0.0f && string != null && (xavs2 = this.musicPool._c(string)) != null) {
            String string2 = "csound_" + this.soundID++;
            jzqf jzqf2 = xpzm2._N;
            SoundMod.starterThread.addTask(() -> {
                jzqf2._c.newSource(true, string2, xavs2._b(), xavs2._a(), false, f, f2, f3, 2, 64.0f);
                jzqf2._c.setVolume(string2, 0.5f * xpzm2._M.field_74340_b);
                jzqf2._c.play(string2);
            });
        }
    }
}


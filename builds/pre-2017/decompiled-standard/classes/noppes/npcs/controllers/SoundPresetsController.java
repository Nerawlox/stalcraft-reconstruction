/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import noppes.npcs.CustomNpcs;
import noppes.npcs.controllers.replica.ReplicaSystem;

public class SoundPresetsController {
    public static SoundPresetsController instance;
    private Map<Integer, SoundPreset> replicas = new LinkedHashMap<Integer, SoundPreset>();

    public SoundPresetsController() {
        instance = this;
        this.load();
    }

    public void load() {
        File file = new File(CustomNpcs.getWorldSaveDirectory(), "sound_presets.dat");
        if (!file.exists()) {
            return;
        }
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            qoac qoac2 = bsvf._a(fileInputStream);
            this.readFromNbt(qoac2);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void save() {
        if (FileWriteBlocker._a) {
            return;
        }
        File file = CustomNpcs.getWorldSaveDirectory();
        File file2 = new File(file, "sound_presets.dat_new");
        File file3 = new File(file, "sound_presets.dat");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file2);){
            bsvf._a(this.saveToNbt(new qoac()), fileOutputStream);
            file2.renameTo(file3);
            if (file2.exists()) {
                file2.delete();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public qoac saveToNbt(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (Map.Entry<Integer, SoundPreset> entry : this.replicas.entrySet()) {
            bsyv2._a(entry.getValue().writeToNbt(new qoac()));
        }
        qoac2._a("Replicas", bsyv2);
        return qoac2;
    }

    public void readFromNbt(qoac qoac2) {
        this.replicas.clear();
        ArrayList<SoundPreset> arrayList = new ArrayList<SoundPreset>();
        int n = 0;
        bsyv bsyv2 = qoac2._n("Replicas");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac object = (qoac)bsyv2._b(i);
            SoundPreset soundPreset = new SoundPreset();
            soundPreset.readFromNbt(object);
            arrayList.add(soundPreset);
            n = Math.max(n, soundPreset.id);
        }
        for (SoundPreset soundPreset : arrayList) {
            if (soundPreset.id != 0) continue;
            soundPreset.id = ++n;
        }
        for (SoundPreset soundPreset : arrayList) {
            this.replicas.put(soundPreset.id, soundPreset);
        }
    }

    public int addPreset(String string, ReplicaSystem replicaSystem) {
        int n = 1;
        while (this.replicas.containsKey(n)) {
            ++n;
        }
        this.replicas.put(n, new SoundPreset(n, string, replicaSystem));
        this.save();
        return n;
    }

    public void removePreset(int n) {
        this.replicas.remove(n);
        this.save();
    }

    public Map<Integer, SoundPreset> getReplicas() {
        return this.replicas;
    }

    public static class SoundPreset {
        public int id = -1;
        public String title;
        public ReplicaSystem replicas;

        public SoundPreset() {
            this.id = -1;
            this.title = "";
            this.replicas = new ReplicaSystem();
        }

        public SoundPreset(int n, String string, ReplicaSystem replicaSystem) {
            this.id = n;
            this.title = string;
            this.replicas = replicaSystem;
        }

        public qoac writeToNbt(qoac qoac2) {
            qoac2._a("Id", this.id);
            qoac2._a("Title", this.title);
            this.replicas.writeToNbt(qoac2);
            return qoac2;
        }

        public void readFromNbt(qoac qoac2) {
            this.id = qoac2._f("Id");
            this.title = qoac2._j("Title");
            this.replicas.readFromNbt(qoac2);
        }
    }
}


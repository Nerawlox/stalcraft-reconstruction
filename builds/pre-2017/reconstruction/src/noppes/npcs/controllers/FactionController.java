/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.CustomNpcs;
import noppes.npcs.controllers.Faction;

public class FactionController {
    private static FactionController instance;
    public HashMap<Integer, Faction> factions;
    private int lastUsedID = 0;
    private int mobFactionId;

    public FactionController() {
        instance = this;
        this.factions = new HashMap();
        this.loadFactions();
        if (this.factions.isEmpty()) {
            this.factions.put(0, new Faction(0, "Friendly", 65280, 2000));
            this.factions.put(1, new Faction(1, "Neutral", 0xF2FF00, 1000));
            this.factions.put(2, new Faction(2, "Aggressive", 0xFF0000, 0));
        }
    }

    public static FactionController getInstance() {
        return instance;
    }

    private void loadFactions() {
        File file = CustomNpcs.getWorldSaveDirectory();
        if (file != null) {
            try {
                File file2 = new File(file, "factions.dat");
                if (file2.exists()) {
                    this.loadFactionsFile(file2);
                }
            }
            catch (Exception exception) {
                try {
                    File file3 = new File(file, "factions.dat_old");
                    if (file3.exists()) {
                        this.loadFactionsFile(file3);
                    }
                }
                catch (Exception exception2) {
                    // empty catch block
                }
            }
        }
        this.mobFactionId = this.getOrCreateMobFaction().id;
    }

    private Faction getOrCreateMobFaction() {
        Faction faction = this.getByName("\u041c\u043e\u0431\u044b");
        if (faction == null) {
            faction = new Faction(this.getUnusedId(), "\u041c\u043e\u0431\u044b", 0xFFFFFF, 0);
            this.saveFaction(faction);
        }
        return faction;
    }

    private void loadFactionsFile(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(file))));
        this.loadFactions(dataInputStream);
        dataInputStream.close();
    }

    public void loadFactions(DataInputStream dataInputStream) throws IOException {
        HashMap<Integer, Faction> hashMap = new HashMap<Integer, Faction>();
        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
        this.lastUsedID = nBTTagCompound._f("lastID");
        NBTTagList nBTTagList = nBTTagCompound._n("NPCFactions");
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                Faction faction = new Faction();
                faction.readNBT(nBTTagCompound2);
                hashMap.put(faction.id, faction);
            }
        }
        this.factions = hashMap;
    }

    public NBTTagCompound getNBT() {
        NBTTagList nBTTagList = new NBTTagList();
        for (int n : this.factions.keySet()) {
            Faction faction = this.factions.get(n);
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            faction.writeNBT(nBTTagCompound);
            nBTTagList._a(nBTTagCompound);
        }
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("lastID", this.lastUsedID);
        nBTTagCompound._a("NPCFactions", nBTTagList);
        return nBTTagCompound;
    }

    public void saveFactions() {
        if (FileWriteBlocker._a) {
            return;
        }
        try {
            File file = CustomNpcs.getWorldSaveDirectory();
            File file2 = new File(file, "factions.dat_new");
            File file3 = new File(file, "factions.dat_old");
            File file4 = new File(file, "factions.dat");
            bsvf._a(this.getNBT(), new FileOutputStream(file2));
            if (file3.exists()) {
                file3.delete();
            }
            file4.renameTo(file3);
            if (file4.exists()) {
                file4.delete();
            }
            file2.renameTo(file4);
            if (file2.exists()) {
                file2.delete();
            }
        }
        catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public Faction getFaction(int n) {
        return this.factions.get(n);
    }

    public void saveFaction(Faction faction) {
        if (faction.id < 0) {
            faction.id = this.getUnusedId();
            while (this.hasName(faction.name)) {
                faction.name = faction.name + "_";
            }
        } else {
            Faction faction2 = this.factions.get(faction.id);
            if (faction2 != null && !faction2.name.equals(faction.name)) {
                while (this.hasName(faction.name)) {
                    faction.name = faction.name + "_";
                }
            }
        }
        this.factions.remove(faction.id);
        this.factions.put(faction.id, faction);
        this.saveFactions();
    }

    public int getUnusedId() {
        if (this.lastUsedID == 0) {
            for (int n : this.factions.keySet()) {
                if (n <= this.lastUsedID) continue;
                this.lastUsedID = n;
            }
        }
        ++this.lastUsedID;
        return this.lastUsedID;
    }

    public void removeFaction(int n) {
        if (n >= 0 && this.factions.size() > 1) {
            this.factions.remove(n);
            this.saveFactions();
        }
    }

    public int getFirstFactionId() {
        return this.factions.keySet().iterator().next();
    }

    public Faction getFirstFaction() {
        return this.factions.values().iterator().next();
    }

    public boolean hasName(String string) {
        Faction faction;
        if (string.trim().isEmpty()) {
            return true;
        }
        Iterator<Faction> iterator2 = this.factions.values().iterator();
        do {
            if (!iterator2.hasNext()) {
                return false;
            }
            faction = iterator2.next();
        } while (!faction.name.equals(string));
        return true;
    }

    public Faction getByName(String string) {
        for (Faction faction : this.factions.values()) {
            if (!string.equals(faction.name)) continue;
            return faction;
        }
        return null;
    }

    public Faction getMobFaction() {
        Faction faction = this.factions.get(this.mobFactionId);
        if (faction == null) {
            faction = this.getOrCreateMobFaction();
            this.mobFactionId = faction.id;
        }
        return faction;
    }
}


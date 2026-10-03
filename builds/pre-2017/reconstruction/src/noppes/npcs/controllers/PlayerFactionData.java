/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.IPlayerData;

public class PlayerFactionData
implements IPlayerData {
    private HashMap<Integer, Integer> factionData = new HashMap();

    public void readNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        if (nBTTagCompound != null && (nBTTagList = nBTTagCompound._n("FactionData")) != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                hashMap.put(nBTTagCompound2._f("Faction"), nBTTagCompound2._f("Points"));
            }
            this.factionData = hashMap;
        }
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (int n : this.factionData.keySet()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Faction", n);
            nBTTagCompound2._a("Points", (int)this.factionData.get(n));
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("FactionData", nBTTagList);
        return nBTTagCompound;
    }

    public HashMap<Integer, Integer> getFactionData() {
        return this.factionData;
    }

    public int getFactionPoints(int n) {
        if (!this.factionData.containsKey(n)) {
            Faction faction = FactionController.getInstance().getFaction(n);
            this.factionData.put(n, faction == null ? -1 : faction.defaultPoints);
        }
        return this.factionData.get(n);
    }

    public void increasePoints(int n, int n2) {
        if (!this.factionData.containsKey(n)) {
            Faction faction = FactionController.getInstance().getFaction(n);
            this.factionData.put(n, faction == null ? -1 : faction.defaultPoints);
        }
        this.factionData.put(n, this.factionData.get(n) + n2);
    }

    public void setPoints(int n, int n2) {
        if (!this.factionData.containsKey(n)) {
            Faction faction = FactionController.getInstance().getFaction(n);
            this.factionData.put(n, faction == null ? -1 : faction.defaultPoints);
        }
        this.factionData.put(n, n2);
    }

    public NBTTagCompound getPlayerGuiData() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeNBT(nBTTagCompound);
        NBTTagList nBTTagList = new NBTTagList();
        for (int n : this.factionData.keySet()) {
            Faction faction = FactionController.getInstance().getFaction(n);
            if (faction == null || faction.hideFaction) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            faction.writeNBT(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("FactionList", nBTTagList);
        return nBTTagCompound;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.IPlayerData;

public class PlayerFactionData
implements IPlayerData {
    private HashMap<Integer, Integer> factionData = new HashMap();

    public void readNBT(qoac qoac2) {
        bsyv bsyv2;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        if (qoac2 != null && (bsyv2 = qoac2._n("FactionData")) != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                hashMap.put(qoac3._f("Faction"), qoac3._f("Points"));
            }
            this.factionData = hashMap;
        }
    }

    @Override
    public qoac writeNBT(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (int n : this.factionData.keySet()) {
            qoac qoac3 = new qoac();
            qoac3._a("Faction", n);
            qoac3._a("Points", (int)this.factionData.get(n));
            bsyv2._a(qoac3);
        }
        qoac2._a("FactionData", bsyv2);
        return qoac2;
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

    public qoac getPlayerGuiData() {
        qoac qoac2 = new qoac();
        this.writeNBT(qoac2);
        bsyv bsyv2 = new bsyv();
        for (int n : this.factionData.keySet()) {
            Faction faction = FactionController.getInstance().getFaction(n);
            if (faction == null || faction.hideFaction) continue;
            qoac qoac3 = new qoac();
            faction.writeNBT(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("FactionList", bsyv2);
        return qoac2;
    }
}


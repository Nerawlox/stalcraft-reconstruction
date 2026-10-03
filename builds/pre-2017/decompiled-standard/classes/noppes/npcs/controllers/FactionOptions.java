/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.LinkedHashSet;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.zwat;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerFactionData;

public class FactionOptions {
    private Set<FactionModifier> modifierSet = new LinkedHashSet<FactionModifier>();

    public void readFromNBT(qoac qoac2) {
        this.modifierSet.clear();
        if (!qoac2._c("modifiers")) {
            this.readLegacyData(qoac2);
        } else {
            bsyv bsyv2 = qoac2._n("modifiers");
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                int n = qoac3._f("factionId");
                boolean bl = qoac3._o("increase");
                int n2 = qoac3._f("points");
                this.modifierSet.add(new FactionModifier(n, bl, n2));
            }
        }
    }

    public qoac writeToNBT(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (FactionModifier factionModifier : this.modifierSet) {
            qoac qoac3 = new qoac();
            qoac3._a("factionId", factionModifier.factionId);
            qoac3._a("increase", factionModifier.increasePoints);
            qoac3._a("points", factionModifier.points);
            bsyv2._a(qoac3);
        }
        qoac2._a("modifiers", bsyv2);
        return qoac2;
    }

    private void readLegacyData(qoac qoac2) {
        int n = qoac2._f("OptionFactions1");
        int n2 = qoac2._f("OptionFactions2");
        boolean bl = qoac2._o("DecreaseFaction1Points");
        boolean bl2 = qoac2._o("DecreaseFaction2Points");
        int n3 = qoac2._f("OptionFaction1Points");
        int n4 = qoac2._f("OptionFaction2Points");
        if (n >= 0 && n3 > 0) {
            this.modifierSet.add(new FactionModifier(n, !bl, n3));
        }
        if (n2 >= 0 && n4 > 0) {
            this.modifierSet.add(new FactionModifier(n2, !bl2, n4));
        }
    }

    public boolean hasFaction(int n) {
        for (FactionModifier factionModifier : this.modifierSet) {
            if (factionModifier.factionId != n) continue;
            return true;
        }
        return false;
    }

    public void addPoints(EntityPlayer entityPlayer) {
        PlayerData playerData = PlayerDataController.instance.getPlayerData(entityPlayer);
        PlayerFactionData playerFactionData = playerData.factionData;
        for (FactionModifier factionModifier : this.modifierSet) {
            if (factionModifier.factionId < 0 || factionModifier.points <= 0) continue;
            this.addPoints(entityPlayer, playerFactionData, factionModifier.factionId, !factionModifier.increasePoints, factionModifier.points);
            playerData.onFactionUpdate(factionModifier.factionId);
        }
        InvokeSideOnly.frontend(() -> {});
    }

    private void addPoints(EntityPlayer entityPlayer, PlayerFactionData playerFactionData, int n, boolean bl, int n2) {
        Faction faction = FactionController.getInstance().getFaction(n);
        if (faction != null) {
            if (!faction.hideFaction) {
                String string = bl ? "faction.decreasepoints" : "faction.increasepoints";
                entityPlayer.func_70006_a(zwat._b(string, faction.name, n2));
            }
            playerFactionData.increasePoints(n, bl ? -n2 : n2);
        }
    }

    public Set<FactionModifier> getModifierSet() {
        return this.modifierSet;
    }

    public static class FactionModifier {
        private int factionId;
        private boolean increasePoints;
        private int points;

        public FactionModifier(int n, boolean bl, int n2) {
            this.factionId = n;
            this.increasePoints = bl;
            this.points = n2;
        }

        public int getFactionId() {
            return this.factionId;
        }

        public void setFactionId(int n) {
            this.factionId = n;
        }

        public boolean isIncreasePoints() {
            return this.increasePoints;
        }

        public void setIncreasePoints(boolean bl) {
            this.increasePoints = bl;
        }

        public int getPoints() {
            return this.points;
        }

        public void setPoints(int n) {
            this.points = n;
        }
    }
}


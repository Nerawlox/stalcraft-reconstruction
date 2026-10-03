/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.LinkedHashSet;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatMessageComponent;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerFactionData;

public class FactionOptions {
    private Set<FactionModifier> modifierSet = new LinkedHashSet<FactionModifier>();

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.modifierSet.clear();
        if (!nBTTagCompound._c("modifiers")) {
            this.readLegacyData(nBTTagCompound);
        } else {
            NBTTagList nBTTagList = nBTTagCompound._n("modifiers");
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                int n = nBTTagCompound2._f("factionId");
                boolean bl = nBTTagCompound2._o("increase");
                int n2 = nBTTagCompound2._f("points");
                this.modifierSet.add(new FactionModifier(n, bl, n2));
            }
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (FactionModifier factionModifier : this.modifierSet) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("factionId", factionModifier.factionId);
            nBTTagCompound2._a("increase", factionModifier.increasePoints);
            nBTTagCompound2._a("points", factionModifier.points);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("modifiers", nBTTagList);
        return nBTTagCompound;
    }

    private void readLegacyData(NBTTagCompound nBTTagCompound) {
        int n = nBTTagCompound._f("OptionFactions1");
        int n2 = nBTTagCompound._f("OptionFactions2");
        boolean bl = nBTTagCompound._o("DecreaseFaction1Points");
        boolean bl2 = nBTTagCompound._o("DecreaseFaction2Points");
        int n3 = nBTTagCompound._f("OptionFaction1Points");
        int n4 = nBTTagCompound._f("OptionFaction2Points");
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
                entityPlayer.sendChatToPlayer(ChatMessageComponent._b(string, faction.name, n2));
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


/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.availability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.constants.EnumAvailabilityFaction;
import noppes.npcs.constants.EnumAvailabilityFactionType;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerFactionData;
import noppes.npcs.controllers.availability.AvailabilityRule;
import noppes.npcs.controllers.availability.EnumRule;

public class FactionRule
extends EnumRule<EnumAvailabilityFactionType> {
    protected EnumAvailabilityFaction stance;

    public FactionRule(EnumAvailabilityFaction enumAvailabilityFaction, EnumAvailabilityFactionType enumAvailabilityFactionType, int n) {
        super(AvailabilityRule.RuleType.FACTION);
        this.stance = enumAvailabilityFaction;
        this.setEnum(enumAvailabilityFactionType);
        this.setId(n);
    }

    public EnumAvailabilityFaction getStance() {
        return this.stance;
    }

    public FactionRule setStance(EnumAvailabilityFaction enumAvailabilityFaction) {
        this.stance = enumAvailabilityFaction;
        return this;
    }

    @Override
    public boolean available(EntityPlayer entityPlayer) {
        EnumAvailabilityFactionType enumAvailabilityFactionType = (EnumAvailabilityFactionType)((Object)this.getEnum());
        if (enumAvailabilityFactionType == EnumAvailabilityFactionType.Always) {
            return true;
        }
        Faction faction = FactionController.getInstance().getFaction(this.id);
        if (faction == null) {
            return true;
        }
        PlayerFactionData playerFactionData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).factionData;
        int n = playerFactionData.getFactionPoints(this.id);
        EnumAvailabilityFaction enumAvailabilityFaction = EnumAvailabilityFaction.Neutral;
        if (faction.neutralPoints >= n) {
            enumAvailabilityFaction = EnumAvailabilityFaction.Hostile;
        }
        if (faction.friendlyPoints < n) {
            enumAvailabilityFaction = EnumAvailabilityFaction.Friendly;
        }
        return enumAvailabilityFactionType == EnumAvailabilityFactionType.Is && this.stance == enumAvailabilityFaction || enumAvailabilityFactionType == EnumAvailabilityFactionType.IsNot && this.stance != enumAvailabilityFaction;
    }

    @Override
    public void save(NBTTagCompound nBTTagCompound) {
        super.save(nBTTagCompound);
        nBTTagCompound._a("stance", (byte)this.stance.ordinal());
    }

    @Override
    public void load(NBTTagCompound nBTTagCompound) {
        super.load(nBTTagCompound);
        this.stance = EnumAvailabilityFaction.values()[nBTTagCompound._d("stance")];
    }

    EnumAvailabilityFactionType[] getEnumValues() {
        return EnumAvailabilityFactionType.values();
    }
}


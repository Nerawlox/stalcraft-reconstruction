/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.tupg;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import noppes.npcs.ICompatibilty;
import noppes.npcs.VersionCompatibility;
import noppes.npcs.constants.EnumAvailabilityDialog;
import noppes.npcs.constants.EnumAvailabilityFaction;
import noppes.npcs.constants.EnumAvailabilityFactionType;
import noppes.npcs.constants.EnumAvailabilityQuest;
import noppes.npcs.constants.EnumDayTime;
import noppes.npcs.controllers.TimeRanges;
import noppes.npcs.controllers.availability.AvailabilityRule;
import noppes.npcs.controllers.availability.DialogRule;
import noppes.npcs.controllers.availability.FactionRule;
import noppes.npcs.controllers.availability.QuestRule;

public class Availability
implements ICompatibilty {
    public int version;
    private Set<AvailabilityRule> ruleSet = new LinkedHashSet<AvailabilityRule>();
    public EnumDayTime daytime;
    public int minPlayerLevel = 0;
    public Map<tupg, Boolean> playerFactions = new EnumMap<tupg, Boolean>(tupg.class);
    public List<String> clans = new ArrayList<String>();
    public String flag = "";
    public TimeRanges timeRanges = new TimeRanges();

    public Availability() {
        this.version = VersionCompatibility.ModRev;
        this.daytime = EnumDayTime.Always;
        for (tupg tupg2 : tupg.values()) {
            this.playerFactions.put(tupg2, true);
        }
    }

    public Set<AvailabilityRule> getRuleSet() {
        return this.ruleSet;
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        int n;
        Object object;
        this.version = nBTTagCompound._f("ModRev");
        VersionCompatibility.CheckAvailabilityCompatibility(this, nBTTagCompound);
        this.ruleSet.clear();
        if (!nBTTagCompound._c("rules")) {
            this.readLegacyData(nBTTagCompound);
        } else {
            object = nBTTagCompound._n("rules");
            for (n = 0; n < ((NBTTagList)object)._d(); ++n) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)((NBTTagList)object)._b(n);
                AvailabilityRule.RuleType enum_ = AvailabilityRule.RuleType.values()[nBTTagCompound2._d("type")];
                AvailabilityRule availabilityRule = enum_.createDefault();
                availabilityRule.load(nBTTagCompound2);
                this.ruleSet.add(availabilityRule);
            }
        }
        this.daytime = EnumDayTime.values()[nBTTagCompound._f("AvailabilityDayTime")];
        this.minPlayerLevel = nBTTagCompound._f("AvailabilityMinPlayerLevel");
        for (tupg tupg2 : tupg.values()) {
            if (!nBTTagCompound._c(tupg2.name())) continue;
            this.playerFactions.put(tupg2, nBTTagCompound._o(tupg2.name()));
        }
        this.clans.clear();
        object = nBTTagCompound._n("clans");
        for (n = 0; n < ((NBTTagList)object)._d(); ++n) {
            this.clans.add(((NBTTagString)((NBTTagList)object)._b((int)n))._c);
        }
        this.flag = nBTTagCompound._j("flag");
        if (nBTTagCompound._c("timeRangeS")) {
            n = nBTTagCompound._f("timeRangeS");
            int n2 = nBTTagCompound._f("timeRangeF");
            if (n != 0 || n2 != 0) {
                this.timeRanges.add(n, n2);
            }
        } else {
            this.timeRanges.readFromNBT(nBTTagCompound);
        }
    }

    private void readLegacyData(NBTTagCompound nBTTagCompound) {
        EnumAvailabilityDialog enumAvailabilityDialog = EnumAvailabilityDialog.values()[nBTTagCompound._f("AvailabilityDialog")];
        int n = nBTTagCompound._f("AvailabilityDialogId");
        this.ruleSet.add(new DialogRule(enumAvailabilityDialog, n));
        EnumAvailabilityQuest enumAvailabilityQuest = EnumAvailabilityQuest.values()[nBTTagCompound._f("AvailabilityQuest")];
        int n2 = nBTTagCompound._f("AvailabilityQuestId");
        this.ruleSet.add(new QuestRule(enumAvailabilityQuest, n2));
        EnumAvailabilityFactionType enumAvailabilityFactionType = EnumAvailabilityFactionType.values()[nBTTagCompound._f("AvailabilityFaction")];
        EnumAvailabilityFaction enumAvailabilityFaction = EnumAvailabilityFaction.values()[nBTTagCompound._f("AvailabilityFactionStance")];
        int n3 = nBTTagCompound._f("AvailabilityFactionId");
        this.ruleSet.add(new FactionRule(enumAvailabilityFaction, enumAvailabilityFactionType, n3));
        EnumAvailabilityDialog enumAvailabilityDialog2 = EnumAvailabilityDialog.values()[nBTTagCompound._f("AvailabilityDialog2")];
        int n4 = nBTTagCompound._f("AvailabilityDialog2Id");
        this.ruleSet.add(new DialogRule(enumAvailabilityDialog2, n4));
        EnumAvailabilityQuest enumAvailabilityQuest2 = EnumAvailabilityQuest.values()[nBTTagCompound._f("AvailabilityQuest2")];
        int n5 = nBTTagCompound._f("AvailabilityQuest2Id");
        this.ruleSet.add(new QuestRule(enumAvailabilityQuest2, n5));
        EnumAvailabilityFactionType enumAvailabilityFactionType2 = EnumAvailabilityFactionType.values()[nBTTagCompound._f("AvailabilityFaction2")];
        EnumAvailabilityFaction enumAvailabilityFaction2 = EnumAvailabilityFaction.values()[nBTTagCompound._f("AvailabilityFaction2Stance")];
        int n6 = nBTTagCompound._f("AvailabilityFaction2Id");
        this.ruleSet.add(new FactionRule(enumAvailabilityFaction2, enumAvailabilityFactionType2, n6));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("ModRev", this.version);
        NBTTagList nBTTagList = new NBTTagList();
        for (AvailabilityRule availabilityRule : this.ruleSet) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("type", (byte)availabilityRule.getType().ordinal());
            availabilityRule.save(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("rules", nBTTagList);
        nBTTagCompound._a("AvailabilityDayTime", this.daytime.ordinal());
        nBTTagCompound._a("AvailabilityMinPlayerLevel", this.minPlayerLevel);
        for (tupg tupg2 : tupg.values()) {
            nBTTagCompound._a(tupg2.name(), this.playerFactions.get((Object)tupg2));
        }
        NBTTagList nBTTagList2 = new NBTTagList();
        for (String string : this.clans) {
            nBTTagList2._a(new NBTTagString("", string));
        }
        nBTTagCompound._a("clans", nBTTagList2);
        nBTTagCompound._a("flag", this.flag);
        this.timeRanges.writeToNBT(nBTTagCompound);
        return nBTTagCompound;
    }

    public boolean isValidTime(World world) {
        return !this.timeRanges.shouldCheck() || this.timeRanges.matches(bqgh._c(world.getWorldTime()));
    }

    public boolean isAvailable(EntityPlayer entityPlayer) {
        return InvokeWithResult.frontend(() -> null);
    }

    @Override
    public int getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(int n) {
        this.version = n;
    }

    public Availability copy() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        Availability availability = new Availability();
        availability.readFromNBT(nBTTagCompound);
        return availability;
    }
}


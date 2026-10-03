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

    public void readFromNBT(qoac qoac2) {
        int n;
        Object object;
        this.version = qoac2._f("ModRev");
        VersionCompatibility.CheckAvailabilityCompatibility(this, qoac2);
        this.ruleSet.clear();
        if (!qoac2._c("rules")) {
            this.readLegacyData(qoac2);
        } else {
            object = qoac2._n("rules");
            for (n = 0; n < ((bsyv)object)._d(); ++n) {
                qoac qoac3 = (qoac)((bsyv)object)._b(n);
                AvailabilityRule.RuleType enum_ = AvailabilityRule.RuleType.values()[qoac3._d("type")];
                AvailabilityRule availabilityRule = enum_.createDefault();
                availabilityRule.load(qoac3);
                this.ruleSet.add(availabilityRule);
            }
        }
        this.daytime = EnumDayTime.values()[qoac2._f("AvailabilityDayTime")];
        this.minPlayerLevel = qoac2._f("AvailabilityMinPlayerLevel");
        for (tupg tupg2 : tupg.values()) {
            if (!qoac2._c(tupg2.name())) continue;
            this.playerFactions.put(tupg2, qoac2._o(tupg2.name()));
        }
        this.clans.clear();
        object = qoac2._n("clans");
        for (n = 0; n < ((bsyv)object)._d(); ++n) {
            this.clans.add(((xsxy)((bsyv)object)._b((int)n))._c);
        }
        this.flag = qoac2._j("flag");
        if (qoac2._c("timeRangeS")) {
            n = qoac2._f("timeRangeS");
            int n2 = qoac2._f("timeRangeF");
            if (n != 0 || n2 != 0) {
                this.timeRanges.add(n, n2);
            }
        } else {
            this.timeRanges.readFromNBT(qoac2);
        }
    }

    private void readLegacyData(qoac qoac2) {
        EnumAvailabilityDialog enumAvailabilityDialog = EnumAvailabilityDialog.values()[qoac2._f("AvailabilityDialog")];
        int n = qoac2._f("AvailabilityDialogId");
        this.ruleSet.add(new DialogRule(enumAvailabilityDialog, n));
        EnumAvailabilityQuest enumAvailabilityQuest = EnumAvailabilityQuest.values()[qoac2._f("AvailabilityQuest")];
        int n2 = qoac2._f("AvailabilityQuestId");
        this.ruleSet.add(new QuestRule(enumAvailabilityQuest, n2));
        EnumAvailabilityFactionType enumAvailabilityFactionType = EnumAvailabilityFactionType.values()[qoac2._f("AvailabilityFaction")];
        EnumAvailabilityFaction enumAvailabilityFaction = EnumAvailabilityFaction.values()[qoac2._f("AvailabilityFactionStance")];
        int n3 = qoac2._f("AvailabilityFactionId");
        this.ruleSet.add(new FactionRule(enumAvailabilityFaction, enumAvailabilityFactionType, n3));
        EnumAvailabilityDialog enumAvailabilityDialog2 = EnumAvailabilityDialog.values()[qoac2._f("AvailabilityDialog2")];
        int n4 = qoac2._f("AvailabilityDialog2Id");
        this.ruleSet.add(new DialogRule(enumAvailabilityDialog2, n4));
        EnumAvailabilityQuest enumAvailabilityQuest2 = EnumAvailabilityQuest.values()[qoac2._f("AvailabilityQuest2")];
        int n5 = qoac2._f("AvailabilityQuest2Id");
        this.ruleSet.add(new QuestRule(enumAvailabilityQuest2, n5));
        EnumAvailabilityFactionType enumAvailabilityFactionType2 = EnumAvailabilityFactionType.values()[qoac2._f("AvailabilityFaction2")];
        EnumAvailabilityFaction enumAvailabilityFaction2 = EnumAvailabilityFaction.values()[qoac2._f("AvailabilityFaction2Stance")];
        int n6 = qoac2._f("AvailabilityFaction2Id");
        this.ruleSet.add(new FactionRule(enumAvailabilityFaction2, enumAvailabilityFactionType2, n6));
    }

    @Override
    public qoac writeToNBT(qoac qoac2) {
        qoac2._a("ModRev", this.version);
        bsyv bsyv2 = new bsyv();
        for (AvailabilityRule availabilityRule : this.ruleSet) {
            qoac qoac3 = new qoac();
            qoac3._a("type", (byte)availabilityRule.getType().ordinal());
            availabilityRule.save(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("rules", bsyv2);
        qoac2._a("AvailabilityDayTime", this.daytime.ordinal());
        qoac2._a("AvailabilityMinPlayerLevel", this.minPlayerLevel);
        for (tupg tupg2 : tupg.values()) {
            qoac2._a(tupg2.name(), this.playerFactions.get((Object)tupg2));
        }
        bsyv bsyv3 = new bsyv();
        for (String string : this.clans) {
            bsyv3._a(new xsxy("", string));
        }
        qoac2._a("clans", bsyv3);
        qoac2._a("flag", this.flag);
        this.timeRanges.writeToNBT(qoac2);
        return qoac2;
    }

    public boolean isValidTime(ozlu ozlu2) {
        return !this.timeRanges.shouldCheck() || this.timeRanges.matches(bqgh._c(ozlu2.func_72820_D()));
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
        qoac qoac2 = new qoac();
        this.writeToNBT(qoac2);
        Availability availability = new Availability();
        availability.readFromNBT(qoac2);
        return availability;
    }
}


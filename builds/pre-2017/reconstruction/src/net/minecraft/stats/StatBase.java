/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.stats;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.stats.AchievementMap;
import net.minecraft.stats.IStatType;
import net.minecraft.util.tdpx;

public class StatBase {
    public final int statId;
    public final String statName;
    public boolean isIndependent;
    public String statGuid;
    public final IStatType type;
    public static NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.US);
    public static IStatType simpleStatType = new fols();
    public static DecimalFormat decimalFormat = new DecimalFormat("########0.00");
    public static IStatType timeStatType = new hurx();
    public static IStatType distanceStatType = new btcd();
    public static IStatType field_111202_k = new nfcw();

    public StatBase(int n, String string, IStatType iStatType) {
        this.statId = n;
        this.statName = string;
        this.type = iStatType;
    }

    public StatBase(int n, String string) {
        this(n, string, simpleStatType);
    }

    public StatBase initIndependentStat() {
        this.isIndependent = true;
        return this;
    }

    public StatBase registerStat() {
        if (dzif._a.containsKey(this.statId)) {
            throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)dzif._a.get((Object)Integer.valueOf((int)this.statId))).statName + "\" and \"" + this.statName + "\" at id " + this.statId);
        }
        dzif._b.add(this);
        dzif._a.put(this.statId, this);
        this.statGuid = AchievementMap._a(this.statId);
        return this;
    }

    public boolean isAchievement() {
        return false;
    }

    public String func_75968_a(int n) {
        return this.type._a(n);
    }

    public String getName() {
        return this.statName;
    }

    public String toString() {
        return tdpx._a(this.statName);
    }

    public static /* synthetic */ NumberFormat getNumberFormat() {
        return numberFormat;
    }

    public static /* synthetic */ DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }
}


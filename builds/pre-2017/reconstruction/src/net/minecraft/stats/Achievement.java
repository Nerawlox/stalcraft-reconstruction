/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.stats;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.IStatStringFormat;
import net.minecraft.stats.StatBase;
import net.minecraft.util.tdpx;

public class Achievement
extends StatBase {
    public final int displayColumn;
    public final int displayRow;
    public final Achievement parentAchievement;
    public final String achievementDescription;
    public IStatStringFormat statStringFormatter;
    public final ItemStack theItemStack;
    public boolean isSpecial;

    public Achievement(int n, String string, int n2, int n3, Item item, Achievement achievement) {
        this(n, string, n2, n3, new ItemStack(item), achievement);
    }

    public Achievement(int n, String string, int n2, int n3, Block block, Achievement achievement) {
        this(n, string, n2, n3, new ItemStack(block), achievement);
    }

    public Achievement(int n, String string, int n2, int n3, ItemStack itemStack, Achievement achievement) {
        super(0x500000 + n, "achievement." + string);
        this.theItemStack = itemStack;
        this.achievementDescription = "achievement." + string + ".desc";
        this.displayColumn = n2;
        this.displayRow = n3;
        if (n2 < AchievementList._a) {
            AchievementList._a = n2;
        }
        if (n3 < AchievementList._b) {
            AchievementList._b = n3;
        }
        if (n2 > AchievementList._c) {
            AchievementList._c = n2;
        }
        if (n3 > AchievementList._d) {
            AchievementList._d = n3;
        }
        this.parentAchievement = achievement;
    }

    public Achievement setIndependent() {
        this.isIndependent = true;
        return this;
    }

    public Achievement setSpecial() {
        this.isSpecial = true;
        return this;
    }

    public Achievement registerAchievement() {
        super.registerStat();
        AchievementList._e.add(this);
        return this;
    }

    @Override
    public boolean isAchievement() {
        return true;
    }

    public String getDescription() {
        if (this.statStringFormatter != null) {
            return this.statStringFormatter._a(tdpx._a(this.achievementDescription));
        }
        return tdpx._a(this.achievementDescription);
    }

    public Achievement setStatStringFormatter(IStatStringFormat iStatStringFormat) {
        this.statStringFormatter = iStatStringFormat;
        return this;
    }

    public boolean getSpecial() {
        return this.isSpecial;
    }

    @Override
    public /* synthetic */ StatBase registerStat() {
        return this.registerAchievement();
    }

    @Override
    public /* synthetic */ StatBase initIndependentStat() {
        return this.setIndependent();
    }
}


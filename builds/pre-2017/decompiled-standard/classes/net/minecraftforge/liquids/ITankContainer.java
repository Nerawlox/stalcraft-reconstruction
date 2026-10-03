/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidStack;

@Deprecated
public interface ITankContainer {
    public int fill(ForgeDirection var1, LiquidStack var2, boolean var3);

    public int fill(int var1, LiquidStack var2, boolean var3);

    public LiquidStack drain(ForgeDirection var1, int var2, boolean var3);

    public LiquidStack drain(int var1, int var2, boolean var3);

    public ILiquidTank[] getTanks(ForgeDirection var1);

    public ILiquidTank getTank(ForgeDirection var1, LiquidStack var2);
}


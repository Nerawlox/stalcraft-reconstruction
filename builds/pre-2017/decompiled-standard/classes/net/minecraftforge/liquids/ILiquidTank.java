/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import net.minecraftforge.liquids.LiquidStack;

@Deprecated
public interface ILiquidTank {
    public LiquidStack getLiquid();

    public int getCapacity();

    public int fill(LiquidStack var1, boolean var2);

    public LiquidStack drain(int var1, boolean var2);

    public int getTankPressure();
}


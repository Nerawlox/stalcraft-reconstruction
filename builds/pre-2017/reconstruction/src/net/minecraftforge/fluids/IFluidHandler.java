/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

public interface IFluidHandler {
    public int fill(ForgeDirection var1, FluidStack var2, boolean var3);

    public FluidStack drain(ForgeDirection var1, FluidStack var2, boolean var3);

    public FluidStack drain(ForgeDirection var1, int var2, boolean var3);

    public boolean canFill(ForgeDirection var1, Fluid var2);

    public boolean canDrain(ForgeDirection var1, Fluid var2);

    public FluidTankInfo[] getTankInfo(ForgeDirection var1);
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

public interface IFluidTank {
    public FluidStack getFluid();

    public int getFluidAmount();

    public int getCapacity();

    public FluidTankInfo getInfo();

    public int fill(FluidStack var1, boolean var2);

    public FluidStack drain(int var1, boolean var2);
}


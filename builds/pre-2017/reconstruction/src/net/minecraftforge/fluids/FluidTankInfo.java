/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;

public final class FluidTankInfo {
    public final FluidStack fluid;
    public final int capacity;

    public FluidTankInfo(FluidStack fluidStack, int n) {
        this.fluid = fluidStack;
        this.capacity = n;
    }

    public FluidTankInfo(IFluidTank iFluidTank) {
        this.fluid = iFluidTank.getFluid();
        this.capacity = iFluidTank.getCapacity();
    }
}


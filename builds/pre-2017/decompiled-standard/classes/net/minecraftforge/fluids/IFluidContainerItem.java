/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraftforge.fluids.FluidStack;

public interface IFluidContainerItem {
    public FluidStack getFluid(cvzo var1);

    public int getCapacity(cvzo var1);

    public int fill(cvzo var1, FluidStack var2, boolean var3);

    public FluidStack drain(cvzo var1, int var2, boolean var3);
}


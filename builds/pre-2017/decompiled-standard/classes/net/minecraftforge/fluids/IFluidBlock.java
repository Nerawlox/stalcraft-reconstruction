/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public interface IFluidBlock {
    public Fluid getFluid();

    public FluidStack drain(ozlu var1, int var2, int var3, int var4, boolean var5);

    public boolean canDrain(ozlu var1, int var2, int var3, int var4);

    public float getFilledPercentage(ozlu var1, int var2, int var3, int var4);
}


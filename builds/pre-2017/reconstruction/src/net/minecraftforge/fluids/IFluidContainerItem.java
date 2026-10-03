/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public interface IFluidContainerItem {
    public FluidStack getFluid(ItemStack var1);

    public int getCapacity(ItemStack var1);

    public int fill(ItemStack var1, FluidStack var2, boolean var3);

    public FluidStack drain(ItemStack var1, int var2, boolean var3);
}


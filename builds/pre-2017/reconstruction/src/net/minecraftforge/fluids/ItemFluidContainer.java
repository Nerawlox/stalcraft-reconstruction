/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

public class ItemFluidContainer
extends Item
implements IFluidContainerItem {
    protected int capacity;

    public ItemFluidContainer(int n) {
        super(n);
    }

    public ItemFluidContainer(int n, int n2) {
        super(n);
        this.capacity = n2;
    }

    public ItemFluidContainer setCapacity(int n) {
        this.capacity = n;
        return this;
    }

    @Override
    public FluidStack getFluid(ItemStack itemStack) {
        if (itemStack._e == null || !itemStack._e._c("Fluid")) {
            return null;
        }
        return FluidStack.loadFluidStackFromNBT(itemStack._e._m("Fluid"));
    }

    @Override
    public int getCapacity(ItemStack itemStack) {
        return this.capacity;
    }

    @Override
    public int fill(ItemStack itemStack, FluidStack fluidStack, boolean bl) {
        if (fluidStack == null) {
            return 0;
        }
        if (!bl) {
            if (itemStack._e == null || !itemStack._e._c("Fluid")) {
                return Math.min(this.capacity, fluidStack.amount);
            }
            FluidStack fluidStack2 = FluidStack.loadFluidStackFromNBT(itemStack._e._m("Fluid"));
            if (fluidStack2 == null) {
                return Math.min(this.capacity, fluidStack.amount);
            }
            if (!fluidStack2.isFluidEqual(fluidStack)) {
                return 0;
            }
            return Math.min(this.capacity - fluidStack2.amount, fluidStack.amount);
        }
        if (itemStack._e == null) {
            itemStack._e = new NBTTagCompound();
        }
        if (!itemStack._e._c("Fluid")) {
            NBTTagCompound nBTTagCompound = fluidStack.writeToNBT(new NBTTagCompound());
            if (this.capacity < fluidStack.amount) {
                nBTTagCompound._a("Amount", this.capacity);
                itemStack._e._a("Fluid", (NBTBase)nBTTagCompound);
                return this.capacity;
            }
            itemStack._e._a("Fluid", (NBTBase)nBTTagCompound);
            return fluidStack.amount;
        }
        NBTTagCompound nBTTagCompound = itemStack._e._m("Fluid");
        FluidStack fluidStack3 = FluidStack.loadFluidStackFromNBT(nBTTagCompound);
        if (!fluidStack3.isFluidEqual(fluidStack)) {
            return 0;
        }
        int n = this.capacity - fluidStack3.amount;
        if (fluidStack.amount < n) {
            fluidStack3.amount += fluidStack.amount;
            n = fluidStack.amount;
        } else {
            fluidStack3.amount = this.capacity;
        }
        itemStack._e._a("Fluid", (NBTBase)fluidStack3.writeToNBT(nBTTagCompound));
        return n;
    }

    @Override
    public FluidStack drain(ItemStack itemStack, int n, boolean bl) {
        if (itemStack._e == null || !itemStack._e._c("Fluid") || n == 0) {
            return null;
        }
        FluidStack fluidStack = FluidStack.loadFluidStackFromNBT(itemStack._e._m("Fluid"));
        if (fluidStack == null) {
            return null;
        }
        int n2 = Math.min(fluidStack.amount, n);
        if (bl) {
            if (n >= fluidStack.amount) {
                itemStack._e._p("Fluid");
                if (itemStack._e._e()) {
                    itemStack._e = null;
                }
                return fluidStack;
            }
            NBTTagCompound nBTTagCompound = itemStack._e._m("Fluid");
            nBTTagCompound._a("Amount", nBTTagCompound._f("Amount") - n);
            itemStack._e._a("Fluid", (NBTBase)nBTTagCompound);
        }
        fluidStack.amount = n2;
        return fluidStack;
    }
}


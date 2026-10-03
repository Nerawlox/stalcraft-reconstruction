/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import java.util.Locale;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidContainerItem;

public class FluidStack {
    public int fluidID;
    public int amount;
    public NBTTagCompound tag;

    public FluidStack(Fluid fluid, int n) {
        this.fluidID = fluid.getID();
        this.amount = n;
    }

    public FluidStack(int n, int n2) {
        this.fluidID = n;
        this.amount = n2;
    }

    public FluidStack(int n, int n2, NBTTagCompound nBTTagCompound) {
        this(n, n2);
        if (nBTTagCompound != null) {
            this.tag = (NBTTagCompound)nBTTagCompound._c();
        }
    }

    public FluidStack(FluidStack fluidStack, int n) {
        this(fluidStack.fluidID, n, fluidStack.tag);
    }

    public static FluidStack loadFluidStackFromNBT(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound == null) {
            return null;
        }
        String string = nBTTagCompound._j("FluidName");
        if (string == null) {
            string = nBTTagCompound._c("LiquidName") ? nBTTagCompound._j("LiquidName").toLowerCase(Locale.ENGLISH) : null;
            string = Fluid.convertLegacyName(string);
        }
        if (string == null || FluidRegistry.getFluid(string) == null) {
            return null;
        }
        FluidStack fluidStack = new FluidStack(FluidRegistry.getFluidID(string), nBTTagCompound._f("Amount"));
        if (nBTTagCompound._c("Tag")) {
            fluidStack.tag = nBTTagCompound._m("Tag");
        } else if (nBTTagCompound._c("extra")) {
            fluidStack.tag = nBTTagCompound._m("extra");
        }
        return fluidStack;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("FluidName", FluidRegistry.getFluidName(this.fluidID));
        nBTTagCompound._a("Amount", this.amount);
        if (this.tag != null) {
            nBTTagCompound._a("Tag", (NBTBase)this.tag);
        }
        return nBTTagCompound;
    }

    public final Fluid getFluid() {
        return FluidRegistry.getFluid(this.fluidID);
    }

    public FluidStack copy() {
        return new FluidStack(this.fluidID, this.amount, this.tag);
    }

    public boolean isFluidEqual(FluidStack fluidStack) {
        return fluidStack != null && this.fluidID == fluidStack.fluidID && this.isFluidStackTagEqual(fluidStack);
    }

    private boolean isFluidStackTagEqual(FluidStack fluidStack) {
        return this.tag == null ? fluidStack.tag == null : (fluidStack.tag == null ? false : this.tag.equals(fluidStack.tag));
    }

    public static boolean areFluidStackTagsEqual(FluidStack fluidStack, FluidStack fluidStack2) {
        return fluidStack == null && fluidStack2 == null ? true : (fluidStack == null || fluidStack2 == null ? false : fluidStack.isFluidStackTagEqual(fluidStack2));
    }

    public boolean containsFluid(FluidStack fluidStack) {
        return this.isFluidEqual(fluidStack) && this.amount >= fluidStack.amount;
    }

    public boolean isFluidStackIdentical(FluidStack fluidStack) {
        return this.isFluidEqual(fluidStack) && this.amount == fluidStack.amount;
    }

    public boolean isFluidEqual(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack._a() instanceof IFluidContainerItem) {
            return this.isFluidEqual(((IFluidContainerItem)((Object)itemStack._a())).getFluid(itemStack));
        }
        return this.isFluidEqual(FluidContainerRegistry.getFluidForFilledItem(itemStack));
    }

    public final int hashCode() {
        return this.fluidID;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof FluidStack)) {
            return false;
        }
        return this.isFluidEqual((FluidStack)object);
    }
}


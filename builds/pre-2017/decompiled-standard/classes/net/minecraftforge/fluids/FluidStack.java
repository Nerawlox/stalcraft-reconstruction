/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import java.util.Locale;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidContainerItem;

public class FluidStack {
    public int fluidID;
    public int amount;
    public qoac tag;

    public FluidStack(Fluid fluid, int n) {
        this.fluidID = fluid.getID();
        this.amount = n;
    }

    public FluidStack(int n, int n2) {
        this.fluidID = n;
        this.amount = n2;
    }

    public FluidStack(int n, int n2, qoac qoac2) {
        this(n, n2);
        if (qoac2 != null) {
            this.tag = (qoac)qoac2._c();
        }
    }

    public FluidStack(FluidStack fluidStack, int n) {
        this(fluidStack.fluidID, n, fluidStack.tag);
    }

    public static FluidStack loadFluidStackFromNBT(qoac qoac2) {
        if (qoac2 == null) {
            return null;
        }
        String string = qoac2._j("FluidName");
        if (string == null) {
            string = qoac2._c("LiquidName") ? qoac2._j("LiquidName").toLowerCase(Locale.ENGLISH) : null;
            string = Fluid.convertLegacyName(string);
        }
        if (string == null || FluidRegistry.getFluid(string) == null) {
            return null;
        }
        FluidStack fluidStack = new FluidStack(FluidRegistry.getFluidID(string), qoac2._f("Amount"));
        if (qoac2._c("Tag")) {
            fluidStack.tag = qoac2._m("Tag");
        } else if (qoac2._c("extra")) {
            fluidStack.tag = qoac2._m("extra");
        }
        return fluidStack;
    }

    public qoac writeToNBT(qoac qoac2) {
        qoac2._a("FluidName", FluidRegistry.getFluidName(this.fluidID));
        qoac2._a("Amount", this.amount);
        if (this.tag != null) {
            qoac2._a("Tag", (huhy)this.tag);
        }
        return qoac2;
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

    public boolean isFluidEqual(cvzo cvzo2) {
        if (cvzo2 == null) {
            return false;
        }
        if (cvzo2._a() instanceof IFluidContainerItem) {
            return this.isFluidEqual(((IFluidContainerItem)((Object)cvzo2._a())).getFluid(cvzo2));
        }
        return this.isFluidEqual(FluidContainerRegistry.getFluidForFilledItem(cvzo2));
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


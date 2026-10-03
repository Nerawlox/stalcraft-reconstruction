/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

public class ItemFluidContainer
extends tgdv
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
    public FluidStack getFluid(cvzo cvzo2) {
        if (cvzo2._e == null || !cvzo2._e._c("Fluid")) {
            return null;
        }
        return FluidStack.loadFluidStackFromNBT(cvzo2._e._m("Fluid"));
    }

    @Override
    public int getCapacity(cvzo cvzo2) {
        return this.capacity;
    }

    @Override
    public int fill(cvzo cvzo2, FluidStack fluidStack, boolean bl) {
        if (fluidStack == null) {
            return 0;
        }
        if (!bl) {
            if (cvzo2._e == null || !cvzo2._e._c("Fluid")) {
                return Math.min(this.capacity, fluidStack.amount);
            }
            FluidStack fluidStack2 = FluidStack.loadFluidStackFromNBT(cvzo2._e._m("Fluid"));
            if (fluidStack2 == null) {
                return Math.min(this.capacity, fluidStack.amount);
            }
            if (!fluidStack2.isFluidEqual(fluidStack)) {
                return 0;
            }
            return Math.min(this.capacity - fluidStack2.amount, fluidStack.amount);
        }
        if (cvzo2._e == null) {
            cvzo2._e = new qoac();
        }
        if (!cvzo2._e._c("Fluid")) {
            qoac qoac2 = fluidStack.writeToNBT(new qoac());
            if (this.capacity < fluidStack.amount) {
                qoac2._a("Amount", this.capacity);
                cvzo2._e._a("Fluid", (huhy)qoac2);
                return this.capacity;
            }
            cvzo2._e._a("Fluid", (huhy)qoac2);
            return fluidStack.amount;
        }
        qoac qoac3 = cvzo2._e._m("Fluid");
        FluidStack fluidStack3 = FluidStack.loadFluidStackFromNBT(qoac3);
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
        cvzo2._e._a("Fluid", (huhy)fluidStack3.writeToNBT(qoac3));
        return n;
    }

    @Override
    public FluidStack drain(cvzo cvzo2, int n, boolean bl) {
        if (cvzo2._e == null || !cvzo2._e._c("Fluid") || n == 0) {
            return null;
        }
        FluidStack fluidStack = FluidStack.loadFluidStackFromNBT(cvzo2._e._m("Fluid"));
        if (fluidStack == null) {
            return null;
        }
        int n2 = Math.min(fluidStack.amount, n);
        if (bl) {
            if (n >= fluidStack.amount) {
                cvzo2._e._p("Fluid");
                if (cvzo2._e._e()) {
                    cvzo2._e = null;
                }
                return fluidStack;
            }
            qoac qoac2 = cvzo2._e._m("Fluid");
            qoac2._a("Amount", qoac2._f("Amount") - n);
            cvzo2._e._a("Fluid", (huhy)qoac2);
        }
        fluidStack.amount = n2;
        return fluidStack;
    }
}


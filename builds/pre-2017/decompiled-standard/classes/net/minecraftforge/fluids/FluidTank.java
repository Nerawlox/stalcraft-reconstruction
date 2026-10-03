/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class FluidTank
implements IFluidTank {
    protected FluidStack fluid;
    protected int capacity;
    protected hurg tile;

    public FluidTank(int n) {
        this(null, n);
    }

    public FluidTank(FluidStack fluidStack, int n) {
        this.fluid = fluidStack;
        this.capacity = n;
    }

    public FluidTank(Fluid fluid, int n, int n2) {
        this(new FluidStack(fluid, n), n2);
    }

    public FluidTank readFromNBT(qoac qoac2) {
        FluidStack fluidStack;
        if (!qoac2._c("Empty") && (fluidStack = FluidStack.loadFluidStackFromNBT(qoac2)) != null) {
            this.setFluid(fluidStack);
        }
        return this;
    }

    public qoac writeToNBT(qoac qoac2) {
        if (this.fluid != null) {
            this.fluid.writeToNBT(qoac2);
        } else {
            qoac2._a("Empty", "");
        }
        return qoac2;
    }

    public void setFluid(FluidStack fluidStack) {
        this.fluid = fluidStack;
    }

    public void setCapacity(int n) {
        this.capacity = n;
    }

    @Override
    public FluidStack getFluid() {
        return this.fluid;
    }

    @Override
    public int getFluidAmount() {
        if (this.fluid == null) {
            return 0;
        }
        return this.fluid.amount;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public FluidTankInfo getInfo() {
        return new FluidTankInfo(this);
    }

    @Override
    public int fill(FluidStack fluidStack, boolean bl) {
        if (fluidStack == null) {
            return 0;
        }
        if (!bl) {
            if (this.fluid == null) {
                return Math.min(this.capacity, fluidStack.amount);
            }
            if (!this.fluid.isFluidEqual(fluidStack)) {
                return 0;
            }
            return Math.min(this.capacity - this.fluid.amount, fluidStack.amount);
        }
        if (this.fluid == null) {
            this.fluid = new FluidStack(fluidStack, Math.min(this.capacity, fluidStack.amount));
            if (this.tile != null) {
                FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(this.fluid, this.tile.field_70331_k, this.tile.field_70329_l, this.tile.field_70330_m, this.tile.field_70327_n, this));
            }
            return this.fluid.amount;
        }
        if (!this.fluid.isFluidEqual(fluidStack)) {
            return 0;
        }
        int n = this.capacity - this.fluid.amount;
        if (fluidStack.amount < n) {
            this.fluid.amount += fluidStack.amount;
            n = fluidStack.amount;
        } else {
            this.fluid.amount = this.capacity;
        }
        if (this.tile != null) {
            FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(this.fluid, this.tile.field_70331_k, this.tile.field_70329_l, this.tile.field_70330_m, this.tile.field_70327_n, this));
        }
        return n;
    }

    @Override
    public FluidStack drain(int n, boolean bl) {
        if (this.fluid == null) {
            return null;
        }
        int n2 = n;
        if (this.fluid.amount < n2) {
            n2 = this.fluid.amount;
        }
        FluidStack fluidStack = new FluidStack(this.fluid, n2);
        if (bl) {
            this.fluid.amount -= n2;
            if (this.fluid.amount <= 0) {
                this.fluid = null;
            }
            if (this.tile != null) {
                FluidEvent.fireEvent(new FluidEvent.FluidDrainingEvent(this.fluid, this.tile.field_70331_k, this.tile.field_70329_l, this.tile.field_70330_m, this.tile.field_70327_n, this));
            }
        }
        return fluidStack;
    }
}


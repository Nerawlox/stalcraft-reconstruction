/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class FluidTank
implements IFluidTank {
    protected FluidStack fluid;
    protected int capacity;
    protected TileEntity tile;

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

    public FluidTank readFromNBT(NBTTagCompound nBTTagCompound) {
        FluidStack fluidStack;
        if (!nBTTagCompound._c("Empty") && (fluidStack = FluidStack.loadFluidStackFromNBT(nBTTagCompound)) != null) {
            this.setFluid(fluidStack);
        }
        return this;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        if (this.fluid != null) {
            this.fluid.writeToNBT(nBTTagCompound);
        } else {
            nBTTagCompound._a("Empty", "");
        }
        return nBTTagCompound;
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
                FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(this.fluid, this.tile.worldObj, this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this));
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
            FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(this.fluid, this.tile.worldObj, this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this));
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
                FluidEvent.fireEvent(new FluidEvent.FluidDrainingEvent(this.fluid, this.tile.worldObj, this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this));
            }
        }
        return fluidStack;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileFluidHandler
extends hurg
implements IFluidHandler {
    protected FluidTank tank = new FluidTank(1000);

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this.tank.writeToNBT(qoac2);
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        this.tank.readFromNBT(qoac2);
    }

    @Override
    public int fill(ForgeDirection forgeDirection, FluidStack fluidStack, boolean bl) {
        return this.tank.fill(fluidStack, bl);
    }

    @Override
    public FluidStack drain(ForgeDirection forgeDirection, FluidStack fluidStack, boolean bl) {
        if (fluidStack == null || !fluidStack.isFluidEqual(this.tank.getFluid())) {
            return null;
        }
        return this.tank.drain(fluidStack.amount, bl);
    }

    @Override
    public FluidStack drain(ForgeDirection forgeDirection, int n, boolean bl) {
        return this.tank.drain(n, bl);
    }

    @Override
    public boolean canFill(ForgeDirection forgeDirection, Fluid fluid) {
        return true;
    }

    @Override
    public boolean canDrain(ForgeDirection forgeDirection, Fluid fluid) {
        return true;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection forgeDirection) {
        return new FluidTankInfo[]{this.tank.getInfo()};
    }
}


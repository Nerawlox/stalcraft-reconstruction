/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidEvent;
import net.minecraftforge.liquids.LiquidStack;

@Deprecated
public class LiquidTank
implements ILiquidTank {
    private LiquidStack liquid;
    private int capacity;
    private int tankPressure;
    private TileEntity tile;

    public LiquidTank(int n) {
        this(null, n);
    }

    public LiquidTank(int n, int n2, int n3) {
        this(new LiquidStack(n, n2), n3);
    }

    public LiquidTank(int n, int n2, int n3, TileEntity tileEntity) {
        this(n, n2, n3);
        this.tile = tileEntity;
    }

    public LiquidTank(LiquidStack liquidStack, int n) {
        this.liquid = liquidStack;
        this.capacity = n;
    }

    public LiquidTank(LiquidStack liquidStack, int n, TileEntity tileEntity) {
        this(liquidStack, n);
        this.tile = tileEntity;
    }

    @Override
    public LiquidStack getLiquid() {
        return this.liquid;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    public void setLiquid(LiquidStack liquidStack) {
        this.liquid = liquidStack;
    }

    public void setCapacity(int n) {
        this.capacity = n;
    }

    @Override
    public int fill(LiquidStack liquidStack, boolean bl) {
        if (liquidStack == null || liquidStack.itemID <= 0) {
            return 0;
        }
        if (this.liquid == null || this.liquid.itemID <= 0) {
            if (liquidStack.amount <= this.capacity) {
                if (bl) {
                    this.liquid = liquidStack.copy();
                }
                return liquidStack.amount;
            }
            if (bl) {
                this.liquid = liquidStack.copy();
                this.liquid.amount = this.capacity;
                if (this.tile != null) {
                    LiquidEvent.fireEvent(new LiquidEvent.LiquidFillingEvent(this.liquid, this.tile.worldObj, this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this));
                }
            }
            return this.capacity;
        }
        if (!this.liquid.isLiquidEqual(liquidStack)) {
            return 0;
        }
        int n = this.capacity - this.liquid.amount;
        if (liquidStack.amount <= n) {
            if (bl) {
                this.liquid.amount += liquidStack.amount;
            }
            return liquidStack.amount;
        }
        if (bl) {
            this.liquid.amount = this.capacity;
        }
        return n;
    }

    @Override
    public LiquidStack drain(int n, boolean bl) {
        if (this.liquid == null || this.liquid.itemID <= 0) {
            return null;
        }
        if (this.liquid.amount <= 0) {
            return null;
        }
        int n2 = n;
        if (this.liquid.amount < n2) {
            n2 = this.liquid.amount;
        }
        if (bl) {
            this.liquid.amount -= n2;
        }
        LiquidStack liquidStack = new LiquidStack(this.liquid.itemID, n2, this.liquid.itemMeta);
        if (this.liquid.amount <= 0) {
            this.liquid = null;
        }
        if (bl && this.tile != null) {
            LiquidEvent.fireEvent(new LiquidEvent.LiquidDrainingEvent(liquidStack, this.tile.worldObj, this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this));
        }
        return liquidStack;
    }

    @Override
    public int getTankPressure() {
        return this.tankPressure;
    }

    public void setTankPressure(int n) {
        this.tankPressure = n;
    }

    public String getLiquidName() {
        return this.liquid != null ? LiquidDictionary.findLiquidName(this.liquid) : null;
    }

    public boolean containsValidLiquid() {
        return LiquidDictionary.findLiquidName(this.liquid) != null;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        if (this.containsValidLiquid()) {
            this.liquid.writeToNBT(nBTTagCompound);
        } else {
            nBTTagCompound._a("emptyTank", "");
        }
        return nBTTagCompound;
    }

    public LiquidTank readFromNBT(NBTTagCompound nBTTagCompound) {
        LiquidStack liquidStack;
        if (!nBTTagCompound._c("emptyTank") && (liquidStack = LiquidStack.loadLiquidStackFromNBT(nBTTagCompound)) != null) {
            this.setLiquid(liquidStack);
        }
        return this;
    }
}


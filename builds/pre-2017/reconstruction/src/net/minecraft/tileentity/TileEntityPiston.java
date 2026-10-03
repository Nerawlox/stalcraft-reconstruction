/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.owak;

public class TileEntityPiston
extends TileEntity {
    public int _a;
    public int _b;
    public int _c;
    public boolean _d;
    public boolean _e;
    public float _f;
    public float _g;
    public List _h = new ArrayList();

    public TileEntityPiston() {
    }

    public TileEntityPiston(int n, int n2, int n3, boolean bl, boolean bl2) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = bl;
        this._e = bl2;
    }

    public int _a() {
        return this._a;
    }

    @Override
    public int getBlockMetadata() {
        return this._b;
    }

    public boolean _b() {
        return this._d;
    }

    public int _c() {
        return this._c;
    }

    public boolean _d() {
        return this._e;
    }

    public float _a(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        return this._g + (this._f - this._g) * f;
    }

    public float _b(float f) {
        if (this._d) {
            return (this._a(f) - 1.0f) * (float)owak._b[this._c];
        }
        return (1.0f - this._a(f)) * (float)owak._b[this._c];
    }

    public float _c(float f) {
        if (this._d) {
            return (this._a(f) - 1.0f) * (float)owak._c[this._c];
        }
        return (1.0f - this._a(f)) * (float)owak._c[this._c];
    }

    public float _d(float f) {
        if (this._d) {
            return (this._a(f) - 1.0f) * (float)owak._d[this._c];
        }
        return (1.0f - this._a(f)) * (float)owak._d[this._c];
    }

    public void _a(float f, float f2) {
        List list;
        f = this._d ? 1.0f - f : (f -= 1.0f);
        AxisAlignedBB axisAlignedBB = Block.pistonMoving._a(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this._a, f, this._c);
        if (axisAlignedBB != null && !(list = this.worldObj.getEntitiesWithinAABBExcludingEntity(null, axisAlignedBB)).isEmpty()) {
            this._h.addAll(list);
            for (Entity entity : this._h) {
                entity.moveEntity(f2 * (float)owak._b[this._c], f2 * (float)owak._c[this._c], f2 * (float)owak._d[this._c]);
            }
            this._h.clear();
        }
    }

    public void _e() {
        if (this._g < 1.0f && this.worldObj != null) {
            this._f = 1.0f;
            this._g = 1.0f;
            this.worldObj.removeBlockTileEntity(this.xCoord, this.yCoord, this.zCoord);
            this.invalidate();
            if (this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) == Block.pistonMoving.blockID) {
                this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, this._a, this._b, 3);
                this.worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this._a);
            }
        }
    }

    @Override
    public void updateEntity() {
        this._g = this._f;
        if (this._g >= 1.0f) {
            this._a(1.0f, 0.25f);
            this.worldObj.removeBlockTileEntity(this.xCoord, this.yCoord, this.zCoord);
            this.invalidate();
            if (this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) == Block.pistonMoving.blockID) {
                this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, this._a, this._b, 3);
                this.worldObj.notifyBlockOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this._a);
            }
            return;
        }
        this._f += 0.5f;
        if (this._f >= 1.0f) {
            this._f = 1.0f;
        }
        if (this._d) {
            this._a(this._f, this._f - this._g + 0.0625f);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._a = nBTTagCompound._f("blockId");
        this._b = nBTTagCompound._f("blockData");
        this._c = nBTTagCompound._f("facing");
        this._g = this._f = nBTTagCompound._h("progress");
        this._d = nBTTagCompound._o("extending");
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("blockId", this._a);
        nBTTagCompound._a("blockData", this._b);
        nBTTagCompound._a("facing", this._c);
        nBTTagCompound._a("progress", this._g);
        nBTTagCompound._a("extending", this._d);
    }
}


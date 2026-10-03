/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class ybzs
extends EntityAIBase {
    public final EntityOcelot _a;
    public final double _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;

    public ybzs(EntityOcelot entityOcelot, double d) {
        this._a = entityOcelot;
        this._b = d;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute() {
        return this._a.isTamed() && !this._a.isSitting() && this._a.getRNG().nextDouble() <= (double)0.0065f && this._a();
    }

    @Override
    public boolean continueExecuting() {
        return this._c <= this._e && this._d <= 60 && this._a(this._a.worldObj, this._f, this._g, this._h);
    }

    @Override
    public void startExecuting() {
        this._a.getNavigator()._a((double)this._f + 0.5, this._g + 1, (double)this._h + 0.5, this._b);
        this._c = 0;
        this._d = 0;
        this._e = this._a.getRNG().nextInt(this._a.getRNG().nextInt(1200) + 1200) + 1200;
        this._a.func_70907_r()._a(false);
    }

    @Override
    public void resetTask() {
        this._a.setSitting(false);
    }

    @Override
    public void updateTask() {
        ++this._c;
        this._a.func_70907_r()._a(false);
        if (this._a.getDistanceSq(this._f, this._g + 1, this._h) > 1.0) {
            this._a.setSitting(false);
            this._a.getNavigator()._a((double)this._f + 0.5, this._g + 1, (double)this._h + 0.5, this._b);
            ++this._d;
        } else if (!this._a.isSitting()) {
            this._a.setSitting(true);
        } else {
            --this._d;
        }
    }

    public boolean _a() {
        int n = (int)this._a.posY;
        double d = 2.147483647E9;
        int n2 = (int)this._a.posX - 8;
        while ((double)n2 < this._a.posX + 8.0) {
            int n3 = (int)this._a.posZ - 8;
            while ((double)n3 < this._a.posZ + 8.0) {
                double d2;
                if (this._a(this._a.worldObj, n2, n, n3) && this._a.worldObj.isAirBlock(n2, n + 1, n3) && (d2 = this._a.getDistanceSq(n2, n, n3)) < d) {
                    this._f = n2;
                    this._g = n;
                    this._h = n3;
                    d = d2;
                }
                ++n3;
            }
            ++n2;
        }
        return d < 2.147483647E9;
    }

    public boolean _a(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2, n3);
        int n5 = world.getBlockMetadata(n, n2, n3);
        if (n4 == Block.chest.blockID) {
            TileEntityChest tileEntityChest = (TileEntityChest)world.getBlockTileEntity(n, n2, n3);
            if (tileEntityChest._i < 1) {
                return true;
            }
        } else {
            if (n4 == Block.furnaceBurning.blockID) {
                return true;
            }
            if (n4 == Block.bed.blockID && !BlockBed._a(n5)) {
                return true;
            }
        }
        return false;
    }
}


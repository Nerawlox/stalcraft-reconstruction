/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class xpzm
extends EntityAIBase {
    public EntityLiving _a;
    public World _b;
    public int _c;

    public xpzm(EntityLiving entityLiving) {
        this._a = entityLiving;
        this._b = entityLiving.worldObj;
        this.setMutexBits(7);
    }

    @Override
    public boolean shouldExecute() {
        int n;
        int n2;
        if (this._a.getRNG().nextInt(this._a.isChild() ? 50 : 1000) != 0) {
            return false;
        }
        int n3 = sajh._c(this._a.posX);
        if (this._b.getBlockId(n3, n2 = sajh._c(this._a.posY), n = sajh._c(this._a.posZ)) == Block.tallGrass.blockID && this._b.getBlockMetadata(n3, n2, n) == 1) {
            return true;
        }
        return this._b.getBlockId(n3, n2 - 1, n) == Block.grass.blockID;
    }

    @Override
    public void startExecuting() {
        this._c = 40;
        this._b.setEntityState(this._a, (byte)10);
        this._a.getNavigator()._h();
    }

    @Override
    public void resetTask() {
        this._c = 0;
    }

    @Override
    public boolean continueExecuting() {
        return this._c > 0;
    }

    public int _a() {
        return this._c;
    }

    @Override
    public void updateTask() {
        int n;
        int n2;
        this._c = Math.max(0, this._c - 1);
        if (this._c != 4) {
            return;
        }
        int n3 = sajh._c(this._a.posX);
        if (this._b.getBlockId(n3, n2 = sajh._c(this._a.posY), n = sajh._c(this._a.posZ)) == Block.tallGrass.blockID) {
            this._b.destroyBlock(n3, n2, n, false);
            this._a.eatGrassBonus();
        } else if (this._b.getBlockId(n3, n2 - 1, n) == Block.grass.blockID) {
            this._b.playAuxSFX(2001, n3, n2 - 1, n, Block.grass.blockID);
            this._b.setBlock(n3, n2 - 1, n, Block.dirt.blockID, 0, 2);
            this._a.eatGrassBonus();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.sajh;

public class EntityAIControlledByPlayer
extends EntityAIBase {
    public final EntityLiving _a;
    public final float _b;
    public float _c;
    public boolean _d;
    public int _e;
    public int _f;

    public EntityAIControlledByPlayer(EntityLiving entityLiving, float f) {
        this._a = entityLiving;
        this._b = f;
        this.setMutexBits(7);
    }

    @Override
    public void startExecuting() {
        this._c = 0.0f;
    }

    @Override
    public void resetTask() {
        this._d = false;
        this._c = 0.0f;
    }

    @Override
    public boolean shouldExecute() {
        return this._a.isEntityAlive() && this._a.riddenByEntity != null && this._a.riddenByEntity instanceof EntityPlayer && (this._d || this._a.canBeSteered());
    }

    @Override
    public void updateTask() {
        ItemStack itemStack;
        EntityPlayer entityPlayer = (EntityPlayer)this._a.riddenByEntity;
        EntityCreature entityCreature = (EntityCreature)this._a;
        float f = sajh._g(entityPlayer.rotationYaw - this._a.rotationYaw) * 0.5f;
        if (f > 5.0f) {
            f = 5.0f;
        }
        if (f < -5.0f) {
            f = -5.0f;
        }
        this._a.rotationYaw = sajh._g(this._a.rotationYaw + f);
        if (this._c < this._b) {
            this._c += (this._b - this._c) * 0.01f;
        }
        if (this._c > this._b) {
            this._c = this._b;
        }
        int n = sajh._c(this._a.posX);
        int n2 = sajh._c(this._a.posY);
        int n3 = sajh._c(this._a.posZ);
        float f2 = this._c;
        if (this._d) {
            if (this._e++ > this._f) {
                this._d = false;
            }
            f2 += f2 * 1.15f * sajh._a((float)this._e / (float)this._f * (float)Math.PI);
        }
        float f3 = 0.91f;
        if (this._a.onGround) {
            f3 = 0.54600006f;
            int n4 = this._a.worldObj.getBlockId(sajh._d(n), sajh._d(n2) - 1, sajh._d(n3));
            if (n4 > 0) {
                f3 = Block.blocksList[n4].slipperiness * 0.91f;
            }
        }
        float f4 = 0.16277136f / (f3 * f3 * f3);
        float f5 = sajh._a(entityCreature.rotationYaw * (float)Math.PI / 180.0f);
        float f6 = sajh._b(entityCreature.rotationYaw * (float)Math.PI / 180.0f);
        float f7 = entityCreature.getAIMoveSpeed() * f4;
        float f8 = Math.max(f2, 1.0f);
        f8 = f7 / f8;
        float f9 = f2 * f8;
        float f10 = -(f9 * f5);
        float f11 = f9 * f6;
        if (sajh._e(f10) > sajh._e(f11)) {
            if (f10 < 0.0f) {
                f10 -= this._a.width / 2.0f;
            }
            if (f10 > 0.0f) {
                f10 += this._a.width / 2.0f;
            }
            f11 = 0.0f;
        } else {
            f10 = 0.0f;
            if (f11 < 0.0f) {
                f11 -= this._a.width / 2.0f;
            }
            if (f11 > 0.0f) {
                f11 += this._a.width / 2.0f;
            }
        }
        int n5 = sajh._c(this._a.posX + (double)f10);
        int n6 = sajh._c(this._a.posZ + (double)f11);
        elhc elhc2 = new elhc(sajh._d(this._a.width + 1.0f), sajh._d(this._a.height + entityPlayer.height + 1.0f), sajh._d(this._a.width + 1.0f));
        if (n != n5 || n3 != n6) {
            boolean bl;
            int n7 = this._a.worldObj.getBlockId(n, n2, n3);
            int n8 = this._a.worldObj.getBlockId(n, n2 - 1, n3);
            boolean bl2 = bl = this._a(n7) || Block.blocksList[n7] == null && this._a(n8);
            if (!bl && rrnl._a(this._a, n5, n2, n6, elhc2, false, false, true) == 0 && rrnl._a(this._a, n, n2 + 1, n3, elhc2, false, false, true) == 1 && rrnl._a(this._a, n5, n2 + 1, n6, elhc2, false, false, true) == 1) {
                entityCreature.getJumpHelper()._a();
            }
        }
        if (!entityPlayer.capabilities._d && this._c >= this._b * 0.5f && this._a.getRNG().nextFloat() < 0.006f && !this._d && (itemStack = entityPlayer.getHeldItem()) != null && itemStack._d == Item.carrotOnAStick.itemID) {
            itemStack._a(1, (EntityLivingBase)entityPlayer);
            if (itemStack._b == 0) {
                ItemStack itemStack2 = new ItemStack(Item.fishingRod);
                itemStack2._d(itemStack._e);
                entityPlayer.inventory._a[entityPlayer.inventory._c] = itemStack2;
            }
        }
        this._a.moveEntityWithHeading(0.0f, f2);
    }

    public boolean _a(int n) {
        return Block.blocksList[n] != null && (Block.blocksList[n].getRenderType() == 10 || Block.blocksList[n] instanceof BlockHalfSlab);
    }

    public boolean _a() {
        return this._d;
    }

    public void _b() {
        this._d = true;
        this._e = 0;
        this._f = this._a.getRNG().nextInt(841) + 140;
    }

    public boolean _c() {
        return !this._a() && this._c > this._b * 0.3f;
    }
}


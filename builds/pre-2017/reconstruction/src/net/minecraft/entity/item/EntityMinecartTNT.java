/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityMinecartTNT
extends EntityMinecart {
    public int minecartTNTFuse = -1;

    public EntityMinecartTNT(World world) {
        super(world);
    }

    public EntityMinecartTNT(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public int getMinecartType() {
        return 3;
    }

    @Override
    public Block getDefaultDisplayTile() {
        return Block.tnt;
    }

    @Override
    public void onUpdate() {
        double d;
        super.onUpdate();
        if (this.minecartTNTFuse > 0) {
            --this.minecartTNTFuse;
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0);
        } else if (this.minecartTNTFuse == 0) {
            this.explodeCart(this.motionX * this.motionX + this.motionZ * this.motionZ);
        }
        if (this.isCollidedHorizontally && (d = this.motionX * this.motionX + this.motionZ * this.motionZ) >= (double)0.01f) {
            this.explodeCart(d);
        }
    }

    @Override
    public void killMinecart(DamageSource damageSource) {
        super.killMinecart(damageSource);
        double d = this.motionX * this.motionX + this.motionZ * this.motionZ;
        if (!damageSource.isExplosion()) {
            this.entityDropItem(new ItemStack(Block.tnt, 1), 0.0f);
        }
        if (damageSource.isFireDamage() || damageSource.isExplosion() || d >= (double)0.01f) {
            this.explodeCart(d);
        }
    }

    public void explodeCart(double d) {
        if (!this.worldObj.isRemote) {
            double d2 = Math.sqrt(d);
            if (d2 > 5.0) {
                d2 = 5.0;
            }
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)(4.0 + this.rand.nextDouble() * 1.5 * d2), true);
            this.setDead();
        }
    }

    @Override
    public void fall(float f) {
        if (f >= 3.0f) {
            float f2 = f / 10.0f;
            this.explodeCart(f2 * f2);
        }
        super.fall(f);
    }

    @Override
    public void onActivatorRailPass(int n, int n2, int n3, boolean bl) {
        if (bl && this.minecartTNTFuse < 0) {
            this.ignite();
        }
    }

    @Override
    public void handleHealthUpdate(byte by) {
        if (by == 10) {
            this.ignite();
        } else {
            super.handleHealthUpdate(by);
        }
    }

    public void ignite() {
        this.minecartTNTFuse = 80;
        if (!this.worldObj.isRemote) {
            this.worldObj.setEntityState(this, (byte)10);
            this.worldObj.playSoundAtEntity(this, "random.fuse", 1.0f, 1.0f);
        }
    }

    public int func_94104_d() {
        return this.minecartTNTFuse;
    }

    public boolean isIgnited() {
        return this.minecartTNTFuse > -1;
    }

    @Override
    public float getBlockExplosionResistance(Explosion explosion, World world, int n, int n2, int n3, Block block) {
        if (this.isIgnited() && (BlockRailBase._a(block.blockID) || BlockRailBase._a(world, n, n2 + 1, n3))) {
            return 0.0f;
        }
        return super.getBlockExplosionResistance(explosion, world, n, n2, n3, block);
    }

    @Override
    public boolean shouldExplodeBlock(Explosion explosion, World world, int n, int n2, int n3, int n4, float f) {
        if (this.isIgnited() && (BlockRailBase._a(n4) || BlockRailBase._a(world, n, n2 + 1, n3))) {
            return false;
        }
        return super.shouldExplodeBlock(explosion, world, n, n2, n3, n4, f);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        if (nBTTagCompound._c("TNTFuse")) {
            this.minecartTNTFuse = nBTTagCompound._f("TNTFuse");
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("TNTFuse", this.minecartTNTFuse);
    }
}


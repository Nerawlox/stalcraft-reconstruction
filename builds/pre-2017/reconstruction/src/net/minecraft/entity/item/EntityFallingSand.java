/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityFallingSand
extends Entity {
    public int blockID;
    public int metadata;
    public int fallTime;
    public boolean shouldDropItem = true;
    public boolean isBreakingAnvil;
    public boolean isAnvil;
    public int fallHurtMax = 40;
    public float fallHurtAmount = 2.0f;
    public NBTTagCompound fallingBlockTileEntityData;

    public EntityFallingSand(World world) {
        super(world);
    }

    public EntityFallingSand(World world, double d, double d2, double d3, int n) {
        this(world, d, d2, d3, n, 0);
    }

    public EntityFallingSand(World world, double d, double d2, double d3, int n, int n2) {
        super(world);
        this.blockID = n;
        this.metadata = n2;
        this.preventEntitySpawning = true;
        this.setSize(0.98f, 0.98f);
        this.yOffset = this.height / 2.0f;
        this.setPosition(d, d2, d3);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = d;
        this.prevPosY = d2;
        this.prevPosZ = d3;
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void entityInit() {
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void onUpdate() {
        if (this.blockID == 0) {
            this.setDead();
            return;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.fallTime;
        this.motionY -= (double)0.04f;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.98f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)0.98f;
        if (!this.worldObj.isRemote) {
            int n = sajh._c(this.posX);
            int n2 = sajh._c(this.posY);
            int n3 = sajh._c(this.posZ);
            if (this.fallTime == 1) {
                if (this.worldObj.getBlockId(n, n2, n3) == this.blockID) {
                    this.worldObj.setBlockToAir(n, n2, n3);
                } else {
                    this.setDead();
                    return;
                }
            }
            if (this.onGround) {
                this.motionX *= (double)0.7f;
                this.motionZ *= (double)0.7f;
                this.motionY *= -0.5;
                if (this.worldObj.getBlockId(n, n2, n3) != Block.pistonMoving.blockID) {
                    this.setDead();
                    if (!this.isBreakingAnvil && this.worldObj.canPlaceEntityOnSide(this.blockID, n, n2, n3, true, 1, null, null) && !uilx._b(this.worldObj, n, n2 - 1, n3) && this.worldObj.setBlock(n, n2, n3, this.blockID, this.metadata, 3)) {
                        TileEntity tileEntity;
                        if (Block.blocksList[this.blockID] instanceof uilx) {
                            ((uilx)Block.blocksList[this.blockID])._a(this.worldObj, n, n2, n3, this.metadata);
                        }
                        if (this.fallingBlockTileEntityData != null && Block.blocksList[this.blockID] instanceof stgn && (tileEntity = this.worldObj.getBlockTileEntity(n, n2, n3)) != null) {
                            NBTTagCompound nBTTagCompound = new NBTTagCompound();
                            tileEntity.writeToNBT(nBTTagCompound);
                            for (NBTBase nBTBase : this.fallingBlockTileEntityData._d()) {
                                if (nBTBase._b().equals("x") || nBTBase._b().equals("y") || nBTBase._b().equals("z")) continue;
                                nBTTagCompound._a(nBTBase._b(), nBTBase._c());
                            }
                            tileEntity.readFromNBT(nBTTagCompound);
                            tileEntity.onInventoryChanged();
                        }
                    } else if (this.shouldDropItem && !this.isBreakingAnvil) {
                        this.entityDropItem(new ItemStack(this.blockID, 1, Block.blocksList[this.blockID].damageDropped(this.metadata)), 0.0f);
                    }
                }
            } else if (this.fallTime > 100 && !this.worldObj.isRemote && (n2 < 1 || n2 > 256) || this.fallTime > 600) {
                if (this.shouldDropItem) {
                    this.entityDropItem(new ItemStack(this.blockID, 1, Block.blocksList[this.blockID].damageDropped(this.metadata)), 0.0f);
                }
                this.setDead();
            }
        }
    }

    @Override
    public void fall(float f) {
        int n;
        if (this.isAnvil && (n = sajh._f(f - 1.0f)) > 0) {
            ArrayList arrayList = new ArrayList(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox));
            DamageSource damageSource = this.blockID == Block.anvil.blockID ? DamageSource.anvil : DamageSource.fallingBlock;
            for (Entity entity : arrayList) {
                entity.attackEntityFrom(damageSource, Math.min(sajh._d((float)n * this.fallHurtAmount), this.fallHurtMax));
            }
            if (this.blockID == Block.anvil.blockID && (double)this.rand.nextFloat() < (double)0.05f + (double)n * 0.05) {
                int n2 = this.metadata >> 2;
                int n3 = this.metadata & 3;
                if (++n2 > 2) {
                    this.isBreakingAnvil = true;
                } else {
                    this.metadata = n3 | n2 << 2;
                }
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Tile", (byte)this.blockID);
        nBTTagCompound._a("TileID", this.blockID);
        nBTTagCompound._a("Data", (byte)this.metadata);
        nBTTagCompound._a("Time", (byte)this.fallTime);
        nBTTagCompound._a("DropItem", this.shouldDropItem);
        nBTTagCompound._a("HurtEntities", this.isAnvil);
        nBTTagCompound._a("FallHurtAmount", this.fallHurtAmount);
        nBTTagCompound._a("FallHurtMax", this.fallHurtMax);
        if (this.fallingBlockTileEntityData != null) {
            nBTTagCompound._a("TileEntityData", this.fallingBlockTileEntityData);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.blockID = nBTTagCompound._c("TileID") ? nBTTagCompound._f("TileID") : nBTTagCompound._d("Tile") & 0xFF;
        this.metadata = nBTTagCompound._d("Data") & 0xFF;
        this.fallTime = nBTTagCompound._d("Time") & 0xFF;
        if (nBTTagCompound._c("HurtEntities")) {
            this.isAnvil = nBTTagCompound._o("HurtEntities");
            this.fallHurtAmount = nBTTagCompound._h("FallHurtAmount");
            this.fallHurtMax = nBTTagCompound._f("FallHurtMax");
        } else if (this.blockID == Block.anvil.blockID) {
            this.isAnvil = true;
        }
        if (nBTTagCompound._c("DropItem")) {
            this.shouldDropItem = nBTTagCompound._o("DropItem");
        }
        if (nBTTagCompound._c("TileEntityData")) {
            this.fallingBlockTileEntityData = nBTTagCompound._m("TileEntityData");
        }
        if (this.blockID == 0) {
            this.blockID = Block.sand.blockID;
        }
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    public World getWorld() {
        return this.worldObj;
    }

    public void setIsAnvil(boolean bl) {
        this.isAnvil = bl;
    }

    @Override
    public boolean canRenderOnFire() {
        return false;
    }

    @Override
    public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
        super.addEntityCrashInfo(crashReportCategory);
        crashReportCategory._a("Immitating block ID", this.blockID);
        crashReportCategory._a("Immitating block data", this.metadata);
    }
}


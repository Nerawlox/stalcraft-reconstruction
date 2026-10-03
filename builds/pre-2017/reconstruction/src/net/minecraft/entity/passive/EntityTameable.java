/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.qlgf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.scoreboard.Team;
import net.minecraft.world.World;

public abstract class EntityTameable
extends EntityAnimal
implements qlgf {
    public EntityAISit aiSit = new EntityAISit(this);

    public EntityTameable(World world) {
        super(world);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, (Object)0);
        this.dataWatcher._a(17, "");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        if (this.getOwnerName() == null) {
            nBTTagCompound._a("Owner", "");
        } else {
            nBTTagCompound._a("Owner", this.getOwnerName());
        }
        nBTTagCompound._a("Sitting", this.isSitting());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        String string = nBTTagCompound._j("Owner");
        if (string.length() > 0) {
            this.setOwner(string);
            this.setTamed(true);
        }
        this.aiSit._a(nBTTagCompound._o("Sitting"));
        this.setSitting(nBTTagCompound._o("Sitting"));
    }

    public void playTameEffect(boolean bl) {
        String string = "heart";
        if (!bl) {
            string = "smoke";
        }
        for (int i = 0; i < 7; ++i) {
            double d = this.rand.nextGaussian() * 0.02;
            double d2 = this.rand.nextGaussian() * 0.02;
            double d3 = this.rand.nextGaussian() * 0.02;
            this.worldObj.spawnParticle(string, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 0.5 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d2, d3);
        }
    }

    @Override
    public void handleHealthUpdate(byte by) {
        if (by == 7) {
            this.playTameEffect(true);
        } else if (by == 6) {
            this.playTameEffect(false);
        } else {
            super.handleHealthUpdate(by);
        }
    }

    public boolean isTamed() {
        return (this.dataWatcher._a(16) & 4) != 0;
    }

    public void setTamed(boolean bl) {
        byte by = this.dataWatcher._a(16);
        if (bl) {
            this.dataWatcher._b(16, (byte)(by | 4));
        } else {
            this.dataWatcher._b(16, (byte)(by & 0xFFFFFFFB));
        }
    }

    public boolean isSitting() {
        return (this.dataWatcher._a(16) & 1) != 0;
    }

    public void setSitting(boolean bl) {
        byte by = this.dataWatcher._a(16);
        if (bl) {
            this.dataWatcher._b(16, (byte)(by | 1));
        } else {
            this.dataWatcher._b(16, (byte)(by & 0xFFFFFFFE));
        }
    }

    @Override
    public String getOwnerName() {
        return this.dataWatcher._e(17);
    }

    public void setOwner(String string) {
        this.dataWatcher._b(17, string);
    }

    public EntityLivingBase func_130012_q() {
        return this.worldObj.getPlayerEntityByName(this.getOwnerName());
    }

    public EntityAISit func_70907_r() {
        return this.aiSit;
    }

    public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return true;
    }

    @Override
    public Team getTeam() {
        EntityLivingBase entityLivingBase;
        if (this.isTamed() && (entityLivingBase = this.func_130012_q()) != null) {
            return entityLivingBase.getTeam();
        }
        return super.getTeam();
    }

    @Override
    public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
        if (this.isTamed()) {
            EntityLivingBase entityLivingBase2 = this.func_130012_q();
            if (entityLivingBase == entityLivingBase2) {
                return true;
            }
            if (entityLivingBase2 != null) {
                return entityLivingBase2.isOnSameTeam(entityLivingBase);
            }
        }
        return super.isOnSameTeam(entityLivingBase);
    }

    @Override
    public /* synthetic */ Entity getOwner() {
        return this.func_130012_q();
    }
}


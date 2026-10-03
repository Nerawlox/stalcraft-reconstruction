/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityWolf
extends EntityMob {
    private int conversionTime;

    public EntityWolf(World world) {
        super(world);
        this.getNavigator()._b(true);
        this.tasks._a(0, new tdpx(this));
        this.tasks._a(2, new pidb(this, EntityPlayer.class, 1.0, false));
        this.tasks._a(3, new pidb(this, EntityVillager.class, 1.0, true));
        this.tasks._a(4, new amxi(this, 1.0));
        this.tasks._a(6, new iurn(this, 1.0));
        this.tasks._a(7, new iurq(this, EntityPlayer.class, 8.0f));
        this.tasks._a(7, new tdmn(this));
        this.targetTasks._a(1, new ezfa(this, true));
        this.targetTasks._a(2, new pibk(this, EntityPlayer.class, 0, true));
        this.targetTasks._a(2, new pibk(this, EntityVillager.class, 0, false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._b)._a(40.0);
        this.getEntityAttribute(sajz._d)._a(0.3);
        this.getEntityAttribute(sajz._a)._a(2.0);
        this.getEntityAttribute(sajz._e)._a(5.0);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher()._a(12, (Object)0);
        this.getDataWatcher()._a(13, (Object)0);
        this.getDataWatcher()._a(14, (Object)0);
    }

    @Override
    public int getTotalArmorValue() {
        int n = super.getTotalArmorValue() + 2;
        if (n > 20) {
            n = 20;
        }
        return n;
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void onUpdate() {
        if (this.worldObj.isRemote || this.conversionTime <= 0) {
            // empty if block
        }
        super.onUpdate();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean bl = super.attackEntityAsMob(entity);
        if (bl && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)this.worldObj.difficultySetting * 0.3f) {
            entity.setFire(2 * this.worldObj.difficultySetting);
        }
        return bl;
    }

    @Override
    protected String getLivingSound() {
        return "mob.wolf.bdog_idle_0";
    }

    @Override
    protected String getHurtSound() {
        return "bdog_hurt_0";
    }

    @Override
    protected String getDeathSound() {
        return "bdog_die_3";
    }

    @Override
    protected void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.zombie.step", 0.15f, 1.0f);
    }

    @Override
    protected int getDropItemId() {
        return Item.rottenFlesh.itemID;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
    }
}


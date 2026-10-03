/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.dwan;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.jxtc;
import net.minecraft.entity.ai.owak;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pibn;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class EntityIronGolem
extends EntityGolem {
    public int homeCheckTimer;
    public Village villageObj;
    public int attackTimer;
    public int holdRoseTick;

    public EntityIronGolem(World world) {
        super(world);
        this.setSize(1.4f, 2.9f);
        this.getNavigator()._a(true);
        this.tasks._a(1, new pidb(this, 1.0, true));
        this.tasks._a(2, new pibn(this, 0.9, 32.0f));
        this.tasks._a(3, new dwan(this, 0.6, true));
        this.tasks._a(4, new amxi(this, 1.0));
        this.tasks._a(5, new owak(this));
        this.tasks._a(6, new iurn(this, 0.6));
        this.tasks._a(7, new iurq(this, EntityPlayer.class, 6.0f));
        this.tasks._a(8, new tdmn(this));
        this.targetTasks._a(1, new jxtc(this));
        this.targetTasks._a(2, new ezfa(this, false));
        this.targetTasks._a(3, new pibk(this, EntityLiving.class, 0, false, true, ezey._a));
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, (Object)0);
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void updateAITick() {
        if (--this.homeCheckTimer <= 0) {
            this.homeCheckTimer = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj._a(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ), 32);
            if (this.villageObj == null) {
                this.detachHome();
            } else {
                ChunkCoordinates chunkCoordinates = this.villageObj._c();
                this.setHomeArea(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c, (int)((float)this.villageObj._d() * 0.6f));
            }
        }
        super.updateAITick();
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(100.0);
        this.getEntityAttribute(sajz._d)._a(0.25);
    }

    @Override
    public int decreaseAirSupply(int n) {
        return n;
    }

    @Override
    public void collideWithEntity(Entity entity) {
        if (entity instanceof ezey && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase)entity);
        }
        super.collideWithEntity(entity);
    }

    @Override
    public void onLivingUpdate() {
        int n;
        int n2;
        int n3;
        int n4;
        super.onLivingUpdate();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.holdRoseTick > 0) {
            --this.holdRoseTick;
        }
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7 && this.rand.nextInt(5) == 0 && (n4 = this.worldObj.getBlockId(n3 = sajh._c(this.posX), n2 = sajh._c(this.posY - (double)0.2f - (double)this.yOffset), n = sajh._c(this.posZ))) > 0) {
            this.worldObj.spawnParticle("tilecrack_" + n4 + "_" + this.worldObj.getBlockMetadata(n3, n2, n), this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.boundingBox._c + 0.1, this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, 4.0 * ((double)this.rand.nextFloat() - 0.5), 0.5, ((double)this.rand.nextFloat() - 0.5) * 4.0);
        }
    }

    @Override
    public boolean canAttackClass(Class clazz) {
        if (this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(clazz)) {
            return false;
        }
        return super.canAttackClass(clazz);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("PlayerCreated", this.isPlayerCreated());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setPlayerCreated(nBTTagCompound._o("PlayerCreated"));
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        this.attackTimer = 10;
        this.worldObj.setEntityState(this, (byte)4);
        boolean bl = entity.attackEntityFrom(DamageSource.causeMobDamage(this), 7 + this.rand.nextInt(15));
        if (bl) {
            entity.motionY += (double)0.4f;
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return bl;
    }

    @Override
    public void handleHealthUpdate(byte by) {
        if (by == 4) {
            this.attackTimer = 10;
            this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        } else if (by == 11) {
            this.holdRoseTick = 400;
        } else {
            super.handleHealthUpdate(by);
        }
    }

    public Village getVillage() {
        return this.villageObj;
    }

    public int getAttackTimer() {
        return this.attackTimer;
    }

    public void setHoldingRose(boolean bl) {
        this.holdRoseTick = bl ? 400 : 0;
        this.worldObj.setEntityState(this, (byte)11);
    }

    @Override
    public String getLivingSound() {
        return "none";
    }

    @Override
    public String getHurtSound() {
        return "mob.irongolem.hit";
    }

    @Override
    public String getDeathSound() {
        return "mob.irongolem.death";
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.irongolem.walk", 1.0f, 1.0f);
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2;
        int n3 = this.rand.nextInt(3);
        for (n2 = 0; n2 < n3; ++n2) {
            this.dropItem(Block.plantRed.blockID, 1);
        }
        n2 = 3 + this.rand.nextInt(3);
        for (int i = 0; i < n2; ++i) {
            this.dropItem(Item.ingotIron.itemID, 1);
        }
    }

    public int getHoldRoseTick() {
        return this.holdRoseTick;
    }

    public boolean isPlayerCreated() {
        return (this.dataWatcher._a(16) & 1) != 0;
    }

    public void setPlayerCreated(boolean bl) {
        byte by = this.dataWatcher._a(16);
        if (bl) {
            this.dataWatcher._b(16, (byte)(by | 1));
        } else {
            this.dataWatcher._b(16, (byte)(by & 0xFFFFFFFE));
        }
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        if (!this.isPlayerCreated() && this.attackingPlayer != null && this.villageObj != null) {
            this.villageObj._a(this.attackingPlayer.getCommandSenderName(), -5);
        }
        super.onDeath(damageSource);
    }
}


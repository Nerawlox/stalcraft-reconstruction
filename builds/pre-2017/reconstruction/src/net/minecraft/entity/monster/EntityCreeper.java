/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.qlgf;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCreeper
extends EntityMob {
    public int lastActiveTime;
    public int timeSinceIgnited;
    public int fuseTime = 30;
    public int explosionRadius = 3;

    public EntityCreeper(World world) {
        super(world);
        this.tasks._a(1, new tdpx(this));
        this.tasks._a(2, new qlgf(this));
        this.tasks._a(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0f, 1.0, 1.2));
        this.tasks._a(4, new pidb(this, 1.0, false));
        this.tasks._a(5, new iurn(this, 0.8));
        this.tasks._a(6, new iurq(this, EntityPlayer.class, 8.0f));
        this.tasks._a(6, new tdmn(this));
        this.targetTasks._a(1, new pibk(this, EntityPlayer.class, 0, true));
        this.targetTasks._a(2, new ezfa(this, false));
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._d)._a(0.25);
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public int getMaxSafePointTries() {
        if (this.getAttackTarget() == null) {
            return 3;
        }
        return 3 + (int)(this.getHealth() - 1.0f);
    }

    @Override
    public void fall(float f) {
        super.fall(f);
        this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + f * 1.5f);
        if (this.timeSinceIgnited > this.fuseTime - 5) {
            this.timeSinceIgnited = this.fuseTime - 5;
        }
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, (Object)-1);
        this.dataWatcher._a(17, (Object)0);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        if (this.dataWatcher._a(17) == 1) {
            nBTTagCompound._a("powered", true);
        }
        nBTTagCompound._a("Fuse", (short)this.fuseTime);
        nBTTagCompound._a("ExplosionRadius", (byte)this.explosionRadius);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.dataWatcher._b(17, (byte)(nBTTagCompound._o("powered") ? 1 : 0));
        if (nBTTagCompound._c("Fuse")) {
            this.fuseTime = nBTTagCompound._e("Fuse");
        }
        if (nBTTagCompound._c("ExplosionRadius")) {
            this.explosionRadius = nBTTagCompound._d("ExplosionRadius");
        }
    }

    @Override
    public void onUpdate() {
        if (this.isEntityAlive()) {
            this.lastActiveTime = this.timeSinceIgnited;
            int n = this.getCreeperState();
            if (n > 0 && this.timeSinceIgnited == 0) {
                this.playSound("random.fuse", 1.0f, 0.5f);
            }
            this.timeSinceIgnited += n;
            if (this.timeSinceIgnited < 0) {
                this.timeSinceIgnited = 0;
            }
            if (this.timeSinceIgnited >= this.fuseTime) {
                this.timeSinceIgnited = this.fuseTime;
                if (!this.worldObj.isRemote) {
                    boolean bl = this.worldObj.getGameRules()._b("mobGriefing");
                    if (this.getPowered()) {
                        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.explosionRadius * 2, bl);
                    } else {
                        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.explosionRadius, bl);
                    }
                    this.setDead();
                }
            }
        }
        super.onUpdate();
    }

    @Override
    public String getHurtSound() {
        return "mob.creeper.say";
    }

    @Override
    public String getDeathSound() {
        return "mob.creeper.death";
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        if (damageSource.getEntity() instanceof EntitySkeleton) {
            int n = Item.record13.itemID + this.rand.nextInt(Item.recordWait.itemID - Item.record13.itemID + 1);
            this.dropItem(n, 1);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return true;
    }

    public boolean getPowered() {
        return this.dataWatcher._a(17) == 1;
    }

    public float getCreeperFlashIntensity(float f) {
        return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * f) / (float)(this.fuseTime - 2);
    }

    @Override
    public int getDropItemId() {
        return Item.gunpowder.itemID;
    }

    public int getCreeperState() {
        return this.dataWatcher._a(16);
    }

    public void setCreeperState(int n) {
        this.dataWatcher._b(16, (byte)n);
    }

    @Override
    public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
        super.onStruckByLightning(entityLightningBolt);
        this.dataWatcher._b(17, (byte)1);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.boss;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.boss.eidj;
import net.minecraft.entity.boss.pidb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityWither
extends EntityMob
implements eidj,
tdmn {
    public float[] field_82220_d = new float[2];
    public float[] field_82221_e = new float[2];
    public float[] field_82217_f = new float[2];
    public float[] field_82218_g = new float[2];
    public int[] field_82223_h = new int[2];
    public int[] field_82224_i = new int[2];
    public int field_82222_j;
    public static final IEntitySelector attackEntitySelector = new pidb();

    public EntityWither(World world) {
        super(world);
        this.setHealth(this.getMaxHealth());
        this.setSize(0.9f, 4.0f);
        this.isImmuneToFire = true;
        this.getNavigator()._e(true);
        this.tasks._a(0, new tdpx(this));
        this.tasks._a(2, new EntityAIArrowAttack(this, 1.0, 40, 20.0f));
        this.tasks._a(5, new iurn(this, 1.0));
        this.tasks._a(6, new iurq(this, EntityPlayer.class, 8.0f));
        this.tasks._a(7, new net.minecraft.entity.ai.tdmn(this));
        this.targetTasks._a(1, new ezfa(this, false));
        this.targetTasks._a(2, new pibk(this, EntityLiving.class, 0, false, false, attackEntitySelector));
        this.experienceValue = 50;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(17, new Integer(0));
        this.dataWatcher._a(18, new Integer(0));
        this.dataWatcher._a(19, new Integer(0));
        this.dataWatcher._a(20, new Integer(0));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("Invul", this.func_82212_n());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.func_82215_s(nBTTagCompound._f("Invul"));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float getShadowSize() {
        return this.height / 8.0f;
    }

    @Override
    public String getLivingSound() {
        return "mob.wither.idle";
    }

    @Override
    public String getHurtSound() {
        return "mob.wither.hurt";
    }

    @Override
    public String getDeathSound() {
        return "mob.wither.death";
    }

    @Override
    public void onLivingUpdate() {
        double d;
        double d2;
        double d3;
        int n;
        int n2;
        double d4;
        double d5;
        double d6;
        Entity entity;
        this.motionY *= (double)0.6f;
        if (!this.worldObj.isRemote && this.getWatchedTargetId(0) > 0 && (entity = this.worldObj.getEntityByID(this.getWatchedTargetId(0))) != null) {
            double d7;
            if (this.posY < entity.posY || !this.isArmored() && this.posY < entity.posY + 5.0) {
                if (this.motionY < 0.0) {
                    this.motionY = 0.0;
                }
                this.motionY += (0.5 - this.motionY) * (double)0.6f;
            }
            if ((d6 = (d7 = entity.posX - this.posX) * d7 + (d5 = entity.posZ - this.posZ) * d5) > 9.0) {
                d4 = sajh._a(d6);
                this.motionX += (d7 / d4 * 0.5 - this.motionX) * (double)0.6f;
                this.motionZ += (d5 / d4 * 0.5 - this.motionZ) * (double)0.6f;
            }
        }
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > (double)0.05f) {
            this.rotationYaw = (float)Math.atan2(this.motionZ, this.motionX) * 57.295776f - 90.0f;
        }
        super.onLivingUpdate();
        for (n2 = 0; n2 < 2; ++n2) {
            this.field_82218_g[n2] = this.field_82221_e[n2];
            this.field_82217_f[n2] = this.field_82220_d[n2];
        }
        for (n2 = 0; n2 < 2; ++n2) {
            n = this.getWatchedTargetId(n2 + 1);
            Entity entity2 = null;
            if (n > 0) {
                entity2 = this.worldObj.getEntityByID(n);
            }
            if (entity2 != null) {
                d5 = this.func_82214_u(n2 + 1);
                d6 = this.func_82208_v(n2 + 1);
                d4 = this.func_82213_w(n2 + 1);
                d3 = entity2.posX - d5;
                d2 = entity2.posY + (double)entity2.getEyeHeight() - d6;
                d = entity2.posZ - d4;
                double d8 = sajh._a(d3 * d3 + d * d);
                float f = (float)(Math.atan2(d, d3) * 180.0 / Math.PI) - 90.0f;
                float f2 = (float)(-(Math.atan2(d2, d8) * 180.0 / Math.PI));
                this.field_82220_d[n2] = this.func_82204_b(this.field_82220_d[n2], f2, 40.0f);
                this.field_82221_e[n2] = this.func_82204_b(this.field_82221_e[n2], f, 10.0f);
                continue;
            }
            this.field_82221_e[n2] = this.func_82204_b(this.field_82221_e[n2], this.renderYawOffset, 10.0f);
        }
        boolean bl = this.isArmored();
        for (n = 0; n < 3; ++n) {
            d3 = this.func_82214_u(n);
            d2 = this.func_82208_v(n);
            d = this.func_82213_w(n);
            this.worldObj.spawnParticle("smoke", d3 + this.rand.nextGaussian() * (double)0.3f, d2 + this.rand.nextGaussian() * (double)0.3f, d + this.rand.nextGaussian() * (double)0.3f, 0.0, 0.0, 0.0);
            if (!bl || this.worldObj.rand.nextInt(4) != 0) continue;
            this.worldObj.spawnParticle("mobSpell", d3 + this.rand.nextGaussian() * (double)0.3f, d2 + this.rand.nextGaussian() * (double)0.3f, d + this.rand.nextGaussian() * (double)0.3f, 0.7f, 0.7f, 0.5);
        }
        if (this.func_82212_n() > 0) {
            for (n = 0; n < 3; ++n) {
                this.worldObj.spawnParticle("mobSpell", this.posX + this.rand.nextGaussian() * 1.0, this.posY + (double)(this.rand.nextFloat() * 3.3f), this.posZ + this.rand.nextGaussian() * 1.0, 0.7f, 0.7f, 0.9f);
            }
        }
    }

    @Override
    public void updateAITasks() {
        if (this.func_82212_n() > 0) {
            int n = this.func_82212_n() - 1;
            if (n <= 0) {
                this.worldObj.newExplosion(this, this.posX, this.posY + (double)this.getEyeHeight(), this.posZ, 7.0f, false, this.worldObj.getGameRules()._b("mobGriefing"));
                this.worldObj.func_82739_e(1013, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
            this.func_82215_s(n);
            if (this.ticksExisted % 10 == 0) {
                this.heal(10.0f);
            }
        } else {
            int n;
            int n2;
            int n3;
            super.updateAITasks();
            block0: for (n3 = 1; n3 < 3; ++n3) {
                Object object;
                if (this.ticksExisted < this.field_82223_h[n3 - 1]) continue;
                this.field_82223_h[n3 - 1] = this.ticksExisted + 10 + this.rand.nextInt(10);
                if (this.worldObj.difficultySetting >= 2) {
                    int n4 = n3 - 1;
                    n2 = this.field_82224_i[n3 - 1];
                    this.field_82224_i[n4] = this.field_82224_i[n3 - 1] + 1;
                    if (n2 > 15) {
                        float f = 10.0f;
                        float f2 = 5.0f;
                        double d = sajh._a(this.rand, this.posX - (double)f, this.posX + (double)f);
                        double d2 = sajh._a(this.rand, this.posY - (double)f2, this.posY + (double)f2);
                        double d3 = sajh._a(this.rand, this.posZ - (double)f, this.posZ + (double)f);
                        this.func_82209_a(n3 + 1, d, d2, d3, true);
                        this.field_82224_i[n3 - 1] = 0;
                    }
                }
                if ((n = this.getWatchedTargetId(n3)) > 0) {
                    object = this.worldObj.getEntityByID(n);
                    if (object != null && ((Entity)object).isEntityAlive() && this.getDistanceSqToEntity((Entity)object) <= 900.0 && this.canEntityBeSeen((Entity)object)) {
                        this.func_82216_a(n3 + 1, (EntityLivingBase)object);
                        this.field_82223_h[n3 - 1] = this.ticksExisted + 40 + this.rand.nextInt(20);
                        this.field_82224_i[n3 - 1] = 0;
                        continue;
                    }
                    this.func_82211_c(n3, 0);
                    continue;
                }
                object = this.worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox._b(20.0, 8.0, 20.0), attackEntitySelector);
                for (n2 = 0; n2 < 10 && !object.isEmpty(); ++n2) {
                    EntityLivingBase entityLivingBase = (EntityLivingBase)object.get(this.rand.nextInt(object.size()));
                    if (entityLivingBase != this && entityLivingBase.isEntityAlive() && this.canEntityBeSeen(entityLivingBase)) {
                        if (entityLivingBase instanceof EntityPlayer) {
                            if (((EntityPlayer)entityLivingBase).capabilities._a) continue block0;
                            this.func_82211_c(n3, entityLivingBase.entityId);
                            continue block0;
                        }
                        this.func_82211_c(n3, entityLivingBase.entityId);
                        continue block0;
                    }
                    object.remove(entityLivingBase);
                }
            }
            if (this.getAttackTarget() != null) {
                this.func_82211_c(0, this.getAttackTarget().entityId);
            } else {
                this.func_82211_c(0, 0);
            }
            if (this.field_82222_j > 0) {
                --this.field_82222_j;
                if (this.field_82222_j == 0 && this.worldObj.getGameRules()._b("mobGriefing")) {
                    n3 = sajh._c(this.posY);
                    n = sajh._c(this.posX);
                    int n5 = sajh._c(this.posZ);
                    n2 = 0;
                    for (int i = -1; i <= 1; ++i) {
                        for (int j = -1; j <= 1; ++j) {
                            for (int k = 0; k <= 3; ++k) {
                                int n6 = n + i;
                                int n7 = n3 + k;
                                int n8 = n5 + j;
                                int n9 = this.worldObj.getBlockId(n6, n7, n8);
                                Block block = Block.blocksList[n9];
                                if (block == null || !block.canEntityDestroy(this.worldObj, n6, n7, n8, this)) continue;
                                n2 = this.worldObj.destroyBlock(n6, n7, n8, true) || n2 != 0 ? 1 : 0;
                            }
                        }
                    }
                    if (n2 != 0) {
                        this.worldObj.playAuxSFXAtEntity(null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    }
                }
            }
            if (this.ticksExisted % 20 == 0) {
                this.heal(1.0f);
            }
        }
    }

    public void func_82206_m() {
        this.func_82215_s(220);
        this.setHealth(this.getMaxHealth() / 3.0f);
    }

    @Override
    public void setInWeb() {
    }

    @Override
    public int getTotalArmorValue() {
        return 4;
    }

    public double func_82214_u(int n) {
        if (n <= 0) {
            return this.posX;
        }
        float f = (this.renderYawOffset + (float)(180 * (n - 1))) / 180.0f * (float)Math.PI;
        float f2 = sajh._b(f);
        return this.posX + (double)f2 * 1.3;
    }

    public double func_82208_v(int n) {
        return n <= 0 ? this.posY + 3.0 : this.posY + 2.2;
    }

    public double func_82213_w(int n) {
        if (n <= 0) {
            return this.posZ;
        }
        float f = (this.renderYawOffset + (float)(180 * (n - 1))) / 180.0f * (float)Math.PI;
        float f2 = sajh._a(f);
        return this.posZ + (double)f2 * 1.3;
    }

    public float func_82204_b(float f, float f2, float f3) {
        float f4 = sajh._g(f2 - f);
        if (f4 > f3) {
            f4 = f3;
        }
        if (f4 < -f3) {
            f4 = -f3;
        }
        return f + f4;
    }

    public void func_82216_a(int n, EntityLivingBase entityLivingBase) {
        this.func_82209_a(n, entityLivingBase.posX, entityLivingBase.posY + (double)entityLivingBase.getEyeHeight() * 0.5, entityLivingBase.posZ, n == 0 && this.rand.nextFloat() < 0.001f);
    }

    public void func_82209_a(int n, double d, double d2, double d3, boolean bl) {
        this.worldObj.playAuxSFXAtEntity(null, 1014, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        double d4 = this.func_82214_u(n);
        double d5 = this.func_82208_v(n);
        double d6 = this.func_82213_w(n);
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        EntityWitherSkull entityWitherSkull = new EntityWitherSkull(this.worldObj, this, d7, d8, d9);
        if (bl) {
            entityWitherSkull.setInvulnerable(true);
        }
        entityWitherSkull.posY = d5;
        entityWitherSkull.posX = d4;
        entityWitherSkull.posZ = d6;
        this.worldObj.spawnEntityInWorld(entityWitherSkull);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entityLivingBase, float f) {
        this.func_82216_a(0, entityLivingBase);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        Entity entity;
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (damageSource == DamageSource.drown) {
            return false;
        }
        if (this.func_82212_n() > 0) {
            return false;
        }
        if (this.isArmored() && (entity = damageSource.getSourceOfDamage()) instanceof EntityArrow) {
            return false;
        }
        entity = damageSource.getEntity();
        if (entity != null && !(entity instanceof EntityPlayer) && entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getCreatureAttribute() == this.getCreatureAttribute()) {
            return false;
        }
        if (this.field_82222_j <= 0) {
            this.field_82222_j = 20;
        }
        int n = 0;
        while (n < this.field_82224_i.length) {
            int n2 = n++;
            this.field_82224_i[n2] = this.field_82224_i[n2] + 3;
        }
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        this.dropItem(Item.netherStar.itemID, 1);
    }

    @Override
    public void despawnEntity() {
        this.entityAge = 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float f) {
        return 0xF000F0;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void fall(float f) {
    }

    @Override
    public void addPotionEffect(PotionEffect potionEffect) {
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(300.0);
        this.getEntityAttribute(sajz._d)._a(0.6f);
        this.getEntityAttribute(sajz._b)._a(40.0);
    }

    @SideOnly(value=Side.CLIENT)
    public float func_82207_a(int n) {
        return this.field_82221_e[n];
    }

    @SideOnly(value=Side.CLIENT)
    public float func_82210_r(int n) {
        return this.field_82220_d[n];
    }

    public int func_82212_n() {
        return this.dataWatcher._c(20);
    }

    public void func_82215_s(int n) {
        this.dataWatcher._b(20, n);
    }

    public int getWatchedTargetId(int n) {
        return this.dataWatcher._c(17 + n);
    }

    public void func_82211_c(int n, int n2) {
        this.dataWatcher._b(17 + n, n2);
    }

    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 2.0f;
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute._b;
    }

    @Override
    public void mountEntity(Entity entity) {
        this.ridingEntity = null;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntitySilverfish
extends EntityMob {
    public int allySummonCooldown;

    public EntitySilverfish(World world) {
        super(world);
        this.setSize(0.3f, 0.7f);
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(8.0);
        this.getEntityAttribute(sajz._d)._a(0.6f);
        this.getEntityAttribute(sajz._e)._a(1.0);
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public Entity findPlayerToAttack() {
        double d = 8.0;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d);
    }

    @Override
    public String getLivingSound() {
        return "mob.silverfish.say";
    }

    @Override
    public String getHurtSound() {
        return "mob.silverfish.hit";
    }

    @Override
    public String getDeathSound() {
        return "mob.silverfish.kill";
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (this.allySummonCooldown <= 0 && (damageSource instanceof EntityDamageSource || damageSource == DamageSource.magic)) {
            this.allySummonCooldown = 20;
        }
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void attackEntity(Entity entity, float f) {
        if (this.attackTime <= 0 && f < 1.2f && entity.boundingBox._f > this.boundingBox._c && entity.boundingBox._c < this.boundingBox._f) {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        }
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.silverfish.step", 0.15f, 1.0f);
    }

    @Override
    public int getDropItemId() {
        return 0;
    }

    @Override
    public void onUpdate() {
        this.renderYawOffset = this.rotationYaw;
        super.onUpdate();
    }

    @Override
    public void updateEntityActionState() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        super.updateEntityActionState();
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.allySummonCooldown > 0) {
            --this.allySummonCooldown;
            if (this.allySummonCooldown == 0) {
                n5 = sajh._c(this.posX);
                n4 = sajh._c(this.posY);
                n3 = sajh._c(this.posZ);
                n2 = 0;
                n = 0;
                while (n2 == 0 && n <= 5 && n >= -5) {
                    int n6 = 0;
                    while (n2 == 0 && n6 <= 10 && n6 >= -10) {
                        int n7 = 0;
                        while (n2 == 0 && n7 <= 10 && n7 >= -10) {
                            int n8 = this.worldObj.getBlockId(n5 + n6, n4 + n, n3 + n7);
                            if (n8 == Block.silverfish.blockID) {
                                if (!this.worldObj.getGameRules()._b("mobGriefing")) {
                                    int n9 = this.worldObj.getBlockMetadata(n5 + n6, n4 + n, n3 + n7);
                                    Block block = Block.stone;
                                    if (n9 == 1) {
                                        block = Block.cobblestone;
                                    }
                                    if (n9 == 2) {
                                        block = Block.stoneBrick;
                                    }
                                    this.worldObj.setBlock(n5 + n6, n4 + n, n3 + n7, block.blockID, 0, 3);
                                } else {
                                    this.worldObj.destroyBlock(n5 + n6, n4 + n, n3 + n7, false);
                                }
                                Block.silverfish.onBlockDestroyedByPlayer(this.worldObj, n5 + n6, n4 + n, n3 + n7, 0);
                                if (this.rand.nextBoolean()) {
                                    n2 = 1;
                                    break;
                                }
                            }
                            n7 = n7 <= 0 ? 1 - n7 : 0 - n7;
                        }
                        n6 = n6 <= 0 ? 1 - n6 : 0 - n6;
                    }
                    n = n <= 0 ? 1 - n : 0 - n;
                }
            }
        }
        if (this.entityToAttack == null && !this.hasPath()) {
            n5 = sajh._c(this.posX);
            n4 = sajh._c(this.posY + 0.5);
            n3 = sajh._c(this.posZ);
            n2 = this.rand.nextInt(6);
            n = this.worldObj.getBlockId(n5 + owak._b[n2], n4 + owak._c[n2], n3 + owak._d[n2]);
            if (htie._a(n)) {
                this.worldObj.setBlock(n5 + owak._b[n2], n4 + owak._c[n2], n3 + owak._d[n2], Block.silverfish.blockID, htie._b(n), 3);
                this.spawnExplosionParticle();
                this.setDead();
            } else {
                this.updateWanderPath();
            }
        } else if (this.entityToAttack != null && !this.hasPath()) {
            this.entityToAttack = null;
        }
    }

    @Override
    public float getBlockPathWeight(int n, int n2, int n3) {
        if (this.worldObj.getBlockId(n, n2 - 1, n3) == Block.stone.blockID) {
            return 10.0f;
        }
        return super.getBlockPathWeight(n, n2, n3);
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        if (super.getCanSpawnHere()) {
            EntityPlayer entityPlayer = this.worldObj.getClosestPlayerToEntity(this, 5.0);
            return entityPlayer == null;
        }
        return false;
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute._c;
    }
}


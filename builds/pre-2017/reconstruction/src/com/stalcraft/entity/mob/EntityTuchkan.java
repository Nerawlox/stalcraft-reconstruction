/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.entity.mob;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.sajz;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;

public class EntityTuchkan
extends EntityMob {
    private int allySummonCooldown;

    public EntityTuchkan(World world) {
        super(world);
        this.setSize(0.4f, 0.7f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(8.0);
        this.getEntityAttribute(sajz._d)._a(0.6f);
        this.getEntityAttribute(sajz._e)._a(1.0);
    }

    @Override
    protected Entity findPlayerToAttack() {
        double d = 8.0;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d);
    }

    @Override
    protected String getLivingSound() {
        return "mob.silverfish.say";
    }

    @Override
    protected String getHurtSound() {
        return "mob.silverfish.hit";
    }

    @Override
    protected String getDeathSound() {
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
    protected void attackEntity(Entity entity, float f) {
        if (this.attackTime <= 0 && f < 1.2f && entity.boundingBox._f > this.boundingBox._c && entity.boundingBox._c < this.boundingBox._f) {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        }
    }

    @Override
    protected void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.silverfish.step", 0.15f, 1.0f);
    }

    @Override
    public void onUpdate() {
        this.renderYawOffset = this.rotationYaw;
        super.onUpdate();
    }

    @Override
    public float getBlockPathWeight(int n, int n2, int n3) {
        return this.worldObj.getBlockId(n, n2 - 1, n3) == Block.stone.blockID ? 10.0f : super.getBlockPathWeight(n, n2, n3);
    }
}


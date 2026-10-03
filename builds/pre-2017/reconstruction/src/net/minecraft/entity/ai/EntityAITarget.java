/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.qlgf;
import net.minecraft.entity.sajz;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.sajh;
import org.apache.commons.lang3.StringUtils;

public abstract class EntityAITarget
extends EntityAIBase {
    public EntityCreature taskOwner;
    public boolean shouldCheckSight;
    public boolean nearbyOnly;
    public int targetSearchStatus;
    public int targetSearchDelay;
    public int field_75298_g;

    public EntityAITarget(EntityCreature entityCreature, boolean bl) {
        this(entityCreature, bl, false);
    }

    public EntityAITarget(EntityCreature entityCreature, boolean bl, boolean bl2) {
        this.taskOwner = entityCreature;
        this.shouldCheckSight = bl;
        this.nearbyOnly = bl2;
    }

    @Override
    public boolean continueExecuting() {
        EntityLivingBase entityLivingBase = this.taskOwner.getAttackTarget();
        if (entityLivingBase == null) {
            return false;
        }
        if (!entityLivingBase.isEntityAlive()) {
            return false;
        }
        double d = this.getTargetDistance();
        if (this.taskOwner.getDistanceSqToEntity(entityLivingBase) > d * d) {
            return false;
        }
        if (this.shouldCheckSight) {
            if (this.taskOwner.getEntitySenses()._a(entityLivingBase)) {
                this.field_75298_g = 0;
            } else if (++this.field_75298_g > 60) {
                return false;
            }
        }
        return true;
    }

    public double getTargetDistance() {
        hubf hubf2 = this.taskOwner.getEntityAttribute(sajz._b);
        return hubf2 == null ? 16.0 : hubf2._e();
    }

    @Override
    public void startExecuting() {
        this.targetSearchStatus = 0;
        this.targetSearchDelay = 0;
        this.field_75298_g = 0;
    }

    @Override
    public void resetTask() {
        this.taskOwner.setAttackTarget(null);
    }

    public boolean isSuitableTarget(EntityLivingBase entityLivingBase, boolean bl) {
        if (entityLivingBase == null) {
            return false;
        }
        if (entityLivingBase == this.taskOwner) {
            return false;
        }
        if (!entityLivingBase.isEntityAlive()) {
            return false;
        }
        if (!this.taskOwner.canAttackClass(entityLivingBase.getClass())) {
            return false;
        }
        if (this.taskOwner instanceof qlgf && StringUtils.isNotEmpty(((qlgf)((Object)this.taskOwner)).getOwnerName())) {
            if (entityLivingBase instanceof qlgf && ((qlgf)((Object)this.taskOwner)).getOwnerName().equals(((qlgf)((Object)entityLivingBase)).getOwnerName())) {
                return false;
            }
            if (entityLivingBase == ((qlgf)((Object)this.taskOwner)).getOwner()) {
                return false;
            }
        } else if (entityLivingBase instanceof EntityPlayer && !bl && ((EntityPlayer)entityLivingBase).capabilities._a) {
            return false;
        }
        if (!this.taskOwner.func_110176_b(sajh._c(entityLivingBase.posX), sajh._c(entityLivingBase.posY), sajh._c(entityLivingBase.posZ))) {
            return false;
        }
        if (this.shouldCheckSight && !this.taskOwner.getEntitySenses()._a(entityLivingBase)) {
            return false;
        }
        if (this.nearbyOnly) {
            if (--this.targetSearchDelay <= 0) {
                this.targetSearchStatus = 0;
            }
            if (this.targetSearchStatus == 0) {
                int n = this.targetSearchStatus = this.canEasilyReach(entityLivingBase) ? 1 : 2;
            }
            if (this.targetSearchStatus == 2) {
                return false;
            }
        }
        return true;
    }

    public boolean canEasilyReach(EntityLivingBase entityLivingBase) {
        int n;
        this.targetSearchDelay = 10 + this.taskOwner.getRNG().nextInt(5);
        PathEntity pathEntity = this.taskOwner.getNavigator()._a(entityLivingBase);
        if (pathEntity == null) {
            return false;
        }
        elhc elhc2 = pathEntity._f();
        if (elhc2 == null) {
            return false;
        }
        int n2 = elhc2._a - sajh._c(entityLivingBase.posX);
        return (double)(n2 * n2 + (n = elhc2._c - sajh._c(entityLivingBase.posZ)) * n) <= 2.25;
    }
}


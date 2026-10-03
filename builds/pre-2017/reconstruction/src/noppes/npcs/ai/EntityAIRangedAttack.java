/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.tdmn;
import net.minecraft.util.sajh;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumNavType;

public class EntityAIRangedAttack
extends EntityAIBase {
    private final EntityNPCInterface entityHost;
    private final tdmn rangedAttackEntityHost;
    private int rangedAttackTime = 0;
    private int field_75318_f = 0;
    private int field_70846_g = 0;
    private int attackTick = 0;
    private boolean hasFired = false;
    private boolean navOverride = false;

    public EntityAIRangedAttack(tdmn tdmn2) {
        if (!(tdmn2 instanceof EntityLivingBase)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }
        this.rangedAttackEntityHost = tdmn2;
        this.entityHost = (EntityNPCInterface)tdmn2;
        this.rangedAttackTime = this.entityHost.stats.fireDelay / 2;
        this.setMutexBits(this.entityHost.aiData.useRangeMelee != 2 && this.entityHost.aiData.tacticalVariant != EnumNavType.Surround && this.entityHost.aiData.tacticalVariant != EnumNavType.Stalk ? 3 : 4);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entityLivingBase = this.entityHost.getAttackTarget();
        if (entityLivingBase != null && entityLivingBase.isEntityAlive()) {
            if (this.entityHost.inventory.getFirearm() == null) {
                return false;
            }
            double d = this.entityHost.getDistanceSq(entityLivingBase.posX, entityLivingBase.boundingBox._c, entityLivingBase.posZ);
            double d2 = this.entityHost.aiData.distanceToMelee * this.entityHost.aiData.distanceToMelee;
            if (this.entityHost.aiData.useRangeMelee == 1 && d <= d2) {
                return false;
            }
            return this.entityHost.aiData.useRangeMelee != 2 || !(d <= 16.0);
        }
        return false;
    }

    @Override
    public boolean continueExecuting() {
        return this.shouldExecute() || !this.entityHost.getNavigator()._g();
    }

    @Override
    public void resetTask() {
        this.entityHost.setAttackTarget(null);
        this.entityHost.getNavigator()._h();
        this.field_75318_f = 0;
        this.hasFired = false;
        if (this.entityHost.aiData.useRangeMelee != 2) {
            this.rangedAttackTime = this.entityHost.stats.fireDelay / 2;
        }
    }

    @Override
    public void updateTask() {
        EntityLivingBase entityLivingBase = this.entityHost.getAttackTarget();
        if (entityLivingBase == null) {
            return;
        }
        double d = this.entityHost.getDistanceSq(entityLivingBase.posX, entityLivingBase.boundingBox._c, entityLivingBase.posZ);
        float f = this.entityHost.stats.rangedRange * this.entityHost.stats.rangedRange;
        this.field_75318_f = this.entityHost.aiData.directLOS && !this.entityHost.getEntitySenses()._a(entityLivingBase) ? 0 : ++this.field_75318_f;
        if (this.entityHost.aiData.useRangeMelee != 2 && !this.navOverride) {
            int n;
            int n2 = n = this.entityHost.aiData.tacticalVariant != EnumNavType.Default ? 5 : 20;
            if (d <= (double)f && this.field_75318_f >= n) {
                this.entityHost.getNavigator()._h();
            } else {
                this.entityHost.getNavigator()._a(entityLivingBase, 1.0);
            }
            this.entityHost.getLookHelper()._a(entityLivingBase, 30.0f, 30.0f);
        }
        this.rangedAttackTime = Math.max(this.rangedAttackTime - 1, 0);
        if (this.rangedAttackTime <= 0 && d <= (double)f && (this.entityHost.getEntitySenses()._a(entityLivingBase) || !this.entityHost.aiData.directLOS && this.entityHost.aiData.canFireIndirect)) {
            if (this.field_70846_g++ <= this.entityHost.stats.burstCount) {
                this.rangedAttackTime = this.entityHost.stats.fireRate;
            } else {
                this.field_70846_g = 0;
                this.hasFired = true;
                this.rangedAttackTime = this.entityHost.stats.fireDelay + sajh._d(this.entityHost.getRNG().nextFloat() * (float)this.entityHost.stats.delayVariance);
            }
            if (this.field_70846_g > 1) {
                this.rangedAttackEntityHost.attackEntityWithRangedAttack(entityLivingBase, !this.entityHost.getEntitySenses()._a(entityLivingBase) ? 1.0f : 0.0f);
            }
        }
    }

    public boolean hasFired() {
        return this.hasFired;
    }

    public void navOverride(boolean bl) {
        this.navOverride = bl;
    }
}


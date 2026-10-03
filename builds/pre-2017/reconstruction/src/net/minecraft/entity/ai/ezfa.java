/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.util.AxisAlignedBB;

public class ezfa
extends EntityAITarget {
    public boolean _a;
    public int _b;

    public ezfa(EntityCreature entityCreature, boolean bl) {
        super(entityCreature, false);
        this._a = bl;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        int n = this.taskOwner.func_142015_aE();
        return n != this._b && this.isSuitableTarget(this.taskOwner.getAITarget(), false);
    }

    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.taskOwner.getAITarget());
        this._b = this.taskOwner.func_142015_aE();
        if (this._a) {
            double d = this.getTargetDistance();
            List list2 = this.taskOwner.worldObj.getEntitiesWithinAABB(this.taskOwner.getClass(), AxisAlignedBB._a()._a(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0, this.taskOwner.posY + 1.0, this.taskOwner.posZ + 1.0)._b(d, 10.0, d));
            for (EntityCreature entityCreature : list2) {
                if (this.taskOwner == entityCreature || entityCreature.getAttackTarget() != null || entityCreature.isOnSameTeam(this.taskOwner.getAITarget())) continue;
                entityCreature.setAttackTarget(this.taskOwner.getAITarget());
            }
        }
        super.startExecuting();
    }
}


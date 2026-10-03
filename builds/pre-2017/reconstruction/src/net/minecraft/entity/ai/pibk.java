/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.Collections;
import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.dwbf;
import net.minecraft.entity.ai.pzdf;

public class pibk
extends EntityAITarget {
    public final Class _a;
    public final int _b;
    public final dwbf _c;
    public final IEntitySelector _d;
    public EntityLivingBase _e;

    public pibk(EntityCreature entityCreature, Class clazz, int n, boolean bl) {
        this(entityCreature, clazz, n, bl, false);
    }

    public pibk(EntityCreature entityCreature, Class clazz, int n, boolean bl, boolean bl2) {
        this(entityCreature, clazz, n, bl, bl2, null);
    }

    public pibk(EntityCreature entityCreature, Class clazz, int n, boolean bl, boolean bl2, IEntitySelector iEntitySelector) {
        super(entityCreature, bl, bl2);
        this._a = clazz;
        this._b = n;
        this._c = new dwbf(entityCreature);
        this.setMutexBits(1);
        this._d = new pzdf(this, iEntitySelector);
    }

    @Override
    public boolean shouldExecute() {
        if (this._b > 0 && this.taskOwner.getRNG().nextInt(this._b) != 0) {
            return false;
        }
        double d = this.getTargetDistance();
        List list2 = this.taskOwner.worldObj.selectEntitiesWithinAABB(this._a, this.taskOwner.boundingBox._b(d, 4.0, d), this._d);
        Collections.sort(list2, this._c);
        if (list2.isEmpty()) {
            return false;
        }
        this._e = (EntityLivingBase)list2.get(0);
        return true;
    }

    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this._e);
        super.startExecuting();
    }
}


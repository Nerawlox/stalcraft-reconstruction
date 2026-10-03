/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.tdmn;
import net.minecraft.util.sajh;

public class EntityAIArrowAttack
extends EntityAIBase {
    public final EntityLiving _a;
    public final tdmn _b;
    public EntityLivingBase _c;
    public int _d = -1;
    public double _e;
    public int _f;
    public int _g;
    public int _h;
    public float _i;
    public float _j;

    public EntityAIArrowAttack(tdmn tdmn2, double d, int n, float f) {
        this(tdmn2, d, n, n, f);
    }

    public EntityAIArrowAttack(tdmn tdmn2, double d, int n, int n2, float f) {
        if (!(tdmn2 instanceof EntityLivingBase)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }
        this._b = tdmn2;
        this._a = (EntityLiving)((Object)tdmn2);
        this._e = d;
        this._g = n;
        this._h = n2;
        this._i = f;
        this._j = f * f;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entityLivingBase = this._a.getAttackTarget();
        if (entityLivingBase == null) {
            return false;
        }
        this._c = entityLivingBase;
        return true;
    }

    @Override
    public boolean continueExecuting() {
        return this.shouldExecute() || !this._a.getNavigator()._g();
    }

    @Override
    public void resetTask() {
        this._c = null;
        this._f = 0;
        this._d = -1;
    }

    @Override
    public void updateTask() {
        double d = this._a.getDistanceSq(this._c.posX, this._c.boundingBox._c, this._c.posZ);
        boolean bl = this._a.getEntitySenses()._a(this._c);
        this._f = bl ? ++this._f : 0;
        if (d > (double)this._j || this._f < 20) {
            this._a.getNavigator()._a(this._c, this._e);
        } else {
            this._a.getNavigator()._h();
        }
        this._a.getLookHelper()._a(this._c, 30.0f, 30.0f);
        if (--this._d == 0) {
            if (d > (double)this._j || !bl) {
                return;
            }
            float f = sajh._a(d) / this._i;
            float f2 = f;
            if (f2 < 0.1f) {
                f2 = 0.1f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this._b.attackEntityWithRangedAttack(this._c, f2);
            this._d = sajh._d(f * (float)(this._h - this._g) + (float)this._g);
        } else if (this._d < 0) {
            float f = sajh._a(d) / this._i;
            this._d = sajh._d(f * (float)(this._h - this._g) + (float)this._g);
        }
    }
}


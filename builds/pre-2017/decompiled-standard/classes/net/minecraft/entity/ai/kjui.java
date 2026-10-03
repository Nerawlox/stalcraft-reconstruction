/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.tdmn;
import net.minecraft.util.sajh;

public class kjui
extends zwat {
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

    public kjui(tdmn tdmn2, double d, int n, float f) {
        this(tdmn2, d, n, n, f);
    }

    public kjui(tdmn tdmn2, double d, int n, int n2, float f) {
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
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        EntityLivingBase entityLivingBase = this._a.func_70638_az();
        if (entityLivingBase == null) {
            return false;
        }
        this._c = entityLivingBase;
        return true;
    }

    @Override
    public boolean func_75253_b() {
        return this.func_75250_a() || !this._a.func_70661_as()._g();
    }

    @Override
    public void func_75251_c() {
        this._c = null;
        this._f = 0;
        this._d = -1;
    }

    @Override
    public void func_75246_d() {
        double d = this._a.func_70092_e(this._c.field_70165_t, this._c.field_70121_D._c, this._c.field_70161_v);
        boolean bl = this._a.func_70635_at()._a(this._c);
        this._f = bl ? ++this._f : 0;
        if (d > (double)this._j || this._f < 20) {
            this._a.func_70661_as()._a(this._c, this._e);
        } else {
            this._a.func_70661_as()._h();
        }
        this._a.func_70671_ap()._a(this._c, 30.0f, 30.0f);
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
            this._b.func_82196_d(this._c, f2);
            this._d = sajh._d(f * (float)(this._h - this._g) + (float)this._g);
        } else if (this._d < 0) {
            float f = sajh._a(d) / this._i;
            this._d = sajh._d(f * (float)(this._h - this._g) + (float)this._g);
        }
    }
}


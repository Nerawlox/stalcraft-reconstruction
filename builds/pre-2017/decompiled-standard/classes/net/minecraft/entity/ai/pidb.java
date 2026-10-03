/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.sajh;

public class pidb
extends zwat {
    public ozlu _a;
    public EntityCreature _b;
    public int _c;
    public double _d;
    public boolean _e;
    public suqn _f;
    public Class _g;
    public int _h;
    public int _i;

    public pidb(EntityCreature entityCreature, Class clazz, double d, boolean bl) {
        this(entityCreature, d, bl);
        this._g = clazz;
    }

    public pidb(EntityCreature entityCreature, double d, boolean bl) {
        this._b = entityCreature;
        this._a = entityCreature.field_70170_p;
        this._d = d;
        this._e = bl;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        EntityLivingBase entityLivingBase = this._b.func_70638_az();
        if (entityLivingBase == null) {
            return false;
        }
        if (!entityLivingBase.func_70089_S()) {
            return false;
        }
        if (this._g != null && !this._g.isAssignableFrom(entityLivingBase.getClass())) {
            return false;
        }
        if (--this._h <= 0) {
            this._f = this._b.func_70661_as()._a(entityLivingBase);
            this._h = 4 + this._b.func_70681_au().nextInt(7);
            return this._f != null;
        }
        return true;
    }

    @Override
    public boolean func_75253_b() {
        EntityLivingBase entityLivingBase = this._b.func_70638_az();
        return entityLivingBase == null ? false : (!entityLivingBase.func_70089_S() ? false : (!this._e ? !this._b.func_70661_as()._g() : this._b.func_110176_b(sajh._c(entityLivingBase.field_70165_t), sajh._c(entityLivingBase.field_70163_u), sajh._c(entityLivingBase.field_70161_v))));
    }

    @Override
    public void func_75249_e() {
        this._b.func_70661_as()._a(this._f, this._d);
        this._h = 0;
    }

    @Override
    public void func_75251_c() {
        this._b.func_70661_as()._h();
    }

    @Override
    public void func_75246_d() {
        EntityLivingBase entityLivingBase = this._b.func_70638_az();
        this._b.func_70671_ap()._a(entityLivingBase, 30.0f, 30.0f);
        if ((this._e || this._b.func_70635_at()._a(entityLivingBase)) && --this._h <= 0) {
            elhc elhc2;
            this._h = this._i + 4 + this._b.func_70681_au().nextInt(7);
            this._b.func_70661_as()._a(entityLivingBase, this._d);
            this._i = this._b.func_70661_as()._d() != null ? ((elhc2 = this._b.func_70661_as()._d()._f()) != null && entityLivingBase.func_70092_e(elhc2._a, elhc2._b, elhc2._c) < 1.0 ? 0 : (this._i += 10)) : (this._i += 10);
        }
        this._c = Math.max(this._c - 1, 0);
        double d = this._b.field_70130_N * 2.0f * this._b.field_70130_N * 2.0f + entityLivingBase.field_70130_N;
        if (this._b.func_70092_e(entityLivingBase.field_70165_t, entityLivingBase.field_70121_D._c, entityLivingBase.field_70161_v) <= d && this._c <= 0) {
            this._c = 20;
            if (this._b.func_70694_bm() != null) {
                this._b.func_71038_i();
            }
            this._b.func_70652_k(entityLivingBase);
        }
    }
}


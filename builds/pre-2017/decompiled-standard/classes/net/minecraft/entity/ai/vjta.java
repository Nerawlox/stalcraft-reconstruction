/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class vjta
extends zwat {
    public EntityCreature _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;
    public ozlu _f;

    public vjta(EntityCreature entityCreature, double d) {
        this._a = entityCreature;
        this._e = d;
        this._f = entityCreature.field_70170_p;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (!this._f.func_72935_r()) {
            return false;
        }
        if (!this._a.func_70027_ad()) {
            return false;
        }
        if (!this._f.func_72937_j(sajh._c(this._a.field_70165_t), (int)this._a.field_70121_D._c, sajh._c(this._a.field_70161_v))) {
            return false;
        }
        ofbx ofbx2 = this._a();
        if (ofbx2 == null) {
            return false;
        }
        this._b = ofbx2._c;
        this._c = ofbx2._d;
        this._d = ofbx2._e;
        return true;
    }

    @Override
    public boolean func_75253_b() {
        return !this._a.func_70661_as()._g();
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._a(this._b, this._c, this._d, this._e);
    }

    public ofbx _a() {
        Random random = this._a.func_70681_au();
        for (int i = 0; i < 10; ++i) {
            int n;
            int n2;
            int n3 = sajh._c(this._a.field_70165_t + (double)random.nextInt(20) - 10.0);
            if (this._f.func_72937_j(n3, n2 = sajh._c(this._a.field_70121_D._c + (double)random.nextInt(6) - 3.0), n = sajh._c(this._a.field_70161_v + (double)random.nextInt(20) - 10.0)) || !(this._a.func_70783_a(n3, n2, n) < 0.0f)) continue;
            return this._f.func_82732_R()._a(n3, n2, n);
        }
        return null;
    }
}


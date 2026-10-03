/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class sajz
extends zwat {
    public EntityCreature _a;
    public ellv _b;
    public int _c = -1;
    public int _d = -1;

    public sajz(EntityCreature entityCreature) {
        this._a = entityCreature;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.field_70170_p.func_72935_r() && !this._a.field_70170_p.func_72896_J() || this._a.field_70170_p.field_73011_w._g) {
            return false;
        }
        if (this._a.func_70681_au().nextInt(50) != 0) {
            return false;
        }
        if (this._c != -1 && this._a.func_70092_e(this._c, this._a.field_70163_u, this._d) < 4.0) {
            return false;
        }
        mtdg mtdg2 = this._a.field_70170_p.field_72982_D._a(sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70163_u), sajh._c(this._a.field_70161_v), 14);
        if (mtdg2 == null) {
            return false;
        }
        this._b = mtdg2._c(sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70163_u), sajh._c(this._a.field_70161_v));
        return this._b != null;
    }

    @Override
    public boolean func_75253_b() {
        return !this._a.func_70661_as()._g();
    }

    @Override
    public void func_75249_e() {
        this._c = -1;
        if (this._a.func_70092_e(this._b._a(), this._b._b, this._b._c()) > 256.0) {
            ofbx ofbx2 = ofaz._a(this._a, 14, 3, this._a.field_70170_p.func_82732_R()._a((double)this._b._a() + 0.5, this._b._b(), (double)this._b._c() + 0.5));
            if (ofbx2 != null) {
                this._a.func_70661_as()._a(ofbx2._c, ofbx2._d, ofbx2._e, 1.0);
            }
        } else {
            this._a.func_70661_as()._a((double)this._b._a() + 0.5, this._b._b(), (double)this._b._c() + 0.5, 1.0);
        }
    }

    @Override
    public void func_75251_c() {
        this._c = this._b._a();
        this._d = this._b._c();
        this._b = null;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.sajh;

public class xpzm
extends zwat {
    public EntityLiving _a;
    public ozlu _b;
    public int _c;

    public xpzm(EntityLiving entityLiving) {
        this._a = entityLiving;
        this._b = entityLiving.field_70170_p;
        this.func_75248_a(7);
    }

    @Override
    public boolean func_75250_a() {
        int n;
        int n2;
        if (this._a.func_70681_au().nextInt(this._a.func_70631_g_() ? 50 : 1000) != 0) {
            return false;
        }
        int n3 = sajh._c(this._a.field_70165_t);
        if (this._b.func_72798_a(n3, n2 = sajh._c(this._a.field_70163_u), n = sajh._c(this._a.field_70161_v)) == twgu.field_71962_X.field_71990_ca && this._b.func_72805_g(n3, n2, n) == 1) {
            return true;
        }
        return this._b.func_72798_a(n3, n2 - 1, n) == twgu.field_71980_u.field_71990_ca;
    }

    @Override
    public void func_75249_e() {
        this._c = 40;
        this._b.func_72960_a(this._a, (byte)10);
        this._a.func_70661_as()._h();
    }

    @Override
    public void func_75251_c() {
        this._c = 0;
    }

    @Override
    public boolean func_75253_b() {
        return this._c > 0;
    }

    public int _a() {
        return this._c;
    }

    @Override
    public void func_75246_d() {
        int n;
        int n2;
        this._c = Math.max(0, this._c - 1);
        if (this._c != 4) {
            return;
        }
        int n3 = sajh._c(this._a.field_70165_t);
        if (this._b.func_72798_a(n3, n2 = sajh._c(this._a.field_70163_u), n = sajh._c(this._a.field_70161_v)) == twgu.field_71962_X.field_71990_ca) {
            this._b.func_94578_a(n3, n2, n, false);
            this._a.func_70615_aA();
        } else if (this._b.func_72798_a(n3, n2 - 1, n) == twgu.field_71980_u.field_71990_ca) {
            this._b.func_72926_e(2001, n3, n2 - 1, n, twgu.field_71980_u.field_71990_ca);
            this._b.func_72832_d(n3, n2 - 1, n, twgu.field_71979_v.field_71990_ca, 0, 2);
            this._a.func_70615_aA();
        }
    }
}


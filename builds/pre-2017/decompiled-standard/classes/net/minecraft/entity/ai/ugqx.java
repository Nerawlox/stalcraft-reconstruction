/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.sajh;

public abstract class ugqx
extends zwat {
    public EntityLiving field_75356_a;
    public int field_75354_b;
    public int field_75355_c;
    public int field_75352_d;
    public nutn field_75353_e;
    public boolean field_75350_f;
    public float field_75351_g;
    public float field_75357_h;

    public ugqx(EntityLiving entityLiving) {
        this.field_75356_a = entityLiving;
    }

    @Override
    public boolean func_75250_a() {
        if (!this.field_75356_a.field_70123_F) {
            return false;
        }
        ujuz ujuz2 = this.field_75356_a.func_70661_as();
        suqn suqn2 = ujuz2._d();
        if (suqn2 == null || suqn2._e() || !ujuz2._b()) {
            return false;
        }
        for (int i = 0; i < Math.min(suqn2._h() + 2, suqn2._g()); ++i) {
            elhc elhc2 = suqn2._c(i);
            this.field_75354_b = elhc2._a;
            this.field_75355_c = elhc2._b + 1;
            this.field_75352_d = elhc2._c;
            if (this.field_75356_a.func_70092_e(this.field_75354_b, this.field_75356_a.field_70163_u, this.field_75352_d) > 2.25) continue;
            this.field_75353_e = this.func_75349_a(this.field_75354_b, this.field_75355_c, this.field_75352_d);
            if (this.field_75353_e == null) continue;
            return true;
        }
        this.field_75354_b = sajh._c(this.field_75356_a.field_70165_t);
        this.field_75355_c = sajh._c(this.field_75356_a.field_70163_u + 1.0);
        this.field_75352_d = sajh._c(this.field_75356_a.field_70161_v);
        this.field_75353_e = this.func_75349_a(this.field_75354_b, this.field_75355_c, this.field_75352_d);
        return this.field_75353_e != null;
    }

    @Override
    public boolean func_75253_b() {
        return !this.field_75350_f;
    }

    @Override
    public void func_75249_e() {
        this.field_75350_f = false;
        this.field_75351_g = (float)((double)((float)this.field_75354_b + 0.5f) - this.field_75356_a.field_70165_t);
        this.field_75357_h = (float)((double)((float)this.field_75352_d + 0.5f) - this.field_75356_a.field_70161_v);
    }

    @Override
    public void func_75246_d() {
        float f = (float)((double)((float)this.field_75354_b + 0.5f) - this.field_75356_a.field_70165_t);
        float f2 = (float)((double)((float)this.field_75352_d + 0.5f) - this.field_75356_a.field_70161_v);
        float f3 = this.field_75351_g * f + this.field_75357_h * f2;
        if (f3 < 0.0f) {
            this.field_75350_f = true;
        }
    }

    public nutn func_75349_a(int n, int n2, int n3) {
        int n4 = this.field_75356_a.field_70170_p.func_72798_a(n, n2, n3);
        if (n4 != twgu.field_72054_aE.field_71990_ca) {
            return null;
        }
        return (nutn)twgu.field_71973_m[n4];
    }
}


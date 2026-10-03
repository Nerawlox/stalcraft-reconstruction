/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.ugqx;

public class jgro
extends ugqx {
    public int _a;
    public int _b = -1;

    public jgro(EntityLiving entityLiving) {
        super(entityLiving);
    }

    @Override
    public boolean func_75250_a() {
        if (!super.func_75250_a()) {
            return false;
        }
        if (!this.field_75356_a.field_70170_p.func_82736_K()._b("mobGriefing")) {
            return false;
        }
        return !this.field_75353_e._b(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d);
    }

    @Override
    public void func_75249_e() {
        super.func_75249_e();
        this._a = 0;
    }

    @Override
    public boolean func_75253_b() {
        double d = this.field_75356_a.func_70092_e(this.field_75354_b, this.field_75355_c, this.field_75352_d);
        return this._a <= 240 && !this.field_75353_e._b(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d) && d < 4.0;
    }

    @Override
    public void func_75251_c() {
        super.func_75251_c();
        this.field_75356_a.field_70170_p.func_72888_f(this.field_75356_a.field_70157_k, this.field_75354_b, this.field_75355_c, this.field_75352_d, -1);
    }

    @Override
    public void func_75246_d() {
        super.func_75246_d();
        if (this.field_75356_a.func_70681_au().nextInt(20) == 0) {
            this.field_75356_a.field_70170_p.func_72926_e(1010, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
        }
        ++this._a;
        int n = (int)((float)this._a / 240.0f * 10.0f);
        if (n != this._b) {
            this.field_75356_a.field_70170_p.func_72888_f(this.field_75356_a.field_70157_k, this.field_75354_b, this.field_75355_c, this.field_75352_d, n);
            this._b = n;
        }
        if (this._a == 240 && this.field_75356_a.field_70170_p.field_73013_u == 3) {
            this.field_75356_a.field_70170_p.func_94571_i(this.field_75354_b, this.field_75355_c, this.field_75352_d);
            this.field_75356_a.field_70170_p.func_72926_e(1012, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
            this.field_75356_a.field_70170_p.func_72926_e(2001, this.field_75354_b, this.field_75355_c, this.field_75352_d, this.field_75353_e.field_71990_ca);
        }
    }
}


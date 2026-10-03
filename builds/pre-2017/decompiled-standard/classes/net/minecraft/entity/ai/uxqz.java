/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.ugqx;

public class uxqz
extends ugqx {
    public boolean _a;
    public int _b;

    public uxqz(EntityLiving entityLiving, boolean bl) {
        super(entityLiving);
        this.field_75356_a = entityLiving;
        this._a = bl;
    }

    @Override
    public boolean func_75253_b() {
        return this._a && this._b > 0 && super.func_75253_b();
    }

    @Override
    public void func_75249_e() {
        this._b = 20;
        this.field_75353_e._a(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d, true);
    }

    @Override
    public void func_75251_c() {
        if (this._a) {
            this.field_75353_e._a(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d, false);
        }
    }

    @Override
    public void func_75246_d() {
        --this._b;
        super.func_75246_d();
    }
}


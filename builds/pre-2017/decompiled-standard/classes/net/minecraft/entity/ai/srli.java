/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import java.util.Random;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityAnimal;

public class srli
extends zwat {
    public EntityAnimal _a;
    public ozlu _b;
    public EntityAnimal _c;
    public int _d;
    public double _e;

    public srli(EntityAnimal entityAnimal, double d) {
        this._a = entityAnimal;
        this._b = entityAnimal.field_70170_p;
        this._e = d;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        if (!this._a.func_70880_s()) {
            return false;
        }
        this._c = this._a();
        return this._c != null;
    }

    @Override
    public boolean func_75253_b() {
        return this._c.func_70089_S() && this._c.func_70880_s() && this._d < 60;
    }

    @Override
    public void func_75251_c() {
        this._c = null;
        this._d = 0;
    }

    @Override
    public void func_75246_d() {
        this._a.func_70671_ap()._a(this._c, 10.0f, (float)this._a.func_70646_bf());
        this._a.func_70661_as()._a(this._c, this._e);
        ++this._d;
        if (this._d >= 60 && this._a.func_70068_e(this._c) < 9.0) {
            this._b();
        }
    }

    public EntityAnimal _a() {
        float f = 8.0f;
        List list2 = this._b.func_72872_a(this._a.getClass(), this._a.field_70121_D._b(f, f, f));
        double d = Double.MAX_VALUE;
        EntityAnimal entityAnimal = null;
        for (EntityAnimal entityAnimal2 : list2) {
            if (!this._a.func_70878_b(entityAnimal2) || !(this._a.func_70068_e(entityAnimal2) < d)) continue;
            entityAnimal = entityAnimal2;
            d = this._a.func_70068_e(entityAnimal2);
        }
        return entityAnimal;
    }

    public void _b() {
        EntityAgeable entityAgeable = this._a.func_90011_a(this._c);
        if (entityAgeable == null) {
            return;
        }
        this._a.func_70873_a(6000);
        this._c.func_70873_a(6000);
        this._a.func_70875_t();
        this._c.func_70875_t();
        entityAgeable.func_70873_a(-24000);
        entityAgeable.func_70012_b(this._a.field_70165_t, this._a.field_70163_u, this._a.field_70161_v, 0.0f, 0.0f);
        this._b.func_72838_d(entityAgeable);
        Random random = this._a.func_70681_au();
        for (int i = 0; i < 7; ++i) {
            double d = random.nextGaussian() * 0.02;
            double d2 = random.nextGaussian() * 0.02;
            double d3 = random.nextGaussian() * 0.02;
            this._b.func_72869_a("heart", this._a.field_70165_t + (double)(random.nextFloat() * this._a.field_70130_N * 2.0f) - (double)this._a.field_70130_N, this._a.field_70163_u + 0.5 + (double)(random.nextFloat() * this._a.field_70131_O), this._a.field_70161_v + (double)(random.nextFloat() * this._a.field_70130_N * 2.0f) - (double)this._a.field_70130_N, d, d2, d3);
        }
        this._b.func_72838_d(new EntityXPOrb(this._b, this._a.field_70165_t, this._a.field_70163_u, this._a.field_70161_v, random.nextInt(7) + 1));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityAnimal;

public class ezfc
extends zwat {
    public EntityAnimal _a;
    public EntityAnimal _b;
    public double _c;
    public int _d;

    public ezfc(EntityAnimal entityAnimal, double d) {
        this._a = entityAnimal;
        this._c = d;
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.func_70874_b() >= 0) {
            return false;
        }
        List list2 = this._a.field_70170_p.func_72872_a(this._a.getClass(), this._a.field_70121_D._b(8.0, 4.0, 8.0));
        EntityAnimal entityAnimal = null;
        double d = Double.MAX_VALUE;
        for (EntityAnimal entityAnimal2 : list2) {
            double d2;
            if (entityAnimal2.func_70874_b() < 0 || (d2 = this._a.func_70068_e(entityAnimal2)) > d) continue;
            d = d2;
            entityAnimal = entityAnimal2;
        }
        if (entityAnimal == null) {
            return false;
        }
        if (d < 9.0) {
            return false;
        }
        this._b = entityAnimal;
        return true;
    }

    @Override
    public boolean func_75253_b() {
        if (!this._b.func_70089_S()) {
            return false;
        }
        double d = this._a.func_70068_e(this._b);
        return !(d < 9.0) && !(d > 256.0);
    }

    @Override
    public void func_75249_e() {
        this._d = 0;
    }

    @Override
    public void func_75251_c() {
        this._b = null;
    }

    @Override
    public void func_75246_d() {
        if (--this._d > 0) {
            return;
        }
        this._d = 10;
        this._a.func_70661_as()._a(this._b, this._c);
    }
}


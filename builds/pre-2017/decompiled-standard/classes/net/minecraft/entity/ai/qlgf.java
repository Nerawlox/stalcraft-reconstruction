/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.monster.EntityCreeper;

public class qlgf
extends zwat {
    public EntityCreeper _a;
    public EntityLivingBase _b;

    public qlgf(EntityCreeper entityCreeper) {
        this._a = entityCreeper;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        EntityLivingBase entityLivingBase = this._a.func_70638_az();
        return this._a.func_70832_p() > 0 || entityLivingBase != null && this._a.func_70068_e(entityLivingBase) < 9.0;
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._h();
        this._b = this._a.func_70638_az();
    }

    @Override
    public void func_75251_c() {
        this._b = null;
    }

    @Override
    public void func_75246_d() {
        if (this._b == null) {
            this._a.func_70829_a(-1);
            return;
        }
        if (this._a.func_70068_e(this._b) > 49.0) {
            this._a.func_70829_a(-1);
            return;
        }
        if (!this._a.func_70635_at()._a(this._b)) {
            this._a.func_70829_a(-1);
            return;
        }
        this._a.func_70829_a(1);
    }
}


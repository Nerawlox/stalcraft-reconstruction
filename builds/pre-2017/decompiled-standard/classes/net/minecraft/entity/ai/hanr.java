/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityTameable;

public class hanr
extends zwat {
    public EntityTameable _a;
    public boolean _b;

    public hanr(EntityTameable entityTameable) {
        this._a = entityTameable;
        this.func_75248_a(5);
    }

    @Override
    public boolean func_75250_a() {
        if (!this._a.func_70909_n()) {
            return false;
        }
        if (this._a.func_70090_H()) {
            return false;
        }
        if (!this._a.field_70122_E) {
            return false;
        }
        EntityLivingBase entityLivingBase = this._a.func_130012_q();
        if (entityLivingBase == null) {
            return true;
        }
        if (this._a.func_70068_e(entityLivingBase) < 144.0 && entityLivingBase.func_70643_av() != null) {
            return false;
        }
        return this._b;
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._h();
        this._a.func_70904_g(true);
    }

    @Override
    public void func_75251_c() {
        this._a.func_70904_g(false);
    }

    public void _a(boolean bl) {
        this._b = bl;
    }
}


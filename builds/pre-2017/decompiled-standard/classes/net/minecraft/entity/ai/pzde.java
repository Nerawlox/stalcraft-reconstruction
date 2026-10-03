/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.gomc;
import net.minecraft.entity.passive.EntityTameable;

public class pzde
extends gomc {
    public EntityTameable _a;
    public EntityLivingBase _b;
    public int _c;

    public pzde(EntityTameable entityTameable) {
        super(entityTameable, false);
        this._a = entityTameable;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (!this._a.func_70909_n()) {
            return false;
        }
        EntityLivingBase entityLivingBase = this._a.func_130012_q();
        if (entityLivingBase == null) {
            return false;
        }
        this._b = entityLivingBase.func_110144_aD();
        int n = entityLivingBase.func_142013_aG();
        return n != this._c && this.func_75296_a(this._b, false) && this._a.func_142018_a(this._b, entityLivingBase);
    }

    @Override
    public void func_75249_e() {
        this.field_75299_d.func_70624_b(this._b);
        EntityLivingBase entityLivingBase = this._a.func_130012_q();
        if (entityLivingBase != null) {
            this._c = entityLivingBase.func_142013_aG();
        }
        super.func_75249_e();
    }
}


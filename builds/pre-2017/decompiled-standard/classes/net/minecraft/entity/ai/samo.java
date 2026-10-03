/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ofbx;

public class samo
extends zwat {
    public EntityVillager _a;
    public EntityLivingBase _b;
    public double _c;
    public int _d;

    public samo(EntityVillager entityVillager, double d) {
        this._a = entityVillager;
        this._c = d;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.func_70874_b() >= 0) {
            return false;
        }
        if (this._a.func_70681_au().nextInt(400) != 0) {
            return false;
        }
        List list = this._a.field_70170_p.func_72872_a(EntityVillager.class, this._a.field_70121_D._b(6.0, 3.0, 6.0));
        double d = Double.MAX_VALUE;
        Object object = list.iterator();
        while (object.hasNext()) {
            double d2;
            EntityVillager entityVillager = (EntityVillager)object.next();
            if (entityVillager == this._a || entityVillager.func_70945_p() || entityVillager.func_70874_b() >= 0 || (d2 = entityVillager.func_70068_e(this._a)) > d) continue;
            d = d2;
            this._b = entityVillager;
        }
        return this._b != null || (object = ofaz._a(this._a, 16, 3)) != null;
    }

    @Override
    public boolean func_75253_b() {
        return this._d > 0;
    }

    @Override
    public void func_75249_e() {
        if (this._b != null) {
            this._a.func_70939_f(true);
        }
        this._d = 1000;
    }

    @Override
    public void func_75251_c() {
        this._a.func_70939_f(false);
        this._b = null;
    }

    @Override
    public void func_75246_d() {
        --this._d;
        if (this._b != null) {
            if (this._a.func_70068_e(this._b) > 4.0) {
                this._a.func_70661_as()._a(this._b, this._c);
            }
        } else if (this._a.func_70661_as()._g()) {
            ofbx ofbx2 = ofaz._a(this._a, 16, 3);
            if (ofbx2 == null) {
                return;
            }
            this._a.func_70661_as()._a(ofbx2._c, ofbx2._d, ofbx2._e, this._c);
        }
    }
}


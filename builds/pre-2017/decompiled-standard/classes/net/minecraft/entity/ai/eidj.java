/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.ezey;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;

public class eidj
extends zwat {
    public final zhos _a = new ezey(this);
    public EntityCreature _b;
    public double _c;
    public double _d;
    public Entity _e;
    public float _f;
    public suqn _g;
    public ujuz _h;
    public Class _i;

    public eidj(EntityCreature entityCreature, Class clazz, float f, double d, double d2) {
        this._b = entityCreature;
        this._i = clazz;
        this._f = f;
        this._c = d;
        this._d = d2;
        this._h = entityCreature.func_70661_as();
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        Object object;
        if (this._i == EntityPlayer.class) {
            if (this._b instanceof EntityTameable && ((EntityTameable)this._b).func_70909_n()) {
                return false;
            }
            this._e = this._b.field_70170_p.func_72890_a(this._b, this._f);
            if (this._e == null) {
                return false;
            }
        } else {
            object = this._b.field_70170_p.func_82733_a(this._i, this._b.field_70121_D._b(this._f, 3.0, this._f), this._a);
            if (object.isEmpty()) {
                return false;
            }
            this._e = (Entity)object.get(0);
        }
        if ((object = ofaz._b(this._b, 16, 7, this._b.field_70170_p.func_82732_R()._a(this._e.field_70165_t, this._e.field_70163_u, this._e.field_70161_v))) == null) {
            return false;
        }
        if (this._e.func_70092_e(((ofbx)object)._c, ((ofbx)object)._d, ((ofbx)object)._e) < this._e.func_70068_e(this._b)) {
            return false;
        }
        this._g = this._h._a(((ofbx)object)._c, ((ofbx)object)._d, ((ofbx)object)._e);
        if (this._g == null) {
            return false;
        }
        return this._g._a((ofbx)object);
    }

    @Override
    public boolean func_75253_b() {
        return !this._h._g();
    }

    @Override
    public void func_75249_e() {
        this._h._a(this._g, this._c);
    }

    @Override
    public void func_75251_c() {
        this._e = null;
    }

    @Override
    public void func_75246_d() {
        if (this._b.func_70068_e(this._e) < 49.0) {
            this._b.func_70661_as()._a(this._d);
        } else {
            this._b.func_70661_as()._a(this._c);
        }
    }

    public static /* synthetic */ EntityCreature _a(eidj eidj2) {
        return eidj2._b;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jgro;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;
import net.minecraft.util.zwat;

public class tupg {
    public final List _a = new ArrayList();
    public final EntityLivingBase _b;
    public int _c;
    public boolean _d;
    public boolean _e;
    public String _f;

    public tupg(EntityLivingBase entityLivingBase) {
        this._b = entityLivingBase;
    }

    public void _a() {
        this._e();
        if (this._b.func_70617_f_()) {
            int n = this._b.field_70170_p.func_72798_a(sajh._c(this._b.field_70165_t), sajh._c(this._b.field_70121_D._c), sajh._c(this._b.field_70161_v));
            if (n == twgu.field_72055_aF.field_71990_ca) {
                this._f = "ladder";
            } else if (n == twgu.field_71998_bu.field_71990_ca) {
                this._f = "vines";
            }
        } else if (this._b.func_70090_H()) {
            this._f = "water";
        }
    }

    public void _a(jxtc jxtc2, float f, float f2) {
        this._f();
        this._a();
        jgro jgro2 = new jgro(jxtc2, this._b.field_70173_aa, f, f2, this._f, this._b.field_70143_R);
        this._a.add(jgro2);
        this._c = this._b.field_70173_aa;
        this._e = true;
        this._d |= jgro2._c();
    }

    public zwat _b() {
        zwat zwat2;
        if (this._a.size() == 0) {
            return zwat._b("death.attack.generic", this._b.func_96090_ax());
        }
        jgro jgro2 = this._d();
        jgro jgro3 = (jgro)this._a.get(this._a.size() - 1);
        String string = jgro3._e();
        Entity entity = jgro3._a().func_76346_g();
        if (jgro2 != null && jgro3._a() == jxtc.field_76379_h) {
            String string2 = jgro2._e();
            if (jgro2._a() == jxtc.field_76379_h || jgro2._a() == jxtc.field_76380_i) {
                zwat2 = zwat._b("death.fell.accident." + this._a(jgro2), this._b.func_96090_ax());
            } else if (!(string2 == null || string != null && string2.equals(string))) {
                cvzo cvzo2;
                Entity entity2 = jgro2._a().func_76346_g();
                cvzo cvzo3 = cvzo2 = entity2 instanceof EntityLivingBase ? ((EntityLivingBase)entity2).func_70694_bm() : null;
                zwat2 = cvzo2 != null && cvzo2._u() ? zwat._b("death.fell.assist.item", this._b.func_96090_ax(), string2, cvzo2._s()) : zwat._b("death.fell.assist", this._b.func_96090_ax(), string2);
            } else if (string != null) {
                cvzo cvzo4;
                cvzo cvzo5 = cvzo4 = entity instanceof EntityLivingBase ? ((EntityLivingBase)entity).func_70694_bm() : null;
                zwat2 = cvzo4 != null && cvzo4._u() ? zwat._b("death.fell.finish.item", this._b.func_96090_ax(), string, cvzo4._s()) : zwat._b("death.fell.finish", this._b.func_96090_ax(), string);
            } else {
                zwat2 = zwat._b("death.fell.killer", this._b.func_96090_ax());
            }
        } else {
            zwat2 = jgro3._a().func_76360_b(this._b);
        }
        return zwat2;
    }

    public EntityLivingBase _c() {
        EntityLivingBase entityLivingBase = null;
        EntityPlayer entityPlayer = null;
        float f = 0.0f;
        float f2 = 0.0f;
        for (jgro jgro2 : this._a) {
            if (jgro2._a().func_76346_g() instanceof EntityPlayer && (entityPlayer == null || jgro2._b() > f2)) {
                f2 = jgro2._b();
                entityPlayer = (EntityPlayer)jgro2._a().func_76346_g();
            }
            if (!(jgro2._a().func_76346_g() instanceof EntityLivingBase) || entityLivingBase != null && !(jgro2._b() > f)) continue;
            f = jgro2._b();
            entityLivingBase = (EntityLivingBase)jgro2._a().func_76346_g();
        }
        if (entityPlayer != null && f2 >= f / 3.0f) {
            return entityPlayer;
        }
        return entityLivingBase;
    }

    public jgro _d() {
        jgro jgro2 = null;
        jgro jgro3 = null;
        int n = 0;
        float f = 0.0f;
        for (int i = 0; i < this._a.size(); ++i) {
            jgro jgro4;
            jgro jgro5 = (jgro)this._a.get(i);
            jgro jgro6 = jgro4 = i > 0 ? (jgro)this._a.get(i - 1) : null;
            if ((jgro5._a() == jxtc.field_76379_h || jgro5._a() == jxtc.field_76380_i) && jgro5._f() > 0.0f && (jgro2 == null || jgro5._f() > f)) {
                jgro2 = i > 0 ? jgro4 : jgro5;
                f = jgro5._f();
            }
            if (jgro5._d() == null || jgro3 != null && !(jgro5._b() > (float)n)) continue;
            jgro3 = jgro5;
        }
        if (f > 5.0f && jgro2 != null) {
            return jgro2;
        }
        if (n > 5 && jgro3 != null) {
            return jgro3;
        }
        return null;
    }

    public String _a(jgro jgro2) {
        return jgro2._d() == null ? "generic" : jgro2._d();
    }

    public void _e() {
        this._f = null;
    }

    public void _f() {
        int n;
        int n2 = n = this._d ? 300 : 100;
        if (this._e && this._b.field_70173_aa - this._c > n) {
            this._a.clear();
            this._e = false;
            this._d = false;
        }
    }
}


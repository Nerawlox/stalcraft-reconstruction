/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import java.util.Calendar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;
import net.minecraft.util.zwaw;

public class EntityBat
extends EntityAmbientCreature {
    public zwaw field_82237_a;

    public EntityBat(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.5f, 0.9f);
        this.func_82236_f(true);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, new Byte(0));
    }

    @Override
    public float func_70599_aP() {
        return 0.1f;
    }

    @Override
    public float func_70647_i() {
        return super.func_70647_i() * 0.95f;
    }

    @Override
    public String func_70639_aQ() {
        if (this.func_82235_h() && this.field_70146_Z.nextInt(4) != 0) {
            return null;
        }
        return "mob.bat.idle";
    }

    @Override
    public String func_70621_aR() {
        return "mob.bat.hurt";
    }

    @Override
    public String func_70673_aS() {
        return "mob.bat.death";
    }

    @Override
    public boolean func_70104_M() {
        return false;
    }

    @Override
    public void func_82167_n(Entity entity) {
    }

    @Override
    public void func_85033_bc() {
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(6.0);
    }

    public boolean func_82235_h() {
        return (this.field_70180_af._a(16) & 1) != 0;
    }

    public void func_82236_f(boolean bl) {
        byte by = this.field_70180_af._a(16);
        if (bl) {
            this.field_70180_af._b(16, (byte)(by | 1));
        } else {
            this.field_70180_af._b(16, (byte)(by & 0xFFFFFFFE));
        }
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.func_82235_h()) {
            this.field_70179_y = 0.0;
            this.field_70181_x = 0.0;
            this.field_70159_w = 0.0;
            this.field_70163_u = (double)sajh._c(this.field_70163_u) + 1.0 - (double)this.field_70131_O;
        } else {
            this.field_70181_x *= (double)0.6f;
        }
    }

    @Override
    public void func_70619_bc() {
        super.func_70619_bc();
        if (this.func_82235_h()) {
            if (!this.field_70170_p.func_72809_s(sajh._c(this.field_70165_t), (int)this.field_70163_u + 1, sajh._c(this.field_70161_v))) {
                this.func_82236_f(false);
                this.field_70170_p.func_72889_a(null, 1015, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            } else {
                if (this.field_70146_Z.nextInt(200) == 0) {
                    this.field_70759_as = this.field_70146_Z.nextInt(360);
                }
                if (this.field_70170_p.func_72890_a(this, 4.0) != null) {
                    this.func_82236_f(false);
                    this.field_70170_p.func_72889_a(null, 1015, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                }
            }
        } else {
            if (!(this.field_82237_a == null || this.field_70170_p.func_72799_c(this.field_82237_a._a, this.field_82237_a._b, this.field_82237_a._c) && this.field_82237_a._b >= 1)) {
                this.field_82237_a = null;
            }
            if (this.field_82237_a == null || this.field_70146_Z.nextInt(30) == 0 || this.field_82237_a._b((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 4.0f) {
                this.field_82237_a = new zwaw((int)this.field_70165_t + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7), (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - 2, (int)this.field_70161_v + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7));
            }
            double d = (double)this.field_82237_a._a + 0.5 - this.field_70165_t;
            double d2 = (double)this.field_82237_a._b + 0.1 - this.field_70163_u;
            double d3 = (double)this.field_82237_a._c + 0.5 - this.field_70161_v;
            this.field_70159_w += (Math.signum(d) * 0.5 - this.field_70159_w) * (double)0.1f;
            this.field_70181_x += (Math.signum(d2) * (double)0.7f - this.field_70181_x) * (double)0.1f;
            this.field_70179_y += (Math.signum(d3) * 0.5 - this.field_70179_y) * (double)0.1f;
            float f = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.1415927410125732) - 90.0f;
            float f2 = sajh._g(f - this.field_70177_z);
            this.field_70701_bs = 0.5f;
            this.field_70177_z += f2;
            if (this.field_70146_Z.nextInt(100) == 0 && this.field_70170_p.func_72809_s(sajh._c(this.field_70165_t), (int)this.field_70163_u + 1, sajh._c(this.field_70161_v))) {
                this.func_82236_f(true);
            }
        }
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public void func_70069_a(float f) {
    }

    @Override
    public void func_70064_a(double d, boolean bl) {
    }

    @Override
    public boolean func_82144_au() {
        return true;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        if (!this.field_70170_p.field_72995_K && this.func_82235_h()) {
            this.func_82236_f(false);
        }
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.field_70180_af._b(16, qoac2._d("BatFlags"));
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("BatFlags", this.field_70180_af._a(16));
    }

    @Override
    public boolean func_70601_bi() {
        int n = sajh._c(this.field_70121_D._c);
        if (n >= 63) {
            return false;
        }
        int n2 = sajh._c(this.field_70165_t);
        int n3 = sajh._c(this.field_70161_v);
        int n4 = this.field_70170_p.func_72957_l(n2, n, n3);
        int n5 = 4;
        Calendar calendar = this.field_70170_p.func_83015_S();
        if (calendar.get(2) + 1 == 10 && calendar.get(5) >= 20 || calendar.get(2) + 1 == 11 && calendar.get(5) <= 3) {
            n5 = 7;
        } else if (this.field_70146_Z.nextBoolean()) {
            return false;
        }
        if (n4 > this.field_70146_Z.nextInt(n5)) {
            return false;
        }
        return super.func_70601_bi();
    }
}


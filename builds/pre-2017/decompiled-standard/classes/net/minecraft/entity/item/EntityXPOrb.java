/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityXPOrb
extends Entity {
    public int field_70533_a;
    public int field_70531_b;
    public int field_70532_c;
    public int field_70529_d = 5;
    public int field_70530_e;
    public EntityPlayer field_80001_f;
    public int field_80002_g;

    public EntityXPOrb(ozlu ozlu2, double d, double d2, double d3, int n) {
        super(ozlu2);
        this.func_70105_a(0.5f, 0.5f);
        this.field_70129_M = this.field_70131_O / 2.0f;
        this.func_70107_b(d, d2, d3);
        this.field_70177_z = (float)(Math.random() * 360.0);
        this.field_70159_w = (float)(Math.random() * (double)0.2f - (double)0.1f) * 2.0f;
        this.field_70181_x = (float)(Math.random() * 0.2) * 2.0f;
        this.field_70179_y = (float)(Math.random() * (double)0.2f - (double)0.1f) * 2.0f;
        this.field_70530_e = n;
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    public EntityXPOrb(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.25f, 0.25f);
        this.field_70129_M = this.field_70131_O / 2.0f;
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public int func_70070_b(float f) {
        float f2 = 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        int n = super.func_70070_b(f);
        int n2 = n & 0xFF;
        int n3 = n >> 16 & 0xFF;
        if ((n2 += (int)(f2 * 15.0f * 16.0f)) > 240) {
            n2 = 240;
        }
        return n2 | n3 << 16;
    }

    @Override
    public void func_70071_h_() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        super.func_70071_h_();
        if (this.field_70532_c > 0) {
            --this.field_70532_c;
        }
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70181_x -= (double)0.03f;
        if (this.field_70170_p.func_72803_f(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)) == tflj._i) {
            this.field_70181_x = 0.2f;
            this.field_70159_w = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f;
            this.field_70179_y = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f;
            this.func_85030_a("random.fizz", 0.4f, 2.0f + this.field_70146_Z.nextFloat() * 0.4f);
        }
        this.func_70048_i(this.field_70165_t, (this.field_70121_D._c + this.field_70121_D._f) / 2.0, this.field_70161_v);
        double d6 = 8.0;
        if (this.field_80002_g < this.field_70533_a - 20 + this.field_70157_k % 100) {
            if (this.field_80001_f == null || this.field_80001_f.func_70068_e(this) > d6 * d6) {
                this.field_80001_f = this.field_70170_p.func_72890_a(this, d6);
            }
            this.field_80002_g = this.field_70533_a;
        }
        if (this.field_80001_f != null && (d5 = 1.0 - (d4 = Math.sqrt((d3 = (this.field_80001_f.field_70165_t - this.field_70165_t) / d6) * d3 + (d2 = (this.field_80001_f.field_70163_u + (double)this.field_80001_f.func_70047_e() - this.field_70163_u) / d6) * d2 + (d = (this.field_80001_f.field_70161_v - this.field_70161_v) / d6) * d))) > 0.0) {
            d5 *= d5;
            this.field_70159_w += d3 / d4 * d5 * 0.1;
            this.field_70181_x += d2 / d4 * d5 * 0.1;
            this.field_70179_y += d / d4 * d5 * 0.1;
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        float f = 0.98f;
        if (this.field_70122_E) {
            f = 0.58800006f;
            int n = this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70121_D._c) - 1, sajh._c(this.field_70161_v));
            if (n > 0) {
                f = twgu.field_71973_m[n].field_72016_cq * 0.98f;
            }
        }
        this.field_70159_w *= (double)f;
        this.field_70181_x *= (double)0.98f;
        this.field_70179_y *= (double)f;
        if (this.field_70122_E) {
            this.field_70181_x *= (double)-0.9f;
        }
        ++this.field_70533_a;
        ++this.field_70531_b;
        if (this.field_70531_b >= 6000) {
            this.func_70106_y();
        }
    }

    @Override
    public boolean func_70072_I() {
        return this.field_70170_p.func_72918_a(this.field_70121_D, tflj._h, this);
    }

    @Override
    public void func_70081_e(int n) {
        this.func_70097_a(jxtc.field_76372_a, n);
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        this.func_70018_K();
        this.field_70529_d = (int)((float)this.field_70529_d - f);
        if (this.field_70529_d <= 0) {
            this.func_70106_y();
        }
        return false;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("Health", (short)((byte)this.field_70529_d));
        qoac2._a("Age", (short)this.field_70531_b);
        qoac2._a("Value", (short)this.field_70530_e);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        this.field_70529_d = qoac2._e("Health") & 0xFF;
        this.field_70531_b = qoac2._e("Age");
        this.field_70530_e = qoac2._e("Value");
    }

    @Override
    public void func_70100_b_(EntityPlayer entityPlayer) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.field_70532_c == 0 && entityPlayer.field_71090_bL == 0) {
            entityPlayer.field_71090_bL = 2;
            this.func_85030_a("random.orb", 0.1f, 0.5f * ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.8f));
            entityPlayer.func_71001_a(this, 1);
            entityPlayer.func_71023_q(this.field_70530_e);
            this.func_70106_y();
        }
    }

    public int func_70526_d() {
        return this.field_70530_e;
    }

    public int func_70528_g() {
        if (this.field_70530_e >= 2477) {
            return 10;
        }
        if (this.field_70530_e >= 1237) {
            return 9;
        }
        if (this.field_70530_e >= 617) {
            return 8;
        }
        if (this.field_70530_e >= 307) {
            return 7;
        }
        if (this.field_70530_e >= 149) {
            return 6;
        }
        if (this.field_70530_e >= 73) {
            return 5;
        }
        if (this.field_70530_e >= 37) {
            return 4;
        }
        if (this.field_70530_e >= 17) {
            return 3;
        }
        if (this.field_70530_e >= 7) {
            return 2;
        }
        if (this.field_70530_e >= 3) {
            return 1;
        }
        return 0;
    }

    public static int func_70527_a(int n) {
        if (n >= 2477) {
            return 2477;
        }
        if (n >= 1237) {
            return 1237;
        }
        if (n >= 617) {
            return 617;
        }
        if (n >= 307) {
            return 307;
        }
        if (n >= 149) {
            return 149;
        }
        if (n >= 73) {
            return 73;
        }
        if (n >= 37) {
            return 37;
        }
        if (n >= 17) {
            return 17;
        }
        if (n >= 7) {
            return 7;
        }
        if (n >= 3) {
            return 3;
        }
        return 1;
    }

    @Override
    public boolean func_70075_an() {
        return false;
    }
}


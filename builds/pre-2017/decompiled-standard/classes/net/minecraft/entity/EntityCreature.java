/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.sajz;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.zwaw;

public abstract class EntityCreature
extends EntityLiving {
    public static final UUID field_110179_h = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
    public static final xson field_110181_i = new xson(field_110179_h, "Fleeing speed bonus", 2.0, 2)._a(false);
    public suqn field_70786_d;
    public Entity field_70789_a;
    public boolean field_70787_b;
    public int field_70788_c;
    public zwaw field_70775_bC = new zwaw(0, 0, 0);
    public float field_70772_bD = -1.0f;
    public zwat field_110178_bs = new amxi(this, 1.0);
    public boolean field_110180_bt;

    public EntityCreature(ozlu ozlu2) {
        super(ozlu2);
    }

    public boolean func_70780_i() {
        return false;
    }

    @Override
    public void func_70626_be() {
        this.field_70170_p.field_72984_F._a("ai");
        if (this.field_70788_c > 0 && --this.field_70788_c == 0) {
            hubf hubf2 = this.func_110148_a(sajz._d);
            hubf2._b(field_110181_i);
        }
        this.field_70787_b = this.func_70780_i();
        float f = 16.0f;
        if (this.field_70789_a == null) {
            this.field_70789_a = this.func_70782_k();
            if (this.field_70789_a != null) {
                this.field_70786_d = this.field_70170_p.func_72865_a(this, this.field_70789_a, f, true, false, false, true);
            }
        } else if (this.field_70789_a.func_70089_S()) {
            float f2 = this.field_70789_a.func_70032_d(this);
            if (this.func_70685_l(this.field_70789_a)) {
                this.func_70785_a(this.field_70789_a, f2);
            }
        } else {
            this.field_70789_a = null;
        }
        this.field_70170_p.field_72984_F._b();
        if (!(this.field_70787_b || this.field_70789_a == null || this.field_70786_d != null && this.field_70146_Z.nextInt(20) != 0)) {
            this.field_70786_d = this.field_70170_p.func_72865_a(this, this.field_70789_a, f, true, false, false, true);
        } else if (!this.field_70787_b && (this.field_70786_d == null && this.field_70146_Z.nextInt(180) == 0 || this.field_70146_Z.nextInt(120) == 0 || this.field_70788_c > 0) && this.field_70708_bq < 100) {
            this.func_70779_j();
        }
        int n = sajh._c(this.field_70121_D._c + 0.5);
        boolean bl = this.func_70090_H();
        boolean bl2 = this.func_70058_J();
        this.field_70125_A = 0.0f;
        if (this.field_70786_d == null || this.field_70146_Z.nextInt(100) == 0) {
            super.func_70626_be();
            this.field_70786_d = null;
            return;
        }
        this.field_70170_p.field_72984_F._a("followpath");
        ofbx ofbx2 = this.field_70786_d._a(this);
        double d = this.field_70130_N * 2.0f;
        while (ofbx2 != null && ofbx2._d(this.field_70165_t, ofbx2._d, this.field_70161_v) < d * d) {
            this.field_70786_d._d();
            if (this.field_70786_d._e()) {
                ofbx2 = null;
                this.field_70786_d = null;
                continue;
            }
            ofbx2 = this.field_70786_d._a(this);
        }
        this.field_70703_bu = false;
        if (ofbx2 != null) {
            double d2 = ofbx2._c - this.field_70165_t;
            double d3 = ofbx2._e - this.field_70161_v;
            double d4 = ofbx2._d - (double)n;
            float f3 = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            float f4 = sajh._g(f3 - this.field_70177_z);
            this.field_70701_bs = (float)this.func_110148_a(sajz._d)._e();
            if (f4 > 30.0f) {
                f4 = 30.0f;
            }
            if (f4 < -30.0f) {
                f4 = -30.0f;
            }
            this.field_70177_z += f4;
            if (this.field_70787_b && this.field_70789_a != null) {
                double d5 = this.field_70789_a.field_70165_t - this.field_70165_t;
                double d6 = this.field_70789_a.field_70161_v - this.field_70161_v;
                float f5 = this.field_70177_z;
                this.field_70177_z = (float)(Math.atan2(d6, d5) * 180.0 / 3.1415927410125732) - 90.0f;
                f4 = (f5 - this.field_70177_z + 90.0f) * (float)Math.PI / 180.0f;
                this.field_70702_br = -sajh._a(f4) * this.field_70701_bs * 1.0f;
                this.field_70701_bs = sajh._b(f4) * this.field_70701_bs * 1.0f;
            }
            if (d4 > 0.0) {
                this.field_70703_bu = true;
            }
        }
        if (this.field_70789_a != null) {
            this.func_70625_a(this.field_70789_a, 30.0f, 30.0f);
        }
        if (this.field_70123_F && !this.func_70781_l()) {
            this.field_70703_bu = true;
        }
        if (this.field_70146_Z.nextFloat() < 0.8f && (bl || bl2)) {
            this.field_70703_bu = true;
        }
        this.field_70170_p.field_72984_F._b();
    }

    public void func_70779_j() {
        this.field_70170_p.field_72984_F._a("stroll");
        boolean bl = false;
        int n = -1;
        int n2 = -1;
        int n3 = -1;
        float f = -99999.0f;
        for (int i = 0; i < 10; ++i) {
            int n4;
            int n5;
            int n6 = sajh._c(this.field_70165_t + (double)this.field_70146_Z.nextInt(13) - 6.0);
            float f2 = this.func_70783_a(n6, n5 = sajh._c(this.field_70163_u + (double)this.field_70146_Z.nextInt(7) - 3.0), n4 = sajh._c(this.field_70161_v + (double)this.field_70146_Z.nextInt(13) - 6.0));
            if (!(f2 > f)) continue;
            f = f2;
            n = n6;
            n2 = n5;
            n3 = n4;
            bl = true;
        }
        if (bl) {
            this.field_70786_d = this.field_70170_p.func_72844_a(this, n, n2, n3, 10.0f, true, false, false, true);
        }
        this.field_70170_p.field_72984_F._b();
    }

    public void func_70785_a(Entity entity, float f) {
    }

    public float func_70783_a(int n, int n2, int n3) {
        return 0.0f;
    }

    public Entity func_70782_k() {
        return null;
    }

    @Override
    public boolean func_70601_bi() {
        int n = sajh._c(this.field_70165_t);
        int n2 = sajh._c(this.field_70121_D._c);
        int n3 = sajh._c(this.field_70161_v);
        return super.func_70601_bi() && this.func_70783_a(n, n2, n3) >= 0.0f;
    }

    public boolean func_70781_l() {
        return this.field_70786_d != null;
    }

    public void func_70778_a(suqn suqn2) {
        this.field_70786_d = suqn2;
    }

    public Entity func_70777_m() {
        return this.field_70789_a;
    }

    public void func_70784_b(Entity entity) {
        this.field_70789_a = entity;
    }

    public boolean func_110173_bK() {
        return this.func_110176_b(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v));
    }

    public boolean func_110176_b(int n, int n2, int n3) {
        if (this.field_70772_bD == -1.0f) {
            return true;
        }
        return this.field_70775_bC._b(n, n2, n3) < this.field_70772_bD * this.field_70772_bD;
    }

    public void func_110171_b(int n, int n2, int n3, int n4) {
        this.field_70775_bC._a(n, n2, n3);
        this.field_70772_bD = n4;
    }

    public zwaw func_110172_bL() {
        return this.field_70775_bC;
    }

    public float func_110174_bM() {
        return this.field_70772_bD;
    }

    public void func_110177_bN() {
        this.field_70772_bD = -1.0f;
    }

    public boolean func_110175_bO() {
        return this.field_70772_bD != -1.0f;
    }

    @Override
    public void func_110159_bB() {
        super.func_110159_bB();
        if (this.func_110167_bD() && this.func_110166_bE() != null && this.func_110166_bE().field_70170_p == this.field_70170_p) {
            Entity entity = this.func_110166_bE();
            this.func_110171_b((int)entity.field_70165_t, (int)entity.field_70163_u, (int)entity.field_70161_v, 5);
            float f = this.func_70032_d(entity);
            if (this instanceof EntityTameable && ((EntityTameable)this).func_70906_o()) {
                if (f > 10.0f) {
                    this.func_110160_i(true, true);
                }
                return;
            }
            if (!this.field_110180_bt) {
                this.field_70714_bg._a(2, this.field_110178_bs);
                this.func_70661_as()._a(false);
                this.field_110180_bt = true;
            }
            this.func_142017_o(f);
            if (f > 4.0f) {
                this.func_70661_as()._a(entity, 1.0);
            }
            if (f > 6.0f) {
                double d = (entity.field_70165_t - this.field_70165_t) / (double)f;
                double d2 = (entity.field_70163_u - this.field_70163_u) / (double)f;
                double d3 = (entity.field_70161_v - this.field_70161_v) / (double)f;
                this.field_70159_w += d * Math.abs(d) * 0.4;
                this.field_70181_x += d2 * Math.abs(d2) * 0.4;
                this.field_70179_y += d3 * Math.abs(d3) * 0.4;
            }
            if (f > 10.0f) {
                this.func_110160_i(true, true);
            }
        } else if (!this.func_110167_bD() && this.field_110180_bt) {
            this.field_110180_bt = false;
            this.field_70714_bg._a(this.field_110178_bs);
            this.func_70661_as()._a(true);
            this.func_110177_bN();
        }
    }

    public void func_142017_o(float f) {
    }
}


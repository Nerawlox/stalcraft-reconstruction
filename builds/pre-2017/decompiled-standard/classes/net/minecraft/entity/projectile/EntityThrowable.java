/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.owak;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public abstract class EntityThrowable
extends Entity
implements owak {
    public int field_70189_d = -1;
    public int field_70190_e = -1;
    public int field_70187_f = -1;
    public int field_70188_g;
    public boolean field_70193_a;
    public int field_70191_b;
    public EntityLivingBase field_70192_c;
    public String field_85053_h;
    public int field_70194_h;
    public int field_70195_i;

    public EntityThrowable(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.25f, 0.25f);
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public boolean func_70112_a(double d) {
        double d2 = this.field_70121_D._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public EntityThrowable(ozlu ozlu2, EntityLivingBase entityLivingBase) {
        super(ozlu2);
        this.field_70192_c = entityLivingBase;
        this.func_70105_a(0.25f, 0.25f);
        this.func_70012_b(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e(), entityLivingBase.field_70161_v, entityLivingBase.field_70177_z, entityLivingBase.field_70125_A);
        this.field_70165_t -= (double)(sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * 0.16f);
        this.field_70163_u -= (double)0.1f;
        this.field_70161_v -= (double)(sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * 0.16f);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0f;
        float f = 0.4f;
        this.field_70159_w = -sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI) * f;
        this.field_70179_y = sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI) * f;
        this.field_70181_x = -sajh._a((this.field_70125_A + this.func_70183_g()) / 180.0f * (float)Math.PI) * f;
        this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.func_70182_d(), 1.0f);
    }

    public EntityThrowable(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2);
        this.field_70194_h = 0;
        this.func_70105_a(0.25f, 0.25f);
        this.func_70107_b(d, d2, d3);
        this.field_70129_M = 0.0f;
    }

    public float func_70182_d() {
        return 1.5f;
    }

    public float func_70183_g() {
        return 0.0f;
    }

    @Override
    public void func_70186_c(double d, double d2, double d3, float f, float f2) {
        float f3 = sajh._a(d * d + d2 * d2 + d3 * d3);
        d /= (double)f3;
        d2 /= (double)f3;
        d3 /= (double)f3;
        d += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)f2;
        d2 += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)f2;
        d3 += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)f2;
        this.field_70159_w = d *= (double)f;
        this.field_70181_x = d2 *= (double)f;
        this.field_70179_y = d3 *= (double)f;
        float f4 = sajh._a(d * d + d3 * d3);
        this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
        this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d2, f4) * 180.0 / 3.1415927410125732);
        this.field_70194_h = 0;
    }

    @Override
    public void func_70016_h(double d, double d2, double d3) {
        this.field_70159_w = d;
        this.field_70181_x = d2;
        this.field_70179_y = d3;
        if (this.field_70127_C == 0.0f && this.field_70126_B == 0.0f) {
            float f = sajh._a(d * d + d3 * d3);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d2, f) * 180.0 / 3.1415927410125732);
        }
    }

    @Override
    public void func_70071_h_() {
        this.field_70142_S = this.field_70165_t;
        this.field_70137_T = this.field_70163_u;
        this.field_70136_U = this.field_70161_v;
        super.func_70071_h_();
        if (this.field_70191_b > 0) {
            --this.field_70191_b;
        }
        if (this.field_70193_a) {
            int n = this.field_70170_p.func_72798_a(this.field_70189_d, this.field_70190_e, this.field_70187_f);
            if (n == this.field_70188_g) {
                ++this.field_70194_h;
                if (this.field_70194_h == 1200) {
                    this.func_70106_y();
                }
                return;
            }
            this.field_70193_a = false;
            this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70194_h = 0;
            this.field_70195_i = 0;
        } else {
            ++this.field_70195_i;
        }
        ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        hank hank2 = this.field_70170_p.func_72933_a(ofbx2, ofbx3);
        ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        if (hank2 != null) {
            ofbx3 = this.field_70170_p.func_82732_R()._a(hank2._h._c, hank2._h._d, hank2._h._e);
        }
        if (!this.field_70170_p.field_72995_K) {
            Entity entity = null;
            List list2 = this.field_70170_p.func_72839_b(this, this.field_70121_D._a(this.field_70159_w, this.field_70181_x, this.field_70179_y)._b(1.0, 1.0, 1.0));
            double d = 0.0;
            EntityLivingBase entityLivingBase = this.func_85052_h();
            for (int i = 0; i < list2.size(); ++i) {
                double d2;
                float f;
                eidj eidj2;
                hank hank3;
                Entity entity2 = (Entity)list2.get(i);
                if (!entity2.func_70067_L() || entity2 == entityLivingBase && this.field_70195_i < 5 || (hank3 = (eidj2 = entity2.field_70121_D._b(f = 0.3f, f, f))._a(ofbx2, ofbx3)) == null || !((d2 = ofbx2._d(hank3._h)) < d) && d != 0.0) continue;
                entity = entity2;
                d = d2;
            }
            if (entity != null) {
                hank2 = new hank(entity);
            }
        }
        if (hank2 != null) {
            if (hank2._c == amww._a && this.field_70170_p.func_72798_a(hank2._d, hank2._e, hank2._f) == twgu.field_72015_be.field_71990_ca) {
                this.func_70063_aa();
            } else {
                this.func_70184_a(hank2);
            }
        }
        this.field_70165_t += this.field_70159_w;
        this.field_70163_u += this.field_70181_x;
        this.field_70161_v += this.field_70179_y;
        float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / 3.1415927410125732);
        this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0 / 3.1415927410125732);
        while (this.field_70125_A - this.field_70127_C < -180.0f) {
            this.field_70127_C -= 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C >= 180.0f) {
            this.field_70127_C += 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B < -180.0f) {
            this.field_70126_B -= 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B >= 180.0f) {
            this.field_70126_B += 360.0f;
        }
        this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2f;
        this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2f;
        float f2 = 0.99f;
        float f3 = this.func_70185_h();
        if (this.func_70090_H()) {
            for (int i = 0; i < 4; ++i) {
                float f4 = 0.25f;
                this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)f4, this.field_70163_u - this.field_70181_x * (double)f4, this.field_70161_v - this.field_70179_y * (double)f4, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
            f2 = 0.8f;
        }
        this.field_70159_w *= (double)f2;
        this.field_70181_x *= (double)f2;
        this.field_70179_y *= (double)f2;
        this.field_70181_x -= (double)f3;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    public float func_70185_h() {
        return 0.03f;
    }

    public abstract void func_70184_a(hank var1);

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("xTile", (short)this.field_70189_d);
        qoac2._a("yTile", (short)this.field_70190_e);
        qoac2._a("zTile", (short)this.field_70187_f);
        qoac2._a("inTile", (byte)this.field_70188_g);
        qoac2._a("shake", (byte)this.field_70191_b);
        qoac2._a("inGround", (byte)(this.field_70193_a ? 1 : 0));
        if ((this.field_85053_h == null || this.field_85053_h.length() == 0) && this.field_70192_c != null && this.field_70192_c instanceof EntityPlayer) {
            this.field_85053_h = this.field_70192_c.func_70023_ak();
        }
        qoac2._a("ownerName", this.field_85053_h == null ? "" : this.field_85053_h);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        this.field_70189_d = qoac2._e("xTile");
        this.field_70190_e = qoac2._e("yTile");
        this.field_70187_f = qoac2._e("zTile");
        this.field_70188_g = qoac2._d("inTile") & 0xFF;
        this.field_70191_b = qoac2._d("shake") & 0xFF;
        this.field_70193_a = qoac2._d("inGround") == 1;
        this.field_85053_h = qoac2._j("ownerName");
        if (this.field_85053_h != null && this.field_85053_h.length() == 0) {
            this.field_85053_h = null;
        }
    }

    @Override
    public float func_70053_R() {
        return 0.0f;
    }

    public EntityLivingBase func_85052_h() {
        if (this.field_70192_c == null && this.field_85053_h != null && this.field_85053_h.length() > 0) {
            this.field_70192_c = this.field_70170_p.func_72924_a(this.field_85053_h);
        }
        return this.field_70192_c;
    }
}


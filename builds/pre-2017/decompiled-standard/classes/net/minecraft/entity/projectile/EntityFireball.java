/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public abstract class EntityFireball
extends Entity {
    public int field_70231_e = -1;
    public int field_70228_f = -1;
    public int field_70229_g = -1;
    public int field_70237_h;
    public boolean field_70238_i;
    public EntityLivingBase field_70235_a;
    public int field_70236_j;
    public int field_70234_an;
    public double field_70232_b;
    public double field_70233_c;
    public double field_70230_d;

    public EntityFireball(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(1.0f, 1.0f);
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public boolean func_70112_a(double d) {
        double d2 = this.field_70121_D._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public EntityFireball(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2);
        this.func_70105_a(1.0f, 1.0f);
        this.func_70012_b(d, d2, d3, this.field_70177_z, this.field_70125_A);
        this.func_70107_b(d, d2, d3);
        double d7 = sajh._a(d4 * d4 + d5 * d5 + d6 * d6);
        this.field_70232_b = d4 / d7 * 0.1;
        this.field_70233_c = d5 / d7 * 0.1;
        this.field_70230_d = d6 / d7 * 0.1;
    }

    public EntityFireball(ozlu ozlu2, EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super(ozlu2);
        this.field_70235_a = entityLivingBase;
        this.func_70105_a(1.0f, 1.0f);
        this.func_70012_b(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v, entityLivingBase.field_70177_z, entityLivingBase.field_70125_A);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0f;
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.field_70159_w = 0.0;
        double d4 = sajh._a((d += this.field_70146_Z.nextGaussian() * 0.4) * d + (d2 += this.field_70146_Z.nextGaussian() * 0.4) * d2 + (d3 += this.field_70146_Z.nextGaussian() * 0.4) * d3);
        this.field_70232_b = d / d4 * 0.1;
        this.field_70233_c = d2 / d4 * 0.1;
        this.field_70230_d = d3 / d4 * 0.1;
    }

    @Override
    public void func_70071_h_() {
        if (!this.field_70170_p.field_72995_K && (this.field_70235_a != null && this.field_70235_a.field_70128_L || !this.field_70170_p.func_72899_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v))) {
            this.func_70106_y();
            return;
        }
        super.func_70071_h_();
        this.func_70015_d(1);
        if (this.field_70238_i) {
            int n = this.field_70170_p.func_72798_a(this.field_70231_e, this.field_70228_f, this.field_70229_g);
            if (n == this.field_70237_h) {
                ++this.field_70236_j;
                if (this.field_70236_j == 600) {
                    this.func_70106_y();
                }
                return;
            }
            this.field_70238_i = false;
            this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
            this.field_70236_j = 0;
            this.field_70234_an = 0;
        } else {
            ++this.field_70234_an;
        }
        ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        hank hank2 = this.field_70170_p.func_72933_a(ofbx2, ofbx3);
        ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx3 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        if (hank2 != null) {
            ofbx3 = this.field_70170_p.func_82732_R()._a(hank2._h._c, hank2._h._d, hank2._h._e);
        }
        Entity entity = null;
        List list2 = this.field_70170_p.func_72839_b(this, this.field_70121_D._a(this.field_70159_w, this.field_70181_x, this.field_70179_y)._b(1.0, 1.0, 1.0));
        double d = 0.0;
        for (int i = 0; i < list2.size(); ++i) {
            double d2;
            float f;
            eidj eidj2;
            hank hank3;
            Entity entity2 = (Entity)list2.get(i);
            if (!entity2.func_70067_L() || entity2.func_70028_i(this.field_70235_a) && this.field_70234_an < 25 || (hank3 = (eidj2 = entity2.field_70121_D._b(f = 0.3f, f, f))._a(ofbx2, ofbx3)) == null || !((d2 = ofbx2._d(hank3._h)) < d) && d != 0.0) continue;
            entity = entity2;
            d = d2;
        }
        if (entity != null) {
            hank2 = new hank(entity);
        }
        if (hank2 != null) {
            this.func_70227_a(hank2);
        }
        this.field_70165_t += this.field_70159_w;
        this.field_70163_u += this.field_70181_x;
        this.field_70161_v += this.field_70179_y;
        float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        this.field_70177_z = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.1415927410125732) + 90.0f;
        this.field_70125_A = (float)(Math.atan2(f, this.field_70181_x) * 180.0 / 3.1415927410125732) - 90.0f;
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
        float f2 = this.func_82341_c();
        if (this.func_70090_H()) {
            for (int i = 0; i < 4; ++i) {
                float f3 = 0.25f;
                this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)f3, this.field_70163_u - this.field_70181_x * (double)f3, this.field_70161_v - this.field_70179_y * (double)f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
            f2 = 0.8f;
        }
        this.field_70159_w += this.field_70232_b;
        this.field_70181_x += this.field_70233_c;
        this.field_70179_y += this.field_70230_d;
        this.field_70159_w *= (double)f2;
        this.field_70181_x *= (double)f2;
        this.field_70179_y *= (double)f2;
        this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5, this.field_70161_v, 0.0, 0.0, 0.0);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    public float func_82341_c() {
        return 0.95f;
    }

    public abstract void func_70227_a(hank var1);

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("xTile", (short)this.field_70231_e);
        qoac2._a("yTile", (short)this.field_70228_f);
        qoac2._a("zTile", (short)this.field_70229_g);
        qoac2._a("inTile", (byte)this.field_70237_h);
        qoac2._a("inGround", (byte)(this.field_70238_i ? 1 : 0));
        qoac2._a("direction", this.func_70087_a(this.field_70159_w, this.field_70181_x, this.field_70179_y));
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        this.field_70231_e = qoac2._e("xTile");
        this.field_70228_f = qoac2._e("yTile");
        this.field_70229_g = qoac2._e("zTile");
        this.field_70237_h = qoac2._d("inTile") & 0xFF;
        boolean bl = this.field_70238_i = qoac2._d("inGround") == 1;
        if (qoac2._c("direction")) {
            bsyv bsyv2 = qoac2._n("direction");
            this.field_70159_w = ((qoae)bsyv2._b((int)0))._c;
            this.field_70181_x = ((qoae)bsyv2._b((int)1))._c;
            this.field_70179_y = ((qoae)bsyv2._b((int)2))._c;
        } else {
            this.func_70106_y();
        }
    }

    @Override
    public boolean func_70067_L() {
        return true;
    }

    @Override
    public float func_70111_Y() {
        return 1.0f;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        this.func_70018_K();
        if (jxtc2.func_76346_g() != null) {
            ofbx ofbx2 = jxtc2.func_76346_g().func_70040_Z();
            if (ofbx2 != null) {
                this.field_70159_w = ofbx2._c;
                this.field_70181_x = ofbx2._d;
                this.field_70179_y = ofbx2._e;
                this.field_70232_b = this.field_70159_w * 0.1;
                this.field_70233_c = this.field_70181_x * 0.1;
                this.field_70230_d = this.field_70179_y * 0.1;
            }
            if (jxtc2.func_76346_g() instanceof EntityLivingBase) {
                this.field_70235_a = (EntityLivingBase)jxtc2.func_76346_g();
            }
            return true;
        }
        return false;
    }

    @Override
    public float func_70053_R() {
        return 0.0f;
    }

    @Override
    public float func_70013_c(float f) {
        return 1.0f;
    }

    @Override
    public int func_70070_b(float f) {
        return 0xF000F0;
    }
}


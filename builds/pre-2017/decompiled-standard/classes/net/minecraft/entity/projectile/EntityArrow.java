/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.owak;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class EntityArrow
extends Entity
implements owak {
    public int field_70247_d = -1;
    public int field_70248_e = -1;
    public int field_70245_f = -1;
    public int field_70246_g;
    public int field_70253_h;
    public boolean field_70254_i;
    public int field_70251_a;
    public int field_70249_b;
    public Entity field_70250_c;
    public int field_70252_j;
    public int field_70257_an;
    public double field_70255_ao = 2.0;
    public int field_70256_ap;

    public EntityArrow(ozlu ozlu2) {
        super(ozlu2);
        this.field_70155_l = 10.0;
        this.func_70105_a(0.5f, 0.5f);
    }

    public EntityArrow(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2);
        this.field_70155_l = 10.0;
        this.func_70105_a(0.5f, 0.5f);
        this.func_70107_b(d, d2, d3);
        this.field_70129_M = 0.0f;
    }

    public EntityArrow(ozlu ozlu2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2, float f, float f2) {
        super(ozlu2);
        this.field_70155_l = 10.0;
        this.field_70250_c = entityLivingBase;
        if (entityLivingBase instanceof EntityPlayer) {
            this.field_70251_a = 1;
        }
        this.field_70163_u = entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e() - (double)0.1f;
        double d = entityLivingBase2.field_70165_t - entityLivingBase.field_70165_t;
        double d2 = entityLivingBase2.field_70121_D._c + (double)(entityLivingBase2.field_70131_O / 3.0f) - this.field_70163_u;
        double d3 = entityLivingBase2.field_70161_v - entityLivingBase.field_70161_v;
        double d4 = sajh._a(d * d + d3 * d3);
        if (d4 < 1.0E-7) {
            return;
        }
        float f3 = (float)(Math.atan2(d3, d) * 180.0 / 3.1415927410125732) - 90.0f;
        float f4 = (float)(-(Math.atan2(d2, d4) * 180.0 / 3.1415927410125732));
        double d5 = d / d4;
        double d6 = d3 / d4;
        this.func_70012_b(entityLivingBase.field_70165_t + d5, this.field_70163_u, entityLivingBase.field_70161_v + d6, f3, f4);
        this.field_70129_M = 0.0f;
        float f5 = (float)d4 * 0.2f;
        this.func_70186_c(d, d2 + (double)f5, d3, f, f2);
    }

    public EntityArrow(ozlu ozlu2, EntityLivingBase entityLivingBase, float f) {
        super(ozlu2);
        this.field_70155_l = 10.0;
        this.field_70250_c = entityLivingBase;
        if (entityLivingBase instanceof EntityPlayer) {
            this.field_70251_a = 1;
        }
        this.func_70105_a(0.5f, 0.5f);
        this.func_70012_b(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e(), entityLivingBase.field_70161_v, entityLivingBase.field_70177_z, entityLivingBase.field_70125_A);
        this.field_70165_t -= (double)(sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * 0.16f);
        this.field_70163_u -= (double)0.1f;
        this.field_70161_v -= (double)(sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * 0.16f);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0f;
        this.field_70159_w = -sajh._a(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI);
        this.field_70179_y = sajh._b(this.field_70177_z / 180.0f * (float)Math.PI) * sajh._b(this.field_70125_A / 180.0f * (float)Math.PI);
        this.field_70181_x = -sajh._a(this.field_70125_A / 180.0f * (float)Math.PI);
        this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, f * 1.5f, 1.0f);
    }

    @Override
    public void func_70088_a() {
        this.field_70180_af._a(16, (Object)0);
    }

    @Override
    public void func_70186_c(double d, double d2, double d3, float f, float f2) {
        float f3 = sajh._a(d * d + d2 * d2 + d3 * d3);
        d /= (double)f3;
        d2 /= (double)f3;
        d3 /= (double)f3;
        d += this.field_70146_Z.nextGaussian() * (double)(this.field_70146_Z.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)f2;
        d2 += this.field_70146_Z.nextGaussian() * (double)(this.field_70146_Z.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)f2;
        d3 += this.field_70146_Z.nextGaussian() * (double)(this.field_70146_Z.nextBoolean() ? -1 : 1) * (double)0.0075f * (double)f2;
        this.field_70159_w = d *= (double)f;
        this.field_70181_x = d2 *= (double)f;
        this.field_70179_y = d3 *= (double)f;
        float f4 = sajh._a(d * d + d3 * d3);
        this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
        this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d2, f4) * 180.0 / 3.1415927410125732);
        this.field_70252_j = 0;
    }

    @Override
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
        this.func_70107_b(d, d2, d3);
        this.func_70101_b(f, f2);
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
            this.field_70127_C = this.field_70125_A;
            this.field_70126_B = this.field_70177_z;
            this.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
            this.field_70252_j = 0;
        }
    }

    @Override
    public void func_70071_h_() {
        Object object;
        int n;
        Object object2;
        int n2;
        super.func_70071_h_();
        if (this.field_70127_C == 0.0f && this.field_70126_B == 0.0f) {
            float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0 / 3.1415927410125732);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0 / 3.1415927410125732);
        }
        if ((n2 = this.field_70170_p.func_72798_a(this.field_70247_d, this.field_70248_e, this.field_70245_f)) > 0) {
            twgu.field_71973_m[n2].func_71902_a(this.field_70170_p, this.field_70247_d, this.field_70248_e, this.field_70245_f);
            object2 = twgu.field_71973_m[n2].func_71872_e(this.field_70170_p, this.field_70247_d, this.field_70248_e, this.field_70245_f);
            if (object2 != null && ((eidj)object2)._a(this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) {
                this.field_70254_i = true;
            }
        }
        if (this.field_70249_b > 0) {
            --this.field_70249_b;
        }
        if (this.field_70254_i) {
            int n3 = this.field_70170_p.func_72798_a(this.field_70247_d, this.field_70248_e, this.field_70245_f);
            int n4 = this.field_70170_p.func_72805_g(this.field_70247_d, this.field_70248_e, this.field_70245_f);
            if (n3 != this.field_70246_g || n4 != this.field_70253_h) {
                this.field_70254_i = false;
                this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
                this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
                this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2f);
                this.field_70252_j = 0;
                this.field_70257_an = 0;
                return;
            }
            ++this.field_70252_j;
            if (this.field_70252_j == 1200) {
                this.func_70106_y();
            }
            return;
        }
        ++this.field_70257_an;
        object2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        hank hank2 = this.field_70170_p.func_72831_a((ofbx)object2, ofbx2, false, true);
        object2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        ofbx2 = this.field_70170_p.func_82732_R()._a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
        if (hank2 != null) {
            ofbx2 = this.field_70170_p.func_82732_R()._a(hank2._h._c, hank2._h._d, hank2._h._e);
        }
        Entity entity = null;
        List list2 = this.field_70170_p.func_72839_b(this, this.field_70121_D._a(this.field_70159_w, this.field_70181_x, this.field_70179_y)._b(1.0, 1.0, 1.0));
        double d = 0.0;
        for (n = 0; n < list2.size(); ++n) {
            double d2;
            float f;
            hank hank3;
            Entity entity2 = (Entity)list2.get(n);
            if (!entity2.func_70067_L() || entity2 == this.field_70250_c && this.field_70257_an < 5 || (hank3 = ((eidj)(object = entity2.field_70121_D._b(f = 0.3f, f, f)))._a((ofbx)object2, ofbx2)) == null || !((d2 = ((ofbx)object2)._d(hank3._h)) < d) && d != 0.0) continue;
            entity = entity2;
            d = d2;
        }
        if (entity != null) {
            hank2 = new hank(entity);
        }
        if (hank2 != null && hank2._i != null && hank2._i instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)hank2._i;
            if (entityPlayer.field_71075_bZ._a || this.field_70250_c instanceof EntityPlayer && !((EntityPlayer)this.field_70250_c).func_96122_a(entityPlayer)) {
                hank2 = null;
            }
        }
        if (hank2 != null) {
            if (hank2._i != null) {
                float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
                int n5 = sajh._e((double)f * this.field_70255_ao);
                if (this.func_70241_g()) {
                    n5 += this.field_70146_Z.nextInt(n5 / 2 + 2);
                }
                jxtc jxtc2 = null;
                jxtc2 = this.field_70250_c == null ? jxtc.func_76353_a(this, this) : jxtc.func_76353_a(this, this.field_70250_c);
                if (this.func_70027_ad() && !(hank2._i instanceof EntityEnderman)) {
                    hank2._i.func_70015_d(5);
                }
                if (hank2._i.func_70097_a(jxtc2, n5)) {
                    if (hank2._i instanceof EntityLivingBase) {
                        float f2;
                        object = (EntityLivingBase)hank2._i;
                        if (!this.field_70170_p.field_72995_K) {
                            ((EntityLivingBase)object).func_85034_r(((EntityLivingBase)object).func_85035_bI() + 1);
                        }
                        if (this.field_70256_ap > 0 && (f2 = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y)) > 0.0f) {
                            hank2._i.func_70024_g(this.field_70159_w * (double)this.field_70256_ap * (double)0.6f / (double)f2, 0.1, this.field_70179_y * (double)this.field_70256_ap * (double)0.6f / (double)f2);
                        }
                        if (this.field_70250_c != null) {
                            ekyk._a(this.field_70250_c, (EntityLivingBase)object, this.field_70146_Z);
                        }
                        if (this.field_70250_c != null && hank2._i != this.field_70250_c && hank2._i instanceof EntityPlayer && this.field_70250_c instanceof EntityPlayerMP) {
                            ((EntityPlayerMP)this.field_70250_c).field_71135_a.func_72567_b(new tgph(6, 0));
                        }
                    }
                    this.func_85030_a("random.bowhit", 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
                    if (!(hank2._i instanceof EntityEnderman)) {
                        this.func_70106_y();
                    }
                } else {
                    this.field_70159_w *= (double)-0.1f;
                    this.field_70181_x *= (double)-0.1f;
                    this.field_70179_y *= (double)-0.1f;
                    this.field_70177_z += 180.0f;
                    this.field_70126_B += 180.0f;
                    this.field_70257_an = 0;
                }
            } else {
                this.field_70247_d = hank2._d;
                this.field_70248_e = hank2._e;
                this.field_70245_f = hank2._f;
                this.field_70246_g = this.field_70170_p.func_72798_a(this.field_70247_d, this.field_70248_e, this.field_70245_f);
                this.field_70253_h = this.field_70170_p.func_72805_g(this.field_70247_d, this.field_70248_e, this.field_70245_f);
                this.field_70159_w = (float)(hank2._h._c - this.field_70165_t);
                this.field_70181_x = (float)(hank2._h._d - this.field_70163_u);
                this.field_70179_y = (float)(hank2._h._e - this.field_70161_v);
                float f = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
                this.field_70165_t -= this.field_70159_w / (double)f * (double)0.05f;
                this.field_70163_u -= this.field_70181_x / (double)f * (double)0.05f;
                this.field_70161_v -= this.field_70179_y / (double)f * (double)0.05f;
                this.func_85030_a("random.bowhit", 1.0f, 1.2f / (this.field_70146_Z.nextFloat() * 0.2f + 0.9f));
                this.field_70254_i = true;
                this.field_70249_b = 7;
                this.func_70243_d(false);
                if (this.field_70246_g != 0) {
                    twgu.field_71973_m[this.field_70246_g].func_71869_a(this.field_70170_p, this.field_70247_d, this.field_70248_e, this.field_70245_f, this);
                }
            }
        }
        if (this.func_70241_g()) {
            for (n = 0; n < 4; ++n) {
                this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70159_w * (double)n / 4.0, this.field_70163_u + this.field_70181_x * (double)n / 4.0, this.field_70161_v + this.field_70179_y * (double)n / 4.0, -this.field_70159_w, -this.field_70181_x + 0.2, -this.field_70179_y);
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
        float f3 = 0.99f;
        float f4 = 0.05f;
        if (this.func_70090_H()) {
            for (int i = 0; i < 4; ++i) {
                float f5 = 0.25f;
                this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)f5, this.field_70163_u - this.field_70181_x * (double)f5, this.field_70161_v - this.field_70179_y * (double)f5, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
            f3 = 0.8f;
        }
        this.field_70159_w *= (double)f3;
        this.field_70181_x *= (double)f3;
        this.field_70179_y *= (double)f3;
        this.field_70181_x -= (double)f4;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_70017_D();
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("xTile", (short)this.field_70247_d);
        qoac2._a("yTile", (short)this.field_70248_e);
        qoac2._a("zTile", (short)this.field_70245_f);
        qoac2._a("inTile", (byte)this.field_70246_g);
        qoac2._a("inData", (byte)this.field_70253_h);
        qoac2._a("shake", (byte)this.field_70249_b);
        qoac2._a("inGround", (byte)(this.field_70254_i ? 1 : 0));
        qoac2._a("pickup", (byte)this.field_70251_a);
        qoac2._a("damage", this.field_70255_ao);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        this.field_70247_d = qoac2._e("xTile");
        this.field_70248_e = qoac2._e("yTile");
        this.field_70245_f = qoac2._e("zTile");
        this.field_70246_g = qoac2._d("inTile") & 0xFF;
        this.field_70253_h = qoac2._d("inData") & 0xFF;
        this.field_70249_b = qoac2._d("shake") & 0xFF;
        boolean bl = this.field_70254_i = qoac2._d("inGround") == 1;
        if (qoac2._c("damage")) {
            this.field_70255_ao = qoac2._i("damage");
        }
        if (qoac2._c("pickup")) {
            this.field_70251_a = qoac2._d("pickup");
        } else if (qoac2._c("player")) {
            this.field_70251_a = qoac2._o("player") ? 1 : 0;
        }
    }

    @Override
    public void func_70100_b_(EntityPlayer entityPlayer) {
        boolean bl;
        if (this.field_70170_p.field_72995_K || !this.field_70254_i || this.field_70249_b > 0) {
            return;
        }
        boolean bl2 = bl = this.field_70251_a == 1 || this.field_70251_a == 2 && entityPlayer.field_71075_bZ._d;
        if (this.field_70251_a == 1 && !entityPlayer.field_71071_by._c(new cvzo(tgdv.field_77704_l, 1))) {
            bl = false;
        }
        if (bl) {
            this.func_85030_a("random.pop", 0.2f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityPlayer.func_71001_a(this, 1);
            this.func_70106_y();
        }
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public float func_70053_R() {
        return 0.0f;
    }

    public void func_70239_b(double d) {
        this.field_70255_ao = d;
    }

    public double func_70242_d() {
        return this.field_70255_ao;
    }

    public void func_70240_a(int n) {
        this.field_70256_ap = n;
    }

    @Override
    public boolean func_70075_an() {
        return false;
    }

    public void func_70243_d(boolean bl) {
        byte by = this.field_70180_af._a(16);
        if (bl) {
            this.field_70180_af._b(16, (byte)(by | 1));
        } else {
            this.field_70180_af._b(16, (byte)(by & 0xFFFFFFFE));
        }
    }

    public boolean func_70241_g() {
        byte by = this.field_70180_af._a(16);
        return (by & 1) != 0;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;

public abstract class EntityHanging
extends Entity {
    public int field_70520_f;
    public int field_82332_a;
    public int field_70523_b;
    public int field_70524_c;
    public int field_70521_d;

    public EntityHanging(ozlu ozlu2) {
        super(ozlu2);
        this.field_70129_M = 0.0f;
        this.func_70105_a(0.5f, 0.5f);
    }

    public EntityHanging(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this(ozlu2);
        this.field_70523_b = n;
        this.field_70524_c = n2;
        this.field_70521_d = n3;
    }

    @Override
    public void func_70088_a() {
    }

    public void func_82328_a(int n) {
        this.field_82332_a = n;
        this.field_70126_B = this.field_70177_z = (float)(n * 90);
        float f = this.func_82329_d();
        float f2 = this.func_82330_g();
        float f3 = this.func_82329_d();
        if (n == 2 || n == 0) {
            f3 = 0.5f;
            this.field_70177_z = this.field_70126_B = (float)(ugqx._f[n] * 90);
        } else {
            f = 0.5f;
        }
        f /= 32.0f;
        f2 /= 32.0f;
        f3 /= 32.0f;
        float f4 = (float)this.field_70523_b + 0.5f;
        float f5 = (float)this.field_70524_c + 0.5f;
        float f6 = (float)this.field_70521_d + 0.5f;
        float f7 = 0.5625f;
        if (n == 2) {
            f6 -= f7;
        }
        if (n == 1) {
            f4 -= f7;
        }
        if (n == 0) {
            f6 += f7;
        }
        if (n == 3) {
            f4 += f7;
        }
        if (n == 2) {
            f4 -= this.func_70517_b(this.func_82329_d());
        }
        if (n == 1) {
            f6 += this.func_70517_b(this.func_82329_d());
        }
        if (n == 0) {
            f4 += this.func_70517_b(this.func_82329_d());
        }
        if (n == 3) {
            f6 -= this.func_70517_b(this.func_82329_d());
        }
        this.func_70107_b(f4, f5 += this.func_70517_b(this.func_82330_g()), f6);
        float f8 = -0.03125f;
        this.field_70121_D._b(f4 - f - f8, f5 - f2 - f8, f6 - f3 - f8, f4 + f + f8, f5 + f2 + f8, f6 + f3 + f8);
    }

    public float func_70517_b(int n) {
        if (n == 32) {
            return 0.5f;
        }
        if (n == 64) {
            return 0.5f;
        }
        return 0.0f;
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70520_f++ == 100 && !this.field_70170_p.field_72995_K) {
            this.field_70520_f = 0;
            if (!this.field_70128_L && !this.func_70518_d()) {
                this.func_70106_y();
                this.func_110128_b(null);
            }
        }
    }

    public boolean func_70518_d() {
        if (!this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty()) {
            return false;
        }
        int n = Math.max(1, this.func_82329_d() / 16);
        int n2 = Math.max(1, this.func_82330_g() / 16);
        int n3 = this.field_70523_b;
        int n4 = this.field_70524_c;
        int n5 = this.field_70521_d;
        if (this.field_82332_a == 2) {
            n3 = sajh._c(this.field_70165_t - (double)((float)this.func_82329_d() / 32.0f));
        }
        if (this.field_82332_a == 1) {
            n5 = sajh._c(this.field_70161_v - (double)((float)this.func_82329_d() / 32.0f));
        }
        if (this.field_82332_a == 0) {
            n3 = sajh._c(this.field_70165_t - (double)((float)this.func_82329_d() / 32.0f));
        }
        if (this.field_82332_a == 3) {
            n5 = sajh._c(this.field_70161_v - (double)((float)this.func_82329_d() / 32.0f));
        }
        n4 = sajh._c(this.field_70163_u - (double)((float)this.func_82330_g() / 32.0f));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                Object object = this.field_82332_a == 2 || this.field_82332_a == 0 ? this.field_70170_p.func_72803_f(n3 + i, n4 + j, this.field_70521_d) : this.field_70170_p.func_72803_f(this.field_70523_b, n4 + j, n5 + i);
                if (((tflj)object)._a()) continue;
                return false;
            }
        }
        List list2 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        for (Object object : list2) {
            if (!(object instanceof EntityHanging)) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean func_70067_L() {
        return true;
    }

    @Override
    public boolean func_85031_j(Entity entity) {
        if (entity instanceof EntityPlayer) {
            return this.func_70097_a(jxtc.func_76365_a((EntityPlayer)entity), 0.0f);
        }
        return false;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return false;
        }
        if (!this.field_70128_L && !this.field_70170_p.field_72995_K) {
            this.func_70106_y();
            this.func_70018_K();
            this.func_110128_b(jxtc2.func_76346_g());
        }
        return true;
    }

    @Override
    public void func_70091_d(double d, double d2, double d3) {
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L && d * d + d2 * d2 + d3 * d3 > 0.0) {
            this.func_70106_y();
            this.func_110128_b(null);
        }
    }

    @Override
    public void func_70024_g(double d, double d2, double d3) {
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L && d * d + d2 * d2 + d3 * d3 > 0.0) {
            this.func_70106_y();
            this.func_110128_b(null);
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("Direction", (byte)this.field_82332_a);
        qoac2._a("TileX", this.field_70523_b);
        qoac2._a("TileY", this.field_70524_c);
        qoac2._a("TileZ", this.field_70521_d);
        switch (this.field_82332_a) {
            case 2: {
                qoac2._a("Dir", (byte)0);
                break;
            }
            case 1: {
                qoac2._a("Dir", (byte)1);
                break;
            }
            case 0: {
                qoac2._a("Dir", (byte)2);
                break;
            }
            case 3: {
                qoac2._a("Dir", (byte)3);
            }
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        if (qoac2._c("Direction")) {
            this.field_82332_a = qoac2._d("Direction");
        } else {
            switch (qoac2._d("Dir")) {
                case 0: {
                    this.field_82332_a = 2;
                    break;
                }
                case 1: {
                    this.field_82332_a = 1;
                    break;
                }
                case 2: {
                    this.field_82332_a = 0;
                    break;
                }
                case 3: {
                    this.field_82332_a = 3;
                }
            }
        }
        this.field_70523_b = qoac2._f("TileX");
        this.field_70524_c = qoac2._f("TileY");
        this.field_70521_d = qoac2._f("TileZ");
        this.func_82328_a(this.field_82332_a);
    }

    public abstract int func_82329_d();

    public abstract int func_82330_g();

    public abstract void func_110128_b(Entity var1);

    @Override
    public boolean func_142008_O() {
        return false;
    }
}


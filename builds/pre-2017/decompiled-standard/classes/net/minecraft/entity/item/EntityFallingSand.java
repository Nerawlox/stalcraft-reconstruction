/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.ArrayList;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityFallingSand
extends Entity {
    public int field_70287_a;
    public int field_70285_b;
    public int field_70286_c;
    public boolean field_70284_d = true;
    public boolean field_82157_e;
    public boolean field_82155_f;
    public int field_82156_g = 40;
    public float field_82158_h = 2.0f;
    public qoac field_98051_e;

    public EntityFallingSand(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityFallingSand(ozlu ozlu2, double d, double d2, double d3, int n) {
        this(ozlu2, d, d2, d3, n, 0);
    }

    public EntityFallingSand(ozlu ozlu2, double d, double d2, double d3, int n, int n2) {
        super(ozlu2);
        this.field_70287_a = n;
        this.field_70285_b = n2;
        this.field_70156_m = true;
        this.func_70105_a(0.98f, 0.98f);
        this.field_70129_M = this.field_70131_O / 2.0f;
        this.func_70107_b(d, d2, d3);
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        this.field_70169_q = d;
        this.field_70167_r = d2;
        this.field_70166_s = d3;
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }

    @Override
    public void func_70071_h_() {
        if (this.field_70287_a == 0) {
            this.func_70106_y();
            return;
        }
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        ++this.field_70286_c;
        this.field_70181_x -= (double)0.04f;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.98f;
        this.field_70181_x *= (double)0.98f;
        this.field_70179_y *= (double)0.98f;
        if (!this.field_70170_p.field_72995_K) {
            int n = sajh._c(this.field_70165_t);
            int n2 = sajh._c(this.field_70163_u);
            int n3 = sajh._c(this.field_70161_v);
            if (this.field_70286_c == 1) {
                if (this.field_70170_p.func_72798_a(n, n2, n3) == this.field_70287_a) {
                    this.field_70170_p.func_94571_i(n, n2, n3);
                } else {
                    this.func_70106_y();
                    return;
                }
            }
            if (this.field_70122_E) {
                this.field_70159_w *= (double)0.7f;
                this.field_70179_y *= (double)0.7f;
                this.field_70181_x *= -0.5;
                if (this.field_70170_p.func_72798_a(n, n2, n3) != twgu.field_72095_ac.field_71990_ca) {
                    this.func_70106_y();
                    if (!this.field_82157_e && this.field_70170_p.func_72931_a(this.field_70287_a, n, n2, n3, true, 1, null, null) && !uilx._b(this.field_70170_p, n, n2 - 1, n3) && this.field_70170_p.func_72832_d(n, n2, n3, this.field_70287_a, this.field_70285_b, 3)) {
                        hurg hurg2;
                        if (twgu.field_71973_m[this.field_70287_a] instanceof uilx) {
                            ((uilx)twgu.field_71973_m[this.field_70287_a])._a(this.field_70170_p, n, n2, n3, this.field_70285_b);
                        }
                        if (this.field_98051_e != null && twgu.field_71973_m[this.field_70287_a] instanceof stgn && (hurg2 = this.field_70170_p.func_72796_p(n, n2, n3)) != null) {
                            qoac qoac2 = new qoac();
                            hurg2.func_70310_b(qoac2);
                            for (huhy huhy2 : this.field_98051_e._d()) {
                                if (huhy2._b().equals("x") || huhy2._b().equals("y") || huhy2._b().equals("z")) continue;
                                qoac2._a(huhy2._b(), huhy2._c());
                            }
                            hurg2.func_70307_a(qoac2);
                            hurg2.func_70296_d();
                        }
                    } else if (this.field_70284_d && !this.field_82157_e) {
                        this.func_70099_a(new cvzo(this.field_70287_a, 1, twgu.field_71973_m[this.field_70287_a].func_71899_b(this.field_70285_b)), 0.0f);
                    }
                }
            } else if (this.field_70286_c > 100 && !this.field_70170_p.field_72995_K && (n2 < 1 || n2 > 256) || this.field_70286_c > 600) {
                if (this.field_70284_d) {
                    this.func_70099_a(new cvzo(this.field_70287_a, 1, twgu.field_71973_m[this.field_70287_a].func_71899_b(this.field_70285_b)), 0.0f);
                }
                this.func_70106_y();
            }
        }
    }

    @Override
    public void func_70069_a(float f) {
        int n;
        if (this.field_82155_f && (n = sajh._f(f - 1.0f)) > 0) {
            ArrayList arrayList = new ArrayList(this.field_70170_p.func_72839_b(this, this.field_70121_D));
            jxtc jxtc2 = this.field_70287_a == twgu.field_82510_ck.field_71990_ca ? jxtc.field_82728_o : jxtc.field_82729_p;
            for (Entity entity : arrayList) {
                entity.func_70097_a(jxtc2, Math.min(sajh._d((float)n * this.field_82158_h), this.field_82156_g));
            }
            if (this.field_70287_a == twgu.field_82510_ck.field_71990_ca && (double)this.field_70146_Z.nextFloat() < (double)0.05f + (double)n * 0.05) {
                int n2 = this.field_70285_b >> 2;
                int n3 = this.field_70285_b & 3;
                if (++n2 > 2) {
                    this.field_82157_e = true;
                } else {
                    this.field_70285_b = n3 | n2 << 2;
                }
            }
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("Tile", (byte)this.field_70287_a);
        qoac2._a("TileID", this.field_70287_a);
        qoac2._a("Data", (byte)this.field_70285_b);
        qoac2._a("Time", (byte)this.field_70286_c);
        qoac2._a("DropItem", this.field_70284_d);
        qoac2._a("HurtEntities", this.field_82155_f);
        qoac2._a("FallHurtAmount", this.field_82158_h);
        qoac2._a("FallHurtMax", this.field_82156_g);
        if (this.field_98051_e != null) {
            qoac2._a("TileEntityData", this.field_98051_e);
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        this.field_70287_a = qoac2._c("TileID") ? qoac2._f("TileID") : qoac2._d("Tile") & 0xFF;
        this.field_70285_b = qoac2._d("Data") & 0xFF;
        this.field_70286_c = qoac2._d("Time") & 0xFF;
        if (qoac2._c("HurtEntities")) {
            this.field_82155_f = qoac2._o("HurtEntities");
            this.field_82158_h = qoac2._h("FallHurtAmount");
            this.field_82156_g = qoac2._f("FallHurtMax");
        } else if (this.field_70287_a == twgu.field_82510_ck.field_71990_ca) {
            this.field_82155_f = true;
        }
        if (qoac2._c("DropItem")) {
            this.field_70284_d = qoac2._o("DropItem");
        }
        if (qoac2._c("TileEntityData")) {
            this.field_98051_e = qoac2._m("TileEntityData");
        }
        if (this.field_70287_a == 0) {
            this.field_70287_a = twgu.field_71939_E.field_71990_ca;
        }
    }

    @Override
    public float func_70053_R() {
        return 0.0f;
    }

    public ozlu func_70283_d() {
        return this.field_70170_p;
    }

    public void func_82154_e(boolean bl) {
        this.field_82155_f = bl;
    }

    @Override
    public boolean func_90999_ad() {
        return false;
    }

    @Override
    public void func_85029_a(jxsn jxsn2) {
        super.func_85029_a(jxsn2);
        jxsn2._a("Immitating block ID", this.field_70287_a);
        jxsn2._a("Immitating block data", this.field_70285_b);
    }
}


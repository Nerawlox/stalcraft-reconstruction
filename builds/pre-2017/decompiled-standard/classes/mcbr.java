/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;
import net.minecraft.util.owak;

public class mcbr
extends hurg {
    public int _a;
    public int _b;
    public int _c;
    public boolean _d;
    public boolean _e;
    public float _f;
    public float _g;
    public List _h = new ArrayList();

    public mcbr() {
    }

    public mcbr(int n, int n2, int n3, boolean bl, boolean bl2) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = bl;
        this._e = bl2;
    }

    public int _a() {
        return this._a;
    }

    @Override
    public int func_70322_n() {
        return this._b;
    }

    public boolean _b() {
        return this._d;
    }

    public int _c() {
        return this._c;
    }

    public boolean _d() {
        return this._e;
    }

    public float _a(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        return this._g + (this._f - this._g) * f;
    }

    public float _b(float f) {
        if (this._d) {
            return (this._a(f) - 1.0f) * (float)owak._b[this._c];
        }
        return (1.0f - this._a(f)) * (float)owak._b[this._c];
    }

    public float _c(float f) {
        if (this._d) {
            return (this._a(f) - 1.0f) * (float)owak._c[this._c];
        }
        return (1.0f - this._a(f)) * (float)owak._c[this._c];
    }

    public float _d(float f) {
        if (this._d) {
            return (this._a(f) - 1.0f) * (float)owak._d[this._c];
        }
        return (1.0f - this._a(f)) * (float)owak._d[this._c];
    }

    public void _a(float f, float f2) {
        List list;
        f = this._d ? 1.0f - f : (f -= 1.0f);
        eidj eidj2 = twgu.field_72095_ac._a(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n, this._a, f, this._c);
        if (eidj2 != null && !(list = this.field_70331_k.func_72839_b(null, eidj2)).isEmpty()) {
            this._h.addAll(list);
            for (Entity entity : this._h) {
                entity.func_70091_d(f2 * (float)owak._b[this._c], f2 * (float)owak._c[this._c], f2 * (float)owak._d[this._c]);
            }
            this._h.clear();
        }
    }

    public void _e() {
        if (this._g < 1.0f && this.field_70331_k != null) {
            this._f = 1.0f;
            this._g = 1.0f;
            this.field_70331_k.func_72932_q(this.field_70329_l, this.field_70330_m, this.field_70327_n);
            this.func_70313_j();
            if (this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n) == twgu.field_72095_ac.field_71990_ca) {
                this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, this._a, this._b, 3);
                this.field_70331_k.func_72821_m(this.field_70329_l, this.field_70330_m, this.field_70327_n, this._a);
            }
        }
    }

    @Override
    public void func_70316_g() {
        this._g = this._f;
        if (this._g >= 1.0f) {
            this._a(1.0f, 0.25f);
            this.field_70331_k.func_72932_q(this.field_70329_l, this.field_70330_m, this.field_70327_n);
            this.func_70313_j();
            if (this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n) == twgu.field_72095_ac.field_71990_ca) {
                this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, this._a, this._b, 3);
                this.field_70331_k.func_72821_m(this.field_70329_l, this.field_70330_m, this.field_70327_n, this._a);
            }
            return;
        }
        this._f += 0.5f;
        if (this._f >= 1.0f) {
            this._f = 1.0f;
        }
        if (this._d) {
            this._a(this._f, this._f - this._g + 0.0625f);
        }
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._a = qoac2._f("blockId");
        this._b = qoac2._f("blockData");
        this._c = qoac2._f("facing");
        this._g = this._f = qoac2._h("progress");
        this._d = qoac2._o("extending");
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("blockId", this._a);
        qoac2._a("blockData", this._b);
        qoac2._a("facing", this._c);
        qoac2._a("progress", this._g);
        qoac2._a("extending", this._d);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.sajh;

public class zhpf {
    public double _a;
    public double _b;

    public zhpf() {
    }

    public zhpf(double d, double d2) {
        this._a = d;
        this._b = d2;
    }

    public double _a(zhpf zhpf2) {
        double d = this._a - zhpf2._a;
        double d2 = this._b - zhpf2._b;
        return Math.sqrt(d * d + d2 * d2);
    }

    public void _a() {
        double d = this._b();
        this._a /= d;
        this._b /= d;
    }

    public float _b() {
        return sajh._a(this._a * this._a + this._b * this._b);
    }

    public void _b(zhpf zhpf2) {
        this._a -= zhpf2._a;
        this._b -= zhpf2._b;
    }

    public boolean _a(double d, double d2, double d3, double d4) {
        boolean bl = false;
        if (this._a < d) {
            this._a = d;
            bl = true;
        } else if (this._a > d3) {
            this._a = d3;
            bl = true;
        }
        if (this._b < d2) {
            this._b = d2;
            bl = true;
        } else if (this._b > d4) {
            this._b = d4;
            bl = true;
        }
        return bl;
    }

    public int _a(ozlu ozlu2) {
        int n = sajh._c(this._a);
        int n2 = sajh._c(this._b);
        for (int i = 256; i > 0; --i) {
            int n3 = ozlu2.func_72798_a(n, i, n2);
            if (n3 == 0) continue;
            return i + 1;
        }
        return 257;
    }

    public boolean _b(ozlu ozlu2) {
        int n = sajh._c(this._a);
        int n2 = sajh._c(this._b);
        for (int i = 256; i > 0; --i) {
            int n3 = ozlu2.func_72798_a(n, i, n2);
            if (n3 == 0) continue;
            tflj tflj2 = twgu.field_71973_m[n3].field_72018_cp;
            return !tflj2._d() && tflj2 != tflj._o;
        }
        return false;
    }

    public void _a(Random random, double d, double d2, double d3, double d4) {
        this._a = sajh._a(random, d, d3);
        this._b = sajh._a(random, d2, d4);
    }
}


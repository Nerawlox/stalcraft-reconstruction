/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.sajh;

public class elhc {
    public final int _a;
    public final int _b;
    public final int _c;
    public final int _d;
    public int _e = -1;
    public float _f;
    public float _g;
    public float _h;
    public elhc _i;
    public boolean _j;

    public elhc(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = elhc._a(n, n2, n3);
    }

    public static int _a(int n, int n2, int n3) {
        return n2 & 0xFF | (n & Short.MAX_VALUE) << 8 | (n3 & Short.MAX_VALUE) << 24 | (n < 0 ? Integer.MIN_VALUE : 0) | (n3 < 0 ? 32768 : 0);
    }

    public float _a(elhc elhc2) {
        float f = elhc2._a - this._a;
        float f2 = elhc2._b - this._b;
        float f3 = elhc2._c - this._c;
        return sajh._c(f * f + f2 * f2 + f3 * f3);
    }

    public float _b(elhc elhc2) {
        float f = elhc2._a - this._a;
        float f2 = elhc2._b - this._b;
        float f3 = elhc2._c - this._c;
        return f * f + f2 * f2 + f3 * f3;
    }

    public boolean equals(Object object) {
        if (object instanceof elhc) {
            elhc elhc2 = (elhc)object;
            return this._d == elhc2._d && this._a == elhc2._a && this._b == elhc2._b && this._c == elhc2._c;
        }
        return false;
    }

    public int hashCode() {
        return this._d;
    }

    public boolean _a() {
        return this._e >= 0;
    }

    public String toString() {
        return this._a + ", " + this._b + ", " + this._c;
    }
}


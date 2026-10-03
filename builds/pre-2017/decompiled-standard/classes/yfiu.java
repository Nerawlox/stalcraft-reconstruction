/*
 * Decompiled with CFR 0.152.
 */
public class yfiu {
    public final byte[] _a;
    public final int _b;
    public final int _c;

    public yfiu(byte[] byArray, int n) {
        this._a = byArray;
        this._b = n;
        this._c = n + 4;
    }

    public int _a(int n, int n2, int n3) {
        int n4 = n << this._c | n3 << this._b | n2;
        int n5 = n4 >> 1;
        int n6 = n4 & 1;
        if (n6 == 0) {
            return this._a[n5] & 0xF;
        }
        return this._a[n5] >> 4 & 0xF;
    }
}


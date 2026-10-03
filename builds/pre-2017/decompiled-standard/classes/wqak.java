/*
 * Decompiled with CFR 0.152.
 */
public class wqak {
    public final byte[] _a;
    public final int _b;
    public final int _c;

    public wqak(int n, int n2) {
        this._a = new byte[n >> 1];
        this._b = n2;
        this._c = n2 + 4;
    }

    public wqak(byte[] byArray, int n) {
        this._a = byArray;
        this._b = n;
        this._c = n + 4;
    }

    public int _a(int n, int n2, int n3) {
        int n4 = n2 << this._c | n3 << this._b | n;
        int n5 = n4 >> 1;
        int n6 = n4 & 1;
        if (n6 == 0) {
            return this._a[n5] & 0xF;
        }
        return this._a[n5] >> 4 & 0xF;
    }

    public void _a(int n, int n2, int n3, int n4) {
        int n5 = n2 << this._c | n3 << this._b | n;
        int n6 = n5 >> 1;
        int n7 = n5 & 1;
        this._a[n6] = n7 == 0 ? (byte)(this._a[n6] & 0xF0 | n4 & 0xF) : (byte)(this._a[n6] & 0xF | (n4 & 0xF) << 4);
    }
}


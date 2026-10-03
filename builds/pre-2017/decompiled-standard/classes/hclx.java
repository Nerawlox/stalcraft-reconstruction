/*
 * Decompiled with CFR 0.152.
 */
public class hclx
extends pked {
    public final int _e;
    public final int _f;
    public final /* synthetic */ tfow _g;

    public hclx(tfow tfow2, int n, int n2, int n3, int n4, int n5) {
        this._g = tfow2;
        super(n, n2, n3, zybc.field_110408_a, 0 + hdpq._a[n4]._e() % 8 * 18, 198 + hdpq._a[n4]._e() / 8 * 18);
        this._e = n4;
        this._f = n5;
    }

    @Override
    public void func_82251_b(int n, int n2) {
        String string = wpcz._a(hdpq._a[this._e]._c());
        if (this._f >= 3 && this._e != hdpq._l._H) {
            string = string + " II";
        }
        this._g.func_74190_a(string, n, n2);
    }
}


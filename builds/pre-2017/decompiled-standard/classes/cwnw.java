/*
 * Decompiled with CFR 0.152.
 */
public class cwnw
extends lqgz {
    public foqh[] _e;

    public cwnw(long l, lqgz lqgz2, nwix nwix2) {
        super(l);
        this._e = nwix2._i();
        this._b = lqgz2;
    }

    @Override
    public int[] _a(int n, int n2, int n3, int n4) {
        int[] nArray = this._b._a(n, n2, n3, n4);
        int[] nArray2 = dins._a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n5;
                this._a(j + n, i + n2);
                int n6 = nArray[j + i * n3];
                nArray2[j + i * n3] = n6 == 0 ? 0 : (n6 == foqh._p._P ? n6 : (n6 == 1 ? this._e[this._a((int)this._e.length)]._P : ((n5 = this._e[this._a((int)this._e.length)]._P) == foqh._g._P ? n5 : foqh._n._P)));
            }
        }
        return nArray2;
    }
}


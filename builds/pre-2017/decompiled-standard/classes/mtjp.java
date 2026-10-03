/*
 * Decompiled with CFR 0.152.
 */
public class mtjp
extends lqgz {
    public mtjp(long l, lqgz lqgz2) {
        super(l);
        this._b = lqgz2;
    }

    @Override
    public int[] _a(int n, int n2, int n3, int n4) {
        int[] nArray = this._b._a(n - 1, n2 - 1, n3 + 2, n4 + 2);
        int[] nArray2 = dins._a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this._a(j + n, i + n2);
                int n5 = nArray[j + 1 + (i + 1) * (n3 + 2)];
                nArray2[j + i * n3] = n5 == foqh._h._P && this._a(6) == 0 || (n5 == foqh._w._P || n5 == foqh._x._P) && this._a(8) == 0 ? foqh._i._P : n5;
            }
        }
        return nArray2;
    }
}


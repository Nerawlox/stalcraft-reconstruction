/*
 * Decompiled with CFR 0.152.
 */
public class nwmj
extends lqgz {
    public nwmj(long l, lqgz lqgz2) {
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
                if (this._a(3) == 0) {
                    int n6 = n5;
                    if (n5 == foqh._d._P) {
                        n6 = foqh._s._P;
                    } else if (n5 == foqh._f._P) {
                        n6 = foqh._t._P;
                    } else if (n5 == foqh._g._P) {
                        n6 = foqh._u._P;
                    } else if (n5 == foqh._c._P) {
                        n6 = foqh._f._P;
                    } else if (n5 == foqh._n._P) {
                        n6 = foqh._o._P;
                    } else if (n5 == foqh._w._P) {
                        n6 = foqh._x._P;
                    }
                    if (n6 == n5) {
                        nArray2[j + i * n3] = n5;
                        continue;
                    }
                    int n7 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    int n8 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    int n9 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    int n10 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (n7 == n5 && n8 == n5 && n9 == n5 && n10 == n5) {
                        nArray2[j + i * n3] = n6;
                        continue;
                    }
                    nArray2[j + i * n3] = n5;
                    continue;
                }
                nArray2[j + i * n3] = n5;
            }
        }
        return nArray2;
    }
}


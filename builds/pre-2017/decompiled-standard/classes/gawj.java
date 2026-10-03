/*
 * Decompiled with CFR 0.152.
 */
public class gawj
extends lqgz {
    public gawj(long l, lqgz lqgz2) {
        super(l);
        this._b = lqgz2;
    }

    @Override
    public int[] _a(int n, int n2, int n3, int n4) {
        int[] nArray = this._b._a(n - 1, n2 - 1, n3 + 2, n4 + 2);
        int[] nArray2 = dins._a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n5;
                int n6;
                int n7;
                int n8;
                this._a(j + n, i + n2);
                int n9 = nArray[j + 1 + (i + 1) * (n3 + 2)];
                if (n9 == foqh._p._P) {
                    n8 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    n7 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    n6 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    n5 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (n8 == foqh._b._P || n7 == foqh._b._P || n6 == foqh._b._P || n5 == foqh._b._P) {
                        nArray2[j + i * n3] = foqh._q._P;
                        continue;
                    }
                    nArray2[j + i * n3] = n9;
                    continue;
                }
                if (n9 != foqh._b._P && n9 != foqh._i._P && n9 != foqh._h._P && n9 != foqh._e._P) {
                    n8 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    n7 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    n6 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    n5 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (n8 == foqh._b._P || n7 == foqh._b._P || n6 == foqh._b._P || n5 == foqh._b._P) {
                        nArray2[j + i * n3] = foqh._r._P;
                        continue;
                    }
                    nArray2[j + i * n3] = n9;
                    continue;
                }
                if (n9 == foqh._e._P) {
                    n8 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                    n7 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                    n6 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                    n5 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                    if (n8 != foqh._e._P || n7 != foqh._e._P || n6 != foqh._e._P || n5 != foqh._e._P) {
                        nArray2[j + i * n3] = foqh._v._P;
                        continue;
                    }
                    nArray2[j + i * n3] = n9;
                    continue;
                }
                nArray2[j + i * n3] = n9;
            }
        }
        return nArray2;
    }
}


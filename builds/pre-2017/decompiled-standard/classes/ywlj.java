/*
 * Decompiled with CFR 0.152.
 */
public class ywlj
extends lqgz {
    public ywlj(long l, lqgz lqgz2) {
        super(l);
        this._b = lqgz2;
    }

    @Override
    public int[] _a(int n, int n2, int n3, int n4) {
        int n5;
        int n6 = n >> 1;
        int n7 = n2 >> 1;
        int n8 = (n3 >> 1) + 3;
        int n9 = (n4 >> 1) + 3;
        int[] nArray = this._b._a(n6, n7, n8, n9);
        int[] nArray2 = dins._a(n8 * 2 * (n9 * 2));
        int n10 = n8 << 1;
        for (int i = 0; i < n9 - 1; ++i) {
            n5 = i << 1;
            int n11 = n5 * n10;
            int n12 = nArray[0 + (i + 0) * n8];
            int n13 = nArray[0 + (i + 1) * n8];
            for (int j = 0; j < n8 - 1; ++j) {
                this._a((long)(j + n6 << 1), (long)(i + n7 << 1));
                int n14 = nArray[j + 1 + (i + 0) * n8];
                int n15 = nArray[j + 1 + (i + 1) * n8];
                nArray2[n11] = n12;
                nArray2[n11++ + n10] = this._a(n12, n13);
                nArray2[n11] = this._a(n12, n14);
                nArray2[n11++ + n10] = this._b(n12, n14, n13, n15);
                n12 = n14;
                n13 = n15;
            }
        }
        int[] nArray3 = dins._a(n3 * n4);
        for (n5 = 0; n5 < n4; ++n5) {
            System.arraycopy(nArray2, (n5 + (n2 & 1)) * (n8 << 1) + (n & 1), nArray3, n5 * n3, n3);
        }
        return nArray3;
    }

    public int _a(int n, int n2) {
        return this._a(2) == 0 ? n : n2;
    }

    public int _b(int n, int n2, int n3, int n4) {
        if (n2 == n3 && n3 == n4) {
            return n2;
        }
        if (n == n2 && n == n3) {
            return n;
        }
        if (n == n2 && n == n4) {
            return n;
        }
        if (n == n3 && n == n4) {
            return n;
        }
        if (n == n2 && n3 != n4) {
            return n;
        }
        if (n == n3 && n2 != n4) {
            return n;
        }
        if (n == n4 && n2 != n3) {
            return n;
        }
        if (n2 == n && n3 != n4) {
            return n2;
        }
        if (n2 == n3 && n != n4) {
            return n2;
        }
        if (n2 == n4 && n != n3) {
            return n2;
        }
        if (n3 == n && n2 != n4) {
            return n3;
        }
        if (n3 == n2 && n != n4) {
            return n3;
        }
        if (n3 == n4 && n != n2) {
            return n3;
        }
        if (n4 == n && n2 != n3) {
            return n3;
        }
        if (n4 == n2 && n != n3) {
            return n3;
        }
        if (n4 == n3 && n != n2) {
            return n3;
        }
        int n5 = this._a(4);
        if (n5 == 0) {
            return n;
        }
        if (n5 == 1) {
            return n2;
        }
        if (n5 == 2) {
            return n3;
        }
        return n4;
    }

    public static lqgz _a(long l, lqgz lqgz2, int n) {
        lqgz lqgz3 = lqgz2;
        for (int i = 0; i < n; ++i) {
            lqgz3 = new ywlj(l + (long)i, lqgz3);
        }
        return lqgz3;
    }
}


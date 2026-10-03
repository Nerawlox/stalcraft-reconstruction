/*
 * Decompiled with CFR 0.152.
 */
public class elsb
extends lqgz {
    public elsb(long l, lqgz lqgz2) {
        super(l);
        this._b = lqgz2;
    }

    @Override
    public int[] _a(int n, int n2, int n3, int n4) {
        int[] nArray = this._b._a(n, n2, n3, n4);
        int[] nArray2 = dins._a(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this._a(j + n, i + n2);
                nArray2[j + i * n3] = nArray[j + i * n3] > 0 ? this._a(2) + 2 : 0;
            }
        }
        return nArray2;
    }
}


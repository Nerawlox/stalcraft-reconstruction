/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public abstract class zzpm {
    public final boolean _p;

    public zzpm() {
        this._p = false;
    }

    public zzpm(boolean bl) {
        this._p = bl;
    }

    public abstract boolean _a(ozlu var1, Random var2, int var3, int var4, int var5);

    public void _a(double d, double d2, double d3) {
    }

    public void _b(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._a(ozlu2, n, n2, n3, n4, 0);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        if (this._p) {
            ozlu2.func_72832_d(n, n2, n3, n4, n5, 3);
        } else {
            ozlu2.func_72832_d(n, n2, n3, n4, n5, 2);
        }
    }
}


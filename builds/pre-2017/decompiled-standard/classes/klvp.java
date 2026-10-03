/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public class klvp
implements Comparator {
    public final /* synthetic */ uzta _a;
    public final /* synthetic */ htnv _b;

    public klvp(htnv htnv2, uzta uzta2) {
        this._b = htnv2;
        this._a = uzta2;
    }

    public int _a(huss huss2, huss huss3) {
        int n = huss2._a();
        int n2 = huss3._a();
        rann rann2 = null;
        rann rann3 = null;
        if (this._b._d == 0) {
            rann2 = dzif._F[n];
            rann3 = dzif._F[n2];
        } else if (this._b._d == 1) {
            rann2 = dzif._D[n];
            rann3 = dzif._D[n2];
        } else if (this._b._d == 2) {
            rann2 = dzif._E[n];
            rann3 = dzif._E[n2];
        }
        if (rann2 != null || rann3 != null) {
            int n3;
            if (rann2 == null) {
                return 1;
            }
            if (rann3 == null) {
                return -1;
            }
            int n4 = uzta._c(this._b._g)._a(rann2);
            if (n4 != (n3 = uzta._c(this._b._g)._a(rann3))) {
                return (n4 - n3) * this._b._e;
            }
        }
        return n - n2;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((huss)object, (huss)object2);
    }
}


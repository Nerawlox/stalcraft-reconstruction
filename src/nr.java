/*
 * Decompiled with CFR 0.152.
 */
public enum nr {
    a,
    b,
    c,
    d,
    e,
    f;


    public int a(double par1) {
        double d1 = par1 - ((double)ls.c(par1) + 0.5);
        switch (nq.a[this.ordinal()]) {
            case 1: {
                if (d1 < 0.0 ? d1 < -0.3125 : d1 < 0.3125) {
                    return ls.f(par1 * 32.0);
                }
                return ls.c(par1 * 32.0);
            }
            case 2: {
                if (d1 < 0.0 ? d1 < -0.3125 : d1 < 0.3125) {
                    return ls.c(par1 * 32.0);
                }
                return ls.f(par1 * 32.0);
            }
            case 3: {
                if (d1 > 0.0) {
                    return ls.c(par1 * 32.0);
                }
                return ls.f(par1 * 32.0);
            }
            case 4: {
                if (d1 < 0.0 ? d1 < -0.1875 : d1 < 0.1875) {
                    return ls.f(par1 * 32.0);
                }
                return ls.c(par1 * 32.0);
            }
            case 5: {
                if (d1 < 0.0 ? d1 < -0.1875 : d1 < 0.1875) {
                    return ls.c(par1 * 32.0);
                }
                return ls.f(par1 * 32.0);
            }
        }
        if (d1 > 0.0) {
            return ls.f(par1 * 32.0);
        }
        return ls.c(par1 * 32.0);
    }
}


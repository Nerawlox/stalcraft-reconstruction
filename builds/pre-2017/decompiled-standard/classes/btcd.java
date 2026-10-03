/*
 * Decompiled with CFR 0.152.
 */
public final class btcd
implements bcaw {
    @Override
    public String _a(int n) {
        double d = (double)n / 100.0;
        double d2 = d / 1000.0;
        if (d2 > 0.5) {
            return rann.func_75969_k().format(d2) + " km";
        }
        if (d > 0.5) {
            return rann.func_75969_k().format(d) + " m";
        }
        return n + " cm";
    }
}


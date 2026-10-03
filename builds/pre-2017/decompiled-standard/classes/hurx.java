/*
 * Decompiled with CFR 0.152.
 */
public final class hurx
implements bcaw {
    @Override
    public String _a(int n) {
        double d = (double)n / 20.0;
        double d2 = d / 60.0;
        double d3 = d2 / 60.0;
        double d4 = d3 / 24.0;
        double d5 = d4 / 365.0;
        if (d5 > 0.5) {
            return rann.func_75969_k().format(d5) + " y";
        }
        if (d4 > 0.5) {
            return rann.func_75969_k().format(d4) + " d";
        }
        if (d3 > 0.5) {
            return rann.func_75969_k().format(d3) + " h";
        }
        if (d2 > 0.5) {
            return rann.func_75969_k().format(d2) + " m";
        }
        return d + " s";
    }
}


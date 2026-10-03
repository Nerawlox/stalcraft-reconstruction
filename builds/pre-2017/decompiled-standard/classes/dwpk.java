/*
 * Decompiled with CFR 0.152.
 */
public class dwpk
implements rplk {
    public static ejcz[] _a = new ejcz[8];
    public static ejcz[] _b = new ejcz[3];
    public static ejcz[] _c = new ejcz[4];
    public static ejcz _d;
    public static ejcz _e;
    public static ejcz _f;
    public static ejcz _g;
    public static ejcz _h;
    public static ejcz _i;
    public static ejcz _j;
    public static ejcz _k;
    public static ejcz _l;
    public static ejcz _m;
    public static ejcz _n;
    public static ejcz _o;
    public static ejcz _p;
    public static ejcz _q;

    @Override
    public void registerIcons(nege nege2) {
        int n;
        for (n = 0; n < 3; ++n) {
            dwpk._b[n] = (ejcz)nege2._b("anomalies:leaf/leaf" + (n + 1));
        }
        for (n = 0; n < 8; ++n) {
            dwpk._a[n] = (ejcz)nege2._b("anomalies:dust/dust" + (n + 1));
        }
        for (n = 0; n < 4; ++n) {
            dwpk._c[n] = (ejcz)nege2._b("anomalies:lighter/newfire" + (n + 1));
        }
        _d = (ejcz)nege2._b("anomalies:electra/idle");
        _p = (ejcz)nege2._b("anomalies:lighter/spark");
        _q = (ejcz)nege2._b("anomalies:lighter/distortion");
        _m = (ejcz)nege2._b("anomalies:funnel/funnel_eye");
        _l = (ejcz)nege2._b("anomalies:funnel/distortion");
        _h = (ejcz)nege2._b("anomalies:electra/active");
        _k = (ejcz)nege2._b("anomalies:bloodsplash");
        _i = (ejcz)nege2._b("anomalies:bolt_throw");
        _j = (ejcz)nege2._b("anomalies:bolt_distortion");
        _n = (ejcz)nege2._b("anomalies:bubble");
        _o = (ejcz)nege2._b("anomalies:bubble_distortion");
        _g = (ejcz)nege2._b("anomalies:steam/steam1");
        _e = (ejcz)nege2._b("anomalies:trampoline/distortion");
        _f = (ejcz)nege2._b("anomalies:trampoline/idle");
    }
}


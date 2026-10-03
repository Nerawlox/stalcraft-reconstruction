/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.texture.IconRegister;

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
    public void registerIcons(IconRegister iconRegister) {
        int n;
        for (n = 0; n < 3; ++n) {
            dwpk._b[n] = (ejcz)iconRegister._b("anomalies:leaf/leaf" + (n + 1));
        }
        for (n = 0; n < 8; ++n) {
            dwpk._a[n] = (ejcz)iconRegister._b("anomalies:dust/dust" + (n + 1));
        }
        for (n = 0; n < 4; ++n) {
            dwpk._c[n] = (ejcz)iconRegister._b("anomalies:lighter/newfire" + (n + 1));
        }
        _d = (ejcz)iconRegister._b("anomalies:electra/idle");
        _p = (ejcz)iconRegister._b("anomalies:lighter/spark");
        _q = (ejcz)iconRegister._b("anomalies:lighter/distortion");
        _m = (ejcz)iconRegister._b("anomalies:funnel/funnel_eye");
        _l = (ejcz)iconRegister._b("anomalies:funnel/distortion");
        _h = (ejcz)iconRegister._b("anomalies:electra/active");
        _k = (ejcz)iconRegister._b("anomalies:bloodsplash");
        _i = (ejcz)iconRegister._b("anomalies:bolt_throw");
        _j = (ejcz)iconRegister._b("anomalies:bolt_distortion");
        _n = (ejcz)iconRegister._b("anomalies:bubble");
        _o = (ejcz)iconRegister._b("anomalies:bubble_distortion");
        _g = (ejcz)iconRegister._b("anomalies:steam/steam1");
        _e = (ejcz)iconRegister._b("anomalies:trampoline/distortion");
        _f = (ejcz)iconRegister._b("anomalies:trampoline/idle");
    }
}


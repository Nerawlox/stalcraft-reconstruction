/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class yewu {
    public static final yewu _a = new yewu();
    public Map _b = new HashMap();
    public Map _c = new HashMap();
    public HashMap<List<Integer>, cvzo> _d = new HashMap();
    public HashMap<List<Integer>, Float> _e = new HashMap();

    public static final yewu _a() {
        return _a;
    }

    public yewu() {
        this._a(twgu.field_71949_H.field_71990_ca, new cvzo(tgdv.field_77703_o), 0.7f);
        this._a(twgu.field_71941_G.field_71990_ca, new cvzo(tgdv.field_77717_p), 1.0f);
        this._a(twgu.field_72073_aw.field_71990_ca, new cvzo(tgdv.field_77702_n), 1.0f);
        this._a(twgu.field_71939_E.field_71990_ca, new cvzo(twgu.field_71946_M), 0.1f);
        this._a(tgdv.field_77784_aq.field_77779_bT, new cvzo(tgdv.field_77782_ar), 0.35f);
        this._a(tgdv.field_77741_bi.field_77779_bT, new cvzo(tgdv.field_77734_bj), 0.35f);
        this._a(tgdv.field_77735_bk.field_77779_bT, new cvzo(tgdv.field_77736_bl), 0.35f);
        this._a(tgdv.field_77754_aU.field_77779_bT, new cvzo(tgdv.field_77753_aV), 0.35f);
        this._a(twgu.field_71978_w.field_71990_ca, new cvzo(twgu.field_71981_t), 0.1f);
        this._a(tgdv.field_77757_aI.field_77779_bT, new cvzo(tgdv.field_77772_aH), 0.3f);
        this._a(twgu.field_72041_aW.field_71990_ca, new cvzo(twgu.field_111032_cD), 0.35f);
        this._a(twgu.field_72038_aV.field_71990_ca, new cvzo(tgdv.field_77756_aW, 1, 2), 0.2f);
        this._a(twgu.field_71951_J.field_71990_ca, new cvzo(tgdv.field_77705_m, 1, 1), 0.15f);
        this._a(twgu.field_72068_bR.field_71990_ca, new cvzo(tgdv.field_77817_bH), 1.0f);
        this._a(tgdv.field_82794_bL.field_77779_bT, new cvzo(tgdv.field_82795_bM), 0.35f);
        this._a(twgu.field_72012_bb.field_71990_ca, new cvzo(tgdv.field_94584_bZ), 0.1f);
        this._a(twgu.field_71950_I.field_71990_ca, new cvzo(tgdv.field_77705_m), 0.1f);
        this._a(twgu.field_72047_aN.field_71990_ca, new cvzo(tgdv.field_77767_aC), 0.7f);
        this._a(twgu.field_71947_N.field_71990_ca, new cvzo(tgdv.field_77756_aW, 1, 4), 0.2f);
        this._a(twgu.field_94342_cr.field_71990_ca, new cvzo(tgdv.field_94583_ca), 0.2f);
    }

    public void _a(int n, cvzo cvzo2, float f) {
        this._b.put(n, cvzo2);
        this._c.put(cvzo2._d, Float.valueOf(f));
    }

    @Deprecated
    public cvzo _a(int n) {
        return (cvzo)this._b.get(n);
    }

    public Map _b() {
        return this._b;
    }

    @Deprecated
    public float _b(int n) {
        return this._c.containsKey(n) ? ((Float)this._c.get(n)).floatValue() : 0.0f;
    }

    public void _a(int n, int n2, cvzo cvzo2, float f) {
        this._d.put(Arrays.asList(n, n2), cvzo2);
        this._e.put(Arrays.asList(cvzo2._d, cvzo2._j()), Float.valueOf(f));
    }

    public cvzo _a(cvzo cvzo2) {
        if (cvzo2 == null) {
            return null;
        }
        cvzo cvzo3 = this._d.get(Arrays.asList(cvzo2._d, cvzo2._j()));
        if (cvzo3 != null) {
            return cvzo3;
        }
        return (cvzo)this._b.get(cvzo2._d);
    }

    public float _b(cvzo cvzo2) {
        if (cvzo2 == null || cvzo2._a() == null) {
            return 0.0f;
        }
        float f = cvzo2._a().getSmeltingExperience(cvzo2);
        if (f < 0.0f && this._e.containsKey(Arrays.asList(cvzo2._d, cvzo2._j()))) {
            f = this._e.get(Arrays.asList(cvzo2._d, cvzo2._j())).floatValue();
        }
        if (f < 0.0f && this._c.containsKey(cvzo2._d)) {
            f = ((Float)this._c.get(cvzo2._d)).floatValue();
        }
        return f < 0.0f ? 0.0f : f;
    }

    public Map<List<Integer>, cvzo> _c() {
        return this._d;
    }
}


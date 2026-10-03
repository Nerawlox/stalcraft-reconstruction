/*
 * Decompiled with CFR 0.152.
 */
public class hufu
extends focs {
    public static final twgu[] _a = new twgu[]{twgu.field_71978_w, twgu.field_72085_aj, twgu.field_72079_ak, twgu.field_71981_t, twgu.field_71957_Q, twgu.field_72087_ao, twgu.field_71949_H, twgu.field_72083_ai, twgu.field_71950_I, twgu.field_72105_ah, twgu.field_71941_G, twgu.field_72073_aw, twgu.field_72071_ax, twgu.field_72036_aT, twgu.field_72012_bb, twgu.field_71947_N, twgu.field_71948_O, twgu.field_72047_aN, twgu.field_72048_aO, twgu.field_72056_aG, twgu.field_71953_U, twgu.field_71954_T, twgu.field_94337_cv};

    public hufu(int n, txfz txfz2) {
        super(n, 2.0f, txfz2, _a);
    }

    @Override
    public boolean func_77641_a(twgu twgu2) {
        if (twgu2 == twgu.field_72089_ap) {
            return this._e._d() == 3;
        }
        if (twgu2 == twgu.field_72071_ax || twgu2 == twgu.field_72073_aw) {
            return this._e._d() >= 2;
        }
        if (twgu2 == twgu.field_72068_bR || twgu2 == twgu.field_72076_bV) {
            return this._e._d() >= 2;
        }
        if (twgu2 == twgu.field_72105_ah || twgu2 == twgu.field_71941_G) {
            return this._e._d() >= 2;
        }
        if (twgu2 == twgu.field_72083_ai || twgu2 == twgu.field_71949_H) {
            return this._e._d() >= 1;
        }
        if (twgu2 == twgu.field_71948_O || twgu2 == twgu.field_71947_N) {
            return this._e._d() >= 1;
        }
        if (twgu2 == twgu.field_72047_aN || twgu2 == twgu.field_72048_aO) {
            return this._e._d() >= 2;
        }
        if (twgu2.field_72018_cp == tflj._e) {
            return true;
        }
        if (twgu2.field_72018_cp == tflj._f) {
            return true;
        }
        return twgu2.field_72018_cp == tflj._g;
    }

    @Override
    public float func_77638_a(cvzo cvzo2, twgu twgu2) {
        if (twgu2 != null && (twgu2.field_72018_cp == tflj._f || twgu2.field_72018_cp == tflj._g || twgu2.field_72018_cp == tflj._e)) {
            return this._c;
        }
        return super.func_77638_a(cvzo2, twgu2);
    }
}


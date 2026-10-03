/*
 * Decompiled with CFR 0.152.
 */
public interface tezq {
    public static final String _a_ = "mdmgm";

    default public float _e_(cvzo cvzo2) {
        float f = 1.0f;
        if (cvzo2._e != null && cvzo2._e._c(_a_)) {
            f *= cvzo2._e._h(_a_);
        }
        return f;
    }

    default public cvzo _a(cvzo cvzo2, float f) {
        if (cvzo2._e == null) {
            cvzo2._e = new qoac();
        }
        float f2 = this._e_(cvzo2) * f;
        cvzo2._e._a(_a_, f2);
        return cvzo2;
    }
}


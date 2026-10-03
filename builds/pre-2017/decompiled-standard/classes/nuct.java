/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface nuct
extends cucv {
    public void _b();

    public jhuw _a();

    public wnxc _a(String var1);

    default public boolean _c() {
        return this._v_().isEmpty();
    }

    default public boolean _a(uhrn uhrn2) {
        return this._v_().remove(uhrn2);
    }

    default public void _f() {
        this._v_().clear();
    }

    default public void _g() {
        for (uhrn uhrn2 : this._v_()) {
            uhrn2.speedFactor = 0.0f;
        }
    }

    default public void _a(uhrn uhrn2, float f) {
        if (f > 0.0f) {
            this._d(uhrn2, f);
        }
        this._d(uhrn2);
    }

    default public void _b(uhrn uhrn2, float f) {
        if (f <= 0.0f) {
            this._b(uhrn2);
        } else {
            for (uhrn uhrn3 : this._a(uhrn2.layer)) {
                uhrn3.weightTickModifier = -1.0f / f;
            }
            this._d(uhrn2, f);
            this._d(uhrn2);
        }
    }

    default public void _c(uhrn uhrn2, float f) {
        this._d(uhrn2, f);
        this._e().add(uhrn2);
    }

    default public void _b(uhrn uhrn2) {
        this._v_().removeIf(uhrn3 -> uhrn3.layer == uhrn2.layer);
        this._d(uhrn2);
    }

    default public void _c(uhrn uhrn2) {
        this._e().add(uhrn2);
    }

    default public List<uhrn> _a(nuco nuco2) {
        ArrayList<uhrn> arrayList = new ArrayList<uhrn>();
        for (uhrn uhrn2 : this._v_()) {
            if (uhrn2.layer != nuco2) continue;
            arrayList.add(uhrn2);
        }
        return arrayList;
    }

    default public void _d(uhrn uhrn2, float f) {
        uhrn2.weight = 1.0E-4f;
        uhrn2.prevWeight = 1.0E-4f;
        uhrn2.weightTickModifier = 1.0f / f;
    }

    default public void _d(uhrn uhrn2) {
        this._v_().add(uhrn2);
        Collections.sort(this._v_());
    }

    public List<uhrn> _v_();

    public List<uhrn> _e();
}


/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class zxbe
implements nuct {
    protected List<uhrn> _a = new ArrayList<uhrn>(2);
    protected List<uhrn> _b = new ArrayList<uhrn>(2);
    private ivtm _e;
    private static final Quaternion _f = new Quaternion();
    public final jhuw _c;
    public final iest[] _d;
    private Quaternion _g = new Quaternion();
    private Quaternion _h = new Quaternion();
    private Vector3f _i = new Vector3f();
    private Vector3f _j = new Vector3f();

    public zxbe(jhuw jhuw2, iest ... iestArray) {
        if (jhuw2 == null) {
            throw new IllegalArgumentException("Model can not be null!");
        }
        this._c = jhuw2;
        this._d = iestArray;
    }

    public zxbe(jhuw jhuw2, zxbe zxbe2) {
        this(jhuw2, new iest[0]);
        for (uhrn uhrn2 : zxbe2._a) {
            this._a.add(uhrn2);
        }
    }

    @Override
    public wnxc _a(String string) {
        gpnv gpnv2 = this._c.getInbuiltAnimationLibrary();
        wnxc wnxc2 = gpnv2 == null ? null : gpnv2._a(string);
        int n = -1;
        while (wnxc2 == null && ++n < this._d.length) {
            wnxc2 = this._d[n]._a._a(string);
        }
        return wnxc2;
    }

    @Override
    public jhuw _a() {
        return this._c;
    }

    @Override
    public void _b() {
        uhrn uhrn2;
        int n;
        for (n = 0; n < this._a.size(); ++n) {
            this._a.get(n).tick(this);
        }
        for (n = 0; n < this._b.size(); ++n) {
            uhrn2 = this._b.get(n);
            if (!this._b(uhrn2.layer)) continue;
            if (uhrn2.weightTickModifier != 0.0f) {
                for (int i = 0; i < this._a.size(); ++i) {
                    uhrn uhrn3 = this._a.get(i);
                    if (uhrn3.layer != uhrn2.layer || !uhrn3.toRemove) continue;
                    uhrn3.weightTickModifier -= uhrn2.weightTickModifier;
                    uhrn3.toRemove = false;
                }
            }
            this._b.remove(n--);
            this._d(uhrn2);
        }
        for (n = 0; n < this._a.size(); ++n) {
            uhrn2 = this._a.get(n);
            if (uhrn2.isActive()) continue;
            uhrn2.onRemove();
            this._a.remove(n--);
        }
    }

    private boolean _b(nuco nuco2) {
        for (int i = 0; i < this._a.size(); ++i) {
            uhrn uhrn2 = this._a.get(i);
            if (uhrn2.layer != nuco2 || !uhrn2.isActive()) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean _c() {
        return this._a.size() == 0;
    }

    @Override
    public List<uhrn> _v_() {
        return this._a;
    }

    @Override
    public List<uhrn> _e() {
        return this._b;
    }

    @Override
    public ivtm _a(float f) {
        return this._a(false, f);
    }

    public ivtm _a(boolean bl, float f) {
        ivtm ivtm2 = this._e;
        if (this._c()) {
            return this._a().getSkeleton()._e;
        }
        if (ivtm2 == null || ivtm2._a() != this._a().getNumBones()) {
            ivtm2 = this._h();
        }
        this._a(ivtm2, f);
        if (bl) {
            this._h();
        }
        return ivtm2;
    }

    public ivtm _a(ivtm ivtm2, float f) {
        int n;
        jhuw jhuw2 = this._a();
        jywl jywl2 = jhuw2.getSkeleton();
        if (ivtm2._a() != jywl2._a) {
            throw new IllegalArgumentException("Illegal number of bones in given skeleton state!");
        }
        if (this._c()) {
            ivtm2._a(jywl2._e);
            return ivtm2;
        }
        nuco nuco2 = null;
        for (n = 0; n < this._a.size(); ++n) {
            uhrn uhrn2 = this._a.get(n);
            if (nuco2 != uhrn2.layer) {
                nuco2 = uhrn2.layer;
                nuco2._b = 0.0f;
            }
            uhrn2.update(this, ivtm2, f);
            if (!uhrn2.shouldApply()) continue;
            nuco2._b += uhrn2.getWeight(f);
        }
        for (n = 0; n < jhuw2.getSkeleton()._b; ++n) {
            this._a(ivtm2, jhuw2.getSkeleton()._b(n), f);
        }
        return ivtm2;
    }

    public ivtm _a(List<uhrn> list, boolean bl, float f) {
        List<uhrn> list2 = this._a;
        this._a = list;
        ivtm ivtm2 = this._a(bl, f);
        this._a = list2;
        return ivtm2;
    }

    private ivtm _h() {
        this._e = new ivtm(this._a().getNumBones());
        return this._e;
    }

    protected void _a(ivtm ivtm2, jywl.kjui kjui2, float f) {
        Object object;
        int n;
        Quaternion quaternion = ivtm2._b[kjui2._c];
        Vector3f vector3f = ivtm2._a[kjui2._c];
        Quaternion quaternion2 = kjui2._a == null ? _f : ivtm2._b[kjui2._a._c];
        quaternion.setIdentity();
        vector3f.set(0.0f, 0.0f, 0.0f);
        float f2 = 0.0f;
        nuco nuco2 = null;
        for (n = 0; n < this._a.size(); ++n) {
            object = this._a.get(n);
            if (!((uhrn)object).layer._a(kjui2) || !((uhrn)object).shouldApply()) continue;
            float f3 = ((uhrn)object).getWeight(f);
            f2 += f3;
            this._h.setIdentity();
            boolean bl = ((uhrn)object).writeRotation(kjui2, this._h);
            if (bl) {
                Quaternion.mul(this._h, quaternion2, this._h);
            }
            if (((uhrn)object).layer != nuco2) {
                quaternion.set(this._h);
            } else {
                jywc._a(quaternion, this._h, quaternion, f3 / f2);
            }
            this._i.set(0.0f, 0.0f, 0.0f);
            boolean bl2 = ((uhrn)object).writeTranslation(kjui2, this._i);
            this._i.scale(f3 / ((uhrn)object).layer._b);
            if (bl2 && kjui2._a != null) {
                this._j.set(ivtm2._a[kjui2._a._c]);
                this._j.scale(f3 / ((uhrn)object).layer._b);
                Vector3f.add(vector3f, this._j, vector3f);
                jywc._a(quaternion2, this._i, this._i);
            }
            Vector3f.add(vector3f, this._i, vector3f);
            nuco2 = ((uhrn)object).layer;
            if (n + 1 != this._a.size() && this._a.get((int)(n + 1)).layer == nuco2) continue;
            f2 = 0.0f;
        }
        if (kjui2._b.size() > 0) {
            for (n = 0; n < kjui2._b.size(); ++n) {
                object = kjui2._b.get(n);
                this._a(ivtm2, (jywl.kjui)object, f);
            }
        }
    }

    public String toString() {
        return "{AnimationContext for " + this._c.location + "}";
    }
}


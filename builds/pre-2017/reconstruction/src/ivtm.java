/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class ivtm
implements cucv {
    public final Vector3f[] _a;
    public final Quaternion[] _b;

    public ivtm(int n) {
        int n2;
        this._a = new Vector3f[n];
        this._b = new Quaternion[n];
        for (n2 = 0; n2 < this._a.length; ++n2) {
            this._a[n2] = new Vector3f();
        }
        for (n2 = 0; n2 < this._b.length; ++n2) {
            this._b[n2] = new Quaternion();
        }
    }

    public ivtm(ivtm ivtm2) {
        this(ivtm2._a());
        this._a(ivtm2);
    }

    public int _a() {
        return this._a.length;
    }

    public void _a(ivtm ivtm2) {
        int n;
        if (this._a() != ivtm2._a()) {
            throw new IllegalArgumentException("Can not copy skeleton state from state with different number of bones!");
        }
        for (n = 0; n < this._a.length; ++n) {
            this._a[n].set(ivtm2._a[n]);
        }
        for (n = 0; n < this._b.length; ++n) {
            this._b[n].set(ivtm2._b[n]);
        }
    }

    public Vector3f _a(int n, Vector3f vector3f) {
        Vector3f vector3f2 = jywc._a(this._b[n], vector3f, null);
        Vector3f.add(vector3f2, this._a[n], vector3f2);
        return vector3f2;
    }

    @Override
    public ivtm _a(float f) {
        return this;
    }
}


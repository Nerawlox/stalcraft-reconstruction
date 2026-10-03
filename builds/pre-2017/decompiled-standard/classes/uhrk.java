/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class uhrk
extends uhrn {
    private ivtm _c;
    public jywl _a;
    public cucv _b;

    public uhrk(nuco nuco2, jywl jywl2, cucv cucv2) {
        super(nuco2);
        this._a = jywl2;
        this._b = cucv2;
    }

    @Override
    public void update(zxbe zxbe2, ivtm ivtm2, float f) {
        this._c = this._b._a(f);
    }

    @Override
    public boolean writeRotation(jywl.kjui kjui2, Quaternion quaternion) {
        jywl.kjui kjui3 = this._a._a(kjui2._d);
        if (kjui3 != null) {
            quaternion.set(this._c._b[kjui3._c]);
        }
        return false;
    }

    @Override
    public boolean writeTranslation(jywl.kjui kjui2, Vector3f vector3f) {
        jywl.kjui kjui3 = this._a._a(kjui2._d);
        if (kjui3 != null) {
            vector3f.set(this._c._a[kjui3._c]);
        }
        return false;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class vkul
extends uhrn {
    private zxbe _a;

    public vkul(nuco nuco2) {
        super(nuco2);
    }

    @Override
    public void update(zxbe zxbe2, ivtm ivtm2, float f) {
        this._a = zxbe2;
    }

    @Override
    public boolean writeRotation(jywl.kjui kjui2, Quaternion quaternion) {
        return true;
    }

    @Override
    public boolean writeTranslation(jywl.kjui kjui2, Vector3f vector3f) {
        vector3f.set(this._a._a().getSkeleton()._e._a[kjui2._c]);
        return false;
    }
}


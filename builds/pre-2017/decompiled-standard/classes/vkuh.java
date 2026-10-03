/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class vkuh
extends uhrn {
    public Quaternion _a = new Quaternion();
    public Vector3f _b = new Vector3f();

    public vkuh(nuco nuco2) {
        super(nuco2);
    }

    @Override
    public void update(zxbe zxbe2, ivtm ivtm2, float f) {
    }

    @Override
    public boolean writeRotation(jywl.kjui kjui2, Quaternion quaternion) {
        if (kjui2._a == null && this._a != null) {
            Quaternion.mul(quaternion, this._a, quaternion);
        }
        return false;
    }

    @Override
    public boolean writeTranslation(jywl.kjui kjui2, Vector3f vector3f) {
        if (kjui2._a == null && this._b != null) {
            Vector3f.add(vector3f, this._b, vector3f);
        }
        return false;
    }
}


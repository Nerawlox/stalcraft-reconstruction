/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.smplayer;

import gloomyfolken.mods.stalker.smplayer.eidj;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public abstract class kjui
extends vkum {
    protected eidj[] _a;

    public kjui(nuco nuco2) {
        super(nuco2);
    }

    @Override
    public void update(zxbe zxbe2, ivtm ivtm2, float f) {
        super.update(zxbe2, ivtm2, f);
        this._a();
    }

    public void _a() {
        if (this._a == null) {
            jywl jywl2 = this.context._a().getSkeleton();
            this._a = new eidj[jywl2._a];
            for (int i = 0; i < jywl2._a; ++i) {
                this._a[i] = this._a(jywl2._a((int)i)._d);
            }
        }
    }

    private eidj _a(jywl.kjui kjui2) {
        return this._a[kjui2._c];
    }

    protected abstract eidj _a(String var1);

    @Override
    public boolean writeRotation(jywl.kjui kjui2, Quaternion quaternion) {
        eidj eidj2 = this._a(kjui2._d);
        if (eidj2 == null) {
            return true;
        }
        if (!eidj2.ignoreBase() && !eidj2.ignoreSuperRotation() && kjui2._a != null) {
            Quaternion.mul(quaternion, this.target._b[kjui2._a._c], quaternion);
        }
        this._a(quaternion, eidj2.rotationOrder(), eidj2.rotateAngleX(), eidj2.rotateAngleY(), eidj2.rotateAngleZ());
        return false;
    }

    private void _a(Quaternion quaternion, int n, float f, float f2, float f3) {
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        if (Float.isNaN(f2)) {
            f2 = 0.0f;
        }
        if (Float.isNaN(f3)) {
            f3 = 0.0f;
        }
        if (n == 0) {
            this.rotate(quaternion, -f3, 0.0f, 0.0f, 1.0f);
            this.rotate(quaternion, -f2, 0.0f, 1.0f, 0.0f);
            this.rotate(quaternion, f, 1.0f, 0.0f, 0.0f);
        } else if (n == 3) {
            this.rotate(quaternion, f, 1.0f, 0.0f, 0.0f);
            this.rotate(quaternion, -f3, 0.0f, 0.0f, 1.0f);
            this.rotate(quaternion, -f2, 0.0f, 1.0f, 0.0f);
        } else if (n == 4) {
            this.rotate(quaternion, -f2, 0.0f, 1.0f, 0.0f);
            this.rotate(quaternion, f, 1.0f, 0.0f, 0.0f);
            this.rotate(quaternion, -f3, 0.0f, 0.0f, 1.0f);
        } else if (n == 5) {
            this.rotate(quaternion, f, 1.0f, 0.0f, 0.0f);
            this.rotate(quaternion, -f2, 0.0f, 1.0f, 0.0f);
            this.rotate(quaternion, -f3, 0.0f, 0.0f, 1.0f);
        } else if (n == 2) {
            this.rotate(quaternion, -f3, 0.0f, 0.0f, 1.0f);
            this.rotate(quaternion, f, 1.0f, 0.0f, 0.0f);
            this.rotate(quaternion, -f2, 0.0f, 1.0f, 0.0f);
        } else if (n == 1) {
            this.rotate(quaternion, -f2, 0.0f, 1.0f, 0.0f);
            this.rotate(quaternion, -f3, 0.0f, 0.0f, 1.0f);
            this.rotate(quaternion, f, 1.0f, 0.0f, 0.0f);
        }
    }

    @Override
    public boolean writeTranslation(jywl.kjui kjui2, Vector3f vector3f) {
        eidj eidj2 = this._a(kjui2._d);
        if (eidj2 != null && !eidj2.ignoreBase()) {
            if (kjui2._a == null) {
                vector3f.set(this.context._a().getSkeleton()._e._a[kjui2._c]);
                vector3f.x += eidj2.rotationPointX() / 16.0f;
                vector3f.y -= eidj2.rotationPointY() / 16.0f;
                vector3f.z -= eidj2.rotationPointZ() / 16.0f;
            } else {
                vector3f.set(eidj2.rotationPointX() / 16.0f + eidj2.translationOffsetX(), -eidj2.rotationPointY() / 16.0f - eidj2.translationOffsetY(), -eidj2.rotationPointZ() / 16.0f - eidj2.translationOffsetZ());
            }
        } else {
            Vector3f.sub(this.context._a().getSkeleton()._e._a[kjui2._c], this.context._a().getSkeleton()._e._a[kjui2._a._c], vector3f);
            eidj eidj3 = this._a(kjui2._a._d);
            if (eidj3 != null) {
                // empty if block
            }
        }
        return true;
    }
}


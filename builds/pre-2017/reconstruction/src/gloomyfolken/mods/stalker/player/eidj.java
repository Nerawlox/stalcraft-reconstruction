/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.mods.stalker.player.zwat;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public abstract class eidj
extends vkum {
    protected zwat[] renderers;

    public eidj(nuco nuco2) {
        super(nuco2);
    }

    @Override
    public void update(zxbe zxbe2, ivtm ivtm2, float f) {
        super.update(zxbe2, ivtm2, f);
        if (this.renderers == null) {
            jywl jywl2 = zxbe2._a().getSkeleton();
            this.renderers = new zwat[jywl2._a];
            for (int i = 0; i < jywl2._a; ++i) {
                this.renderers[i] = this.getRenderer(jywl2._a((int)i)._d);
            }
        }
    }

    protected zwat getRenderer(jywl.kjui kjui2) {
        return this.renderers[kjui2._c];
    }

    protected abstract zwat getRenderer(String var1);

    @Override
    public boolean writeRotation(jywl.kjui kjui2, Quaternion quaternion) {
        zwat zwat2 = this.getRenderer(kjui2._d);
        if (zwat2 == null) {
            return true;
        }
        jywc._a(quaternion, zwat2.rotateAngleX(), -zwat2.rotateAngleY(), -zwat2.rotateAngleZ());
        return false;
    }

    @Override
    public boolean writeTranslation(jywl.kjui kjui2, Vector3f vector3f) {
        zwat zwat2 = this.getRenderer(kjui2._d);
        if (zwat2 == null && kjui2._a == null) {
            vector3f.set(kjui2._e);
        } else if (zwat2 != null) {
            if (kjui2._a == null) {
                vector3f.set(this.context._a().getSkeleton()._e._a[kjui2._c]);
                vector3f.x += zwat2.rotationPointX() / 16.0f;
                vector3f.y -= zwat2.rotationPointY() / 16.0f;
                vector3f.z += zwat2.rotationPointZ() / 16.0f;
            } else {
                vector3f.set(zwat2.rotationPointX() / 16.0f, -zwat2.rotationPointY() / 16.0f, -zwat2.rotationPointZ() / 16.0f);
            }
        } else if (kjui2._b.isEmpty()) {
            Vector3f.sub(this.context._a().getSkeleton()._e._a[kjui2._c], this.context._a().getSkeleton()._e._a[kjui2._a._c], vector3f);
        }
        return true;
    }
}


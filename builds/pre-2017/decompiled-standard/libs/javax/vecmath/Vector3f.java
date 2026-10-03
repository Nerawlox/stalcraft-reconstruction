/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3d;

public class Vector3f
extends Tuple3f
implements Serializable {
    static final long serialVersionUID = -7031930069184524614L;

    public Vector3f(float f, float f2, float f3) {
        super(f, f2, f3);
    }

    public Vector3f(float[] fArray) {
        super(fArray);
    }

    public Vector3f(Vector3f vector3f) {
        super(vector3f);
    }

    public Vector3f(Vector3d vector3d) {
        super(vector3d);
    }

    public Vector3f(Tuple3f tuple3f) {
        super(tuple3f);
    }

    public Vector3f(Tuple3d tuple3d) {
        super(tuple3d);
    }

    public Vector3f() {
    }

    public final float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public final float length() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public final void cross(Vector3f vector3f, Vector3f vector3f2) {
        float f = vector3f.y * vector3f2.z - vector3f.z * vector3f2.y;
        float f2 = vector3f2.x * vector3f.z - vector3f2.z * vector3f.x;
        this.z = vector3f.x * vector3f2.y - vector3f.y * vector3f2.x;
        this.x = f;
        this.y = f2;
    }

    public final float dot(Vector3f vector3f) {
        return this.x * vector3f.x + this.y * vector3f.y + this.z * vector3f.z;
    }

    public final void normalize(Vector3f vector3f) {
        float f = (float)(1.0 / Math.sqrt(vector3f.x * vector3f.x + vector3f.y * vector3f.y + vector3f.z * vector3f.z));
        this.x = vector3f.x * f;
        this.y = vector3f.y * f;
        this.z = vector3f.z * f;
    }

    public final void normalize() {
        float f = (float)(1.0 / Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z));
        this.x *= f;
        this.y *= f;
        this.z *= f;
    }

    public final float angle(Vector3f vector3f) {
        double d = this.dot(vector3f) / (this.length() * vector3f.length());
        if (d < -1.0) {
            d = -1.0;
        }
        if (d > 1.0) {
            d = 1.0;
        }
        return (float)Math.acos(d);
    }
}


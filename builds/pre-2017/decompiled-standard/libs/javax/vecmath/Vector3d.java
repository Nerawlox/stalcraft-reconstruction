/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class Vector3d
extends Tuple3d
implements Serializable {
    static final long serialVersionUID = 3761969948420550442L;

    public Vector3d(double d, double d2, double d3) {
        super(d, d2, d3);
    }

    public Vector3d(double[] dArray) {
        super(dArray);
    }

    public Vector3d(Vector3d vector3d) {
        super(vector3d);
    }

    public Vector3d(Vector3f vector3f) {
        super(vector3f);
    }

    public Vector3d(Tuple3f tuple3f) {
        super(tuple3f);
    }

    public Vector3d(Tuple3d tuple3d) {
        super(tuple3d);
    }

    public Vector3d() {
    }

    public final void cross(Vector3d vector3d, Vector3d vector3d2) {
        double d = vector3d.y * vector3d2.z - vector3d.z * vector3d2.y;
        double d2 = vector3d2.x * vector3d.z - vector3d2.z * vector3d.x;
        this.z = vector3d.x * vector3d2.y - vector3d.y * vector3d2.x;
        this.x = d;
        this.y = d2;
    }

    public final void normalize(Vector3d vector3d) {
        double d = 1.0 / Math.sqrt(vector3d.x * vector3d.x + vector3d.y * vector3d.y + vector3d.z * vector3d.z);
        this.x = vector3d.x * d;
        this.y = vector3d.y * d;
        this.z = vector3d.z * d;
    }

    public final void normalize() {
        double d = 1.0 / Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        this.x *= d;
        this.y *= d;
        this.z *= d;
    }

    public final double dot(Vector3d vector3d) {
        return this.x * vector3d.x + this.y * vector3d.y + this.z * vector3d.z;
    }

    public final double lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public final double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public final double angle(Vector3d vector3d) {
        double d = this.dot(vector3d) / (this.length() * vector3d.length());
        if (d < -1.0) {
            d = -1.0;
        }
        if (d > 1.0) {
            d = 1.0;
        }
        return Math.acos(d);
    }
}


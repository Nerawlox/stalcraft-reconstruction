/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple3f;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;
import javax.vecmath.Vector4d;

public class Vector4f
extends Tuple4f
implements Serializable {
    static final long serialVersionUID = 8749319902347760659L;

    public Vector4f(float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
    }

    public Vector4f(float[] fArray) {
        super(fArray);
    }

    public Vector4f(Vector4f vector4f) {
        super(vector4f);
    }

    public Vector4f(Vector4d vector4d) {
        super(vector4d);
    }

    public Vector4f(Tuple4f tuple4f) {
        super(tuple4f);
    }

    public Vector4f(Tuple4d tuple4d) {
        super(tuple4d);
    }

    public Vector4f(Tuple3f tuple3f) {
        super(tuple3f.x, tuple3f.y, tuple3f.z, 0.0f);
    }

    public Vector4f() {
    }

    public final void set(Tuple3f tuple3f) {
        this.x = tuple3f.x;
        this.y = tuple3f.y;
        this.z = tuple3f.z;
        this.w = 0.0f;
    }

    public final float length() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }

    public final float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }

    public final float dot(Vector4f vector4f) {
        return this.x * vector4f.x + this.y * vector4f.y + this.z * vector4f.z + this.w * vector4f.w;
    }

    public final void normalize(Vector4f vector4f) {
        float f = (float)(1.0 / Math.sqrt(vector4f.x * vector4f.x + vector4f.y * vector4f.y + vector4f.z * vector4f.z + vector4f.w * vector4f.w));
        this.x = vector4f.x * f;
        this.y = vector4f.y * f;
        this.z = vector4f.z * f;
        this.w = vector4f.w * f;
    }

    public final void normalize() {
        float f = (float)(1.0 / Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w));
        this.x *= f;
        this.y *= f;
        this.z *= f;
        this.w *= f;
    }

    public final float angle(Vector4f vector4f) {
        double d = this.dot(vector4f) / (this.length() * vector4f.length());
        if (d < -1.0) {
            d = -1.0;
        }
        if (d > 1.0) {
            d = 1.0;
        }
        return (float)Math.acos(d);
    }
}


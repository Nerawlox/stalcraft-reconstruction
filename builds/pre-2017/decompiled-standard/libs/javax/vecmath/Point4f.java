/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Point4d;
import javax.vecmath.Tuple3f;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;

public class Point4f
extends Tuple4f
implements Serializable {
    static final long serialVersionUID = 4643134103185764459L;

    public Point4f(float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
    }

    public Point4f(float[] fArray) {
        super(fArray);
    }

    public Point4f(Point4f point4f) {
        super(point4f);
    }

    public Point4f(Point4d point4d) {
        super(point4d);
    }

    public Point4f(Tuple4f tuple4f) {
        super(tuple4f);
    }

    public Point4f(Tuple4d tuple4d) {
        super(tuple4d);
    }

    public Point4f(Tuple3f tuple3f) {
        super(tuple3f.x, tuple3f.y, tuple3f.z, 1.0f);
    }

    public Point4f() {
    }

    public final void set(Tuple3f tuple3f) {
        this.x = tuple3f.x;
        this.y = tuple3f.y;
        this.z = tuple3f.z;
        this.w = 1.0f;
    }

    public final float distanceSquared(Point4f point4f) {
        float f = this.x - point4f.x;
        float f2 = this.y - point4f.y;
        float f3 = this.z - point4f.z;
        float f4 = this.w - point4f.w;
        return f * f + f2 * f2 + f3 * f3 + f4 * f4;
    }

    public final float distance(Point4f point4f) {
        float f = this.x - point4f.x;
        float f2 = this.y - point4f.y;
        float f3 = this.z - point4f.z;
        float f4 = this.w - point4f.w;
        return (float)Math.sqrt(f * f + f2 * f2 + f3 * f3 + f4 * f4);
    }

    public final float distanceL1(Point4f point4f) {
        return Math.abs(this.x - point4f.x) + Math.abs(this.y - point4f.y) + Math.abs(this.z - point4f.z) + Math.abs(this.w - point4f.w);
    }

    public final float distanceLinf(Point4f point4f) {
        float f = Math.max(Math.abs(this.x - point4f.x), Math.abs(this.y - point4f.y));
        float f2 = Math.max(Math.abs(this.z - point4f.z), Math.abs(this.w - point4f.w));
        return Math.max(f, f2);
    }

    public final void project(Point4f point4f) {
        float f = 1.0f / point4f.w;
        this.x = point4f.x * f;
        this.y = point4f.y * f;
        this.z = point4f.z * f;
        this.w = 1.0f;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Point4f;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;

public class Point4d
extends Tuple4d
implements Serializable {
    static final long serialVersionUID = 1733471895962736949L;

    public Point4d(double d, double d2, double d3, double d4) {
        super(d, d2, d3, d4);
    }

    public Point4d(double[] dArray) {
        super(dArray);
    }

    public Point4d(Point4d point4d) {
        super(point4d);
    }

    public Point4d(Point4f point4f) {
        super(point4f);
    }

    public Point4d(Tuple4f tuple4f) {
        super(tuple4f);
    }

    public Point4d(Tuple4d tuple4d) {
        super(tuple4d);
    }

    public Point4d(Tuple3d tuple3d) {
        super(tuple3d.x, tuple3d.y, tuple3d.z, 1.0);
    }

    public Point4d() {
    }

    public final void set(Tuple3d tuple3d) {
        this.x = tuple3d.x;
        this.y = tuple3d.y;
        this.z = tuple3d.z;
        this.w = 1.0;
    }

    public final double distanceSquared(Point4d point4d) {
        double d = this.x - point4d.x;
        double d2 = this.y - point4d.y;
        double d3 = this.z - point4d.z;
        double d4 = this.w - point4d.w;
        return d * d + d2 * d2 + d3 * d3 + d4 * d4;
    }

    public final double distance(Point4d point4d) {
        double d = this.x - point4d.x;
        double d2 = this.y - point4d.y;
        double d3 = this.z - point4d.z;
        double d4 = this.w - point4d.w;
        return Math.sqrt(d * d + d2 * d2 + d3 * d3 + d4 * d4);
    }

    public final double distanceL1(Point4d point4d) {
        return Math.abs(this.x - point4d.x) + Math.abs(this.y - point4d.y) + Math.abs(this.z - point4d.z) + Math.abs(this.w - point4d.w);
    }

    public final double distanceLinf(Point4d point4d) {
        double d = Math.max(Math.abs(this.x - point4d.x), Math.abs(this.y - point4d.y));
        double d2 = Math.max(Math.abs(this.z - point4d.z), Math.abs(this.w - point4d.w));
        return Math.max(d, d2);
    }

    public final void project(Point4d point4d) {
        double d = 1.0 / point4d.w;
        this.x = point4d.x * d;
        this.y = point4d.y * d;
        this.z = point4d.z * d;
        this.w = 1.0;
    }
}


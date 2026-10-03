/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Point2d;
import javax.vecmath.Tuple2d;
import javax.vecmath.Tuple2f;

public class Point2f
extends Tuple2f
implements Serializable {
    static final long serialVersionUID = -4801347926528714435L;

    public Point2f(float f, float f2) {
        super(f, f2);
    }

    public Point2f(float[] fArray) {
        super(fArray);
    }

    public Point2f(Point2f point2f) {
        super(point2f);
    }

    public Point2f(Point2d point2d) {
        super(point2d);
    }

    public Point2f(Tuple2d tuple2d) {
        super(tuple2d);
    }

    public Point2f(Tuple2f tuple2f) {
        super(tuple2f);
    }

    public Point2f() {
    }

    public final float distanceSquared(Point2f point2f) {
        float f = this.x - point2f.x;
        float f2 = this.y - point2f.y;
        return f * f + f2 * f2;
    }

    public final float distance(Point2f point2f) {
        float f = this.x - point2f.x;
        float f2 = this.y - point2f.y;
        return (float)Math.sqrt(f * f + f2 * f2);
    }

    public final float distanceL1(Point2f point2f) {
        return Math.abs(this.x - point2f.x) + Math.abs(this.y - point2f.y);
    }

    public final float distanceLinf(Point2f point2f) {
        return Math.max(Math.abs(this.x - point2f.x), Math.abs(this.y - point2f.y));
    }
}


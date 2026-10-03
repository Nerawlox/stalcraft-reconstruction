/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Point2f;
import javax.vecmath.Tuple2d;
import javax.vecmath.Tuple2f;

public class Point2d
extends Tuple2d
implements Serializable {
    static final long serialVersionUID = 1133748791492571954L;

    public Point2d(double d, double d2) {
        super(d, d2);
    }

    public Point2d(double[] dArray) {
        super(dArray);
    }

    public Point2d(Point2d point2d) {
        super(point2d);
    }

    public Point2d(Point2f point2f) {
        super(point2f);
    }

    public Point2d(Tuple2d tuple2d) {
        super(tuple2d);
    }

    public Point2d(Tuple2f tuple2f) {
        super(tuple2f);
    }

    public Point2d() {
    }

    public final double distanceSquared(Point2d point2d) {
        double d = this.x - point2d.x;
        double d2 = this.y - point2d.y;
        return d * d + d2 * d2;
    }

    public final double distance(Point2d point2d) {
        double d = this.x - point2d.x;
        double d2 = this.y - point2d.y;
        return Math.sqrt(d * d + d2 * d2);
    }

    public final double distanceL1(Point2d point2d) {
        return Math.abs(this.x - point2d.x) + Math.abs(this.y - point2d.y);
    }

    public final double distanceLinf(Point2d point2d) {
        return Math.max(Math.abs(this.x - point2d.x), Math.abs(this.y - point2d.y));
    }
}


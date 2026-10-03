/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple2d;
import javax.vecmath.Tuple2f;
import javax.vecmath.Vector2f;

public class Vector2d
extends Tuple2d
implements Serializable {
    static final long serialVersionUID = 8572646365302599857L;

    public Vector2d(double d, double d2) {
        super(d, d2);
    }

    public Vector2d(double[] dArray) {
        super(dArray);
    }

    public Vector2d(Vector2d vector2d) {
        super(vector2d);
    }

    public Vector2d(Vector2f vector2f) {
        super(vector2f);
    }

    public Vector2d(Tuple2d tuple2d) {
        super(tuple2d);
    }

    public Vector2d(Tuple2f tuple2f) {
        super(tuple2f);
    }

    public Vector2d() {
    }

    public final double dot(Vector2d vector2d) {
        return this.x * vector2d.x + this.y * vector2d.y;
    }

    public final double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public final double lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }

    public final void normalize(Vector2d vector2d) {
        double d = 1.0 / Math.sqrt(vector2d.x * vector2d.x + vector2d.y * vector2d.y);
        this.x = vector2d.x * d;
        this.y = vector2d.y * d;
    }

    public final void normalize() {
        double d = 1.0 / Math.sqrt(this.x * this.x + this.y * this.y);
        this.x *= d;
        this.y *= d;
    }

    public final double angle(Vector2d vector2d) {
        double d = this.dot(vector2d) / (this.length() * vector2d.length());
        if (d < -1.0) {
            d = -1.0;
        }
        if (d > 1.0) {
            d = 1.0;
        }
        return Math.acos(d);
    }
}


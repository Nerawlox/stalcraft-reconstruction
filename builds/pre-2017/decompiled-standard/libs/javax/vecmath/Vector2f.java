/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple2d;
import javax.vecmath.Tuple2f;
import javax.vecmath.Vector2d;

public class Vector2f
extends Tuple2f
implements Serializable {
    static final long serialVersionUID = -2168194326883512320L;

    public Vector2f(float f, float f2) {
        super(f, f2);
    }

    public Vector2f(float[] fArray) {
        super(fArray);
    }

    public Vector2f(Vector2f vector2f) {
        super(vector2f);
    }

    public Vector2f(Vector2d vector2d) {
        super(vector2d);
    }

    public Vector2f(Tuple2f tuple2f) {
        super(tuple2f);
    }

    public Vector2f(Tuple2d tuple2d) {
        super(tuple2d);
    }

    public Vector2f() {
    }

    public final float dot(Vector2f vector2f) {
        return this.x * vector2f.x + this.y * vector2f.y;
    }

    public final float length() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public final float lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }

    public final void normalize(Vector2f vector2f) {
        float f = (float)(1.0 / Math.sqrt(vector2f.x * vector2f.x + vector2f.y * vector2f.y));
        this.x = vector2f.x * f;
        this.y = vector2f.y * f;
    }

    public final void normalize() {
        float f = (float)(1.0 / Math.sqrt(this.x * this.x + this.y * this.y));
        this.x *= f;
        this.y *= f;
    }

    public final float angle(Vector2f vector2f) {
        double d = this.dot(vector2f) / (this.length() * vector2f.length());
        if (d < -1.0) {
            d = -1.0;
        }
        if (d > 1.0) {
            d = 1.0;
        }
        return (float)Math.acos(d);
    }
}


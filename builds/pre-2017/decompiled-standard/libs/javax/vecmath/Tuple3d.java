/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Point3d;
import javax.vecmath.Tuple3f;
import javax.vecmath.VecMathUtil;

public abstract class Tuple3d
implements Serializable,
Cloneable {
    static final long serialVersionUID = 5542096614926168415L;
    public double x;
    public double y;
    public double z;

    public Tuple3d(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public Tuple3d(double[] dArray) {
        this.x = dArray[0];
        this.y = dArray[1];
        this.z = dArray[2];
    }

    public Tuple3d(Tuple3d tuple3d) {
        this.x = tuple3d.x;
        this.y = tuple3d.y;
        this.z = tuple3d.z;
    }

    public Tuple3d(Tuple3f tuple3f) {
        this.x = tuple3f.x;
        this.y = tuple3f.y;
        this.z = tuple3f.z;
    }

    public Tuple3d() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public final void set(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public final void set(double[] dArray) {
        this.x = dArray[0];
        this.y = dArray[1];
        this.z = dArray[2];
    }

    public final void set(Tuple3d tuple3d) {
        this.x = tuple3d.x;
        this.y = tuple3d.y;
        this.z = tuple3d.z;
    }

    public final void set(Tuple3f tuple3f) {
        this.x = tuple3f.x;
        this.y = tuple3f.y;
        this.z = tuple3f.z;
    }

    public final void get(double[] dArray) {
        dArray[0] = this.x;
        dArray[1] = this.y;
        dArray[2] = this.z;
    }

    public final void get(Tuple3d tuple3d) {
        tuple3d.x = this.x;
        tuple3d.y = this.y;
        tuple3d.z = this.z;
    }

    public final void add(Tuple3d tuple3d, Tuple3d tuple3d2) {
        this.x = tuple3d.x + tuple3d2.x;
        this.y = tuple3d.y + tuple3d2.y;
        this.z = tuple3d.z + tuple3d2.z;
    }

    public final void add(Tuple3d tuple3d) {
        this.x += tuple3d.x;
        this.y += tuple3d.y;
        this.z += tuple3d.z;
    }

    public final void sub(Tuple3d tuple3d, Tuple3d tuple3d2) {
        this.x = tuple3d.x - tuple3d2.x;
        this.y = tuple3d.y - tuple3d2.y;
        this.z = tuple3d.z - tuple3d2.z;
    }

    public final void sub(Tuple3d tuple3d) {
        this.x -= tuple3d.x;
        this.y -= tuple3d.y;
        this.z -= tuple3d.z;
    }

    public final void negate(Tuple3d tuple3d) {
        this.x = -tuple3d.x;
        this.y = -tuple3d.y;
        this.z = -tuple3d.z;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public final void scale(double d, Tuple3d tuple3d) {
        this.x = d * tuple3d.x;
        this.y = d * tuple3d.y;
        this.z = d * tuple3d.z;
    }

    public final void scale(double d) {
        this.x *= d;
        this.y *= d;
        this.z *= d;
    }

    public final void scaleAdd(double d, Tuple3d tuple3d, Tuple3d tuple3d2) {
        this.x = d * tuple3d.x + tuple3d2.x;
        this.y = d * tuple3d.y + tuple3d2.y;
        this.z = d * tuple3d.z + tuple3d2.z;
    }

    public final void scaleAdd(double d, Tuple3f tuple3f) {
        this.scaleAdd(d, new Point3d(tuple3f));
    }

    public final void scaleAdd(double d, Tuple3d tuple3d) {
        this.x = d * this.x + tuple3d.x;
        this.y = d * this.y + tuple3d.y;
        this.z = d * this.z + tuple3d.z;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + VecMathUtil.doubleToLongBits(this.x);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.y);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.z);
        return (int)(l ^ l >> 32);
    }

    public boolean equals(Tuple3d tuple3d) {
        try {
            return this.x == tuple3d.x && this.y == tuple3d.y && this.z == tuple3d.z;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Tuple3d tuple3d = (Tuple3d)object;
            return this.x == tuple3d.x && this.y == tuple3d.y && this.z == tuple3d.z;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple3d tuple3d, double d) {
        double d2 = this.x - tuple3d.x;
        double d3 = d2 < 0.0 ? -d2 : d2;
        if (d3 > d) {
            return false;
        }
        d2 = this.y - tuple3d.y;
        double d4 = d2 < 0.0 ? -d2 : d2;
        if (d4 > d) {
            return false;
        }
        d2 = this.z - tuple3d.z;
        double d5 = d2 < 0.0 ? -d2 : d2;
        return !(d5 > d);
    }

    public final void clamp(float f, float f2, Tuple3d tuple3d) {
        this.clamp((double)f, (double)f2, tuple3d);
    }

    public final void clamp(double d, double d2, Tuple3d tuple3d) {
        this.x = tuple3d.x > d2 ? d2 : (tuple3d.x < d ? d : tuple3d.x);
        this.y = tuple3d.y > d2 ? d2 : (tuple3d.y < d ? d : tuple3d.y);
        this.z = tuple3d.z > d2 ? d2 : (tuple3d.z < d ? d : tuple3d.z);
    }

    public final void clampMin(float f, Tuple3d tuple3d) {
        this.clampMin((double)f, tuple3d);
    }

    public final void clampMin(double d, Tuple3d tuple3d) {
        this.x = tuple3d.x < d ? d : tuple3d.x;
        this.y = tuple3d.y < d ? d : tuple3d.y;
        this.z = tuple3d.z < d ? d : tuple3d.z;
    }

    public final void clampMax(float f, Tuple3d tuple3d) {
        this.clampMax((double)f, tuple3d);
    }

    public final void clampMax(double d, Tuple3d tuple3d) {
        this.x = tuple3d.x > d ? d : tuple3d.x;
        this.y = tuple3d.y > d ? d : tuple3d.y;
        this.z = tuple3d.z > d ? d : tuple3d.z;
    }

    public final void absolute(Tuple3d tuple3d) {
        this.x = Math.abs(tuple3d.x);
        this.y = Math.abs(tuple3d.y);
        this.z = Math.abs(tuple3d.z);
    }

    public final void clamp(float f, float f2) {
        this.clamp((double)f, (double)f2);
    }

    public final void clamp(double d, double d2) {
        if (this.x > d2) {
            this.x = d2;
        } else if (this.x < d) {
            this.x = d;
        }
        if (this.y > d2) {
            this.y = d2;
        } else if (this.y < d) {
            this.y = d;
        }
        if (this.z > d2) {
            this.z = d2;
        } else if (this.z < d) {
            this.z = d;
        }
    }

    public final void clampMin(float f) {
        this.clampMin((double)f);
    }

    public final void clampMin(double d) {
        if (this.x < d) {
            this.x = d;
        }
        if (this.y < d) {
            this.y = d;
        }
        if (this.z < d) {
            this.z = d;
        }
    }

    public final void clampMax(float f) {
        this.clampMax((double)f);
    }

    public final void clampMax(double d) {
        if (this.x > d) {
            this.x = d;
        }
        if (this.y > d) {
            this.y = d;
        }
        if (this.z > d) {
            this.z = d;
        }
    }

    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
    }

    public final void interpolate(Tuple3d tuple3d, Tuple3d tuple3d2, float f) {
        this.interpolate(tuple3d, tuple3d2, (double)f);
    }

    public final void interpolate(Tuple3d tuple3d, Tuple3d tuple3d2, double d) {
        this.x = (1.0 - d) * tuple3d.x + d * tuple3d2.x;
        this.y = (1.0 - d) * tuple3d.y + d * tuple3d2.y;
        this.z = (1.0 - d) * tuple3d.z + d * tuple3d2.z;
    }

    public final void interpolate(Tuple3d tuple3d, float f) {
        this.interpolate(tuple3d, (double)f);
    }

    public final void interpolate(Tuple3d tuple3d, double d) {
        this.x = (1.0 - d) * this.x + d * tuple3d.x;
        this.y = (1.0 - d) * this.y + d * tuple3d.y;
        this.z = (1.0 - d) * this.z + d * tuple3d.z;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }
}


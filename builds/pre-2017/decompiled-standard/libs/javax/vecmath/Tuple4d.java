/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple4f;
import javax.vecmath.VecMathUtil;

public abstract class Tuple4d
implements Serializable,
Cloneable {
    static final long serialVersionUID = -4748953690425311052L;
    public double x;
    public double y;
    public double z;
    public double w;

    public Tuple4d(double d, double d2, double d3, double d4) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.w = d4;
    }

    public Tuple4d(double[] dArray) {
        this.x = dArray[0];
        this.y = dArray[1];
        this.z = dArray[2];
        this.w = dArray[3];
    }

    public Tuple4d(Tuple4d tuple4d) {
        this.x = tuple4d.x;
        this.y = tuple4d.y;
        this.z = tuple4d.z;
        this.w = tuple4d.w;
    }

    public Tuple4d(Tuple4f tuple4f) {
        this.x = tuple4f.x;
        this.y = tuple4f.y;
        this.z = tuple4f.z;
        this.w = tuple4f.w;
    }

    public Tuple4d() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.w = 0.0;
    }

    public final void set(double d, double d2, double d3, double d4) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.w = d4;
    }

    public final void set(double[] dArray) {
        this.x = dArray[0];
        this.y = dArray[1];
        this.z = dArray[2];
        this.w = dArray[3];
    }

    public final void set(Tuple4d tuple4d) {
        this.x = tuple4d.x;
        this.y = tuple4d.y;
        this.z = tuple4d.z;
        this.w = tuple4d.w;
    }

    public final void set(Tuple4f tuple4f) {
        this.x = tuple4f.x;
        this.y = tuple4f.y;
        this.z = tuple4f.z;
        this.w = tuple4f.w;
    }

    public final void get(double[] dArray) {
        dArray[0] = this.x;
        dArray[1] = this.y;
        dArray[2] = this.z;
        dArray[3] = this.w;
    }

    public final void get(Tuple4d tuple4d) {
        tuple4d.x = this.x;
        tuple4d.y = this.y;
        tuple4d.z = this.z;
        tuple4d.w = this.w;
    }

    public final void add(Tuple4d tuple4d, Tuple4d tuple4d2) {
        this.x = tuple4d.x + tuple4d2.x;
        this.y = tuple4d.y + tuple4d2.y;
        this.z = tuple4d.z + tuple4d2.z;
        this.w = tuple4d.w + tuple4d2.w;
    }

    public final void add(Tuple4d tuple4d) {
        this.x += tuple4d.x;
        this.y += tuple4d.y;
        this.z += tuple4d.z;
        this.w += tuple4d.w;
    }

    public final void sub(Tuple4d tuple4d, Tuple4d tuple4d2) {
        this.x = tuple4d.x - tuple4d2.x;
        this.y = tuple4d.y - tuple4d2.y;
        this.z = tuple4d.z - tuple4d2.z;
        this.w = tuple4d.w - tuple4d2.w;
    }

    public final void sub(Tuple4d tuple4d) {
        this.x -= tuple4d.x;
        this.y -= tuple4d.y;
        this.z -= tuple4d.z;
        this.w -= tuple4d.w;
    }

    public final void negate(Tuple4d tuple4d) {
        this.x = -tuple4d.x;
        this.y = -tuple4d.y;
        this.z = -tuple4d.z;
        this.w = -tuple4d.w;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
    }

    public final void scale(double d, Tuple4d tuple4d) {
        this.x = d * tuple4d.x;
        this.y = d * tuple4d.y;
        this.z = d * tuple4d.z;
        this.w = d * tuple4d.w;
    }

    public final void scale(double d) {
        this.x *= d;
        this.y *= d;
        this.z *= d;
        this.w *= d;
    }

    public final void scaleAdd(double d, Tuple4d tuple4d, Tuple4d tuple4d2) {
        this.x = d * tuple4d.x + tuple4d2.x;
        this.y = d * tuple4d.y + tuple4d2.y;
        this.z = d * tuple4d.z + tuple4d2.z;
        this.w = d * tuple4d.w + tuple4d2.w;
    }

    public final void scaleAdd(float f, Tuple4d tuple4d) {
        this.scaleAdd((double)f, tuple4d);
    }

    public final void scaleAdd(double d, Tuple4d tuple4d) {
        this.x = d * this.x + tuple4d.x;
        this.y = d * this.y + tuple4d.y;
        this.z = d * this.z + tuple4d.z;
        this.w = d * this.w + tuple4d.w;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.w + ")";
    }

    public boolean equals(Tuple4d tuple4d) {
        try {
            return this.x == tuple4d.x && this.y == tuple4d.y && this.z == tuple4d.z && this.w == tuple4d.w;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Tuple4d tuple4d = (Tuple4d)object;
            return this.x == tuple4d.x && this.y == tuple4d.y && this.z == tuple4d.z && this.w == tuple4d.w;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple4d tuple4d, double d) {
        double d2 = this.x - tuple4d.x;
        double d3 = d2 < 0.0 ? -d2 : d2;
        if (d3 > d) {
            return false;
        }
        d2 = this.y - tuple4d.y;
        double d4 = d2 < 0.0 ? -d2 : d2;
        if (d4 > d) {
            return false;
        }
        d2 = this.z - tuple4d.z;
        double d5 = d2 < 0.0 ? -d2 : d2;
        if (d5 > d) {
            return false;
        }
        d2 = this.w - tuple4d.w;
        double d6 = d2 < 0.0 ? -d2 : d2;
        return !(d6 > d);
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + VecMathUtil.doubleToLongBits(this.x);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.y);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.z);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.w);
        return (int)(l ^ l >> 32);
    }

    public final void clamp(float f, float f2, Tuple4d tuple4d) {
        this.clamp((double)f, (double)f2, tuple4d);
    }

    public final void clamp(double d, double d2, Tuple4d tuple4d) {
        this.x = tuple4d.x > d2 ? d2 : (tuple4d.x < d ? d : tuple4d.x);
        this.y = tuple4d.y > d2 ? d2 : (tuple4d.y < d ? d : tuple4d.y);
        this.z = tuple4d.z > d2 ? d2 : (tuple4d.z < d ? d : tuple4d.z);
        this.w = tuple4d.w > d2 ? d2 : (tuple4d.w < d ? d : tuple4d.w);
    }

    public final void clampMin(float f, Tuple4d tuple4d) {
        this.clampMin((double)f, tuple4d);
    }

    public final void clampMin(double d, Tuple4d tuple4d) {
        this.x = tuple4d.x < d ? d : tuple4d.x;
        this.y = tuple4d.y < d ? d : tuple4d.y;
        this.z = tuple4d.z < d ? d : tuple4d.z;
        this.w = tuple4d.w < d ? d : tuple4d.w;
    }

    public final void clampMax(float f, Tuple4d tuple4d) {
        this.clampMax((double)f, tuple4d);
    }

    public final void clampMax(double d, Tuple4d tuple4d) {
        this.x = tuple4d.x > d ? d : tuple4d.x;
        this.y = tuple4d.y > d ? d : tuple4d.y;
        this.z = tuple4d.z > d ? d : tuple4d.z;
        this.w = tuple4d.w > d ? d : tuple4d.z;
    }

    public final void absolute(Tuple4d tuple4d) {
        this.x = Math.abs(tuple4d.x);
        this.y = Math.abs(tuple4d.y);
        this.z = Math.abs(tuple4d.z);
        this.w = Math.abs(tuple4d.w);
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
        if (this.w > d2) {
            this.w = d2;
        } else if (this.w < d) {
            this.w = d;
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
        if (this.w < d) {
            this.w = d;
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
        if (this.w > d) {
            this.w = d;
        }
    }

    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
    }

    public void interpolate(Tuple4d tuple4d, Tuple4d tuple4d2, float f) {
        this.interpolate(tuple4d, tuple4d2, (double)f);
    }

    public void interpolate(Tuple4d tuple4d, Tuple4d tuple4d2, double d) {
        this.x = (1.0 - d) * tuple4d.x + d * tuple4d2.x;
        this.y = (1.0 - d) * tuple4d.y + d * tuple4d2.y;
        this.z = (1.0 - d) * tuple4d.z + d * tuple4d2.z;
        this.w = (1.0 - d) * tuple4d.w + d * tuple4d2.w;
    }

    public void interpolate(Tuple4d tuple4d, float f) {
        this.interpolate(tuple4d, (double)f);
    }

    public void interpolate(Tuple4d tuple4d, double d) {
        this.x = (1.0 - d) * this.x + d * tuple4d.x;
        this.y = (1.0 - d) * this.y + d * tuple4d.y;
        this.z = (1.0 - d) * this.z + d * tuple4d.z;
        this.w = (1.0 - d) * this.w + d * tuple4d.w;
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


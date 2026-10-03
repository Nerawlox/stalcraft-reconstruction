/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix3d;
import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4d;
import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4d;
import javax.vecmath.Quat4f;
import javax.vecmath.VecMathUtil;
import javax.vecmath.Vector3d;

public class AxisAngle4d
implements Serializable,
Cloneable {
    static final long serialVersionUID = 3644296204459140589L;
    public double x;
    public double y;
    public double z;
    public double angle;
    static final double EPS = 1.0E-6;

    public AxisAngle4d(double d, double d2, double d3, double d4) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.angle = d4;
    }

    public AxisAngle4d(double[] dArray) {
        this.x = dArray[0];
        this.y = dArray[1];
        this.z = dArray[2];
        this.angle = dArray[3];
    }

    public AxisAngle4d(AxisAngle4d axisAngle4d) {
        this.x = axisAngle4d.x;
        this.y = axisAngle4d.y;
        this.z = axisAngle4d.z;
        this.angle = axisAngle4d.angle;
    }

    public AxisAngle4d(AxisAngle4f axisAngle4f) {
        this.x = axisAngle4f.x;
        this.y = axisAngle4f.y;
        this.z = axisAngle4f.z;
        this.angle = axisAngle4f.angle;
    }

    public AxisAngle4d(Vector3d vector3d, double d) {
        this.x = vector3d.x;
        this.y = vector3d.y;
        this.z = vector3d.z;
        this.angle = d;
    }

    public AxisAngle4d() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 1.0;
        this.angle = 0.0;
    }

    public final void set(double d, double d2, double d3, double d4) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.angle = d4;
    }

    public final void set(double[] dArray) {
        this.x = dArray[0];
        this.y = dArray[1];
        this.z = dArray[2];
        this.angle = dArray[3];
    }

    public final void set(AxisAngle4d axisAngle4d) {
        this.x = axisAngle4d.x;
        this.y = axisAngle4d.y;
        this.z = axisAngle4d.z;
        this.angle = axisAngle4d.angle;
    }

    public final void set(AxisAngle4f axisAngle4f) {
        this.x = axisAngle4f.x;
        this.y = axisAngle4f.y;
        this.z = axisAngle4f.z;
        this.angle = axisAngle4f.angle;
    }

    public final void set(Vector3d vector3d, double d) {
        this.x = vector3d.x;
        this.y = vector3d.y;
        this.z = vector3d.z;
        this.angle = d;
    }

    public final void get(double[] dArray) {
        dArray[0] = this.x;
        dArray[1] = this.y;
        dArray[2] = this.z;
        dArray[3] = this.angle;
    }

    public final void set(Matrix4f matrix4f) {
        Matrix3d matrix3d = new Matrix3d();
        matrix4f.get(matrix3d);
        this.x = (float)(matrix3d.m21 - matrix3d.m12);
        this.y = (float)(matrix3d.m02 - matrix3d.m20);
        this.z = (float)(matrix3d.m10 - matrix3d.m01);
        double d = this.x * this.x + this.y * this.y + this.z * this.z;
        if (d > 1.0E-6) {
            d = Math.sqrt(d);
            double d2 = 0.5 * d;
            double d3 = 0.5 * (matrix3d.m00 + matrix3d.m11 + matrix3d.m22 - 1.0);
            this.angle = (float)Math.atan2(d2, d3);
            double d4 = 1.0 / d;
            this.x *= d4;
            this.y *= d4;
            this.z *= d4;
        } else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }

    public final void set(Matrix4d matrix4d) {
        Matrix3d matrix3d = new Matrix3d();
        matrix4d.get(matrix3d);
        this.x = (float)(matrix3d.m21 - matrix3d.m12);
        this.y = (float)(matrix3d.m02 - matrix3d.m20);
        this.z = (float)(matrix3d.m10 - matrix3d.m01);
        double d = this.x * this.x + this.y * this.y + this.z * this.z;
        if (d > 1.0E-6) {
            d = Math.sqrt(d);
            double d2 = 0.5 * d;
            double d3 = 0.5 * (matrix3d.m00 + matrix3d.m11 + matrix3d.m22 - 1.0);
            this.angle = (float)Math.atan2(d2, d3);
            double d4 = 1.0 / d;
            this.x *= d4;
            this.y *= d4;
            this.z *= d4;
        } else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }

    public final void set(Matrix3f matrix3f) {
        this.x = matrix3f.m21 - matrix3f.m12;
        this.y = matrix3f.m02 - matrix3f.m20;
        this.z = matrix3f.m10 - matrix3f.m01;
        double d = this.x * this.x + this.y * this.y + this.z * this.z;
        if (d > 1.0E-6) {
            d = Math.sqrt(d);
            double d2 = 0.5 * d;
            double d3 = 0.5 * ((double)(matrix3f.m00 + matrix3f.m11 + matrix3f.m22) - 1.0);
            this.angle = (float)Math.atan2(d2, d3);
            double d4 = 1.0 / d;
            this.x *= d4;
            this.y *= d4;
            this.z *= d4;
        } else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }

    public final void set(Matrix3d matrix3d) {
        this.x = (float)(matrix3d.m21 - matrix3d.m12);
        this.y = (float)(matrix3d.m02 - matrix3d.m20);
        this.z = (float)(matrix3d.m10 - matrix3d.m01);
        double d = this.x * this.x + this.y * this.y + this.z * this.z;
        if (d > 1.0E-6) {
            d = Math.sqrt(d);
            double d2 = 0.5 * d;
            double d3 = 0.5 * (matrix3d.m00 + matrix3d.m11 + matrix3d.m22 - 1.0);
            this.angle = (float)Math.atan2(d2, d3);
            double d4 = 1.0 / d;
            this.x *= d4;
            this.y *= d4;
            this.z *= d4;
        } else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }

    public final void set(Quat4f quat4f) {
        double d = quat4f.x * quat4f.x + quat4f.y * quat4f.y + quat4f.z * quat4f.z;
        if (d > 1.0E-6) {
            d = Math.sqrt(d);
            double d2 = 1.0 / d;
            this.x = (double)quat4f.x * d2;
            this.y = (double)quat4f.y * d2;
            this.z = (double)quat4f.z * d2;
            this.angle = 2.0 * Math.atan2(d, quat4f.w);
        } else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }

    public final void set(Quat4d quat4d) {
        double d = quat4d.x * quat4d.x + quat4d.y * quat4d.y + quat4d.z * quat4d.z;
        if (d > 1.0E-6) {
            d = Math.sqrt(d);
            double d2 = 1.0 / d;
            this.x = quat4d.x * d2;
            this.y = quat4d.y * d2;
            this.z = quat4d.z * d2;
            this.angle = 2.0 * Math.atan2(d, quat4d.w);
        } else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.angle + ")";
    }

    public boolean equals(AxisAngle4d axisAngle4d) {
        try {
            return this.x == axisAngle4d.x && this.y == axisAngle4d.y && this.z == axisAngle4d.z && this.angle == axisAngle4d.angle;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            AxisAngle4d axisAngle4d = (AxisAngle4d)object;
            return this.x == axisAngle4d.x && this.y == axisAngle4d.y && this.z == axisAngle4d.z && this.angle == axisAngle4d.angle;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public boolean epsilonEquals(AxisAngle4d axisAngle4d, double d) {
        double d2 = this.x - axisAngle4d.x;
        double d3 = d2 < 0.0 ? -d2 : d2;
        if (d3 > d) {
            return false;
        }
        d2 = this.y - axisAngle4d.y;
        double d4 = d2 < 0.0 ? -d2 : d2;
        if (d4 > d) {
            return false;
        }
        d2 = this.z - axisAngle4d.z;
        double d5 = d2 < 0.0 ? -d2 : d2;
        if (d5 > d) {
            return false;
        }
        d2 = this.angle - axisAngle4d.angle;
        double d6 = d2 < 0.0 ? -d2 : d2;
        return !(d6 > d);
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + VecMathUtil.doubleToLongBits(this.x);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.y);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.z);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.angle);
        return (int)(l ^ l >> 32);
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


/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Matrix3d;
import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4d;
import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4d;
import javax.vecmath.Quat4f;
import javax.vecmath.VecMathUtil;
import javax.vecmath.Vector3f;

public class AxisAngle4f
implements Serializable,
Cloneable {
    static final long serialVersionUID = -163246355858070601L;
    public float x;
    public float y;
    public float z;
    public float angle;
    static final double EPS = 1.0E-6;

    public AxisAngle4f(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.angle = f4;
    }

    public AxisAngle4f(float[] fArray) {
        this.x = fArray[0];
        this.y = fArray[1];
        this.z = fArray[2];
        this.angle = fArray[3];
    }

    public AxisAngle4f(AxisAngle4f axisAngle4f) {
        this.x = axisAngle4f.x;
        this.y = axisAngle4f.y;
        this.z = axisAngle4f.z;
        this.angle = axisAngle4f.angle;
    }

    public AxisAngle4f(AxisAngle4d axisAngle4d) {
        this.x = (float)axisAngle4d.x;
        this.y = (float)axisAngle4d.y;
        this.z = (float)axisAngle4d.z;
        this.angle = (float)axisAngle4d.angle;
    }

    public AxisAngle4f(Vector3f vector3f, float f) {
        this.x = vector3f.x;
        this.y = vector3f.y;
        this.z = vector3f.z;
        this.angle = f;
    }

    public AxisAngle4f() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 1.0f;
        this.angle = 0.0f;
    }

    public final void set(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.angle = f4;
    }

    public final void set(float[] fArray) {
        this.x = fArray[0];
        this.y = fArray[1];
        this.z = fArray[2];
        this.angle = fArray[3];
    }

    public final void set(AxisAngle4f axisAngle4f) {
        this.x = axisAngle4f.x;
        this.y = axisAngle4f.y;
        this.z = axisAngle4f.z;
        this.angle = axisAngle4f.angle;
    }

    public final void set(AxisAngle4d axisAngle4d) {
        this.x = (float)axisAngle4d.x;
        this.y = (float)axisAngle4d.y;
        this.z = (float)axisAngle4d.z;
        this.angle = (float)axisAngle4d.angle;
    }

    public final void set(Vector3f vector3f, float f) {
        this.x = vector3f.x;
        this.y = vector3f.y;
        this.z = vector3f.z;
        this.angle = f;
    }

    public final void get(float[] fArray) {
        fArray[0] = this.x;
        fArray[1] = this.y;
        fArray[2] = this.z;
        fArray[3] = this.angle;
    }

    public final void set(Quat4f quat4f) {
        double d = quat4f.x * quat4f.x + quat4f.y * quat4f.y + quat4f.z * quat4f.z;
        if (d > 1.0E-6) {
            d = Math.sqrt(d);
            double d2 = 1.0 / d;
            this.x = (float)((double)quat4f.x * d2);
            this.y = (float)((double)quat4f.y * d2);
            this.z = (float)((double)quat4f.z * d2);
            this.angle = (float)(2.0 * Math.atan2(d, quat4f.w));
        } else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
        }
    }

    public final void set(Quat4d quat4d) {
        double d = quat4d.x * quat4d.x + quat4d.y * quat4d.y + quat4d.z * quat4d.z;
        if (d > 1.0E-6) {
            d = Math.sqrt(d);
            double d2 = 1.0 / d;
            this.x = (float)(quat4d.x * d2);
            this.y = (float)(quat4d.y * d2);
            this.z = (float)(quat4d.z * d2);
            this.angle = (float)(2.0 * Math.atan2(d, quat4d.w));
        } else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
        }
    }

    public final void set(Matrix4f matrix4f) {
        Matrix3f matrix3f = new Matrix3f();
        matrix4f.get(matrix3f);
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
            this.x = (float)((double)this.x * d4);
            this.y = (float)((double)this.y * d4);
            this.z = (float)((double)this.z * d4);
        } else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
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
            this.x = (float)((double)this.x * d4);
            this.y = (float)((double)this.y * d4);
            this.z = (float)((double)this.z * d4);
        } else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
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
            this.x = (float)((double)this.x * d4);
            this.y = (float)((double)this.y * d4);
            this.z = (float)((double)this.z * d4);
        } else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
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
            this.x = (float)((double)this.x * d4);
            this.y = (float)((double)this.y * d4);
            this.z = (float)((double)this.z * d4);
        } else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
        }
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.angle + ")";
    }

    public boolean equals(AxisAngle4f axisAngle4f) {
        try {
            return this.x == axisAngle4f.x && this.y == axisAngle4f.y && this.z == axisAngle4f.z && this.angle == axisAngle4f.angle;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            AxisAngle4f axisAngle4f = (AxisAngle4f)object;
            return this.x == axisAngle4f.x && this.y == axisAngle4f.y && this.z == axisAngle4f.z && this.angle == axisAngle4f.angle;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public boolean epsilonEquals(AxisAngle4f axisAngle4f, float f) {
        float f2 = this.x - axisAngle4f.x;
        float f3 = f2 < 0.0f ? -f2 : f2;
        if (f3 > f) {
            return false;
        }
        f2 = this.y - axisAngle4f.y;
        float f4 = f2 < 0.0f ? -f2 : f2;
        if (f4 > f) {
            return false;
        }
        f2 = this.z - axisAngle4f.z;
        float f5 = f2 < 0.0f ? -f2 : f2;
        if (f5 > f) {
            return false;
        }
        f2 = this.angle - axisAngle4f.angle;
        float f6 = f2 < 0.0f ? -f2 : f2;
        return !(f6 > f);
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.x);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.y);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.z);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.angle);
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


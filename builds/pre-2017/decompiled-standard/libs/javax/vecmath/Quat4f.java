/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix3d;
import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4d;
import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4d;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;

public class Quat4f
extends Tuple4f
implements Serializable {
    static final long serialVersionUID = 2675933778405442383L;
    static final double EPS = 1.0E-6;
    static final double EPS2 = 1.0E-30;
    static final double PIO2 = 1.57079632679;

    public Quat4f(float f, float f2, float f3, float f4) {
        float f5 = (float)(1.0 / Math.sqrt(f * f + f2 * f2 + f3 * f3 + f4 * f4));
        this.x = f * f5;
        this.y = f2 * f5;
        this.z = f3 * f5;
        this.w = f4 * f5;
    }

    public Quat4f(float[] fArray) {
        float f = (float)(1.0 / Math.sqrt(fArray[0] * fArray[0] + fArray[1] * fArray[1] + fArray[2] * fArray[2] + fArray[3] * fArray[3]));
        this.x = fArray[0] * f;
        this.y = fArray[1] * f;
        this.z = fArray[2] * f;
        this.w = fArray[3] * f;
    }

    public Quat4f(Quat4f quat4f) {
        super(quat4f);
    }

    public Quat4f(Quat4d quat4d) {
        super(quat4d);
    }

    public Quat4f(Tuple4f tuple4f) {
        float f = (float)(1.0 / Math.sqrt(tuple4f.x * tuple4f.x + tuple4f.y * tuple4f.y + tuple4f.z * tuple4f.z + tuple4f.w * tuple4f.w));
        this.x = tuple4f.x * f;
        this.y = tuple4f.y * f;
        this.z = tuple4f.z * f;
        this.w = tuple4f.w * f;
    }

    public Quat4f(Tuple4d tuple4d) {
        double d = 1.0 / Math.sqrt(tuple4d.x * tuple4d.x + tuple4d.y * tuple4d.y + tuple4d.z * tuple4d.z + tuple4d.w * tuple4d.w);
        this.x = (float)(tuple4d.x * d);
        this.y = (float)(tuple4d.y * d);
        this.z = (float)(tuple4d.z * d);
        this.w = (float)(tuple4d.w * d);
    }

    public Quat4f() {
    }

    public final void conjugate(Quat4f quat4f) {
        this.x = -quat4f.x;
        this.y = -quat4f.y;
        this.z = -quat4f.z;
        this.w = quat4f.w;
    }

    public final void conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public final void mul(Quat4f quat4f, Quat4f quat4f2) {
        if (this != quat4f && this != quat4f2) {
            this.w = quat4f.w * quat4f2.w - quat4f.x * quat4f2.x - quat4f.y * quat4f2.y - quat4f.z * quat4f2.z;
            this.x = quat4f.w * quat4f2.x + quat4f2.w * quat4f.x + quat4f.y * quat4f2.z - quat4f.z * quat4f2.y;
            this.y = quat4f.w * quat4f2.y + quat4f2.w * quat4f.y - quat4f.x * quat4f2.z + quat4f.z * quat4f2.x;
            this.z = quat4f.w * quat4f2.z + quat4f2.w * quat4f.z + quat4f.x * quat4f2.y - quat4f.y * quat4f2.x;
        } else {
            float f = quat4f.w * quat4f2.w - quat4f.x * quat4f2.x - quat4f.y * quat4f2.y - quat4f.z * quat4f2.z;
            float f2 = quat4f.w * quat4f2.x + quat4f2.w * quat4f.x + quat4f.y * quat4f2.z - quat4f.z * quat4f2.y;
            float f3 = quat4f.w * quat4f2.y + quat4f2.w * quat4f.y - quat4f.x * quat4f2.z + quat4f.z * quat4f2.x;
            this.z = quat4f.w * quat4f2.z + quat4f2.w * quat4f.z + quat4f.x * quat4f2.y - quat4f.y * quat4f2.x;
            this.w = f;
            this.x = f2;
            this.y = f3;
        }
    }

    public final void mul(Quat4f quat4f) {
        float f = this.w * quat4f.w - this.x * quat4f.x - this.y * quat4f.y - this.z * quat4f.z;
        float f2 = this.w * quat4f.x + quat4f.w * this.x + this.y * quat4f.z - this.z * quat4f.y;
        float f3 = this.w * quat4f.y + quat4f.w * this.y - this.x * quat4f.z + this.z * quat4f.x;
        this.z = this.w * quat4f.z + quat4f.w * this.z + this.x * quat4f.y - this.y * quat4f.x;
        this.w = f;
        this.x = f2;
        this.y = f3;
    }

    public final void mulInverse(Quat4f quat4f, Quat4f quat4f2) {
        Quat4f quat4f3 = new Quat4f(quat4f2);
        quat4f3.inverse();
        this.mul(quat4f, quat4f3);
    }

    public final void mulInverse(Quat4f quat4f) {
        Quat4f quat4f2 = new Quat4f(quat4f);
        quat4f2.inverse();
        this.mul(quat4f2);
    }

    public final void inverse(Quat4f quat4f) {
        float f = 1.0f / (quat4f.w * quat4f.w + quat4f.x * quat4f.x + quat4f.y * quat4f.y + quat4f.z * quat4f.z);
        this.w = f * quat4f.w;
        this.x = -f * quat4f.x;
        this.y = -f * quat4f.y;
        this.z = -f * quat4f.z;
    }

    public final void inverse() {
        float f = 1.0f / (this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z);
        this.w *= f;
        this.x *= -f;
        this.y *= -f;
        this.z *= -f;
    }

    public final void normalize(Quat4f quat4f) {
        float f = quat4f.x * quat4f.x + quat4f.y * quat4f.y + quat4f.z * quat4f.z + quat4f.w * quat4f.w;
        if (f > 0.0f) {
            f = 1.0f / (float)Math.sqrt(f);
            this.x = f * quat4f.x;
            this.y = f * quat4f.y;
            this.z = f * quat4f.z;
            this.w = f * quat4f.w;
        } else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.w = 0.0f;
        }
    }

    public final void normalize() {
        float f = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        if (f > 0.0f) {
            f = 1.0f / (float)Math.sqrt(f);
            this.x *= f;
            this.y *= f;
            this.z *= f;
            this.w *= f;
        } else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.w = 0.0f;
        }
    }

    public final void set(Matrix4f matrix4f) {
        float f = 0.25f * (matrix4f.m00 + matrix4f.m11 + matrix4f.m22 + matrix4f.m33);
        if (f >= 0.0f) {
            if ((double)f >= 1.0E-30) {
                this.w = (float)Math.sqrt(f);
                f = 0.25f / this.w;
                this.x = (matrix4f.m21 - matrix4f.m12) * f;
                this.y = (matrix4f.m02 - matrix4f.m20) * f;
                this.z = (matrix4f.m10 - matrix4f.m01) * f;
                return;
            }
        } else {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        this.w = 0.0f;
        f = -0.5f * (matrix4f.m11 + matrix4f.m22);
        if (f >= 0.0f) {
            if ((double)f >= 1.0E-30) {
                this.x = (float)Math.sqrt(f);
                f = 1.0f / (2.0f * this.x);
                this.y = matrix4f.m10 * f;
                this.z = matrix4f.m20 * f;
                return;
            }
        } else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        this.x = 0.0f;
        f = 0.5f * (1.0f - matrix4f.m22);
        if ((double)f >= 1.0E-30) {
            this.y = (float)Math.sqrt(f);
            this.z = matrix4f.m21 / (2.0f * this.y);
            return;
        }
        this.y = 0.0f;
        this.z = 1.0f;
    }

    public final void set(Matrix4d matrix4d) {
        double d = 0.25 * (matrix4d.m00 + matrix4d.m11 + matrix4d.m22 + matrix4d.m33);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.w = (float)Math.sqrt(d);
                d = 0.25 / (double)this.w;
                this.x = (float)((matrix4d.m21 - matrix4d.m12) * d);
                this.y = (float)((matrix4d.m02 - matrix4d.m20) * d);
                this.z = (float)((matrix4d.m10 - matrix4d.m01) * d);
                return;
            }
        } else {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        this.w = 0.0f;
        d = -0.5 * (matrix4d.m11 + matrix4d.m22);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.x = (float)Math.sqrt(d);
                d = 0.5 / (double)this.x;
                this.y = (float)(matrix4d.m10 * d);
                this.z = (float)(matrix4d.m20 * d);
                return;
            }
        } else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        this.x = 0.0f;
        d = 0.5 * (1.0 - matrix4d.m22);
        if (d >= 1.0E-30) {
            this.y = (float)Math.sqrt(d);
            this.z = (float)(matrix4d.m21 / (2.0 * (double)this.y));
            return;
        }
        this.y = 0.0f;
        this.z = 1.0f;
    }

    public final void set(Matrix3f matrix3f) {
        float f = 0.25f * (matrix3f.m00 + matrix3f.m11 + matrix3f.m22 + 1.0f);
        if (f >= 0.0f) {
            if ((double)f >= 1.0E-30) {
                this.w = (float)Math.sqrt(f);
                f = 0.25f / this.w;
                this.x = (matrix3f.m21 - matrix3f.m12) * f;
                this.y = (matrix3f.m02 - matrix3f.m20) * f;
                this.z = (matrix3f.m10 - matrix3f.m01) * f;
                return;
            }
        } else {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        this.w = 0.0f;
        f = -0.5f * (matrix3f.m11 + matrix3f.m22);
        if (f >= 0.0f) {
            if ((double)f >= 1.0E-30) {
                this.x = (float)Math.sqrt(f);
                f = 0.5f / this.x;
                this.y = matrix3f.m10 * f;
                this.z = matrix3f.m20 * f;
                return;
            }
        } else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        this.x = 0.0f;
        f = 0.5f * (1.0f - matrix3f.m22);
        if ((double)f >= 1.0E-30) {
            this.y = (float)Math.sqrt(f);
            this.z = matrix3f.m21 / (2.0f * this.y);
            return;
        }
        this.y = 0.0f;
        this.z = 1.0f;
    }

    public final void set(Matrix3d matrix3d) {
        double d = 0.25 * (matrix3d.m00 + matrix3d.m11 + matrix3d.m22 + 1.0);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.w = (float)Math.sqrt(d);
                d = 0.25 / (double)this.w;
                this.x = (float)((matrix3d.m21 - matrix3d.m12) * d);
                this.y = (float)((matrix3d.m02 - matrix3d.m20) * d);
                this.z = (float)((matrix3d.m10 - matrix3d.m01) * d);
                return;
            }
        } else {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        this.w = 0.0f;
        d = -0.5 * (matrix3d.m11 + matrix3d.m22);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.x = (float)Math.sqrt(d);
                d = 0.5 / (double)this.x;
                this.y = (float)(matrix3d.m10 * d);
                this.z = (float)(matrix3d.m20 * d);
                return;
            }
        } else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        this.x = 0.0f;
        d = 0.5 * (1.0 - matrix3d.m22);
        if (d >= 1.0E-30) {
            this.y = (float)Math.sqrt(d);
            this.z = (float)(matrix3d.m21 / (2.0 * (double)this.y));
            return;
        }
        this.y = 0.0f;
        this.z = 1.0f;
    }

    public final void set(AxisAngle4f axisAngle4f) {
        float f = (float)Math.sqrt(axisAngle4f.x * axisAngle4f.x + axisAngle4f.y * axisAngle4f.y + axisAngle4f.z * axisAngle4f.z);
        if ((double)f < 1.0E-6) {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
        } else {
            f = 1.0f / f;
            float f2 = (float)Math.sin((double)axisAngle4f.angle / 2.0);
            this.w = (float)Math.cos((double)axisAngle4f.angle / 2.0);
            this.x = axisAngle4f.x * f * f2;
            this.y = axisAngle4f.y * f * f2;
            this.z = axisAngle4f.z * f * f2;
        }
    }

    public final void set(AxisAngle4d axisAngle4d) {
        float f = (float)(1.0 / Math.sqrt(axisAngle4d.x * axisAngle4d.x + axisAngle4d.y * axisAngle4d.y + axisAngle4d.z * axisAngle4d.z));
        if ((double)f < 1.0E-6) {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
        } else {
            f = 1.0f / f;
            float f2 = (float)Math.sin(axisAngle4d.angle / 2.0);
            this.w = (float)Math.cos(axisAngle4d.angle / 2.0);
            this.x = (float)axisAngle4d.x * f * f2;
            this.y = (float)axisAngle4d.y * f * f2;
            this.z = (float)axisAngle4d.z * f * f2;
        }
    }

    public final void interpolate(Quat4f quat4f, float f) {
        double d;
        double d2;
        double d3 = this.x * quat4f.x + this.y * quat4f.y + this.z * quat4f.z + this.w * quat4f.w;
        if (d3 < 0.0) {
            quat4f.x = -quat4f.x;
            quat4f.y = -quat4f.y;
            quat4f.z = -quat4f.z;
            quat4f.w = -quat4f.w;
            d3 = -d3;
        }
        if (1.0 - d3 > 1.0E-6) {
            double d4 = Math.acos(d3);
            double d5 = Math.sin(d4);
            d2 = Math.sin((1.0 - (double)f) * d4) / d5;
            d = Math.sin((double)f * d4) / d5;
        } else {
            d2 = 1.0 - (double)f;
            d = f;
        }
        this.w = (float)(d2 * (double)this.w + d * (double)quat4f.w);
        this.x = (float)(d2 * (double)this.x + d * (double)quat4f.x);
        this.y = (float)(d2 * (double)this.y + d * (double)quat4f.y);
        this.z = (float)(d2 * (double)this.z + d * (double)quat4f.z);
    }

    public final void interpolate(Quat4f quat4f, Quat4f quat4f2, float f) {
        double d;
        double d2;
        double d3 = quat4f2.x * quat4f.x + quat4f2.y * quat4f.y + quat4f2.z * quat4f.z + quat4f2.w * quat4f.w;
        if (d3 < 0.0) {
            quat4f.x = -quat4f.x;
            quat4f.y = -quat4f.y;
            quat4f.z = -quat4f.z;
            quat4f.w = -quat4f.w;
            d3 = -d3;
        }
        if (1.0 - d3 > 1.0E-6) {
            double d4 = Math.acos(d3);
            double d5 = Math.sin(d4);
            d2 = Math.sin((1.0 - (double)f) * d4) / d5;
            d = Math.sin((double)f * d4) / d5;
        } else {
            d2 = 1.0 - (double)f;
            d = f;
        }
        this.w = (float)(d2 * (double)quat4f.w + d * (double)quat4f2.w);
        this.x = (float)(d2 * (double)quat4f.x + d * (double)quat4f2.x);
        this.y = (float)(d2 * (double)quat4f.y + d * (double)quat4f2.y);
        this.z = (float)(d2 * (double)quat4f.z + d * (double)quat4f2.z);
    }
}


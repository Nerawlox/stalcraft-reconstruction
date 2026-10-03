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
import javax.vecmath.Quat4f;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;

public class Quat4d
extends Tuple4d
implements Serializable {
    static final long serialVersionUID = 7577479888820201099L;
    static final double EPS = 1.0E-6;
    static final double EPS2 = 1.0E-30;
    static final double PIO2 = 1.57079632679;

    public Quat4d(double d, double d2, double d3, double d4) {
        double d5 = 1.0 / Math.sqrt(d * d + d2 * d2 + d3 * d3 + d4 * d4);
        this.x = d * d5;
        this.y = d2 * d5;
        this.z = d3 * d5;
        this.w = d4 * d5;
    }

    public Quat4d(double[] dArray) {
        double d = 1.0 / Math.sqrt(dArray[0] * dArray[0] + dArray[1] * dArray[1] + dArray[2] * dArray[2] + dArray[3] * dArray[3]);
        this.x = dArray[0] * d;
        this.y = dArray[1] * d;
        this.z = dArray[2] * d;
        this.w = dArray[3] * d;
    }

    public Quat4d(Quat4d quat4d) {
        super(quat4d);
    }

    public Quat4d(Quat4f quat4f) {
        super(quat4f);
    }

    public Quat4d(Tuple4f tuple4f) {
        double d = 1.0 / Math.sqrt(tuple4f.x * tuple4f.x + tuple4f.y * tuple4f.y + tuple4f.z * tuple4f.z + tuple4f.w * tuple4f.w);
        this.x = (double)tuple4f.x * d;
        this.y = (double)tuple4f.y * d;
        this.z = (double)tuple4f.z * d;
        this.w = (double)tuple4f.w * d;
    }

    public Quat4d(Tuple4d tuple4d) {
        double d = 1.0 / Math.sqrt(tuple4d.x * tuple4d.x + tuple4d.y * tuple4d.y + tuple4d.z * tuple4d.z + tuple4d.w * tuple4d.w);
        this.x = tuple4d.x * d;
        this.y = tuple4d.y * d;
        this.z = tuple4d.z * d;
        this.w = tuple4d.w * d;
    }

    public Quat4d() {
    }

    public final void conjugate(Quat4d quat4d) {
        this.x = -quat4d.x;
        this.y = -quat4d.y;
        this.z = -quat4d.z;
        this.w = quat4d.w;
    }

    public final void conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public final void mul(Quat4d quat4d, Quat4d quat4d2) {
        if (this != quat4d && this != quat4d2) {
            this.w = quat4d.w * quat4d2.w - quat4d.x * quat4d2.x - quat4d.y * quat4d2.y - quat4d.z * quat4d2.z;
            this.x = quat4d.w * quat4d2.x + quat4d2.w * quat4d.x + quat4d.y * quat4d2.z - quat4d.z * quat4d2.y;
            this.y = quat4d.w * quat4d2.y + quat4d2.w * quat4d.y - quat4d.x * quat4d2.z + quat4d.z * quat4d2.x;
            this.z = quat4d.w * quat4d2.z + quat4d2.w * quat4d.z + quat4d.x * quat4d2.y - quat4d.y * quat4d2.x;
        } else {
            double d = quat4d.w * quat4d2.w - quat4d.x * quat4d2.x - quat4d.y * quat4d2.y - quat4d.z * quat4d2.z;
            double d2 = quat4d.w * quat4d2.x + quat4d2.w * quat4d.x + quat4d.y * quat4d2.z - quat4d.z * quat4d2.y;
            double d3 = quat4d.w * quat4d2.y + quat4d2.w * quat4d.y - quat4d.x * quat4d2.z + quat4d.z * quat4d2.x;
            this.z = quat4d.w * quat4d2.z + quat4d2.w * quat4d.z + quat4d.x * quat4d2.y - quat4d.y * quat4d2.x;
            this.w = d;
            this.x = d2;
            this.y = d3;
        }
    }

    public final void mul(Quat4d quat4d) {
        double d = this.w * quat4d.w - this.x * quat4d.x - this.y * quat4d.y - this.z * quat4d.z;
        double d2 = this.w * quat4d.x + quat4d.w * this.x + this.y * quat4d.z - this.z * quat4d.y;
        double d3 = this.w * quat4d.y + quat4d.w * this.y - this.x * quat4d.z + this.z * quat4d.x;
        this.z = this.w * quat4d.z + quat4d.w * this.z + this.x * quat4d.y - this.y * quat4d.x;
        this.w = d;
        this.x = d2;
        this.y = d3;
    }

    public final void mulInverse(Quat4d quat4d, Quat4d quat4d2) {
        Quat4d quat4d3 = new Quat4d(quat4d2);
        quat4d3.inverse();
        this.mul(quat4d, quat4d3);
    }

    public final void mulInverse(Quat4d quat4d) {
        Quat4d quat4d2 = new Quat4d(quat4d);
        quat4d2.inverse();
        this.mul(quat4d2);
    }

    public final void inverse(Quat4d quat4d) {
        double d = 1.0 / (quat4d.w * quat4d.w + quat4d.x * quat4d.x + quat4d.y * quat4d.y + quat4d.z * quat4d.z);
        this.w = d * quat4d.w;
        this.x = -d * quat4d.x;
        this.y = -d * quat4d.y;
        this.z = -d * quat4d.z;
    }

    public final void inverse() {
        double d = 1.0 / (this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z);
        this.w *= d;
        this.x *= -d;
        this.y *= -d;
        this.z *= -d;
    }

    public final void normalize(Quat4d quat4d) {
        double d = quat4d.x * quat4d.x + quat4d.y * quat4d.y + quat4d.z * quat4d.z + quat4d.w * quat4d.w;
        if (d > 0.0) {
            d = 1.0 / Math.sqrt(d);
            this.x = d * quat4d.x;
            this.y = d * quat4d.y;
            this.z = d * quat4d.z;
            this.w = d * quat4d.w;
        } else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
            this.w = 0.0;
        }
    }

    public final void normalize() {
        double d = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        if (d > 0.0) {
            d = 1.0 / Math.sqrt(d);
            this.x *= d;
            this.y *= d;
            this.z *= d;
            this.w *= d;
        } else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
            this.w = 0.0;
        }
    }

    public final void set(Matrix4f matrix4f) {
        double d = 0.25 * (double)(matrix4f.m00 + matrix4f.m11 + matrix4f.m22 + matrix4f.m33);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.w = Math.sqrt(d);
                d = 0.25 / this.w;
                this.x = (double)(matrix4f.m21 - matrix4f.m12) * d;
                this.y = (double)(matrix4f.m02 - matrix4f.m20) * d;
                this.z = (double)(matrix4f.m10 - matrix4f.m01) * d;
                return;
            }
        } else {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        this.w = 0.0;
        d = -0.5 * (double)(matrix4f.m11 + matrix4f.m22);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.x = Math.sqrt(d);
                d = 1.0 / (2.0 * this.x);
                this.y = (double)matrix4f.m10 * d;
                this.z = (double)matrix4f.m20 * d;
                return;
            }
        } else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        this.x = 0.0;
        d = 0.5 * (1.0 - (double)matrix4f.m22);
        if (d >= 1.0E-30) {
            this.y = Math.sqrt(d);
            this.z = (double)matrix4f.m21 / (2.0 * this.y);
            return;
        }
        this.y = 0.0;
        this.z = 1.0;
    }

    public final void set(Matrix4d matrix4d) {
        double d = 0.25 * (matrix4d.m00 + matrix4d.m11 + matrix4d.m22 + matrix4d.m33);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.w = Math.sqrt(d);
                d = 0.25 / this.w;
                this.x = (matrix4d.m21 - matrix4d.m12) * d;
                this.y = (matrix4d.m02 - matrix4d.m20) * d;
                this.z = (matrix4d.m10 - matrix4d.m01) * d;
                return;
            }
        } else {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        this.w = 0.0;
        d = -0.5 * (matrix4d.m11 + matrix4d.m22);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.x = Math.sqrt(d);
                d = 0.5 / this.x;
                this.y = matrix4d.m10 * d;
                this.z = matrix4d.m20 * d;
                return;
            }
        } else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        this.x = 0.0;
        d = 0.5 * (1.0 - matrix4d.m22);
        if (d >= 1.0E-30) {
            this.y = Math.sqrt(d);
            this.z = matrix4d.m21 / (2.0 * this.y);
            return;
        }
        this.y = 0.0;
        this.z = 1.0;
    }

    public final void set(Matrix3f matrix3f) {
        double d = 0.25 * ((double)(matrix3f.m00 + matrix3f.m11 + matrix3f.m22) + 1.0);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.w = Math.sqrt(d);
                d = 0.25 / this.w;
                this.x = (double)(matrix3f.m21 - matrix3f.m12) * d;
                this.y = (double)(matrix3f.m02 - matrix3f.m20) * d;
                this.z = (double)(matrix3f.m10 - matrix3f.m01) * d;
                return;
            }
        } else {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        this.w = 0.0;
        d = -0.5 * (double)(matrix3f.m11 + matrix3f.m22);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.x = Math.sqrt(d);
                d = 0.5 / this.x;
                this.y = (double)matrix3f.m10 * d;
                this.z = (double)matrix3f.m20 * d;
                return;
            }
        } else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        this.x = 0.0;
        d = 0.5 * (1.0 - (double)matrix3f.m22);
        if (d >= 1.0E-30) {
            this.y = Math.sqrt(d);
            this.z = (double)matrix3f.m21 / (2.0 * this.y);
        }
        this.y = 0.0;
        this.z = 1.0;
    }

    public final void set(Matrix3d matrix3d) {
        double d = 0.25 * (matrix3d.m00 + matrix3d.m11 + matrix3d.m22 + 1.0);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.w = Math.sqrt(d);
                d = 0.25 / this.w;
                this.x = (matrix3d.m21 - matrix3d.m12) * d;
                this.y = (matrix3d.m02 - matrix3d.m20) * d;
                this.z = (matrix3d.m10 - matrix3d.m01) * d;
                return;
            }
        } else {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        this.w = 0.0;
        d = -0.5 * (matrix3d.m11 + matrix3d.m22);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.x = Math.sqrt(d);
                d = 0.5 / this.x;
                this.y = matrix3d.m10 * d;
                this.z = matrix3d.m20 * d;
                return;
            }
        } else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        this.x = 0.0;
        d = 0.5 * (1.0 - matrix3d.m22);
        if (d >= 1.0E-30) {
            this.y = Math.sqrt(d);
            this.z = matrix3d.m21 / (2.0 * this.y);
            return;
        }
        this.y = 0.0;
        this.z = 1.0;
    }

    public final void set(AxisAngle4f axisAngle4f) {
        double d = Math.sqrt(axisAngle4f.x * axisAngle4f.x + axisAngle4f.y * axisAngle4f.y + axisAngle4f.z * axisAngle4f.z);
        if (d < 1.0E-6) {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
        } else {
            double d2 = Math.sin((double)axisAngle4f.angle / 2.0);
            d = 1.0 / d;
            this.w = Math.cos((double)axisAngle4f.angle / 2.0);
            this.x = (double)axisAngle4f.x * d * d2;
            this.y = (double)axisAngle4f.y * d * d2;
            this.z = (double)axisAngle4f.z * d * d2;
        }
    }

    public final void set(AxisAngle4d axisAngle4d) {
        double d = Math.sqrt(axisAngle4d.x * axisAngle4d.x + axisAngle4d.y * axisAngle4d.y + axisAngle4d.z * axisAngle4d.z);
        if (d < 1.0E-6) {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
        } else {
            d = 1.0 / d;
            double d2 = Math.sin(axisAngle4d.angle / 2.0);
            this.w = Math.cos(axisAngle4d.angle / 2.0);
            this.x = axisAngle4d.x * d * d2;
            this.y = axisAngle4d.y * d * d2;
            this.z = axisAngle4d.z * d * d2;
        }
    }

    public final void interpolate(Quat4d quat4d, double d) {
        double d2;
        double d3;
        double d4 = this.x * quat4d.x + this.y * quat4d.y + this.z * quat4d.z + this.w * quat4d.w;
        if (d4 < 0.0) {
            quat4d.x = -quat4d.x;
            quat4d.y = -quat4d.y;
            quat4d.z = -quat4d.z;
            quat4d.w = -quat4d.w;
            d4 = -d4;
        }
        if (1.0 - d4 > 1.0E-6) {
            double d5 = Math.acos(d4);
            double d6 = Math.sin(d5);
            d3 = Math.sin((1.0 - d) * d5) / d6;
            d2 = Math.sin(d * d5) / d6;
        } else {
            d3 = 1.0 - d;
            d2 = d;
        }
        this.w = d3 * this.w + d2 * quat4d.w;
        this.x = d3 * this.x + d2 * quat4d.x;
        this.y = d3 * this.y + d2 * quat4d.y;
        this.z = d3 * this.z + d2 * quat4d.z;
    }

    public final void interpolate(Quat4d quat4d, Quat4d quat4d2, double d) {
        double d2;
        double d3;
        double d4 = quat4d2.x * quat4d.x + quat4d2.y * quat4d.y + quat4d2.z * quat4d.z + quat4d2.w * quat4d.w;
        if (d4 < 0.0) {
            quat4d.x = -quat4d.x;
            quat4d.y = -quat4d.y;
            quat4d.z = -quat4d.z;
            quat4d.w = -quat4d.w;
            d4 = -d4;
        }
        if (1.0 - d4 > 1.0E-6) {
            double d5 = Math.acos(d4);
            double d6 = Math.sin(d5);
            d3 = Math.sin((1.0 - d) * d5) / d6;
            d2 = Math.sin(d * d5) / d6;
        } else {
            d3 = 1.0 - d;
            d2 = d;
        }
        this.w = d3 * quat4d.w + d2 * quat4d2.w;
        this.x = d3 * quat4d.x + d2 * quat4d2.x;
        this.y = d3 * quat4d.y + d2 * quat4d2.y;
        this.z = d3 * quat4d.z + d2 * quat4d2.z;
    }
}


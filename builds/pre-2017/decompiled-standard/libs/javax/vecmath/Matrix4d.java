/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix3d;
import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Quat4d;
import javax.vecmath.Quat4f;
import javax.vecmath.SingularMatrixException;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;
import javax.vecmath.VecMathI18N;
import javax.vecmath.VecMathUtil;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4d;

public class Matrix4d
implements Serializable,
Cloneable {
    static final long serialVersionUID = 8223903484171633710L;
    public double m00;
    public double m01;
    public double m02;
    public double m03;
    public double m10;
    public double m11;
    public double m12;
    public double m13;
    public double m20;
    public double m21;
    public double m22;
    public double m23;
    public double m30;
    public double m31;
    public double m32;
    public double m33;
    private static final double EPS = 1.0E-10;

    public Matrix4d(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        this.m00 = d;
        this.m01 = d2;
        this.m02 = d3;
        this.m03 = d4;
        this.m10 = d5;
        this.m11 = d6;
        this.m12 = d7;
        this.m13 = d8;
        this.m20 = d9;
        this.m21 = d10;
        this.m22 = d11;
        this.m23 = d12;
        this.m30 = d13;
        this.m31 = d14;
        this.m32 = d15;
        this.m33 = d16;
    }

    public Matrix4d(double[] dArray) {
        this.m00 = dArray[0];
        this.m01 = dArray[1];
        this.m02 = dArray[2];
        this.m03 = dArray[3];
        this.m10 = dArray[4];
        this.m11 = dArray[5];
        this.m12 = dArray[6];
        this.m13 = dArray[7];
        this.m20 = dArray[8];
        this.m21 = dArray[9];
        this.m22 = dArray[10];
        this.m23 = dArray[11];
        this.m30 = dArray[12];
        this.m31 = dArray[13];
        this.m32 = dArray[14];
        this.m33 = dArray[15];
    }

    public Matrix4d(Quat4d quat4d, Vector3d vector3d, double d) {
        this.m00 = d * (1.0 - 2.0 * quat4d.y * quat4d.y - 2.0 * quat4d.z * quat4d.z);
        this.m10 = d * (2.0 * (quat4d.x * quat4d.y + quat4d.w * quat4d.z));
        this.m20 = d * (2.0 * (quat4d.x * quat4d.z - quat4d.w * quat4d.y));
        this.m01 = d * (2.0 * (quat4d.x * quat4d.y - quat4d.w * quat4d.z));
        this.m11 = d * (1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.z * quat4d.z);
        this.m21 = d * (2.0 * (quat4d.y * quat4d.z + quat4d.w * quat4d.x));
        this.m02 = d * (2.0 * (quat4d.x * quat4d.z + quat4d.w * quat4d.y));
        this.m12 = d * (2.0 * (quat4d.y * quat4d.z - quat4d.w * quat4d.x));
        this.m22 = d * (1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.y * quat4d.y);
        this.m03 = vector3d.x;
        this.m13 = vector3d.y;
        this.m23 = vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public Matrix4d(Quat4f quat4f, Vector3d vector3d, double d) {
        this.m00 = d * (1.0 - 2.0 * (double)quat4f.y * (double)quat4f.y - 2.0 * (double)quat4f.z * (double)quat4f.z);
        this.m10 = d * (2.0 * (double)(quat4f.x * quat4f.y + quat4f.w * quat4f.z));
        this.m20 = d * (2.0 * (double)(quat4f.x * quat4f.z - quat4f.w * quat4f.y));
        this.m01 = d * (2.0 * (double)(quat4f.x * quat4f.y - quat4f.w * quat4f.z));
        this.m11 = d * (1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.z * (double)quat4f.z);
        this.m21 = d * (2.0 * (double)(quat4f.y * quat4f.z + quat4f.w * quat4f.x));
        this.m02 = d * (2.0 * (double)(quat4f.x * quat4f.z + quat4f.w * quat4f.y));
        this.m12 = d * (2.0 * (double)(quat4f.y * quat4f.z - quat4f.w * quat4f.x));
        this.m22 = d * (1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.y * (double)quat4f.y);
        this.m03 = vector3d.x;
        this.m13 = vector3d.y;
        this.m23 = vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public Matrix4d(Matrix4d matrix4d) {
        this.m00 = matrix4d.m00;
        this.m01 = matrix4d.m01;
        this.m02 = matrix4d.m02;
        this.m03 = matrix4d.m03;
        this.m10 = matrix4d.m10;
        this.m11 = matrix4d.m11;
        this.m12 = matrix4d.m12;
        this.m13 = matrix4d.m13;
        this.m20 = matrix4d.m20;
        this.m21 = matrix4d.m21;
        this.m22 = matrix4d.m22;
        this.m23 = matrix4d.m23;
        this.m30 = matrix4d.m30;
        this.m31 = matrix4d.m31;
        this.m32 = matrix4d.m32;
        this.m33 = matrix4d.m33;
    }

    public Matrix4d(Matrix4f matrix4f) {
        this.m00 = matrix4f.m00;
        this.m01 = matrix4f.m01;
        this.m02 = matrix4f.m02;
        this.m03 = matrix4f.m03;
        this.m10 = matrix4f.m10;
        this.m11 = matrix4f.m11;
        this.m12 = matrix4f.m12;
        this.m13 = matrix4f.m13;
        this.m20 = matrix4f.m20;
        this.m21 = matrix4f.m21;
        this.m22 = matrix4f.m22;
        this.m23 = matrix4f.m23;
        this.m30 = matrix4f.m30;
        this.m31 = matrix4f.m31;
        this.m32 = matrix4f.m32;
        this.m33 = matrix4f.m33;
    }

    public Matrix4d(Matrix3f matrix3f, Vector3d vector3d, double d) {
        this.m00 = (double)matrix3f.m00 * d;
        this.m01 = (double)matrix3f.m01 * d;
        this.m02 = (double)matrix3f.m02 * d;
        this.m03 = vector3d.x;
        this.m10 = (double)matrix3f.m10 * d;
        this.m11 = (double)matrix3f.m11 * d;
        this.m12 = (double)matrix3f.m12 * d;
        this.m13 = vector3d.y;
        this.m20 = (double)matrix3f.m20 * d;
        this.m21 = (double)matrix3f.m21 * d;
        this.m22 = (double)matrix3f.m22 * d;
        this.m23 = vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public Matrix4d(Matrix3d matrix3d, Vector3d vector3d, double d) {
        this.m00 = matrix3d.m00 * d;
        this.m01 = matrix3d.m01 * d;
        this.m02 = matrix3d.m02 * d;
        this.m03 = vector3d.x;
        this.m10 = matrix3d.m10 * d;
        this.m11 = matrix3d.m11 * d;
        this.m12 = matrix3d.m12 * d;
        this.m13 = vector3d.y;
        this.m20 = matrix3d.m20 * d;
        this.m21 = matrix3d.m21 * d;
        this.m22 = matrix3d.m22 * d;
        this.m23 = vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public Matrix4d() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 0.0;
    }

    public String toString() {
        return this.m00 + ", " + this.m01 + ", " + this.m02 + ", " + this.m03 + "\n" + this.m10 + ", " + this.m11 + ", " + this.m12 + ", " + this.m13 + "\n" + this.m20 + ", " + this.m21 + ", " + this.m22 + ", " + this.m23 + "\n" + this.m30 + ", " + this.m31 + ", " + this.m32 + ", " + this.m33 + "\n";
    }

    public final void setIdentity() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void setElement(int n, int n2, double d) {
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        this.m00 = d;
                        break block0;
                    }
                    case 1: {
                        this.m01 = d;
                        break block0;
                    }
                    case 2: {
                        this.m02 = d;
                        break block0;
                    }
                    case 3: {
                        this.m03 = d;
                        break block0;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        this.m10 = d;
                        break block0;
                    }
                    case 1: {
                        this.m11 = d;
                        break block0;
                    }
                    case 2: {
                        this.m12 = d;
                        break block0;
                    }
                    case 3: {
                        this.m13 = d;
                        break block0;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        this.m20 = d;
                        break block0;
                    }
                    case 1: {
                        this.m21 = d;
                        break block0;
                    }
                    case 2: {
                        this.m22 = d;
                        break block0;
                    }
                    case 3: {
                        this.m23 = d;
                        break block0;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
            }
            case 3: {
                switch (n2) {
                    case 0: {
                        this.m30 = d;
                        break block0;
                    }
                    case 1: {
                        this.m31 = d;
                        break block0;
                    }
                    case 2: {
                        this.m32 = d;
                        break block0;
                    }
                    case 3: {
                        this.m33 = d;
                        break block0;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
            }
        }
    }

    public final double getElement(int n, int n2) {
        switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        return this.m00;
                    }
                    case 1: {
                        return this.m01;
                    }
                    case 2: {
                        return this.m02;
                    }
                    case 3: {
                        return this.m03;
                    }
                }
                break;
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        return this.m10;
                    }
                    case 1: {
                        return this.m11;
                    }
                    case 2: {
                        return this.m12;
                    }
                    case 3: {
                        return this.m13;
                    }
                }
                break;
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        return this.m20;
                    }
                    case 1: {
                        return this.m21;
                    }
                    case 2: {
                        return this.m22;
                    }
                    case 3: {
                        return this.m23;
                    }
                }
                break;
            }
            case 3: {
                switch (n2) {
                    case 0: {
                        return this.m30;
                    }
                    case 1: {
                        return this.m31;
                    }
                    case 2: {
                        return this.m32;
                    }
                    case 3: {
                        return this.m33;
                    }
                }
                break;
            }
        }
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d1"));
    }

    public final void getRow(int n, Vector4d vector4d) {
        if (n == 0) {
            vector4d.x = this.m00;
            vector4d.y = this.m01;
            vector4d.z = this.m02;
            vector4d.w = this.m03;
        } else if (n == 1) {
            vector4d.x = this.m10;
            vector4d.y = this.m11;
            vector4d.z = this.m12;
            vector4d.w = this.m13;
        } else if (n == 2) {
            vector4d.x = this.m20;
            vector4d.y = this.m21;
            vector4d.z = this.m22;
            vector4d.w = this.m23;
        } else if (n == 3) {
            vector4d.x = this.m30;
            vector4d.y = this.m31;
            vector4d.z = this.m32;
            vector4d.w = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d2"));
        }
    }

    public final void getRow(int n, double[] dArray) {
        if (n == 0) {
            dArray[0] = this.m00;
            dArray[1] = this.m01;
            dArray[2] = this.m02;
            dArray[3] = this.m03;
        } else if (n == 1) {
            dArray[0] = this.m10;
            dArray[1] = this.m11;
            dArray[2] = this.m12;
            dArray[3] = this.m13;
        } else if (n == 2) {
            dArray[0] = this.m20;
            dArray[1] = this.m21;
            dArray[2] = this.m22;
            dArray[3] = this.m23;
        } else if (n == 3) {
            dArray[0] = this.m30;
            dArray[1] = this.m31;
            dArray[2] = this.m32;
            dArray[3] = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d2"));
        }
    }

    public final void getColumn(int n, Vector4d vector4d) {
        if (n == 0) {
            vector4d.x = this.m00;
            vector4d.y = this.m10;
            vector4d.z = this.m20;
            vector4d.w = this.m30;
        } else if (n == 1) {
            vector4d.x = this.m01;
            vector4d.y = this.m11;
            vector4d.z = this.m21;
            vector4d.w = this.m31;
        } else if (n == 2) {
            vector4d.x = this.m02;
            vector4d.y = this.m12;
            vector4d.z = this.m22;
            vector4d.w = this.m32;
        } else if (n == 3) {
            vector4d.x = this.m03;
            vector4d.y = this.m13;
            vector4d.z = this.m23;
            vector4d.w = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d3"));
        }
    }

    public final void getColumn(int n, double[] dArray) {
        if (n == 0) {
            dArray[0] = this.m00;
            dArray[1] = this.m10;
            dArray[2] = this.m20;
            dArray[3] = this.m30;
        } else if (n == 1) {
            dArray[0] = this.m01;
            dArray[1] = this.m11;
            dArray[2] = this.m21;
            dArray[3] = this.m31;
        } else if (n == 2) {
            dArray[0] = this.m02;
            dArray[1] = this.m12;
            dArray[2] = this.m22;
            dArray[3] = this.m32;
        } else if (n == 3) {
            dArray[0] = this.m03;
            dArray[1] = this.m13;
            dArray[2] = this.m23;
            dArray[3] = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d3"));
        }
    }

    public final void get(Matrix3d matrix3d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        matrix3d.m00 = dArray[0];
        matrix3d.m01 = dArray[1];
        matrix3d.m02 = dArray[2];
        matrix3d.m10 = dArray[3];
        matrix3d.m11 = dArray[4];
        matrix3d.m12 = dArray[5];
        matrix3d.m20 = dArray[6];
        matrix3d.m21 = dArray[7];
        matrix3d.m22 = dArray[8];
    }

    public final void get(Matrix3f matrix3f) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        matrix3f.m00 = (float)dArray[0];
        matrix3f.m01 = (float)dArray[1];
        matrix3f.m02 = (float)dArray[2];
        matrix3f.m10 = (float)dArray[3];
        matrix3f.m11 = (float)dArray[4];
        matrix3f.m12 = (float)dArray[5];
        matrix3f.m20 = (float)dArray[6];
        matrix3f.m21 = (float)dArray[7];
        matrix3f.m22 = (float)dArray[8];
    }

    public final double get(Matrix3d matrix3d, Vector3d vector3d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        matrix3d.m00 = dArray[0];
        matrix3d.m01 = dArray[1];
        matrix3d.m02 = dArray[2];
        matrix3d.m10 = dArray[3];
        matrix3d.m11 = dArray[4];
        matrix3d.m12 = dArray[5];
        matrix3d.m20 = dArray[6];
        matrix3d.m21 = dArray[7];
        matrix3d.m22 = dArray[8];
        vector3d.x = this.m03;
        vector3d.y = this.m13;
        vector3d.z = this.m23;
        return Matrix3d.max3(dArray2);
    }

    public final double get(Matrix3f matrix3f, Vector3d vector3d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        matrix3f.m00 = (float)dArray[0];
        matrix3f.m01 = (float)dArray[1];
        matrix3f.m02 = (float)dArray[2];
        matrix3f.m10 = (float)dArray[3];
        matrix3f.m11 = (float)dArray[4];
        matrix3f.m12 = (float)dArray[5];
        matrix3f.m20 = (float)dArray[6];
        matrix3f.m21 = (float)dArray[7];
        matrix3f.m22 = (float)dArray[8];
        vector3d.x = this.m03;
        vector3d.y = this.m13;
        vector3d.z = this.m23;
        return Matrix3d.max3(dArray2);
    }

    public final void get(Quat4f quat4f) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        double d = 0.25 * (1.0 + dArray[0] + dArray[4] + dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat4f.w = (float)Math.sqrt(d);
            d = 0.25 / (double)quat4f.w;
            quat4f.x = (float)((dArray[7] - dArray[5]) * d);
            quat4f.y = (float)((dArray[2] - dArray[6]) * d);
            quat4f.z = (float)((dArray[3] - dArray[1]) * d);
            return;
        }
        quat4f.w = 0.0f;
        d = -0.5 * (dArray[4] + dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat4f.x = (float)Math.sqrt(d);
            d = 0.5 / (double)quat4f.x;
            quat4f.y = (float)(dArray[3] * d);
            quat4f.z = (float)(dArray[6] * d);
            return;
        }
        quat4f.x = 0.0f;
        d = 0.5 * (1.0 - dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat4f.y = (float)Math.sqrt(d);
            quat4f.z = (float)(dArray[7] / (2.0 * (double)quat4f.y));
            return;
        }
        quat4f.y = 0.0f;
        quat4f.z = 1.0f;
    }

    public final void get(Quat4d quat4d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        double d = 0.25 * (1.0 + dArray[0] + dArray[4] + dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat4d.w = Math.sqrt(d);
            d = 0.25 / quat4d.w;
            quat4d.x = (dArray[7] - dArray[5]) * d;
            quat4d.y = (dArray[2] - dArray[6]) * d;
            quat4d.z = (dArray[3] - dArray[1]) * d;
            return;
        }
        quat4d.w = 0.0;
        d = -0.5 * (dArray[4] + dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat4d.x = Math.sqrt(d);
            d = 0.5 / quat4d.x;
            quat4d.y = dArray[3] * d;
            quat4d.z = dArray[6] * d;
            return;
        }
        quat4d.x = 0.0;
        d = 0.5 * (1.0 - dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat4d.y = Math.sqrt(d);
            quat4d.z = dArray[7] / (2.0 * quat4d.y);
            return;
        }
        quat4d.y = 0.0;
        quat4d.z = 1.0;
    }

    public final void get(Vector3d vector3d) {
        vector3d.x = this.m03;
        vector3d.y = this.m13;
        vector3d.z = this.m23;
    }

    public final void getRotationScale(Matrix3f matrix3f) {
        matrix3f.m00 = (float)this.m00;
        matrix3f.m01 = (float)this.m01;
        matrix3f.m02 = (float)this.m02;
        matrix3f.m10 = (float)this.m10;
        matrix3f.m11 = (float)this.m11;
        matrix3f.m12 = (float)this.m12;
        matrix3f.m20 = (float)this.m20;
        matrix3f.m21 = (float)this.m21;
        matrix3f.m22 = (float)this.m22;
    }

    public final void getRotationScale(Matrix3d matrix3d) {
        matrix3d.m00 = this.m00;
        matrix3d.m01 = this.m01;
        matrix3d.m02 = this.m02;
        matrix3d.m10 = this.m10;
        matrix3d.m11 = this.m11;
        matrix3d.m12 = this.m12;
        matrix3d.m20 = this.m20;
        matrix3d.m21 = this.m21;
        matrix3d.m22 = this.m22;
    }

    public final double getScale() {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        return Matrix3d.max3(dArray2);
    }

    public final void setRotationScale(Matrix3d matrix3d) {
        this.m00 = matrix3d.m00;
        this.m01 = matrix3d.m01;
        this.m02 = matrix3d.m02;
        this.m10 = matrix3d.m10;
        this.m11 = matrix3d.m11;
        this.m12 = matrix3d.m12;
        this.m20 = matrix3d.m20;
        this.m21 = matrix3d.m21;
        this.m22 = matrix3d.m22;
    }

    public final void setRotationScale(Matrix3f matrix3f) {
        this.m00 = matrix3f.m00;
        this.m01 = matrix3f.m01;
        this.m02 = matrix3f.m02;
        this.m10 = matrix3f.m10;
        this.m11 = matrix3f.m11;
        this.m12 = matrix3f.m12;
        this.m20 = matrix3f.m20;
        this.m21 = matrix3f.m21;
        this.m22 = matrix3f.m22;
    }

    public final void setScale(double d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = dArray[0] * d;
        this.m01 = dArray[1] * d;
        this.m02 = dArray[2] * d;
        this.m10 = dArray[3] * d;
        this.m11 = dArray[4] * d;
        this.m12 = dArray[5] * d;
        this.m20 = dArray[6] * d;
        this.m21 = dArray[7] * d;
        this.m22 = dArray[8] * d;
    }

    public final void setRow(int n, double d, double d2, double d3, double d4) {
        switch (n) {
            case 0: {
                this.m00 = d;
                this.m01 = d2;
                this.m02 = d3;
                this.m03 = d4;
                break;
            }
            case 1: {
                this.m10 = d;
                this.m11 = d2;
                this.m12 = d3;
                this.m13 = d4;
                break;
            }
            case 2: {
                this.m20 = d;
                this.m21 = d2;
                this.m22 = d3;
                this.m23 = d4;
                break;
            }
            case 3: {
                this.m30 = d;
                this.m31 = d2;
                this.m32 = d3;
                this.m33 = d4;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d4"));
            }
        }
    }

    public final void setRow(int n, Vector4d vector4d) {
        switch (n) {
            case 0: {
                this.m00 = vector4d.x;
                this.m01 = vector4d.y;
                this.m02 = vector4d.z;
                this.m03 = vector4d.w;
                break;
            }
            case 1: {
                this.m10 = vector4d.x;
                this.m11 = vector4d.y;
                this.m12 = vector4d.z;
                this.m13 = vector4d.w;
                break;
            }
            case 2: {
                this.m20 = vector4d.x;
                this.m21 = vector4d.y;
                this.m22 = vector4d.z;
                this.m23 = vector4d.w;
                break;
            }
            case 3: {
                this.m30 = vector4d.x;
                this.m31 = vector4d.y;
                this.m32 = vector4d.z;
                this.m33 = vector4d.w;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d4"));
            }
        }
    }

    public final void setRow(int n, double[] dArray) {
        switch (n) {
            case 0: {
                this.m00 = dArray[0];
                this.m01 = dArray[1];
                this.m02 = dArray[2];
                this.m03 = dArray[3];
                break;
            }
            case 1: {
                this.m10 = dArray[0];
                this.m11 = dArray[1];
                this.m12 = dArray[2];
                this.m13 = dArray[3];
                break;
            }
            case 2: {
                this.m20 = dArray[0];
                this.m21 = dArray[1];
                this.m22 = dArray[2];
                this.m23 = dArray[3];
                break;
            }
            case 3: {
                this.m30 = dArray[0];
                this.m31 = dArray[1];
                this.m32 = dArray[2];
                this.m33 = dArray[3];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d4"));
            }
        }
    }

    public final void setColumn(int n, double d, double d2, double d3, double d4) {
        switch (n) {
            case 0: {
                this.m00 = d;
                this.m10 = d2;
                this.m20 = d3;
                this.m30 = d4;
                break;
            }
            case 1: {
                this.m01 = d;
                this.m11 = d2;
                this.m21 = d3;
                this.m31 = d4;
                break;
            }
            case 2: {
                this.m02 = d;
                this.m12 = d2;
                this.m22 = d3;
                this.m32 = d4;
                break;
            }
            case 3: {
                this.m03 = d;
                this.m13 = d2;
                this.m23 = d3;
                this.m33 = d4;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d7"));
            }
        }
    }

    public final void setColumn(int n, Vector4d vector4d) {
        switch (n) {
            case 0: {
                this.m00 = vector4d.x;
                this.m10 = vector4d.y;
                this.m20 = vector4d.z;
                this.m30 = vector4d.w;
                break;
            }
            case 1: {
                this.m01 = vector4d.x;
                this.m11 = vector4d.y;
                this.m21 = vector4d.z;
                this.m31 = vector4d.w;
                break;
            }
            case 2: {
                this.m02 = vector4d.x;
                this.m12 = vector4d.y;
                this.m22 = vector4d.z;
                this.m32 = vector4d.w;
                break;
            }
            case 3: {
                this.m03 = vector4d.x;
                this.m13 = vector4d.y;
                this.m23 = vector4d.z;
                this.m33 = vector4d.w;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d7"));
            }
        }
    }

    public final void setColumn(int n, double[] dArray) {
        switch (n) {
            case 0: {
                this.m00 = dArray[0];
                this.m10 = dArray[1];
                this.m20 = dArray[2];
                this.m30 = dArray[3];
                break;
            }
            case 1: {
                this.m01 = dArray[0];
                this.m11 = dArray[1];
                this.m21 = dArray[2];
                this.m31 = dArray[3];
                break;
            }
            case 2: {
                this.m02 = dArray[0];
                this.m12 = dArray[1];
                this.m22 = dArray[2];
                this.m32 = dArray[3];
                break;
            }
            case 3: {
                this.m03 = dArray[0];
                this.m13 = dArray[1];
                this.m23 = dArray[2];
                this.m33 = dArray[3];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d7"));
            }
        }
    }

    public final void add(double d) {
        this.m00 += d;
        this.m01 += d;
        this.m02 += d;
        this.m03 += d;
        this.m10 += d;
        this.m11 += d;
        this.m12 += d;
        this.m13 += d;
        this.m20 += d;
        this.m21 += d;
        this.m22 += d;
        this.m23 += d;
        this.m30 += d;
        this.m31 += d;
        this.m32 += d;
        this.m33 += d;
    }

    public final void add(double d, Matrix4d matrix4d) {
        this.m00 = matrix4d.m00 + d;
        this.m01 = matrix4d.m01 + d;
        this.m02 = matrix4d.m02 + d;
        this.m03 = matrix4d.m03 + d;
        this.m10 = matrix4d.m10 + d;
        this.m11 = matrix4d.m11 + d;
        this.m12 = matrix4d.m12 + d;
        this.m13 = matrix4d.m13 + d;
        this.m20 = matrix4d.m20 + d;
        this.m21 = matrix4d.m21 + d;
        this.m22 = matrix4d.m22 + d;
        this.m23 = matrix4d.m23 + d;
        this.m30 = matrix4d.m30 + d;
        this.m31 = matrix4d.m31 + d;
        this.m32 = matrix4d.m32 + d;
        this.m33 = matrix4d.m33 + d;
    }

    public final void add(Matrix4d matrix4d, Matrix4d matrix4d2) {
        this.m00 = matrix4d.m00 + matrix4d2.m00;
        this.m01 = matrix4d.m01 + matrix4d2.m01;
        this.m02 = matrix4d.m02 + matrix4d2.m02;
        this.m03 = matrix4d.m03 + matrix4d2.m03;
        this.m10 = matrix4d.m10 + matrix4d2.m10;
        this.m11 = matrix4d.m11 + matrix4d2.m11;
        this.m12 = matrix4d.m12 + matrix4d2.m12;
        this.m13 = matrix4d.m13 + matrix4d2.m13;
        this.m20 = matrix4d.m20 + matrix4d2.m20;
        this.m21 = matrix4d.m21 + matrix4d2.m21;
        this.m22 = matrix4d.m22 + matrix4d2.m22;
        this.m23 = matrix4d.m23 + matrix4d2.m23;
        this.m30 = matrix4d.m30 + matrix4d2.m30;
        this.m31 = matrix4d.m31 + matrix4d2.m31;
        this.m32 = matrix4d.m32 + matrix4d2.m32;
        this.m33 = matrix4d.m33 + matrix4d2.m33;
    }

    public final void add(Matrix4d matrix4d) {
        this.m00 += matrix4d.m00;
        this.m01 += matrix4d.m01;
        this.m02 += matrix4d.m02;
        this.m03 += matrix4d.m03;
        this.m10 += matrix4d.m10;
        this.m11 += matrix4d.m11;
        this.m12 += matrix4d.m12;
        this.m13 += matrix4d.m13;
        this.m20 += matrix4d.m20;
        this.m21 += matrix4d.m21;
        this.m22 += matrix4d.m22;
        this.m23 += matrix4d.m23;
        this.m30 += matrix4d.m30;
        this.m31 += matrix4d.m31;
        this.m32 += matrix4d.m32;
        this.m33 += matrix4d.m33;
    }

    public final void sub(Matrix4d matrix4d, Matrix4d matrix4d2) {
        this.m00 = matrix4d.m00 - matrix4d2.m00;
        this.m01 = matrix4d.m01 - matrix4d2.m01;
        this.m02 = matrix4d.m02 - matrix4d2.m02;
        this.m03 = matrix4d.m03 - matrix4d2.m03;
        this.m10 = matrix4d.m10 - matrix4d2.m10;
        this.m11 = matrix4d.m11 - matrix4d2.m11;
        this.m12 = matrix4d.m12 - matrix4d2.m12;
        this.m13 = matrix4d.m13 - matrix4d2.m13;
        this.m20 = matrix4d.m20 - matrix4d2.m20;
        this.m21 = matrix4d.m21 - matrix4d2.m21;
        this.m22 = matrix4d.m22 - matrix4d2.m22;
        this.m23 = matrix4d.m23 - matrix4d2.m23;
        this.m30 = matrix4d.m30 - matrix4d2.m30;
        this.m31 = matrix4d.m31 - matrix4d2.m31;
        this.m32 = matrix4d.m32 - matrix4d2.m32;
        this.m33 = matrix4d.m33 - matrix4d2.m33;
    }

    public final void sub(Matrix4d matrix4d) {
        this.m00 -= matrix4d.m00;
        this.m01 -= matrix4d.m01;
        this.m02 -= matrix4d.m02;
        this.m03 -= matrix4d.m03;
        this.m10 -= matrix4d.m10;
        this.m11 -= matrix4d.m11;
        this.m12 -= matrix4d.m12;
        this.m13 -= matrix4d.m13;
        this.m20 -= matrix4d.m20;
        this.m21 -= matrix4d.m21;
        this.m22 -= matrix4d.m22;
        this.m23 -= matrix4d.m23;
        this.m30 -= matrix4d.m30;
        this.m31 -= matrix4d.m31;
        this.m32 -= matrix4d.m32;
        this.m33 -= matrix4d.m33;
    }

    public final void transpose() {
        double d = this.m10;
        this.m10 = this.m01;
        this.m01 = d;
        d = this.m20;
        this.m20 = this.m02;
        this.m02 = d;
        d = this.m30;
        this.m30 = this.m03;
        this.m03 = d;
        d = this.m21;
        this.m21 = this.m12;
        this.m12 = d;
        d = this.m31;
        this.m31 = this.m13;
        this.m13 = d;
        d = this.m32;
        this.m32 = this.m23;
        this.m23 = d;
    }

    public final void transpose(Matrix4d matrix4d) {
        if (this != matrix4d) {
            this.m00 = matrix4d.m00;
            this.m01 = matrix4d.m10;
            this.m02 = matrix4d.m20;
            this.m03 = matrix4d.m30;
            this.m10 = matrix4d.m01;
            this.m11 = matrix4d.m11;
            this.m12 = matrix4d.m21;
            this.m13 = matrix4d.m31;
            this.m20 = matrix4d.m02;
            this.m21 = matrix4d.m12;
            this.m22 = matrix4d.m22;
            this.m23 = matrix4d.m32;
            this.m30 = matrix4d.m03;
            this.m31 = matrix4d.m13;
            this.m32 = matrix4d.m23;
            this.m33 = matrix4d.m33;
        } else {
            this.transpose();
        }
    }

    public final void set(double[] dArray) {
        this.m00 = dArray[0];
        this.m01 = dArray[1];
        this.m02 = dArray[2];
        this.m03 = dArray[3];
        this.m10 = dArray[4];
        this.m11 = dArray[5];
        this.m12 = dArray[6];
        this.m13 = dArray[7];
        this.m20 = dArray[8];
        this.m21 = dArray[9];
        this.m22 = dArray[10];
        this.m23 = dArray[11];
        this.m30 = dArray[12];
        this.m31 = dArray[13];
        this.m32 = dArray[14];
        this.m33 = dArray[15];
    }

    public final void set(Matrix3f matrix3f) {
        this.m00 = matrix3f.m00;
        this.m01 = matrix3f.m01;
        this.m02 = matrix3f.m02;
        this.m03 = 0.0;
        this.m10 = matrix3f.m10;
        this.m11 = matrix3f.m11;
        this.m12 = matrix3f.m12;
        this.m13 = 0.0;
        this.m20 = matrix3f.m20;
        this.m21 = matrix3f.m21;
        this.m22 = matrix3f.m22;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Matrix3d matrix3d) {
        this.m00 = matrix3d.m00;
        this.m01 = matrix3d.m01;
        this.m02 = matrix3d.m02;
        this.m03 = 0.0;
        this.m10 = matrix3d.m10;
        this.m11 = matrix3d.m11;
        this.m12 = matrix3d.m12;
        this.m13 = 0.0;
        this.m20 = matrix3d.m20;
        this.m21 = matrix3d.m21;
        this.m22 = matrix3d.m22;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Quat4d quat4d) {
        this.m00 = 1.0 - 2.0 * quat4d.y * quat4d.y - 2.0 * quat4d.z * quat4d.z;
        this.m10 = 2.0 * (quat4d.x * quat4d.y + quat4d.w * quat4d.z);
        this.m20 = 2.0 * (quat4d.x * quat4d.z - quat4d.w * quat4d.y);
        this.m01 = 2.0 * (quat4d.x * quat4d.y - quat4d.w * quat4d.z);
        this.m11 = 1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.z * quat4d.z;
        this.m21 = 2.0 * (quat4d.y * quat4d.z + quat4d.w * quat4d.x);
        this.m02 = 2.0 * (quat4d.x * quat4d.z + quat4d.w * quat4d.y);
        this.m12 = 2.0 * (quat4d.y * quat4d.z - quat4d.w * quat4d.x);
        this.m22 = 1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.y * quat4d.y;
        this.m03 = 0.0;
        this.m13 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(AxisAngle4d axisAngle4d) {
        double d = Math.sqrt(axisAngle4d.x * axisAngle4d.x + axisAngle4d.y * axisAngle4d.y + axisAngle4d.z * axisAngle4d.z);
        if (d < 1.0E-10) {
            this.m00 = 1.0;
            this.m01 = 0.0;
            this.m02 = 0.0;
            this.m10 = 0.0;
            this.m11 = 1.0;
            this.m12 = 0.0;
            this.m20 = 0.0;
            this.m21 = 0.0;
            this.m22 = 1.0;
        } else {
            d = 1.0 / d;
            double d2 = axisAngle4d.x * d;
            double d3 = axisAngle4d.y * d;
            double d4 = axisAngle4d.z * d;
            double d5 = Math.sin(axisAngle4d.angle);
            double d6 = Math.cos(axisAngle4d.angle);
            double d7 = 1.0 - d6;
            double d8 = d2 * d4;
            double d9 = d2 * d3;
            double d10 = d3 * d4;
            this.m00 = d7 * d2 * d2 + d6;
            this.m01 = d7 * d9 - d5 * d4;
            this.m02 = d7 * d8 + d5 * d3;
            this.m10 = d7 * d9 + d5 * d4;
            this.m11 = d7 * d3 * d3 + d6;
            this.m12 = d7 * d10 - d5 * d2;
            this.m20 = d7 * d8 - d5 * d3;
            this.m21 = d7 * d10 + d5 * d2;
            this.m22 = d7 * d4 * d4 + d6;
        }
        this.m03 = 0.0;
        this.m13 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Quat4f quat4f) {
        this.m00 = 1.0 - 2.0 * (double)quat4f.y * (double)quat4f.y - 2.0 * (double)quat4f.z * (double)quat4f.z;
        this.m10 = 2.0 * (double)(quat4f.x * quat4f.y + quat4f.w * quat4f.z);
        this.m20 = 2.0 * (double)(quat4f.x * quat4f.z - quat4f.w * quat4f.y);
        this.m01 = 2.0 * (double)(quat4f.x * quat4f.y - quat4f.w * quat4f.z);
        this.m11 = 1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.z * (double)quat4f.z;
        this.m21 = 2.0 * (double)(quat4f.y * quat4f.z + quat4f.w * quat4f.x);
        this.m02 = 2.0 * (double)(quat4f.x * quat4f.z + quat4f.w * quat4f.y);
        this.m12 = 2.0 * (double)(quat4f.y * quat4f.z - quat4f.w * quat4f.x);
        this.m22 = 1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.y * (double)quat4f.y;
        this.m03 = 0.0;
        this.m13 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(AxisAngle4f axisAngle4f) {
        double d = Math.sqrt(axisAngle4f.x * axisAngle4f.x + axisAngle4f.y * axisAngle4f.y + axisAngle4f.z * axisAngle4f.z);
        if (d < 1.0E-10) {
            this.m00 = 1.0;
            this.m01 = 0.0;
            this.m02 = 0.0;
            this.m10 = 0.0;
            this.m11 = 1.0;
            this.m12 = 0.0;
            this.m20 = 0.0;
            this.m21 = 0.0;
            this.m22 = 1.0;
        } else {
            d = 1.0 / d;
            double d2 = (double)axisAngle4f.x * d;
            double d3 = (double)axisAngle4f.y * d;
            double d4 = (double)axisAngle4f.z * d;
            double d5 = Math.sin(axisAngle4f.angle);
            double d6 = Math.cos(axisAngle4f.angle);
            double d7 = 1.0 - d6;
            double d8 = d2 * d4;
            double d9 = d2 * d3;
            double d10 = d3 * d4;
            this.m00 = d7 * d2 * d2 + d6;
            this.m01 = d7 * d9 - d5 * d4;
            this.m02 = d7 * d8 + d5 * d3;
            this.m10 = d7 * d9 + d5 * d4;
            this.m11 = d7 * d3 * d3 + d6;
            this.m12 = d7 * d10 - d5 * d2;
            this.m20 = d7 * d8 - d5 * d3;
            this.m21 = d7 * d10 + d5 * d2;
            this.m22 = d7 * d4 * d4 + d6;
        }
        this.m03 = 0.0;
        this.m13 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Quat4d quat4d, Vector3d vector3d, double d) {
        this.m00 = d * (1.0 - 2.0 * quat4d.y * quat4d.y - 2.0 * quat4d.z * quat4d.z);
        this.m10 = d * (2.0 * (quat4d.x * quat4d.y + quat4d.w * quat4d.z));
        this.m20 = d * (2.0 * (quat4d.x * quat4d.z - quat4d.w * quat4d.y));
        this.m01 = d * (2.0 * (quat4d.x * quat4d.y - quat4d.w * quat4d.z));
        this.m11 = d * (1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.z * quat4d.z);
        this.m21 = d * (2.0 * (quat4d.y * quat4d.z + quat4d.w * quat4d.x));
        this.m02 = d * (2.0 * (quat4d.x * quat4d.z + quat4d.w * quat4d.y));
        this.m12 = d * (2.0 * (quat4d.y * quat4d.z - quat4d.w * quat4d.x));
        this.m22 = d * (1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.y * quat4d.y);
        this.m03 = vector3d.x;
        this.m13 = vector3d.y;
        this.m23 = vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Quat4f quat4f, Vector3d vector3d, double d) {
        this.m00 = d * (1.0 - 2.0 * (double)quat4f.y * (double)quat4f.y - 2.0 * (double)quat4f.z * (double)quat4f.z);
        this.m10 = d * (2.0 * (double)(quat4f.x * quat4f.y + quat4f.w * quat4f.z));
        this.m20 = d * (2.0 * (double)(quat4f.x * quat4f.z - quat4f.w * quat4f.y));
        this.m01 = d * (2.0 * (double)(quat4f.x * quat4f.y - quat4f.w * quat4f.z));
        this.m11 = d * (1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.z * (double)quat4f.z);
        this.m21 = d * (2.0 * (double)(quat4f.y * quat4f.z + quat4f.w * quat4f.x));
        this.m02 = d * (2.0 * (double)(quat4f.x * quat4f.z + quat4f.w * quat4f.y));
        this.m12 = d * (2.0 * (double)(quat4f.y * quat4f.z - quat4f.w * quat4f.x));
        this.m22 = d * (1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.y * (double)quat4f.y);
        this.m03 = vector3d.x;
        this.m13 = vector3d.y;
        this.m23 = vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Quat4f quat4f, Vector3f vector3f, float f) {
        this.m00 = (double)f * (1.0 - 2.0 * (double)quat4f.y * (double)quat4f.y - 2.0 * (double)quat4f.z * (double)quat4f.z);
        this.m10 = (double)f * (2.0 * (double)(quat4f.x * quat4f.y + quat4f.w * quat4f.z));
        this.m20 = (double)f * (2.0 * (double)(quat4f.x * quat4f.z - quat4f.w * quat4f.y));
        this.m01 = (double)f * (2.0 * (double)(quat4f.x * quat4f.y - quat4f.w * quat4f.z));
        this.m11 = (double)f * (1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.z * (double)quat4f.z);
        this.m21 = (double)f * (2.0 * (double)(quat4f.y * quat4f.z + quat4f.w * quat4f.x));
        this.m02 = (double)f * (2.0 * (double)(quat4f.x * quat4f.z + quat4f.w * quat4f.y));
        this.m12 = (double)f * (2.0 * (double)(quat4f.y * quat4f.z - quat4f.w * quat4f.x));
        this.m22 = (double)f * (1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.y * (double)quat4f.y);
        this.m03 = vector3f.x;
        this.m13 = vector3f.y;
        this.m23 = vector3f.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Matrix4f matrix4f) {
        this.m00 = matrix4f.m00;
        this.m01 = matrix4f.m01;
        this.m02 = matrix4f.m02;
        this.m03 = matrix4f.m03;
        this.m10 = matrix4f.m10;
        this.m11 = matrix4f.m11;
        this.m12 = matrix4f.m12;
        this.m13 = matrix4f.m13;
        this.m20 = matrix4f.m20;
        this.m21 = matrix4f.m21;
        this.m22 = matrix4f.m22;
        this.m23 = matrix4f.m23;
        this.m30 = matrix4f.m30;
        this.m31 = matrix4f.m31;
        this.m32 = matrix4f.m32;
        this.m33 = matrix4f.m33;
    }

    public final void set(Matrix4d matrix4d) {
        this.m00 = matrix4d.m00;
        this.m01 = matrix4d.m01;
        this.m02 = matrix4d.m02;
        this.m03 = matrix4d.m03;
        this.m10 = matrix4d.m10;
        this.m11 = matrix4d.m11;
        this.m12 = matrix4d.m12;
        this.m13 = matrix4d.m13;
        this.m20 = matrix4d.m20;
        this.m21 = matrix4d.m21;
        this.m22 = matrix4d.m22;
        this.m23 = matrix4d.m23;
        this.m30 = matrix4d.m30;
        this.m31 = matrix4d.m31;
        this.m32 = matrix4d.m32;
        this.m33 = matrix4d.m33;
    }

    public final void invert(Matrix4d matrix4d) {
        this.invertGeneral(matrix4d);
    }

    public final void invert() {
        this.invertGeneral(this);
    }

    final void invertGeneral(Matrix4d matrix4d) {
        double[] dArray = new double[16];
        int[] nArray = new int[4];
        double[] dArray2 = new double[]{matrix4d.m00, matrix4d.m01, matrix4d.m02, matrix4d.m03, matrix4d.m10, matrix4d.m11, matrix4d.m12, matrix4d.m13, matrix4d.m20, matrix4d.m21, matrix4d.m22, matrix4d.m23, matrix4d.m30, matrix4d.m31, matrix4d.m32, matrix4d.m33};
        if (!Matrix4d.luDecomposition(dArray2, nArray)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix4d10"));
        }
        for (int i = 0; i < 16; ++i) {
            dArray[i] = 0.0;
        }
        dArray[0] = 1.0;
        dArray[5] = 1.0;
        dArray[10] = 1.0;
        dArray[15] = 1.0;
        Matrix4d.luBacksubstitution(dArray2, nArray, dArray);
        this.m00 = dArray[0];
        this.m01 = dArray[1];
        this.m02 = dArray[2];
        this.m03 = dArray[3];
        this.m10 = dArray[4];
        this.m11 = dArray[5];
        this.m12 = dArray[6];
        this.m13 = dArray[7];
        this.m20 = dArray[8];
        this.m21 = dArray[9];
        this.m22 = dArray[10];
        this.m23 = dArray[11];
        this.m30 = dArray[12];
        this.m31 = dArray[13];
        this.m32 = dArray[14];
        this.m33 = dArray[15];
    }

    static boolean luDecomposition(double[] dArray, int[] nArray) {
        int n;
        double[] dArray2 = new double[4];
        int n2 = 0;
        int n3 = 0;
        int n4 = 4;
        while (n4-- != 0) {
            double d = 0.0;
            n = 4;
            while (n-- != 0) {
                double d2 = dArray[n2++];
                if (!((d2 = Math.abs(d2)) > d)) continue;
                d = d2;
            }
            if (d == 0.0) {
                return false;
            }
            dArray2[n3++] = 1.0 / d;
        }
        n = 0;
        for (n4 = 0; n4 < 4; ++n4) {
            double d;
            int n5;
            int n6;
            int n7;
            double d3;
            int n8;
            for (n2 = 0; n2 < n4; ++n2) {
                n8 = n + 4 * n2 + n4;
                d3 = dArray[n8];
                int n9 = n2;
                int n10 = n + 4 * n2;
                n7 = n + n4;
                while (n9-- != 0) {
                    d3 -= dArray[n10] * dArray[n7];
                    ++n10;
                    n7 += 4;
                }
                dArray[n8] = d3;
            }
            double d4 = 0.0;
            n3 = -1;
            for (n2 = n4; n2 < 4; ++n2) {
                double d5;
                n8 = n + 4 * n2 + n4;
                d3 = dArray[n8];
                n6 = n4;
                n5 = n + 4 * n2;
                n7 = n + n4;
                while (n6-- != 0) {
                    d3 -= dArray[n5] * dArray[n7];
                    ++n5;
                    n7 += 4;
                }
                dArray[n8] = d3;
                d = dArray2[n2] * Math.abs(d3);
                if (!(d5 >= d4)) continue;
                d4 = d;
                n3 = n2;
            }
            if (n3 < 0) {
                throw new RuntimeException(VecMathI18N.getString("Matrix4d11"));
            }
            if (n4 != n3) {
                n6 = 4;
                n5 = n + 4 * n3;
                n7 = n + 4 * n4;
                while (n6-- != 0) {
                    d = dArray[n5];
                    dArray[n5++] = dArray[n7];
                    dArray[n7++] = d;
                }
                dArray2[n3] = dArray2[n4];
            }
            nArray[n4] = n3;
            if (dArray[n + 4 * n4 + n4] == 0.0) {
                return false;
            }
            if (n4 == 3) continue;
            d = 1.0 / dArray[n + 4 * n4 + n4];
            n8 = n + 4 * (n4 + 1) + n4;
            n2 = 3 - n4;
            while (n2-- != 0) {
                int n11 = n8;
                dArray[n11] = dArray[n11] * d;
                n8 += 4;
            }
        }
        return true;
    }

    static void luBacksubstitution(double[] dArray, int[] nArray, double[] dArray2) {
        int n = 0;
        for (int i = 0; i < 4; ++i) {
            int n2;
            int n3 = i;
            int n4 = -1;
            for (int j = 0; j < 4; ++j) {
                int n5 = nArray[n + j];
                double d = dArray2[n3 + 4 * n5];
                dArray2[n3 + 4 * n5] = dArray2[n3 + 4 * j];
                if (n4 >= 0) {
                    n2 = j * 4;
                    for (int k = n4; k <= j - 1; ++k) {
                        d -= dArray[n2 + k] * dArray2[n3 + 4 * k];
                    }
                } else if (d != 0.0) {
                    n4 = j;
                }
                dArray2[n3 + 4 * j] = d;
            }
            n2 = 12;
            int n6 = n3 + 12;
            dArray2[n6] = dArray2[n6] / dArray[n2 + 3];
            dArray2[n3 + 8] = (dArray2[n3 + 8] - dArray[(n2 -= 4) + 3] * dArray2[n3 + 12]) / dArray[n2 + 2];
            dArray2[n3 + 4] = (dArray2[n3 + 4] - dArray[(n2 -= 4) + 2] * dArray2[n3 + 8] - dArray[n2 + 3] * dArray2[n3 + 12]) / dArray[n2 + 1];
            dArray2[n3 + 0] = (dArray2[n3 + 0] - dArray[(n2 -= 4) + 1] * dArray2[n3 + 4] - dArray[n2 + 2] * dArray2[n3 + 8] - dArray[n2 + 3] * dArray2[n3 + 12]) / dArray[n2 + 0];
        }
    }

    public final double determinant() {
        double d = this.m00 * (this.m11 * this.m22 * this.m33 + this.m12 * this.m23 * this.m31 + this.m13 * this.m21 * this.m32 - this.m13 * this.m22 * this.m31 - this.m11 * this.m23 * this.m32 - this.m12 * this.m21 * this.m33);
        d -= this.m01 * (this.m10 * this.m22 * this.m33 + this.m12 * this.m23 * this.m30 + this.m13 * this.m20 * this.m32 - this.m13 * this.m22 * this.m30 - this.m10 * this.m23 * this.m32 - this.m12 * this.m20 * this.m33);
        d += this.m02 * (this.m10 * this.m21 * this.m33 + this.m11 * this.m23 * this.m30 + this.m13 * this.m20 * this.m31 - this.m13 * this.m21 * this.m30 - this.m10 * this.m23 * this.m31 - this.m11 * this.m20 * this.m33);
        return d -= this.m03 * (this.m10 * this.m21 * this.m32 + this.m11 * this.m22 * this.m30 + this.m12 * this.m20 * this.m31 - this.m12 * this.m21 * this.m30 - this.m10 * this.m22 * this.m31 - this.m11 * this.m20 * this.m32);
    }

    public final void set(double d) {
        this.m00 = d;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = d;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = d;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Vector3d vector3d) {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = vector3d.x;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = vector3d.y;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(double d, Vector3d vector3d) {
        this.m00 = d;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = vector3d.x;
        this.m10 = 0.0;
        this.m11 = d;
        this.m12 = 0.0;
        this.m13 = vector3d.y;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = d;
        this.m23 = vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Vector3d vector3d, double d) {
        this.m00 = d;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = d * vector3d.x;
        this.m10 = 0.0;
        this.m11 = d;
        this.m12 = 0.0;
        this.m13 = d * vector3d.y;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = d;
        this.m23 = d * vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Matrix3f matrix3f, Vector3f vector3f, float f) {
        this.m00 = matrix3f.m00 * f;
        this.m01 = matrix3f.m01 * f;
        this.m02 = matrix3f.m02 * f;
        this.m03 = vector3f.x;
        this.m10 = matrix3f.m10 * f;
        this.m11 = matrix3f.m11 * f;
        this.m12 = matrix3f.m12 * f;
        this.m13 = vector3f.y;
        this.m20 = matrix3f.m20 * f;
        this.m21 = matrix3f.m21 * f;
        this.m22 = matrix3f.m22 * f;
        this.m23 = vector3f.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void set(Matrix3d matrix3d, Vector3d vector3d, double d) {
        this.m00 = matrix3d.m00 * d;
        this.m01 = matrix3d.m01 * d;
        this.m02 = matrix3d.m02 * d;
        this.m03 = vector3d.x;
        this.m10 = matrix3d.m10 * d;
        this.m11 = matrix3d.m11 * d;
        this.m12 = matrix3d.m12 * d;
        this.m13 = vector3d.y;
        this.m20 = matrix3d.m20 * d;
        this.m21 = matrix3d.m21 * d;
        this.m22 = matrix3d.m22 * d;
        this.m23 = vector3d.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void setTranslation(Vector3d vector3d) {
        this.m03 = vector3d.x;
        this.m13 = vector3d.y;
        this.m23 = vector3d.z;
    }

    public final void rotX(double d) {
        double d2 = Math.sin(d);
        double d3 = Math.cos(d);
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = d3;
        this.m12 = -d2;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = d2;
        this.m22 = d3;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void rotY(double d) {
        double d2;
        double d3 = Math.sin(d);
        this.m00 = d2 = Math.cos(d);
        this.m01 = 0.0;
        this.m02 = d3;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = -d3;
        this.m21 = 0.0;
        this.m22 = d2;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void rotZ(double d) {
        double d2;
        double d3 = Math.sin(d);
        this.m00 = d2 = Math.cos(d);
        this.m01 = -d3;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = d3;
        this.m11 = d2;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }

    public final void mul(double d) {
        this.m00 *= d;
        this.m01 *= d;
        this.m02 *= d;
        this.m03 *= d;
        this.m10 *= d;
        this.m11 *= d;
        this.m12 *= d;
        this.m13 *= d;
        this.m20 *= d;
        this.m21 *= d;
        this.m22 *= d;
        this.m23 *= d;
        this.m30 *= d;
        this.m31 *= d;
        this.m32 *= d;
        this.m33 *= d;
    }

    public final void mul(double d, Matrix4d matrix4d) {
        this.m00 = matrix4d.m00 * d;
        this.m01 = matrix4d.m01 * d;
        this.m02 = matrix4d.m02 * d;
        this.m03 = matrix4d.m03 * d;
        this.m10 = matrix4d.m10 * d;
        this.m11 = matrix4d.m11 * d;
        this.m12 = matrix4d.m12 * d;
        this.m13 = matrix4d.m13 * d;
        this.m20 = matrix4d.m20 * d;
        this.m21 = matrix4d.m21 * d;
        this.m22 = matrix4d.m22 * d;
        this.m23 = matrix4d.m23 * d;
        this.m30 = matrix4d.m30 * d;
        this.m31 = matrix4d.m31 * d;
        this.m32 = matrix4d.m32 * d;
        this.m33 = matrix4d.m33 * d;
    }

    public final void mul(Matrix4d matrix4d) {
        double d = this.m00 * matrix4d.m00 + this.m01 * matrix4d.m10 + this.m02 * matrix4d.m20 + this.m03 * matrix4d.m30;
        double d2 = this.m00 * matrix4d.m01 + this.m01 * matrix4d.m11 + this.m02 * matrix4d.m21 + this.m03 * matrix4d.m31;
        double d3 = this.m00 * matrix4d.m02 + this.m01 * matrix4d.m12 + this.m02 * matrix4d.m22 + this.m03 * matrix4d.m32;
        double d4 = this.m00 * matrix4d.m03 + this.m01 * matrix4d.m13 + this.m02 * matrix4d.m23 + this.m03 * matrix4d.m33;
        double d5 = this.m10 * matrix4d.m00 + this.m11 * matrix4d.m10 + this.m12 * matrix4d.m20 + this.m13 * matrix4d.m30;
        double d6 = this.m10 * matrix4d.m01 + this.m11 * matrix4d.m11 + this.m12 * matrix4d.m21 + this.m13 * matrix4d.m31;
        double d7 = this.m10 * matrix4d.m02 + this.m11 * matrix4d.m12 + this.m12 * matrix4d.m22 + this.m13 * matrix4d.m32;
        double d8 = this.m10 * matrix4d.m03 + this.m11 * matrix4d.m13 + this.m12 * matrix4d.m23 + this.m13 * matrix4d.m33;
        double d9 = this.m20 * matrix4d.m00 + this.m21 * matrix4d.m10 + this.m22 * matrix4d.m20 + this.m23 * matrix4d.m30;
        double d10 = this.m20 * matrix4d.m01 + this.m21 * matrix4d.m11 + this.m22 * matrix4d.m21 + this.m23 * matrix4d.m31;
        double d11 = this.m20 * matrix4d.m02 + this.m21 * matrix4d.m12 + this.m22 * matrix4d.m22 + this.m23 * matrix4d.m32;
        double d12 = this.m20 * matrix4d.m03 + this.m21 * matrix4d.m13 + this.m22 * matrix4d.m23 + this.m23 * matrix4d.m33;
        double d13 = this.m30 * matrix4d.m00 + this.m31 * matrix4d.m10 + this.m32 * matrix4d.m20 + this.m33 * matrix4d.m30;
        double d14 = this.m30 * matrix4d.m01 + this.m31 * matrix4d.m11 + this.m32 * matrix4d.m21 + this.m33 * matrix4d.m31;
        double d15 = this.m30 * matrix4d.m02 + this.m31 * matrix4d.m12 + this.m32 * matrix4d.m22 + this.m33 * matrix4d.m32;
        double d16 = this.m30 * matrix4d.m03 + this.m31 * matrix4d.m13 + this.m32 * matrix4d.m23 + this.m33 * matrix4d.m33;
        this.m00 = d;
        this.m01 = d2;
        this.m02 = d3;
        this.m03 = d4;
        this.m10 = d5;
        this.m11 = d6;
        this.m12 = d7;
        this.m13 = d8;
        this.m20 = d9;
        this.m21 = d10;
        this.m22 = d11;
        this.m23 = d12;
        this.m30 = d13;
        this.m31 = d14;
        this.m32 = d15;
        this.m33 = d16;
    }

    public final void mul(Matrix4d matrix4d, Matrix4d matrix4d2) {
        if (this != matrix4d && this != matrix4d2) {
            this.m00 = matrix4d.m00 * matrix4d2.m00 + matrix4d.m01 * matrix4d2.m10 + matrix4d.m02 * matrix4d2.m20 + matrix4d.m03 * matrix4d2.m30;
            this.m01 = matrix4d.m00 * matrix4d2.m01 + matrix4d.m01 * matrix4d2.m11 + matrix4d.m02 * matrix4d2.m21 + matrix4d.m03 * matrix4d2.m31;
            this.m02 = matrix4d.m00 * matrix4d2.m02 + matrix4d.m01 * matrix4d2.m12 + matrix4d.m02 * matrix4d2.m22 + matrix4d.m03 * matrix4d2.m32;
            this.m03 = matrix4d.m00 * matrix4d2.m03 + matrix4d.m01 * matrix4d2.m13 + matrix4d.m02 * matrix4d2.m23 + matrix4d.m03 * matrix4d2.m33;
            this.m10 = matrix4d.m10 * matrix4d2.m00 + matrix4d.m11 * matrix4d2.m10 + matrix4d.m12 * matrix4d2.m20 + matrix4d.m13 * matrix4d2.m30;
            this.m11 = matrix4d.m10 * matrix4d2.m01 + matrix4d.m11 * matrix4d2.m11 + matrix4d.m12 * matrix4d2.m21 + matrix4d.m13 * matrix4d2.m31;
            this.m12 = matrix4d.m10 * matrix4d2.m02 + matrix4d.m11 * matrix4d2.m12 + matrix4d.m12 * matrix4d2.m22 + matrix4d.m13 * matrix4d2.m32;
            this.m13 = matrix4d.m10 * matrix4d2.m03 + matrix4d.m11 * matrix4d2.m13 + matrix4d.m12 * matrix4d2.m23 + matrix4d.m13 * matrix4d2.m33;
            this.m20 = matrix4d.m20 * matrix4d2.m00 + matrix4d.m21 * matrix4d2.m10 + matrix4d.m22 * matrix4d2.m20 + matrix4d.m23 * matrix4d2.m30;
            this.m21 = matrix4d.m20 * matrix4d2.m01 + matrix4d.m21 * matrix4d2.m11 + matrix4d.m22 * matrix4d2.m21 + matrix4d.m23 * matrix4d2.m31;
            this.m22 = matrix4d.m20 * matrix4d2.m02 + matrix4d.m21 * matrix4d2.m12 + matrix4d.m22 * matrix4d2.m22 + matrix4d.m23 * matrix4d2.m32;
            this.m23 = matrix4d.m20 * matrix4d2.m03 + matrix4d.m21 * matrix4d2.m13 + matrix4d.m22 * matrix4d2.m23 + matrix4d.m23 * matrix4d2.m33;
            this.m30 = matrix4d.m30 * matrix4d2.m00 + matrix4d.m31 * matrix4d2.m10 + matrix4d.m32 * matrix4d2.m20 + matrix4d.m33 * matrix4d2.m30;
            this.m31 = matrix4d.m30 * matrix4d2.m01 + matrix4d.m31 * matrix4d2.m11 + matrix4d.m32 * matrix4d2.m21 + matrix4d.m33 * matrix4d2.m31;
            this.m32 = matrix4d.m30 * matrix4d2.m02 + matrix4d.m31 * matrix4d2.m12 + matrix4d.m32 * matrix4d2.m22 + matrix4d.m33 * matrix4d2.m32;
            this.m33 = matrix4d.m30 * matrix4d2.m03 + matrix4d.m31 * matrix4d2.m13 + matrix4d.m32 * matrix4d2.m23 + matrix4d.m33 * matrix4d2.m33;
        } else {
            double d = matrix4d.m00 * matrix4d2.m00 + matrix4d.m01 * matrix4d2.m10 + matrix4d.m02 * matrix4d2.m20 + matrix4d.m03 * matrix4d2.m30;
            double d2 = matrix4d.m00 * matrix4d2.m01 + matrix4d.m01 * matrix4d2.m11 + matrix4d.m02 * matrix4d2.m21 + matrix4d.m03 * matrix4d2.m31;
            double d3 = matrix4d.m00 * matrix4d2.m02 + matrix4d.m01 * matrix4d2.m12 + matrix4d.m02 * matrix4d2.m22 + matrix4d.m03 * matrix4d2.m32;
            double d4 = matrix4d.m00 * matrix4d2.m03 + matrix4d.m01 * matrix4d2.m13 + matrix4d.m02 * matrix4d2.m23 + matrix4d.m03 * matrix4d2.m33;
            double d5 = matrix4d.m10 * matrix4d2.m00 + matrix4d.m11 * matrix4d2.m10 + matrix4d.m12 * matrix4d2.m20 + matrix4d.m13 * matrix4d2.m30;
            double d6 = matrix4d.m10 * matrix4d2.m01 + matrix4d.m11 * matrix4d2.m11 + matrix4d.m12 * matrix4d2.m21 + matrix4d.m13 * matrix4d2.m31;
            double d7 = matrix4d.m10 * matrix4d2.m02 + matrix4d.m11 * matrix4d2.m12 + matrix4d.m12 * matrix4d2.m22 + matrix4d.m13 * matrix4d2.m32;
            double d8 = matrix4d.m10 * matrix4d2.m03 + matrix4d.m11 * matrix4d2.m13 + matrix4d.m12 * matrix4d2.m23 + matrix4d.m13 * matrix4d2.m33;
            double d9 = matrix4d.m20 * matrix4d2.m00 + matrix4d.m21 * matrix4d2.m10 + matrix4d.m22 * matrix4d2.m20 + matrix4d.m23 * matrix4d2.m30;
            double d10 = matrix4d.m20 * matrix4d2.m01 + matrix4d.m21 * matrix4d2.m11 + matrix4d.m22 * matrix4d2.m21 + matrix4d.m23 * matrix4d2.m31;
            double d11 = matrix4d.m20 * matrix4d2.m02 + matrix4d.m21 * matrix4d2.m12 + matrix4d.m22 * matrix4d2.m22 + matrix4d.m23 * matrix4d2.m32;
            double d12 = matrix4d.m20 * matrix4d2.m03 + matrix4d.m21 * matrix4d2.m13 + matrix4d.m22 * matrix4d2.m23 + matrix4d.m23 * matrix4d2.m33;
            double d13 = matrix4d.m30 * matrix4d2.m00 + matrix4d.m31 * matrix4d2.m10 + matrix4d.m32 * matrix4d2.m20 + matrix4d.m33 * matrix4d2.m30;
            double d14 = matrix4d.m30 * matrix4d2.m01 + matrix4d.m31 * matrix4d2.m11 + matrix4d.m32 * matrix4d2.m21 + matrix4d.m33 * matrix4d2.m31;
            double d15 = matrix4d.m30 * matrix4d2.m02 + matrix4d.m31 * matrix4d2.m12 + matrix4d.m32 * matrix4d2.m22 + matrix4d.m33 * matrix4d2.m32;
            double d16 = matrix4d.m30 * matrix4d2.m03 + matrix4d.m31 * matrix4d2.m13 + matrix4d.m32 * matrix4d2.m23 + matrix4d.m33 * matrix4d2.m33;
            this.m00 = d;
            this.m01 = d2;
            this.m02 = d3;
            this.m03 = d4;
            this.m10 = d5;
            this.m11 = d6;
            this.m12 = d7;
            this.m13 = d8;
            this.m20 = d9;
            this.m21 = d10;
            this.m22 = d11;
            this.m23 = d12;
            this.m30 = d13;
            this.m31 = d14;
            this.m32 = d15;
            this.m33 = d16;
        }
    }

    public final void mulTransposeBoth(Matrix4d matrix4d, Matrix4d matrix4d2) {
        if (this != matrix4d && this != matrix4d2) {
            this.m00 = matrix4d.m00 * matrix4d2.m00 + matrix4d.m10 * matrix4d2.m01 + matrix4d.m20 * matrix4d2.m02 + matrix4d.m30 * matrix4d2.m03;
            this.m01 = matrix4d.m00 * matrix4d2.m10 + matrix4d.m10 * matrix4d2.m11 + matrix4d.m20 * matrix4d2.m12 + matrix4d.m30 * matrix4d2.m13;
            this.m02 = matrix4d.m00 * matrix4d2.m20 + matrix4d.m10 * matrix4d2.m21 + matrix4d.m20 * matrix4d2.m22 + matrix4d.m30 * matrix4d2.m23;
            this.m03 = matrix4d.m00 * matrix4d2.m30 + matrix4d.m10 * matrix4d2.m31 + matrix4d.m20 * matrix4d2.m32 + matrix4d.m30 * matrix4d2.m33;
            this.m10 = matrix4d.m01 * matrix4d2.m00 + matrix4d.m11 * matrix4d2.m01 + matrix4d.m21 * matrix4d2.m02 + matrix4d.m31 * matrix4d2.m03;
            this.m11 = matrix4d.m01 * matrix4d2.m10 + matrix4d.m11 * matrix4d2.m11 + matrix4d.m21 * matrix4d2.m12 + matrix4d.m31 * matrix4d2.m13;
            this.m12 = matrix4d.m01 * matrix4d2.m20 + matrix4d.m11 * matrix4d2.m21 + matrix4d.m21 * matrix4d2.m22 + matrix4d.m31 * matrix4d2.m23;
            this.m13 = matrix4d.m01 * matrix4d2.m30 + matrix4d.m11 * matrix4d2.m31 + matrix4d.m21 * matrix4d2.m32 + matrix4d.m31 * matrix4d2.m33;
            this.m20 = matrix4d.m02 * matrix4d2.m00 + matrix4d.m12 * matrix4d2.m01 + matrix4d.m22 * matrix4d2.m02 + matrix4d.m32 * matrix4d2.m03;
            this.m21 = matrix4d.m02 * matrix4d2.m10 + matrix4d.m12 * matrix4d2.m11 + matrix4d.m22 * matrix4d2.m12 + matrix4d.m32 * matrix4d2.m13;
            this.m22 = matrix4d.m02 * matrix4d2.m20 + matrix4d.m12 * matrix4d2.m21 + matrix4d.m22 * matrix4d2.m22 + matrix4d.m32 * matrix4d2.m23;
            this.m23 = matrix4d.m02 * matrix4d2.m30 + matrix4d.m12 * matrix4d2.m31 + matrix4d.m22 * matrix4d2.m32 + matrix4d.m32 * matrix4d2.m33;
            this.m30 = matrix4d.m03 * matrix4d2.m00 + matrix4d.m13 * matrix4d2.m01 + matrix4d.m23 * matrix4d2.m02 + matrix4d.m33 * matrix4d2.m03;
            this.m31 = matrix4d.m03 * matrix4d2.m10 + matrix4d.m13 * matrix4d2.m11 + matrix4d.m23 * matrix4d2.m12 + matrix4d.m33 * matrix4d2.m13;
            this.m32 = matrix4d.m03 * matrix4d2.m20 + matrix4d.m13 * matrix4d2.m21 + matrix4d.m23 * matrix4d2.m22 + matrix4d.m33 * matrix4d2.m23;
            this.m33 = matrix4d.m03 * matrix4d2.m30 + matrix4d.m13 * matrix4d2.m31 + matrix4d.m23 * matrix4d2.m32 + matrix4d.m33 * matrix4d2.m33;
        } else {
            double d = matrix4d.m00 * matrix4d2.m00 + matrix4d.m10 * matrix4d2.m01 + matrix4d.m20 * matrix4d2.m02 + matrix4d.m30 * matrix4d2.m03;
            double d2 = matrix4d.m00 * matrix4d2.m10 + matrix4d.m10 * matrix4d2.m11 + matrix4d.m20 * matrix4d2.m12 + matrix4d.m30 * matrix4d2.m13;
            double d3 = matrix4d.m00 * matrix4d2.m20 + matrix4d.m10 * matrix4d2.m21 + matrix4d.m20 * matrix4d2.m22 + matrix4d.m30 * matrix4d2.m23;
            double d4 = matrix4d.m00 * matrix4d2.m30 + matrix4d.m10 * matrix4d2.m31 + matrix4d.m20 * matrix4d2.m32 + matrix4d.m30 * matrix4d2.m33;
            double d5 = matrix4d.m01 * matrix4d2.m00 + matrix4d.m11 * matrix4d2.m01 + matrix4d.m21 * matrix4d2.m02 + matrix4d.m31 * matrix4d2.m03;
            double d6 = matrix4d.m01 * matrix4d2.m10 + matrix4d.m11 * matrix4d2.m11 + matrix4d.m21 * matrix4d2.m12 + matrix4d.m31 * matrix4d2.m13;
            double d7 = matrix4d.m01 * matrix4d2.m20 + matrix4d.m11 * matrix4d2.m21 + matrix4d.m21 * matrix4d2.m22 + matrix4d.m31 * matrix4d2.m23;
            double d8 = matrix4d.m01 * matrix4d2.m30 + matrix4d.m11 * matrix4d2.m31 + matrix4d.m21 * matrix4d2.m32 + matrix4d.m31 * matrix4d2.m33;
            double d9 = matrix4d.m02 * matrix4d2.m00 + matrix4d.m12 * matrix4d2.m01 + matrix4d.m22 * matrix4d2.m02 + matrix4d.m32 * matrix4d2.m03;
            double d10 = matrix4d.m02 * matrix4d2.m10 + matrix4d.m12 * matrix4d2.m11 + matrix4d.m22 * matrix4d2.m12 + matrix4d.m32 * matrix4d2.m13;
            double d11 = matrix4d.m02 * matrix4d2.m20 + matrix4d.m12 * matrix4d2.m21 + matrix4d.m22 * matrix4d2.m22 + matrix4d.m32 * matrix4d2.m23;
            double d12 = matrix4d.m02 * matrix4d2.m30 + matrix4d.m12 * matrix4d2.m31 + matrix4d.m22 * matrix4d2.m32 + matrix4d.m32 * matrix4d2.m33;
            double d13 = matrix4d.m03 * matrix4d2.m00 + matrix4d.m13 * matrix4d2.m01 + matrix4d.m23 * matrix4d2.m02 + matrix4d.m33 * matrix4d2.m03;
            double d14 = matrix4d.m03 * matrix4d2.m10 + matrix4d.m13 * matrix4d2.m11 + matrix4d.m23 * matrix4d2.m12 + matrix4d.m33 * matrix4d2.m13;
            double d15 = matrix4d.m03 * matrix4d2.m20 + matrix4d.m13 * matrix4d2.m21 + matrix4d.m23 * matrix4d2.m22 + matrix4d.m33 * matrix4d2.m23;
            double d16 = matrix4d.m03 * matrix4d2.m30 + matrix4d.m13 * matrix4d2.m31 + matrix4d.m23 * matrix4d2.m32 + matrix4d.m33 * matrix4d2.m33;
            this.m00 = d;
            this.m01 = d2;
            this.m02 = d3;
            this.m03 = d4;
            this.m10 = d5;
            this.m11 = d6;
            this.m12 = d7;
            this.m13 = d8;
            this.m20 = d9;
            this.m21 = d10;
            this.m22 = d11;
            this.m23 = d12;
            this.m30 = d13;
            this.m31 = d14;
            this.m32 = d15;
            this.m33 = d16;
        }
    }

    public final void mulTransposeRight(Matrix4d matrix4d, Matrix4d matrix4d2) {
        if (this != matrix4d && this != matrix4d2) {
            this.m00 = matrix4d.m00 * matrix4d2.m00 + matrix4d.m01 * matrix4d2.m01 + matrix4d.m02 * matrix4d2.m02 + matrix4d.m03 * matrix4d2.m03;
            this.m01 = matrix4d.m00 * matrix4d2.m10 + matrix4d.m01 * matrix4d2.m11 + matrix4d.m02 * matrix4d2.m12 + matrix4d.m03 * matrix4d2.m13;
            this.m02 = matrix4d.m00 * matrix4d2.m20 + matrix4d.m01 * matrix4d2.m21 + matrix4d.m02 * matrix4d2.m22 + matrix4d.m03 * matrix4d2.m23;
            this.m03 = matrix4d.m00 * matrix4d2.m30 + matrix4d.m01 * matrix4d2.m31 + matrix4d.m02 * matrix4d2.m32 + matrix4d.m03 * matrix4d2.m33;
            this.m10 = matrix4d.m10 * matrix4d2.m00 + matrix4d.m11 * matrix4d2.m01 + matrix4d.m12 * matrix4d2.m02 + matrix4d.m13 * matrix4d2.m03;
            this.m11 = matrix4d.m10 * matrix4d2.m10 + matrix4d.m11 * matrix4d2.m11 + matrix4d.m12 * matrix4d2.m12 + matrix4d.m13 * matrix4d2.m13;
            this.m12 = matrix4d.m10 * matrix4d2.m20 + matrix4d.m11 * matrix4d2.m21 + matrix4d.m12 * matrix4d2.m22 + matrix4d.m13 * matrix4d2.m23;
            this.m13 = matrix4d.m10 * matrix4d2.m30 + matrix4d.m11 * matrix4d2.m31 + matrix4d.m12 * matrix4d2.m32 + matrix4d.m13 * matrix4d2.m33;
            this.m20 = matrix4d.m20 * matrix4d2.m00 + matrix4d.m21 * matrix4d2.m01 + matrix4d.m22 * matrix4d2.m02 + matrix4d.m23 * matrix4d2.m03;
            this.m21 = matrix4d.m20 * matrix4d2.m10 + matrix4d.m21 * matrix4d2.m11 + matrix4d.m22 * matrix4d2.m12 + matrix4d.m23 * matrix4d2.m13;
            this.m22 = matrix4d.m20 * matrix4d2.m20 + matrix4d.m21 * matrix4d2.m21 + matrix4d.m22 * matrix4d2.m22 + matrix4d.m23 * matrix4d2.m23;
            this.m23 = matrix4d.m20 * matrix4d2.m30 + matrix4d.m21 * matrix4d2.m31 + matrix4d.m22 * matrix4d2.m32 + matrix4d.m23 * matrix4d2.m33;
            this.m30 = matrix4d.m30 * matrix4d2.m00 + matrix4d.m31 * matrix4d2.m01 + matrix4d.m32 * matrix4d2.m02 + matrix4d.m33 * matrix4d2.m03;
            this.m31 = matrix4d.m30 * matrix4d2.m10 + matrix4d.m31 * matrix4d2.m11 + matrix4d.m32 * matrix4d2.m12 + matrix4d.m33 * matrix4d2.m13;
            this.m32 = matrix4d.m30 * matrix4d2.m20 + matrix4d.m31 * matrix4d2.m21 + matrix4d.m32 * matrix4d2.m22 + matrix4d.m33 * matrix4d2.m23;
            this.m33 = matrix4d.m30 * matrix4d2.m30 + matrix4d.m31 * matrix4d2.m31 + matrix4d.m32 * matrix4d2.m32 + matrix4d.m33 * matrix4d2.m33;
        } else {
            double d = matrix4d.m00 * matrix4d2.m00 + matrix4d.m01 * matrix4d2.m01 + matrix4d.m02 * matrix4d2.m02 + matrix4d.m03 * matrix4d2.m03;
            double d2 = matrix4d.m00 * matrix4d2.m10 + matrix4d.m01 * matrix4d2.m11 + matrix4d.m02 * matrix4d2.m12 + matrix4d.m03 * matrix4d2.m13;
            double d3 = matrix4d.m00 * matrix4d2.m20 + matrix4d.m01 * matrix4d2.m21 + matrix4d.m02 * matrix4d2.m22 + matrix4d.m03 * matrix4d2.m23;
            double d4 = matrix4d.m00 * matrix4d2.m30 + matrix4d.m01 * matrix4d2.m31 + matrix4d.m02 * matrix4d2.m32 + matrix4d.m03 * matrix4d2.m33;
            double d5 = matrix4d.m10 * matrix4d2.m00 + matrix4d.m11 * matrix4d2.m01 + matrix4d.m12 * matrix4d2.m02 + matrix4d.m13 * matrix4d2.m03;
            double d6 = matrix4d.m10 * matrix4d2.m10 + matrix4d.m11 * matrix4d2.m11 + matrix4d.m12 * matrix4d2.m12 + matrix4d.m13 * matrix4d2.m13;
            double d7 = matrix4d.m10 * matrix4d2.m20 + matrix4d.m11 * matrix4d2.m21 + matrix4d.m12 * matrix4d2.m22 + matrix4d.m13 * matrix4d2.m23;
            double d8 = matrix4d.m10 * matrix4d2.m30 + matrix4d.m11 * matrix4d2.m31 + matrix4d.m12 * matrix4d2.m32 + matrix4d.m13 * matrix4d2.m33;
            double d9 = matrix4d.m20 * matrix4d2.m00 + matrix4d.m21 * matrix4d2.m01 + matrix4d.m22 * matrix4d2.m02 + matrix4d.m23 * matrix4d2.m03;
            double d10 = matrix4d.m20 * matrix4d2.m10 + matrix4d.m21 * matrix4d2.m11 + matrix4d.m22 * matrix4d2.m12 + matrix4d.m23 * matrix4d2.m13;
            double d11 = matrix4d.m20 * matrix4d2.m20 + matrix4d.m21 * matrix4d2.m21 + matrix4d.m22 * matrix4d2.m22 + matrix4d.m23 * matrix4d2.m23;
            double d12 = matrix4d.m20 * matrix4d2.m30 + matrix4d.m21 * matrix4d2.m31 + matrix4d.m22 * matrix4d2.m32 + matrix4d.m23 * matrix4d2.m33;
            double d13 = matrix4d.m30 * matrix4d2.m00 + matrix4d.m31 * matrix4d2.m01 + matrix4d.m32 * matrix4d2.m02 + matrix4d.m33 * matrix4d2.m03;
            double d14 = matrix4d.m30 * matrix4d2.m10 + matrix4d.m31 * matrix4d2.m11 + matrix4d.m32 * matrix4d2.m12 + matrix4d.m33 * matrix4d2.m13;
            double d15 = matrix4d.m30 * matrix4d2.m20 + matrix4d.m31 * matrix4d2.m21 + matrix4d.m32 * matrix4d2.m22 + matrix4d.m33 * matrix4d2.m23;
            double d16 = matrix4d.m30 * matrix4d2.m30 + matrix4d.m31 * matrix4d2.m31 + matrix4d.m32 * matrix4d2.m32 + matrix4d.m33 * matrix4d2.m33;
            this.m00 = d;
            this.m01 = d2;
            this.m02 = d3;
            this.m03 = d4;
            this.m10 = d5;
            this.m11 = d6;
            this.m12 = d7;
            this.m13 = d8;
            this.m20 = d9;
            this.m21 = d10;
            this.m22 = d11;
            this.m23 = d12;
            this.m30 = d13;
            this.m31 = d14;
            this.m32 = d15;
            this.m33 = d16;
        }
    }

    public final void mulTransposeLeft(Matrix4d matrix4d, Matrix4d matrix4d2) {
        if (this != matrix4d && this != matrix4d2) {
            this.m00 = matrix4d.m00 * matrix4d2.m00 + matrix4d.m10 * matrix4d2.m10 + matrix4d.m20 * matrix4d2.m20 + matrix4d.m30 * matrix4d2.m30;
            this.m01 = matrix4d.m00 * matrix4d2.m01 + matrix4d.m10 * matrix4d2.m11 + matrix4d.m20 * matrix4d2.m21 + matrix4d.m30 * matrix4d2.m31;
            this.m02 = matrix4d.m00 * matrix4d2.m02 + matrix4d.m10 * matrix4d2.m12 + matrix4d.m20 * matrix4d2.m22 + matrix4d.m30 * matrix4d2.m32;
            this.m03 = matrix4d.m00 * matrix4d2.m03 + matrix4d.m10 * matrix4d2.m13 + matrix4d.m20 * matrix4d2.m23 + matrix4d.m30 * matrix4d2.m33;
            this.m10 = matrix4d.m01 * matrix4d2.m00 + matrix4d.m11 * matrix4d2.m10 + matrix4d.m21 * matrix4d2.m20 + matrix4d.m31 * matrix4d2.m30;
            this.m11 = matrix4d.m01 * matrix4d2.m01 + matrix4d.m11 * matrix4d2.m11 + matrix4d.m21 * matrix4d2.m21 + matrix4d.m31 * matrix4d2.m31;
            this.m12 = matrix4d.m01 * matrix4d2.m02 + matrix4d.m11 * matrix4d2.m12 + matrix4d.m21 * matrix4d2.m22 + matrix4d.m31 * matrix4d2.m32;
            this.m13 = matrix4d.m01 * matrix4d2.m03 + matrix4d.m11 * matrix4d2.m13 + matrix4d.m21 * matrix4d2.m23 + matrix4d.m31 * matrix4d2.m33;
            this.m20 = matrix4d.m02 * matrix4d2.m00 + matrix4d.m12 * matrix4d2.m10 + matrix4d.m22 * matrix4d2.m20 + matrix4d.m32 * matrix4d2.m30;
            this.m21 = matrix4d.m02 * matrix4d2.m01 + matrix4d.m12 * matrix4d2.m11 + matrix4d.m22 * matrix4d2.m21 + matrix4d.m32 * matrix4d2.m31;
            this.m22 = matrix4d.m02 * matrix4d2.m02 + matrix4d.m12 * matrix4d2.m12 + matrix4d.m22 * matrix4d2.m22 + matrix4d.m32 * matrix4d2.m32;
            this.m23 = matrix4d.m02 * matrix4d2.m03 + matrix4d.m12 * matrix4d2.m13 + matrix4d.m22 * matrix4d2.m23 + matrix4d.m32 * matrix4d2.m33;
            this.m30 = matrix4d.m03 * matrix4d2.m00 + matrix4d.m13 * matrix4d2.m10 + matrix4d.m23 * matrix4d2.m20 + matrix4d.m33 * matrix4d2.m30;
            this.m31 = matrix4d.m03 * matrix4d2.m01 + matrix4d.m13 * matrix4d2.m11 + matrix4d.m23 * matrix4d2.m21 + matrix4d.m33 * matrix4d2.m31;
            this.m32 = matrix4d.m03 * matrix4d2.m02 + matrix4d.m13 * matrix4d2.m12 + matrix4d.m23 * matrix4d2.m22 + matrix4d.m33 * matrix4d2.m32;
            this.m33 = matrix4d.m03 * matrix4d2.m03 + matrix4d.m13 * matrix4d2.m13 + matrix4d.m23 * matrix4d2.m23 + matrix4d.m33 * matrix4d2.m33;
        } else {
            double d = matrix4d.m00 * matrix4d2.m00 + matrix4d.m10 * matrix4d2.m10 + matrix4d.m20 * matrix4d2.m20 + matrix4d.m30 * matrix4d2.m30;
            double d2 = matrix4d.m00 * matrix4d2.m01 + matrix4d.m10 * matrix4d2.m11 + matrix4d.m20 * matrix4d2.m21 + matrix4d.m30 * matrix4d2.m31;
            double d3 = matrix4d.m00 * matrix4d2.m02 + matrix4d.m10 * matrix4d2.m12 + matrix4d.m20 * matrix4d2.m22 + matrix4d.m30 * matrix4d2.m32;
            double d4 = matrix4d.m00 * matrix4d2.m03 + matrix4d.m10 * matrix4d2.m13 + matrix4d.m20 * matrix4d2.m23 + matrix4d.m30 * matrix4d2.m33;
            double d5 = matrix4d.m01 * matrix4d2.m00 + matrix4d.m11 * matrix4d2.m10 + matrix4d.m21 * matrix4d2.m20 + matrix4d.m31 * matrix4d2.m30;
            double d6 = matrix4d.m01 * matrix4d2.m01 + matrix4d.m11 * matrix4d2.m11 + matrix4d.m21 * matrix4d2.m21 + matrix4d.m31 * matrix4d2.m31;
            double d7 = matrix4d.m01 * matrix4d2.m02 + matrix4d.m11 * matrix4d2.m12 + matrix4d.m21 * matrix4d2.m22 + matrix4d.m31 * matrix4d2.m32;
            double d8 = matrix4d.m01 * matrix4d2.m03 + matrix4d.m11 * matrix4d2.m13 + matrix4d.m21 * matrix4d2.m23 + matrix4d.m31 * matrix4d2.m33;
            double d9 = matrix4d.m02 * matrix4d2.m00 + matrix4d.m12 * matrix4d2.m10 + matrix4d.m22 * matrix4d2.m20 + matrix4d.m32 * matrix4d2.m30;
            double d10 = matrix4d.m02 * matrix4d2.m01 + matrix4d.m12 * matrix4d2.m11 + matrix4d.m22 * matrix4d2.m21 + matrix4d.m32 * matrix4d2.m31;
            double d11 = matrix4d.m02 * matrix4d2.m02 + matrix4d.m12 * matrix4d2.m12 + matrix4d.m22 * matrix4d2.m22 + matrix4d.m32 * matrix4d2.m32;
            double d12 = matrix4d.m02 * matrix4d2.m03 + matrix4d.m12 * matrix4d2.m13 + matrix4d.m22 * matrix4d2.m23 + matrix4d.m32 * matrix4d2.m33;
            double d13 = matrix4d.m03 * matrix4d2.m00 + matrix4d.m13 * matrix4d2.m10 + matrix4d.m23 * matrix4d2.m20 + matrix4d.m33 * matrix4d2.m30;
            double d14 = matrix4d.m03 * matrix4d2.m01 + matrix4d.m13 * matrix4d2.m11 + matrix4d.m23 * matrix4d2.m21 + matrix4d.m33 * matrix4d2.m31;
            double d15 = matrix4d.m03 * matrix4d2.m02 + matrix4d.m13 * matrix4d2.m12 + matrix4d.m23 * matrix4d2.m22 + matrix4d.m33 * matrix4d2.m32;
            double d16 = matrix4d.m03 * matrix4d2.m03 + matrix4d.m13 * matrix4d2.m13 + matrix4d.m23 * matrix4d2.m23 + matrix4d.m33 * matrix4d2.m33;
            this.m00 = d;
            this.m01 = d2;
            this.m02 = d3;
            this.m03 = d4;
            this.m10 = d5;
            this.m11 = d6;
            this.m12 = d7;
            this.m13 = d8;
            this.m20 = d9;
            this.m21 = d10;
            this.m22 = d11;
            this.m23 = d12;
            this.m30 = d13;
            this.m31 = d14;
            this.m32 = d15;
            this.m33 = d16;
        }
    }

    public boolean equals(Matrix4d matrix4d) {
        try {
            return this.m00 == matrix4d.m00 && this.m01 == matrix4d.m01 && this.m02 == matrix4d.m02 && this.m03 == matrix4d.m03 && this.m10 == matrix4d.m10 && this.m11 == matrix4d.m11 && this.m12 == matrix4d.m12 && this.m13 == matrix4d.m13 && this.m20 == matrix4d.m20 && this.m21 == matrix4d.m21 && this.m22 == matrix4d.m22 && this.m23 == matrix4d.m23 && this.m30 == matrix4d.m30 && this.m31 == matrix4d.m31 && this.m32 == matrix4d.m32 && this.m33 == matrix4d.m33;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Matrix4d matrix4d = (Matrix4d)object;
            return this.m00 == matrix4d.m00 && this.m01 == matrix4d.m01 && this.m02 == matrix4d.m02 && this.m03 == matrix4d.m03 && this.m10 == matrix4d.m10 && this.m11 == matrix4d.m11 && this.m12 == matrix4d.m12 && this.m13 == matrix4d.m13 && this.m20 == matrix4d.m20 && this.m21 == matrix4d.m21 && this.m22 == matrix4d.m22 && this.m23 == matrix4d.m23 && this.m30 == matrix4d.m30 && this.m31 == matrix4d.m31 && this.m32 == matrix4d.m32 && this.m33 == matrix4d.m33;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean epsilonEquals(Matrix4d matrix4d, float f) {
        return this.epsilonEquals(matrix4d, (double)f);
    }

    public boolean epsilonEquals(Matrix4d matrix4d, double d) {
        double d2 = this.m00 - matrix4d.m00;
        double d3 = d2 < 0.0 ? -d2 : d2;
        if (d3 > d) {
            return false;
        }
        d2 = this.m01 - matrix4d.m01;
        double d4 = d2 < 0.0 ? -d2 : d2;
        if (d4 > d) {
            return false;
        }
        d2 = this.m02 - matrix4d.m02;
        double d5 = d2 < 0.0 ? -d2 : d2;
        if (d5 > d) {
            return false;
        }
        d2 = this.m03 - matrix4d.m03;
        double d6 = d2 < 0.0 ? -d2 : d2;
        if (d6 > d) {
            return false;
        }
        d2 = this.m10 - matrix4d.m10;
        double d7 = d2 < 0.0 ? -d2 : d2;
        if (d7 > d) {
            return false;
        }
        d2 = this.m11 - matrix4d.m11;
        double d8 = d2 < 0.0 ? -d2 : d2;
        if (d8 > d) {
            return false;
        }
        d2 = this.m12 - matrix4d.m12;
        double d9 = d2 < 0.0 ? -d2 : d2;
        if (d9 > d) {
            return false;
        }
        d2 = this.m13 - matrix4d.m13;
        double d10 = d2 < 0.0 ? -d2 : d2;
        if (d10 > d) {
            return false;
        }
        d2 = this.m20 - matrix4d.m20;
        double d11 = d2 < 0.0 ? -d2 : d2;
        if (d11 > d) {
            return false;
        }
        d2 = this.m21 - matrix4d.m21;
        double d12 = d2 < 0.0 ? -d2 : d2;
        if (d12 > d) {
            return false;
        }
        d2 = this.m22 - matrix4d.m22;
        double d13 = d2 < 0.0 ? -d2 : d2;
        if (d13 > d) {
            return false;
        }
        d2 = this.m23 - matrix4d.m23;
        double d14 = d2 < 0.0 ? -d2 : d2;
        if (d14 > d) {
            return false;
        }
        d2 = this.m30 - matrix4d.m30;
        double d15 = d2 < 0.0 ? -d2 : d2;
        if (d15 > d) {
            return false;
        }
        d2 = this.m31 - matrix4d.m31;
        double d16 = d2 < 0.0 ? -d2 : d2;
        if (d16 > d) {
            return false;
        }
        d2 = this.m32 - matrix4d.m32;
        double d17 = d2 < 0.0 ? -d2 : d2;
        if (d17 > d) {
            return false;
        }
        d2 = this.m33 - matrix4d.m33;
        double d18 = d2 < 0.0 ? -d2 : d2;
        return !(d18 > d);
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m00);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m01);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m02);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m03);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m10);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m11);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m12);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m13);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m20);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m21);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m22);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m23);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m30);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m31);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m32);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m33);
        return (int)(l ^ l >> 32);
    }

    public final void transform(Tuple4d tuple4d, Tuple4d tuple4d2) {
        double d = this.m00 * tuple4d.x + this.m01 * tuple4d.y + this.m02 * tuple4d.z + this.m03 * tuple4d.w;
        double d2 = this.m10 * tuple4d.x + this.m11 * tuple4d.y + this.m12 * tuple4d.z + this.m13 * tuple4d.w;
        double d3 = this.m20 * tuple4d.x + this.m21 * tuple4d.y + this.m22 * tuple4d.z + this.m23 * tuple4d.w;
        tuple4d2.w = this.m30 * tuple4d.x + this.m31 * tuple4d.y + this.m32 * tuple4d.z + this.m33 * tuple4d.w;
        tuple4d2.x = d;
        tuple4d2.y = d2;
        tuple4d2.z = d3;
    }

    public final void transform(Tuple4d tuple4d) {
        double d = this.m00 * tuple4d.x + this.m01 * tuple4d.y + this.m02 * tuple4d.z + this.m03 * tuple4d.w;
        double d2 = this.m10 * tuple4d.x + this.m11 * tuple4d.y + this.m12 * tuple4d.z + this.m13 * tuple4d.w;
        double d3 = this.m20 * tuple4d.x + this.m21 * tuple4d.y + this.m22 * tuple4d.z + this.m23 * tuple4d.w;
        tuple4d.w = this.m30 * tuple4d.x + this.m31 * tuple4d.y + this.m32 * tuple4d.z + this.m33 * tuple4d.w;
        tuple4d.x = d;
        tuple4d.y = d2;
        tuple4d.z = d3;
    }

    public final void transform(Tuple4f tuple4f, Tuple4f tuple4f2) {
        float f = (float)(this.m00 * (double)tuple4f.x + this.m01 * (double)tuple4f.y + this.m02 * (double)tuple4f.z + this.m03 * (double)tuple4f.w);
        float f2 = (float)(this.m10 * (double)tuple4f.x + this.m11 * (double)tuple4f.y + this.m12 * (double)tuple4f.z + this.m13 * (double)tuple4f.w);
        float f3 = (float)(this.m20 * (double)tuple4f.x + this.m21 * (double)tuple4f.y + this.m22 * (double)tuple4f.z + this.m23 * (double)tuple4f.w);
        tuple4f2.w = (float)(this.m30 * (double)tuple4f.x + this.m31 * (double)tuple4f.y + this.m32 * (double)tuple4f.z + this.m33 * (double)tuple4f.w);
        tuple4f2.x = f;
        tuple4f2.y = f2;
        tuple4f2.z = f3;
    }

    public final void transform(Tuple4f tuple4f) {
        float f = (float)(this.m00 * (double)tuple4f.x + this.m01 * (double)tuple4f.y + this.m02 * (double)tuple4f.z + this.m03 * (double)tuple4f.w);
        float f2 = (float)(this.m10 * (double)tuple4f.x + this.m11 * (double)tuple4f.y + this.m12 * (double)tuple4f.z + this.m13 * (double)tuple4f.w);
        float f3 = (float)(this.m20 * (double)tuple4f.x + this.m21 * (double)tuple4f.y + this.m22 * (double)tuple4f.z + this.m23 * (double)tuple4f.w);
        tuple4f.w = (float)(this.m30 * (double)tuple4f.x + this.m31 * (double)tuple4f.y + this.m32 * (double)tuple4f.z + this.m33 * (double)tuple4f.w);
        tuple4f.x = f;
        tuple4f.y = f2;
        tuple4f.z = f3;
    }

    public final void transform(Point3d point3d, Point3d point3d2) {
        double d = this.m00 * point3d.x + this.m01 * point3d.y + this.m02 * point3d.z + this.m03;
        double d2 = this.m10 * point3d.x + this.m11 * point3d.y + this.m12 * point3d.z + this.m13;
        point3d2.z = this.m20 * point3d.x + this.m21 * point3d.y + this.m22 * point3d.z + this.m23;
        point3d2.x = d;
        point3d2.y = d2;
    }

    public final void transform(Point3d point3d) {
        double d = this.m00 * point3d.x + this.m01 * point3d.y + this.m02 * point3d.z + this.m03;
        double d2 = this.m10 * point3d.x + this.m11 * point3d.y + this.m12 * point3d.z + this.m13;
        point3d.z = this.m20 * point3d.x + this.m21 * point3d.y + this.m22 * point3d.z + this.m23;
        point3d.x = d;
        point3d.y = d2;
    }

    public final void transform(Point3f point3f, Point3f point3f2) {
        float f = (float)(this.m00 * (double)point3f.x + this.m01 * (double)point3f.y + this.m02 * (double)point3f.z + this.m03);
        float f2 = (float)(this.m10 * (double)point3f.x + this.m11 * (double)point3f.y + this.m12 * (double)point3f.z + this.m13);
        point3f2.z = (float)(this.m20 * (double)point3f.x + this.m21 * (double)point3f.y + this.m22 * (double)point3f.z + this.m23);
        point3f2.x = f;
        point3f2.y = f2;
    }

    public final void transform(Point3f point3f) {
        float f = (float)(this.m00 * (double)point3f.x + this.m01 * (double)point3f.y + this.m02 * (double)point3f.z + this.m03);
        float f2 = (float)(this.m10 * (double)point3f.x + this.m11 * (double)point3f.y + this.m12 * (double)point3f.z + this.m13);
        point3f.z = (float)(this.m20 * (double)point3f.x + this.m21 * (double)point3f.y + this.m22 * (double)point3f.z + this.m23);
        point3f.x = f;
        point3f.y = f2;
    }

    public final void transform(Vector3d vector3d, Vector3d vector3d2) {
        double d = this.m00 * vector3d.x + this.m01 * vector3d.y + this.m02 * vector3d.z;
        double d2 = this.m10 * vector3d.x + this.m11 * vector3d.y + this.m12 * vector3d.z;
        vector3d2.z = this.m20 * vector3d.x + this.m21 * vector3d.y + this.m22 * vector3d.z;
        vector3d2.x = d;
        vector3d2.y = d2;
    }

    public final void transform(Vector3d vector3d) {
        double d = this.m00 * vector3d.x + this.m01 * vector3d.y + this.m02 * vector3d.z;
        double d2 = this.m10 * vector3d.x + this.m11 * vector3d.y + this.m12 * vector3d.z;
        vector3d.z = this.m20 * vector3d.x + this.m21 * vector3d.y + this.m22 * vector3d.z;
        vector3d.x = d;
        vector3d.y = d2;
    }

    public final void transform(Vector3f vector3f, Vector3f vector3f2) {
        float f = (float)(this.m00 * (double)vector3f.x + this.m01 * (double)vector3f.y + this.m02 * (double)vector3f.z);
        float f2 = (float)(this.m10 * (double)vector3f.x + this.m11 * (double)vector3f.y + this.m12 * (double)vector3f.z);
        vector3f2.z = (float)(this.m20 * (double)vector3f.x + this.m21 * (double)vector3f.y + this.m22 * (double)vector3f.z);
        vector3f2.x = f;
        vector3f2.y = f2;
    }

    public final void transform(Vector3f vector3f) {
        float f = (float)(this.m00 * (double)vector3f.x + this.m01 * (double)vector3f.y + this.m02 * (double)vector3f.z);
        float f2 = (float)(this.m10 * (double)vector3f.x + this.m11 * (double)vector3f.y + this.m12 * (double)vector3f.z);
        vector3f.z = (float)(this.m20 * (double)vector3f.x + this.m21 * (double)vector3f.y + this.m22 * (double)vector3f.z);
        vector3f.x = f;
        vector3f.y = f2;
    }

    public final void setRotation(Matrix3d matrix3d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = matrix3d.m00 * dArray2[0];
        this.m01 = matrix3d.m01 * dArray2[1];
        this.m02 = matrix3d.m02 * dArray2[2];
        this.m10 = matrix3d.m10 * dArray2[0];
        this.m11 = matrix3d.m11 * dArray2[1];
        this.m12 = matrix3d.m12 * dArray2[2];
        this.m20 = matrix3d.m20 * dArray2[0];
        this.m21 = matrix3d.m21 * dArray2[1];
        this.m22 = matrix3d.m22 * dArray2[2];
    }

    public final void setRotation(Matrix3f matrix3f) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = (double)matrix3f.m00 * dArray2[0];
        this.m01 = (double)matrix3f.m01 * dArray2[1];
        this.m02 = (double)matrix3f.m02 * dArray2[2];
        this.m10 = (double)matrix3f.m10 * dArray2[0];
        this.m11 = (double)matrix3f.m11 * dArray2[1];
        this.m12 = (double)matrix3f.m12 * dArray2[2];
        this.m20 = (double)matrix3f.m20 * dArray2[0];
        this.m21 = (double)matrix3f.m21 * dArray2[1];
        this.m22 = (double)matrix3f.m22 * dArray2[2];
    }

    public final void setRotation(Quat4f quat4f) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = (1.0 - (double)(2.0f * quat4f.y * quat4f.y) - (double)(2.0f * quat4f.z * quat4f.z)) * dArray2[0];
        this.m10 = 2.0 * (double)(quat4f.x * quat4f.y + quat4f.w * quat4f.z) * dArray2[0];
        this.m20 = 2.0 * (double)(quat4f.x * quat4f.z - quat4f.w * quat4f.y) * dArray2[0];
        this.m01 = 2.0 * (double)(quat4f.x * quat4f.y - quat4f.w * quat4f.z) * dArray2[1];
        this.m11 = (1.0 - (double)(2.0f * quat4f.x * quat4f.x) - (double)(2.0f * quat4f.z * quat4f.z)) * dArray2[1];
        this.m21 = 2.0 * (double)(quat4f.y * quat4f.z + quat4f.w * quat4f.x) * dArray2[1];
        this.m02 = 2.0 * (double)(quat4f.x * quat4f.z + quat4f.w * quat4f.y) * dArray2[2];
        this.m12 = 2.0 * (double)(quat4f.y * quat4f.z - quat4f.w * quat4f.x) * dArray2[2];
        this.m22 = (1.0 - (double)(2.0f * quat4f.x * quat4f.x) - (double)(2.0f * quat4f.y * quat4f.y)) * dArray2[2];
    }

    public final void setRotation(Quat4d quat4d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = (1.0 - 2.0 * quat4d.y * quat4d.y - 2.0 * quat4d.z * quat4d.z) * dArray2[0];
        this.m10 = 2.0 * (quat4d.x * quat4d.y + quat4d.w * quat4d.z) * dArray2[0];
        this.m20 = 2.0 * (quat4d.x * quat4d.z - quat4d.w * quat4d.y) * dArray2[0];
        this.m01 = 2.0 * (quat4d.x * quat4d.y - quat4d.w * quat4d.z) * dArray2[1];
        this.m11 = (1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.z * quat4d.z) * dArray2[1];
        this.m21 = 2.0 * (quat4d.y * quat4d.z + quat4d.w * quat4d.x) * dArray2[1];
        this.m02 = 2.0 * (quat4d.x * quat4d.z + quat4d.w * quat4d.y) * dArray2[2];
        this.m12 = 2.0 * (quat4d.y * quat4d.z - quat4d.w * quat4d.x) * dArray2[2];
        this.m22 = (1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.y * quat4d.y) * dArray2[2];
    }

    public final void setRotation(AxisAngle4d axisAngle4d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        double d = 1.0 / Math.sqrt(axisAngle4d.x * axisAngle4d.x + axisAngle4d.y * axisAngle4d.y + axisAngle4d.z * axisAngle4d.z);
        double d2 = axisAngle4d.x * d;
        double d3 = axisAngle4d.y * d;
        double d4 = axisAngle4d.z * d;
        double d5 = Math.sin(axisAngle4d.angle);
        double d6 = Math.cos(axisAngle4d.angle);
        double d7 = 1.0 - d6;
        double d8 = axisAngle4d.x * axisAngle4d.z;
        double d9 = axisAngle4d.x * axisAngle4d.y;
        double d10 = axisAngle4d.y * axisAngle4d.z;
        this.m00 = (d7 * d2 * d2 + d6) * dArray2[0];
        this.m01 = (d7 * d9 - d5 * d4) * dArray2[1];
        this.m02 = (d7 * d8 + d5 * d3) * dArray2[2];
        this.m10 = (d7 * d9 + d5 * d4) * dArray2[0];
        this.m11 = (d7 * d3 * d3 + d6) * dArray2[1];
        this.m12 = (d7 * d10 - d5 * d2) * dArray2[2];
        this.m20 = (d7 * d8 - d5 * d3) * dArray2[0];
        this.m21 = (d7 * d10 + d5 * d2) * dArray2[1];
        this.m22 = (d7 * d4 * d4 + d6) * dArray2[2];
    }

    public final void setZero() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 0.0;
    }

    public final void negate() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;
        this.m03 = -this.m03;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;
        this.m13 = -this.m13;
        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
        this.m23 = -this.m23;
        this.m30 = -this.m30;
        this.m31 = -this.m31;
        this.m32 = -this.m32;
        this.m33 = -this.m33;
    }

    public final void negate(Matrix4d matrix4d) {
        this.m00 = -matrix4d.m00;
        this.m01 = -matrix4d.m01;
        this.m02 = -matrix4d.m02;
        this.m03 = -matrix4d.m03;
        this.m10 = -matrix4d.m10;
        this.m11 = -matrix4d.m11;
        this.m12 = -matrix4d.m12;
        this.m13 = -matrix4d.m13;
        this.m20 = -matrix4d.m20;
        this.m21 = -matrix4d.m21;
        this.m22 = -matrix4d.m22;
        this.m23 = -matrix4d.m23;
        this.m30 = -matrix4d.m30;
        this.m31 = -matrix4d.m31;
        this.m32 = -matrix4d.m32;
        this.m33 = -matrix4d.m33;
    }

    private final void getScaleRotate(double[] dArray, double[] dArray2) {
        double[] dArray3 = new double[]{this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22};
        Matrix3d.compute_svd(dArray3, dArray, dArray2);
    }

    public Object clone() {
        Matrix4d matrix4d = null;
        try {
            matrix4d = (Matrix4d)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        return matrix4d;
    }
}


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
import javax.vecmath.Point3f;
import javax.vecmath.Quat4d;
import javax.vecmath.Quat4f;
import javax.vecmath.SingularMatrixException;
import javax.vecmath.Tuple4f;
import javax.vecmath.VecMathI18N;
import javax.vecmath.VecMathUtil;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class Matrix4f
implements Serializable,
Cloneable {
    static final long serialVersionUID = -8405036035410109353L;
    public float m00;
    public float m01;
    public float m02;
    public float m03;
    public float m10;
    public float m11;
    public float m12;
    public float m13;
    public float m20;
    public float m21;
    public float m22;
    public float m23;
    public float m30;
    public float m31;
    public float m32;
    public float m33;
    private static final double EPS = 1.0E-8;

    public Matrix4f(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.m00 = f;
        this.m01 = f2;
        this.m02 = f3;
        this.m03 = f4;
        this.m10 = f5;
        this.m11 = f6;
        this.m12 = f7;
        this.m13 = f8;
        this.m20 = f9;
        this.m21 = f10;
        this.m22 = f11;
        this.m23 = f12;
        this.m30 = f13;
        this.m31 = f14;
        this.m32 = f15;
        this.m33 = f16;
    }

    public Matrix4f(float[] fArray) {
        this.m00 = fArray[0];
        this.m01 = fArray[1];
        this.m02 = fArray[2];
        this.m03 = fArray[3];
        this.m10 = fArray[4];
        this.m11 = fArray[5];
        this.m12 = fArray[6];
        this.m13 = fArray[7];
        this.m20 = fArray[8];
        this.m21 = fArray[9];
        this.m22 = fArray[10];
        this.m23 = fArray[11];
        this.m30 = fArray[12];
        this.m31 = fArray[13];
        this.m32 = fArray[14];
        this.m33 = fArray[15];
    }

    public Matrix4f(Quat4f quat4f, Vector3f vector3f, float f) {
        this.m00 = (float)((double)f * (1.0 - 2.0 * (double)quat4f.y * (double)quat4f.y - 2.0 * (double)quat4f.z * (double)quat4f.z));
        this.m10 = (float)((double)f * (2.0 * (double)(quat4f.x * quat4f.y + quat4f.w * quat4f.z)));
        this.m20 = (float)((double)f * (2.0 * (double)(quat4f.x * quat4f.z - quat4f.w * quat4f.y)));
        this.m01 = (float)((double)f * (2.0 * (double)(quat4f.x * quat4f.y - quat4f.w * quat4f.z)));
        this.m11 = (float)((double)f * (1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.z * (double)quat4f.z));
        this.m21 = (float)((double)f * (2.0 * (double)(quat4f.y * quat4f.z + quat4f.w * quat4f.x)));
        this.m02 = (float)((double)f * (2.0 * (double)(quat4f.x * quat4f.z + quat4f.w * quat4f.y)));
        this.m12 = (float)((double)f * (2.0 * (double)(quat4f.y * quat4f.z - quat4f.w * quat4f.x)));
        this.m22 = (float)((double)f * (1.0 - 2.0 * (double)quat4f.x * (double)quat4f.x - 2.0 * (double)quat4f.y * (double)quat4f.y));
        this.m03 = vector3f.x;
        this.m13 = vector3f.y;
        this.m23 = vector3f.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public Matrix4f(Matrix4d matrix4d) {
        this.m00 = (float)matrix4d.m00;
        this.m01 = (float)matrix4d.m01;
        this.m02 = (float)matrix4d.m02;
        this.m03 = (float)matrix4d.m03;
        this.m10 = (float)matrix4d.m10;
        this.m11 = (float)matrix4d.m11;
        this.m12 = (float)matrix4d.m12;
        this.m13 = (float)matrix4d.m13;
        this.m20 = (float)matrix4d.m20;
        this.m21 = (float)matrix4d.m21;
        this.m22 = (float)matrix4d.m22;
        this.m23 = (float)matrix4d.m23;
        this.m30 = (float)matrix4d.m30;
        this.m31 = (float)matrix4d.m31;
        this.m32 = (float)matrix4d.m32;
        this.m33 = (float)matrix4d.m33;
    }

    public Matrix4f(Matrix4f matrix4f) {
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

    public Matrix4f(Matrix3f matrix3f, Vector3f vector3f, float f) {
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
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public Matrix4f() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
    }

    public String toString() {
        return this.m00 + ", " + this.m01 + ", " + this.m02 + ", " + this.m03 + "\n" + this.m10 + ", " + this.m11 + ", " + this.m12 + ", " + this.m13 + "\n" + this.m20 + ", " + this.m21 + ", " + this.m22 + ", " + this.m23 + "\n" + this.m30 + ", " + this.m31 + ", " + this.m32 + ", " + this.m33 + "\n";
    }

    public final void setIdentity() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void setElement(int n, int n2, float f) {
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        this.m00 = f;
                        break block0;
                    }
                    case 1: {
                        this.m01 = f;
                        break block0;
                    }
                    case 2: {
                        this.m02 = f;
                        break block0;
                    }
                    case 3: {
                        this.m03 = f;
                        break block0;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        this.m10 = f;
                        break block0;
                    }
                    case 1: {
                        this.m11 = f;
                        break block0;
                    }
                    case 2: {
                        this.m12 = f;
                        break block0;
                    }
                    case 3: {
                        this.m13 = f;
                        break block0;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        this.m20 = f;
                        break block0;
                    }
                    case 1: {
                        this.m21 = f;
                        break block0;
                    }
                    case 2: {
                        this.m22 = f;
                        break block0;
                    }
                    case 3: {
                        this.m23 = f;
                        break block0;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
            }
            case 3: {
                switch (n2) {
                    case 0: {
                        this.m30 = f;
                        break block0;
                    }
                    case 1: {
                        this.m31 = f;
                        break block0;
                    }
                    case 2: {
                        this.m32 = f;
                        break block0;
                    }
                    case 3: {
                        this.m33 = f;
                        break block0;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
            }
        }
    }

    public final float getElement(int n, int n2) {
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
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f1"));
    }

    public final void getRow(int n, Vector4f vector4f) {
        if (n == 0) {
            vector4f.x = this.m00;
            vector4f.y = this.m01;
            vector4f.z = this.m02;
            vector4f.w = this.m03;
        } else if (n == 1) {
            vector4f.x = this.m10;
            vector4f.y = this.m11;
            vector4f.z = this.m12;
            vector4f.w = this.m13;
        } else if (n == 2) {
            vector4f.x = this.m20;
            vector4f.y = this.m21;
            vector4f.z = this.m22;
            vector4f.w = this.m23;
        } else if (n == 3) {
            vector4f.x = this.m30;
            vector4f.y = this.m31;
            vector4f.z = this.m32;
            vector4f.w = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f2"));
        }
    }

    public final void getRow(int n, float[] fArray) {
        if (n == 0) {
            fArray[0] = this.m00;
            fArray[1] = this.m01;
            fArray[2] = this.m02;
            fArray[3] = this.m03;
        } else if (n == 1) {
            fArray[0] = this.m10;
            fArray[1] = this.m11;
            fArray[2] = this.m12;
            fArray[3] = this.m13;
        } else if (n == 2) {
            fArray[0] = this.m20;
            fArray[1] = this.m21;
            fArray[2] = this.m22;
            fArray[3] = this.m23;
        } else if (n == 3) {
            fArray[0] = this.m30;
            fArray[1] = this.m31;
            fArray[2] = this.m32;
            fArray[3] = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f2"));
        }
    }

    public final void getColumn(int n, Vector4f vector4f) {
        if (n == 0) {
            vector4f.x = this.m00;
            vector4f.y = this.m10;
            vector4f.z = this.m20;
            vector4f.w = this.m30;
        } else if (n == 1) {
            vector4f.x = this.m01;
            vector4f.y = this.m11;
            vector4f.z = this.m21;
            vector4f.w = this.m31;
        } else if (n == 2) {
            vector4f.x = this.m02;
            vector4f.y = this.m12;
            vector4f.z = this.m22;
            vector4f.w = this.m32;
        } else if (n == 3) {
            vector4f.x = this.m03;
            vector4f.y = this.m13;
            vector4f.z = this.m23;
            vector4f.w = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f4"));
        }
    }

    public final void getColumn(int n, float[] fArray) {
        if (n == 0) {
            fArray[0] = this.m00;
            fArray[1] = this.m10;
            fArray[2] = this.m20;
            fArray[3] = this.m30;
        } else if (n == 1) {
            fArray[0] = this.m01;
            fArray[1] = this.m11;
            fArray[2] = this.m21;
            fArray[3] = this.m31;
        } else if (n == 2) {
            fArray[0] = this.m02;
            fArray[1] = this.m12;
            fArray[2] = this.m22;
            fArray[3] = this.m32;
        } else if (n == 3) {
            fArray[0] = this.m03;
            fArray[1] = this.m13;
            fArray[2] = this.m23;
            fArray[3] = this.m33;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f4"));
        }
    }

    public final void setScale(float f) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = (float)(dArray[0] * (double)f);
        this.m01 = (float)(dArray[1] * (double)f);
        this.m02 = (float)(dArray[2] * (double)f);
        this.m10 = (float)(dArray[3] * (double)f);
        this.m11 = (float)(dArray[4] * (double)f);
        this.m12 = (float)(dArray[5] * (double)f);
        this.m20 = (float)(dArray[6] * (double)f);
        this.m21 = (float)(dArray[7] * (double)f);
        this.m22 = (float)(dArray[8] * (double)f);
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

    public final float get(Matrix3f matrix3f, Vector3f vector3f) {
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
        vector3f.x = this.m03;
        vector3f.y = this.m13;
        vector3f.z = this.m23;
        return (float)Matrix3d.max3(dArray2);
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

    public final void get(Vector3f vector3f) {
        vector3f.x = this.m03;
        vector3f.y = this.m13;
        vector3f.z = this.m23;
    }

    public final void getRotationScale(Matrix3f matrix3f) {
        matrix3f.m00 = this.m00;
        matrix3f.m01 = this.m01;
        matrix3f.m02 = this.m02;
        matrix3f.m10 = this.m10;
        matrix3f.m11 = this.m11;
        matrix3f.m12 = this.m12;
        matrix3f.m20 = this.m20;
        matrix3f.m21 = this.m21;
        matrix3f.m22 = this.m22;
    }

    public final float getScale() {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        return (float)Matrix3d.max3(dArray2);
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

    public final void setRow(int n, float f, float f2, float f3, float f4) {
        switch (n) {
            case 0: {
                this.m00 = f;
                this.m01 = f2;
                this.m02 = f3;
                this.m03 = f4;
                break;
            }
            case 1: {
                this.m10 = f;
                this.m11 = f2;
                this.m12 = f3;
                this.m13 = f4;
                break;
            }
            case 2: {
                this.m20 = f;
                this.m21 = f2;
                this.m22 = f3;
                this.m23 = f4;
                break;
            }
            case 3: {
                this.m30 = f;
                this.m31 = f2;
                this.m32 = f3;
                this.m33 = f4;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f6"));
            }
        }
    }

    public final void setRow(int n, Vector4f vector4f) {
        switch (n) {
            case 0: {
                this.m00 = vector4f.x;
                this.m01 = vector4f.y;
                this.m02 = vector4f.z;
                this.m03 = vector4f.w;
                break;
            }
            case 1: {
                this.m10 = vector4f.x;
                this.m11 = vector4f.y;
                this.m12 = vector4f.z;
                this.m13 = vector4f.w;
                break;
            }
            case 2: {
                this.m20 = vector4f.x;
                this.m21 = vector4f.y;
                this.m22 = vector4f.z;
                this.m23 = vector4f.w;
                break;
            }
            case 3: {
                this.m30 = vector4f.x;
                this.m31 = vector4f.y;
                this.m32 = vector4f.z;
                this.m33 = vector4f.w;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f6"));
            }
        }
    }

    public final void setRow(int n, float[] fArray) {
        switch (n) {
            case 0: {
                this.m00 = fArray[0];
                this.m01 = fArray[1];
                this.m02 = fArray[2];
                this.m03 = fArray[3];
                break;
            }
            case 1: {
                this.m10 = fArray[0];
                this.m11 = fArray[1];
                this.m12 = fArray[2];
                this.m13 = fArray[3];
                break;
            }
            case 2: {
                this.m20 = fArray[0];
                this.m21 = fArray[1];
                this.m22 = fArray[2];
                this.m23 = fArray[3];
                break;
            }
            case 3: {
                this.m30 = fArray[0];
                this.m31 = fArray[1];
                this.m32 = fArray[2];
                this.m33 = fArray[3];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f6"));
            }
        }
    }

    public final void setColumn(int n, float f, float f2, float f3, float f4) {
        switch (n) {
            case 0: {
                this.m00 = f;
                this.m10 = f2;
                this.m20 = f3;
                this.m30 = f4;
                break;
            }
            case 1: {
                this.m01 = f;
                this.m11 = f2;
                this.m21 = f3;
                this.m31 = f4;
                break;
            }
            case 2: {
                this.m02 = f;
                this.m12 = f2;
                this.m22 = f3;
                this.m32 = f4;
                break;
            }
            case 3: {
                this.m03 = f;
                this.m13 = f2;
                this.m23 = f3;
                this.m33 = f4;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f9"));
            }
        }
    }

    public final void setColumn(int n, Vector4f vector4f) {
        switch (n) {
            case 0: {
                this.m00 = vector4f.x;
                this.m10 = vector4f.y;
                this.m20 = vector4f.z;
                this.m30 = vector4f.w;
                break;
            }
            case 1: {
                this.m01 = vector4f.x;
                this.m11 = vector4f.y;
                this.m21 = vector4f.z;
                this.m31 = vector4f.w;
                break;
            }
            case 2: {
                this.m02 = vector4f.x;
                this.m12 = vector4f.y;
                this.m22 = vector4f.z;
                this.m32 = vector4f.w;
                break;
            }
            case 3: {
                this.m03 = vector4f.x;
                this.m13 = vector4f.y;
                this.m23 = vector4f.z;
                this.m33 = vector4f.w;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f9"));
            }
        }
    }

    public final void setColumn(int n, float[] fArray) {
        switch (n) {
            case 0: {
                this.m00 = fArray[0];
                this.m10 = fArray[1];
                this.m20 = fArray[2];
                this.m30 = fArray[3];
                break;
            }
            case 1: {
                this.m01 = fArray[0];
                this.m11 = fArray[1];
                this.m21 = fArray[2];
                this.m31 = fArray[3];
                break;
            }
            case 2: {
                this.m02 = fArray[0];
                this.m12 = fArray[1];
                this.m22 = fArray[2];
                this.m32 = fArray[3];
                break;
            }
            case 3: {
                this.m03 = fArray[0];
                this.m13 = fArray[1];
                this.m23 = fArray[2];
                this.m33 = fArray[3];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f9"));
            }
        }
    }

    public final void add(float f) {
        this.m00 += f;
        this.m01 += f;
        this.m02 += f;
        this.m03 += f;
        this.m10 += f;
        this.m11 += f;
        this.m12 += f;
        this.m13 += f;
        this.m20 += f;
        this.m21 += f;
        this.m22 += f;
        this.m23 += f;
        this.m30 += f;
        this.m31 += f;
        this.m32 += f;
        this.m33 += f;
    }

    public final void add(float f, Matrix4f matrix4f) {
        this.m00 = matrix4f.m00 + f;
        this.m01 = matrix4f.m01 + f;
        this.m02 = matrix4f.m02 + f;
        this.m03 = matrix4f.m03 + f;
        this.m10 = matrix4f.m10 + f;
        this.m11 = matrix4f.m11 + f;
        this.m12 = matrix4f.m12 + f;
        this.m13 = matrix4f.m13 + f;
        this.m20 = matrix4f.m20 + f;
        this.m21 = matrix4f.m21 + f;
        this.m22 = matrix4f.m22 + f;
        this.m23 = matrix4f.m23 + f;
        this.m30 = matrix4f.m30 + f;
        this.m31 = matrix4f.m31 + f;
        this.m32 = matrix4f.m32 + f;
        this.m33 = matrix4f.m33 + f;
    }

    public final void add(Matrix4f matrix4f, Matrix4f matrix4f2) {
        this.m00 = matrix4f.m00 + matrix4f2.m00;
        this.m01 = matrix4f.m01 + matrix4f2.m01;
        this.m02 = matrix4f.m02 + matrix4f2.m02;
        this.m03 = matrix4f.m03 + matrix4f2.m03;
        this.m10 = matrix4f.m10 + matrix4f2.m10;
        this.m11 = matrix4f.m11 + matrix4f2.m11;
        this.m12 = matrix4f.m12 + matrix4f2.m12;
        this.m13 = matrix4f.m13 + matrix4f2.m13;
        this.m20 = matrix4f.m20 + matrix4f2.m20;
        this.m21 = matrix4f.m21 + matrix4f2.m21;
        this.m22 = matrix4f.m22 + matrix4f2.m22;
        this.m23 = matrix4f.m23 + matrix4f2.m23;
        this.m30 = matrix4f.m30 + matrix4f2.m30;
        this.m31 = matrix4f.m31 + matrix4f2.m31;
        this.m32 = matrix4f.m32 + matrix4f2.m32;
        this.m33 = matrix4f.m33 + matrix4f2.m33;
    }

    public final void add(Matrix4f matrix4f) {
        this.m00 += matrix4f.m00;
        this.m01 += matrix4f.m01;
        this.m02 += matrix4f.m02;
        this.m03 += matrix4f.m03;
        this.m10 += matrix4f.m10;
        this.m11 += matrix4f.m11;
        this.m12 += matrix4f.m12;
        this.m13 += matrix4f.m13;
        this.m20 += matrix4f.m20;
        this.m21 += matrix4f.m21;
        this.m22 += matrix4f.m22;
        this.m23 += matrix4f.m23;
        this.m30 += matrix4f.m30;
        this.m31 += matrix4f.m31;
        this.m32 += matrix4f.m32;
        this.m33 += matrix4f.m33;
    }

    public final void sub(Matrix4f matrix4f, Matrix4f matrix4f2) {
        this.m00 = matrix4f.m00 - matrix4f2.m00;
        this.m01 = matrix4f.m01 - matrix4f2.m01;
        this.m02 = matrix4f.m02 - matrix4f2.m02;
        this.m03 = matrix4f.m03 - matrix4f2.m03;
        this.m10 = matrix4f.m10 - matrix4f2.m10;
        this.m11 = matrix4f.m11 - matrix4f2.m11;
        this.m12 = matrix4f.m12 - matrix4f2.m12;
        this.m13 = matrix4f.m13 - matrix4f2.m13;
        this.m20 = matrix4f.m20 - matrix4f2.m20;
        this.m21 = matrix4f.m21 - matrix4f2.m21;
        this.m22 = matrix4f.m22 - matrix4f2.m22;
        this.m23 = matrix4f.m23 - matrix4f2.m23;
        this.m30 = matrix4f.m30 - matrix4f2.m30;
        this.m31 = matrix4f.m31 - matrix4f2.m31;
        this.m32 = matrix4f.m32 - matrix4f2.m32;
        this.m33 = matrix4f.m33 - matrix4f2.m33;
    }

    public final void sub(Matrix4f matrix4f) {
        this.m00 -= matrix4f.m00;
        this.m01 -= matrix4f.m01;
        this.m02 -= matrix4f.m02;
        this.m03 -= matrix4f.m03;
        this.m10 -= matrix4f.m10;
        this.m11 -= matrix4f.m11;
        this.m12 -= matrix4f.m12;
        this.m13 -= matrix4f.m13;
        this.m20 -= matrix4f.m20;
        this.m21 -= matrix4f.m21;
        this.m22 -= matrix4f.m22;
        this.m23 -= matrix4f.m23;
        this.m30 -= matrix4f.m30;
        this.m31 -= matrix4f.m31;
        this.m32 -= matrix4f.m32;
        this.m33 -= matrix4f.m33;
    }

    public final void transpose() {
        float f = this.m10;
        this.m10 = this.m01;
        this.m01 = f;
        f = this.m20;
        this.m20 = this.m02;
        this.m02 = f;
        f = this.m30;
        this.m30 = this.m03;
        this.m03 = f;
        f = this.m21;
        this.m21 = this.m12;
        this.m12 = f;
        f = this.m31;
        this.m31 = this.m13;
        this.m13 = f;
        f = this.m32;
        this.m32 = this.m23;
        this.m23 = f;
    }

    public final void transpose(Matrix4f matrix4f) {
        if (this != matrix4f) {
            this.m00 = matrix4f.m00;
            this.m01 = matrix4f.m10;
            this.m02 = matrix4f.m20;
            this.m03 = matrix4f.m30;
            this.m10 = matrix4f.m01;
            this.m11 = matrix4f.m11;
            this.m12 = matrix4f.m21;
            this.m13 = matrix4f.m31;
            this.m20 = matrix4f.m02;
            this.m21 = matrix4f.m12;
            this.m22 = matrix4f.m22;
            this.m23 = matrix4f.m32;
            this.m30 = matrix4f.m03;
            this.m31 = matrix4f.m13;
            this.m32 = matrix4f.m23;
            this.m33 = matrix4f.m33;
        } else {
            this.transpose();
        }
    }

    public final void set(Quat4f quat4f) {
        this.m00 = 1.0f - 2.0f * quat4f.y * quat4f.y - 2.0f * quat4f.z * quat4f.z;
        this.m10 = 2.0f * (quat4f.x * quat4f.y + quat4f.w * quat4f.z);
        this.m20 = 2.0f * (quat4f.x * quat4f.z - quat4f.w * quat4f.y);
        this.m01 = 2.0f * (quat4f.x * quat4f.y - quat4f.w * quat4f.z);
        this.m11 = 1.0f - 2.0f * quat4f.x * quat4f.x - 2.0f * quat4f.z * quat4f.z;
        this.m21 = 2.0f * (quat4f.y * quat4f.z + quat4f.w * quat4f.x);
        this.m02 = 2.0f * (quat4f.x * quat4f.z + quat4f.w * quat4f.y);
        this.m12 = 2.0f * (quat4f.y * quat4f.z - quat4f.w * quat4f.x);
        this.m22 = 1.0f - 2.0f * quat4f.x * quat4f.x - 2.0f * quat4f.y * quat4f.y;
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(AxisAngle4f axisAngle4f) {
        float f = (float)Math.sqrt(axisAngle4f.x * axisAngle4f.x + axisAngle4f.y * axisAngle4f.y + axisAngle4f.z * axisAngle4f.z);
        if ((double)f < 1.0E-8) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            this.m20 = 0.0f;
            this.m21 = 0.0f;
            this.m22 = 1.0f;
        } else {
            f = 1.0f / f;
            float f2 = axisAngle4f.x * f;
            float f3 = axisAngle4f.y * f;
            float f4 = axisAngle4f.z * f;
            float f5 = (float)Math.sin(axisAngle4f.angle);
            float f6 = (float)Math.cos(axisAngle4f.angle);
            float f7 = 1.0f - f6;
            float f8 = f2 * f4;
            float f9 = f2 * f3;
            float f10 = f3 * f4;
            this.m00 = f7 * f2 * f2 + f6;
            this.m01 = f7 * f9 - f5 * f4;
            this.m02 = f7 * f8 + f5 * f3;
            this.m10 = f7 * f9 + f5 * f4;
            this.m11 = f7 * f3 * f3 + f6;
            this.m12 = f7 * f10 - f5 * f2;
            this.m20 = f7 * f8 - f5 * f3;
            this.m21 = f7 * f10 + f5 * f2;
            this.m22 = f7 * f4 * f4 + f6;
        }
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Quat4d quat4d) {
        this.m00 = (float)(1.0 - 2.0 * quat4d.y * quat4d.y - 2.0 * quat4d.z * quat4d.z);
        this.m10 = (float)(2.0 * (quat4d.x * quat4d.y + quat4d.w * quat4d.z));
        this.m20 = (float)(2.0 * (quat4d.x * quat4d.z - quat4d.w * quat4d.y));
        this.m01 = (float)(2.0 * (quat4d.x * quat4d.y - quat4d.w * quat4d.z));
        this.m11 = (float)(1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.z * quat4d.z);
        this.m21 = (float)(2.0 * (quat4d.y * quat4d.z + quat4d.w * quat4d.x));
        this.m02 = (float)(2.0 * (quat4d.x * quat4d.z + quat4d.w * quat4d.y));
        this.m12 = (float)(2.0 * (quat4d.y * quat4d.z - quat4d.w * quat4d.x));
        this.m22 = (float)(1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.y * quat4d.y);
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(AxisAngle4d axisAngle4d) {
        double d = Math.sqrt(axisAngle4d.x * axisAngle4d.x + axisAngle4d.y * axisAngle4d.y + axisAngle4d.z * axisAngle4d.z);
        if (d < 1.0E-8) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            this.m20 = 0.0f;
            this.m21 = 0.0f;
            this.m22 = 1.0f;
        } else {
            d = 1.0 / d;
            double d2 = axisAngle4d.x * d;
            double d3 = axisAngle4d.y * d;
            double d4 = axisAngle4d.z * d;
            float f = (float)Math.sin(axisAngle4d.angle);
            float f2 = (float)Math.cos(axisAngle4d.angle);
            float f3 = 1.0f - f2;
            float f4 = (float)(d2 * d4);
            float f5 = (float)(d2 * d3);
            float f6 = (float)(d3 * d4);
            this.m00 = f3 * (float)(d2 * d2) + f2;
            this.m01 = f3 * f5 - f * (float)d4;
            this.m02 = f3 * f4 + f * (float)d3;
            this.m10 = f3 * f5 + f * (float)d4;
            this.m11 = f3 * (float)(d3 * d3) + f2;
            this.m12 = f3 * f6 - f * (float)d2;
            this.m20 = f3 * f4 - f * (float)d3;
            this.m21 = f3 * f6 + f * (float)d2;
            this.m22 = f3 * (float)(d4 * d4) + f2;
        }
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Quat4d quat4d, Vector3d vector3d, double d) {
        this.m00 = (float)(d * (1.0 - 2.0 * quat4d.y * quat4d.y - 2.0 * quat4d.z * quat4d.z));
        this.m10 = (float)(d * (2.0 * (quat4d.x * quat4d.y + quat4d.w * quat4d.z)));
        this.m20 = (float)(d * (2.0 * (quat4d.x * quat4d.z - quat4d.w * quat4d.y)));
        this.m01 = (float)(d * (2.0 * (quat4d.x * quat4d.y - quat4d.w * quat4d.z)));
        this.m11 = (float)(d * (1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.z * quat4d.z));
        this.m21 = (float)(d * (2.0 * (quat4d.y * quat4d.z + quat4d.w * quat4d.x)));
        this.m02 = (float)(d * (2.0 * (quat4d.x * quat4d.z + quat4d.w * quat4d.y)));
        this.m12 = (float)(d * (2.0 * (quat4d.y * quat4d.z - quat4d.w * quat4d.x)));
        this.m22 = (float)(d * (1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.y * quat4d.y));
        this.m03 = (float)vector3d.x;
        this.m13 = (float)vector3d.y;
        this.m23 = (float)vector3d.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Quat4f quat4f, Vector3f vector3f, float f) {
        this.m00 = f * (1.0f - 2.0f * quat4f.y * quat4f.y - 2.0f * quat4f.z * quat4f.z);
        this.m10 = f * (2.0f * (quat4f.x * quat4f.y + quat4f.w * quat4f.z));
        this.m20 = f * (2.0f * (quat4f.x * quat4f.z - quat4f.w * quat4f.y));
        this.m01 = f * (2.0f * (quat4f.x * quat4f.y - quat4f.w * quat4f.z));
        this.m11 = f * (1.0f - 2.0f * quat4f.x * quat4f.x - 2.0f * quat4f.z * quat4f.z);
        this.m21 = f * (2.0f * (quat4f.y * quat4f.z + quat4f.w * quat4f.x));
        this.m02 = f * (2.0f * (quat4f.x * quat4f.z + quat4f.w * quat4f.y));
        this.m12 = f * (2.0f * (quat4f.y * quat4f.z - quat4f.w * quat4f.x));
        this.m22 = f * (1.0f - 2.0f * quat4f.x * quat4f.x - 2.0f * quat4f.y * quat4f.y);
        this.m03 = vector3f.x;
        this.m13 = vector3f.y;
        this.m23 = vector3f.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Matrix4d matrix4d) {
        this.m00 = (float)matrix4d.m00;
        this.m01 = (float)matrix4d.m01;
        this.m02 = (float)matrix4d.m02;
        this.m03 = (float)matrix4d.m03;
        this.m10 = (float)matrix4d.m10;
        this.m11 = (float)matrix4d.m11;
        this.m12 = (float)matrix4d.m12;
        this.m13 = (float)matrix4d.m13;
        this.m20 = (float)matrix4d.m20;
        this.m21 = (float)matrix4d.m21;
        this.m22 = (float)matrix4d.m22;
        this.m23 = (float)matrix4d.m23;
        this.m30 = (float)matrix4d.m30;
        this.m31 = (float)matrix4d.m31;
        this.m32 = (float)matrix4d.m32;
        this.m33 = (float)matrix4d.m33;
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

    public final void invert(Matrix4f matrix4f) {
        this.invertGeneral(matrix4f);
    }

    public final void invert() {
        this.invertGeneral(this);
    }

    final void invertGeneral(Matrix4f matrix4f) {
        double[] dArray = new double[16];
        double[] dArray2 = new double[16];
        int[] nArray = new int[4];
        dArray[0] = matrix4f.m00;
        dArray[1] = matrix4f.m01;
        dArray[2] = matrix4f.m02;
        dArray[3] = matrix4f.m03;
        dArray[4] = matrix4f.m10;
        dArray[5] = matrix4f.m11;
        dArray[6] = matrix4f.m12;
        dArray[7] = matrix4f.m13;
        dArray[8] = matrix4f.m20;
        dArray[9] = matrix4f.m21;
        dArray[10] = matrix4f.m22;
        dArray[11] = matrix4f.m23;
        dArray[12] = matrix4f.m30;
        dArray[13] = matrix4f.m31;
        dArray[14] = matrix4f.m32;
        dArray[15] = matrix4f.m33;
        if (!Matrix4f.luDecomposition(dArray, nArray)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix4f12"));
        }
        for (int i = 0; i < 16; ++i) {
            dArray2[i] = 0.0;
        }
        dArray2[0] = 1.0;
        dArray2[5] = 1.0;
        dArray2[10] = 1.0;
        dArray2[15] = 1.0;
        Matrix4f.luBacksubstitution(dArray, nArray, dArray2);
        this.m00 = (float)dArray2[0];
        this.m01 = (float)dArray2[1];
        this.m02 = (float)dArray2[2];
        this.m03 = (float)dArray2[3];
        this.m10 = (float)dArray2[4];
        this.m11 = (float)dArray2[5];
        this.m12 = (float)dArray2[6];
        this.m13 = (float)dArray2[7];
        this.m20 = (float)dArray2[8];
        this.m21 = (float)dArray2[9];
        this.m22 = (float)dArray2[10];
        this.m23 = (float)dArray2[11];
        this.m30 = (float)dArray2[12];
        this.m31 = (float)dArray2[13];
        this.m32 = (float)dArray2[14];
        this.m33 = (float)dArray2[15];
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
                throw new RuntimeException(VecMathI18N.getString("Matrix4f13"));
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

    public final float determinant() {
        float f = this.m00 * (this.m11 * this.m22 * this.m33 + this.m12 * this.m23 * this.m31 + this.m13 * this.m21 * this.m32 - this.m13 * this.m22 * this.m31 - this.m11 * this.m23 * this.m32 - this.m12 * this.m21 * this.m33);
        f -= this.m01 * (this.m10 * this.m22 * this.m33 + this.m12 * this.m23 * this.m30 + this.m13 * this.m20 * this.m32 - this.m13 * this.m22 * this.m30 - this.m10 * this.m23 * this.m32 - this.m12 * this.m20 * this.m33);
        f += this.m02 * (this.m10 * this.m21 * this.m33 + this.m11 * this.m23 * this.m30 + this.m13 * this.m20 * this.m31 - this.m13 * this.m21 * this.m30 - this.m10 * this.m23 * this.m31 - this.m11 * this.m20 * this.m33);
        return f -= this.m03 * (this.m10 * this.m21 * this.m32 + this.m11 * this.m22 * this.m30 + this.m12 * this.m20 * this.m31 - this.m12 * this.m21 * this.m30 - this.m10 * this.m22 * this.m31 - this.m11 * this.m20 * this.m32);
    }

    public final void set(Matrix3f matrix3f) {
        this.m00 = matrix3f.m00;
        this.m01 = matrix3f.m01;
        this.m02 = matrix3f.m02;
        this.m03 = 0.0f;
        this.m10 = matrix3f.m10;
        this.m11 = matrix3f.m11;
        this.m12 = matrix3f.m12;
        this.m13 = 0.0f;
        this.m20 = matrix3f.m20;
        this.m21 = matrix3f.m21;
        this.m22 = matrix3f.m22;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Matrix3d matrix3d) {
        this.m00 = (float)matrix3d.m00;
        this.m01 = (float)matrix3d.m01;
        this.m02 = (float)matrix3d.m02;
        this.m03 = 0.0f;
        this.m10 = (float)matrix3d.m10;
        this.m11 = (float)matrix3d.m11;
        this.m12 = (float)matrix3d.m12;
        this.m13 = 0.0f;
        this.m20 = (float)matrix3d.m20;
        this.m21 = (float)matrix3d.m21;
        this.m22 = (float)matrix3d.m22;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(float f) {
        this.m00 = f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(float[] fArray) {
        this.m00 = fArray[0];
        this.m01 = fArray[1];
        this.m02 = fArray[2];
        this.m03 = fArray[3];
        this.m10 = fArray[4];
        this.m11 = fArray[5];
        this.m12 = fArray[6];
        this.m13 = fArray[7];
        this.m20 = fArray[8];
        this.m21 = fArray[9];
        this.m22 = fArray[10];
        this.m23 = fArray[11];
        this.m30 = fArray[12];
        this.m31 = fArray[13];
        this.m32 = fArray[14];
        this.m33 = fArray[15];
    }

    public final void set(Vector3f vector3f) {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = vector3f.x;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = vector3f.y;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = vector3f.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(float f, Vector3f vector3f) {
        this.m00 = f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = vector3f.x;
        this.m10 = 0.0f;
        this.m11 = f;
        this.m12 = 0.0f;
        this.m13 = vector3f.y;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = f;
        this.m23 = vector3f.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Vector3f vector3f, float f) {
        this.m00 = f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = f * vector3f.x;
        this.m10 = 0.0f;
        this.m11 = f;
        this.m12 = 0.0f;
        this.m13 = f * vector3f.y;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = f;
        this.m23 = f * vector3f.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
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
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void set(Matrix3d matrix3d, Vector3d vector3d, double d) {
        this.m00 = (float)(matrix3d.m00 * d);
        this.m01 = (float)(matrix3d.m01 * d);
        this.m02 = (float)(matrix3d.m02 * d);
        this.m03 = (float)vector3d.x;
        this.m10 = (float)(matrix3d.m10 * d);
        this.m11 = (float)(matrix3d.m11 * d);
        this.m12 = (float)(matrix3d.m12 * d);
        this.m13 = (float)vector3d.y;
        this.m20 = (float)(matrix3d.m20 * d);
        this.m21 = (float)(matrix3d.m21 * d);
        this.m22 = (float)(matrix3d.m22 * d);
        this.m23 = (float)vector3d.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void setTranslation(Vector3f vector3f) {
        this.m03 = vector3f.x;
        this.m13 = vector3f.y;
        this.m23 = vector3f.z;
    }

    public final void rotX(float f) {
        float f2 = (float)Math.sin(f);
        float f3 = (float)Math.cos(f);
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = f3;
        this.m12 = -f2;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = f2;
        this.m22 = f3;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void rotY(float f) {
        float f2;
        float f3 = (float)Math.sin(f);
        this.m00 = f2 = (float)Math.cos(f);
        this.m01 = 0.0f;
        this.m02 = f3;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = -f3;
        this.m21 = 0.0f;
        this.m22 = f2;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void rotZ(float f) {
        float f2;
        float f3 = (float)Math.sin(f);
        this.m00 = f2 = (float)Math.cos(f);
        this.m01 = -f3;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = f3;
        this.m11 = f2;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    public final void mul(float f) {
        this.m00 *= f;
        this.m01 *= f;
        this.m02 *= f;
        this.m03 *= f;
        this.m10 *= f;
        this.m11 *= f;
        this.m12 *= f;
        this.m13 *= f;
        this.m20 *= f;
        this.m21 *= f;
        this.m22 *= f;
        this.m23 *= f;
        this.m30 *= f;
        this.m31 *= f;
        this.m32 *= f;
        this.m33 *= f;
    }

    public final void mul(float f, Matrix4f matrix4f) {
        this.m00 = matrix4f.m00 * f;
        this.m01 = matrix4f.m01 * f;
        this.m02 = matrix4f.m02 * f;
        this.m03 = matrix4f.m03 * f;
        this.m10 = matrix4f.m10 * f;
        this.m11 = matrix4f.m11 * f;
        this.m12 = matrix4f.m12 * f;
        this.m13 = matrix4f.m13 * f;
        this.m20 = matrix4f.m20 * f;
        this.m21 = matrix4f.m21 * f;
        this.m22 = matrix4f.m22 * f;
        this.m23 = matrix4f.m23 * f;
        this.m30 = matrix4f.m30 * f;
        this.m31 = matrix4f.m31 * f;
        this.m32 = matrix4f.m32 * f;
        this.m33 = matrix4f.m33 * f;
    }

    public final void mul(Matrix4f matrix4f) {
        float f = this.m00 * matrix4f.m00 + this.m01 * matrix4f.m10 + this.m02 * matrix4f.m20 + this.m03 * matrix4f.m30;
        float f2 = this.m00 * matrix4f.m01 + this.m01 * matrix4f.m11 + this.m02 * matrix4f.m21 + this.m03 * matrix4f.m31;
        float f3 = this.m00 * matrix4f.m02 + this.m01 * matrix4f.m12 + this.m02 * matrix4f.m22 + this.m03 * matrix4f.m32;
        float f4 = this.m00 * matrix4f.m03 + this.m01 * matrix4f.m13 + this.m02 * matrix4f.m23 + this.m03 * matrix4f.m33;
        float f5 = this.m10 * matrix4f.m00 + this.m11 * matrix4f.m10 + this.m12 * matrix4f.m20 + this.m13 * matrix4f.m30;
        float f6 = this.m10 * matrix4f.m01 + this.m11 * matrix4f.m11 + this.m12 * matrix4f.m21 + this.m13 * matrix4f.m31;
        float f7 = this.m10 * matrix4f.m02 + this.m11 * matrix4f.m12 + this.m12 * matrix4f.m22 + this.m13 * matrix4f.m32;
        float f8 = this.m10 * matrix4f.m03 + this.m11 * matrix4f.m13 + this.m12 * matrix4f.m23 + this.m13 * matrix4f.m33;
        float f9 = this.m20 * matrix4f.m00 + this.m21 * matrix4f.m10 + this.m22 * matrix4f.m20 + this.m23 * matrix4f.m30;
        float f10 = this.m20 * matrix4f.m01 + this.m21 * matrix4f.m11 + this.m22 * matrix4f.m21 + this.m23 * matrix4f.m31;
        float f11 = this.m20 * matrix4f.m02 + this.m21 * matrix4f.m12 + this.m22 * matrix4f.m22 + this.m23 * matrix4f.m32;
        float f12 = this.m20 * matrix4f.m03 + this.m21 * matrix4f.m13 + this.m22 * matrix4f.m23 + this.m23 * matrix4f.m33;
        float f13 = this.m30 * matrix4f.m00 + this.m31 * matrix4f.m10 + this.m32 * matrix4f.m20 + this.m33 * matrix4f.m30;
        float f14 = this.m30 * matrix4f.m01 + this.m31 * matrix4f.m11 + this.m32 * matrix4f.m21 + this.m33 * matrix4f.m31;
        float f15 = this.m30 * matrix4f.m02 + this.m31 * matrix4f.m12 + this.m32 * matrix4f.m22 + this.m33 * matrix4f.m32;
        float f16 = this.m30 * matrix4f.m03 + this.m31 * matrix4f.m13 + this.m32 * matrix4f.m23 + this.m33 * matrix4f.m33;
        this.m00 = f;
        this.m01 = f2;
        this.m02 = f3;
        this.m03 = f4;
        this.m10 = f5;
        this.m11 = f6;
        this.m12 = f7;
        this.m13 = f8;
        this.m20 = f9;
        this.m21 = f10;
        this.m22 = f11;
        this.m23 = f12;
        this.m30 = f13;
        this.m31 = f14;
        this.m32 = f15;
        this.m33 = f16;
    }

    public final void mul(Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (this != matrix4f && this != matrix4f2) {
            this.m00 = matrix4f.m00 * matrix4f2.m00 + matrix4f.m01 * matrix4f2.m10 + matrix4f.m02 * matrix4f2.m20 + matrix4f.m03 * matrix4f2.m30;
            this.m01 = matrix4f.m00 * matrix4f2.m01 + matrix4f.m01 * matrix4f2.m11 + matrix4f.m02 * matrix4f2.m21 + matrix4f.m03 * matrix4f2.m31;
            this.m02 = matrix4f.m00 * matrix4f2.m02 + matrix4f.m01 * matrix4f2.m12 + matrix4f.m02 * matrix4f2.m22 + matrix4f.m03 * matrix4f2.m32;
            this.m03 = matrix4f.m00 * matrix4f2.m03 + matrix4f.m01 * matrix4f2.m13 + matrix4f.m02 * matrix4f2.m23 + matrix4f.m03 * matrix4f2.m33;
            this.m10 = matrix4f.m10 * matrix4f2.m00 + matrix4f.m11 * matrix4f2.m10 + matrix4f.m12 * matrix4f2.m20 + matrix4f.m13 * matrix4f2.m30;
            this.m11 = matrix4f.m10 * matrix4f2.m01 + matrix4f.m11 * matrix4f2.m11 + matrix4f.m12 * matrix4f2.m21 + matrix4f.m13 * matrix4f2.m31;
            this.m12 = matrix4f.m10 * matrix4f2.m02 + matrix4f.m11 * matrix4f2.m12 + matrix4f.m12 * matrix4f2.m22 + matrix4f.m13 * matrix4f2.m32;
            this.m13 = matrix4f.m10 * matrix4f2.m03 + matrix4f.m11 * matrix4f2.m13 + matrix4f.m12 * matrix4f2.m23 + matrix4f.m13 * matrix4f2.m33;
            this.m20 = matrix4f.m20 * matrix4f2.m00 + matrix4f.m21 * matrix4f2.m10 + matrix4f.m22 * matrix4f2.m20 + matrix4f.m23 * matrix4f2.m30;
            this.m21 = matrix4f.m20 * matrix4f2.m01 + matrix4f.m21 * matrix4f2.m11 + matrix4f.m22 * matrix4f2.m21 + matrix4f.m23 * matrix4f2.m31;
            this.m22 = matrix4f.m20 * matrix4f2.m02 + matrix4f.m21 * matrix4f2.m12 + matrix4f.m22 * matrix4f2.m22 + matrix4f.m23 * matrix4f2.m32;
            this.m23 = matrix4f.m20 * matrix4f2.m03 + matrix4f.m21 * matrix4f2.m13 + matrix4f.m22 * matrix4f2.m23 + matrix4f.m23 * matrix4f2.m33;
            this.m30 = matrix4f.m30 * matrix4f2.m00 + matrix4f.m31 * matrix4f2.m10 + matrix4f.m32 * matrix4f2.m20 + matrix4f.m33 * matrix4f2.m30;
            this.m31 = matrix4f.m30 * matrix4f2.m01 + matrix4f.m31 * matrix4f2.m11 + matrix4f.m32 * matrix4f2.m21 + matrix4f.m33 * matrix4f2.m31;
            this.m32 = matrix4f.m30 * matrix4f2.m02 + matrix4f.m31 * matrix4f2.m12 + matrix4f.m32 * matrix4f2.m22 + matrix4f.m33 * matrix4f2.m32;
            this.m33 = matrix4f.m30 * matrix4f2.m03 + matrix4f.m31 * matrix4f2.m13 + matrix4f.m32 * matrix4f2.m23 + matrix4f.m33 * matrix4f2.m33;
        } else {
            float f = matrix4f.m00 * matrix4f2.m00 + matrix4f.m01 * matrix4f2.m10 + matrix4f.m02 * matrix4f2.m20 + matrix4f.m03 * matrix4f2.m30;
            float f2 = matrix4f.m00 * matrix4f2.m01 + matrix4f.m01 * matrix4f2.m11 + matrix4f.m02 * matrix4f2.m21 + matrix4f.m03 * matrix4f2.m31;
            float f3 = matrix4f.m00 * matrix4f2.m02 + matrix4f.m01 * matrix4f2.m12 + matrix4f.m02 * matrix4f2.m22 + matrix4f.m03 * matrix4f2.m32;
            float f4 = matrix4f.m00 * matrix4f2.m03 + matrix4f.m01 * matrix4f2.m13 + matrix4f.m02 * matrix4f2.m23 + matrix4f.m03 * matrix4f2.m33;
            float f5 = matrix4f.m10 * matrix4f2.m00 + matrix4f.m11 * matrix4f2.m10 + matrix4f.m12 * matrix4f2.m20 + matrix4f.m13 * matrix4f2.m30;
            float f6 = matrix4f.m10 * matrix4f2.m01 + matrix4f.m11 * matrix4f2.m11 + matrix4f.m12 * matrix4f2.m21 + matrix4f.m13 * matrix4f2.m31;
            float f7 = matrix4f.m10 * matrix4f2.m02 + matrix4f.m11 * matrix4f2.m12 + matrix4f.m12 * matrix4f2.m22 + matrix4f.m13 * matrix4f2.m32;
            float f8 = matrix4f.m10 * matrix4f2.m03 + matrix4f.m11 * matrix4f2.m13 + matrix4f.m12 * matrix4f2.m23 + matrix4f.m13 * matrix4f2.m33;
            float f9 = matrix4f.m20 * matrix4f2.m00 + matrix4f.m21 * matrix4f2.m10 + matrix4f.m22 * matrix4f2.m20 + matrix4f.m23 * matrix4f2.m30;
            float f10 = matrix4f.m20 * matrix4f2.m01 + matrix4f.m21 * matrix4f2.m11 + matrix4f.m22 * matrix4f2.m21 + matrix4f.m23 * matrix4f2.m31;
            float f11 = matrix4f.m20 * matrix4f2.m02 + matrix4f.m21 * matrix4f2.m12 + matrix4f.m22 * matrix4f2.m22 + matrix4f.m23 * matrix4f2.m32;
            float f12 = matrix4f.m20 * matrix4f2.m03 + matrix4f.m21 * matrix4f2.m13 + matrix4f.m22 * matrix4f2.m23 + matrix4f.m23 * matrix4f2.m33;
            float f13 = matrix4f.m30 * matrix4f2.m00 + matrix4f.m31 * matrix4f2.m10 + matrix4f.m32 * matrix4f2.m20 + matrix4f.m33 * matrix4f2.m30;
            float f14 = matrix4f.m30 * matrix4f2.m01 + matrix4f.m31 * matrix4f2.m11 + matrix4f.m32 * matrix4f2.m21 + matrix4f.m33 * matrix4f2.m31;
            float f15 = matrix4f.m30 * matrix4f2.m02 + matrix4f.m31 * matrix4f2.m12 + matrix4f.m32 * matrix4f2.m22 + matrix4f.m33 * matrix4f2.m32;
            float f16 = matrix4f.m30 * matrix4f2.m03 + matrix4f.m31 * matrix4f2.m13 + matrix4f.m32 * matrix4f2.m23 + matrix4f.m33 * matrix4f2.m33;
            this.m00 = f;
            this.m01 = f2;
            this.m02 = f3;
            this.m03 = f4;
            this.m10 = f5;
            this.m11 = f6;
            this.m12 = f7;
            this.m13 = f8;
            this.m20 = f9;
            this.m21 = f10;
            this.m22 = f11;
            this.m23 = f12;
            this.m30 = f13;
            this.m31 = f14;
            this.m32 = f15;
            this.m33 = f16;
        }
    }

    public final void mulTransposeBoth(Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (this != matrix4f && this != matrix4f2) {
            this.m00 = matrix4f.m00 * matrix4f2.m00 + matrix4f.m10 * matrix4f2.m01 + matrix4f.m20 * matrix4f2.m02 + matrix4f.m30 * matrix4f2.m03;
            this.m01 = matrix4f.m00 * matrix4f2.m10 + matrix4f.m10 * matrix4f2.m11 + matrix4f.m20 * matrix4f2.m12 + matrix4f.m30 * matrix4f2.m13;
            this.m02 = matrix4f.m00 * matrix4f2.m20 + matrix4f.m10 * matrix4f2.m21 + matrix4f.m20 * matrix4f2.m22 + matrix4f.m30 * matrix4f2.m23;
            this.m03 = matrix4f.m00 * matrix4f2.m30 + matrix4f.m10 * matrix4f2.m31 + matrix4f.m20 * matrix4f2.m32 + matrix4f.m30 * matrix4f2.m33;
            this.m10 = matrix4f.m01 * matrix4f2.m00 + matrix4f.m11 * matrix4f2.m01 + matrix4f.m21 * matrix4f2.m02 + matrix4f.m31 * matrix4f2.m03;
            this.m11 = matrix4f.m01 * matrix4f2.m10 + matrix4f.m11 * matrix4f2.m11 + matrix4f.m21 * matrix4f2.m12 + matrix4f.m31 * matrix4f2.m13;
            this.m12 = matrix4f.m01 * matrix4f2.m20 + matrix4f.m11 * matrix4f2.m21 + matrix4f.m21 * matrix4f2.m22 + matrix4f.m31 * matrix4f2.m23;
            this.m13 = matrix4f.m01 * matrix4f2.m30 + matrix4f.m11 * matrix4f2.m31 + matrix4f.m21 * matrix4f2.m32 + matrix4f.m31 * matrix4f2.m33;
            this.m20 = matrix4f.m02 * matrix4f2.m00 + matrix4f.m12 * matrix4f2.m01 + matrix4f.m22 * matrix4f2.m02 + matrix4f.m32 * matrix4f2.m03;
            this.m21 = matrix4f.m02 * matrix4f2.m10 + matrix4f.m12 * matrix4f2.m11 + matrix4f.m22 * matrix4f2.m12 + matrix4f.m32 * matrix4f2.m13;
            this.m22 = matrix4f.m02 * matrix4f2.m20 + matrix4f.m12 * matrix4f2.m21 + matrix4f.m22 * matrix4f2.m22 + matrix4f.m32 * matrix4f2.m23;
            this.m23 = matrix4f.m02 * matrix4f2.m30 + matrix4f.m12 * matrix4f2.m31 + matrix4f.m22 * matrix4f2.m32 + matrix4f.m32 * matrix4f2.m33;
            this.m30 = matrix4f.m03 * matrix4f2.m00 + matrix4f.m13 * matrix4f2.m01 + matrix4f.m23 * matrix4f2.m02 + matrix4f.m33 * matrix4f2.m03;
            this.m31 = matrix4f.m03 * matrix4f2.m10 + matrix4f.m13 * matrix4f2.m11 + matrix4f.m23 * matrix4f2.m12 + matrix4f.m33 * matrix4f2.m13;
            this.m32 = matrix4f.m03 * matrix4f2.m20 + matrix4f.m13 * matrix4f2.m21 + matrix4f.m23 * matrix4f2.m22 + matrix4f.m33 * matrix4f2.m23;
            this.m33 = matrix4f.m03 * matrix4f2.m30 + matrix4f.m13 * matrix4f2.m31 + matrix4f.m23 * matrix4f2.m32 + matrix4f.m33 * matrix4f2.m33;
        } else {
            float f = matrix4f.m00 * matrix4f2.m00 + matrix4f.m10 * matrix4f2.m01 + matrix4f.m20 * matrix4f2.m02 + matrix4f.m30 * matrix4f2.m03;
            float f2 = matrix4f.m00 * matrix4f2.m10 + matrix4f.m10 * matrix4f2.m11 + matrix4f.m20 * matrix4f2.m12 + matrix4f.m30 * matrix4f2.m13;
            float f3 = matrix4f.m00 * matrix4f2.m20 + matrix4f.m10 * matrix4f2.m21 + matrix4f.m20 * matrix4f2.m22 + matrix4f.m30 * matrix4f2.m23;
            float f4 = matrix4f.m00 * matrix4f2.m30 + matrix4f.m10 * matrix4f2.m31 + matrix4f.m20 * matrix4f2.m32 + matrix4f.m30 * matrix4f2.m33;
            float f5 = matrix4f.m01 * matrix4f2.m00 + matrix4f.m11 * matrix4f2.m01 + matrix4f.m21 * matrix4f2.m02 + matrix4f.m31 * matrix4f2.m03;
            float f6 = matrix4f.m01 * matrix4f2.m10 + matrix4f.m11 * matrix4f2.m11 + matrix4f.m21 * matrix4f2.m12 + matrix4f.m31 * matrix4f2.m13;
            float f7 = matrix4f.m01 * matrix4f2.m20 + matrix4f.m11 * matrix4f2.m21 + matrix4f.m21 * matrix4f2.m22 + matrix4f.m31 * matrix4f2.m23;
            float f8 = matrix4f.m01 * matrix4f2.m30 + matrix4f.m11 * matrix4f2.m31 + matrix4f.m21 * matrix4f2.m32 + matrix4f.m31 * matrix4f2.m33;
            float f9 = matrix4f.m02 * matrix4f2.m00 + matrix4f.m12 * matrix4f2.m01 + matrix4f.m22 * matrix4f2.m02 + matrix4f.m32 * matrix4f2.m03;
            float f10 = matrix4f.m02 * matrix4f2.m10 + matrix4f.m12 * matrix4f2.m11 + matrix4f.m22 * matrix4f2.m12 + matrix4f.m32 * matrix4f2.m13;
            float f11 = matrix4f.m02 * matrix4f2.m20 + matrix4f.m12 * matrix4f2.m21 + matrix4f.m22 * matrix4f2.m22 + matrix4f.m32 * matrix4f2.m23;
            float f12 = matrix4f.m02 * matrix4f2.m30 + matrix4f.m12 * matrix4f2.m31 + matrix4f.m22 * matrix4f2.m32 + matrix4f.m32 * matrix4f2.m33;
            float f13 = matrix4f.m03 * matrix4f2.m00 + matrix4f.m13 * matrix4f2.m01 + matrix4f.m23 * matrix4f2.m02 + matrix4f.m33 * matrix4f2.m03;
            float f14 = matrix4f.m03 * matrix4f2.m10 + matrix4f.m13 * matrix4f2.m11 + matrix4f.m23 * matrix4f2.m12 + matrix4f.m33 * matrix4f2.m13;
            float f15 = matrix4f.m03 * matrix4f2.m20 + matrix4f.m13 * matrix4f2.m21 + matrix4f.m23 * matrix4f2.m22 + matrix4f.m33 * matrix4f2.m23;
            float f16 = matrix4f.m03 * matrix4f2.m30 + matrix4f.m13 * matrix4f2.m31 + matrix4f.m23 * matrix4f2.m32 + matrix4f.m33 * matrix4f2.m33;
            this.m00 = f;
            this.m01 = f2;
            this.m02 = f3;
            this.m03 = f4;
            this.m10 = f5;
            this.m11 = f6;
            this.m12 = f7;
            this.m13 = f8;
            this.m20 = f9;
            this.m21 = f10;
            this.m22 = f11;
            this.m23 = f12;
            this.m30 = f13;
            this.m31 = f14;
            this.m32 = f15;
            this.m33 = f16;
        }
    }

    public final void mulTransposeRight(Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (this != matrix4f && this != matrix4f2) {
            this.m00 = matrix4f.m00 * matrix4f2.m00 + matrix4f.m01 * matrix4f2.m01 + matrix4f.m02 * matrix4f2.m02 + matrix4f.m03 * matrix4f2.m03;
            this.m01 = matrix4f.m00 * matrix4f2.m10 + matrix4f.m01 * matrix4f2.m11 + matrix4f.m02 * matrix4f2.m12 + matrix4f.m03 * matrix4f2.m13;
            this.m02 = matrix4f.m00 * matrix4f2.m20 + matrix4f.m01 * matrix4f2.m21 + matrix4f.m02 * matrix4f2.m22 + matrix4f.m03 * matrix4f2.m23;
            this.m03 = matrix4f.m00 * matrix4f2.m30 + matrix4f.m01 * matrix4f2.m31 + matrix4f.m02 * matrix4f2.m32 + matrix4f.m03 * matrix4f2.m33;
            this.m10 = matrix4f.m10 * matrix4f2.m00 + matrix4f.m11 * matrix4f2.m01 + matrix4f.m12 * matrix4f2.m02 + matrix4f.m13 * matrix4f2.m03;
            this.m11 = matrix4f.m10 * matrix4f2.m10 + matrix4f.m11 * matrix4f2.m11 + matrix4f.m12 * matrix4f2.m12 + matrix4f.m13 * matrix4f2.m13;
            this.m12 = matrix4f.m10 * matrix4f2.m20 + matrix4f.m11 * matrix4f2.m21 + matrix4f.m12 * matrix4f2.m22 + matrix4f.m13 * matrix4f2.m23;
            this.m13 = matrix4f.m10 * matrix4f2.m30 + matrix4f.m11 * matrix4f2.m31 + matrix4f.m12 * matrix4f2.m32 + matrix4f.m13 * matrix4f2.m33;
            this.m20 = matrix4f.m20 * matrix4f2.m00 + matrix4f.m21 * matrix4f2.m01 + matrix4f.m22 * matrix4f2.m02 + matrix4f.m23 * matrix4f2.m03;
            this.m21 = matrix4f.m20 * matrix4f2.m10 + matrix4f.m21 * matrix4f2.m11 + matrix4f.m22 * matrix4f2.m12 + matrix4f.m23 * matrix4f2.m13;
            this.m22 = matrix4f.m20 * matrix4f2.m20 + matrix4f.m21 * matrix4f2.m21 + matrix4f.m22 * matrix4f2.m22 + matrix4f.m23 * matrix4f2.m23;
            this.m23 = matrix4f.m20 * matrix4f2.m30 + matrix4f.m21 * matrix4f2.m31 + matrix4f.m22 * matrix4f2.m32 + matrix4f.m23 * matrix4f2.m33;
            this.m30 = matrix4f.m30 * matrix4f2.m00 + matrix4f.m31 * matrix4f2.m01 + matrix4f.m32 * matrix4f2.m02 + matrix4f.m33 * matrix4f2.m03;
            this.m31 = matrix4f.m30 * matrix4f2.m10 + matrix4f.m31 * matrix4f2.m11 + matrix4f.m32 * matrix4f2.m12 + matrix4f.m33 * matrix4f2.m13;
            this.m32 = matrix4f.m30 * matrix4f2.m20 + matrix4f.m31 * matrix4f2.m21 + matrix4f.m32 * matrix4f2.m22 + matrix4f.m33 * matrix4f2.m23;
            this.m33 = matrix4f.m30 * matrix4f2.m30 + matrix4f.m31 * matrix4f2.m31 + matrix4f.m32 * matrix4f2.m32 + matrix4f.m33 * matrix4f2.m33;
        } else {
            float f = matrix4f.m00 * matrix4f2.m00 + matrix4f.m01 * matrix4f2.m01 + matrix4f.m02 * matrix4f2.m02 + matrix4f.m03 * matrix4f2.m03;
            float f2 = matrix4f.m00 * matrix4f2.m10 + matrix4f.m01 * matrix4f2.m11 + matrix4f.m02 * matrix4f2.m12 + matrix4f.m03 * matrix4f2.m13;
            float f3 = matrix4f.m00 * matrix4f2.m20 + matrix4f.m01 * matrix4f2.m21 + matrix4f.m02 * matrix4f2.m22 + matrix4f.m03 * matrix4f2.m23;
            float f4 = matrix4f.m00 * matrix4f2.m30 + matrix4f.m01 * matrix4f2.m31 + matrix4f.m02 * matrix4f2.m32 + matrix4f.m03 * matrix4f2.m33;
            float f5 = matrix4f.m10 * matrix4f2.m00 + matrix4f.m11 * matrix4f2.m01 + matrix4f.m12 * matrix4f2.m02 + matrix4f.m13 * matrix4f2.m03;
            float f6 = matrix4f.m10 * matrix4f2.m10 + matrix4f.m11 * matrix4f2.m11 + matrix4f.m12 * matrix4f2.m12 + matrix4f.m13 * matrix4f2.m13;
            float f7 = matrix4f.m10 * matrix4f2.m20 + matrix4f.m11 * matrix4f2.m21 + matrix4f.m12 * matrix4f2.m22 + matrix4f.m13 * matrix4f2.m23;
            float f8 = matrix4f.m10 * matrix4f2.m30 + matrix4f.m11 * matrix4f2.m31 + matrix4f.m12 * matrix4f2.m32 + matrix4f.m13 * matrix4f2.m33;
            float f9 = matrix4f.m20 * matrix4f2.m00 + matrix4f.m21 * matrix4f2.m01 + matrix4f.m22 * matrix4f2.m02 + matrix4f.m23 * matrix4f2.m03;
            float f10 = matrix4f.m20 * matrix4f2.m10 + matrix4f.m21 * matrix4f2.m11 + matrix4f.m22 * matrix4f2.m12 + matrix4f.m23 * matrix4f2.m13;
            float f11 = matrix4f.m20 * matrix4f2.m20 + matrix4f.m21 * matrix4f2.m21 + matrix4f.m22 * matrix4f2.m22 + matrix4f.m23 * matrix4f2.m23;
            float f12 = matrix4f.m20 * matrix4f2.m30 + matrix4f.m21 * matrix4f2.m31 + matrix4f.m22 * matrix4f2.m32 + matrix4f.m23 * matrix4f2.m33;
            float f13 = matrix4f.m30 * matrix4f2.m00 + matrix4f.m31 * matrix4f2.m01 + matrix4f.m32 * matrix4f2.m02 + matrix4f.m33 * matrix4f2.m03;
            float f14 = matrix4f.m30 * matrix4f2.m10 + matrix4f.m31 * matrix4f2.m11 + matrix4f.m32 * matrix4f2.m12 + matrix4f.m33 * matrix4f2.m13;
            float f15 = matrix4f.m30 * matrix4f2.m20 + matrix4f.m31 * matrix4f2.m21 + matrix4f.m32 * matrix4f2.m22 + matrix4f.m33 * matrix4f2.m23;
            float f16 = matrix4f.m30 * matrix4f2.m30 + matrix4f.m31 * matrix4f2.m31 + matrix4f.m32 * matrix4f2.m32 + matrix4f.m33 * matrix4f2.m33;
            this.m00 = f;
            this.m01 = f2;
            this.m02 = f3;
            this.m03 = f4;
            this.m10 = f5;
            this.m11 = f6;
            this.m12 = f7;
            this.m13 = f8;
            this.m20 = f9;
            this.m21 = f10;
            this.m22 = f11;
            this.m23 = f12;
            this.m30 = f13;
            this.m31 = f14;
            this.m32 = f15;
            this.m33 = f16;
        }
    }

    public final void mulTransposeLeft(Matrix4f matrix4f, Matrix4f matrix4f2) {
        if (this != matrix4f && this != matrix4f2) {
            this.m00 = matrix4f.m00 * matrix4f2.m00 + matrix4f.m10 * matrix4f2.m10 + matrix4f.m20 * matrix4f2.m20 + matrix4f.m30 * matrix4f2.m30;
            this.m01 = matrix4f.m00 * matrix4f2.m01 + matrix4f.m10 * matrix4f2.m11 + matrix4f.m20 * matrix4f2.m21 + matrix4f.m30 * matrix4f2.m31;
            this.m02 = matrix4f.m00 * matrix4f2.m02 + matrix4f.m10 * matrix4f2.m12 + matrix4f.m20 * matrix4f2.m22 + matrix4f.m30 * matrix4f2.m32;
            this.m03 = matrix4f.m00 * matrix4f2.m03 + matrix4f.m10 * matrix4f2.m13 + matrix4f.m20 * matrix4f2.m23 + matrix4f.m30 * matrix4f2.m33;
            this.m10 = matrix4f.m01 * matrix4f2.m00 + matrix4f.m11 * matrix4f2.m10 + matrix4f.m21 * matrix4f2.m20 + matrix4f.m31 * matrix4f2.m30;
            this.m11 = matrix4f.m01 * matrix4f2.m01 + matrix4f.m11 * matrix4f2.m11 + matrix4f.m21 * matrix4f2.m21 + matrix4f.m31 * matrix4f2.m31;
            this.m12 = matrix4f.m01 * matrix4f2.m02 + matrix4f.m11 * matrix4f2.m12 + matrix4f.m21 * matrix4f2.m22 + matrix4f.m31 * matrix4f2.m32;
            this.m13 = matrix4f.m01 * matrix4f2.m03 + matrix4f.m11 * matrix4f2.m13 + matrix4f.m21 * matrix4f2.m23 + matrix4f.m31 * matrix4f2.m33;
            this.m20 = matrix4f.m02 * matrix4f2.m00 + matrix4f.m12 * matrix4f2.m10 + matrix4f.m22 * matrix4f2.m20 + matrix4f.m32 * matrix4f2.m30;
            this.m21 = matrix4f.m02 * matrix4f2.m01 + matrix4f.m12 * matrix4f2.m11 + matrix4f.m22 * matrix4f2.m21 + matrix4f.m32 * matrix4f2.m31;
            this.m22 = matrix4f.m02 * matrix4f2.m02 + matrix4f.m12 * matrix4f2.m12 + matrix4f.m22 * matrix4f2.m22 + matrix4f.m32 * matrix4f2.m32;
            this.m23 = matrix4f.m02 * matrix4f2.m03 + matrix4f.m12 * matrix4f2.m13 + matrix4f.m22 * matrix4f2.m23 + matrix4f.m32 * matrix4f2.m33;
            this.m30 = matrix4f.m03 * matrix4f2.m00 + matrix4f.m13 * matrix4f2.m10 + matrix4f.m23 * matrix4f2.m20 + matrix4f.m33 * matrix4f2.m30;
            this.m31 = matrix4f.m03 * matrix4f2.m01 + matrix4f.m13 * matrix4f2.m11 + matrix4f.m23 * matrix4f2.m21 + matrix4f.m33 * matrix4f2.m31;
            this.m32 = matrix4f.m03 * matrix4f2.m02 + matrix4f.m13 * matrix4f2.m12 + matrix4f.m23 * matrix4f2.m22 + matrix4f.m33 * matrix4f2.m32;
            this.m33 = matrix4f.m03 * matrix4f2.m03 + matrix4f.m13 * matrix4f2.m13 + matrix4f.m23 * matrix4f2.m23 + matrix4f.m33 * matrix4f2.m33;
        } else {
            float f = matrix4f.m00 * matrix4f2.m00 + matrix4f.m10 * matrix4f2.m10 + matrix4f.m20 * matrix4f2.m20 + matrix4f.m30 * matrix4f2.m30;
            float f2 = matrix4f.m00 * matrix4f2.m01 + matrix4f.m10 * matrix4f2.m11 + matrix4f.m20 * matrix4f2.m21 + matrix4f.m30 * matrix4f2.m31;
            float f3 = matrix4f.m00 * matrix4f2.m02 + matrix4f.m10 * matrix4f2.m12 + matrix4f.m20 * matrix4f2.m22 + matrix4f.m30 * matrix4f2.m32;
            float f4 = matrix4f.m00 * matrix4f2.m03 + matrix4f.m10 * matrix4f2.m13 + matrix4f.m20 * matrix4f2.m23 + matrix4f.m30 * matrix4f2.m33;
            float f5 = matrix4f.m01 * matrix4f2.m00 + matrix4f.m11 * matrix4f2.m10 + matrix4f.m21 * matrix4f2.m20 + matrix4f.m31 * matrix4f2.m30;
            float f6 = matrix4f.m01 * matrix4f2.m01 + matrix4f.m11 * matrix4f2.m11 + matrix4f.m21 * matrix4f2.m21 + matrix4f.m31 * matrix4f2.m31;
            float f7 = matrix4f.m01 * matrix4f2.m02 + matrix4f.m11 * matrix4f2.m12 + matrix4f.m21 * matrix4f2.m22 + matrix4f.m31 * matrix4f2.m32;
            float f8 = matrix4f.m01 * matrix4f2.m03 + matrix4f.m11 * matrix4f2.m13 + matrix4f.m21 * matrix4f2.m23 + matrix4f.m31 * matrix4f2.m33;
            float f9 = matrix4f.m02 * matrix4f2.m00 + matrix4f.m12 * matrix4f2.m10 + matrix4f.m22 * matrix4f2.m20 + matrix4f.m32 * matrix4f2.m30;
            float f10 = matrix4f.m02 * matrix4f2.m01 + matrix4f.m12 * matrix4f2.m11 + matrix4f.m22 * matrix4f2.m21 + matrix4f.m32 * matrix4f2.m31;
            float f11 = matrix4f.m02 * matrix4f2.m02 + matrix4f.m12 * matrix4f2.m12 + matrix4f.m22 * matrix4f2.m22 + matrix4f.m32 * matrix4f2.m32;
            float f12 = matrix4f.m02 * matrix4f2.m03 + matrix4f.m12 * matrix4f2.m13 + matrix4f.m22 * matrix4f2.m23 + matrix4f.m32 * matrix4f2.m33;
            float f13 = matrix4f.m03 * matrix4f2.m00 + matrix4f.m13 * matrix4f2.m10 + matrix4f.m23 * matrix4f2.m20 + matrix4f.m33 * matrix4f2.m30;
            float f14 = matrix4f.m03 * matrix4f2.m01 + matrix4f.m13 * matrix4f2.m11 + matrix4f.m23 * matrix4f2.m21 + matrix4f.m33 * matrix4f2.m31;
            float f15 = matrix4f.m03 * matrix4f2.m02 + matrix4f.m13 * matrix4f2.m12 + matrix4f.m23 * matrix4f2.m22 + matrix4f.m33 * matrix4f2.m32;
            float f16 = matrix4f.m03 * matrix4f2.m03 + matrix4f.m13 * matrix4f2.m13 + matrix4f.m23 * matrix4f2.m23 + matrix4f.m33 * matrix4f2.m33;
            this.m00 = f;
            this.m01 = f2;
            this.m02 = f3;
            this.m03 = f4;
            this.m10 = f5;
            this.m11 = f6;
            this.m12 = f7;
            this.m13 = f8;
            this.m20 = f9;
            this.m21 = f10;
            this.m22 = f11;
            this.m23 = f12;
            this.m30 = f13;
            this.m31 = f14;
            this.m32 = f15;
            this.m33 = f16;
        }
    }

    public boolean equals(Matrix4f matrix4f) {
        try {
            return this.m00 == matrix4f.m00 && this.m01 == matrix4f.m01 && this.m02 == matrix4f.m02 && this.m03 == matrix4f.m03 && this.m10 == matrix4f.m10 && this.m11 == matrix4f.m11 && this.m12 == matrix4f.m12 && this.m13 == matrix4f.m13 && this.m20 == matrix4f.m20 && this.m21 == matrix4f.m21 && this.m22 == matrix4f.m22 && this.m23 == matrix4f.m23 && this.m30 == matrix4f.m30 && this.m31 == matrix4f.m31 && this.m32 == matrix4f.m32 && this.m33 == matrix4f.m33;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Matrix4f matrix4f = (Matrix4f)object;
            return this.m00 == matrix4f.m00 && this.m01 == matrix4f.m01 && this.m02 == matrix4f.m02 && this.m03 == matrix4f.m03 && this.m10 == matrix4f.m10 && this.m11 == matrix4f.m11 && this.m12 == matrix4f.m12 && this.m13 == matrix4f.m13 && this.m20 == matrix4f.m20 && this.m21 == matrix4f.m21 && this.m22 == matrix4f.m22 && this.m23 == matrix4f.m23 && this.m30 == matrix4f.m30 && this.m31 == matrix4f.m31 && this.m32 == matrix4f.m32 && this.m33 == matrix4f.m33;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean epsilonEquals(Matrix4f matrix4f, float f) {
        boolean bl = true;
        if (Math.abs(this.m00 - matrix4f.m00) > f) {
            bl = false;
        }
        if (Math.abs(this.m01 - matrix4f.m01) > f) {
            bl = false;
        }
        if (Math.abs(this.m02 - matrix4f.m02) > f) {
            bl = false;
        }
        if (Math.abs(this.m03 - matrix4f.m03) > f) {
            bl = false;
        }
        if (Math.abs(this.m10 - matrix4f.m10) > f) {
            bl = false;
        }
        if (Math.abs(this.m11 - matrix4f.m11) > f) {
            bl = false;
        }
        if (Math.abs(this.m12 - matrix4f.m12) > f) {
            bl = false;
        }
        if (Math.abs(this.m13 - matrix4f.m13) > f) {
            bl = false;
        }
        if (Math.abs(this.m20 - matrix4f.m20) > f) {
            bl = false;
        }
        if (Math.abs(this.m21 - matrix4f.m21) > f) {
            bl = false;
        }
        if (Math.abs(this.m22 - matrix4f.m22) > f) {
            bl = false;
        }
        if (Math.abs(this.m23 - matrix4f.m23) > f) {
            bl = false;
        }
        if (Math.abs(this.m30 - matrix4f.m30) > f) {
            bl = false;
        }
        if (Math.abs(this.m31 - matrix4f.m31) > f) {
            bl = false;
        }
        if (Math.abs(this.m32 - matrix4f.m32) > f) {
            bl = false;
        }
        if (Math.abs(this.m33 - matrix4f.m33) > f) {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m00);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m01);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m02);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m03);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m10);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m11);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m12);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m13);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m20);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m21);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m22);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m23);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m30);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m31);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m32);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.m33);
        return (int)(l ^ l >> 32);
    }

    public final void transform(Tuple4f tuple4f, Tuple4f tuple4f2) {
        float f = this.m00 * tuple4f.x + this.m01 * tuple4f.y + this.m02 * tuple4f.z + this.m03 * tuple4f.w;
        float f2 = this.m10 * tuple4f.x + this.m11 * tuple4f.y + this.m12 * tuple4f.z + this.m13 * tuple4f.w;
        float f3 = this.m20 * tuple4f.x + this.m21 * tuple4f.y + this.m22 * tuple4f.z + this.m23 * tuple4f.w;
        tuple4f2.w = this.m30 * tuple4f.x + this.m31 * tuple4f.y + this.m32 * tuple4f.z + this.m33 * tuple4f.w;
        tuple4f2.x = f;
        tuple4f2.y = f2;
        tuple4f2.z = f3;
    }

    public final void transform(Tuple4f tuple4f) {
        float f = this.m00 * tuple4f.x + this.m01 * tuple4f.y + this.m02 * tuple4f.z + this.m03 * tuple4f.w;
        float f2 = this.m10 * tuple4f.x + this.m11 * tuple4f.y + this.m12 * tuple4f.z + this.m13 * tuple4f.w;
        float f3 = this.m20 * tuple4f.x + this.m21 * tuple4f.y + this.m22 * tuple4f.z + this.m23 * tuple4f.w;
        tuple4f.w = this.m30 * tuple4f.x + this.m31 * tuple4f.y + this.m32 * tuple4f.z + this.m33 * tuple4f.w;
        tuple4f.x = f;
        tuple4f.y = f2;
        tuple4f.z = f3;
    }

    public final void transform(Point3f point3f, Point3f point3f2) {
        float f = this.m00 * point3f.x + this.m01 * point3f.y + this.m02 * point3f.z + this.m03;
        float f2 = this.m10 * point3f.x + this.m11 * point3f.y + this.m12 * point3f.z + this.m13;
        point3f2.z = this.m20 * point3f.x + this.m21 * point3f.y + this.m22 * point3f.z + this.m23;
        point3f2.x = f;
        point3f2.y = f2;
    }

    public final void transform(Point3f point3f) {
        float f = this.m00 * point3f.x + this.m01 * point3f.y + this.m02 * point3f.z + this.m03;
        float f2 = this.m10 * point3f.x + this.m11 * point3f.y + this.m12 * point3f.z + this.m13;
        point3f.z = this.m20 * point3f.x + this.m21 * point3f.y + this.m22 * point3f.z + this.m23;
        point3f.x = f;
        point3f.y = f2;
    }

    public final void transform(Vector3f vector3f, Vector3f vector3f2) {
        float f = this.m00 * vector3f.x + this.m01 * vector3f.y + this.m02 * vector3f.z;
        float f2 = this.m10 * vector3f.x + this.m11 * vector3f.y + this.m12 * vector3f.z;
        vector3f2.z = this.m20 * vector3f.x + this.m21 * vector3f.y + this.m22 * vector3f.z;
        vector3f2.x = f;
        vector3f2.y = f2;
    }

    public final void transform(Vector3f vector3f) {
        float f = this.m00 * vector3f.x + this.m01 * vector3f.y + this.m02 * vector3f.z;
        float f2 = this.m10 * vector3f.x + this.m11 * vector3f.y + this.m12 * vector3f.z;
        vector3f.z = this.m20 * vector3f.x + this.m21 * vector3f.y + this.m22 * vector3f.z;
        vector3f.x = f;
        vector3f.y = f2;
    }

    public final void setRotation(Matrix3d matrix3d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = (float)(matrix3d.m00 * dArray2[0]);
        this.m01 = (float)(matrix3d.m01 * dArray2[1]);
        this.m02 = (float)(matrix3d.m02 * dArray2[2]);
        this.m10 = (float)(matrix3d.m10 * dArray2[0]);
        this.m11 = (float)(matrix3d.m11 * dArray2[1]);
        this.m12 = (float)(matrix3d.m12 * dArray2[2]);
        this.m20 = (float)(matrix3d.m20 * dArray2[0]);
        this.m21 = (float)(matrix3d.m21 * dArray2[1]);
        this.m22 = (float)(matrix3d.m22 * dArray2[2]);
    }

    public final void setRotation(Matrix3f matrix3f) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = (float)((double)matrix3f.m00 * dArray2[0]);
        this.m01 = (float)((double)matrix3f.m01 * dArray2[1]);
        this.m02 = (float)((double)matrix3f.m02 * dArray2[2]);
        this.m10 = (float)((double)matrix3f.m10 * dArray2[0]);
        this.m11 = (float)((double)matrix3f.m11 * dArray2[1]);
        this.m12 = (float)((double)matrix3f.m12 * dArray2[2]);
        this.m20 = (float)((double)matrix3f.m20 * dArray2[0]);
        this.m21 = (float)((double)matrix3f.m21 * dArray2[1]);
        this.m22 = (float)((double)matrix3f.m22 * dArray2[2]);
    }

    public final void setRotation(Quat4f quat4f) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = (float)((double)(1.0f - 2.0f * quat4f.y * quat4f.y - 2.0f * quat4f.z * quat4f.z) * dArray2[0]);
        this.m10 = (float)((double)(2.0f * (quat4f.x * quat4f.y + quat4f.w * quat4f.z)) * dArray2[0]);
        this.m20 = (float)((double)(2.0f * (quat4f.x * quat4f.z - quat4f.w * quat4f.y)) * dArray2[0]);
        this.m01 = (float)((double)(2.0f * (quat4f.x * quat4f.y - quat4f.w * quat4f.z)) * dArray2[1]);
        this.m11 = (float)((double)(1.0f - 2.0f * quat4f.x * quat4f.x - 2.0f * quat4f.z * quat4f.z) * dArray2[1]);
        this.m21 = (float)((double)(2.0f * (quat4f.y * quat4f.z + quat4f.w * quat4f.x)) * dArray2[1]);
        this.m02 = (float)((double)(2.0f * (quat4f.x * quat4f.z + quat4f.w * quat4f.y)) * dArray2[2]);
        this.m12 = (float)((double)(2.0f * (quat4f.y * quat4f.z - quat4f.w * quat4f.x)) * dArray2[2]);
        this.m22 = (float)((double)(1.0f - 2.0f * quat4f.x * quat4f.x - 2.0f * quat4f.y * quat4f.y) * dArray2[2]);
    }

    public final void setRotation(Quat4d quat4d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = (float)((1.0 - 2.0 * quat4d.y * quat4d.y - 2.0 * quat4d.z * quat4d.z) * dArray2[0]);
        this.m10 = (float)(2.0 * (quat4d.x * quat4d.y + quat4d.w * quat4d.z) * dArray2[0]);
        this.m20 = (float)(2.0 * (quat4d.x * quat4d.z - quat4d.w * quat4d.y) * dArray2[0]);
        this.m01 = (float)(2.0 * (quat4d.x * quat4d.y - quat4d.w * quat4d.z) * dArray2[1]);
        this.m11 = (float)((1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.z * quat4d.z) * dArray2[1]);
        this.m21 = (float)(2.0 * (quat4d.y * quat4d.z + quat4d.w * quat4d.x) * dArray2[1]);
        this.m02 = (float)(2.0 * (quat4d.x * quat4d.z + quat4d.w * quat4d.y) * dArray2[2]);
        this.m12 = (float)(2.0 * (quat4d.y * quat4d.z - quat4d.w * quat4d.x) * dArray2[2]);
        this.m22 = (float)((1.0 - 2.0 * quat4d.x * quat4d.x - 2.0 * quat4d.y * quat4d.y) * dArray2[2]);
    }

    public final void setRotation(AxisAngle4f axisAngle4f) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        double d = Math.sqrt(axisAngle4f.x * axisAngle4f.x + axisAngle4f.y * axisAngle4f.y + axisAngle4f.z * axisAngle4f.z);
        if (d < 1.0E-8) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            this.m20 = 0.0f;
            this.m21 = 0.0f;
            this.m22 = 1.0f;
        } else {
            d = 1.0 / d;
            double d2 = (double)axisAngle4f.x * d;
            double d3 = (double)axisAngle4f.y * d;
            double d4 = (double)axisAngle4f.z * d;
            double d5 = Math.sin(axisAngle4f.angle);
            double d6 = Math.cos(axisAngle4f.angle);
            double d7 = 1.0 - d6;
            double d8 = axisAngle4f.x * axisAngle4f.z;
            double d9 = axisAngle4f.x * axisAngle4f.y;
            double d10 = axisAngle4f.y * axisAngle4f.z;
            this.m00 = (float)((d7 * d2 * d2 + d6) * dArray2[0]);
            this.m01 = (float)((d7 * d9 - d5 * d4) * dArray2[1]);
            this.m02 = (float)((d7 * d8 + d5 * d3) * dArray2[2]);
            this.m10 = (float)((d7 * d9 + d5 * d4) * dArray2[0]);
            this.m11 = (float)((d7 * d3 * d3 + d6) * dArray2[1]);
            this.m12 = (float)((d7 * d10 - d5 * d2) * dArray2[2]);
            this.m20 = (float)((d7 * d8 - d5 * d3) * dArray2[0]);
            this.m21 = (float)((d7 * d10 + d5 * d2) * dArray2[1]);
            this.m22 = (float)((d7 * d4 * d4 + d6) * dArray2[2]);
        }
    }

    public final void setZero() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
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

    public final void negate(Matrix4f matrix4f) {
        this.m00 = -matrix4f.m00;
        this.m01 = -matrix4f.m01;
        this.m02 = -matrix4f.m02;
        this.m03 = -matrix4f.m03;
        this.m10 = -matrix4f.m10;
        this.m11 = -matrix4f.m11;
        this.m12 = -matrix4f.m12;
        this.m13 = -matrix4f.m13;
        this.m20 = -matrix4f.m20;
        this.m21 = -matrix4f.m21;
        this.m22 = -matrix4f.m22;
        this.m23 = -matrix4f.m23;
        this.m30 = -matrix4f.m30;
        this.m31 = -matrix4f.m31;
        this.m32 = -matrix4f.m32;
        this.m33 = -matrix4f.m33;
    }

    private final void getScaleRotate(double[] dArray, double[] dArray2) {
        double[] dArray3 = new double[]{this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22};
        Matrix3d.compute_svd(dArray3, dArray, dArray2);
    }

    public Object clone() {
        Matrix4f matrix4f = null;
        try {
            matrix4f = (Matrix4f)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        return matrix4f;
    }
}


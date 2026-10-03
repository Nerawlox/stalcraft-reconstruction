/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix3f;
import javax.vecmath.Quat4d;
import javax.vecmath.Quat4f;
import javax.vecmath.SingularMatrixException;
import javax.vecmath.Tuple3d;
import javax.vecmath.VecMathI18N;
import javax.vecmath.VecMathUtil;
import javax.vecmath.Vector3d;

public class Matrix3d
implements Serializable,
Cloneable {
    static final long serialVersionUID = 6837536777072402710L;
    public double m00;
    public double m01;
    public double m02;
    public double m10;
    public double m11;
    public double m12;
    public double m20;
    public double m21;
    public double m22;
    private static final double EPS = 1.110223024E-16;
    private static final double ERR_EPS = 1.0E-8;
    private static double xin;
    private static double yin;
    private static double zin;
    private static double xout;
    private static double yout;
    private static double zout;

    public Matrix3d(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.m00 = d;
        this.m01 = d2;
        this.m02 = d3;
        this.m10 = d4;
        this.m11 = d5;
        this.m12 = d6;
        this.m20 = d7;
        this.m21 = d8;
        this.m22 = d9;
    }

    public Matrix3d(double[] dArray) {
        this.m00 = dArray[0];
        this.m01 = dArray[1];
        this.m02 = dArray[2];
        this.m10 = dArray[3];
        this.m11 = dArray[4];
        this.m12 = dArray[5];
        this.m20 = dArray[6];
        this.m21 = dArray[7];
        this.m22 = dArray[8];
    }

    public Matrix3d(Matrix3d matrix3d) {
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

    public Matrix3d(Matrix3f matrix3f) {
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

    public Matrix3d() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
    }

    public String toString() {
        return this.m00 + ", " + this.m01 + ", " + this.m02 + "\n" + this.m10 + ", " + this.m11 + ", " + this.m12 + "\n" + this.m20 + ", " + this.m21 + ", " + this.m22 + "\n";
    }

    public final void setIdentity() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
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
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
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
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
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
                }
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
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
                }
                break;
            }
        }
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d1"));
    }

    public final void getRow(int n, Vector3d vector3d) {
        if (n == 0) {
            vector3d.x = this.m00;
            vector3d.y = this.m01;
            vector3d.z = this.m02;
        } else if (n == 1) {
            vector3d.x = this.m10;
            vector3d.y = this.m11;
            vector3d.z = this.m12;
        } else if (n == 2) {
            vector3d.x = this.m20;
            vector3d.y = this.m21;
            vector3d.z = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d2"));
        }
    }

    public final void getRow(int n, double[] dArray) {
        if (n == 0) {
            dArray[0] = this.m00;
            dArray[1] = this.m01;
            dArray[2] = this.m02;
        } else if (n == 1) {
            dArray[0] = this.m10;
            dArray[1] = this.m11;
            dArray[2] = this.m12;
        } else if (n == 2) {
            dArray[0] = this.m20;
            dArray[1] = this.m21;
            dArray[2] = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d2"));
        }
    }

    public final void getColumn(int n, Vector3d vector3d) {
        if (n == 0) {
            vector3d.x = this.m00;
            vector3d.y = this.m10;
            vector3d.z = this.m20;
        } else if (n == 1) {
            vector3d.x = this.m01;
            vector3d.y = this.m11;
            vector3d.z = this.m21;
        } else if (n == 2) {
            vector3d.x = this.m02;
            vector3d.y = this.m12;
            vector3d.z = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d4"));
        }
    }

    public final void getColumn(int n, double[] dArray) {
        if (n == 0) {
            dArray[0] = this.m00;
            dArray[1] = this.m10;
            dArray[2] = this.m20;
        } else if (n == 1) {
            dArray[0] = this.m01;
            dArray[1] = this.m11;
            dArray[2] = this.m21;
        } else if (n == 2) {
            dArray[0] = this.m02;
            dArray[1] = this.m12;
            dArray[2] = this.m22;
        } else {
            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d4"));
        }
    }

    public final void setRow(int n, double d, double d2, double d3) {
        switch (n) {
            case 0: {
                this.m00 = d;
                this.m01 = d2;
                this.m02 = d3;
                break;
            }
            case 1: {
                this.m10 = d;
                this.m11 = d2;
                this.m12 = d3;
                break;
            }
            case 2: {
                this.m20 = d;
                this.m21 = d2;
                this.m22 = d3;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d6"));
            }
        }
    }

    public final void setRow(int n, Vector3d vector3d) {
        switch (n) {
            case 0: {
                this.m00 = vector3d.x;
                this.m01 = vector3d.y;
                this.m02 = vector3d.z;
                break;
            }
            case 1: {
                this.m10 = vector3d.x;
                this.m11 = vector3d.y;
                this.m12 = vector3d.z;
                break;
            }
            case 2: {
                this.m20 = vector3d.x;
                this.m21 = vector3d.y;
                this.m22 = vector3d.z;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d6"));
            }
        }
    }

    public final void setRow(int n, double[] dArray) {
        switch (n) {
            case 0: {
                this.m00 = dArray[0];
                this.m01 = dArray[1];
                this.m02 = dArray[2];
                break;
            }
            case 1: {
                this.m10 = dArray[0];
                this.m11 = dArray[1];
                this.m12 = dArray[2];
                break;
            }
            case 2: {
                this.m20 = dArray[0];
                this.m21 = dArray[1];
                this.m22 = dArray[2];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d6"));
            }
        }
    }

    public final void setColumn(int n, double d, double d2, double d3) {
        switch (n) {
            case 0: {
                this.m00 = d;
                this.m10 = d2;
                this.m20 = d3;
                break;
            }
            case 1: {
                this.m01 = d;
                this.m11 = d2;
                this.m21 = d3;
                break;
            }
            case 2: {
                this.m02 = d;
                this.m12 = d2;
                this.m22 = d3;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d9"));
            }
        }
    }

    public final void setColumn(int n, Vector3d vector3d) {
        switch (n) {
            case 0: {
                this.m00 = vector3d.x;
                this.m10 = vector3d.y;
                this.m20 = vector3d.z;
                break;
            }
            case 1: {
                this.m01 = vector3d.x;
                this.m11 = vector3d.y;
                this.m21 = vector3d.z;
                break;
            }
            case 2: {
                this.m02 = vector3d.x;
                this.m12 = vector3d.y;
                this.m22 = vector3d.z;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d9"));
            }
        }
    }

    public final void setColumn(int n, double[] dArray) {
        switch (n) {
            case 0: {
                this.m00 = dArray[0];
                this.m10 = dArray[1];
                this.m20 = dArray[2];
                break;
            }
            case 1: {
                this.m01 = dArray[0];
                this.m11 = dArray[1];
                this.m21 = dArray[2];
                break;
            }
            case 2: {
                this.m02 = dArray[0];
                this.m12 = dArray[1];
                this.m22 = dArray[2];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d9"));
            }
        }
    }

    public final double getScale() {
        double[] dArray = new double[3];
        double[] dArray2 = new double[9];
        this.getScaleRotate(dArray, dArray2);
        return Matrix3d.max3(dArray);
    }

    public final void add(double d) {
        this.m00 += d;
        this.m01 += d;
        this.m02 += d;
        this.m10 += d;
        this.m11 += d;
        this.m12 += d;
        this.m20 += d;
        this.m21 += d;
        this.m22 += d;
    }

    public final void add(double d, Matrix3d matrix3d) {
        this.m00 = matrix3d.m00 + d;
        this.m01 = matrix3d.m01 + d;
        this.m02 = matrix3d.m02 + d;
        this.m10 = matrix3d.m10 + d;
        this.m11 = matrix3d.m11 + d;
        this.m12 = matrix3d.m12 + d;
        this.m20 = matrix3d.m20 + d;
        this.m21 = matrix3d.m21 + d;
        this.m22 = matrix3d.m22 + d;
    }

    public final void add(Matrix3d matrix3d, Matrix3d matrix3d2) {
        this.m00 = matrix3d.m00 + matrix3d2.m00;
        this.m01 = matrix3d.m01 + matrix3d2.m01;
        this.m02 = matrix3d.m02 + matrix3d2.m02;
        this.m10 = matrix3d.m10 + matrix3d2.m10;
        this.m11 = matrix3d.m11 + matrix3d2.m11;
        this.m12 = matrix3d.m12 + matrix3d2.m12;
        this.m20 = matrix3d.m20 + matrix3d2.m20;
        this.m21 = matrix3d.m21 + matrix3d2.m21;
        this.m22 = matrix3d.m22 + matrix3d2.m22;
    }

    public final void add(Matrix3d matrix3d) {
        this.m00 += matrix3d.m00;
        this.m01 += matrix3d.m01;
        this.m02 += matrix3d.m02;
        this.m10 += matrix3d.m10;
        this.m11 += matrix3d.m11;
        this.m12 += matrix3d.m12;
        this.m20 += matrix3d.m20;
        this.m21 += matrix3d.m21;
        this.m22 += matrix3d.m22;
    }

    public final void sub(Matrix3d matrix3d, Matrix3d matrix3d2) {
        this.m00 = matrix3d.m00 - matrix3d2.m00;
        this.m01 = matrix3d.m01 - matrix3d2.m01;
        this.m02 = matrix3d.m02 - matrix3d2.m02;
        this.m10 = matrix3d.m10 - matrix3d2.m10;
        this.m11 = matrix3d.m11 - matrix3d2.m11;
        this.m12 = matrix3d.m12 - matrix3d2.m12;
        this.m20 = matrix3d.m20 - matrix3d2.m20;
        this.m21 = matrix3d.m21 - matrix3d2.m21;
        this.m22 = matrix3d.m22 - matrix3d2.m22;
    }

    public final void sub(Matrix3d matrix3d) {
        this.m00 -= matrix3d.m00;
        this.m01 -= matrix3d.m01;
        this.m02 -= matrix3d.m02;
        this.m10 -= matrix3d.m10;
        this.m11 -= matrix3d.m11;
        this.m12 -= matrix3d.m12;
        this.m20 -= matrix3d.m20;
        this.m21 -= matrix3d.m21;
        this.m22 -= matrix3d.m22;
    }

    public final void transpose() {
        double d = this.m10;
        this.m10 = this.m01;
        this.m01 = d;
        d = this.m20;
        this.m20 = this.m02;
        this.m02 = d;
        d = this.m21;
        this.m21 = this.m12;
        this.m12 = d;
    }

    public final void transpose(Matrix3d matrix3d) {
        if (this != matrix3d) {
            this.m00 = matrix3d.m00;
            this.m01 = matrix3d.m10;
            this.m02 = matrix3d.m20;
            this.m10 = matrix3d.m01;
            this.m11 = matrix3d.m11;
            this.m12 = matrix3d.m21;
            this.m20 = matrix3d.m02;
            this.m21 = matrix3d.m12;
            this.m22 = matrix3d.m22;
        } else {
            this.transpose();
        }
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
    }

    public final void set(AxisAngle4d axisAngle4d) {
        double d = Math.sqrt(axisAngle4d.x * axisAngle4d.x + axisAngle4d.y * axisAngle4d.y + axisAngle4d.z * axisAngle4d.z);
        if (d < 1.110223024E-16) {
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
            double d8 = axisAngle4d.x * axisAngle4d.z;
            double d9 = axisAngle4d.x * axisAngle4d.y;
            double d10 = axisAngle4d.y * axisAngle4d.z;
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
    }

    public final void set(AxisAngle4f axisAngle4f) {
        double d = Math.sqrt(axisAngle4f.x * axisAngle4f.x + axisAngle4f.y * axisAngle4f.y + axisAngle4f.z * axisAngle4f.z);
        if (d < 1.110223024E-16) {
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
    }

    public final void set(Matrix3f matrix3f) {
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

    public final void set(Matrix3d matrix3d) {
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

    public final void set(double[] dArray) {
        this.m00 = dArray[0];
        this.m01 = dArray[1];
        this.m02 = dArray[2];
        this.m10 = dArray[3];
        this.m11 = dArray[4];
        this.m12 = dArray[5];
        this.m20 = dArray[6];
        this.m21 = dArray[7];
        this.m22 = dArray[8];
    }

    public final void invert(Matrix3d matrix3d) {
        this.invertGeneral(matrix3d);
    }

    public final void invert() {
        this.invertGeneral(this);
    }

    private final void invertGeneral(Matrix3d matrix3d) {
        double[] dArray = new double[9];
        int[] nArray = new int[3];
        double[] dArray2 = new double[]{matrix3d.m00, matrix3d.m01, matrix3d.m02, matrix3d.m10, matrix3d.m11, matrix3d.m12, matrix3d.m20, matrix3d.m21, matrix3d.m22};
        if (!Matrix3d.luDecomposition(dArray2, nArray)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix3d12"));
        }
        for (int i = 0; i < 9; ++i) {
            dArray[i] = 0.0;
        }
        dArray[0] = 1.0;
        dArray[4] = 1.0;
        dArray[8] = 1.0;
        Matrix3d.luBacksubstitution(dArray2, nArray, dArray);
        this.m00 = dArray[0];
        this.m01 = dArray[1];
        this.m02 = dArray[2];
        this.m10 = dArray[3];
        this.m11 = dArray[4];
        this.m12 = dArray[5];
        this.m20 = dArray[6];
        this.m21 = dArray[7];
        this.m22 = dArray[8];
    }

    static boolean luDecomposition(double[] dArray, int[] nArray) {
        int n;
        double[] dArray2 = new double[3];
        int n2 = 0;
        int n3 = 0;
        int n4 = 3;
        while (n4-- != 0) {
            double d = 0.0;
            n = 3;
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
        for (n4 = 0; n4 < 3; ++n4) {
            double d;
            int n5;
            int n6;
            int n7;
            double d3;
            int n8;
            for (n2 = 0; n2 < n4; ++n2) {
                n8 = n + 3 * n2 + n4;
                d3 = dArray[n8];
                int n9 = n2;
                int n10 = n + 3 * n2;
                n7 = n + n4;
                while (n9-- != 0) {
                    d3 -= dArray[n10] * dArray[n7];
                    ++n10;
                    n7 += 3;
                }
                dArray[n8] = d3;
            }
            double d4 = 0.0;
            n3 = -1;
            for (n2 = n4; n2 < 3; ++n2) {
                double d5;
                n8 = n + 3 * n2 + n4;
                d3 = dArray[n8];
                n6 = n4;
                n5 = n + 3 * n2;
                n7 = n + n4;
                while (n6-- != 0) {
                    d3 -= dArray[n5] * dArray[n7];
                    ++n5;
                    n7 += 3;
                }
                dArray[n8] = d3;
                d = dArray2[n2] * Math.abs(d3);
                if (!(d5 >= d4)) continue;
                d4 = d;
                n3 = n2;
            }
            if (n3 < 0) {
                throw new RuntimeException(VecMathI18N.getString("Matrix3d13"));
            }
            if (n4 != n3) {
                n6 = 3;
                n5 = n + 3 * n3;
                n7 = n + 3 * n4;
                while (n6-- != 0) {
                    d = dArray[n5];
                    dArray[n5++] = dArray[n7];
                    dArray[n7++] = d;
                }
                dArray2[n3] = dArray2[n4];
            }
            nArray[n4] = n3;
            if (dArray[n + 3 * n4 + n4] == 0.0) {
                return false;
            }
            if (n4 == 2) continue;
            d = 1.0 / dArray[n + 3 * n4 + n4];
            n8 = n + 3 * (n4 + 1) + n4;
            n2 = 2 - n4;
            while (n2-- != 0) {
                int n11 = n8;
                dArray[n11] = dArray[n11] * d;
                n8 += 3;
            }
        }
        return true;
    }

    static void luBacksubstitution(double[] dArray, int[] nArray, double[] dArray2) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            int n2;
            int n3 = i;
            int n4 = -1;
            for (int j = 0; j < 3; ++j) {
                int n5 = nArray[n + j];
                double d = dArray2[n3 + 3 * n5];
                dArray2[n3 + 3 * n5] = dArray2[n3 + 3 * j];
                if (n4 >= 0) {
                    n2 = j * 3;
                    for (int k = n4; k <= j - 1; ++k) {
                        d -= dArray[n2 + k] * dArray2[n3 + 3 * k];
                    }
                } else if (d != 0.0) {
                    n4 = j;
                }
                dArray2[n3 + 3 * j] = d;
            }
            n2 = 6;
            int n6 = n3 + 6;
            dArray2[n6] = dArray2[n6] / dArray[n2 + 2];
            dArray2[n3 + 3] = (dArray2[n3 + 3] - dArray[(n2 -= 3) + 2] * dArray2[n3 + 6]) / dArray[n2 + 1];
            dArray2[n3 + 0] = (dArray2[n3 + 0] - dArray[(n2 -= 3) + 1] * dArray2[n3 + 3] - dArray[n2 + 2] * dArray2[n3 + 6]) / dArray[n2 + 0];
        }
    }

    public final double determinant() {
        double d = this.m00 * (this.m11 * this.m22 - this.m12 * this.m21) + this.m01 * (this.m12 * this.m20 - this.m10 * this.m22) + this.m02 * (this.m10 * this.m21 - this.m11 * this.m20);
        return d;
    }

    public final void set(double d) {
        this.m00 = d;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m10 = 0.0;
        this.m11 = d;
        this.m12 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = d;
    }

    public final void rotX(double d) {
        double d2 = Math.sin(d);
        double d3 = Math.cos(d);
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m10 = 0.0;
        this.m11 = d3;
        this.m12 = -d2;
        this.m20 = 0.0;
        this.m21 = d2;
        this.m22 = d3;
    }

    public final void rotY(double d) {
        double d2;
        double d3 = Math.sin(d);
        this.m00 = d2 = Math.cos(d);
        this.m01 = 0.0;
        this.m02 = d3;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m20 = -d3;
        this.m21 = 0.0;
        this.m22 = d2;
    }

    public final void rotZ(double d) {
        double d2;
        double d3 = Math.sin(d);
        this.m00 = d2 = Math.cos(d);
        this.m01 = -d3;
        this.m02 = 0.0;
        this.m10 = d3;
        this.m11 = d2;
        this.m12 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
    }

    public final void mul(double d) {
        this.m00 *= d;
        this.m01 *= d;
        this.m02 *= d;
        this.m10 *= d;
        this.m11 *= d;
        this.m12 *= d;
        this.m20 *= d;
        this.m21 *= d;
        this.m22 *= d;
    }

    public final void mul(double d, Matrix3d matrix3d) {
        this.m00 = d * matrix3d.m00;
        this.m01 = d * matrix3d.m01;
        this.m02 = d * matrix3d.m02;
        this.m10 = d * matrix3d.m10;
        this.m11 = d * matrix3d.m11;
        this.m12 = d * matrix3d.m12;
        this.m20 = d * matrix3d.m20;
        this.m21 = d * matrix3d.m21;
        this.m22 = d * matrix3d.m22;
    }

    public final void mul(Matrix3d matrix3d) {
        double d = this.m00 * matrix3d.m00 + this.m01 * matrix3d.m10 + this.m02 * matrix3d.m20;
        double d2 = this.m00 * matrix3d.m01 + this.m01 * matrix3d.m11 + this.m02 * matrix3d.m21;
        double d3 = this.m00 * matrix3d.m02 + this.m01 * matrix3d.m12 + this.m02 * matrix3d.m22;
        double d4 = this.m10 * matrix3d.m00 + this.m11 * matrix3d.m10 + this.m12 * matrix3d.m20;
        double d5 = this.m10 * matrix3d.m01 + this.m11 * matrix3d.m11 + this.m12 * matrix3d.m21;
        double d6 = this.m10 * matrix3d.m02 + this.m11 * matrix3d.m12 + this.m12 * matrix3d.m22;
        double d7 = this.m20 * matrix3d.m00 + this.m21 * matrix3d.m10 + this.m22 * matrix3d.m20;
        double d8 = this.m20 * matrix3d.m01 + this.m21 * matrix3d.m11 + this.m22 * matrix3d.m21;
        double d9 = this.m20 * matrix3d.m02 + this.m21 * matrix3d.m12 + this.m22 * matrix3d.m22;
        this.m00 = d;
        this.m01 = d2;
        this.m02 = d3;
        this.m10 = d4;
        this.m11 = d5;
        this.m12 = d6;
        this.m20 = d7;
        this.m21 = d8;
        this.m22 = d9;
    }

    public final void mul(Matrix3d matrix3d, Matrix3d matrix3d2) {
        if (this != matrix3d && this != matrix3d2) {
            this.m00 = matrix3d.m00 * matrix3d2.m00 + matrix3d.m01 * matrix3d2.m10 + matrix3d.m02 * matrix3d2.m20;
            this.m01 = matrix3d.m00 * matrix3d2.m01 + matrix3d.m01 * matrix3d2.m11 + matrix3d.m02 * matrix3d2.m21;
            this.m02 = matrix3d.m00 * matrix3d2.m02 + matrix3d.m01 * matrix3d2.m12 + matrix3d.m02 * matrix3d2.m22;
            this.m10 = matrix3d.m10 * matrix3d2.m00 + matrix3d.m11 * matrix3d2.m10 + matrix3d.m12 * matrix3d2.m20;
            this.m11 = matrix3d.m10 * matrix3d2.m01 + matrix3d.m11 * matrix3d2.m11 + matrix3d.m12 * matrix3d2.m21;
            this.m12 = matrix3d.m10 * matrix3d2.m02 + matrix3d.m11 * matrix3d2.m12 + matrix3d.m12 * matrix3d2.m22;
            this.m20 = matrix3d.m20 * matrix3d2.m00 + matrix3d.m21 * matrix3d2.m10 + matrix3d.m22 * matrix3d2.m20;
            this.m21 = matrix3d.m20 * matrix3d2.m01 + matrix3d.m21 * matrix3d2.m11 + matrix3d.m22 * matrix3d2.m21;
            this.m22 = matrix3d.m20 * matrix3d2.m02 + matrix3d.m21 * matrix3d2.m12 + matrix3d.m22 * matrix3d2.m22;
        } else {
            double d = matrix3d.m00 * matrix3d2.m00 + matrix3d.m01 * matrix3d2.m10 + matrix3d.m02 * matrix3d2.m20;
            double d2 = matrix3d.m00 * matrix3d2.m01 + matrix3d.m01 * matrix3d2.m11 + matrix3d.m02 * matrix3d2.m21;
            double d3 = matrix3d.m00 * matrix3d2.m02 + matrix3d.m01 * matrix3d2.m12 + matrix3d.m02 * matrix3d2.m22;
            double d4 = matrix3d.m10 * matrix3d2.m00 + matrix3d.m11 * matrix3d2.m10 + matrix3d.m12 * matrix3d2.m20;
            double d5 = matrix3d.m10 * matrix3d2.m01 + matrix3d.m11 * matrix3d2.m11 + matrix3d.m12 * matrix3d2.m21;
            double d6 = matrix3d.m10 * matrix3d2.m02 + matrix3d.m11 * matrix3d2.m12 + matrix3d.m12 * matrix3d2.m22;
            double d7 = matrix3d.m20 * matrix3d2.m00 + matrix3d.m21 * matrix3d2.m10 + matrix3d.m22 * matrix3d2.m20;
            double d8 = matrix3d.m20 * matrix3d2.m01 + matrix3d.m21 * matrix3d2.m11 + matrix3d.m22 * matrix3d2.m21;
            double d9 = matrix3d.m20 * matrix3d2.m02 + matrix3d.m21 * matrix3d2.m12 + matrix3d.m22 * matrix3d2.m22;
            this.m00 = d;
            this.m01 = d2;
            this.m02 = d3;
            this.m10 = d4;
            this.m11 = d5;
            this.m12 = d6;
            this.m20 = d7;
            this.m21 = d8;
            this.m22 = d9;
        }
    }

    public final void mulNormalize(Matrix3d matrix3d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[9];
        double[] dArray3 = new double[3];
        dArray[0] = this.m00 * matrix3d.m00 + this.m01 * matrix3d.m10 + this.m02 * matrix3d.m20;
        dArray[1] = this.m00 * matrix3d.m01 + this.m01 * matrix3d.m11 + this.m02 * matrix3d.m21;
        dArray[2] = this.m00 * matrix3d.m02 + this.m01 * matrix3d.m12 + this.m02 * matrix3d.m22;
        dArray[3] = this.m10 * matrix3d.m00 + this.m11 * matrix3d.m10 + this.m12 * matrix3d.m20;
        dArray[4] = this.m10 * matrix3d.m01 + this.m11 * matrix3d.m11 + this.m12 * matrix3d.m21;
        dArray[5] = this.m10 * matrix3d.m02 + this.m11 * matrix3d.m12 + this.m12 * matrix3d.m22;
        dArray[6] = this.m20 * matrix3d.m00 + this.m21 * matrix3d.m10 + this.m22 * matrix3d.m20;
        dArray[7] = this.m20 * matrix3d.m01 + this.m21 * matrix3d.m11 + this.m22 * matrix3d.m21;
        dArray[8] = this.m20 * matrix3d.m02 + this.m21 * matrix3d.m12 + this.m22 * matrix3d.m22;
        Matrix3d.compute_svd(dArray, dArray3, dArray2);
        this.m00 = dArray2[0];
        this.m01 = dArray2[1];
        this.m02 = dArray2[2];
        this.m10 = dArray2[3];
        this.m11 = dArray2[4];
        this.m12 = dArray2[5];
        this.m20 = dArray2[6];
        this.m21 = dArray2[7];
        this.m22 = dArray2[8];
    }

    public final void mulNormalize(Matrix3d matrix3d, Matrix3d matrix3d2) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[9];
        double[] dArray3 = new double[3];
        dArray[0] = matrix3d.m00 * matrix3d2.m00 + matrix3d.m01 * matrix3d2.m10 + matrix3d.m02 * matrix3d2.m20;
        dArray[1] = matrix3d.m00 * matrix3d2.m01 + matrix3d.m01 * matrix3d2.m11 + matrix3d.m02 * matrix3d2.m21;
        dArray[2] = matrix3d.m00 * matrix3d2.m02 + matrix3d.m01 * matrix3d2.m12 + matrix3d.m02 * matrix3d2.m22;
        dArray[3] = matrix3d.m10 * matrix3d2.m00 + matrix3d.m11 * matrix3d2.m10 + matrix3d.m12 * matrix3d2.m20;
        dArray[4] = matrix3d.m10 * matrix3d2.m01 + matrix3d.m11 * matrix3d2.m11 + matrix3d.m12 * matrix3d2.m21;
        dArray[5] = matrix3d.m10 * matrix3d2.m02 + matrix3d.m11 * matrix3d2.m12 + matrix3d.m12 * matrix3d2.m22;
        dArray[6] = matrix3d.m20 * matrix3d2.m00 + matrix3d.m21 * matrix3d2.m10 + matrix3d.m22 * matrix3d2.m20;
        dArray[7] = matrix3d.m20 * matrix3d2.m01 + matrix3d.m21 * matrix3d2.m11 + matrix3d.m22 * matrix3d2.m21;
        dArray[8] = matrix3d.m20 * matrix3d2.m02 + matrix3d.m21 * matrix3d2.m12 + matrix3d.m22 * matrix3d2.m22;
        Matrix3d.compute_svd(dArray, dArray3, dArray2);
        this.m00 = dArray2[0];
        this.m01 = dArray2[1];
        this.m02 = dArray2[2];
        this.m10 = dArray2[3];
        this.m11 = dArray2[4];
        this.m12 = dArray2[5];
        this.m20 = dArray2[6];
        this.m21 = dArray2[7];
        this.m22 = dArray2[8];
    }

    public final void mulTransposeBoth(Matrix3d matrix3d, Matrix3d matrix3d2) {
        if (this != matrix3d && this != matrix3d2) {
            this.m00 = matrix3d.m00 * matrix3d2.m00 + matrix3d.m10 * matrix3d2.m01 + matrix3d.m20 * matrix3d2.m02;
            this.m01 = matrix3d.m00 * matrix3d2.m10 + matrix3d.m10 * matrix3d2.m11 + matrix3d.m20 * matrix3d2.m12;
            this.m02 = matrix3d.m00 * matrix3d2.m20 + matrix3d.m10 * matrix3d2.m21 + matrix3d.m20 * matrix3d2.m22;
            this.m10 = matrix3d.m01 * matrix3d2.m00 + matrix3d.m11 * matrix3d2.m01 + matrix3d.m21 * matrix3d2.m02;
            this.m11 = matrix3d.m01 * matrix3d2.m10 + matrix3d.m11 * matrix3d2.m11 + matrix3d.m21 * matrix3d2.m12;
            this.m12 = matrix3d.m01 * matrix3d2.m20 + matrix3d.m11 * matrix3d2.m21 + matrix3d.m21 * matrix3d2.m22;
            this.m20 = matrix3d.m02 * matrix3d2.m00 + matrix3d.m12 * matrix3d2.m01 + matrix3d.m22 * matrix3d2.m02;
            this.m21 = matrix3d.m02 * matrix3d2.m10 + matrix3d.m12 * matrix3d2.m11 + matrix3d.m22 * matrix3d2.m12;
            this.m22 = matrix3d.m02 * matrix3d2.m20 + matrix3d.m12 * matrix3d2.m21 + matrix3d.m22 * matrix3d2.m22;
        } else {
            double d = matrix3d.m00 * matrix3d2.m00 + matrix3d.m10 * matrix3d2.m01 + matrix3d.m20 * matrix3d2.m02;
            double d2 = matrix3d.m00 * matrix3d2.m10 + matrix3d.m10 * matrix3d2.m11 + matrix3d.m20 * matrix3d2.m12;
            double d3 = matrix3d.m00 * matrix3d2.m20 + matrix3d.m10 * matrix3d2.m21 + matrix3d.m20 * matrix3d2.m22;
            double d4 = matrix3d.m01 * matrix3d2.m00 + matrix3d.m11 * matrix3d2.m01 + matrix3d.m21 * matrix3d2.m02;
            double d5 = matrix3d.m01 * matrix3d2.m10 + matrix3d.m11 * matrix3d2.m11 + matrix3d.m21 * matrix3d2.m12;
            double d6 = matrix3d.m01 * matrix3d2.m20 + matrix3d.m11 * matrix3d2.m21 + matrix3d.m21 * matrix3d2.m22;
            double d7 = matrix3d.m02 * matrix3d2.m00 + matrix3d.m12 * matrix3d2.m01 + matrix3d.m22 * matrix3d2.m02;
            double d8 = matrix3d.m02 * matrix3d2.m10 + matrix3d.m12 * matrix3d2.m11 + matrix3d.m22 * matrix3d2.m12;
            double d9 = matrix3d.m02 * matrix3d2.m20 + matrix3d.m12 * matrix3d2.m21 + matrix3d.m22 * matrix3d2.m22;
            this.m00 = d;
            this.m01 = d2;
            this.m02 = d3;
            this.m10 = d4;
            this.m11 = d5;
            this.m12 = d6;
            this.m20 = d7;
            this.m21 = d8;
            this.m22 = d9;
        }
    }

    public final void mulTransposeRight(Matrix3d matrix3d, Matrix3d matrix3d2) {
        if (this != matrix3d && this != matrix3d2) {
            this.m00 = matrix3d.m00 * matrix3d2.m00 + matrix3d.m01 * matrix3d2.m01 + matrix3d.m02 * matrix3d2.m02;
            this.m01 = matrix3d.m00 * matrix3d2.m10 + matrix3d.m01 * matrix3d2.m11 + matrix3d.m02 * matrix3d2.m12;
            this.m02 = matrix3d.m00 * matrix3d2.m20 + matrix3d.m01 * matrix3d2.m21 + matrix3d.m02 * matrix3d2.m22;
            this.m10 = matrix3d.m10 * matrix3d2.m00 + matrix3d.m11 * matrix3d2.m01 + matrix3d.m12 * matrix3d2.m02;
            this.m11 = matrix3d.m10 * matrix3d2.m10 + matrix3d.m11 * matrix3d2.m11 + matrix3d.m12 * matrix3d2.m12;
            this.m12 = matrix3d.m10 * matrix3d2.m20 + matrix3d.m11 * matrix3d2.m21 + matrix3d.m12 * matrix3d2.m22;
            this.m20 = matrix3d.m20 * matrix3d2.m00 + matrix3d.m21 * matrix3d2.m01 + matrix3d.m22 * matrix3d2.m02;
            this.m21 = matrix3d.m20 * matrix3d2.m10 + matrix3d.m21 * matrix3d2.m11 + matrix3d.m22 * matrix3d2.m12;
            this.m22 = matrix3d.m20 * matrix3d2.m20 + matrix3d.m21 * matrix3d2.m21 + matrix3d.m22 * matrix3d2.m22;
        } else {
            double d = matrix3d.m00 * matrix3d2.m00 + matrix3d.m01 * matrix3d2.m01 + matrix3d.m02 * matrix3d2.m02;
            double d2 = matrix3d.m00 * matrix3d2.m10 + matrix3d.m01 * matrix3d2.m11 + matrix3d.m02 * matrix3d2.m12;
            double d3 = matrix3d.m00 * matrix3d2.m20 + matrix3d.m01 * matrix3d2.m21 + matrix3d.m02 * matrix3d2.m22;
            double d4 = matrix3d.m10 * matrix3d2.m00 + matrix3d.m11 * matrix3d2.m01 + matrix3d.m12 * matrix3d2.m02;
            double d5 = matrix3d.m10 * matrix3d2.m10 + matrix3d.m11 * matrix3d2.m11 + matrix3d.m12 * matrix3d2.m12;
            double d6 = matrix3d.m10 * matrix3d2.m20 + matrix3d.m11 * matrix3d2.m21 + matrix3d.m12 * matrix3d2.m22;
            double d7 = matrix3d.m20 * matrix3d2.m00 + matrix3d.m21 * matrix3d2.m01 + matrix3d.m22 * matrix3d2.m02;
            double d8 = matrix3d.m20 * matrix3d2.m10 + matrix3d.m21 * matrix3d2.m11 + matrix3d.m22 * matrix3d2.m12;
            double d9 = matrix3d.m20 * matrix3d2.m20 + matrix3d.m21 * matrix3d2.m21 + matrix3d.m22 * matrix3d2.m22;
            this.m00 = d;
            this.m01 = d2;
            this.m02 = d3;
            this.m10 = d4;
            this.m11 = d5;
            this.m12 = d6;
            this.m20 = d7;
            this.m21 = d8;
            this.m22 = d9;
        }
    }

    public final void mulTransposeLeft(Matrix3d matrix3d, Matrix3d matrix3d2) {
        if (this != matrix3d && this != matrix3d2) {
            this.m00 = matrix3d.m00 * matrix3d2.m00 + matrix3d.m10 * matrix3d2.m10 + matrix3d.m20 * matrix3d2.m20;
            this.m01 = matrix3d.m00 * matrix3d2.m01 + matrix3d.m10 * matrix3d2.m11 + matrix3d.m20 * matrix3d2.m21;
            this.m02 = matrix3d.m00 * matrix3d2.m02 + matrix3d.m10 * matrix3d2.m12 + matrix3d.m20 * matrix3d2.m22;
            this.m10 = matrix3d.m01 * matrix3d2.m00 + matrix3d.m11 * matrix3d2.m10 + matrix3d.m21 * matrix3d2.m20;
            this.m11 = matrix3d.m01 * matrix3d2.m01 + matrix3d.m11 * matrix3d2.m11 + matrix3d.m21 * matrix3d2.m21;
            this.m12 = matrix3d.m01 * matrix3d2.m02 + matrix3d.m11 * matrix3d2.m12 + matrix3d.m21 * matrix3d2.m22;
            this.m20 = matrix3d.m02 * matrix3d2.m00 + matrix3d.m12 * matrix3d2.m10 + matrix3d.m22 * matrix3d2.m20;
            this.m21 = matrix3d.m02 * matrix3d2.m01 + matrix3d.m12 * matrix3d2.m11 + matrix3d.m22 * matrix3d2.m21;
            this.m22 = matrix3d.m02 * matrix3d2.m02 + matrix3d.m12 * matrix3d2.m12 + matrix3d.m22 * matrix3d2.m22;
        } else {
            double d = matrix3d.m00 * matrix3d2.m00 + matrix3d.m10 * matrix3d2.m10 + matrix3d.m20 * matrix3d2.m20;
            double d2 = matrix3d.m00 * matrix3d2.m01 + matrix3d.m10 * matrix3d2.m11 + matrix3d.m20 * matrix3d2.m21;
            double d3 = matrix3d.m00 * matrix3d2.m02 + matrix3d.m10 * matrix3d2.m12 + matrix3d.m20 * matrix3d2.m22;
            double d4 = matrix3d.m01 * matrix3d2.m00 + matrix3d.m11 * matrix3d2.m10 + matrix3d.m21 * matrix3d2.m20;
            double d5 = matrix3d.m01 * matrix3d2.m01 + matrix3d.m11 * matrix3d2.m11 + matrix3d.m21 * matrix3d2.m21;
            double d6 = matrix3d.m01 * matrix3d2.m02 + matrix3d.m11 * matrix3d2.m12 + matrix3d.m21 * matrix3d2.m22;
            double d7 = matrix3d.m02 * matrix3d2.m00 + matrix3d.m12 * matrix3d2.m10 + matrix3d.m22 * matrix3d2.m20;
            double d8 = matrix3d.m02 * matrix3d2.m01 + matrix3d.m12 * matrix3d2.m11 + matrix3d.m22 * matrix3d2.m21;
            double d9 = matrix3d.m02 * matrix3d2.m02 + matrix3d.m12 * matrix3d2.m12 + matrix3d.m22 * matrix3d2.m22;
            this.m00 = d;
            this.m01 = d2;
            this.m02 = d3;
            this.m10 = d4;
            this.m11 = d5;
            this.m12 = d6;
            this.m20 = d7;
            this.m21 = d8;
            this.m22 = d9;
        }
    }

    public final void normalize() {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.m00 = dArray[0];
        this.m01 = dArray[1];
        this.m02 = dArray[2];
        this.m10 = dArray[3];
        this.m11 = dArray[4];
        this.m12 = dArray[5];
        this.m20 = dArray[6];
        this.m21 = dArray[7];
        this.m22 = dArray[8];
    }

    public final void normalize(Matrix3d matrix3d) {
        double[] dArray = new double[9];
        double[] dArray2 = new double[9];
        double[] dArray3 = new double[3];
        dArray[0] = matrix3d.m00;
        dArray[1] = matrix3d.m01;
        dArray[2] = matrix3d.m02;
        dArray[3] = matrix3d.m10;
        dArray[4] = matrix3d.m11;
        dArray[5] = matrix3d.m12;
        dArray[6] = matrix3d.m20;
        dArray[7] = matrix3d.m21;
        dArray[8] = matrix3d.m22;
        Matrix3d.compute_svd(dArray, dArray3, dArray2);
        this.m00 = dArray2[0];
        this.m01 = dArray2[1];
        this.m02 = dArray2[2];
        this.m10 = dArray2[3];
        this.m11 = dArray2[4];
        this.m12 = dArray2[5];
        this.m20 = dArray2[6];
        this.m21 = dArray2[7];
        this.m22 = dArray2[8];
    }

    public final void normalizeCP() {
        double d = 1.0 / Math.sqrt(this.m00 * this.m00 + this.m10 * this.m10 + this.m20 * this.m20);
        this.m00 *= d;
        this.m10 *= d;
        this.m20 *= d;
        d = 1.0 / Math.sqrt(this.m01 * this.m01 + this.m11 * this.m11 + this.m21 * this.m21);
        this.m01 *= d;
        this.m11 *= d;
        this.m21 *= d;
        this.m02 = this.m10 * this.m21 - this.m11 * this.m20;
        this.m12 = this.m01 * this.m20 - this.m00 * this.m21;
        this.m22 = this.m00 * this.m11 - this.m01 * this.m10;
    }

    public final void normalizeCP(Matrix3d matrix3d) {
        double d = 1.0 / Math.sqrt(matrix3d.m00 * matrix3d.m00 + matrix3d.m10 * matrix3d.m10 + matrix3d.m20 * matrix3d.m20);
        this.m00 = matrix3d.m00 * d;
        this.m10 = matrix3d.m10 * d;
        this.m20 = matrix3d.m20 * d;
        d = 1.0 / Math.sqrt(matrix3d.m01 * matrix3d.m01 + matrix3d.m11 * matrix3d.m11 + matrix3d.m21 * matrix3d.m21);
        this.m01 = matrix3d.m01 * d;
        this.m11 = matrix3d.m11 * d;
        this.m21 = matrix3d.m21 * d;
        this.m02 = this.m10 * this.m21 - this.m11 * this.m20;
        this.m12 = this.m01 * this.m20 - this.m00 * this.m21;
        this.m22 = this.m00 * this.m11 - this.m01 * this.m10;
    }

    public boolean equals(Matrix3d matrix3d) {
        try {
            return this.m00 == matrix3d.m00 && this.m01 == matrix3d.m01 && this.m02 == matrix3d.m02 && this.m10 == matrix3d.m10 && this.m11 == matrix3d.m11 && this.m12 == matrix3d.m12 && this.m20 == matrix3d.m20 && this.m21 == matrix3d.m21 && this.m22 == matrix3d.m22;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Matrix3d matrix3d = (Matrix3d)object;
            return this.m00 == matrix3d.m00 && this.m01 == matrix3d.m01 && this.m02 == matrix3d.m02 && this.m10 == matrix3d.m10 && this.m11 == matrix3d.m11 && this.m12 == matrix3d.m12 && this.m20 == matrix3d.m20 && this.m21 == matrix3d.m21 && this.m22 == matrix3d.m22;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean epsilonEquals(Matrix3d matrix3d, double d) {
        double d2 = this.m00 - matrix3d.m00;
        double d3 = d2 < 0.0 ? -d2 : d2;
        if (d3 > d) {
            return false;
        }
        d2 = this.m01 - matrix3d.m01;
        double d4 = d2 < 0.0 ? -d2 : d2;
        if (d4 > d) {
            return false;
        }
        d2 = this.m02 - matrix3d.m02;
        double d5 = d2 < 0.0 ? -d2 : d2;
        if (d5 > d) {
            return false;
        }
        d2 = this.m10 - matrix3d.m10;
        double d6 = d2 < 0.0 ? -d2 : d2;
        if (d6 > d) {
            return false;
        }
        d2 = this.m11 - matrix3d.m11;
        double d7 = d2 < 0.0 ? -d2 : d2;
        if (d7 > d) {
            return false;
        }
        d2 = this.m12 - matrix3d.m12;
        double d8 = d2 < 0.0 ? -d2 : d2;
        if (d8 > d) {
            return false;
        }
        d2 = this.m20 - matrix3d.m20;
        double d9 = d2 < 0.0 ? -d2 : d2;
        if (d9 > d) {
            return false;
        }
        d2 = this.m21 - matrix3d.m21;
        double d10 = d2 < 0.0 ? -d2 : d2;
        if (d10 > d) {
            return false;
        }
        d2 = this.m22 - matrix3d.m22;
        double d11 = d2 < 0.0 ? -d2 : d2;
        return !(d11 > d);
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m00);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m01);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m02);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m10);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m11);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m12);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m20);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m21);
        l = 31L * l + VecMathUtil.doubleToLongBits(this.m22);
        return (int)(l ^ l >> 32);
    }

    public final void setZero() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
    }

    public final void negate() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;
        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
    }

    public final void negate(Matrix3d matrix3d) {
        this.m00 = -matrix3d.m00;
        this.m01 = -matrix3d.m01;
        this.m02 = -matrix3d.m02;
        this.m10 = -matrix3d.m10;
        this.m11 = -matrix3d.m11;
        this.m12 = -matrix3d.m12;
        this.m20 = -matrix3d.m20;
        this.m21 = -matrix3d.m21;
        this.m22 = -matrix3d.m22;
    }

    public final void transform(Tuple3d tuple3d) {
        double d = this.m00 * tuple3d.x + this.m01 * tuple3d.y + this.m02 * tuple3d.z;
        double d2 = this.m10 * tuple3d.x + this.m11 * tuple3d.y + this.m12 * tuple3d.z;
        double d3 = this.m20 * tuple3d.x + this.m21 * tuple3d.y + this.m22 * tuple3d.z;
        tuple3d.set(d, d2, d3);
    }

    public final void transform(Tuple3d tuple3d, Tuple3d tuple3d2) {
        double d = this.m00 * tuple3d.x + this.m01 * tuple3d.y + this.m02 * tuple3d.z;
        double d2 = this.m10 * tuple3d.x + this.m11 * tuple3d.y + this.m12 * tuple3d.z;
        tuple3d2.z = this.m20 * tuple3d.x + this.m21 * tuple3d.y + this.m22 * tuple3d.z;
        tuple3d2.x = d;
        tuple3d2.y = d2;
    }

    final void getScaleRotate(double[] dArray, double[] dArray2) {
        double[] dArray3 = new double[]{this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22};
        Matrix3d.compute_svd(dArray3, dArray, dArray2);
    }

    static void compute_svd(double[] dArray, double[] dArray2, double[] dArray3) {
        double d;
        int n;
        double[] dArray4 = new double[9];
        double[] dArray5 = new double[9];
        double[] dArray6 = new double[9];
        double[] dArray7 = new double[9];
        double[] dArray8 = dArray6;
        double[] dArray9 = dArray7;
        double[] dArray10 = new double[9];
        double[] dArray11 = new double[3];
        double[] dArray12 = new double[3];
        int n2 = 0;
        for (n = 0; n < 9; ++n) {
            dArray10[n] = dArray[n];
        }
        if (dArray[3] * dArray[3] < 1.110223024E-16) {
            dArray4[0] = 1.0;
            dArray4[1] = 0.0;
            dArray4[2] = 0.0;
            dArray4[3] = 0.0;
            dArray4[4] = 1.0;
            dArray4[5] = 0.0;
            dArray4[6] = 0.0;
            dArray4[7] = 0.0;
            dArray4[8] = 1.0;
        } else if (dArray[0] * dArray[0] < 1.110223024E-16) {
            dArray8[0] = dArray[0];
            dArray8[1] = dArray[1];
            dArray8[2] = dArray[2];
            dArray[0] = dArray[3];
            dArray[1] = dArray[4];
            dArray[2] = dArray[5];
            dArray[3] = -dArray8[0];
            dArray[4] = -dArray8[1];
            dArray[5] = -dArray8[2];
            dArray4[0] = 0.0;
            dArray4[1] = 1.0;
            dArray4[2] = 0.0;
            dArray4[3] = -1.0;
            dArray4[4] = 0.0;
            dArray4[5] = 0.0;
            dArray4[6] = 0.0;
            dArray4[7] = 0.0;
            dArray4[8] = 1.0;
        } else {
            d = 1.0 / Math.sqrt(dArray[0] * dArray[0] + dArray[3] * dArray[3]);
            double d2 = dArray[0] * d;
            double d3 = dArray[3] * d;
            dArray8[0] = d2 * dArray[0] + d3 * dArray[3];
            dArray8[1] = d2 * dArray[1] + d3 * dArray[4];
            dArray8[2] = d2 * dArray[2] + d3 * dArray[5];
            dArray[3] = -d3 * dArray[0] + d2 * dArray[3];
            dArray[4] = -d3 * dArray[1] + d2 * dArray[4];
            dArray[5] = -d3 * dArray[2] + d2 * dArray[5];
            dArray[0] = dArray8[0];
            dArray[1] = dArray8[1];
            dArray[2] = dArray8[2];
            dArray4[0] = d2;
            dArray4[1] = d3;
            dArray4[2] = 0.0;
            dArray4[3] = -d3;
            dArray4[4] = d2;
            dArray4[5] = 0.0;
            dArray4[6] = 0.0;
            dArray4[7] = 0.0;
            dArray4[8] = 1.0;
        }
        if (!(dArray[6] * dArray[6] < 1.110223024E-16)) {
            if (dArray[0] * dArray[0] < 1.110223024E-16) {
                dArray8[0] = dArray[0];
                dArray8[1] = dArray[1];
                dArray8[2] = dArray[2];
                dArray[0] = dArray[6];
                dArray[1] = dArray[7];
                dArray[2] = dArray[8];
                dArray[6] = -dArray8[0];
                dArray[7] = -dArray8[1];
                dArray[8] = -dArray8[2];
                dArray8[0] = dArray4[0];
                dArray8[1] = dArray4[1];
                dArray8[2] = dArray4[2];
                dArray4[0] = dArray4[6];
                dArray4[1] = dArray4[7];
                dArray4[2] = dArray4[8];
                dArray4[6] = -dArray8[0];
                dArray4[7] = -dArray8[1];
                dArray4[8] = -dArray8[2];
            } else {
                d = 1.0 / Math.sqrt(dArray[0] * dArray[0] + dArray[6] * dArray[6]);
                double d4 = dArray[0] * d;
                double d5 = dArray[6] * d;
                dArray8[0] = d4 * dArray[0] + d5 * dArray[6];
                dArray8[1] = d4 * dArray[1] + d5 * dArray[7];
                dArray8[2] = d4 * dArray[2] + d5 * dArray[8];
                dArray[6] = -d5 * dArray[0] + d4 * dArray[6];
                dArray[7] = -d5 * dArray[1] + d4 * dArray[7];
                dArray[8] = -d5 * dArray[2] + d4 * dArray[8];
                dArray[0] = dArray8[0];
                dArray[1] = dArray8[1];
                dArray[2] = dArray8[2];
                dArray8[0] = d4 * dArray4[0];
                dArray8[1] = d4 * dArray4[1];
                dArray4[2] = d5;
                dArray8[6] = -dArray4[0] * d5;
                dArray8[7] = -dArray4[1] * d5;
                dArray4[8] = d4;
                dArray4[0] = dArray8[0];
                dArray4[1] = dArray8[1];
                dArray4[6] = dArray8[6];
                dArray4[7] = dArray8[7];
            }
        }
        if (dArray[2] * dArray[2] < 1.110223024E-16) {
            dArray5[0] = 1.0;
            dArray5[1] = 0.0;
            dArray5[2] = 0.0;
            dArray5[3] = 0.0;
            dArray5[4] = 1.0;
            dArray5[5] = 0.0;
            dArray5[6] = 0.0;
            dArray5[7] = 0.0;
            dArray5[8] = 1.0;
        } else if (dArray[1] * dArray[1] < 1.110223024E-16) {
            dArray8[2] = dArray[2];
            dArray8[5] = dArray[5];
            dArray8[8] = dArray[8];
            dArray[2] = -dArray[1];
            dArray[5] = -dArray[4];
            dArray[8] = -dArray[7];
            dArray[1] = dArray8[2];
            dArray[4] = dArray8[5];
            dArray[7] = dArray8[8];
            dArray5[0] = 1.0;
            dArray5[1] = 0.0;
            dArray5[2] = 0.0;
            dArray5[3] = 0.0;
            dArray5[4] = 0.0;
            dArray5[5] = -1.0;
            dArray5[6] = 0.0;
            dArray5[7] = 1.0;
            dArray5[8] = 0.0;
        } else {
            d = 1.0 / Math.sqrt(dArray[1] * dArray[1] + dArray[2] * dArray[2]);
            double d6 = dArray[1] * d;
            double d7 = dArray[2] * d;
            dArray8[1] = d6 * dArray[1] + d7 * dArray[2];
            dArray[2] = -d7 * dArray[1] + d6 * dArray[2];
            dArray[1] = dArray8[1];
            dArray8[4] = d6 * dArray[4] + d7 * dArray[5];
            dArray[5] = -d7 * dArray[4] + d6 * dArray[5];
            dArray[4] = dArray8[4];
            dArray8[7] = d6 * dArray[7] + d7 * dArray[8];
            dArray[8] = -d7 * dArray[7] + d6 * dArray[8];
            dArray[7] = dArray8[7];
            dArray5[0] = 1.0;
            dArray5[1] = 0.0;
            dArray5[2] = 0.0;
            dArray5[3] = 0.0;
            dArray5[4] = d6;
            dArray5[5] = -d7;
            dArray5[6] = 0.0;
            dArray5[7] = d7;
            dArray5[8] = d6;
        }
        if (!(dArray[7] * dArray[7] < 1.110223024E-16)) {
            if (dArray[4] * dArray[4] < 1.110223024E-16) {
                dArray8[3] = dArray[3];
                dArray8[4] = dArray[4];
                dArray8[5] = dArray[5];
                dArray[3] = dArray[6];
                dArray[4] = dArray[7];
                dArray[5] = dArray[8];
                dArray[6] = -dArray8[3];
                dArray[7] = -dArray8[4];
                dArray[8] = -dArray8[5];
                dArray8[3] = dArray4[3];
                dArray8[4] = dArray4[4];
                dArray8[5] = dArray4[5];
                dArray4[3] = dArray4[6];
                dArray4[4] = dArray4[7];
                dArray4[5] = dArray4[8];
                dArray4[6] = -dArray8[3];
                dArray4[7] = -dArray8[4];
                dArray4[8] = -dArray8[5];
            } else {
                d = 1.0 / Math.sqrt(dArray[4] * dArray[4] + dArray[7] * dArray[7]);
                double d8 = dArray[4] * d;
                double d9 = dArray[7] * d;
                dArray8[3] = d8 * dArray[3] + d9 * dArray[6];
                dArray[6] = -d9 * dArray[3] + d8 * dArray[6];
                dArray[3] = dArray8[3];
                dArray8[4] = d8 * dArray[4] + d9 * dArray[7];
                dArray[7] = -d9 * dArray[4] + d8 * dArray[7];
                dArray[4] = dArray8[4];
                dArray8[5] = d8 * dArray[5] + d9 * dArray[8];
                dArray[8] = -d9 * dArray[5] + d8 * dArray[8];
                dArray[5] = dArray8[5];
                dArray8[3] = d8 * dArray4[3] + d9 * dArray4[6];
                dArray4[6] = -d9 * dArray4[3] + d8 * dArray4[6];
                dArray4[3] = dArray8[3];
                dArray8[4] = d8 * dArray4[4] + d9 * dArray4[7];
                dArray4[7] = -d9 * dArray4[4] + d8 * dArray4[7];
                dArray4[4] = dArray8[4];
                dArray8[5] = d8 * dArray4[5] + d9 * dArray4[8];
                dArray4[8] = -d9 * dArray4[5] + d8 * dArray4[8];
                dArray4[5] = dArray8[5];
            }
        }
        dArray9[0] = dArray[0];
        dArray9[1] = dArray[4];
        dArray9[2] = dArray[8];
        dArray11[0] = dArray[1];
        dArray11[1] = dArray[5];
        if (!(dArray11[0] * dArray11[0] < 1.110223024E-16) || !(dArray11[1] * dArray11[1] < 1.110223024E-16)) {
            Matrix3d.compute_qr(dArray9, dArray11, dArray4, dArray5);
        }
        dArray12[0] = dArray9[0];
        dArray12[1] = dArray9[1];
        dArray12[2] = dArray9[2];
        if (Matrix3d.almostEqual(Math.abs(dArray12[0]), 1.0) && Matrix3d.almostEqual(Math.abs(dArray12[1]), 1.0) && Matrix3d.almostEqual(Math.abs(dArray12[2]), 1.0)) {
            for (n = 0; n < 3; ++n) {
                if (!(dArray12[n] < 0.0)) continue;
                ++n2;
            }
            if (n2 == 0 || n2 == 2) {
                dArray2[2] = 1.0;
                dArray2[1] = 1.0;
                dArray2[0] = 1.0;
                for (n = 0; n < 9; ++n) {
                    dArray3[n] = dArray10[n];
                }
                return;
            }
        }
        Matrix3d.transpose_mat(dArray4, dArray6);
        Matrix3d.transpose_mat(dArray5, dArray7);
        Matrix3d.svdReorder(dArray, dArray6, dArray7, dArray12, dArray3, dArray2);
    }

    static void svdReorder(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, double[] dArray5, double[] dArray6) {
        int[] nArray = new int[3];
        int[] nArray2 = new int[3];
        double[] dArray7 = new double[3];
        double[] dArray8 = new double[9];
        if (dArray4[0] < 0.0) {
            dArray4[0] = -dArray4[0];
            dArray3[0] = -dArray3[0];
            dArray3[1] = -dArray3[1];
            dArray3[2] = -dArray3[2];
        }
        if (dArray4[1] < 0.0) {
            dArray4[1] = -dArray4[1];
            dArray3[3] = -dArray3[3];
            dArray3[4] = -dArray3[4];
            dArray3[5] = -dArray3[5];
        }
        if (dArray4[2] < 0.0) {
            dArray4[2] = -dArray4[2];
            dArray3[6] = -dArray3[6];
            dArray3[7] = -dArray3[7];
            dArray3[8] = -dArray3[8];
        }
        Matrix3d.mat_mul(dArray2, dArray3, dArray8);
        if (Matrix3d.almostEqual(Math.abs(dArray4[0]), Math.abs(dArray4[1])) && Matrix3d.almostEqual(Math.abs(dArray4[1]), Math.abs(dArray4[2]))) {
            int n;
            for (n = 0; n < 9; ++n) {
                dArray5[n] = dArray8[n];
            }
            for (n = 0; n < 3; ++n) {
                dArray6[n] = dArray4[n];
            }
        } else {
            int n;
            int n2;
            int n3;
            if (dArray4[0] > dArray4[1]) {
                if (dArray4[0] > dArray4[2]) {
                    if (dArray4[2] > dArray4[1]) {
                        nArray[0] = 0;
                        nArray[1] = 2;
                        nArray[2] = 1;
                    } else {
                        nArray[0] = 0;
                        nArray[1] = 1;
                        nArray[2] = 2;
                    }
                } else {
                    nArray[0] = 2;
                    nArray[1] = 0;
                    nArray[2] = 1;
                }
            } else if (dArray4[1] > dArray4[2]) {
                if (dArray4[2] > dArray4[0]) {
                    nArray[0] = 1;
                    nArray[1] = 2;
                    nArray[2] = 0;
                } else {
                    nArray[0] = 1;
                    nArray[1] = 0;
                    nArray[2] = 2;
                }
            } else {
                nArray[0] = 2;
                nArray[1] = 1;
                nArray[2] = 0;
            }
            dArray7[0] = dArray[0] * dArray[0] + dArray[1] * dArray[1] + dArray[2] * dArray[2];
            dArray7[1] = dArray[3] * dArray[3] + dArray[4] * dArray[4] + dArray[5] * dArray[5];
            dArray7[2] = dArray[6] * dArray[6] + dArray[7] * dArray[7] + dArray[8] * dArray[8];
            if (dArray7[0] > dArray7[1]) {
                if (dArray7[0] > dArray7[2]) {
                    if (dArray7[2] > dArray7[1]) {
                        n3 = 0;
                        n2 = 1;
                        n = 2;
                    } else {
                        n3 = 0;
                        n = 1;
                        n2 = 2;
                    }
                } else {
                    n2 = 0;
                    n3 = 1;
                    n = 2;
                }
            } else if (dArray7[1] > dArray7[2]) {
                if (dArray7[2] > dArray7[0]) {
                    n = 0;
                    n2 = 1;
                    n3 = 2;
                } else {
                    n = 0;
                    n3 = 1;
                    n2 = 2;
                }
            } else {
                n2 = 0;
                n = 1;
                n3 = 2;
            }
            int n4 = nArray[n3];
            dArray6[0] = dArray4[n4];
            n4 = nArray[n];
            dArray6[1] = dArray4[n4];
            n4 = nArray[n2];
            dArray6[2] = dArray4[n4];
            n4 = nArray[n3];
            dArray5[0] = dArray8[n4];
            n4 = nArray[n3] + 3;
            dArray5[3] = dArray8[n4];
            n4 = nArray[n3] + 6;
            dArray5[6] = dArray8[n4];
            n4 = nArray[n];
            dArray5[1] = dArray8[n4];
            n4 = nArray[n] + 3;
            dArray5[4] = dArray8[n4];
            n4 = nArray[n] + 6;
            dArray5[7] = dArray8[n4];
            n4 = nArray[n2];
            dArray5[2] = dArray8[n4];
            n4 = nArray[n2] + 3;
            dArray5[5] = dArray8[n4];
            n4 = nArray[n2] + 6;
            dArray5[8] = dArray8[n4];
        }
    }

    static int compute_qr(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4) {
        double d;
        double d2;
        double[] dArray5 = new double[2];
        double[] dArray6 = new double[2];
        double[] dArray7 = new double[2];
        double[] dArray8 = new double[2];
        double[] dArray9 = new double[9];
        double d3 = 1.0;
        double d4 = -1.0;
        boolean bl = false;
        int n = 1;
        if (Math.abs(dArray2[1]) < 4.89E-15 || Math.abs(dArray2[0]) < 4.89E-15) {
            bl = true;
        }
        for (int i = 0; i < 10 && !bl; ++i) {
            double d5 = Matrix3d.compute_shift(dArray[1], dArray2[1], dArray[2]);
            double d6 = (Math.abs(dArray[0]) - d5) * (Matrix3d.d_sign(d3, dArray[0]) + d5 / dArray[0]);
            double d7 = dArray2[0];
            double d8 = Matrix3d.compute_rot(d6, d7, dArray8, dArray6, 0, n);
            d6 = dArray6[0] * dArray[0] + dArray8[0] * dArray2[0];
            dArray2[0] = dArray6[0] * dArray2[0] - dArray8[0] * dArray[0];
            d7 = dArray8[0] * dArray[1];
            dArray[1] = dArray6[0] * dArray[1];
            d8 = Matrix3d.compute_rot(d6, d7, dArray7, dArray5, 0, n);
            n = 0;
            dArray[0] = d8;
            d6 = dArray5[0] * dArray2[0] + dArray7[0] * dArray[1];
            dArray[1] = dArray5[0] * dArray[1] - dArray7[0] * dArray2[0];
            d7 = dArray7[0] * dArray2[1];
            dArray2[1] = dArray5[0] * dArray2[1];
            dArray2[0] = d8 = Matrix3d.compute_rot(d6, d7, dArray8, dArray6, 1, n);
            d6 = dArray6[1] * dArray[1] + dArray8[1] * dArray2[1];
            dArray2[1] = dArray6[1] * dArray2[1] - dArray8[1] * dArray[1];
            d7 = dArray8[1] * dArray[2];
            dArray[2] = dArray6[1] * dArray[2];
            dArray[1] = d8 = Matrix3d.compute_rot(d6, d7, dArray7, dArray5, 1, n);
            d6 = dArray5[1] * dArray2[1] + dArray7[1] * dArray[2];
            dArray[2] = dArray5[1] * dArray[2] - dArray7[1] * dArray2[1];
            dArray2[1] = d6;
            d2 = dArray3[0];
            dArray3[0] = dArray5[0] * d2 + dArray7[0] * dArray3[3];
            dArray3[3] = -dArray7[0] * d2 + dArray5[0] * dArray3[3];
            d2 = dArray3[1];
            dArray3[1] = dArray5[0] * d2 + dArray7[0] * dArray3[4];
            dArray3[4] = -dArray7[0] * d2 + dArray5[0] * dArray3[4];
            d2 = dArray3[2];
            dArray3[2] = dArray5[0] * d2 + dArray7[0] * dArray3[5];
            dArray3[5] = -dArray7[0] * d2 + dArray5[0] * dArray3[5];
            d2 = dArray3[3];
            dArray3[3] = dArray5[1] * d2 + dArray7[1] * dArray3[6];
            dArray3[6] = -dArray7[1] * d2 + dArray5[1] * dArray3[6];
            d2 = dArray3[4];
            dArray3[4] = dArray5[1] * d2 + dArray7[1] * dArray3[7];
            dArray3[7] = -dArray7[1] * d2 + dArray5[1] * dArray3[7];
            d2 = dArray3[5];
            dArray3[5] = dArray5[1] * d2 + dArray7[1] * dArray3[8];
            dArray3[8] = -dArray7[1] * d2 + dArray5[1] * dArray3[8];
            d = dArray4[0];
            dArray4[0] = dArray6[0] * d + dArray8[0] * dArray4[1];
            dArray4[1] = -dArray8[0] * d + dArray6[0] * dArray4[1];
            d = dArray4[3];
            dArray4[3] = dArray6[0] * d + dArray8[0] * dArray4[4];
            dArray4[4] = -dArray8[0] * d + dArray6[0] * dArray4[4];
            d = dArray4[6];
            dArray4[6] = dArray6[0] * d + dArray8[0] * dArray4[7];
            dArray4[7] = -dArray8[0] * d + dArray6[0] * dArray4[7];
            d = dArray4[1];
            dArray4[1] = dArray6[1] * d + dArray8[1] * dArray4[2];
            dArray4[2] = -dArray8[1] * d + dArray6[1] * dArray4[2];
            d = dArray4[4];
            dArray4[4] = dArray6[1] * d + dArray8[1] * dArray4[5];
            dArray4[5] = -dArray8[1] * d + dArray6[1] * dArray4[5];
            d = dArray4[7];
            dArray4[7] = dArray6[1] * d + dArray8[1] * dArray4[8];
            dArray4[8] = -dArray8[1] * d + dArray6[1] * dArray4[8];
            dArray9[0] = dArray[0];
            dArray9[1] = dArray2[0];
            dArray9[2] = 0.0;
            dArray9[3] = 0.0;
            dArray9[4] = dArray[1];
            dArray9[5] = dArray2[1];
            dArray9[6] = 0.0;
            dArray9[7] = 0.0;
            dArray9[8] = dArray[2];
            if (!(Math.abs(dArray2[1]) < 4.89E-15) && !(Math.abs(dArray2[0]) < 4.89E-15)) continue;
            bl = true;
        }
        if (Math.abs(dArray2[1]) < 4.89E-15) {
            Matrix3d.compute_2X2(dArray[0], dArray2[0], dArray[1], dArray, dArray7, dArray5, dArray8, dArray6, 0);
            d2 = dArray3[0];
            dArray3[0] = dArray5[0] * d2 + dArray7[0] * dArray3[3];
            dArray3[3] = -dArray7[0] * d2 + dArray5[0] * dArray3[3];
            d2 = dArray3[1];
            dArray3[1] = dArray5[0] * d2 + dArray7[0] * dArray3[4];
            dArray3[4] = -dArray7[0] * d2 + dArray5[0] * dArray3[4];
            d2 = dArray3[2];
            dArray3[2] = dArray5[0] * d2 + dArray7[0] * dArray3[5];
            dArray3[5] = -dArray7[0] * d2 + dArray5[0] * dArray3[5];
            d = dArray4[0];
            dArray4[0] = dArray6[0] * d + dArray8[0] * dArray4[1];
            dArray4[1] = -dArray8[0] * d + dArray6[0] * dArray4[1];
            d = dArray4[3];
            dArray4[3] = dArray6[0] * d + dArray8[0] * dArray4[4];
            dArray4[4] = -dArray8[0] * d + dArray6[0] * dArray4[4];
            d = dArray4[6];
            dArray4[6] = dArray6[0] * d + dArray8[0] * dArray4[7];
            dArray4[7] = -dArray8[0] * d + dArray6[0] * dArray4[7];
        } else {
            Matrix3d.compute_2X2(dArray[1], dArray2[1], dArray[2], dArray, dArray7, dArray5, dArray8, dArray6, 1);
            d2 = dArray3[3];
            dArray3[3] = dArray5[0] * d2 + dArray7[0] * dArray3[6];
            dArray3[6] = -dArray7[0] * d2 + dArray5[0] * dArray3[6];
            d2 = dArray3[4];
            dArray3[4] = dArray5[0] * d2 + dArray7[0] * dArray3[7];
            dArray3[7] = -dArray7[0] * d2 + dArray5[0] * dArray3[7];
            d2 = dArray3[5];
            dArray3[5] = dArray5[0] * d2 + dArray7[0] * dArray3[8];
            dArray3[8] = -dArray7[0] * d2 + dArray5[0] * dArray3[8];
            d = dArray4[1];
            dArray4[1] = dArray6[0] * d + dArray8[0] * dArray4[2];
            dArray4[2] = -dArray8[0] * d + dArray6[0] * dArray4[2];
            d = dArray4[4];
            dArray4[4] = dArray6[0] * d + dArray8[0] * dArray4[5];
            dArray4[5] = -dArray8[0] * d + dArray6[0] * dArray4[5];
            d = dArray4[7];
            dArray4[7] = dArray6[0] * d + dArray8[0] * dArray4[8];
            dArray4[8] = -dArray8[0] * d + dArray6[0] * dArray4[8];
        }
        return 0;
    }

    static double max(double d, double d2) {
        if (d > d2) {
            return d;
        }
        return d2;
    }

    static double min(double d, double d2) {
        if (d < d2) {
            return d;
        }
        return d2;
    }

    static double d_sign(double d, double d2) {
        double d3 = d >= 0.0 ? d : -d;
        return d2 >= 0.0 ? d3 : -d3;
    }

    static double compute_shift(double d, double d2, double d3) {
        double d4;
        double d5 = Math.abs(d);
        double d6 = Math.abs(d2);
        double d7 = Math.abs(d3);
        double d8 = Matrix3d.min(d5, d7);
        double d9 = Matrix3d.max(d5, d7);
        if (d8 == 0.0) {
            d4 = 0.0;
            if (d9 != 0.0) {
                double d10 = Matrix3d.min(d9, d6) / Matrix3d.max(d9, d6);
            }
        } else if (d6 < d9) {
            double d11 = d8 / d9 + 1.0;
            double d12 = (d9 - d8) / d9;
            double d13 = d6 / d9;
            double d14 = d13 * d13;
            double d15 = 2.0 / (Math.sqrt(d11 * d11 + d14) + Math.sqrt(d12 * d12 + d14));
            d4 = d8 * d15;
        } else {
            double d16 = d9 / d6;
            if (d16 == 0.0) {
                d4 = d8 * d9 / d6;
            } else {
                double d17 = d8 / d9 + 1.0;
                double d18 = (d9 - d8) / d9;
                double d19 = d17 * d16;
                double d20 = d18 * d16;
                double d21 = 1.0 / (Math.sqrt(d19 * d19 + 1.0) + Math.sqrt(d20 * d20 + 1.0));
                d4 = d8 * d21 * d16;
                d4 += d4;
            }
        }
        return d4;
    }

    static int compute_2X2(double d, double d2, double d3, double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, double[] dArray5, int n) {
        double d4;
        double d5;
        double d6 = 2.0;
        double d7 = 1.0;
        double d8 = dArray[0];
        double d9 = dArray[1];
        double d10 = 0.0;
        double d11 = 0.0;
        double d12 = 0.0;
        double d13 = 0.0;
        double d14 = 0.0;
        double d15 = d;
        double d16 = Math.abs(d15);
        double d17 = d3;
        double d18 = Math.abs(d3);
        int n2 = 1;
        boolean bl = d18 > d16;
        if (bl) {
            n2 = 3;
            double d19 = d15;
            d15 = d17;
            d17 = d19;
            d19 = d16;
            d16 = d18;
            d18 = d19;
        }
        if ((d5 = Math.abs(d4 = d2)) == 0.0) {
            dArray[1] = d18;
            dArray[0] = d16;
            d10 = 1.0;
            d11 = 1.0;
            d12 = 0.0;
            d13 = 0.0;
        } else {
            boolean bl2 = true;
            if (d5 > d16) {
                n2 = 2;
                if (d16 / d5 < 1.110223024E-16) {
                    bl2 = false;
                    d8 = d5;
                    d9 = d18 > 1.0 ? d16 / (d5 / d18) : d16 / d5 * d18;
                    d10 = 1.0;
                    d12 = d17 / d4;
                    d13 = 1.0;
                    d11 = d15 / d4;
                }
            }
            if (bl2) {
                double d20 = d16 - d18;
                double d21 = d20 == d16 ? 1.0 : d20 / d16;
                double d22 = d4 / d15;
                double d23 = 2.0 - d21;
                double d24 = d22 * d22;
                double d25 = d23 * d23;
                double d26 = Math.sqrt(d25 + d24);
                double d27 = d21 == 0.0 ? Math.abs(d22) : Math.sqrt(d21 * d21 + d24);
                double d28 = (d26 + d27) * 0.5;
                if (d5 > d16) {
                    n2 = 2;
                    if (d16 / d5 < 1.110223024E-16) {
                        bl2 = false;
                        d8 = d5;
                        d9 = d18 > 1.0 ? d16 / (d5 / d18) : d16 / d5 * d18;
                        d10 = 1.0;
                        d12 = d17 / d4;
                        d13 = 1.0;
                        d11 = d15 / d4;
                    }
                }
                if (bl2) {
                    d20 = d16 - d18;
                    d21 = d20 == d16 ? 1.0 : d20 / d16;
                    d22 = d4 / d15;
                    d23 = 2.0 - d21;
                    d24 = d22 * d22;
                    d25 = d23 * d23;
                    d26 = Math.sqrt(d25 + d24);
                    d27 = d21 == 0.0 ? Math.abs(d22) : Math.sqrt(d21 * d21 + d24);
                    d28 = (d26 + d27) * 0.5;
                    d9 = d18 / d28;
                    d8 = d16 * d28;
                    d23 = d24 == 0.0 ? (d21 == 0.0 ? Matrix3d.d_sign(d6, d15) * Matrix3d.d_sign(d7, d4) : d4 / Matrix3d.d_sign(d20, d15) + d22 / d23) : (d22 / (d26 + d23) + d22 / (d27 + d21)) * (d28 + 1.0);
                    d21 = Math.sqrt(d23 * d23 + 4.0);
                    d11 = 2.0 / d21;
                    d13 = d23 / d21;
                    d10 = (d11 + d13 * d22) / d28;
                    d12 = d17 / d15 * d13 / d28;
                }
            }
            if (bl) {
                dArray3[0] = d13;
                dArray2[0] = d11;
                dArray5[0] = d12;
                dArray4[0] = d10;
            } else {
                dArray3[0] = d10;
                dArray2[0] = d12;
                dArray5[0] = d11;
                dArray4[0] = d13;
            }
            if (n2 == 1) {
                d14 = Matrix3d.d_sign(d7, dArray5[0]) * Matrix3d.d_sign(d7, dArray3[0]) * Matrix3d.d_sign(d7, d);
            }
            if (n2 == 2) {
                d14 = Matrix3d.d_sign(d7, dArray4[0]) * Matrix3d.d_sign(d7, dArray3[0]) * Matrix3d.d_sign(d7, d2);
            }
            if (n2 == 3) {
                d14 = Matrix3d.d_sign(d7, dArray4[0]) * Matrix3d.d_sign(d7, dArray2[0]) * Matrix3d.d_sign(d7, d3);
            }
            dArray[n] = Matrix3d.d_sign(d8, d14);
            double d29 = d14 * Matrix3d.d_sign(d7, d) * Matrix3d.d_sign(d7, d3);
            dArray[n + 1] = Matrix3d.d_sign(d9, d29);
        }
        return 0;
    }

    static double compute_rot(double d, double d2, double[] dArray, double[] dArray2, int n, int n2) {
        double d3;
        double d4;
        double d5;
        if (d2 == 0.0) {
            d5 = 1.0;
            d4 = 0.0;
            d3 = d;
        } else if (d == 0.0) {
            d5 = 0.0;
            d4 = 1.0;
            d3 = d2;
        } else {
            double d6 = d;
            double d7 = d2;
            double d8 = Matrix3d.max(Math.abs(d6), Math.abs(d7));
            if (d8 >= 4.9947976805055876E145) {
                int n3 = 0;
                while (d8 >= 4.9947976805055876E145) {
                    ++n3;
                    d8 = Matrix3d.max(Math.abs(d6 *= 2.002083095183101E-146), Math.abs(d7 *= 2.002083095183101E-146));
                }
                d3 = Math.sqrt(d6 * d6 + d7 * d7);
                d5 = d6 / d3;
                d4 = d7 / d3;
                int n4 = n3;
                for (int i = 1; i <= n3; ++i) {
                    d3 *= 4.9947976805055876E145;
                }
            } else if (d8 <= 2.002083095183101E-146) {
                int n5 = 0;
                while (d8 <= 2.002083095183101E-146) {
                    ++n5;
                    d8 = Matrix3d.max(Math.abs(d6 *= 4.9947976805055876E145), Math.abs(d7 *= 4.9947976805055876E145));
                }
                d3 = Math.sqrt(d6 * d6 + d7 * d7);
                d5 = d6 / d3;
                d4 = d7 / d3;
                int n6 = n5;
                for (int i = 1; i <= n5; ++i) {
                    d3 *= 2.002083095183101E-146;
                }
            } else {
                d3 = Math.sqrt(d6 * d6 + d7 * d7);
                d5 = d6 / d3;
                d4 = d7 / d3;
            }
            if (Math.abs(d) > Math.abs(d2) && d5 < 0.0) {
                d5 = -d5;
                d4 = -d4;
                d3 = -d3;
            }
        }
        dArray[n] = d4;
        dArray2[n] = d5;
        return d3;
    }

    static void print_mat(double[] dArray) {
        for (int i = 0; i < 3; ++i) {
            System.out.println(dArray[i * 3 + 0] + " " + dArray[i * 3 + 1] + " " + dArray[i * 3 + 2] + "\n");
        }
    }

    static void print_det(double[] dArray) {
        double d = dArray[0] * dArray[4] * dArray[8] + dArray[1] * dArray[5] * dArray[6] + dArray[2] * dArray[3] * dArray[7] - dArray[2] * dArray[4] * dArray[6] - dArray[0] * dArray[5] * dArray[7] - dArray[1] * dArray[3] * dArray[8];
        System.out.println("det= " + d);
    }

    static void mat_mul(double[] dArray, double[] dArray2, double[] dArray3) {
        double[] dArray4 = new double[]{dArray[0] * dArray2[0] + dArray[1] * dArray2[3] + dArray[2] * dArray2[6], dArray[0] * dArray2[1] + dArray[1] * dArray2[4] + dArray[2] * dArray2[7], dArray[0] * dArray2[2] + dArray[1] * dArray2[5] + dArray[2] * dArray2[8], dArray[3] * dArray2[0] + dArray[4] * dArray2[3] + dArray[5] * dArray2[6], dArray[3] * dArray2[1] + dArray[4] * dArray2[4] + dArray[5] * dArray2[7], dArray[3] * dArray2[2] + dArray[4] * dArray2[5] + dArray[5] * dArray2[8], dArray[6] * dArray2[0] + dArray[7] * dArray2[3] + dArray[8] * dArray2[6], dArray[6] * dArray2[1] + dArray[7] * dArray2[4] + dArray[8] * dArray2[7], dArray[6] * dArray2[2] + dArray[7] * dArray2[5] + dArray[8] * dArray2[8]};
        for (int i = 0; i < 9; ++i) {
            dArray3[i] = dArray4[i];
        }
    }

    static void transpose_mat(double[] dArray, double[] dArray2) {
        dArray2[0] = dArray[0];
        dArray2[1] = dArray[3];
        dArray2[2] = dArray[6];
        dArray2[3] = dArray[1];
        dArray2[4] = dArray[4];
        dArray2[5] = dArray[7];
        dArray2[6] = dArray[2];
        dArray2[7] = dArray[5];
        dArray2[8] = dArray[8];
    }

    static double max3(double[] dArray) {
        if (dArray[0] > dArray[1]) {
            if (dArray[0] > dArray[2]) {
                return dArray[0];
            }
            return dArray[2];
        }
        if (dArray[1] > dArray[2]) {
            return dArray[1];
        }
        return dArray[2];
    }

    private static final boolean almostEqual(double d, double d2) {
        double d3;
        double d4;
        if (d == d2) {
            return true;
        }
        double d5 = Math.abs(d - d2);
        double d6 = Math.abs(d);
        double d7 = d4 = d6 >= (d3 = Math.abs(d2)) ? d6 : d3;
        if (d5 < 1.0E-6) {
            return true;
        }
        return d5 / d4 < 1.0E-4;
    }

    public Object clone() {
        Matrix3d matrix3d = null;
        try {
            matrix3d = (Matrix3d)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        return matrix3d;
    }
}


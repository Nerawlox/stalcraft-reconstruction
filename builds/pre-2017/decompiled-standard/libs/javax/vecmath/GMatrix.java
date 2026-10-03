/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.GVector;
import javax.vecmath.Matrix3d;
import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4d;
import javax.vecmath.Matrix4f;
import javax.vecmath.MismatchedSizeException;
import javax.vecmath.SingularMatrixException;
import javax.vecmath.VecMathI18N;
import javax.vecmath.VecMathUtil;

public class GMatrix
implements Serializable,
Cloneable {
    static final long serialVersionUID = 2777097312029690941L;
    private static final boolean debug = false;
    int nRow;
    int nCol;
    double[][] values;
    private static final double EPS = 1.0E-10;

    public GMatrix(int n, int n2) {
        int n3;
        this.values = new double[n][n2];
        this.nRow = n;
        this.nCol = n2;
        for (n3 = 0; n3 < n; ++n3) {
            for (int i = 0; i < n2; ++i) {
                this.values[n3][i] = 0.0;
            }
        }
        int n4 = n < n2 ? n : n2;
        for (n3 = 0; n3 < n4; ++n3) {
            this.values[n3][n3] = 1.0;
        }
    }

    public GMatrix(int n, int n2, double[] dArray) {
        this.values = new double[n][n2];
        this.nRow = n;
        this.nCol = n2;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                this.values[i][j] = dArray[i * n2 + j];
            }
        }
    }

    public GMatrix(GMatrix gMatrix) {
        this.nRow = gMatrix.nRow;
        this.nCol = gMatrix.nCol;
        this.values = new double[this.nRow][this.nCol];
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                this.values[i][j] = gMatrix.values[i][j];
            }
        }
    }

    public final void mul(GMatrix gMatrix) {
        if (this.nCol != gMatrix.nRow || this.nCol != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix0"));
        }
        double[][] dArray = new double[this.nRow][this.nCol];
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                dArray[i][j] = 0.0;
                for (int k = 0; k < this.nCol; ++k) {
                    double[] dArray2 = dArray[i];
                    int n = j;
                    dArray2[n] = dArray2[n] + this.values[i][k] * gMatrix.values[k][j];
                }
            }
        }
        this.values = dArray;
    }

    public final void mul(GMatrix gMatrix, GMatrix gMatrix2) {
        if (gMatrix.nCol != gMatrix2.nRow || this.nRow != gMatrix.nRow || this.nCol != gMatrix2.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix1"));
        }
        double[][] dArray = new double[this.nRow][this.nCol];
        for (int i = 0; i < gMatrix.nRow; ++i) {
            for (int j = 0; j < gMatrix2.nCol; ++j) {
                dArray[i][j] = 0.0;
                for (int k = 0; k < gMatrix.nCol; ++k) {
                    double[] dArray2 = dArray[i];
                    int n = j;
                    dArray2[n] = dArray2[n] + gMatrix.values[i][k] * gMatrix2.values[k][j];
                }
            }
        }
        this.values = dArray;
    }

    public final void mul(GVector gVector, GVector gVector2) {
        if (this.nRow < gVector.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix2"));
        }
        if (this.nCol < gVector2.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix3"));
        }
        for (int i = 0; i < gVector.getSize(); ++i) {
            for (int j = 0; j < gVector2.getSize(); ++j) {
                this.values[i][j] = gVector.values[i] * gVector2.values[j];
            }
        }
    }

    public final void add(GMatrix gMatrix) {
        if (this.nRow != gMatrix.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix4"));
        }
        if (this.nCol != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix5"));
        }
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                this.values[i][j] = this.values[i][j] + gMatrix.values[i][j];
            }
        }
    }

    public final void add(GMatrix gMatrix, GMatrix gMatrix2) {
        if (gMatrix2.nRow != gMatrix.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix6"));
        }
        if (gMatrix2.nCol != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix7"));
        }
        if (this.nCol != gMatrix.nCol || this.nRow != gMatrix.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix8"));
        }
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                this.values[i][j] = gMatrix.values[i][j] + gMatrix2.values[i][j];
            }
        }
    }

    public final void sub(GMatrix gMatrix) {
        if (this.nRow != gMatrix.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix9"));
        }
        if (this.nCol != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix28"));
        }
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                this.values[i][j] = this.values[i][j] - gMatrix.values[i][j];
            }
        }
    }

    public final void sub(GMatrix gMatrix, GMatrix gMatrix2) {
        if (gMatrix2.nRow != gMatrix.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix10"));
        }
        if (gMatrix2.nCol != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix11"));
        }
        if (this.nRow != gMatrix.nRow || this.nCol != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix12"));
        }
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                this.values[i][j] = gMatrix.values[i][j] - gMatrix2.values[i][j];
            }
        }
    }

    public final void negate() {
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                this.values[i][j] = -this.values[i][j];
            }
        }
    }

    public final void negate(GMatrix gMatrix) {
        if (this.nRow != gMatrix.nRow || this.nCol != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix13"));
        }
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                this.values[i][j] = -gMatrix.values[i][j];
            }
        }
    }

    public final void setIdentity() {
        int n;
        for (n = 0; n < this.nRow; ++n) {
            for (int i = 0; i < this.nCol; ++i) {
                this.values[n][i] = 0.0;
            }
        }
        int n2 = this.nRow < this.nCol ? this.nRow : this.nCol;
        for (n = 0; n < n2; ++n) {
            this.values[n][n] = 1.0;
        }
    }

    public final void setZero() {
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                this.values[i][j] = 0.0;
            }
        }
    }

    public final void identityMinus() {
        int n;
        for (n = 0; n < this.nRow; ++n) {
            for (int i = 0; i < this.nCol; ++i) {
                this.values[n][i] = -this.values[n][i];
            }
        }
        int n2 = this.nRow < this.nCol ? this.nRow : this.nCol;
        n = 0;
        while (n < n2) {
            double[] dArray = this.values[n];
            int n3 = n++;
            dArray[n3] = dArray[n3] + 1.0;
        }
    }

    public final void invert() {
        this.invertGeneral(this);
    }

    public final void invert(GMatrix gMatrix) {
        this.invertGeneral(gMatrix);
    }

    public final void copySubMatrix(int n, int n2, int n3, int n4, int n5, int n6, GMatrix gMatrix) {
        if (this != gMatrix) {
            for (int i = 0; i < n3; ++i) {
                for (int j = 0; j < n4; ++j) {
                    gMatrix.values[n5 + i][n6 + j] = this.values[n + i][n2 + j];
                }
            }
        } else {
            int n7;
            int n8;
            double[][] dArray = new double[n3][n4];
            for (n8 = 0; n8 < n3; ++n8) {
                for (n7 = 0; n7 < n4; ++n7) {
                    dArray[n8][n7] = this.values[n + n8][n2 + n7];
                }
            }
            for (n8 = 0; n8 < n3; ++n8) {
                for (n7 = 0; n7 < n4; ++n7) {
                    gMatrix.values[n5 + n8][n6 + n7] = dArray[n8][n7];
                }
            }
        }
    }

    public final void setSize(int n, int n2) {
        double[][] dArray = new double[n][n2];
        int n3 = this.nRow < n ? this.nRow : n;
        int n4 = this.nCol < n2 ? this.nCol : n2;
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n4; ++j) {
                dArray[i][j] = this.values[i][j];
            }
        }
        this.nRow = n;
        this.nCol = n2;
        this.values = dArray;
    }

    public final void set(double[] dArray) {
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                this.values[i][j] = dArray[this.nCol * i + j];
            }
        }
    }

    public final void set(Matrix3f matrix3f) {
        if (this.nCol < 3 || this.nRow < 3) {
            this.nCol = 3;
            this.nRow = 3;
            this.values = new double[this.nRow][this.nCol];
        }
        this.values[0][0] = matrix3f.m00;
        this.values[0][1] = matrix3f.m01;
        this.values[0][2] = matrix3f.m02;
        this.values[1][0] = matrix3f.m10;
        this.values[1][1] = matrix3f.m11;
        this.values[1][2] = matrix3f.m12;
        this.values[2][0] = matrix3f.m20;
        this.values[2][1] = matrix3f.m21;
        this.values[2][2] = matrix3f.m22;
        for (int i = 3; i < this.nRow; ++i) {
            for (int j = 3; j < this.nCol; ++j) {
                this.values[i][j] = 0.0;
            }
        }
    }

    public final void set(Matrix3d matrix3d) {
        if (this.nRow < 3 || this.nCol < 3) {
            this.values = new double[3][3];
            this.nRow = 3;
            this.nCol = 3;
        }
        this.values[0][0] = matrix3d.m00;
        this.values[0][1] = matrix3d.m01;
        this.values[0][2] = matrix3d.m02;
        this.values[1][0] = matrix3d.m10;
        this.values[1][1] = matrix3d.m11;
        this.values[1][2] = matrix3d.m12;
        this.values[2][0] = matrix3d.m20;
        this.values[2][1] = matrix3d.m21;
        this.values[2][2] = matrix3d.m22;
        for (int i = 3; i < this.nRow; ++i) {
            for (int j = 3; j < this.nCol; ++j) {
                this.values[i][j] = 0.0;
            }
        }
    }

    public final void set(Matrix4f matrix4f) {
        if (this.nRow < 4 || this.nCol < 4) {
            this.values = new double[4][4];
            this.nRow = 4;
            this.nCol = 4;
        }
        this.values[0][0] = matrix4f.m00;
        this.values[0][1] = matrix4f.m01;
        this.values[0][2] = matrix4f.m02;
        this.values[0][3] = matrix4f.m03;
        this.values[1][0] = matrix4f.m10;
        this.values[1][1] = matrix4f.m11;
        this.values[1][2] = matrix4f.m12;
        this.values[1][3] = matrix4f.m13;
        this.values[2][0] = matrix4f.m20;
        this.values[2][1] = matrix4f.m21;
        this.values[2][2] = matrix4f.m22;
        this.values[2][3] = matrix4f.m23;
        this.values[3][0] = matrix4f.m30;
        this.values[3][1] = matrix4f.m31;
        this.values[3][2] = matrix4f.m32;
        this.values[3][3] = matrix4f.m33;
        for (int i = 4; i < this.nRow; ++i) {
            for (int j = 4; j < this.nCol; ++j) {
                this.values[i][j] = 0.0;
            }
        }
    }

    public final void set(Matrix4d matrix4d) {
        if (this.nRow < 4 || this.nCol < 4) {
            this.values = new double[4][4];
            this.nRow = 4;
            this.nCol = 4;
        }
        this.values[0][0] = matrix4d.m00;
        this.values[0][1] = matrix4d.m01;
        this.values[0][2] = matrix4d.m02;
        this.values[0][3] = matrix4d.m03;
        this.values[1][0] = matrix4d.m10;
        this.values[1][1] = matrix4d.m11;
        this.values[1][2] = matrix4d.m12;
        this.values[1][3] = matrix4d.m13;
        this.values[2][0] = matrix4d.m20;
        this.values[2][1] = matrix4d.m21;
        this.values[2][2] = matrix4d.m22;
        this.values[2][3] = matrix4d.m23;
        this.values[3][0] = matrix4d.m30;
        this.values[3][1] = matrix4d.m31;
        this.values[3][2] = matrix4d.m32;
        this.values[3][3] = matrix4d.m33;
        for (int i = 4; i < this.nRow; ++i) {
            for (int j = 4; j < this.nCol; ++j) {
                this.values[i][j] = 0.0;
            }
        }
    }

    public final void set(GMatrix gMatrix) {
        int n;
        int n2;
        if (this.nRow < gMatrix.nRow || this.nCol < gMatrix.nCol) {
            this.nRow = gMatrix.nRow;
            this.nCol = gMatrix.nCol;
            this.values = new double[this.nRow][this.nCol];
        }
        for (n2 = 0; n2 < Math.min(this.nRow, gMatrix.nRow); ++n2) {
            for (n = 0; n < Math.min(this.nCol, gMatrix.nCol); ++n) {
                this.values[n2][n] = gMatrix.values[n2][n];
            }
        }
        for (n2 = gMatrix.nRow; n2 < this.nRow; ++n2) {
            for (n = gMatrix.nCol; n < this.nCol; ++n) {
                this.values[n2][n] = 0.0;
            }
        }
    }

    public final int getNumRow() {
        return this.nRow;
    }

    public final int getNumCol() {
        return this.nCol;
    }

    public final double getElement(int n, int n2) {
        return this.values[n][n2];
    }

    public final void setElement(int n, int n2, double d) {
        this.values[n][n2] = d;
    }

    public final void getRow(int n, double[] dArray) {
        for (int i = 0; i < this.nCol; ++i) {
            dArray[i] = this.values[n][i];
        }
    }

    public final void getRow(int n, GVector gVector) {
        if (gVector.getSize() < this.nCol) {
            gVector.setSize(this.nCol);
        }
        for (int i = 0; i < this.nCol; ++i) {
            gVector.values[i] = this.values[n][i];
        }
    }

    public final void getColumn(int n, double[] dArray) {
        for (int i = 0; i < this.nRow; ++i) {
            dArray[i] = this.values[i][n];
        }
    }

    public final void getColumn(int n, GVector gVector) {
        if (gVector.getSize() < this.nRow) {
            gVector.setSize(this.nRow);
        }
        for (int i = 0; i < this.nRow; ++i) {
            gVector.values[i] = this.values[i][n];
        }
    }

    public final void get(Matrix3d matrix3d) {
        if (this.nRow < 3 || this.nCol < 3) {
            matrix3d.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    matrix3d.m00 = this.values[0][0];
                    if (this.nRow > 1) {
                        matrix3d.m10 = this.values[1][0];
                        if (this.nRow > 2) {
                            matrix3d.m20 = this.values[2][0];
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        matrix3d.m01 = this.values[0][1];
                        if (this.nRow > 1) {
                            matrix3d.m11 = this.values[1][1];
                            if (this.nRow > 2) {
                                matrix3d.m21 = this.values[2][1];
                            }
                        }
                    }
                    if (this.nCol > 2 && this.nRow > 0) {
                        matrix3d.m02 = this.values[0][2];
                        if (this.nRow > 1) {
                            matrix3d.m12 = this.values[1][2];
                            if (this.nRow > 2) {
                                matrix3d.m22 = this.values[2][2];
                            }
                        }
                    }
                }
            }
        } else {
            matrix3d.m00 = this.values[0][0];
            matrix3d.m01 = this.values[0][1];
            matrix3d.m02 = this.values[0][2];
            matrix3d.m10 = this.values[1][0];
            matrix3d.m11 = this.values[1][1];
            matrix3d.m12 = this.values[1][2];
            matrix3d.m20 = this.values[2][0];
            matrix3d.m21 = this.values[2][1];
            matrix3d.m22 = this.values[2][2];
        }
    }

    public final void get(Matrix3f matrix3f) {
        if (this.nRow < 3 || this.nCol < 3) {
            matrix3f.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    matrix3f.m00 = (float)this.values[0][0];
                    if (this.nRow > 1) {
                        matrix3f.m10 = (float)this.values[1][0];
                        if (this.nRow > 2) {
                            matrix3f.m20 = (float)this.values[2][0];
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        matrix3f.m01 = (float)this.values[0][1];
                        if (this.nRow > 1) {
                            matrix3f.m11 = (float)this.values[1][1];
                            if (this.nRow > 2) {
                                matrix3f.m21 = (float)this.values[2][1];
                            }
                        }
                    }
                    if (this.nCol > 2 && this.nRow > 0) {
                        matrix3f.m02 = (float)this.values[0][2];
                        if (this.nRow > 1) {
                            matrix3f.m12 = (float)this.values[1][2];
                            if (this.nRow > 2) {
                                matrix3f.m22 = (float)this.values[2][2];
                            }
                        }
                    }
                }
            }
        } else {
            matrix3f.m00 = (float)this.values[0][0];
            matrix3f.m01 = (float)this.values[0][1];
            matrix3f.m02 = (float)this.values[0][2];
            matrix3f.m10 = (float)this.values[1][0];
            matrix3f.m11 = (float)this.values[1][1];
            matrix3f.m12 = (float)this.values[1][2];
            matrix3f.m20 = (float)this.values[2][0];
            matrix3f.m21 = (float)this.values[2][1];
            matrix3f.m22 = (float)this.values[2][2];
        }
    }

    public final void get(Matrix4d matrix4d) {
        if (this.nRow < 4 || this.nCol < 4) {
            matrix4d.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    matrix4d.m00 = this.values[0][0];
                    if (this.nRow > 1) {
                        matrix4d.m10 = this.values[1][0];
                        if (this.nRow > 2) {
                            matrix4d.m20 = this.values[2][0];
                            if (this.nRow > 3) {
                                matrix4d.m30 = this.values[3][0];
                            }
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        matrix4d.m01 = this.values[0][1];
                        if (this.nRow > 1) {
                            matrix4d.m11 = this.values[1][1];
                            if (this.nRow > 2) {
                                matrix4d.m21 = this.values[2][1];
                                if (this.nRow > 3) {
                                    matrix4d.m31 = this.values[3][1];
                                }
                            }
                        }
                    }
                    if (this.nCol > 2) {
                        if (this.nRow > 0) {
                            matrix4d.m02 = this.values[0][2];
                            if (this.nRow > 1) {
                                matrix4d.m12 = this.values[1][2];
                                if (this.nRow > 2) {
                                    matrix4d.m22 = this.values[2][2];
                                    if (this.nRow > 3) {
                                        matrix4d.m32 = this.values[3][2];
                                    }
                                }
                            }
                        }
                        if (this.nCol > 3 && this.nRow > 0) {
                            matrix4d.m03 = this.values[0][3];
                            if (this.nRow > 1) {
                                matrix4d.m13 = this.values[1][3];
                                if (this.nRow > 2) {
                                    matrix4d.m23 = this.values[2][3];
                                    if (this.nRow > 3) {
                                        matrix4d.m33 = this.values[3][3];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            matrix4d.m00 = this.values[0][0];
            matrix4d.m01 = this.values[0][1];
            matrix4d.m02 = this.values[0][2];
            matrix4d.m03 = this.values[0][3];
            matrix4d.m10 = this.values[1][0];
            matrix4d.m11 = this.values[1][1];
            matrix4d.m12 = this.values[1][2];
            matrix4d.m13 = this.values[1][3];
            matrix4d.m20 = this.values[2][0];
            matrix4d.m21 = this.values[2][1];
            matrix4d.m22 = this.values[2][2];
            matrix4d.m23 = this.values[2][3];
            matrix4d.m30 = this.values[3][0];
            matrix4d.m31 = this.values[3][1];
            matrix4d.m32 = this.values[3][2];
            matrix4d.m33 = this.values[3][3];
        }
    }

    public final void get(Matrix4f matrix4f) {
        if (this.nRow < 4 || this.nCol < 4) {
            matrix4f.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    matrix4f.m00 = (float)this.values[0][0];
                    if (this.nRow > 1) {
                        matrix4f.m10 = (float)this.values[1][0];
                        if (this.nRow > 2) {
                            matrix4f.m20 = (float)this.values[2][0];
                            if (this.nRow > 3) {
                                matrix4f.m30 = (float)this.values[3][0];
                            }
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        matrix4f.m01 = (float)this.values[0][1];
                        if (this.nRow > 1) {
                            matrix4f.m11 = (float)this.values[1][1];
                            if (this.nRow > 2) {
                                matrix4f.m21 = (float)this.values[2][1];
                                if (this.nRow > 3) {
                                    matrix4f.m31 = (float)this.values[3][1];
                                }
                            }
                        }
                    }
                    if (this.nCol > 2) {
                        if (this.nRow > 0) {
                            matrix4f.m02 = (float)this.values[0][2];
                            if (this.nRow > 1) {
                                matrix4f.m12 = (float)this.values[1][2];
                                if (this.nRow > 2) {
                                    matrix4f.m22 = (float)this.values[2][2];
                                    if (this.nRow > 3) {
                                        matrix4f.m32 = (float)this.values[3][2];
                                    }
                                }
                            }
                        }
                        if (this.nCol > 3 && this.nRow > 0) {
                            matrix4f.m03 = (float)this.values[0][3];
                            if (this.nRow > 1) {
                                matrix4f.m13 = (float)this.values[1][3];
                                if (this.nRow > 2) {
                                    matrix4f.m23 = (float)this.values[2][3];
                                    if (this.nRow > 3) {
                                        matrix4f.m33 = (float)this.values[3][3];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            matrix4f.m00 = (float)this.values[0][0];
            matrix4f.m01 = (float)this.values[0][1];
            matrix4f.m02 = (float)this.values[0][2];
            matrix4f.m03 = (float)this.values[0][3];
            matrix4f.m10 = (float)this.values[1][0];
            matrix4f.m11 = (float)this.values[1][1];
            matrix4f.m12 = (float)this.values[1][2];
            matrix4f.m13 = (float)this.values[1][3];
            matrix4f.m20 = (float)this.values[2][0];
            matrix4f.m21 = (float)this.values[2][1];
            matrix4f.m22 = (float)this.values[2][2];
            matrix4f.m23 = (float)this.values[2][3];
            matrix4f.m30 = (float)this.values[3][0];
            matrix4f.m31 = (float)this.values[3][1];
            matrix4f.m32 = (float)this.values[3][2];
            matrix4f.m33 = (float)this.values[3][3];
        }
    }

    public final void get(GMatrix gMatrix) {
        int n;
        int n2;
        int n3 = this.nCol < gMatrix.nCol ? this.nCol : gMatrix.nCol;
        int n4 = this.nRow < gMatrix.nRow ? this.nRow : gMatrix.nRow;
        for (n2 = 0; n2 < n4; ++n2) {
            for (n = 0; n < n3; ++n) {
                gMatrix.values[n2][n] = this.values[n2][n];
            }
        }
        for (n2 = n4; n2 < gMatrix.nRow; ++n2) {
            for (n = 0; n < gMatrix.nCol; ++n) {
                gMatrix.values[n2][n] = 0.0;
            }
        }
        for (n = n3; n < gMatrix.nCol; ++n) {
            for (n2 = 0; n2 < n4; ++n2) {
                gMatrix.values[n2][n] = 0.0;
            }
        }
    }

    public final void setRow(int n, double[] dArray) {
        for (int i = 0; i < this.nCol; ++i) {
            this.values[n][i] = dArray[i];
        }
    }

    public final void setRow(int n, GVector gVector) {
        for (int i = 0; i < this.nCol; ++i) {
            this.values[n][i] = gVector.values[i];
        }
    }

    public final void setColumn(int n, double[] dArray) {
        for (int i = 0; i < this.nRow; ++i) {
            this.values[i][n] = dArray[i];
        }
    }

    public final void setColumn(int n, GVector gVector) {
        for (int i = 0; i < this.nRow; ++i) {
            this.values[i][n] = gVector.values[i];
        }
    }

    public final void mulTransposeBoth(GMatrix gMatrix, GMatrix gMatrix2) {
        if (gMatrix.nRow != gMatrix2.nCol || this.nRow != gMatrix.nCol || this.nCol != gMatrix2.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix14"));
        }
        if (gMatrix == this || gMatrix2 == this) {
            double[][] dArray = new double[this.nRow][this.nCol];
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < this.nCol; ++j) {
                    dArray[i][j] = 0.0;
                    for (int k = 0; k < gMatrix.nRow; ++k) {
                        double[] dArray2 = dArray[i];
                        int n = j;
                        dArray2[n] = dArray2[n] + gMatrix.values[k][i] * gMatrix2.values[j][k];
                    }
                }
            }
            this.values = dArray;
        } else {
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < this.nCol; ++j) {
                    this.values[i][j] = 0.0;
                    for (int k = 0; k < gMatrix.nRow; ++k) {
                        double[] dArray = this.values[i];
                        int n = j;
                        dArray[n] = dArray[n] + gMatrix.values[k][i] * gMatrix2.values[j][k];
                    }
                }
            }
        }
    }

    public final void mulTransposeRight(GMatrix gMatrix, GMatrix gMatrix2) {
        if (gMatrix.nCol != gMatrix2.nCol || this.nCol != gMatrix2.nRow || this.nRow != gMatrix.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix15"));
        }
        if (gMatrix == this || gMatrix2 == this) {
            double[][] dArray = new double[this.nRow][this.nCol];
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < this.nCol; ++j) {
                    dArray[i][j] = 0.0;
                    for (int k = 0; k < gMatrix.nCol; ++k) {
                        double[] dArray2 = dArray[i];
                        int n = j;
                        dArray2[n] = dArray2[n] + gMatrix.values[i][k] * gMatrix2.values[j][k];
                    }
                }
            }
            this.values = dArray;
        } else {
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < this.nCol; ++j) {
                    this.values[i][j] = 0.0;
                    for (int k = 0; k < gMatrix.nCol; ++k) {
                        double[] dArray = this.values[i];
                        int n = j;
                        dArray[n] = dArray[n] + gMatrix.values[i][k] * gMatrix2.values[j][k];
                    }
                }
            }
        }
    }

    public final void mulTransposeLeft(GMatrix gMatrix, GMatrix gMatrix2) {
        if (gMatrix.nRow != gMatrix2.nRow || this.nCol != gMatrix2.nCol || this.nRow != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix16"));
        }
        if (gMatrix == this || gMatrix2 == this) {
            double[][] dArray = new double[this.nRow][this.nCol];
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < this.nCol; ++j) {
                    dArray[i][j] = 0.0;
                    for (int k = 0; k < gMatrix.nRow; ++k) {
                        double[] dArray2 = dArray[i];
                        int n = j;
                        dArray2[n] = dArray2[n] + gMatrix.values[k][i] * gMatrix2.values[k][j];
                    }
                }
            }
            this.values = dArray;
        } else {
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < this.nCol; ++j) {
                    this.values[i][j] = 0.0;
                    for (int k = 0; k < gMatrix.nRow; ++k) {
                        double[] dArray = this.values[i];
                        int n = j;
                        dArray[n] = dArray[n] + gMatrix.values[k][i] * gMatrix2.values[k][j];
                    }
                }
            }
        }
    }

    public final void transpose() {
        if (this.nRow != this.nCol) {
            int n = this.nRow;
            this.nRow = this.nCol;
            this.nCol = n;
            double[][] dArray = new double[this.nRow][this.nCol];
            for (n = 0; n < this.nRow; ++n) {
                for (int i = 0; i < this.nCol; ++i) {
                    dArray[n][i] = this.values[i][n];
                }
            }
            this.values = dArray;
        } else {
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < i; ++j) {
                    double d = this.values[i][j];
                    this.values[i][j] = this.values[j][i];
                    this.values[j][i] = d;
                }
            }
        }
    }

    public final void transpose(GMatrix gMatrix) {
        if (this.nRow != gMatrix.nCol || this.nCol != gMatrix.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix17"));
        }
        if (gMatrix != this) {
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < this.nCol; ++j) {
                    this.values[i][j] = gMatrix.values[j][i];
                }
            }
        } else {
            this.transpose();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.nRow * this.nCol * 8);
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                stringBuffer.append(this.values[i][j]).append(" ");
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    private static void checkMatrix(GMatrix gMatrix) {
        for (int i = 0; i < gMatrix.nRow; ++i) {
            for (int j = 0; j < gMatrix.nCol; ++j) {
                if (Math.abs(gMatrix.values[i][j]) < 1.0E-10) {
                    System.out.print(" 0.0     ");
                    continue;
                }
                System.out.print(" " + gMatrix.values[i][j]);
            }
            System.out.print("\n");
        }
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + (long)this.nRow;
        l = 31L * l + (long)this.nCol;
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                l = 31L * l + VecMathUtil.doubleToLongBits(this.values[i][j]);
            }
        }
        return (int)(l ^ l >> 32);
    }

    public boolean equals(GMatrix gMatrix) {
        try {
            if (this.nRow != gMatrix.nRow || this.nCol != gMatrix.nCol) {
                return false;
            }
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < this.nCol; ++j) {
                    if (this.values[i][j] == gMatrix.values[i][j]) continue;
                    return false;
                }
            }
            return true;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            GMatrix gMatrix = (GMatrix)object;
            if (this.nRow != gMatrix.nRow || this.nCol != gMatrix.nCol) {
                return false;
            }
            for (int i = 0; i < this.nRow; ++i) {
                for (int j = 0; j < this.nCol; ++j) {
                    if (this.values[i][j] == gMatrix.values[i][j]) continue;
                    return false;
                }
            }
            return true;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean epsilonEquals(GMatrix gMatrix, float f) {
        return this.epsilonEquals(gMatrix, (double)f);
    }

    public boolean epsilonEquals(GMatrix gMatrix, double d) {
        if (this.nRow != gMatrix.nRow || this.nCol != gMatrix.nCol) {
            return false;
        }
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                double d2 = this.values[i][j] - gMatrix.values[i][j];
                double d3 = d2 < 0.0 ? -d2 : d2;
                if (!(d3 > d)) continue;
                return false;
            }
        }
        return true;
    }

    public final double trace() {
        int n = this.nRow < this.nCol ? this.nRow : this.nCol;
        double d = 0.0;
        for (int i = 0; i < n; ++i) {
            d += this.values[i][i];
        }
        return d;
    }

    public final int SVD(GMatrix gMatrix, GMatrix gMatrix2, GMatrix gMatrix3) {
        if (this.nCol != gMatrix3.nCol || this.nCol != gMatrix3.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix18"));
        }
        if (this.nRow != gMatrix.nRow || this.nRow != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix25"));
        }
        if (this.nRow != gMatrix2.nRow || this.nCol != gMatrix2.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix26"));
        }
        if (this.nRow == 2 && this.nCol == 2 && this.values[1][0] == 0.0) {
            gMatrix.setIdentity();
            gMatrix3.setIdentity();
            if (this.values[0][1] == 0.0) {
                return 2;
            }
            double[] dArray = new double[1];
            double[] dArray2 = new double[1];
            double[] dArray3 = new double[1];
            double[] dArray4 = new double[1];
            double[] dArray5 = new double[]{this.values[0][0], this.values[1][1]};
            GMatrix.compute_2X2(this.values[0][0], this.values[0][1], this.values[1][1], dArray5, dArray, dArray3, dArray2, dArray4, 0);
            GMatrix.update_u(0, gMatrix, dArray3, dArray);
            GMatrix.update_v(0, gMatrix3, dArray4, dArray2);
            return 2;
        }
        return GMatrix.computeSVD(this, gMatrix, gMatrix2, gMatrix3);
    }

    public final int LUD(GMatrix gMatrix, GVector gVector) {
        int n;
        int n2;
        int n3 = gMatrix.nRow * gMatrix.nCol;
        double[] dArray = new double[n3];
        int[] nArray = new int[1];
        int[] nArray2 = new int[gMatrix.nRow];
        if (this.nRow != this.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix19"));
        }
        if (this.nRow != gMatrix.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix27"));
        }
        if (this.nCol != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix27"));
        }
        if (gMatrix.nRow != gVector.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix20"));
        }
        for (n2 = 0; n2 < this.nRow; ++n2) {
            for (n = 0; n < this.nCol; ++n) {
                dArray[n2 * this.nCol + n] = this.values[n2][n];
            }
        }
        if (!GMatrix.luDecomposition(gMatrix.nRow, dArray, nArray2, nArray)) {
            throw new SingularMatrixException(VecMathI18N.getString("GMatrix21"));
        }
        for (n2 = 0; n2 < this.nRow; ++n2) {
            for (n = 0; n < this.nCol; ++n) {
                gMatrix.values[n2][n] = dArray[n2 * this.nCol + n];
            }
        }
        for (n2 = 0; n2 < gMatrix.nRow; ++n2) {
            gVector.values[n2] = nArray2[n2];
        }
        return nArray[0];
    }

    public final void setScale(double d) {
        int n;
        int n2 = this.nRow < this.nCol ? this.nRow : this.nCol;
        for (n = 0; n < this.nRow; ++n) {
            for (int i = 0; i < this.nCol; ++i) {
                this.values[n][i] = 0.0;
            }
        }
        for (n = 0; n < n2; ++n) {
            this.values[n][n] = d;
        }
    }

    final void invertGeneral(GMatrix gMatrix) {
        int n;
        int n2;
        int n3 = gMatrix.nRow * gMatrix.nCol;
        double[] dArray = new double[n3];
        double[] dArray2 = new double[n3];
        int[] nArray = new int[gMatrix.nRow];
        int[] nArray2 = new int[1];
        if (gMatrix.nRow != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix22"));
        }
        for (n2 = 0; n2 < this.nRow; ++n2) {
            for (n = 0; n < this.nCol; ++n) {
                dArray[n2 * this.nCol + n] = gMatrix.values[n2][n];
            }
        }
        if (!GMatrix.luDecomposition(gMatrix.nRow, dArray, nArray, nArray2)) {
            throw new SingularMatrixException(VecMathI18N.getString("GMatrix21"));
        }
        for (n2 = 0; n2 < n3; ++n2) {
            dArray2[n2] = 0.0;
        }
        for (n2 = 0; n2 < this.nCol; ++n2) {
            dArray2[n2 + n2 * this.nCol] = 1.0;
        }
        GMatrix.luBacksubstitution(gMatrix.nRow, dArray, nArray, dArray2);
        for (n2 = 0; n2 < this.nRow; ++n2) {
            for (n = 0; n < this.nCol; ++n) {
                this.values[n2][n] = dArray2[n2 * this.nCol + n];
            }
        }
    }

    static boolean luDecomposition(int n, double[] dArray, int[] nArray, int[] nArray2) {
        double d;
        int n2;
        double d2;
        double[] dArray2 = new double[n];
        int n3 = 0;
        int n4 = 0;
        nArray2[0] = 1;
        int n5 = n;
        while (n5-- != 0) {
            d2 = 0.0;
            n2 = n;
            while (n2-- != 0) {
                d = dArray[n3++];
                if (!((d = Math.abs(d)) > d2)) continue;
                d2 = d;
            }
            if (d2 == 0.0) {
                return false;
            }
            dArray2[n4++] = 1.0 / d2;
        }
        int n6 = 0;
        for (n2 = 0; n2 < n; ++n2) {
            int n7;
            int n8;
            int n9;
            double d3;
            int n10;
            for (n5 = 0; n5 < n2; ++n5) {
                n10 = n6 + n * n5 + n2;
                d3 = dArray[n10];
                n9 = n5;
                n8 = n6 + n * n5;
                n7 = n6 + n2;
                while (n9-- != 0) {
                    d3 -= dArray[n8] * dArray[n7];
                    ++n8;
                    n7 += n;
                }
                dArray[n10] = d3;
            }
            d2 = 0.0;
            int n11 = -1;
            for (n5 = n2; n5 < n; ++n5) {
                double d4;
                n10 = n6 + n * n5 + n2;
                d3 = dArray[n10];
                n9 = n2;
                n8 = n6 + n * n5;
                n7 = n6 + n2;
                while (n9-- != 0) {
                    d3 -= dArray[n8] * dArray[n7];
                    ++n8;
                    n7 += n;
                }
                dArray[n10] = d3;
                d = dArray2[n5] * Math.abs(d3);
                if (!(d4 >= d2)) continue;
                d2 = d;
                n11 = n5;
            }
            if (n11 < 0) {
                throw new RuntimeException(VecMathI18N.getString("GMatrix24"));
            }
            if (n2 != n11) {
                n9 = n;
                n8 = n6 + n * n11;
                n7 = n6 + n * n2;
                while (n9-- != 0) {
                    d = dArray[n8];
                    dArray[n8++] = dArray[n7];
                    dArray[n7++] = d;
                }
                dArray2[n11] = dArray2[n2];
                nArray2[0] = -nArray2[0];
            }
            nArray[n2] = n11;
            if (dArray[n6 + n * n2 + n2] == 0.0) {
                return false;
            }
            if (n2 == n - 1) continue;
            d = 1.0 / dArray[n6 + n * n2 + n2];
            n10 = n6 + n * (n2 + 1) + n2;
            n5 = n - 1 - n2;
            while (n5-- != 0) {
                int n12 = n10;
                dArray[n12] = dArray[n12] * d;
                n10 += n;
            }
        }
        return true;
    }

    static void luBacksubstitution(int n, double[] dArray, int[] nArray, double[] dArray2) {
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            int n3;
            int n4;
            int n5;
            int n6 = i;
            int n7 = -1;
            for (n5 = 0; n5 < n; ++n5) {
                int n8 = nArray[n2 + n5];
                double d = dArray2[n6 + n * n8];
                dArray2[n6 + n * n8] = dArray2[n6 + n * n5];
                if (n7 >= 0) {
                    n4 = n5 * n;
                    for (n3 = n7; n3 <= n5 - 1; ++n3) {
                        d -= dArray[n4 + n3] * dArray2[n6 + n * n3];
                    }
                } else if (d != 0.0) {
                    n7 = n5;
                }
                dArray2[n6 + n * n5] = d;
            }
            for (n5 = 0; n5 < n; ++n5) {
                int n9 = n - 1 - n5;
                n4 = n * n9;
                double d = 0.0;
                for (n3 = 1; n3 <= n5; ++n3) {
                    d += dArray[n4 + n - n3] * dArray2[n6 + n * (n - n3)];
                }
                dArray2[n6 + n * n9] = (dArray2[n6 + n * n9] - d) / dArray[n4 + n9];
            }
        }
    }

    static int computeSVD(GMatrix gMatrix, GMatrix gMatrix2, GMatrix gMatrix3, GMatrix gMatrix4) {
        int n;
        int n2;
        int n3;
        GMatrix gMatrix5 = new GMatrix(gMatrix.nRow, gMatrix.nCol);
        GMatrix gMatrix6 = new GMatrix(gMatrix.nRow, gMatrix.nCol);
        GMatrix gMatrix7 = new GMatrix(gMatrix.nRow, gMatrix.nCol);
        GMatrix gMatrix8 = new GMatrix(gMatrix);
        if (gMatrix8.nRow >= gMatrix8.nCol) {
            n3 = gMatrix8.nCol;
            n2 = gMatrix8.nCol - 1;
        } else {
            n3 = gMatrix8.nRow;
            n2 = gMatrix8.nRow;
        }
        int n4 = gMatrix8.nRow > gMatrix8.nCol ? gMatrix8.nRow : gMatrix8.nCol;
        double[] dArray = new double[n4];
        double[] dArray2 = new double[n3];
        double[] dArray3 = new double[n2];
        int n5 = 0;
        gMatrix2.setIdentity();
        gMatrix4.setIdentity();
        int n6 = gMatrix8.nRow;
        int n7 = gMatrix8.nCol;
        for (int i = 0; i < n3; ++i) {
            double d;
            int n8;
            int n9;
            double d2;
            double d3;
            if (n6 > 1) {
                d3 = 0.0;
                for (n = 0; n < n6; ++n) {
                    d3 += gMatrix8.values[n + i][i] * gMatrix8.values[n + i][i];
                }
                d3 = Math.sqrt(d3);
                dArray[0] = gMatrix8.values[i][i] == 0.0 ? d3 : gMatrix8.values[i][i] + GMatrix.d_sign(d3, gMatrix8.values[i][i]);
                for (n = 1; n < n6; ++n) {
                    dArray[n] = gMatrix8.values[i + n][i];
                }
                d2 = 0.0;
                for (n = 0; n < n6; ++n) {
                    d2 += dArray[n] * dArray[n];
                }
                d2 = 2.0 / d2;
                for (n9 = i; n9 < gMatrix8.nRow; ++n9) {
                    for (n8 = i; n8 < gMatrix8.nRow; ++n8) {
                        gMatrix6.values[n9][n8] = -d2 * dArray[n9 - i] * dArray[n8 - i];
                    }
                }
                n = i;
                while (n < gMatrix8.nRow) {
                    double[] dArray4 = gMatrix6.values[n];
                    int n10 = n++;
                    dArray4[n10] = dArray4[n10] + 1.0;
                }
                d = 0.0;
                for (n = i; n < gMatrix8.nRow; ++n) {
                    d += gMatrix6.values[i][n] * gMatrix8.values[n][i];
                }
                gMatrix8.values[i][i] = d;
                for (n9 = i; n9 < gMatrix8.nRow; ++n9) {
                    for (n8 = i + 1; n8 < gMatrix8.nCol; ++n8) {
                        gMatrix5.values[n9][n8] = 0.0;
                        for (n = i; n < gMatrix8.nCol; ++n) {
                            double[] dArray5 = gMatrix5.values[n9];
                            int n11 = n8;
                            dArray5[n11] = dArray5[n11] + gMatrix6.values[n9][n] * gMatrix8.values[n][n8];
                        }
                    }
                }
                for (n9 = i; n9 < gMatrix8.nRow; ++n9) {
                    for (n8 = i + 1; n8 < gMatrix8.nCol; ++n8) {
                        gMatrix8.values[n9][n8] = gMatrix5.values[n9][n8];
                    }
                }
                for (n9 = i; n9 < gMatrix8.nRow; ++n9) {
                    for (n8 = 0; n8 < gMatrix8.nCol; ++n8) {
                        gMatrix5.values[n9][n8] = 0.0;
                        for (n = i; n < gMatrix8.nCol; ++n) {
                            double[] dArray6 = gMatrix5.values[n9];
                            int n12 = n8;
                            dArray6[n12] = dArray6[n12] + gMatrix6.values[n9][n] * gMatrix2.values[n][n8];
                        }
                    }
                }
                for (n9 = i; n9 < gMatrix8.nRow; ++n9) {
                    for (n8 = 0; n8 < gMatrix8.nCol; ++n8) {
                        gMatrix2.values[n9][n8] = gMatrix5.values[n9][n8];
                    }
                }
                --n6;
            }
            if (n7 <= 2) continue;
            d3 = 0.0;
            for (n = 1; n < n7; ++n) {
                d3 += gMatrix8.values[i][i + n] * gMatrix8.values[i][i + n];
            }
            d3 = Math.sqrt(d3);
            dArray[0] = gMatrix8.values[i][i + 1] == 0.0 ? d3 : gMatrix8.values[i][i + 1] + GMatrix.d_sign(d3, gMatrix8.values[i][i + 1]);
            for (n = 1; n < n7 - 1; ++n) {
                dArray[n] = gMatrix8.values[i][i + n + 1];
            }
            d2 = 0.0;
            for (n = 0; n < n7 - 1; ++n) {
                d2 += dArray[n] * dArray[n];
            }
            d2 = 2.0 / d2;
            for (n9 = i + 1; n9 < n7; ++n9) {
                for (n8 = i + 1; n8 < gMatrix8.nCol; ++n8) {
                    gMatrix7.values[n9][n8] = -d2 * dArray[n9 - i - 1] * dArray[n8 - i - 1];
                }
            }
            n = i + 1;
            while (n < gMatrix8.nCol) {
                double[] dArray7 = gMatrix7.values[n];
                int n13 = n++;
                dArray7[n13] = dArray7[n13] + 1.0;
            }
            d = 0.0;
            for (n = i; n < gMatrix8.nCol; ++n) {
                d += gMatrix7.values[n][i + 1] * gMatrix8.values[i][n];
            }
            gMatrix8.values[i][i + 1] = d;
            for (n9 = i + 1; n9 < gMatrix8.nRow; ++n9) {
                for (n8 = i + 1; n8 < gMatrix8.nCol; ++n8) {
                    gMatrix5.values[n9][n8] = 0.0;
                    for (n = i + 1; n < gMatrix8.nCol; ++n) {
                        double[] dArray8 = gMatrix5.values[n9];
                        int n14 = n8;
                        dArray8[n14] = dArray8[n14] + gMatrix7.values[n][n8] * gMatrix8.values[n9][n];
                    }
                }
            }
            for (n9 = i + 1; n9 < gMatrix8.nRow; ++n9) {
                for (n8 = i + 1; n8 < gMatrix8.nCol; ++n8) {
                    gMatrix8.values[n9][n8] = gMatrix5.values[n9][n8];
                }
            }
            for (n9 = 0; n9 < gMatrix8.nRow; ++n9) {
                for (n8 = i + 1; n8 < gMatrix8.nCol; ++n8) {
                    gMatrix5.values[n9][n8] = 0.0;
                    for (n = i + 1; n < gMatrix8.nCol; ++n) {
                        double[] dArray9 = gMatrix5.values[n9];
                        int n15 = n8;
                        dArray9[n15] = dArray9[n15] + gMatrix7.values[n][n8] * gMatrix4.values[n9][n];
                    }
                }
            }
            for (n9 = 0; n9 < gMatrix8.nRow; ++n9) {
                for (n8 = i + 1; n8 < gMatrix8.nCol; ++n8) {
                    gMatrix4.values[n9][n8] = gMatrix5.values[n9][n8];
                }
            }
            --n7;
        }
        for (n = 0; n < n3; ++n) {
            dArray2[n] = gMatrix8.values[n][n];
        }
        for (n = 0; n < n2; ++n) {
            dArray3[n] = gMatrix8.values[n][n + 1];
        }
        if (gMatrix8.nRow == 2 && gMatrix8.nCol == 2) {
            double[] dArray10 = new double[1];
            double[] dArray11 = new double[1];
            double[] dArray12 = new double[1];
            double[] dArray13 = new double[1];
            GMatrix.compute_2X2(dArray2[0], dArray3[0], dArray2[1], dArray2, dArray12, dArray10, dArray13, dArray11, 0);
            GMatrix.update_u(0, gMatrix2, dArray10, dArray12);
            GMatrix.update_v(0, gMatrix4, dArray11, dArray13);
            return 2;
        }
        GMatrix.compute_qr(0, dArray3.length - 1, dArray2, dArray3, gMatrix2, gMatrix4);
        n5 = dArray2.length;
        return n5;
    }

    static void compute_qr(int n, int n2, double[] dArray, double[] dArray2, GMatrix gMatrix, GMatrix gMatrix2) {
        int n3;
        double[] dArray3 = new double[1];
        double[] dArray4 = new double[1];
        double[] dArray5 = new double[1];
        double[] dArray6 = new double[1];
        GMatrix gMatrix3 = new GMatrix(gMatrix.nCol, gMatrix2.nRow);
        double d = 1.0;
        double d2 = -1.0;
        boolean bl = false;
        double d3 = 0.0;
        double d4 = 0.0;
        for (int i = 0; i < 2 && !bl; ++i) {
            double d5;
            for (n3 = n; n3 <= n2; ++n3) {
                if (n3 == n) {
                    int n4 = dArray2.length == dArray.length ? n2 : n2 + 1;
                    double d6 = GMatrix.compute_shift(dArray[n4 - 1], dArray2[n2], dArray[n4]);
                    d3 = (Math.abs(dArray[n3]) - d6) * (GMatrix.d_sign(d, dArray[n3]) + d6 / dArray[n3]);
                    d4 = dArray2[n3];
                }
                d5 = GMatrix.compute_rot(d3, d4, dArray6, dArray4);
                if (n3 != n) {
                    dArray2[n3 - 1] = d5;
                }
                d3 = dArray4[0] * dArray[n3] + dArray6[0] * dArray2[n3];
                dArray2[n3] = dArray4[0] * dArray2[n3] - dArray6[0] * dArray[n3];
                d4 = dArray6[0] * dArray[n3 + 1];
                dArray[n3 + 1] = dArray4[0] * dArray[n3 + 1];
                GMatrix.update_v(n3, gMatrix2, dArray4, dArray6);
                dArray[n3] = d5 = GMatrix.compute_rot(d3, d4, dArray5, dArray3);
                d3 = dArray3[0] * dArray2[n3] + dArray5[0] * dArray[n3 + 1];
                dArray[n3 + 1] = dArray3[0] * dArray[n3 + 1] - dArray5[0] * dArray2[n3];
                if (n3 < n2) {
                    d4 = dArray5[0] * dArray2[n3 + 1];
                    dArray2[n3 + 1] = dArray3[0] * dArray2[n3 + 1];
                }
                GMatrix.update_u(n3, gMatrix, dArray3, dArray5);
            }
            if (dArray.length == dArray2.length) {
                d5 = GMatrix.compute_rot(d3, d4, dArray6, dArray4);
                d3 = dArray4[0] * dArray[n3] + dArray6[0] * dArray2[n3];
                dArray2[n3] = dArray4[0] * dArray2[n3] - dArray6[0] * dArray[n3];
                dArray[n3 + 1] = dArray4[0] * dArray[n3 + 1];
                GMatrix.update_v(n3, gMatrix2, dArray4, dArray6);
            }
            while (n2 - n > 1 && Math.abs(dArray2[n2]) < 4.89E-15) {
                --n2;
            }
            for (int j = n2 - 2; j > n; --j) {
                if (!(Math.abs(dArray2[j]) < 4.89E-15)) continue;
                GMatrix.compute_qr(j + 1, n2, dArray, dArray2, gMatrix, gMatrix2);
                n2 = j - 1;
                while (n2 - n > 1 && Math.abs(dArray2[n2]) < 4.89E-15) {
                    --n2;
                }
            }
            if (n2 - n > 1 || !(Math.abs(dArray2[n + 1]) < 4.89E-15)) continue;
            bl = true;
        }
        if (Math.abs(dArray2[1]) < 4.89E-15) {
            GMatrix.compute_2X2(dArray[n], dArray2[n], dArray[n + 1], dArray, dArray5, dArray3, dArray6, dArray4, 0);
            dArray2[n] = 0.0;
            dArray2[n + 1] = 0.0;
        }
        n3 = n;
        GMatrix.update_u(n3, gMatrix, dArray3, dArray5);
        GMatrix.update_v(n3, gMatrix2, dArray4, dArray6);
    }

    private static void print_se(double[] dArray, double[] dArray2) {
        System.out.println("\ns =" + dArray[0] + " " + dArray[1] + " " + dArray[2]);
        System.out.println("e =" + dArray2[0] + " " + dArray2[1]);
    }

    private static void update_v(int n, GMatrix gMatrix, double[] dArray, double[] dArray2) {
        for (int i = 0; i < gMatrix.nRow; ++i) {
            double d = gMatrix.values[i][n];
            gMatrix.values[i][n] = dArray[0] * d + dArray2[0] * gMatrix.values[i][n + 1];
            gMatrix.values[i][n + 1] = -dArray2[0] * d + dArray[0] * gMatrix.values[i][n + 1];
        }
    }

    private static void chase_up(double[] dArray, double[] dArray2, int n, GMatrix gMatrix) {
        int n2;
        double[] dArray3 = new double[1];
        double[] dArray4 = new double[1];
        GMatrix gMatrix2 = new GMatrix(gMatrix.nRow, gMatrix.nCol);
        GMatrix gMatrix3 = new GMatrix(gMatrix.nRow, gMatrix.nCol);
        double d = dArray2[n];
        double d2 = dArray[n];
        for (n2 = n; n2 > 0; --n2) {
            double d3 = GMatrix.compute_rot(d, d2, dArray4, dArray3);
            d = -dArray2[n2 - 1] * dArray4[0];
            d2 = dArray[n2 - 1];
            dArray[n2] = d3;
            dArray2[n2 - 1] = dArray2[n2 - 1] * dArray3[0];
            GMatrix.update_v_split(n2, n + 1, gMatrix, dArray3, dArray4, gMatrix2, gMatrix3);
        }
        dArray[n2 + 1] = GMatrix.compute_rot(d, d2, dArray4, dArray3);
        GMatrix.update_v_split(n2, n + 1, gMatrix, dArray3, dArray4, gMatrix2, gMatrix3);
    }

    private static void chase_across(double[] dArray, double[] dArray2, int n, GMatrix gMatrix) {
        int n2;
        double[] dArray3 = new double[1];
        double[] dArray4 = new double[1];
        GMatrix gMatrix2 = new GMatrix(gMatrix.nRow, gMatrix.nCol);
        GMatrix gMatrix3 = new GMatrix(gMatrix.nRow, gMatrix.nCol);
        double d = dArray2[n];
        double d2 = dArray[n + 1];
        for (n2 = n; n2 < gMatrix.nCol - 2; ++n2) {
            double d3 = GMatrix.compute_rot(d2, d, dArray4, dArray3);
            d = -dArray2[n2 + 1] * dArray4[0];
            d2 = dArray[n2 + 2];
            dArray[n2 + 1] = d3;
            dArray2[n2 + 1] = dArray2[n2 + 1] * dArray3[0];
            GMatrix.update_u_split(n, n2 + 1, gMatrix, dArray3, dArray4, gMatrix2, gMatrix3);
        }
        dArray[n2 + 1] = GMatrix.compute_rot(d2, d, dArray4, dArray3);
        GMatrix.update_u_split(n, n2 + 1, gMatrix, dArray3, dArray4, gMatrix2, gMatrix3);
    }

    private static void update_v_split(int n, int n2, GMatrix gMatrix, double[] dArray, double[] dArray2, GMatrix gMatrix2, GMatrix gMatrix3) {
        for (int i = 0; i < gMatrix.nRow; ++i) {
            double d = gMatrix.values[i][n];
            gMatrix.values[i][n] = dArray[0] * d - dArray2[0] * gMatrix.values[i][n2];
            gMatrix.values[i][n2] = dArray2[0] * d + dArray[0] * gMatrix.values[i][n2];
        }
        System.out.println("topr    =" + n);
        System.out.println("bottomr =" + n2);
        System.out.println("cosr =" + dArray[0]);
        System.out.println("sinr =" + dArray2[0]);
        System.out.println("\nm =");
        GMatrix.checkMatrix(gMatrix3);
        System.out.println("\nv =");
        GMatrix.checkMatrix(gMatrix2);
        gMatrix3.mul(gMatrix3, gMatrix2);
        System.out.println("\nt*m =");
        GMatrix.checkMatrix(gMatrix3);
    }

    private static void update_u_split(int n, int n2, GMatrix gMatrix, double[] dArray, double[] dArray2, GMatrix gMatrix2, GMatrix gMatrix3) {
        for (int i = 0; i < gMatrix.nCol; ++i) {
            double d = gMatrix.values[n][i];
            gMatrix.values[n][i] = dArray[0] * d - dArray2[0] * gMatrix.values[n2][i];
            gMatrix.values[n2][i] = dArray2[0] * d + dArray[0] * gMatrix.values[n2][i];
        }
        System.out.println("\nm=");
        GMatrix.checkMatrix(gMatrix3);
        System.out.println("\nu=");
        GMatrix.checkMatrix(gMatrix2);
        gMatrix3.mul(gMatrix2, gMatrix3);
        System.out.println("\nt*m=");
        GMatrix.checkMatrix(gMatrix3);
    }

    private static void update_u(int n, GMatrix gMatrix, double[] dArray, double[] dArray2) {
        for (int i = 0; i < gMatrix.nCol; ++i) {
            double d = gMatrix.values[n][i];
            gMatrix.values[n][i] = dArray[0] * d + dArray2[0] * gMatrix.values[n + 1][i];
            gMatrix.values[n + 1][i] = -dArray2[0] * d + dArray[0] * gMatrix.values[n + 1][i];
        }
    }

    private static void print_m(GMatrix gMatrix, GMatrix gMatrix2, GMatrix gMatrix3) {
        GMatrix gMatrix4 = new GMatrix(gMatrix.nCol, gMatrix.nRow);
        gMatrix4.mul(gMatrix2, gMatrix4);
        gMatrix4.mul(gMatrix4, gMatrix3);
        System.out.println("\n m = \n" + GMatrix.toString(gMatrix4));
    }

    private static String toString(GMatrix gMatrix) {
        StringBuffer stringBuffer = new StringBuffer(gMatrix.nRow * gMatrix.nCol * 8);
        for (int i = 0; i < gMatrix.nRow; ++i) {
            for (int j = 0; j < gMatrix.nCol; ++j) {
                if (Math.abs(gMatrix.values[i][j]) < 1.0E-9) {
                    stringBuffer.append("0.0000 ");
                    continue;
                }
                stringBuffer.append(gMatrix.values[i][j]).append(" ");
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    private static void print_svd(double[] dArray, double[] dArray2, GMatrix gMatrix, GMatrix gMatrix2) {
        int n;
        GMatrix gMatrix3 = new GMatrix(gMatrix.nCol, gMatrix2.nRow);
        System.out.println(" \ns = ");
        for (n = 0; n < dArray.length; ++n) {
            System.out.println(" " + dArray[n]);
        }
        System.out.println(" \ne = ");
        for (n = 0; n < dArray2.length; ++n) {
            System.out.println(" " + dArray2[n]);
        }
        System.out.println(" \nu  = \n" + gMatrix.toString());
        System.out.println(" \nv  = \n" + gMatrix2.toString());
        gMatrix3.setIdentity();
        for (n = 0; n < dArray.length; ++n) {
            gMatrix3.values[n][n] = dArray[n];
        }
        for (n = 0; n < dArray2.length; ++n) {
            gMatrix3.values[n][n + 1] = dArray2[n];
        }
        System.out.println(" \nm  = \n" + gMatrix3.toString());
        gMatrix3.mulTransposeLeft(gMatrix, gMatrix3);
        gMatrix3.mulTransposeRight(gMatrix3, gMatrix2);
        System.out.println(" \n u.transpose*m*v.transpose  = \n" + gMatrix3.toString());
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

    static double compute_shift(double d, double d2, double d3) {
        double d4;
        double d5 = Math.abs(d);
        double d6 = Math.abs(d2);
        double d7 = Math.abs(d3);
        double d8 = GMatrix.min(d5, d7);
        double d9 = GMatrix.max(d5, d7);
        if (d8 == 0.0) {
            d4 = 0.0;
            if (d9 != 0.0) {
                double d10 = GMatrix.min(d9, d6) / GMatrix.max(d9, d6);
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
                if (d16 / d5 < 1.0E-10) {
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
                    if (d16 / d5 < 1.0E-10) {
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
                    d23 = d24 == 0.0 ? (d21 == 0.0 ? GMatrix.d_sign(d6, d15) * GMatrix.d_sign(d7, d4) : d4 / GMatrix.d_sign(d20, d15) + d22 / d23) : (d22 / (d26 + d23) + d22 / (d27 + d21)) * (d28 + 1.0);
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
                d14 = GMatrix.d_sign(d7, dArray5[0]) * GMatrix.d_sign(d7, dArray3[0]) * GMatrix.d_sign(d7, d);
            }
            if (n2 == 2) {
                d14 = GMatrix.d_sign(d7, dArray4[0]) * GMatrix.d_sign(d7, dArray3[0]) * GMatrix.d_sign(d7, d2);
            }
            if (n2 == 3) {
                d14 = GMatrix.d_sign(d7, dArray4[0]) * GMatrix.d_sign(d7, dArray2[0]) * GMatrix.d_sign(d7, d3);
            }
            dArray[n] = GMatrix.d_sign(d8, d14);
            double d29 = d14 * GMatrix.d_sign(d7, d) * GMatrix.d_sign(d7, d3);
            dArray[n + 1] = GMatrix.d_sign(d9, d29);
        }
        return 0;
    }

    static double compute_rot(double d, double d2, double[] dArray, double[] dArray2) {
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
            double d8 = GMatrix.max(Math.abs(d6), Math.abs(d7));
            if (d8 >= 4.9947976805055876E145) {
                int n = 0;
                while (d8 >= 4.9947976805055876E145) {
                    ++n;
                    d8 = GMatrix.max(Math.abs(d6 *= 2.002083095183101E-146), Math.abs(d7 *= 2.002083095183101E-146));
                }
                d3 = Math.sqrt(d6 * d6 + d7 * d7);
                d5 = d6 / d3;
                d4 = d7 / d3;
                int n2 = n;
                for (int i = 1; i <= n; ++i) {
                    d3 *= 4.9947976805055876E145;
                }
            } else if (d8 <= 2.002083095183101E-146) {
                int n = 0;
                while (d8 <= 2.002083095183101E-146) {
                    ++n;
                    d8 = GMatrix.max(Math.abs(d6 *= 4.9947976805055876E145), Math.abs(d7 *= 4.9947976805055876E145));
                }
                d3 = Math.sqrt(d6 * d6 + d7 * d7);
                d5 = d6 / d3;
                d4 = d7 / d3;
                int n3 = n;
                for (int i = 1; i <= n; ++i) {
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
        dArray[0] = d4;
        dArray2[0] = d5;
        return d3;
    }

    static double d_sign(double d, double d2) {
        double d3 = d >= 0.0 ? d : -d;
        return d2 >= 0.0 ? d3 : -d3;
    }

    public Object clone() {
        GMatrix gMatrix = null;
        try {
            gMatrix = (GMatrix)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        gMatrix.values = new double[this.nRow][this.nCol];
        for (int i = 0; i < this.nRow; ++i) {
            for (int j = 0; j < this.nCol; ++j) {
                gMatrix.values[i][j] = this.values[i][j];
            }
        }
        return gMatrix;
    }
}


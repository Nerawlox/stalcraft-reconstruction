/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.GMatrix;
import javax.vecmath.MismatchedSizeException;
import javax.vecmath.Tuple2f;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;
import javax.vecmath.VecMathI18N;
import javax.vecmath.VecMathUtil;

public class GVector
implements Serializable,
Cloneable {
    private int length;
    double[] values;
    static final long serialVersionUID = 1398850036893875112L;

    public GVector(int n) {
        this.length = n;
        this.values = new double[n];
        for (int i = 0; i < n; ++i) {
            this.values[i] = 0.0;
        }
    }

    public GVector(double[] dArray) {
        this.length = dArray.length;
        this.values = new double[dArray.length];
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = dArray[i];
        }
    }

    public GVector(GVector gVector) {
        this.values = new double[gVector.length];
        this.length = gVector.length;
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = gVector.values[i];
        }
    }

    public GVector(Tuple2f tuple2f) {
        this.values = new double[2];
        this.values[0] = tuple2f.x;
        this.values[1] = tuple2f.y;
        this.length = 2;
    }

    public GVector(Tuple3f tuple3f) {
        this.values = new double[3];
        this.values[0] = tuple3f.x;
        this.values[1] = tuple3f.y;
        this.values[2] = tuple3f.z;
        this.length = 3;
    }

    public GVector(Tuple3d tuple3d) {
        this.values = new double[3];
        this.values[0] = tuple3d.x;
        this.values[1] = tuple3d.y;
        this.values[2] = tuple3d.z;
        this.length = 3;
    }

    public GVector(Tuple4f tuple4f) {
        this.values = new double[4];
        this.values[0] = tuple4f.x;
        this.values[1] = tuple4f.y;
        this.values[2] = tuple4f.z;
        this.values[3] = tuple4f.w;
        this.length = 4;
    }

    public GVector(Tuple4d tuple4d) {
        this.values = new double[4];
        this.values[0] = tuple4d.x;
        this.values[1] = tuple4d.y;
        this.values[2] = tuple4d.z;
        this.values[3] = tuple4d.w;
        this.length = 4;
    }

    public GVector(double[] dArray, int n) {
        this.length = n;
        this.values = new double[n];
        for (int i = 0; i < n; ++i) {
            this.values[i] = dArray[i];
        }
    }

    public final double norm() {
        double d = 0.0;
        for (int i = 0; i < this.length; ++i) {
            d += this.values[i] * this.values[i];
        }
        return Math.sqrt(d);
    }

    public final double normSquared() {
        double d = 0.0;
        for (int i = 0; i < this.length; ++i) {
            d += this.values[i] * this.values[i];
        }
        return d;
    }

    public final void normalize(GVector gVector) {
        int n;
        double d = 0.0;
        if (this.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector0"));
        }
        for (n = 0; n < this.length; ++n) {
            d += gVector.values[n] * gVector.values[n];
        }
        double d2 = 1.0 / Math.sqrt(d);
        for (n = 0; n < this.length; ++n) {
            this.values[n] = gVector.values[n] * d2;
        }
    }

    public final void normalize() {
        int n;
        double d = 0.0;
        for (n = 0; n < this.length; ++n) {
            d += this.values[n] * this.values[n];
        }
        double d2 = 1.0 / Math.sqrt(d);
        for (n = 0; n < this.length; ++n) {
            this.values[n] = this.values[n] * d2;
        }
    }

    public final void scale(double d, GVector gVector) {
        if (this.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector1"));
        }
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = gVector.values[i] * d;
        }
    }

    public final void scale(double d) {
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = this.values[i] * d;
        }
    }

    public final void scaleAdd(double d, GVector gVector, GVector gVector2) {
        if (gVector2.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector2"));
        }
        if (this.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector3"));
        }
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = gVector.values[i] * d + gVector2.values[i];
        }
    }

    public final void add(GVector gVector) {
        if (this.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector4"));
        }
        for (int i = 0; i < this.length; ++i) {
            int n = i;
            this.values[n] = this.values[n] + gVector.values[i];
        }
    }

    public final void add(GVector gVector, GVector gVector2) {
        if (gVector.length != gVector2.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector5"));
        }
        if (this.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector6"));
        }
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = gVector.values[i] + gVector2.values[i];
        }
    }

    public final void sub(GVector gVector) {
        if (this.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector7"));
        }
        for (int i = 0; i < this.length; ++i) {
            int n = i;
            this.values[n] = this.values[n] - gVector.values[i];
        }
    }

    public final void sub(GVector gVector, GVector gVector2) {
        if (gVector.length != gVector2.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector8"));
        }
        if (this.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector9"));
        }
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = gVector.values[i] - gVector2.values[i];
        }
    }

    public final void mul(GMatrix gMatrix, GVector gVector) {
        if (gMatrix.getNumCol() != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector10"));
        }
        if (this.length != gMatrix.getNumRow()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector11"));
        }
        double[] dArray = gVector != this ? gVector.values : (double[])this.values.clone();
        for (int i = this.length - 1; i >= 0; --i) {
            this.values[i] = 0.0;
            for (int j = gVector.length - 1; j >= 0; --j) {
                int n = i;
                this.values[n] = this.values[n] + gMatrix.values[i][j] * dArray[j];
            }
        }
    }

    public final void mul(GVector gVector, GMatrix gMatrix) {
        if (gMatrix.getNumRow() != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector12"));
        }
        if (this.length != gMatrix.getNumCol()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector13"));
        }
        double[] dArray = gVector != this ? gVector.values : (double[])this.values.clone();
        for (int i = this.length - 1; i >= 0; --i) {
            this.values[i] = 0.0;
            for (int j = gVector.length - 1; j >= 0; --j) {
                int n = i;
                this.values[n] = this.values[n] + gMatrix.values[j][i] * dArray[j];
            }
        }
    }

    public final void negate() {
        int n = this.length - 1;
        while (n >= 0) {
            int n2 = n--;
            this.values[n2] = this.values[n2] * -1.0;
        }
    }

    public final void zero() {
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = 0.0;
        }
    }

    public final void setSize(int n) {
        double[] dArray = new double[n];
        int n2 = this.length < n ? this.length : n;
        for (int i = 0; i < n2; ++i) {
            dArray[i] = this.values[i];
        }
        this.length = n;
        this.values = dArray;
    }

    public final void set(double[] dArray) {
        for (int i = this.length - 1; i >= 0; --i) {
            this.values[i] = dArray[i];
        }
    }

    public final void set(GVector gVector) {
        if (this.length < gVector.length) {
            this.length = gVector.length;
            this.values = new double[this.length];
            for (int i = 0; i < this.length; ++i) {
                this.values[i] = gVector.values[i];
            }
        } else {
            int n;
            for (n = 0; n < gVector.length; ++n) {
                this.values[n] = gVector.values[n];
            }
            for (n = gVector.length; n < this.length; ++n) {
                this.values[n] = 0.0;
            }
        }
    }

    public final void set(Tuple2f tuple2f) {
        if (this.length < 2) {
            this.length = 2;
            this.values = new double[2];
        }
        this.values[0] = tuple2f.x;
        this.values[1] = tuple2f.y;
        for (int i = 2; i < this.length; ++i) {
            this.values[i] = 0.0;
        }
    }

    public final void set(Tuple3f tuple3f) {
        if (this.length < 3) {
            this.length = 3;
            this.values = new double[3];
        }
        this.values[0] = tuple3f.x;
        this.values[1] = tuple3f.y;
        this.values[2] = tuple3f.z;
        for (int i = 3; i < this.length; ++i) {
            this.values[i] = 0.0;
        }
    }

    public final void set(Tuple3d tuple3d) {
        if (this.length < 3) {
            this.length = 3;
            this.values = new double[3];
        }
        this.values[0] = tuple3d.x;
        this.values[1] = tuple3d.y;
        this.values[2] = tuple3d.z;
        for (int i = 3; i < this.length; ++i) {
            this.values[i] = 0.0;
        }
    }

    public final void set(Tuple4f tuple4f) {
        if (this.length < 4) {
            this.length = 4;
            this.values = new double[4];
        }
        this.values[0] = tuple4f.x;
        this.values[1] = tuple4f.y;
        this.values[2] = tuple4f.z;
        this.values[3] = tuple4f.w;
        for (int i = 4; i < this.length; ++i) {
            this.values[i] = 0.0;
        }
    }

    public final void set(Tuple4d tuple4d) {
        if (this.length < 4) {
            this.length = 4;
            this.values = new double[4];
        }
        this.values[0] = tuple4d.x;
        this.values[1] = tuple4d.y;
        this.values[2] = tuple4d.z;
        this.values[3] = tuple4d.w;
        for (int i = 4; i < this.length; ++i) {
            this.values[i] = 0.0;
        }
    }

    public final int getSize() {
        return this.values.length;
    }

    public final double getElement(int n) {
        return this.values[n];
    }

    public final void setElement(int n, double d) {
        this.values[n] = d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.length * 8);
        for (int i = 0; i < this.length; ++i) {
            stringBuffer.append(this.values[i]).append(" ");
        }
        return stringBuffer.toString();
    }

    public int hashCode() {
        long l = 1L;
        for (int i = 0; i < this.length; ++i) {
            l = 31L * l + VecMathUtil.doubleToLongBits(this.values[i]);
        }
        return (int)(l ^ l >> 32);
    }

    public boolean equals(GVector gVector) {
        try {
            if (this.length != gVector.length) {
                return false;
            }
            for (int i = 0; i < this.length; ++i) {
                if (this.values[i] == gVector.values[i]) continue;
                return false;
            }
            return true;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            GVector gVector = (GVector)object;
            if (this.length != gVector.length) {
                return false;
            }
            for (int i = 0; i < this.length; ++i) {
                if (this.values[i] == gVector.values[i]) continue;
                return false;
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

    public boolean epsilonEquals(GVector gVector, double d) {
        if (this.length != gVector.length) {
            return false;
        }
        for (int i = 0; i < this.length; ++i) {
            double d2 = this.values[i] - gVector.values[i];
            double d3 = d2 < 0.0 ? -d2 : d2;
            if (!(d3 > d)) continue;
            return false;
        }
        return true;
    }

    public final double dot(GVector gVector) {
        if (this.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector14"));
        }
        double d = 0.0;
        for (int i = 0; i < this.length; ++i) {
            d += this.values[i] * gVector.values[i];
        }
        return d;
    }

    public final void SVDBackSolve(GMatrix gMatrix, GMatrix gMatrix2, GMatrix gMatrix3, GVector gVector) {
        if (gMatrix.nRow != gVector.getSize() || gMatrix.nRow != gMatrix.nCol || gMatrix.nRow != gMatrix2.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector15"));
        }
        if (gMatrix2.nCol != this.values.length || gMatrix2.nCol != gMatrix3.nCol || gMatrix2.nCol != gMatrix3.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector23"));
        }
        GMatrix gMatrix4 = new GMatrix(gMatrix.nRow, gMatrix2.nCol);
        gMatrix4.mul(gMatrix, gMatrix3);
        gMatrix4.mulTransposeRight(gMatrix, gMatrix2);
        gMatrix4.invert();
        this.mul(gMatrix4, gVector);
    }

    public final void LUDBackSolve(GMatrix gMatrix, GVector gVector, GVector gVector2) {
        int n;
        int n2 = gMatrix.nRow * gMatrix.nCol;
        double[] dArray = new double[n2];
        double[] dArray2 = new double[n2];
        int[] nArray = new int[gVector.getSize()];
        if (gMatrix.nRow != gVector.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector16"));
        }
        if (gMatrix.nRow != gVector2.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector24"));
        }
        if (gMatrix.nRow != gMatrix.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector25"));
        }
        for (n = 0; n < gMatrix.nRow; ++n) {
            for (int i = 0; i < gMatrix.nCol; ++i) {
                dArray[n * gMatrix.nCol + i] = gMatrix.values[n][i];
            }
        }
        for (n = 0; n < n2; ++n) {
            dArray2[n] = 0.0;
        }
        for (n = 0; n < gMatrix.nRow; ++n) {
            dArray2[n * gMatrix.nCol] = gVector.values[n];
        }
        for (n = 0; n < gMatrix.nCol; ++n) {
            nArray[n] = (int)gVector2.values[n];
        }
        GMatrix.luBacksubstitution(gMatrix.nRow, dArray, nArray, dArray2);
        for (n = 0; n < gMatrix.nRow; ++n) {
            this.values[n] = dArray2[n * gMatrix.nCol];
        }
    }

    public final double angle(GVector gVector) {
        return Math.acos(this.dot(gVector) / (this.norm() * gVector.norm()));
    }

    public final void interpolate(GVector gVector, GVector gVector2, float f) {
        this.interpolate(gVector, gVector2, (double)f);
    }

    public final void interpolate(GVector gVector, float f) {
        this.interpolate(gVector, (double)f);
    }

    public final void interpolate(GVector gVector, GVector gVector2, double d) {
        if (gVector2.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector20"));
        }
        if (this.length != gVector.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector21"));
        }
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = (1.0 - d) * gVector.values[i] + d * gVector2.values[i];
        }
    }

    public final void interpolate(GVector gVector, double d) {
        if (gVector.length != this.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector22"));
        }
        for (int i = 0; i < this.length; ++i) {
            this.values[i] = (1.0 - d) * this.values[i] + d * gVector.values[i];
        }
    }

    public Object clone() {
        GVector gVector = null;
        try {
            gVector = (GVector)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        gVector.values = new double[this.length];
        for (int i = 0; i < this.length; ++i) {
            gVector.values[i] = this.values[i];
        }
        return gVector;
    }
}


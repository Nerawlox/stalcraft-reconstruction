/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple4d;
import javax.vecmath.VecMathUtil;

public abstract class Tuple4f
implements Serializable,
Cloneable {
    static final long serialVersionUID = 7068460319248845763L;
    public float x;
    public float y;
    public float z;
    public float w;

    public Tuple4f(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public Tuple4f(float[] fArray) {
        this.x = fArray[0];
        this.y = fArray[1];
        this.z = fArray[2];
        this.w = fArray[3];
    }

    public Tuple4f(Tuple4f tuple4f) {
        this.x = tuple4f.x;
        this.y = tuple4f.y;
        this.z = tuple4f.z;
        this.w = tuple4f.w;
    }

    public Tuple4f(Tuple4d tuple4d) {
        this.x = (float)tuple4d.x;
        this.y = (float)tuple4d.y;
        this.z = (float)tuple4d.z;
        this.w = (float)tuple4d.w;
    }

    public Tuple4f() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = 0.0f;
    }

    public final void set(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public final void set(float[] fArray) {
        this.x = fArray[0];
        this.y = fArray[1];
        this.z = fArray[2];
        this.w = fArray[3];
    }

    public final void set(Tuple4f tuple4f) {
        this.x = tuple4f.x;
        this.y = tuple4f.y;
        this.z = tuple4f.z;
        this.w = tuple4f.w;
    }

    public final void set(Tuple4d tuple4d) {
        this.x = (float)tuple4d.x;
        this.y = (float)tuple4d.y;
        this.z = (float)tuple4d.z;
        this.w = (float)tuple4d.w;
    }

    public final void get(float[] fArray) {
        fArray[0] = this.x;
        fArray[1] = this.y;
        fArray[2] = this.z;
        fArray[3] = this.w;
    }

    public final void get(Tuple4f tuple4f) {
        tuple4f.x = this.x;
        tuple4f.y = this.y;
        tuple4f.z = this.z;
        tuple4f.w = this.w;
    }

    public final void add(Tuple4f tuple4f, Tuple4f tuple4f2) {
        this.x = tuple4f.x + tuple4f2.x;
        this.y = tuple4f.y + tuple4f2.y;
        this.z = tuple4f.z + tuple4f2.z;
        this.w = tuple4f.w + tuple4f2.w;
    }

    public final void add(Tuple4f tuple4f) {
        this.x += tuple4f.x;
        this.y += tuple4f.y;
        this.z += tuple4f.z;
        this.w += tuple4f.w;
    }

    public final void sub(Tuple4f tuple4f, Tuple4f tuple4f2) {
        this.x = tuple4f.x - tuple4f2.x;
        this.y = tuple4f.y - tuple4f2.y;
        this.z = tuple4f.z - tuple4f2.z;
        this.w = tuple4f.w - tuple4f2.w;
    }

    public final void sub(Tuple4f tuple4f) {
        this.x -= tuple4f.x;
        this.y -= tuple4f.y;
        this.z -= tuple4f.z;
        this.w -= tuple4f.w;
    }

    public final void negate(Tuple4f tuple4f) {
        this.x = -tuple4f.x;
        this.y = -tuple4f.y;
        this.z = -tuple4f.z;
        this.w = -tuple4f.w;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
    }

    public final void scale(float f, Tuple4f tuple4f) {
        this.x = f * tuple4f.x;
        this.y = f * tuple4f.y;
        this.z = f * tuple4f.z;
        this.w = f * tuple4f.w;
    }

    public final void scale(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
        this.w *= f;
    }

    public final void scaleAdd(float f, Tuple4f tuple4f, Tuple4f tuple4f2) {
        this.x = f * tuple4f.x + tuple4f2.x;
        this.y = f * tuple4f.y + tuple4f2.y;
        this.z = f * tuple4f.z + tuple4f2.z;
        this.w = f * tuple4f.w + tuple4f2.w;
    }

    public final void scaleAdd(float f, Tuple4f tuple4f) {
        this.x = f * this.x + tuple4f.x;
        this.y = f * this.y + tuple4f.y;
        this.z = f * this.z + tuple4f.z;
        this.w = f * this.w + tuple4f.w;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.w + ")";
    }

    public boolean equals(Tuple4f tuple4f) {
        try {
            return this.x == tuple4f.x && this.y == tuple4f.y && this.z == tuple4f.z && this.w == tuple4f.w;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Tuple4f tuple4f = (Tuple4f)object;
            return this.x == tuple4f.x && this.y == tuple4f.y && this.z == tuple4f.z && this.w == tuple4f.w;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple4f tuple4f, float f) {
        float f2 = this.x - tuple4f.x;
        float f3 = f2 < 0.0f ? -f2 : f2;
        if (f3 > f) {
            return false;
        }
        f2 = this.y - tuple4f.y;
        float f4 = f2 < 0.0f ? -f2 : f2;
        if (f4 > f) {
            return false;
        }
        f2 = this.z - tuple4f.z;
        float f5 = f2 < 0.0f ? -f2 : f2;
        if (f5 > f) {
            return false;
        }
        f2 = this.w - tuple4f.w;
        float f6 = f2 < 0.0f ? -f2 : f2;
        return !(f6 > f);
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.x);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.y);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.z);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.w);
        return (int)(l ^ l >> 32);
    }

    public final void clamp(float f, float f2, Tuple4f tuple4f) {
        this.x = tuple4f.x > f2 ? f2 : (tuple4f.x < f ? f : tuple4f.x);
        this.y = tuple4f.y > f2 ? f2 : (tuple4f.y < f ? f : tuple4f.y);
        this.z = tuple4f.z > f2 ? f2 : (tuple4f.z < f ? f : tuple4f.z);
        this.w = tuple4f.w > f2 ? f2 : (tuple4f.w < f ? f : tuple4f.w);
    }

    public final void clampMin(float f, Tuple4f tuple4f) {
        this.x = tuple4f.x < f ? f : tuple4f.x;
        this.y = tuple4f.y < f ? f : tuple4f.y;
        this.z = tuple4f.z < f ? f : tuple4f.z;
        this.w = tuple4f.w < f ? f : tuple4f.w;
    }

    public final void clampMax(float f, Tuple4f tuple4f) {
        this.x = tuple4f.x > f ? f : tuple4f.x;
        this.y = tuple4f.y > f ? f : tuple4f.y;
        this.z = tuple4f.z > f ? f : tuple4f.z;
        this.w = tuple4f.w > f ? f : tuple4f.z;
    }

    public final void absolute(Tuple4f tuple4f) {
        this.x = Math.abs(tuple4f.x);
        this.y = Math.abs(tuple4f.y);
        this.z = Math.abs(tuple4f.z);
        this.w = Math.abs(tuple4f.w);
    }

    public final void clamp(float f, float f2) {
        if (this.x > f2) {
            this.x = f2;
        } else if (this.x < f) {
            this.x = f;
        }
        if (this.y > f2) {
            this.y = f2;
        } else if (this.y < f) {
            this.y = f;
        }
        if (this.z > f2) {
            this.z = f2;
        } else if (this.z < f) {
            this.z = f;
        }
        if (this.w > f2) {
            this.w = f2;
        } else if (this.w < f) {
            this.w = f;
        }
    }

    public final void clampMin(float f) {
        if (this.x < f) {
            this.x = f;
        }
        if (this.y < f) {
            this.y = f;
        }
        if (this.z < f) {
            this.z = f;
        }
        if (this.w < f) {
            this.w = f;
        }
    }

    public final void clampMax(float f) {
        if (this.x > f) {
            this.x = f;
        }
        if (this.y > f) {
            this.y = f;
        }
        if (this.z > f) {
            this.z = f;
        }
        if (this.w > f) {
            this.w = f;
        }
    }

    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
    }

    public void interpolate(Tuple4f tuple4f, Tuple4f tuple4f2, float f) {
        this.x = (1.0f - f) * tuple4f.x + f * tuple4f2.x;
        this.y = (1.0f - f) * tuple4f.y + f * tuple4f2.y;
        this.z = (1.0f - f) * tuple4f.z + f * tuple4f2.z;
        this.w = (1.0f - f) * tuple4f.w + f * tuple4f2.w;
    }

    public void interpolate(Tuple4f tuple4f, float f) {
        this.x = (1.0f - f) * this.x + f * tuple4f.x;
        this.y = (1.0f - f) * this.y + f * tuple4f.y;
        this.z = (1.0f - f) * this.z + f * tuple4f.z;
        this.w = (1.0f - f) * this.w + f * tuple4f.w;
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


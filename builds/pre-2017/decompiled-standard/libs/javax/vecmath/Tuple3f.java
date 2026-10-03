/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple3d;
import javax.vecmath.VecMathUtil;

public abstract class Tuple3f
implements Serializable,
Cloneable {
    static final long serialVersionUID = 5019834619484343712L;
    public float x;
    public float y;
    public float z;

    public Tuple3f(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public Tuple3f(float[] fArray) {
        this.x = fArray[0];
        this.y = fArray[1];
        this.z = fArray[2];
    }

    public Tuple3f(Tuple3f tuple3f) {
        this.x = tuple3f.x;
        this.y = tuple3f.y;
        this.z = tuple3f.z;
    }

    public Tuple3f(Tuple3d tuple3d) {
        this.x = (float)tuple3d.x;
        this.y = (float)tuple3d.y;
        this.z = (float)tuple3d.z;
    }

    public Tuple3f() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    public final void set(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public final void set(float[] fArray) {
        this.x = fArray[0];
        this.y = fArray[1];
        this.z = fArray[2];
    }

    public final void set(Tuple3f tuple3f) {
        this.x = tuple3f.x;
        this.y = tuple3f.y;
        this.z = tuple3f.z;
    }

    public final void set(Tuple3d tuple3d) {
        this.x = (float)tuple3d.x;
        this.y = (float)tuple3d.y;
        this.z = (float)tuple3d.z;
    }

    public final void get(float[] fArray) {
        fArray[0] = this.x;
        fArray[1] = this.y;
        fArray[2] = this.z;
    }

    public final void get(Tuple3f tuple3f) {
        tuple3f.x = this.x;
        tuple3f.y = this.y;
        tuple3f.z = this.z;
    }

    public final void add(Tuple3f tuple3f, Tuple3f tuple3f2) {
        this.x = tuple3f.x + tuple3f2.x;
        this.y = tuple3f.y + tuple3f2.y;
        this.z = tuple3f.z + tuple3f2.z;
    }

    public final void add(Tuple3f tuple3f) {
        this.x += tuple3f.x;
        this.y += tuple3f.y;
        this.z += tuple3f.z;
    }

    public final void sub(Tuple3f tuple3f, Tuple3f tuple3f2) {
        this.x = tuple3f.x - tuple3f2.x;
        this.y = tuple3f.y - tuple3f2.y;
        this.z = tuple3f.z - tuple3f2.z;
    }

    public final void sub(Tuple3f tuple3f) {
        this.x -= tuple3f.x;
        this.y -= tuple3f.y;
        this.z -= tuple3f.z;
    }

    public final void negate(Tuple3f tuple3f) {
        this.x = -tuple3f.x;
        this.y = -tuple3f.y;
        this.z = -tuple3f.z;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public final void scale(float f, Tuple3f tuple3f) {
        this.x = f * tuple3f.x;
        this.y = f * tuple3f.y;
        this.z = f * tuple3f.z;
    }

    public final void scale(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
    }

    public final void scaleAdd(float f, Tuple3f tuple3f, Tuple3f tuple3f2) {
        this.x = f * tuple3f.x + tuple3f2.x;
        this.y = f * tuple3f.y + tuple3f2.y;
        this.z = f * tuple3f.z + tuple3f2.z;
    }

    public final void scaleAdd(float f, Tuple3f tuple3f) {
        this.x = f * this.x + tuple3f.x;
        this.y = f * this.y + tuple3f.y;
        this.z = f * this.z + tuple3f.z;
    }

    public boolean equals(Tuple3f tuple3f) {
        try {
            return this.x == tuple3f.x && this.y == tuple3f.y && this.z == tuple3f.z;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Tuple3f tuple3f = (Tuple3f)object;
            return this.x == tuple3f.x && this.y == tuple3f.y && this.z == tuple3f.z;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public boolean epsilonEquals(Tuple3f tuple3f, float f) {
        float f2 = this.x - tuple3f.x;
        float f3 = f2 < 0.0f ? -f2 : f2;
        if (f3 > f) {
            return false;
        }
        f2 = this.y - tuple3f.y;
        float f4 = f2 < 0.0f ? -f2 : f2;
        if (f4 > f) {
            return false;
        }
        f2 = this.z - tuple3f.z;
        float f5 = f2 < 0.0f ? -f2 : f2;
        return !(f5 > f);
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.x);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.y);
        l = 31L * l + (long)VecMathUtil.floatToIntBits(this.z);
        return (int)(l ^ l >> 32);
    }

    public final void clamp(float f, float f2, Tuple3f tuple3f) {
        this.x = tuple3f.x > f2 ? f2 : (tuple3f.x < f ? f : tuple3f.x);
        this.y = tuple3f.y > f2 ? f2 : (tuple3f.y < f ? f : tuple3f.y);
        this.z = tuple3f.z > f2 ? f2 : (tuple3f.z < f ? f : tuple3f.z);
    }

    public final void clampMin(float f, Tuple3f tuple3f) {
        this.x = tuple3f.x < f ? f : tuple3f.x;
        this.y = tuple3f.y < f ? f : tuple3f.y;
        this.z = tuple3f.z < f ? f : tuple3f.z;
    }

    public final void clampMax(float f, Tuple3f tuple3f) {
        this.x = tuple3f.x > f ? f : tuple3f.x;
        this.y = tuple3f.y > f ? f : tuple3f.y;
        this.z = tuple3f.z > f ? f : tuple3f.z;
    }

    public final void absolute(Tuple3f tuple3f) {
        this.x = Math.abs(tuple3f.x);
        this.y = Math.abs(tuple3f.y);
        this.z = Math.abs(tuple3f.z);
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
    }

    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
    }

    public final void interpolate(Tuple3f tuple3f, Tuple3f tuple3f2, float f) {
        this.x = (1.0f - f) * tuple3f.x + f * tuple3f2.x;
        this.y = (1.0f - f) * tuple3f.y + f * tuple3f2.y;
        this.z = (1.0f - f) * tuple3f.z + f * tuple3f2.z;
    }

    public final void interpolate(Tuple3f tuple3f, float f) {
        this.x = (1.0f - f) * this.x + f * tuple3f.x;
        this.y = (1.0f - f) * this.y + f * tuple3f.y;
        this.z = (1.0f - f) * this.z + f * tuple3f.z;
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


/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple4i
implements Serializable,
Cloneable {
    static final long serialVersionUID = 8064614250942616720L;
    public int x;
    public int y;
    public int z;
    public int w;

    public Tuple4i(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.w = n4;
    }

    public Tuple4i(int[] nArray) {
        this.x = nArray[0];
        this.y = nArray[1];
        this.z = nArray[2];
        this.w = nArray[3];
    }

    public Tuple4i(Tuple4i tuple4i) {
        this.x = tuple4i.x;
        this.y = tuple4i.y;
        this.z = tuple4i.z;
        this.w = tuple4i.w;
    }

    public Tuple4i() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    public final void set(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.w = n4;
    }

    public final void set(int[] nArray) {
        this.x = nArray[0];
        this.y = nArray[1];
        this.z = nArray[2];
        this.w = nArray[3];
    }

    public final void set(Tuple4i tuple4i) {
        this.x = tuple4i.x;
        this.y = tuple4i.y;
        this.z = tuple4i.z;
        this.w = tuple4i.w;
    }

    public final void get(int[] nArray) {
        nArray[0] = this.x;
        nArray[1] = this.y;
        nArray[2] = this.z;
        nArray[3] = this.w;
    }

    public final void get(Tuple4i tuple4i) {
        tuple4i.x = this.x;
        tuple4i.y = this.y;
        tuple4i.z = this.z;
        tuple4i.w = this.w;
    }

    public final void add(Tuple4i tuple4i, Tuple4i tuple4i2) {
        this.x = tuple4i.x + tuple4i2.x;
        this.y = tuple4i.y + tuple4i2.y;
        this.z = tuple4i.z + tuple4i2.z;
        this.w = tuple4i.w + tuple4i2.w;
    }

    public final void add(Tuple4i tuple4i) {
        this.x += tuple4i.x;
        this.y += tuple4i.y;
        this.z += tuple4i.z;
        this.w += tuple4i.w;
    }

    public final void sub(Tuple4i tuple4i, Tuple4i tuple4i2) {
        this.x = tuple4i.x - tuple4i2.x;
        this.y = tuple4i.y - tuple4i2.y;
        this.z = tuple4i.z - tuple4i2.z;
        this.w = tuple4i.w - tuple4i2.w;
    }

    public final void sub(Tuple4i tuple4i) {
        this.x -= tuple4i.x;
        this.y -= tuple4i.y;
        this.z -= tuple4i.z;
        this.w -= tuple4i.w;
    }

    public final void negate(Tuple4i tuple4i) {
        this.x = -tuple4i.x;
        this.y = -tuple4i.y;
        this.z = -tuple4i.z;
        this.w = -tuple4i.w;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
    }

    public final void scale(int n, Tuple4i tuple4i) {
        this.x = n * tuple4i.x;
        this.y = n * tuple4i.y;
        this.z = n * tuple4i.z;
        this.w = n * tuple4i.w;
    }

    public final void scale(int n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
        this.w *= n;
    }

    public final void scaleAdd(int n, Tuple4i tuple4i, Tuple4i tuple4i2) {
        this.x = n * tuple4i.x + tuple4i2.x;
        this.y = n * tuple4i.y + tuple4i2.y;
        this.z = n * tuple4i.z + tuple4i2.z;
        this.w = n * tuple4i.w + tuple4i2.w;
    }

    public final void scaleAdd(int n, Tuple4i tuple4i) {
        this.x = n * this.x + tuple4i.x;
        this.y = n * this.y + tuple4i.y;
        this.z = n * this.z + tuple4i.z;
        this.w = n * this.w + tuple4i.w;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.w + ")";
    }

    public boolean equals(Object object) {
        try {
            Tuple4i tuple4i = (Tuple4i)object;
            return this.x == tuple4i.x && this.y == tuple4i.y && this.z == tuple4i.z && this.w == tuple4i.w;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public int hashCode() {
        long l = 1L;
        l = 31L * l + (long)this.x;
        l = 31L * l + (long)this.y;
        l = 31L * l + (long)this.z;
        l = 31L * l + (long)this.w;
        return (int)(l ^ l >> 32);
    }

    public final void clamp(int n, int n2, Tuple4i tuple4i) {
        this.x = tuple4i.x > n2 ? n2 : (tuple4i.x < n ? n : tuple4i.x);
        this.y = tuple4i.y > n2 ? n2 : (tuple4i.y < n ? n : tuple4i.y);
        this.z = tuple4i.z > n2 ? n2 : (tuple4i.z < n ? n : tuple4i.z);
        this.w = tuple4i.w > n2 ? n2 : (tuple4i.w < n ? n : tuple4i.w);
    }

    public final void clampMin(int n, Tuple4i tuple4i) {
        this.x = tuple4i.x < n ? n : tuple4i.x;
        this.y = tuple4i.y < n ? n : tuple4i.y;
        this.z = tuple4i.z < n ? n : tuple4i.z;
        this.w = tuple4i.w < n ? n : tuple4i.w;
    }

    public final void clampMax(int n, Tuple4i tuple4i) {
        this.x = tuple4i.x > n ? n : tuple4i.x;
        this.y = tuple4i.y > n ? n : tuple4i.y;
        this.z = tuple4i.z > n ? n : tuple4i.z;
        this.w = tuple4i.w > n ? n : tuple4i.z;
    }

    public final void absolute(Tuple4i tuple4i) {
        this.x = Math.abs(tuple4i.x);
        this.y = Math.abs(tuple4i.y);
        this.z = Math.abs(tuple4i.z);
        this.w = Math.abs(tuple4i.w);
    }

    public final void clamp(int n, int n2) {
        if (this.x > n2) {
            this.x = n2;
        } else if (this.x < n) {
            this.x = n;
        }
        if (this.y > n2) {
            this.y = n2;
        } else if (this.y < n) {
            this.y = n;
        }
        if (this.z > n2) {
            this.z = n2;
        } else if (this.z < n) {
            this.z = n;
        }
        if (this.w > n2) {
            this.w = n2;
        } else if (this.w < n) {
            this.w = n;
        }
    }

    public final void clampMin(int n) {
        if (this.x < n) {
            this.x = n;
        }
        if (this.y < n) {
            this.y = n;
        }
        if (this.z < n) {
            this.z = n;
        }
        if (this.w < n) {
            this.w = n;
        }
    }

    public final void clampMax(int n) {
        if (this.x > n) {
            this.x = n;
        }
        if (this.y > n) {
            this.y = n;
        }
        if (this.z > n) {
            this.z = n;
        }
        if (this.w > n) {
            this.w = n;
        }
    }

    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
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


/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple3i
implements Serializable,
Cloneable {
    static final long serialVersionUID = -732740491767276200L;
    public int x;
    public int y;
    public int z;

    public Tuple3i(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public Tuple3i(int[] nArray) {
        this.x = nArray[0];
        this.y = nArray[1];
        this.z = nArray[2];
    }

    public Tuple3i(Tuple3i tuple3i) {
        this.x = tuple3i.x;
        this.y = tuple3i.y;
        this.z = tuple3i.z;
    }

    public Tuple3i() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public final void set(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public final void set(int[] nArray) {
        this.x = nArray[0];
        this.y = nArray[1];
        this.z = nArray[2];
    }

    public final void set(Tuple3i tuple3i) {
        this.x = tuple3i.x;
        this.y = tuple3i.y;
        this.z = tuple3i.z;
    }

    public final void get(int[] nArray) {
        nArray[0] = this.x;
        nArray[1] = this.y;
        nArray[2] = this.z;
    }

    public final void get(Tuple3i tuple3i) {
        tuple3i.x = this.x;
        tuple3i.y = this.y;
        tuple3i.z = this.z;
    }

    public final void add(Tuple3i tuple3i, Tuple3i tuple3i2) {
        this.x = tuple3i.x + tuple3i2.x;
        this.y = tuple3i.y + tuple3i2.y;
        this.z = tuple3i.z + tuple3i2.z;
    }

    public final void add(Tuple3i tuple3i) {
        this.x += tuple3i.x;
        this.y += tuple3i.y;
        this.z += tuple3i.z;
    }

    public final void sub(Tuple3i tuple3i, Tuple3i tuple3i2) {
        this.x = tuple3i.x - tuple3i2.x;
        this.y = tuple3i.y - tuple3i2.y;
        this.z = tuple3i.z - tuple3i2.z;
    }

    public final void sub(Tuple3i tuple3i) {
        this.x -= tuple3i.x;
        this.y -= tuple3i.y;
        this.z -= tuple3i.z;
    }

    public final void negate(Tuple3i tuple3i) {
        this.x = -tuple3i.x;
        this.y = -tuple3i.y;
        this.z = -tuple3i.z;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public final void scale(int n, Tuple3i tuple3i) {
        this.x = n * tuple3i.x;
        this.y = n * tuple3i.y;
        this.z = n * tuple3i.z;
    }

    public final void scale(int n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
    }

    public final void scaleAdd(int n, Tuple3i tuple3i, Tuple3i tuple3i2) {
        this.x = n * tuple3i.x + tuple3i2.x;
        this.y = n * tuple3i.y + tuple3i2.y;
        this.z = n * tuple3i.z + tuple3i2.z;
    }

    public final void scaleAdd(int n, Tuple3i tuple3i) {
        this.x = n * this.x + tuple3i.x;
        this.y = n * this.y + tuple3i.y;
        this.z = n * this.z + tuple3i.z;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    public boolean equals(Object object) {
        try {
            Tuple3i tuple3i = (Tuple3i)object;
            return this.x == tuple3i.x && this.y == tuple3i.y && this.z == tuple3i.z;
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
        return (int)(l ^ l >> 32);
    }

    public final void clamp(int n, int n2, Tuple3i tuple3i) {
        this.x = tuple3i.x > n2 ? n2 : (tuple3i.x < n ? n : tuple3i.x);
        this.y = tuple3i.y > n2 ? n2 : (tuple3i.y < n ? n : tuple3i.y);
        this.z = tuple3i.z > n2 ? n2 : (tuple3i.z < n ? n : tuple3i.z);
    }

    public final void clampMin(int n, Tuple3i tuple3i) {
        this.x = tuple3i.x < n ? n : tuple3i.x;
        this.y = tuple3i.y < n ? n : tuple3i.y;
        this.z = tuple3i.z < n ? n : tuple3i.z;
    }

    public final void clampMax(int n, Tuple3i tuple3i) {
        this.x = tuple3i.x > n ? n : tuple3i.x;
        this.y = tuple3i.y > n ? n : tuple3i.y;
        this.z = tuple3i.z > n ? n : tuple3i.z;
    }

    public final void absolute(Tuple3i tuple3i) {
        this.x = Math.abs(tuple3i.x);
        this.y = Math.abs(tuple3i.y);
        this.z = Math.abs(tuple3i.z);
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
    }

    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
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


/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple2i
implements Serializable,
Cloneable {
    static final long serialVersionUID = -3555701650170169638L;
    public int x;
    public int y;

    public Tuple2i(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public Tuple2i(int[] nArray) {
        this.x = nArray[0];
        this.y = nArray[1];
    }

    public Tuple2i(Tuple2i tuple2i) {
        this.x = tuple2i.x;
        this.y = tuple2i.y;
    }

    public Tuple2i() {
        this.x = 0;
        this.y = 0;
    }

    public final void set(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public final void set(int[] nArray) {
        this.x = nArray[0];
        this.y = nArray[1];
    }

    public final void set(Tuple2i tuple2i) {
        this.x = tuple2i.x;
        this.y = tuple2i.y;
    }

    public final void get(int[] nArray) {
        nArray[0] = this.x;
        nArray[1] = this.y;
    }

    public final void get(Tuple2i tuple2i) {
        tuple2i.x = this.x;
        tuple2i.y = this.y;
    }

    public final void add(Tuple2i tuple2i, Tuple2i tuple2i2) {
        this.x = tuple2i.x + tuple2i2.x;
        this.y = tuple2i.y + tuple2i2.y;
    }

    public final void add(Tuple2i tuple2i) {
        this.x += tuple2i.x;
        this.y += tuple2i.y;
    }

    public final void sub(Tuple2i tuple2i, Tuple2i tuple2i2) {
        this.x = tuple2i.x - tuple2i2.x;
        this.y = tuple2i.y - tuple2i2.y;
    }

    public final void sub(Tuple2i tuple2i) {
        this.x -= tuple2i.x;
        this.y -= tuple2i.y;
    }

    public final void negate(Tuple2i tuple2i) {
        this.x = -tuple2i.x;
        this.y = -tuple2i.y;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public final void scale(int n, Tuple2i tuple2i) {
        this.x = n * tuple2i.x;
        this.y = n * tuple2i.y;
    }

    public final void scale(int n) {
        this.x *= n;
        this.y *= n;
    }

    public final void scaleAdd(int n, Tuple2i tuple2i, Tuple2i tuple2i2) {
        this.x = n * tuple2i.x + tuple2i2.x;
        this.y = n * tuple2i.y + tuple2i2.y;
    }

    public final void scaleAdd(int n, Tuple2i tuple2i) {
        this.x = n * this.x + tuple2i.x;
        this.y = n * this.y + tuple2i.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean equals(Object object) {
        try {
            Tuple2i tuple2i = (Tuple2i)object;
            return this.x == tuple2i.x && this.y == tuple2i.y;
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
        return (int)(l ^ l >> 32);
    }

    public final void clamp(int n, int n2, Tuple2i tuple2i) {
        this.x = tuple2i.x > n2 ? n2 : (tuple2i.x < n ? n : tuple2i.x);
        this.y = tuple2i.y > n2 ? n2 : (tuple2i.y < n ? n : tuple2i.y);
    }

    public final void clampMin(int n, Tuple2i tuple2i) {
        this.x = tuple2i.x < n ? n : tuple2i.x;
        this.y = tuple2i.y < n ? n : tuple2i.y;
    }

    public final void clampMax(int n, Tuple2i tuple2i) {
        this.x = tuple2i.x > n ? n : tuple2i.x;
        this.y = tuple2i.y > n ? n : tuple2i.y;
    }

    public final void absolute(Tuple2i tuple2i) {
        this.x = Math.abs(tuple2i.x);
        this.y = Math.abs(tuple2i.y);
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
    }

    public final void clampMin(int n) {
        if (this.x < n) {
            this.x = n;
        }
        if (this.y < n) {
            this.y = n;
        }
    }

    public final void clampMax(int n) {
        if (this.x > n) {
            this.x = n;
        }
        if (this.y > n) {
            this.y = n;
        }
    }

    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
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


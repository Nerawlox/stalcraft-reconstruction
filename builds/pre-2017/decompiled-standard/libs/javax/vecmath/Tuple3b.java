/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple3b
implements Serializable,
Cloneable {
    static final long serialVersionUID = -483782685323607044L;
    public byte x;
    public byte y;
    public byte z;

    public Tuple3b(byte by, byte by2, byte by3) {
        this.x = by;
        this.y = by2;
        this.z = by3;
    }

    public Tuple3b(byte[] byArray) {
        this.x = byArray[0];
        this.y = byArray[1];
        this.z = byArray[2];
    }

    public Tuple3b(Tuple3b tuple3b) {
        this.x = tuple3b.x;
        this.y = tuple3b.y;
        this.z = tuple3b.z;
    }

    public Tuple3b() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public String toString() {
        return "(" + (this.x & 0xFF) + ", " + (this.y & 0xFF) + ", " + (this.z & 0xFF) + ")";
    }

    public final void get(byte[] byArray) {
        byArray[0] = this.x;
        byArray[1] = this.y;
        byArray[2] = this.z;
    }

    public final void get(Tuple3b tuple3b) {
        tuple3b.x = this.x;
        tuple3b.y = this.y;
        tuple3b.z = this.z;
    }

    public final void set(Tuple3b tuple3b) {
        this.x = tuple3b.x;
        this.y = tuple3b.y;
        this.z = tuple3b.z;
    }

    public final void set(byte[] byArray) {
        this.x = byArray[0];
        this.y = byArray[1];
        this.z = byArray[2];
    }

    public boolean equals(Tuple3b tuple3b) {
        try {
            return this.x == tuple3b.x && this.y == tuple3b.y && this.z == tuple3b.z;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Tuple3b tuple3b = (Tuple3b)object;
            return this.x == tuple3b.x && this.y == tuple3b.y && this.z == tuple3b.z;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public int hashCode() {
        return (this.x & 0xFF) << 0 | (this.y & 0xFF) << 8 | (this.z & 0xFF) << 16;
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


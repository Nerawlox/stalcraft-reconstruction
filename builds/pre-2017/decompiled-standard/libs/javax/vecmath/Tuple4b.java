/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;

public abstract class Tuple4b
implements Serializable,
Cloneable {
    static final long serialVersionUID = -8226727741811898211L;
    public byte x;
    public byte y;
    public byte z;
    public byte w;

    public Tuple4b(byte by, byte by2, byte by3, byte by4) {
        this.x = by;
        this.y = by2;
        this.z = by3;
        this.w = by4;
    }

    public Tuple4b(byte[] byArray) {
        this.x = byArray[0];
        this.y = byArray[1];
        this.z = byArray[2];
        this.w = byArray[3];
    }

    public Tuple4b(Tuple4b tuple4b) {
        this.x = tuple4b.x;
        this.y = tuple4b.y;
        this.z = tuple4b.z;
        this.w = tuple4b.w;
    }

    public Tuple4b() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    public String toString() {
        return "(" + (this.x & 0xFF) + ", " + (this.y & 0xFF) + ", " + (this.z & 0xFF) + ", " + (this.w & 0xFF) + ")";
    }

    public final void get(byte[] byArray) {
        byArray[0] = this.x;
        byArray[1] = this.y;
        byArray[2] = this.z;
        byArray[3] = this.w;
    }

    public final void get(Tuple4b tuple4b) {
        tuple4b.x = this.x;
        tuple4b.y = this.y;
        tuple4b.z = this.z;
        tuple4b.w = this.w;
    }

    public final void set(Tuple4b tuple4b) {
        this.x = tuple4b.x;
        this.y = tuple4b.y;
        this.z = tuple4b.z;
        this.w = tuple4b.w;
    }

    public final void set(byte[] byArray) {
        this.x = byArray[0];
        this.y = byArray[1];
        this.z = byArray[2];
        this.w = byArray[3];
    }

    public boolean equals(Tuple4b tuple4b) {
        try {
            return this.x == tuple4b.x && this.y == tuple4b.y && this.z == tuple4b.z && this.w == tuple4b.w;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        try {
            Tuple4b tuple4b = (Tuple4b)object;
            return this.x == tuple4b.x && this.y == tuple4b.y && this.z == tuple4b.z && this.w == tuple4b.w;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public int hashCode() {
        return (this.x & 0xFF) << 0 | (this.y & 0xFF) << 8 | (this.z & 0xFF) << 16 | (this.w & 0xFF) << 24;
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


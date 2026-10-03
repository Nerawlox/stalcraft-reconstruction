/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

public class zwaw
implements Comparable {
    public int _a;
    public int _b;
    public int _c;

    public zwaw() {
    }

    public zwaw(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    public zwaw(zwaw zwaw2) {
        this._a = zwaw2._a;
        this._b = zwaw2._b;
        this._c = zwaw2._c;
    }

    public boolean equals(Object object) {
        if (!(object instanceof zwaw)) {
            return false;
        }
        zwaw zwaw2 = (zwaw)object;
        return this._a == zwaw2._a && this._b == zwaw2._b && this._c == zwaw2._c;
    }

    public int hashCode() {
        return this._a + this._c << 8 + this._b << 16;
    }

    public int _a(zwaw zwaw2) {
        if (this._b == zwaw2._b) {
            if (this._c == zwaw2._c) {
                return this._a - zwaw2._a;
            }
            return this._c - zwaw2._c;
        }
        return this._b - zwaw2._b;
    }

    public void _a(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    public float _b(int n, int n2, int n3) {
        float f = this._a - n;
        float f2 = this._b - n2;
        float f3 = this._c - n3;
        return f * f + f2 * f2 + f3 * f3;
    }

    public float _b(zwaw zwaw2) {
        return this._b(zwaw2._a, zwaw2._b, zwaw2._c);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this._a((zwaw)object);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
public class jjym {
    public final int _a;
    public final int _b;

    public jjym(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    public static long _a(int n, int n2) {
        return (long)n & 0xFFFFFFFFL | ((long)n2 & 0xFFFFFFFFL) << 32;
    }

    public int hashCode() {
        long l = jjym._a(this._a, this._b);
        int n = (int)l;
        int n2 = (int)(l >> 32);
        return n ^ n2;
    }

    public boolean equals(Object object) {
        jjym jjym2 = (jjym)object;
        return jjym2._a == this._a && jjym2._b == this._b;
    }

    public int _a() {
        return (this._a << 4) + 8;
    }

    public int _b() {
        return (this._b << 4) + 8;
    }

    public xtcd _a(int n) {
        return new xtcd(this._a(), n, this._b());
    }

    public String toString() {
        return "[" + this._a + ", " + this._b + "]";
    }
}


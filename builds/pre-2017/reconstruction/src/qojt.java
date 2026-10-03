/*
 * Decompiled with CFR 0.152.
 */
public final class qojt
implements Comparable {
    public double _a;
    public double _b;
    public String _c;

    public qojt(String string, double d, double d2) {
        this._c = string;
        this._a = d;
        this._b = d2;
    }

    public int _a(qojt qojt2) {
        if (qojt2._a < this._a) {
            return -1;
        }
        if (qojt2._a > this._a) {
            return 1;
        }
        return qojt2._c.compareTo(this._c);
    }

    public int _a() {
        return (this._c.hashCode() & 0xAAAAAA) + 0x444444;
    }

    public /* synthetic */ int compareTo(Object object) {
        return this._a((qojt)object);
    }
}


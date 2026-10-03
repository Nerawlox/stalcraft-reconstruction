/*
 * Decompiled with CFR 0.152.
 */
public class htsm {
    public String _a;
    public String _b;
    public String _c;
    public String _d;
    public long _e;
    public int _f = 78;
    public String _g = "1.6.4";
    public boolean _h;
    public boolean _i = true;
    public boolean _j;
    public boolean _k;

    public htsm(String string, String string2) {
        this._a = string;
        this._b = string2;
    }

    public qoac _a() {
        qoac qoac2 = new qoac();
        qoac2._a("name", this._a);
        qoac2._a("ip", this._b);
        qoac2._a("hideAddress", this._k);
        if (!this._i) {
            qoac2._a("acceptTextures", this._j);
        }
        return qoac2;
    }

    public void _a(boolean bl) {
        this._j = bl;
        this._i = false;
    }

    public boolean _b() {
        return this._k;
    }

    public void _b(boolean bl) {
        this._k = bl;
    }

    public static htsm _a(qoac qoac2) {
        htsm htsm2 = new htsm(qoac2._j("name"), qoac2._j("ip"));
        htsm2._k = qoac2._o("hideAddress");
        if (qoac2._c("acceptTextures")) {
            htsm2._a(qoac2._o("acceptTextures"));
        }
        return htsm2;
    }
}


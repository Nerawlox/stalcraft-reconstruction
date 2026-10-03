/*
 * Decompiled with CFR 0.152.
 */
public class ixxg {
    public String _a;
    public boolean _b;
    public int _c;
    public double _d;

    public ixxg(String string) {
        this._a(string);
    }

    public void _a(String string) {
        this._a = string;
        this._b = Boolean.parseBoolean(string);
        try {
            this._c = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            this._d = Double.parseDouble(string);
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public String _a() {
        return this._a;
    }

    public boolean _b() {
        return this._b;
    }
}


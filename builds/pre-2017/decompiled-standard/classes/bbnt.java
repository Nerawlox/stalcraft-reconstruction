/*
 * Decompiled with CFR 0.152.
 */
public class bbnt
extends neqj {
    public final double _d;
    public final double _e;
    public String _f;

    public bbnt(String string, double d, double d2, double d3) {
        super(string, d);
        this._d = d2;
        this._e = d3;
        if (d2 > d3) {
            throw new IllegalArgumentException("Minimum value cannot be bigger than maximum value!");
        }
        if (d < d2) {
            throw new IllegalArgumentException("Default value cannot be lower than minimum value!");
        }
        if (d > d3) {
            throw new IllegalArgumentException("Default value cannot be bigger than maximum value!");
        }
    }

    public bbnt _a(String string) {
        this._f = string;
        return this;
    }

    public String _d() {
        return this._f;
    }

    @Override
    public double _a(double d) {
        if (d < this._d) {
            d = this._d;
        }
        if (d > this._e) {
            d = this._e;
        }
        return d;
    }
}


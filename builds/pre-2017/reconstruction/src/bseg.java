/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.AxisAlignedBB;

public class bseg
implements lpai {
    public dykk _a = qnnz._a();
    public double _b;
    public double _c;
    public double _d;

    @Override
    public void _a(double d, double d2, double d3) {
        this._b = d;
        this._c = d2;
        this._d = d3;
    }

    public boolean _a(double d, double d2, double d3, double d4, double d5, double d6) {
        return this._a._a(d - this._b, d2 - this._c, d3 - this._d, d4 - this._b, d5 - this._c, d6 - this._d);
    }

    @Override
    public boolean _a(AxisAlignedBB axisAlignedBB) {
        return this._a(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d, axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
    }

    public boolean _b(double d, double d2, double d3, double d4, double d5, double d6) {
        return this._a._b(d - this._b, d2 - this._c, d3 - this._d, d4 - this._b, d5 - this._c, d6 - this._d);
    }

    @Override
    public boolean _b(AxisAlignedBB axisAlignedBB) {
        return this._b(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d, axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
    }
}


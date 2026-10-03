/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public abstract class xqwz {
    protected ozlu _a;
    protected int _b;
    protected int _c;
    protected int _d;
    protected int _e;
    protected int _f;
    protected int _g;
    protected byte _h;
    public int[] _i = new int[0];
    public int _j;
    protected int _k;
    protected int _l;
    protected byte[] _m;
    public eidj _n = eidj._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

    public xqwz(ozlu ozlu2, int n, int n2, int n3, byte by) {
        this._a = ozlu2;
        this._b = n;
        this._c = n2;
        this._d = n3;
        this._e = n - by;
        this._f = n2 - by;
        this._g = n3 - by;
        this._a(by);
    }

    public void _a(byte by) {
        this._h = (byte)sajh._a(0, (int)by, 15);
        this._k = by * 2 + 1;
        this._l = this._k * this._k;
        this._b();
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        this._a = ozlu2;
        this._b = n;
        this._c = n2;
        this._d = n3;
        this._e = n - this._h;
        this._f = n2 - this._h;
        this._g = n3 - this._h;
        this._b();
    }

    public void _b() {
        this._k = this._h * 2 + 1;
        this._l = this._k * this._k;
        this._m = new byte[this._k * this._k * this._k];
        this._a(this._h, this._h, this._h, this._h);
        this._i = new int[this._h * this._h];
        int n = 0;
        for (int i = 0; i < this._m.length; ++i) {
            if (this._m[i] <= 0) continue;
            byte by = (byte)(i / this._l);
            byte by2 = (byte)(i % this._l / this._k);
            byte by3 = (byte)(i % this._k);
            int n2 = 0;
            int n3 = this._a.func_72798_a(this._e + by, this._f + by2, this._g + by3);
            if (n3 != 0) {
                twgu twgu2 = twgu.field_71973_m[n3];
                if (!twgu2.func_71926_d() && twgu2.func_71857_b() >= 0) {
                    n2 = (byte)(n2 | 1);
                }
                if (twgu2.func_71887_s()) {
                    n2 = (byte)(n2 | 0x80);
                }
            }
            if (!twgu.field_71970_n[n3]) {
                if (this._a(by, (byte)(by2 - 1), by3)) {
                    n2 = (byte)(n2 | 2);
                }
                if (this._a(by, (byte)(by2 + 1), by3)) {
                    n2 = (byte)(n2 | 4);
                }
                if (this._a(by, by2, (byte)(by3 + 1))) {
                    n2 = (byte)(n2 | 8);
                }
                if (this._a(by, by2, (byte)(by3 - 1))) {
                    n2 = (byte)(n2 | 0x10);
                }
                if (this._a((byte)(by + 1), by2, by3)) {
                    n2 = (byte)(n2 | 0x20);
                }
                if (this._a((byte)(by - 1), by2, by3)) {
                    n2 = (byte)(n2 | 0x40);
                }
            }
            if (n2 == 0) continue;
            if (++n >= this._i.length) {
                this._i = this._a(this._i);
            }
            this._i[n] = n2 << 24 | this._m[i] << 18 | by << 12 | by2 << 6 | by3;
        }
        this._j = n + 1;
        this._n._b(this._e, this._f, this._g, this._e + this._k, this._f + this._k, this._g + this._k);
    }

    private int[] _a(int[] nArray) {
        int[] nArray2 = new int[nArray.length * 2];
        for (int i = 0; i < nArray.length; ++i) {
            nArray2[i] = nArray[i];
        }
        return nArray2;
    }

    private boolean _a(byte by, byte by2, byte by3) {
        int n = this._a.func_72798_a(this._e + by, this._f + by2, this._g + by3);
        return twgu.field_71970_n[n];
    }

    private void _a(byte by, byte by2, byte by3, byte by4) {
        int n = by * this._l + by2 * this._k + by3;
        byte by5 = this._m[n];
        if (by5 < by4) {
            int n2 = this._a.getBlockLightOpacity(this._e + by, this._f + by2, this._g + by3);
            boolean bl = n2 > 15;
            this._m[n] = by4;
            by4 = bl ? (byte)0 : (byte)(by4 - (n2 + 1));
            if (by4 > 0) {
                this._a((byte)(by - 1), by2, by3, by4);
                this._a((byte)(by + 1), by2, by3, by4);
                this._a(by, (byte)(by2 - 1), by3, by4);
                this._a(by, (byte)(by2 + 1), by3, by4);
                this._a(by, by2, (byte)(by3 - 1), by4);
                this._a(by, by2, (byte)(by3 + 1), by4);
            }
        }
    }

    public boolean _a() {
        return true;
    }

    public void _c() {
        GL11.glBlendFunc(770, 1);
    }

    public boolean _a(int n, int n2, int n3) {
        byte by = 0;
        by += sajh._a(n - this._b);
        by += sajh._a(n2 - this._c);
        return (by += sajh._a(n3 - this._d)) < this._h;
    }

    public ozlu _d() {
        return this._a;
    }

    public int _e() {
        return this._b;
    }

    public int _f() {
        return this._c;
    }

    public int _g() {
        return this._d;
    }

    public abstract void _a(int var1);
}


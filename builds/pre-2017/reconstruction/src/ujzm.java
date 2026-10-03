/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;

public class ujzm {
    public int _a;
    public int _b;
    public int _c;
    public byte[] _d;
    public wqak _e;
    public wqak _f;
    public wqak _g;
    public wqak _h;

    public ujzm(int n, boolean bl) {
        this._a = n;
        this._d = new byte[4096];
        this._f = new wqak(this._d.length, 4);
        this._g = new wqak(this._d.length, 4);
        if (bl) {
            this._h = new wqak(this._d.length, 4);
        }
    }

    public int _a(int n, int n2, int n3) {
        int n4 = this._d[n2 << 8 | n3 << 4 | n] & 0xFF;
        if (this._e != null) {
            return this._e._a(n, n2, n3) << 8 | n4;
        }
        return n4;
    }

    public void _a(int n, int n2, int n3, int n4) {
        int n5 = this._d[n2 << 8 | n3 << 4 | n] & 0xFF;
        if (this._e != null) {
            n5 = this._e._a(n, n2, n3) << 8 | n5;
        }
        if (n5 == 0 && n4 != 0) {
            ++this._b;
            if (Block.blocksList[n4] != null && Block.blocksList[n4].getTickRandomly()) {
                ++this._c;
            }
        } else if (n5 != 0 && n4 == 0) {
            --this._b;
            if (Block.blocksList[n5] != null && Block.blocksList[n5].getTickRandomly()) {
                --this._c;
            }
        } else if (Block.blocksList[n5] != null && Block.blocksList[n5].getTickRandomly() && (Block.blocksList[n4] == null || !Block.blocksList[n4].getTickRandomly())) {
            --this._c;
        } else if ((Block.blocksList[n5] == null || !Block.blocksList[n5].getTickRandomly()) && Block.blocksList[n4] != null && Block.blocksList[n4].getTickRandomly()) {
            ++this._c;
        }
        this._d[n2 << 8 | n3 << 4 | n] = (byte)(n4 & 0xFF);
        if (n4 > 255) {
            if (this._e == null) {
                this._e = new wqak(this._d.length, 4);
            }
            this._e._a(n, n2, n3, (n4 & 0xF00) >> 8);
        } else if (this._e != null) {
            this._e._a(n, n2, n3, 0);
        }
    }

    public int _b(int n, int n2, int n3) {
        return this._f._a(n, n2, n3);
    }

    public void _b(int n, int n2, int n3, int n4) {
        this._f._a(n, n2, n3, n4);
    }

    public boolean _a() {
        return this._b == 0;
    }

    public boolean _b() {
        return this._c > 0;
    }

    public int _c() {
        return this._a;
    }

    public void _c(int n, int n2, int n3, int n4) {
        this._h._a(n, n2, n3, n4);
    }

    public int _c(int n, int n2, int n3) {
        return this._h._a(n, n2, n3);
    }

    public void _d(int n, int n2, int n3, int n4) {
        this._g._a(n, n2, n3, n4);
    }

    public int _d(int n, int n2, int n3) {
        return this._g._a(n, n2, n3);
    }

    public void _d() {
        this._b = 0;
        this._c = 0;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    int n = this._a(i, j, k);
                    if (n <= 0) continue;
                    if (Block.blocksList[n] == null) {
                        this._d[j << 8 | k << 4 | i] = 0;
                        if (this._e == null) continue;
                        this._e._a(i, j, k, 0);
                        continue;
                    }
                    ++this._b;
                    if (!Block.blocksList[n].getTickRandomly()) continue;
                    ++this._c;
                }
            }
        }
    }

    public byte[] _e() {
        return this._d;
    }

    public void _f() {
        this._e = null;
    }

    public wqak _g() {
        return this._e;
    }

    public wqak _h() {
        return this._f;
    }

    public wqak _i() {
        return this._g;
    }

    public wqak _j() {
        return this._h;
    }

    public void _a(byte[] byArray) {
        this._d = byArray;
    }

    public void _a(wqak wqak2) {
        this._e = wqak2;
    }

    public void _b(wqak wqak2) {
        this._f = wqak2;
    }

    public void _c(wqak wqak2) {
        this._g = wqak2;
    }

    public void _d(wqak wqak2) {
        this._h = wqak2;
    }

    public wqak _k() {
        this._e = new wqak(this._d.length, 4);
        return this._e;
    }
}


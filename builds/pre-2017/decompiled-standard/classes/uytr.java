/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class uytr {
    public static final int _a = 128;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public String _i;
    public int _j;
    public int _k;
    public int _l;
    public int _m;
    public int _n;
    public int _o;
    public int _p;
    public static final int _q = 131072;
    public static final int _r = 4;
    public static final int _s = 1;
    public static final int _t = 512;
    public static final int _u = 1024;
    public static final int _v = 2048;
    public static final int _w = 4096;
    public static final int _x = 8192;
    public static final int _y = 16384;
    public static final int _z = 32768;
    public static final int _A = 0x200000;
    public final qmig _B;

    public uytr(hbom hbom2) throws IOException {
        byte[] byArray = new byte[4];
        hbom2.read(byArray);
        String string = new String(byArray, "US-ASCII");
        if (!string.equals("DDS ") && !string.equals("ERK ")) {
            throw new IOException("Bad magic: " + string);
        }
        int n = hbom2.readInt();
        if (n != 124) {
            throw new IOException("Wrong header size: " + n);
        }
        this._b = hbom2.readInt();
        this._c = hbom2.readInt();
        this._d = hbom2.readInt();
        this._e = hbom2.readInt();
        this._f = hbom2.readInt();
        this._g = hbom2.readInt();
        hbom2.skip(44L);
        n = hbom2.readInt();
        if (n != 32) {
            throw new IOException("Wrong pixel format size: " + n);
        }
        this._h = hbom2.readInt();
        hbom2.read(byArray);
        this._i = (this._h & 4) == 0 ? null : new String(byArray, "US-ASCII");
        this._j = hbom2.readInt();
        this._k = hbom2.readInt();
        this._l = hbom2.readInt();
        this._m = hbom2.readInt();
        this._n = hbom2.readInt();
        this._o = hbom2.readInt();
        this._p = hbom2.readInt();
        hbom2.skip(8L);
        hbom2.skip(4L);
        this._B = this._f();
        if (this._e()) {
            for (int i = 0; i < 6; ++i) {
                if (this._a(i)) continue;
                throw new IOException("Missing cubemap face " + i);
            }
        }
    }

    public int _a() {
        return (this._b & 0x20000) == 0 ? 1 : this._g;
    }

    public int _b() {
        return this._d * this._c;
    }

    public boolean _c() {
        return (this._h & 1) != 0;
    }

    public boolean _d() {
        return (this._p & 0x200000) != 0;
    }

    public boolean _e() {
        return (this._p & 0x200) != 0;
    }

    public boolean _a(int n) {
        if (n < 0 || n > 5) {
            throw new IllegalArgumentException("Invalid layer");
        }
        return (this._p & 1024 << n) != 0;
    }

    private qmig _f() throws IOException {
        if (this._i()) {
            return this._j();
        }
        if (this._k()) {
            return this._l();
        }
        if (this._g()) {
            return this._h();
        }
        throw new IOException("Unknown format: " + this._i);
    }

    private boolean _g() {
        return this._i == null;
    }

    private qmig _h() throws IOException {
        if (this._k == 255 && this._l == 65280 && this._m == 0xFF0000) {
            if ((this._h & 1) == 0) {
                throw new IOException("R8G8B8 dds format is not supported");
            }
            if (this._n == -16777216) {
                return qmig._a;
            }
        } else if (this._k == 0xFF0000 && this._l == 65280 && this._m == 255) {
            if ((this._h & 1) == 0) {
                throw new IOException("R8G8B8 dds format is not supported");
            }
            if (this._n == -16777216) {
                return qmig._b;
            }
        }
        throw new IOException("Unknown format: " + this._k + "/" + this._l + "/" + this._m + "/" + this._n);
    }

    private boolean _i() {
        int n;
        if (this._i == null) {
            return false;
        }
        for (n = 1; n < this._i.length(); ++n) {
            if (this._i.charAt(n) == '\u0000') continue;
            return false;
        }
        n = this._i.charAt(0);
        return n >= 111 && n <= 116;
    }

    private qmig _j() throws IOException {
        char c = this._i.charAt(0);
        if (c == 'o') {
            return qmig._g;
        }
        if (c == 'p') {
            return qmig._h;
        }
        if (c == 'q') {
            return qmig._i;
        }
        if (c == 'r') {
            return qmig._j;
        }
        if (c == 's') {
            return qmig._k;
        }
        if (c == 't') {
            return qmig._l;
        }
        throw new IOException("Unknown float format: " + this._i);
    }

    private boolean _k() {
        return this._i != null && this._i.startsWith("DXT") || "ATI2".equals(this._i);
    }

    private qmig _l() throws IOException {
        if ("DXT1".equals(this._i)) {
            return qmig._c;
        }
        if ("DXT3".equals(this._i)) {
            return qmig._d;
        }
        if ("DXT5".equals(this._i)) {
            return qmig._e;
        }
        if ("ATI2".equals(this._i)) {
            return qmig._f;
        }
        throw new IOException("Unknown compressed format: " + this._i);
    }
}


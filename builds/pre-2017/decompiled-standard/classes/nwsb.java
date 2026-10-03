/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class nwsb
extends thcx {
    public static final int _b = 0;
    public static final int _c = 1;
    public static final int _d = 2;
    protected static final String _e = "D";
    protected static final String _f = System.getProperty("line.separator");
    protected static final int _g = 203;
    protected static final int _h = 205;
    protected String _i = "";
    protected String _j = "";
    protected String _k = "";
    protected mcmy _l;
    protected int _m;
    protected int _n;
    protected int _o;
    protected int _p;
    protected int _q;
    protected int _r;
    protected int _s;
    protected int _t;
    protected int _u;
    protected int _v;
    protected long _J = 0L;
    protected long _K = 0L;
    protected boolean _L;
    protected ditq _M;

    public nwsb(ywry ywry2, int n, int n2) {
        super(ywry2, n);
        this._m = n2;
        this._n = n2;
        this._r = -1;
        this._s = -4473925;
        this._o = 4;
        this._p = 2;
        this._l = yfpk._b;
        this._q = 0;
        this._t = 0;
        this._E = true;
        this._L = false;
        this._M = new bcpm();
        this._m();
    }

    public nwsb(ywry ywry2, int n, int n2, int n3, int n4) {
        this(ywry2, n, n2);
        this._d(n3, n4);
    }

    public nwsb _a(int n) {
        this._n = n;
        this._m();
        return this;
    }

    public nwsb _a(mcmy mcmy2) {
        this._l = mcmy2;
        this._m();
        return this;
    }

    public nwsb _a(String string) {
        this._k = string;
        return this;
    }

    public nwsb _b(int n) {
        this._u = Math.max(0, Math.min(2, n));
        return this;
    }

    public nwsb _c(int n) {
        this._v = Math.max(0, Math.min(2, n));
        return this;
    }

    public int _c(String string) {
        int n = this._b().length();
        this._i = string;
        return n -= this._b().length();
    }

    public String _b() {
        return this._i;
    }

    protected void _d(String string) {
        this._j = string;
    }

    protected String _c() {
        return this._j;
    }

    public void _e(int n) {
        this._q = this._f(n);
    }

    public void _a() {
        int n = this._A - this._o;
        this._d(this._b(this._b(), n, this._t));
    }

    protected int _f(int n) {
        return Math.max(0, Math.min(n, this._b().length()));
    }

    protected int _c(int n, int n2, int n3) {
        return Math.max(n2, Math.min(n, n3));
    }

    @Override
    public void _a(char c, int n) {
        this._c(c, n);
    }

    @Override
    public void _a(int n, int n2, int n3) {
        super._a(n, n2, n3);
        this._b(n, n2);
    }

    public void _c(int n, int n2) {
        this._o = n;
        this._p = n2;
    }

    public void _b(int n, int n2) {
        int n3 = n - this._y;
        String string = this._l._a(this._b(), n3 -= this._o);
        int n4 = this._b().length() - this._c().length();
        this._e(string.length() + (n4 - this._t));
    }

    public void _c(char c, int n) {
        StringBuilder stringBuilder = new StringBuilder(this._b());
        int n2 = this._b().length() - this._c().length();
        if (this._b().length() > 0 && this._q > 0) {
            if (gqjz.func_73861_o() && ((byte)c == 127 || (byte)c == 8)) {
                int n3 = this._b().length();
                String string = this._b().substring(0, this._q);
                n3 = (string = string.replaceAll(" +", " ")).contains(" ") ? (n3 -= stringBuilder.delete(string.lastIndexOf(" "), this._q).length()) : (n3 -= stringBuilder.delete(0, this._q).length());
                this._t = this._c(this._t - n3, 0, n2);
                this._c(stringBuilder.toString());
                this._e(this._q - n3);
                this._a();
                this._J = 0L;
                return;
            }
            if ((byte)c == 8) {
                stringBuilder.deleteCharAt(this._q - 1);
                this._t = this._c(this._t - 1, 0, n2);
                this._c(stringBuilder.toString());
                this._e(this._q - 1);
                this._a();
                this._J = 0L;
                return;
            }
        }
        if (n == 203) {
            int n4 = this._b().length() - this._c().length();
            int n5 = this._f(this._q - n4 + this._t);
            if (n5 <= 0) {
                this._t = this._c(this._t + 1, 0, n4);
                this._a();
                n4 = this._b().length() - this._c().length();
                this._e(n4 - this._t);
                return;
            }
            this._e(this._q - 1);
            return;
        }
        if (n == 205) {
            int n6 = this._b().length() - this._c().length();
            int n7 = this._q;
            if (n7 >= this._c().length()) {
                this._t = this._c(this._t - 1, 0, n6);
                this._a();
            }
            this._e(this._q + 1);
            return;
        }
        if (this._b().length() >= this._m) {
            return;
        }
        if (!this._l._c.contains(c + "")) {
            return;
        }
        if (!this._M._a(c)) {
            return;
        }
        stringBuilder.insert(this._q, c);
        if (!this._M._a(stringBuilder.toString())) {
            return;
        }
        this._c(stringBuilder.toString());
        this._a();
        this._e(this._q + 1);
        this._J = 0L;
    }

    public nwsb _a(ditq ditq2) {
        this._M = ditq2;
        return this;
    }

    public String _b(String string, int n, int n2) {
        return this._l._b(string.substring(0, string.length() - n2), n);
    }

    @Override
    public thcx _a(int[] nArray) {
        this._L = true;
        return super._a(nArray);
    }

    @Override
    public void _a(xpzm xpzm2, int n, int n2) {
        if (!this._L) {
            qozx._b(0, 0, this._A, this._B, -1610612736);
        } else {
            super._a(xpzm2, n, n2);
        }
    }

    @Override
    public void _b(xpzm xpzm2, int n, int n2) {
        GL11.glPushMatrix();
        StringBuilder stringBuilder = new StringBuilder(this._c());
        int n3 = this._b().length() - this._c().length();
        boolean bl = this._l._a(this._b()) <= (double)this._A;
        this._J += System.currentTimeMillis() - this._K;
        int n4 = this._c(this._q + this._t - n3, 0, this._c().length());
        if (this._l()) {
            stringBuilder.insert(n4, this._J % 1000L < 600L ? "\t" : "");
        }
        int n5 = this._u;
        int n6 = this._o;
        int n7 = this._r;
        if (this._b().length() == 0 && !this._l()) {
            stringBuilder = new StringBuilder(this._k);
            n7 = this._s;
            n5 = 1;
            n6 = 0;
        }
        double d = this._l._a(stringBuilder.toString());
        int n8 = 0;
        int n9 = 0;
        if (n5 == 1) {
            n8 = this._A / 2;
        }
        if (this._v == 1) {
            n9 = this._B / 4;
        }
        if (n5 == 2) {
            n8 = (int)((double)this._A - d / 4.0);
        }
        if (this._v == 2) {
            n9 = this._B / 2;
        }
        n8 += n6 / 2;
        n9 -= this._p / 2;
        if (n5 > 0) {
            this._a(stringBuilder.toString(), (int)((double)n8 - this._l._a(stringBuilder.toString()) / 2.0), n9, n7);
        } else {
            this._a(stringBuilder.toString(), n8, n9, n7);
        }
        this._K = System.currentTimeMillis();
        GL11.glPopMatrix();
        if (this._f(n, n2) && this._k() && !bl) {
            this._a(this._b(), n, n2);
        }
    }

    public void _a(String string, int n, int n2, int n3) {
        this._l._b(string, n, n2, n3);
    }

    public boolean _d() {
        return this._L;
    }

    public void _a(String string, int n, int n2) {
        GL11.glTranslated(8.0, -8.0, 0.0);
        int n3 = (int)(this._l._a(this._b()) + (double)this._o);
        qozx._b(0, 0, n3, this._B, 0x70000000);
        GL11.glTranslated(this._o / 2, -this._p / 2, 0.0);
        this._l._b(this._b(), 0.0, 0.0, -1);
    }

    @Override
    public void _m() {
        int n = (int)this._l._a(_e);
        int n2 = (int)(this._l._b(_e) + (double)this._p);
        this._A = this._n * n + this._o / 2;
        this._B = n2;
    }

    public static int _a(String string, String string2, int n) throws IndexOutOfBoundsException {
        int n2 = -1;
        Pattern pattern = Pattern.compile(string2, 8);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            if (--n != 0) continue;
            n2 = matcher.start();
            break;
        }
        if (n2 < 0) {
            return -1;
        }
        return n2;
    }
}


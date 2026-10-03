/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import net.minecraft.util.ResourceLocation;

public class kkwv
extends jyth<temw>
implements ejfb {
    public static boolean _a = true;
    private final boolean _c;
    private temw _d;
    private int _e = -1;
    private long[] _g;
    private static final float _h = (float)Math.log(2.0);

    public kkwv(ResourceLocation resourceLocation, boolean bl) {
        super(resourceLocation);
        this._c = bl;
        this._c(20000);
    }

    public kkwv _a(int n) {
        this._e = n;
        return this;
    }

    protected temw _a() {
        return (temw)super._f();
    }

    @Override
    protected void _a(temw temw2) {
        if (this._c()) {
            temw2._b = new hbmw(temw2, null, -1);
        }
        super._a(temw2);
    }

    @Override
    public void func_110551_a(xsfs xsfs2) throws IOException {
    }

    @Override
    public int func_110552_b() {
        temw temw2 = (temw)this._u_();
        if (temw2 == null) {
            if (this._r()) {
                return fmib._b(this._e());
            }
            return fmib._a(this._e());
        }
        return temw2.func_110552_b();
    }

    @Override
    public void _a(float f) {
        temw temw2 = (temw)this._u_();
        if (!this._c()) {
            this._a(temw2, 0);
            return;
        }
        if (temw2 != null && temw2._c()._c()) {
            float f2 = temw2._c()._a;
            float f3 = temw2._c()._b;
            float f4 = f2 * f3;
            int n = Math.max(0, (int)(0.5 * (double)kkwv._b(f4 / f)));
            this._a(temw2, n);
        }
    }

    @Override
    public void _b(int n) {
        temw temw2 = (temw)this._u_();
        if (!this._c()) {
            this._a(temw2, 0);
            return;
        }
        if (temw2 != null && temw2._c()._c()) {
            this._a(temw2, n);
        }
    }

    private void _a(temw temw2, int n) {
        if (temw2 == null || !temw2._c()._c() || this._d != null) {
            return;
        }
        if (this._g != null && n < this._g.length) {
            this._g[n] = System.currentTimeMillis();
        }
        if (temw2._b._c() > n) {
            this._b(temw2, n);
        }
    }

    private static float _b(float f) {
        return (float)Math.log(f) / _h;
    }

    private void _b(temw temw2, int n) {
        this._d = (temw)hsju._a._b(this._b);
        temw temw3 = qmdg._a._h() ? null : temw2;
        this._d._b = new hbmw(this._d, temw3, n);
        this._d.onLoaded(() -> {
            temw temw2 = (temw)super._u_();
            this._a(this._d, oxca.kjui._c);
            if (temw2 != null) {
                temw2.release();
            }
            this._d = null;
        });
        this._d.load(true);
    }

    @Override
    public int _e() {
        temw temw2 = (temw)this._u_();
        if (temw2 != null) {
            return temw2._e();
        }
        if (this._e >= 0) {
            return this._e;
        }
        return 3553;
    }

    @Override
    protected void _a(temw temw2, oxca.kjui kjui2) {
        super._a(temw2, kjui2);
        if (kjui2 == oxca.kjui._c && temw2 != null && temw2._b != null) {
            long l = System.currentTimeMillis();
            this._g = new long[temw2._c()._c];
            for (int i = 0; i < this._g.length; ++i) {
                this._g[i] = l;
            }
        }
    }

    @Override
    protected boolean _t_() {
        if (this._d != null) {
            return false;
        }
        if (super._t_()) {
            return true;
        }
        if (this._q() && this._c()) {
            temw temw2 = (temw)this._h();
            if (this._g != null && temw2._b != null) {
                int n;
                int n2 = Integer.MAX_VALUE;
                boolean bl = false;
                long l = System.currentTimeMillis();
                for (int i = n = temw2._b._c(); i < this._g.length; ++i) {
                    if (this._g[i] + (long)this._f > l || !temw2._b._a(i)) {
                        n2 = i;
                        break;
                    }
                    if (this._g[i] + (long)(this._f * 2) >= l) continue;
                    bl = true;
                }
                if (bl && n2 > temw2._b._c()) {
                    this._b(temw2, n2);
                }
            }
        }
        return false;
    }

    public boolean _c() {
        return this._c && _a;
    }

    @Override
    protected /* synthetic */ uytm _f() {
        return this._a();
    }
}


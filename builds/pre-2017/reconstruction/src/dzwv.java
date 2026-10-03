/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class dzwv
extends thcx {
    public static final int _m = 0;
    public static final int _n = 1;
    public static final int _o = 2;
    private boolean _a = false;
    protected String _p = "";
    protected mcmy _q;
    protected int _r = 1;
    protected int _s = 1;
    protected int _t;
    protected int _u;
    protected int _v = -1;

    public dzwv(ywry ywry2, int n) {
        super(ywry2, n);
        this._a();
        this._a(dium._a.get("btn_long"));
        this._c(0, -2);
    }

    public dzwv _a(int n) {
        this._v = n;
        return this;
    }

    public dzwv _c(int n, int n2) {
        this._t = n;
        this._u = n2;
        return this;
    }

    public dzwv _a(mcmy mcmy2) {
        if (mcmy2 != null) {
            this._q = mcmy2;
        }
        return this;
    }

    public void _a() {
        this._q = yfpk._c;
    }

    public dzwv _a(String string) {
        this._p = string;
        return this;
    }

    public void _b() {
        this._F._a((thcx)this);
    }

    @Override
    public void _a(char c, int n) {
        if (this._l() && n == 57) {
            this._b();
        }
    }

    public void _b(int n) {
        this._r = Math.max(0, Math.min(2, n));
    }

    public void _c(int n) {
        this._s = Math.max(0, Math.min(2, n));
    }

    @Override
    public void _a(int n, int n2, int n3) {
        this._b();
    }

    public void _a(boolean bl) {
        this._a = bl;
    }

    public boolean _c() {
        return this._a && this._k();
    }

    @Override
    public void _a(Minecraft minecraft, int n, int n2) {
        super._a(minecraft, n, n2);
        this._a(this._f(n, n2));
        double d = 1.0;
        if (this._c()) {
            d -= 0.15;
        }
        GL11.glColor4d(d, d, d, 1.0);
        this._b(n, n2);
        if (this._l()) {
            this._d();
        }
    }

    @Override
    public void _b(Minecraft minecraft, int n, int n2) {
        super._b(minecraft, n, n2);
        double d = this._q._a(this._p);
        int n3 = 0;
        int n4 = 0;
        if (this._r == 1) {
            n3 = this._A / 2;
        }
        if (this._s == 1) {
            n4 = this._B / 4;
        }
        if (this._r == 2) {
            n3 = (int)((double)this._A - d / 4.0);
        }
        if (this._s == 2) {
            n4 = this._B / 2;
        }
        n3 += this._t / 2;
        n4 += this._u / 2;
        if (this._r > 0) {
            this._q._a(this._p, n3, n4, this._v, 1.0f);
        } else {
            this._q._b(this._p, n3, n4, this._v);
        }
    }

    protected void _b(int n, int n2) {
        qozx._a(0, 0, this._I);
    }

    protected void _d() {
    }
}


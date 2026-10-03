/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class ditu
extends dzwv {
    protected boolean _a = true;
    protected boolean _b = false;

    public ditu(ywry ywry2, int n) {
        super(ywry2, n);
    }

    public ditu _e(boolean bl) {
        this._b = bl;
        return this;
    }

    public ditu _f(boolean bl) {
        this._a = bl;
        return this;
    }

    @Override
    public void _a(xpzm xpzm2, int n, int n2) {
        super._a(xpzm2, n, n2);
        this._a(this._f(n, n2));
        double d = 1.0;
        if (this._c() && !this._b) {
            d -= 0.15;
        }
        if (this._a && !this._b) {
            d -= 0.3;
        }
        GL11.glColor4d(d, d, d, 1.0);
        this._b(n, n2);
        if (this._l()) {
            this._d();
        }
    }

    @Override
    public void _m() {
        super._m();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.Tessellator;

public class ekfb
extends ohcb {
    public final /* synthetic */ xaxz _n;

    public ekfb(xaxz xaxz2) {
        this._n = xaxz2;
        super(xaxz._a(xaxz2), xaxz._b(xaxz2), xaxz._a(xaxz2, 2), xaxz._c(xaxz2), xaxz._a(xaxz2, 9) - xaxz._a(xaxz2, 2), 12);
    }

    @Override
    public int _a() {
        return xaxz._d((xaxz)this._n)._f.size() + 1;
    }

    @Override
    public void _a(int n, boolean bl) {
        if (n >= xaxz._d((xaxz)this._n)._f.size()) {
            return;
        }
        xaxz._b(this._n, n);
    }

    @Override
    public boolean _a(int n) {
        return n == xaxz._e(this._n);
    }

    @Override
    public int _b() {
        return this._a() * 12;
    }

    @Override
    public void _c() {
    }

    @Override
    public void _a(int n, int n2, int n3, int n4, Tessellator tessellator) {
        if (n < xaxz._d((xaxz)this._n)._f.size()) {
            this._b(n, n2, n3, n4, tessellator);
        }
    }

    public void _b(int n, int n2, int n3, int n4, Tessellator tessellator) {
        String string = (String)xaxz._d((xaxz)this._n)._f.get(n);
        this._n.drawString(xaxz._f(this._n), string, n2 + 2, n3 + 1, 0xFFFFFF);
    }
}


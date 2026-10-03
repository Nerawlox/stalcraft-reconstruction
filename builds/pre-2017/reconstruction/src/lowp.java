/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.Gui;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class lowp
extends maxt {
    public final /* synthetic */ htmo _u;

    public lowp(htmo htmo2) {
        this._u = htmo2;
        super(htmo._f(htmo2), htmo2.width, htmo2.height, 32, htmo2.height - 64, 36);
    }

    @Override
    public int _a() {
        return htmo._c(this._u).size() + 1;
    }

    @Override
    public void _a(int n, boolean bl) {
        if (n >= htmo._c(this._u).size()) {
            return;
        }
        McoServer mcoServer = (McoServer)htmo._c(this._u).get(n);
        htmo._b(this._u, mcoServer._a);
        htmo._h((htmo)this._u).displayString = !htmo._g(this._u)._P()._a().equals(mcoServer._e) ? wpcz._a("mco.selectServer.leave") : wpcz._a("mco.selectServer.configure");
        boolean bl2 = htmo._i((htmo)this._u).enabled = mcoServer._d.equals("OPEN") && !mcoServer._h;
        if (bl && htmo._i((htmo)this._u).enabled) {
            htmo._c(this._u, htmo._a(this._u));
        }
    }

    @Override
    public boolean _a(int n) {
        return n == htmo._d(this._u, htmo._a(this._u));
    }

    @Override
    public boolean _b(int n) {
        try {
            return n >= 0 && n < htmo._c(this._u).size() && ((McoServer)htmo._c((htmo)this._u).get((int)n))._e.toLowerCase().equals(htmo._j(this._u)._P()._a());
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public int _b() {
        return this._a() * 36;
    }

    @Override
    public void _c() {
        this._u.drawDefaultBackground();
    }

    @Override
    public void _a(int n, int n2, int n3, int n4, Tessellator tessellator) {
        if (n < htmo._c(this._u).size()) {
            this._b(n, n2, n3, n4, tessellator);
        }
    }

    public void _b(int n, int n2, int n3, int n4, Tessellator tessellator) {
        McoServer mcoServer = (McoServer)htmo._c(this._u).get(n);
        this._u.drawString(htmo._k(this._u), mcoServer._b(), n2 + 2, n3 + 1, 0xFFFFFF);
        int n5 = 207;
        int n6 = 1;
        if (mcoServer._h) {
            htmo._a(this._u, n2 + n5, n3 + n6, this._k, this._l);
        } else if (mcoServer._d.equals("CLOSED")) {
            htmo._b(this._u, n2 + n5, n3 + n6, this._k, this._l);
        } else if (mcoServer._e.equals(htmo._l(this._u)._P()._a()) && mcoServer._k < 7) {
            this._a(n, n2 - 14, n3, mcoServer);
            htmo._a(this._u, n2 + n5, n3 + n6, this._k, this._l, mcoServer._k);
        } else if (mcoServer._d.equals("OPEN")) {
            htmo._c(this._u, n2 + n5, n3 + n6, this._k, this._l);
            this._a(n, n2 - 14, n3, mcoServer);
        }
        this._u.drawString(htmo._m(this._u), mcoServer._a(), n2 + 2, n3 + 12, 0x6C6C6C);
        this._u.drawString(htmo._n(this._u), mcoServer._e, n2 + 2, n3 + 12 + 11, 0x4C4C4C);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(int n, int n2, int n3, McoServer mcoServer) {
        if (mcoServer._g == null) {
            return;
        }
        Object object = htmo._e();
        synchronized (object) {
            if (htmo._f() < 5 && (!mcoServer._n || mcoServer._o)) {
                new qnif(this, mcoServer).start();
            }
        }
        if (mcoServer._m != null) {
            this._u.drawString(htmo._o(this._u), mcoServer._m, n2 + 215 - htmo._p(this._u)._b(mcoServer._m), n3 + 1, 0x808080);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        htmo._q(this._u)._R()._a(Gui.icons);
    }
}


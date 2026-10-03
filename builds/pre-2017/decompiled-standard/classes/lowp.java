/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.opengl.GL11;

public class lowp
extends maxt {
    public final /* synthetic */ htmo _u;

    public lowp(htmo htmo2) {
        this._u = htmo2;
        super(htmo._f(htmo2), htmo2.field_73880_f, htmo2.field_73881_g, 32, htmo2.field_73881_g - 64, 36);
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
        rqmh rqmh2 = (rqmh)htmo._c(this._u).get(n);
        htmo._b(this._u, rqmh2._a);
        htmo._h((htmo)this._u).field_73744_e = !htmo._g(this._u)._P()._a().equals(rqmh2._e) ? wpcz._a("mco.selectServer.leave") : wpcz._a("mco.selectServer.configure");
        boolean bl2 = htmo._i((htmo)this._u).field_73742_g = rqmh2._d.equals("OPEN") && !rqmh2._h;
        if (bl && htmo._i((htmo)this._u).field_73742_g) {
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
            return n >= 0 && n < htmo._c(this._u).size() && ((rqmh)htmo._c((htmo)this._u).get((int)n))._e.toLowerCase().equals(htmo._j(this._u)._P()._a());
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
        this._u.func_73873_v_();
    }

    @Override
    public void _a(int n, int n2, int n3, int n4, htvf htvf2) {
        if (n < htmo._c(this._u).size()) {
            this._b(n, n2, n3, n4, htvf2);
        }
    }

    public void _b(int n, int n2, int n3, int n4, htvf htvf2) {
        rqmh rqmh2 = (rqmh)htmo._c(this._u).get(n);
        this._u.func_73731_b(htmo._k(this._u), rqmh2._b(), n2 + 2, n3 + 1, 0xFFFFFF);
        int n5 = 207;
        int n6 = 1;
        if (rqmh2._h) {
            htmo._a(this._u, n2 + n5, n3 + n6, this._k, this._l);
        } else if (rqmh2._d.equals("CLOSED")) {
            htmo._b(this._u, n2 + n5, n3 + n6, this._k, this._l);
        } else if (rqmh2._e.equals(htmo._l(this._u)._P()._a()) && rqmh2._k < 7) {
            this._a(n, n2 - 14, n3, rqmh2);
            htmo._a(this._u, n2 + n5, n3 + n6, this._k, this._l, rqmh2._k);
        } else if (rqmh2._d.equals("OPEN")) {
            htmo._c(this._u, n2 + n5, n3 + n6, this._k, this._l);
            this._a(n, n2 - 14, n3, rqmh2);
        }
        this._u.func_73731_b(htmo._m(this._u), rqmh2._a(), n2 + 2, n3 + 12, 0x6C6C6C);
        this._u.func_73731_b(htmo._n(this._u), rqmh2._e, n2 + 2, n3 + 12 + 11, 0x4C4C4C);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(int n, int n2, int n3, rqmh rqmh2) {
        if (rqmh2._g == null) {
            return;
        }
        Object object = htmo._e();
        synchronized (object) {
            if (htmo._f() < 5 && (!rqmh2._n || rqmh2._o)) {
                new qnif(this, rqmh2).start();
            }
        }
        if (rqmh2._m != null) {
            this._u.func_73731_b(htmo._o(this._u), rqmh2._m, n2 + 215 - htmo._p(this._u)._b(rqmh2._m), n3 + 1, 0x808080);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        htmo._q(this._u)._R()._a(bawa.field_110324_m);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import znw.mods.auction.pidb;

public class knjj
extends wqly {
    public knjj(elxl elxl2) {
        super(elxl2);
    }

    @Override
    protected void _a(elxl elxl2) {
        int n;
        this._H = elxl2;
        this._x = new ArrayList();
        this._Y = 475;
        this._Z = 475;
        this.__ad = this._Y / 2;
        this.__ae = this._Z / 2;
        this._T = true;
        this._F = jgro._e;
        this._p = new dzwv(this, 0);
        this._o = new dzwv(this, 2);
        this._n = new dzwv(this, 3);
        this._l = new dzwv(this, 5);
        this._m = new dzwv(this, 7);
        this._q = new dzwv(this, 8);
        this._r = new dzwv(this, 9);
        this._E = new dzwv(this, 20);
        this._D = new ditu(this, 21);
        this._C = new dzwv(this, 22);
        this._B = new dzwv(this, 23);
        ((ditu)this._D)._e(false)._c(false)._b(false);
        this._s = new dzwv(this, 24);
        this._t = new vnih(this, 25);
        this._t._a(knjj._c("auction.sort." + wqly._h[0].toString() + "a"));
        this._k = new nwsb(this, 10, 45){

            @Override
            public void _a(char c, int n) {
                super._a(c, n);
                if (n == 28 || n == 156) {
                    knjj.this._d();
                }
            }
        };
        this._i = new mtox(this, 999);
        this._w = new wqly.kjui[6];
        for (n = 0; n < 6; ++n) {
            this._w[n] = new wqly.kjui(this, this, 200 + n);
            this._w[n]._d(213, 22)._c(false)._d(false);
            this._i._a(this._w[n]);
        }
        this._v = new dzwv[wqly._h.length * 2];
        for (n = 0; n < wqly._h.length * 2; ++n) {
            this._v[n] = new dzwv(this, 300 + n);
            this._v[n]._a(yfpk._b)._d(64, 11);
            this._v[n]._a(knjj._c("auction.sort." + wqly._h[n / 2].toString() + (n % 2 == 0 ? "a" : "d")));
            this._v[n]._x = 3.0;
            this._t._a(this._v[n]);
        }
        this._k._a(knjj._d("text_box"))._d(64, 11);
        this._k._k = knjj._c("auction.btn.note.name");
        this._k._c(8, -4);
        this._m._x = 1.0;
        this._s._d(17, 17)._a(knjj._d("btn_add"));
        this._n._d(36, 12)._d(true)._c(false)._a(knjj._d("btn_short"));
        this._o._d(36, 12)._d(true)._c(false)._a(knjj._d("btn_short"));
        this._q._d(64, 12)._c(false)._d(true);
        this._r._d(64, 12)._c(false)._d(true);
        this._m._d(64, 12)._c(false)._d(true);
        this._l._d(36, 12)._c(false)._d(true)._a(knjj._d("btn_short"));
        this._p._d(14, 14)._c(false)._d(true)._a(knjj._d("btn_close"));
        this._l._a(knjj._c("auction.btn.search"));
        this._m._a(knjj._c("mail.btn.proceed"));
        this._n._a(knjj._c("mail.btn.forward"));
        this._o._a(knjj._c("mail.btn.back"));
        this._q._a(knjj._c("auction.btn.cancellot"));
        this._r._a(knjj._c("auction.label.buylot"));
        this._D._a(knjj._c("auction.btn.mlots"));
        this._E._a(knjj._c("auction.btn.mbids"));
        this._C._a(knjj._c("auction.btn.msearch"));
        this._B._a(knjj._c("auction.btn.mplace"));
        this._D._a(yfpk._g)._d(36, 12)._a(knjj._d("btn_short"));
        this._E._a(yfpk._g)._d(36, 12)._a(knjj._d("btn_short"));
        this._B._a(yfpk._g)._d(64, 12);
        this._C._a(yfpk._g)._d(36, 12)._a(knjj._d("btn_short"));
        this._t._d(64, 11)._d(true)._a(knjj._d("list_box"));
        this._i._a(this._p);
        this._i._a(this._k);
        this._i._a(this._l);
        this._i._a(this._q);
        this._i._a(this._n);
        this._i._a(this._o);
        this._i._a(this._D);
        this._i._a(this._E);
        this._i._a(this._C);
        this._i._a(this._B);
        this._i._a(this._t);
        this._i._a(this._s);
        this._e(this._i);
        this._k._a();
        this._d();
    }

    @Override
    public void func_73866_w_() {
        int n;
        super.func_73866_w_();
        int n2 = this.__ag;
        int n3 = this.__ah;
        this._p._a(n2 + 220, n3 + 10);
        this._s._a(n2 + 200, n3 + 10);
        this._l._a(n2 + 195, n3 + 40);
        this._k._a(n2 + 126, n3 + 40);
        this._m._a(n2 + 90, n3 + 205);
        this._n._a(n2 + 195, n3 + 219);
        this._o._a(n2 + 10, n3 + 219);
        this._b(this._z);
        for (n = 0; n < 6; ++n) {
            this._w[n]._a(n2 + 10, n3 + 22 * n + 63);
        }
        for (n = 0; n < wqly._h.length * 2; ++n) {
            this._v[n]._a(n2 + 60, n3 + 51 + n * 11);
        }
        this._B._a(n2 + 8 + 36, n3 + 26);
        this._C._a(n2 + 8, n3 + 26);
        this._D._a(n2 + 8 + 36 + 64, n3 + 26);
        this._E._a(n2 + 8 + 36 + 64 + 36, n3 + 26);
        this._t._a(n2 + 60, n3 + 40);
    }

    @Override
    public void _a(thcx thcx2) {
        switch (thcx2._H) {
            case 0: {
                this.field_73882_e._t.func_71053_j();
                break;
            }
            case 23: {
                new yfpr(pidb._e).sendToServer();
                break;
            }
            case 20: {
                new yfpr(pidb._h).sendToServer();
                break;
            }
            case 22: {
                new yfpr(pidb._f).sendToServer();
                break;
            }
            case 24: {
                this._d();
                break;
            }
            case 3: {
                ++this._A;
                if (this._A > this._I) {
                    this._A = this._I;
                    break;
                }
                this._d();
                break;
            }
            case 2: {
                --this._A;
                if (this._A < 0) {
                    this._A = 0;
                    break;
                }
                this._d();
                break;
            }
            case 5: {
                this._A = 0;
                this._d();
                break;
            }
            case 8: {
                new ozul()._a(this._J).sendToServer();
            }
        }
        if (thcx2._H >= 300 && thcx2._H < 300 + wqly._h.length * 2) {
            this._F = wqly._h[(thcx2._H - 300) / 2];
            this._G = thcx2._H % 2 == 1;
            String string = knjj._c("auction.sort." + this._F.toString() + (this._G ? "d" : "a"));
            this._t._a(yfpk._b._a(string, 48));
            this._d();
        }
        super._a(thcx2);
    }

    @Override
    protected int _e() {
        return zwaw._b.ordinal();
    }
}


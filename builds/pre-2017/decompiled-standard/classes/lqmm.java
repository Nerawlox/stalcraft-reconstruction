/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.money.zwat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import znw.mods.auction.pidb;

public class lqmm
extends ywry {
    private static int _e = 150000;
    private static int _f = 250000;
    private static int _g = 5000;
    public static final int _a = 0;
    public static final int _b = 1;
    public static final int _c = 2;
    public static final int _d = 3;
    private static final ResourceLocation _h = new ResourceLocation("auction", "textures/gui/auction_list.png");
    private static final ResourceLocation _i = new ResourceLocation("auction", "textures/gui/mail_msg.png");
    private static final int[] _j = new int[]{6, 12, 24, 48};
    private mtox _k;
    private mtox _l;
    private vnih _m;
    private nwsb _n;
    private nwsb _o;
    private dzwv _p;
    private dzwv _q;
    private dzwv _r;
    private dzwv _s;
    private dzwv _t;
    private dzwv _u;
    private dzwv _v;
    private dzwv[] _w;
    private int _x;
    private boolean _y;
    private String _z;

    public lqmm(jjgc jjgc2) {
        super(jjgc2);
        this._Y = 475;
        this._Z = 475;
        this.__ad = this._Y / 2;
        this.__ae = this._Z / 2;
        this._T = true;
        this._z = "";
        this._v = new dzwv(this, 20);
        this._u = new dzwv(this, 21);
        this._t = new dzwv(this, 22);
        this._s = new ditu(this, 23);
        ((ditu)this._s)._e(false)._c(false)._b(false);
        this._x = 1;
        this._r = new dzwv(this, 0);
        this._m = new vnih(this, 3);
        this._p = new dzwv(this, 6);
        this._q = new dzwv(this, 8);
        this._n = new nwsb(this, 11, 11){

            @Override
            public void _a(String string, int n, int n2, int n3) {
                try {
                    if (this._l()) {
                        super._a(string, n, n2, n3);
                    } else {
                        super._a(NumberFormat.getNumberInstance(Locale.US).format(Long.parseLong(string)) + " " + 1._b("rub"), n - 4, n2, n3);
                    }
                }
                catch (Exception exception) {
                    super._a(string, n, n2, n3);
                }
            }
        };
        this._o = new nwsb(this, 13, 11){

            @Override
            public void _a(String string, int n, int n2, int n3) {
                try {
                    if (this._l()) {
                        super._a(string, n, n2, n3);
                    } else {
                        super._a(NumberFormat.getNumberInstance(Locale.US).format(Long.parseLong(string)) + " " + 2._b("rub"), n - 4, n2, n3);
                    }
                }
                catch (Exception exception) {
                    super._a(string, n, n2, n3);
                }
            }
        };
        this._k = new mtox(this, 999);
        this._l = new mtox(this, 998){

            @Override
            public void _a(xpzm xpzm2, int n, int n2) {
                xpzm2._R()._a(_i);
                qozx._b(-58, -79, 180, 157, 0x70000000);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                lqmm.this.func_73729_b(0, 0, 129, 126, 128, 82);
                xpzm2._R()._a(ywry._N);
            }

            @Override
            public void _b(xpzm xpzm2, int n, int n2) {
                mcmy mcmy2 = yfpk._h;
                mcmy mcmy3 = yfpk._b;
                mcmy2._b(3._b("\u0412\u043d\u0438\u043c\u0430\u043d\u0438\u0435"), 65.0, 9.0, -1, 1.0f);
                String string = 3._b(lqmm.this._z);
                string = string.replace("\\n", ywry._P);
                string = mcmy3._c(string, 112);
                int n3 = 40;
                int n4 = 10;
                int n5 = n4 * string.split(ywry._P, -1).length;
                mcmy3._a(string, 63.0, n3 - n5 / 4, -69, 0.6f);
            }
        };
        this._l._x = 2.0;
        ditq ditq2 = new ditq(){

            @Override
            public boolean _a(String string) {
                try {
                    Long.parseLong(string);
                }
                catch (NumberFormatException numberFormatException) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean _a(char c) {
                try {
                    Integer.parseInt(c + "");
                }
                catch (NumberFormatException numberFormatException) {
                    return false;
                }
                return true;
            }
        };
        this._w = new dzwv[4];
        for (int i = 0; i < 4; ++i) {
            this._w[i] = new dzwv(this, 120 + i);
            this._w[i]._d(64, 10)._c(false)._d(true)._a(lqmm._d("text_box"));
            this._w[i]._x = 3.0;
            this._w[i]._a(-1);
            this._w[i]._a(_j[i] + " " + lqmm._c("auction.list.time_postfix"));
            this._w[i]._a(yfpk._b);
            this._m._a(this._w[i]);
        }
        this._n._k = lqmm._c("auction.btn.note.summ");
        this._o._k = lqmm._c("auction.btn.note.summ");
        this._n._b(1)._c(-4, -4);
        this._o._b(1)._c(-4, -4);
        this._n._a(ditq2)._a(lqmm._d("text_box"))._d(64, 11);
        this._o._a(ditq2)._a(lqmm._d("text_box"))._d(64, 11);
        this._q._x = 3.0;
        this._u._a(yfpk._g)._d(36, 12)._a(lqmm._d("btn_short"));
        this._v._a(yfpk._g)._d(36, 12)._a(lqmm._d("btn_short"));
        this._s._a(yfpk._g)._d(64, 12);
        this._t._a(yfpk._g)._d(36, 12)._a(lqmm._d("btn_short"));
        this._q._d(64, 12)._c(false)._d(true);
        this._p._d(64, 12)._c(false)._d(true);
        this._r._d(14, 14)._c(false)._d(true)._a(lqmm._d("btn_close"));
        this._m._d(64, 11)._d(true)._a(lqmm._d("list_box"));
        this._m._a(_j[this._x] + " " + lqmm._c("auction.list.time_postfix"));
        this._p._a(lqmm._c("auction.btn.place"));
        this._q._a(lqmm._c("mail.btn.back"));
        this._u._a(lqmm._c("auction.btn.mlots"));
        this._v._a(lqmm._c("auction.btn.mbids"));
        this._t._a(lqmm._c("auction.btn.msearch"));
        this._s._a(lqmm._c("auction.btn.mplace"));
        this._k._a(this._r);
        this._k._a(this._m);
        this._k._a(this._n);
        this._k._a(this._o);
        this._k._a(this._p);
        this._k._a(this._u);
        this._k._a(this._v);
        this._k._a(this._t);
        this._k._a(this._s);
        this._e(this._k);
        this._l._a(this._q);
        this._l._b(false);
        this._l._d(false);
        this._l._d(400, 400);
        this._e(this._l);
    }

    @Override
    public void _a(String string) {
        if ("place_limit".equals(string) || "place_timeout".equals(string) || "place_ok".equals(string)) {
            this._z = lqmm._c("state." + string);
            this._a();
        }
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        int n = this.__ag;
        int n2 = this.__ah;
        this._r._a(n + 220, n2 + 10);
        this._m._a(n + 90, n2 + 64);
        for (int i = 0; i < 4; ++i) {
            this._w[i]._a(n + 90, n2 + 75 + 11 * i);
        }
        this._n._a(n + 90, n2 + 91);
        this._o._a(n + 90, n2 + 113);
        this._p._a(n + 90, n2 + 166);
        this._l._a(n + 60, n2 + 80);
        this._q._a(n + 92, n2 + 140);
        this._s._a(n + 8 + 36, n2 + 26);
        this._t._a(n + 8, n2 + 26);
        this._u._a(n + 8 + 36 + 64, n2 + 26);
        this._v._a(n + 8 + 36 + 64 + 36, n2 + 26);
    }

    public void _a() {
        if (this._y) {
            return;
        }
        this.__aG = false;
        this._y = true;
        this._l._b(true);
        this._l._d(true);
        this._k._b(false);
    }

    @Override
    public void _a(yeso yeso2, int n, int n2, int n3) {
    }

    public void _b() {
        if (!this._y) {
            return;
        }
        this.__aG = true;
        this._y = false;
        this._l._b(false);
        this._l._d(false);
        this._k._b(true);
    }

    public void _b(String string) {
        this._a();
        this._z = string;
    }

    public boolean _c() {
        try {
            int n;
            if (this._n._b() == null || this._n._b().length() == 0) {
                this._b("auction.err.noStartPrice");
                return false;
            }
            int n2 = Integer.parseInt(this._n._b());
            if (this._o._b() != null && this._o._b().length() > 0 && (n = Integer.parseInt(this._o._b())) > 0 && n <= n2) {
                this._b("auction.err.maxBiggerStart");
                return false;
            }
            cvzo cvzo2 = ((elxl)this.__af)._b.func_70301_a(0);
            if (cvzo2 == null) {
                this._b("auction.err.noItem");
                return false;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public void _d() {
        if (!this._c()) {
            return;
        }
        try {
            cvzo cvzo2 = ((elxl)this.__af)._b.func_70301_a(0);
            if (cvzo2 == null) {
                return;
            }
            int n = Integer.parseInt(this._n._b());
            int n2 = 0;
            if (this._o._b() != null && this._o._b().length() > 0) {
                n2 = Integer.parseInt(this._o._b());
            }
            int n3 = _j[this._x];
            String string = cvzo2._s();
            new ozul()._a(n, n2, n3, string).sendToServer();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void _a(thcx thcx2) {
        switch (thcx2._H) {
            case 0: {
                this.field_73882_e._t.func_71053_j();
                break;
            }
            case 20: {
                new yfpr(pidb._h).sendToServer();
                break;
            }
            case 21: {
                new yfpr(pidb._g).sendToServer();
                break;
            }
            case 22: {
                new yfpr(pidb._f).sendToServer();
                break;
            }
            case 6: {
                this._d();
                break;
            }
            case 8: {
                this._b();
            }
        }
        if (thcx2._H >= 120 && thcx2._H < 124) {
            this._x = thcx2._H - 120;
            this._m._a(_j[this._x] + " " + lqmm._c("auction.list.time_postfix"));
        }
        super._a(thcx2);
    }

    @Override
    protected void _b(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.__ag;
        int n4 = this.__ah;
        this.field_73882_e._R()._a(_h);
        this.func_73729_b(n3, n4, 0, 0, this._Y / 2 + 3, this._Z / 2 + 4);
        this.field_73882_e._R()._a(ywry._N);
        this._a(n3 + 110, n4 + 42, lqmm._d("slot"));
        this._a(n3 + 10, n4 + 61, lqmm._d("hr_long"));
    }

    @Override
    protected void _c(float f, int n, int n2) {
        int n3 = this.__ag;
        int n4 = this.__ah;
        GL11.glPushMatrix();
        this._a(n3, n4);
        mcmy mcmy2 = yfpk._e;
        mcmy mcmy3 = yfpk._h;
        yfpk._i._b(lqmm._c("auction.title.list"), this.__ad / 2, 12.0, -1, 1.0f);
        String string = "";
        cvzo cvzo2 = ((elxl)this.__af)._b.func_70301_a(0);
        if (cvzo2 != null) {
            string = cvzo2._s();
            string = string + " x " + cvzo2._b;
        }
        mcmy3._b(lqmm._c("auction.label.selectItem"), 20.0, 47.0, -1);
        mcmy3._b(lqmm._c("auction.label.time"), 20.0, 65.0, -1);
        mcmy3._b(lqmm._c("auction.label.startPrice"), 20.0, 92.0, -1);
        mcmy3._b(lqmm._c("auction.label.maxPrice"), 20.0, 114.0, -1);
        try {
            int n5 = Integer.parseInt(this._n._b());
            switch (this._x) {
                case 0: {
                    n5 = (int)Math.ceil((double)n5 / 100.0);
                    break;
                }
                case 1: {
                    n5 = (int)Math.ceil((double)n5 / 50.0);
                    break;
                }
                case 2: {
                    n5 = (int)Math.ceil((double)n5 / 33.33);
                    break;
                }
                case 3: {
                    n5 = (int)Math.ceil((double)n5 / 20.0);
                }
            }
            mcmy3._b(lqmm._c("auction.label.pledge") + ": " + n5 + " " + lqmm._c("rub"), 20.0, 141.0, -1);
        }
        catch (Exception exception) {
            mcmy3._b(lqmm._c("auction.label.pledge") + ": 0 " + lqmm._c("rub"), 20.0, 141.0, -1);
        }
        double d = mcmy3._a("" + zwat._a(this.field_73882_e._t)._a());
        yfpk._c._b("" + zwat._a(this.field_73882_e._t)._a() + " " + lqmm._c("rub"), 220.0 - d, 29.0, -1);
        yfpk._b._b(string, 132.0, 47.0, -1);
        mcmy2._b(mcmy2._c(lqmm._c("auction.desc.pledge"), 210), 20.0, 151.0, -1);
        mcmy2._b(mcmy2._c(lqmm._c("auction.desc.buyPrice"), 210), 20.0, 124.0, -1);
        mcmy2._b(mcmy2._c(lqmm._c("auction.desc.times"), 210), 20.0, 75.0, -1);
        mcmy2._b(mcmy2._c(lqmm._c("auction.desc.startPrice"), 210), 20.0, 102.0, -1);
        GL11.glPopMatrix();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.money.zwat;
import java.awt.Rectangle;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import znw.mods.auction.pidb;

public class dzvh
extends ywry {
    protected static final ResourceLocation _a = new ResourceLocation("auction", "textures/gui/mail_list.png");
    protected static final ResourceLocation _b = new ResourceLocation("auction", "textures/gui/mail_msg.png");
    private nwsb _c;
    private nwsb _d;
    private lqmc _e;
    private dzwv _f;
    private dzwv _g;
    private dzwv _h;
    private dzwv _i;
    private dzwv _j;
    private dzwv _k;
    private mtox _l;
    private mtox _m;
    private mtox _n;
    private boolean _o;
    private boolean _p;
    private boolean _q;
    private String _r;
    private int _s;
    private long _t;
    private dzwv _u;
    private dzwv _v;
    private dzwv _w;
    private nwsb _x;

    public dzvh(jjgc jjgc2) {
        super(jjgc2);
        this._Y = 296;
        this._Z = 471;
        this.__ad = this._Y / 2;
        this.__ae = this._Z / 2;
        this._q = false;
        this._o = false;
        this._p = false;
        this._T = true;
        this._l = new mtox(this, 999);
        this._m = new mtox(this, 998){

            @Override
            public void _a(xpzm xpzm2, int n, int n2) {
                int n3 = dzvh.this.__ag;
                int n4 = dzvh.this.__ah;
                xpzm2._R()._a(_b);
                qozx._b(n3 - this._y, n4 - this._z, n3 - this._y + dzvh.this.__ad, n4 - this._z + dzvh.this.__ae, 0x70000000);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                dzvh.this.func_73729_b(0, 0, 80, 0, 174, 126);
                dzvh.this._c(15, -50);
            }

            @Override
            public void _b(xpzm xpzm2, int n, int n2) {
                super._b(xpzm2, n, n2);
                mcmy mcmy2 = yfpk._i;
                mcmy2._b(1._b("mail.window.title.attach"), 87.0, 11.0, -1979721, 1.0f);
            }
        };
        this._n = new mtox(this, 997){

            @Override
            public void _a(xpzm xpzm2, int n, int n2) {
                int n3 = dzvh.this.__ag;
                int n4 = dzvh.this.__ah;
                xpzm2._R()._a(_b);
                qozx._b(n3 - this._y, n4 - this._z, n3 - this._y + dzvh.this.__ad, n4 - this._z + dzvh.this.__ae, 0x70000000);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                dzvh.this.func_73729_b(0, 15, 121, 127, dzvh.this.__ad, 126);
            }

            @Override
            public void _b(xpzm xpzm2, int n, int n2) {
                super._b(xpzm2, n, n2);
                mcmy mcmy2 = yfpk._i;
                mcmy mcmy3 = yfpk._e;
                String string = "\u0412\u043d\u0438\u043c\u0430\u043d\u0438\u0435";
                mcmy2._b(2._b(string), 73.0, 24.0, -1, 1.0f);
                int n3 = 55;
                int n4 = 10;
                String string2 = 2._b(dzvh.this._r);
                string2 = mcmy3._c(string2, 112);
                int n5 = n4 * string2.split(ywry._P, -1).length;
                mcmy3._a(string2, 73.0, n3 - n5 / 4, -1, 0.6f);
            }
        };
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
                    Long.parseLong(c + "");
                }
                catch (NumberFormatException numberFormatException) {
                    return false;
                }
                return true;
            }
        };
        this._f = new dzwv(this, 0);
        this._g = new dzwv(this, 3);
        this._c = new nwsb(this, 4, 20);
        this._d = new nwsb(this, 5, 30);
        this._e = new lqmc(this, 6, 600, 20);
        this._h = new dzwv(this, 7){

            @Override
            public void _a(xpzm xpzm2, int n, int n2) {
                super._a(xpzm2, n, n2);
                this._a(this._g(n, n2));
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
            public void _b(xpzm xpzm2, int n, int n2) {
                if (!this._c()) {
                    return;
                }
                GL11.glTranslated(8.0, -8.0, 0.0);
                String string = 4._b("container.mailbox.attachment");
                int n3 = (int)this._q._a(string);
                qozx._b(-2, 0, n3 + 4, 10, 0x70000000);
                this._q._b(string, 0.0, 0.0, -1);
            }
        };
        this._i = new dzwv(this, 8);
        this._j = new dzwv(this, 9);
        this._k = new dzwv(this, 10);
        this._x = new nwsb(this, 13, 14){

            @Override
            public void _a(String string, int n, int n2, int n3) {
                try {
                    if (this._l()) {
                        super._a(string, n, n2, n3);
                    } else {
                        super._a(NumberFormat.getNumberInstance(Locale.US).format(Long.parseLong(string)), n - 2, n2, n3);
                    }
                }
                catch (Exception exception) {
                    super._a(string, n, n2, n3);
                }
            }
        };
        this._u = new dzwv(this, 15);
        this._v = new dzwv(this, 16);
        this._w = new ditu(this, 17);
        ((ditu)this._w)._e(false)._b(false);
        this._d._a(20);
        this._e._a(20)._d(128, 92);
        this._f._d(14, 14)._c(false)._d(true)._a(dzvh._d("btn_close"));
        this._h._d(17, 17)._c(false)._d(true)._a(dzvh._d("btn_inv"));
        this._g._d(64, 12)._c(false)._d(true);
        this._i._d(64, 12)._c(false)._d(true);
        this._j._d(36, 12)._c(false)._d(true)._a(dzvh._d("btn_short"));
        this._k._d(36, 12)._c(false)._d(true)._a(dzvh._d("btn_short"));
        this._u._a(yfpk._g)._d(43, 12)._c(false)._a(dzvh._d("btn_mid"));
        this._v._a(yfpk._g)._d(43, 12)._c(false)._a(dzvh._d("btn_mid"));
        this._w._a(yfpk._g)._d(43, 12)._c(false)._a(dzvh._d("btn_mid"));
        this._j._x = 1.0;
        this._k._x = 1.0;
        this._g._a(dzvh._c("mail.btn.send"));
        this._i._a(dzvh._c("mail.btn.proceed"));
        this._j._a(dzvh._c("mail.btn.yes"));
        this._k._a(dzvh._c("mail.btn.no"));
        this._u._a(dzvh._c("mail.tab.incoming"));
        this._v._a(dzvh._c("mail.tab.sent"));
        this._w._a(dzvh._c("mail.tab.newletter"));
        this._i._x = 1.0;
        this._x._k = dzvh._c("auction.btn.note.summ");
        this._x._b(1)._c(-4, -4);
        this._x._a(ditq2)._a(dzvh._d("text_box"))._d(64, 11);
        this._c._a(dzvh._d("text_box"))._d(64, 11);
        this._d._a(dzvh._d("text_box"))._d(64, 11);
        this._c._c(4, -4);
        this._d._c(4, -4);
        this._l._a(this._f);
        this._l._a(this._c);
        this._l._a(this._d);
        this._l._a(this._e);
        this._l._a(this._g);
        this._l._a(this._h);
        this._l._a(this._u);
        this._l._a(this._v);
        this._l._a(this._w);
        this._l._a(this._x);
        this._l._b(true);
        this._m._a(this._i);
        this._m._d(false);
        this._m._b(false);
        this._n._a(this._j);
        this._n._a(this._k);
        this._n._d(false);
        this._n._b(false);
        this._e(this._l);
        this._e(this._m);
        this._e(this._n);
        this.__aF = true;
    }

    @Override
    public void _a(yeso yeso2, int n, int n2, int n3) {
        if (!this._o && !this._p) {
            this._c();
        }
        super._a(yeso2, n, n2, n3);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        int n = this.__aa;
        int n2 = this.__ab;
        this._d._a(n + 35, n2 + 49);
        this._c._a(n + 35, n2 + 37);
        this._e._a(n + 10, n2 + 72);
        this._g._a(n + 40, n2 + 218);
        this._f._a(n + 128, n2 + 5);
        this._h._a(n + 12, n2 + 182);
        this._m._a(n - 15, n2 + 50);
        this._i._a(n + 40, n2 + 155);
        this._x._a(n + 35, n2 + 202);
        this._k._a(n + 58, n2 + 130);
        this._n._a(n + 5, n2 + 55);
        this._u._a(n + 6, n2 + 24);
        this._v._a(n + 49, n2 + 24);
        this._w._a(n + 92, n2 + 24);
    }

    public void _a(int n) {
        this._s = n;
    }

    public void _a(long l) {
        this._t = l + System.currentTimeMillis();
    }

    public void _a() {
        this._p = true;
        this._n._d(true);
        this._n._b(true);
        this._l._b(false);
        this.__aF = false;
    }

    public void _b(String string) {
        this._r = string;
        int n = this.__aa;
        int n2 = this.__ab;
        this._q = true;
        this._j._d(false);
        this._k._a(dzvh._c("mail.btn.back"));
    }

    @Override
    public void _a(String string) {
        super._a(string);
        if ("send_no_target_user".equals(string) || "send_ok".equals(string) || "send_timeout".equals(string) || "send_yourself".equals(string)) {
            this._b(dzvh._c("state." + string));
            this._a();
        }
    }

    public void _b() {
        int n = this.__aa;
        int n2 = this.__ab;
        this._p = false;
        this._q = false;
        this._j._d(true);
        this._n._d(false);
        this._n._b(false);
        this._l._b(true);
        this._j._a(n + 10, n2 + 130);
        this._k._a(dzvh._c("mail.btn.no"));
        this.__aF = true;
    }

    @Override
    public void _a(thcx thcx2) {
        switch (thcx2._H) {
            case 0: {
                this.field_73882_e._t.func_71053_j();
                break;
            }
            case 1: {
                new yfpr(pidb._a).sendToServer();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                try {
                    new nwrm()._a(this._e._b(), this._d._b(), this._c._b(), Long.parseLong(this._x._b())).sendToServer();
                }
                catch (NumberFormatException numberFormatException) {
                    new nwrm()._a(this._e._b(), this._d._b(), this._c._b(), 0L).sendToServer();
                }
                break;
            }
            case 7: {
                this._c();
                break;
            }
            case 8: {
                this._d();
                break;
            }
            case 9: {
                break;
            }
            case 10: {
                this._b();
                break;
            }
            case 15: {
                new yfpr(pidb._a).sendToServer();
                break;
            }
            case 16: {
                new yfpr(pidb._b).sendToServer();
            }
        }
    }

    public void _c() {
        if (this._o) {
            return;
        }
        cwsz cwsz2 = (cwsz)this.__af;
        new nwrm()._a(false).sendToServer();
        cwsz2._a();
        this._l._b(false);
        this._m._d(true);
        this._m._b(true);
        this._o = true;
        this.__aE.add(new Rectangle(this.__ag - 25, this.__ah + 50, 175, 125));
    }

    public void _d() {
        if (!this._o) {
            return;
        }
        cwsz cwsz2 = (cwsz)this.__af;
        new nwrm()._a(true).sendToServer();
        cwsz2._b();
        this._l._b(true);
        this._m._d(false);
        this._m._b(false);
        this._o = false;
        this.__aE.clear();
    }

    @Override
    public ResourceLocation _g() {
        return ywry._N;
    }

    protected void _c(int n, int n2) {
        this.field_73882_e._R()._a(ywry._N);
        int[] nArray = dzvh._d("slot");
        for (int i = 0; i < 4; ++i) {
            qozx._a(n + 20 * i + 35, n2 + 180, nArray);
        }
    }

    @Override
    protected void _b(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.__aa;
        int n4 = this.__ab;
        this.field_73882_e._R()._a(_a);
        this._a(n3, n4, this.__ad + 1, this.__ae, 8, 8, this._Y + 10, this._Z + 10, 512, 512);
        this._c(n3, n4);
        int[] nArray = dzvh._d("hr");
        this._a(n3 + 5, n4 + 176, nArray[4] - 60, nArray[5], nArray[0], nArray[1], nArray[2], nArray[3], 512, 512);
    }

    @Override
    protected void _c(float f, int n, int n2) {
        int n3 = this.__aa;
        int n4 = this.__ab;
        GL11.glPushMatrix();
        this._a(n3, n4);
        mcmy mcmy2 = yfpk._i;
        mcmy mcmy3 = yfpk._h;
        mcmy mcmy4 = yfpk._c;
        mcmy2._b(dzvh._c("mail.title.msg_list"), this.__ad / 2 - 4, 8.0, -1979721, 1.0f);
        mcmy3._b(dzvh._c("mail.send.to"), 10.0, 37.0, -1);
        mcmy3._b(dzvh._c("mail.send.topic"), 10.0, 49.0, -1);
        mcmy3._b(dzvh._c("mail.send.msg"), 10.0, 61.0, -1);
        mcmy3._b(dzvh._c("rub"), 100.0, 203.0, -1);
        mcmy3._b(dzvh._c("mail.attachment"), 10.0, 167.0, -1);
        double d = mcmy3._a("" + zwat._a(this.field_73882_e._t)._a());
        yfpk._c._b("" + zwat._a(this.field_73882_e._t)._a() + " " + dzvh._c("rub"), 123.0 - d, 167.0, -1);
        mcmy4._b(this._e._b().length() + "/" + this._e._m, 10.0, 222.0, -7576755);
        GL11.glPopMatrix();
    }
}


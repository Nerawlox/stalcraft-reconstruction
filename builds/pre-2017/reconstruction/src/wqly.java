/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.money.zwat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public abstract class wqly
extends ywry {
    public static final int _a = 0;
    public static final int _b = 1;
    public static final int _c = 2;
    public static final int _d = 3;
    protected static final ResourceLocation _e = new ResourceLocation("auction", "textures/gui/auction_list_bg.png");
    protected static final ResourceLocation _f = new ResourceLocation("auction", "textures/gui/mail_msg.png");
    protected static final int[] _g = new int[]{6, 12, 24, 48};
    protected static final jgro[] _h = new jgro[]{jgro._e, jgro._f, jgro._a, jgro._d};
    protected mtox _i;
    protected mtox _j = new mtox(this, 971){

        @Override
        public void _a(Minecraft minecraft, int n, int n2) {
            int n3 = wqly.this.__ag;
            int n4 = wqly.this.__ah;
            minecraft._R()._a(_f);
            qozx._b(n3 - this._y, n4 - this._z, n3 - this._y + wqly.this.__ad, n4 - this._z + wqly.this.__ae, 0x70000000);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            wqly.this.drawTexturedModalRect(0, 0, 129, 126, 128, 82);
        }

        @Override
        public void _b(Minecraft minecraft, int n, int n2) {
            super._b(minecraft, n, n2);
            mcmy mcmy2 = yfpk._h;
            mcmy mcmy3 = yfpk._e;
            String string = "\u0412\u043d\u0438\u043c\u0430\u043d\u0438\u0435";
            mcmy2._b(1._b(string), 65.0, 9.0, -1, 1.0f);
            int n3 = 40;
            int n4 = 10;
            String string2 = mcmy3._c(wqly.this._M, 112);
            int n5 = n4 * string2.split(ywry._P, -1).length;
            mcmy3._a(string2, 63.0, n3 - n5 / 4, -69, 0.6f);
        }
    };
    protected nwsb _k;
    protected dzwv _l;
    protected dzwv _m;
    protected dzwv _n;
    protected dzwv _o;
    protected dzwv _p;
    protected dzwv _q;
    protected dzwv _r;
    protected dzwv _s;
    protected vnih _t;
    protected dzwv _u = new dzwv(this, 901);
    protected dzwv[] _v;
    protected kjui[] _w;
    protected ArrayList<ezey> _x;
    protected boolean _y;
    protected int _z = -1;
    protected int _A = 0;
    protected dzwv _B;
    protected dzwv _C;
    protected dzwv _D;
    protected dzwv _E;
    protected jgro _F;
    protected boolean _G;
    protected elxl _H;
    protected int _I = 0;
    protected int _J = -1;
    protected long _K = -1L;
    protected nwsb _L;
    protected String _M;

    public wqly(elxl elxl2) {
        super(elxl2);
        this._a(elxl2);
        this._u._a(wqly._c("mail.btn.back"));
        this._u._d(64, 12)._c(false)._d(true)._a(wqly._d("btn_long"));
        this._j._b(false);
        this._j._d(false);
        this._e(this._j);
        this._j._a(this._u);
    }

    @Override
    public void initGui() {
        super.initGui();
        int n = this.__ag;
        int n2 = this.__ah;
        this._j._a(n + 60, n2 + 80);
        this._u._a(n + 92, n2 + 140);
    }

    @Override
    public void _a(thcx thcx2) {
        if (thcx2._H == this._u._H) {
            this._c();
        }
    }

    protected abstract void _a(elxl var1);

    public void _a() {
        int n;
        for (n = 0; n < 6; ++n) {
            this._w[n]._b(false);
            this._w[n]._d(false);
            this._H.putStackInSlot(n, null);
        }
        for (n = 0; n < 6 && n < this._x.size(); ++n) {
            ezey ezey2 = this._x.get(n);
            this._w[n]._b(true);
            this._w[n]._d(true);
            this._w[n]._a(ezey2);
        }
        this._b(-1);
    }

    public void _a(ArrayList<String> arrayList, int n) {
        this._n._b(true);
        this._o._b(true);
        this._s._b(true);
        this._l._b(true);
        if (arrayList == null || n == -1) {
            return;
        }
        this._x.clear();
        for (String string : arrayList) {
            this._x.add(tupg._a(string));
        }
        this._I = (n - 1) / 6;
        this._I = Math.max(0, this._I);
        if (this._A > this._I) {
            this._A = this._I;
            this._d();
        } else {
            this._a();
        }
    }

    @Override
    public void _a(String string) {
        if ("bid_ok".equals(string) || "bid_late".equals(string) || "cancel_lot_ok".equals(string)) {
            this._d();
        }
        this._M = wqly._c("state." + string);
        this._b();
    }

    public boolean _a(int n) {
        return n > this._z && this._z >= 0;
    }

    protected void _b(int n) {
        this._z = n;
        this._H._c = n;
        this._H._b();
        int n2 = this.__ag;
        int n3 = this.__ah;
        if (n < 0) {
            this._q._d(false);
            this._r._d(false);
            this._q._b(false);
            this._r._b(false);
            this._J = -1;
            this._K = -1L;
        } else {
            if (this._w[n]._b > 0L) {
                this._r._d(true);
                this._r._b(true);
            } else {
                this._r._b(false);
                this._r._d(false);
            }
            this._q._d(true);
            this._q._b(true);
            this._q._a(n2 + 70, n3 + 89 + 22 * n);
            this._r._a(n2 + 140, n3 + 89 + 22 * n);
            this._J = this._w[n]._d;
            this._K = this._w[n]._a;
        }
    }

    public void _b() {
        if (this._y) {
            return;
        }
        this._y = true;
        this._j._b(true);
        this._j._d(true);
        this._i._b(false);
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
    }

    public void _c() {
        if (!this._y) {
            return;
        }
        this._y = false;
        this._j._b(false);
        this._j._d(false);
        this._i._b(true);
    }

    protected void _d() {
        this._n._b(false);
        this._o._b(false);
        this._s._b(false);
        this._l._b(false);
        String string = this._k._b();
        string = string.trim();
        new ozul()._a(string, this._F, this._A * 6, this._G, this._e()).sendToServer();
    }

    protected abstract int _e();

    @Override
    protected void _a(float f, int n, int n2) {
        super._a(f, n, n2);
    }

    @Override
    protected void _b(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.__ag;
        int n4 = this.__ah;
        this.mc._R()._a(_e);
        this.drawTexturedModalRect(n3, n4, 0, 0, this._Y / 2 + 3, this._Z / 2 + 4);
        this.mc._R()._a(ywry._N);
        this._a(n3 + 10, n4 + 61, wqly._d("hr_long"));
    }

    @Override
    protected void _c(float f, int n, int n2) {
        int n3 = this.__ag;
        int n4 = this.__ah;
        GL11.glPushMatrix();
        this._a(n3, n4);
        mcmy mcmy2 = yfpk._h;
        mcmy mcmy3 = yfpk._i;
        mcmy3._b(wqly._c("auction.title.list"), this.__ad / 2, 12.0, -1, 1.0f);
        mcmy2._b(wqly._c("auction.label.search"), 10.0, 41.0, -1);
        mcmy2._b(wqly._c("auction.label.name"), 10.0, 54.0, -1);
        mcmy2._b(wqly._c("auction.label.bid"), 125.0, 54.0, -1);
        mcmy2._b(wqly._c("auction.label.maxPrice"), 175.0, 54.0, -1);
        double d = mcmy2._a("" + zwat._a(this.mc._t)._a());
        yfpk._c._b("" + zwat._a(this.mc._t)._a() + " " + wqly._c("rub"), 220.0 - d, 29.0, -1);
        mcmy2._a(wqly._c("mail.label.page") + " " + (this._A + 1) + "/" + (this._I + 1), this.__ad / 2, 220.0, -1, 1.0f);
        GL11.glPopMatrix();
    }

    protected class kjui
    extends dzwv {
        public long _a;
        public long _b;
        public long _c;
        public int _d;
        public String _e;
        public String _f;
        public String _g;
        public Date _h;
        public ItemStack _i;
        public ezey _j;
        private int _J;
        private int _K;
        public boolean _k;

        public kjui(ywry ywry2, int n) {
            super(ywry2, n);
            this._k = false;
            this._a(new int[6]);
        }

        @Override
        public thcx _a(int n, int n2) {
            this._J = n;
            this._K = n2;
            return super._a(n, n2);
        }

        public String _a(long l) {
            if (l / 10L != 1L) {
                if (l % 10L >= 2L && l % 10L <= 4L) {
                    return "234";
                }
                if (l % 10L == 1L) {
                    return "1";
                }
            }
            return "other";
        }

        public void _a(Date date) {
            Date date2 = new Date();
            long l = date.getTime() - date2.getTime();
            if (l < 0L) {
                this._f = kjui._b("auction.lotended");
                return;
            }
            long l2 = TimeUnit.MILLISECONDS.toSeconds(l);
            long l3 = TimeUnit.MILLISECONDS.toMinutes(l);
            long l4 = TimeUnit.MILLISECONDS.toHours(l);
            String string = "";
            String string2 = "";
            if (l4 > 0L) {
                if (l3 >= 30L) {
                    ++l4;
                }
                string2 = kjui._b("prefix.hours");
                string = kjui._b("suffix.hours." + this._a(l4));
                this._f = l4 + " " + string2 + string + " " + kjui._b("auction.label.left");
            } else if (l3 > 0L) {
                if (l2 >= 30L) {
                    ++l3;
                }
                string2 = kjui._b("prefix.mins");
                string = kjui._b("suffix.mins." + this._a(l3));
                this._f = l3 + " " + string2 + string + " " + kjui._b("auction.label.left");
            } else {
                string2 = kjui._b("prefix.secs");
                string = kjui._b("suffix.secs." + this._a(l2));
                this._f = l2 + " " + string2 + string + " " + kjui._b("auction.label.left");
            }
        }

        public void _a(ezey ezey2) {
            this._j = ezey2;
            this._d = ezey2._b();
            this._a = ezey2._k();
            this._b = ezey2._e();
            this._c = ezey2._d();
            if (this._a == 0L) {
                this._a = ezey2._c();
            }
            this._k = ezey2._j().equals(Minecraft._E()._P()._a());
            this._h = new Date(new Date().getTime() + ezey2._a().getTime());
            this._a(this._h);
            this._g = ezey2._h();
            this._i = sval._a(ezey2._i());
            if (this._i != null) {
                this._e = this._i._s();
                wqly.this._H.putStackInSlot(this._H - 200, this._i);
            } else {
                this._e = "";
                wqly.this._H.putStackInSlot(this._H - 200, null);
            }
        }

        @Override
        public void _a(int n, int n2, int n3) {
            if (wqly.this._z == this._g() - 200) {
                wqly.this._b(-1);
            } else {
                wqly.this._b(this._g() - 200);
            }
            super._a(n, n2, n3);
        }

        @Override
        protected void _b(int n, int n2) {
        }

        @Override
        public void _c(Minecraft minecraft, int n, int n2) {
            this._z = this._K + (wqly.this._a(this._g() - 200) ? 22 : 0);
            super._c(minecraft, n, n2);
        }

        @Override
        public void _a(Minecraft minecraft, int n, int n2) {
            this._a(this._f(n, n2));
            boolean bl = wqly.this._z == this._g() - 200;
            qozx._a(0, 21 + (bl ? 22 : 0), ywry._d("hr"));
            qozx._a(1, 2, ywry._d("category_empty"));
            qozx._a(0, 1, ywry._d("slot"));
        }

        @Override
        public void _b(Minecraft minecraft, int n, int n2) {
            mcmy mcmy2 = yfpk._d;
            mcmy mcmy3 = yfpk._c;
            mcmy mcmy4 = yfpk._b;
            this._a(this._h);
            if (this._a > 0L) {
                mcmy3._a(this._a + " " + kjui._b("rub"), 127.0, 7.0, this._k ? -176 : -1, 1.0f);
            } else {
                mcmy3._a("---", 127.0, 7.0, -1, 1.0f);
            }
            if (this._b > 0L) {
                mcmy3._a(this._b + " " + kjui._b("rub"), 185.0, 7.0, -1, 1.0f);
            } else {
                mcmy3._a("---", 185.0, 7.0, -1, 1.0f);
            }
            String string = mcmy3._a(this._e, 80);
            string = string.equals(this._e) ? string : string + "...";
            mcmy3._b(string, 20.0, 2.0, -1);
            yfpk._b._b(this._f, 20.0, 10.0, -86);
            if (this._c()) {
                int n3 = this._B;
                if (wqly.this._z == this._g() - 200) {
                    n3 *= 2;
                }
                qozx._b(0, 0, this._A, n3, 0x40000000);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.primitives.Ints;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import znw.mods.auction.pidb;

@SideOnly(value=Side.CLIENT)
public class mcnh
extends ywry {
    protected static final ResourceLocation _a = new ResourceLocation("auction", "textures/gui/mail_list.png");
    protected static final ResourceLocation _b = new ResourceLocation("auction", "textures/gui/mail_msg.png");
    private dzwv _c;
    private dzwv _d;
    private dzwv _e;
    private dzwv _f;
    private dzwv _g;
    private dzwv _h;
    private dzwv _i;
    private mtox _j;
    private mtox _k;
    private kjui[] _l;
    private dzwv _m;
    private ditu _n;
    private ditu _o;
    private int _p = 0;
    private boolean[] _q;
    private int _r;
    private ArrayList<zwat> _s;
    private boolean _t;
    private int _u;

    public mcnh(Container container) {
        this(container, false);
    }

    public mcnh(Container container, boolean bl) {
        super(container);
        this._t = bl;
        this._s = new ArrayList();
        this._a(true);
        this.__ad = 148;
        this.__ae = 235;
        this._Y = 296;
        this._Z = 471;
        this._q = new boolean[7];
        this._r = 0;
        this._c = new dzwv(this, 7);
        this._d = new dzwv(this, 10);
        this._e = new dzwv(this, 11);
        this._f = new dzwv(this, 12);
        this._g = new dzwv(this, 13);
        this._h = new dzwv(this, 14);
        this._i = new dzwv(this, 9);
        this._n = new ditu(this, 15);
        this._n._e(bl)._c(false)._b(bl);
        this._o = new ditu(this, 16);
        this._o._e(!bl)._c(false)._b(!bl);
        this._m = new dzwv(this, 17);
        this._j = new mtox(this, 999);
        this._k = new mtox(this, 998){

            @Override
            public void _a(Minecraft minecraft, int n, int n2) {
                int n3 = mcnh.this.__ag;
                int n4 = mcnh.this.__ah;
                minecraft._R()._a(_b);
                qozx._b(n3 - this._y, n4 - this._z, n3 - this._y + mcnh.this.__ad, n4 - this._z + mcnh.this.__ae, 0x70000000);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                mcnh.this.drawTexturedModalRect(0, 15, 121, 127, mcnh.this.__ad, 126);
            }

            @Override
            public void _b(Minecraft minecraft, int n, int n2) {
                super._b(minecraft, n, n2);
                mcmy mcmy2 = yfpk._h;
                mcmy mcmy3 = yfpk._e;
                String string = "mail.window.title.confirm";
                mcmy2._b(1._b(string), 73.0, 24.0, -1, 1.0f);
                int n3 = 55;
                int n4 = 10;
                String string2 = 1._b(mcnh.this._r > 0 ? "mail.confirm.delete" : "mail.confirm.delete_none");
                string2 = mcmy3._c(string2, 112);
                int n5 = n4 * string2.split(ywry._P, -1).length;
                mcmy3._a(string2, 73.0, n3 - n5 / 4, -1, 0.6f);
            }
        };
        this._l = new kjui[7];
        for (int i = 0; i < 7; ++i) {
            this._l[i] = new kjui(this, i);
            this._l[i]._d(false);
            this._j._a(this._l[i]);
        }
        this._c._d(14, 14)._c(false)._d(true)._a(mcnh._d("btn_close"));
        this._d._d(36, 12)._d(true)._c(false)._a(mcnh._d("btn_short"));
        this._e._d(36, 12)._d(true)._c(false)._a(mcnh._d("btn_short"));
        this._f._d(36, 12)._c(false)._d(false)._a(mcnh._d("btn_short"));
        this._g._d(36, 12)._c(false)._d(true)._a(mcnh._d("btn_short"));
        this._h._d(43, 12)._c(false)._d(true)._a(mcnh._d("btn_mid"));
        this._i._d(64, 12)._c(false)._d(true);
        this._n._a(yfpk._g)._d(43, 12)._c(false)._a(mcnh._d("btn_mid"));
        this._o._a(yfpk._g)._d(43, 12)._c(false)._a(mcnh._d("btn_mid"));
        this._m._a(yfpk._g)._d(43, 12)._c(false)._a(mcnh._d("btn_mid"));
        this._f._x = 1.0;
        this._g._x = 1.0;
        this._d._a(mcnh._c("mail.btn.forward"));
        this._e._a(mcnh._c("mail.btn.back"));
        this._f._a(mcnh._c("mail.btn.yes"));
        this._g._a(mcnh._c("mail.btn.back"));
        this._h._a(mcnh._c("mail.btn.delete"));
        this._n._a(mcnh._c("mail.tab.incoming"));
        this._o._a(mcnh._c("mail.tab.sent"));
        this._m._a(mcnh._c("mail.tab.newletter"));
        this._i._a(mcnh._c("mail.btn.deleteread"));
        this._j._a(this._c);
        this._j._a(this._d);
        this._j._a(this._e);
        this._j._a(this._h);
        this._j._a(this._n);
        this._j._a(this._o);
        this._j._a(this._m);
        this._j._a(this._i);
        this._j._b(true);
        this._k._a(this._f);
        this._k._a(this._g);
        this._k._d(false);
        this._k._b(false);
        this._e(this._j);
        this._e(this._k);
        this._i();
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        int n = this.__ag;
        int n2 = this.__ah;
        for (int i = 0; i < 7; ++i) {
            this._l[i]._a(n + 4, n2 + 24 * i + 37);
        }
        this._c._a(n + 128, n2 + 5);
        this._e._a(n + 7, n2 + 217);
        this._d._a(n + 107, n2 + 217);
        this._h._a(n + 7, n2 + 204);
        this._i._a(n + 79, n2 + 204);
        this._k._a(n + 5, n2 + 55);
        this._f._a(n + 30, n2 + 130);
        this._n._a(n + 6, n2 + 24);
        this._o._a(n + 49, n2 + 24);
        this._m._a(n + 92, n2 + 24);
        if (this._r > 0) {
            this._g._a(n + 85, n2 + 130);
        } else {
            this._g._a(n + 58, n2 + 130);
        }
    }

    public void _a() {
        this._j._b(false);
        this._k._b(true);
        this._k._d(true);
    }

    public void _b() {
        this._j._b(true);
        this._k._b(false);
        this._k._d(false);
    }

    @Override
    public void _a(thcx thcx2) {
        if (thcx2._H < 7) {
            kjui kjui2 = (kjui)thcx2;
            new nwrm()._b(kjui2._f, this._t).sendToServer();
        } else {
            switch (thcx2._H) {
                case 7: {
                    this.mc._t.closeScreen();
                    break;
                }
                case 8: {
                    break;
                }
                case 9: {
                    new nwrm()._c().sendToServer();
                    break;
                }
                case 17: {
                    new yfpr(pidb._c).sendToServer();
                    break;
                }
                case 10: {
                    ++this._p;
                    if (this._p > this._u) {
                        this._p = this._u;
                        break;
                    }
                    this._i();
                    break;
                }
                case 11: {
                    --this._p;
                    if (this._p < 0) {
                        this._p = 0;
                        break;
                    }
                    this._i();
                    break;
                }
                case 12: {
                    ArrayList<zwat> arrayList = new ArrayList<zwat>();
                    ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
                    for (int i = 0; i < 7 && i < this._s.size(); ++i) {
                        if (!this._q[i]) continue;
                        if (this._l[i] != null) {
                            arrayList2.add(this._l[i]._f);
                        }
                        arrayList.add(this._s.get(i));
                    }
                    new nwrm()._a(Ints.toArray(arrayList2)).sendToServer();
                    this._s.removeAll(arrayList);
                    this._e();
                    this._b();
                    break;
                }
                case 13: {
                    this._b();
                    break;
                }
                case 14: {
                    this._d();
                    this._a();
                    break;
                }
                case 15: {
                    this._n._e(false)._b(false);
                    this._o._e(true)._b(true);
                    this._t = false;
                    this._a(new ArrayList<String>(), 0, false);
                    this._i();
                    break;
                }
                case 16: {
                    this._n._e(true)._b(true);
                    this._o._e(false)._b(false);
                    this._t = true;
                    this._a(new ArrayList<String>(), 0, true);
                    this._i();
                }
            }
        }
    }

    public int _c() {
        int n = 0;
        for (int i = 0; i < 7; ++i) {
            if (!this._q[i]) continue;
            ++n;
        }
        return n;
    }

    public void _d() {
        int n = this.__ag;
        int n2 = this.__ah;
        if (this._r > 0) {
            this._f._d(true);
            this._g._a(n + 85, n2 + 130);
            this._g._a(mcnh._c("mail.btn.no"));
        } else {
            this._f._d(false);
            this._g._a(n + 58, n2 + 130);
            this._g._a(mcnh._c("mail.btn.back"));
        }
    }

    public void _e() {
        int n;
        for (n = 0; n < 7; ++n) {
            this._q[n] = false;
            this._l[n]._b(false);
            this._l[n]._d(false);
        }
        for (n = 0; n < 7 && n < this._s.size(); ++n) {
            zwat zwat2 = this._s.get(n);
            this._l[n]._a(zwat2);
            this._l[n]._b(true);
            this._l[n]._d(true);
        }
        this._r = 0;
        this._d();
    }

    public void _i() {
        new nwrm()._a(this._p * 7, this._t).sendToServer();
    }

    public void _a(ArrayList<String> arrayList, int n, boolean bl) {
        this._s.clear();
        for (String string : arrayList) {
            this._s.add(qlgf._a(string));
        }
        this._u = (n - 1) / 7;
        this._u = Math.max(0, this._u);
        if (this._p > this._u) {
            this._p = this._u;
            this._i();
        } else {
            this._e();
        }
    }

    @Override
    public void _a(String string) {
        if ("delete_ok".equals(string)) {
            this._i();
        }
    }

    @Override
    public ResourceLocation _g() {
        return ywry._N;
    }

    @Override
    protected void _b(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.__ag;
        int n4 = this.__ah;
        this.mc._R()._a(_a);
        this._a(n3, n4, this.__ad + 1, this.__ae, 8, 8, this._Y + 10, this._Z + 10, 512, 512);
    }

    @Override
    protected void _c(float f, int n, int n2) {
        int n3 = this.__ag;
        int n4 = this.__ah;
        GL11.glPushMatrix();
        this._a(n3, n4);
        mcmy mcmy2 = yfpk._i;
        mcmy mcmy3 = yfpk._h;
        mcmy2._b(mcnh._c("mail.title.msg_list"), this.__ad / 2 - 4, 8.0, -1979721, 1.0f);
        mcmy3._a(mcnh._c("mail.label.page") + " " + (this._p + 1) + "/" + (this._u + 1), this.__ad / 2, 218.0, -1979721, 1.0f);
        GL11.glPopMatrix();
    }

    class kjui
    extends dzwv {
        private String _b;
        private String _c;
        private String _d;
        private String _e;
        private int _f;
        private zwat _g;

        public kjui(ywry ywry2, int n) {
            super(ywry2, n);
            this._d(117, 24);
            this._a(new int[6]);
        }

        public kjui _a(zwat zwat2) {
            mcmy mcmy2 = yfpk._c;
            this._g = zwat2;
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                this._f = zwat2._j();
                this._b = zwat2._d();
                this._c = ywry._O.format(zwat2._i());
                this._d = zwat2._h();
                this._e = zwat2._b();
                if (mcmy2._a(this._b) > 100.0) {
                    this._b = mcmy2._a(this._b, 100);
                }
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                Calendar calendar3 = Calendar.getInstance();
                calendar.setTime(simpleDateFormat.parse(this._c));
                calendar2.add(6, -1);
                if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
                    this._c = kjui._b("date.yesterday");
                }
                if (calendar.get(1) == calendar3.get(1) && calendar.get(6) == calendar3.get(6)) {
                    this._c = kjui._b("date.today");
                }
                if (this._c.contains(" ")) {
                    this._c = this._c.substring(0, this._c.indexOf(" "));
                }
            }
            catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            return this;
        }

        @Override
        protected void _b(int n, int n2) {
            boolean bl;
            eidj eidj2 = kjui._a(this._g._f());
            if ("quests".equals(this._d)) {
                qozx._a(17, 2, ywry._d("quest_reward"));
            } else if (eidj2 != null && !this._g._g().equals("read_opened")) {
                if (eidj2._b().length > 0) {
                    qozx._a(17, 2, ywry._d("icon_item"));
                } else {
                    qozx._a(17, 2, ywry._d("icon_rub"));
                }
            } else if ("common".equals(this._d)) {
                qozx._a(17, 2, ywry._d("icon_mail"));
            } else if ("auction".equals(this._d)) {
                qozx._a(17, 2, ywry._d("icon_auc"));
            }
            boolean bl2 = bl = n - this._y < 15;
            if (bl && this._c()) {
                GL11.glColor4d(1.0, 0.8, 0.4, 1.0);
            }
            if (mcnh.this._q[this._H]) {
                qozx._a(6, 7, ywry._d("checkbox_overlay"));
            } else {
                qozx._a(6, 7, ywry._d("checkbox"));
            }
            int[] nArray = ywry._d("hr");
            qozx._a(2.0, 20.0, nArray[4] - 63, nArray[5], nArray[0], nArray[1], nArray[2], nArray[3], 512.0, 512.0);
        }

        @Override
        public void _a(int n, int n2, int n3) {
            if (n - this._y >= 15) {
                super._a(n, n2, n3);
            } else {
                this._p();
            }
        }

        public void _p() {
            ((mcnh)mcnh.this)._q[this._H] = !mcnh.this._q[this._H];
            mcnh.this._r = mcnh.this._c();
            mcnh.this._d();
        }

        @Override
        protected void _d() {
        }

        @Override
        public void _b(Minecraft minecraft, int n, int n2) {
            mcmy mcmy2 = yfpk._c;
            mcmy mcmy3 = yfpk._b;
            String string = "quests".equalsIgnoreCase(this._d) ? this._e : (mcnh.this._t ? kjui._b("mail.list.to") : kjui._b("mail.list.from")) + this._b;
            mcmy2._b(string, 37.0, 2.0, this._c() ? -33014 : -1979721);
            mcmy3._b(this._c, 37.0, 10.0, this._c() ? -33014 : -1979721);
        }
    }
}


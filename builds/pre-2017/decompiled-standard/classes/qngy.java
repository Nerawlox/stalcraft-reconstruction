/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class qngy
extends lpaq {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
    public static tgfo _b = new tgfo("tmp", true, 45);
    public static int _c = tgbl.field_78030_b.func_78021_a();
    public float _d;
    public boolean _e;
    public boolean _f;
    public ifms _g;
    public List _h;
    public yeso _i;
    public boolean _j;
    public jzuc _k;
    public static int _l = 0;
    public int _m = 0;

    public qngy(EntityPlayer entityPlayer) {
        super(new dyct(entityPlayer));
        entityPlayer.field_71070_bA = this.field_74193_d;
        this.field_73885_j = true;
        entityPlayer.func_71064_a(sdqa._f, 1);
        this.field_74195_c = 136;
        this.field_74194_b = 195;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        if (!this.field_73882_e._j._i()) {
            this.field_73882_e._a(new cebg(this.field_73882_e._t));
        }
    }

    @Override
    public void func_74191_a(yeso yeso2, int n, int n2, int n3) {
        this._j = true;
        boolean bl = n3 == 1;
        int n4 = n3 = n == -999 && n3 == 0 ? 4 : n3;
        if (yeso2 == null && _c != tgbl.field_78036_m.func_78021_a() && n3 != 5) {
            eidj eidj2 = this.field_73882_e._t.field_71071_by;
            if (eidj2._g() != null) {
                if (n2 == 0) {
                    this.field_73882_e._t.func_71021_b(eidj2._g());
                    this.field_73882_e._j._a(eidj2._g());
                    eidj2._d(null);
                }
                if (n2 == 1) {
                    cvzo cvzo2 = eidj2._g()._a(1);
                    this.field_73882_e._t.func_71021_b(cvzo2);
                    this.field_73882_e._j._a(cvzo2);
                    if (eidj2._g()._b == 0) {
                        eidj2._d(null);
                    }
                }
            }
        } else if (yeso2 == this._i && bl) {
            for (int i = 0; i < this.field_73882_e._t.field_71069_bz.func_75138_a().size(); ++i) {
                this.field_73882_e._j._a((cvzo)null, i);
            }
        } else if (_c == tgbl.field_78036_m.func_78021_a()) {
            if (yeso2 == this._i) {
                this.field_73882_e._t.field_71071_by._d(null);
            } else if (n3 == 4 && yeso2 != null && yeso2.func_75216_d()) {
                cvzo cvzo3 = yeso2.func_75209_a(n2 == 0 ? 1 : yeso2.func_75211_c()._d());
                this.field_73882_e._t.func_71021_b(cvzo3);
                this.field_73882_e._j._a(cvzo3);
            } else if (n3 == 4 && this.field_73882_e._t.field_71071_by._g() != null) {
                this.field_73882_e._t.func_71021_b(this.field_73882_e._t.field_71071_by._g());
                this.field_73882_e._j._a(this.field_73882_e._t.field_71071_by._g());
                this.field_73882_e._t.field_71071_by._d(null);
            } else {
                this.field_73882_e._t.field_71069_bz.func_75144_a(yeso2 == null ? n : ekhg._a((ekhg)((ekhg)yeso2)).field_75222_d, n2, n3, this.field_73882_e._t);
                this.field_73882_e._t.field_71069_bz.func_75142_b();
            }
        } else if (n3 != 5 && yeso2.field_75224_c == _b) {
            eidj eidj3 = this.field_73882_e._t.field_71071_by;
            cvzo cvzo4 = eidj3._g();
            cvzo cvzo5 = yeso2.func_75211_c();
            if (n3 == 2) {
                if (cvzo5 != null && n2 >= 0 && n2 < 9) {
                    cvzo cvzo6 = cvzo5._l();
                    cvzo6._b = cvzo6._d();
                    this.field_73882_e._t.field_71071_by.func_70299_a(n2, cvzo6);
                    this.field_73882_e._t.field_71069_bz.func_75142_b();
                }
                return;
            }
            if (n3 == 3) {
                if (eidj3._g() == null && yeso2.func_75216_d()) {
                    cvzo cvzo7 = yeso2.func_75211_c()._l();
                    cvzo7._b = cvzo7._d();
                    eidj3._d(cvzo7);
                }
                return;
            }
            if (n3 == 4) {
                if (cvzo5 != null) {
                    cvzo cvzo8 = cvzo5._l();
                    cvzo8._b = n2 == 0 ? 1 : cvzo8._d();
                    this.field_73882_e._t.func_71021_b(cvzo8);
                    this.field_73882_e._j._a(cvzo8);
                }
                return;
            }
            if (cvzo4 != null && cvzo5 != null && cvzo4._b(cvzo5) && cvzo._a(cvzo4, cvzo5)) {
                if (n2 == 0) {
                    if (bl) {
                        cvzo4._b = cvzo4._d();
                    } else if (cvzo4._b < cvzo4._d()) {
                        ++cvzo4._b;
                    }
                } else if (cvzo4._b <= 1) {
                    eidj3._d(null);
                } else {
                    --cvzo4._b;
                }
            } else if (cvzo5 != null && cvzo4 == null) {
                eidj3._d(cvzo._c(cvzo5));
                cvzo4 = eidj3._g();
                if (bl) {
                    cvzo4._b = cvzo4._d();
                }
            } else {
                eidj3._d(null);
            }
        } else {
            this.field_74193_d.func_75144_a(yeso2 == null ? n : yeso2.field_75222_d, n2, n3, this.field_73882_e._t);
            if (jjgc.func_94532_c(n2) == 2) {
                for (int i = 0; i < 9; ++i) {
                    this.field_73882_e._j._a(this.field_74193_d.func_75139_a(45 + i).func_75211_c(), 36 + i);
                }
            } else if (yeso2 != null) {
                cvzo cvzo9 = this.field_74193_d.func_75139_a(yeso2.field_75222_d).func_75211_c();
                this.field_73882_e._j._a(cvzo9, yeso2.field_75222_d - this.field_74193_d.field_75151_b.size() + 9 + 36);
            }
        }
    }

    @Override
    public void func_73866_w_() {
        if (this.field_73882_e._j._i()) {
            super.func_73866_w_();
            this.field_73887_h.clear();
            Keyboard.enableRepeatEvents(true);
            this._g = new ifms(this.field_73886_k, this.field_74198_m + 82, this.field_74197_n + 6, 89, this.field_73886_k._c);
            this._g.func_73804_f(15);
            this._g.func_73786_a(false);
            this._g.func_73790_e(false);
            this._g.func_73794_g(0xFFFFFF);
            int n = _c;
            _c = -1;
            this._a(tgbl.field_78032_a[n]);
            this._k = new jzuc(this.field_73882_e);
            this.field_73882_e._t.field_71069_bz.func_75132_a(this._k);
            int n2 = tgbl.field_78032_a.length;
            if (n2 > 12) {
                this.field_73887_h.add(new jiok(101, this.field_74198_m, this.field_74197_n - 50, 20, 20, "<"));
                this.field_73887_h.add(new jiok(102, this.field_74198_m + this.field_74194_b - 20, this.field_74197_n - 50, 20, 20, ">"));
                this._m = (n2 - 12) / 10 + 1;
            }
        } else {
            this.field_73882_e._a(new cebg(this.field_73882_e._t));
        }
    }

    @Override
    public void func_73874_b() {
        super.func_73874_b();
        if (this.field_73882_e._t != null && this.field_73882_e._t.field_71071_by != null) {
            this.field_73882_e._t.field_71069_bz.func_82847_b(this._k);
        }
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (!tgbl.field_78032_a[_c].hasSearchBar()) {
            if (GameSettings.func_100015_a(this.field_73882_e._M.field_74310_D)) {
                this._a(tgbl.field_78027_g);
            } else {
                super.func_73869_a(c, n);
            }
        } else {
            if (this._j) {
                this._j = false;
                this._g.func_73782_a("");
            }
            if (!this.func_82319_a(n)) {
                if (this._g.func_73802_a(c, n)) {
                    this._a();
                } else {
                    super.func_73869_a(c, n);
                }
            }
        }
    }

    public void _a() {
        dyct dyct2 = (dyct)this.field_74193_d;
        dyct2._a.clear();
        tgbl tgbl2 = tgbl.field_78032_a[_c];
        if (tgbl2.hasSearchBar() && tgbl2 != tgbl.field_78027_g) {
            tgbl2.func_78018_a(dyct2._a);
            this._a(dyct2);
            return;
        }
        for (tgdv tgdv2 : tgdv.field_77698_e) {
            if (tgdv2 == null || tgdv2.func_77640_w() == null) continue;
            tgdv2.func_77633_a(tgdv2.field_77779_bT, null, dyct2._a);
        }
        for (zhqo zhqo2 : zhqo._a) {
            if (zhqo2 == null || zhqo2._A == null) continue;
            tgdv.field_92105_bW._a(zhqo2, dyct2._a);
        }
        this._a(dyct2);
    }

    public void _a(dyct dyct2) {
        Iterator iterator = dyct2._a.iterator();
        String string = this._g.func_73781_b().toLowerCase();
        while (iterator.hasNext()) {
            cvzo cvzo2 = (cvzo)iterator.next();
            boolean bl = false;
            for (String string2 : cvzo2._a((EntityPlayer)this.field_73882_e._t, this.field_73882_e._M.field_82882_x)) {
                if (!string2.toLowerCase().contains(string)) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            iterator.remove();
        }
        this._d = 0.0f;
        dyct2._a(0.0f);
    }

    @Override
    public void func_74189_g(int n, int n2) {
        tgbl tgbl2 = tgbl.field_78032_a[_c];
        if (tgbl2 != null && tgbl2.func_78019_g()) {
            this.field_73886_k._b(wpcz._a(tgbl2.func_78024_c()), 8, 6, 0x404040);
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        if (n3 == 0) {
            int n4 = n - this.field_74198_m;
            int n5 = n2 - this.field_74197_n;
            for (tgbl tgbl2 : tgbl.field_78032_a) {
                if (!this._a(tgbl2, n4, n5)) continue;
                return;
            }
        }
        super.func_73864_a(n, n2, n3);
    }

    @Override
    public void func_73879_b(int n, int n2, int n3) {
        if (n3 == 0) {
            int n4 = n - this.field_74198_m;
            int n5 = n2 - this.field_74197_n;
            for (tgbl tgbl2 : tgbl.field_78032_a) {
                if (tgbl2 == null || !this._a(tgbl2, n4, n5)) continue;
                this._a(tgbl2);
                return;
            }
        }
        super.func_73879_b(n, n2, n3);
    }

    public boolean _b() {
        if (tgbl.field_78032_a[_c] == null) {
            return false;
        }
        return _c != tgbl.field_78036_m.func_78021_a() && tgbl.field_78032_a[_c].func_78017_i() && ((dyct)this.field_74193_d)._a();
    }

    public void _a(tgbl tgbl2) {
        if (tgbl2 == null) {
            return;
        }
        int n = _c;
        _c = tgbl2.func_78021_a();
        dyct dyct2 = (dyct)this.field_74193_d;
        this.field_94077_p.clear();
        dyct2._a.clear();
        tgbl2.func_78018_a(dyct2._a);
        if (tgbl2 == tgbl.field_78036_m) {
            jjgc jjgc2 = this.field_73882_e._t.field_71069_bz;
            if (this._h == null) {
                this._h = dyct2.field_75151_b;
            }
            dyct2.field_75151_b = new ArrayList();
            for (int i = 0; i < jjgc2.field_75151_b.size(); ++i) {
                int n2;
                int n3;
                int n4;
                ekhg ekhg2 = new ekhg(this, (yeso)jjgc2.field_75151_b.get(i), i);
                dyct2.field_75151_b.add(ekhg2);
                if (i >= 5 && i < 9) {
                    n4 = i - 5;
                    n3 = n4 / 2;
                    n2 = n4 % 2;
                    ekhg2.field_75223_e = 9 + n3 * 54;
                    ekhg2.field_75221_f = 6 + n2 * 27;
                    continue;
                }
                if (i >= 0 && i < 5) {
                    ekhg2.field_75221_f = -2000;
                    ekhg2.field_75223_e = -2000;
                    continue;
                }
                if (i >= jjgc2.field_75151_b.size()) continue;
                n4 = i - 9;
                n3 = n4 % 9;
                n2 = n4 / 9;
                ekhg2.field_75223_e = 9 + n3 * 18;
                ekhg2.field_75221_f = i >= 36 ? 112 : 54 + n2 * 18;
            }
            this._i = new yeso(_b, 0, 173, 112);
            dyct2.field_75151_b.add(this._i);
        } else if (n == tgbl.field_78036_m.func_78021_a()) {
            dyct2.field_75151_b = this._h;
            this._h = null;
        }
        if (this._g != null) {
            if (tgbl2.hasSearchBar()) {
                this._g.func_73790_e(true);
                this._g.func_73805_d(false);
                this._g.func_73796_b(true);
                this._g.func_73782_a("");
                this._a();
            } else {
                this._g.func_73790_e(false);
                this._g.func_73805_d(true);
                this._g.func_73796_b(false);
            }
        }
        this._d = 0.0f;
        dyct2._a(0.0f);
    }

    @Override
    public void func_73867_d() {
        super.func_73867_d();
        int n = Mouse.getEventDWheel();
        if (n != 0 && this._b()) {
            int n2 = ((dyct)this.field_74193_d)._a.size() / 9 - 5 + 1;
            if (n > 0) {
                n = 1;
            }
            if (n < 0) {
                n = -1;
            }
            this._d = (float)((double)this._d - (double)n / (double)n2);
            if (this._d < 0.0f) {
                this._d = 0.0f;
            }
            if (this._d > 1.0f) {
                this._d = 1.0f;
            }
            ((dyct)this.field_74193_d)._a(this._d);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        boolean bl = Mouse.isButtonDown(0);
        int n3 = this.field_74198_m;
        int n4 = this.field_74197_n;
        int n5 = n3 + 175;
        int n6 = n4 + 18;
        int n7 = n5 + 14;
        int n8 = n6 + 112;
        if (!this._f && bl && n >= n5 && n2 >= n6 && n < n7 && n2 < n8) {
            this._e = this._b();
        }
        if (!bl) {
            this._e = false;
        }
        this._f = bl;
        if (this._e) {
            this._d = ((float)(n2 - n6) - 7.5f) / ((float)(n8 - n6) - 15.0f);
            if (this._d < 0.0f) {
                this._d = 0.0f;
            }
            if (this._d > 1.0f) {
                this._d = 1.0f;
            }
            ((dyct)this.field_74193_d)._a(this._d);
        }
        super.func_73863_a(n, n2, f);
        tgbl[] tgblArray = tgbl.field_78032_a;
        int n9 = _l * 10;
        int n10 = Math.min(tgblArray.length, (_l + 1) * 10 + 2);
        if (_l != 0) {
            n9 += 2;
        }
        boolean bl2 = false;
        for (int i = n9; i < n10; ++i) {
            tgbl tgbl2 = tgblArray[i];
            if (tgbl2 == null || !this._b(tgbl2, n, n2)) continue;
            bl2 = true;
            break;
        }
        if (!bl2 && !this._b(tgbl.field_78027_g, n, n2)) {
            this._b(tgbl.field_78036_m, n, n2);
        }
        if (this._i != null && _c == tgbl.field_78036_m.func_78021_a() && this.func_74188_c(this._i.field_75223_e, this._i.field_75221_f, 16, 16, n, n2)) {
            this.func_74190_a(wpcz._a("inventory.binSlot"), n, n2);
        }
        if (this._m != 0) {
            String string = String.format("%d / %d", _l + 1, this._m + 1);
            int n11 = this.field_73886_k._b(string);
            GL11.glDisable(2896);
            this.field_73735_i = 300.0f;
            qngy.field_74196_a.field_77023_b = 300.0f;
            this.field_73886_k._b(string, this.field_74198_m + this.field_74194_b / 2 - n11 / 2, this.field_74197_n - 44, -1);
            this.field_73735_i = 0.0f;
            qngy.field_74196_a.field_77023_b = 0.0f;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
    }

    @Override
    public void func_74184_a(cvzo cvzo2, int n, int n2) {
        if (_c == tgbl.field_78027_g.func_78021_a()) {
            Map map;
            List list = cvzo2._a((EntityPlayer)this.field_73882_e._t, this.field_73882_e._M.field_82882_x);
            tgbl tgbl2 = cvzo2._a().func_77640_w();
            if (tgbl2 == null && cvzo2._d == tgdv.field_92105_bW.field_77779_bT && (map = zhty._a(cvzo2)).size() == 1) {
                zhqo zhqo2 = zhqo._a[(Integer)map.keySet().iterator().next()];
                for (tgbl tgbl3 : tgbl.field_78032_a) {
                    if (!tgbl3.func_111226_a(zhqo2._A)) continue;
                    tgbl2 = tgbl3;
                    break;
                }
            }
            if (tgbl2 != null) {
                list.add(1, "" + (Object)((Object)ezfc._r) + (Object)((Object)ezfc._j) + wpcz._a(tgbl2.func_78024_c()));
            }
            for (int i = 0; i < list.size(); ++i) {
                if (i == 0) {
                    list.set(i, "\u00a7" + Integer.toHexString(cvzo2._w()._e) + (String)list.get(i));
                    continue;
                }
                list.set(i, (Object)((Object)ezfc._h) + (String)list.get(i));
            }
            this.func_102021_a(list, n, n2);
        } else {
            super.func_74184_a(cvzo2, n, n2);
        }
    }

    @Override
    public void func_74185_a(float f, int n, int n2) {
        int n3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        qnon._c();
        tgbl tgbl2 = tgbl.field_78032_a[_c];
        tgbl[] tgblArray = tgbl.field_78032_a;
        int n4 = tgblArray.length;
        int n5 = _l * 10;
        n4 = Math.min(tgblArray.length, (_l + 1) * 10 + 2);
        if (_l != 0) {
            n5 += 2;
        }
        for (n3 = n5; n3 < n4; ++n3) {
            tgbl tgbl3 = tgblArray[n3];
            this.field_73882_e._R()._a(_a);
            if (tgbl3 == null || tgbl3.func_78021_a() == _c) continue;
            this._b(tgbl3);
        }
        if (_l != 0) {
            if (tgbl2 != tgbl.field_78027_g) {
                this.field_73882_e._R()._a(_a);
                this._b(tgbl.field_78027_g);
            }
            if (tgbl2 != tgbl.field_78036_m) {
                this.field_73882_e._R()._a(_a);
                this._b(tgbl.field_78036_m);
            }
        }
        this.field_73882_e._R()._a(new ResourceLocation("textures/gui/container/creative_inventory/tab_" + tgbl2.func_78015_f()));
        this.func_73729_b(this.field_74198_m, this.field_74197_n, 0, 0, this.field_74194_b, this.field_74195_c);
        this._g.func_73795_f();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n6 = this.field_74198_m + 175;
        n4 = this.field_74197_n + 18;
        n3 = n4 + 112;
        this.field_73882_e._R()._a(_a);
        if (tgbl2.func_78017_i()) {
            this.func_73729_b(n6, n4 + (int)((float)(n3 - n4 - 17) * this._d), 232 + (this._b() ? 0 : 12), 0, 12, 15);
        }
        if ((tgbl2 == null || tgbl2.getTabPage() != _l) && tgbl2 != tgbl.field_78027_g && tgbl2 != tgbl.field_78036_m) {
            return;
        }
        this._b(tgbl2);
        if (tgbl2 == tgbl.field_78036_m) {
            cebg._a(this.field_74198_m + 43, this.field_74197_n + 45, 20, this.field_74198_m + 43 - n, this.field_74197_n + 45 - 30 - n2, this.field_73882_e._t);
        }
    }

    public boolean _a(tgbl tgbl2, int n, int n2) {
        if (tgbl2.getTabPage() != _l && tgbl2 != tgbl.field_78027_g && tgbl2 != tgbl.field_78036_m) {
            return false;
        }
        int n3 = tgbl2.func_78020_k();
        int n4 = 28 * n3;
        int n5 = 0;
        if (n3 == 5) {
            n4 = this.field_74194_b - 28 + 2;
        } else if (n3 > 0) {
            n4 += n3;
        }
        int n6 = tgbl2.func_78023_l() ? n5 - 32 : n5 + this.field_74195_c;
        return n >= n4 && n <= n4 + 28 && n2 >= n6 && n2 <= n6 + 32;
    }

    public boolean _b(tgbl tgbl2, int n, int n2) {
        int n3 = tgbl2.func_78020_k();
        int n4 = 28 * n3;
        int n5 = 0;
        if (n3 == 5) {
            n4 = this.field_74194_b - 28 + 2;
        } else if (n3 > 0) {
            n4 += n3;
        }
        int n6 = tgbl2.func_78023_l() ? n5 - 32 : n5 + this.field_74195_c;
        if (this.func_74188_c(n4 + 3, n6 + 3, 23, 27, n, n2)) {
            this.func_74190_a(wpcz._a(tgbl2.func_78024_c()), n, n2);
            return true;
        }
        return false;
    }

    public void _b(tgbl tgbl2) {
        boolean bl = tgbl2.func_78021_a() == _c;
        boolean bl2 = tgbl2.func_78023_l();
        int n = tgbl2.func_78020_k();
        int n2 = n * 28;
        int n3 = 0;
        int n4 = this.field_74198_m + 28 * n;
        int n5 = this.field_74197_n;
        int n6 = 32;
        if (bl) {
            n3 += 32;
        }
        if (n == 5) {
            n4 = this.field_74198_m + this.field_74194_b - 28;
        } else if (n > 0) {
            n4 += n;
        }
        if (bl2) {
            n5 -= 28;
        } else {
            n3 += 64;
            n5 += this.field_74195_c - 4;
        }
        GL11.glDisable(2896);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        this.func_73729_b(n4, n5, n2, n3, 28, n6);
        this.field_73735_i = 100.0f;
        qngy.field_74196_a.field_77023_b = 100.0f;
        int n7 = bl2 ? 1 : -1;
        GL11.glEnable(2896);
        GL11.glEnable(32826);
        cvzo cvzo2 = tgbl2.getIconItemStack();
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo2, n4 += 6, n5 += 8 + n7);
        field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._R(), cvzo2, n4, n5);
        GL11.glDisable(2896);
        qngy.field_74196_a.field_77023_b = 0.0f;
        this.field_73735_i = 0.0f;
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(new ohbq(this.field_73882_e._X));
        }
        if (jiok2.field_73741_f == 1) {
            this.field_73882_e._a(new uzta(this, this.field_73882_e._X));
        }
        if (jiok2.field_73741_f == 101) {
            _l = Math.max(_l - 1, 0);
        } else if (jiok2.field_73741_f == 102) {
            _l = Math.min(_l + 1, this._m);
        }
    }

    public int _c() {
        return _c;
    }

    public static tgfo _d() {
        return _b;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import org.apache.commons.lang3.StringUtils;

public class sdci
extends jjgc {
    public mssh _a = new wpoq();
    public mssh _b = new netm(this, "Repair", true, 2);
    public ozlu _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public String _i;
    public final EntityPlayer _j;

    public sdci(eidj eidj2, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        int n4;
        this._c = ozlu2;
        this._d = n;
        this._e = n2;
        this._f = n3;
        this._j = entityPlayer;
        this.func_75146_a(new yeso(this._b, 0, 27, 47));
        this.func_75146_a(new yeso(this._b, 1, 76, 47));
        this.func_75146_a(new cvvn(this, this._a, 2, 134, 47, ozlu2, n, n2, n3));
        for (n4 = 0; n4 < 3; ++n4) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(eidj2, i + n4 * 9 + 9, 8 + i * 18, 84 + n4 * 18));
            }
        }
        for (n4 = 0; n4 < 9; ++n4) {
            this.func_75146_a(new yeso(eidj2, n4, 8 + n4 * 18, 142));
        }
    }

    @Override
    public void func_75130_a(mssh mssh2) {
        super.func_75130_a(mssh2);
        if (mssh2 == this._b) {
            this._a();
        }
    }

    public void _a() {
        cvzo cvzo2 = this._b.func_70301_a(0);
        this._g = 0;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (cvzo2 == null) {
            this._a.func_70299_a(0, null);
            this._g = 0;
        } else {
            int n4;
            zhqo zhqo2;
            Iterator iterator2;
            int n5;
            int n6;
            int n7;
            int n8;
            cvzo cvzo3 = cvzo2._l();
            cvzo cvzo4 = this._b.func_70301_a(1);
            Map map = zhty._a(cvzo3);
            boolean bl = false;
            int n9 = n2 + cvzo2._C() + (cvzo4 == null ? 0 : cvzo4._C());
            this._h = 0;
            if (cvzo4 != null) {
                boolean bl2 = bl = cvzo4._d == tgdv.field_92105_bW.field_77779_bT && tgdv.field_92105_bW._a(cvzo4)._d() > 0;
                if (cvzo3._f() && tgdv.field_77698_e[cvzo3._d].func_82789_a(cvzo2, cvzo4)) {
                    n8 = Math.min(cvzo3._i(), cvzo3._k() / 4);
                    if (n8 <= 0) {
                        this._a.func_70299_a(0, null);
                        this._g = 0;
                        return;
                    }
                    for (n7 = 0; n8 > 0 && n7 < cvzo4._b; ++n7) {
                        n6 = cvzo3._i() - n8;
                        cvzo3._b(n6);
                        n += Math.max(1, n8 / 100) + map.size();
                        n8 = Math.min(cvzo3._i(), cvzo3._k() / 4);
                    }
                    this._h = n7;
                } else {
                    if (!(bl || cvzo3._d == cvzo4._d && cvzo3._f())) {
                        this._a.func_70299_a(0, null);
                        this._g = 0;
                        return;
                    }
                    if (cvzo3._f() && !bl) {
                        n8 = cvzo2._k() - cvzo2._i();
                        n7 = cvzo4._k() - cvzo4._i();
                        n6 = n7 + cvzo3._k() * 12 / 100;
                        int n10 = n8 + n6;
                        n5 = cvzo3._k() - n10;
                        if (n5 < 0) {
                            n5 = 0;
                        }
                        if (n5 < cvzo3._j()) {
                            cvzo3._b(n5);
                            n += Math.max(1, n6 / 100);
                        }
                    }
                    Map map2 = zhty._a(cvzo4);
                    iterator2 = map2.keySet().iterator();
                    while (iterator2.hasNext()) {
                        int n11;
                        n6 = (Integer)iterator2.next();
                        zhqo2 = zhqo._a[n6];
                        n5 = map.containsKey(n6) ? (Integer)map.get(n6) : 0;
                        n4 = (Integer)map2.get(n6);
                        int n12 = n5 == n4 ? ++n4 : Math.max(n4, n5);
                        n4 = n12;
                        int n13 = n4 - n5;
                        boolean bl3 = zhqo2._a(cvzo2);
                        if (this._j.field_71075_bZ._d || cvzo2._d == lprm.field_92105_bW.field_77779_bT) {
                            bl3 = true;
                        }
                        Iterator iterator3 = map.keySet().iterator();
                        while (iterator3.hasNext()) {
                            n11 = (Integer)iterator3.next();
                            if (n11 == n6 || zhqo2._a(zhqo._a[n11])) continue;
                            bl3 = false;
                            n += n13;
                        }
                        if (!bl3) continue;
                        if (n4 > zhqo2._c()) {
                            n4 = zhqo2._c();
                        }
                        map.put(n6, n4);
                        n11 = 0;
                        switch (zhqo2._a()) {
                            case 1: {
                                n11 = 8;
                                break;
                            }
                            case 2: {
                                n11 = 4;
                            }
                            default: {
                                break;
                            }
                            case 5: {
                                n11 = 2;
                                break;
                            }
                            case 10: {
                                n11 = 1;
                            }
                        }
                        if (bl) {
                            n11 = Math.max(1, n11 / 2);
                        }
                        n += n11 * n13;
                    }
                }
            }
            if (StringUtils.isBlank(this._i)) {
                if (cvzo2._u()) {
                    n3 = cvzo2._f() ? 7 : cvzo2._b * 5;
                    n += n3;
                    cvzo3._t();
                }
            } else if (!this._i.equals(cvzo2._s())) {
                n3 = cvzo2._f() ? 7 : cvzo2._b * 5;
                n += n3;
                if (cvzo2._u()) {
                    n9 += n3 / 2;
                }
                cvzo3._a(this._i);
            }
            n8 = 0;
            iterator2 = map.keySet().iterator();
            while (iterator2.hasNext()) {
                n6 = (Integer)iterator2.next();
                zhqo2 = zhqo._a[n6];
                n5 = (Integer)map.get(n6);
                n4 = 0;
                ++n8;
                switch (zhqo2._a()) {
                    case 1: {
                        n4 = 8;
                        break;
                    }
                    case 2: {
                        n4 = 4;
                    }
                    default: {
                        break;
                    }
                    case 5: {
                        n4 = 2;
                        break;
                    }
                    case 10: {
                        n4 = 1;
                    }
                }
                if (bl) {
                    n4 = Math.max(1, n4 / 2);
                }
                n9 += n8 + n5 * n4;
            }
            if (bl) {
                n9 = Math.max(1, n9 / 2);
            }
            if (bl && cvzo3 != null && !tgdv.field_77698_e[cvzo3._d].isBookEnchantable(cvzo3, cvzo4)) {
                cvzo3 = null;
            }
            this._g = n9 + n;
            if (n <= 0) {
                cvzo3 = null;
            }
            if (n3 == n && n3 > 0 && this._g >= 40) {
                this._g = 39;
            }
            if (this._g >= 40 && !this._j.field_71075_bZ._d) {
                cvzo3 = null;
            }
            if (cvzo3 != null) {
                n7 = cvzo3._C();
                if (cvzo4 != null && n7 < cvzo4._C()) {
                    n7 = cvzo4._C();
                }
                if (cvzo3._u()) {
                    n7 -= 9;
                }
                if (n7 < 0) {
                    n7 = 0;
                }
                cvzo3._d(n7 += 2);
                zhty._a(map, cvzo3);
            }
            this._a.func_70299_a(0, cvzo3);
            this.func_75142_b();
        }
    }

    @Override
    public void func_75132_a(sdcd sdcd2) {
        super.func_75132_a(sdcd2);
        sdcd2.func_71112_a(this, 0, this._g);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_75137_b(int n, int n2) {
        if (n == 0) {
            this._g = n2;
        }
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        if (!this._c.field_72995_K) {
            for (int i = 0; i < this._b.func_70302_i_(); ++i) {
                cvzo cvzo2 = this._b.func_70304_b(i);
                if (cvzo2 == null) continue;
                entityPlayer.func_71021_b(cvzo2);
            }
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return this._c.func_72798_a(this._d, this._e, this._f) != twgu.field_82510_ck.field_71990_ca ? false : entityPlayer.func_70092_e((double)this._d + 0.5, (double)this._e + 0.5, (double)this._f + 0.5) <= 64.0;
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n == 2) {
                if (!this.func_75135_a(cvzo3, 3, 39, true)) {
                    return null;
                }
                yeso2.func_75220_a(cvzo3, cvzo2);
            } else if (n != 0 && n != 1 ? n >= 3 && n < 39 && !this.func_75135_a(cvzo3, 0, 2, false) : !this.func_75135_a(cvzo3, 3, 39, false)) {
                return null;
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
            if (cvzo3._b == cvzo2._b) {
                return null;
            }
            yeso2.func_82870_a(entityPlayer, cvzo3);
        }
        return cvzo2;
    }

    public void _a(String string) {
        this._i = string;
        if (this.func_75139_a(2).func_75216_d()) {
            cvzo cvzo2 = this.func_75139_a(2).func_75211_c();
            if (StringUtils.isBlank(string)) {
                cvzo2._t();
            } else {
                cvzo2._a(this._i);
            }
        }
        this._a();
    }

    public static mssh _a(sdci sdci2) {
        return sdci2._b;
    }

    public static int _b(sdci sdci2) {
        return sdci2._h;
    }
}


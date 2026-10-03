/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.zwaw;

public class ywfm
extends plne {
    public ozlu _a;
    public final List _b = new ArrayList();
    public final List _c = new ArrayList();
    public final List _d = new ArrayList();
    public int _e;

    public ywfm(String string) {
        super(string);
    }

    public ywfm(ozlu ozlu2) {
        super("villages");
        this._a = ozlu2;
        this.func_76185_a();
    }

    public void _a(ozlu ozlu2) {
        this._a = ozlu2;
        for (mtdg mtdg2 : this._d) {
            mtdg2._a(ozlu2);
        }
    }

    public void _a(int n, int n2, int n3) {
        if (this._b.size() <= 64 && !this._d(n, n2, n3)) {
            this._b.add(new zwaw(n, n2, n3));
        }
    }

    public void _a() {
        ++this._e;
        for (mtdg mtdg2 : this._d) {
            mtdg2._a(this._e);
        }
        this._b();
        this._d();
        this._e();
        if (this._e % 400 == 0) {
            this.func_76185_a();
        }
    }

    public void _b() {
        Iterator iterator2 = this._d.iterator();
        while (iterator2.hasNext()) {
            mtdg mtdg2 = (mtdg)iterator2.next();
            if (!mtdg2._i()) continue;
            iterator2.remove();
            this.func_76185_a();
        }
    }

    public List _c() {
        return this._d;
    }

    public mtdg _a(int n, int n2, int n3, int n4) {
        mtdg mtdg2 = null;
        float f = Float.MAX_VALUE;
        for (mtdg mtdg3 : this._d) {
            float f2;
            float f3 = mtdg3._c()._b(n, n2, n3);
            if (!(f3 < f) || !(f3 <= (f2 = (float)(n4 + mtdg3._d())) * f2)) continue;
            mtdg2 = mtdg3;
            f = f3;
        }
        return mtdg2;
    }

    public void _d() {
        if (!this._b.isEmpty()) {
            this._a((zwaw)this._b.remove(0));
        }
    }

    public void _e() {
        for (int i = 0; i < this._c.size(); ++i) {
            mtdg mtdg22;
            ellv ellv2 = (ellv)this._c.get(i);
            boolean bl = false;
            for (mtdg mtdg22 : this._d) {
                float f;
                int n = (int)mtdg22._c()._b(ellv2._a, ellv2._b, ellv2._c);
                if ((float)n > (f = 32.0f + (float)mtdg22._d()) * f) continue;
                mtdg22._a(ellv2);
                bl = true;
                break;
            }
            if (bl) continue;
            mtdg22 = new mtdg(this._a);
            mtdg22._a(ellv2);
            this._d.add(mtdg22);
            this.func_76185_a();
        }
        this._c.clear();
    }

    public void _a(zwaw zwaw2) {
        int n = 16;
        int n2 = 4;
        int n3 = 16;
        for (int i = zwaw2._a - n; i < zwaw2._a + n; ++i) {
            for (int j = zwaw2._b - n2; j < zwaw2._b + n2; ++j) {
                for (int k = zwaw2._c - n3; k < zwaw2._c + n3; ++k) {
                    if (!this._e(i, j, k)) continue;
                    ellv ellv2 = this._b(i, j, k);
                    if (ellv2 == null) {
                        this._c(i, j, k);
                        continue;
                    }
                    ellv2._f = this._e;
                }
            }
        }
    }

    public ellv _b(int n, int n2, int n3) {
        ellv ellv2;
        Iterator iterator2 = this._c.iterator();
        do {
            if (!iterator2.hasNext()) {
                mtdg mtdg2;
                ellv ellv3;
                iterator2 = this._d.iterator();
                do {
                    if (iterator2.hasNext()) continue;
                    return null;
                } while ((ellv3 = (mtdg2 = (mtdg)iterator2.next())._d(n, n2, n3)) == null);
                return ellv3;
            }
            ellv2 = (ellv)iterator2.next();
        } while (ellv2._a != n || ellv2._c != n3 || Math.abs(ellv2._b - n2) > 1);
        return ellv2;
    }

    public void _c(int n, int n2, int n3) {
        int n4 = ((nutn)twgu.field_72054_aE)._a(this._a, n, n2, n3);
        if (n4 != 0 && n4 != 2) {
            int n5;
            int n6 = 0;
            for (n5 = -5; n5 < 0; ++n5) {
                if (!this._a.func_72937_j(n, n2, n3 + n5)) continue;
                --n6;
            }
            for (n5 = 1; n5 <= 5; ++n5) {
                if (!this._a.func_72937_j(n, n2, n3 + n5)) continue;
                ++n6;
            }
            if (n6 != 0) {
                this._c.add(new ellv(n, n2, n3, 0, n6 > 0 ? -2 : 2, this._e));
            }
        } else {
            int n7;
            int n8 = 0;
            for (n7 = -5; n7 < 0; ++n7) {
                if (!this._a.func_72937_j(n + n7, n2, n3)) continue;
                --n8;
            }
            for (n7 = 1; n7 <= 5; ++n7) {
                if (!this._a.func_72937_j(n + n7, n2, n3)) continue;
                ++n8;
            }
            if (n8 != 0) {
                this._c.add(new ellv(n, n2, n3, n8 > 0 ? -2 : 2, 0, this._e));
            }
        }
    }

    public boolean _d(int n, int n2, int n3) {
        zwaw zwaw2;
        Iterator iterator2 = this._b.iterator();
        do {
            if (!iterator2.hasNext()) {
                return false;
            }
            zwaw2 = (zwaw)iterator2.next();
        } while (zwaw2._a != n || zwaw2._b != n2 || zwaw2._c != n3);
        return true;
    }

    public boolean _e(int n, int n2, int n3) {
        int n4 = this._a.func_72798_a(n, n2, n3);
        return n4 == twgu.field_72054_aE.field_71990_ca;
    }

    @Override
    public void func_76184_a(qoac qoac2) {
        this._e = qoac2._f("Tick");
        bsyv bsyv2 = qoac2._n("Villages");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            mtdg mtdg2 = new mtdg();
            mtdg2._a(qoac3);
            this._d.add(mtdg2);
        }
    }

    @Override
    public void func_76187_b(qoac qoac2) {
        qoac2._a("Tick", this._e);
        bsyv bsyv2 = new bsyv("Villages");
        for (mtdg mtdg2 : this._d) {
            qoac qoac3 = new qoac("Village");
            mtdg2._b(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("Villages", bsyv2);
    }
}


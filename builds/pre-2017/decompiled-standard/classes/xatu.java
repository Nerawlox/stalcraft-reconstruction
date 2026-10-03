/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class xatu
extends matb {
    public boolean _a;
    public static Map _b = new HashMap();

    public boolean _a(ozlu ozlu2, int n, int n2, int n3, boolean bl) {
        if (!_b.containsKey(ozlu2)) {
            _b.put(ozlu2, new ArrayList());
        }
        List list = (List)_b.get(ozlu2);
        if (bl) {
            list.add(new uzqb(n, n2, n3, ozlu2.func_82737_E()));
        }
        int n4 = 0;
        for (int i = 0; i < list.size(); ++i) {
            uzqb uzqb2 = (uzqb)list.get(i);
            if (uzqb2._a != n || uzqb2._b != n2 || uzqb2._c != n3 || ++n4 < 8) continue;
            return true;
        }
        return false;
    }

    public xatu(int n, boolean bl) {
        super(n);
        this._a = bl;
        this.func_71907_b(true);
        this.func_71849_a(null);
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 2;
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72805_g(n, n2, n3) == 0) {
            super.func_71861_g(ozlu2, n, n2, n3);
        }
        if (this._a) {
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
        }
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        if (this._a) {
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
        }
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (!this._a) {
            return 0;
        }
        int n5 = sdrg2.func_72805_g(n, n2, n3);
        if (n5 == 5 && n4 == 1) {
            return 0;
        }
        if (n5 == 3 && n4 == 3) {
            return 0;
        }
        if (n5 == 4 && n4 == 2) {
            return 0;
        }
        if (n5 == 1 && n4 == 5) {
            return 0;
        }
        if (n5 == 2 && n4 == 4) {
            return 0;
        }
        return 15;
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (n4 == 5 && ozlu2.func_94574_k(n, n2 - 1, n3, 0)) {
            return true;
        }
        if (n4 == 3 && ozlu2.func_94574_k(n, n2, n3 - 1, 2)) {
            return true;
        }
        if (n4 == 4 && ozlu2.func_94574_k(n, n2, n3 + 1, 3)) {
            return true;
        }
        if (n4 == 1 && ozlu2.func_94574_k(n - 1, n2, n3, 4)) {
            return true;
        }
        return n4 == 2 && ozlu2.func_94574_k(n + 1, n2, n3, 5);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        boolean bl = this._a(ozlu2, n, n2, n3);
        List list = (List)_b.get(ozlu2);
        while (list != null && !list.isEmpty() && ozlu2.func_82737_E() - ((uzqb)list.get((int)0))._d > 60L) {
            list.remove(0);
        }
        if (this._a) {
            if (bl) {
                ozlu2.func_72832_d(n, n2, n3, twgu.field_72049_aP.field_71990_ca, ozlu2.func_72805_g(n, n2, n3), 3);
                if (this._a(ozlu2, n, n2, n3, true)) {
                    ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.fizz", 0.5f, 2.6f + (ozlu2.field_73012_v.nextFloat() - ozlu2.field_73012_v.nextFloat()) * 0.8f);
                    for (int i = 0; i < 5; ++i) {
                        double d = (double)n + random.nextDouble() * 0.6 + 0.2;
                        double d2 = (double)n2 + random.nextDouble() * 0.6 + 0.2;
                        double d3 = (double)n3 + random.nextDouble() * 0.6 + 0.2;
                        ozlu2.func_72869_a("smoke", d, d2, d3, 0.0, 0.0, 0.0);
                    }
                }
            }
        } else if (!bl && !this._a(ozlu2, n, n2, n3, false)) {
            ozlu2.func_72832_d(n, n2, n3, twgu.field_72035_aQ.field_71990_ca, ozlu2.func_72805_g(n, n2, n3), 3);
        }
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (this._a(ozlu2, n, n2, n3, n4)) {
            return;
        }
        boolean bl = this._a(ozlu2, n, n2, n3);
        if (this._a && bl || !this._a && !bl) {
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
        }
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            return this.func_71865_a(sdrg2, n, n2, n3, n4);
        }
        return 0;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_72035_aQ.field_71990_ca;
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!this._a) {
            return;
        }
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        double d = (double)((float)n + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d2 = (double)((float)n2 + 0.7f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d3 = (double)((float)n3 + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d4 = 0.22f;
        double d5 = 0.27f;
        if (n4 == 1) {
            ozlu2.func_72869_a("reddust", d - d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        } else if (n4 == 2) {
            ozlu2.func_72869_a("reddust", d + d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        } else if (n4 == 3) {
            ozlu2.func_72869_a("reddust", d, d2 + d4, d3 - d5, 0.0, 0.0, 0.0);
        } else if (n4 == 4) {
            ozlu2.func_72869_a("reddust", d, d2 + d4, d3 + d5, 0.0, 0.0, 0.0);
        } else {
            ozlu2.func_72869_a("reddust", d, d2, d3, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return twgu.field_72035_aQ.field_71990_ca;
    }

    @Override
    public boolean func_94334_h(int n) {
        return n == twgu.field_72049_aP.field_71990_ca || n == twgu.field_72035_aQ.field_71990_ca;
    }
}


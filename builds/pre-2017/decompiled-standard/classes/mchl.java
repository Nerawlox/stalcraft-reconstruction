/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.util.vjvn;
import net.minecraftforge.common.ChestGenHooks;

public class mchl
extends zztd {
    public boolean _a;
    public boolean _b;
    public boolean _c;
    public int _d;

    public mchl() {
    }

    @Override
    public void _a(qoac qoac2) {
        qoac2._a("hr", this._a);
        qoac2._a("sc", this._b);
        qoac2._a("hps", this._c);
        qoac2._a("Num", this._d);
    }

    @Override
    public void _b(qoac qoac2) {
        this._a = qoac2._o("hr");
        this._b = qoac2._o("sc");
        this._c = qoac2._o("hps");
        this._d = qoac2._f("Num");
    }

    public mchl(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
        this._a = random.nextInt(3) == 0;
        this._b = !this._a && random.nextInt(23) == 0;
        this._d = this._n != 2 && this._n != 0 ? uken2._b() / 5 : uken2._d() / 5;
    }

    public static uken _a(List list, Random random, int n, int n2, int n3, int n4) {
        int n5;
        uken uken2 = new uken(n, n2, n3, n, n2 + 2, n3);
        for (n5 = random.nextInt(3) + 2; n5 > 0; --n5) {
            int n6 = n5 * 5;
            switch (n4) {
                case 0: {
                    uken2._d = n + 2;
                    uken2._f = n3 + (n6 - 1);
                    break;
                }
                case 1: {
                    uken2._a = n - (n6 - 1);
                    uken2._f = n3 + 2;
                    break;
                }
                case 2: {
                    uken2._d = n + 2;
                    uken2._c = n3 - (n6 - 1);
                    break;
                }
                case 3: {
                    uken2._d = n + (n6 - 1);
                    uken2._f = n3 + 2;
                }
            }
            if (zztd._a(list, uken2) == null) break;
        }
        return n5 > 0 ? uken2 : null;
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        block24: {
            int n = this._e();
            int n2 = random.nextInt(4);
            switch (this._n) {
                case 0: {
                    if (n2 <= 1) {
                        mtob._b(zztd2, list, random, this._m._a, this._m._b - 1 + random.nextInt(3), this._m._f + 1, this._n, n);
                        break;
                    }
                    if (n2 == 2) {
                        mtob._b(zztd2, list, random, this._m._a - 1, this._m._b - 1 + random.nextInt(3), this._m._f - 3, 1, n);
                        break;
                    }
                    mtob._b(zztd2, list, random, this._m._d + 1, this._m._b - 1 + random.nextInt(3), this._m._f - 3, 3, n);
                    break;
                }
                case 1: {
                    if (n2 <= 1) {
                        mtob._b(zztd2, list, random, this._m._a - 1, this._m._b - 1 + random.nextInt(3), this._m._c, this._n, n);
                        break;
                    }
                    if (n2 == 2) {
                        mtob._b(zztd2, list, random, this._m._a, this._m._b - 1 + random.nextInt(3), this._m._c - 1, 2, n);
                        break;
                    }
                    mtob._b(zztd2, list, random, this._m._a, this._m._b - 1 + random.nextInt(3), this._m._f + 1, 0, n);
                    break;
                }
                case 2: {
                    if (n2 <= 1) {
                        mtob._b(zztd2, list, random, this._m._a, this._m._b - 1 + random.nextInt(3), this._m._c - 1, this._n, n);
                        break;
                    }
                    if (n2 == 2) {
                        mtob._b(zztd2, list, random, this._m._a - 1, this._m._b - 1 + random.nextInt(3), this._m._c, 1, n);
                        break;
                    }
                    mtob._b(zztd2, list, random, this._m._d + 1, this._m._b - 1 + random.nextInt(3), this._m._c, 3, n);
                    break;
                }
                case 3: {
                    if (n2 <= 1) {
                        mtob._b(zztd2, list, random, this._m._d + 1, this._m._b - 1 + random.nextInt(3), this._m._c, this._n, n);
                        break;
                    }
                    if (n2 == 2) {
                        mtob._b(zztd2, list, random, this._m._d - 3, this._m._b - 1 + random.nextInt(3), this._m._c - 1, 2, n);
                        break;
                    }
                    mtob._b(zztd2, list, random, this._m._d - 3, this._m._b - 1 + random.nextInt(3), this._m._f + 1, 0, n);
                }
            }
            if (n >= 8) break block24;
            if (this._n != 2 && this._n != 0) {
                int n3 = this._m._a + 3;
                while (n3 + 3 <= this._m._d) {
                    int n4 = random.nextInt(5);
                    if (n4 == 0) {
                        mtob._b(zztd2, list, random, n3, this._m._b, this._m._c - 1, 2, n + 1);
                    } else if (n4 == 1) {
                        mtob._b(zztd2, list, random, n3, this._m._b, this._m._f + 1, 0, n + 1);
                    }
                    n3 += 5;
                }
            } else {
                int n5 = this._m._c + 3;
                while (n5 + 3 <= this._m._f) {
                    int n6 = random.nextInt(5);
                    if (n6 == 0) {
                        mtob._b(zztd2, list, random, this._m._a - 1, this._m._b, n5, 1, n + 1);
                    } else if (n6 == 1) {
                        mtob._b(zztd2, list, random, this._m._d + 1, this._m._b, n5, 3, n + 1);
                    }
                    n5 += 5;
                }
            }
        }
    }

    @Override
    public boolean _a(ozlu ozlu2, uken uken2, Random random, int n, int n2, int n3, vjvn[] vjvnArray, int n4) {
        int n5;
        int n6;
        int n7 = this._c(n, n3);
        if (uken2._b(n7, n6 = this._b(n2), n5 = this._d(n, n3)) && ozlu2.func_72798_a(n7, n6, n5) == 0) {
            ozlu2.func_72832_d(n7, n6, n5, twgu.field_72056_aG.field_71990_ca, this._e(twgu.field_72056_aG.field_71990_ca, random.nextBoolean() ? 1 : 0), 2);
            EntityMinecartChest entityMinecartChest = new EntityMinecartChest(ozlu2, (float)n7 + 0.5f, (float)n6 + 0.5f, (float)n5 + 0.5f);
            vjvn._a(random, vjvnArray, entityMinecartChest, n4);
            ozlu2.func_72838_d(entityMinecartChest);
            return true;
        }
        return false;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        boolean bl = false;
        boolean bl2 = true;
        boolean bl3 = false;
        boolean bl4 = true;
        int n4 = this._d * 5 - 1;
        this._a(ozlu2, uken2, 0, 0, 0, 2, 1, n4, 0, 0, false);
        this._a(ozlu2, uken2, random, 0.8f, 0, 2, 0, 2, 2, n4, 0, 0, false);
        if (this._b) {
            this._a(ozlu2, uken2, random, 0.6f, 0, 0, 0, 2, 1, n4, twgu.field_71955_W.field_71990_ca, 0, false);
        }
        for (n3 = 0; n3 < this._d; ++n3) {
            n2 = 2 + n3 * 5;
            this._a(ozlu2, uken2, 0, 0, n2, 0, 1, n2, twgu.field_72031_aZ.field_71990_ca, 0, false);
            this._a(ozlu2, uken2, 2, 0, n2, 2, 1, n2, twgu.field_72031_aZ.field_71990_ca, 0, false);
            if (random.nextInt(4) == 0) {
                this._a(ozlu2, uken2, 0, 2, n2, 0, 2, n2, twgu.field_71988_x.field_71990_ca, 0, false);
                this._a(ozlu2, uken2, 2, 2, n2, 2, 2, n2, twgu.field_71988_x.field_71990_ca, 0, false);
            } else {
                this._a(ozlu2, uken2, 0, 2, n2, 2, 2, n2, twgu.field_71988_x.field_71990_ca, 0, false);
            }
            this._a(ozlu2, uken2, random, 0.1f, 0, 2, n2 - 1, twgu.field_71955_W.field_71990_ca, 0);
            this._a(ozlu2, uken2, random, 0.1f, 2, 2, n2 - 1, twgu.field_71955_W.field_71990_ca, 0);
            this._a(ozlu2, uken2, random, 0.1f, 0, 2, n2 + 1, twgu.field_71955_W.field_71990_ca, 0);
            this._a(ozlu2, uken2, random, 0.1f, 2, 2, n2 + 1, twgu.field_71955_W.field_71990_ca, 0);
            this._a(ozlu2, uken2, random, 0.05f, 0, 2, n2 - 2, twgu.field_71955_W.field_71990_ca, 0);
            this._a(ozlu2, uken2, random, 0.05f, 2, 2, n2 - 2, twgu.field_71955_W.field_71990_ca, 0);
            this._a(ozlu2, uken2, random, 0.05f, 0, 2, n2 + 2, twgu.field_71955_W.field_71990_ca, 0);
            this._a(ozlu2, uken2, random, 0.05f, 2, 2, n2 + 2, twgu.field_71955_W.field_71990_ca, 0);
            this._a(ozlu2, uken2, random, 0.05f, 1, 2, n2 - 1, twgu.field_72069_aq.field_71990_ca, 0);
            this._a(ozlu2, uken2, random, 0.05f, 1, 2, n2 + 1, twgu.field_72069_aq.field_71990_ca, 0);
            ChestGenHooks chestGenHooks = ChestGenHooks.getInfo("mineshaftCorridor");
            if (random.nextInt(100) == 0) {
                this._a(ozlu2, uken2, random, 2, 0, n2 - 1, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
            }
            if (random.nextInt(100) == 0) {
                this._a(ozlu2, uken2, random, 0, 0, n2 + 1, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
            }
            if (!this._b || this._c) continue;
            n = this._b(0);
            int n5 = n2 - 1 + random.nextInt(3);
            int n6 = this._c(1, n5);
            if (!uken2._b(n6, n, n5 = this._d(1, n5))) continue;
            this._c = true;
            ozlu2.func_72832_d(n6, n, n5, twgu.field_72065_as.field_71990_ca, 0, 2);
            xtcq xtcq2 = (xtcq)ozlu2.func_72796_p(n6, n, n5);
            if (xtcq2 == null) continue;
            xtcq2._a()._a("CaveSpider");
        }
        for (n3 = 0; n3 <= 2; ++n3) {
            for (n2 = 0; n2 <= n4; ++n2) {
                n = this._a(ozlu2, n3, -1, n2, uken2);
                if (n != 0) continue;
                this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, n3, -1, n2, uken2);
            }
        }
        if (this._a) {
            for (n3 = 0; n3 <= n4; ++n3) {
                n2 = this._a(ozlu2, 1, -1, n3, uken2);
                if (n2 <= 0 || !twgu.field_71970_n[n2]) continue;
                this._a(ozlu2, uken2, random, 0.7f, 1, 0, n3, twgu.field_72056_aG.field_71990_ca, this._e(twgu.field_72056_aG.field_71990_ca, 0));
            }
        }
        return true;
    }
}


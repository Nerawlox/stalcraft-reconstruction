/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.vjvn;
import net.minecraftforge.common.ChestGenHooks;

public class cwpq
extends cfof {
    public static final vjvn[] _b = new vjvn[]{new vjvn(tgdv.field_77760_aL.field_77779_bT, 0, 1, 3, 20), new vjvn(tgdv.field_77759_aK.field_77779_bT, 0, 2, 7, 20), new vjvn(tgdv.field_82801_bO.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_77750_aQ.field_77779_bT, 0, 1, 1, 1)};
    public boolean _c;

    public cwpq() {
    }

    public cwpq(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
        this._c = uken2._c() > 6;
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Tall", this._c);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._c = qoac2._o("Tall");
    }

    public static cwpq _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -4, -1, 0, 14, 11, 15, n4);
        if (!(cwpq._a(uken2) && zztd._a(list2, uken2) == null || cwpq._a(uken2 = uken._a(n, n2, n3, -4, -1, 0, 14, 6, 15, n4)) && zztd._a(list2, uken2) == null)) {
            return null;
        }
        return new cwpq(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        int n2 = 11;
        if (!this._c) {
            n2 = 6;
        }
        this._a(ozlu2, uken2, 0, 0, 0, 13, n2 - 1, 14, true, random, iyda._d());
        this._a(ozlu2, random, uken2, this._a, 4, 1, 0);
        this._a(ozlu2, uken2, random, 0.07f, 2, 1, 1, 11, 4, 13, twgu.field_71955_W.field_71990_ca, twgu.field_71955_W.field_71990_ca, false);
        boolean bl = true;
        boolean bl2 = true;
        for (n = 1; n <= 13; ++n) {
            if ((n - 1) % 4 == 0) {
                this._a(ozlu2, uken2, 1, 1, n, 1, 4, n, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
                this._a(ozlu2, uken2, 12, 1, n, 12, 4, n, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
                this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 2, 3, n, uken2);
                this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 11, 3, n, uken2);
                if (!this._c) continue;
                this._a(ozlu2, uken2, 1, 6, n, 1, 9, n, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
                this._a(ozlu2, uken2, 12, 6, n, 12, 9, n, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
                continue;
            }
            this._a(ozlu2, uken2, 1, 1, n, 1, 4, n, twgu.field_72093_an.field_71990_ca, twgu.field_72093_an.field_71990_ca, false);
            this._a(ozlu2, uken2, 12, 1, n, 12, 4, n, twgu.field_72093_an.field_71990_ca, twgu.field_72093_an.field_71990_ca, false);
            if (!this._c) continue;
            this._a(ozlu2, uken2, 1, 6, n, 1, 9, n, twgu.field_72093_an.field_71990_ca, twgu.field_72093_an.field_71990_ca, false);
            this._a(ozlu2, uken2, 12, 6, n, 12, 9, n, twgu.field_72093_an.field_71990_ca, twgu.field_72093_an.field_71990_ca, false);
        }
        for (n = 3; n < 12; n += 2) {
            this._a(ozlu2, uken2, 3, 1, n, 4, 3, n, twgu.field_72093_an.field_71990_ca, twgu.field_72093_an.field_71990_ca, false);
            this._a(ozlu2, uken2, 6, 1, n, 7, 3, n, twgu.field_72093_an.field_71990_ca, twgu.field_72093_an.field_71990_ca, false);
            this._a(ozlu2, uken2, 9, 1, n, 10, 3, n, twgu.field_72093_an.field_71990_ca, twgu.field_72093_an.field_71990_ca, false);
        }
        if (this._c) {
            this._a(ozlu2, uken2, 1, 5, 1, 3, 5, 13, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
            this._a(ozlu2, uken2, 10, 5, 1, 12, 5, 13, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
            this._a(ozlu2, uken2, 4, 5, 1, 9, 5, 2, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
            this._a(ozlu2, uken2, 4, 5, 12, 9, 5, 13, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
            this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 9, 5, 11, uken2);
            this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 8, 5, 11, uken2);
            this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 9, 5, 10, uken2);
            this._a(ozlu2, uken2, 3, 6, 2, 3, 6, 12, twgu.field_72031_aZ.field_71990_ca, twgu.field_72031_aZ.field_71990_ca, false);
            this._a(ozlu2, uken2, 10, 6, 2, 10, 6, 10, twgu.field_72031_aZ.field_71990_ca, twgu.field_72031_aZ.field_71990_ca, false);
            this._a(ozlu2, uken2, 4, 6, 2, 9, 6, 2, twgu.field_72031_aZ.field_71990_ca, twgu.field_72031_aZ.field_71990_ca, false);
            this._a(ozlu2, uken2, 4, 6, 12, 8, 6, 12, twgu.field_72031_aZ.field_71990_ca, twgu.field_72031_aZ.field_71990_ca, false);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 9, 6, 11, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 8, 6, 11, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 9, 6, 10, uken2);
            n = this._e(twgu.field_72055_aF.field_71990_ca, 3);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 10, 1, 13, uken2);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 10, 2, 13, uken2);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 10, 3, 13, uken2);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 10, 4, 13, uken2);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 10, 5, 13, uken2);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 10, 6, 13, uken2);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 10, 7, 13, uken2);
            int n3 = 7;
            int n4 = 7;
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3 - 1, 9, n4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3, 9, n4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3 - 1, 8, n4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3, 8, n4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3 - 1, 7, n4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3, 7, n4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3 - 2, 7, n4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3 + 1, 7, n4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3 - 1, 7, n4 - 1, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3 - 1, 7, n4 + 1, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3, 7, n4 - 1, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, n3, 7, n4 + 1, uken2);
            this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, n3 - 2, 8, n4, uken2);
            this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, n3 + 1, 8, n4, uken2);
            this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, n3 - 1, 8, n4 - 1, uken2);
            this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, n3 - 1, 8, n4 + 1, uken2);
            this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, n3, 8, n4 - 1, uken2);
            this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, n3, 8, n4 + 1, uken2);
        }
        ChestGenHooks chestGenHooks = ChestGenHooks.getInfo("strongholdLibrary");
        this._a(ozlu2, uken2, random, 3, 3, 5, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
        if (this._c) {
            this._a(ozlu2, 0, 0, 12, 9, 1, uken2);
            this._a(ozlu2, uken2, random, 12, 8, 1, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
        }
        return true;
    }
}


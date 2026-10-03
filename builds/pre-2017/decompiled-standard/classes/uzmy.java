/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.dwan;

public class uzmy
extends ndvn {
    public static final String[] _b = new String[]{"stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick", "netherBrick", "quartz"};
    public dwan _c;

    public uzmy(int n, boolean bl) {
        super(n, bl, tflj._e);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        int n3 = n2 & 7;
        if (this._a && (n2 & 8) != 0) {
            n = 1;
        }
        if (n3 == 0) {
            if (n == 1 || n == 0) {
                return this.field_94336_cN;
            }
            return this._c;
        }
        if (n3 == 1) {
            return twgu.field_71957_Q.func_71851_a(n);
        }
        if (n3 == 2) {
            return twgu.field_71988_x.func_71851_a(n);
        }
        if (n3 == 3) {
            return twgu.field_71978_w.func_71851_a(n);
        }
        if (n3 == 4) {
            return twgu.field_72081_al.func_71851_a(n);
        }
        if (n3 == 5) {
            return twgu.field_72007_bm.func_71858_a(n, 0);
        }
        if (n3 == 6) {
            return twgu.field_72033_bA.func_71851_a(1);
        }
        if (n3 == 7) {
            return twgu.field_94339_ct.func_71851_a(n);
        }
        return this.field_94336_cN;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("stone_slab_top");
        this._c = nege2._b("stone_slab_side");
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_72079_ak.field_71990_ca;
    }

    @Override
    public cvzo func_71880_c_(int n) {
        return new cvzo(twgu.field_72079_ak.field_71990_ca, 2, n & 7);
    }

    @Override
    public String _b(int n) {
        if (n < 0 || n >= _b.length) {
            n = 0;
        }
        return super.func_71917_a() + "." + _b[n];
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list2) {
        if (n == twgu.field_72085_aj.field_71990_ca) {
            return;
        }
        for (int i = 0; i <= 7; ++i) {
            if (i == 2) continue;
            list2.add(new cvzo(n, 1, i));
        }
    }
}


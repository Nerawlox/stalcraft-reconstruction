/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class ifiu
extends twgu {
    public static final String[] _a = new String[]{"normal", "mossy"};

    public ifiu(int n, twgu twgu2) {
        super(n, twgu2.field_72018_cp);
        this.func_71848_c(twgu2.field_71989_cb);
        this.func_71894_b(twgu2.field_72029_cc / 3.0f);
        this.func_71884_a(twgu2.field_72020_cn);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n2 == 1) {
            return twgu.field_72087_ao.func_71851_a(n);
        }
        return twgu.field_71978_w.func_71851_a(n);
    }

    @Override
    public int func_71857_b() {
        return 32;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return false;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        boolean bl = this._a(sdrg2, n, n2, n3 - 1);
        boolean bl2 = this._a(sdrg2, n, n2, n3 + 1);
        boolean bl3 = this._a(sdrg2, n - 1, n2, n3);
        boolean bl4 = this._a(sdrg2, n + 1, n2, n3);
        float f = 0.25f;
        float f2 = 0.75f;
        float f3 = 0.25f;
        float f4 = 0.75f;
        float f5 = 1.0f;
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        if (bl3) {
            f = 0.0f;
        }
        if (bl4) {
            f2 = 1.0f;
        }
        if (bl && bl2 && !bl3 && !bl4) {
            f5 = 0.8125f;
            f = 0.3125f;
            f2 = 0.6875f;
        } else if (!bl && !bl2 && bl3 && bl4) {
            f5 = 0.8125f;
            f3 = 0.3125f;
            f4 = 0.6875f;
        }
        this.func_71905_a(f, 0.0f, f3, f2, f5, f4);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        this.field_72022_cl = 1.5;
        return super.func_71872_e(ozlu2, n, n2, n3);
    }

    public boolean _a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72798_a(n, n2, n3);
        if (n4 == this.field_71990_ca || n4 == twgu.field_71993_bv.field_71990_ca) {
            return true;
        }
        twgu twgu2 = twgu.field_71973_m[n4];
        if (twgu2 != null && twgu2.field_72018_cp._k() && twgu2.func_71886_c()) {
            return twgu2.field_72018_cp != tflj._B;
        }
        return false;
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list2) {
        list2.add(new cvzo(n, 1, 0));
        list2.add(new cvzo(n, 1, 1));
    }

    @Override
    public int func_71899_b(int n) {
        return n;
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            return super.func_71877_c(sdrg2, n, n2, n3, n4);
        }
        return true;
    }

    @Override
    public void func_94332_a(nege nege2) {
    }
}


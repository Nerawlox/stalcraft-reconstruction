/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class zxwy
extends twgu {
    public zxwy(int n) {
        super(n, tflj._r);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
        this.func_71907_b(true);
        this.func_71849_a(tgbl.field_78031_c);
        this._a(0);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        return twgu.field_72101_ab.func_71858_a(n, n2);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        boolean bl = false;
        float f = 0.0625f;
        return eidj._a()._a((double)n + this.field_72026_ch, (double)n2 + this.field_72023_ci, (double)n3 + this.field_72024_cj, (double)n + this.field_72021_ck, (float)n2 + (float)bl * f, (double)n3 + this.field_72019_cm);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public void func_71919_f() {
        this._a(0);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this._a(sdrg2.func_72805_g(n, n2, n3));
    }

    public void _a(int n) {
        int n2 = 0;
        float f = (float)(1 * (1 + n2)) / 16.0f;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return super.func_71930_b(ozlu2, n, n2, n3) && this.func_71854_d(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._a(ozlu2, n, n2, n3);
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        if (!this.func_71854_d(ozlu2, n, n2, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94571_i(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        return !ozlu2.func_72799_c(n, n2 - 1, n3);
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return true;
        }
        return super.func_71877_c(sdrg2, n, n2, n3, n4);
    }

    @Override
    public int func_71899_b(int n) {
        return n;
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list2) {
        for (int i = 0; i < 16; ++i) {
            list2.add(new cvzo(n, 1, i));
        }
    }

    @Override
    public void func_94332_a(nege nege2) {
    }
}


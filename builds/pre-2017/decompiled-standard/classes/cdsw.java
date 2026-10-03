/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;

public class cdsw
extends iwgt {
    public dwan[] _a = new dwan[2];

    public cdsw(int n) {
        super(n, tflj._d);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
        this.func_71849_a(tgbl.field_78028_d);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return sdrg2.func_72805_g(n, n2, n3);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.field_73011_w._g) {
            return;
        }
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        int n5 = ozlu2.func_72972_b(rrqi._a, n, n2, n3) - ozlu2.field_73008_k;
        float f = ozlu2.func_72929_e(1.0f);
        f = f < (float)Math.PI ? (f += (0.0f - f) * 0.2f) : (f += ((float)Math.PI * 2 - f) * 0.2f);
        n5 = Math.round((float)n5 * sajh._b(f));
        if (n5 < 0) {
            n5 = 0;
        }
        if (n5 > 15) {
            n5 = 15;
        }
        if (n4 != n5) {
            ozlu2.func_72921_c(n, n2, n3, n5, 3);
        }
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new aqba();
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1) {
            return this._a[0];
        }
        return this._a[1];
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._a[0] = nege2._b(this.func_111023_E() + "_top");
        this._a[1] = nege2._b(this.func_111023_E() + "_side");
    }
}


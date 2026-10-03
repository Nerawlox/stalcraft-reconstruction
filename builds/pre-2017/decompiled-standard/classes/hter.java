/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;

public abstract class hter
extends twgu {
    public String _a;

    public hter(int n, String string, tflj tflj2) {
        super(n, tflj2);
        this._a = string;
        this.func_71849_a(tgbl.field_78028_d);
        this.func_71907_b(true);
        this._a(this._c(15));
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this._a(sdrg2.func_72805_g(n, n2, n3));
    }

    public void _a(int n) {
        boolean bl = this._b(n) > 0;
        float f = 0.0625f;
        if (bl) {
            this.func_71905_a(f, 0.0f, f, 1.0f - f, 0.03125f, 1.0f - f);
        } else {
            this.func_71905_a(f, 0.0f, f, 1.0f - f, 0.0625f, 1.0f - f);
        }
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 20;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
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
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return true;
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72797_t(n, n2 - 1, n3) || htgl._a(ozlu2.func_72798_a(n, n2 - 1, n3));
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (!ozlu2.func_72797_t(n, n2 - 1, n3) && !htgl._a(ozlu2.func_72798_a(n, n2 - 1, n3))) {
            bl = true;
        }
        if (bl) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.field_72995_K) {
            return;
        }
        int n4 = this._b(ozlu2.func_72805_g(n, n2, n3));
        if (n4 > 0) {
            this._a(ozlu2, n, n2, n3, n4);
        }
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if (ozlu2.field_72995_K) {
            return;
        }
        int n4 = this._b(ozlu2.func_72805_g(n, n2, n3));
        if (n4 == 0) {
            this._a(ozlu2, n, n2, n3, n4);
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = this._b(ozlu2, n, n2, n3);
        boolean bl2 = n4 > 0;
        boolean bl3 = bl = n5 > 0;
        if (n4 != n5) {
            ozlu2.func_72921_c(n, n2, n3, this._c(n5), 2);
            this._a(ozlu2, n, n2, n3);
            ozlu2.func_72909_d(n, n2, n3, n, n2, n3);
        }
        if (!bl && bl2) {
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.3f, 0.5f);
        } else if (bl && !bl2) {
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (bl) {
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
        }
    }

    public eidj _a(int n, int n2, int n3) {
        float f = 0.125f;
        return eidj._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, (double)n2 + 0.25, (float)(n3 + 1) - f);
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        if (this._b(n5) > 0) {
            this._a(ozlu2, n, n2, n3);
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return this._b(sdrg2.func_72805_g(n, n2, n3));
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return this._b(sdrg2.func_72805_g(n, n2, n3));
        }
        return 0;
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public void func_71919_f() {
        float f = 0.5f;
        float f2 = 0.125f;
        float f3 = 0.5f;
        this.func_71905_a(0.5f - f, 0.5f - f2, 0.5f - f3, 0.5f + f, 0.5f + f2, 0.5f + f3);
    }

    @Override
    public int func_71915_e() {
        return 1;
    }

    public abstract int _b(ozlu var1, int var2, int var3, int var4);

    public abstract int _b(int var1);

    public abstract int _c(int var1);

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this._a);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class htic
extends iwgt {
    public Class _a;
    public boolean _b;

    public htic(int n, Class clazz, boolean bl) {
        super(n, tflj._d);
        this._b = bl;
        this._a = clazz;
        float f = 0.25f;
        float f2 = 1.0f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        return twgu.field_71988_x.func_71851_a(n);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71911_a_(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        if (this._b) {
            return;
        }
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        float f = 0.28125f;
        float f2 = 0.78125f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.125f;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        if (n4 == 2) {
            this.func_71905_a(f3, f, 1.0f - f5, f4, f2, 1.0f);
        }
        if (n4 == 3) {
            this.func_71905_a(f3, f, 0.0f, f4, f2, f5);
        }
        if (n4 == 4) {
            this.func_71905_a(1.0f - f5, f, f3, 1.0f, f2, f4);
        }
        if (n4 == 5) {
            this.func_71905_a(0.0f, f, f3, f5, f2, f4);
        }
    }

    @Override
    public int func_71857_b() {
        return -1;
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
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        try {
            return (hurg)this._a.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77792_au.field_77779_bT;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (this._b) {
            if (!ozlu2.func_72803_f(n, n2 - 1, n3)._a()) {
                bl = true;
            }
        } else {
            int n5 = ozlu2.func_72805_g(n, n2, n3);
            bl = true;
            if (n5 == 2 && ozlu2.func_72803_f(n, n2, n3 + 1)._a()) {
                bl = false;
            }
            if (n5 == 3 && ozlu2.func_72803_f(n, n2, n3 - 1)._a()) {
                bl = false;
            }
            if (n5 == 4 && ozlu2.func_72803_f(n + 1, n2, n3)._a()) {
                bl = false;
            }
            if (n5 == 5 && ozlu2.func_72803_f(n - 1, n2, n3)._a()) {
                bl = false;
            }
        }
        if (bl) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94571_i(n, n2, n3);
        }
        super.func_71863_a(ozlu2, n, n2, n3, n4);
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77792_au.field_77779_bT;
    }

    @Override
    public void func_94332_a(nege nege2) {
    }
}


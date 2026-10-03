/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;
import net.minecraft.util.owak;

public abstract class ndvn
extends twgu {
    public final boolean _a;

    public ndvn(int n, boolean bl, tflj tflj2) {
        super(n, tflj2);
        this._a = bl;
        if (bl) {
            ndvn.field_71970_n[n] = true;
        } else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
        this.func_71868_h(255);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        if (this._a) {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            boolean bl;
            boolean bl2 = bl = (sdrg2.func_72805_g(n, n2, n3) & 8) != 0;
            if (bl) {
                this.func_71905_a(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
            } else {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
            }
        }
    }

    @Override
    public void func_71919_f() {
        if (this._a) {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list, Entity entity) {
        this.func_71902_a(ozlu2, n, n2, n3);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
    }

    @Override
    public boolean func_71926_d() {
        return this._a;
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (this._a) {
            return n5;
        }
        if (n4 == 0 || n4 != 1 && (double)f2 > 0.5) {
            return n5 | 8;
        }
        return n5;
    }

    @Override
    public int func_71925_a(Random random) {
        if (this._a) {
            return 2;
        }
        return 1;
    }

    @Override
    public int func_71899_b(int n) {
        return n & 7;
    }

    @Override
    public boolean func_71886_c() {
        return this._a;
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        boolean bl;
        if (this._a) {
            return super.func_71877_c(sdrg2, n, n2, n3, n4);
        }
        if (n4 != 1 && n4 != 0 && !super.func_71877_c(sdrg2, n, n2, n3, n4)) {
            return false;
        }
        int n5 = n;
        int n6 = n2;
        int n7 = n3;
        boolean bl2 = bl = (sdrg2.func_72805_g(n5 += owak._b[owak._a[n4]], n6 += owak._c[owak._a[n4]], n7 += owak._d[owak._a[n4]]) & 8) != 0;
        if (bl) {
            if (n4 == 0) {
                return true;
            }
            if (n4 == 1 && super.func_71877_c(sdrg2, n, n2, n3, n4)) {
                return true;
            }
            return !ndvn._a(sdrg2.func_72798_a(n, n2, n3)) || (sdrg2.func_72805_g(n, n2, n3) & 8) == 0;
        }
        if (n4 == 1) {
            return true;
        }
        if (n4 == 0 && super.func_71877_c(sdrg2, n, n2, n3, n4)) {
            return true;
        }
        return !ndvn._a(sdrg2.func_72798_a(n, n2, n3)) || (sdrg2.func_72805_g(n, n2, n3) & 8) != 0;
    }

    public static boolean _a(int n) {
        return n == twgu.field_72079_ak.field_71990_ca || n == twgu.field_72092_bO.field_71990_ca;
    }

    public abstract String _b(int var1);

    @Override
    public int func_71873_h(ozlu ozlu2, int n, int n2, int n3) {
        return super.func_71873_h(ozlu2, n, n2, n3) & 7;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        if (ndvn._a(this.field_71990_ca)) {
            return this.field_71990_ca;
        }
        if (this.field_71990_ca == twgu.field_72085_aj.field_71990_ca) {
            return twgu.field_72079_ak.field_71990_ca;
        }
        if (this.field_71990_ca == twgu.field_72090_bN.field_71990_ca) {
            return twgu.field_72092_bO.field_71990_ca;
        }
        return twgu.field_72079_ak.field_71990_ca;
    }
}


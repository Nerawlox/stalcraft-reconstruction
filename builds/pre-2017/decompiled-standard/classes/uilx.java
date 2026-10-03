/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.item.EntityFallingSand;

public class uilx
extends twgu {
    public static boolean _e;

    public uilx(int n) {
        super(n, tflj._p);
        this.func_71849_a(tgbl.field_78030_b);
    }

    public uilx(int n, tflj tflj2) {
        super(n, tflj2);
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!ozlu2.field_72995_K) {
            this._a(ozlu2, n, n2, n3);
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        if (uilx._b(ozlu2, n, n2 - 1, n3) && n2 >= 0) {
            int n4 = 32;
            if (!_e && ozlu2.func_72904_c(n - n4, n2 - n4, n3 - n4, n + n4, n2 + n4, n3 + n4)) {
                if (!ozlu2.field_72995_K) {
                    EntityFallingSand entityFallingSand = new EntityFallingSand(ozlu2, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this.field_71990_ca, ozlu2.func_72805_g(n, n2, n3));
                    this._a(entityFallingSand);
                    ozlu2.func_72838_d(entityFallingSand);
                }
            } else {
                ozlu2.func_94571_i(n, n2, n3);
                while (uilx._b(ozlu2, n, n2 - 1, n3) && n2 > 0) {
                    --n2;
                }
                if (n2 > 0) {
                    ozlu2.func_94575_c(n, n2, n3, this.field_71990_ca);
                }
            }
        }
    }

    public void _a(EntityFallingSand entityFallingSand) {
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 2;
    }

    public static boolean _b(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        if (ozlu2.func_72799_c(n, n2, n3)) {
            return true;
        }
        if (n4 == twgu.field_72067_ar.field_71990_ca) {
            return true;
        }
        tflj tflj2 = twgu.field_71973_m[n4].field_72018_cp;
        return tflj2 == tflj._h ? true : tflj2 == tflj._i;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
    }
}


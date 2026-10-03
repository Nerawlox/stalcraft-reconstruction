/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class vlkn
extends scgt {
    public dwan[] _a;

    public vlkn(int n) {
        super(n, true);
        this.func_71907_b(true);
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 20;
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if (ozlu2.field_72995_K) {
            return;
        }
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if ((n4 & 8) != 0) {
            return;
        }
        this._a(ozlu2, n, n2, n3, n4);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.field_72995_K) {
            return;
        }
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if ((n4 & 8) == 0) {
            return;
        }
        this._a(ozlu2, n, n2, n3, n4);
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return (sdrg2.func_72805_g(n, n2, n3) & 8) != 0 ? 15 : 0;
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if ((sdrg2.func_72805_g(n, n2, n3) & 8) == 0) {
            return 0;
        }
        return n4 == 1 ? 15 : 0;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl = (n4 & 8) != 0;
        boolean bl2 = false;
        float f = 0.125f;
        List list2 = ozlu2.func_72872_a(EntityMinecart.class, eidj._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, (float)(n2 + 1) - f, (float)(n3 + 1) - f));
        if (!list2.isEmpty()) {
            bl2 = true;
        }
        if (bl2 && !bl) {
            ozlu2.func_72921_c(n, n2, n3, n4 | 8, 3);
            ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            ozlu2.func_72909_d(n, n2, n3, n, n2, n3);
        }
        if (!bl2 && bl) {
            ozlu2.func_72921_c(n, n2, n3, n4 & 7, 3);
            ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            ozlu2.func_72909_d(n, n2, n3, n, n2, n3);
        }
        if (bl2) {
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
        }
        ozlu2.func_96440_m(n, n2, n3, this.field_71990_ca);
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        super.func_71861_g(ozlu2, n, n2, n3);
        this._a(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3));
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if ((ozlu2.func_72805_g(n, n2, n3) & 8) > 0) {
            float f = 0.125f;
            List list2 = ozlu2.func_82733_a(EntityMinecart.class, eidj._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, (float)(n2 + 1) - f, (float)(n3 + 1) - f), zhos._b);
            if (list2.size() > 0) {
                return jjgc.func_94526_b((mssh)list2.get(0));
            }
        }
        return 0;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._a = new dwan[2];
        this._a[0] = nege2._b(this.func_111023_E());
        this._a[1] = nege2._b(this.func_111023_E() + "_powered");
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if ((n2 & 8) != 0) {
            return this._a[1];
        }
        return this._a[0];
    }
}


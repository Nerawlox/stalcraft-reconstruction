/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.ugqx;

public class uikz
extends twgu {
    public uikz(int n) {
        super(n, tflj._q);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.15625f, 1.0f);
        this.func_71907_b(true);
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 10;
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
    public int func_71856_s_() {
        return 1;
    }

    @Override
    public int func_71857_b() {
        return 30;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77683_K.field_77779_bT;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77683_K.field_77779_bT;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        boolean bl2 = (n5 & 2) == 2;
        boolean bl3 = bl = !ozlu2.func_72797_t(n, n2 - 1, n3);
        if (bl2 != bl) {
            this.func_71897_c(ozlu2, n, n2, n3, n5, 0);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        boolean bl;
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        boolean bl2 = (n4 & 4) == 4;
        boolean bl3 = bl = (n4 & 2) == 2;
        if (!bl) {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.09375f, 1.0f);
        } else if (!bl2) {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        } else {
            this.func_71905_a(0.0f, 0.0625f, 0.0f, 1.0f, 0.15625f, 1.0f);
        }
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72797_t(n, n2 - 1, n3) ? 0 : 2;
        ozlu2.func_72921_c(n, n2, n3, n4, 3);
        this._a(ozlu2, n, n2, n3, n4);
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        this._a(ozlu2, n, n2, n3, n5 | 1);
    }

    @Override
    public void func_71846_a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        if (ozlu2.field_72995_K) {
            return;
        }
        if (entityPlayer.func_71045_bC() != null && entityPlayer.func_71045_bC()._d == tgdv.field_77745_be.field_77779_bT) {
            ozlu2.func_72921_c(n, n2, n3, n4 | 8, 4);
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        block0: for (int i = 0; i < 2; ++i) {
            for (int j = 1; j < 42; ++j) {
                int n5 = n + ugqx._a[i] * j;
                int n6 = n3 + ugqx._b[i] * j;
                int n7 = ozlu2.func_72798_a(n5, n2, n6);
                if (n7 == twgu.field_72064_bT.field_71990_ca) {
                    int n8 = ozlu2.func_72805_g(n5, n2, n6) & 3;
                    if (n8 != ugqx._f[i]) continue block0;
                    twgu.field_72064_bT._a(ozlu2, n5, n2, n6, n7, ozlu2.func_72805_g(n5, n2, n6), true, j, n4);
                    continue block0;
                }
                if (n7 != twgu.field_72062_bU.field_71990_ca) continue block0;
            }
        }
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if (ozlu2.field_72995_K) {
            return;
        }
        if ((ozlu2.func_72805_g(n, n2, n3) & 1) == 1) {
            return;
        }
        this._a(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.field_72995_K) {
            return;
        }
        if ((ozlu2.func_72805_g(n, n2, n3) & 1) != 1) {
            return;
        }
        this._a(ozlu2, n, n2, n3);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        boolean bl = (n4 & 1) == 1;
        boolean bl2 = false;
        List list = ozlu2.func_72839_b(null, eidj._a()._a((double)n + this.field_72026_ch, (double)n2 + this.field_72023_ci, (double)n3 + this.field_72024_cj, (double)n + this.field_72021_ck, (double)n2 + this.field_72022_cl, (double)n3 + this.field_72019_cm));
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                if (entity.func_82144_au()) continue;
                bl2 = true;
                break;
            }
        }
        if (bl2 && !bl) {
            n4 |= 1;
        }
        if (!bl2 && bl) {
            n4 &= 0xFFFFFFFE;
        }
        if (bl2 != bl) {
            ozlu2.func_72921_c(n, n2, n3, n4, 3);
            this._a(ozlu2, n, n2, n3, n4);
        }
        if (bl2) {
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
        }
    }

    public static boolean _a(sdrg sdrg2, int n, int n2, int n3, int n4, int n5) {
        boolean bl;
        int n6 = n + ugqx._a[n5];
        int n7 = n2;
        int n8 = n3 + ugqx._b[n5];
        int n9 = sdrg2.func_72798_a(n6, n7, n8);
        boolean bl2 = bl = (n4 & 2) == 2;
        if (n9 == twgu.field_72064_bT.field_71990_ca) {
            int n10 = sdrg2.func_72805_g(n6, n7, n8);
            int n11 = n10 & 3;
            return n11 == ugqx._f[n5];
        }
        if (n9 == twgu.field_72062_bU.field_71990_ca) {
            int n12 = sdrg2.func_72805_g(n6, n7, n8);
            boolean bl3 = (n12 & 2) == 2;
            return bl == bl3;
        }
        return false;
    }
}


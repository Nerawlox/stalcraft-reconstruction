/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.vjvn;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class grvu
extends zzpm {
    public static final vjvn[] _a = new vjvn[]{new vjvn(tgdv.field_77765_aA.field_77779_bT, 0, 1, 1, 10), new vjvn(tgdv.field_77703_o.field_77779_bT, 0, 1, 4, 10), new vjvn(tgdv.field_77684_U.field_77779_bT, 0, 1, 1, 10), new vjvn(tgdv.field_77685_T.field_77779_bT, 0, 1, 4, 10), new vjvn(tgdv.field_77677_M.field_77779_bT, 0, 1, 4, 10), new vjvn(tgdv.field_77683_K.field_77779_bT, 0, 1, 4, 10), new vjvn(tgdv.field_77788_aw.field_77779_bT, 0, 1, 1, 10), new vjvn(tgdv.field_77778_at.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_77767_aC.field_77779_bT, 0, 1, 4, 10), new vjvn(tgdv.field_77819_bI.field_77779_bT, 0, 1, 1, 10), new vjvn(tgdv.field_77797_bJ.field_77779_bT, 0, 1, 1, 10), new vjvn(tgdv.field_111212_ci.field_77779_bT, 0, 1, 1, 10), new vjvn(tgdv.field_111216_cf.field_77779_bT, 0, 1, 1, 2), new vjvn(tgdv.field_111215_ce.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_111213_cg.field_77779_bT, 0, 1, 1, 1)};

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7 = 3;
        int n8 = random.nextInt(2) + 2;
        int n9 = random.nextInt(2) + 2;
        int n10 = 0;
        for (n6 = n - n8 - 1; n6 <= n + n8 + 1; ++n6) {
            for (n5 = n2 - 1; n5 <= n2 + n7 + 1; ++n5) {
                for (n4 = n3 - n9 - 1; n4 <= n3 + n9 + 1; ++n4) {
                    tflj tflj2 = ozlu2.func_72803_f(n6, n5, n4);
                    if (n5 == n2 - 1 && !tflj2._a()) {
                        return false;
                    }
                    if (n5 == n2 + n7 + 1 && !tflj2._a()) {
                        return false;
                    }
                    if (n6 != n - n8 - 1 && n6 != n + n8 + 1 && n4 != n3 - n9 - 1 && n4 != n3 + n9 + 1 || n5 != n2 || !ozlu2.func_72799_c(n6, n5, n4) || !ozlu2.func_72799_c(n6, n5 + 1, n4)) continue;
                    ++n10;
                }
            }
        }
        if (n10 >= 1 && n10 <= 5) {
            for (n6 = n - n8 - 1; n6 <= n + n8 + 1; ++n6) {
                for (n5 = n2 + n7; n5 >= n2 - 1; --n5) {
                    for (n4 = n3 - n9 - 1; n4 <= n3 + n9 + 1; ++n4) {
                        if (n6 != n - n8 - 1 && n5 != n2 - 1 && n4 != n3 - n9 - 1 && n6 != n + n8 + 1 && n5 != n2 + n7 + 1 && n4 != n3 + n9 + 1) {
                            ozlu2.func_94571_i(n6, n5, n4);
                            continue;
                        }
                        if (n5 >= 0 && !ozlu2.func_72803_f(n6, n5 - 1, n4)._a()) {
                            ozlu2.func_94571_i(n6, n5, n4);
                            continue;
                        }
                        if (!ozlu2.func_72803_f(n6, n5, n4)._a()) continue;
                        if (n5 == n2 - 1 && random.nextInt(4) != 0) {
                            ozlu2.func_72832_d(n6, n5, n4, twgu.field_72087_ao.field_71990_ca, 0, 2);
                            continue;
                        }
                        ozlu2.func_72832_d(n6, n5, n4, twgu.field_71978_w.field_71990_ca, 0, 2);
                    }
                }
            }
            block6: for (n6 = 0; n6 < 2; ++n6) {
                for (n5 = 0; n5 < 3; ++n5) {
                    int n11;
                    n4 = n + random.nextInt(n8 * 2 + 1) - n8;
                    if (!ozlu2.func_72799_c(n4, n2, n11 = n3 + random.nextInt(n9 * 2 + 1) - n9)) continue;
                    int n12 = 0;
                    if (ozlu2.func_72803_f(n4 - 1, n2, n11)._a()) {
                        ++n12;
                    }
                    if (ozlu2.func_72803_f(n4 + 1, n2, n11)._a()) {
                        ++n12;
                    }
                    if (ozlu2.func_72803_f(n4, n2, n11 - 1)._a()) {
                        ++n12;
                    }
                    if (ozlu2.func_72803_f(n4, n2, n11 + 1)._a()) {
                        ++n12;
                    }
                    if (n12 != 1) continue;
                    ozlu2.func_72832_d(n4, n2, n11, twgu.field_72077_au.field_71990_ca, 0, 2);
                    yfav yfav2 = (yfav)ozlu2.func_72796_p(n4, n2, n11);
                    if (yfav2 == null) continue block6;
                    ChestGenHooks chestGenHooks = ChestGenHooks.getInfo("dungeonChest");
                    vjvn._a(random, chestGenHooks.getItems(random), yfav2, chestGenHooks.getCount(random));
                    continue block6;
                }
            }
            ozlu2.func_72832_d(n, n2, n3, twgu.field_72065_as.field_71990_ca, 0, 2);
            xtcq xtcq2 = (xtcq)ozlu2.func_72796_p(n, n2, n3);
            if (xtcq2 != null) {
                xtcq2._a()._a(this._a(random));
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + n + ", " + n2 + ", " + n3 + ")");
            }
            return true;
        }
        return false;
    }

    public String _a(Random random) {
        return DungeonHooks.getRandomDungeonMob(random);
    }
}


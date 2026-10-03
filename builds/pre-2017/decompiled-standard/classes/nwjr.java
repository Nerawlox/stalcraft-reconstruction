/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;

public class nwjr
extends zzpm {
    public nwjr(boolean bl) {
        super(bl);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(3) + 5;
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= 256) {
            boolean bl2;
            int n5;
            int n6;
            int n7;
            int n8;
            for (n8 = n2; n8 <= n2 + 1 + n4; ++n8) {
                int n9 = 1;
                if (n8 == n2) {
                    n9 = 0;
                }
                if (n8 >= n2 + 1 + n4 - 2) {
                    n9 = 2;
                }
                for (n7 = n - n9; n7 <= n + n9 && bl; ++n7) {
                    for (n6 = n3 - n9; n6 <= n3 + n9 && bl; ++n6) {
                        if (n8 >= 0 && n8 < 256) {
                            n5 = ozlu2.func_72798_a(n7, n8, n6);
                            twgu twgu2 = twgu.field_71973_m[n5];
                            if (twgu2 == null || twgu2.isAirBlock(ozlu2, n7, n8, n6) || twgu2.isLeaves(ozlu2, n7, n8, n6)) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n8 = ozlu2.func_72798_a(n, n2 - 1, n3);
            twgu twgu3 = twgu.field_71973_m[n8];
            boolean bl3 = bl2 = twgu3 != null && twgu3.canSustainPlant(ozlu2, n, n2 - 1, n3, ForgeDirection.UP, (rqeh)twgu.field_71987_y);
            if (bl2 && n2 < 256 - n4 - 1) {
                int n10;
                twgu3.onPlantGrow(ozlu2, n, n2 - 1, n3, n, n2, n3);
                for (n10 = n2 - 3 + n4; n10 <= n2 + n4; ++n10) {
                    n7 = n10 - (n2 + n4);
                    n6 = 1 - n7 / 2;
                    for (n5 = n - n6; n5 <= n + n6; ++n5) {
                        int n11 = n5 - n;
                        for (int i = n3 - n6; i <= n3 + n6; ++i) {
                            int n12;
                            twgu twgu4;
                            int n13 = i - n3;
                            if (Math.abs(n11) == n6 && Math.abs(n13) == n6 && (random.nextInt(2) == 0 || n7 == 0) || (twgu4 = twgu.field_71973_m[n12 = ozlu2.func_72798_a(n5, n10, i)]) != null && !twgu4.canBeReplacedByLeaves(ozlu2, n5, n10, i)) continue;
                            this._a(ozlu2, n5, n10, i, twgu.field_71952_K.field_71990_ca, 2);
                        }
                    }
                }
                for (n10 = 0; n10 < n4; ++n10) {
                    n7 = ozlu2.func_72798_a(n, n2 + n10, n3);
                    twgu twgu5 = twgu.field_71973_m[n7];
                    if (twgu5 != null && !twgu5.isAirBlock(ozlu2, n, n2 + n10, n3) && !twgu5.isLeaves(ozlu2, n, n2 + n10, n3)) continue;
                    this._a(ozlu2, n, n2 + n10, n3, twgu.field_71951_J.field_71990_ca, 2);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}


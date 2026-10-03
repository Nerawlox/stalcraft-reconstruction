/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class yuxu
extends twgu {
    public static final int[][] _a = new int[][]{{2, 6}, {3, 7}, {2, 3}, {6, 7}, {0, 4}, {1, 5}, {0, 1}, {4, 5}};
    public final twgu _b;
    public final int _c;
    public boolean _d;
    public int _e;

    public yuxu(int n, twgu twgu2, int n2) {
        super(n, twgu2.field_72018_cp);
        this._b = twgu2;
        this._c = n2;
        this.func_71848_c(twgu2.field_71989_cb);
        this.func_71894_b(twgu2.field_72029_cc / 3.0f);
        this.func_71884_a(twgu2.field_72020_cn);
        this.func_71868_h(255);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        if (this._d) {
            this.func_71905_a(0.5f * (float)(this._e % 2), 0.5f * (float)(this._e / 2 % 2), 0.5f * (float)(this._e / 4 % 2), 0.5f + 0.5f * (float)(this._e % 2), 0.5f + 0.5f * (float)(this._e / 2 % 2), 0.5f + 0.5f * (float)(this._e / 4 % 2));
        } else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
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
    public int func_71857_b() {
        return 10;
    }

    public void _a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        if ((n4 & 4) != 0) {
            this.func_71905_a(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
    }

    public static boolean _a(int n) {
        return n > 0 && twgu.field_71973_m[n] instanceof yuxu;
    }

    public boolean _a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = sdrg2.func_72798_a(n, n2, n3);
        return yuxu._a(n5) && sdrg2.func_72805_g(n, n2, n3) == n4;
    }

    public boolean _b(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        int n5 = n4 & 3;
        float f = 0.5f;
        float f2 = 1.0f;
        if ((n4 & 4) != 0) {
            f = 0.0f;
            f2 = 0.5f;
        }
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 0.5f;
        boolean bl = true;
        if (n5 == 0) {
            f3 = 0.5f;
            f6 = 1.0f;
            int n6 = sdrg2.func_72798_a(n + 1, n2, n3);
            int n7 = sdrg2.func_72805_g(n + 1, n2, n3);
            if (yuxu._a(n6) && (n4 & 4) == (n7 & 4)) {
                int n8 = n7 & 3;
                if (n8 == 3 && !this._a(sdrg2, n, n2, n3 + 1, n4)) {
                    f6 = 0.5f;
                    bl = false;
                } else if (n8 == 2 && !this._a(sdrg2, n, n2, n3 - 1, n4)) {
                    f5 = 0.5f;
                    bl = false;
                }
            }
        } else if (n5 == 1) {
            f4 = 0.5f;
            f6 = 1.0f;
            int n9 = sdrg2.func_72798_a(n - 1, n2, n3);
            int n10 = sdrg2.func_72805_g(n - 1, n2, n3);
            if (yuxu._a(n9) && (n4 & 4) == (n10 & 4)) {
                int n11 = n10 & 3;
                if (n11 == 3 && !this._a(sdrg2, n, n2, n3 + 1, n4)) {
                    f6 = 0.5f;
                    bl = false;
                } else if (n11 == 2 && !this._a(sdrg2, n, n2, n3 - 1, n4)) {
                    f5 = 0.5f;
                    bl = false;
                }
            }
        } else if (n5 == 2) {
            f5 = 0.5f;
            f6 = 1.0f;
            int n12 = sdrg2.func_72798_a(n, n2, n3 + 1);
            int n13 = sdrg2.func_72805_g(n, n2, n3 + 1);
            if (yuxu._a(n12) && (n4 & 4) == (n13 & 4)) {
                int n14 = n13 & 3;
                if (n14 == 1 && !this._a(sdrg2, n + 1, n2, n3, n4)) {
                    f4 = 0.5f;
                    bl = false;
                } else if (n14 == 0 && !this._a(sdrg2, n - 1, n2, n3, n4)) {
                    f3 = 0.5f;
                    bl = false;
                }
            }
        } else if (n5 == 3) {
            int n15 = sdrg2.func_72798_a(n, n2, n3 - 1);
            int n16 = sdrg2.func_72805_g(n, n2, n3 - 1);
            if (yuxu._a(n15) && (n4 & 4) == (n16 & 4)) {
                int n17 = n16 & 3;
                if (n17 == 1 && !this._a(sdrg2, n + 1, n2, n3, n4)) {
                    f4 = 0.5f;
                    bl = false;
                } else if (n17 == 0 && !this._a(sdrg2, n - 1, n2, n3, n4)) {
                    f3 = 0.5f;
                    bl = false;
                }
            }
        }
        this.func_71905_a(f3, f, f5, f4, f2, f6);
        return bl;
    }

    public boolean _c(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        int n5 = n4 & 3;
        float f = 0.5f;
        float f2 = 1.0f;
        if ((n4 & 4) != 0) {
            f = 0.0f;
            f2 = 0.5f;
        }
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.5f;
        float f6 = 1.0f;
        boolean bl = false;
        if (n5 == 0) {
            int n6 = sdrg2.func_72798_a(n - 1, n2, n3);
            int n7 = sdrg2.func_72805_g(n - 1, n2, n3);
            if (yuxu._a(n6) && (n4 & 4) == (n7 & 4)) {
                int n8 = n7 & 3;
                if (n8 == 3 && !this._a(sdrg2, n, n2, n3 - 1, n4)) {
                    f5 = 0.0f;
                    f6 = 0.5f;
                    bl = true;
                } else if (n8 == 2 && !this._a(sdrg2, n, n2, n3 + 1, n4)) {
                    f5 = 0.5f;
                    f6 = 1.0f;
                    bl = true;
                }
            }
        } else if (n5 == 1) {
            int n9 = sdrg2.func_72798_a(n + 1, n2, n3);
            int n10 = sdrg2.func_72805_g(n + 1, n2, n3);
            if (yuxu._a(n9) && (n4 & 4) == (n10 & 4)) {
                f3 = 0.5f;
                f4 = 1.0f;
                int n11 = n10 & 3;
                if (n11 == 3 && !this._a(sdrg2, n, n2, n3 - 1, n4)) {
                    f5 = 0.0f;
                    f6 = 0.5f;
                    bl = true;
                } else if (n11 == 2 && !this._a(sdrg2, n, n2, n3 + 1, n4)) {
                    f5 = 0.5f;
                    f6 = 1.0f;
                    bl = true;
                }
            }
        } else if (n5 == 2) {
            int n12 = sdrg2.func_72798_a(n, n2, n3 - 1);
            int n13 = sdrg2.func_72805_g(n, n2, n3 - 1);
            if (yuxu._a(n12) && (n4 & 4) == (n13 & 4)) {
                f5 = 0.0f;
                f6 = 0.5f;
                int n14 = n13 & 3;
                if (n14 == 1 && !this._a(sdrg2, n - 1, n2, n3, n4)) {
                    bl = true;
                } else if (n14 == 0 && !this._a(sdrg2, n + 1, n2, n3, n4)) {
                    f3 = 0.5f;
                    f4 = 1.0f;
                    bl = true;
                }
            }
        } else if (n5 == 3) {
            int n15 = sdrg2.func_72798_a(n, n2, n3 + 1);
            int n16 = sdrg2.func_72805_g(n, n2, n3 + 1);
            if (yuxu._a(n15) && (n4 & 4) == (n16 & 4)) {
                int n17 = n16 & 3;
                if (n17 == 1 && !this._a(sdrg2, n - 1, n2, n3, n4)) {
                    bl = true;
                } else if (n17 == 0 && !this._a(sdrg2, n + 1, n2, n3, n4)) {
                    f3 = 0.5f;
                    f4 = 1.0f;
                    bl = true;
                }
            }
        }
        if (bl) {
            this.func_71905_a(f3, f, f5, f4, f2, f6);
        }
        return bl;
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        this._a(ozlu2, n, n2, n3);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        boolean bl = this._b(ozlu2, n, n2, n3);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        if (bl && this._c(ozlu2, n, n2, n3)) {
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        }
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        this._b.func_71862_a(ozlu2, n, n2, n3, random);
    }

    @Override
    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        this._b.func_71921_a(ozlu2, n, n2, n3, entityPlayer);
    }

    @Override
    public void func_71898_d(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._b.func_71898_d(ozlu2, n, n2, n3, n4);
    }

    @Override
    public int func_71874_e(sdrg sdrg2, int n, int n2, int n3) {
        return this._b.func_71874_e(sdrg2, n, n2, n3);
    }

    @Override
    public float func_71870_f(sdrg sdrg2, int n, int n2, int n3) {
        return this._b.func_71870_f(sdrg2, n, n2, n3);
    }

    @Override
    public float func_71904_a(Entity entity) {
        return this._b.func_71904_a(entity);
    }

    @Override
    public int func_71856_s_() {
        return this._b.func_71856_s_();
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        return this._b.func_71858_a(n, this._c);
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return this._b.func_71859_p_(ozlu2);
    }

    @Override
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        return this._b.func_71911_a_(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71901_a(ozlu ozlu2, int n, int n2, int n3, Entity entity, ofbx ofbx2) {
        this._b.func_71901_a(ozlu2, n, n2, n3, entity, ofbx2);
    }

    @Override
    public boolean func_71935_l() {
        return this._b.func_71935_l();
    }

    @Override
    public boolean func_71913_a(int n, boolean bl) {
        return this._b.func_71913_a(n, bl);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return this._b.func_71930_b(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71863_a(ozlu2, n, n2, n3, 0);
        this._b.func_71861_g(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        this._b.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public void func_71891_b(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        this._b.func_71891_b(ozlu2, n, n2, n3, entity);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        this._b.func_71847_b(ozlu2, n, n2, n3, random);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        return this._b.func_71903_a(ozlu2, n, n2, n3, entityPlayer, 0, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public void func_71867_k(ozlu ozlu2, int n, int n2, int n3, elkd elkd2) {
        this._b.func_71867_k(ozlu2, n, n2, n3, elkd2);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
        int n5 = ozlu2.func_72805_g(n, n2, n3) & 4;
        if (n4 == 0) {
            ozlu2.func_72921_c(n, n2, n3, 2 | n5, 2);
        }
        if (n4 == 1) {
            ozlu2.func_72921_c(n, n2, n3, 1 | n5, 2);
        }
        if (n4 == 2) {
            ozlu2.func_72921_c(n, n2, n3, 3 | n5, 2);
        }
        if (n4 == 3) {
            ozlu2.func_72921_c(n, n2, n3, 0 | n5, 2);
        }
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (n4 == 0 || n4 != 1 && (double)f2 > 0.5) {
            return n5 | 4;
        }
        return n5;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        void var12_16;
        void object;
        hank[] hankArray = new hank[8];
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        int n5 = n4 & 3;
        boolean bl = (n4 & 4) == 4;
        int[] nArray = _a[n5 + (bl ? 4 : 0)];
        this._d = true;
        boolean i = false;
        while (object < 8) {
            this._e = object;
            int[] nArray2 = nArray;
            int n6 = nArray2.length;
            for (int j = 0; j < n6; ++j) {
                int n7 = nArray2[j];
                if (n7 != object) continue;
            }
            hankArray[object] = super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
            ++object;
        }
        for (int j : nArray) {
            hankArray[j] = null;
        }
        Object var12_15 = null;
        double d = 0.0;
        for (hank hank2 : hankArray) {
            double d2;
            if (hank2 == null || !((d2 = hank2._h._e(ofbx3)) > d)) continue;
            hank hank3 = hank2;
            d = d2;
        }
        return var12_16;
    }

    @Override
    public void func_94332_a(nege nege2) {
    }
}


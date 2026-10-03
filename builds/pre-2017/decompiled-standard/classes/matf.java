/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.eidj;
import net.minecraft.util.ugqx;
import net.minecraftforge.common.ForgeDirection;

public class matf
extends twgu {
    public matf(int n) {
        super(n, tflj._q);
        this.func_71849_a(tgbl.field_78028_d);
        this.func_71907_b(true);
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
    public int func_71857_b() {
        return 29;
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 10;
    }

    @Override
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        return forgeDirection == ForgeDirection.NORTH && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || forgeDirection == ForgeDirection.SOUTH && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || forgeDirection == ForgeDirection.WEST && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || forgeDirection == ForgeDirection.EAST && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) || ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = 0;
        if (n4 == 2 && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true)) {
            n6 = 2;
        }
        if (n4 == 3 && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true)) {
            n6 = 0;
        }
        if (n4 == 4 && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true)) {
            n6 = 1;
        }
        if (n4 == 5 && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true)) {
            n6 = 3;
        }
        return n6;
    }

    @Override
    public void func_85105_g(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._a(ozlu2, n, n2, n3, this.field_71990_ca, n4, false, -1, 0);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (n4 != this.field_71990_ca && this._a(ozlu2, n, n2, n3)) {
            int n5 = ozlu2.func_72805_g(n, n2, n3);
            int n6 = n5 & 3;
            boolean bl = false;
            if (!ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) && n6 == 3) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) && n6 == 1) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) && n6 == 0) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) && n6 == 2) {
                bl = true;
            }
            if (bl) {
                this.func_71897_c(ozlu2, n, n2, n3, n5, 0);
                ozlu2.func_94571_i(n, n2, n3);
            }
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, boolean bl, int n6, int n7) {
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        int n13 = n5 & 3;
        boolean bl2 = (n5 & 4) == 4;
        boolean bl3 = (n5 & 8) == 8;
        boolean bl4 = n4 == twgu.field_72064_bT.field_71990_ca;
        boolean bl5 = false;
        boolean bl6 = !ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP);
        int n14 = ugqx._a[n13];
        int n15 = ugqx._b[n13];
        int n16 = 0;
        int[] nArray = new int[42];
        for (n12 = 1; n12 < 42; ++n12) {
            n11 = n + n14 * n12;
            n10 = n3 + n15 * n12;
            n9 = ozlu2.func_72798_a(n11, n2, n10);
            if (n9 == twgu.field_72064_bT.field_71990_ca) {
                n8 = ozlu2.func_72805_g(n11, n2, n10);
                if ((n8 & 3) != ugqx._f[n13]) break;
                n16 = n12;
                break;
            }
            if (n9 != twgu.field_72062_bU.field_71990_ca && n12 != n6) {
                nArray[n12] = -1;
                bl4 = false;
                continue;
            }
            n8 = n12 == n6 ? n7 : ozlu2.func_72805_g(n11, n2, n10);
            boolean bl7 = (n8 & 8) != 8;
            boolean bl8 = (n8 & 1) == 1;
            boolean bl9 = (n8 & 2) == 2;
            bl4 &= bl9 == bl6;
            bl5 |= bl7 && bl8;
            nArray[n12] = n8;
            if (n12 != n6) continue;
            ozlu2.func_72836_a(n, n2, n3, n4, this.func_71859_p_(ozlu2));
            bl4 &= bl7;
        }
        n12 = (bl4 ? 4 : 0) | ((bl5 &= (bl4 &= n16 > 1)) ? 8 : 0);
        n5 = n13 | n12;
        if (n16 > 0) {
            n11 = n + n14 * n16;
            n10 = n3 + n15 * n16;
            n9 = ugqx._f[n13];
            ozlu2.func_72921_c(n11, n2, n10, n9 | n12, 3);
            this._a(ozlu2, n11, n2, n10, n9);
            this._a(ozlu2, n11, n2, n10, bl4, bl5, bl2, bl3);
        }
        this._a(ozlu2, n, n2, n3, bl4, bl5, bl2, bl3);
        if (n4 > 0) {
            ozlu2.func_72921_c(n, n2, n3, n5, 3);
            if (bl) {
                this._a(ozlu2, n, n2, n3, n13);
            }
        }
        if (bl2 != bl4) {
            for (n11 = 1; n11 < n16; ++n11) {
                n10 = n + n14 * n11;
                n9 = n3 + n15 * n11;
                n8 = nArray[n11];
                if (n8 < 0) continue;
                n8 = bl4 ? (n8 |= 4) : (n8 &= 0xFFFFFFFB);
                ozlu2.func_72921_c(n10, n2, n9, n8, 3);
            }
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        this._a(ozlu2, n, n2, n3, this.field_71990_ca, ozlu2.func_72805_g(n, n2, n3), true, -1, 0);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl2 && !bl4) {
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.4f, 0.6f);
        } else if (!bl2 && bl4) {
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.4f, 0.5f);
        } else if (bl && !bl3) {
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.click", 0.4f, 0.7f);
        } else if (!bl && bl3) {
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.1, (double)n3 + 0.5, "random.bowhit", 0.4f, 1.2f / (ozlu2.field_73012_v.nextFloat() * 0.2f + 0.9f));
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        if (n4 == 3) {
            ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
        } else if (n4 == 1) {
            ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
        } else if (n4 == 0) {
            ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
        } else if (n4 == 2) {
            ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
        }
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        if (!this.func_71930_b(ozlu2, n, n2, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94571_i(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3) & 3;
        float f = 0.1875f;
        if (n4 == 3) {
            this.func_71905_a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        } else if (n4 == 1) {
            this.func_71905_a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        } else if (n4 == 0) {
            this.func_71905_a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        } else if (n4 == 2) {
            this.func_71905_a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        }
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        boolean bl;
        boolean bl2 = (n5 & 4) == 4;
        boolean bl3 = bl = (n5 & 8) == 8;
        if (bl2 || bl) {
            this._a(ozlu2, n, n2, n3, 0, n5, false, -1, 0);
        }
        if (bl) {
            ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
            int n6 = n5 & 3;
            if (n6 == 3) {
                ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
            } else if (n6 == 1) {
                ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
            } else if (n6 == 0) {
                ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
            } else if (n6 == 2) {
                ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
            }
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return (sdrg2.func_72805_g(n, n2, n3) & 8) == 8 ? 15 : 0;
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = sdrg2.func_72805_g(n, n2, n3);
        if ((n5 & 8) != 8) {
            return 0;
        }
        int n6 = n5 & 3;
        return n6 == 2 && n4 == 2 ? 15 : (n6 == 0 && n4 == 3 ? 15 : (n6 == 1 && n4 == 4 ? 15 : (n6 == 3 && n4 == 5 ? 15 : 0)));
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }
}


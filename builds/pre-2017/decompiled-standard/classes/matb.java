/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraftforge.common.ForgeDirection;

public class matb
extends twgu {
    public matb(int n) {
        super(n, tflj._q);
        this.func_71907_b(true);
        this.func_71849_a(tgbl.field_78031_c);
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
        return 2;
    }

    public boolean _b(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72797_t(n, n2, n3)) {
            return true;
        }
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        return twgu.field_71973_m[n4] != null && twgu.field_71973_m[n4].canPlaceTorchOnTop(ozlu2, n, n2, n3);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true) || ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true) || ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true) || ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true) || this._b(ozlu2, n, n2 - 1, n3);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = n5;
        if (n4 == 1 && this._b(ozlu2, n, n2 - 1, n3)) {
            n6 = 5;
        }
        if (n4 == 2 && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true)) {
            n6 = 4;
        }
        if (n4 == 3 && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true)) {
            n6 = 3;
        }
        if (n4 == 4 && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true)) {
            n6 = 2;
        }
        if (n4 == 5 && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true)) {
            n6 = 1;
        }
        return n6;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        super.func_71847_b(ozlu2, n, n2, n3, random);
        if (ozlu2.func_72805_g(n, n2, n3) == 0) {
            this.func_71861_g(ozlu2, n, n2, n3);
        }
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72805_g(n, n2, n3) == 0) {
            if (ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true)) {
                ozlu2.func_72921_c(n, n2, n3, 1, 2);
            } else if (ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true)) {
                ozlu2.func_72921_c(n, n2, n3, 2, 2);
            } else if (ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true)) {
                ozlu2.func_72921_c(n, n2, n3, 3, 2);
            } else if (ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true)) {
                ozlu2.func_72921_c(n, n2, n3, 4, 2);
            } else if (this._b(ozlu2, n, n2 - 1, n3)) {
                ozlu2.func_72921_c(n, n2, n3, 5, 2);
            }
        }
        this._c(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._a(ozlu2, n, n2, n3, n4);
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (this._c(ozlu2, n, n2, n3)) {
            int n5 = ozlu2.func_72805_g(n, n2, n3);
            boolean bl = false;
            if (!ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST, true) && n5 == 1) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST, true) && n5 == 2) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH, true) && n5 == 3) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH, true) && n5 == 4) {
                bl = true;
            }
            if (!this._b(ozlu2, n, n2 - 1, n3) && n5 == 5) {
                bl = true;
            }
            if (bl) {
                this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
                ozlu2.func_94571_i(n, n2, n3);
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean _c(ozlu ozlu2, int n, int n2, int n3) {
        if (!this.func_71930_b(ozlu2, n, n2, n3)) {
            if (ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca) {
                this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
                ozlu2.func_94571_i(n, n2, n3);
            }
            return false;
        }
        return true;
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3) & 7;
        float f = 0.15f;
        if (n4 == 1) {
            this.func_71905_a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        } else if (n4 == 2) {
            this.func_71905_a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        } else if (n4 == 3) {
            this.func_71905_a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        } else if (n4 == 4) {
            this.func_71905_a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        } else {
            f = 0.1f;
            this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.6f, 0.5f + f);
        }
        return super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        double d = (float)n + 0.5f;
        double d2 = (float)n2 + 0.7f;
        double d3 = (float)n3 + 0.5f;
        double d4 = 0.22f;
        double d5 = 0.27f;
        if (n4 == 1) {
            ozlu2.func_72869_a("smoke", d - d5, d2 + d4, d3, 0.0, 0.0, 0.0);
            ozlu2.func_72869_a("flame", d - d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        } else if (n4 == 2) {
            ozlu2.func_72869_a("smoke", d + d5, d2 + d4, d3, 0.0, 0.0, 0.0);
            ozlu2.func_72869_a("flame", d + d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        } else if (n4 == 3) {
            ozlu2.func_72869_a("smoke", d, d2 + d4, d3 - d5, 0.0, 0.0, 0.0);
            ozlu2.func_72869_a("flame", d, d2 + d4, d3 - d5, 0.0, 0.0, 0.0);
        } else if (n4 == 4) {
            ozlu2.func_72869_a("smoke", d, d2 + d4, d3 + d5, 0.0, 0.0, 0.0);
            ozlu2.func_72869_a("flame", d, d2 + d4, d3 + d5, 0.0, 0.0, 0.0);
        } else {
            ozlu2.func_72869_a("smoke", d, d2, d3, 0.0, 0.0, 0.0);
            ozlu2.func_72869_a("flame", d, d2, d3, 0.0, 0.0, 0.0);
        }
    }
}


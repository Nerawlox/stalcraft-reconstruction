/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.eidj;
import net.minecraftforge.common.ForgeDirection;

public abstract class scbx
extends twgu {
    public boolean _a;

    public scbx(int n, boolean bl) {
        super(n, tflj._q);
        this.func_71907_b(true);
        this.func_71849_a(tgbl.field_78028_d);
        this._a = bl;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return this._a ? 30 : 20;
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
        int n6 = ozlu2.func_72805_g(n, n2, n3);
        int n7 = n6 & 8;
        n6 &= 7;
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        n6 = forgeDirection == ForgeDirection.NORTH && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) ? 4 : (forgeDirection == ForgeDirection.SOUTH && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) ? 3 : (forgeDirection == ForgeDirection.WEST && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) ? 2 : (forgeDirection == ForgeDirection.EAST && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) ? 1 : this._a(ozlu2, n, n2, n3))));
        return n6 + n7;
    }

    public int _a(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            return 1;
        }
        if (ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            return 2;
        }
        if (ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            return 3;
        }
        if (ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            return 4;
        }
        return 1;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (this._b(ozlu2, n, n2, n3)) {
            int n5 = ozlu2.func_72805_g(n, n2, n3) & 7;
            boolean bl = false;
            if (!ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) && n5 == 1) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) && n5 == 2) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) && n5 == 3) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) && n5 == 4) {
                bl = true;
            }
            if (bl) {
                this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
                ozlu2.func_94571_i(n, n2, n3);
            }
        }
    }

    public boolean _b(ozlu ozlu2, int n, int n2, int n3) {
        if (!this.func_71930_b(ozlu2, n, n2, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94571_i(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        this._a(n4);
    }

    public void _a(int n) {
        int n2 = n & 7;
        boolean bl = (n & 8) > 0;
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.1875f;
        float f4 = 0.125f;
        if (bl) {
            f4 = 0.0625f;
        }
        if (n2 == 1) {
            this.func_71905_a(0.0f, f, 0.5f - f3, f4, f2, 0.5f + f3);
        } else if (n2 == 2) {
            this.func_71905_a(1.0f - f4, f, 0.5f - f3, 1.0f, f2, 0.5f + f3);
        } else if (n2 == 3) {
            this.func_71905_a(0.5f - f3, f, 0.0f, 0.5f + f3, f2, f4);
        } else if (n2 == 4) {
            this.func_71905_a(0.5f - f3, f, 1.0f - f4, 0.5f + f3, f2, 1.0f);
        }
    }

    @Override
    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        int n6 = n5 & 7;
        int n7 = 8 - (n5 & 8);
        if (n7 == 0) {
            return true;
        }
        ozlu2.func_72921_c(n, n2, n3, n6 + n7, 3);
        ozlu2.func_72909_d(n, n2, n3, n, n2, n3);
        ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, 0.6f);
        this._a(ozlu2, n, n2, n3, n6);
        ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
        return true;
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 8) > 0) {
            int n6 = n5 & 7;
            this._a(ozlu2, n, n2, n3, n6);
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return (sdrg2.func_72805_g(n, n2, n3) & 8) > 0 ? 15 : 0;
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = sdrg2.func_72805_g(n, n2, n3);
        if ((n5 & 8) == 0) {
            return 0;
        }
        int n6 = n5 & 7;
        return n6 == 5 && n4 == 1 ? 15 : (n6 == 4 && n4 == 2 ? 15 : (n6 == 3 && n4 == 3 ? 15 : (n6 == 2 && n4 == 4 ? 15 : (n6 == 1 && n4 == 5 ? 15 : 0))));
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4;
        if (!ozlu2.field_72995_K && ((n4 = ozlu2.func_72805_g(n, n2, n3)) & 8) != 0) {
            if (this._a) {
                this._c(ozlu2, n, n2, n3);
            } else {
                ozlu2.func_72921_c(n, n2, n3, n4 & 7, 3);
                int n5 = n4 & 7;
                this._a(ozlu2, n, n2, n3, n5);
                ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, 0.5f);
                ozlu2.func_72909_d(n, n2, n3, n, n2, n3);
            }
        }
    }

    @Override
    public void func_71919_f() {
        float f = 0.1875f;
        float f2 = 0.125f;
        float f3 = 0.125f;
        this.func_71905_a(0.5f - f, 0.5f - f2, 0.5f - f3, 0.5f + f, 0.5f + f2, 0.5f + f3);
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if (!ozlu2.field_72995_K && this._a && (ozlu2.func_72805_g(n, n2, n3) & 8) == 0) {
            this._c(ozlu2, n, n2, n3);
        }
    }

    public void _c(ozlu ozlu2, int n, int n2, int n3) {
        boolean bl;
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        int n5 = n4 & 7;
        boolean bl2 = (n4 & 8) != 0;
        this._a(n4);
        List list = ozlu2.func_72872_a(EntityArrow.class, eidj._a()._a((double)n + this.field_72026_ch, (double)n2 + this.field_72023_ci, (double)n3 + this.field_72024_cj, (double)n + this.field_72021_ck, (double)n2 + this.field_72022_cl, (double)n3 + this.field_72019_cm));
        boolean bl3 = bl = !list.isEmpty();
        if (bl && !bl2) {
            ozlu2.func_72921_c(n, n2, n3, n5 | 8, 3);
            this._a(ozlu2, n, n2, n3, n5);
            ozlu2.func_72909_d(n, n2, n3, n, n2, n3);
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (!bl && bl2) {
            ozlu2.func_72921_c(n, n2, n3, n5, 3);
            this._a(ozlu2, n, n2, n3, n5);
            ozlu2.func_72909_d(n, n2, n3, n, n2, n3);
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, 0.5f);
        }
        if (bl) {
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        if (n4 == 1) {
            ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
        } else if (n4 == 2) {
            ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
        } else if (n4 == 3) {
            ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
        } else if (n4 == 4) {
            ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
        } else {
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
    }
}


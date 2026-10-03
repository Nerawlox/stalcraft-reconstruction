/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeDirection;

public class tfgg
extends twgu {
    public tfgg(int n) {
        super(n, tflj._q);
        this.func_71849_a(tgbl.field_78028_d);
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
        return 12;
    }

    @Override
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        return forgeDirection == ForgeDirection.DOWN && ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) || forgeDirection == ForgeDirection.UP && ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) || forgeDirection == ForgeDirection.NORTH && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || forgeDirection == ForgeDirection.SOUTH && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || forgeDirection == ForgeDirection.WEST && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || forgeDirection == ForgeDirection.EAST && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) || ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) || ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = n5 & 8;
        int n7 = n5 & 7;
        int n8 = -1;
        if (n4 == 0 && ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN)) {
            n8 = 0;
        }
        if (n4 == 1 && ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP)) {
            n8 = 5;
        }
        if (n4 == 2 && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            n8 = 4;
        }
        if (n4 == 3 && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            n8 = 3;
        }
        if (n4 == 4 && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            n8 = 2;
        }
        if (n4 == 5 && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            n8 = 1;
        }
        return n8 + n6;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        int n5 = n4 & 7;
        int n6 = n4 & 8;
        if (n5 == tfgg._a(1)) {
            if ((sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                ozlu2.func_72921_c(n, n2, n3, 5 | n6, 2);
            } else {
                ozlu2.func_72921_c(n, n2, n3, 6 | n6, 2);
            }
        } else if (n5 == tfgg._a(0)) {
            if ((sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                ozlu2.func_72921_c(n, n2, n3, 7 | n6, 2);
            } else {
                ozlu2.func_72921_c(n, n2, n3, 0 | n6, 2);
            }
        }
    }

    public static int _a(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 5;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (this._a(ozlu2, n, n2, n3)) {
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
            if (!ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) && n5 == 5) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) && n5 == 6) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) && n5 == 0) {
                bl = true;
            }
            if (!ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) && n5 == 7) {
                bl = true;
            }
            if (bl) {
                this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
                ozlu2.func_94571_i(n, n2, n3);
            }
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
        int n4 = sdrg2.func_72805_g(n, n2, n3) & 7;
        float f = 0.1875f;
        if (n4 == 1) {
            this.func_71905_a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        } else if (n4 == 2) {
            this.func_71905_a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        } else if (n4 == 3) {
            this.func_71905_a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        } else if (n4 == 4) {
            this.func_71905_a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        } else if (n4 != 5 && n4 != 6) {
            if (n4 == 0 || n4 == 7) {
                f = 0.25f;
                this.func_71905_a(0.5f - f, 0.4f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
            }
        } else {
            f = 0.25f;
            this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.6f, 0.5f + f);
        }
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        int n6 = n5 & 7;
        int n7 = 8 - (n5 & 8);
        ozlu2.func_72921_c(n, n2, n3, n6 + n7, 3);
        ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, n7 > 0 ? 0.6f : 0.5f);
        ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        if (n6 == 1) {
            ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
        } else if (n6 == 2) {
            ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
        } else if (n6 == 3) {
            ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
        } else if (n6 == 4) {
            ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
        } else if (n6 != 5 && n6 != 6) {
            if (n6 == 0 || n6 == 7) {
                ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
            }
        } else {
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
        }
        return true;
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 8) > 0) {
            ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
            int n6 = n5 & 7;
            if (n6 == 1) {
                ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
            } else if (n6 == 2) {
                ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
            } else if (n6 == 3) {
                ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
            } else if (n6 == 4) {
                ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
            } else if (n6 != 5 && n6 != 6) {
                if (n6 == 0 || n6 == 7) {
                    ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
                }
            } else {
                ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            }
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
        return n6 == 0 && n4 == 0 ? 15 : (n6 == 7 && n4 == 0 ? 15 : (n6 == 6 && n4 == 1 ? 15 : (n6 == 5 && n4 == 1 ? 15 : (n6 == 4 && n4 == 2 ? 15 : (n6 == 3 && n4 == 3 ? 15 : (n6 == 2 && n4 == 4 ? 15 : (n6 == 1 && n4 == 5 ? 15 : 0)))))));
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }
}


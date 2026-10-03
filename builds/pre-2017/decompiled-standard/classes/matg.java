/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraftforge.common.ForgeDirection;

public class matg
extends twgu {
    public static boolean _a = false;

    public matg(int n, tflj tflj2) {
        super(n, tflj2);
        float f = 0.5f;
        float f2 = 1.0f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
        this.func_71849_a(tgbl.field_78028_d);
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
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return !matg._b(sdrg2.func_72805_g(n, n2, n3));
    }

    @Override
    public int func_71857_b() {
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71911_a_(ozlu2, n, n2, n3);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71872_e(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this._a(sdrg2.func_72805_g(n, n2, n3));
    }

    @Override
    public void func_71919_f() {
        float f = 0.1875f;
        this.func_71905_a(0.0f, 0.5f - f / 2.0f, 0.0f, 1.0f, 0.5f + f / 2.0f, 1.0f);
    }

    public void _a(int n) {
        float f = 0.1875f;
        if ((n & 8) != 0) {
            this.func_71905_a(0.0f, 1.0f - f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
        }
        if (matg._b(n)) {
            if ((n & 3) == 0) {
                this.func_71905_a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
            }
            if ((n & 3) == 1) {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
            }
            if ((n & 3) == 2) {
                this.func_71905_a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
            if ((n & 3) == 3) {
                this.func_71905_a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (this.field_72018_cp == tflj._f) {
            return true;
        }
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        ozlu2.func_72921_c(n, n2, n3, n5 ^ 4, 2);
        ozlu2.func_72889_a(entityPlayer, 1003, n, n2, n3, 0);
        return true;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, boolean bl) {
        boolean bl2;
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        boolean bl3 = bl2 = (n4 & 4) > 0;
        if (bl2 != bl) {
            ozlu2.func_72921_c(n, n2, n3, n4 ^ 4, 2);
            ozlu2.func_72889_a(null, 1003, n, n2, n3, 0);
        }
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K) {
            boolean bl;
            int n5 = ozlu2.func_72805_g(n, n2, n3);
            int n6 = n;
            int n7 = n3;
            if ((n5 & 3) == 0) {
                n7 = n3 + 1;
            }
            if ((n5 & 3) == 1) {
                --n7;
            }
            if ((n5 & 3) == 2) {
                n6 = n + 1;
            }
            if ((n5 & 3) == 3) {
                --n6;
            }
            if (!matg._c(ozlu2.func_72798_a(n6, n2, n7)) && !ozlu2.isBlockSolidOnSide(n6, n2, n7, ForgeDirection.getOrientation((n5 & 3) + 2))) {
                ozlu2.func_94571_i(n, n2, n3);
                this.func_71897_c(ozlu2, n, n2, n3, n5, 0);
            }
            if ((bl = ozlu2.func_72864_z(n, n2, n3)) || n4 > 0 && twgu.field_71973_m[n4].func_71853_i()) {
                this._a(ozlu2, n, n2, n3, bl);
            }
        }
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = 0;
        if (n4 == 2) {
            n6 = 0;
        }
        if (n4 == 3) {
            n6 = 1;
        }
        if (n4 == 4) {
            n6 = 2;
        }
        if (n4 == 5) {
            n6 = 3;
        }
        if (n4 != 1 && n4 != 0 && f2 > 0.5f) {
            n6 |= 8;
        }
        return n6;
    }

    @Override
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (_a) {
            return true;
        }
        if (n4 == 0) {
            return false;
        }
        if (n4 == 1) {
            return false;
        }
        if (n4 == 2) {
            ++n3;
        }
        if (n4 == 3) {
            --n3;
        }
        if (n4 == 4) {
            ++n;
        }
        if (n4 == 5) {
            --n;
        }
        return matg._c(ozlu2.func_72798_a(n, n2, n3)) || ozlu2.isBlockSolidOnSide(n, n2, n3, ForgeDirection.UP);
    }

    public static boolean _b(int n) {
        return (n & 4) != 0;
    }

    public static boolean _c(int n) {
        if (_a) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        twgu twgu2 = twgu.field_71973_m[n];
        return twgu2 != null && twgu2.field_72018_cp._k() && twgu2.func_71886_c() || twgu2 == twgu.field_72014_bd || twgu2 instanceof ndvn || twgu2 instanceof yuxu;
    }
}


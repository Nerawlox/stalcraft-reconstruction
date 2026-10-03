/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.owak;

public class uzku
extends iwgt {
    public uzku(int n) {
        super(n, tflj._G);
        this.func_71848_c(-1.0f);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return null;
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (hurg2 instanceof mcbr) {
            ((mcbr)hurg2)._e();
        } else {
            super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
        }
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }

    @Override
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return false;
    }

    @Override
    public int func_71857_b() {
        return -1;
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
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (!ozlu2.field_72995_K && ozlu2.func_72796_p(n, n2, n3) == null) {
            ozlu2.func_94571_i(n, n2, n3);
            return true;
        }
        return false;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        if (ozlu2.field_72995_K) {
            return;
        }
        mcbr mcbr2 = this._a(ozlu2, n, n2, n3);
        if (mcbr2 == null) {
            return;
        }
        twgu.field_71973_m[mcbr2._a()].func_71897_c(ozlu2, n, n2, n3, mcbr2.func_70322_n(), 0);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K) {
            ozlu2.func_72796_p(n, n2, n3);
        }
    }

    public static hurg _a(int n, int n2, int n3, boolean bl, boolean bl2) {
        return new mcbr(n, n2, n3, bl, bl2);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        mcbr mcbr2 = this._a(ozlu2, n, n2, n3);
        if (mcbr2 == null) {
            return null;
        }
        float f = mcbr2._a(0.0f);
        if (mcbr2._b()) {
            f = 1.0f - f;
        }
        return this._a(ozlu2, n, n2, n3, mcbr2._a(), f, mcbr2._c());
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        mcbr mcbr2 = this._a(sdrg2, n, n2, n3);
        if (mcbr2 != null) {
            twgu twgu2 = twgu.field_71973_m[mcbr2._a()];
            if (twgu2 == null || twgu2 == this) {
                return;
            }
            twgu2.func_71902_a(sdrg2, n, n2, n3);
            float f = mcbr2._a(0.0f);
            if (mcbr2._b()) {
                f = 1.0f - f;
            }
            int n4 = mcbr2._c();
            this.field_72026_ch = twgu2.func_83009_v() - (double)((float)owak._b[n4] * f);
            this.field_72023_ci = twgu2.func_83008_x() - (double)((float)owak._c[n4] * f);
            this.field_72024_cj = twgu2.func_83005_z() - (double)((float)owak._d[n4] * f);
            this.field_72021_ck = twgu2.func_83007_w() - (double)((float)owak._b[n4] * f);
            this.field_72022_cl = twgu2.func_83010_y() - (double)((float)owak._c[n4] * f);
            this.field_72019_cm = twgu2.func_83006_A() - (double)((float)owak._d[n4] * f);
        }
    }

    public eidj _a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        if (n4 == 0 || n4 == this.field_71990_ca) {
            return null;
        }
        eidj eidj2 = twgu.field_71973_m[n4].func_71872_e(ozlu2, n, n2, n3);
        if (eidj2 == null) {
            return null;
        }
        if (owak._b[n5] < 0) {
            eidj2._b -= (double)((float)owak._b[n5] * f);
        } else {
            eidj2._e -= (double)((float)owak._b[n5] * f);
        }
        if (owak._c[n5] < 0) {
            eidj2._c -= (double)((float)owak._c[n5] * f);
        } else {
            eidj2._f -= (double)((float)owak._c[n5] * f);
        }
        if (owak._d[n5] < 0) {
            eidj2._d -= (double)((float)owak._d[n5] * f);
        } else {
            eidj2._g -= (double)((float)owak._d[n5] * f);
        }
        return eidj2;
    }

    public mcbr _a(sdrg sdrg2, int n, int n2, int n3) {
        hurg hurg2 = sdrg2.func_72796_p(n, n2, n3);
        if (hurg2 instanceof mcbr) {
            return (mcbr)hurg2;
        }
        return null;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return 0;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("piston_top_normal");
    }
}


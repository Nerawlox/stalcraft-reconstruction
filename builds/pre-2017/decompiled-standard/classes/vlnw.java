/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;

public class vlnw
extends twgu {
    public vlnw(int n) {
        super(n, tflj._q);
        this.func_71919_f();
    }

    @Override
    public void func_71919_f() {
        float f = 0.375f;
        float f2 = f / 2.0f;
        this.func_71905_a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f, 0.5f + f2);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 33;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 == null) {
            return false;
        }
        if (ozlu2.func_72805_g(n, n2, n3) != 0) {
            return false;
        }
        int n5 = vlnw._a(cvzo2);
        if (n5 > 0) {
            ozlu2.func_72921_c(n, n2, n3, n5, 2);
            if (!entityPlayer.field_71075_bZ._d && --cvzo2._b <= 0) {
                entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
            }
            return true;
        }
        return false;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        cvzo cvzo2 = vlnw._a(ozlu2.func_72805_g(n, n2, n3));
        if (cvzo2 == null) {
            return tgdv.field_82796_bJ.field_77779_bT;
        }
        return cvzo2._d;
    }

    @Override
    public int func_71873_h(ozlu ozlu2, int n, int n2, int n3) {
        cvzo cvzo2 = vlnw._a(ozlu2.func_72805_g(n, n2, n3));
        if (cvzo2 == null) {
            return tgdv.field_82796_bJ.field_77779_bT;
        }
        return cvzo2._j();
    }

    @Override
    public boolean func_82505_u_() {
        return true;
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return super.func_71930_b(ozlu2, n, n2, n3) && ozlu2.func_72797_t(n, n2 - 1, n3);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.func_72797_t(n, n2 - 1, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        cvzo cvzo2;
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, n5);
        if (n4 > 0 && (cvzo2 = vlnw._a(n4)) != null) {
            this.func_71929_a(ozlu2, n, n2, n3, cvzo2);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_82796_bJ.field_77779_bT;
    }

    public static cvzo _a(int n) {
        switch (n) {
            case 1: {
                return new cvzo(twgu.field_72107_ae);
            }
            case 2: {
                return new cvzo(twgu.field_72097_ad);
            }
            case 9: {
                return new cvzo(twgu.field_72038_aV);
            }
            case 8: {
                return new cvzo(twgu.field_72109_af);
            }
            case 7: {
                return new cvzo(twgu.field_72103_ag);
            }
            case 10: {
                return new cvzo(twgu.field_71961_Y);
            }
            case 3: {
                return new cvzo(twgu.field_71987_y, 1, 0);
            }
            case 5: {
                return new cvzo(twgu.field_71987_y, 1, 2);
            }
            case 4: {
                return new cvzo(twgu.field_71987_y, 1, 1);
            }
            case 6: {
                return new cvzo(twgu.field_71987_y, 1, 3);
            }
            case 11: {
                return new cvzo(twgu.field_71962_X, 1, 2);
            }
        }
        return null;
    }

    public static int _a(cvzo cvzo2) {
        int n = cvzo2._a().field_77779_bT;
        if (n == twgu.field_72107_ae.field_71990_ca) {
            return 1;
        }
        if (n == twgu.field_72097_ad.field_71990_ca) {
            return 2;
        }
        if (n == twgu.field_72038_aV.field_71990_ca) {
            return 9;
        }
        if (n == twgu.field_72109_af.field_71990_ca) {
            return 8;
        }
        if (n == twgu.field_72103_ag.field_71990_ca) {
            return 7;
        }
        if (n == twgu.field_71961_Y.field_71990_ca) {
            return 10;
        }
        if (n == twgu.field_71987_y.field_71990_ca) {
            switch (cvzo2._j()) {
                case 0: {
                    return 3;
                }
                case 2: {
                    return 5;
                }
                case 1: {
                    return 4;
                }
                case 3: {
                    return 6;
                }
            }
        }
        if (n == twgu.field_71962_X.field_71990_ca) {
            switch (cvzo2._j()) {
                case 2: {
                    return 11;
                }
            }
        }
        return 0;
    }
}


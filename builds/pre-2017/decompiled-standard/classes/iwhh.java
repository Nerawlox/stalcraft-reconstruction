/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class iwhh
extends twgu {
    public dwan _a;
    public dwan _b;
    public dwan _c;

    public iwhh(int n) {
        super(n, tflj._f);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1) {
            return this._b;
        }
        if (n == 0) {
            return this._c;
        }
        return this.field_94336_cN;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._a = nege2._b(this.func_111023_E() + "_" + "inner");
        this._b = nege2._b(this.func_111023_E() + "_top");
        this._c = nege2._b(this.func_111023_E() + "_" + "bottom");
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
    }

    public static dwan _a(String string) {
        if (string.equals("inner")) {
            return twgu.field_72108_bG._a;
        }
        if (string.equals("bottom")) {
            return twgu.field_72108_bG._c;
        }
        return null;
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list, Entity entity) {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.3125f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        float f = 0.125f;
        this.func_71905_a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        this.func_71905_a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        this.func_71905_a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        this.func_71919_f();
    }

    @Override
    public void func_71919_f() {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 24;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 == null) {
            return true;
        }
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        int n6 = iwhh._a(n5);
        if (cvzo2._d == tgdv.field_77786_ax.field_77779_bT) {
            if (n6 < 3) {
                if (!entityPlayer.field_71075_bZ._d) {
                    entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, new cvzo(tgdv.field_77788_aw));
                }
                ozlu2.func_72921_c(n, n2, n3, 3, 2);
                ozlu2.func_96440_m(n, n2, n3, this.field_71990_ca);
            }
            return true;
        }
        if (cvzo2._d == tgdv.field_77729_bt.field_77779_bT) {
            if (n6 > 0) {
                cvzo cvzo3 = new cvzo(tgdv.field_77726_bs, 1, 0);
                if (!entityPlayer.field_71071_by._c(cvzo3)) {
                    ozlu2.func_72838_d(new EntityItem(ozlu2, (double)n + 0.5, (double)n2 + 1.5, (double)n3 + 0.5, cvzo3));
                } else if (entityPlayer instanceof EntityPlayerMP) {
                    ((EntityPlayerMP)entityPlayer).func_71120_a(entityPlayer.field_71069_bz);
                }
                --cvzo2._b;
                if (cvzo2._b <= 0) {
                    entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
                }
                ozlu2.func_72921_c(n, n2, n3, n6 - 1, 2);
                ozlu2.func_96440_m(n, n2, n3, this.field_71990_ca);
            }
        } else if (n6 > 0 && cvzo2._a() instanceof lpno && ((lpno)cvzo2._a()).func_82812_d() == yery._a) {
            lpno lpno2 = (lpno)cvzo2._a();
            lpno2.func_82815_c(cvzo2);
            ozlu2.func_72921_c(n, n2, n3, n6 - 1, 2);
            ozlu2.func_96440_m(n, n2, n3, this.field_71990_ca);
            return true;
        }
        return true;
    }

    @Override
    public void func_71892_f(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.field_73012_v.nextInt(20) != 1) {
            return;
        }
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (n4 < 3) {
            ozlu2.func_72921_c(n, n2, n3, n4 + 1, 2);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77721_bz.field_77779_bT;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77721_bz.field_77779_bT;
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        return iwhh._a(n5);
    }

    public static int _a(int n) {
        return n;
    }
}


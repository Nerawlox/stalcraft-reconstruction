/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;

public class kloa
extends gqau {
    public kloa(int n) {
        super(n, tflj._d);
        this.func_71849_a(tgbl.field_78028_d);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        return twgu.field_71988_x.func_71851_a(n);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        if (!ozlu2.func_72803_f(n, n2 - 1, n3)._a()) {
            return false;
        }
        return super.func_71930_b(ozlu2, n, n2, n3);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (kloa._a(n4)) {
            return null;
        }
        if (n4 == 2 || n4 == 0) {
            return eidj._a()._a(n, n2, (float)n3 + 0.375f, n + 1, (float)n2 + 1.5f, (float)n3 + 0.625f);
        }
        return eidj._a()._a((float)n + 0.375f, n2, n3, (float)n + 0.625f, (float)n2 + 1.5f, n3 + 1);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = kloa._d(sdrg2.func_72805_g(n, n2, n3));
        if (n4 == 2 || n4 == 0) {
            this.func_71905_a(0.0f, 0.0f, 0.375f, 1.0f, 1.0f, 0.625f);
        } else {
            this.func_71905_a(0.375f, 0.0f, 0.0f, 0.625f, 1.0f, 1.0f);
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
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return kloa._a(sdrg2.func_72805_g(n, n2, n3));
    }

    @Override
    public int func_71857_b() {
        return 21;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = (sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3) % 4;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        if (kloa._a(n5)) {
            ozlu2.func_72921_c(n, n2, n3, n5 & 0xFFFFFFFB, 2);
        } else {
            int n6 = (sajh._c((double)(entityPlayer.field_70177_z * 4.0f / 360.0f) + 0.5) & 3) % 4;
            int n7 = kloa._d(n5);
            if (n7 == (n6 + 2) % 4) {
                n5 = n6;
            }
            ozlu2.func_72921_c(n, n2, n3, n5 | 4, 2);
        }
        ozlu2.func_72889_a(entityPlayer, 1003, n, n2, n3, 0);
        return true;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (ozlu2.field_72995_K) {
            return;
        }
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        boolean bl = ozlu2.func_72864_z(n, n2, n3);
        if (bl || n4 > 0 && twgu.field_71973_m[n4].func_71853_i()) {
            if (bl && !kloa._a(n5)) {
                ozlu2.func_72921_c(n, n2, n3, n5 | 4, 2);
                ozlu2.func_72889_a(null, 1003, n, n2, n3, 0);
            } else if (!bl && kloa._a(n5)) {
                ozlu2.func_72921_c(n, n2, n3, n5 & 0xFFFFFFFB, 2);
                ozlu2.func_72889_a(null, 1003, n, n2, n3, 0);
            }
        }
    }

    public static boolean _a(int n) {
        return (n & 4) != 0;
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public void func_94332_a(nege nege2) {
    }
}


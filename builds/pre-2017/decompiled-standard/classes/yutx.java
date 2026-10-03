/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class yutx
extends twgu {
    public dwan _a;
    public dwan _b;
    public dwan _c;

    public yutx(int n) {
        super(n, tflj._E);
        this.func_71907_b(true);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        float f = 0.0625f;
        float f2 = (float)(1 + n4 * 2) / 16.0f;
        float f3 = 0.5f;
        this.func_71905_a(f2, 0.0f, f, 1.0f - f, f3, 1.0f - f);
    }

    @Override
    public void func_71919_f() {
        float f = 0.0625f;
        float f2 = 0.5f;
        this.func_71905_a(f, 0.0f, f, 1.0f - f, f2, 1.0f - f);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        float f = 0.0625f;
        float f2 = (float)(1 + n4 * 2) / 16.0f;
        float f3 = 0.5f;
        return eidj._a()._a((float)n + f2, n2, (float)n3 + f, (float)(n + 1) - f, (float)n2 + f3 - f, (float)(n3 + 1) - f);
    }

    @Override
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        float f = 0.0625f;
        float f2 = (float)(1 + n4 * 2) / 16.0f;
        float f3 = 0.5f;
        return eidj._a()._a((float)n + f2, n2, (float)n3 + f, (float)(n + 1) - f, (float)n2 + f3, (float)(n3 + 1) - f);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1) {
            return this._a;
        }
        if (n == 0) {
            return this._b;
        }
        if (n2 > 0 && n == 4) {
            return this._c;
        }
        return this.field_94336_cN;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
        this._c = nege2._b(this.func_111023_E() + "_inner");
        this._a = nege2._b(this.func_111023_E() + "_top");
        this._b = nege2._b(this.func_111023_E() + "_bottom");
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        this._a(ozlu2, n, n2, n3, entityPlayer);
        return true;
    }

    @Override
    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        this._a(ozlu2, n, n2, n3, entityPlayer);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (entityPlayer.func_71043_e(false)) {
            entityPlayer.func_71024_bL()._a(2, 0.1f);
            int n4 = ozlu2.func_72805_g(n, n2, n3) + 1;
            if (n4 >= 6) {
                ozlu2.func_94571_i(n, n2, n3);
            } else {
                ozlu2.func_72921_c(n, n2, n3, n4, 2);
            }
        }
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        if (!super.func_71930_b(ozlu2, n, n2, n3)) {
            return false;
        }
        return this.func_71854_d(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!this.func_71854_d(ozlu2, n, n2, n3)) {
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72803_f(n, n2 - 1, n3)._a();
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77746_aZ.field_77779_bT;
    }
}


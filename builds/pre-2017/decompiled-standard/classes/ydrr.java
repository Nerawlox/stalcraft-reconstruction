/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;

public class ydrr
extends iwgt {
    public dwan _a;
    public dwan _b;

    public ydrr(int n) {
        super(n, tflj._e);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
        this.func_71868_h(0);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        super.func_71862_a(ozlu2, n, n2, n3, random);
        for (int i = n - 2; i <= n + 2; ++i) {
            block1: for (int j = n3 - 2; j <= n3 + 2; ++j) {
                if (i > n - 2 && i < n + 2 && j == n3 - 1) {
                    j = n3 + 2;
                }
                if (random.nextInt(16) != 0) continue;
                for (int k = n2; k <= n2 + 1; ++k) {
                    if (ozlu2.func_72798_a(i, k, j) != twgu.field_72093_an.field_71990_ca) continue;
                    if (!ozlu2.func_72799_c((i - n) / 2 + n, k, (j - n3) / 2 + n3)) continue block1;
                    ozlu2.func_72869_a("enchantmenttable", (double)n + 0.5, (double)n2 + 2.0, (double)n3 + 0.5, (double)((float)(i - n) + random.nextFloat()) - 0.5, (float)(k - n2) - random.nextFloat() - 1.0f, (double)((float)(j - n3) + random.nextFloat()) - 0.5);
                }
            }
        }
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 0) {
            return this._b;
        }
        if (n == 1) {
            return this._a;
        }
        return this.field_94336_cN;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new mtdr();
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        mtdr mtdr2 = (mtdr)ozlu2.func_72796_p(n, n2, n3);
        entityPlayer.func_71002_c(n, n2, n3, mtdr2._b() ? mtdr2._a() : null);
        return true;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        super.func_71860_a(ozlu2, n, n2, n3, entityLivingBase, cvzo2);
        if (cvzo2._u()) {
            ((mtdr)ozlu2.func_72796_p(n, n2, n3))._a(cvzo2._s());
        }
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_" + "side");
        this._a = nege2._b(this.func_111023_E() + "_" + "top");
        this._b = nege2._b(this.func_111023_E() + "_" + "bottom");
    }
}


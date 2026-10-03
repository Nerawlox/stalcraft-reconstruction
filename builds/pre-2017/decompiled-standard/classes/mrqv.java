/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class mrqv
extends iwgt {
    public mrqv(int n) {
        super(n, tflj._e);
        this.func_71849_a(tgbl.field_78031_c);
        this.func_71905_a(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
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
        return 22;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_72089_ap.field_71990_ca;
    }

    @Override
    public int func_71925_a(Random random) {
        return 8;
    }

    @Override
    public boolean func_71906_q_() {
        return true;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = 0;
        int n5 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
        if (n5 == 0) {
            n4 = 2;
        }
        if (n5 == 1) {
            n4 = 5;
        }
        if (n5 == 2) {
            n4 = 3;
        }
        if (n5 == 3) {
            n4 = 4;
        }
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        tgfn tgfn2 = entityPlayer.func_71005_bN();
        gaqr gaqr2 = (gaqr)ozlu2.func_72796_p(n, n2, n3);
        if (tgfn2 == null || gaqr2 == null) {
            return true;
        }
        if (ozlu2.func_72809_s(n, n2 + 1, n3)) {
            return true;
        }
        if (ozlu2.field_72995_K) {
            return true;
        }
        tgfn2._a(gaqr2);
        entityPlayer.func_71007_a(tgfn2);
        return true;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new gaqr();
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        for (int i = 0; i < 3; ++i) {
            double d = (float)n + random.nextFloat();
            double d2 = (float)n2 + random.nextFloat();
            double d3 = (float)n3 + random.nextFloat();
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            int n4 = random.nextInt(2) * 2 - 1;
            int n5 = random.nextInt(2) * 2 - 1;
            d4 = ((double)random.nextFloat() - 0.5) * 0.125;
            d5 = ((double)random.nextFloat() - 0.5) * 0.125;
            d6 = ((double)random.nextFloat() - 0.5) * 0.125;
            d3 = (double)n3 + 0.5 + 0.25 * (double)n5;
            d6 = random.nextFloat() * 1.0f * (float)n5;
            d = (double)n + 0.5 + 0.25 * (double)n4;
            d4 = random.nextFloat() * 1.0f * (float)n4;
            ozlu2.func_72869_a("portal", d, d2, d3, d4, d5, d6);
        }
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("obsidian");
    }
}


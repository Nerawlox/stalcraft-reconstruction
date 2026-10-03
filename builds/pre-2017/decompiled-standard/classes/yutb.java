/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.player.EntityPlayer;

public class yutb
extends twgu {
    public yutb(int n) {
        super(n, tflj._C);
        this.func_71905_a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        this._a(ozlu2, n, n2, n3);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        if (uilx._b(ozlu2, n, n2 - 1, n3) && n2 >= 0) {
            int n4 = 32;
            if (uilx._e || !ozlu2.func_72904_c(n - n4, n2 - n4, n3 - n4, n + n4, n2 + n4, n3 + n4)) {
                ozlu2.func_94571_i(n, n2, n3);
                while (uilx._b(ozlu2, n, n2 - 1, n3) && n2 > 0) {
                    --n2;
                }
                if (n2 > 0) {
                    ozlu2.func_72832_d(n, n2, n3, this.field_71990_ca, 0, 2);
                }
            } else {
                EntityFallingSand entityFallingSand = new EntityFallingSand(ozlu2, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this.field_71990_ca);
                ozlu2.func_72838_d(entityFallingSand);
            }
        }
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        this._b(ozlu2, n, n2, n3);
        return true;
    }

    @Override
    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        this._b(ozlu2, n, n2, n3);
    }

    public void _b(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72798_a(n, n2, n3) != this.field_71990_ca) {
            return;
        }
        for (int i = 0; i < 1000; ++i) {
            int n4;
            int n5;
            int n6 = n + ozlu2.field_73012_v.nextInt(16) - ozlu2.field_73012_v.nextInt(16);
            if (ozlu2.func_72798_a(n6, n5 = n2 + ozlu2.field_73012_v.nextInt(8) - ozlu2.field_73012_v.nextInt(8), n4 = n3 + ozlu2.field_73012_v.nextInt(16) - ozlu2.field_73012_v.nextInt(16)) != 0) continue;
            if (!ozlu2.field_72995_K) {
                ozlu2.func_72832_d(n6, n5, n4, this.field_71990_ca, ozlu2.func_72805_g(n, n2, n3), 2);
                ozlu2.func_94571_i(n, n2, n3);
            } else {
                int n7 = 128;
                for (int j = 0; j < n7; ++j) {
                    double d = ozlu2.field_73012_v.nextDouble();
                    float f = (ozlu2.field_73012_v.nextFloat() - 0.5f) * 0.2f;
                    float f2 = (ozlu2.field_73012_v.nextFloat() - 0.5f) * 0.2f;
                    float f3 = (ozlu2.field_73012_v.nextFloat() - 0.5f) * 0.2f;
                    double d2 = (double)n6 + (double)(n - n6) * d + (ozlu2.field_73012_v.nextDouble() - 0.5) * 1.0 + 0.5;
                    double d3 = (double)n5 + (double)(n2 - n5) * d + ozlu2.field_73012_v.nextDouble() * 1.0 - 0.5;
                    double d4 = (double)n4 + (double)(n3 - n4) * d + (ozlu2.field_73012_v.nextDouble() - 0.5) * 1.0 + 0.5;
                    ozlu2.func_72869_a("portal", d2, d3, d4, f, f2, f3);
                }
            }
            return;
        }
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 5;
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
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int func_71857_b() {
        return 27;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return 0;
    }
}


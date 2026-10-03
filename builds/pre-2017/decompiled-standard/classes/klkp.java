/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;

public class klkp
extends iwgt {
    public static boolean _a;

    public klkp(int n, tflj tflj2) {
        super(n, tflj2);
        this.func_71900_a(1.0f);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new zziy();
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        float f = 0.0625f;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (n4 != 0) {
            return false;
        }
        return super.func_71877_c(sdrg2, n, n2, n3, n4);
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list, Entity entity) {
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
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if (entity.field_70154_o == null && entity.field_70153_n == null && !ozlu2.field_72995_K) {
            entity.func_71027_c(1);
        }
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        double d = (float)n + random.nextFloat();
        double d2 = (float)n2 + 0.8f;
        double d3 = (float)n3 + random.nextFloat();
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        ozlu2.func_72869_a("smoke", d, d2, d3, d4, d5, d6);
    }

    @Override
    public int func_71857_b() {
        return -1;
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        if (_a) {
            return;
        }
        if (ozlu2.field_73011_w._i != 0) {
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return 0;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("portal");
    }
}


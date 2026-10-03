/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.item.EntityEnderCrystal;

public class cwkj
extends zzpm {
    public int _a;

    public cwkj(int n) {
        this._a = n;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        if (!ozlu2.func_72799_c(n, n2, n3) || ozlu2.func_72798_a(n, n2 - 1, n3) != this._a) {
            return false;
        }
        int n8 = random.nextInt(32) + 6;
        int n9 = random.nextInt(4) + 1;
        for (n7 = n - n9; n7 <= n + n9; ++n7) {
            for (n6 = n3 - n9; n6 <= n3 + n9; ++n6) {
                n5 = n7 - n;
                n4 = n6 - n3;
                if (n5 * n5 + n4 * n4 > n9 * n9 + 1 || ozlu2.func_72798_a(n7, n2 - 1, n6) == this._a) continue;
                return false;
            }
        }
        for (n7 = n2; n7 < n2 + n8 && n7 < 128; ++n7) {
            for (n6 = n - n9; n6 <= n + n9; ++n6) {
                for (n5 = n3 - n9; n5 <= n3 + n9; ++n5) {
                    n4 = n6 - n;
                    int n10 = n5 - n3;
                    if (n4 * n4 + n10 * n10 > n9 * n9 + 1) continue;
                    ozlu2.func_72832_d(n6, n7, n5, twgu.field_72089_ap.field_71990_ca, 0, 2);
                }
            }
        }
        EntityEnderCrystal entityEnderCrystal = new EntityEnderCrystal(ozlu2);
        entityEnderCrystal.func_70012_b((float)n + 0.5f, n2 + n8, (float)n3 + 0.5f, random.nextFloat() * 360.0f, 0.0f);
        ozlu2.func_72838_d(entityEnderCrystal);
        ozlu2.func_72832_d(n, n2 + n8, n3, twgu.field_71986_z.field_71990_ca, 0, 2);
        return true;
    }
}


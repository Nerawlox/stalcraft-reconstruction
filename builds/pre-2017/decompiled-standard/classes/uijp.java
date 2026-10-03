/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.util.dwan;

public class uijp
extends twgu {
    @SideOnly(value=Side.CLIENT)
    public dwan _a;
    @SideOnly(value=Side.CLIENT)
    public dwan _b;

    public uijp(int n) {
        super(n, tflj._b);
        this.func_71907_b(true);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return n == 1 ? this._a : (n == 0 ? twgu.field_71979_v.func_71851_a(n) : this.field_94336_cN);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!ozlu2.field_72995_K) {
            if (ozlu2.func_72957_l(n, n2 + 1, n3) < 4 && ozlu2.getBlockLightOpacity(n, n2 + 1, n3) > 2) {
                ozlu2.func_94575_c(n, n2, n3, twgu.field_71979_v.field_71990_ca);
            } else if (ozlu2.func_72957_l(n, n2 + 1, n3) >= 9) {
                for (int i = 0; i < 4; ++i) {
                    int n4 = n + random.nextInt(3) - 1;
                    int n5 = n2 + random.nextInt(5) - 3;
                    int n6 = n3 + random.nextInt(3) - 1;
                    int n7 = ozlu2.func_72798_a(n4, n5 + 1, n6);
                    if (ozlu2.func_72798_a(n4, n5, n6) != twgu.field_71979_v.field_71990_ca || ozlu2.func_72957_l(n4, n5 + 1, n6) < 4 || ozlu2.getBlockLightOpacity(n4, n5 + 1, n6) > 2) continue;
                    ozlu2.func_94575_c(n4, n5, n6, this.field_71990_ca);
                }
            }
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_71979_v.func_71885_a(0, random, n2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71895_b(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return this._a;
        }
        if (n4 == 0) {
            return twgu.field_71979_v.func_71851_a(n4);
        }
        tflj tflj2 = sdrg2.func_72803_f(n, n2 + 1, n3);
        return tflj2 != tflj._x && tflj2 != tflj._y ? this.field_94336_cN : this._b;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
        this._a = nege2._b(this.func_111023_E() + "_top");
        this._b = nege2._b("grass_side_snowed");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        super.func_71862_a(ozlu2, n, n2, n3, random);
        if (random.nextInt(10) == 0) {
            ozlu2.func_72869_a("townaura", (float)n + random.nextFloat(), (float)n2 + 1.1f, (float)n3 + random.nextFloat(), 0.0, 0.0, 0.0);
        }
    }
}


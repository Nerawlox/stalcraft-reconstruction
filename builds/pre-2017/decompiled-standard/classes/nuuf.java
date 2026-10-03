/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeDirection;

public class nuuf
extends aorr {
    @SideOnly(value=Side.CLIENT)
    public dwan[] _b;

    public nuuf(int n) {
        super(n);
        this.func_71907_b(true);
        float f = 0.5f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.func_71849_a(null);
        this.func_71848_c(0.0f);
        this.func_71884_a(field_71965_g);
        this.func_71896_v();
    }

    @Override
    public boolean _a(int n) {
        return n == twgu.field_72050_aA.field_71990_ca;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        float f;
        int n4;
        super.func_71847_b(ozlu2, n, n2, n3, random);
        if (ozlu2.func_72957_l(n, n2 + 1, n3) >= 9 && (n4 = ozlu2.func_72805_g(n, n2, n3)) < 7 && random.nextInt((int)(25.0f / (f = this._b(ozlu2, n, n2, n3))) + 1) == 0) {
            ozlu2.func_72921_c(n, n2, n3, ++n4, 2);
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3) + sajh._a(ozlu2.field_73012_v, 2, 5);
        if (n4 > 7) {
            n4 = 7;
        }
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    public float _b(ozlu ozlu2, int n, int n2, int n3) {
        float f = 1.0f;
        int n4 = ozlu2.func_72798_a(n, n2, n3 - 1);
        int n5 = ozlu2.func_72798_a(n, n2, n3 + 1);
        int n6 = ozlu2.func_72798_a(n - 1, n2, n3);
        int n7 = ozlu2.func_72798_a(n + 1, n2, n3);
        int n8 = ozlu2.func_72798_a(n - 1, n2, n3 - 1);
        int n9 = ozlu2.func_72798_a(n + 1, n2, n3 - 1);
        int n10 = ozlu2.func_72798_a(n + 1, n2, n3 + 1);
        int n11 = ozlu2.func_72798_a(n - 1, n2, n3 + 1);
        boolean bl = n6 == this.field_71990_ca || n7 == this.field_71990_ca;
        boolean bl2 = n4 == this.field_71990_ca || n5 == this.field_71990_ca;
        boolean bl3 = n8 == this.field_71990_ca || n9 == this.field_71990_ca || n10 == this.field_71990_ca || n11 == this.field_71990_ca;
        for (int i = n - 1; i <= n + 1; ++i) {
            for (int j = n3 - 1; j <= n3 + 1; ++j) {
                int n12 = ozlu2.func_72798_a(i, n2 - 1, j);
                float f2 = 0.0f;
                if (field_71973_m[n12] != null && field_71973_m[n12].canSustainPlant(ozlu2, i, n2 - 1, j, ForgeDirection.UP, this)) {
                    f2 = 1.0f;
                    if (field_71973_m[n12].isFertile(ozlu2, i, n2 - 1, j)) {
                        f2 = 3.0f;
                    }
                }
                if (i != n || j != n3) {
                    f2 /= 4.0f;
                }
                f += f2;
            }
        }
        if (bl3 || bl && bl2) {
            f /= 2.0f;
        }
        return f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        if (n2 < 0 || n2 > 7) {
            n2 = 7;
        }
        return this._b[n2];
    }

    @Override
    public int func_71857_b() {
        return 6;
    }

    public int _a() {
        return tgdv.field_77690_S.field_77779_bT;
    }

    public int _b() {
        return tgdv.field_77685_T.field_77779_bT;
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, 0);
    }

    @Override
    public ArrayList<cvzo> getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<cvzo> arrayList = super.getBlockDropped(ozlu2, n, n2, n3, n4, n5);
        if (n4 >= 7) {
            for (int i = 0; i < 3 + n5; ++i) {
                if (ozlu2.field_73012_v.nextInt(15) > n4) continue;
                arrayList.add(new cvzo(this._a(), 1, 0));
            }
        }
        return arrayList;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return n == 7 ? this._b() : this._a();
    }

    @Override
    public int func_71925_a(Random random) {
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return this._a();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._b = new dwan[8];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = nege2._b(this.func_111023_E() + "_stage_" + i);
        }
    }
}


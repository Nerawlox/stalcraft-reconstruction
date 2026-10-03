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

public class xati
extends aorr {
    public final twgu _a;
    @SideOnly(value=Side.CLIENT)
    public dwan _b;

    public xati(int n, twgu twgu2) {
        super(n);
        this._a = twgu2;
        this.func_71907_b(true);
        float f = 0.125f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.func_71849_a(null);
    }

    @Override
    public boolean _a(int n) {
        return n == twgu.field_72050_aA.field_71990_ca;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        float f;
        super.func_71847_b(ozlu2, n, n2, n3, random);
        if (ozlu2.func_72957_l(n, n2 + 1, n3) >= 9 && random.nextInt((int)(25.0f / (f = this._b(ozlu2, n, n2, n3))) + 1) == 0) {
            int n4 = ozlu2.func_72805_g(n, n2, n3);
            if (n4 < 7) {
                ozlu2.func_72921_c(n, n2, n3, ++n4, 2);
            } else {
                int n5;
                boolean bl;
                if (ozlu2.func_72798_a(n - 1, n2, n3) == this._a.field_71990_ca) {
                    return;
                }
                if (ozlu2.func_72798_a(n + 1, n2, n3) == this._a.field_71990_ca) {
                    return;
                }
                if (ozlu2.func_72798_a(n, n2, n3 - 1) == this._a.field_71990_ca) {
                    return;
                }
                if (ozlu2.func_72798_a(n, n2, n3 + 1) == this._a.field_71990_ca) {
                    return;
                }
                int n6 = random.nextInt(4);
                int n7 = n;
                int n8 = n3;
                if (n6 == 0) {
                    n7 = n - 1;
                }
                if (n6 == 1) {
                    ++n7;
                }
                if (n6 == 2) {
                    n8 = n3 - 1;
                }
                if (n6 == 3) {
                    ++n8;
                }
                boolean bl2 = bl = field_71973_m[n5 = ozlu2.func_72798_a(n7, n2 - 1, n8)] != null && field_71973_m[n5].canSustainPlant(ozlu2, n7, n2 - 1, n8, ForgeDirection.UP, this);
                if (ozlu2.func_72799_c(n7, n2, n8) && (bl || n5 == twgu.field_71979_v.field_71990_ca || n5 == twgu.field_71980_u.field_71990_ca)) {
                    ozlu2.func_94575_c(n7, n2, n8, this._a.field_71990_ca);
                }
            }
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
    public int func_71889_f_(int n) {
        int n2 = n * 32;
        int n3 = 255 - n * 8;
        int n4 = n * 4;
        return n2 << 16 | n3 << 8 | n4;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        return this.func_71889_f_(sdrg2.func_72805_g(n, n2, n3));
    }

    @Override
    public void func_71919_f() {
        float f = 0.125f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this.field_72022_cl = (float)(sdrg2.func_72805_g(n, n2, n3) * 2 + 2) / 16.0f;
        float f = 0.125f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, (float)this.field_72022_cl, 0.5f + f);
    }

    @Override
    public int func_71857_b() {
        return 19;
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        return n4 < 7 ? -1 : (sdrg2.func_72798_a(n - 1, n2, n3) == this._a.field_71990_ca ? 0 : (sdrg2.func_72798_a(n + 1, n2, n3) == this._a.field_71990_ca ? 1 : (sdrg2.func_72798_a(n, n2, n3 - 1) == this._a.field_71990_ca ? 2 : (sdrg2.func_72798_a(n, n2, n3 + 1) == this._a.field_71990_ca ? 3 : -1))));
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, n5);
    }

    @Override
    public ArrayList<cvzo> getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        for (int i = 0; i < 3; ++i) {
            if (ozlu2.field_73012_v.nextInt(15) > n4) continue;
            arrayList.add(new cvzo(this._a == field_72061_ba ? tgdv.field_77739_bg : tgdv.field_77740_bh));
        }
        return arrayList;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return -1;
    }

    @Override
    public int func_71925_a(Random random) {
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return this._a == twgu.field_72061_ba ? tgdv.field_77739_bg.field_77779_bT : (this._a == twgu.field_71997_br ? tgdv.field_77740_bh.field_77779_bT : 0);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_disconnected");
        this._b = nege2._b(this.func_111023_E() + "_connected");
    }

    @SideOnly(value=Side.CLIENT)
    public dwan _a() {
        return this._b;
    }
}


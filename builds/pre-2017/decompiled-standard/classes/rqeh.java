/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.util.dwan;
import net.minecraftforge.event.terraingen.TerrainGen;

public class rqeh
extends aorr {
    public static final String[] _a = new String[]{"oak", "spruce", "birch", "jungle"};
    @SideOnly(value=Side.CLIENT)
    public dwan[] _b;

    public rqeh(int n) {
        super(n);
        float f = 0.4f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!ozlu2.field_72995_K) {
            super.func_71847_b(ozlu2, n, n2, n3, random);
            if (ozlu2.func_72957_l(n, n2 + 1, n3) >= 9 && random.nextInt(7) == 0) {
                this._a(ozlu2, n, n2, n3, random);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return this._b[n2 &= 3];
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if ((n4 & 8) == 0) {
            ozlu2.func_72921_c(n, n2, n3, n4 | 8, 4);
        } else {
            this._b(ozlu2, n, n2, n3, random);
        }
    }

    public void _b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!TerrainGen.saplingGrowTree(ozlu2, random, n, n2, n3)) {
            return;
        }
        int n4 = ozlu2.func_72805_g(n, n2, n3) & 3;
        zzpm zzpm2 = null;
        int n5 = 0;
        int n6 = 0;
        boolean bl = false;
        if (n4 == 1) {
            zzpm2 = new nwmw(true);
        } else if (n4 == 2) {
            zzpm2 = new nwjr(true);
        } else if (n4 == 3) {
            for (n5 = 0; n5 >= -1; --n5) {
                for (n6 = 0; n6 >= -1; --n6) {
                    if (!this._a(ozlu2, n + n5, n2, n3 + n6, 3) || !this._a(ozlu2, n + n5 + 1, n2, n3 + n6, 3) || !this._a(ozlu2, n + n5, n2, n3 + n6 + 1, 3) || !this._a(ozlu2, n + n5 + 1, n2, n3 + n6 + 1, 3)) continue;
                    zzpm2 = new mtgt(true, 10 + random.nextInt(20), 3, 3);
                    bl = true;
                    break;
                }
                if (zzpm2 != null) break;
            }
            if (zzpm2 == null) {
                n6 = 0;
                n5 = 0;
                zzpm2 = new dzqi(true, 4 + random.nextInt(7), 3, 3, false);
            }
        } else {
            zzpm2 = new dzqi(true);
            if (random.nextInt(10) == 0) {
                zzpm2 = new nfiu(true);
            }
        }
        if (bl) {
            ozlu2.func_72832_d(n + n5, n2, n3 + n6, 0, 0, 4);
            ozlu2.func_72832_d(n + n5 + 1, n2, n3 + n6, 0, 0, 4);
            ozlu2.func_72832_d(n + n5, n2, n3 + n6 + 1, 0, 0, 4);
            ozlu2.func_72832_d(n + n5 + 1, n2, n3 + n6 + 1, 0, 0, 4);
        } else {
            ozlu2.func_72832_d(n, n2, n3, 0, 0, 4);
        }
        if (!((zzpm)zzpm2)._a(ozlu2, random, n + n5, n2, n3 + n6)) {
            if (bl) {
                ozlu2.func_72832_d(n + n5, n2, n3 + n6, this.field_71990_ca, n4, 4);
                ozlu2.func_72832_d(n + n5 + 1, n2, n3 + n6, this.field_71990_ca, n4, 4);
                ozlu2.func_72832_d(n + n5, n2, n3 + n6 + 1, this.field_71990_ca, n4, 4);
                ozlu2.func_72832_d(n + n5 + 1, n2, n3 + n6 + 1, this.field_71990_ca, n4, 4);
            } else {
                ozlu2.func_72832_d(n, n2, n3, this.field_71990_ca, n4, 4);
            }
        }
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca && (ozlu2.func_72805_g(n, n2, n3) & 3) == n4;
    }

    @Override
    public int func_71899_b(int n) {
        return n & 3;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71879_a(int n, tgbl tgbl2, List list) {
        list.add(new cvzo(n, 1, 0));
        list.add(new cvzo(n, 1, 1));
        list.add(new cvzo(n, 1, 2));
        list.add(new cvzo(n, 1, 3));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._b = new dwan[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = nege2._b(this.func_111023_E() + "_" + _a[i]);
        }
    }
}


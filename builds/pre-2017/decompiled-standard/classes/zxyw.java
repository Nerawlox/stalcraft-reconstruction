/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.util.dwan;

public class zxyw
extends uznj {
    public static final String[] _a = new String[]{"oak", "spruce", "birch", "jungle"};
    @SideOnly(value=Side.CLIENT)
    public dwan[] _b;
    @SideOnly(value=Side.CLIENT)
    public dwan[] _c;

    public zxyw(int n) {
        super(n, tflj._d);
        this.func_71849_a(tgbl.field_78030_b);
    }

    @Override
    public int func_71925_a(Random random) {
        return 1;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_71951_J.field_71990_ca;
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        int n6 = 4;
        int n7 = n6 + 1;
        if (ozlu2.func_72904_c(n - n7, n2 - n7, n3 - n7, n + n7, n2 + n7, n3 + n7)) {
            for (int i = -n6; i <= n6; ++i) {
                for (int j = -n6; j <= n6; ++j) {
                    for (int k = -n6; k <= n6; ++k) {
                        int n8 = ozlu2.func_72798_a(n + i, n2 + j, n3 + k);
                        if (twgu.field_71973_m[n8] == null) continue;
                        twgu.field_71973_m[n8].beginLeavesDecay(ozlu2, n + i, n2 + j, n3 + k);
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan _a(int n) {
        return this._b[n];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan _b(int n) {
        return this._c[n];
    }

    public static int _c(int n) {
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
        this._c = new dwan[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = nege2._b(this.func_111023_E() + "_" + _a[i]);
            this._c[i] = nege2._b(this.func_111023_E() + "_" + _a[i] + "_top");
        }
    }

    @Override
    public boolean canSustainLeaves(ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }

    @Override
    public boolean isWood(ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }
}


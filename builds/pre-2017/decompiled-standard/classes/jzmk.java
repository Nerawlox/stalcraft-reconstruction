/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.Random;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public class jzmk
extends twgu {
    @SideOnly(value=Side.CLIENT)
    public dwan _a;
    @SideOnly(value=Side.CLIENT)
    public dwan _b;
    @SideOnly(value=Side.CLIENT)
    public dwan _c;

    public jzmk(int n) {
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
        GloomyHooks.updateTick(this, ozlu2, n, n2, n3, random);
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
        BlockRendererList.onRegisterIconsHook(this, nege2);
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
        this._a = nege2._b(this.func_111023_E() + "_top");
        this._b = nege2._b(this.func_111023_E() + "_side_snowed");
        this._c = nege2._b(this.func_111023_E() + "_side_overlay");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71933_m() {
        double d = 0.5;
        double d2 = 1.0;
        return gapq._a(d, d2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71889_f_(int n) {
        return this.func_71933_m();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int n7 = sdrg2.func_72807_a(n + j, n3 + i)._l();
                n4 += (n7 & 0xFF0000) >> 16;
                n5 += (n7 & 0xFF00) >> 8;
                n6 += n7 & 0xFF;
            }
        }
        return (n4 / 9 & 0xFF) << 16 | (n5 / 9 & 0xFF) << 8 | n6 / 9 & 0xFF;
    }

    @SideOnly(value=Side.CLIENT)
    public static dwan _a() {
        return twgu.field_71980_u._c;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class zgzq
extends twgu {
    public zgzq(int n) {
        super(n, tflj._x);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.func_71907_b(true);
        this.func_71849_a(tgbl.field_78031_c);
        this._a(0);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("snow");
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3) & 7;
        float f = 0.125f;
        return eidj._a()._a((double)n + this.field_72026_ch, (double)n2 + this.field_72023_ci, (double)n3 + this.field_72024_cj, (double)n + this.field_72021_ck, (float)n2 + (float)n4 * f, (double)n3 + this.field_72019_cm);
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
    public void func_71919_f() {
        this._a(0);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this._a(sdrg2.func_72805_g(n, n2, n3));
    }

    public void _a(int n) {
        int n2 = n & 7;
        float f = (float)(2 * (1 + n2)) / 16.0f;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72798_a(n, n2 - 1, n3);
        twgu twgu2 = twgu.field_71973_m[n4];
        if (twgu2 == null) {
            return false;
        }
        if (twgu2 == this && (ozlu2.func_72805_g(n, n2 - 1, n3) & 7) == 7) {
            return true;
        }
        if (!twgu2.isLeaves(ozlu2, n, n2 - 1, n3) && !twgu.field_71973_m[n4].func_71926_d()) {
            return false;
        }
        return ozlu2.func_72803_f(n, n2 - 1, n3)._c();
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._a(ozlu2, n, n2, n3);
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        if (!this.func_71930_b(ozlu2, n, n2, n3)) {
            ozlu2.func_94571_i(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public void func_71893_a(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        super.func_71893_a(ozlu2, entityPlayer, n, n2, n3, n4);
        ozlu2.func_94571_i(n, n2, n3);
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77768_aD.field_77779_bT;
    }

    @Override
    public int func_71925_a(Random random) {
        return 1;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.func_72972_b(rrqi._b, n, n2, n3) > 11) {
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return n4 == 1 ? true : super.func_71877_c(sdrg2, n, n2, n3, n4);
    }

    @Override
    public int quantityDropped(int n, int n2, Random random) {
        return (n & 7) + 1;
    }

    @Override
    public boolean isBlockReplaceable(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        return n4 >= 7 ? false : this.field_72018_cp._j();
    }
}


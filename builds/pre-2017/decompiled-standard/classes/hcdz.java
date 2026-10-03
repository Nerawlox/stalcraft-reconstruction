/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;

public class hcdz
extends iwgt {
    public dwan _a;

    public hcdz(int n) {
        super(n, tflj._d);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1) {
            return this._a;
        }
        return this.field_94336_cN;
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.func_72805_g(n, n2, n3) == 0) {
            return false;
        }
        this._a(ozlu2, n, n2, n3);
        return true;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, cvzo cvzo2) {
        if (ozlu2.field_72995_K) {
            return;
        }
        xcbe xcbe2 = (xcbe)ozlu2.func_72796_p(n, n2, n3);
        if (xcbe2 == null) {
            return;
        }
        xcbe2._a(cvzo2._l());
        ozlu2.func_72921_c(n, n2, n3, 1, 2);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.field_72995_K) {
            return;
        }
        xcbe xcbe2 = (xcbe)ozlu2.func_72796_p(n, n2, n3);
        if (xcbe2 == null) {
            return;
        }
        cvzo cvzo2 = xcbe2._a();
        if (cvzo2 == null) {
            return;
        }
        ozlu2.func_72926_e(1005, n, n2, n3, 0);
        ozlu2.func_72934_a(null, n, n2, n3);
        xcbe2._a(null);
        ozlu2.func_72921_c(n, n2, n3, 0, 2);
        float f = 0.7f;
        double d = (double)(ozlu2.field_73012_v.nextFloat() * f) + (double)(1.0f - f) * 0.5;
        double d2 = (double)(ozlu2.field_73012_v.nextFloat() * f) + (double)(1.0f - f) * 0.2 + 0.6;
        double d3 = (double)(ozlu2.field_73012_v.nextFloat() * f) + (double)(1.0f - f) * 0.5;
        cvzo cvzo3 = cvzo2._l();
        EntityItem entityItem = new EntityItem(ozlu2, (double)n + d, (double)n2 + d2, (double)n3 + d3, cvzo3);
        entityItem.field_70293_c = 10;
        ozlu2.func_72838_d(entityItem);
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        this._a(ozlu2, n, n2, n3);
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        if (ozlu2.field_72995_K) {
            return;
        }
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, 0);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new xcbe();
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
        this._a = nege2._b(this.func_111023_E() + "_top");
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        cvzo cvzo2 = ((xcbe)ozlu2.func_72796_p(n, n2, n3))._a();
        return cvzo2 == null ? 0 : cvzo2._d + 1 - tgdv.field_77819_bI.field_77779_bT;
    }
}


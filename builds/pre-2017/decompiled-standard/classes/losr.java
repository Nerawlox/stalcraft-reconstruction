/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class losr
extends twgu {
    public boolean _a;

    public losr(int n, boolean bl) {
        super(n, tflj._e);
        if (bl) {
            this.func_71907_b(true);
        }
        this._a = bl;
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 30;
    }

    @Override
    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        this._a(ozlu2, n, n2, n3);
        super.func_71921_a(ozlu2, n, n2, n3, entityPlayer);
    }

    @Override
    public void func_71891_b(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        this._a(ozlu2, n, n2, n3);
        super.func_71891_b(ozlu2, n, n2, n3, entity);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        this._a(ozlu2, n, n2, n3);
        return super.func_71903_a(ozlu2, n, n2, n3, entityPlayer, n4, f, f2, f3);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        this._b(ozlu2, n, n2, n3);
        if (this.field_71990_ca == twgu.field_72047_aN.field_71990_ca) {
            ozlu2.func_94575_c(n, n2, n3, twgu.field_72048_aO.field_71990_ca);
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (this.field_71990_ca == twgu.field_72048_aO.field_71990_ca) {
            ozlu2.func_94575_c(n, n2, n3, twgu.field_72047_aN.field_71990_ca);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77767_aC.field_77779_bT;
    }

    @Override
    public int func_71910_a(int n, Random random) {
        return this.func_71925_a(random) + random.nextInt(n + 1);
    }

    @Override
    public int func_71925_a(Random random) {
        return 4 + random.nextInt(2);
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, n5);
    }

    @Override
    public int getExpDrop(ozlu ozlu2, int n, int n2) {
        if (this.func_71885_a(n, ozlu2.field_73012_v, n2) != this.field_71990_ca) {
            int n3 = 1 + ozlu2.field_73012_v.nextInt(5);
            return n3;
        }
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (this._a) {
            this._b(ozlu2, n, n2, n3);
        }
    }

    public void _b(ozlu ozlu2, int n, int n2, int n3) {
        Random random = ozlu2.field_73012_v;
        double d = 0.0625;
        for (int i = 0; i < 6; ++i) {
            double d2 = (float)n + random.nextFloat();
            double d3 = (float)n2 + random.nextFloat();
            double d4 = (float)n3 + random.nextFloat();
            if (i == 0 && !ozlu2.func_72804_r(n, n2 + 1, n3)) {
                d3 = (double)(n2 + 1) + d;
            }
            if (i == 1 && !ozlu2.func_72804_r(n, n2 - 1, n3)) {
                d3 = (double)(n2 + 0) - d;
            }
            if (i == 2 && !ozlu2.func_72804_r(n, n2, n3 + 1)) {
                d4 = (double)(n3 + 1) + d;
            }
            if (i == 3 && !ozlu2.func_72804_r(n, n2, n3 - 1)) {
                d4 = (double)(n3 + 0) - d;
            }
            if (i == 4 && !ozlu2.func_72804_r(n + 1, n2, n3)) {
                d2 = (double)(n + 1) + d;
            }
            if (i == 5 && !ozlu2.func_72804_r(n - 1, n2, n3)) {
                d2 = (double)(n + 0) - d;
            }
            if (!(d2 < (double)n || d2 > (double)(n + 1) || d3 < 0.0 || d3 > (double)(n2 + 1) || d4 < (double)n3) && !(d4 > (double)(n3 + 1))) continue;
            ozlu2.func_72869_a("reddust", d2, d3, d4, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public cvzo func_71880_c_(int n) {
        return new cvzo(twgu.field_72047_aN);
    }
}


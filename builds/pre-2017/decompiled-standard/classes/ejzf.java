/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class ejzf
extends twgu {
    @SideOnly(value=Side.CLIENT)
    public dwan _a;
    @SideOnly(value=Side.CLIENT)
    public dwan _b;

    public ejzf(int n) {
        super(n, tflj._c);
        this.func_71907_b(true);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        this.func_71868_h(255);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return eidj._a()._a(n + 0, n2 + 0, n3 + 0, n + 1, n2 + 1, n3 + 1);
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
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return n == 1 ? (n2 > 0 ? this._a : this._b) : twgu.field_71979_v.func_71851_a(n);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!this._b(ozlu2, n, n2, n3) && !ozlu2.func_72951_B(n, n2 + 1, n3)) {
            int n4 = ozlu2.func_72805_g(n, n2, n3);
            if (n4 > 0) {
                ozlu2.func_72921_c(n, n2, n3, n4 - 1, 2);
            } else if (!this._a(ozlu2, n, n2, n3)) {
                ozlu2.func_94575_c(n, n2, n3, twgu.field_71979_v.field_71990_ca);
            }
        } else {
            ozlu2.func_72921_c(n, n2, n3, 7, 2);
        }
    }

    @Override
    public void func_71866_a(ozlu ozlu2, int n, int n2, int n3, Entity entity, float f) {
        if (!ozlu2.field_72995_K && ozlu2.field_73012_v.nextFloat() < f - 0.5f) {
            if (!(entity instanceof EntityPlayer) && !ozlu2.func_82736_K()._b("mobGriefing")) {
                return;
            }
            ozlu2.func_94575_c(n, n2, n3, twgu.field_71979_v.field_71990_ca);
        }
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = 0;
        for (int i = n - n4; i <= n + n4; ++i) {
            for (int j = n3 - n4; j <= n3 + n4; ++j) {
                int n5 = ozlu2.func_72798_a(i, n2 + 1, j);
                twgu twgu2 = field_71973_m[n5];
                if (!(twgu2 instanceof IPlantable) || !this.canSustainPlant(ozlu2, n, n2, n3, ForgeDirection.UP, (IPlantable)((Object)twgu2))) continue;
                return true;
            }
        }
        return false;
    }

    public boolean _b(ozlu ozlu2, int n, int n2, int n3) {
        for (int i = n - 4; i <= n + 4; ++i) {
            for (int j = n2; j <= n2 + 1; ++j) {
                for (int k = n3 - 4; k <= n3 + 4; ++k) {
                    if (ozlu2.func_72803_f(i, j, k) != tflj._h) continue;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        super.func_71863_a(ozlu2, n, n2, n3, n4);
        tflj tflj2 = ozlu2.func_72803_f(n, n2 + 1, n3);
        if (tflj2._a()) {
            ozlu2.func_94575_c(n, n2, n3, twgu.field_71979_v.field_71990_ca);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_71979_v.func_71885_a(0, random, n2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return twgu.field_71979_v.field_71990_ca;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._a = nege2._b(this.func_111023_E() + "_wet");
        this._b = nege2._b(this.func_111023_E() + "_dry");
    }
}


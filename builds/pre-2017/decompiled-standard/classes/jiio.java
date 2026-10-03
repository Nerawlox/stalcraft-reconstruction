/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.jxtc;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class jiio
extends twgu
implements IPlantable {
    @SideOnly(value=Side.CLIENT)
    public dwan _a;
    @SideOnly(value=Side.CLIENT)
    public dwan _b;

    public jiio(int n) {
        super(n, tflj._z);
        this.func_71907_b(true);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.func_72799_c(n, n2 + 1, n3)) {
            int n4 = 1;
            while (ozlu2.func_72798_a(n, n2 - n4, n3) == this.field_71990_ca) {
                ++n4;
            }
            if (n4 < 3) {
                int n5 = ozlu2.func_72805_g(n, n2, n3);
                if (n5 == 15) {
                    ozlu2.func_94575_c(n, n2 + 1, n3, this.field_71990_ca);
                    ozlu2.func_72921_c(n, n2, n3, 0, 4);
                    this.func_71863_a(ozlu2, n, n2 + 1, n3, this.field_71990_ca);
                } else {
                    ozlu2.func_72921_c(n, n2, n3, n5 + 1, 4);
                }
            }
        }
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        float f = 0.0625f;
        return eidj._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, (float)(n2 + 1) - f, (float)(n3 + 1) - f);
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        float f = 0.0625f;
        return eidj._a()._a((float)n + f, n2, (float)n3 + f, (float)(n + 1) - f, n2 + 1, (float)(n3 + 1) - f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return n == 1 ? this._a : (n == 0 ? this._b : this.field_94336_cN);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 13;
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return !super.func_71930_b(ozlu2, n, n2, n3) ? false : this.func_71854_d(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!this.func_71854_d(ozlu2, n, n2, n3)) {
            ozlu2.func_94578_a(n, n2, n3, true);
        }
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72803_f(n - 1, n2, n3)._a()) {
            return false;
        }
        if (ozlu2.func_72803_f(n + 1, n2, n3)._a()) {
            return false;
        }
        if (ozlu2.func_72803_f(n, n2, n3 - 1)._a()) {
            return false;
        }
        if (ozlu2.func_72803_f(n, n2, n3 + 1)._a()) {
            return false;
        }
        int n4 = ozlu2.func_72798_a(n, n2 - 1, n3);
        return field_71973_m[n4] != null && field_71973_m[n4].canSustainPlant(ozlu2, n, n2 - 1, n3, ForgeDirection.UP, this);
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        entity.func_70097_a(jxtc.field_76367_g, 1.0f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
        this._a = nege2._b(this.func_111023_E() + "_top");
        this._b = nege2._b(this.func_111023_E() + "_bottom");
    }

    @Override
    public EnumPlantType getPlantType(ozlu ozlu2, int n, int n2, int n3) {
        return EnumPlantType.Desert;
    }

    @Override
    public int getPlantID(ozlu ozlu2, int n, int n2, int n3) {
        return this.field_71990_ca;
    }

    @Override
    public int getPlantMetadata(ozlu ozlu2, int n, int n2, int n3) {
        return -1;
    }
}


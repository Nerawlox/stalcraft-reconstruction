/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.Random;
import net.minecraft.util.eidj;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class aorr
extends twgu
implements IPlantable {
    public aorr(int n, tflj tflj2) {
        super(n, tflj2);
        this.func_71907_b(true);
        float f = 0.2f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 3.0f, 0.5f + f);
        this.func_71849_a(tgbl.field_78031_c);
    }

    public aorr(int n) {
        this(n, tflj._k);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return super.func_71930_b(ozlu2, n, n2, n3) && this.func_71854_d(ozlu2, n, n2, n3);
    }

    public boolean _a(int n) {
        return n == twgu.field_71980_u.field_71990_ca || n == twgu.field_71979_v.field_71990_ca || n == twgu.field_72050_aA.field_71990_ca;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        super.func_71863_a(ozlu2, n, n2, n3, n4);
        this._c(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        this._c(ozlu2, n, n2, n3);
    }

    public final void _c(ozlu ozlu2, int n, int n2, int n3) {
        if (!this.func_71854_d(ozlu2, n, n2, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_72832_d(n, n2, n3, 0, 0, 2);
        }
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        GloomyHooks.canBlockStay(this, ozlu2, n, n2, n3);
        return true;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
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
    public int func_71857_b() {
        int n = GloomyHooks.getRenderType(this);
        return n;
    }

    @Override
    public EnumPlantType getPlantType(ozlu ozlu2, int n, int n2, int n3) {
        if (this.field_71990_ca == aorr.field_72058_az.field_71990_ca) {
            return EnumPlantType.Crop;
        }
        if (this.field_71990_ca == aorr.field_71961_Y.field_71990_ca) {
            return EnumPlantType.Desert;
        }
        if (this.field_71990_ca == aorr.field_71991_bz.field_71990_ca) {
            return EnumPlantType.Water;
        }
        if (this.field_71990_ca == aorr.field_72103_ag.field_71990_ca) {
            return EnumPlantType.Cave;
        }
        if (this.field_71990_ca == aorr.field_72109_af.field_71990_ca) {
            return EnumPlantType.Cave;
        }
        if (this.field_71990_ca == aorr.field_72094_bD.field_71990_ca) {
            return EnumPlantType.Nether;
        }
        if (this.field_71990_ca == aorr.field_71987_y.field_71990_ca) {
            return EnumPlantType.Plains;
        }
        if (this.field_71990_ca == aorr.field_71999_bt.field_71990_ca) {
            return EnumPlantType.Crop;
        }
        if (this.field_71990_ca == aorr.field_71996_bs.field_71990_ca) {
            return EnumPlantType.Crop;
        }
        if (this.field_71990_ca == aorr.field_71962_X.field_71990_ca) {
            return EnumPlantType.Plains;
        }
        return EnumPlantType.Plains;
    }

    @Override
    public int getPlantID(ozlu ozlu2, int n, int n2, int n3) {
        return this.field_71990_ca;
    }

    @Override
    public int getPlantMetadata(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72805_g(n, n2, n3);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.util.eidj;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class sthg
extends twgu
implements IPlantable {
    public sthg(int n) {
        super(n, tflj._k);
        float f = 0.375f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
        this.func_71907_b(true);
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
                } else {
                    ozlu2.func_72921_c(n, n2, n3, n5 + 1, 4);
                }
            }
        }
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2 - 1, n3)];
        return twgu2 != null && twgu2.canSustainPlant(ozlu2, n, n2 - 1, n3, ForgeDirection.UP, this);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._a(ozlu2, n, n2, n3);
    }

    public final void _a(ozlu ozlu2, int n, int n2, int n3) {
        if (!this.func_71854_d(ozlu2, n, n2, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        return this.func_71930_b(ozlu2, n, n2, n3);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77758_aJ.field_77779_bT;
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
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77758_aJ.field_77779_bT;
    }

    @Override
    public EnumPlantType getPlantType(ozlu ozlu2, int n, int n2, int n3) {
        return EnumPlantType.Beach;
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


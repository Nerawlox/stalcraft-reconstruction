/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class htgl
extends twgu {
    public final String _a;

    public htgl(int n, String string, tflj tflj2) {
        super(n, tflj2);
        this._a = string;
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list, Entity entity) {
        boolean bl = this._a(ozlu2, n, n2, n3 - 1);
        boolean bl2 = this._a(ozlu2, n, n2, n3 + 1);
        boolean bl3 = this._a(ozlu2, n - 1, n2, n3);
        boolean bl4 = this._a(ozlu2, n + 1, n2, n3);
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.375f;
        float f4 = 0.625f;
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        if (bl || bl2) {
            this.func_71905_a(f, 0.0f, f3, f2, 1.5f, f4);
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        }
        f3 = 0.375f;
        f4 = 0.625f;
        if (bl3) {
            f = 0.0f;
        }
        if (bl4) {
            f2 = 1.0f;
        }
        if (bl3 || bl4 || !bl && !bl2) {
            this.func_71905_a(f, 0.0f, f3, f2, 1.5f, f4);
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        }
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        this.func_71905_a(f, 0.0f, f3, f2, 1.0f, f4);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        boolean bl = this._a(sdrg2, n, n2, n3 - 1);
        boolean bl2 = this._a(sdrg2, n, n2, n3 + 1);
        boolean bl3 = this._a(sdrg2, n - 1, n2, n3);
        boolean bl4 = this._a(sdrg2, n + 1, n2, n3);
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.375f;
        float f4 = 0.625f;
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        if (bl3) {
            f = 0.0f;
        }
        if (bl4) {
            f2 = 1.0f;
        }
        this.func_71905_a(f, 0.0f, f3, f2, 1.0f, f4);
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
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 11;
    }

    public boolean _a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72798_a(n, n2, n3);
        if (n4 == this.field_71990_ca || n4 == twgu.field_71993_bv.field_71990_ca) {
            return true;
        }
        twgu twgu2 = twgu.field_71973_m[n4];
        if (twgu2 != null && twgu2.field_72018_cp._k() && twgu2.func_71886_c()) {
            return twgu2.field_72018_cp != tflj._B;
        }
        return false;
    }

    public static boolean _a(int n) {
        return n == twgu.field_72031_aZ.field_71990_ca || n == twgu.field_72098_bB.field_71990_ca;
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this._a);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        return bsut._a(entityPlayer, ozlu2, n, n2, n3);
    }
}


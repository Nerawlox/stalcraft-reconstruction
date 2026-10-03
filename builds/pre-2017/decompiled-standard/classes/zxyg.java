/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraftforge.common.ForgeDirection;

public class zxyg
extends twgu {
    public final String _a;
    public final boolean _b;
    public final String _c;
    @SideOnly(value=Side.CLIENT)
    public dwan _d;

    public zxyg(int n, String string, String string2, tflj tflj2, boolean bl) {
        super(n, tflj2);
        this._a = string2;
        this._b = bl;
        this._c = string;
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return !this._b ? 0 : super.func_71885_a(n, random, n2);
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
        return 18;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = sdrg2.func_72798_a(n, n2, n3);
        return n5 == this.field_71990_ca ? false : super.func_71877_c(sdrg2, n, n2, n3, n4);
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        boolean bl = this._a(ozlu2, n, n2, n3, ForgeDirection.NORTH);
        boolean bl2 = this._a(ozlu2, n, n2, n3, ForgeDirection.SOUTH);
        boolean bl3 = this._a(ozlu2, n, n2, n3, ForgeDirection.WEST);
        boolean bl4 = this._a(ozlu2, n, n2, n3, ForgeDirection.EAST);
        if ((!bl3 || !bl4) && (bl3 || bl4 || bl || bl2)) {
            if (bl3 && !bl4) {
                this.func_71905_a(0.0f, 0.0f, 0.4375f, 0.5f, 1.0f, 0.5625f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
            } else if (!bl3 && bl4) {
                this.func_71905_a(0.5f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
            }
        } else {
            this.func_71905_a(0.0f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        }
        if ((!bl || !bl2) && (bl3 || bl4 || bl || bl2)) {
            if (bl && !bl2) {
                this.func_71905_a(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 0.5f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
            } else if (!bl && bl2) {
                this.func_71905_a(0.4375f, 0.0f, 0.5f, 0.5625f, 1.0f, 1.0f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
            }
        } else {
            this.func_71905_a(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 1.0f);
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        }
    }

    @Override
    public void func_71919_f() {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        float f = 0.4375f;
        float f2 = 0.5625f;
        float f3 = 0.4375f;
        float f4 = 0.5625f;
        boolean bl = this._a(sdrg2, n, n2, n3, ForgeDirection.NORTH);
        boolean bl2 = this._a(sdrg2, n, n2, n3, ForgeDirection.SOUTH);
        boolean bl3 = this._a(sdrg2, n, n2, n3, ForgeDirection.WEST);
        boolean bl4 = this._a(sdrg2, n, n2, n3, ForgeDirection.EAST);
        if ((!bl3 || !bl4) && (bl3 || bl4 || bl || bl2)) {
            if (bl3 && !bl4) {
                f = 0.0f;
            } else if (!bl3 && bl4) {
                f2 = 1.0f;
            }
        } else {
            f = 0.0f;
            f2 = 1.0f;
        }
        if ((!bl || !bl2) && (bl3 || bl4 || bl || bl2)) {
            if (bl && !bl2) {
                f3 = 0.0f;
            } else if (!bl && bl2) {
                f4 = 1.0f;
            }
        } else {
            f3 = 0.0f;
            f4 = 1.0f;
        }
        this.func_71905_a(f, 0.0f, f3, f2, 1.0f, f4);
    }

    @SideOnly(value=Side.CLIENT)
    public dwan _a() {
        return this._d;
    }

    public final boolean _a(int n) {
        return twgu.field_71970_n[n] || n == this.field_71990_ca || n == twgu.field_71946_M.field_71990_ca;
    }

    @Override
    public boolean func_71906_q_() {
        return true;
    }

    @Override
    public cvzo func_71880_c_(int n) {
        return new cvzo(this.field_71990_ca, 1, n);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this._c);
        this._d = nege2._b(this._a);
    }

    public boolean _a(sdrg sdrg2, int n, int n2, int n3, ForgeDirection forgeDirection) {
        return this._a(sdrg2.func_72798_a(n + forgeDirection.offsetX, n2 + forgeDirection.offsetY, n3 + forgeDirection.offsetZ)) || sdrg2.isBlockSolidOnSide(n + forgeDirection.offsetX, n2 + forgeDirection.offsetY, n3 + forgeDirection.offsetZ, forgeDirection.getOpposite(), false);
    }
}


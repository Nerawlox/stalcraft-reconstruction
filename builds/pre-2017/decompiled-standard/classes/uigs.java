/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;

public class uigs
extends twgu {
    public dwan _a;
    public dwan _b;

    public uigs(int n) {
        super(n, tflj._e);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1) {
            return this._a;
        }
        if (n == 0) {
            return twgu.field_72082_bJ.func_71851_a(n);
        }
        return this.field_94336_cN;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
        this._a = nege2._b(this.func_111023_E() + "_top");
        this._b = nege2._b(this.func_111023_E() + "_eye");
    }

    public dwan _a() {
        return this._b;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 26;
    }

    @Override
    public void func_71919_f() {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.8125f, 1.0f);
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list, Entity entity) {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.8125f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (uigs._a(n4)) {
            this.func_71905_a(0.3125f, 0.8125f, 0.3125f, 0.6875f, 1.0f, 0.6875f);
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list, entity);
        }
        this.func_71919_f();
    }

    public static boolean _a(int n) {
        return (n & 4) != 0;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = ((sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3) + 2) % 4;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        if (uigs._a(n5)) {
            return 15;
        }
        return 0;
    }
}


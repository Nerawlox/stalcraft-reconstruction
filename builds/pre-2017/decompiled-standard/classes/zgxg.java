/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.eidj;

public class zgxg
extends aorr {
    public zgxg(int n) {
        super(n);
        float f = 0.5f;
        float f2 = 0.015625f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public int func_71857_b() {
        return 23;
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        if (entity == null || !(entity instanceof EntityBoat)) {
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        }
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return eidj._a()._a((double)n + this.field_72026_ch, (double)n2 + this.field_72023_ci, (double)n3 + this.field_72024_cj, (double)n + this.field_72021_ck, (double)n2 + this.field_72022_cl, (double)n3 + this.field_72019_cm);
    }

    @Override
    public int func_71933_m() {
        return 2129968;
    }

    @Override
    public int func_71889_f_(int n) {
        return 2129968;
    }

    @Override
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        return 2129968;
    }

    @Override
    public boolean _a(int n) {
        return n == twgu.field_71943_B.field_71990_ca;
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        if (n2 < 0 || n2 >= 256) {
            return false;
        }
        return ozlu2.func_72803_f(n, n2 - 1, n3) == tflj._h && ozlu2.func_72805_g(n, n2 - 1, n3) == 0;
    }
}


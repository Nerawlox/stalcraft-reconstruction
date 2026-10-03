/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.srok;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;

public class gprg
extends iwgt {
    private final float _b;
    private final int _c;
    public int _a;

    public gprg(int n, String string, float f, int n2) {
        super(n, tflj._f);
        this._b = f;
        this._c = n2;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.2f, 1.0f);
        this.func_111022_d(string);
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        oxif oxif2;
        if (entity instanceof EntityLivingBase && !entity.func_85032_ar() && entity.func_70089_S() && (oxif2 = (oxif)ozlu2.func_72796_p(n, n2, n3)) != null && oxif2._a <= 0) {
            long l = srok._a(n, n2, n3);
            float f = (srok._a(l) - 0.5f) * 0.5f + 0.5f;
            float f2 = (srok._b(l) - 0.5f) * 0.5f + 0.5f;
            if (entity.field_70121_D != null && this._a(n, n2, n3, f, f2)._b(entity.field_70121_D)) {
                InvokeSideOnly.frontend(() -> {});
                oxif2._a = this._c;
            }
        }
    }

    private eidj _a(int n, int n2, int n3, float f, float f2) {
        return eidj._a((double)((float)n + f) - 0.2, n2, (double)((float)n3 + f2) - 0.2, (double)((float)n + f) + 0.2, (double)n2 + 0.2, (double)((float)n3 + f2) + 0.2);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        super.func_71860_a(ozlu2, n, n2, n3, entityLivingBase, cvzo2);
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z / 90.0f) + 2.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new oxif();
    }

    @Override
    public int func_71857_b() {
        return this._a;
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
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }
}


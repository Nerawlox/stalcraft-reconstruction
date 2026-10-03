/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ezfa;

public final class apls
extends bbmo {
    @Override
    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        double d = ekuw2._b() + (double)ezfa2._a();
        double d2 = (float)ekuw2._f() + 0.2f;
        double d3 = ekuw2._d() + (double)ezfa2._c();
        Entity entity = mbrx._a(ekuw2._a(), cvzo2._j(), d, d2, d3);
        if (entity instanceof EntityLivingBase && cvzo2._u()) {
            ((EntityLiving)entity).func_94058_c(cvzo2._s());
        }
        cvzo2._a(1);
        return cvzo2;
    }
}


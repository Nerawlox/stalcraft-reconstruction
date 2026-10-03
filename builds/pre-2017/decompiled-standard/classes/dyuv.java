/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.ezfa;

public final class dyuv
extends bbmo {
    @Override
    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        yent yent2 = ejzs._a(ekuw2);
        double d = yent2._b() + (double)((float)ezfa2._a() * 0.3f);
        double d2 = yent2._c() + (double)((float)ezfa2._a() * 0.3f);
        double d3 = yent2._d() + (double)((float)ezfa2._c() * 0.3f);
        ozlu ozlu2 = ekuw2._a();
        Random random = ozlu2.field_73012_v;
        double d4 = random.nextGaussian() * 0.05 + (double)ezfa2._a();
        double d5 = random.nextGaussian() * 0.05 + (double)ezfa2._b();
        double d6 = random.nextGaussian() * 0.05 + (double)ezfa2._c();
        ozlu2.func_72838_d(new EntitySmallFireball(ozlu2, d, d2, d3, d4, d5, d6));
        cvzo2._a(1);
        return cvzo2;
    }

    @Override
    public void _a(ekuw ekuw2) {
        ekuw2._a().func_72926_e(1009, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.util.ezfa;

public final class lpkp
extends bbmo {
    @Override
    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        double d = ekuw2._b() + (double)ezfa2._a();
        double d2 = (float)ekuw2._f() + 0.2f;
        double d3 = ekuw2._d() + (double)ezfa2._c();
        EntityFireworkRocket entityFireworkRocket = new EntityFireworkRocket(ekuw2._a(), d, d2, d3, cvzo2);
        ekuw2._a().func_72838_d(entityFireworkRocket);
        cvzo2._a(1);
        return cvzo2;
    }

    @Override
    public void _a(ekuw ekuw2) {
        ekuw2._a().func_72926_e(1002, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }
}


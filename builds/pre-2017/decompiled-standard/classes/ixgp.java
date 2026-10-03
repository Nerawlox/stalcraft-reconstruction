/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.ezfa;

public final class ixgp
extends bbmo {
    public final bbmo _a = new bbmo();

    @Override
    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        double d;
        int n;
        int n2;
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        ozlu ozlu2 = ekuw2._a();
        double d2 = ekuw2._b() + (double)((float)ezfa2._a() * 1.125f);
        double d3 = ekuw2._c() + (double)((float)ezfa2._b() * 1.125f);
        double d4 = ekuw2._d() + (double)((float)ezfa2._c() * 1.125f);
        int n3 = ekuw2._e() + ezfa2._a();
        int n4 = ozlu2.func_72798_a(n3, n2 = ekuw2._f() + ezfa2._b(), n = ekuw2._g() + ezfa2._c());
        if (scgt._a(n4)) {
            d = 0.0;
        } else if (n4 == 0 && scgt._a(ozlu2.func_72798_a(n3, n2 - 1, n))) {
            d = -1.0;
        } else {
            return this._a._a(ekuw2, cvzo2);
        }
        EntityMinecart entityMinecart = EntityMinecart.func_94090_a(ozlu2, d2, d3 + d, d4, ((ujjf)cvzo2._a())._b);
        if (cvzo2._u()) {
            entityMinecart.func_96094_a(cvzo2._s());
        }
        ozlu2.func_72838_d(entityMinecart);
        cvzo2._a(1);
        return cvzo2;
    }

    @Override
    public void _a(ekuw ekuw2) {
        ekuw2._a().func_72926_e(1000, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }
}


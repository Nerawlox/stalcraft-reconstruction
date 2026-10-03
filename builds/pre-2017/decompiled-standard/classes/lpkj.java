/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.ezfa;

public final class lpkj
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
        tflj tflj2 = ozlu2.func_72803_f(n3, n2 = ekuw2._f() + ezfa2._b(), n = ekuw2._g() + ezfa2._c());
        if (tflj._h.equals(tflj2)) {
            d = 1.0;
        } else if (tflj._a.equals(tflj2) && tflj._h.equals(ozlu2.func_72803_f(n3, n2 - 1, n))) {
            d = 0.0;
        } else {
            return this._a._a(ekuw2, cvzo2);
        }
        EntityBoat entityBoat = new EntityBoat(ozlu2, d2, d3 + d, d4);
        ozlu2.func_72838_d(entityBoat);
        cvzo2._a(1);
        return cvzo2;
    }

    @Override
    public void _a(ekuw ekuw2) {
        ekuw2._a().func_72926_e(1000, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }
}


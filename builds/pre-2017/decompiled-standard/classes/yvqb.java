/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ezfa;

public final class yvqb
extends bbmo {
    public final bbmo _a = new bbmo();

    @Override
    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        tgdv tgdv2;
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        ozlu ozlu2 = ekuw2._a();
        int n = ekuw2._e() + ezfa2._a();
        int n2 = ekuw2._f() + ezfa2._b();
        int n3 = ekuw2._g() + ezfa2._c();
        tflj tflj2 = ozlu2.func_72803_f(n, n2, n3);
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (tflj._h.equals(tflj2) && n4 == 0) {
            tgdv2 = tgdv.field_77786_ax;
        } else if (tflj._i.equals(tflj2) && n4 == 0) {
            tgdv2 = tgdv.field_77775_ay;
        } else {
            return super._b(ekuw2, cvzo2);
        }
        ozlu2.func_94571_i(n, n2, n3);
        if (--cvzo2._b == 0) {
            cvzo2._d = tgdv2.field_77779_bT;
            cvzo2._b = 1;
        } else if (((jjzo)ekuw2._i())._a(new cvzo(tgdv2)) < 0) {
            this._a._a(ekuw2, new cvzo(tgdv2));
        }
        return cvzo2;
    }
}


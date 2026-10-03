/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ezfa;

public final class neoz
extends bbmo {
    public boolean _a = true;

    @Override
    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        if (cvzo2._j() == 15) {
            int n;
            int n2;
            int n3;
            ezfa ezfa2 = ejzs._a(ekuw2._h());
            ozlu ozlu2 = ekuw2._a();
            if (hugs._a(cvzo2, ozlu2, n3 = ekuw2._e() + ezfa2._a(), n2 = ekuw2._f() + ezfa2._b(), n = ekuw2._g() + ezfa2._c())) {
                if (!ozlu2.field_72995_K) {
                    ozlu2.func_72926_e(2005, n3, n2, n, 0);
                }
            } else {
                this._a = false;
            }
            return cvzo2;
        }
        return super._b(ekuw2, cvzo2);
    }

    @Override
    public void _a(ekuw ekuw2) {
        if (this._a) {
            ekuw2._a().func_72926_e(1000, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
        } else {
            ekuw2._a().func_72926_e(1001, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
        }
    }
}


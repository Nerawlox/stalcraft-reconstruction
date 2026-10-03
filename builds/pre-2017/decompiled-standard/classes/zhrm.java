/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.owak;
import net.minecraft.util.ezfa;

public abstract class zhrm
extends bbmo {
    @Override
    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        ozlu ozlu2 = ekuw2._a();
        yent yent2 = ejzs._a(ekuw2);
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        owak owak2 = this._a(ozlu2, yent2);
        owak2.func_70186_c(ezfa2._a(), (float)ezfa2._b() + 0.1f, ezfa2._c(), this._b(), this._a());
        ozlu2.func_72838_d((Entity)((Object)owak2));
        cvzo2._a(1);
        return cvzo2;
    }

    @Override
    public void _a(ekuw ekuw2) {
        ekuw2._a().func_72926_e(1002, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }

    public abstract owak _a(ozlu var1, yent var2);

    public float _a() {
        return 6.0f;
    }

    public float _b() {
        return 1.1f;
    }
}


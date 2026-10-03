/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.ezfa;

public final class zhra
extends bbmo {
    @Override
    public cvzo _b(ekuw ekuw2, cvzo cvzo2) {
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        ozlu ozlu2 = ekuw2._a();
        int n = ekuw2._e() + ezfa2._a();
        int n2 = ekuw2._f() + ezfa2._b();
        int n3 = ekuw2._g() + ezfa2._c();
        EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(ozlu2, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, null);
        ozlu2.func_72838_d(entityTNTPrimed);
        --cvzo2._b;
        return cvzo2;
    }
}


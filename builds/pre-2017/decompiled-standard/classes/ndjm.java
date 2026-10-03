/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.xpzm;
import java.util.Iterator;

public interface ndjm
extends woej {
    @Override
    default public float _a(cvzo cvzo2) {
        xpzm xpzm2 = (xpzm)((Object)cvzo2._a());
        float f = bahe._a(cvzo2._d, cvzo2._b);
        Iterator<qoac> iterator2 = xpzm2._d(cvzo2);
        while (iterator2.hasNext()) {
            qoac qoac2 = iterator2.next();
            short s = qoac2._e("id");
            int n = qoac2._c("Count_i") ? qoac2._f("Count_i") : (int)qoac2._d("Count");
            f += bahe._a(s, n);
        }
        return f;
    }
}


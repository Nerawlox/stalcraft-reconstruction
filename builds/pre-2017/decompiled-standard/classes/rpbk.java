/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;
import java.util.Set;

public class rpbk
extends yeso {
    public static Set<Class> _a = new HashSet<Class>();
    public zwyn _b;

    public rpbk(zwyn zwyn2, mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
        this._b = zwyn2;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return cvzo2 == null || !rpbk._a(cvzo2);
    }

    private static boolean _a(cvzo cvzo2) {
        tgdv tgdv2 = cvzo2._a();
        if (tgdv2 == null) {
            return false;
        }
        Class<?> clazz = tgdv2.getClass();
        for (Class clazz2 : _a) {
            if (!clazz2.isAssignableFrom(clazz)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void func_75218_e() {
        super.func_75218_e();
    }

    @Override
    public boolean func_111238_b() {
        return this._b.isSlotActive(this);
    }
}


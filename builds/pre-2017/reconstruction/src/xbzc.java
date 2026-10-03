/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class xbzc {
    public static boolean _a = true;
    public static final Map _b = new HashMap();
    public static final Map _c = new HashMap();
    public static final Object _d = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void _a(int n, long l) {
        if (!_a) {
            return;
        }
        Object object = _d;
        synchronized (object) {
            if (_b.containsKey(n)) {
                _b.put(n, (Long)_b.get(n) + 1L);
                _c.put(n, (Long)_c.get(n) + l);
            } else {
                _b.put(n, 1L);
                _c.put(n, l);
            }
        }
    }
}


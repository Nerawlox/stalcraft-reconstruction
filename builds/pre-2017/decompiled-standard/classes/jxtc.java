/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class jxtc {
    private static final int _b = 10;
    private static HashMap<String, jxtc> _c = new HashMap();
    private HashMap<String, Long> _d = new HashMap();
    private final String _e;
    private int _f;
    private long _g;
    public long _a;

    private jxtc(String string) {
        this._e = string;
        _c.put(string, this);
    }

    public void _a(ugqx ugqx2) {
        ++this._a;
        ++this._f;
        this._d.put(ugqx2.toString(), System.currentTimeMillis());
    }

    public boolean _b(ugqx ugqx2) {
        if (!this._d.containsKey(ugqx2.toString())) {
            return true;
        }
        return System.currentTimeMillis() - this._d.get(ugqx2.toString()) >= ugqx2._i;
    }

    public boolean _c(ugqx ugqx2) {
        boolean bl = this._b(ugqx2);
        if (bl) {
            this._a(ugqx2);
        }
        return bl;
    }

    public boolean _a() {
        if (this._g > System.currentTimeMillis() + 1000L) {
            this._g = System.currentTimeMillis();
            this._f = 0;
        }
        return this._f > 10;
    }

    public static jxtc _a(String string) {
        jxtc jxtc2 = _c.get(string);
        if (jxtc2 == null) {
            return new jxtc(string);
        }
        return _c.get(string);
    }

    public String _b() {
        return this._e;
    }
}


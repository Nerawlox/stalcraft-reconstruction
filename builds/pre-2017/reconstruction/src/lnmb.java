/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class lnmb {
    private boolean _a;
    private Map<String, qlzo> _b = new HashMap<String, qlzo>();
    private long _c = 0L;

    public lnmb _a(String string, qlzo qlzo2) {
        this._b.put(string, qlzo2);
        return this;
    }

    public lnmb _a(boolean bl) {
        this._a = bl;
        return this;
    }

    public float _a(String string) {
        qlzo qlzo2 = this._b.get(string);
        float f = qlzo2 != null ? qlzo2._b() : 0.0f;
        return this._a ? 1.0f - f : f;
    }

    public float _a(String string, long l) {
        qlzo qlzo2 = this._b.get(string);
        float f = qlzo2 != null ? qlzo2._a(l) : 0.0f;
        return this._a ? 1.0f - f : f;
    }

    public lnmb _a() {
        this._c = System.currentTimeMillis();
        this._b.values().forEach(qlzo::_a);
        return this;
    }

    public long _b() {
        return this._c;
    }
}


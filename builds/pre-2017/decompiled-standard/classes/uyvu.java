/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class uyvu {
    public float _a;
    public float _b;
    public final int _c = _d.incrementAndGet();
    private static AtomicInteger _d = new AtomicInteger();
    private static HashMap<uyvu, uyvu> _e = new HashMap();

    private uyvu(float f, float f2) {
        this._a = f;
        this._b = f2;
    }

    public static uyvu _a(float f, float f2) {
        uyvu uyvu2 = new uyvu(f, f2);
        uyvu uyvu3 = _e.get(uyvu2);
        if (uyvu3 == null) {
            _e.put(uyvu2, uyvu2);
            return uyvu2;
        }
        return uyvu3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        uyvu uyvu2 = (uyvu)object;
        if (Float.compare(uyvu2._a, this._a) != 0) {
            return false;
        }
        return Float.compare(uyvu2._b, this._b) == 0;
    }

    public int hashCode() {
        int n = this._a != 0.0f ? Float.floatToIntBits(this._a) : 0;
        n = 31 * n + (this._b != 0.0f ? Float.floatToIntBits(this._b) : 0);
        return n;
    }
}


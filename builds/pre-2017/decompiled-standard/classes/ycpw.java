/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ycpw
implements qlzo {
    private NavigableMap<Long, ivew> _a = new TreeMap<Long, ivew>();
    private List<ivew> _b = new ArrayList<ivew>();
    private long _c = 0L;
    private long _d = 0L;

    @Override
    public qlzo _a(ivew ivew2) {
        this._b.add(ivew2);
        this._a.clear();
        this._c = 0L;
        long l = 0L;
        for (ivew ivew3 : this._b) {
            this._a.put(l, ivew3);
            l += ivew3._b();
        }
        this._c = l;
        return this;
    }

    @Override
    public qlzo _a() {
        this._d = System.currentTimeMillis();
        return this;
    }

    @Override
    public float _b() {
        throw new UnsupportedOperationException("Use #get(long) instead.");
    }

    @Override
    public float _a(long l) {
        long l2 = l % this._c;
        Map.Entry<Long, ivew> entry = this._a.floorEntry(l2);
        if (entry != null) {
            return entry.getValue()._a(l2 - entry.getKey());
        }
        return 0.0f;
    }

    @Override
    public long _c() {
        return this._d;
    }

    @Override
    public long _d() {
        return this._c;
    }
}


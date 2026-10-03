/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class owvh
implements qlzo {
    private List<ivew> _a = new ArrayList<ivew>();
    private long _b = -1L;
    private int _c = 0;
    private long _d = -1L;
    private long _e = 0L;

    @Override
    public qlzo _a(ivew ivew2) {
        this._a.add(ivew2);
        this._e += ivew2._b();
        return this;
    }

    @Override
    public float _b() {
        ivew ivew2;
        if (this._a.isEmpty()) {
            return 0.0f;
        }
        long l = System.currentTimeMillis();
        long l2 = l - this._d;
        if (l2 > (ivew2 = this._a.get(this._c))._b()) {
            for (long i = l2; i > ivew2._b(); i -= ivew2._b()) {
                this._c = (this._c + 1) % this._a.size();
                ivew2 = this._a.get(this._c);
            }
            this._d = l;
            l2 = 0L;
        }
        return ivew2._a(l2);
    }

    @Override
    public float _a(long l) {
        return this._b();
    }

    @Override
    public long _c() {
        return this._b;
    }

    @Override
    public long _d() {
        return this._e;
    }

    @Override
    public qlzo _a() {
        this._d = this._b = System.currentTimeMillis();
        this._c = 0;
        return this;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public abstract class hsnd<T>
implements oxca {
    private T _a;
    private oxca.kjui _b = oxca.kjui._a;
    private long _c;
    private static final int _d = 10000;
    private AtomicInteger _e = new AtomicInteger();
    private final List<Consumer<T>> _g = new ArrayList<Consumer<T>>(1);
    protected int _f = 10000;

    public T _u_() {
        this._c = System.currentTimeMillis();
        oxca.kjui kjui2 = this._b;
        if (kjui2 == oxca.kjui._c) {
            return this._a;
        }
        if (kjui2 == oxca.kjui._a) {
            this._m();
        }
        return null;
    }

    public T _h() {
        return this._a;
    }

    public boolean _i() {
        return this._u_() != null;
    }

    public void _j() {
        this._a((T)null);
    }

    public void _a(Consumer<T> consumer) {
        if (!ogai._w()) {
            ogai._t()._e(() -> this._a((T)consumer));
            return;
        }
        this._e.incrementAndGet();
        this._b(consumer);
        this._u_();
    }

    public void _b(Consumer<T> consumer) {
        if (!ogai._w()) {
            ogai._t()._e(() -> this._b(consumer));
            return;
        }
        if (consumer != null) {
            if (this._b == oxca.kjui._c) {
                consumer.accept(this._a);
            } else {
                this._g.add(consumer);
            }
        }
    }

    public void _k() {
        if (this._e.decrementAndGet() < 0) {
            gpmu._b("Decremented number of users of " + this + " to a negative number! There is definitely a resource management flow somewhere!", new Object[0]);
        }
    }

    public void _c(int n) {
        this._f = n;
    }

    public int _l() {
        return this._e.get();
    }

    @Override
    public oxca.kjui getState() {
        return this._b;
    }

    void _m() {
        if (!ogai._w()) {
            ogai._t()._e(this::_m);
            return;
        }
        if (this._b != oxca.kjui._a) {
            return;
        }
        try {
            this._a(null, oxca.kjui._b);
            this._d();
            ogai._t()._a(this);
        }
        catch (Exception exception) {
            gpmu._b("Can not load reference: " + this, new Object[0]);
            exception.printStackTrace();
            this._a(null, oxca.kjui._d);
            ogai._t()._b(this);
        }
    }

    protected abstract void _d();

    protected boolean _t_() {
        int n = this._e.get();
        if (n > 0) {
            this._c = System.currentTimeMillis();
        } else if (this._b == oxca.kjui._c) {
            boolean bl;
            boolean bl2 = bl = this._c + (long)this._f > System.currentTimeMillis();
            if (!bl) {
                this._n();
                return true;
            }
        }
        return false;
    }

    void _n() {
        if (this._b == oxca.kjui._c && this._a != null) {
            try {
                this._a(this._a);
            }
            catch (Exception exception) {
                gpmu._b("Can not unload resource at " + this, new Object[0]);
                exception.printStackTrace();
            }
        } else {
            gpmu._b("Unloading resource from state " + (Object)((Object)this._b), new Object[0]);
        }
        this._a(null, oxca.kjui._a);
    }

    protected abstract void _a(T var1);

    protected void _a(T t, oxca.kjui kjui2) {
        ogai._y();
        if (t != null && kjui2 != oxca.kjui._c) {
            gpmu._b("Can set referent to not-null only if state is LOADED: " + this, new Object[0]);
            t = null;
        }
        this._a = t;
        this._b = kjui2;
        if (kjui2 == oxca.kjui._c || kjui2 == oxca.kjui._d) {
            for (int i = 0; i < this._g.size(); ++i) {
                this._g.get(i).accept(t);
            }
            this._g.clear();
        }
    }

    void _o() {
        if (this._b == oxca.kjui._d) {
            this._a(null, oxca.kjui._a);
        }
    }
}


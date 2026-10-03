/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class mbnm
implements hubf {
    public final mbno _a;
    public final txei _b;
    public final Map _c = Maps.newHashMap();
    public final Map _d = Maps.newHashMap();
    public final Map _e = Maps.newHashMap();
    public double _f;
    public boolean _g = true;
    public double _h;

    public mbnm(mbno mbno2, txei txei2) {
        this._a = mbno2;
        this._b = txei2;
        this._f = txei2._b();
        for (int i = 0; i < 3; ++i) {
            this._c.put(i, new HashSet());
        }
    }

    @Override
    public txei _a() {
        return this._b;
    }

    @Override
    public double _b() {
        return this._f;
    }

    @Override
    public void _a(double d) {
        if (d == this._b()) {
            return;
        }
        this._f = d;
        this._f();
    }

    public Collection _a(int n) {
        return (Collection)this._c.get(n);
    }

    @Override
    public Collection _c() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < 3; ++i) {
            hashSet.addAll(this._a(i));
        }
        return hashSet;
    }

    @Override
    public xson _a(UUID uUID) {
        return (xson)this._e.get(uUID);
    }

    @Override
    public void _a(xson xson2) {
        if (this._a(xson2._a()) != null) {
            throw new IllegalArgumentException("Modifier is already applied on this attribute!");
        }
        HashSet<xson> hashSet = (HashSet<xson>)this._d.get(xson2._b());
        if (hashSet == null) {
            hashSet = new HashSet<xson>();
            this._d.put(xson2._b(), hashSet);
        }
        ((Set)this._c.get(xson2._c())).add(xson2);
        hashSet.add(xson2);
        this._e.put(xson2._a(), xson2);
        this._f();
    }

    public void _f() {
        this._g = true;
        this._a._a(this);
    }

    @Override
    public void _b(xson xson2) {
        for (int i = 0; i < 3; ++i) {
            Set set = (Set)this._c.get(i);
            set.remove(xson2);
        }
        Set set = (Set)this._d.get(xson2._b());
        if (set != null) {
            set.remove(xson2);
            if (set.isEmpty()) {
                this._d.remove(xson2._b());
            }
        }
        this._e.remove(xson2._a());
        this._f();
    }

    @Override
    public void _d() {
        ArrayList arrayList = this._c();
        if (arrayList == null) {
            return;
        }
        arrayList = new ArrayList(arrayList);
        for (xson xson2 : arrayList) {
            this._b(xson2);
        }
    }

    @Override
    public double _e() {
        if (this._g) {
            this._h = this._g();
            this._g = false;
        }
        return this._h;
    }

    public double _g() {
        double d = this._b();
        for (xson xson2 : this._a(0)) {
            d += xson2._d();
        }
        double d2 = d;
        for (xson xson3 : this._a(1)) {
            d2 += d * xson3._d();
        }
        for (xson xson3 : this._a(2)) {
            d2 *= 1.0 + xson3._d();
        }
        return this._b._a(d2);
    }
}


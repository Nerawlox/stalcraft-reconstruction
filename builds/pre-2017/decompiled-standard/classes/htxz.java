/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class htxz
implements gqyj {
    public final List _a;
    public final int _b;
    public final int _c;
    public final int _d;

    public htxz(List list, int n, int n2, int n3) {
        this._a = list;
        this._b = n;
        this._c = n2;
        this._d = n3;
    }

    public int _a() {
        return this._c;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._a.size();
    }

    public int _d() {
        return this._d;
    }

    public msgn _a(int n) {
        return (msgn)this._a.get(n);
    }

    public int _b(int n) {
        msgn msgn2 = this._a(n);
        if (msgn2._a()) {
            return this._d;
        }
        return msgn2._b();
    }

    public boolean _c(int n) {
        return !((msgn)this._a.get(n))._a();
    }

    public int _d(int n) {
        return ((msgn)this._a.get(n))._c();
    }

    public Set _e() {
        HashSet<Integer> hashSet = Sets.newHashSet();
        for (msgn msgn2 : this._a) {
            hashSet.add(msgn2._c());
        }
        return hashSet;
    }
}


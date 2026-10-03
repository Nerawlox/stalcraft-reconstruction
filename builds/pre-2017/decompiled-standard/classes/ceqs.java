/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ceqs
extends mbno {
    public final Set _c = Sets.newHashSet();
    public final Map _d = new grqc();

    public mbnm _c(txei txei2) {
        return (mbnm)super._a(txei2);
    }

    public mbnm _b(String string) {
        hubf hubf2 = super._a(string);
        if (hubf2 == null) {
            hubf2 = (hubf)this._d.get(string);
        }
        return (mbnm)hubf2;
    }

    @Override
    public hubf _b(txei txei2) {
        if (this._b.containsKey(txei2._a())) {
            throw new IllegalArgumentException("Attribute is already registered!");
        }
        mbnm mbnm2 = new mbnm(this, txei2);
        this._b.put(txei2._a(), mbnm2);
        if (txei2 instanceof bbnt && ((bbnt)txei2)._d() != null) {
            this._d.put(((bbnt)txei2)._d(), mbnm2);
        }
        this._a.put(txei2, mbnm2);
        return mbnm2;
    }

    @Override
    public void _a(mbnm mbnm2) {
        if (mbnm2._a()._c()) {
            this._c.add(mbnm2);
        }
    }

    public Set _b() {
        return this._c;
    }

    public Collection _c() {
        HashSet<hubf> hashSet = Sets.newHashSet();
        for (hubf hubf2 : this._a()) {
            if (!hubf2._a()._c()) continue;
            hashSet.add(hubf2);
        }
        return hashSet;
    }

    @Override
    public /* synthetic */ hubf _a(String string) {
        return this._b(string);
    }

    @Override
    public /* synthetic */ hubf _a(txei txei2) {
        return this._c(txei2);
    }
}


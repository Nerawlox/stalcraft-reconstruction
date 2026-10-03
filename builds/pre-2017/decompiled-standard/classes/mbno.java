/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class mbno {
    public final Map _a = new HashMap();
    public final Map _b = new grqc();

    public hubf _a(txei txei2) {
        return (hubf)this._a.get(txei2);
    }

    public hubf _a(String string) {
        return (hubf)this._b.get(string);
    }

    public abstract hubf _b(txei var1);

    public Collection _a() {
        return this._b.values();
    }

    public void _a(mbnm mbnm2) {
    }

    public void _a(Multimap multimap) {
        for (Map.Entry entry : multimap.entries()) {
            hubf hubf2 = this._a((String)entry.getKey());
            if (hubf2 == null) continue;
            hubf2._b((xson)entry.getValue());
        }
    }

    public void _b(Multimap multimap) {
        for (Map.Entry entry : multimap.entries()) {
            hubf hubf2 = this._a((String)entry.getKey());
            if (hubf2 == null) continue;
            hubf2._b((xson)entry.getValue());
            hubf2._a((xson)entry.getValue());
        }
    }
}


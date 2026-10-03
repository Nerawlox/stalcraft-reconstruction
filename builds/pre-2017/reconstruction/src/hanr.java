/*
 * Decompiled with CFR 0.152.
 */
import java.util.Set;

public class hanr
extends turb<samo> {
    public final Set<String> _e;

    public hanr(String string, String string2, String string3, String string4, int n, Set<String> set) {
        super(string, string2, string3, string4, n);
        this._e = set;
    }

    public hanr(String string, String string2, int n, Set<String> set) {
        super(string, string2, n);
        this._e = set;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean _a(samo samo2) {
        Set<String> set = samo2._e();
        if (this._e.size() > set.size()) return false;
        if (!this._e.stream().allMatch(set::contains)) return false;
        return true;
    }

    public samo _g() {
        return new samo(this);
    }

    @Override
    public /* synthetic */ pzde _f() {
        return this._g();
    }
}


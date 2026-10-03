/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;
import java.util.Set;

public class xroo
extends kjwj {
    private Set<Integer> _b;
    private String _c;

    public xroo(int n, String string, String string2, List<String> list2, int n2, Set<Integer> set, String string3) {
        super(n, string, string2, list2, n2);
        this._b = set;
        this._c = string3;
    }

    public Set<Integer> _a() {
        return this._b;
    }

    public String _b() {
        return this._c;
    }
}


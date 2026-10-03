/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class ejvi
extends mrnb {
    protected pjxf _b(rpaa rpaa2, int n, String string, String string2, List<String> list2) {
        int n2 = rpaa2._g("clip_size");
        float f = rpaa2._l("jamming");
        return new pjxf(n, string, string2, list2, n2, f);
    }

    @Override
    public String _a() {
        return "magazine";
    }

    protected /* synthetic */ dxwc _a(rpaa rpaa2, int n, String string, String string2, List list2) {
        return this._b(rpaa2, n, string, string2, list2);
    }
}


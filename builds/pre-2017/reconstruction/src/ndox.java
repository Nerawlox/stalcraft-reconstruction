/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Set;

public class ndox
extends mrnb {
    @Override
    public String _a() {
        return "forend";
    }

    @Override
    protected dxwc _a(rpaa rpaa2, int n, String string, String string2, List<String> list) {
        ifdp ifdp2 = new ifdp(n, string, string2, list, rpaa2._i("detach_default_sight"));
        for (int i = 0; i < dxwc.pidb._y.length; ++i) {
            String string3 = "mount" + (i + 1) + "_type";
            Set<dxwc.ezey> set = ndox._a(rpaa2, string3);
            if (set == null) continue;
            ifdp2._h.put(dxwc.pidb._y[i], set);
        }
        return ifdp2;
    }
}


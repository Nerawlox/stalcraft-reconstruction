/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Set;

public class nupx
extends mrnb {
    @Override
    public String _a() {
        return "sight_mount";
    }

    @Override
    protected dxwc _a(rpaa rpaa2, int n, String string, String string2, List<String> list2) {
        Set<dxwc.ezey> set = nupx._a(rpaa2, "sight_on_mount_type");
        return new ifcv(n, string, string2, list2, set);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class cdpf
extends mrnb {
    protected htce _b(rpaa rpaa2, int n, String string, String string2, List<String> list) {
        String string3 = rpaa2._a("separate_model", (String)null);
        String string4 = rpaa2._a("separate_texture", (String)null);
        boolean bl = rpaa2._i("flashlight");
        return new htce(n, string, string2, list, string3, string4, bl);
    }

    @Override
    public String _a() {
        return "side_att";
    }

    protected /* synthetic */ dxwc _a(rpaa rpaa2, int n, String string, String string2, List list) {
        return this._b(rpaa2, n, string, string2, list);
    }
}


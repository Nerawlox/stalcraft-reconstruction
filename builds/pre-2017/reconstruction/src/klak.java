/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class klak
extends mqrl {
    @Override
    public String _a() {
        return "armor_upgrade";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list2 = rpaa2._c("description");
        xafi xafi2 = cdjc._a(rpaa2);
        float f = rpaa2._a("fail_base", 1.0f);
        int n2 = rpaa2._a("stack_size", 64);
        new bafv(n, string, string2, list2, n2, xafi2, f);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class nujq
extends mqrl {
    @Override
    public String _a() {
        return "artefakt";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list = rpaa2._c("description");
        int n2 = rpaa2._a("stack_size", 64);
        boolean bl = rpaa2._i("custom_description");
        xafi xafi2 = cdjc._a(rpaa2);
        float f = rpaa2._a("damage_to_backpack", 1.0f);
        float f2 = rpaa2._a("random_stats_factor", 0.1f);
        String string3 = rpaa2._a("visual_effect_id", (String)null);
        new cdit(n, string, string2, list, n2, xafi2, bl, f, f2, string3);
    }
}


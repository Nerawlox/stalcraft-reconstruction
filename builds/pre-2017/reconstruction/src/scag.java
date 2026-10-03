/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class scag
extends mqrl {
    @Override
    public String _a() {
        return "weapon_upgrade";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list2 = rpaa2._c("description");
        int n2 = rpaa2._a("stack_size", 64);
        stap.kjui kjui2 = stap.kjui.valueOf(rpaa2._h("type").toUpperCase());
        float f = rpaa2._j("value");
        float f2 = rpaa2._a("fail_base", 1.0f);
        new stap(n, string, string2, list2, n2, kjui2, f, f2);
    }
}


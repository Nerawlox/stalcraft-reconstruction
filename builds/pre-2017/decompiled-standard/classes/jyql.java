/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;

public class jyql
extends mqrl {
    @Override
    public String _a() {
        return "custom";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list2 = rpaa2._c("description");
        int n2 = rpaa2._a("stack_size", 64);
        new kjwj(n, string, "customitems:" + string2, list2, n2);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class yukj
extends mqrl {
    @Override
    public String _a() {
        return "blueprint";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("item_texture");
        List<String> list2 = rpaa2._c("description");
        int n2 = rpaa2._a("stack_size", 64);
        int n3 = rpaa2._g("recipe_id");
        new aofd(n, string, list2, n2, n3);
    }
}


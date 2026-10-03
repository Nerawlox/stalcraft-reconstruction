/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class oxqd
extends mqrl {
    @Override
    public String _a() {
        return "repair_kit";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        float f = rpaa2._a("repair_amount", 1.0f);
        float f2 = rpaa2._a("max_damage_mod", 1.0f);
        List<String> list = rpaa2._c("description");
        String string3 = rpaa2._a("kit_type", "weapon");
        nujd.kjui kjui2 = nujd.kjui.valueOf(string3.toUpperCase());
        new nujd(n, string, string2, list, kjui2, f, f2);
    }
}


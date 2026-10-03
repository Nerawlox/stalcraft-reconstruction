/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class ydnu
extends mqrl {
    @Override
    public String _a() {
        return "bullet";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list2 = rpaa2._c("description");
        int n2 = rpaa2._a("stack_size", 64);
        String string3 = rpaa2._a("type", "default").toUpperCase();
        nusq.kjui kjui2 = nusq.kjui.valueOf(string3);
        String string4 = rpaa2._a("type_name", kjui2._f);
        float f = rpaa2._k("damage");
        float f2 = rpaa2._k("piercing");
        float f3 = rpaa2._l("incendiary");
        float f4 = rpaa2._a("bleeding", 5.0f) / 100.0f;
        float f5 = rpaa2._l("jamming");
        float f6 = rpaa2._k("spread");
        float f7 = rpaa2._k("stopping_power");
        float f8 = rpaa2._j("hit_energy");
        int n3 = rpaa2._a("num_bullets", 1);
        new nusq(n, string, string2, list2, n2, kjui2, string4, f, f2, f3, f5, f4, f6, f7, f8, n3);
    }
}


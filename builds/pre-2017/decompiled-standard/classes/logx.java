/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class logx
extends mqrl {
    @Override
    public String _a() {
        return "medicine";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        String string3 = rpaa2._h("sound");
        List<String> list = rpaa2._c("description");
        int n2 = rpaa2._a("stack_size", 64);
        int n3 = rpaa2._g("duration");
        int n4 = rpaa2._g("cooldown");
        float f = rpaa2._j("instant_regen");
        int n5 = rpaa2._a("food_amount", 0);
        float f2 = rpaa2._a("saturation_amount", 0.0f);
        int n6 = rpaa2._a("calories", 0);
        boolean bl = rpaa2._i("custom_description");
        xafi xafi2 = cdjc._a(rpaa2);
        new sbvk(n, string, string2, list, n2, string3, f, n4, n3, xafi2, bl, n5, f2, n6);
    }
}


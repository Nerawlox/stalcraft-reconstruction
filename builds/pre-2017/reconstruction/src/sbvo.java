/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.List;

public class sbvo
extends mqrl {
    @Override
    public String _a() {
        return "backpack";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list = rpaa2._c("description");
        int n2 = rpaa2._a("stack_size", 1);
        int n3 = rpaa2._g("artefakt_slots");
        int n4 = rpaa2._g("durability");
        float f = rpaa2._j("inner_protection_factor");
        xafi xafi2 = cdjc._a(rpaa2);
        pjov pjov2 = aoeq._a(rpaa2);
        String string3 = rpaa2._h("model");
        String string4 = rpaa2._a("material_lib", (String)null);
        brhe brhe2 = this._a(n, string, string2, list, n2, n3, n4, f, xafi2, pjov2, string3, string4);
        brhe2._h = rpaa2._a("detail_amount", 0);
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> new ndfq(brhe2)._a());
        }
    }

    protected brhe _a(int n, String string, String string2, List<String> list, int n2, int n3, int n4, float f, xafi xafi2, pjov pjov2, String string3, String string4) {
        return new brhe(n, string, string2, list, n2, n3, n4, f, xafi2, pjov2, string3, string4);
    }
}


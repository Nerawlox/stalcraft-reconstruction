/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.util.sajh;

public class ejpa
extends mqrl {
    private static int _a = 0;

    @Override
    public String _a() {
        return "armor";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        int n2 = rpaa2._g("durability");
        int n3 = rpaa2._a("armor_slot", 1);
        yery yery2 = yery._e;
        dgmz dgmz2 = new dgmz(n, string, yery2, n3, n2);
        dgmz2._h = rpaa2._a("detail_amount", 0);
        dgmz2._n = sajh._a(rpaa2._g("artefakt_slots"), 0, 5);
        dgmz2._i = rpaa2._i("flashlight");
        dgmz2._j = rpaa2._i("night_vision");
        dgmz2._l = rpaa2._c("description");
        dgmz2._m = rpaa2._i("custom_description");
        dgmz2._k = cdjc._a(rpaa2);
        dgmz2._o = this._a(rpaa2._h("rarity"));
        dgmz2._c = rpaa2._h("item_texture");
        dgmz2._d = rpaa2._h("model");
        dgmz2._e = rpaa2._a("material_lib", (String)null);
        dgmz2._f = rpaa2._a("hands_model", (String)null);
        dgmz2._r = rpaa2._a("suppression_factor", 0.0f);
        if (dgmz2._f != null) {
            dgmz2._g = rpaa2._a("hands_material_lib", (String)null);
        }
        dgmz2._p = aoeq._a(rpaa2);
        if (rpaa2._i("no_backpack")) {
            dgmz2._q = new int[0];
        } else if (rpaa2._b("compatible_backpacks")) {
            dgmz2._q = rpaa2._f("compatible_backpacks");
        }
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> new tewl(dgmz2)._a());
        }
    }
}


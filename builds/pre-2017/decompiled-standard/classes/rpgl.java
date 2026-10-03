/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.customitem.CustomItemsMod;

public class rpgl
extends mqrl {
    @Override
    public String _a() {
        return "block";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        int n2 = rpaa2._g("chest_size");
        boolean bl = rpaa2._i("collide");
        boolean bl2 = n2 > 0;
        gphy gphy2 = bl2 ? new uyqj(n, n2, bl) : new gphy(n, bl);
        gphy2.func_71864_b("block" + n);
        LanguageRegistry.addName(gphy2, rpaa2._h("name"));
        gphy2._e = rpaa2._i("rotatable");
        gphy2._d = rpaa2._g("light_value");
        twgu.field_71970_n[gphy2.field_71990_ca] = gphy2._b = rpaa2._i("opaque");
        twgu.field_71971_o[gphy2.field_71990_ca] = gphy2._b ? 255 : 0;
        float f = rpaa2._j("min_x");
        float f2 = rpaa2._j("min_y");
        float f3 = rpaa2._j("min_z");
        float f4 = rpaa2._a("max_x", 1.0f);
        float f5 = rpaa2._a("max_y", 1.0f);
        float f6 = rpaa2._a("max_z", 1.0f);
        gphy2._a(f, f2, f3, f4, f5, f6);
        if (bl2) {
            uyqj uyqj2 = (uyqj)gphy2;
            String string = rpaa2._a("loot", (String)null);
            uyqj2._a(CustomItemsMod._a(string));
            uyqj2._i = rpaa2._a("open_sound", "");
            uyqj2._j = rpaa2._a("close_sound", "");
            if ("default".equals(uyqj2._i)) {
                uyqj2._i = "random.chestopen";
            }
            if ("default".equals(uyqj2._j)) {
                uyqj2._j = "random.chestclose";
            }
        } else if (rpaa2._b("type")) {
            gphy2._f = gphy.kjui.valueOf(rpaa2._h("type").toUpperCase());
            if (gphy2._f == gphy.kjui._b) {
                gphy2._g = rpaa2._a("workbench_id", "");
            }
        } else {
            gphy2._f = null;
        }
        if (!rpaa2._b("model") || rpaa2._i("simple_render")) {
            gphy2._a = rpaa2._h("icon");
            GameRegistry.registerBlock((twgu)gphy2, "block" + n);
        } else {
            GameRegistry.registerBlock(gphy2, qmdn.class, "block" + n);
            tgdv.field_77698_e[n].func_111206_d("customitems:decorblocks/" + rpaa2._h("icon"));
        }
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> this._a(gphy2, rpaa2));
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a(gphy gphy2, rpaa rpaa2) {
        boolean bl;
        String string = rpaa2._a("model", (String)null);
        boolean bl2 = bl = string != null && rpaa2._i("simple_render");
        if (string != null) {
            if (bl) {
                rpgl._a(gphy2, rpaa2);
            } else {
                String string2 = "customitems:models/blocks/" + string;
                String string3 = null;
                String string4 = null;
                if (rpaa2._b("model_texture")) {
                    string3 = "customitems:models/blocks/" + rpaa2._h("model_texture");
                }
                if (rpaa2._b("material_lib")) {
                    string4 = "customitems:models/blocks/" + rpaa2._h("material_lib");
                }
                float f = rpaa2._a("render_distance", 64.0f);
                gphy2._a(-1);
                fmea._a._a(gphy2, string2, string4, string3, f);
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(twgu twgu2, rpaa rpaa2) {
        String string = rpaa2._a("model", (String)null);
        String string2 = "/assets/customitems/models/blocks/" + string;
        hsdi hsdi2 = new hsdi(string2, rpaa2._i("random_rotation"), rpaa2._i("color_multiplier"), rpaa2._j("max_pos_offset"), rpaa2._a("min_scale", 1.0f), rpaa2._a("max_scale", 1.0f), rpaa2._a("min_instances", 1), rpaa2._a("max_instances", 1), rpaa2._a("ambient_color", new float[]{0.4f, 0.4f, 0.4f}), rpaa2._a("diffuse_color", new float[]{0.6f, 0.6f, 0.6f}));
        GloomyHooks._a[twgu2.field_71990_ca] = hsdi2.getRenderId();
        RenderingRegistry.registerBlockHandler(hsdi2.getRenderId(), hsdi2);
    }
}


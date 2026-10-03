/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.block.Block;

public class cunf
extends mqrl {
    @Override
    public String _a() {
        return "landmine";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("model");
        String string2 = rpaa2._a("name", "block_" + n);
        float f = rpaa2._j("power");
        String string3 = rpaa2._h("model_texture");
        int n2 = rpaa2._a("explosion_freq", 20);
        gprg gprg2 = new gprg(n, string3, f, n2);
        GameRegistry.registerBlock((Block)gprg2, "block_" + n);
        LanguageRegistry.addName(gprg2, string2);
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> {
                yugv yugv2 = new yugv(string);
                RenderingRegistry.registerBlockHandler(yugv2.getRenderId(), yugv2);
                gprg2._a = yugv2.getRenderId();
            });
        }
    }
}


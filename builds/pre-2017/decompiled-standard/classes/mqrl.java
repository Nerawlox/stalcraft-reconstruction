/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public abstract class mqrl {
    public abstract String _a();

    public final void _a(rpaa rpaa2) {
        this._b(rpaa2);
        tgdv tgdv2 = tgdv.field_77698_e[rpaa2._e];
        if (tgdv2 != null) {
            if (FMLCommonHandler.instance().getSide().isClient()) {
                InvokeSideOnly.client(() -> this._a(rpaa2, tgdv2));
            }
            MinecraftForge.EVENT_BUS.post(new piyf(tgdv2, rpaa2));
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a(rpaa rpaa2, tgdv tgdv2) {
        Object object;
        if (rpaa2._b("custom_model")) {
            Object object2;
            if (rpaa2._b("custom_render_config")) {
                object2 = uyvo._a(rpaa2._h("custom_render_config"));
                object = new anpy((ResourceLocation)object2);
            } else {
                object = new anpy(null);
            }
            object2 = new anoq("/assets/", rpaa2._h("custom_model"), rpaa2._a("custom_material_lib", (String)null), (anpy)object, rpaa2._i("animate_on_ground"), rpaa2._i("animate_first_person"), rpaa2._i("has_distortions"));
            ((hbcv)object2)._c._a(rpaa2);
            MinecraftForgeClient.registerItemRenderer(tgdv2.field_77779_bT, (IItemRenderer)object2);
            anoq._i._a(rpaa2._e, object2);
        }
        if (rpaa2._b("custom_effector")) {
            object = uyvo._a(rpaa2._h("custom_effector"));
            iefo._a._a()._a(rpaa2._e, new oxbc((ResourceLocation)object));
        }
    }

    public abstract void _b(rpaa var1);

    protected String _a(rpaa rpaa2, String string, String string2, String string3) {
        String string4 = this._a(rpaa2, string, string2);
        return string4 == null ? string2 + ":" + string3 : string4;
    }

    protected String _a(rpaa rpaa2, String string, String string2) {
        String string3 = rpaa2._a(string, (String)null);
        if (string3 != null && (string3 = string2 + ":" + string3).indexOf(".") >= 0) {
            string3 = string3.substring(0, string3.lastIndexOf("."));
        }
        return string3;
    }

    protected zywl _a(String string) {
        try {
            return zywl.valueOf(string);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public boolean _b() {
        return true;
    }
}


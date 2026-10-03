/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.pibk;
import gloomyfolken.mods.core.misc.ybzs;
import java.util.List;
import net.minecraftforge.client.MinecraftForgeClient;

public class ifbd
extends mqrl {
    @Override
    public String _a() {
        return "grenade";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list = rpaa2._c("description");
        int n2 = rpaa2._a("stack_size", 60);
        String string3 = rpaa2._h("model_thrown");
        float f = rpaa2._a("max_start_speed", 1.0f);
        int n3 = rpaa2._a("throw_period", 20);
        int n4 = rpaa2._a("prepare_period", 10);
        float f2 = rpaa2._a("throw_degree_offset", -10.0f);
        boolean bl = rpaa2._a("ignite_in_hand", false);
        int n5 = rpaa2._a("ignite_time", 30);
        int n6 = rpaa2._a("ignite_prepare_time", 30);
        int n7 = rpaa2._a("flash_time", 80);
        int n8 = rpaa2._a("flash_deaf_time", 100);
        String string4 = rpaa2._a("sound_explosion", "gren.explosion_default");
        String string5 = rpaa2._a("sound_pin", "gren.pin_default");
        float f3 = rpaa2._j("explosion_size");
        int n9 = rpaa2._g("lifetime");
        boolean bl2 = rpaa2._i("explosion_on_collide");
        scai scai2 = scai.valueOf(rpaa2._a("grenade_type", "FRAG").toUpperCase());
        boolean bl3 = rpaa2._a("hand_use", true);
        pibk pibk2 = new pibk(rpaa2);
        pibk2._b(rpaa2._a("anim_name", "/assets/weapons/anims/grenade.anm"));
        yurw yurw2 = new yurw(n, string, pibk2, string2, list, f3, bl, n9, bl2, string3, scai2);
        yurw2._h = n5;
        yurw2._g = n6;
        yurw2._j = n8;
        yurw2._i = n7;
        yurw2._l = string5;
        yurw2._k = string4;
        yurw2._m = bl3;
        yurw yurw3 = yurw2;
        yurw3._b(n4);
        yurw3._a(n3);
        yurw3._a(f);
        yurw3._b(f2);
        yurw3.func_77625_d(n2);
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> this._a(yurw3, rpaa2));
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a(ybzs ybzs2, rpaa rpaa2) {
        ejwe ejwe2 = new ejwe(ybzs2, zfvg::_i, "");
        ejwe2._c._a(rpaa2);
        MinecraftForgeClient.registerItemRenderer(ybzs2.field_77779_bT, ejwe2);
        anoq._i._a(ybzs2.field_77779_bT, ejwe2);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.pibk;
import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.client.MinecraftForgeClient;

public class xakq
extends mqrl {
    private static final List<String> _a = new ArrayList<String>();

    @Override
    public String _a() {
        return "melee_weapon";
    }

    @Override
    public void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string2 = rpaa2._h("name");
        String string3 = rpaa2._h("item_texture");
        List<String> list2 = rpaa2._c("description");
        float f = rpaa2._a("critical_hit_mod", 2.5f);
        float f2 = rpaa2._a("bleed_chance", 2.5f);
        float f3 = rpaa2._a("damage_spread", 0.0f);
        float f4 = rpaa2._a("reach", 3.0f);
        Float[] floatArray = (Float[])_a.stream().map(string -> Float.valueOf(rpaa2._a("damage_" + string, 5.0f))).toArray(Float[]::new);
        Integer[] integerArray = (Integer[])_a.stream().map(string -> rpaa2._a("delay_" + string, 0)).toArray(Integer[]::new);
        Integer[] integerArray2 = (Integer[])_a.stream().map(string -> rpaa2._a("cd_" + string, 8)).toArray(Integer[]::new);
        String string4 = rpaa2._h("swing_sound");
        String string5 = rpaa2._h("swing_sound_strong");
        pibk pibk2 = new pibk(rpaa2);
        pibk2._b(rpaa2._a("anim_name", "/assets/weapons/anims/knife.anm"));
        cdse cdse2 = new cdse(n, string2, string3, list2, floatArray, integerArray, integerArray2, f3, f, f2, string4, string5, f4, pibk2);
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> this._a(cdse2, rpaa2));
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a(cdse cdse2, rpaa rpaa2) {
        ejwe ejwe2 = new ejwe(cdse2, ndlw::_g, "weapons/models/meleeweapons/");
        ejwe2._c._a(rpaa2);
        MinecraftForgeClient.registerItemRenderer(cdse2.itemID, ejwe2);
        anoq._i._a(cdse2.itemID, ejwe2);
    }

    static {
        _a.add("common");
        _a.add("strong");
    }
}


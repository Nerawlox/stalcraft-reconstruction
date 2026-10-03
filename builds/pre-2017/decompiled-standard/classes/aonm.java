/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.tdpf;
import gloomyfolken.mods.weapon.qlgf;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraftforge.client.MinecraftForgeClient;

public class aonm
extends mqrl {
    @Override
    public String _a() {
        return "weapon";
    }

    @Override
    public void _b(rpaa rpaa2) {
        Object object;
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list = rpaa2._c("description");
        wolf wolf2 = new wolf(n, string, string2, list);
        wolf2._d(rpaa2._a("rate_of_fire", 1200.0f / (float)rpaa2._a("cooldown", 1)));
        wolf2._b(rpaa2._j("damage"), rpaa2._j("damage_distant"));
        float f = rpaa2._a("max_distance", 64.0f);
        wolf2._e(f);
        wolf2._a(rpaa2._a("damage_decrease_start", f), rpaa2._a("damage_decrease_end", f));
        wolf2._a(rpaa2._g("clip_size"));
        float f2 = rpaa2._j("recoil");
        float f3 = rpaa2._j("horizontal_recoil");
        wolf2._a(f2);
        wolf2._b(f3);
        wolf2._c(rpaa2._a("wiggle", 1.0f));
        wolf2._f(rpaa2._l("jamming"));
        wolf2.func_77656_e(rpaa2._g("durability"));
        wolf2._B = rpaa2._a("detail_amount", 0);
        wolf2._j = rpaa2._a("spread", 1.0f);
        wolf2._k = rpaa2._a("additional_hip_spread", 5.0f);
        wolf2._l = rpaa2._a("min_additional_hip_spread", wolf2._k * 0.4f);
        wolf2._m = rpaa2._j("shot_spread_multiplier_increase");
        wolf2._o = rpaa2._j("tick_spread_multiplier_reduction");
        wolf2._n = rpaa2._a("max_spread_multiplier", 1.0f);
        wolf2._p = rpaa2._a("movement_spread_factor", 1.0f);
        wolf2._r = rpaa2._a("crawling_spread_factor", 1.0f);
        wolf2._q = rpaa2._a("sneaking_spread_factor", 1.0f);
        if (rpaa2._i("stepwise_reload")) {
            wolf2._a(rpaa2._g("reload_begin_time"), rpaa2._g("reload_step_time"), rpaa2._g("reload_end_time"));
        } else {
            wolf2._b(rpaa2._g("reload_time"));
        }
        wolf2._z = rpaa2._a("aim_switch_time", 5) * 50;
        wolf2._u = rpaa2._a("draw_time", 10);
        wolf2.__af = new xrpu(rpaa2._h("anim"), string);
        wolf2.__ah = rpaa2._d("fp_groups");
        wolf2._C = rpaa2._h("model_name");
        wolf2._U = rpaa2._i("render_equipped");
        wolf2._D = rpaa2._h("aiming_texture");
        wolf2._E = rpaa2._a("material_lib", (String)null);
        wolf2._G = rpaa2._a("model_name_lod", (String)null);
        wolf2._H = rpaa2._a("material_lib_lod", (String)null);
        wolf2._I = this._a(rpaa2, "shoot_sound", "weapons", "generic_shoot");
        wolf2._J = this._a(rpaa2, "reload_sound", "weapons", "generic_reload");
        wolf2._K = this._a(rpaa2, "silencer_shoot_sound", "weapons", "generic_silent");
        wolf2._N = this._a(rpaa2, "empty_sound", "weapons", "generic_empty");
        wolf2._L = this._a(rpaa2, "draw_sound", "weapons", "generic_draw");
        wolf2._M = this._a(rpaa2, "misfire_sound", "weapons", "generic_misfire");
        List<String> list2 = rpaa2._c("special_sounds");
        wolf2._A = new HashSet<String>(list2.size());
        for (String string3 : list2) {
            wolf2._A.add("weapons:" + string3);
        }
        wolf2._b = rpaa2._f("bullets_id");
        wolf2._c = rpaa2._f("default_attachments_id");
        wolf2._O = rpaa2._i("is_pistol");
        wolf2._P = rpaa2._i("rapid_mode");
        wolf2._Q = rpaa2._i("burst_mode");
        wolf2._R = Math.max(1.0f, rpaa2._j("zoom"));
        wolf2._S = rpaa2._a("fov", 40.0f);
        wolf2._T = rpaa2._a("zoom_fov", 40.0f);
        for (dxwc.pidb pidb2 : dxwc.pidb.values()) {
            String string4;
            wolf2._e.put(pidb2, Float.valueOf(rpaa2._j(pidb2._t + "_weight")));
            Set<dxwc.ezey> set = mrnb._a(rpaa2, pidb2._r + "_type");
            if (set != null) {
                wolf2._f.put(pidb2, set);
            }
            if ((string4 = rpaa2._a(pidb2._r + "_name", (String)null)) == null) continue;
            wolf2._g.put(pidb2, string4);
        }
        wolf2.__ae = this._a(rpaa2._h("rarity"));
        wolf2.__ac = rpaa2._i("animated");
        wolf2.__ad = rpaa2._i("mirrored");
        if (wolf2.__ac) {
            wolf2._F = rpaa2._a("weapon_anim", (String)null);
            object = rpaa2._c("special_anims");
            wolf2.__ab = new HashSet<String>(object.size());
            wolf2.__ab.addAll((Collection<String>)object);
        }
        wolf2.__ag = rpaa2._a("tp_reload_anim", (String)null);
        wolf2._a(rpaa2._h("sleeve_model"), rpaa2._h("sleeve_texture"));
        if (rpaa2._i("force_launcher_camera_pos")) {
            wolf2.__ai = new klka(rpaa2._j("l_posX"), rpaa2._j("l_posY"), rpaa2._j("l_posZ"), 0.0f, 0.0f, 0.0f, rpaa2._j("l_rotX"), rpaa2._j("l_rotY"));
        }
        tdpf._b(wolf2.__aa, rpaa2._a("sleeve_speed_x", -0.15f), rpaa2._a("sleeve_speed_y", 0.25f), rpaa2._a("sleeve_speed_z", 0.0f));
        wolf2._X = rpaa2._a("sleeve_fp_scale", 1.0f);
        wolf2._Y = rpaa2._g("num_sleeves_on_reload");
        wolf2._Z = rpaa2._g("spawn_sleeve_time") * 50;
        wolf2.__ak = rpaa2._a("noise", -1.0f);
        wolf2.__al = rpaa2._a("silenced_noise", -1.0f);
        wolf2.__am = rpaa2._a("suppression", 0.25f);
        wolf2._t = rpaa2._a("is_silenced", false);
        wolf2._s = rpaa2._a("equipped_speed_modifier", 1.0f);
        wolf2.__an = Float.floatToIntBits(f2) ^ Float.floatToIntBits(f3) ^ 0x936A2B0E;
        object = rpaa2._h("category");
        if (!((String)object).isEmpty()) {
            wolf2.__aj = qlgf.valueOf(((String)object).toUpperCase());
        }
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> this._a(wolf2, rpaa2));
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a(wolf wolf2, rpaa rpaa2) {
        if (!wolf2.__ac) {
            throw new IllegalStateException("not animated weapons are not supported any more");
        }
        pjux pjux2 = new pjux(wolf2);
        pjux2._c._a(rpaa2);
        MinecraftForgeClient.registerItemRenderer(wolf2.field_77779_bT, pjux2);
        pjux._i._a(wolf2.field_77779_bT, pjux2);
    }
}


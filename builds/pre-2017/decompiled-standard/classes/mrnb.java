/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.util.eidj;

public abstract class mrnb
extends mqrl {
    @Override
    public final void _b(rpaa rpaa2) {
        int n = rpaa2._g("item_id");
        String string = rpaa2._h("name");
        String string2 = rpaa2._h("item_texture");
        List<String> list2 = rpaa2._c("description");
        String string3 = rpaa2._a("model", (String)null);
        String string4 = rpaa2._a("material_lib", (String)null);
        String[] stringArray = rpaa2._d("mount_types");
        HashSet<dxwc.ezey> hashSet = new HashSet<dxwc.ezey>(stringArray.length);
        for (String string5 : stringArray) {
            hashSet.add(dxwc.ezey._a(string5));
        }
        dxwc.kjui kjui2 = new dxwc.kjui(rpaa2._k("damage"), rpaa2._k("rate_of_fire"), rpaa2._k("wiggle"), rpaa2._k("recoil"), rpaa2._k("horizontal_recoil"), rpaa2._k("spread"), rpaa2._k("hip_spread"), rpaa2._k("aim_switch_time"), rpaa2._k("draw_time"), rpaa2._k("distance"), rpaa2._k("durability"));
        eidj eidj2 = null;
        if (rpaa2._b("min_x")) {
            eidj2 = eidj._a(rpaa2._j("min_x"), rpaa2._j("min_y"), rpaa2._j("min_z"), rpaa2._j("max_x"), rpaa2._j("max_y"), rpaa2._j("max_z"));
        }
        dxwc dxwc2 = this._a(rpaa2, n, string, string2, list2);
        dxwc2._a(hashSet, string3, string4, kjui2, eidj2);
        dxwc2.func_77656_e(rpaa2._a("item_durability", 0));
        dxwc2._f = rpaa2._a("detail_amount", 0);
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> dxwc2._c());
        }
    }

    static Set<dxwc.ezey> _a(rpaa rpaa2, String string) {
        String[] stringArray = rpaa2._a(string, (String[])null);
        if (stringArray != null) {
            HashSet<dxwc.ezey> hashSet = new HashSet<dxwc.ezey>(stringArray.length);
            for (String string2 : stringArray) {
                hashSet.add(dxwc.ezey._a(string2));
            }
            return hashSet;
        }
        return null;
    }

    protected abstract dxwc _a(rpaa var1, int var2, String var3, String var4, List<String> var5);
}


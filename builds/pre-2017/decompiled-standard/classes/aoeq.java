/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.ezey;
import java.util.EnumMap;

public class aoeq {
    public static pjov _a(rpaa rpaa2) {
        pjov pjov2 = new pjov();
        EnumMap<ezey.kjui, Float> enumMap = pjov2._a;
        enumMap.put(ezey.kjui._a, Float.valueOf(rpaa2._a("electroshock_durability_factor", 0.1f)));
        enumMap.put(ezey.kjui._b, Float.valueOf(rpaa2._a("burn_durability_factor", 0.25f)));
        enumMap.put(ezey.kjui._c, Float.valueOf(rpaa2._a("chemical_burn_durability_factor", 0.25f)));
        enumMap.put(ezey.kjui._d, Float.valueOf(rpaa2._a("tear_durability_factor", 1.0f)));
        enumMap.put(ezey.kjui._e, Float.valueOf(rpaa2._a("explosion_durability_factor", 1.25f)));
        enumMap.put(ezey.kjui._f, Float.valueOf(rpaa2._a("bullet_durability_factor", 1.0f)));
        return pjov2;
    }
}


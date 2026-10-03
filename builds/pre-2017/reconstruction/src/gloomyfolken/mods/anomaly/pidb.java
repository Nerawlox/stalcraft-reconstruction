/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import gloomyfolken.mods.core.misc.ezey;
import net.minecraft.util.DamageSource;

public class pidb
extends ezey {
    public static DamageSource _a = new pidb("electra", " \u0443\u0431\u0438\u043b\u043e \u044d\u043b\u0435\u043a\u0442\u0440\u043e\u0439", ezey.kjui._a);
    public static DamageSource _b = new pidb("carousel", " \u0440\u0430\u0437\u043e\u0440\u0432\u0430\u043b\u043e \u043a\u0430\u0440\u0443\u0441\u0435\u043b\u044c\u044e", ezey.kjui._d);
    public static DamageSource _c = new pidb("coach", " \u043f\u043e\u0433\u0438\u0431 \u0438\u0437-\u0437\u0430 \u0442\u0440\u0435\u043d\u0435\u0440\u0430", ezey.kjui._i);
    public static DamageSource _d = new pidb("kissel", " \u0440\u0430\u0441\u0442\u0432\u043e\u0440\u0438\u043b\u0441\u044f \u0432 \u043a\u0438\u0441\u0435\u043b\u0435", ezey.kjui._c);
    public static DamageSource _e = new pidb("steam", " \u0441\u0432\u0430\u0440\u0438\u043b\u0441\u044f \u0432 \u043f\u0430\u0440\u0435", ezey.kjui._b);
    public static DamageSource _f = new pidb("trampoline", " \u0440\u0430\u0437\u043e\u0440\u0432\u0430\u043b\u043e \u0431\u0430\u0442\u0443\u0442\u043e\u043c", ezey.kjui._d);
    public static DamageSource _g = new pidb("blackhole", " \u0440\u0430\u0437\u043e\u0440\u0432\u0430\u043b\u043e \u0432\u043e\u0440\u043e\u043d\u043a\u043e\u0439", ezey.kjui._i);
    public static DamageSource _h = new pidb("lighter", " \u0441\u0433\u043e\u0440\u0435\u043b \u0432 \u0436\u0430\u0440\u043a\u0435", ezey.kjui._b);
    public static DamageSource _i = new pidb("circus", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0446\u0438\u0440\u043a\u0430", ezey.kjui._b);

    public pidb(String string, String string2, ezey.kjui kjui2) {
        super(string, string2, kjui2);
        this.setDamageBypassesArmor();
    }
}


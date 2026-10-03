/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.ezey;
import java.util.EnumMap;

public class pjov {
    public EnumMap<ezey.kjui, Float> _a = new EnumMap(ezey.kjui.class);

    public float _a(ezey.kjui kjui2) {
        Float f = this._a.get((Object)kjui2);
        if (f == null) {
            return 1.0f;
        }
        return f.floatValue();
    }
}


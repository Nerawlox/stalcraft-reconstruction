/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import gloomyfolken.mods.core.misc.amww;
import java.util.EnumMap;
import java.util.Set;

public interface yusn
extends amww {
    public EnumMap<dxwc.pidb, Set<dxwc.ezey>> _w_();

    default public Set<dxwc.ezey> _a(dxwc.pidb pidb2) {
        return this._w_().get((Object)pidb2);
    }

    default public boolean _a(dxwc dxwc2, dxwc.pidb pidb2) {
        Set<dxwc.ezey> set = this._a(pidb2);
        return set != null && !Sets.intersection(dxwc2._c, set).isEmpty() && pidb2._q.contains((Object)dxwc2._b) && dxwc2._a_(pidb2);
    }

    default public boolean _a(dxwc dxwc2) {
        for (dxwc.pidb pidb2 : dxwc2._b._a()) {
            if (!this._a(dxwc2, pidb2)) continue;
            return true;
        }
        return false;
    }
}


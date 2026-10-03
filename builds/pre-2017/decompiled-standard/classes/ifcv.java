/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;

public class ifcv
extends dxwc
implements yusn {
    public EnumMap<dxwc.pidb, Set<dxwc.ezey>> _h = new EnumMap(dxwc.pidb.class);
    private static List<ifcv> _i = new ArrayList<ifcv>();

    public ifcv(int n, String string, String string2, List<String> list2, Set<dxwc.ezey> set) {
        super(n, string, string2, list2, dxwc.eidj._g);
        _i.add(this);
        this._h.put(dxwc.pidb._m, set);
    }

    public static List<ifcv> _b() {
        return _i;
    }

    @Override
    public EnumMap<dxwc.pidb, Set<dxwc.ezey>> _w_() {
        return this._h;
    }
}


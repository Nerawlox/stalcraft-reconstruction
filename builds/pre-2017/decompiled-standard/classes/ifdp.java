/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;

public class ifdp
extends dxwc
implements yusn {
    public EnumMap<dxwc.pidb, Set<dxwc.ezey>> _h = new EnumMap(dxwc.pidb.class);
    private static List<ifdp> _j = new ArrayList<ifdp>();
    public boolean _i;

    public ifdp(int n, String string, String string2, List<String> list, boolean bl) {
        super(n, string, string2, list, dxwc.eidj._a);
        this._i = bl;
        _j.add(this);
    }

    public static List<ifdp> _b() {
        return _j;
    }

    @Override
    public EnumMap<dxwc.pidb, Set<dxwc.ezey>> _w_() {
        return this._h;
    }
}


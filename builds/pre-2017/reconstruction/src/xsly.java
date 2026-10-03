/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

public class xsly
implements zhqu {
    public final Map _b = this._a();

    public HashMap _a() {
        return Maps.newHashMap();
    }

    @Override
    public Object _a(Object object) {
        return this._b.get(object);
    }

    @Override
    public void _a(Object object, Object object2) {
        this._b.put(object, object2);
    }
}


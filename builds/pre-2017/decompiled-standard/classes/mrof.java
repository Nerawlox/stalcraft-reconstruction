/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ArrayListMultimap;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.Iterator;
import net.minecraft.client.xpzm;

public class mrof {
    public ArrayListMultimap<Object, mamj> _a = ArrayListMultimap.create();
    private xpzm _b = xpzm._E();

    @ezey(_a={eidj.CLIENT})
    public void _a(Object object, int n, float f, float f2, boolean bl) {
        mamj mamj2 = twcp._a._a(n, f, f2, bl);
        if (mamj2 != null) {
            this._a.put(object, (Object)mamj2);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void _a() {
        Iterator iterator2 = this._a.values().iterator();
        while (iterator2.hasNext()) {
            mamj mamj2 = (mamj)iterator2.next();
            if (++mamj2._k <= mamj2._i && (!mamj2._j || this._b._M.field_74320_O == 0)) continue;
            iterator2.remove();
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void _a(Object object, float f) {
        if (!this._a.containsKey(object)) {
            return;
        }
        for (mamj mamj2 : this._a.get(object)) {
            mamj2._a();
        }
    }
}


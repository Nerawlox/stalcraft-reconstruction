/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class btsm
implements dzyj {
    protected HashMap<Class<? extends ywts>, List<ywts>> _a = Maps.newHashMap();
    protected int _b = 0;

    public btsm() {
        for (Class clazz : this._a()) {
            this._a.put(clazz, new CopyOnWriteArrayList());
        }
    }

    public abstract Class[] _a();

    @Override
    public btsm _c() {
        return this;
    }

    @Override
    public <K extends ywts> List<K> _a(Class<K> clazz) {
        List<ywts> list2 = this._a.get(clazz);
        if (list2 == null) {
            list2 = new ArrayList<ywts>();
        }
        return list2;
    }

    public void _a(ywts ywts2) {
        if (ywts2 != null) {
            for (Class clazz : this._a()) {
                this._a(clazz, ywts2);
            }
        }
    }

    public void _b(ywts ywts2) {
        if (ywts2 != null) {
            for (Class clazz : this._a()) {
                this._b(clazz, ywts2);
            }
        }
    }

    private void _a(Class<? extends ywts> clazz, ywts ywts2) {
        if (clazz.isInstance(ywts2)) {
            List<ywts> list2 = this._a.get(clazz);
            if (list2 == null) {
                list2 = new CopyOnWriteArrayList<ywts>();
                this._a.put(clazz, list2);
            }
            if (list2.add(ywts2)) {
                ++this._b;
            }
        }
    }

    private void _b(Class<? extends ywts> clazz, ywts ywts2) {
        List<ywts> list2;
        if (clazz.isInstance(ywts2) && (list2 = this._a.get(clazz)) != null && list2.remove(ywts2)) {
            --this._b;
        }
    }

    private void _b(Class<? extends ywts> clazz) {
        List<ywts> list2 = this._a.get(clazz);
        if (list2 != null) {
            list2.clear();
        }
    }

    public boolean _d() {
        return this._b > 0;
    }

    public void _e() {
        for (Class clazz : this._a()) {
            this._b(clazz);
        }
        this._b = 0;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public abstract class tycc {
    public LinkedList _a = new LinkedList();
    public uken _b;
    public int _c;
    public int _d;

    public tycc() {
    }

    public tycc(int n, int n2) {
        this._c = n;
        this._d = n2;
    }

    public uken _a() {
        return this._b;
    }

    public LinkedList _b() {
        return this._a;
    }

    public void _a(ozlu ozlu2, Random random, uken uken2) {
        Iterator iterator2 = this._a.iterator();
        while (iterator2.hasNext()) {
            zztd zztd2 = (zztd)iterator2.next();
            if (!zztd2._d()._a(uken2) || zztd2._a(ozlu2, random, uken2)) continue;
            iterator2.remove();
        }
    }

    public void _c() {
        this._b = uken._a();
        for (zztd zztd2 : this._a) {
            this._b._b(zztd2._d());
        }
    }

    public qoac _a(int n, int n2) {
        if (cfps._a(this) == null) {
            throw new RuntimeException("StructureStart \"" + this.getClass().getName() + "\" missing ID Mapping, Modder see MapGenStructureIO");
        }
        qoac qoac2 = new qoac();
        qoac2._a("id", cfps._a(this));
        qoac2._a("ChunkX", n);
        qoac2._a("ChunkZ", n2);
        qoac2._a("BB", this._b._a("BB"));
        bsyv bsyv2 = new bsyv("Children");
        for (zztd zztd2 : this._a) {
            bsyv2._a(zztd2._c());
        }
        qoac2._a("Children", bsyv2);
        this._a(qoac2);
        return qoac2;
    }

    public void _a(qoac qoac2) {
    }

    public void _a(ozlu ozlu2, qoac qoac2) {
        this._c = qoac2._f("ChunkX");
        this._d = qoac2._f("ChunkZ");
        if (qoac2._c("BB")) {
            this._b = new uken(qoac2._l("BB"));
        }
        bsyv bsyv2 = qoac2._n("Children");
        for (int i = 0; i < bsyv2._d(); ++i) {
            this._a.add(cfps._b((qoac)bsyv2._b(i), ozlu2));
        }
        this._b(qoac2);
    }

    public void _b(qoac qoac2) {
    }

    public void _a(ozlu ozlu2, Random random, int n) {
        int n2 = 63 - n;
        int n3 = this._b._c() + 1;
        if (n3 < n2) {
            n3 += random.nextInt(n2 - n3);
        }
        int n4 = n3 - this._b._e;
        this._b._a(0, n4, 0);
        for (zztd zztd2 : this._a) {
            zztd2._d()._a(0, n4, 0);
        }
    }

    public void _a(ozlu ozlu2, Random random, int n, int n2) {
        int n3 = n2 - n + 1 - this._b._c();
        boolean bl = true;
        int n4 = n3 > 1 ? n + random.nextInt(n3) : n;
        int n5 = n4 - this._b._b;
        this._b._a(0, n5, 0);
        for (zztd zztd2 : this._a) {
            zztd2._d()._a(0, n5, 0);
        }
    }

    public boolean _d() {
        return true;
    }

    public int _e() {
        return this._c;
    }

    public int _f() {
        return this._d;
    }
}


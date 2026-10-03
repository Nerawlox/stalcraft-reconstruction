/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ozrz
extends aqgq {
    public zztf _a;
    public List _c;
    public List _d;
    public ArrayList _e = new ArrayList();

    public ozrz() {
    }

    public ozrz(Random random, int n, int n2) {
        super(random, n, n2);
        this._c = new ArrayList();
        for (zztf zztf2 : yfov._b()) {
            zztf2._c = 0;
            this._c.add(zztf2);
        }
        this._d = new ArrayList();
        for (zztf zztf2 : yfov._c()) {
            zztf2._c = 0;
            this._d.add(zztf2);
        }
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
    }
}


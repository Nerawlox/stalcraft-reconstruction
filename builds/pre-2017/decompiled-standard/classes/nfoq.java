/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class nfoq
extends tycc {
    public boolean _e;

    public nfoq() {
    }

    public nfoq(ozlu ozlu2, Random random, int n, int n2, int n3) {
        super(n, n2);
        int n4;
        List list2 = tybp._a(random, n3);
        fovt fovt2 = new fovt(ozlu2.func_72959_q(), 0, random, (n << 4) + 2, (n2 << 4) + 2, list2, n3);
        this._a.add(fovt2);
        fovt2._a(fovt2, this._a, random);
        List list3 = fovt2._l;
        List list4 = fovt2._k;
        while (!list3.isEmpty() || !list4.isEmpty()) {
            Object object;
            if (list3.isEmpty()) {
                n4 = random.nextInt(list4.size());
                object = (zztd)list4.remove(n4);
                ((zztd)object)._a(fovt2, this._a, random);
                continue;
            }
            n4 = random.nextInt(list3.size());
            object = (zztd)list3.remove(n4);
            ((zztd)object)._a(fovt2, this._a, random);
        }
        this._c();
        n4 = 0;
        for (zztd zztd2 : this._a) {
            if (zztd2 instanceof yfll) continue;
            ++n4;
        }
        this._e = n4 > 2;
    }

    @Override
    public boolean _d() {
        return this._e;
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Valid", this._e);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._e = qoac2._o("Valid");
    }
}


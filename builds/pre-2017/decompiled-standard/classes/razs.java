/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class razs
extends tycc {
    public razs() {
    }

    public razs(ozlu ozlu2, Random random, int n, int n2) {
        super(n, n2);
        iyda._b();
        xciz xciz2 = new xciz(0, random, (n << 4) + 2, (n2 << 4) + 2);
        this._a.add(xciz2);
        xciz2._a(xciz2, this._a, random);
        List list2 = xciz2._e;
        while (!list2.isEmpty()) {
            int n3 = random.nextInt(list2.size());
            zztd zztd2 = (zztd)list2.remove(n3);
            zztd2._a(xciz2, this._a, random);
        }
        this._c();
        this._a(ozlu2, random, 10);
    }
}


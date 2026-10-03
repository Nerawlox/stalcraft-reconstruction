/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Random;

public class dzua
extends tycc {
    public dzua() {
    }

    public dzua(ozlu ozlu2, Random random, int n, int n2) {
        super(n, n2);
        ozrz ozrz2 = new ozrz(random, (n << 4) + 2, (n2 << 4) + 2);
        this._a.add(ozrz2);
        ozrz2._a(ozrz2, this._a, random);
        ArrayList arrayList = ozrz2._e;
        while (!arrayList.isEmpty()) {
            int n3 = random.nextInt(arrayList.size());
            zztd zztd2 = (zztd)arrayList.remove(n3);
            zztd2._a(ozrz2, this._a, random);
        }
        this._c();
        this._a(ozlu2, random, 48, 70);
    }
}


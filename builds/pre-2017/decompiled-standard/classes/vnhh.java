/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class vnhh
extends tycc {
    public vnhh() {
    }

    public vnhh(ozlu ozlu2, Random random, int n, int n2) {
        super(n, n2);
        foqh foqh2 = ozlu2.func_72807_a(n * 16 + 8, n2 * 16 + 8);
        if (foqh2 == foqh._w || foqh2 == foqh._x) {
            zipx zipx2 = new zipx(random, n * 16, n2 * 16);
            this._a.add(zipx2);
        } else if (foqh2 == foqh._h) {
            nfmv nfmv2 = new nfmv(random, n * 16, n2 * 16);
            this._a.add(nfmv2);
        } else {
            qowq qowq2 = new qowq(random, n * 16, n2 * 16);
            this._a.add(qowq2);
        }
        this._c();
    }
}


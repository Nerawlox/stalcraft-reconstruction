/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class zhua
extends zhqo {
    public zhua(int n, int n2) {
        super(n, n2, nvsz._h);
        this._a("durability");
    }

    @Override
    public int _a(int n) {
        return 5 + (n - 1) * 8;
    }

    @Override
    public int _b(int n) {
        return super._a(n) + 50;
    }

    @Override
    public int _c() {
        return 3;
    }

    @Override
    public boolean _a(cvzo cvzo2) {
        if (cvzo2._f()) {
            return true;
        }
        return super._a(cvzo2);
    }

    public static boolean _a(cvzo cvzo2, int n, Random random) {
        if (cvzo2._a() instanceof lpno && random.nextFloat() < 0.6f) {
            return false;
        }
        return random.nextInt(n + 1) > 0;
    }
}


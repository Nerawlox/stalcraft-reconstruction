/*
 * Decompiled with CFR 0.152.
 */
public class ogev
extends ntvb {
    public ogev() {
        super(30);
    }

    @Override
    public int _a(int n) {
        if (n == 0) {
            return 0xFFFFFF;
        }
        if (n < 0) {
            return 0xCF0000;
        }
        return 52992;
    }

    @Override
    public String _a() {
        return "\u041e\u0447\u043a\u0438 \u0440\u0435\u0441\u0443\u0440\u0441\u043e\u0432 ";
    }
}


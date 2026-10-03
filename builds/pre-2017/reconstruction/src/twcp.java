/*
 * Decompiled with CFR 0.152.
 */
public class twcp {
    public static twcp _a = new twcp();
    public static final int _b = 0;
    public static final int _c = 1;
    public static final int _d = 2;
    public static final int _e = 3;
    public static final int _f = 4;
    public static final int _g = 5;
    public static final int _h = 6;
    public static final int _i = 7;

    public mamj _a(int n, float f, float f2, boolean bl) {
        switch (n) {
            case 1: {
                return new ogso(f, f2, bl);
            }
            case 2: {
                return new uien(f, f2, bl);
            }
            case 3: {
                return new nuql(f, f2, bl);
            }
            case 4: {
                return new xaly(f, f2, bl);
            }
            case 5: {
                return new ndpk(f, f2, bl);
            }
            case 6: {
                return new dgtl(f, f2, bl);
            }
            case 7: {
                return new htah(f, f2, bl);
            }
        }
        return null;
    }

    public String _a(int n) {
        switch (n) {
            case 1: {
                return "\u0410\u0432\u0442\u043e\u043c\u0430\u0442";
            }
            case 2: {
                return "\u041f\u0438\u0441\u0442\u043e\u043b\u0435\u0442";
            }
            case 3: {
                return "\u0414\u0440\u043e\u0431\u043e\u0432\u0438\u043a";
            }
            case 4: {
                return "\u0412\u0438\u043d\u0442\u043e\u0432\u043a\u0430";
            }
            case 5: {
                return "\u041c\u0438\u043d\u0438\u0433\u0430\u043d";
            }
            case 6: {
                return "\u0413\u043b\u0443\u0448\u0438\u0442\u0435\u043b\u044c";
            }
            case 7: {
                return "\u0413\u0430\u0443\u0441\u0441";
            }
        }
        return "\u041d\u0435\u0442";
    }

    public void _b(int n) {
        if (n != 0) {
            fmib._e(mamj._g);
        }
        switch (n) {
            case 1: {
                fmib._b(ogso._c);
                break;
            }
            case 2: {
                fmib._b(uien._c);
                break;
            }
            case 3: {
                fmib._b(nuql._d);
                break;
            }
            case 4: {
                fmib._b(xaly._c);
                break;
            }
            case 5: {
                fmib._b(ndpk._b);
                break;
            }
            case 6: {
                fmib._b(dgtl._c);
                break;
            }
            case 7: {
                fmib._b(htah._d);
            }
        }
    }

    public int _a() {
        return 7;
    }
}


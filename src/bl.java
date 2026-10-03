/*
 * Decompiled with CFR 0.152.
 */
public enum bl {
    a(0, 1, 0, -1, 0),
    b(1, 0, 0, 1, 0),
    c(2, 3, 0, 0, -1),
    d(3, 2, 0, 0, 1),
    e(4, 5, -1, 0, 0),
    f(5, 4, 1, 0, 0);

    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private static final bl[] l;

    private bl(int par3, int par4, int par5, int par6, int par7) {
        this.g = par3;
        this.h = par4;
        this.i = par5;
        this.j = par6;
        this.k = par7;
    }

    public int c() {
        return this.i;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public static bl a(int par0) {
        return l[par0 % l.length];
    }

    static {
        l = new bl[6];
        bl[] var0 = bl.values();
        int var1 = var0.length;
        for (int var2 = 0; var2 < var1; ++var2) {
            bl var3;
            bl.l[var3.g] = var3 = var0[var2];
        }
    }
}


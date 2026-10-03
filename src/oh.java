/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  rn
 *  se
 *  th
 */
public enum oh {
    a(th.class, 70, akc.a, false, false),
    b(rp.class, 10, akc.a, true, true),
    c(rn.class, 15, akc.a, true, false),
    d(se.class, 5, akc.h, true, false);

    private final Class e;
    private final int f;
    private final akc g;
    private final boolean h;
    private final boolean i;

    private oh(Class par3Class, int par4, akc par5Material, boolean par6, boolean par7) {
        this.e = par3Class;
        this.f = par4;
        this.g = par5Material;
        this.h = par6;
        this.i = par7;
    }

    public Class a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public akc c() {
        return this.g;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }
}


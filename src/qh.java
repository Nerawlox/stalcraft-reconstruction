/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ps
 */
public class qh
extends ps {
    private sd a;
    private ub b;
    private int c;

    public qh(sd par1EntityIronGolem) {
        this.a = par1EntityIronGolem;
        this.a(3);
    }

    public boolean a() {
        if (!this.a.q.v()) {
            return false;
        }
        if (this.a.aD().nextInt(8000) != 0) {
            return false;
        }
        this.b = (ub)((Object)this.a.q.a(ub.class, this.a.E.b(6.0, 2.0, 6.0), (nn)((Object)this.a)));
        return this.b != null;
    }

    public boolean b() {
        return this.c > 0;
    }

    public void c() {
        this.c = 400;
        this.a.a(true);
    }

    public void d() {
        this.a.a(false);
        this.b = null;
    }

    public void e() {
        this.a.h().a((nn)((Object)this.b), 30.0f, 30.0f);
        --this.c;
    }
}


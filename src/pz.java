/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ps
 */
public class pz
extends ps {
    private ub b;
    private ub c;
    private abw d;
    private int e;
    rj a;

    public pz(ub par1EntityVillager) {
        this.b = par1EntityVillager;
        this.d = par1EntityVillager.q;
        this.a(3);
    }

    public boolean a() {
        if (this.b.b() != 0) {
            return false;
        }
        if (this.b.aD().nextInt(500) != 0) {
            return false;
        }
        this.a = this.d.A.a(ls.c(this.b.u), ls.c(this.b.v), ls.c(this.b.w), 0);
        if (this.a == null) {
            return false;
        }
        if (!this.f()) {
            return false;
        }
        nn entity = this.d.a(ub.class, this.b.E.b(8.0, 3.0, 8.0), (nn)((Object)this.b));
        if (entity == null) {
            return false;
        }
        this.c = (ub)((Object)entity);
        return this.c.b() == 0;
    }

    public void c() {
        this.e = 300;
        this.b.i(true);
    }

    public void d() {
        this.a = null;
        this.c = null;
        this.b.i(false);
    }

    public boolean b() {
        return this.e >= 0 && this.f() && this.b.b() == 0;
    }

    public void e() {
        --this.e;
        this.b.h().a((nn)((Object)this.c), 10.0f, 30.0f);
        if (this.b.e((nn)((Object)this.c)) > 2.25) {
            this.b.k().a((nn)((Object)this.c), 0.25);
        } else if (this.e == 0 && this.c.bU()) {
            this.g();
        }
        if (this.b.aD().nextInt(35) == 0) {
            this.d.a((nn)((Object)this.b), (byte)12);
        }
    }

    private boolean f() {
        if (!this.a.i()) {
            return false;
        }
        int i2 = (int)((double)this.a.c() * 0.35);
        return this.a.e() < i2;
    }

    private void g() {
        ub entityvillager = this.b.b(this.c);
        this.c.c(6000);
        this.b.c(6000);
        entityvillager.c(-24000);
        entityvillager.b(this.b.u, this.b.v, this.b.w, 0.0f, 0.0f);
        this.d.d((nn)((Object)entityvillager));
        this.d.a((nn)((Object)entityvillager), (byte)12);
    }
}


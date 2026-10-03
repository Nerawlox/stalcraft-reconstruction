/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nk
 *  oa
 *  ps
 */
import java.util.List;
import java.util.Random;

public class pk
extends ps {
    private rp d;
    abw a;
    private rp e;
    int b;
    double c;

    public pk(rp par1EntityAnimal, double par2) {
        this.d = par1EntityAnimal;
        this.a = par1EntityAnimal.q;
        this.c = par2;
        this.a(3);
    }

    public boolean a() {
        if (!this.d.bY()) {
            return false;
        }
        this.e = this.f();
        return this.e != null;
    }

    public boolean b() {
        return this.e.T() && this.e.bY() && this.b < 60;
    }

    public void d() {
        this.e = null;
        this.b = 0;
    }

    public void e() {
        this.d.h().a((nn)((Object)this.e), 10.0f, (float)this.d.bp());
        this.d.k().a((nn)((Object)this.e), this.c);
        ++this.b;
        if (this.b >= 60 && this.d.e((nn)((Object)this.e)) < 9.0) {
            this.g();
        }
    }

    private rp f() {
        float f2 = 8.0f;
        List list = this.a.a(((Object)((Object)this.d)).getClass(), this.d.E.b((double)f2, (double)f2, (double)f2));
        double d0 = Double.MAX_VALUE;
        rp entityanimal = null;
        for (rp entityanimal1 : list) {
            if (!this.d.a(entityanimal1) || !(this.d.e((nn)((Object)entityanimal1)) < d0)) continue;
            entityanimal = entityanimal1;
            d0 = this.d.e((nn)((Object)entityanimal1));
        }
        return entityanimal;
    }

    private void g() {
        nk entityageable = this.d.a(this.e);
        if (entityageable != null) {
            this.d.c(6000);
            this.e.c(6000);
            this.d.bZ();
            this.e.bZ();
            entityageable.c(-24000);
            entityageable.b(this.d.u, this.d.v, this.d.w, 0.0f, 0.0f);
            this.a.d((nn)entityageable);
            Random random = this.d.aD();
            for (int i2 = 0; i2 < 7; ++i2) {
                double d0 = random.nextGaussian() * 0.02;
                double d1 = random.nextGaussian() * 0.02;
                double d2 = random.nextGaussian() * 0.02;
                this.a.a("heart", this.d.u + (double)(random.nextFloat() * this.d.O * 2.0f) - (double)this.d.O, this.d.v + 0.5 + (double)(random.nextFloat() * this.d.P), this.d.w + (double)(random.nextFloat() * this.d.O * 2.0f) - (double)this.d.O, d0, d1, d2);
            }
            this.a.d((nn)new oa(this.a, this.d.u, this.d.v, this.d.w, random.nextInt(7) + 1));
        }
    }
}


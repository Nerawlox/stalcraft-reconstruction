/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ps
 */
import java.util.List;

public class pr
extends ps {
    rp a;
    rp b;
    double c;
    private int d;

    public pr(rp par1EntityAnimal, double par2) {
        this.a = par1EntityAnimal;
        this.c = par2;
    }

    public boolean a() {
        if (this.a.b() >= 0) {
            return false;
        }
        List list = this.a.q.a(((Object)((Object)this.a)).getClass(), this.a.E.b(8.0, 4.0, 8.0));
        rp entityanimal = null;
        double d0 = Double.MAX_VALUE;
        for (rp entityanimal1 : list) {
            double d1;
            if (entityanimal1.b() < 0 || !((d1 = this.a.e((nn)((Object)entityanimal1))) <= d0)) continue;
            d0 = d1;
            entityanimal = entityanimal1;
        }
        if (entityanimal == null) {
            return false;
        }
        if (d0 < 9.0) {
            return false;
        }
        this.b = entityanimal;
        return true;
    }

    public boolean b() {
        if (!this.b.T()) {
            return false;
        }
        double d0 = this.a.e((nn)((Object)this.b));
        return d0 >= 9.0 && d0 <= 256.0;
    }

    public void c() {
        this.d = 0;
    }

    public void d() {
        this.b = null;
    }

    public void e() {
        if (--this.d <= 0) {
            this.d = 10;
            this.a.k().a((nn)((Object)this.b), this.c);
        }
    }
}


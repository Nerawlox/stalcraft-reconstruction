/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atc
 *  ps
 *  rh
 */
import java.util.List;

public class qk
extends ps {
    private ub a;
    private of b;
    private double c;
    private int d;

    public qk(ub par1EntityVillager, double par2) {
        this.a = par1EntityVillager;
        this.c = par2;
        this.a(1);
    }

    public boolean a() {
        atc vec3;
        if (this.a.b() >= 0) {
            return false;
        }
        if (this.a.aD().nextInt(400) != 0) {
            return false;
        }
        List list = this.a.q.a(ub.class, this.a.E.b(6.0, 3.0, 6.0));
        double d0 = Double.MAX_VALUE;
        for (ub entityvillager : list) {
            double d1;
            if (entityvillager == this.a || entityvillager.bV() || entityvillager.b() >= 0 || !((d1 = entityvillager.e((nn)((Object)this.a))) <= d0)) continue;
            d0 = d1;
            this.b = entityvillager;
        }
        return this.b != null || (vec3 = rh.a((on)((Object)this.a), (int)16, (int)3)) != null;
    }

    public boolean b() {
        return this.d > 0;
    }

    public void c() {
        if (this.b != null) {
            this.a.j(true);
        }
        this.d = 1000;
    }

    public void d() {
        this.a.j(false);
        this.b = null;
    }

    public void e() {
        --this.d;
        if (this.b != null) {
            if (this.a.e(this.b) > 4.0) {
                this.a.k().a((nn)this.b, this.c);
            }
        } else if (this.a.k().g()) {
            atc vec3 = rh.a((on)((Object)this.a), (int)16, (int)3);
            if (vec3 == null) {
                return;
            }
            this.a.k().a(vec3.c, vec3.d, vec3.e, this.c);
        }
    }
}


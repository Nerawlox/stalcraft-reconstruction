/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alf
 *  atc
 *  nw
 *  oq
 *  ph
 *  ps
 *  rf
 *  rh
 */
import java.util.List;

public class pg
extends ps {
    public final nw a = new ph(this);
    private on b;
    private double c;
    private double d;
    private nn e;
    private float f;
    private alf g;
    private rf h;
    private Class i;

    public pg(on par1EntityCreature, Class par2Class, float par3, double par4, double par6) {
        this.b = par1EntityCreature;
        this.i = par2Class;
        this.f = par3;
        this.c = par4;
        this.d = par6;
        this.h = par1EntityCreature.k();
        this.a(1);
    }

    public boolean a() {
        atc vec3;
        if (this.i == uf.class) {
            if (this.b instanceof oq && ((oq)this.b).bT()) {
                return false;
            }
            this.e = this.b.q.a((nn)this.b, (double)this.f);
            if (this.e == null) {
                return false;
            }
        } else {
            List list = this.b.q.a(this.i, this.b.E.b((double)this.f, 3.0, (double)this.f), this.a);
            if (list.isEmpty()) {
                return false;
            }
            this.e = (nn)list.get(0);
        }
        if ((vec3 = rh.b((on)this.b, (int)16, (int)7, (atc)this.b.q.V().a(this.e.u, this.e.v, this.e.w))) == null) {
            return false;
        }
        if (this.e.e(vec3.c, vec3.d, vec3.e) < this.e.e(this.b)) {
            return false;
        }
        this.g = this.h.a(vec3.c, vec3.d, vec3.e);
        return this.g == null ? false : this.g.b(vec3);
    }

    public boolean b() {
        return !this.h.g();
    }

    public void c() {
        this.h.a(this.g, this.c);
    }

    public void d() {
        this.e = null;
    }

    public void e() {
        if (this.b.e(this.e) < 49.0) {
            this.b.k().a(this.d);
        } else {
            this.b.k().a(this.c);
        }
    }

    static on a(pg par0EntityAIAvoidEntity) {
        return par0EntityAIAvoidEntity.b;
    }
}


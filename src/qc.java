/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alf
 *  atc
 *  ps
 *  rh
 *  ri
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qc
extends ps {
    private on a;
    private double b;
    private alf c;
    private ri d;
    private boolean e;
    private List f = new ArrayList();

    public qc(on par1EntityCreature, double par2, boolean par4) {
        this.a = par1EntityCreature;
        this.b = par2;
        this.e = par4;
        this.a(1);
    }

    public boolean a() {
        this.f();
        if (this.e && this.a.q.v()) {
            return false;
        }
        rj village = this.a.q.A.a(ls.c(this.a.u), ls.c(this.a.v), ls.c(this.a.w), 0);
        if (village == null) {
            return false;
        }
        this.d = this.a(village);
        if (this.d == null) {
            return false;
        }
        boolean flag = this.a.k().c();
        this.a.k().b(false);
        this.c = this.a.k().a((double)this.d.a, (double)this.d.b, (double)this.d.c);
        this.a.k().b(flag);
        if (this.c != null) {
            return true;
        }
        atc vec3 = rh.a((on)this.a, (int)10, (int)7, (atc)this.a.q.V().a((double)this.d.a, (double)this.d.b, (double)this.d.c));
        if (vec3 == null) {
            return false;
        }
        this.a.k().b(false);
        this.c = this.a.k().a(vec3.c, vec3.d, vec3.e);
        this.a.k().b(flag);
        return this.c != null;
    }

    public boolean b() {
        if (this.a.k().g()) {
            return false;
        }
        float f2 = this.a.O + 4.0f;
        return this.a.e(this.d.a, this.d.b, this.d.c) > (double)(f2 * f2);
    }

    public void c() {
        this.a.k().a(this.c, this.b);
    }

    public void d() {
        if (this.a.k().g() || this.a.e(this.d.a, this.d.b, this.d.c) < 16.0) {
            this.f.add(this.d);
        }
    }

    private ri a(rj par1Village) {
        ri villagedoorinfo = null;
        int i2 = Integer.MAX_VALUE;
        List list = par1Village.f();
        for (ri villagedoorinfo1 : list) {
            int j2 = villagedoorinfo1.b(ls.c(this.a.u), ls.c(this.a.v), ls.c(this.a.w));
            if (j2 >= i2 || this.a(villagedoorinfo1)) continue;
            villagedoorinfo = villagedoorinfo1;
            i2 = j2;
        }
        return villagedoorinfo;
    }

    private boolean a(ri par1VillageDoorInfo) {
        ri villagedoorinfo1;
        Iterator iterator = this.f.iterator();
        do {
            if (!iterator.hasNext()) {
                return false;
            }
            villagedoorinfo1 = (ri)iterator.next();
        } while (par1VillageDoorInfo.a != villagedoorinfo1.a || par1VillageDoorInfo.b != villagedoorinfo1.b || par1VillageDoorInfo.c != villagedoorinfo1.c);
        return true;
    }

    private void f() {
        if (this.f.size() > 15) {
            this.f.remove(0);
        }
    }
}


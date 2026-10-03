/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ps
 */
import java.util.List;

public class qt
extends ps {
    private ub a;
    private sd b;
    private int c;
    private boolean d;

    public qt(ub par1EntityVillager) {
        this.a = par1EntityVillager;
        this.a(3);
    }

    public boolean a() {
        if (this.a.b() >= 0) {
            return false;
        }
        if (!this.a.q.v()) {
            return false;
        }
        List list = this.a.q.a(sd.class, this.a.E.b(6.0, 2.0, 6.0));
        if (list.isEmpty()) {
            return false;
        }
        for (sd entityirongolem : list) {
            if (entityirongolem.bV() <= 0) continue;
            this.b = entityirongolem;
            break;
        }
        return this.b != null;
    }

    public boolean b() {
        return this.b.bV() > 0;
    }

    public void c() {
        this.c = this.a.aD().nextInt(320);
        this.d = false;
        this.b.k().h();
    }

    public void d() {
        this.b = null;
        this.a.k().h();
    }

    public void e() {
        this.a.h().a((nn)((Object)this.b), 30.0f, 30.0f);
        if (this.b.bV() == this.c) {
            this.a.k().a((nn)((Object)this.b), 0.5);
            this.d = true;
        }
        if (this.d && this.a.e((nn)((Object)this.b)) < 4.0) {
            this.b.a(false);
            this.a.k().h();
        }
    }
}


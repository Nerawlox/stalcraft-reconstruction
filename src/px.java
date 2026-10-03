/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ps
 */
public class px
extends ps {
    private og b;
    protected nn a;
    private float c;
    private int d;
    private float e;
    private Class f;

    public px(og par1EntityLiving, Class par2Class, float par3) {
        this.b = par1EntityLiving;
        this.f = par2Class;
        this.c = par3;
        this.e = 0.02f;
        this.a(2);
    }

    public px(og par1EntityLiving, Class par2Class, float par3, float par4) {
        this.b = par1EntityLiving;
        this.f = par2Class;
        this.c = par3;
        this.e = par4;
        this.a(2);
    }

    public boolean a() {
        if (this.b.aD().nextFloat() >= this.e) {
            return false;
        }
        if (this.b.m() != null) {
            this.a = this.b.m();
        }
        this.a = this.f == uf.class ? this.b.q.a((nn)this.b, (double)this.c) : this.b.q.a(this.f, this.b.E.b((double)this.c, 3.0, (double)this.c), (nn)this.b);
        return this.a != null;
    }

    public boolean b() {
        return !this.a.T() ? false : (this.b.e(this.a) > (double)(this.c * this.c) ? false : this.d > 0);
    }

    public void c() {
        this.d = 40 + this.b.aD().nextInt(40);
    }

    public void d() {
        this.a = null;
    }

    public void e() {
        this.b.h().a(this.a.u, this.a.v + (double)this.a.f(), this.a.w, 10.0f, this.b.bp());
        --this.d;
    }
}


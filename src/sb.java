/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nb
 *  ps
 *  qm
 *  qn
 *  qy
 *  rv
 *  th
 *  to
 *  up
 */
public class sb
extends rv
implements to {
    public sb(abw par1World) {
        super(par1World);
        this.a(0.4f, 1.8f);
        this.k().a(true);
        this.c.a(1, (ps)new qn((to)this, 1.25, 20, 10.0f));
        this.c.a(2, (ps)new qm((on)((Object)this), 1.0));
        this.c.a(3, (ps)new px((og)((Object)this), uf.class, 6.0f));
        this.c.a(4, (ps)new ql((og)((Object)this)));
        this.d.a(1, (ps)new qy((on)((Object)this), og.class, 0, true, false, th.a));
    }

    public boolean bf() {
        return true;
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(4.0);
        this.a(tp.d).a((double)0.2f);
    }

    public void c() {
        int j2;
        int i2;
        super.c();
        if (this.G()) {
            this.a(nb.e, 1.0f);
        }
        if (this.q.a(i2 = ls.c(this.u), j2 = ls.c(this.w)).j() > 1.0f) {
            this.a(nb.b, 1.0f);
        }
        for (i2 = 0; i2 < 4; ++i2) {
            int l2;
            int k2;
            j2 = ls.c(this.u + (double)((float)(i2 % 2 * 2 - 1) * 0.25f));
            if (this.q.a(j2, k2 = ls.c(this.v), l2 = ls.c(this.w + (double)((float)(i2 / 2 % 2 * 2 - 1) * 0.25f))) != 0 || !(this.q.a(j2, l2).j() < 0.8f) || !aqz.aX.c(this.q, j2, k2, l2)) continue;
            this.q.c(j2, k2, l2, aqz.aX.cF);
        }
    }

    protected int s() {
        return yc.aF.cv;
    }

    protected void b(boolean par1, int par2) {
        int j2 = this.ab.nextInt(16);
        for (int k2 = 0; k2 < j2; ++k2) {
            this.b(yc.aF.cv, 1);
        }
    }

    public void a(of par1EntityLivingBase, float par2) {
        up entitysnowball = new up(this.q, (of)((Object)this));
        double d0 = par1EntityLivingBase.u - this.u;
        double d1 = par1EntityLivingBase.v + (double)par1EntityLivingBase.f() - (double)1.1f - entitysnowball.v;
        double d2 = par1EntityLivingBase.w - this.w;
        float f1 = ls.a(d0 * d0 + d2 * d2) * 0.2f;
        entitysnowball.c(d0, d1 + (double)f1, d2, 1.6f, 12.0f);
        this.a("random.bow", 1.0f, 1.0f / (this.aD().nextFloat() * 0.4f + 0.8f));
        this.q.d((nn)entitysnowball);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nk
 *  pp
 *  ps
 *  qj
 *  qm
 *  qu
 *  yw
 */
public class rq
extends rp {
    public float bp;
    public float bq;
    public float br;
    public float bs;
    public float bt = 1.0f;
    public int bu;

    public rq(abw par1World) {
        super(par1World);
        this.a(0.3f, 0.7f);
        this.bu = this.ab.nextInt(6000) + 6000;
        this.c.a(0, (ps)new pp((og)((Object)this)));
        this.c.a(1, (ps)new qj((on)((Object)this), 1.4));
        this.c.a(2, (ps)new pk(this, 1.0));
        this.c.a(3, (ps)new qu((on)((Object)this), 1.0, yc.U.cv, false));
        this.c.a(4, (ps)new pr(this, 1.1));
        this.c.a(5, (ps)new qm((on)((Object)this), 1.0));
        this.c.a(6, (ps)new px((og)((Object)this), uf.class, 6.0f));
        this.c.a(7, (ps)new ql((og)((Object)this)));
    }

    public boolean bf() {
        return true;
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(4.0);
        this.a(tp.d).a(0.25);
    }

    @Override
    public void c() {
        super.c();
        this.bs = this.bp;
        this.br = this.bq;
        this.bq = (float)((double)this.bq + (double)(this.F ? -1 : 4) * 0.3);
        if (this.bq < 0.0f) {
            this.bq = 0.0f;
        }
        if (this.bq > 1.0f) {
            this.bq = 1.0f;
        }
        if (!this.F && this.bt < 1.0f) {
            this.bt = 1.0f;
        }
        this.bt = (float)((double)this.bt * 0.9);
        if (!this.F && this.y < 0.0) {
            this.y *= 0.6;
        }
        this.bp += this.bt * 2.0f;
        if (!this.g_() && !this.q.I && --this.bu <= 0) {
            this.a("mob.chicken.plop", 1.0f, (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
            this.b(yc.aR.cv, 1);
            this.bu = this.ab.nextInt(6000) + 6000;
        }
    }

    protected void b(float par1) {
    }

    protected String r() {
        return "mob.chicken.say";
    }

    protected String aO() {
        return "mob.chicken.hurt";
    }

    protected String aP() {
        return "mob.chicken.hurt";
    }

    protected void a(int par1, int par2, int par3, int par4) {
        this.a("mob.chicken.step", 0.15f, 1.0f);
    }

    protected int s() {
        return yc.N.cv;
    }

    protected void b(boolean par1, int par2) {
        int j2 = this.ab.nextInt(3) + this.ab.nextInt(1 + par2);
        for (int k2 = 0; k2 < j2; ++k2) {
            this.b(yc.N.cv, 1);
        }
        if (this.af()) {
            this.b(yc.bn.cv, 1);
        } else {
            this.b(yc.bm.cv, 1);
        }
    }

    public rq b(nk par1EntityAgeable) {
        return new rq(this.q);
    }

    @Override
    public boolean c(ye par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.b() instanceof yw;
    }

    public nk a(nk par1EntityAgeable) {
        return this.b(par1EntityAgeable);
    }
}


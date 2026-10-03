/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ni
 *  oi
 *  tu
 */
public class tt
extends tm {
    public tt(abw par1World) {
        super(par1World);
        this.a(1.4f, 0.9f);
    }

    @Override
    protected void a() {
        super.a();
        this.ah.a(16, new Byte(0));
    }

    @Override
    public void l_() {
        super.l_();
        if (!this.q.I) {
            this.a(this.G);
        }
    }

    @Override
    protected void az() {
        super.az();
        this.a(tp.a).a(16.0);
        this.a(tp.d).a((double)0.8f);
    }

    @Override
    protected nn bL() {
        float f2 = this.d(1.0f);
        if (f2 < 0.5f) {
            double d0 = 16.0;
            return this.q.b((nn)this, d0);
        }
        return null;
    }

    @Override
    protected String r() {
        return "mob.spider.say";
    }

    @Override
    protected String aO() {
        return "mob.spider.say";
    }

    @Override
    protected String aP() {
        return "mob.spider.death";
    }

    @Override
    protected void a(int par1, int par2, int par3, int par4) {
        this.a("mob.spider.step", 0.15f, 1.0f);
    }

    @Override
    protected void a(nn par1Entity, float par2) {
        float f1 = this.d(1.0f);
        if (f1 > 0.5f && this.ab.nextInt(100) == 0) {
            this.j = null;
        } else if (par2 > 2.0f && par2 < 6.0f && this.ab.nextInt(10) == 0) {
            if (this.F) {
                double d0 = par1Entity.u - this.u;
                double d1 = par1Entity.w - this.w;
                float f2 = ls.a(d0 * d0 + d1 * d1);
                this.x = d0 / (double)f2 * 0.5 * (double)0.8f + this.x * (double)0.2f;
                this.z = d1 / (double)f2 * 0.5 * (double)0.8f + this.z * (double)0.2f;
                this.y = 0.4f;
            }
        } else {
            super.a(par1Entity, par2);
        }
    }

    @Override
    protected int s() {
        return yc.M.cv;
    }

    @Override
    protected void b(boolean par1, int par2) {
        super.b(par1, par2);
        if (par1 && (this.ab.nextInt(3) == 0 || this.ab.nextInt(1 + par2) > 0)) {
            this.b(yc.bw.cv, 1);
        }
    }

    @Override
    public boolean e() {
        return this.bT();
    }

    @Override
    public void am() {
    }

    @Override
    public oj aY() {
        return oj.c;
    }

    @Override
    public boolean d(nj par1PotionEffect) {
        return par1PotionEffect.a() == ni.u.H ? false : super.d(par1PotionEffect);
    }

    public boolean bT() {
        return (this.ah.a(16) & 1) != 0;
    }

    public void a(boolean par1) {
        byte b0 = this.ah.a(16);
        b0 = par1 ? (byte)(b0 | 1) : (byte)(b0 & 0xFFFFFFFE);
        this.ah.b(16, b0);
    }

    @Override
    public oi a(oi par1EntityLivingData) {
        int i2;
        oi par1EntityLivingData1 = super.a(par1EntityLivingData);
        if (this.q.s.nextInt(100) == 0) {
            tr entityskeleton = new tr(this.q);
            entityskeleton.b(this.u, this.v, this.w, this.A, 0.0f);
            entityskeleton.a((oi)null);
            this.q.d(entityskeleton);
            entityskeleton.a((nn)this);
        }
        if (par1EntityLivingData1 == null) {
            par1EntityLivingData1 = new tu();
            if (this.q.r > 2 && this.q.s.nextFloat() < 0.1f * this.q.b(this.u, this.v, this.w)) {
                ((tu)par1EntityLivingData1).a(this.q.s);
            }
        }
        if (par1EntityLivingData1 instanceof tu && (i2 = ((tu)par1EntityLivingData1).a) > 0 && ni.a[i2] != null) {
            this.c(new nj(i2, Integer.MAX_VALUE));
        }
        return par1EntityLivingData1;
    }
}


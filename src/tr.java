/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aau
 *  aaw
 *  aej
 *  kp
 *  ku
 *  nb
 *  ni
 *  oi
 *  po
 *  pp
 *  ps
 *  qa
 *  qm
 *  qn
 *  qp
 *  qx
 *  qy
 *  to
 */
import java.util.Calendar;

public class tr
extends tm
implements to {
    private qn bp = new qn((to)this, 1.0, 20, 60, 15.0f);
    private qa bq = new qa((on)this, uf.class, 1.2, false);

    public tr(abw par1World) {
        super(par1World);
        this.c.a(1, (ps)new pp((og)this));
        this.c.a(2, (ps)new qp((on)this));
        this.c.a(3, (ps)new po((on)this, 1.0));
        this.c.a(5, (ps)new qm((on)this, 1.0));
        this.c.a(6, (ps)new px(this, uf.class, 8.0f));
        this.c.a(6, (ps)new ql(this));
        this.d.a(1, (ps)new qx((on)this, false));
        this.d.a(2, (ps)new qy((on)this, uf.class, 0, true));
        if (par1World != null && !par1World.I) {
            this.bT();
        }
    }

    @Override
    protected void az() {
        super.az();
        this.a(tp.d).a(0.25);
    }

    @Override
    protected void a() {
        super.a();
        this.ah.a(13, new Byte(0));
    }

    @Override
    public boolean bf() {
        return true;
    }

    @Override
    protected String r() {
        return "mob.skeleton.say";
    }

    @Override
    protected String aO() {
        return "mob.skeleton.hurt";
    }

    @Override
    protected String aP() {
        return "mob.skeleton.death";
    }

    @Override
    protected void a(int par1, int par2, int par3, int par4) {
        this.a("mob.skeleton.step", 0.15f, 1.0f);
    }

    @Override
    public boolean m(nn par1Entity) {
        if (super.m(par1Entity)) {
            if (this.bV() == 1 && par1Entity instanceof of) {
                ((of)par1Entity).c(new nj(ni.v.H, 200));
            }
            return true;
        }
        return false;
    }

    @Override
    public oj aY() {
        return oj.b;
    }

    @Override
    public void c() {
        float f2;
        if (this.q.v() && !this.q.I && (f2 = this.d(1.0f)) > 0.5f && this.ab.nextFloat() * 30.0f < (f2 - 0.4f) * 2.0f && this.q.l(ls.c(this.u), ls.c(this.v), ls.c(this.w))) {
            boolean flag = true;
            ye itemstack = this.n(4);
            if (itemstack != null) {
                if (itemstack.g()) {
                    itemstack.b(itemstack.j() + this.ab.nextInt(2));
                    if (itemstack.j() >= itemstack.l()) {
                        this.a(itemstack);
                        this.c(4, null);
                    }
                }
                flag = false;
            }
            if (flag) {
                this.d(8);
            }
        }
        if (this.q.I && this.bV() == 1) {
            this.a(0.72f, 2.34f);
        }
        super.c();
    }

    @Override
    public void V() {
        super.V();
        if (this.o instanceof on) {
            on entitycreature = (on)this.o;
            this.aN = entitycreature.aN;
        }
    }

    @Override
    public void a(nb par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof uh && par1DamageSource.i() instanceof uf) {
            uf entityplayer = (uf)par1DamageSource.i();
            double d0 = entityplayer.u - this.u;
            double d1 = entityplayer.w - this.w;
            if (d0 * d0 + d1 * d1 >= 2500.0) {
                entityplayer.a((ku)kp.v);
            }
        }
    }

    @Override
    protected int s() {
        return yc.n.cv;
    }

    @Override
    protected void b(boolean par1, int par2) {
        int k2;
        int j2;
        if (this.bV() == 1) {
            j2 = this.ab.nextInt(3 + par2) - 1;
            for (k2 = 0; k2 < j2; ++k2) {
                this.b(yc.o.cv, 1);
            }
        } else {
            j2 = this.ab.nextInt(3 + par2);
            for (k2 = 0; k2 < j2; ++k2) {
                this.b(yc.n.cv, 1);
            }
        }
        j2 = this.ab.nextInt(3 + par2);
        for (k2 = 0; k2 < j2; ++k2) {
            this.b(yc.aZ.cv, 1);
        }
    }

    @Override
    protected void l(int par1) {
        if (this.bV() == 1) {
            this.a(new ye(yc.bS.cv, 1, 1), 0.0f);
        }
    }

    @Override
    protected void bw() {
        super.bw();
        this.c(0, new ye((yc)yc.m));
    }

    @Override
    public oi a(oi par1EntityLivingData) {
        Calendar calendar;
        par1EntityLivingData = super.a(par1EntityLivingData);
        if (this.q.t instanceof aej && this.aD().nextInt(5) > 0) {
            this.c.a(4, (ps)this.bq);
            this.a(1);
            this.c(0, new ye(yc.x));
            this.a(tp.e).a(4.0);
        } else {
            this.c.a(4, (ps)this.bp);
            this.bw();
            this.bx();
        }
        this.h(this.ab.nextFloat() < 0.55f * this.q.b(this.u, this.v, this.w));
        if (this.n(4) == null && (calendar = this.q.W()).get(2) + 1 == 10 && calendar.get(5) == 31 && this.ab.nextFloat() < 0.25f) {
            this.c(4, new ye(this.ab.nextFloat() < 0.1f ? aqz.bk : aqz.bf));
            this.e[4] = 0.0f;
        }
        return par1EntityLivingData;
    }

    public void bT() {
        this.c.a((ps)this.bq);
        this.c.a((ps)this.bp);
        ye itemstack = this.aZ();
        if (itemstack != null && itemstack.d == yc.m.cv) {
            this.c.a(4, (ps)this.bp);
        } else {
            this.c.a(4, (ps)this.bq);
        }
    }

    public void a(of par1EntityLivingBase, float par2) {
        uh entityarrow = new uh(this.q, this, par1EntityLivingBase, 1.6f, 14 - this.q.r * 4);
        int i2 = aaw.a((int)aau.v.z, (ye)this.aZ());
        int j2 = aaw.a((int)aau.w.z, (ye)this.aZ());
        entityarrow.b((double)(par2 * 2.0f) + this.ab.nextGaussian() * 0.25 + (double)((float)this.q.r * 0.11f));
        if (i2 > 0) {
            entityarrow.b(entityarrow.c() + (double)i2 * 0.5 + 0.5);
        }
        if (j2 > 0) {
            entityarrow.a(j2);
        }
        if (aaw.a((int)aau.x.z, (ye)this.aZ()) > 0 || this.bV() == 1) {
            entityarrow.d(100);
        }
        this.a("random.bow", 1.0f, 1.0f / (this.aD().nextFloat() * 0.4f + 0.8f));
        this.q.d(entityarrow);
    }

    public int bV() {
        return this.ah.a(13);
    }

    public void a(int par1) {
        this.ah.b(13, (byte)par1);
        boolean bl2 = this.ag = par1 == 1;
        if (par1 == 1) {
            this.a(0.72f, 2.34f);
        } else {
            this.a(0.6f, 1.8f);
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        if (par1NBTTagCompound.b("SkeletonType")) {
            byte b0 = par1NBTTagCompound.c("SkeletonType");
            this.a((int)b0);
        }
        this.bT();
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("SkeletonType", (byte)this.bV());
    }

    @Override
    public void c(int par1, ye par2ItemStack) {
        super.c(par1, par2ItemStack);
        if (!this.q.I && par1 == 0) {
            this.bT();
        }
    }

    @Override
    public double X() {
        return super.X() - 0.5;
    }
}


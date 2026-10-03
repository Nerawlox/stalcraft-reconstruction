/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nb
 *  nk
 *  oi
 *  oq
 *  pp
 *  pq
 *  ps
 *  pw
 *  qf
 *  qg
 *  qm
 *  qu
 *  rb
 */
public class rx
extends oq {
    private qu bq;

    public rx(abw par1World) {
        super(par1World);
        this.a(0.6f, 0.8f);
        this.k().a(true);
        this.c.a(1, (ps)new pp((og)((Object)this)));
        this.c.a(2, (ps)this.bp);
        this.bq = new qu((on)((Object)this), 0.6, yc.aW.cv, true);
        this.c.a(3, (ps)this.bq);
        this.c.a(4, (ps)new pg((on)((Object)this), uf.class, 16.0f, 0.8, 1.33));
        this.c.a(5, (ps)new pq((oq)this, 1.0, 10.0f, 5.0f));
        this.c.a(6, (ps)new qg(this, 1.33));
        this.c.a(7, (ps)new pw((og)((Object)this), 0.3f));
        this.c.a(8, (ps)new qf((og)((Object)this)));
        this.c.a(9, (ps)new pk((rp)((Object)this), 0.8));
        this.c.a(10, (ps)new qm((on)((Object)this), 0.8));
        this.c.a(11, (ps)new px((og)((Object)this), uf.class, 10.0f));
        this.d.a(1, (ps)new rb((oq)this, rq.class, 750, false));
    }

    protected void a() {
        super.a();
        this.ah.a(18, (Object)0);
    }

    public void bk() {
        if (this.i().a()) {
            double d0 = this.i().b();
            if (d0 == 0.6) {
                this.b(true);
                this.c(false);
            } else if (d0 == 1.33) {
                this.b(false);
                this.c(true);
            } else {
                this.b(false);
                this.c(false);
            }
        } else {
            this.b(false);
            this.c(false);
        }
    }

    protected boolean t() {
        return !this.bT() && this.ac > 2400;
    }

    public boolean bf() {
        return true;
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(10.0);
        this.a(tp.d).a((double)0.3f);
    }

    protected void b(float par1) {
    }

    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("CatType", this.ca());
    }

    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.p(par1NBTTagCompound.e("CatType"));
    }

    protected String r() {
        return this.bT() ? (this.bY() ? "mob.cat.purr" : (this.ab.nextInt(4) == 0 ? "mob.cat.purreow" : "mob.cat.meow")) : "";
    }

    protected String aO() {
        return "mob.cat.hitt";
    }

    protected String aP() {
        return "mob.cat.hitt";
    }

    protected float ba() {
        return 0.4f;
    }

    protected int s() {
        return yc.aH.cv;
    }

    public boolean m(nn par1Entity) {
        return par1Entity.a(nb.a((of)((Object)this)), 3.0f);
    }

    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        this.bp.a(false);
        return super.a(par1DamageSource, par2);
    }

    protected void b(boolean par1, int par2) {
    }

    public boolean a(uf par1EntityPlayer) {
        ye itemstack = par1EntityPlayer.bn.h();
        if (this.bT()) {
            if (par1EntityPlayer.c_().equalsIgnoreCase(this.h_()) && !this.q.I && !this.c(itemstack)) {
                this.bp.a(!this.bU());
            }
        } else if (this.bq.f() && itemstack != null && itemstack.d == yc.aW.cv && par1EntityPlayer.e((nn)((Object)this)) < 9.0) {
            if (!par1EntityPlayer.bG.d) {
                --itemstack.b;
            }
            if (itemstack.b <= 0) {
                par1EntityPlayer.bn.a(par1EntityPlayer.bn.c, (ye)null);
            }
            if (!this.q.I) {
                if (this.ab.nextInt(3) == 0) {
                    this.j(true);
                    this.p(1 + this.q.s.nextInt(3));
                    this.b(par1EntityPlayer.c_());
                    this.i(true);
                    this.bp.a(true);
                    this.q.a((nn)((Object)this), (byte)7);
                } else {
                    this.i(false);
                    this.q.a((nn)((Object)this), (byte)6);
                }
            }
            return true;
        }
        return super.a(par1EntityPlayer);
    }

    public rx b(nk par1EntityAgeable) {
        rx entityocelot = new rx(this.q);
        if (this.bT()) {
            entityocelot.b(this.h_());
            entityocelot.j(true);
            entityocelot.p(this.ca());
        }
        return entityocelot;
    }

    public boolean c(ye par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.d == yc.aW.cv;
    }

    public boolean a(rp par1EntityAnimal) {
        if (par1EntityAnimal == this) {
            return false;
        }
        if (!this.bT()) {
            return false;
        }
        if (!(par1EntityAnimal instanceof rx)) {
            return false;
        }
        rx entityocelot = (rx)((Object)par1EntityAnimal);
        return !entityocelot.bT() ? false : this.bY() && entityocelot.bY();
    }

    public int ca() {
        return this.ah.a(18);
    }

    public void p(int par1) {
        this.ah.b(18, (byte)par1);
    }

    public boolean bs() {
        if (this.q.s.nextInt(3) == 0) {
            return false;
        }
        if (this.q.b(this.E) && this.q.a((nn)((Object)this), this.E).isEmpty() && !this.q.d(this.E)) {
            int i2 = ls.c(this.u);
            int j2 = ls.c(this.E.b);
            int k2 = ls.c(this.w);
            if (j2 < 63) {
                return false;
            }
            int l2 = this.q.a(i2, j2 - 1, k2);
            aqz block = aqz.s[l2];
            if (l2 == aqz.z.cF || block != null && block.isLeaves(this.q, i2, j2 - 1, k2)) {
                return true;
            }
        }
        return false;
    }

    public String an() {
        return this.bB() ? this.bA() : (this.bT() ? "entity.Cat.name" : super.an());
    }

    public oi a(oi par1EntityLivingData) {
        par1EntityLivingData = super.a(par1EntityLivingData);
        if (this.q.s.nextInt(7) == 0) {
            for (int i2 = 0; i2 < 2; ++i2) {
                rx entityocelot = new rx(this.q);
                entityocelot.b(this.u, this.v, this.w, this.A, 0.0f);
                entityocelot.c(-24000);
                this.q.d((nn)((Object)entityocelot));
            }
        }
        return par1EntityLivingData;
    }

    public nk a(nk par1EntityAgeable) {
        return this.b(par1EntityAgeable);
    }
}


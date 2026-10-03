/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ann
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 *  nk
 *  oq
 *  pi
 *  pp
 *  pq
 *  ps
 *  pw
 *  qa
 *  qm
 *  qx
 *  rb
 *  rc
 *  rd
 *  xx
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class sf
extends oq {
    private float bq;
    private float br;
    private boolean bs;
    private boolean bt;
    private float bu;
    private float bv;

    public sf(abw par1World) {
        super(par1World);
        this.a(0.6f, 0.8f);
        this.k().a(true);
        this.c.a(1, (ps)new pp((og)((Object)this)));
        this.c.a(2, (ps)this.bp);
        this.c.a(3, (ps)new pw((og)((Object)this), 0.4f));
        this.c.a(4, (ps)new qa((on)((Object)this), 1.0, true));
        this.c.a(5, (ps)new pq((oq)this, 1.0, 10.0f, 2.0f));
        this.c.a(6, (ps)new pk((rp)((Object)this), 1.0));
        this.c.a(7, (ps)new qm((on)((Object)this), 1.0));
        this.c.a(8, (ps)new pi(this, 8.0f));
        this.c.a(9, (ps)new px((og)((Object)this), uf.class, 8.0f));
        this.c.a(9, (ps)new ql((og)((Object)this)));
        this.d.a(1, (ps)new rc((oq)this));
        this.d.a(2, (ps)new rd((oq)this));
        this.d.a(3, (ps)new qx((on)((Object)this), true));
        this.d.a(4, (ps)new rb((oq)this, rz.class, 200, false));
        this.j(false);
    }

    protected void az() {
        super.az();
        this.a(tp.d).a((double)0.3f);
        if (this.bT()) {
            this.a(tp.a).a(20.0);
        } else {
            this.a(tp.a).a(8.0);
        }
    }

    public boolean bf() {
        return true;
    }

    public void d(of par1EntityLivingBase) {
        super.d(par1EntityLivingBase);
        if (par1EntityLivingBase == null) {
            this.l(false);
        } else if (!this.bT()) {
            this.l(true);
        }
    }

    protected void bk() {
        this.ah.b(18, Float.valueOf(this.aN()));
    }

    protected void a() {
        super.a();
        this.ah.a(18, new Float(this.aN()));
        this.ah.a(19, new Byte(0));
        this.ah.a(20, new Byte((byte)ann.j_((int)1)));
    }

    protected void a(int par1, int par2, int par3, int par4) {
        this.a("mob.wolf.step", 0.15f, 1.0f);
    }

    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("Angry", this.cc());
        par1NBTTagCompound.a("CollarColor", (byte)this.cd());
    }

    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.l(par1NBTTagCompound.n("Angry"));
        if (par1NBTTagCompound.b("CollarColor")) {
            this.p(par1NBTTagCompound.c("CollarColor"));
        }
    }

    protected String r() {
        return this.cc() ? "mob.wolf.growl" : (this.ab.nextInt(3) == 0 ? (this.bT() && this.ah.d(18) < 10.0f ? "mob.wolf.whine" : "mob.wolf.panting") : "mob.wolf.bark");
    }

    protected String aO() {
        return "mob.wolf.hurt";
    }

    protected String aP() {
        return "mob.wolf.death";
    }

    protected float ba() {
        return 0.4f;
    }

    protected int s() {
        return -1;
    }

    public void c() {
        super.c();
        if (!this.q.I && this.bs && !this.bt && !this.bM() && this.F) {
            this.bt = true;
            this.bu = 0.0f;
            this.bv = 0.0f;
            this.q.a((nn)((Object)this), (byte)8);
        }
    }

    public void l_() {
        super.l_();
        this.br = this.bq;
        this.bq = this.ce() ? (this.bq += (1.0f - this.bq) * 0.4f) : (this.bq += (0.0f - this.bq) * 0.4f);
        if (this.ce()) {
            this.g = 10;
        }
        if (this.G()) {
            this.bs = true;
            this.bt = false;
            this.bu = 0.0f;
            this.bv = 0.0f;
        } else if ((this.bs || this.bt) && this.bt) {
            if (this.bu == 0.0f) {
                this.a("mob.wolf.shake", this.ba(), (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
            }
            this.bv = this.bu;
            this.bu += 0.05f;
            if (this.bv >= 2.0f) {
                this.bs = false;
                this.bt = false;
                this.bv = 0.0f;
                this.bu = 0.0f;
            }
            if (this.bu > 0.4f) {
                float f2 = (float)this.E.b;
                int i2 = (int)(ls.a((this.bu - 0.4f) * (float)Math.PI) * 7.0f);
                for (int j2 = 0; j2 < i2; ++j2) {
                    float f1 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O * 0.5f;
                    float f22 = (this.ab.nextFloat() * 2.0f - 1.0f) * this.O * 0.5f;
                    this.q.a("splash", this.u + (double)f1, (double)(f2 + 0.8f), this.w + (double)f22, this.x, this.y, this.z);
                }
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public boolean ca() {
        return this.bs;
    }

    @SideOnly(value=Side.CLIENT)
    public float p(float par1) {
        return 0.75f + (this.bv + (this.bu - this.bv) * par1) / 2.0f * 0.25f;
    }

    @SideOnly(value=Side.CLIENT)
    public float g(float par1, float par2) {
        float f2 = (this.bv + (this.bu - this.bv) * par1 + par2) / 1.8f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        return ls.a(f2 * (float)Math.PI) * ls.a(f2 * (float)Math.PI * 11.0f) * 0.15f * (float)Math.PI;
    }

    @SideOnly(value=Side.CLIENT)
    public float q(float par1) {
        return (this.br + (this.bq - this.br) * par1) * 0.15f * (float)Math.PI;
    }

    public float f() {
        return this.P * 0.8f;
    }

    public int bp() {
        return this.bU() ? 20 : super.bp();
    }

    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        nn entity = par1DamageSource.i();
        this.bp.a(false);
        if (entity != null && !(entity instanceof uf) && !(entity instanceof uh)) {
            par2 = (par2 + 1.0f) / 2.0f;
        }
        return super.a(par1DamageSource, par2);
    }

    public boolean m(nn par1Entity) {
        int i2 = this.bT() ? 4 : 2;
        return par1Entity.a(nb.a((of)((Object)this)), (float)i2);
    }

    public void j(boolean par1) {
        super.j(par1);
        if (par1) {
            this.a(tp.a).a(20.0);
        } else {
            this.a(tp.a).a(8.0);
        }
    }

    public boolean a(uf par1EntityPlayer) {
        ye itemstack = par1EntityPlayer.bn.h();
        if (this.bT()) {
            if (itemstack != null) {
                int i2;
                if (yc.g[itemstack.d] instanceof xx) {
                    xx itemfood = (xx)yc.g[itemstack.d];
                    if (itemfood.j() && this.ah.d(18) < 20.0f) {
                        if (!par1EntityPlayer.bG.d) {
                            --itemstack.b;
                        }
                        this.f(itemfood.g());
                        if (itemstack.b <= 0) {
                            par1EntityPlayer.bn.a(par1EntityPlayer.bn.c, (ye)null);
                        }
                        return true;
                    }
                } else if (itemstack.d == yc.aY.cv && (i2 = ann.j_((int)itemstack.k())) != this.cd()) {
                    this.p(i2);
                    if (!par1EntityPlayer.bG.d && --itemstack.b <= 0) {
                        par1EntityPlayer.bn.a(par1EntityPlayer.bn.c, (ye)null);
                    }
                    return true;
                }
            }
            if (par1EntityPlayer.c_().equalsIgnoreCase(this.h_()) && !this.q.I && !this.c(itemstack)) {
                this.bp.a(!this.bU());
                this.bd = false;
                this.a(null);
                this.b(null);
                this.d(null);
            }
        } else if (itemstack != null && itemstack.d == yc.aZ.cv && !this.cc()) {
            if (!par1EntityPlayer.bG.d) {
                --itemstack.b;
            }
            if (itemstack.b <= 0) {
                par1EntityPlayer.bn.a(par1EntityPlayer.bn.c, (ye)null);
            }
            if (!this.q.I) {
                if (this.ab.nextInt(3) == 0) {
                    this.j(true);
                    this.a(null);
                    this.d(null);
                    this.bp.a(true);
                    this.g(20.0f);
                    this.b(par1EntityPlayer.c_());
                    this.i(true);
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

    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 8) {
            this.bt = true;
            this.bu = 0.0f;
            this.bv = 0.0f;
        } else {
            super.a(par1);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public float cb() {
        return this.cc() ? 1.5393804f : (this.bT() ? (0.55f - (20.0f - this.ah.d(18)) * 0.02f) * (float)Math.PI : 0.62831855f);
    }

    public boolean c(ye par1ItemStack) {
        return par1ItemStack == null ? false : (!(yc.g[par1ItemStack.d] instanceof xx) ? false : ((xx)yc.g[par1ItemStack.d]).j());
    }

    public int bv() {
        return 8;
    }

    public boolean cc() {
        return (this.ah.a(16) & 2) != 0;
    }

    public void l(boolean par1) {
        byte b0 = this.ah.a(16);
        if (par1) {
            this.ah.b(16, (byte)(b0 | 2));
        } else {
            this.ah.b(16, (byte)(b0 & 0xFFFFFFFD));
        }
    }

    public int cd() {
        return this.ah.a(20) & 0xF;
    }

    public void p(int par1) {
        this.ah.b(20, (byte)(par1 & 0xF));
    }

    public sf b(nk par1EntityAgeable) {
        sf entitywolf = new sf(this.q);
        String s2 = this.h_();
        if (s2 != null && s2.trim().length() > 0) {
            entitywolf.b(s2);
            entitywolf.j(true);
        }
        return entitywolf;
    }

    public void m(boolean par1) {
        if (par1) {
            this.ah.b(19, (byte)1);
        } else {
            this.ah.b(19, (byte)0);
        }
    }

    public boolean a(rp par1EntityAnimal) {
        if (par1EntityAnimal == this) {
            return false;
        }
        if (!this.bT()) {
            return false;
        }
        if (!(par1EntityAnimal instanceof sf)) {
            return false;
        }
        sf entitywolf = (sf)((Object)par1EntityAnimal);
        return !entitywolf.bT() ? false : (entitywolf.bU() ? false : this.bY() && entitywolf.bY());
    }

    public boolean ce() {
        return this.ah.a(19) == 1;
    }

    protected boolean t() {
        return !this.bT() && this.ac > 2400;
    }

    public boolean a(of par1EntityLivingBase, of par2EntityLivingBase) {
        if (!(par1EntityLivingBase instanceof tf) && !(par1EntityLivingBase instanceof tj)) {
            sf entitywolf;
            if (par1EntityLivingBase instanceof sf && (entitywolf = (sf)((Object)par1EntityLivingBase)).bT() && entitywolf.bV() == par2EntityLivingBase) {
                return false;
            }
            return par1EntityLivingBase instanceof uf && par2EntityLivingBase instanceof uf && !((uf)par2EntityLivingBase).a((uf)par1EntityLivingBase) ? false : !(par1EntityLivingBase instanceof rs) || !((rs)((Object)par1EntityLivingBase)).bW();
        }
        return false;
    }

    public nk a(nk par1EntityAgeable) {
        return this.b(par1EntityAgeable);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kp
 *  ku
 *  nk
 *  pp
 *  ps
 *  qj
 *  qm
 *  qu
 *  sp
 *  tn
 */
public class ry
extends rp {
    private final pl bp;

    public ry(abw par1World) {
        super(par1World);
        this.a(0.9f, 0.9f);
        this.k().a(true);
        this.c.a(0, (ps)new pp((og)((Object)this)));
        this.c.a(1, (ps)new qj((on)((Object)this), 1.25));
        this.bp = new pl((og)((Object)this), 0.3f);
        this.c.a(2, (ps)this.bp);
        this.c.a(3, (ps)new pk(this, 1.0));
        this.c.a(4, (ps)new qu((on)((Object)this), 1.2, yc.bT.cv, false));
        this.c.a(4, (ps)new qu((on)((Object)this), 1.2, yc.bM.cv, false));
        this.c.a(5, (ps)new pr(this, 1.1));
        this.c.a(6, (ps)new qm((on)((Object)this), 1.0));
        this.c.a(7, (ps)new px((og)((Object)this), uf.class, 6.0f));
        this.c.a(8, (ps)new ql((og)((Object)this)));
    }

    public boolean bf() {
        return true;
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(10.0);
        this.a(tp.d).a(0.25);
    }

    protected void bi() {
        super.bi();
    }

    public boolean by() {
        ye itemstack = ((uf)this.n).aZ();
        return itemstack != null && itemstack.d == yc.bT.cv;
    }

    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("Saddle", this.bT());
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.i(par1NBTTagCompound.n("Saddle"));
    }

    protected String r() {
        return "mob.pig.say";
    }

    protected String aO() {
        return "mob.pig.say";
    }

    protected String aP() {
        return "mob.pig.death";
    }

    protected void a(int par1, int par2, int par3, int par4) {
        this.a("mob.pig.step", 0.15f, 1.0f);
    }

    @Override
    public boolean a(uf par1EntityPlayer) {
        if (super.a(par1EntityPlayer)) {
            return true;
        }
        if (this.bT() && !this.q.I && (this.n == null || this.n == par1EntityPlayer)) {
            par1EntityPlayer.a((nn)((Object)this));
            return true;
        }
        return false;
    }

    protected int s() {
        return this.af() ? yc.at.cv : yc.as.cv;
    }

    protected void b(boolean par1, int par2) {
        int j2 = this.ab.nextInt(3) + 1 + this.ab.nextInt(1 + par2);
        for (int k2 = 0; k2 < j2; ++k2) {
            if (this.af()) {
                this.b(yc.at.cv, 1);
                continue;
            }
            this.b(yc.as.cv, 1);
        }
        if (this.bT()) {
            this.b(yc.aC.cv, 1);
        }
    }

    public boolean bT() {
        return (this.ah.a(16) & 1) != 0;
    }

    public void i(boolean par1) {
        if (par1) {
            this.ah.b(16, (byte)1);
        } else {
            this.ah.b(16, (byte)0);
        }
    }

    public void a(sp par1EntityLightningBolt) {
        if (!this.q.I) {
            tn entitypigzombie = new tn(this.q);
            entitypigzombie.b(this.u, this.v, this.w, this.A, this.B);
            this.q.d((nn)entitypigzombie);
            this.x();
        }
    }

    protected void b(float par1) {
        super.b(par1);
        if (par1 > 5.0f && this.n instanceof uf) {
            ((uf)this.n).a((ku)kp.u);
        }
    }

    public ry b(nk par1EntityAgeable) {
        return new ry(this.q);
    }

    @Override
    public boolean c(ye par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.d == yc.bM.cv;
    }

    public pl bU() {
        return this.bp;
    }

    public nk a(nk par1EntityAgeable) {
        return this.b(par1EntityAgeable);
    }
}


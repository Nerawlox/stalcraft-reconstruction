/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 *  pp
 *  ps
 *  qa
 *  qm
 *  qs
 *  qx
 *  qy
 *  sp
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class tf
extends tm {
    private int bp;
    private int bq;
    private int br = 30;
    private int bs = 3;

    public tf(abw par1World) {
        super(par1World);
        this.c.a(1, (ps)new pp((og)this));
        this.c.a(2, (ps)new qs(this));
        this.c.a(3, (ps)new pg(this, rx.class, 6.0f, 1.0, 1.2));
        this.c.a(4, (ps)new qa((on)this, 1.0, false));
        this.c.a(5, (ps)new qm((on)this, 0.8));
        this.c.a(6, (ps)new px(this, uf.class, 8.0f));
        this.c.a(6, (ps)new ql(this));
        this.d.a(1, (ps)new qy((on)this, uf.class, 0, true));
        this.d.a(2, (ps)new qx((on)this, false));
    }

    @Override
    protected void az() {
        super.az();
        this.a(tp.d).a(0.25);
    }

    @Override
    public boolean bf() {
        return true;
    }

    @Override
    public int as() {
        return this.m() == null ? 3 : 3 + (int)(this.aN() - 1.0f);
    }

    @Override
    protected void b(float par1) {
        super.b(par1);
        this.bq = (int)((float)this.bq + par1 * 1.5f);
        if (this.bq > this.br - 5) {
            this.bq = this.br - 5;
        }
    }

    @Override
    protected void a() {
        super.a();
        this.ah.a(16, (Object)-1);
        this.ah.a(17, (Object)0);
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        if (this.ah.a(17) == 1) {
            par1NBTTagCompound.a("powered", true);
        }
        par1NBTTagCompound.a("Fuse", (short)this.br);
        par1NBTTagCompound.a("ExplosionRadius", (byte)this.bs);
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.ah.b(17, (byte)(par1NBTTagCompound.n("powered") ? 1 : 0));
        if (par1NBTTagCompound.b("Fuse")) {
            this.br = par1NBTTagCompound.d("Fuse");
        }
        if (par1NBTTagCompound.b("ExplosionRadius")) {
            this.bs = par1NBTTagCompound.c("ExplosionRadius");
        }
    }

    @Override
    public void l_() {
        if (this.T()) {
            this.bp = this.bq;
            int i2 = this.bV();
            if (i2 > 0 && this.bq == 0) {
                this.a("random.fuse", 1.0f, 0.5f);
            }
            this.bq += i2;
            if (this.bq < 0) {
                this.bq = 0;
            }
            if (this.bq >= this.br) {
                this.bq = this.br;
                if (!this.q.I) {
                    boolean flag = this.q.O().b("mobGriefing");
                    if (this.bT()) {
                        this.q.a(this, this.u, this.v, this.w, (float)(this.bs * 2), flag);
                    } else {
                        this.q.a(this, this.u, this.v, this.w, (float)this.bs, flag);
                    }
                    this.x();
                }
            }
        }
        super.l_();
    }

    @Override
    protected String aO() {
        return "mob.creeper.say";
    }

    @Override
    protected String aP() {
        return "mob.creeper.death";
    }

    @Override
    public void a(nb par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.i() instanceof tr) {
            int i2 = yc.cj.cv + this.ab.nextInt(yc.cu.cv - yc.cj.cv + 1);
            this.b(i2, 1);
        }
    }

    @Override
    public boolean m(nn par1Entity) {
        return true;
    }

    public boolean bT() {
        return this.ah.a(17) == 1;
    }

    @SideOnly(value=Side.CLIENT)
    public float a(float par1) {
        return ((float)this.bp + (float)(this.bq - this.bp) * par1) / (float)(this.br - 2);
    }

    @Override
    protected int s() {
        return yc.O.cv;
    }

    public int bV() {
        return this.ah.a(16);
    }

    public void a(int par1) {
        this.ah.b(16, (byte)par1);
    }

    @Override
    public void a(sp par1EntityLightningBolt) {
        super.a(par1EntityLightningBolt);
        this.ah.b(17, (byte)1);
    }
}


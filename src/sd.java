/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 *  ps
 *  qa
 *  qd
 *  qe
 *  qm
 *  qw
 *  qx
 *  qy
 *  rv
 *  t
 *  th
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class sd
extends rv {
    private int bq;
    rj bp;
    private int br;
    private int bs;

    public sd(abw par1World) {
        super(par1World);
        this.a(1.4f, 2.9f);
        this.k().a(true);
        this.c.a(1, (ps)new qa((on)((Object)this), 1.0, true));
        this.c.a(2, (ps)new qe((on)((Object)this), 0.9, 32.0f));
        this.c.a(3, (ps)new qc((on)((Object)this), 0.6, true));
        this.c.a(4, (ps)new qd((on)((Object)this), 1.0));
        this.c.a(5, (ps)new qh(this));
        this.c.a(6, (ps)new qm((on)((Object)this), 0.6));
        this.c.a(7, (ps)new px((og)((Object)this), uf.class, 6.0f));
        this.c.a(8, (ps)new ql((og)((Object)this)));
        this.d.a(1, (ps)new qw(this));
        this.d.a(2, (ps)new qx((on)((Object)this), false));
        this.d.a(3, (ps)new qy((on)((Object)this), og.class, 0, false, true, th.a));
    }

    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
    }

    public boolean bf() {
        return true;
    }

    protected void bk() {
        if (--this.bq <= 0) {
            this.bq = 70 + this.ab.nextInt(50);
            this.bp = this.q.A.a(ls.c(this.u), ls.c(this.v), ls.c(this.w), 32);
            if (this.bp == null) {
                this.bR();
            } else {
                t chunkcoordinates = this.bp.a();
                this.b(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, (int)((float)this.bp.b() * 0.6f));
            }
        }
        super.bk();
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(100.0);
        this.a(tp.d).a(0.25);
    }

    protected int h(int par1) {
        return par1;
    }

    protected void n(nn par1Entity) {
        if (par1Entity instanceof th && this.aD().nextInt(20) == 0) {
            this.d((of)par1Entity);
        }
        super.n(par1Entity);
    }

    public void c() {
        int k2;
        int j2;
        int i2;
        int l2;
        super.c();
        if (this.br > 0) {
            --this.br;
        }
        if (this.bs > 0) {
            --this.bs;
        }
        if (this.x * this.x + this.z * this.z > 2.500000277905201E-7 && this.ab.nextInt(5) == 0 && (l2 = this.q.a(i2 = ls.c(this.u), j2 = ls.c(this.v - (double)0.2f - (double)this.N), k2 = ls.c(this.w))) > 0) {
            this.q.a("tilecrack_" + l2 + "_" + this.q.h(i2, j2, k2), this.u + ((double)this.ab.nextFloat() - 0.5) * (double)this.O, this.E.b + 0.1, this.w + ((double)this.ab.nextFloat() - 0.5) * (double)this.O, 4.0 * ((double)this.ab.nextFloat() - 0.5), 0.5, ((double)this.ab.nextFloat() - 0.5) * 4.0);
        }
    }

    public boolean a(Class par1Class) {
        return this.bW() && uf.class.isAssignableFrom(par1Class) ? false : super.a(par1Class);
    }

    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("PlayerCreated", this.bW());
    }

    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.i(par1NBTTagCompound.n("PlayerCreated"));
    }

    public boolean m(nn par1Entity) {
        this.br = 10;
        this.q.a((nn)((Object)this), (byte)4);
        boolean flag = par1Entity.a(nb.a((of)((Object)this)), (float)(7 + this.ab.nextInt(15)));
        if (flag) {
            par1Entity.y += (double)0.4f;
        }
        this.a("mob.irongolem.throw", 1.0f, 1.0f);
        return flag;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 4) {
            this.br = 10;
            this.a("mob.irongolem.throw", 1.0f, 1.0f);
        } else if (par1 == 11) {
            this.bs = 400;
        } else {
            super.a(par1);
        }
    }

    public rj bT() {
        return this.bp;
    }

    @SideOnly(value=Side.CLIENT)
    public int bU() {
        return this.br;
    }

    public void a(boolean par1) {
        this.bs = par1 ? 400 : 0;
        this.q.a((nn)((Object)this), (byte)11);
    }

    protected String r() {
        return "none";
    }

    protected String aO() {
        return "mob.irongolem.hit";
    }

    protected String aP() {
        return "mob.irongolem.death";
    }

    protected void a(int par1, int par2, int par3, int par4) {
        this.a("mob.irongolem.walk", 1.0f, 1.0f);
    }

    protected void b(boolean par1, int par2) {
        int k2;
        int j2 = this.ab.nextInt(3);
        for (k2 = 0; k2 < j2; ++k2) {
            this.b(aqz.aj.cF, 1);
        }
        k2 = 3 + this.ab.nextInt(3);
        for (int l2 = 0; l2 < k2; ++l2) {
            this.b(yc.q.cv, 1);
        }
    }

    public int bV() {
        return this.bs;
    }

    public boolean bW() {
        return (this.ah.a(16) & 1) != 0;
    }

    public void i(boolean par1) {
        byte b0 = this.ah.a(16);
        if (par1) {
            this.ah.b(16, (byte)(b0 | 1));
        } else {
            this.ah.b(16, (byte)(b0 & 0xFFFFFFFE));
        }
    }

    public void a(nb par1DamageSource) {
        if (!this.bW() && this.aS != null && this.bp != null) {
            this.bp.a(this.aS.c_(), -5);
        }
        super.a(par1DamageSource);
    }
}


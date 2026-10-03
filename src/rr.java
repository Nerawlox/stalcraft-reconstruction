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
 */
public class rr
extends rp {
    public rr(abw par1World) {
        super(par1World);
        this.a(0.9f, 1.3f);
        this.k().a(true);
        this.c.a(0, (ps)new pp((og)((Object)this)));
        this.c.a(1, (ps)new qj((on)((Object)this), 2.0));
        this.c.a(2, (ps)new pk(this, 1.0));
        this.c.a(3, (ps)new qu((on)((Object)this), 1.25, yc.V.cv, false));
        this.c.a(4, (ps)new pr(this, 1.25));
        this.c.a(5, (ps)new qm((on)((Object)this), 1.0));
        this.c.a(6, (ps)new px((og)((Object)this), uf.class, 6.0f));
        this.c.a(7, (ps)new ql((og)((Object)this)));
    }

    public boolean bf() {
        return true;
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(10.0);
        this.a(tp.d).a((double)0.2f);
    }

    protected String r() {
        return "mob.cow.say";
    }

    protected String aO() {
        return "mob.cow.hurt";
    }

    protected String aP() {
        return "mob.cow.hurt";
    }

    protected void a(int par1, int par2, int par3, int par4) {
        this.a("mob.cow.step", 0.15f, 1.0f);
    }

    protected float ba() {
        return 0.4f;
    }

    protected int s() {
        return yc.aH.cv;
    }

    protected void b(boolean par1, int par2) {
        int k2;
        int j2 = this.ab.nextInt(3) + this.ab.nextInt(1 + par2);
        for (k2 = 0; k2 < j2; ++k2) {
            this.b(yc.aH.cv, 1);
        }
        j2 = this.ab.nextInt(3) + 1 + this.ab.nextInt(1 + par2);
        for (k2 = 0; k2 < j2; ++k2) {
            if (this.af()) {
                this.b(yc.bl.cv, 1);
                continue;
            }
            this.b(yc.bk.cv, 1);
        }
    }

    @Override
    public boolean a(uf par1EntityPlayer) {
        ye itemstack = par1EntityPlayer.bn.h();
        if (itemstack != null && itemstack.d == yc.ay.cv && !par1EntityPlayer.bG.d) {
            if (itemstack.b-- == 1) {
                par1EntityPlayer.bn.a(par1EntityPlayer.bn.c, new ye(yc.aI));
            } else if (!par1EntityPlayer.bn.a(new ye(yc.aI))) {
                par1EntityPlayer.b(new ye(yc.aI.cv, 1, 0));
            }
            return true;
        }
        return super.a(par1EntityPlayer);
    }

    public rr b(nk par1EntityAgeable) {
        return new rr(this.q);
    }

    public nk a(nk par1EntityAgeable) {
        return this.b(par1EntityAgeable);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 *  ni
 *  os
 *  ot
 *  pp
 *  ps
 *  qm
 *  qn
 *  qx
 *  qy
 *  to
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.UUID;

public class tv
extends tm
implements to {
    private static final UUID bp = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
    private static final ot bq = new ot(bp, "Drinking speed penalty", -0.25, 0).a(false);
    private static final int[] br = new int[]{yc.aV.cv, yc.ba.cv, yc.aE.cv, yc.bw.cv, yc.bv.cv, yc.O.cv, yc.F.cv, yc.F.cv};
    private int bs;

    public tv(abw par1World) {
        super(par1World);
        this.c.a(1, (ps)new pp((og)this));
        this.c.a(2, (ps)new qn((to)this, 1.0, 60, 10.0f));
        this.c.a(2, (ps)new qm((on)this, 1.0));
        this.c.a(3, (ps)new px(this, uf.class, 8.0f));
        this.c.a(3, (ps)new ql(this));
        this.d.a(1, (ps)new qx((on)this, false));
        this.d.a(2, (ps)new qy((on)this, uf.class, 0, true));
    }

    @Override
    protected void a() {
        super.a();
        this.v().a(21, (Object)0);
    }

    @Override
    protected String r() {
        return "mob.witch.idle";
    }

    @Override
    protected String aO() {
        return "mob.witch.hurt";
    }

    @Override
    protected String aP() {
        return "mob.witch.death";
    }

    public void a(boolean par1) {
        this.v().b(21, (byte)(par1 ? 1 : 0));
    }

    public boolean bT() {
        return this.v().a(21) == 1;
    }

    @Override
    protected void az() {
        super.az();
        this.a(tp.a).a(26.0);
        this.a(tp.d).a(0.25);
    }

    @Override
    public boolean bf() {
        return true;
    }

    @Override
    public void c() {
        if (!this.q.I) {
            if (this.bT()) {
                if (this.bs-- <= 0) {
                    List list;
                    this.a(false);
                    ye itemstack = this.aZ();
                    this.c(0, null);
                    if (itemstack != null && itemstack.d == yc.bu.cv && (list = yc.bu.g(itemstack)) != null) {
                        for (nj potioneffect : list) {
                            this.c(new nj(potioneffect));
                        }
                    }
                    this.a(tp.d).b(bq);
                }
            } else {
                int short1 = -1;
                if (this.ab.nextFloat() < 0.15f && this.af() && !this.a(ni.n)) {
                    short1 = 16307;
                } else if (this.ab.nextFloat() < 0.05f && this.aN() < this.aT()) {
                    short1 = 16341;
                } else if (this.ab.nextFloat() < 0.25f && this.m() != null && !this.a(ni.c) && this.m().e(this) > 121.0) {
                    short1 = 16274;
                } else if (this.ab.nextFloat() < 0.25f && this.m() != null && !this.a(ni.c) && this.m().e(this) > 121.0) {
                    short1 = 16274;
                }
                if (short1 > -1) {
                    this.c(0, new ye(yc.bu, 1, short1));
                    this.bs = this.aZ().n();
                    this.a(true);
                    os attributeinstance = this.a(tp.d);
                    attributeinstance.b(bq);
                    attributeinstance.a(bq);
                }
            }
            if (this.ab.nextFloat() < 7.5E-4f) {
                this.q.a((nn)this, (byte)15);
            }
        }
        super.c();
    }

    @Override
    protected float c(nb par1DamageSource, float par2) {
        par2 = super.c(par1DamageSource, par2);
        if (par1DamageSource.i() == this) {
            par2 = 0.0f;
        }
        if (par1DamageSource.q()) {
            par2 = (float)((double)par2 * 0.15);
        }
        return par2;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 15) {
            for (int i2 = 0; i2 < this.ab.nextInt(35) + 10; ++i2) {
                this.q.a("witchMagic", this.u + this.ab.nextGaussian() * (double)0.13f, this.E.e + 0.5 + this.ab.nextGaussian() * (double)0.13f, this.w + this.ab.nextGaussian() * (double)0.13f, 0.0, 0.0, 0.0);
            }
        } else {
            super.a(par1);
        }
    }

    @Override
    protected void b(boolean par1, int par2) {
        int j2 = this.ab.nextInt(3) + 1;
        for (int k2 = 0; k2 < j2; ++k2) {
            int l2 = this.ab.nextInt(3);
            int i1 = br[this.ab.nextInt(br.length)];
            if (par2 > 0) {
                l2 += this.ab.nextInt(par2 + 1);
            }
            for (int j1 = 0; j1 < l2; ++j1) {
                this.b(i1, 1);
            }
        }
    }

    public void a(of par1EntityLivingBase, float par2) {
        if (!this.bT()) {
            uu entitypotion = new uu(this.q, (of)this, 32732);
            entitypotion.B -= -20.0f;
            double d0 = par1EntityLivingBase.u + par1EntityLivingBase.x - this.u;
            double d1 = par1EntityLivingBase.v + (double)par1EntityLivingBase.f() - (double)1.1f - this.v;
            double d2 = par1EntityLivingBase.w + par1EntityLivingBase.z - this.w;
            float f1 = ls.a(d0 * d0 + d2 * d2);
            if (f1 >= 8.0f && !par1EntityLivingBase.a(ni.d)) {
                entitypotion.a(32698);
            } else if (par1EntityLivingBase.aN() >= 8.0f && !par1EntityLivingBase.a(ni.u)) {
                entitypotion.a(32660);
            } else if (f1 <= 3.0f && !par1EntityLivingBase.a(ni.t) && this.ab.nextFloat() < 0.25f) {
                entitypotion.a(32696);
            }
            entitypotion.c(d0, d1 + (double)(f1 * 0.2f), d2, 0.75f, 8.0f);
            this.q.d(entitypotion);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 *  net.minecraftforge.common.ForgeDummyContainer
 *  net.minecraftforge.event.Event$Result
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.event.entity.living.ZombieEvent$SummonAidEvent
 *  ni
 *  oi
 *  or
 *  os
 *  ot
 *  oy
 *  pj
 *  pp
 *  ps
 *  qa
 *  qd
 *  qm
 *  qx
 *  qy
 *  tx
 *  ty
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import java.util.UUID;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.ZombieEvent;

public class tw
extends tm {
    protected static final or bp = new oy("zombie.spawnReinforcements", 0.0, 0.0, 1.0).a("Spawn Reinforcements Chance");
    private static final UUID bq = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final ot br = new ot(bq, "Baby speed boost", 0.5, 1);
    private int bs;

    public tw(abw par1World) {
        super(par1World);
        this.k().b(true);
        this.c.a(0, (ps)new pp((og)this));
        this.c.a(1, (ps)new pj((og)this));
        this.c.a(2, (ps)new qa((on)this, uf.class, 1.0, false));
        this.c.a(3, (ps)new qa((on)this, ub.class, 1.0, true));
        this.c.a(4, (ps)new qd((on)this, 1.0));
        this.c.a(5, (ps)new qc(this, 1.0, false));
        this.c.a(6, (ps)new qm((on)this, 1.0));
        this.c.a(7, (ps)new px(this, uf.class, 8.0f));
        this.c.a(7, (ps)new ql(this));
        this.d.a(1, (ps)new qx((on)this, true));
        this.d.a(2, (ps)new qy((on)this, uf.class, 0, true));
        this.d.a(2, (ps)new qy((on)this, ub.class, 0, false));
    }

    @Override
    protected void az() {
        super.az();
        this.a(tp.b).a(40.0);
        this.a(tp.d).a((double)0.23f);
        this.a(tp.e).a(3.0);
        this.aX().b(bp).a(this.ab.nextDouble() * ForgeDummyContainer.zombieSummonBaseChance);
    }

    @Override
    protected void a() {
        super.a();
        this.v().a(12, (Object)0);
        this.v().a(13, (Object)0);
        this.v().a(14, (Object)0);
    }

    @Override
    public int aQ() {
        int i2 = super.aQ() + 2;
        if (i2 > 20) {
            i2 = 20;
        }
        return i2;
    }

    @Override
    protected boolean bf() {
        return true;
    }

    @Override
    public boolean g_() {
        return this.v().a(12) == 1;
    }

    public void a(boolean par1) {
        this.v().b(12, (byte)(par1 ? 1 : 0));
        if (this.q != null && !this.q.I) {
            os attributeinstance = this.a(tp.d);
            attributeinstance.b(br);
            if (par1) {
                attributeinstance.a(br);
            }
        }
    }

    public boolean bT() {
        return this.v().a(13) == 1;
    }

    public void i(boolean par1) {
        this.v().b(13, (byte)(par1 ? 1 : 0));
    }

    @Override
    public void c() {
        float f2;
        if (this.q.v() && !this.q.I && !this.g_() && (f2 = this.d(1.0f)) > 0.5f && this.ab.nextFloat() * 30.0f < (f2 - 0.4f) * 2.0f && this.q.l(ls.c(this.u), ls.c(this.v), ls.c(this.w))) {
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
        super.c();
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        int k2;
        int j2;
        int i2;
        ZombieEvent.SummonAidEvent summonAid;
        if (!super.a(par1DamageSource, par2)) {
            return false;
        }
        of entitylivingbase = this.m();
        if (entitylivingbase == null && this.bN() instanceof of) {
            entitylivingbase = (of)this.bN();
        }
        if (entitylivingbase == null && par1DamageSource.i() instanceof of) {
            entitylivingbase = (of)par1DamageSource.i();
        }
        if ((summonAid = ForgeEventFactory.fireZombieSummonAid((tw)this, (abw)this.q, (int)(i2 = ls.c(this.u)), (int)(j2 = ls.c(this.v)), (int)(k2 = ls.c(this.w)), (of)entitylivingbase, (double)this.a(bp).e())).getResult() == Event.Result.DENY) {
            return true;
        }
        if (summonAid.getResult() == Event.Result.ALLOW || entitylivingbase != null && this.q.r >= 3 && (double)this.ab.nextFloat() < this.a(bp).e()) {
            tw entityzombie = summonAid.customSummonedAid != null && summonAid.getResult() == Event.Result.ALLOW ? summonAid.customSummonedAid : new tw(this.q);
            for (int l2 = 0; l2 < 50; ++l2) {
                int k1;
                int j1;
                int i1 = i2 + ls.a(this.ab, 7, 40) * ls.a(this.ab, -1, 1);
                if (!this.q.w(i1, (j1 = j2 + ls.a(this.ab, 7, 40) * ls.a(this.ab, -1, 1)) - 1, k1 = k2 + ls.a(this.ab, 7, 40) * ls.a(this.ab, -1, 1)) || this.q.n(i1, j1, k1) >= 10) continue;
                entityzombie.b((double)i1, (double)j1, (double)k1);
                if (!this.q.b(entityzombie.E) || !this.q.a((nn)entityzombie, entityzombie.E).isEmpty() || this.q.d(entityzombie.E)) continue;
                this.q.d(entityzombie);
                if (entitylivingbase != null) {
                    entityzombie.d(entitylivingbase);
                }
                entityzombie.a((oi)null);
                this.a(bp).a(new ot("Zombie reinforcement caller charge", (double)-0.05f, 0));
                entityzombie.a(bp).a(new ot("Zombie reinforcement callee charge", (double)-0.05f, 0));
                break;
            }
        }
        return true;
    }

    @Override
    public void l_() {
        if (!this.q.I && this.bV()) {
            int i2 = this.bX();
            this.bs -= i2;
            if (this.bs <= 0) {
                this.bW();
            }
        }
        super.l_();
    }

    @Override
    public boolean m(nn par1Entity) {
        boolean flag = super.m(par1Entity);
        if (flag && this.aZ() == null && this.af() && this.ab.nextFloat() < (float)this.q.r * 0.3f) {
            par1Entity.d(2 * this.q.r);
        }
        return flag;
    }

    @Override
    protected String r() {
        return "mob.zombie.say";
    }

    @Override
    protected String aO() {
        return "mob.zombie.hurt";
    }

    @Override
    protected String aP() {
        return "mob.zombie.death";
    }

    @Override
    protected void a(int par1, int par2, int par3, int par4) {
        this.a("mob.zombie.step", 0.15f, 1.0f);
    }

    @Override
    protected int s() {
        return yc.bo.cv;
    }

    @Override
    public oj aY() {
        return oj.b;
    }

    @Override
    protected void l(int par1) {
        switch (this.ab.nextInt(3)) {
            case 0: {
                this.b(yc.q.cv, 1);
                break;
            }
            case 1: {
                this.b(yc.bM.cv, 1);
                break;
            }
            case 2: {
                this.b(yc.bN.cv, 1);
            }
        }
    }

    @Override
    protected void bw() {
        super.bw();
        float f2 = this.ab.nextFloat();
        float f3 = this.q.r == 3 ? 0.05f : 0.01f;
        if (f2 < f3) {
            int i2 = this.ab.nextInt(3);
            if (i2 == 0) {
                this.c(0, new ye(yc.s));
            } else {
                this.c(0, new ye(yc.h));
            }
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        if (this.g_()) {
            par1NBTTagCompound.a("IsBaby", true);
        }
        if (this.bT()) {
            par1NBTTagCompound.a("IsVillager", true);
        }
        par1NBTTagCompound.a("ConversionTime", this.bV() ? this.bs : -1);
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        if (par1NBTTagCompound.n("IsBaby")) {
            this.a(true);
        }
        if (par1NBTTagCompound.n("IsVillager")) {
            this.i(true);
        }
        if (par1NBTTagCompound.b("ConversionTime") && par1NBTTagCompound.e("ConversionTime") > -1) {
            this.a(par1NBTTagCompound.e("ConversionTime"));
        }
    }

    @Override
    public void a(of par1EntityLivingBase) {
        super.a(par1EntityLivingBase);
        if (this.q.r >= 2 && par1EntityLivingBase instanceof ub) {
            if (this.q.r == 2 && this.ab.nextBoolean()) {
                return;
            }
            tw entityzombie = new tw(this.q);
            entityzombie.j(par1EntityLivingBase);
            this.q.e(par1EntityLivingBase);
            entityzombie.a((oi)null);
            entityzombie.i(true);
            if (par1EntityLivingBase.g_()) {
                entityzombie.a(true);
            }
            this.q.d(entityzombie);
            this.q.a(null, 1016, (int)this.u, (int)this.v, (int)this.w, 0);
        }
    }

    @Override
    public oi a(oi par1EntityLivingData) {
        Calendar calendar;
        oi par1EntityLivingData1 = super.a(par1EntityLivingData);
        float f2 = this.q.b(this.u, this.v, this.w);
        this.h(this.ab.nextFloat() < 0.55f * f2);
        if (par1EntityLivingData1 == null) {
            par1EntityLivingData1 = new ty(this, this.q.s.nextFloat() < ForgeDummyContainer.zombieBabyChance, this.q.s.nextFloat() < 0.05f, (tx)null);
        }
        if (par1EntityLivingData1 instanceof ty) {
            ty entityzombiegroupdata = (ty)par1EntityLivingData1;
            if (entityzombiegroupdata.b) {
                this.i(true);
            }
            if (entityzombiegroupdata.a) {
                this.a(true);
            }
        }
        this.bw();
        this.bx();
        if (this.n(4) == null && (calendar = this.q.W()).get(2) + 1 == 10 && calendar.get(5) == 31 && this.ab.nextFloat() < 0.25f) {
            this.c(4, new ye(this.ab.nextFloat() < 0.1f ? aqz.bk : aqz.bf));
            this.e[4] = 0.0f;
        }
        this.a(tp.c).a(new ot("Random spawn bonus", this.ab.nextDouble() * (double)0.05f, 0));
        this.a(tp.b).a(new ot("Random zombie-spawn bonus", this.ab.nextDouble() * 1.5, 2));
        if (this.ab.nextFloat() < f2 * 0.05f) {
            this.a(bp).a(new ot("Leader zombie bonus", this.ab.nextDouble() * 0.25 + 0.5, 0));
            this.a(tp.a).a(new ot("Leader zombie bonus", this.ab.nextDouble() * 3.0 + 1.0, 2));
        }
        return par1EntityLivingData1;
    }

    @Override
    public boolean a(uf par1EntityPlayer) {
        ye itemstack = par1EntityPlayer.by();
        if (itemstack != null && itemstack.b() == yc.av && itemstack.k() == 0 && this.bT() && this.a(ni.t)) {
            if (!par1EntityPlayer.bG.d) {
                --itemstack.b;
            }
            if (itemstack.b <= 0) {
                par1EntityPlayer.bn.a(par1EntityPlayer.bn.c, (ye)null);
            }
            if (!this.q.I) {
                this.a(this.ab.nextInt(2401) + 3600);
            }
            return true;
        }
        return false;
    }

    protected void a(int par1) {
        this.bs = par1;
        this.v().b(14, (byte)1);
        this.k(ni.t.H);
        this.c(new nj(ni.g.H, par1, Math.min(this.q.r - 1, 0)));
        this.q.a((nn)this, (byte)16);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 16) {
            this.q.a(this.u + 0.5, this.v + 0.5, this.w + 0.5, "mob.zombie.remedy", 1.0f + this.ab.nextFloat(), this.ab.nextFloat() * 0.7f + 0.3f, false);
        } else {
            super.a(par1);
        }
    }

    @Override
    protected boolean t() {
        return !this.bV();
    }

    public boolean bV() {
        return this.v().a(14) == 1;
    }

    protected void bW() {
        ub entityvillager = new ub(this.q);
        entityvillager.j(this);
        entityvillager.a((oi)null);
        entityvillager.bX();
        if (this.g_()) {
            entityvillager.c(-24000);
        }
        this.q.e(this);
        this.q.d((nn)((Object)entityvillager));
        entityvillager.c(new nj(ni.k.H, 200, 0));
        this.q.a(null, 1017, (int)this.u, (int)this.v, (int)this.w, 0);
    }

    protected int bX() {
        int i2 = 1;
        if (this.ab.nextFloat() < 0.01f) {
            int j2 = 0;
            for (int k2 = (int)this.u - 4; k2 < (int)this.u + 4 && j2 < 14; ++k2) {
                for (int l2 = (int)this.v - 4; l2 < (int)this.v + 4 && j2 < 14; ++l2) {
                    for (int i1 = (int)this.w - 4; i1 < (int)this.w + 4 && j2 < 14; ++i1) {
                        int j1 = this.q.a(k2, l2, i1);
                        if (j1 != aqz.bu.cF && j1 != aqz.X.cF) continue;
                        if (this.ab.nextFloat() < 0.3f) {
                            ++i2;
                        }
                        ++j2;
                    }
                }
            }
        }
        return i2;
    }
}


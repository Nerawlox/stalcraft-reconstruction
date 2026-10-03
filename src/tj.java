/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  kp
 *  ku
 *  nb
 *  ob
 *  th
 *  um
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class tj
extends ob
implements th {
    public int h;
    public double i;
    public double j;
    public double bn;
    private nn bq;
    private int br;
    public int bo;
    public int bp;
    private int bs = 1;

    public tj(abw par1World) {
        super(par1World);
        this.a(4.0f, 4.0f);
        this.ag = true;
        this.b = 5;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean bJ() {
        return this.ah.a(16) != 0;
    }

    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        if ("fireball".equals(par1DamageSource.n()) && par1DamageSource.i() instanceof uf) {
            super.a(par1DamageSource, 1000.0f);
            ((uf)par1DamageSource.i()).a((ku)kp.y);
            return true;
        }
        return super.a(par1DamageSource, par2);
    }

    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(10.0);
    }

    protected void bl() {
        byte b1;
        byte b0;
        if (!this.q.I && this.q.r == 0) {
            this.x();
        }
        this.u();
        this.bo = this.bp;
        double d0 = this.i - this.u;
        double d1 = this.j - this.v;
        double d2 = this.bn - this.w;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
        if (d3 < 1.0 || d3 > 3600.0) {
            this.i = this.u + (double)((this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.j = this.v + (double)((this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.bn = this.w + (double)((this.ab.nextFloat() * 2.0f - 1.0f) * 16.0f);
        }
        if (this.h-- <= 0) {
            this.h += this.ab.nextInt(5) + 2;
            if (this.a(this.i, this.j, this.bn, d3 = (double)ls.a(d3))) {
                this.x += d0 / d3 * 0.1;
                this.y += d1 / d3 * 0.1;
                this.z += d2 / d3 * 0.1;
            } else {
                this.i = this.u;
                this.j = this.v;
                this.bn = this.w;
            }
        }
        if (this.bq != null && this.bq.M) {
            this.bq = null;
        }
        if (this.bq == null || this.br-- <= 0) {
            this.bq = this.q.b((nn)((Object)this), 100.0);
            if (this.bq != null) {
                this.br = 20;
            }
        }
        double d4 = 64.0;
        if (this.bq != null && this.bq.e((nn)((Object)this)) < d4 * d4) {
            double d5 = this.bq.u - this.u;
            double d6 = this.bq.E.b + (double)(this.bq.P / 2.0f) - (this.v + (double)(this.P / 2.0f));
            double d7 = this.bq.w - this.w;
            this.aN = this.A = -((float)Math.atan2(d5, d7)) * 180.0f / (float)Math.PI;
            if (this.o(this.bq)) {
                if (this.bp == 10) {
                    this.q.a(null, 1007, (int)this.u, (int)this.v, (int)this.w, 0);
                }
                ++this.bp;
                if (this.bp == 20) {
                    this.q.a(null, 1008, (int)this.u, (int)this.v, (int)this.w, 0);
                    um entitylargefireball = new um(this.q, (of)((Object)this), d5, d6, d7);
                    entitylargefireball.e = this.bs;
                    double d8 = 4.0;
                    atc vec3 = this.j(1.0f);
                    entitylargefireball.u = this.u + vec3.c * d8;
                    entitylargefireball.v = this.v + (double)(this.P / 2.0f) + 0.5;
                    entitylargefireball.w = this.w + vec3.e * d8;
                    this.q.d((nn)entitylargefireball);
                    this.bp = -40;
                }
            } else if (this.bp > 0) {
                --this.bp;
            }
        } else {
            this.aN = this.A = -((float)Math.atan2(this.x, this.z)) * 180.0f / (float)Math.PI;
            if (this.bp > 0) {
                --this.bp;
            }
        }
        if (!this.q.I && (b0 = this.ah.a(16)) != (b1 = (byte)(this.bp > 10 ? 1 : 0))) {
            this.ah.b(16, b1);
        }
    }

    private boolean a(double par1, double par3, double par5, double par7) {
        double d4 = (this.i - this.u) / par7;
        double d5 = (this.j - this.v) / par7;
        double d6 = (this.bn - this.w) / par7;
        asx axisalignedbb = this.E.c();
        int i2 = 1;
        while ((double)i2 < par7) {
            axisalignedbb.d(d4, d5, d6);
            if (!this.q.a((nn)((Object)this), axisalignedbb).isEmpty()) {
                return false;
            }
            ++i2;
        }
        return true;
    }

    protected String r() {
        return "mob.ghast.moan";
    }

    protected String aO() {
        return "mob.ghast.scream";
    }

    protected String aP() {
        return "mob.ghast.death";
    }

    protected int s() {
        return yc.O.cv;
    }

    protected void b(boolean par1, int par2) {
        int k2;
        int j2 = this.ab.nextInt(2) + this.ab.nextInt(1 + par2);
        for (k2 = 0; k2 < j2; ++k2) {
            this.b(yc.br.cv, 1);
        }
        j2 = this.ab.nextInt(3) + this.ab.nextInt(1 + par2);
        for (k2 = 0; k2 < j2; ++k2) {
            this.b(yc.O.cv, 1);
        }
    }

    protected float ba() {
        return 10.0f;
    }

    public boolean bs() {
        return this.ab.nextInt(20) == 0 && super.bs() && this.q.r > 0;
    }

    public int bv() {
        return 1;
    }

    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("ExplosionPower", this.bs);
    }

    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        if (par1NBTTagCompound.b("ExplosionPower")) {
            this.bs = par1NBTTagCompound.e("ExplosionPower");
        }
    }
}


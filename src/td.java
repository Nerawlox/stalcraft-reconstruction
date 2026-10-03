/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 *  uo
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class td
extends tm {
    private float bp = 0.5f;
    private int bq;
    private int br;

    public td(abw par1World) {
        super(par1World);
        this.ag = true;
        this.b = 10;
    }

    @Override
    protected void az() {
        super.az();
        this.a(tp.e).a(6.0);
    }

    @Override
    protected void a() {
        super.a();
        this.ah.a(16, new Byte(0));
    }

    @Override
    protected String r() {
        return "mob.blaze.breathe";
    }

    @Override
    protected String aO() {
        return "mob.blaze.hit";
    }

    @Override
    protected String aP() {
        return "mob.blaze.death";
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int c(float par1) {
        return 0xF000F0;
    }

    @Override
    public float d(float par1) {
        return 1.0f;
    }

    @Override
    public void c() {
        if (!this.q.I) {
            if (this.G()) {
                this.a(nb.e, 1.0f);
            }
            --this.bq;
            if (this.bq <= 0) {
                this.bq = 100;
                this.bp = 0.5f + (float)this.ab.nextGaussian() * 3.0f;
            }
            if (this.bN() != null && this.bN().v + (double)this.bN().f() > this.v + (double)this.f() + (double)this.bp) {
                this.y += ((double)0.3f - this.y) * (double)0.3f;
            }
        }
        if (this.ab.nextInt(24) == 0) {
            this.q.a(this.u + 0.5, this.v + 0.5, this.w + 0.5, "fire.fire", 1.0f + this.ab.nextFloat(), this.ab.nextFloat() * 0.7f + 0.3f);
        }
        if (!this.F && this.y < 0.0) {
            this.y *= 0.6;
        }
        for (int i2 = 0; i2 < 2; ++i2) {
            this.q.a("largesmoke", this.u + (this.ab.nextDouble() - 0.5) * (double)this.O, this.v + this.ab.nextDouble() * (double)this.P, this.w + (this.ab.nextDouble() - 0.5) * (double)this.O, 0.0, 0.0, 0.0);
        }
        super.c();
    }

    @Override
    protected void a(nn par1Entity, float par2) {
        if (this.aC <= 0 && par2 < 2.0f && par1Entity.E.e > this.E.b && par1Entity.E.b < this.E.e) {
            this.aC = 20;
            this.m(par1Entity);
        } else if (par2 < 30.0f) {
            double d0 = par1Entity.u - this.u;
            double d1 = par1Entity.E.b + (double)(par1Entity.P / 2.0f) - (this.v + (double)(this.P / 2.0f));
            double d2 = par1Entity.w - this.w;
            if (this.aC == 0) {
                ++this.br;
                if (this.br == 1) {
                    this.aC = 60;
                    this.a(true);
                } else if (this.br <= 4) {
                    this.aC = 6;
                } else {
                    this.aC = 100;
                    this.br = 0;
                    this.a(false);
                }
                if (this.br > 1) {
                    float f1 = ls.c(par2) * 0.5f;
                    this.q.a(null, 1009, (int)this.u, (int)this.v, (int)this.w, 0);
                    for (int i2 = 0; i2 < 1; ++i2) {
                        uo entitysmallfireball = new uo(this.q, (of)this, d0 + this.ab.nextGaussian() * (double)f1, d1, d2 + this.ab.nextGaussian() * (double)f1);
                        entitysmallfireball.v = this.v + (double)(this.P / 2.0f) + 0.5;
                        this.q.d((nn)entitysmallfireball);
                    }
                }
            }
            this.A = (float)(Math.atan2(d2, d0) * 180.0 / Math.PI) - 90.0f;
            this.bn = true;
        }
    }

    @Override
    protected void b(float par1) {
    }

    @Override
    protected int s() {
        return yc.bq.cv;
    }

    @Override
    public boolean af() {
        return this.bT();
    }

    @Override
    protected void b(boolean par1, int par2) {
        if (par1) {
            int j2 = this.ab.nextInt(2 + par2);
            for (int k2 = 0; k2 < j2; ++k2) {
                this.b(yc.bq.cv, 1);
            }
        }
    }

    public boolean bT() {
        return (this.ah.a(16) & 1) != 0;
    }

    public void a(boolean par1) {
        byte b0 = this.ah.a(16);
        b0 = par1 ? (byte)(b0 | 1) : (byte)(b0 & 0xFFFFFFFE);
        this.ah.b(16, b0);
    }

    @Override
    protected boolean i_() {
        return true;
    }
}


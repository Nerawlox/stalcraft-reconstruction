/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nb
 *  th
 */
public class ts
extends og
implements th {
    public float h;
    public float i;
    public float j;
    private int bn;

    public ts(abw par1World) {
        super(par1World);
        int i2 = 1 << this.ab.nextInt(3);
        this.N = 0.0f;
        this.bn = this.ab.nextInt(20) + 10;
        this.a(i2);
    }

    @Override
    protected void a() {
        super.a();
        this.ah.a(16, new Byte(1));
    }

    protected void a(int par1) {
        this.ah.b(16, new Byte((byte)par1));
        this.a(0.6f * (float)par1, 0.6f * (float)par1);
        this.b(this.u, this.v, this.w);
        this.a(tp.a).a((double)(par1 * par1));
        this.g(this.aT());
        this.b = par1;
    }

    public int bR() {
        return this.ah.a(16);
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("Size", this.bR() - 1);
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.a(par1NBTTagCompound.e("Size") + 1);
    }

    protected String bJ() {
        return "slime";
    }

    protected String bP() {
        return "mob.slime." + (this.bR() > 1 ? "big" : "small");
    }

    @Override
    public void l_() {
        int i2;
        if (!this.q.I && this.q.r == 0 && this.bR() > 0) {
            this.M = true;
        }
        this.i += (this.h - this.i) * 0.5f;
        this.j = this.i;
        boolean flag = this.F;
        super.l_();
        if (this.F && !flag) {
            i2 = this.bR();
            for (int j2 = 0; j2 < i2 * 8; ++j2) {
                float f2 = this.ab.nextFloat() * (float)Math.PI * 2.0f;
                float f1 = this.ab.nextFloat() * 0.5f + 0.5f;
                float f22 = ls.a(f2) * (float)i2 * 0.5f * f1;
                float f3 = ls.b(f2) * (float)i2 * 0.5f * f1;
                this.q.a(this.bJ(), this.u + (double)f22, this.E.b, this.w + (double)f3, 0.0, 0.0, 0.0);
            }
            if (this.bQ()) {
                this.a(this.bP(), this.ba(), ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f) / 0.8f);
            }
            this.h = -0.5f;
        } else if (!this.F && flag) {
            this.h = 1.0f;
        }
        this.bM();
        if (this.q.I) {
            i2 = this.bR();
            this.a(0.6f * (float)i2, 0.6f * (float)i2);
        }
    }

    @Override
    protected void bl() {
        this.u();
        uf entityplayer = this.q.b((nn)this, 16.0);
        if (entityplayer != null) {
            this.a(entityplayer, 10.0f, 20.0f);
        }
        if (this.F && this.bn-- <= 0) {
            this.bn = this.bL();
            if (entityplayer != null) {
                this.bn /= 3;
            }
            this.bd = true;
            if (this.bS()) {
                this.a(this.bP(), this.ba(), ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f) * 0.8f);
            }
            this.be = 1.0f - this.ab.nextFloat() * 2.0f;
            this.bf = 1 * this.bR();
        } else {
            this.bd = false;
            if (this.F) {
                this.bf = 0.0f;
                this.be = 0.0f;
            }
        }
    }

    protected void bM() {
        this.h *= 0.6f;
    }

    protected int bL() {
        return this.ab.nextInt(20) + 10;
    }

    protected ts bK() {
        return new ts(this.q);
    }

    @Override
    public void x() {
        int i2 = this.bR();
        if (!this.q.I && i2 > 1 && this.aN() <= 0.0f) {
            int j2 = 2 + this.ab.nextInt(3);
            for (int k2 = 0; k2 < j2; ++k2) {
                float f2 = ((float)(k2 % 2) - 0.5f) * (float)i2 / 4.0f;
                float f1 = ((float)(k2 / 2) - 0.5f) * (float)i2 / 4.0f;
                ts entityslime = this.bK();
                entityslime.a(i2 / 2);
                entityslime.b(this.u + (double)f2, this.v + 0.5, this.w + (double)f1, this.ab.nextFloat() * 360.0f, 0.0f);
                this.q.d(entityslime);
            }
        }
        super.x();
    }

    @Override
    public void b_(uf par1EntityPlayer) {
        if (this.bN()) {
            int i2 = this.bR();
            if (this.o(par1EntityPlayer) && this.e((nn)par1EntityPlayer) < 0.6 * (double)i2 * 0.6 * (double)i2 && par1EntityPlayer.a(nb.a((of)this), (float)this.bO())) {
                this.a("mob.attack", 1.0f, (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 1.0f);
            }
        }
    }

    protected boolean bN() {
        return this.bR() > 1;
    }

    protected int bO() {
        return this.bR();
    }

    @Override
    protected String aO() {
        return "mob.slime." + (this.bR() > 1 ? "big" : "small");
    }

    @Override
    protected String aP() {
        return "mob.slime." + (this.bR() > 1 ? "big" : "small");
    }

    @Override
    protected int s() {
        return this.bR() == 1 ? yc.aO.cv : 0;
    }

    @Override
    public boolean bs() {
        adr chunk = this.q.d(ls.c(this.u), ls.c(this.w));
        if (this.q.N().u().handleSlimeSpawnReduction(this.ab, this.q)) {
            return false;
        }
        if (this.bR() == 1 || this.q.r > 0) {
            acq biomegenbase = this.q.a(ls.c(this.u), ls.c(this.w));
            if (biomegenbase == acq.h && this.v > 50.0 && this.v < 70.0 && this.ab.nextFloat() < 0.5f && this.ab.nextFloat() < this.q.x() && this.q.n(ls.c(this.u), ls.c(this.v), ls.c(this.w)) <= this.ab.nextInt(8)) {
                return super.bs();
            }
            if (this.ab.nextInt(10) == 0 && chunk.a(987234911L).nextInt(10) == 0 && this.v < 40.0) {
                return super.bs();
            }
        }
        return false;
    }

    @Override
    protected float ba() {
        return 0.4f * (float)this.bR();
    }

    @Override
    public int bp() {
        return 0;
    }

    protected boolean bS() {
        return this.bR() > 0;
    }

    protected boolean bQ() {
        return this.bR() > 2;
    }
}


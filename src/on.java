/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alf
 *  atc
 *  oq
 *  os
 *  ot
 *  ps
 *  qd
 *  t
 */
import java.util.UUID;

public abstract class on
extends og {
    public static final UUID h = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
    public static final ot i = new ot(h, "Fleeing speed bonus", 2.0, 2).a(false);
    private alf bp;
    protected nn j;
    protected boolean bn;
    protected int bo;
    private t bq = new t(0, 0, 0);
    private float br = -1.0f;
    private ps bs = new qd(this, 1.0);
    private boolean bt;

    public on(abw par1World) {
        super(par1World);
    }

    protected boolean bJ() {
        return false;
    }

    @Override
    protected void bl() {
        this.q.C.a("ai");
        if (this.bo > 0 && --this.bo == 0) {
            os attributeinstance = this.a(tp.d);
            attributeinstance.b(i);
        }
        this.bn = this.bJ();
        float f2 = 16.0f;
        if (this.j == null) {
            this.j = this.bL();
            if (this.j != null) {
                this.bp = this.q.a((nn)this, this.j, f2, true, false, false, true);
            }
        } else if (this.j.T()) {
            float f1 = this.j.d(this);
            if (this.o(this.j)) {
                this.a(this.j, f1);
            }
        } else {
            this.j = null;
        }
        this.q.C.b();
        if (!(this.bn || this.j == null || this.bp != null && this.ab.nextInt(20) != 0)) {
            this.bp = this.q.a((nn)this, this.j, f2, true, false, false, true);
        } else if (!this.bn && (this.bp == null && this.ab.nextInt(180) == 0 || this.ab.nextInt(120) == 0 || this.bo > 0) && this.aV < 100) {
            this.bK();
        }
        int i2 = ls.c(this.E.b + 0.5);
        boolean flag = this.H();
        boolean flag1 = this.J();
        this.B = 0.0f;
        if (this.bp != null && this.ab.nextInt(100) != 0) {
            this.q.C.a("followpath");
            atc vec3 = this.bp.a((nn)this);
            double d0 = this.O * 2.0f;
            while (vec3 != null && vec3.d(this.u, vec3.d, this.w) < d0 * d0) {
                this.bp.a();
                if (this.bp.b()) {
                    vec3 = null;
                    this.bp = null;
                    continue;
                }
                vec3 = this.bp.a((nn)this);
            }
            this.bd = false;
            if (vec3 != null) {
                double d1 = vec3.c - this.u;
                double d2 = vec3.e - this.w;
                double d3 = vec3.d - (double)i2;
                float f22 = (float)(Math.atan2(d2, d1) * 180.0 / Math.PI) - 90.0f;
                float f3 = ls.g(f22 - this.A);
                this.bf = (float)this.a(tp.d).e();
                if (f3 > 30.0f) {
                    f3 = 30.0f;
                }
                if (f3 < -30.0f) {
                    f3 = -30.0f;
                }
                this.A += f3;
                if (this.bn && this.j != null) {
                    double d4 = this.j.u - this.u;
                    double d5 = this.j.w - this.w;
                    float f4 = this.A;
                    this.A = (float)(Math.atan2(d5, d4) * 180.0 / Math.PI) - 90.0f;
                    f3 = (f4 - this.A + 90.0f) * (float)Math.PI / 180.0f;
                    this.be = -ls.a(f3) * this.bf * 1.0f;
                    this.bf = ls.b(f3) * this.bf * 1.0f;
                }
                if (d3 > 0.0) {
                    this.bd = true;
                }
            }
            if (this.j != null) {
                this.a(this.j, 30.0f, 30.0f);
            }
            if (this.G && !this.bM()) {
                this.bd = true;
            }
            if (this.ab.nextFloat() < 0.8f && (flag || flag1)) {
                this.bd = true;
            }
            this.q.C.b();
        } else {
            super.bl();
            this.bp = null;
        }
    }

    protected void bK() {
        this.q.C.a("stroll");
        boolean flag = false;
        int i2 = -1;
        int j2 = -1;
        int k2 = -1;
        float f2 = -99999.0f;
        for (int l2 = 0; l2 < 10; ++l2) {
            int k1;
            int j1;
            int i1 = ls.c(this.u + (double)this.ab.nextInt(13) - 6.0);
            float f1 = this.a(i1, j1 = ls.c(this.v + (double)this.ab.nextInt(7) - 3.0), k1 = ls.c(this.w + (double)this.ab.nextInt(13) - 6.0));
            if (!(f1 > f2)) continue;
            f2 = f1;
            i2 = i1;
            j2 = j1;
            k2 = k1;
            flag = true;
        }
        if (flag) {
            this.bp = this.q.a(this, i2, j2, k2, 10.0f, true, false, false, true);
        }
        this.q.C.b();
    }

    protected void a(nn par1Entity, float par2) {
    }

    public float a(int par1, int par2, int par3) {
        return 0.0f;
    }

    protected nn bL() {
        return null;
    }

    @Override
    public boolean bs() {
        int i2 = ls.c(this.u);
        int j2 = ls.c(this.E.b);
        int k2 = ls.c(this.w);
        return super.bs() && this.a(i2, j2, k2) >= 0.0f;
    }

    public boolean bM() {
        return this.bp != null;
    }

    public void a(alf par1PathEntity) {
        this.bp = par1PathEntity;
    }

    public nn bN() {
        return this.j;
    }

    public void b(nn par1Entity) {
        this.j = par1Entity;
    }

    public boolean bO() {
        return this.b(ls.c(this.u), ls.c(this.v), ls.c(this.w));
    }

    public boolean b(int par1, int par2, int par3) {
        return this.br == -1.0f ? true : this.bq.e(par1, par2, par3) < this.br * this.br;
    }

    public void b(int par1, int par2, int par3, int par4) {
        this.bq.b(par1, par2, par3);
        this.br = par4;
    }

    public t bP() {
        return this.bq;
    }

    public float bQ() {
        return this.br;
    }

    public void bR() {
        this.br = -1.0f;
    }

    public boolean bS() {
        return this.br != -1.0f;
    }

    @Override
    protected void bF() {
        super.bF();
        if (this.bH() && this.bI() != null && this.bI().q == this.q) {
            nn entity = this.bI();
            this.b((int)entity.u, (int)entity.v, (int)entity.w, 5);
            float f2 = this.d(entity);
            if (this instanceof oq && ((oq)this).bU()) {
                if (f2 > 10.0f) {
                    this.a(true, true);
                }
                return;
            }
            if (!this.bt) {
                this.c.a(2, this.bs);
                this.k().a(false);
                this.bt = true;
            }
            this.o(f2);
            if (f2 > 4.0f) {
                this.k().a(entity, 1.0);
            }
            if (f2 > 6.0f) {
                double d0 = (entity.u - this.u) / (double)f2;
                double d1 = (entity.v - this.v) / (double)f2;
                double d2 = (entity.w - this.w) / (double)f2;
                this.x += d0 * Math.abs(d0) * 0.4;
                this.y += d1 * Math.abs(d1) * 0.4;
                this.z += d2 * Math.abs(d2) * 0.4;
            }
            if (f2 > 10.0f) {
                this.a(true, true);
            }
        } else if (!this.bH() && this.bt) {
            this.bt = false;
            this.c.a(this.bs);
            this.k().a(true);
            this.bR();
        }
    }

    protected void o(float par1) {
    }
}


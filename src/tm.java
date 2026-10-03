/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaw
 *  abh
 *  nb
 *  th
 */
import java.util.Random;

public abstract class tm
extends on
implements th {
    public tm(abw par1World) {
        super(par1World);
        this.b = 5;
    }

    @Override
    public void c() {
        this.aW();
        float f2 = this.d(1.0f);
        if (f2 > 0.5f) {
            this.aV += 2;
        }
        super.c();
    }

    @Override
    public void l_() {
        super.l_();
        if (!this.q.I && this.q.r == 0) {
            this.x();
        }
    }

    @Override
    protected nn bL() {
        uf entityplayer = this.q.b((nn)this, 16.0);
        return entityplayer != null && this.o(entityplayer) ? entityplayer : null;
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        if (super.a(par1DamageSource, par2)) {
            nn entity = par1DamageSource.i();
            if (this.n != entity && this.o != entity) {
                if (entity != this) {
                    this.j = entity;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean m(nn par1Entity) {
        boolean flag;
        float f2 = (float)this.a(tp.e).e();
        int i2 = 0;
        if (par1Entity instanceof of) {
            f2 += aaw.a((of)this, (of)((of)par1Entity));
            i2 += aaw.b((of)this, (of)((of)par1Entity));
        }
        if (flag = par1Entity.a(nb.a((of)this), f2)) {
            int j2;
            if (i2 > 0) {
                par1Entity.g(-ls.a(this.A * (float)Math.PI / 180.0f) * (float)i2 * 0.5f, 0.1, ls.b(this.A * (float)Math.PI / 180.0f) * (float)i2 * 0.5f);
                this.x *= 0.6;
                this.z *= 0.6;
            }
            if ((j2 = aaw.a((of)this)) > 0) {
                par1Entity.d(j2 * 4);
            }
            if (par1Entity instanceof of) {
                abh.a((nn)this, (of)((of)par1Entity), (Random)this.ab);
            }
        }
        return flag;
    }

    @Override
    protected void a(nn par1Entity, float par2) {
        if (this.aC <= 0 && par2 < 2.0f && par1Entity.E.e > this.E.b && par1Entity.E.b < this.E.e) {
            this.aC = 20;
            this.m(par1Entity);
        }
    }

    @Override
    public float a(int par1, int par2, int par3) {
        return 0.5f - this.q.q(par1, par2, par3);
    }

    protected boolean i_() {
        int k2;
        int j2;
        int i2 = ls.c(this.u);
        if (this.q.b(ach.a, i2, j2 = ls.c(this.E.b), k2 = ls.c(this.w)) > this.ab.nextInt(32)) {
            return false;
        }
        int l2 = this.q.n(i2, j2, k2);
        if (this.q.P()) {
            int i1 = this.q.j;
            this.q.j = 10;
            l2 = this.q.n(i2, j2, k2);
            this.q.j = i1;
        }
        return l2 <= this.ab.nextInt(8);
    }

    @Override
    public boolean bs() {
        return this.q.r > 0 && this.i_() && super.bs();
    }

    @Override
    protected void az() {
        super.az();
        this.aX().b(tp.e);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  se
 */
public class sc
extends se {
    public float bp;
    public float bq;
    public float br;
    public float bs;
    public float bt;
    public float bu;
    public float bv;
    public float bw;
    private float bx;
    private float by;
    private float bz;
    private float bA;
    private float bB;
    private float bC;

    public sc(abw par1World) {
        super(par1World);
        this.a(0.95f, 0.95f);
        this.by = 1.0f / (this.ab.nextFloat() + 1.0f) * 0.2f;
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(10.0);
    }

    protected String r() {
        return null;
    }

    protected String aO() {
        return null;
    }

    protected String aP() {
        return null;
    }

    protected float ba() {
        return 0.4f;
    }

    protected int s() {
        return 0;
    }

    protected boolean e_() {
        return false;
    }

    protected void b(boolean par1, int par2) {
        int j2 = this.ab.nextInt(3 + par2) + 1;
        for (int k2 = 0; k2 < j2; ++k2) {
            this.a(new ye(yc.aY, 1, 0), 0.0f);
        }
    }

    public boolean H() {
        return this.q.a(this.E.b(0.0, (double)-0.6f, 0.0), akc.h, (nn)((Object)this));
    }

    public void c() {
        super.c();
        this.bq = this.bp;
        this.bs = this.br;
        this.bu = this.bt;
        this.bw = this.bv;
        this.bt += this.by;
        if (this.bt > (float)Math.PI * 2) {
            this.bt -= (float)Math.PI * 2;
            if (this.ab.nextInt(10) == 0) {
                this.by = 1.0f / (this.ab.nextFloat() + 1.0f) * 0.2f;
            }
        }
        if (this.H()) {
            float f2;
            if (this.bt < (float)Math.PI) {
                f2 = this.bt / (float)Math.PI;
                this.bv = ls.a(f2 * f2 * (float)Math.PI) * (float)Math.PI * 0.25f;
                if ((double)f2 > 0.75) {
                    this.bx = 1.0f;
                    this.bz = 1.0f;
                } else {
                    this.bz *= 0.8f;
                }
            } else {
                this.bv = 0.0f;
                this.bx *= 0.9f;
                this.bz *= 0.99f;
            }
            if (!this.q.I) {
                this.x = this.bA * this.bx;
                this.y = this.bB * this.bx;
                this.z = this.bC * this.bx;
            }
            f2 = ls.a(this.x * this.x + this.z * this.z);
            this.aN += (-((float)Math.atan2(this.x, this.z)) * 180.0f / (float)Math.PI - this.aN) * 0.1f;
            this.A = this.aN;
            this.br += (float)Math.PI * this.bz * 1.5f;
            this.bp += (-((float)Math.atan2(f2, this.y)) * 180.0f / (float)Math.PI - this.bp) * 0.1f;
        } else {
            this.bv = ls.e(ls.a(this.bt)) * (float)Math.PI * 0.25f;
            if (!this.q.I) {
                this.x = 0.0;
                this.y -= 0.08;
                this.y *= (double)0.98f;
                this.z = 0.0;
            }
            this.bp = (float)((double)this.bp + (double)(-90.0f - this.bp) * 0.02);
        }
    }

    public void e(float par1, float par2) {
        this.d(this.x, this.y, this.z);
    }

    protected void bl() {
        ++this.aV;
        if (this.aV > 100) {
            this.bC = 0.0f;
            this.bB = 0.0f;
            this.bA = 0.0f;
        } else if (this.ab.nextInt(50) == 0 || !this.ae || this.bA == 0.0f && this.bB == 0.0f && this.bC == 0.0f) {
            float f2 = this.ab.nextFloat() * (float)Math.PI * 2.0f;
            this.bA = ls.b(f2) * 0.2f;
            this.bB = -0.1f + this.ab.nextFloat() * 0.2f;
            this.bC = ls.a(f2) * 0.2f;
        }
        this.u();
    }

    public boolean bs() {
        return this.v > 45.0 && this.v < 63.0 && super.bs();
    }
}


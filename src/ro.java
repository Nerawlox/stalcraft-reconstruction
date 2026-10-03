/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nb
 *  rn
 *  t
 */
import java.util.Calendar;

public class ro
extends rn {
    private t h;

    public ro(abw par1World) {
        super(par1World);
        this.a(0.5f, 0.9f);
        this.a(true);
    }

    protected void a() {
        super.a();
        this.ah.a(16, new Byte(0));
    }

    protected float ba() {
        return 0.1f;
    }

    protected float bb() {
        return super.bb() * 0.95f;
    }

    protected String r() {
        return this.bJ() && this.ab.nextInt(4) != 0 ? null : "mob.bat.idle";
    }

    protected String aO() {
        return "mob.bat.hurt";
    }

    protected String aP() {
        return "mob.bat.death";
    }

    public boolean M() {
        return false;
    }

    protected void n(nn par1Entity) {
    }

    protected void bj() {
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(6.0);
    }

    public boolean bJ() {
        return (this.ah.a(16) & 1) != 0;
    }

    public void a(boolean par1) {
        byte b0 = this.ah.a(16);
        if (par1) {
            this.ah.b(16, (byte)(b0 | 1));
        } else {
            this.ah.b(16, (byte)(b0 & 0xFFFFFFFE));
        }
    }

    protected boolean bf() {
        return true;
    }

    public void l_() {
        super.l_();
        if (this.bJ()) {
            this.z = 0.0;
            this.y = 0.0;
            this.x = 0.0;
            this.v = (double)ls.c(this.v) + 1.0 - (double)this.P;
        } else {
            this.y *= (double)0.6f;
        }
    }

    protected void bi() {
        super.bi();
        if (this.bJ()) {
            if (!this.q.u(ls.c(this.u), (int)this.v + 1, ls.c(this.w))) {
                this.a(false);
                this.q.a(null, 1015, (int)this.u, (int)this.v, (int)this.w, 0);
            } else {
                if (this.ab.nextInt(200) == 0) {
                    this.aP = this.ab.nextInt(360);
                }
                if (this.q.a((nn)((Object)this), 4.0) != null) {
                    this.a(false);
                    this.q.a(null, 1015, (int)this.u, (int)this.v, (int)this.w, 0);
                }
            }
        } else {
            if (!(this.h == null || this.q.c(this.h.a, this.h.b, this.h.c) && this.h.b >= 1)) {
                this.h = null;
            }
            if (this.h == null || this.ab.nextInt(30) == 0 || this.h.e((int)this.u, (int)this.v, (int)this.w) < 4.0f) {
                this.h = new t((int)this.u + this.ab.nextInt(7) - this.ab.nextInt(7), (int)this.v + this.ab.nextInt(6) - 2, (int)this.w + this.ab.nextInt(7) - this.ab.nextInt(7));
            }
            double d0 = (double)this.h.a + 0.5 - this.u;
            double d1 = (double)this.h.b + 0.1 - this.v;
            double d2 = (double)this.h.c + 0.5 - this.w;
            this.x += (Math.signum(d0) * 0.5 - this.x) * (double)0.1f;
            this.y += (Math.signum(d1) * (double)0.7f - this.y) * (double)0.1f;
            this.z += (Math.signum(d2) * 0.5 - this.z) * (double)0.1f;
            float f2 = (float)(Math.atan2(this.z, this.x) * 180.0 / Math.PI) - 90.0f;
            float f1 = ls.g(f2 - this.A);
            this.bf = 0.5f;
            this.A += f1;
            if (this.ab.nextInt(100) == 0 && this.q.u(ls.c(this.u), (int)this.v + 1, ls.c(this.w))) {
                this.a(true);
            }
        }
    }

    protected boolean e_() {
        return false;
    }

    protected void b(float par1) {
    }

    protected void a(double par1, boolean par3) {
    }

    public boolean au() {
        return true;
    }

    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        if (!this.q.I && this.bJ()) {
            this.a(false);
        }
        return super.a(par1DamageSource, par2);
    }

    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.ah.b(16, par1NBTTagCompound.c("BatFlags"));
    }

    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("BatFlags", this.ah.a(16));
    }

    public boolean bs() {
        int i2 = ls.c(this.E.b);
        if (i2 >= 63) {
            return false;
        }
        int j2 = ls.c(this.u);
        int k2 = ls.c(this.w);
        int l2 = this.q.n(j2, i2, k2);
        int b0 = 4;
        Calendar calendar = this.q.W();
        if (!(calendar.get(2) + 1 == 10 && calendar.get(5) >= 20 || calendar.get(2) + 1 == 11 && calendar.get(5) <= 3)) {
            if (this.ab.nextBoolean()) {
                return false;
            }
        } else {
            b0 = 7;
        }
        return l2 > this.ab.nextInt(b0) ? false : super.bs();
    }
}


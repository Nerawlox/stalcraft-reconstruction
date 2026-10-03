/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alg
 *  aop
 *  ps
 */
public class pl
extends ps {
    private final og a;
    private final float b;
    private float c;
    private boolean d;
    private int e;
    private int f;

    public pl(og par1EntityLiving, float par2) {
        this.a = par1EntityLiving;
        this.b = par2;
        this.a(7);
    }

    public void c() {
        this.c = 0.0f;
    }

    public void d() {
        this.d = false;
        this.c = 0.0f;
    }

    public boolean a() {
        return this.a.T() && this.a.n != null && this.a.n instanceof uf && (this.d || this.a.by());
    }

    public void e() {
        ye itemstack;
        uf entityplayer = (uf)this.a.n;
        on entitycreature = (on)this.a;
        float f2 = ls.g(entityplayer.A - this.a.A) * 0.5f;
        if (f2 > 5.0f) {
            f2 = 5.0f;
        }
        if (f2 < -5.0f) {
            f2 = -5.0f;
        }
        this.a.A = ls.g(this.a.A + f2);
        if (this.c < this.b) {
            this.c += (this.b - this.c) * 0.01f;
        }
        if (this.c > this.b) {
            this.c = this.b;
        }
        int i2 = ls.c(this.a.u);
        int j2 = ls.c(this.a.v);
        int k2 = ls.c(this.a.w);
        float f1 = this.c;
        if (this.d) {
            if (this.e++ > this.f) {
                this.d = false;
            }
            f1 += f1 * 1.15f * ls.a((float)this.e / (float)this.f * (float)Math.PI);
        }
        float f22 = 0.91f;
        if (this.a.F) {
            f22 = 0.54600006f;
            int l2 = this.a.q.a(ls.d(i2), ls.d(j2) - 1, ls.d(k2));
            if (l2 > 0) {
                f22 = aqz.s[l2].cV * 0.91f;
            }
        }
        float f3 = 0.16277136f / (f22 * f22 * f22);
        float f4 = ls.a(entitycreature.A * (float)Math.PI / 180.0f);
        float f5 = ls.b(entitycreature.A * (float)Math.PI / 180.0f);
        float f6 = entitycreature.bg() * f3;
        float f7 = Math.max(f1, 1.0f);
        f7 = f6 / f7;
        float f8 = f1 * f7;
        float f9 = -(f8 * f4);
        float f10 = f8 * f5;
        if (ls.e(f9) > ls.e(f10)) {
            if (f9 < 0.0f) {
                f9 -= this.a.O / 2.0f;
            }
            if (f9 > 0.0f) {
                f9 += this.a.O / 2.0f;
            }
            f10 = 0.0f;
        } else {
            f9 = 0.0f;
            if (f10 < 0.0f) {
                f10 -= this.a.O / 2.0f;
            }
            if (f10 > 0.0f) {
                f10 += this.a.O / 2.0f;
            }
        }
        int i1 = ls.c(this.a.u + (double)f9);
        int j1 = ls.c(this.a.w + (double)f10);
        ale pathpoint = new ale(ls.d(this.a.O + 1.0f), ls.d(this.a.P + entityplayer.P + 1.0f), ls.d(this.a.O + 1.0f));
        if (i2 != i1 || k2 != j1) {
            boolean flag;
            int k1 = this.a.q.a(i2, j2, k2);
            int l1 = this.a.q.a(i2, j2 - 1, k2);
            boolean bl2 = flag = this.b(k1) || aqz.s[k1] == null && this.b(l1);
            if (!flag && alg.a((nn)this.a, (int)i1, (int)j2, (int)j1, (ale)pathpoint, (boolean)false, (boolean)false, (boolean)true) == 0 && alg.a((nn)this.a, (int)i2, (int)(j2 + 1), (int)k2, (ale)pathpoint, (boolean)false, (boolean)false, (boolean)true) == 1 && alg.a((nn)this.a, (int)i1, (int)(j2 + 1), (int)j1, (ale)pathpoint, (boolean)false, (boolean)false, (boolean)true) == 1) {
                entitycreature.j().a();
            }
        }
        if (!entityplayer.bG.d && this.c >= this.b * 0.5f && this.a.aD().nextFloat() < 0.006f && !this.d && (itemstack = entityplayer.aZ()) != null && itemstack.d == yc.bT.cv) {
            itemstack.a(1, (of)entityplayer);
            if (itemstack.b == 0) {
                ye itemstack1 = new ye((yc)yc.aT);
                itemstack1.d(itemstack.e);
                entityplayer.bn.a[entityplayer.bn.c] = itemstack1;
            }
        }
        this.a.e(0.0f, f1);
    }

    private boolean b(int par1) {
        return aqz.s[par1] != null && (aqz.s[par1].d() == 10 || aqz.s[par1] instanceof aop);
    }

    public boolean f() {
        return this.d;
    }

    public void g() {
        this.d = true;
        this.e = 0;
        this.f = this.a.aD().nextInt(841) + 140;
    }

    public boolean h() {
        return !this.f() && this.c > this.b * 0.3f;
    }
}


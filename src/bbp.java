/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bbp
extends bbo {
    private bcu a;
    private bcu b;
    private bcu c;
    private bcu d;
    private bcu e;
    private bcu f;
    private bcu g;
    private bcu h;
    private bcu i;
    private bcu j;
    private bcu k;
    private bcu l;
    private bcu m;
    private bcu n;
    private bcu o;
    private bcu v;
    private bcu w;
    private bcu x;
    private bcu y;
    private bcu z;
    private bcu A;
    private bcu B;
    private bcu C;
    private bcu D;
    private bcu E;
    private bcu F;
    private bcu G;
    private bcu H;
    private bcu I;
    private bcu J;
    private bcu K;
    private bcu L;
    private bcu M;
    private bcu N;
    private bcu O;
    private bcu P;
    private bcu Q;
    private bcu R;
    private bcu S;

    public bbp() {
        this.t = 128;
        this.u = 128;
        this.k = new bcu(this, 0, 34);
        this.k.a(-5.0f, -8.0f, -19.0f, 10, 10, 24);
        this.k.a(0.0f, 11.0f, 9.0f);
        this.l = new bcu(this, 44, 0);
        this.l.a(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.l.a(0.0f, 3.0f, 14.0f);
        this.a(this.l, -1.134464f, 0.0f, 0.0f);
        this.m = new bcu(this, 38, 7);
        this.m.a(-1.5f, -2.0f, 3.0f, 3, 4, 7);
        this.m.a(0.0f, 3.0f, 14.0f);
        this.a(this.m, -1.134464f, 0.0f, 0.0f);
        this.n = new bcu(this, 24, 3);
        this.n.a(-1.5f, -4.5f, 9.0f, 3, 4, 7);
        this.n.a(0.0f, 3.0f, 14.0f);
        this.a(this.n, -1.40215f, 0.0f, 0.0f);
        this.o = new bcu(this, 78, 29);
        this.o.a(-2.5f, -2.0f, -2.5f, 4, 9, 5);
        this.o.a(4.0f, 9.0f, 11.0f);
        this.v = new bcu(this, 78, 43);
        this.v.a(-2.0f, 0.0f, -1.5f, 3, 5, 3);
        this.v.a(4.0f, 16.0f, 11.0f);
        this.w = new bcu(this, 78, 51);
        this.w.a(-2.5f, 5.1f, -2.0f, 4, 3, 4);
        this.w.a(4.0f, 16.0f, 11.0f);
        this.x = new bcu(this, 96, 29);
        this.x.a(-1.5f, -2.0f, -2.5f, 4, 9, 5);
        this.x.a(-4.0f, 9.0f, 11.0f);
        this.y = new bcu(this, 96, 43);
        this.y.a(-1.0f, 0.0f, -1.5f, 3, 5, 3);
        this.y.a(-4.0f, 16.0f, 11.0f);
        this.z = new bcu(this, 96, 51);
        this.z.a(-1.5f, 5.1f, -2.0f, 4, 3, 4);
        this.z.a(-4.0f, 16.0f, 11.0f);
        this.A = new bcu(this, 44, 29);
        this.A.a(-1.9f, -1.0f, -2.1f, 3, 8, 4);
        this.A.a(4.0f, 9.0f, -8.0f);
        this.B = new bcu(this, 44, 41);
        this.B.a(-1.9f, 0.0f, -1.6f, 3, 5, 3);
        this.B.a(4.0f, 16.0f, -8.0f);
        this.C = new bcu(this, 44, 51);
        this.C.a(-2.4f, 5.1f, -2.1f, 4, 3, 4);
        this.C.a(4.0f, 16.0f, -8.0f);
        this.D = new bcu(this, 60, 29);
        this.D.a(-1.1f, -1.0f, -2.1f, 3, 8, 4);
        this.D.a(-4.0f, 9.0f, -8.0f);
        this.E = new bcu(this, 60, 41);
        this.E.a(-1.1f, 0.0f, -1.6f, 3, 5, 3);
        this.E.a(-4.0f, 16.0f, -8.0f);
        this.F = new bcu(this, 60, 51);
        this.F.a(-1.6f, 5.1f, -2.1f, 4, 3, 4);
        this.F.a(-4.0f, 16.0f, -8.0f);
        this.a = new bcu(this, 0, 0);
        this.a.a(-2.5f, -10.0f, -1.5f, 5, 5, 7);
        this.a.a(0.0f, 4.0f, -10.0f);
        this.a(this.a, 0.5235988f, 0.0f, 0.0f);
        this.b = new bcu(this, 24, 18);
        this.b.a(-2.0f, -10.0f, -7.0f, 4, 3, 6);
        this.b.a(0.0f, 3.95f, -10.0f);
        this.a(this.b, 0.5235988f, 0.0f, 0.0f);
        this.c = new bcu(this, 24, 27);
        this.c.a(-2.0f, -7.0f, -6.5f, 4, 2, 5);
        this.c.a(0.0f, 4.0f, -10.0f);
        this.a(this.c, 0.5235988f, 0.0f, 0.0f);
        this.a.a(this.b);
        this.a.a(this.c);
        this.d = new bcu(this, 0, 0);
        this.d.a(0.45f, -12.0f, 4.0f, 2, 3, 1);
        this.d.a(0.0f, 4.0f, -10.0f);
        this.a(this.d, 0.5235988f, 0.0f, 0.0f);
        this.e = new bcu(this, 0, 0);
        this.e.a(-2.45f, -12.0f, 4.0f, 2, 3, 1);
        this.e.a(0.0f, 4.0f, -10.0f);
        this.a(this.e, 0.5235988f, 0.0f, 0.0f);
        this.f = new bcu(this, 0, 12);
        this.f.a(-2.0f, -16.0f, 4.0f, 2, 7, 1);
        this.f.a(0.0f, 4.0f, -10.0f);
        this.a(this.f, 0.5235988f, 0.0f, 0.2617994f);
        this.g = new bcu(this, 0, 12);
        this.g.a(0.0f, -16.0f, 4.0f, 2, 7, 1);
        this.g.a(0.0f, 4.0f, -10.0f);
        this.a(this.g, 0.5235988f, 0.0f, -0.2617994f);
        this.h = new bcu(this, 0, 12);
        this.h.a(-2.05f, -9.8f, -2.0f, 4, 14, 8);
        this.h.a(0.0f, 4.0f, -10.0f);
        this.a(this.h, 0.5235988f, 0.0f, 0.0f);
        this.G = new bcu(this, 0, 34);
        this.G.a(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.G.a(-7.5f, 3.0f, 10.0f);
        this.a(this.G, 0.0f, 1.5707964f, 0.0f);
        this.H = new bcu(this, 0, 47);
        this.H.a(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.H.a(4.5f, 3.0f, 10.0f);
        this.a(this.H, 0.0f, 1.5707964f, 0.0f);
        this.I = new bcu(this, 80, 0);
        this.I.a(-5.0f, 0.0f, -3.0f, 10, 1, 8);
        this.I.a(0.0f, 2.0f, 2.0f);
        this.J = new bcu(this, 106, 9);
        this.J.a(-1.5f, -1.0f, -3.0f, 3, 1, 2);
        this.J.a(0.0f, 2.0f, 2.0f);
        this.K = new bcu(this, 80, 9);
        this.K.a(-4.0f, -1.0f, 3.0f, 8, 1, 2);
        this.K.a(0.0f, 2.0f, 2.0f);
        this.M = new bcu(this, 74, 0);
        this.M.a(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.M.a(5.0f, 3.0f, 2.0f);
        this.L = new bcu(this, 70, 0);
        this.L.a(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.L.a(5.0f, 3.0f, 2.0f);
        this.O = new bcu(this, 74, 4);
        this.O.a(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.O.a(-5.0f, 3.0f, 2.0f);
        this.N = new bcu(this, 80, 0);
        this.N.a(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.N.a(-5.0f, 3.0f, 2.0f);
        this.P = new bcu(this, 74, 13);
        this.P.a(1.5f, -8.0f, -4.0f, 1, 2, 2);
        this.P.a(0.0f, 4.0f, -10.0f);
        this.a(this.P, 0.5235988f, 0.0f, 0.0f);
        this.Q = new bcu(this, 74, 13);
        this.Q.a(-2.5f, -8.0f, -4.0f, 1, 2, 2);
        this.Q.a(0.0f, 4.0f, -10.0f);
        this.a(this.Q, 0.5235988f, 0.0f, 0.0f);
        this.R = new bcu(this, 44, 10);
        this.R.a(2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.R.a(0.0f, 4.0f, -10.0f);
        this.S = new bcu(this, 44, 5);
        this.S.a(-2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.S.a(0.0f, 4.0f, -10.0f);
        this.j = new bcu(this, 58, 0);
        this.j.a(-1.0f, -11.5f, 5.0f, 2, 16, 4);
        this.j.a(0.0f, 4.0f, -10.0f);
        this.a(this.j, 0.5235988f, 0.0f, 0.0f);
        this.i = new bcu(this, 80, 12);
        this.i.a(-2.5f, -10.1f, -7.0f, 5, 5, 12, 0.2f);
        this.i.a(0.0f, 4.0f, -10.0f);
        this.a(this.i, 0.5235988f, 0.0f, 0.0f);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        boolean flag4;
        rs entityhorse = (rs)((Object)par1Entity);
        int i2 = entityhorse.bT();
        float f6 = entityhorse.p(0.0f);
        boolean flag = entityhorse.bV();
        boolean flag1 = flag && entityhorse.co();
        boolean flag2 = flag && entityhorse.ce();
        boolean flag3 = i2 == 1 || i2 == 2;
        float f7 = entityhorse.cc();
        boolean bl2 = flag4 = entityhorse.n != null;
        if (flag1) {
            this.i.a(par7);
            this.I.a(par7);
            this.J.a(par7);
            this.K.a(par7);
            this.L.a(par7);
            this.M.a(par7);
            this.N.a(par7);
            this.O.a(par7);
            this.P.a(par7);
            this.Q.a(par7);
            if (flag4) {
                this.R.a(par7);
                this.S.a(par7);
            }
        }
        if (!flag) {
            GL11.glPushMatrix();
            GL11.glScalef((float)f7, (float)(0.5f + f7 * 0.5f), (float)f7);
            GL11.glTranslatef((float)0.0f, (float)(0.95f * (1.0f - f7)), (float)0.0f);
        }
        this.o.a(par7);
        this.v.a(par7);
        this.w.a(par7);
        this.x.a(par7);
        this.y.a(par7);
        this.z.a(par7);
        this.A.a(par7);
        this.B.a(par7);
        this.C.a(par7);
        this.D.a(par7);
        this.E.a(par7);
        this.F.a(par7);
        if (!flag) {
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef((float)f7, (float)f7, (float)f7);
            GL11.glTranslatef((float)0.0f, (float)(1.35f * (1.0f - f7)), (float)0.0f);
        }
        this.k.a(par7);
        this.l.a(par7);
        this.m.a(par7);
        this.n.a(par7);
        this.h.a(par7);
        this.j.a(par7);
        if (!flag) {
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            float f8 = 0.5f + f7 * f7 * 0.5f;
            GL11.glScalef((float)f8, (float)f8, (float)f8);
            if (f6 <= 0.0f) {
                GL11.glTranslatef((float)0.0f, (float)(1.35f * (1.0f - f7)), (float)0.0f);
            } else {
                GL11.glTranslatef((float)0.0f, (float)(0.9f * (1.0f - f7) * f6 + 1.35f * (1.0f - f7) * (1.0f - f6)), (float)(0.15f * (1.0f - f7) * f6));
            }
        }
        if (flag3) {
            this.f.a(par7);
            this.g.a(par7);
        } else {
            this.d.a(par7);
            this.e.a(par7);
        }
        this.a.a(par7);
        if (!flag) {
            GL11.glPopMatrix();
        }
        if (flag2) {
            this.G.a(par7);
            this.H.a(par7);
        }
    }

    private void a(bcu par1ModelRenderer, float par2, float par3, float par4) {
        par1ModelRenderer.f = par2;
        par1ModelRenderer.g = par3;
        par1ModelRenderer.h = par4;
    }

    private float a(float par1, float par2, float par3) {
        float f3;
        for (f3 = par2 - par1; f3 < -180.0f; f3 += 360.0f) {
        }
        while (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        return par1 + par3 * f3;
    }

    public void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        super.a(par1EntityLivingBase, par2, par3, par4);
        float f3 = this.a(par1EntityLivingBase.aO, par1EntityLivingBase.aN, par4);
        float f4 = this.a(par1EntityLivingBase.aQ, par1EntityLivingBase.aP, par4);
        float f5 = par1EntityLivingBase.D + (par1EntityLivingBase.B - par1EntityLivingBase.D) * par4;
        float f6 = f4 - f3;
        float f7 = f5 / 57.295776f;
        if (f6 > 20.0f) {
            f6 = 20.0f;
        }
        if (f6 < -20.0f) {
            f6 = -20.0f;
        }
        if (par3 > 0.2f) {
            f7 += ls.b(par2 * 0.4f) * 0.15f * par3;
        }
        rs entityhorse = (rs)((Object)par1EntityLivingBase);
        float f8 = entityhorse.p(par4);
        float f9 = entityhorse.q(par4);
        float f10 = 1.0f - f9;
        float f11 = entityhorse.r(par4);
        boolean flag = entityhorse.bp != 0;
        boolean flag1 = entityhorse.co();
        boolean flag2 = entityhorse.n != null;
        float f12 = (float)par1EntityLivingBase.ac + par4;
        float f13 = ls.b(par2 * 0.6662f + (float)Math.PI);
        float f14 = f13 * 0.8f * par3;
        this.a.d = 4.0f;
        this.a.e = -10.0f;
        this.l.d = 3.0f;
        this.m.e = 14.0f;
        this.H.d = 3.0f;
        this.H.e = 10.0f;
        this.k.f = 0.0f;
        this.a.f = 0.5235988f + f7;
        this.a.g = f6 / 57.295776f;
        this.a.f = f9 * (0.2617994f + f7) + f8 * 2.18166f + (1.0f - Math.max(f9, f8)) * this.a.f;
        this.a.g = f9 * (f6 / 57.295776f) + (1.0f - Math.max(f9, f8)) * this.a.g;
        this.a.d = f9 * -6.0f + f8 * 11.0f + (1.0f - Math.max(f9, f8)) * this.a.d;
        this.a.e = f9 * -1.0f + f8 * -10.0f + (1.0f - Math.max(f9, f8)) * this.a.e;
        this.l.d = f9 * 9.0f + f10 * this.l.d;
        this.m.e = f9 * 18.0f + f10 * this.m.e;
        this.H.d = f9 * 5.5f + f10 * this.H.d;
        this.H.e = f9 * 15.0f + f10 * this.H.e;
        this.k.f = f9 * -0.7853982f + f10 * this.k.f;
        this.d.d = this.a.d;
        this.e.d = this.a.d;
        this.f.d = this.a.d;
        this.g.d = this.a.d;
        this.h.d = this.a.d;
        this.b.d = 0.02f;
        this.c.d = 0.0f;
        this.j.d = this.a.d;
        this.d.e = this.a.e;
        this.e.e = this.a.e;
        this.f.e = this.a.e;
        this.g.e = this.a.e;
        this.h.e = this.a.e;
        this.b.e = 0.02f - f11 * 1.0f;
        this.c.e = 0.0f + f11 * 1.0f;
        this.j.e = this.a.e;
        this.d.f = this.a.f;
        this.e.f = this.a.f;
        this.f.f = this.a.f;
        this.g.f = this.a.f;
        this.h.f = this.a.f;
        this.b.f = 0.0f - 0.09424778f * f11;
        this.c.f = 0.0f + 0.15707964f * f11;
        this.j.f = this.a.f;
        this.d.g = this.a.g;
        this.e.g = this.a.g;
        this.f.g = this.a.g;
        this.g.g = this.a.g;
        this.h.g = this.a.g;
        this.b.g = 0.0f;
        this.c.g = 0.0f;
        this.j.g = this.a.g;
        this.G.f = f14 / 5.0f;
        this.H.f = -f14 / 5.0f;
        float f15 = 1.5707964f;
        float f16 = 4.712389f;
        float f17 = -1.0471976f;
        float f18 = 0.2617994f * f9;
        float f19 = ls.b(f12 * 0.6f + (float)Math.PI);
        this.A.d = -2.0f * f9 + 9.0f * f10;
        this.A.e = -2.0f * f9 + -8.0f * f10;
        this.D.d = this.A.d;
        this.D.e = this.A.e;
        this.v.d = this.o.d + ls.a(1.5707964f + f18 + f10 * -f13 * 0.5f * par3) * 7.0f;
        this.v.e = this.o.e + ls.b(4.712389f + f18 + f10 * -f13 * 0.5f * par3) * 7.0f;
        this.y.d = this.x.d + ls.a(1.5707964f + f18 + f10 * f13 * 0.5f * par3) * 7.0f;
        this.y.e = this.x.e + ls.b(4.712389f + f18 + f10 * f13 * 0.5f * par3) * 7.0f;
        float f20 = (-1.0471976f + f19) * f9 + f14 * f10;
        float f21 = (-1.0471976f + -f19) * f9 + -f14 * f10;
        this.B.d = this.A.d + ls.a(1.5707964f + f20) * 7.0f;
        this.B.e = this.A.e + ls.b(4.712389f + f20) * 7.0f;
        this.E.d = this.D.d + ls.a(1.5707964f + f21) * 7.0f;
        this.E.e = this.D.e + ls.b(4.712389f + f21) * 7.0f;
        this.o.f = f18 + -f13 * 0.5f * par3 * f10;
        this.w.f = this.v.f = -0.08726646f * f9 + (-f13 * 0.5f * par3 - Math.max(0.0f, f13 * 0.5f * par3)) * f10;
        this.x.f = f18 + f13 * 0.5f * par3 * f10;
        this.z.f = this.y.f = -0.08726646f * f9 + (f13 * 0.5f * par3 - Math.max(0.0f, -f13 * 0.5f * par3)) * f10;
        this.A.f = f20;
        this.C.f = this.B.f = (this.A.f + (float)Math.PI * Math.max(0.0f, 0.2f + f19 * 0.2f)) * f9 + (f14 + Math.max(0.0f, f13 * 0.5f * par3)) * f10;
        this.D.f = f21;
        this.F.f = this.E.f = (this.D.f + (float)Math.PI * Math.max(0.0f, 0.2f - f19 * 0.2f)) * f9 + (-f14 + Math.max(0.0f, -f13 * 0.5f * par3)) * f10;
        this.w.d = this.v.d;
        this.w.e = this.v.e;
        this.z.d = this.y.d;
        this.z.e = this.y.e;
        this.C.d = this.B.d;
        this.C.e = this.B.e;
        this.F.d = this.E.d;
        this.F.e = this.E.e;
        if (flag1) {
            this.I.d = f9 * 0.5f + f10 * 2.0f;
            this.I.e = f9 * 11.0f + f10 * 2.0f;
            this.J.d = this.I.d;
            this.K.d = this.I.d;
            this.L.d = this.I.d;
            this.N.d = this.I.d;
            this.M.d = this.I.d;
            this.O.d = this.I.d;
            this.G.d = this.H.d;
            this.J.e = this.I.e;
            this.K.e = this.I.e;
            this.L.e = this.I.e;
            this.N.e = this.I.e;
            this.M.e = this.I.e;
            this.O.e = this.I.e;
            this.G.e = this.H.e;
            this.I.f = this.k.f;
            this.J.f = this.k.f;
            this.K.f = this.k.f;
            this.R.d = this.a.d;
            this.S.d = this.a.d;
            this.i.d = this.a.d;
            this.P.d = this.a.d;
            this.Q.d = this.a.d;
            this.R.e = this.a.e;
            this.S.e = this.a.e;
            this.i.e = this.a.e;
            this.P.e = this.a.e;
            this.Q.e = this.a.e;
            this.R.f = f7;
            this.S.f = f7;
            this.i.f = this.a.f;
            this.P.f = this.a.f;
            this.Q.f = this.a.f;
            this.i.g = this.a.g;
            this.P.g = this.a.g;
            this.R.g = this.a.g;
            this.Q.g = this.a.g;
            this.S.g = this.a.g;
            if (flag2) {
                this.L.f = -1.0471976f;
                this.M.f = -1.0471976f;
                this.N.f = -1.0471976f;
                this.O.f = -1.0471976f;
                this.L.h = 0.0f;
                this.M.h = 0.0f;
                this.N.h = 0.0f;
                this.O.h = 0.0f;
            } else {
                this.L.f = f14 / 3.0f;
                this.M.f = f14 / 3.0f;
                this.N.f = f14 / 3.0f;
                this.O.f = f14 / 3.0f;
                this.L.h = f14 / 5.0f;
                this.M.h = f14 / 5.0f;
                this.N.h = -f14 / 5.0f;
                this.O.h = -f14 / 5.0f;
            }
        }
        if ((f15 = -1.3089f + par3 * 1.5f) > 0.0f) {
            f15 = 0.0f;
        }
        if (flag) {
            this.l.g = ls.b(f12 * 0.7f);
            f15 = 0.0f;
        } else {
            this.l.g = 0.0f;
        }
        this.m.g = this.l.g;
        this.n.g = this.l.g;
        this.m.d = this.l.d;
        this.n.d = this.l.d;
        this.m.e = this.l.e;
        this.n.e = this.l.e;
        this.l.f = f15;
        this.m.f = f15;
        this.n.f = -0.2618f + f15;
    }
}


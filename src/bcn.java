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
public class bcn
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
    private float m;

    public bcn(float par1) {
        this.t = 256;
        this.u = 256;
        this.a("body.body", 0, 0);
        this.a("wing.skin", -56, 88);
        this.a("wingtip.skin", -56, 144);
        this.a("rearleg.main", 0, 0);
        this.a("rearfoot.main", 112, 0);
        this.a("rearlegtip.main", 196, 0);
        this.a("head.upperhead", 112, 30);
        this.a("wing.bone", 112, 88);
        this.a("head.upperlip", 176, 44);
        this.a("jaw.jaw", 176, 65);
        this.a("frontleg.main", 112, 104);
        this.a("wingtip.bone", 112, 136);
        this.a("frontfoot.main", 144, 104);
        this.a("neck.box", 192, 104);
        this.a("frontlegtip.main", 226, 138);
        this.a("body.scale", 220, 53);
        this.a("head.scale", 0, 0);
        this.a("neck.scale", 48, 0);
        this.a("head.nostril", 112, 0);
        float f1 = -16.0f;
        this.a = new bcu(this, "head");
        this.a.a("upperlip", -6.0f, -1.0f, -8.0f + f1, 12, 5, 16);
        this.a.a("upperhead", -8.0f, -8.0f, 6.0f + f1, 16, 16, 16);
        this.a.i = true;
        this.a.a("scale", -5.0f, -12.0f, 12.0f + f1, 2, 4, 6);
        this.a.a("nostril", -5.0f, -3.0f, -6.0f + f1, 2, 2, 4);
        this.a.i = false;
        this.a.a("scale", 3.0f, -12.0f, 12.0f + f1, 2, 4, 6);
        this.a.a("nostril", 3.0f, -3.0f, -6.0f + f1, 2, 2, 4);
        this.c = new bcu(this, "jaw");
        this.c.a(0.0f, 4.0f, 8.0f + f1);
        this.c.a("jaw", -6.0f, 0.0f, -16.0f, 12, 4, 16);
        this.a.a(this.c);
        this.b = new bcu(this, "neck");
        this.b.a("box", -5.0f, -5.0f, -5.0f, 10, 10, 10);
        this.b.a("scale", -1.0f, -9.0f, -3.0f, 2, 4, 6);
        this.d = new bcu(this, "body");
        this.d.a(0.0f, 4.0f, 8.0f);
        this.d.a("body", -12.0f, 0.0f, -16.0f, 24, 24, 64);
        this.d.a("scale", -1.0f, -6.0f, -10.0f, 2, 6, 12);
        this.d.a("scale", -1.0f, -6.0f, 10.0f, 2, 6, 12);
        this.d.a("scale", -1.0f, -6.0f, 30.0f, 2, 6, 12);
        this.k = new bcu(this, "wing");
        this.k.a(-12.0f, 5.0f, 2.0f);
        this.k.a("bone", -56.0f, -4.0f, -4.0f, 56, 8, 8);
        this.k.a("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.l = new bcu(this, "wingtip");
        this.l.a(-56.0f, 0.0f, 0.0f);
        this.l.a("bone", -56.0f, -2.0f, -2.0f, 56, 4, 4);
        this.l.a("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.k.a(this.l);
        this.f = new bcu(this, "frontleg");
        this.f.a(-12.0f, 20.0f, 2.0f);
        this.f.a("main", -4.0f, -4.0f, -4.0f, 8, 24, 8);
        this.h = new bcu(this, "frontlegtip");
        this.h.a(0.0f, 20.0f, -1.0f);
        this.h.a("main", -3.0f, -1.0f, -3.0f, 6, 24, 6);
        this.f.a(this.h);
        this.j = new bcu(this, "frontfoot");
        this.j.a(0.0f, 23.0f, 0.0f);
        this.j.a("main", -4.0f, 0.0f, -12.0f, 8, 4, 16);
        this.h.a(this.j);
        this.e = new bcu(this, "rearleg");
        this.e.a(-16.0f, 16.0f, 42.0f);
        this.e.a("main", -8.0f, -4.0f, -8.0f, 16, 32, 16);
        this.g = new bcu(this, "rearlegtip");
        this.g.a(0.0f, 32.0f, -4.0f);
        this.g.a("main", -6.0f, -2.0f, 0.0f, 12, 32, 12);
        this.e.a(this.g);
        this.i = new bcu(this, "rearfoot");
        this.i.a(0.0f, 31.0f, 4.0f);
        this.i.a("main", -9.0f, 0.0f, -20.0f, 18, 6, 24);
        this.g.a(this.i);
    }

    public void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        this.m = par4;
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        float f15;
        GL11.glPushMatrix();
        sk entitydragon = (sk)par1Entity;
        float f6 = entitydragon.bx + (entitydragon.by - entitydragon.bx) * this.m;
        this.c.f = (float)(Math.sin(f6 * (float)Math.PI * 2.0f) + 1.0) * 0.2f;
        float f7 = (float)(Math.sin(f6 * (float)Math.PI * 2.0f - 1.0f) + 1.0);
        f7 = (f7 * f7 * 1.0f + f7 * 2.0f) * 0.05f;
        GL11.glTranslatef((float)0.0f, (float)(f7 - 2.0f), (float)-3.0f);
        GL11.glRotatef((float)(f7 * 2.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        float f8 = -30.0f;
        float f9 = 0.0f;
        float f10 = 1.5f;
        double[] adouble = entitydragon.b(6, this.m);
        float f11 = this.a(entitydragon.b(5, this.m)[0] - entitydragon.b(10, this.m)[0]);
        float f12 = this.a(entitydragon.b(5, this.m)[0] + (double)(f11 / 2.0f));
        f8 += 2.0f;
        float f13 = f6 * (float)Math.PI * 2.0f;
        f8 = 20.0f;
        float f14 = -12.0f;
        for (int i2 = 0; i2 < 5; ++i2) {
            double[] adouble1 = entitydragon.b(5 - i2, this.m);
            f15 = (float)Math.cos((float)i2 * 0.45f + f13) * 0.15f;
            this.b.g = this.a(adouble1[0] - adouble[0]) * (float)Math.PI / 180.0f * f10;
            this.b.f = f15 + (float)(adouble1[1] - adouble[1]) * (float)Math.PI / 180.0f * f10 * 5.0f;
            this.b.h = -this.a(adouble1[0] - (double)f12) * (float)Math.PI / 180.0f * f10;
            this.b.d = f8;
            this.b.e = f14;
            this.b.c = f9;
            f8 = (float)((double)f8 + Math.sin(this.b.f) * 10.0);
            f14 = (float)((double)f14 - Math.cos(this.b.g) * Math.cos(this.b.f) * 10.0);
            f9 = (float)((double)f9 - Math.sin(this.b.g) * Math.cos(this.b.f) * 10.0);
            this.b.a(par7);
        }
        this.a.d = f8;
        this.a.e = f14;
        this.a.c = f9;
        double[] adouble2 = entitydragon.b(0, this.m);
        this.a.g = this.a(adouble2[0] - adouble[0]) * (float)Math.PI / 180.0f * 1.0f;
        this.a.h = -this.a(adouble2[0] - (double)f12) * (float)Math.PI / 180.0f * 1.0f;
        this.a.a(par7);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-f11 * f10 * 1.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glTranslatef((float)0.0f, (float)-1.0f, (float)0.0f);
        this.d.h = 0.0f;
        this.d.a(par7);
        for (int j2 = 0; j2 < 2; ++j2) {
            GL11.glEnable((int)2884);
            f15 = f6 * (float)Math.PI * 2.0f;
            this.k.f = 0.125f - (float)Math.cos(f15) * 0.2f;
            this.k.g = 0.25f;
            this.k.h = (float)(Math.sin(f15) + 0.125) * 0.8f;
            this.l.h = -((float)(Math.sin(f15 + 2.0f) + 0.5)) * 0.75f;
            this.e.f = 1.0f + f7 * 0.1f;
            this.g.f = 0.5f + f7 * 0.1f;
            this.i.f = 0.75f + f7 * 0.1f;
            this.f.f = 1.3f + f7 * 0.1f;
            this.h.f = -0.5f - f7 * 0.1f;
            this.j.f = 0.75f + f7 * 0.1f;
            this.k.a(par7);
            this.f.a(par7);
            this.e.a(par7);
            GL11.glScalef((float)-1.0f, (float)1.0f, (float)1.0f);
            if (j2 != 0) continue;
            GL11.glCullFace((int)1028);
        }
        GL11.glPopMatrix();
        GL11.glCullFace((int)1029);
        GL11.glDisable((int)2884);
        float f16 = -((float)Math.sin(f6 * (float)Math.PI * 2.0f)) * 0.0f;
        f13 = f6 * (float)Math.PI * 2.0f;
        f8 = 10.0f;
        f14 = 60.0f;
        f9 = 0.0f;
        adouble = entitydragon.b(11, this.m);
        for (int k = 0; k < 12; ++k) {
            adouble2 = entitydragon.b(12 + k, this.m);
            f16 = (float)((double)f16 + Math.sin((float)k * 0.45f + f13) * (double)0.05f);
            this.b.g = (this.a(adouble2[0] - adouble[0]) * f10 + 180.0f) * (float)Math.PI / 180.0f;
            this.b.f = f16 + (float)(adouble2[1] - adouble[1]) * (float)Math.PI / 180.0f * f10 * 5.0f;
            this.b.h = this.a(adouble2[0] - (double)f12) * (float)Math.PI / 180.0f * f10;
            this.b.d = f8;
            this.b.e = f14;
            this.b.c = f9;
            f8 = (float)((double)f8 + Math.sin(this.b.f) * 10.0);
            f14 = (float)((double)f14 - Math.cos(this.b.g) * Math.cos(this.b.f) * 10.0);
            f9 = (float)((double)f9 - Math.sin(this.b.g) * Math.cos(this.b.f) * 10.0);
            this.b.a(par7);
        }
        GL11.glPopMatrix();
    }

    private float a(double par1) {
        while (par1 >= 180.0) {
            par1 -= 360.0;
        }
        while (par1 < -180.0) {
            par1 += 360.0;
        }
        return (float)par1;
    }
}


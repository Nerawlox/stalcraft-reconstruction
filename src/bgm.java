/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class bgm {
    private static final bjo a = new bjo("textures/misc/shadow.png");
    protected bgl b;
    protected bfr c = new bfr();
    protected float d;
    protected float e = 1.0f;

    public abstract void a(nn var1, double var2, double var4, double var6, float var8, float var9);

    protected abstract bjo a(nn var1);

    protected void b(nn par1Entity) {
        this.a(this.a(par1Entity));
    }

    protected void a(bjo par1ResourceLocation) {
        this.b.e.a(par1ResourceLocation);
    }

    private void a(nn par1Entity, double par2, double par4, double par6, float par8) {
        GL11.glDisable((int)2896);
        ms icon = aqz.aw.c(0);
        ms icon1 = aqz.aw.c(1);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        float f1 = par1Entity.O * 1.4f;
        GL11.glScalef((float)f1, (float)f1, (float)f1);
        bfq tessellator = bfq.a;
        float f2 = 0.5f;
        float f3 = 0.0f;
        float f4 = par1Entity.P / f1;
        float f5 = (float)(par1Entity.v - par1Entity.E.b);
        GL11.glRotatef((float)(-this.b.j), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)(-0.3f + (float)((int)f4) * 0.02f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float f6 = 0.0f;
        int i2 = 0;
        tessellator.b();
        while (f4 > 0.0f) {
            ms icon2 = i2 % 2 == 0 ? icon : icon1;
            this.a(bik.b);
            float f7 = icon2.c();
            float f8 = icon2.e();
            float f9 = icon2.d();
            float f10 = icon2.f();
            if (i2 / 2 % 2 == 0) {
                float f11 = f9;
                f9 = f7;
                f7 = f11;
            }
            tessellator.a(f2 - f3, 0.0f - f5, f6, f9, f10);
            tessellator.a(-f2 - f3, 0.0f - f5, f6, f7, f10);
            tessellator.a(-f2 - f3, 1.4f - f5, f6, f7, f8);
            tessellator.a(f2 - f3, 1.4f - f5, f6, f9, f8);
            f4 -= 0.45f;
            f5 -= 0.45f;
            f2 *= 0.9f;
            f6 += 0.03f;
            ++i2;
        }
        tessellator.a();
        GL11.glPopMatrix();
        GL11.glEnable((int)2896);
    }

    private void c(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        this.b.e.a(a);
        abw world = this.b();
        GL11.glDepthMask((boolean)false);
        float f2 = this.d;
        if (par1Entity instanceof og) {
            og entityliving = (og)par1Entity;
            f2 *= entityliving.bt();
            if (entityliving.g_()) {
                f2 *= 0.5f;
            }
        }
        double d3 = par1Entity.U + (par1Entity.u - par1Entity.U) * (double)par9;
        double d4 = par1Entity.V + (par1Entity.v - par1Entity.V) * (double)par9 + (double)par1Entity.S();
        double d5 = par1Entity.W + (par1Entity.w - par1Entity.W) * (double)par9;
        int i2 = ls.c(d3 - (double)f2);
        int j2 = ls.c(d3 + (double)f2);
        int k = ls.c(d4 - (double)f2);
        int l2 = ls.c(d4);
        int i1 = ls.c(d5 - (double)f2);
        int j1 = ls.c(d5 + (double)f2);
        double d6 = par2 - d3;
        double d7 = par4 - d4;
        double d8 = par6 - d5;
        bfq tessellator = bfq.a;
        tessellator.b();
        for (int k1 = i2; k1 <= j2; ++k1) {
            for (int l1 = k; l1 <= l2; ++l1) {
                for (int i22 = i1; i22 <= j1; ++i22) {
                    int j22 = world.a(k1, l1 - 1, i22);
                    if (j22 <= 0 || world.n(k1, l1, i22) <= 3) continue;
                    this.a(aqz.s[j22], par2, par4 + (double)par1Entity.S(), par6, k1, l1, i22, par8, f2, d6, d7 + (double)par1Entity.S(), d8);
                }
            }
        }
        tessellator.a();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3042);
        GL11.glDepthMask((boolean)true);
    }

    private abw b() {
        return this.b.g;
    }

    private void a(aqz par1Block, double par2, double par4, double par6, int par8, int par9, int par10, float par11, float par12, double par13, double par15, double par17) {
        double d6;
        bfq tessellator = bfq.a;
        if (par1Block.b() && (d6 = ((double)par11 - (par4 - ((double)par9 + par15)) / 2.0) * 0.5 * (double)this.b().q(par8, par9, par10)) >= 0.0) {
            if (d6 > 1.0) {
                d6 = 1.0;
            }
            tessellator.a(1.0f, 1.0f, 1.0f, (float)d6);
            double d7 = (double)par8 + par1Block.u() + par13;
            double d8 = (double)par8 + par1Block.v() + par13;
            double d9 = (double)par9 + par1Block.w() + par15 + 0.015625;
            double d10 = (double)par10 + par1Block.y() + par17;
            double d11 = (double)par10 + par1Block.z() + par17;
            float f2 = (float)((par2 - d7) / 2.0 / (double)par12 + 0.5);
            float f3 = (float)((par2 - d8) / 2.0 / (double)par12 + 0.5);
            float f4 = (float)((par6 - d10) / 2.0 / (double)par12 + 0.5);
            float f5 = (float)((par6 - d11) / 2.0 / (double)par12 + 0.5);
            tessellator.a(d7, d9, d10, f2, f4);
            tessellator.a(d7, d9, d11, f2, f5);
            tessellator.a(d8, d9, d11, f3, f5);
            tessellator.a(d8, d9, d10, f3, f4);
        }
    }

    public static void a(asx par0AxisAlignedBB, double par1, double par3, double par5) {
        GL11.glDisable((int)3553);
        bfq tessellator = bfq.a;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        tessellator.b();
        tessellator.b(par1, par3, par5);
        tessellator.b(0.0f, 0.0f, -1.0f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.b(0.0f, 0.0f, 1.0f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.b(0.0f, -1.0f, 0.0f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.b(0.0f, 1.0f, 0.0f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.b(-1.0f, 0.0f, 0.0f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.b(1.0f, 0.0f, 0.0f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.b(0.0, 0.0, 0.0);
        tessellator.a();
        GL11.glEnable((int)3553);
    }

    public static void a(asx par0AxisAlignedBB) {
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
        tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
        tessellator.a();
    }

    public void a(bgl par1RenderManager) {
        this.b = par1RenderManager;
    }

    public void b(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        double d3;
        float f2;
        if (this.b.l.j && this.d > 0.0f && !par1Entity.aj() && (f2 = (float)((1.0 - (d3 = this.b.a(par1Entity.u, par1Entity.v, par1Entity.w)) / 256.0) * (double)this.e)) > 0.0f) {
            this.c(par1Entity, par2, par4, par6, f2, par9);
        }
        if (par1Entity.av()) {
            this.a(par1Entity, par2, par4, par6, par9);
        }
    }

    public avi a() {
        return this.b.a();
    }

    public void a(mt par1IconRegister) {
    }
}


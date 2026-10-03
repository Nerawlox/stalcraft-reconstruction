/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class avk {
    public static final bjo k = new bjo("textures/gui/options_background.png");
    public static final bjo l = new bjo("textures/gui/container/stats_icons.png");
    public static final bjo m = new bjo("textures/gui/icons.png");
    protected float n;

    protected void a(int par1, int par2, int par3, int par4) {
        if (par2 < par1) {
            int i1 = par1;
            par1 = par2;
            par2 = i1;
        }
        avk.a(par1, par3, par2 + 1, par3 + 1, par4);
    }

    protected void b(int par1, int par2, int par3, int par4) {
        if (par3 < par2) {
            int i1 = par2;
            par2 = par3;
            par3 = i1;
        }
        avk.a(par1, par2 + 1, par1 + 1, par3, par4);
    }

    public static void a(int par0, int par1, int par2, int par3, int par4) {
        int j1;
        if (par0 < par2) {
            j1 = par0;
            par0 = par2;
            par2 = j1;
        }
        if (par1 < par3) {
            j1 = par1;
            par1 = par3;
            par3 = j1;
        }
        float f = (float)(par4 >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(par4 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(par4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(par4 & 0xFF) / 255.0f;
        bfq tessellator = bfq.a;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)f1, (float)f2, (float)f3, (float)f);
        tessellator.b();
        tessellator.a((double)par0, (double)par3, 0.0);
        tessellator.a((double)par2, (double)par3, 0.0);
        tessellator.a((double)par2, (double)par1, 0.0);
        tessellator.a((double)par0, (double)par1, 0.0);
        tessellator.a();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
    }

    protected void a(int par1, int par2, int par3, int par4, int par5, int par6) {
        float f = (float)(par5 >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(par5 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(par5 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(par5 & 0xFF) / 255.0f;
        float f4 = (float)(par6 >> 24 & 0xFF) / 255.0f;
        float f5 = (float)(par6 >> 16 & 0xFF) / 255.0f;
        float f6 = (float)(par6 >> 8 & 0xFF) / 255.0f;
        float f7 = (float)(par6 & 0xFF) / 255.0f;
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glShadeModel((int)7425);
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(f1, f2, f3, f);
        tessellator.a((double)par3, (double)par2, (double)this.n);
        tessellator.a((double)par1, (double)par2, (double)this.n);
        tessellator.a(f5, f6, f7, f4);
        tessellator.a((double)par1, (double)par4, (double)this.n);
        tessellator.a((double)par3, (double)par4, (double)this.n);
        tessellator.a();
        GL11.glShadeModel((int)7424);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glEnable((int)3553);
    }

    public void a(avi par1FontRenderer, String par2Str, int par3, int par4, int par5) {
        par1FontRenderer.a(par2Str, par3 - par1FontRenderer.a(par2Str) / 2, par4, par5);
    }

    public void b(avi par1FontRenderer, String par2Str, int par3, int par4, int par5) {
        par1FontRenderer.a(par2Str, par3, par4, par5);
    }

    public void b(int par1, int par2, int par3, int par4, int par5, int par6) {
        float f = 0.00390625f;
        float f1 = 0.00390625f;
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(par1 + 0, par2 + par6, this.n, (float)(par3 + 0) * f, (float)(par4 + par6) * f1);
        tessellator.a(par1 + par5, par2 + par6, this.n, (float)(par3 + par5) * f, (float)(par4 + par6) * f1);
        tessellator.a(par1 + par5, par2 + 0, this.n, (float)(par3 + par5) * f, (float)(par4 + 0) * f1);
        tessellator.a(par1 + 0, par2 + 0, this.n, (float)(par3 + 0) * f, (float)(par4 + 0) * f1);
        tessellator.a();
    }

    public void a(int par1, int par2, ms par3Icon, int par4, int par5) {
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(par1 + 0, par2 + par5, this.n, par3Icon.c(), par3Icon.f());
        tessellator.a(par1 + par4, par2 + par5, this.n, par3Icon.d(), par3Icon.f());
        tessellator.a(par1 + par4, par2 + 0, this.n, par3Icon.d(), par3Icon.e());
        tessellator.a(par1 + 0, par2 + 0, this.n, par3Icon.c(), par3Icon.e());
        tessellator.a();
    }
}


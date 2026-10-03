/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  beg
 *  bim
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bec
extends beg {
    private static final bjo a = new bjo("textures/entity/explosion.png");
    private int aB;
    private int aC;
    private bim aD;
    private float aE;

    public bec(bim par1TextureManager, abw par2World, double par3, double par5, double par7, double par9, double par11, double par13) {
        super(par2World, par3, par5, par7, 0.0, 0.0, 0.0);
        this.aD = par1TextureManager;
        this.aC = 6 + this.ab.nextInt(4);
        this.au = this.av = this.ab.nextFloat() * 0.6f + 0.4f;
        this.j = this.av;
        this.aE = 1.0f - (float)par9 * 0.5f;
    }

    public void a(bfq par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
        int i2 = (int)(((float)this.aB + par2) * 15.0f / (float)this.aC);
        if (i2 <= 15) {
            this.aD.a(a);
            float f6 = (float)(i2 % 4) / 4.0f;
            float f7 = f6 + 0.24975f;
            float f8 = (float)(i2 / 4) / 4.0f;
            float f9 = f8 + 0.24975f;
            float f10 = 2.0f * this.aE;
            float f11 = (float)(this.r + (this.u - this.r) * (double)par2 - ay);
            float f12 = (float)(this.s + (this.v - this.s) * (double)par2 - az);
            float f13 = (float)(this.t + (this.w - this.t) * (double)par2 - aA);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)2896);
            att.a();
            par1Tessellator.b();
            par1Tessellator.a(this.j, this.au, this.av, 1.0f);
            par1Tessellator.b(0.0f, 1.0f, 0.0f);
            par1Tessellator.c(240);
            par1Tessellator.a(f11 - par3 * f10 - par6 * f10, f12 - par4 * f10, f13 - par5 * f10 - par7 * f10, f7, f9);
            par1Tessellator.a(f11 - par3 * f10 + par6 * f10, f12 + par4 * f10, f13 - par5 * f10 + par7 * f10, f7, f8);
            par1Tessellator.a(f11 + par3 * f10 + par6 * f10, f12 + par4 * f10, f13 + par5 * f10 + par7 * f10, f6, f8);
            par1Tessellator.a(f11 + par3 * f10 - par6 * f10, f12 - par4 * f10, f13 + par5 * f10 - par7 * f10, f6, f9);
            par1Tessellator.a();
            GL11.glPolygonOffset((float)0.0f, (float)0.0f);
            GL11.glEnable((int)2896);
        }
    }

    public int c(float par1) {
        return 61680;
    }

    public void l_() {
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        ++this.aB;
        if (this.aB == this.aC) {
            this.x();
        }
    }

    public int b() {
        return 3;
    }
}


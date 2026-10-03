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
public class bea
extends beg {
    private static final bjo a = new bjo("textures/particle/footprint.png");
    private int aB;
    private int aC;
    private bim aD;

    public bea(bim par1TextureManager, abw par2World, double par3, double par5, double par7) {
        super(par2World, par3, par5, par7, 0.0, 0.0, 0.0);
        this.aD = par1TextureManager;
        this.z = 0.0;
        this.y = 0.0;
        this.x = 0.0;
        this.aC = 200;
    }

    public void a(bfq par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
        float f7;
        float f6 = ((float)this.aB + par2) / (float)this.aC;
        if ((f7 = 2.0f - (f6 *= f6) * 2.0f) > 1.0f) {
            f7 = 1.0f;
        }
        f7 *= 0.2f;
        GL11.glDisable((int)2896);
        float f8 = 0.125f;
        float f9 = (float)(this.u - ay);
        float f10 = (float)(this.v - az);
        float f11 = (float)(this.w - aA);
        float f12 = this.q.q(ls.c(this.u), ls.c(this.v), ls.c(this.w));
        this.aD.a(a);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        par1Tessellator.b();
        par1Tessellator.a(f12, f12, f12, f7);
        par1Tessellator.a(f9 - f8, f10, f11 + f8, 0.0, 1.0);
        par1Tessellator.a(f9 + f8, f10, f11 + f8, 1.0, 1.0);
        par1Tessellator.a(f9 + f8, f10, f11 - f8, 1.0, 0.0);
        par1Tessellator.a(f9 - f8, f10, f11 - f8, 0.0, 0.0);
        par1Tessellator.a();
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2896);
    }

    public void l_() {
        ++this.aB;
        if (this.aB == this.aC) {
            this.x();
        }
    }

    public int b() {
        return 3;
    }
}


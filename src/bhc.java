/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atc
 *  bbo
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bhc
extends bgm {
    private static final bjo g = new bjo("textures/entity/minecart.png");
    protected bbo a = new bbn();
    protected final bfr f;

    public bhc() {
        this.d = 0.5f;
        this.f = new bfr();
    }

    public void a(st par1EntityMinecart, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        this.b(par1EntityMinecart);
        long i2 = (long)par1EntityMinecart.k * 493286711L;
        i2 = i2 * i2 * 4392167121L + i2 * 98761L;
        float f2 = (((float)(i2 >> 16 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        float f3 = (((float)(i2 >> 20 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        float f4 = (((float)(i2 >> 24 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        GL11.glTranslatef((float)f2, (float)f3, (float)f4);
        double d3 = par1EntityMinecart.U + (par1EntityMinecart.u - par1EntityMinecart.U) * (double)par9;
        double d4 = par1EntityMinecart.V + (par1EntityMinecart.v - par1EntityMinecart.V) * (double)par9;
        double d5 = par1EntityMinecart.W + (par1EntityMinecart.w - par1EntityMinecart.W) * (double)par9;
        double d6 = 0.3f;
        atc vec3 = par1EntityMinecart.a(d3, d4, d5);
        float f5 = par1EntityMinecart.D + (par1EntityMinecart.B - par1EntityMinecart.D) * par9;
        if (vec3 != null) {
            atc vec31 = par1EntityMinecart.a(d3, d4, d5, d6);
            atc vec32 = par1EntityMinecart.a(d3, d4, d5, -d6);
            if (vec31 == null) {
                vec31 = vec3;
            }
            if (vec32 == null) {
                vec32 = vec3;
            }
            par2 += vec3.c - d3;
            par4 += (vec31.d + vec32.d) / 2.0 - d4;
            par6 += vec3.e - d5;
            atc vec33 = vec32.c(-vec31.c, -vec31.d, -vec31.e);
            if (vec33.b() != 0.0) {
                vec33 = vec33.a();
                par8 = (float)(Math.atan2(vec33.e, vec33.c) * 180.0 / Math.PI);
                f5 = (float)(Math.atan(vec33.d) * 73.0);
            }
        }
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        GL11.glRotatef((float)(180.0f - par8), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-f5), (float)0.0f, (float)0.0f, (float)1.0f);
        float f6 = (float)par1EntityMinecart.j() - par9;
        float f7 = par1EntityMinecart.i() - par9;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f6 > 0.0f) {
            GL11.glRotatef((float)(ls.a(f6) * f6 * f7 / 10.0f * (float)par1EntityMinecart.k()), (float)1.0f, (float)0.0f, (float)0.0f);
        }
        int j2 = par1EntityMinecart.q();
        aqz block = par1EntityMinecart.m();
        int k = par1EntityMinecart.o();
        if (block != null) {
            GL11.glPushMatrix();
            this.a(bik.b);
            float f8 = 0.75f;
            GL11.glScalef((float)f8, (float)f8, (float)f8);
            GL11.glTranslatef((float)0.0f, (float)((float)j2 / 16.0f), (float)0.0f);
            this.a(par1EntityMinecart, par9, block, k);
            GL11.glPopMatrix();
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.b(par1EntityMinecart);
        }
        GL11.glScalef((float)-1.0f, (float)-1.0f, (float)1.0f);
        this.a.a((nn)par1EntityMinecart, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    protected bjo a(st par1EntityMinecart) {
        return g;
    }

    protected void a(st par1EntityMinecart, float par2, aqz par3Block, int par4) {
        float f1 = par1EntityMinecart.d(par2);
        GL11.glPushMatrix();
        this.f.a(par3Block, par4, f1);
        GL11.glPopMatrix();
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((st)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((st)par1Entity, par2, par4, par6, par8, par9);
    }
}


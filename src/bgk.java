/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbh
 *  bbo
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  tg
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgk
extends bhe {
    private static final bjo a = new bjo("textures/entity/enderman/enderman_eyes.png");
    private static final bjo f = new bjo("textures/entity/enderman/enderman.png");
    private bbh g;
    private Random h = new Random();

    public bgk() {
        super((bbo)new bbh(), 0.5f);
        this.g = (bbh)this.i;
        this.a((bbo)this.g);
    }

    public void a(tg par1EntityEnderman, double par2, double par4, double par6, float par8, float par9) {
        this.g.a = par1EntityEnderman.bV() > 0;
        this.g.b = par1EntityEnderman.bX();
        if (par1EntityEnderman.bX()) {
            double d3 = 0.02;
            par2 += this.h.nextGaussian() * d3;
            par6 += this.h.nextGaussian() * d3;
        }
        super.a((og)par1EntityEnderman, par2, par4, par6, par8, par9);
    }

    protected bjo a(tg par1EntityEnderman) {
        return f;
    }

    protected void a(tg par1EntityEnderman, float par2) {
        super.c((of)par1EntityEnderman, par2);
        if (par1EntityEnderman.bV() > 0) {
            GL11.glEnable((int)32826);
            GL11.glPushMatrix();
            float f1 = 0.5f;
            GL11.glTranslatef((float)0.0f, (float)0.6875f, (float)-0.75f);
            GL11.glRotatef((float)20.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glScalef((float)(-(f1 *= 1.0f)), (float)(-f1), (float)f1);
            int i2 = par1EntityEnderman.c(par2);
            int j2 = i2 % 65536;
            int k = i2 / 65536;
            bma.a((int)bma.b, (float)((float)j2 / 1.0f), (float)((float)k / 1.0f));
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.a(bik.b);
            this.c.a(aqz.s[par1EntityEnderman.bV()], par1EntityEnderman.bW(), 1.0f);
            GL11.glPopMatrix();
            GL11.glDisable((int)32826);
        }
    }

    protected int a(tg par1EntityEnderman, int par2, float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.a(a);
        float f1 = 1.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)1, (int)1);
        GL11.glDisable((int)2896);
        if (par1EntityEnderman.aj()) {
            GL11.glDepthMask((boolean)false);
        } else {
            GL11.glDepthMask((boolean)true);
        }
        int c0 = 61680;
        int j2 = c0 % 65536;
        int k = c0 / 65536;
        bma.a((int)bma.b, (float)((float)j2 / 1.0f), (float)((float)k / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2896);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f1);
        return 1;
    }

    @Override
    public void a(og par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.a((tg)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    @Override
    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return this.a((tg)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected void c(of par1EntityLivingBase, float par2) {
        this.a((tg)par1EntityLivingBase, par2);
    }

    @Override
    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.a((tg)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((tg)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((tg)par1Entity, par2, par4, par6, par8, par9);
    }
}


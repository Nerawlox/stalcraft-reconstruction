/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bez
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  sg
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgj
extends bhe {
    private static final bjo f = new bjo("textures/entity/enderdragon/dragon_exploding.png");
    private static final bjo g = new bjo("textures/entity/endercrystal/endercrystal_beam.png");
    private static final bjo h = new bjo("textures/entity/enderdragon/dragon_eyes.png");
    private static final bjo k = new bjo("textures/entity/enderdragon/dragon.png");
    protected bcn a;

    public bgj() {
        super(new bcn(0.0f), 0.5f);
        this.a = (bcn)this.i;
        this.a(this.i);
    }

    protected void a(sk par1EntityDragon, float par2, float par3, float par4) {
        float f3 = (float)par1EntityDragon.b(7, par4)[0];
        float f4 = (float)(par1EntityDragon.b(5, par4)[1] - par1EntityDragon.b(10, par4)[1]);
        GL11.glRotatef((float)(-f3), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(f4 * 10.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)1.0f);
        if (par1EntityDragon.aB > 0) {
            float f5 = ((float)par1EntityDragon.aB + par4 - 1.0f) / 20.0f * 1.6f;
            if ((f5 = ls.c(f5)) > 1.0f) {
                f5 = 1.0f;
            }
            GL11.glRotatef((float)(f5 * this.a((of)par1EntityDragon)), (float)0.0f, (float)0.0f, (float)1.0f);
        }
    }

    protected void a(sk par1EntityDragon, float par2, float par3, float par4, float par5, float par6, float par7) {
        if (par1EntityDragon.bB > 0) {
            float f6 = (float)par1EntityDragon.bB / 200.0f;
            GL11.glDepthFunc((int)515);
            GL11.glEnable((int)3008);
            GL11.glAlphaFunc((int)516, (float)f6);
            this.a(f);
            this.i.a((nn)par1EntityDragon, par2, par3, par4, par5, par6, par7);
            GL11.glAlphaFunc((int)516, (float)0.1f);
            GL11.glDepthFunc((int)514);
        }
        this.b((nn)par1EntityDragon);
        this.i.a((nn)par1EntityDragon, par2, par3, par4, par5, par6, par7);
        if (par1EntityDragon.ay > 0) {
            GL11.glDepthFunc((int)514);
            GL11.glDisable((int)3553);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glColor4f((float)1.0f, (float)0.0f, (float)0.0f, (float)0.5f);
            this.i.a((nn)par1EntityDragon, par2, par3, par4, par5, par6, par7);
            GL11.glEnable((int)3553);
            GL11.glDisable((int)3042);
            GL11.glDepthFunc((int)515);
        }
    }

    public void a(sk par1EntityDragon, double par2, double par4, double par6, float par8, float par9) {
        bez.a((sg)par1EntityDragon, (boolean)false);
        super.a(par1EntityDragon, par2, par4, par6, par8, par9);
        if (par1EntityDragon.bC != null) {
            float f2 = (float)par1EntityDragon.bC.a + par9;
            float f3 = ls.a(f2 * 0.2f) / 2.0f + 0.5f;
            f3 = (f3 * f3 + f3) * 0.2f;
            float f4 = (float)(par1EntityDragon.bC.u - par1EntityDragon.u - (par1EntityDragon.r - par1EntityDragon.u) * (double)(1.0f - par9));
            float f5 = (float)((double)f3 + par1EntityDragon.bC.v - 1.0 - par1EntityDragon.v - (par1EntityDragon.s - par1EntityDragon.v) * (double)(1.0f - par9));
            float f6 = (float)(par1EntityDragon.bC.w - par1EntityDragon.w - (par1EntityDragon.t - par1EntityDragon.w) * (double)(1.0f - par9));
            float f7 = ls.c(f4 * f4 + f6 * f6);
            float f8 = ls.c(f4 * f4 + f5 * f5 + f6 * f6);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)par2), (float)((float)par4 + 2.0f), (float)((float)par6));
            GL11.glRotatef((float)((float)(-Math.atan2(f6, f4)) * 180.0f / (float)Math.PI - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)((float)(-Math.atan2(f7, f5)) * 180.0f / (float)Math.PI - 90.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            bfq tessellator = bfq.a;
            att.a();
            GL11.glDisable((int)2884);
            this.a(g);
            GL11.glShadeModel((int)7425);
            float f9 = 0.0f - ((float)par1EntityDragon.ac + par9) * 0.01f;
            float f10 = ls.c(f4 * f4 + f5 * f5 + f6 * f6) / 32.0f - ((float)par1EntityDragon.ac + par9) * 0.01f;
            tessellator.b(5);
            int b0 = 8;
            for (int i2 = 0; i2 <= b0; ++i2) {
                float f11 = ls.a((float)(i2 % b0) * (float)Math.PI * 2.0f / (float)b0) * 0.75f;
                float f12 = ls.b((float)(i2 % b0) * (float)Math.PI * 2.0f / (float)b0) * 0.75f;
                float f13 = (float)(i2 % b0) * 1.0f / (float)b0;
                tessellator.d(0);
                tessellator.a(f11 * 0.2f, f12 * 0.2f, 0.0, f13, f10);
                tessellator.d(0xFFFFFF);
                tessellator.a(f11, f12, f8, f13, f9);
            }
            tessellator.a();
            GL11.glEnable((int)2884);
            GL11.glShadeModel((int)7424);
            att.b();
            GL11.glPopMatrix();
        }
    }

    protected bjo a(sk par1EntityDragon) {
        return k;
    }

    protected void a(sk par1EntityDragon, float par2) {
        super.c(par1EntityDragon, par2);
        bfq tessellator = bfq.a;
        if (par1EntityDragon.bB > 0) {
            att.a();
            float f1 = ((float)par1EntityDragon.bB + par2) / 200.0f;
            float f2 = 0.0f;
            if (f1 > 0.8f) {
                f2 = (f1 - 0.8f) / 0.2f;
            }
            Random random = new Random(432L);
            GL11.glDisable((int)3553);
            GL11.glShadeModel((int)7425);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)1);
            GL11.glDisable((int)3008);
            GL11.glEnable((int)2884);
            GL11.glDepthMask((boolean)false);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.0f, (float)-1.0f, (float)-2.0f);
            int i2 = 0;
            while ((float)i2 < (f1 + f1 * f1) / 2.0f * 60.0f) {
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(random.nextFloat() * 360.0f + f1 * 90.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                tessellator.b(6);
                float f3 = random.nextFloat() * 20.0f + 5.0f + f2 * 10.0f;
                float f4 = random.nextFloat() * 2.0f + 1.0f + f2 * 2.0f;
                tessellator.a(0xFFFFFF, (int)(255.0f * (1.0f - f2)));
                tessellator.a(0.0, 0.0, 0.0);
                tessellator.a(0xFF00FF, 0);
                tessellator.a(-0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.a(0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.a(0.0, (double)f3, (double)(1.0f * f4));
                tessellator.a(-0.866 * (double)f4, (double)f3, (double)(-0.5f * f4));
                tessellator.a();
                ++i2;
            }
            GL11.glPopMatrix();
            GL11.glDepthMask((boolean)true);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3042);
            GL11.glShadeModel((int)7424);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)3008);
            att.b();
        }
    }

    protected int a(sk par1EntityDragon, int par2, float par3) {
        if (par2 == 1) {
            GL11.glDepthFunc((int)515);
        }
        if (par2 != 0) {
            return -1;
        }
        this.a(h);
        float f1 = 1.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)1, (int)1);
        GL11.glDisable((int)2896);
        GL11.glDepthFunc((int)514);
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
        this.a((sk)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    @Override
    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return this.a((sk)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected void c(of par1EntityLivingBase, float par2) {
        this.a((sk)par1EntityLivingBase, par2);
    }

    @Override
    protected void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        this.a((sk)par1EntityLivingBase, par2, par3, par4);
    }

    @Override
    protected void a(of par1EntityLivingBase, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a((sk)par1EntityLivingBase, par2, par3, par4, par5, par6, par7);
    }

    @Override
    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.a((sk)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((sk)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((sk)par1Entity, par2, par4, par6, par8, par9);
    }
}


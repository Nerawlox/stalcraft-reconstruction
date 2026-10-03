/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  oc
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class bhe
extends bhb {
    public bhe(bbo par1ModelBase, float par2) {
        super(par1ModelBase, par2);
    }

    protected boolean b(og par1EntityLiving) {
        return super.b(par1EntityLiving) && (par1EntityLiving.bd() || par1EntityLiving.bB() && par1EntityLiving == this.b.i);
    }

    public void a(og par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        super.a((of)par1EntityLiving, par2, par4, par6, par8, par9);
        this.b(par1EntityLiving, par2, par4, par6, par8, par9);
    }

    private double a(double par1, double par3, double par5) {
        return par1 + (par3 - par1) * par5;
    }

    protected void b(og par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        nn entity = par1EntityLiving.bI();
        if (entity != null) {
            float f2;
            int i2;
            par4 -= (1.6 - (double)par1EntityLiving.P) * 0.5;
            bfq tessellator = bfq.a;
            double d3 = this.a(entity.C, (double)entity.A, (double)(par9 * 0.5f)) * 0.01745329238474369;
            double d4 = this.a(entity.D, (double)entity.B, (double)(par9 * 0.5f)) * 0.01745329238474369;
            double d5 = Math.cos(d3);
            double d6 = Math.sin(d3);
            double d7 = Math.sin(d4);
            if (entity instanceof oc) {
                d5 = 0.0;
                d6 = 0.0;
                d7 = -1.0;
            }
            double d8 = Math.cos(d4);
            double d9 = this.a(entity.r, entity.u, (double)par9) - d5 * 0.7 - d6 * 0.5 * d8;
            double d10 = this.a(entity.s + (double)entity.f() * 0.7, entity.v + (double)entity.f() * 0.7, (double)par9) - d7 * 0.5 - 0.25;
            double d11 = this.a(entity.t, entity.w, (double)par9) - d6 * 0.7 + d5 * 0.5 * d8;
            double d12 = this.a(par1EntityLiving.aO, (double)par1EntityLiving.aN, (double)par9) * 0.01745329238474369 + 1.5707963267948966;
            d5 = Math.cos(d12) * (double)par1EntityLiving.O * 0.4;
            d6 = Math.sin(d12) * (double)par1EntityLiving.O * 0.4;
            double d13 = this.a(par1EntityLiving.r, par1EntityLiving.u, (double)par9) + d5;
            double d14 = this.a(par1EntityLiving.s, par1EntityLiving.v, (double)par9);
            double d15 = this.a(par1EntityLiving.t, par1EntityLiving.w, (double)par9) + d6;
            par2 += d5;
            par6 += d6;
            double d16 = (float)(d9 - d13);
            double d17 = (float)(d10 - d14);
            double d18 = (float)(d11 - d15);
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2884);
            boolean flag = true;
            double d19 = 0.025;
            tessellator.b(5);
            for (i2 = 0; i2 <= 24; ++i2) {
                if (i2 % 2 == 0) {
                    tessellator.a(0.5f, 0.4f, 0.3f, 1.0f);
                } else {
                    tessellator.a(0.35f, 0.28f, 0.21000001f, 1.0f);
                }
                f2 = (float)i2 / 24.0f;
                tessellator.a(par2 + d16 * (double)f2 + 0.0, par4 + d17 * (double)(f2 * f2 + f2) * 0.5 + (double)((24.0f - (float)i2) / 18.0f + 0.125f), par6 + d18 * (double)f2);
                tessellator.a(par2 + d16 * (double)f2 + 0.025, par4 + d17 * (double)(f2 * f2 + f2) * 0.5 + (double)((24.0f - (float)i2) / 18.0f + 0.125f) + 0.025, par6 + d18 * (double)f2);
            }
            tessellator.a();
            tessellator.b(5);
            for (i2 = 0; i2 <= 24; ++i2) {
                if (i2 % 2 == 0) {
                    tessellator.a(0.5f, 0.4f, 0.3f, 1.0f);
                } else {
                    tessellator.a(0.35f, 0.28f, 0.21000001f, 1.0f);
                }
                f2 = (float)i2 / 24.0f;
                tessellator.a(par2 + d16 * (double)f2 + 0.0, par4 + d17 * (double)(f2 * f2 + f2) * 0.5 + (double)((24.0f - (float)i2) / 18.0f + 0.125f) + 0.025, par6 + d18 * (double)f2);
                tessellator.a(par2 + d16 * (double)f2 + 0.025, par4 + d17 * (double)(f2 * f2 + f2) * 0.5 + (double)((24.0f - (float)i2) / 18.0f + 0.125f), par6 + d18 * (double)f2 + 0.025);
            }
            tessellator.a();
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2884);
        }
    }

    @Override
    protected boolean b(of par1EntityLivingBase) {
        return this.b((og)par1EntityLivingBase);
    }

    @Override
    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.a((og)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((og)par1Entity, par2, par4, par6, par8, par9);
    }
}


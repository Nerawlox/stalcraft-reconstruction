/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  sp
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bha
extends bgm {
    public void a(sp par1EntityLightningBolt, double par2, double par4, double par6, float par8, float par9) {
        bfq tessellator = bfq.a;
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)1);
        double[] adouble = new double[8];
        double[] adouble1 = new double[8];
        double d3 = 0.0;
        double d4 = 0.0;
        Random random = new Random(par1EntityLightningBolt.a);
        for (int i2 = 7; i2 >= 0; --i2) {
            adouble[i2] = d3;
            adouble1[i2] = d4;
            d3 += (double)(random.nextInt(11) - 5);
            d4 += (double)(random.nextInt(11) - 5);
        }
        for (int j2 = 0; j2 < 4; ++j2) {
            Random random1 = new Random(par1EntityLightningBolt.a);
            for (int k = 0; k < 3; ++k) {
                int l2 = 7;
                int i1 = 0;
                if (k > 0) {
                    l2 = 7 - k;
                }
                if (k > 0) {
                    i1 = l2 - 2;
                }
                double d5 = adouble[l2] - d3;
                double d6 = adouble1[l2] - d4;
                for (int j1 = l2; j1 >= i1; --j1) {
                    double d7 = d5;
                    double d8 = d6;
                    if (k == 0) {
                        d5 += (double)(random1.nextInt(11) - 5);
                        d6 += (double)(random1.nextInt(11) - 5);
                    } else {
                        d5 += (double)(random1.nextInt(31) - 15);
                        d6 += (double)(random1.nextInt(31) - 15);
                    }
                    tessellator.b(5);
                    float f2 = 0.5f;
                    tessellator.a(0.9f * f2, 0.9f * f2, 1.0f * f2, 0.3f);
                    double d9 = 0.1 + (double)j2 * 0.2;
                    if (k == 0) {
                        d9 *= (double)j1 * 0.1 + 1.0;
                    }
                    double d10 = 0.1 + (double)j2 * 0.2;
                    if (k == 0) {
                        d10 *= (double)(j1 - 1) * 0.1 + 1.0;
                    }
                    for (int k1 = 0; k1 < 5; ++k1) {
                        double d11 = par2 + 0.5 - d9;
                        double d12 = par6 + 0.5 - d9;
                        if (k1 == 1 || k1 == 2) {
                            d11 += d9 * 2.0;
                        }
                        if (k1 == 2 || k1 == 3) {
                            d12 += d9 * 2.0;
                        }
                        double d13 = par2 + 0.5 - d10;
                        double d14 = par6 + 0.5 - d10;
                        if (k1 == 1 || k1 == 2) {
                            d13 += d10 * 2.0;
                        }
                        if (k1 == 2 || k1 == 3) {
                            d14 += d10 * 2.0;
                        }
                        tessellator.a(d13 + d5, par4 + (double)(j1 * 16), d14 + d6);
                        tessellator.a(d11 + d7, par4 + (double)((j1 + 1) * 16), d12 + d8);
                    }
                    tessellator.a();
                }
            }
        }
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
    }

    protected bjo a(sp par1EntityLightningBolt) {
        return null;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((sp)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((sp)par1Entity, par2, par4, par6, par8, par9);
    }
}


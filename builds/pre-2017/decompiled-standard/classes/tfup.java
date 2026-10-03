/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class tfup
extends tfvm {
    public void _a(EntityLightningBolt entityLightningBolt, double d, double d2, double d3, float f, float f2) {
        htvf htvf2 = htvf.field_78398_a;
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        double[] dArray = new double[8];
        double[] dArray2 = new double[8];
        double d4 = 0.0;
        double d5 = 0.0;
        Random random = new Random(entityLightningBolt.field_70264_a);
        for (int i = 7; i >= 0; --i) {
            dArray[i] = d4;
            dArray2[i] = d5;
            d4 += (double)(random.nextInt(11) - 5);
            d5 += (double)(random.nextInt(11) - 5);
        }
        for (int i = 0; i < 4; ++i) {
            Random random2 = new Random(entityLightningBolt.field_70264_a);
            for (int j = 0; j < 3; ++j) {
                int n = 7;
                int n2 = 0;
                if (j > 0) {
                    n = 7 - j;
                }
                if (j > 0) {
                    n2 = n - 2;
                }
                double d6 = dArray[n] - d4;
                double d7 = dArray2[n] - d5;
                for (int k = n; k >= n2; --k) {
                    double d8 = d6;
                    double d9 = d7;
                    if (j == 0) {
                        d6 += (double)(random2.nextInt(11) - 5);
                        d7 += (double)(random2.nextInt(11) - 5);
                    } else {
                        d6 += (double)(random2.nextInt(31) - 15);
                        d7 += (double)(random2.nextInt(31) - 15);
                    }
                    htvf2.func_78371_b(5);
                    float f3 = 0.5f;
                    htvf2.func_78369_a(0.9f * f3, 0.9f * f3, 1.0f * f3, 0.3f);
                    double d10 = 0.1 + (double)i * 0.2;
                    if (j == 0) {
                        d10 *= (double)k * 0.1 + 1.0;
                    }
                    double d11 = 0.1 + (double)i * 0.2;
                    if (j == 0) {
                        d11 *= (double)(k - 1) * 0.1 + 1.0;
                    }
                    for (int i2 = 0; i2 < 5; ++i2) {
                        double d12 = d + 0.5 - d10;
                        double d13 = d3 + 0.5 - d10;
                        if (i2 == 1 || i2 == 2) {
                            d12 += d10 * 2.0;
                        }
                        if (i2 == 2 || i2 == 3) {
                            d13 += d10 * 2.0;
                        }
                        double d14 = d + 0.5 - d11;
                        double d15 = d3 + 0.5 - d11;
                        if (i2 == 1 || i2 == 2) {
                            d14 += d11 * 2.0;
                        }
                        if (i2 == 2 || i2 == 3) {
                            d15 += d11 * 2.0;
                        }
                        htvf2.func_78377_a(d14 + d6, d2 + (double)(k * 16), d15 + d7);
                        htvf2.func_78377_a(d12 + d8, d2 + (double)((k + 1) * 16), d13 + d9);
                    }
                    htvf2.func_78381_a();
                }
            }
        }
        GL11.glDisable(3042);
        GL11.glEnable(2896);
        GL11.glEnable(3553);
    }

    public ResourceLocation _a(EntityLightningBolt entityLightningBolt) {
        return null;
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityLightningBolt)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityLightningBolt)entity, d, d2, d3, f, f2);
    }
}


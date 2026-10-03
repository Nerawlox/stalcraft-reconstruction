/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkOverlayFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.particle.kjui;
import net.minecraft.client.xpzm;
import net.minecraft.util.sajh;

@SideOnly(value=Side.CLIENT)
public class EntityFireworkStarterFX
extends EntityFX {
    public int field_92042_ax;
    public final kjui field_92040_ay;
    public bsyv field_92039_az;
    public boolean field_92041_a;

    public EntityFireworkStarterFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6, kjui kjui2, qoac qoac2) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70159_w = d4;
        this.field_70181_x = d5;
        this.field_70179_y = d6;
        this.field_92040_ay = kjui2;
        this.field_70547_e = 8;
        if (qoac2 != null) {
            this.field_92039_az = qoac2._n("Explosions");
            if (this.field_92039_az != null && this.field_92039_az._d() == 0) {
                this.field_92039_az = null;
            } else if (this.field_92039_az != null) {
                this.field_70547_e = this.field_92039_az._d() * 2 - 1;
                for (int i = 0; i < this.field_92039_az._d(); ++i) {
                    qoac qoac3 = (qoac)this.field_92039_az._b(i);
                    if (!qoac3._o("Flicker")) continue;
                    this.field_92041_a = true;
                    this.field_70547_e += 15;
                    break;
                }
            }
        }
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    @Override
    public void func_70071_h_() {
        Object object;
        int n;
        boolean bl;
        if (this.field_92042_ax == 0 && this.field_92039_az != null) {
            bl = this.func_92037_i();
            n = 0;
            if (this.field_92039_az._d() >= 3) {
                n = 1;
            } else {
                for (int i = 0; i < this.field_92039_az._d(); ++i) {
                    qoac qoac2 = (qoac)this.field_92039_az._b(i);
                    if (qoac2._d("Type") != 1) continue;
                    n = 1;
                    break;
                }
            }
            object = "fireworks." + (n != 0 ? "largeBlast" : "blast") + (bl ? "_far" : "");
            this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, (String)object, 20.0f, 0.95f + this.field_70146_Z.nextFloat() * 0.1f, true);
        }
        if (this.field_92042_ax % 2 == 0 && this.field_92039_az != null && this.field_92042_ax / 2 < this.field_92039_az._d()) {
            n = this.field_92042_ax / 2;
            object = (qoac)this.field_92039_az._b(n);
            byte by = ((qoac)object)._d("Type");
            boolean bl2 = ((qoac)object)._o("Trail");
            boolean bl3 = ((qoac)object)._o("Flicker");
            int[] nArray = ((qoac)object)._l("Colors");
            int[] nArray2 = ((qoac)object)._l("FadeColors");
            if (by == 1) {
                this.func_92035_a(0.5, 4, nArray, nArray2, bl2, bl3);
            } else if (by == 2) {
                this.func_92038_a(0.5, new double[][]{{0.0, 1.0}, {0.3455, 0.309}, {0.9511, 0.309}, {0.3795918367346939, -0.12653061224489795}, {0.6122448979591837, -0.8040816326530612}, {0.0, -0.35918367346938773}}, nArray, nArray2, bl2, bl3, false);
            } else if (by == 3) {
                this.func_92038_a(0.5, new double[][]{{0.0, 0.2}, {0.2, 0.2}, {0.2, 0.6}, {0.6, 0.6}, {0.6, 0.2}, {0.2, 0.2}, {0.2, 0.0}, {0.4, 0.0}, {0.4, -0.6}, {0.2, -0.6}, {0.2, -0.4}, {0.0, -0.4}}, nArray, nArray2, bl2, bl3, true);
            } else if (by == 4) {
                this.func_92036_a(nArray, nArray2, bl2, bl3);
            } else {
                this.func_92035_a(0.25, 2, nArray, nArray2, bl2, bl3);
            }
            int n2 = nArray[0];
            float f = (float)((n2 & 0xFF0000) >> 16) / 255.0f;
            float f2 = (float)((n2 & 0xFF00) >> 8) / 255.0f;
            float f3 = (float)((n2 & 0xFF) >> 0) / 255.0f;
            EntityFireworkOverlayFX entityFireworkOverlayFX = new EntityFireworkOverlayFX(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            entityFireworkOverlayFX.func_70538_b(f, f2, f3);
            this.field_92040_ay._a(entityFireworkOverlayFX);
        }
        ++this.field_92042_ax;
        if (this.field_92042_ax > this.field_70547_e) {
            if (this.field_92041_a) {
                bl = this.func_92037_i();
                String string = "fireworks." + (bl ? "twinkle_far" : "twinkle");
                this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, string, 20.0f, 0.9f + this.field_70146_Z.nextFloat() * 0.15f, true);
            }
            this.func_70106_y();
        }
    }

    public boolean func_92037_i() {
        xpzm xpzm2 = xpzm._E();
        return xpzm2 == null || xpzm2._u == null || xpzm2._u.func_70092_e(this.field_70165_t, this.field_70163_u, this.field_70161_v) >= 256.0;
    }

    public void func_92034_a(double d, double d2, double d3, double d4, double d5, double d6, int[] nArray, int[] nArray2, boolean bl, boolean bl2) {
        EntityFireworkSparkFX entityFireworkSparkFX = new EntityFireworkSparkFX(this.field_70170_p, d, d2, d3, d4, d5, d6, this.field_92040_ay);
        entityFireworkSparkFX.func_92045_e(bl);
        entityFireworkSparkFX.func_92043_f(bl2);
        int n = this.field_70146_Z.nextInt(nArray.length);
        entityFireworkSparkFX.func_92044_a(nArray[n]);
        if (nArray2 != null && nArray2.length > 0) {
            entityFireworkSparkFX.func_92046_g(nArray2[this.field_70146_Z.nextInt(nArray2.length)]);
        }
        this.field_92040_ay._a(entityFireworkSparkFX);
    }

    public void func_92035_a(double d, int n, int[] nArray, int[] nArray2, boolean bl, boolean bl2) {
        double d2 = this.field_70165_t;
        double d3 = this.field_70163_u;
        double d4 = this.field_70161_v;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    double d5 = (double)j + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 0.5;
                    double d6 = (double)i + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 0.5;
                    double d7 = (double)k + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 0.5;
                    double d8 = (double)sajh._a(d5 * d5 + d6 * d6 + d7 * d7) / d + this.field_70146_Z.nextGaussian() * 0.05;
                    this.func_92034_a(d2, d3, d4, d5 / d8, d6 / d8, d7 / d8, nArray, nArray2, bl, bl2);
                    if (i == -n || i == n || j == -n || j == n) continue;
                    k += n * 2 - 1;
                }
            }
        }
    }

    public void func_92038_a(double d, double[][] dArray, int[] nArray, int[] nArray2, boolean bl, boolean bl2, boolean bl3) {
        double d2 = dArray[0][0];
        double d3 = dArray[0][1];
        this.func_92034_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, d2 * d, d3 * d, 0.0, nArray, nArray2, bl, bl2);
        float f = this.field_70146_Z.nextFloat() * (float)Math.PI;
        double d4 = bl3 ? 0.034 : 0.34;
        for (int i = 0; i < 3; ++i) {
            double d5 = (double)f + (double)((float)i * (float)Math.PI) * d4;
            double d6 = d2;
            double d7 = d3;
            for (int j = 1; j < dArray.length; ++j) {
                double d8 = dArray[j][0];
                double d9 = dArray[j][1];
                for (double d10 = 0.25; d10 <= 1.0; d10 += 0.25) {
                    double d11 = (d6 + (d8 - d6) * d10) * d;
                    double d12 = (d7 + (d9 - d7) * d10) * d;
                    double d13 = d11 * Math.sin(d5);
                    d11 *= Math.cos(d5);
                    for (double d14 = -1.0; d14 <= 1.0; d14 += 2.0) {
                        this.func_92034_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, d11 * d14, d12, d13 * d14, nArray, nArray2, bl, bl2);
                    }
                }
                d6 = d8;
                d7 = d9;
            }
        }
    }

    public void func_92036_a(int[] nArray, int[] nArray2, boolean bl, boolean bl2) {
        double d = this.field_70146_Z.nextGaussian() * 0.05;
        double d2 = this.field_70146_Z.nextGaussian() * 0.05;
        for (int i = 0; i < 70; ++i) {
            double d3 = this.field_70159_w * 0.5 + this.field_70146_Z.nextGaussian() * 0.15 + d;
            double d4 = this.field_70179_y * 0.5 + this.field_70146_Z.nextGaussian() * 0.15 + d2;
            double d5 = this.field_70181_x * 0.5 + this.field_70146_Z.nextDouble() * 0.5;
            this.func_92034_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, d3, d5, d4, nArray, nArray2, bl, bl2);
        }
    }

    @Override
    public int func_70537_b() {
        return 0;
    }
}


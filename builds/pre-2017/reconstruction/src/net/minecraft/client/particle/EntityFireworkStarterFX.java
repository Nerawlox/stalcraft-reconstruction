/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkOverlayFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

@SideOnly(value=Side.CLIENT)
public class EntityFireworkStarterFX
extends EntityFX {
    public int fireworkAge;
    public final EffectRenderer theEffectRenderer;
    public NBTTagList fireworkExplosions;
    public boolean twinkle;

    public EntityFireworkStarterFX(World world, double d, double d2, double d3, double d4, double d5, double d6, EffectRenderer effectRenderer, NBTTagCompound nBTTagCompound) {
        super(world, d, d2, d3, 0.0, 0.0, 0.0);
        this.motionX = d4;
        this.motionY = d5;
        this.motionZ = d6;
        this.theEffectRenderer = effectRenderer;
        this.particleMaxAge = 8;
        if (nBTTagCompound != null) {
            this.fireworkExplosions = nBTTagCompound._n("Explosions");
            if (this.fireworkExplosions != null && this.fireworkExplosions._d() == 0) {
                this.fireworkExplosions = null;
            } else if (this.fireworkExplosions != null) {
                this.particleMaxAge = this.fireworkExplosions._d() * 2 - 1;
                for (int i = 0; i < this.fireworkExplosions._d(); ++i) {
                    NBTTagCompound nBTTagCompound2 = (NBTTagCompound)this.fireworkExplosions._b(i);
                    if (!nBTTagCompound2._o("Flicker")) continue;
                    this.twinkle = true;
                    this.particleMaxAge += 15;
                    break;
                }
            }
        }
    }

    @Override
    public void renderParticle(Tessellator tessellator, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    @Override
    public void onUpdate() {
        Object object;
        int n;
        boolean bl;
        if (this.fireworkAge == 0 && this.fireworkExplosions != null) {
            bl = this.func_92037_i();
            n = 0;
            if (this.fireworkExplosions._d() >= 3) {
                n = 1;
            } else {
                for (int i = 0; i < this.fireworkExplosions._d(); ++i) {
                    NBTTagCompound nBTTagCompound = (NBTTagCompound)this.fireworkExplosions._b(i);
                    if (nBTTagCompound._d("Type") != 1) continue;
                    n = 1;
                    break;
                }
            }
            object = "fireworks." + (n != 0 ? "largeBlast" : "blast") + (bl ? "_far" : "");
            this.worldObj.playSound(this.posX, this.posY, this.posZ, (String)object, 20.0f, 0.95f + this.rand.nextFloat() * 0.1f, true);
        }
        if (this.fireworkAge % 2 == 0 && this.fireworkExplosions != null && this.fireworkAge / 2 < this.fireworkExplosions._d()) {
            n = this.fireworkAge / 2;
            object = (NBTTagCompound)this.fireworkExplosions._b(n);
            byte by = ((NBTTagCompound)object)._d("Type");
            boolean bl2 = ((NBTTagCompound)object)._o("Trail");
            boolean bl3 = ((NBTTagCompound)object)._o("Flicker");
            int[] nArray = ((NBTTagCompound)object)._l("Colors");
            int[] nArray2 = ((NBTTagCompound)object)._l("FadeColors");
            if (by == 1) {
                this.createBall(0.5, 4, nArray, nArray2, bl2, bl3);
            } else if (by == 2) {
                this.createShaped(0.5, new double[][]{{0.0, 1.0}, {0.3455, 0.309}, {0.9511, 0.309}, {0.3795918367346939, -0.12653061224489795}, {0.6122448979591837, -0.8040816326530612}, {0.0, -0.35918367346938773}}, nArray, nArray2, bl2, bl3, false);
            } else if (by == 3) {
                this.createShaped(0.5, new double[][]{{0.0, 0.2}, {0.2, 0.2}, {0.2, 0.6}, {0.6, 0.6}, {0.6, 0.2}, {0.2, 0.2}, {0.2, 0.0}, {0.4, 0.0}, {0.4, -0.6}, {0.2, -0.6}, {0.2, -0.4}, {0.0, -0.4}}, nArray, nArray2, bl2, bl3, true);
            } else if (by == 4) {
                this.createBurst(nArray, nArray2, bl2, bl3);
            } else {
                this.createBall(0.25, 2, nArray, nArray2, bl2, bl3);
            }
            int n2 = nArray[0];
            float f = (float)((n2 & 0xFF0000) >> 16) / 255.0f;
            float f2 = (float)((n2 & 0xFF00) >> 8) / 255.0f;
            float f3 = (float)((n2 & 0xFF) >> 0) / 255.0f;
            EntityFireworkOverlayFX entityFireworkOverlayFX = new EntityFireworkOverlayFX(this.worldObj, this.posX, this.posY, this.posZ);
            entityFireworkOverlayFX.setRBGColorF(f, f2, f3);
            this.theEffectRenderer._a(entityFireworkOverlayFX);
        }
        ++this.fireworkAge;
        if (this.fireworkAge > this.particleMaxAge) {
            if (this.twinkle) {
                bl = this.func_92037_i();
                String string = "fireworks." + (bl ? "twinkle_far" : "twinkle");
                this.worldObj.playSound(this.posX, this.posY, this.posZ, string, 20.0f, 0.9f + this.rand.nextFloat() * 0.15f, true);
            }
            this.setDead();
        }
    }

    public boolean func_92037_i() {
        Minecraft minecraft = Minecraft._E();
        return minecraft == null || minecraft._u == null || minecraft._u.getDistanceSq(this.posX, this.posY, this.posZ) >= 256.0;
    }

    public void createParticle(double d, double d2, double d3, double d4, double d5, double d6, int[] nArray, int[] nArray2, boolean bl, boolean bl2) {
        EntityFireworkSparkFX entityFireworkSparkFX = new EntityFireworkSparkFX(this.worldObj, d, d2, d3, d4, d5, d6, this.theEffectRenderer);
        entityFireworkSparkFX.setTrail(bl);
        entityFireworkSparkFX.setTwinkle(bl2);
        int n = this.rand.nextInt(nArray.length);
        entityFireworkSparkFX.setColour(nArray[n]);
        if (nArray2 != null && nArray2.length > 0) {
            entityFireworkSparkFX.setFadeColour(nArray2[this.rand.nextInt(nArray2.length)]);
        }
        this.theEffectRenderer._a(entityFireworkSparkFX);
    }

    public void createBall(double d, int n, int[] nArray, int[] nArray2, boolean bl, boolean bl2) {
        double d2 = this.posX;
        double d3 = this.posY;
        double d4 = this.posZ;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    double d5 = (double)j + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                    double d6 = (double)i + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                    double d7 = (double)k + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                    double d8 = (double)sajh._a(d5 * d5 + d6 * d6 + d7 * d7) / d + this.rand.nextGaussian() * 0.05;
                    this.createParticle(d2, d3, d4, d5 / d8, d6 / d8, d7 / d8, nArray, nArray2, bl, bl2);
                    if (i == -n || i == n || j == -n || j == n) continue;
                    k += n * 2 - 1;
                }
            }
        }
    }

    public void createShaped(double d, double[][] dArray, int[] nArray, int[] nArray2, boolean bl, boolean bl2, boolean bl3) {
        double d2 = dArray[0][0];
        double d3 = dArray[0][1];
        this.createParticle(this.posX, this.posY, this.posZ, d2 * d, d3 * d, 0.0, nArray, nArray2, bl, bl2);
        float f = this.rand.nextFloat() * (float)Math.PI;
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
                        this.createParticle(this.posX, this.posY, this.posZ, d11 * d14, d12, d13 * d14, nArray, nArray2, bl, bl2);
                    }
                }
                d6 = d8;
                d7 = d9;
            }
        }
    }

    public void createBurst(int[] nArray, int[] nArray2, boolean bl, boolean bl2) {
        double d = this.rand.nextGaussian() * 0.05;
        double d2 = this.rand.nextGaussian() * 0.05;
        for (int i = 0; i < 70; ++i) {
            double d3 = this.motionX * 0.5 + this.rand.nextGaussian() * 0.15 + d;
            double d4 = this.motionZ * 0.5 + this.rand.nextGaussian() * 0.15 + d2;
            double d5 = this.motionY * 0.5 + this.rand.nextDouble() * 0.5;
            this.createParticle(this.posX, this.posY, this.posZ, d3, d5, d4, nArray, nArray2, bl, bl2);
        }
    }

    @Override
    public int getFXLayer() {
        return 0;
    }
}


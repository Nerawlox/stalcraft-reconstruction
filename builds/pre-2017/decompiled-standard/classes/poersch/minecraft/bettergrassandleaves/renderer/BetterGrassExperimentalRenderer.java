/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.ResourceHelper;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterGrassExperimentalRenderer
extends BlockRenderer
implements ITextureLoadingCallback {
    private dwan[] iconBetterGrassTop;

    @Override
    public void onRegisterIcons(nege nege2) {
        this.iconBetterGrassTop = BetterGrassExperimentalRenderer.registerBlockIcons("better_grass_top");
        if (this.iconBetterGrassTop == null) {
            this.iconBetterGrassTop = ResourceHelper.registerIconsCallback(nege2, "bettergrassandleaves", "textures/blocks/", "better_grass_top", "minecraft", "textures/blocks/", "grass_top", this);
        }
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterGrass.value).booleanValue()) {
            return false;
        }
        long l = BetterGrassExperimentalRenderer.getRandomOffsetForPosition(n, n2, n3);
        int n4 = sdrg2.func_72798_a(n, n2 + 1, n3);
        if (((Boolean[])BetterGrassAndLeavesMod.allowBetterGrass.value)[n4].booleanValue() && n4 != twgu.field_72037_aS.field_71990_ca) {
            double d;
            double d2;
            double d3;
            double d4;
            dwan dwan2;
            int n5 = twgu2.func_71920_b(sdrg2, n, n2, n3);
            float f = (float)(n5 >> 16 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue();
            float f2 = (float)(n5 >> 8 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue();
            float f3 = (float)(n5 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue();
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 + 1, n3));
            BlockRenderer.tessellator.get().func_78386_a(f, f2, f3);
            dwan dwan3 = dwan2 = this.iconBetterGrassTop != null ? this.iconBetterGrassTop[sajh._d((float)(l >> 12 & 0xFL) / 15.0f * (float)(this.iconBetterGrassTop.length - 1) + 0.5f)] : null;
            if (dwan2 == null) {
                return false;
            }
            double d5 = 0.24 * (double)((Float)BetterGrassAndLeavesMod.averageGrassHeight.value).floatValue();
            double d6 = (double)n2 + 1.0;
            double d7 = d5 + (double)((float)(l >> 12 & 0xFL) / 15.0f) * 0.14;
            double d8 = d5 + (double)((float)(l >> 16 & 0xFL) / 15.0f) * 0.14;
            double d9 = d5 + (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.14;
            double d10 = d5 + (double)((float)(l >> 24 & 0xFL) / 15.0f) * 0.14;
            if ((float)(l >> 8 & 0xFL) / 15.0f < 0.5f) {
                d4 = dwan2.func_94209_e();
                d3 = dwan2.func_94212_f();
            } else {
                d4 = dwan2.func_94212_f();
                d3 = dwan2.func_94209_e();
            }
            if ((float)(l >> 4 & 0xFL) / 15.0f < 0.5f) {
                d2 = dwan2.func_94206_g();
                d = dwan2.func_94210_h();
            } else {
                d2 = dwan2.func_94210_h();
                d = dwan2.func_94206_g();
            }
            int n6 = (int)(10.0f + 12.0f * ((Float)BetterGrassAndLeavesMod.averageGrassHeight.value).floatValue());
            for (int i = 0; i < n6; ++i) {
                float f4 = 1.0f - (float)i / (float)n6;
                float f5 = 0.5f + 0.5f * f4;
                BlockRenderer.tessellator.get().func_78386_a(f * f5, f2 * f5, f3 * f5);
                BlockRenderer.tessellator.get().func_78374_a(n, d6 + d7 * (double)f4, n3, d4, d2);
                BlockRenderer.tessellator.get().func_78374_a(n, d6 + d8 * (double)f4, (double)n3 + 1.0, d4, d);
                BlockRenderer.tessellator.get().func_78374_a((double)n + 1.0, d6 + d9 * (double)f4, (double)n3 + 1.0, d3, d);
                BlockRenderer.tessellator.get().func_78374_a((double)n + 1.0, d6 + d10 * (double)f4, n3, d3, d2);
            }
        }
        return false;
    }

    @Override
    public BufferedImage onTextureLoading(dhji dhji2, BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        BufferedImage bufferedImage2 = new BufferedImage(n, n, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.drawImage(bufferedImage, null, 0, 0);
        graphics2D.dispose();
        char c = dhji2.func_94215_i().length() > 0 ? dhji2.func_94215_i().charAt(dhji2.func_94215_i().length() - 1) : (char)'\u0000';
        int[] nArray = bufferedImage2.getRGB(0, 0, n, n, new int[n * n], 0, n);
        int n2 = n <= 16 ? 1 : n / 16;
        for (int i = 0; i < n; i += n2) {
            for (int j = 0; j < n; j += n2) {
                long l = (long)(j * 3129871) ^ (long)c * 116129781L ^ (long)i;
                if (!((double)((float)((l = l * l * 42317861L + l * 11L) >> 16 & 0xFL) / 15.0f) > 0.4)) continue;
                for (int k = i; k < i + n2; ++k) {
                    for (int i2 = j; i2 < j + n2; ++i2) {
                        int n3 = k * n + i2;
                        nArray[n3] = nArray[n3] & 0xFFFFFF;
                    }
                }
            }
        }
        bufferedImage2.setRGB(0, 0, n, n, nArray, 0, n);
        return bufferedImage2;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterSeaweed;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterSeaweedRenderer
extends BlockRenderer
implements IBetterSeaweed,
ITextureLoadingCallback {
    public static dwan[] iconBetterAlgae;
    public static dwan[][] iconBetterReed;

    @Override
    public void onRegisterIcons(nege nege2) {
        iconBetterAlgae = BetterSeaweedRenderer.registerBlockIcons("better_algae");
        iconBetterReed = new dwan[2][];
        BetterSeaweedRenderer.iconBetterReed[0] = BetterSeaweedRenderer.registerBlockIconsCallback("better_reed_bottom", "better_reed", this);
        BetterSeaweedRenderer.iconBetterReed[1] = BetterSeaweedRenderer.registerBlockIconsCallback("better_reed_top", "better_reed", this);
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterSeaweed.value).booleanValue()) {
            return false;
        }
        if (sdrg2.func_72803_f(n, n2 + 1, n3) == tflj._h) {
            IBetterSeaweed iBetterSeaweed = twgu2 instanceof IBetterSeaweed ? (IBetterSeaweed)((Object)twgu2) : this;
            long l = BetterSeaweedRenderer.getRandomOffsetForPosition(n, n2, n3);
            if (sdrg2.func_72803_f(n, n2 + 2, n3) == tflj._h) {
                if (!((Boolean[])BetterGrassAndLeavesMod.algaeHostingBiomes.value)[sdrg2.func_72807_a((int)n, (int)n3)._P].booleanValue() || (float)(l >> 4 & 0xFL) / 15.0f >= ((Float)BetterGrassAndLeavesMod.algaePopulation.value).floatValue()) {
                    return false;
                }
                dwan dwan2 = iBetterSeaweed.getIconBetterAlgae(0, (float)(l >> 12 & 0xFL) / 15.0f);
                if (dwan2 == null) {
                    return false;
                }
                BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 + 1, n3));
                BlockRenderer.tessellator.get().func_78386_a(((Float)BetterGrassAndLeavesMod.betterAlgaeBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterAlgaeBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterAlgaeBrightness.value).floatValue());
                double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
                double d2 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
                double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
                boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
                BetterSeaweedRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
                this.renderCrossedQuadsY(dwan2, d, d2, d3, bl, false);
            } else if (((Boolean[])BetterGrassAndLeavesMod.reedHostingBiomes.value)[sdrg2.func_72807_a((int)n, (int)n3)._P].booleanValue() && sdrg2.func_72799_c(n, n2 + 2, n3)) {
                float f = (float)(l >> 4 & 0xFL) / 15.0f;
                if (this.nearShore(sdrg2, n, n2 + 1, n3) ? f >= ((Float)BetterGrassAndLeavesMod.reedPopulation.value).floatValue() : f >= ((Float)BetterGrassAndLeavesMod.reedPopulation.value).floatValue() * ((Float)BetterGrassAndLeavesMod.reedOffshorePopulation.value).floatValue()) {
                    return false;
                }
                float f2 = (float)(l >> 12 & 0xFL) / 15.0f;
                dwan dwan3 = iBetterSeaweed.getIconBetterReed(0, f2);
                if (dwan3 == null) {
                    return false;
                }
                BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 + 2, n3));
                BlockRenderer.tessellator.get().func_78386_a(((Float)BetterGrassAndLeavesMod.betterReedBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterReedBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterReedBrightness.value).floatValue());
                double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
                double d4 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
                double d5 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
                boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
                BetterSeaweedRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
                this.renderCrossedQuadsY(dwan3, d, d4, d5, bl, false);
                dwan3 = iBetterSeaweed.getIconBetterReed(1, f2);
                if (dwan3 == null) {
                    return false;
                }
                this.renderCrossedQuadsY(dwan3, d, d4 + 1.414, d5, bl, false);
            }
        }
        return false;
    }

    protected boolean nearShore(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72803_f(n - 2, n2, n3) != tflj._h) {
            return true;
        }
        if (sdrg2.func_72803_f(n + 2, n2, n3) != tflj._h) {
            return true;
        }
        if (sdrg2.func_72803_f(n, n2, n3 - 2) != tflj._h) {
            return true;
        }
        return sdrg2.func_72803_f(n, n2, n3 + 2) != tflj._h;
    }

    @Override
    public BufferedImage onTextureLoading(dhji dhji2, BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        BufferedImage bufferedImage2 = new BufferedImage(n, n, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.drawImage(bufferedImage, null, 0, dhji2.func_94215_i().startsWith("better_reed_top") ? n * 2 - bufferedImage.getHeight() : -bufferedImage.getHeight() + n);
        graphics2D.dispose();
        return bufferedImage2;
    }

    @Override
    public dwan getIconBetterAlgae(int n, float f) {
        return iconBetterAlgae == null ? null : iconBetterAlgae[(int)(f * (float)(iconBetterAlgae.length - 1) + 0.5f)];
    }

    @Override
    public dwan getIconBetterReed(int n, float f) {
        return iconBetterReed != null && iconBetterReed[n] != null ? iconBetterReed[n][(int)(f * (float)(iconBetterReed[n].length - 1) + 0.5f)] : null;
    }
}


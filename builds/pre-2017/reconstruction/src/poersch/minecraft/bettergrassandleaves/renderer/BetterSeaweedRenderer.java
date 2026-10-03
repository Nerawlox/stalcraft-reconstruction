/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterSeaweed;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterSeaweedRenderer
extends BlockRenderer
implements IBetterSeaweed,
ITextureLoadingCallback {
    public static Icon[] iconBetterAlgae;
    public static Icon[][] iconBetterReed;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconBetterAlgae = BetterSeaweedRenderer.registerBlockIcons("better_algae");
        iconBetterReed = new Icon[2][];
        BetterSeaweedRenderer.iconBetterReed[0] = BetterSeaweedRenderer.registerBlockIconsCallback("better_reed_bottom", "better_reed", this);
        BetterSeaweedRenderer.iconBetterReed[1] = BetterSeaweedRenderer.registerBlockIconsCallback("better_reed_top", "better_reed", this);
    }

    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterSeaweed.value).booleanValue()) {
            return false;
        }
        if (iBlockAccess.getBlockMaterial(n, n2 + 1, n3) == Material._h) {
            IBetterSeaweed iBetterSeaweed = block instanceof IBetterSeaweed ? (IBetterSeaweed)((Object)block) : this;
            long l = BetterSeaweedRenderer.getRandomOffsetForPosition(n, n2, n3);
            if (iBlockAccess.getBlockMaterial(n, n2 + 2, n3) == Material._h) {
                if (!((Boolean[])BetterGrassAndLeavesMod.algaeHostingBiomes.value)[iBlockAccess.getBiomeGenForCoords((int)n, (int)n3)._P].booleanValue() || (float)(l >> 4 & 0xFL) / 15.0f >= ((Float)BetterGrassAndLeavesMod.algaePopulation.value).floatValue()) {
                    return false;
                }
                Icon icon = iBetterSeaweed.getIconBetterAlgae(0, (float)(l >> 12 & 0xFL) / 15.0f);
                if (icon == null) {
                    return false;
                }
                BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 + 1, n3));
                BlockRenderer.tessellator.get().setColorOpaque_F(((Float)BetterGrassAndLeavesMod.betterAlgaeBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterAlgaeBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterAlgaeBrightness.value).floatValue());
                double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
                double d2 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
                double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
                boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
                BetterSeaweedRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
                this.renderCrossedQuadsY(icon, d, d2, d3, bl, false);
            } else if (((Boolean[])BetterGrassAndLeavesMod.reedHostingBiomes.value)[iBlockAccess.getBiomeGenForCoords((int)n, (int)n3)._P].booleanValue() && iBlockAccess.isAirBlock(n, n2 + 2, n3)) {
                float f = (float)(l >> 4 & 0xFL) / 15.0f;
                if (this.nearShore(iBlockAccess, n, n2 + 1, n3) ? f >= ((Float)BetterGrassAndLeavesMod.reedPopulation.value).floatValue() : f >= ((Float)BetterGrassAndLeavesMod.reedPopulation.value).floatValue() * ((Float)BetterGrassAndLeavesMod.reedOffshorePopulation.value).floatValue()) {
                    return false;
                }
                float f2 = (float)(l >> 12 & 0xFL) / 15.0f;
                Icon icon = iBetterSeaweed.getIconBetterReed(0, f2);
                if (icon == null) {
                    return false;
                }
                BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 + 2, n3));
                BlockRenderer.tessellator.get().setColorOpaque_F(((Float)BetterGrassAndLeavesMod.betterReedBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterReedBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterReedBrightness.value).floatValue());
                double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
                double d4 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
                double d5 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
                boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
                BetterSeaweedRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
                this.renderCrossedQuadsY(icon, d, d4, d5, bl, false);
                icon = iBetterSeaweed.getIconBetterReed(1, f2);
                if (icon == null) {
                    return false;
                }
                this.renderCrossedQuadsY(icon, d, d4 + 1.414, d5, bl, false);
            }
        }
        return false;
    }

    protected boolean nearShore(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.getBlockMaterial(n - 2, n2, n3) != Material._h) {
            return true;
        }
        if (iBlockAccess.getBlockMaterial(n + 2, n2, n3) != Material._h) {
            return true;
        }
        if (iBlockAccess.getBlockMaterial(n, n2, n3 - 2) != Material._h) {
            return true;
        }
        return iBlockAccess.getBlockMaterial(n, n2, n3 + 2) != Material._h;
    }

    @Override
    public BufferedImage onTextureLoading(TextureAtlasSprite textureAtlasSprite, BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        BufferedImage bufferedImage2 = new BufferedImage(n, n, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.drawImage(bufferedImage, null, 0, textureAtlasSprite.getIconName().startsWith("better_reed_top") ? n * 2 - bufferedImage.getHeight() : -bufferedImage.getHeight() + n);
        graphics2D.dispose();
        return bufferedImage2;
    }

    @Override
    public Icon getIconBetterAlgae(int n, float f) {
        return iconBetterAlgae == null ? null : iconBetterAlgae[(int)(f * (float)(iconBetterAlgae.length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconBetterReed(int n, float f) {
        return iconBetterReed != null && iconBetterReed[n] != null ? iconBetterReed[n][(int)(f * (float)(iconBetterReed[n].length - 1) + 0.5f)] : null;
    }
}


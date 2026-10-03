/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterCactus;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterCactiRenderer
extends BlockRenderer
implements IBetterCactus {
    public static Icon[] iconBetterCactus;
    public static Icon[] iconBetterCactusArm;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconBetterCactus = BetterCactiRenderer.registerBlockIcons("better_cactus");
        iconBetterCactusArm = BetterCactiRenderer.registerBlockIcons("better_cactus_arm");
    }

    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterCacti.value).booleanValue()) {
            return false;
        }
        IBetterCactus iBetterCactus = block instanceof IBetterCactus ? (IBetterCactus)((Object)block) : this;
        long l = BetterCactiRenderer.getRandomOffsetForPosition(n, n2, n3);
        double d = BlockRenderer.tessellator.get().xOffset;
        double d2 = BlockRenderer.tessellator.get().zOffset;
        BlockRenderer.tessellator.get().xOffset += ((double)((float)(l & 0xFL) / 15.0f) - 0.5) * 0.08;
        BlockRenderer.tessellator.get().zOffset += ((double)((float)(l >> 4 & 0xFL) / 15.0f) - 0.5) * 0.08;
        block.setBlockBoundsBasedOnState(iBlockAccess, n, n2, n3);
        renderBlocks._a(block);
        renderBlocks._t(block, n, n2, n3);
        BlockRenderer.tessellator.get().setColorOpaque_F(((Float)BetterGrassAndLeavesMod.betterCactiBrightness.value).floatValue() * 0.78f, ((Float)BetterGrassAndLeavesMod.betterCactiBrightness.value).floatValue() * 0.78f, ((Float)BetterGrassAndLeavesMod.betterCactiBrightness.value).floatValue() * 0.78f);
        Icon icon = iBetterCactus.getIconBetterCactus(0, (float)(l >> 8 & 0xFL) / 15.0f);
        if (icon != null) {
            boolean bl = (float)(l >> 12 & 0xFL) / 15.0f < 0.5f;
            BetterCactiRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap32px, n, n2, n3);
            this.renderCrossedQuadsY(icon, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, bl, false);
        }
        if ((icon = iBetterCactus.getIconBetterCactusArm(0, (float)(l >> 12 & 0xFL) / 15.0f)) != null) {
            double d3 = ((double)((float)(l & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d4 = (double)((float)(l >> 4 & 0xFL) / 15.0f) * 0.16;
            double d5 = ((double)((float)(l >> 8 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl = (float)(l >> 16 & 0xFL) / 15.0f < 0.5f;
            BetterCactiRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap16px, n, n2, n3);
            switch ((int)((float)(l >> 8 & 0xFL) / 15.0f * 3.0f + 0.5f)) {
                case 0: {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n - 1, n2, n3));
                    this.renderCrossedQuadsX(icon, (double)n - 0.4714 + d4, (double)n2 + 0.5 + d5, (double)n3 + 0.5 + d3, bl, true);
                    break;
                }
                case 1: {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n + 1, n2, n3));
                    this.renderCrossedQuadsX(icon, (double)n + 1.4714 - d4, (double)n2 + 0.5 + d5, (double)n3 + 0.5 + d3, bl, false);
                    break;
                }
                case 2: {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 - 1));
                    this.renderCrossedQuadsZ(icon, (double)n + 0.5 + d3, (double)n2 + 0.5 + d5, (double)n3 - 0.4714 + d4, bl, true);
                    break;
                }
                default: {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 + 1));
                    this.renderCrossedQuadsZ(icon, (double)n + 0.5 + d3, (double)n2 + 0.5 + d5, (double)n3 + 1.4714 - d4, bl, false);
                }
            }
        }
        BlockRenderer.tessellator.get().xOffset = d;
        BlockRenderer.tessellator.get().zOffset = d2;
        return true;
    }

    @Override
    public Icon getIconBetterCactus(int n, float f) {
        return iconBetterCactus == null ? null : iconBetterCactus[(int)(f * (float)(iconBetterCactus.length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconBetterCactusArm(int n, float f) {
        return iconBetterCactusArm == null ? null : iconBetterCactusArm[(int)(f * (float)(iconBetterCactusArm.length - 1) + 0.5f)];
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterLeavesExperimentalRenderer
extends BlockRenderer {
    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        float f;
        int n4;
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterLeaves.value).booleanValue()) {
            return false;
        }
        Icon icon = block.getIcon(iBlockAccess.getBlockMetadata(n, n2, n3), 0);
        int n5 = block.colorMultiplier(iBlockAccess, n, n2, n3);
        float f2 = (float)(n5 >> 16 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
        float f3 = (float)(n5 >> 8 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
        float f4 = (float)(n5 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
        if (iBlockAccess.isAirBlock(n, n2 + 1, n3)) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 + 1, n3));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().setColorOpaque_F(f2 * f, f3 * f, f4 * f);
                renderBlocks._b(block, (double)n, (double)n2 + (double)n4 * 0.02, (double)n3, icon);
            }
        }
        if (iBlockAccess.isAirBlock(n, n2 - 1, n3)) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 - 1, n3));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().setColorOpaque_F(f2 * f, f3 * f, f4 * f);
                renderBlocks._a(block, (double)n, (double)n2 - (double)n4 * 0.02, (double)n3, icon);
            }
        }
        if (iBlockAccess.isAirBlock(n + 1, n2, n3)) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n + 1, n2, n3));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().setColorOpaque_F(f2 * f, f3 * f, f4 * f);
                renderBlocks._f(block, (double)n + (double)n4 * 0.02, n2, n3, icon);
            }
        }
        if (iBlockAccess.isAirBlock(n - 1, n2, n3)) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n - 1, n2, n3));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().setColorOpaque_F(f2 * f, f3 * f, f4 * f);
                renderBlocks._e(block, (double)n - (double)n4 * 0.02, n2, n3, icon);
            }
        }
        if (iBlockAccess.isAirBlock(n, n2, n3 + 1)) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 + 1));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().setColorOpaque_F(f2 * f, f3 * f, f4 * f);
                renderBlocks._d(block, n, n2, (double)n3 + (double)n4 * 0.02, icon);
            }
        }
        if (iBlockAccess.isAirBlock(n, n2, n3 - 1)) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 - 1));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().setColorOpaque_F(f2 * f, f3 * f, f4 * f);
                renderBlocks._c(block, (double)n, (double)n2, (double)n3 - (double)n4 * 0.02, icon);
            }
        }
        return false;
    }
}


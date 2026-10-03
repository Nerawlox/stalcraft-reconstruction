/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterLeaves;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterLeavesAdvancedRenderer
extends BlockRenderer {
    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterLeaves.value).booleanValue()) {
            return false;
        }
        long l = BetterLeavesAdvancedRenderer.getRandomOffsetForPosition(n, n2, n3);
        int n4 = BetterLeavesRenderer.blockHasVisibleSide(block, iBlockAccess, n, n2, n3);
        if (n4 > -1) {
            IBetterLeaves iBetterLeaves = block instanceof IBetterLeaves ? (IBetterLeaves)((Object)block) : (IBetterLeaves)BlockRenderer.leavesRenderer.get(0);
            int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
            float f = (float)(l >> 12 & 0xFL) / 15.0f;
            Icon icon = iBetterLeaves.getIconBetterLeaves(n5, f);
            if (icon == null && (icon = BetterLeavesRenderer.getIconFromMap(block.getIcon(0, n5).getIconName(), f)) == null) {
                icon = block.getIcon(0, n5);
            }
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.45;
            double d2 = (double)n2 + 0.5 + ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.45;
            int n6 = block.colorMultiplier(iBlockAccess, n, n2, n3);
            float f2 = (float)(n6 >> 16 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            float f3 = (float)(n6 >> 8 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            float f4 = (float)(n6 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            boolean bl2 = (float)(l >> 4 & 0xFL) / 15.0f < 0.5f;
            BetterLeavesAdvancedRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap32px, n, n2, n3);
            if (!block.isOpaqueCube()) {
                BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3));
            } else {
                BlockRenderer.tessellator.get().setBrightness(n4);
            }
            Minecraft minecraft = this.minecraft;
            if (Minecraft._C()) {
                this.renderCrossedQuadsShadedX(icon, d + (bl ? -0.15 : 0.15), d2, d3, bl, bl2, f2, f3, f4, f2 * 0.58f, f3 * 0.58f, f4 * 0.58f);
                this.renderCrossedQuadsShadedY(icon, d, d2, d3, bl, bl2, f2, f3, f4, f2 * 0.58f, f3 * 0.58f, f4 * 0.58f);
                this.renderCrossedQuadsShadedZ(icon, d, d2, d3 + (bl2 ? -0.15 : 0.15), bl, bl2, f2, f3, f4, f2 * 0.58f, f3 * 0.58f, f4 * 0.58f);
            } else {
                BlockRenderer.tessellator.get().setColorOpaque_F(f2 * 0.78f, f3 * 0.78f, f4 * 0.78f);
                this.renderCrossedQuadsX(icon, d + (bl ? -0.15 : 0.15), d2, d3, bl, bl2);
                this.renderCrossedQuadsY(icon, d, d2, d3, bl, bl2);
                this.renderCrossedQuadsZ(icon, d, d2, d3 + (bl2 ? -0.15 : 0.15), bl, bl2);
            }
            if (((Boolean)BetterGrassAndLeavesMod.renderSnowedLeaves.value).booleanValue() && iBlockAccess.getBlockId(n, n2 + 1, n3) == Block.snow.blockID) {
                icon = iBetterLeaves.getIconBetterLeavesSnowed(0, (float)(l >> 12 & 0xFL) / 15.0f);
                if (icon == null) {
                    return true;
                }
                BlockRenderer.tessellator.get().setColorOpaque_F(1.0f, 1.0f, 1.0f);
                minecraft = this.minecraft;
                if (Minecraft._C()) {
                    this.renderCrossedQuadsShadedY(icon, d, d2, d3, bl, false, 1.0f, 1.0f, 1.0f, 0.58f, 0.58f, 0.58f);
                } else {
                    BlockRenderer.tessellator.get().setColorOpaque_F(0.78f, 0.78f, 0.78f);
                    this.renderCrossedQuadsY(icon, d, d2, d3, bl, false);
                }
            }
        }
        return true;
    }

    @Override
    public boolean onRandomDisplayTick(Block block, World world, int n, int n2, int n3, Random random) {
        return ((BlockRenderer)BlockRenderer.leavesRenderer.get(0)).onRandomDisplayTick(block, world, n, n2, n3, random);
    }
}


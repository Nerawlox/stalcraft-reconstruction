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
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterLilyPad;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterLilyPadRenderer
extends BlockRenderer
implements IBetterLilyPad {
    public static Icon[] iconBetterLilyPadFlower;
    public static Icon[] iconBetterLilyPadRoots;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconBetterLilyPadFlower = BetterLilyPadRenderer.registerBlockIcons("better_lilypad_flower");
        iconBetterLilyPadRoots = BetterLilyPadRenderer.registerBlockIcons("better_lilypad_roots");
    }

    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        Icon icon;
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterLilyPads.value).booleanValue()) {
            return false;
        }
        long l = BetterLilyPadRenderer.getRandomOffsetForPosition(n, n2, n3);
        double d = BlockRenderer.tessellator.get().xOffset;
        double d2 = BlockRenderer.tessellator.get().yOffset;
        double d3 = BlockRenderer.tessellator.get().zOffset;
        BlockRenderer.tessellator.get().xOffset += ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
        BlockRenderer.tessellator.get().yOffset += 0.015625 + ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 0.5) * 0.007;
        BlockRenderer.tessellator.get().zOffset += ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
        block.setBlockBoundsBasedOnState(iBlockAccess, n, n2, n3);
        renderBlocks._a(block);
        renderBlocks._o(block, n, n2, n3);
        IBetterLilyPad iBetterLilyPad = block instanceof IBetterLilyPad ? (IBetterLilyPad)((Object)block) : this;
        boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
        BetterLilyPadRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap16px, n, n2, n3);
        BlockRenderer.tessellator.get().setColorOpaque_F(((Float)BetterGrassAndLeavesMod.betterLilyPadsBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterLilyPadsBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterLilyPadsBrightness.value).floatValue());
        if ((float)(l >> 4 & 0xFL) / 15.0f < ((Float)BetterGrassAndLeavesMod.lilyPadFlowerPopulation.value).floatValue() && (icon = iBetterLilyPad.getIconBetterLilyPadFlower(0, (float)(l >> 12 & 0xFL) / 15.0f)) != null) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3));
            this.renderCrossedQuadsY(icon, (double)n + 0.5, (double)n2 + 0.487025, (double)n3 + 0.5, bl, false);
        }
        if ((icon = iBetterLilyPad.getIconBetterLilyPadRoots(0, (float)(l >> 12 & 0xFL) / 15.0f)) != null) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 - 1, n3));
            this.renderCrossedQuadsY(icon, (double)n + 0.5, (double)n2 - 0.455775, (double)n3 + 0.5, bl, false);
        }
        BlockRenderer.tessellator.get().xOffset = d;
        BlockRenderer.tessellator.get().yOffset = d2;
        BlockRenderer.tessellator.get().zOffset = d3;
        return true;
    }

    @Override
    public Icon getIconBetterLilyPadFlower(int n, float f) {
        return iconBetterLilyPadFlower == null ? null : iconBetterLilyPadFlower[(int)(f * (float)(iconBetterLilyPadFlower.length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconBetterLilyPadRoots(int n, float f) {
        return iconBetterLilyPadRoots == null ? null : iconBetterLilyPadRoots[(int)(f * (float)(iconBetterLilyPadRoots.length - 1) + 0.5f)];
    }
}


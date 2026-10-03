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
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterNetherrack;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterNetherrackRenderer
extends BlockRenderer
implements IBetterNetherrack {
    public static Icon[] iconBetterNetherrack;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconBetterNetherrack = BetterNetherrackRenderer.registerBlockIcons("better_netherrack");
    }

    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterNetherrack.value).booleanValue()) {
            return false;
        }
        if (iBlockAccess.isAirBlock(n, n2 - 1, n3)) {
            IBetterNetherrack iBetterNetherrack = block instanceof IBetterNetherrack ? (IBetterNetherrack)((Object)block) : this;
            long l = BetterNetherrackRenderer.getRandomOffsetForPosition(n, n2, n3);
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 - 1, n3));
            BlockRenderer.tessellator.get().setColorOpaque_F(((Float)BetterGrassAndLeavesMod.betterNetherrackBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterNetherrackBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterNetherrackBrightness.value).floatValue());
            Icon icon = iBetterNetherrack.getIconBetterNetherrack(0, (float)(l >> 12 & 0xFL) / 15.0f);
            if (icon == null) {
                return false;
            }
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d2 = (double)n2 - 0.707 + (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            BetterNetherrackRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
            this.renderCrossedQuadsY(icon, d, d2, d3, bl, false);
        }
        return false;
    }

    @Override
    public Icon getIconBetterNetherrack(int n, float f) {
        return iconBetterNetherrack == null ? null : iconBetterNetherrack[(int)(f * (float)(iconBetterNetherrack.length - 1) + 0.5f)];
    }
}


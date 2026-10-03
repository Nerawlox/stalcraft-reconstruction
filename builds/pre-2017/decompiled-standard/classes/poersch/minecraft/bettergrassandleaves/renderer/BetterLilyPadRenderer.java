/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterLilyPad;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterLilyPadRenderer
extends BlockRenderer
implements IBetterLilyPad {
    public static dwan[] iconBetterLilyPadFlower;
    public static dwan[] iconBetterLilyPadRoots;

    @Override
    public void onRegisterIcons(nege nege2) {
        iconBetterLilyPadFlower = BetterLilyPadRenderer.registerBlockIcons("better_lilypad_flower");
        iconBetterLilyPadRoots = BetterLilyPadRenderer.registerBlockIcons("better_lilypad_roots");
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        dwan dwan2;
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterLilyPads.value).booleanValue()) {
            return false;
        }
        long l = BetterLilyPadRenderer.getRandomOffsetForPosition(n, n2, n3);
        double d = BlockRenderer.tessellator.get().field_78408_v;
        double d2 = BlockRenderer.tessellator.get().field_78407_w;
        double d3 = BlockRenderer.tessellator.get().field_78417_x;
        BlockRenderer.tessellator.get().field_78408_v += ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
        BlockRenderer.tessellator.get().field_78407_w += 0.015625 + ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 0.5) * 0.007;
        BlockRenderer.tessellator.get().field_78417_x += ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
        twgu2.func_71902_a(sdrg2, n, n2, n3);
        htvc2._a(twgu2);
        htvc2._o(twgu2, n, n2, n3);
        IBetterLilyPad iBetterLilyPad = twgu2 instanceof IBetterLilyPad ? (IBetterLilyPad)((Object)twgu2) : this;
        boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
        BetterLilyPadRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap16px, n, n2, n3);
        BlockRenderer.tessellator.get().func_78386_a(((Float)BetterGrassAndLeavesMod.betterLilyPadsBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterLilyPadsBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterLilyPadsBrightness.value).floatValue());
        if ((float)(l >> 4 & 0xFL) / 15.0f < ((Float)BetterGrassAndLeavesMod.lilyPadFlowerPopulation.value).floatValue() && (dwan2 = iBetterLilyPad.getIconBetterLilyPadFlower(0, (float)(l >> 12 & 0xFL) / 15.0f)) != null) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3));
            this.renderCrossedQuadsY(dwan2, (double)n + 0.5, (double)n2 + 0.487025, (double)n3 + 0.5, bl, false);
        }
        if ((dwan2 = iBetterLilyPad.getIconBetterLilyPadRoots(0, (float)(l >> 12 & 0xFL) / 15.0f)) != null) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 - 1, n3));
            this.renderCrossedQuadsY(dwan2, (double)n + 0.5, (double)n2 - 0.455775, (double)n3 + 0.5, bl, false);
        }
        BlockRenderer.tessellator.get().field_78408_v = d;
        BlockRenderer.tessellator.get().field_78407_w = d2;
        BlockRenderer.tessellator.get().field_78417_x = d3;
        return true;
    }

    @Override
    public dwan getIconBetterLilyPadFlower(int n, float f) {
        return iconBetterLilyPadFlower == null ? null : iconBetterLilyPadFlower[(int)(f * (float)(iconBetterLilyPadFlower.length - 1) + 0.5f)];
    }

    @Override
    public dwan getIconBetterLilyPadRoots(int n, float f) {
        return iconBetterLilyPadRoots == null ? null : iconBetterLilyPadRoots[(int)(f * (float)(iconBetterLilyPadRoots.length - 1) + 0.5f)];
    }
}


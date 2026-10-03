/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterNetherrack;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterNetherrackRenderer
extends BlockRenderer
implements IBetterNetherrack {
    public static dwan[] iconBetterNetherrack;

    @Override
    public void onRegisterIcons(nege nege2) {
        iconBetterNetherrack = BetterNetherrackRenderer.registerBlockIcons("better_netherrack");
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterNetherrack.value).booleanValue()) {
            return false;
        }
        if (sdrg2.func_72799_c(n, n2 - 1, n3)) {
            IBetterNetherrack iBetterNetherrack = twgu2 instanceof IBetterNetherrack ? (IBetterNetherrack)((Object)twgu2) : this;
            long l = BetterNetherrackRenderer.getRandomOffsetForPosition(n, n2, n3);
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 - 1, n3));
            BlockRenderer.tessellator.get().func_78386_a(((Float)BetterGrassAndLeavesMod.betterNetherrackBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterNetherrackBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterNetherrackBrightness.value).floatValue());
            dwan dwan2 = iBetterNetherrack.getIconBetterNetherrack(0, (float)(l >> 12 & 0xFL) / 15.0f);
            if (dwan2 == null) {
                return false;
            }
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d2 = (double)n2 - 0.707 + (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            BetterNetherrackRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
            this.renderCrossedQuadsY(dwan2, d, d2, d3, bl, false);
        }
        return false;
    }

    @Override
    public dwan getIconBetterNetherrack(int n, float f) {
        return iconBetterNetherrack == null ? null : iconBetterNetherrack[(int)(f * (float)(iconBetterNetherrack.length - 1) + 0.5f)];
    }
}


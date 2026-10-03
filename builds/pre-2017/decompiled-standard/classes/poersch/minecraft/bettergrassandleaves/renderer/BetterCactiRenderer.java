/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterCactus;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterCactiRenderer
extends BlockRenderer
implements IBetterCactus {
    public static dwan[] iconBetterCactus;
    public static dwan[] iconBetterCactusArm;

    @Override
    public void onRegisterIcons(nege nege2) {
        iconBetterCactus = BetterCactiRenderer.registerBlockIcons("better_cactus");
        iconBetterCactusArm = BetterCactiRenderer.registerBlockIcons("better_cactus_arm");
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterCacti.value).booleanValue()) {
            return false;
        }
        IBetterCactus iBetterCactus = twgu2 instanceof IBetterCactus ? (IBetterCactus)((Object)twgu2) : this;
        long l = BetterCactiRenderer.getRandomOffsetForPosition(n, n2, n3);
        double d = BlockRenderer.tessellator.get().field_78408_v;
        double d2 = BlockRenderer.tessellator.get().field_78417_x;
        BlockRenderer.tessellator.get().field_78408_v += ((double)((float)(l & 0xFL) / 15.0f) - 0.5) * 0.08;
        BlockRenderer.tessellator.get().field_78417_x += ((double)((float)(l >> 4 & 0xFL) / 15.0f) - 0.5) * 0.08;
        twgu2.func_71902_a(sdrg2, n, n2, n3);
        htvc2._a(twgu2);
        htvc2._t(twgu2, n, n2, n3);
        BlockRenderer.tessellator.get().func_78386_a(((Float)BetterGrassAndLeavesMod.betterCactiBrightness.value).floatValue() * 0.78f, ((Float)BetterGrassAndLeavesMod.betterCactiBrightness.value).floatValue() * 0.78f, ((Float)BetterGrassAndLeavesMod.betterCactiBrightness.value).floatValue() * 0.78f);
        dwan dwan2 = iBetterCactus.getIconBetterCactus(0, (float)(l >> 8 & 0xFL) / 15.0f);
        if (dwan2 != null) {
            boolean bl = (float)(l >> 12 & 0xFL) / 15.0f < 0.5f;
            BetterCactiRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap32px, n, n2, n3);
            this.renderCrossedQuadsY(dwan2, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, bl, false);
        }
        if ((dwan2 = iBetterCactus.getIconBetterCactusArm(0, (float)(l >> 12 & 0xFL) / 15.0f)) != null) {
            double d3 = ((double)((float)(l & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d4 = (double)((float)(l >> 4 & 0xFL) / 15.0f) * 0.16;
            double d5 = ((double)((float)(l >> 8 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl = (float)(l >> 16 & 0xFL) / 15.0f < 0.5f;
            BetterCactiRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap16px, n, n2, n3);
            switch ((int)((float)(l >> 8 & 0xFL) / 15.0f * 3.0f + 0.5f)) {
                case 0: {
                    BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n - 1, n2, n3));
                    this.renderCrossedQuadsX(dwan2, (double)n - 0.4714 + d4, (double)n2 + 0.5 + d5, (double)n3 + 0.5 + d3, bl, true);
                    break;
                }
                case 1: {
                    BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n + 1, n2, n3));
                    this.renderCrossedQuadsX(dwan2, (double)n + 1.4714 - d4, (double)n2 + 0.5 + d5, (double)n3 + 0.5 + d3, bl, false);
                    break;
                }
                case 2: {
                    BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3 - 1));
                    this.renderCrossedQuadsZ(dwan2, (double)n + 0.5 + d3, (double)n2 + 0.5 + d5, (double)n3 - 0.4714 + d4, bl, true);
                    break;
                }
                default: {
                    BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3 + 1));
                    this.renderCrossedQuadsZ(dwan2, (double)n + 0.5 + d3, (double)n2 + 0.5 + d5, (double)n3 + 1.4714 - d4, bl, false);
                }
            }
        }
        BlockRenderer.tessellator.get().field_78408_v = d;
        BlockRenderer.tessellator.get().field_78417_x = d2;
        return true;
    }

    @Override
    public dwan getIconBetterCactus(int n, float f) {
        return iconBetterCactus == null ? null : iconBetterCactus[(int)(f * (float)(iconBetterCactus.length - 1) + 0.5f)];
    }

    @Override
    public dwan getIconBetterCactusArm(int n, float f) {
        return iconBetterCactusArm == null ? null : iconBetterCactusArm[(int)(f * (float)(iconBetterCactusArm.length - 1) + 0.5f)];
    }
}


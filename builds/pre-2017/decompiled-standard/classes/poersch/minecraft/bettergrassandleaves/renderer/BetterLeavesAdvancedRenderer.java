/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.util.Random;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterLeaves;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterLeavesAdvancedRenderer
extends BlockRenderer {
    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterLeaves.value).booleanValue()) {
            return false;
        }
        long l = BetterLeavesAdvancedRenderer.getRandomOffsetForPosition(n, n2, n3);
        int n4 = BetterLeavesRenderer.blockHasVisibleSide(twgu2, sdrg2, n, n2, n3);
        if (n4 > -1) {
            IBetterLeaves iBetterLeaves = twgu2 instanceof IBetterLeaves ? (IBetterLeaves)((Object)twgu2) : (IBetterLeaves)BlockRenderer.leavesRenderer.get(0);
            int n5 = sdrg2.func_72805_g(n, n2, n3);
            float f = (float)(l >> 12 & 0xFL) / 15.0f;
            dwan dwan2 = iBetterLeaves.getIconBetterLeaves(n5, f);
            if (dwan2 == null && (dwan2 = BetterLeavesRenderer.getIconFromMap(twgu2.func_71858_a(0, n5).func_94215_i(), f)) == null) {
                dwan2 = twgu2.func_71858_a(0, n5);
            }
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.45;
            double d2 = (double)n2 + 0.5 + ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.45;
            int n6 = twgu2.func_71920_b(sdrg2, n, n2, n3);
            float f2 = (float)(n6 >> 16 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            float f3 = (float)(n6 >> 8 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            float f4 = (float)(n6 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            boolean bl2 = (float)(l >> 4 & 0xFL) / 15.0f < 0.5f;
            BetterLeavesAdvancedRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap32px, n, n2, n3);
            if (!twgu2.func_71926_d()) {
                BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3));
            } else {
                BlockRenderer.tessellator.get().func_78380_c(n4);
            }
            xpzm xpzm2 = this.minecraft;
            if (xpzm._C()) {
                this.renderCrossedQuadsShadedX(dwan2, d + (bl ? -0.15 : 0.15), d2, d3, bl, bl2, f2, f3, f4, f2 * 0.58f, f3 * 0.58f, f4 * 0.58f);
                this.renderCrossedQuadsShadedY(dwan2, d, d2, d3, bl, bl2, f2, f3, f4, f2 * 0.58f, f3 * 0.58f, f4 * 0.58f);
                this.renderCrossedQuadsShadedZ(dwan2, d, d2, d3 + (bl2 ? -0.15 : 0.15), bl, bl2, f2, f3, f4, f2 * 0.58f, f3 * 0.58f, f4 * 0.58f);
            } else {
                BlockRenderer.tessellator.get().func_78386_a(f2 * 0.78f, f3 * 0.78f, f4 * 0.78f);
                this.renderCrossedQuadsX(dwan2, d + (bl ? -0.15 : 0.15), d2, d3, bl, bl2);
                this.renderCrossedQuadsY(dwan2, d, d2, d3, bl, bl2);
                this.renderCrossedQuadsZ(dwan2, d, d2, d3 + (bl2 ? -0.15 : 0.15), bl, bl2);
            }
            if (((Boolean)BetterGrassAndLeavesMod.renderSnowedLeaves.value).booleanValue() && sdrg2.func_72798_a(n, n2 + 1, n3) == twgu.field_72037_aS.field_71990_ca) {
                dwan2 = iBetterLeaves.getIconBetterLeavesSnowed(0, (float)(l >> 12 & 0xFL) / 15.0f);
                if (dwan2 == null) {
                    return true;
                }
                BlockRenderer.tessellator.get().func_78386_a(1.0f, 1.0f, 1.0f);
                xpzm2 = this.minecraft;
                if (xpzm._C()) {
                    this.renderCrossedQuadsShadedY(dwan2, d, d2, d3, bl, false, 1.0f, 1.0f, 1.0f, 0.58f, 0.58f, 0.58f);
                } else {
                    BlockRenderer.tessellator.get().func_78386_a(0.78f, 0.78f, 0.78f);
                    this.renderCrossedQuadsY(dwan2, d, d2, d3, bl, false);
                }
            }
        }
        return true;
    }

    @Override
    public boolean onRandomDisplayTick(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, Random random) {
        return ((BlockRenderer)BlockRenderer.leavesRenderer.get(0)).onRandomDisplayTick(twgu2, ozlu2, n, n2, n3, random);
    }
}


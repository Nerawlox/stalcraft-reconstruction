/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterLeavesExperimentalRenderer
extends BlockRenderer {
    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        float f;
        int n4;
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterLeaves.value).booleanValue()) {
            return false;
        }
        dwan dwan2 = twgu2.func_71858_a(sdrg2.func_72805_g(n, n2, n3), 0);
        int n5 = twgu2.func_71920_b(sdrg2, n, n2, n3);
        float f2 = (float)(n5 >> 16 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
        float f3 = (float)(n5 >> 8 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
        float f4 = (float)(n5 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
        if (sdrg2.func_72799_c(n, n2 + 1, n3)) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 + 1, n3));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().func_78386_a(f2 * f, f3 * f, f4 * f);
                htvc2._b(twgu2, (double)n, (double)n2 + (double)n4 * 0.02, (double)n3, dwan2);
            }
        }
        if (sdrg2.func_72799_c(n, n2 - 1, n3)) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 - 1, n3));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().func_78386_a(f2 * f, f3 * f, f4 * f);
                htvc2._a(twgu2, (double)n, (double)n2 - (double)n4 * 0.02, (double)n3, dwan2);
            }
        }
        if (sdrg2.func_72799_c(n + 1, n2, n3)) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n + 1, n2, n3));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().func_78386_a(f2 * f, f3 * f, f4 * f);
                htvc2._f(twgu2, (double)n + (double)n4 * 0.02, n2, n3, dwan2);
            }
        }
        if (sdrg2.func_72799_c(n - 1, n2, n3)) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n - 1, n2, n3));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().func_78386_a(f2 * f, f3 * f, f4 * f);
                htvc2._e(twgu2, (double)n - (double)n4 * 0.02, n2, n3, dwan2);
            }
        }
        if (sdrg2.func_72799_c(n, n2, n3 + 1)) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3 + 1));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().func_78386_a(f2 * f, f3 * f, f4 * f);
                htvc2._d(twgu2, n, n2, (double)n3 + (double)n4 * 0.02, dwan2);
            }
        }
        if (sdrg2.func_72799_c(n, n2, n3 - 1)) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3 - 1));
            for (n4 = 1; n4 < 5; ++n4) {
                f = 0.5f + 0.1f * (float)n4;
                BlockRenderer.tessellator.get().func_78386_a(f2 * f, f3 * f, f4 * f);
                htvc2._c(twgu2, (double)n, (double)n2, (double)n3 - (double)n4 * 0.02, dwan2);
            }
        }
        return false;
    }
}


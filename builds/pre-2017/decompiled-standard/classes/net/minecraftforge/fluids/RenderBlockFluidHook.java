/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.RenderBlockFluid;

public class RenderBlockFluidHook
extends RenderBlockFluid {
    public static RenderBlockFluidHook hookedInstance = new RenderBlockFluidHook();

    @Override
    public boolean renderWorldBlock(sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4, htvc htvc2) {
        float f;
        float f2;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        boolean bl;
        double d7;
        double d8;
        double d9;
        double d10;
        float f3;
        if (!(twgu2 instanceof BlockFluidBase)) {
            return false;
        }
        htvf htvf2 = htvc2.__aF;
        int n5 = twgu2.func_71920_b(sdrg2, n, n2, n3);
        float f4 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n5 & 0xFF) / 255.0f;
        BlockFluidBase blockFluidBase = (BlockFluidBase)twgu2;
        int n6 = sdrg2.func_72805_g(n, n2, n3);
        boolean bl2 = sdrg2.func_72798_a(n, n2 - blockFluidBase.densityDir, n3) != blockFluidBase.field_71990_ca;
        boolean bl3 = twgu2.func_71877_c(sdrg2, n, n2 + blockFluidBase.densityDir, n3, 0) && sdrg2.func_72798_a(n, n2 + blockFluidBase.densityDir, n3) != blockFluidBase.field_71990_ca;
        boolean[] blArray = new boolean[]{twgu2.func_71877_c(sdrg2, n, n2, n3 - 1, 2), twgu2.func_71877_c(sdrg2, n, n2, n3 + 1, 3), twgu2.func_71877_c(sdrg2, n - 1, n2, n3, 4), twgu2.func_71877_c(sdrg2, n + 1, n2, n3, 5)};
        if (!(bl2 || bl3 || blArray[0] || blArray[1] || blArray[2] || blArray[3])) {
            return false;
        }
        boolean bl4 = false;
        float f7 = this.getFluidHeightForRender(sdrg2, n, n2, n3, blockFluidBase);
        if (f7 != 1.0f) {
            float f8 = this.getFluidHeightForRender(sdrg2, n - 1, n2, n3 - 1, blockFluidBase);
            float f9 = this.getFluidHeightForRender(sdrg2, n - 1, n2, n3, blockFluidBase);
            f3 = this.getFluidHeightForRender(sdrg2, n - 1, n2, n3 + 1, blockFluidBase);
            float f10 = this.getFluidHeightForRender(sdrg2, n, n2, n3 - 1, blockFluidBase);
            float f11 = this.getFluidHeightForRender(sdrg2, n, n2, n3 + 1, blockFluidBase);
            float f12 = this.getFluidHeightForRender(sdrg2, n + 1, n2, n3 - 1, blockFluidBase);
            float f13 = this.getFluidHeightForRender(sdrg2, n + 1, n2, n3, blockFluidBase);
            float f14 = this.getFluidHeightForRender(sdrg2, n + 1, n2, n3 + 1, blockFluidBase);
            d10 = this.getFluidHeightAverage(new float[]{f8, f9, f10, f7});
            d9 = this.getFluidHeightAverage(new float[]{f9, f3, f11, f7});
            d8 = this.getFluidHeightAverage(new float[]{f11, f13, f14, f7});
            d7 = this.getFluidHeightAverage(new float[]{f10, f12, f13, f7});
        } else {
            d10 = f7;
            d9 = f7;
            d8 = f7;
            d7 = f7;
        }
        boolean bl5 = bl = blockFluidBase.densityDir == 1;
        if (htvc2._d || bl2) {
            double d11;
            double d12;
            bl4 = true;
            dwan dwan2 = twgu2.func_71858_a(1, n6);
            f3 = (float)BlockFluidBase.getFlowDirection(sdrg2, n, n2, n3);
            if (f3 > -999.0f) {
                dwan2 = twgu2.func_71858_a(2, n6);
            }
            d10 -= (double)0.001f;
            d9 -= (double)0.001f;
            d8 -= (double)0.001f;
            d7 -= (double)0.001f;
            if (f3 < -999.0f) {
                d6 = dwan2.func_94214_a(0.0);
                d5 = dwan2.func_94207_b(0.0);
                d12 = d6;
                d4 = dwan2.func_94207_b(16.0);
                d3 = dwan2.func_94214_a(16.0);
                d11 = d4;
                d2 = d3;
                d = d5;
            } else {
                f2 = sajh._a(f3) * 0.25f;
                f = sajh._b(f3) * 0.25f;
                d6 = dwan2.func_94214_a(8.0f + (-f - f2) * 16.0f);
                d5 = dwan2.func_94207_b(8.0f + (-f + f2) * 16.0f);
                d12 = dwan2.func_94214_a(8.0f + (-f + f2) * 16.0f);
                d4 = dwan2.func_94207_b(8.0f + (f + f2) * 16.0f);
                d3 = dwan2.func_94214_a(8.0f + (f + f2) * 16.0f);
                d11 = dwan2.func_94207_b(8.0f + (f - f2) * 16.0f);
                d2 = dwan2.func_94214_a(8.0f + (f - f2) * 16.0f);
                d = dwan2.func_94207_b(8.0f + (-f - f2) * 16.0f);
            }
            htvf2.func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3));
            htvf2.func_78386_a(1.0f * f4, 1.0f * f5, 1.0f * f6);
            if (!bl) {
                htvf2.func_78374_a(n + 0, (double)n2 + d10, n3 + 0, d6, d5);
                htvf2.func_78374_a(n + 0, (double)n2 + d9, n3 + 1, d12, d4);
                htvf2.func_78374_a(n + 1, (double)n2 + d8, n3 + 1, d3, d11);
                htvf2.func_78374_a(n + 1, (double)n2 + d7, n3 + 0, d2, d);
            } else {
                htvf2.func_78374_a(n + 1, (double)(n2 + 1) - d7, n3 + 0, d2, d);
                htvf2.func_78374_a(n + 1, (double)(n2 + 1) - d8, n3 + 1, d3, d11);
                htvf2.func_78374_a(n + 0, (double)(n2 + 1) - d9, n3 + 1, d12, d4);
                htvf2.func_78374_a(n + 0, (double)(n2 + 1) - d10, n3 + 0, d6, d5);
            }
        }
        if (htvc2._d || bl3) {
            bl4 = true;
            htvf2.func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 - 1, n3));
            if (!bl) {
                htvf2.func_78386_a(0.5f * f4, 0.5f * f5, 0.5f * f6);
                htvc2._a(twgu2, (double)n, (double)n2 + (double)0.001f, (double)n3, twgu2.func_71858_a(0, n6));
            } else {
                htvf2.func_78386_a(1.0f * f4, 1.0f * f5, 1.0f * f6);
                htvc2._b(twgu2, (double)n, (double)n2 + (double)0.001f, (double)n3, twgu2.func_71858_a(1, n6));
            }
        }
        for (int i = 0; i < 4; ++i) {
            int n7 = n;
            int n8 = n3;
            switch (i) {
                case 0: {
                    --n8;
                    break;
                }
                case 1: {
                    ++n8;
                    break;
                }
                case 2: {
                    --n7;
                    break;
                }
                case 3: {
                    ++n7;
                }
            }
            dwan dwan3 = twgu2.func_71858_a(i + 2, n6);
            if (!htvc2._d && !blArray[i]) continue;
            bl4 = true;
            if (i == 0) {
                d6 = d10;
                d3 = d7;
                d2 = n;
                d4 = n + 1;
                d5 = (double)n3 + (double)0.001f;
                d = (double)n3 + (double)0.001f;
            } else if (i == 1) {
                d6 = d8;
                d3 = d9;
                d2 = n + 1;
                d4 = n;
                d5 = (double)(n3 + 1) - (double)0.001f;
                d = (double)(n3 + 1) - (double)0.001f;
            } else if (i == 2) {
                d6 = d9;
                d3 = d10;
                d2 = (double)n + (double)0.001f;
                d4 = (double)n + (double)0.001f;
                d5 = n3 + 1;
                d = n3;
            } else {
                d6 = d7;
                d3 = d8;
                d2 = (double)(n + 1) - (double)0.001f;
                d4 = (double)(n + 1) - (double)0.001f;
                d5 = n3;
                d = n3 + 1;
            }
            float f15 = dwan3.func_94214_a(0.0);
            float f16 = dwan3.func_94214_a(8.0);
            f2 = dwan3.func_94207_b((1.0 - d6) * 16.0 * 0.5);
            f = dwan3.func_94207_b((1.0 - d3) * 16.0 * 0.5);
            float f17 = dwan3.func_94207_b(8.0);
            htvf2.func_78380_c(twgu2.func_71874_e(sdrg2, n7, n2, n8));
            float f18 = 1.0f;
            f18 = i < 2 ? 0.8f : 0.6f;
            htvf2.func_78386_a(1.0f * f18 * f4, 1.0f * f18 * f5, 1.0f * f18 * f6);
            if (!bl) {
                htvf2.func_78374_a(d2, (double)n2 + d6, d5, f15, f2);
                htvf2.func_78374_a(d4, (double)n2 + d3, d, f16, f);
                htvf2.func_78374_a(d4, n2 + 0, d, f16, f17);
                htvf2.func_78374_a(d2, n2 + 0, d5, f15, f17);
                continue;
            }
            htvf2.func_78374_a(d2, n2 + 1 - 0, d5, f15, f17);
            htvf2.func_78374_a(d4, n2 + 1 - 0, d, f16, f17);
            htvf2.func_78374_a(d4, (double)(n2 + 1) - d3, d, f16, f);
            htvf2.func_78374_a(d2, (double)(n2 + 1) - d6, d5, f15, f2);
        }
        htvc2._j = 0.0;
        htvc2._k = 1.0;
        return bl4;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.FluidRegistry;

public class RenderBlockFluid
implements ISimpleBlockRenderingHandler {
    public static RenderBlockFluid instance = new RenderBlockFluid();
    static final float LIGHT_Y_NEG = 0.5f;
    static final float LIGHT_Y_POS = 1.0f;
    static final float LIGHT_XZ_NEG = 0.8f;
    static final float LIGHT_XZ_POS = 0.6f;
    static final double RENDER_OFFSET = (double)0.001f;

    public float getFluidHeightAverage(float[] fArray) {
        float f = 0.0f;
        int n = 0;
        float f2 = 0.0f;
        for (int i = 0; i < fArray.length; ++i) {
            if (fArray[i] >= 0.875f && f2 != 1.0f) {
                f2 = fArray[i];
            }
            if (!(fArray[i] >= 0.0f)) continue;
            f += fArray[i];
            ++n;
        }
        if (f2 == 0.0f) {
            f2 = f / (float)n;
        }
        return f2;
    }

    public float getFluidHeightForRender(IBlockAccess iBlockAccess, int n, int n2, int n3, BlockFluidBase blockFluidBase) {
        if (iBlockAccess.getBlockId(n, n2, n3) == blockFluidBase.blockID) {
            if (iBlockAccess.getBlockMaterial(n, n2 - blockFluidBase.densityDir, n3)._d()) {
                return 1.0f;
            }
            if (iBlockAccess.getBlockMetadata(n, n2, n3) == blockFluidBase.getMaxRenderHeightMeta()) {
                return 0.875f;
            }
        }
        return !iBlockAccess.getBlockMaterial(n, n2, n3)._a() && iBlockAccess.getBlockId(n, n2 - blockFluidBase.densityDir, n3) == blockFluidBase.blockID ? 1.0f : blockFluidBase.getQuantaPercentage(iBlockAccess, n, n2, n3) * 0.875f;
    }

    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4, RenderBlocks renderBlocks) {
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
        if (!(block instanceof BlockFluidBase)) {
            return false;
        }
        Tessellator tessellator = Tessellator.instance;
        int n5 = block.colorMultiplier(iBlockAccess, n, n2, n3);
        float f4 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n5 & 0xFF) / 255.0f;
        BlockFluidBase blockFluidBase = (BlockFluidBase)block;
        int n6 = iBlockAccess.getBlockMetadata(n, n2, n3);
        boolean bl2 = iBlockAccess.getBlockId(n, n2 - blockFluidBase.densityDir, n3) != blockFluidBase.blockID;
        boolean bl3 = block.shouldSideBeRendered(iBlockAccess, n, n2 + blockFluidBase.densityDir, n3, 0) && iBlockAccess.getBlockId(n, n2 + blockFluidBase.densityDir, n3) != blockFluidBase.blockID;
        boolean[] blArray = new boolean[]{block.shouldSideBeRendered(iBlockAccess, n, n2, n3 - 1, 2), block.shouldSideBeRendered(iBlockAccess, n, n2, n3 + 1, 3), block.shouldSideBeRendered(iBlockAccess, n - 1, n2, n3, 4), block.shouldSideBeRendered(iBlockAccess, n + 1, n2, n3, 5)};
        if (!(bl2 || bl3 || blArray[0] || blArray[1] || blArray[2] || blArray[3])) {
            return false;
        }
        boolean bl4 = false;
        float f7 = this.getFluidHeightForRender(iBlockAccess, n, n2, n3, blockFluidBase);
        if (f7 != 1.0f) {
            float f8 = this.getFluidHeightForRender(iBlockAccess, n - 1, n2, n3 - 1, blockFluidBase);
            float f9 = this.getFluidHeightForRender(iBlockAccess, n - 1, n2, n3, blockFluidBase);
            f3 = this.getFluidHeightForRender(iBlockAccess, n - 1, n2, n3 + 1, blockFluidBase);
            float f10 = this.getFluidHeightForRender(iBlockAccess, n, n2, n3 - 1, blockFluidBase);
            float f11 = this.getFluidHeightForRender(iBlockAccess, n, n2, n3 + 1, blockFluidBase);
            float f12 = this.getFluidHeightForRender(iBlockAccess, n + 1, n2, n3 - 1, blockFluidBase);
            float f13 = this.getFluidHeightForRender(iBlockAccess, n + 1, n2, n3, blockFluidBase);
            float f14 = this.getFluidHeightForRender(iBlockAccess, n + 1, n2, n3 + 1, blockFluidBase);
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
        if (renderBlocks._d || bl2) {
            double d11;
            double d12;
            bl4 = true;
            Icon icon = block.getIcon(1, n6);
            f3 = (float)BlockFluidBase.getFlowDirection(iBlockAccess, n, n2, n3);
            if (f3 > -999.0f) {
                icon = block.getIcon(2, n6);
            }
            d10 -= (double)0.001f;
            d9 -= (double)0.001f;
            d8 -= (double)0.001f;
            d7 -= (double)0.001f;
            if (f3 < -999.0f) {
                d6 = icon.getInterpolatedU(0.0);
                d5 = icon.getInterpolatedV(0.0);
                d12 = d6;
                d4 = icon.getInterpolatedV(16.0);
                d3 = icon.getInterpolatedU(16.0);
                d11 = d4;
                d2 = d3;
                d = d5;
            } else {
                f2 = sajh._a(f3) * 0.25f;
                f = sajh._b(f3) * 0.25f;
                d6 = icon.getInterpolatedU(8.0f + (-f - f2) * 16.0f);
                d5 = icon.getInterpolatedV(8.0f + (-f + f2) * 16.0f);
                d12 = icon.getInterpolatedU(8.0f + (-f + f2) * 16.0f);
                d4 = icon.getInterpolatedV(8.0f + (f + f2) * 16.0f);
                d3 = icon.getInterpolatedU(8.0f + (f + f2) * 16.0f);
                d11 = icon.getInterpolatedV(8.0f + (f - f2) * 16.0f);
                d2 = icon.getInterpolatedU(8.0f + (f - f2) * 16.0f);
                d = icon.getInterpolatedV(8.0f + (-f - f2) * 16.0f);
            }
            tessellator.setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3));
            tessellator.setColorOpaque_F(1.0f * f4, 1.0f * f5, 1.0f * f6);
            if (!bl) {
                tessellator.addVertexWithUV(n + 0, (double)n2 + d10, n3 + 0, d6, d5);
                tessellator.addVertexWithUV(n + 0, (double)n2 + d9, n3 + 1, d12, d4);
                tessellator.addVertexWithUV(n + 1, (double)n2 + d8, n3 + 1, d3, d11);
                tessellator.addVertexWithUV(n + 1, (double)n2 + d7, n3 + 0, d2, d);
            } else {
                tessellator.addVertexWithUV(n + 1, (double)(n2 + 1) - d7, n3 + 0, d2, d);
                tessellator.addVertexWithUV(n + 1, (double)(n2 + 1) - d8, n3 + 1, d3, d11);
                tessellator.addVertexWithUV(n + 0, (double)(n2 + 1) - d9, n3 + 1, d12, d4);
                tessellator.addVertexWithUV(n + 0, (double)(n2 + 1) - d10, n3 + 0, d6, d5);
            }
        }
        if (renderBlocks._d || bl3) {
            bl4 = true;
            tessellator.setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 - 1, n3));
            if (!bl) {
                tessellator.setColorOpaque_F(0.5f * f4, 0.5f * f5, 0.5f * f6);
                renderBlocks._a(block, (double)n, (double)n2 + (double)0.001f, (double)n3, block.getIcon(0, n6));
            } else {
                tessellator.setColorOpaque_F(1.0f * f4, 1.0f * f5, 1.0f * f6);
                renderBlocks._b(block, (double)n, (double)n2 + (double)0.001f, (double)n3, block.getIcon(1, n6));
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
            Icon icon = block.getIcon(i + 2, n6);
            if (!renderBlocks._d && !blArray[i]) continue;
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
            float f15 = icon.getInterpolatedU(0.0);
            float f16 = icon.getInterpolatedU(8.0);
            f2 = icon.getInterpolatedV((1.0 - d6) * 16.0 * 0.5);
            f = icon.getInterpolatedV((1.0 - d3) * 16.0 * 0.5);
            float f17 = icon.getInterpolatedV(8.0);
            tessellator.setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n7, n2, n8));
            float f18 = 1.0f;
            f18 = i < 2 ? 0.8f : 0.6f;
            tessellator.setColorOpaque_F(1.0f * f18 * f4, 1.0f * f18 * f5, 1.0f * f18 * f6);
            if (!bl) {
                tessellator.addVertexWithUV(d2, (double)n2 + d6, d5, f15, f2);
                tessellator.addVertexWithUV(d4, (double)n2 + d3, d, f16, f);
                tessellator.addVertexWithUV(d4, n2 + 0, d, f16, f17);
                tessellator.addVertexWithUV(d2, n2 + 0, d5, f15, f17);
                continue;
            }
            tessellator.addVertexWithUV(d2, n2 + 1 - 0, d5, f15, f17);
            tessellator.addVertexWithUV(d4, n2 + 1 - 0, d, f16, f17);
            tessellator.addVertexWithUV(d4, (double)(n2 + 1) - d3, d, f16, f);
            tessellator.addVertexWithUV(d2, (double)(n2 + 1) - d6, d5, f15, f2);
        }
        renderBlocks._j = 0.0;
        renderBlocks._k = 1.0;
        return bl4;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return false;
    }

    @Override
    public int getRenderId() {
        return FluidRegistry.renderIdFluid;
    }
}


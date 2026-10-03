/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.IconHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.Vec3;

public class BlockHandlerCarpentersLever
extends BlockHandlerBase {
    @Override
    public boolean shouldRender3DInInventory() {
        return false;
    }

    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4) {
        Block block2 = this.isSideCover ? BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering) : BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        this.renderLever(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
        return this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n);
    }

    public boolean renderLever(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = n4 & 7;
        boolean bl = (n4 & 8) > 0;
        Tessellator tessellator = renderBlocks.__aF;
        boolean bl2 = renderBlocks._b();
        float f = 0.25f;
        float f2 = 0.1875f;
        float f3 = 0.1875f;
        if (n5 == 5) {
            renderBlocks._a(0.5f - f2, 0.0, (double)(0.5f - f), (double)(0.5f + f2), (double)f3, (double)(0.5f + f));
        } else if (n5 == 6) {
            renderBlocks._a(0.5f - f, 0.0, (double)(0.5f - f2), (double)(0.5f + f), (double)f3, (double)(0.5f + f2));
        } else if (n5 == 4) {
            renderBlocks._a(0.5f - f2, 0.5f - f, (double)(1.0f - f3), (double)(0.5f + f2), (double)(0.5f + f), 1.0);
        } else if (n5 == 3) {
            renderBlocks._a(0.5f - f2, 0.5f - f, 0.0, (double)(0.5f + f2), (double)(0.5f + f), (double)f3);
        } else if (n5 == 2) {
            renderBlocks._a(1.0f - f3, 0.5f - f, (double)(0.5f - f2), 1.0, (double)(0.5f + f), (double)(0.5f + f2));
        } else if (n5 == 1) {
            renderBlocks._a(0.0, 0.5f - f, (double)(0.5f - f2), (double)f3, (double)(0.5f + f), (double)(0.5f + f2));
        } else if (n5 == 0) {
            renderBlocks._a(0.5f - f, 1.0f - f3, (double)(0.5f - f2), (double)(0.5f + f), 1.0, (double)(0.5f + f2));
        } else if (n5 == 7) {
            renderBlocks._a(0.5f - f2, 1.0f - f3, (double)(0.5f - f), (double)(0.5f + f2), 1.0, (double)(0.5f + f));
        }
        renderBlocks._d = true;
        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        renderBlocks._d = false;
        if (!bl2) {
            renderBlocks._a();
        }
        tessellator.setBrightness(block.getMixedBrightnessForBlock(renderBlocks._a, n, n2, n3));
        float f4 = 1.0f;
        if (Block.lightValue[block.blockID] > 0) {
            f4 = 1.0f;
        }
        tessellator.setColorOpaque_F(f4, f4, f4);
        Icon icon = IconHandler.icon_lever;
        if (renderBlocks._b()) {
            icon = renderBlocks._b;
        }
        double d = icon.getMinU();
        double d2 = icon.getMinV();
        double d3 = icon.getMaxU();
        double d4 = icon.getMaxV();
        Vec3[] vec3Array = new Vec3[8];
        float f5 = 0.0625f;
        float f6 = 0.0625f;
        float f7 = 0.625f;
        vec3Array[0] = renderBlocks._a.getWorldVec3Pool()._a(-f5, 0.0, -f6);
        vec3Array[1] = renderBlocks._a.getWorldVec3Pool()._a(f5, 0.0, -f6);
        vec3Array[2] = renderBlocks._a.getWorldVec3Pool()._a(f5, 0.0, f6);
        vec3Array[3] = renderBlocks._a.getWorldVec3Pool()._a(-f5, 0.0, f6);
        vec3Array[4] = renderBlocks._a.getWorldVec3Pool()._a(-f5, f7, -f6);
        vec3Array[5] = renderBlocks._a.getWorldVec3Pool()._a(f5, f7, -f6);
        vec3Array[6] = renderBlocks._a.getWorldVec3Pool()._a(f5, f7, f6);
        vec3Array[7] = renderBlocks._a.getWorldVec3Pool()._a(-f5, f7, f6);
        for (int i = 0; i < 8; ++i) {
            if (bl) {
                vec3Array[i]._e -= 0.0625;
                vec3Array[i]._a(0.69813174f);
            } else {
                vec3Array[i]._e += 0.0625;
                vec3Array[i]._a(-0.69813174f);
            }
            if (n5 == 0 || n5 == 7) {
                vec3Array[i]._c((float)Math.PI);
            }
            if (n5 == 6 || n5 == 0) {
                vec3Array[i]._b(1.5707964f);
            }
            if (n5 > 0 && n5 < 5) {
                vec3Array[i]._d -= 0.375;
                vec3Array[i]._a(1.5707964f);
                if (n5 == 4) {
                    vec3Array[i]._b(0.0f);
                }
                if (n5 == 3) {
                    vec3Array[i]._b((float)Math.PI);
                }
                if (n5 == 2) {
                    vec3Array[i]._b(1.5707964f);
                }
                if (n5 == 1) {
                    vec3Array[i]._b(-1.5707964f);
                }
                vec3Array[i]._c += (double)n + 0.5;
                vec3Array[i]._d += (double)((float)n2 + 0.5f);
                vec3Array[i]._e += (double)n3 + 0.5;
                continue;
            }
            if (n5 != 0 && n5 != 7) {
                vec3Array[i]._c += (double)n + 0.5;
                vec3Array[i]._d += (double)((float)n2 + 0.125f);
                vec3Array[i]._e += (double)n3 + 0.5;
                continue;
            }
            vec3Array[i]._c += (double)n + 0.5;
            vec3Array[i]._d += (double)((float)n2 + 0.875f);
            vec3Array[i]._e += (double)n3 + 0.5;
        }
        Vec3 vec3 = null;
        Vec3 vec32 = null;
        Vec3 vec33 = null;
        Vec3 vec34 = null;
        for (int i = 0; i < 6; ++i) {
            if (i == 0) {
                d = icon.getInterpolatedU(7.0);
                d2 = icon.getInterpolatedV(6.0);
                d3 = icon.getInterpolatedU(9.0);
                d4 = icon.getInterpolatedV(8.0);
            } else if (i == 2) {
                d = icon.getInterpolatedU(7.0);
                d2 = icon.getInterpolatedV(6.0);
                d3 = icon.getInterpolatedU(9.0);
                d4 = icon.getMaxV();
            }
            if (i == 0) {
                vec3 = vec3Array[0];
                vec32 = vec3Array[1];
                vec33 = vec3Array[2];
                vec34 = vec3Array[3];
            } else if (i == 1) {
                vec3 = vec3Array[7];
                vec32 = vec3Array[6];
                vec33 = vec3Array[5];
                vec34 = vec3Array[4];
            } else if (i == 2) {
                vec3 = vec3Array[1];
                vec32 = vec3Array[0];
                vec33 = vec3Array[4];
                vec34 = vec3Array[5];
            } else if (i == 3) {
                vec3 = vec3Array[2];
                vec32 = vec3Array[1];
                vec33 = vec3Array[5];
                vec34 = vec3Array[6];
            } else if (i == 4) {
                vec3 = vec3Array[3];
                vec32 = vec3Array[2];
                vec33 = vec3Array[6];
                vec34 = vec3Array[7];
            } else if (i == 5) {
                vec3 = vec3Array[0];
                vec32 = vec3Array[3];
                vec33 = vec3Array[7];
                vec34 = vec3Array[4];
            }
            tessellator.addVertexWithUV(vec3._c, vec3._d, vec3._e, d, d4);
            tessellator.addVertexWithUV(vec32._c, vec32._d, vec32._e, d3, d4);
            tessellator.addVertexWithUV(vec33._c, vec33._d, vec33._e, d3, d2);
            tessellator.addVertexWithUV(vec34._c, vec34._d, vec34._e, d, d2);
        }
        return true;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockCarpentersStairs;
import carpentersblocks.data.Stairs;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersStairs
extends BlockHandlerBase {
    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
        Tessellator tessellator = renderBlocks.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        renderBlocks._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        for (int i = 0; i < 2; ++i) {
            switch (i) {
                case 0: {
                    renderBlocks._a(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
                    break;
                }
                case 1: {
                    renderBlocks._a(0.5, 0.5, 0.0, 1.0, 1.0, 1.0);
                }
            }
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            renderBlocks._a(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(0));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            renderBlocks._b(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(1));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            renderBlocks._c(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            renderBlocks._d(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(3));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            renderBlocks._e(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(4));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            renderBlocks._f(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(5));
            tessellator.draw();
        }
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }

    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4) {
        Block block2 = this.isSideCover ? BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering) : BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        Stairs stairs = Stairs.stairsList[n5];
        BlockCarpentersStairs blockCarpentersStairs = (BlockCarpentersStairs)BlockHandler.blockCarpentersStairs;
        for (int i = 0; i < 3; ++i) {
            float[] fArray = blockCarpentersStairs.genBounds(i, stairs);
            if (fArray == null) continue;
            blockCarpentersStairs.setBlockBounds(fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5]);
            renderBlocks._a(fArray[0], fArray[1], (double)fArray[2], (double)fArray[3], (double)fArray[4], (double)fArray[5]);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
        }
        return this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n);
    }

    @Override
    protected boolean renderSideCovers(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4) {
        boolean bl = false;
        this.isSideCover = true;
        renderBlocks._d = true;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        Stairs stairs = Stairs.stairsList[n5];
        BlockCarpentersStairs blockCarpentersStairs = (BlockCarpentersStairs)BlockHandler.blockCarpentersStairs;
        for (int i = 0; i < 3; ++i) {
            float[] fArray = blockCarpentersStairs.genBounds(i, stairs);
            if (fArray == null) continue;
            for (int j = 0; j < 6; ++j) {
                Block block2 = BlockProperties.getCoverBlock(tECarpentersBlock, j);
                this.coverRendering = j;
                if (!BlockProperties.hasCover(tECarpentersBlock, j) || !this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n) && !this.shouldRenderPattern(tECarpentersBlock, n)) continue;
                renderBlocks._a(fArray[0], fArray[1], (double)fArray[2], (double)fArray[3], (double)fArray[4], (double)fArray[5]);
                int[] nArray = this.setSideCoverRenderBounds(BlockHandlerBase.tempRenderOffset, tECarpentersBlock, renderBlocks, n2, n3, n4, j);
                if (!this.clipSideCoverBoundsBasedOnState(renderBlocks, n5, i, j)) continue;
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, nArray[0], nArray[1], nArray[2]);
                bl = true;
            }
        }
        renderBlocks._d = false;
        this.coverRendering = 6;
        this.isSideCover = false;
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean clipSideCoverBoundsBasedOnState(RenderBlocks renderBlocks, int n, int n2, int n3) {
        block177: {
            ++n2;
            switch (n) {
                case 0: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            renderBlocks._l += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                    }
                    return true;
                }
                case 1: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            renderBlocks._m -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                    }
                    return true;
                }
                case 2: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            renderBlocks._m -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                    }
                    return true;
                }
                case 3: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            renderBlocks._l += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                    }
                    return true;
                }
                case 4: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2) return true;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 3;
                        }
                    }
                    return true;
                }
                case 5: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3) return true;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 2;
                        }
                    }
                    return true;
                }
                case 6: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                    }
                    return true;
                }
                case 7: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                    }
                    return true;
                }
                case 8: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2) return true;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 3;
                        }
                    }
                    return true;
                }
                case 9: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3) return true;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 2;
                        }
                    }
                    return true;
                }
                case 10: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                    }
                    return true;
                }
                case 11: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                    }
                    return true;
                }
                case 12: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            renderBlocks._m -= 0.5;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 2) {
                                renderBlocks._j += 0.5;
                                return true;
                            } else {
                                if (n3 != 4) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 3 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 13: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            renderBlocks._m -= 0.5;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 2) {
                                renderBlocks._k -= 0.5;
                                return true;
                            } else {
                                if (n3 != 4) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 3 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 14: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            renderBlocks._m -= 0.5;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 2) {
                                renderBlocks._j += 0.5;
                                return true;
                            } else {
                                if (n3 != 5) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 3 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 15: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            renderBlocks._m -= 0.5;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 2) {
                                renderBlocks._k -= 0.5;
                                return true;
                            } else {
                                if (n3 != 5) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 3 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 16: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            renderBlocks._l += 0.5;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 3) {
                                renderBlocks._j += 0.5;
                                return true;
                            } else {
                                if (n3 != 5) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 2 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 17: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            renderBlocks._l += 0.5;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 3) {
                                renderBlocks._k -= 0.5;
                                return true;
                            } else {
                                if (n3 != 5) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 2 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 18: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            renderBlocks._l += 0.5;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 3) {
                                renderBlocks._j += 0.5;
                                return true;
                            } else {
                                if (n3 != 4) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 2 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 19: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            renderBlocks._l += 0.5;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 3) {
                                renderBlocks._k -= 0.5;
                                return true;
                            } else {
                                if (n3 != 4) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 2 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 20: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3 && n3 != 4) return true;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                        case 3: {
                            return n3 != 2 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 21: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3 && n3 != 4) return true;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                        case 3: {
                            return n3 != 2 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 22: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3 && n3 != 5) return true;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                        case 3: {
                            return n3 != 2 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 23: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3 && n3 != 5) return true;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                        case 3: {
                            return n3 != 2 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 24: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2 && n3 != 5) return true;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                        case 3: {
                            return n3 != 3 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 25: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2 && n3 != 5) return true;
                            renderBlocks._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                        case 3: {
                            return n3 != 3 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 26: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2 && n3 != 4) return true;
                            renderBlocks._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                        case 3: {
                            return n3 != 3 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 27: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2 && n3 != 4) return true;
                            renderBlocks._k -= 0.5;
                            break block177;
                        }
                        case 2: {
                            if (n3 != 5) return true;
                            return false;
                        }
                        case 3: {
                            if (n3 != 3 && n3 != 4) return true;
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}


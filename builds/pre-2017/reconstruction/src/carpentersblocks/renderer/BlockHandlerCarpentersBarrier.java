/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockCarpentersBarrier;
import carpentersblocks.data.Barrier;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersBarrier
extends BlockHandlerBase {
    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
        Tessellator tessellator = renderBlocks.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        for (int i = 0; i < 4; ++i) {
            switch (i) {
                case 0: {
                    renderBlocks._a(0.125, 0.0, 0.375, 0.375, 1.0, 0.625);
                    break;
                }
                case 1: {
                    renderBlocks._a(0.625, 0.0, 0.375, 0.875, 1.0, 0.625);
                    break;
                }
                case 2: {
                    renderBlocks._a(0.0, 0.8125, 0.4375, 1.0, 0.9375, 0.5625);
                    break;
                }
                case 3: {
                    renderBlocks._a(0.0, 0.4375, 0.4375, 1.0, 0.5625, 0.5625);
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
        int n6 = Barrier.getType(n5);
        switch (n6) {
            case 4: {
                this.renderPicketFence(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            case 5: {
                this.renderVerticalPlankFence(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            case 6: {
                this.renderWall(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            default: {
                this.renderFence(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
            }
        }
        return this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n);
    }

    private boolean isPostAt(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.getBlockId(n, n2, n3) != BlockHandler.blockCarpentersBarrierID) {
            return false;
        }
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        boolean bl = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, iBlockAccess, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, iBlockAccess, n + 1, n2, n3, ForgeDirection.WEST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, iBlockAccess, n, n2 + 1, n3, ForgeDirection.UP);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, iBlockAccess, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, iBlockAccess, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl6 = bl && bl2;
        boolean bl7 = bl4 && bl5;
        return Barrier.getPost(BlockProperties.getData(tECarpentersBlock)) == 1 || bl6 == bl7 || bl3 || (bl || bl2) && (bl4 || bl5);
    }

    public boolean renderFence(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
        float f;
        boolean bl;
        int n4 = BlockProperties.getData(tECarpentersBlock);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n + 1, n2, n3, ForgeDirection.WEST);
        blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 + 1, n3, ForgeDirection.DOWN);
        blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 - 1, n3, ForgeDirection.UP);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2, n3 + 1, ForgeDirection.NORTH);
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        f6 = 0.375f;
        f7 = 0.625f;
        f5 = 1.0f;
        float f8 = (float)Barrier.getType(n4) * 0.0625f;
        boolean bl6 = bl = Barrier.getType(n4) == 3;
        if (this.isPostAt(renderBlocks._a, n, n2, n3) || this.isPostAt(renderBlocks._a, n, n2 + 1, n3)) {
            renderBlocks._a(f6, 0.0, (double)f6, (double)f7, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        f6 = 0.4375f;
        f7 = 0.5625f;
        f5 = 0.9375f;
        f4 = 0.75f;
        f2 = bl2 ? 0.0f : f6;
        f3 = bl3 ? 1.0f : f7;
        float f9 = bl4 ? 0.0f : f6;
        float f10 = f = bl5 ? 1.0f : f7;
        if (bl2 || bl3) {
            renderBlocks._a(f2, bl ? 0.1875 : (double)(f4 - f8), (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl4 || bl5) {
            renderBlocks._a(f6, bl ? 0.1875 : (double)(f4 - f8), (double)f9, (double)f7, (double)f5, (double)f);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (!bl) {
            f4 = 0.375f;
            f5 = 0.5625f;
            if (bl2 || bl3) {
                renderBlocks._a(f2, f4 - f8, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
            if (bl4 || bl5) {
                renderBlocks._a(f6, f4 - f8, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        }
        blockCarpentersBarrier.setBlockBoundsBasedOnState(renderBlocks._a, n, n2, n3);
        return true;
    }

    public boolean renderPicketFence(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
        float f;
        int n4 = BlockProperties.getData(tECarpentersBlock);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean bl = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n + 1, n2, n3, ForgeDirection.WEST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 + 1, n3, ForgeDirection.DOWN);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 - 1, n3, ForgeDirection.UP);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl6 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl7 = renderBlocks._a.getBlockId(n, n2 + 1, n3) == BlockHandler.blockCarpentersBarrierID;
        boolean bl8 = renderBlocks._a.getBlockId(n, n2 - 1, n3) == BlockHandler.blockCarpentersBarrierID;
        f6 = 0.4375f;
        f7 = 0.5625f;
        float f8 = f5 = bl3 ? 1.0f : 0.6875f;
        if (this.isPostAt(renderBlocks._a, n, n2, n3)) {
            renderBlocks._a(f6, 0.0, (double)f6, (double)f7, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        f6 = 0.4375f;
        f7 = 0.5625f;
        f5 = 0.6875f;
        f4 = 0.625f;
        f2 = bl ? 0.0f : f6;
        f3 = bl2 ? 1.0f : f7;
        float f9 = bl5 ? 0.0f : f6;
        float f10 = f = bl6 ? 1.0f : f7;
        if (!bl7) {
            if (bl || bl2) {
                renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
            if (bl5 || bl6) {
                renderBlocks._a(f6, f4, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        }
        if (!bl8) {
            f4 = 0.1875f;
            f5 = 0.25f;
            if (bl || bl2) {
                renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
            if (bl5 || bl6) {
                renderBlocks._a(f6, f4, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        }
        f4 = bl4 ? 0.0f : 0.0625f;
        f5 = 1.0f;
        f2 = 0.4375f;
        f3 = 0.5625f;
        f6 = 0.5625f;
        f7 = 0.625f;
        if (!bl6) {
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        f6 -= 0.1875f;
        f7 -= 0.1875f;
        if (!bl5) {
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        f6 = 0.4375f;
        f7 = 0.5625f;
        f2 = 0.5625f;
        f3 = 0.625f;
        if (!bl2) {
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        f2 -= 0.1875f;
        f3 -= 0.1875f;
        if (!bl) {
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl) {
            f5 = bl3 ? 1.0f : 0.875f;
            f3 = 0.3125f;
            f2 = 0.1875f;
            f7 = 0.625f;
            f6 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            f5 = bl3 ? 1.0f : 0.8125f;
            f3 = 0.0625f;
            f2 = 0.0f;
            f7 = 0.625f;
            f6 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl2) {
            f5 = bl3 ? 1.0f : 0.875f;
            f2 = 0.6875f;
            f3 = 0.8125f;
            f7 = 0.625f;
            f6 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            f5 = bl3 ? 1.0f : 0.8125f;
            f2 = 0.9375f;
            f3 = 1.0f;
            f7 = 0.625f;
            f6 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl5) {
            f5 = bl3 ? 1.0f : 0.875f;
            f7 = 0.3125f;
            f6 = 0.1875f;
            f3 = 0.625f;
            f2 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            f5 = bl3 ? 1.0f : 0.8125f;
            f7 = 0.0625f;
            f6 = 0.0f;
            f3 = 0.625f;
            f2 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl6) {
            f5 = bl3 ? 1.0f : 0.875f;
            f6 = 0.6875f;
            f7 = 0.8125f;
            f3 = 0.625f;
            f2 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            f5 = bl3 ? 1.0f : 0.8125f;
            f6 = 0.9375f;
            f7 = 1.0f;
            f3 = 0.625f;
            f2 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        blockCarpentersBarrier.setBlockBoundsBasedOnState(renderBlocks._a, n, n2, n3);
        return true;
    }

    public boolean renderWall(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
        BlockProperties.getData(tECarpentersBlock);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        boolean bl = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n + 1, n2, n3, ForgeDirection.WEST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 + 1, n3, ForgeDirection.DOWN);
        blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 - 1, n3, ForgeDirection.UP);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl6 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 + 1, n3 - 1, ForgeDirection.SOUTH);
        boolean bl7 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 + 1, n3 + 1, ForgeDirection.NORTH);
        boolean bl8 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n - 1, n2 + 1, n3, ForgeDirection.EAST);
        boolean bl9 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n + 1, n2 + 1, n3, ForgeDirection.WEST);
        if (this.isPostAt(renderBlocks._a, n, n2, n3) || this.isPostAt(renderBlocks._a, n, n2 + 1, n3)) {
            renderBlocks._a(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl) {
            renderBlocks._a(0.0, 0.0, 0.3125, 0.5, bl3 && bl8 ? 1.0 : 0.8125, 0.6875);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl2) {
            renderBlocks._a(0.5, 0.0, 0.3125, 1.0, bl3 && bl9 ? 1.0 : 0.8125, 0.6875);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl4) {
            renderBlocks._a(0.3125, 0.0, 0.0, 0.6875, bl3 && bl6 ? 1.0 : 0.8125, 0.5);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl5) {
            renderBlocks._a(0.3125, 0.0, 0.5, 0.6875, bl3 && bl7 ? 1.0 : 0.8125, 1.0);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        return true;
    }

    public boolean renderVerticalPlankFence(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
        float f;
        BlockProperties.getData(tECarpentersBlock);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean bl = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n + 1, n2, n3, ForgeDirection.WEST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 + 1, n3, ForgeDirection.DOWN);
        blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2 - 1, n3, ForgeDirection.UP);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, renderBlocks._a, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl6 = renderBlocks._a.getBlockId(n, n2 + 1, n3) == BlockHandler.blockCarpentersBarrierID;
        boolean bl7 = renderBlocks._a.getBlockId(n, n2 - 1, n3) == BlockHandler.blockCarpentersBarrierID;
        f5 = 0.875f;
        if (bl3) {
            f5 = 1.0f;
        }
        f6 = 0.4375f;
        f7 = 0.5625f;
        if (this.isPostAt(renderBlocks._a, n, n2, n3)) {
            renderBlocks._a(f6, 0.0, (double)f6, (double)f7, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        float f8 = 1.0E-4f;
        f6 = 0.4375f + f8;
        f7 = 0.5625f - f8;
        f5 = 0.875f;
        f4 = 0.75f;
        f2 = bl ? 0.0f : f7;
        f3 = bl2 ? 1.0f : f6;
        float f9 = bl4 ? 0.0f : f6;
        float f10 = f = bl5 ? 1.0f : f7;
        if (!bl6) {
            if (bl || bl2) {
                renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
            if (bl4 || bl5) {
                renderBlocks._a(f6, f4, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        }
        if (!bl7) {
            f4 = 0.125f;
            f5 = 0.25f;
            if (bl || bl2) {
                renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
            if (bl4 || bl5) {
                renderBlocks._a(f6, f4, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        }
        f4 = 0.0f;
        f5 = 1.0f;
        if (bl) {
            f3 = 0.5f;
            f2 = 0.3125f;
            f7 = 0.625f;
            f6 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            f3 = 0.1875f;
            f2 = 0.0f;
            f7 = 0.625f;
            f6 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl2) {
            f2 = 0.5f;
            f3 = 0.6875f;
            f7 = 0.625f;
            f6 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            f2 = 0.8125f;
            f3 = 1.0f;
            f7 = 0.625f;
            f6 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl4) {
            f7 = 0.5f;
            f6 = 0.3125f;
            f3 = 0.625f;
            f2 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            f7 = 0.1875f;
            f6 = 0.0f;
            f3 = 0.625f;
            f2 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl5) {
            f6 = 0.5f;
            f7 = 0.6875f;
            f3 = 0.625f;
            f2 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            f6 = 0.8125f;
            f7 = 1.0f;
            f3 = 0.625f;
            f2 = 0.5625f;
            renderBlocks._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        blockCarpentersBarrier.setBlockBoundsBasedOnState(renderBlocks._a, n, n2, n3);
        return true;
    }
}


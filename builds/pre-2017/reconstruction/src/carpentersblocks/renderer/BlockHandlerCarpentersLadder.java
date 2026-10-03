/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersLadder
extends BlockHandlerBase {
    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
        Tessellator tessellator = renderBlocks.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        for (int i = 0; i < 6; ++i) {
            switch (i) {
                case 0: {
                    renderBlocks._a(0.0, 0.0, 0.375, 0.125, 1.0, 0.625);
                    break;
                }
                case 1: {
                    renderBlocks._a(0.875, 0.0, 0.375, 1.0, 1.0, 0.625);
                    break;
                }
                case 2: {
                    renderBlocks._a(0.125, 0.125, 0.4375, 0.875, 0.1875, 0.5625);
                    break;
                }
                case 3: {
                    renderBlocks._a(0.125, 0.375, 0.4375, 0.875, 0.4375, 0.5625);
                    break;
                }
                case 4: {
                    renderBlocks._a(0.125, 0.625, 0.4375, 0.875, 0.6875, 0.5625);
                    break;
                }
                case 5: {
                    renderBlocks._a(0.125, 0.875, 0.4375, 0.875, 0.9375, 0.5625);
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
        this.disableAO = true;
        int n5 = renderBlocks._a.getBlockMetadata(n2, n3, n4);
        Block block2 = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        double d = 0.0;
        double d2 = 1.0;
        double d3 = 0.0;
        double d4 = 1.0;
        boolean bl = tECarpentersBlock.worldObj.getBlockId(n2 - 1, n3, n4) == block.blockID && tECarpentersBlock.worldObj.getBlockMetadata(n2 - 1, n3, n4) == n5;
        boolean bl2 = tECarpentersBlock.worldObj.getBlockId(n2 + 1, n3, n4) == block.blockID && tECarpentersBlock.worldObj.getBlockMetadata(n2 + 1, n3, n4) == n5;
        boolean bl3 = tECarpentersBlock.worldObj.getBlockId(n2, n3, n4 - 1) == block.blockID && tECarpentersBlock.worldObj.getBlockMetadata(n2, n3, n4 - 1) == n5;
        boolean bl4 = tECarpentersBlock.worldObj.getBlockId(n2, n3, n4 + 1) == block.blockID && tECarpentersBlock.worldObj.getBlockMetadata(n2, n3, n4 + 1) == n5;
        switch (n5) {
            case 0: {
                if (!bl) {
                    renderBlocks._a(0.0, 0.0, 0.375, 0.125, 1.0, 0.625);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                if (!bl2) {
                    renderBlocks._a(0.875, 0.0, 0.375, 1.0, 1.0, 0.625);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                d = bl ? 0.0 : 0.125;
                d2 = bl2 ? 1.0 : 0.875;
                renderBlocks._a(d, 0.125, 0.4375, d2, 0.1875, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(d, 0.375, 0.4375, d2, 0.4375, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(d, 0.625, 0.4375, d2, 0.6875, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(d, 0.875, 0.4375, d2, 0.9375, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            case 1: {
                if (!bl3) {
                    renderBlocks._a(0.375, 0.0, 0.0, 0.625, 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                if (!bl4) {
                    renderBlocks._a(0.375, 0.0, 0.875, 0.625, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                d3 = bl3 ? 0.0 : 0.125;
                d4 = bl4 ? 1.0 : 0.875;
                renderBlocks._a(0.4375, 0.125, d3, 0.5625, 0.1875, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(0.4375, 0.375, d3, 0.5625, 0.4375, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(0.4375, 0.625, d3, 0.5625, 0.6875, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(0.4375, 0.875, d3, 0.5625, 0.9375, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            case 2: {
                if (!bl) {
                    renderBlocks._a(0.0, 0.0, 0.8125, 0.125, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                if (!bl2) {
                    renderBlocks._a(0.875, 0.0, 0.8125, 1.0, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                d = bl ? 0.0 : 0.125;
                d2 = bl2 ? 1.0 : 0.875;
                renderBlocks._a(d, 0.125, 0.875, d2, 0.1875, 1.0);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(d, 0.375, 0.875, d2, 0.4375, 1.0);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(d, 0.625, 0.875, d2, 0.6875, 1.0);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(d, 0.875, 0.875, d2, 0.9375, 1.0);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            case 3: {
                if (!bl) {
                    renderBlocks._a(0.0, 0.0, 0.0, 0.125, 1.0, 0.1875);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                if (!bl2) {
                    renderBlocks._a(0.875, 0.0, 0.0, 1.0, 1.0, 0.1875);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                d = bl ? 0.0 : 0.125;
                d2 = bl2 ? 1.0 : 0.875;
                renderBlocks._a(d, 0.125, 0.0, d2, 0.1875, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(d, 0.375, 0.0, d2, 0.4375, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(d, 0.625, 0.0, d2, 0.6875, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(d, 0.875, 0.0, d2, 0.9375, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            case 4: {
                if (!bl3) {
                    renderBlocks._a(0.8125, 0.0, 0.0, 1.0, 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                if (!bl4) {
                    renderBlocks._a(0.8125, 0.0, 0.875, 1.0, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                d3 = bl3 ? 0.0 : 0.125;
                d4 = bl4 ? 1.0 : 0.875;
                renderBlocks._a(0.875, 0.125, d3, 1.0, 0.1875, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(0.875, 0.375, d3, 1.0, 0.4375, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(0.875, 0.625, d3, 1.0, 0.6875, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(0.875, 0.875, d3, 1.0, 0.9375, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            case 5: {
                if (!bl3) {
                    renderBlocks._a(0.0, 0.0, 0.0, 0.1875, 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                if (!bl4) {
                    renderBlocks._a(0.0, 0.0, 0.875, 0.1875, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                }
                d3 = bl3 ? 0.0 : 0.125;
                d4 = bl4 ? 1.0 : 0.875;
                renderBlocks._a(0.0, 0.125, d3, 0.1875, 0.1875, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(0.0, 0.375, d3, 0.1875, 0.4375, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(0.0, 0.625, d3, 0.1875, 0.6875, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                renderBlocks._a(0.0, 0.875, d3, 0.1875, 0.9375, d4);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
            }
        }
        this.disableAO = false;
        return this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n);
    }
}


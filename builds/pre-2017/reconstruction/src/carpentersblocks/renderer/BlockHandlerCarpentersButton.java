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

public class BlockHandlerCarpentersButton
extends BlockHandlerBase {
    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
        Tessellator tessellator = renderBlocks.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        renderBlocks._a(0.3125, 0.375, 0.375, 0.6875, 0.625, 0.625);
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
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }

    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4) {
        Block block2 = this.isSideCover ? BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering) : BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        renderBlocks._d = true;
        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
        renderBlocks._d = false;
        return this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n);
    }
}


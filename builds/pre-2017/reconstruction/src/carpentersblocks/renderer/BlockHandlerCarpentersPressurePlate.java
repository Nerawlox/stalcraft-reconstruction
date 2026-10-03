/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.util.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersPressurePlate
extends BlockHandlerBase {
    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
        Tessellator tessellator = renderBlocks.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        renderBlocks._a(0.0, 0.375, 0.0, 1.0, 0.625, 1.0);
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
        renderBlocks._c(block, 0.0, 0.0, 0.0, BlockHandler.blockCarpentersBarrier.getBlockTextureFromSide(2));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 0.0f, 1.0f);
        renderBlocks._d(block, 0.0, 0.0, 0.0, BlockHandler.blockCarpentersBarrier.getBlockTextureFromSide(3));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0f, 0.0f, 0.0f);
        renderBlocks._e(block, 0.0, 0.0, 0.0, BlockHandler.blockCarpentersBarrier.getBlockTextureFromSide(4));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0f, 0.0f, 0.0f);
        renderBlocks._f(block, 0.0, 0.0, 0.0, BlockHandler.blockCarpentersBarrier.getBlockTextureFromSide(5));
        tessellator.draw();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }
}


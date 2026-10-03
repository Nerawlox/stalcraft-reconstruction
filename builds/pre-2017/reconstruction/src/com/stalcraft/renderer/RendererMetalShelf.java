/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer;

import com.stalcraft.tile.TileEntityMetalShelf;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RendererMetalShelf
extends TileEntitySpecialRenderer {
    protected IModelCustom model = AdvancedModelLoader.loadModel("/assets/stalcraft/models/metal_shelf.mcsa");
    private ResourceLocation texture = new ResourceLocation("stalcraft", "textures/blocks/woodplanks.dds");

    public RendererMetalShelf() {
        fmib._b(this.texture);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this.renderTileEntity((TileEntityMetalShelf)tileEntity, d, d2, d3, f);
    }

    public void renderTileEntity(TileEntityMetalShelf tileEntityMetalShelf, double d, double d2, double d3, float f) {
        int n = tileEntityMetalShelf.worldObj.getBlockMetadata(tileEntityMetalShelf.xCoord, tileEntityMetalShelf.yCoord, tileEntityMetalShelf.zCoord);
        int n2 = n * 90;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.537f, (float)d2 + 2.0f, (float)d3 + 0.502f);
        GL11.glRotatef(-180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(n2, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(1.0f, 1.5f, 1.0f);
        GL11.glTranslatef(0.0f, -1.4625f, 0.0f);
        this.bindTexture(this.texture);
        this.model.renderAll();
        GL11.glPopMatrix();
    }
}


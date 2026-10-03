/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer;

import com.stalcraft.tile.TileEntityCabinet;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RendererCabinet
extends TileEntitySpecialRenderer {
    protected IModelCustom model = AdvancedModelLoader.loadModel("/assets/stalcraft/models/cabinet.mcsa");
    private ResourceLocation textureTrashbin = new ResourceLocation("stalcraft", "textures/blocks/trashbin.dds");
    private ResourceLocation textureCabinet = new ResourceLocation("stalcraft", "textures/blocks/cabinet.dds");

    public RendererCabinet() {
        fmib._b(this.textureTrashbin);
        fmib._b(this.textureCabinet);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this.renderTileEntity((TileEntityCabinet)tileEntity, d, d2, d3, f);
    }

    public void renderTileEntity(TileEntityCabinet tileEntityCabinet, double d, double d2, double d3, float f) {
        int n = tileEntityCabinet.worldObj.getBlockMetadata(tileEntityCabinet.xCoord, tileEntityCabinet.yCoord, tileEntityCabinet.zCoord);
        int n2 = n * 90;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.532f, (float)d2 + 2.264f, (float)d3 + 0.458f);
        GL11.glRotatef(-180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(n2, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(1.0f, 1.5f, 1.0f);
        GL11.glTranslatef(0.0f, -1.4625f, 0.0f);
        this.bindTexture(this.textureTrashbin);
        this.model.renderOnly("body");
        this.bindTexture(this.textureCabinet);
        this.model.renderOnly("doors");
        GL11.glPopMatrix();
    }
}


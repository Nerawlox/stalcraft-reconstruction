/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer;

import com.stalcraft.tile.TileEntityConcreteWall;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RendererConcreteWall
extends TileEntitySpecialRenderer {
    protected IModelCustom model = AdvancedModelLoader.loadModel("/assets/stalcraft/models/concrete_wall.mcsa");
    private ResourceLocation texture = new ResourceLocation("stalcraft", "textures/blocks/concretewall.dds");

    public RendererConcreteWall() {
        fmib._b(this.texture);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this.renderTileEntity((TileEntityConcreteWall)tileEntity, d, d2, d3, f);
    }

    public void renderTileEntity(TileEntityConcreteWall tileEntityConcreteWall, double d, double d2, double d3, float f) {
        int n = tileEntityConcreteWall.worldObj.getBlockMetadata(tileEntityConcreteWall.xCoord, tileEntityConcreteWall.yCoord, tileEntityConcreteWall.zCoord);
        int n2 = n * 90;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.537f, (float)d2 + 1.3f, (float)d3 + 0.502f);
        GL11.glRotatef(-180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(n2, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(1.0f, 0.686f, 1.0f);
        GL11.glTranslatef(0.0f, -1.4625f, 0.0f);
        this.bindTexture(this.texture);
        this.model.renderAll();
        GL11.glPopMatrix();
    }
}


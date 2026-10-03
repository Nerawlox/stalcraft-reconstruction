/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer;

import com.stalcraft.tile.TileEntityBlueShelf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RendererBlueShelf
extends htys {
    protected IModelCustom model = AdvancedModelLoader.loadModel("/assets/stalcraft/models/blue_shelf.mcsa");
    private ResourceLocation texture = new ResourceLocation("stalcraft", "textures/blocks/blueshelf.dds");

    public RendererBlueShelf() {
        fmib._b(this.texture);
    }

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        this.renderTileEntity((TileEntityBlueShelf)hurg2, d, d2, d3, f);
    }

    public void renderTileEntity(TileEntityBlueShelf tileEntityBlueShelf, double d, double d2, double d3, float f) {
        int n = tileEntityBlueShelf.field_70331_k.func_72805_g(tileEntityBlueShelf.field_70329_l, tileEntityBlueShelf.field_70330_m, tileEntityBlueShelf.field_70327_n);
        int n2 = n * 90;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.537f, (float)d2 + 1.4f, (float)d3 + 0.502f);
        GL11.glRotatef(-180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(n2, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -1.4625f, 0.0f);
        this.func_110628_a(this.texture);
        this.model.renderAll();
        GL11.glPopMatrix();
    }
}


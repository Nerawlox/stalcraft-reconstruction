/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer;

import com.stalcraft.tile.TileEntityUrn;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RendererUrn
extends htys {
    protected IModelCustom model = AdvancedModelLoader.loadModel("/assets/stalcraft/models/urn.mcsa");
    private ResourceLocation texture = new ResourceLocation("stalcraft", "textures/blocks/trashbin.dds");

    public RendererUrn() {
        fmib._b(this.texture);
    }

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        this.renderTileEntity((TileEntityUrn)hurg2, d, d2, d3, f);
    }

    public void renderTileEntity(TileEntityUrn tileEntityUrn, double d, double d2, double d3, float f) {
        int n = tileEntityUrn.field_70331_k.func_72805_g(tileEntityUrn.field_70329_l, tileEntityUrn.field_70330_m, tileEntityUrn.field_70327_n);
        int n2 = n * 90;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2 + 1.5f, (float)d3 + 0.5f);
        GL11.glRotatef(-180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(n2, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(1.0f, 1.0f, 1.5f);
        GL11.glTranslatef(0.0f, -1.4625f, 0.0f);
        this.func_110628_a(this.texture);
        this.model.renderAll();
        GL11.glPopMatrix();
    }
}


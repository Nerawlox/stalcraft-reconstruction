/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class TileEntitySpecialRenderer {
    public TileEntityRenderer tileEntityRenderer;

    public abstract void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8);

    public void bindTexture(ResourceLocation resourceLocation) {
        TextureManager textureManager = this.tileEntityRenderer._g;
        if (textureManager != null) {
            textureManager._a(resourceLocation);
        }
    }

    public void setTileEntityRenderer(TileEntityRenderer tileEntityRenderer) {
        this.tileEntityRenderer = tileEntityRenderer;
    }

    public void onWorldChange(World world) {
    }

    public FontRenderer getFontRenderer() {
        return this.tileEntityRenderer._a();
    }
}


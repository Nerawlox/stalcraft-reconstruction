/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.client.model.ModelCarpentryBench;
import org.lwjgl.opengl.GL11;

public class BlockCarpentryBenchRenderer
extends TileEntitySpecialRenderer {
    private static final ResourceLocation RES_NORMAL_SINGLE = new ResourceLocation("customnpcs", "textures/misc/CarpentryBench.png");
    private ModelCarpentryBench model = new ModelCarpentryBench();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        int n = tileEntity.worldObj.getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2 + 1.4f, (float)d3 + 0.5f);
        GL11.glScalef(0.95f, 0.95f, 0.95f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(90 * n, 0.0f, 1.0f, 0.0f);
        this.bindTexture(RES_NORMAL_SINGLE);
        this.model.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
}


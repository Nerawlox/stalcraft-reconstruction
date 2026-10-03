/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import noppes.npcs.CustomItems;
import noppes.npcs.client.model.ModelMailboxUS;
import noppes.npcs.client.model.ModelMailboxWow;
import org.lwjgl.opengl.GL11;

public class BlockMailboxRenderer
extends TileEntitySpecialRenderer
implements ISimpleBlockRenderingHandler {
    private static final ResourceLocation text1 = new ResourceLocation("customnpcs", "textures/misc/mailbox1.png");
    private static final ResourceLocation text2 = new ResourceLocation("customnpcs", "textures/misc/mailbox2.png");
    private ModelMailboxUS model = new ModelMailboxUS();
    private ModelMailboxWow model2 = new ModelMailboxWow();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        int n = tileEntity.worldObj.getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) | 4;
        int n2 = tileEntity.worldObj.getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) >> 2;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2 + 1.5f, (float)d3 + 0.5f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(90 * n, 0.0f, 1.0f, 0.0f);
        if (n2 == 0) {
            this.bindTexture(text1);
            this.model.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
        if (n2 == 1) {
            this.bindTexture(text2);
            this.model2.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
        GL11.glPopMatrix();
    }

    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.8f, 0.0f);
        GL11.glScalef(0.9f, 0.9f, 0.9f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        if (n == 0) {
            this.bindTexture(text1);
            this.model.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
        if (n == 1) {
            this.bindTexture(text2);
            this.model2.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4, RenderBlocks renderBlocks) {
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }

    @Override
    public int getRenderId() {
        return CustomItems.mailbox.getRenderType();
    }
}


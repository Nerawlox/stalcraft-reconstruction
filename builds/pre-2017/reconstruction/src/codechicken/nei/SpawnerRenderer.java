/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class SpawnerRenderer
implements IItemRenderer {
    @Override
    public boolean handleRenderType(ItemStack itemStack, IItemRenderer.ItemRenderType itemRenderType) {
        return true;
    }

    public void renderInventoryItem(RenderBlocks renderBlocks, ItemStack itemStack) {
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, Object ... objectArray) {
        switch (itemRenderType) {
            case EQUIPPED: 
            case EQUIPPED_FIRST_PERSON: {
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            }
            case INVENTORY: 
            case ENTITY: {
                this.renderInventoryItem((RenderBlocks)objectArray[0], itemStack);
            }
        }
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, IItemRenderer.ItemRendererHelper itemRendererHelper) {
        return true;
    }
}


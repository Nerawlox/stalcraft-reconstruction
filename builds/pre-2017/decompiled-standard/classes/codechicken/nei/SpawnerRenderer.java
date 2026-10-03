/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class SpawnerRenderer
implements IItemRenderer {
    @Override
    public boolean handleRenderType(cvzo cvzo2, IItemRenderer.ItemRenderType itemRenderType) {
        return true;
    }

    public void renderInventoryItem(htvc htvc2, cvzo cvzo2) {
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType itemRenderType, cvzo cvzo2, Object ... objectArray) {
        switch (itemRenderType) {
            case EQUIPPED: 
            case EQUIPPED_FIRST_PERSON: {
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            }
            case INVENTORY: 
            case ENTITY: {
                this.renderInventoryItem((htvc)objectArray[0], cvzo2);
            }
        }
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, cvzo cvzo2, IItemRenderer.ItemRendererHelper itemRendererHelper) {
        return true;
    }
}


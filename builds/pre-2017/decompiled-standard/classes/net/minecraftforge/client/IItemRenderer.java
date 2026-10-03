/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

public interface IItemRenderer {
    public boolean handleRenderType(cvzo var1, ItemRenderType var2);

    public boolean shouldUseRenderHelper(ItemRenderType var1, cvzo var2, ItemRendererHelper var3);

    public void renderItem(ItemRenderType var1, cvzo var2, Object ... var3);

    public static enum ItemRendererHelper {
        ENTITY_ROTATION,
        ENTITY_BOBBING,
        EQUIPPED_BLOCK,
        BLOCK_3D,
        INVENTORY_BLOCK;

    }

    public static enum ItemRenderType {
        ENTITY,
        EQUIPPED,
        EQUIPPED_FIRST_PERSON,
        INVENTORY,
        FIRST_PERSON_MAP;

    }
}


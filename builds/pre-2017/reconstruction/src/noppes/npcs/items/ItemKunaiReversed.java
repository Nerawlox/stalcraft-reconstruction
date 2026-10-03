/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.client.renderer.texture.IconRegister;
import noppes.npcs.CustomItems;
import noppes.npcs.items.ItemKunai;
import org.lwjgl.opengl.GL11;

public class ItemKunaiReversed
extends ItemKunai {
    public ItemKunaiReversed(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.4f, -0.9f, -0.4f);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = CustomItems.kunai.getIconFromDamage(0);
    }
}


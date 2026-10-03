/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.client.renderer.texture.IconRegister;
import noppes.npcs.items.ItemDagger;
import org.lwjgl.opengl.GL11;

public class ItemDaggerReversed
extends ItemDagger {
    private ItemDagger dagger;

    public ItemDaggerReversed(int n, ItemDagger itemDagger, txfz txfz2) {
        super(n, txfz2);
        this.dagger = itemDagger;
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.6f, 0.6f, 0.6f);
        GL11.glTranslatef(-0.26f, 0.5f, 0.26f);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 1.0f);
    }

    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = this.dagger.getIconFromDamage(0);
    }
}


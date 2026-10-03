/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.CustomItems;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemWand
extends ItemNpcInterface {
    public ItemWand(int n) {
        super(n);
        this.func_77637_a(CustomItems.tabMisc);
    }

    @Override
    public boolean func_77636_d(cvzo cvzo2) {
        return true;
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.54f, 0.54f, 0.54f);
        GL11.glTranslatef(0.0f, 0.4f, -0.04f);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.items.ItemMusic;
import org.lwjgl.opengl.GL11;

public class ItemBanjo
extends ItemMusic {
    public ItemBanjo(int n) {
        super(n);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.85f, 0.85f, 0.85f);
        GL11.glTranslatef(0.0f, 0.4f, 0.0f);
        GL11.glRotatef(-90.0f, -1.0f, 0.0f, 1.0f);
    }
}


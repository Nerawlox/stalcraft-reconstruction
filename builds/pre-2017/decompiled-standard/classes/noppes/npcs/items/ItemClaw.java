/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.items.ItemNpcWeaponInterface;
import org.lwjgl.opengl.GL11;

public class ItemClaw
extends ItemNpcWeaponInterface {
    public ItemClaw(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.6f, 0.6f, 0.6f);
        GL11.glTranslatef(-0.6f, 0.2f, 0.3f);
        GL11.glRotatef(90.0f, -1.0f, 0.0f, -1.0f);
        GL11.glRotatef(-6.0f, 0.0f, 1.0f, 0.0f);
    }
}


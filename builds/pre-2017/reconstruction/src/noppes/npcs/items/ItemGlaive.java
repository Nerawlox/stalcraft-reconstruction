/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.items.ItemNpcWeaponInterface;
import org.lwjgl.opengl.GL11;

public class ItemGlaive
extends ItemNpcWeaponInterface {
    public ItemGlaive(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public void renderSpecial() {
        GL11.glTranslatef(0.16f, -0.34f, -0.14f);
    }
}


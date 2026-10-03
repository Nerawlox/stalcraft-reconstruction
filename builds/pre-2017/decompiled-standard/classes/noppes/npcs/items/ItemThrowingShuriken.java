/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.items.ItemThrowingWeapon;
import org.lwjgl.opengl.GL11;

public class ItemThrowingShuriken
extends ItemThrowingWeapon {
    public ItemThrowingShuriken(int n) {
        super(n);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        GL11.glTranslatef(-0.25f, 0.2f, 0.3f);
    }

    @Override
    public boolean func_77629_n_() {
        return true;
    }
}


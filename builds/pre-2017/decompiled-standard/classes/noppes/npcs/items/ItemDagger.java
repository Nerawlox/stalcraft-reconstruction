/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.items.ItemNpcWeaponInterface;
import org.lwjgl.opengl.GL11;

public class ItemDagger
extends ItemNpcWeaponInterface {
    public ItemDagger(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.6f, 0.6f, 0.6f);
        GL11.glTranslatef(-0.05f, 0.32f, 0.05f);
    }

    @Override
    public boolean func_77629_n_() {
        return true;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.items.ItemNpcWeaponInterface;
import org.lwjgl.opengl.GL11;

public class ItemScythe
extends ItemNpcWeaponInterface {
    public ItemScythe(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public void renderSpecial() {
        GL11.glTranslatef(-0.1f, 0.0f, 0.1f);
    }

    @Override
    public boolean func_77629_n_() {
        return true;
    }
}


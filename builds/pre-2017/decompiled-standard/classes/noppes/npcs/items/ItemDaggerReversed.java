/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

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
    public boolean func_77629_n_() {
        return true;
    }

    @Override
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = this.dagger.func_77617_a(0);
    }
}


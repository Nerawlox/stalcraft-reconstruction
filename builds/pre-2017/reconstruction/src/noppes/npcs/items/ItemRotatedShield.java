/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemShield;
import org.lwjgl.opengl.GL11;

public class ItemRotatedShield
extends ItemShield {
    public ItemRotatedShield(int n, EnumNpcToolMaterial enumNpcToolMaterial) {
        super(n, enumNpcToolMaterial);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.6f, 0.6f, 0.6f);
        GL11.glTranslatef(-0.1f, 1.0f, -0.18f);
        GL11.glRotatef(120.0f, 1.0f, 0.0f, 1.0f);
        GL11.glRotatef(-6.0f, 0.0f, 1.0f, 0.0f);
    }
}


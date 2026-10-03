/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.items.ItemMusic;
import org.lwjgl.opengl.GL11;

public class ItemViolin
extends ItemMusic {
    public ItemViolin(int n) {
        super(n);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.66f, 0.66f, 0.66f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.2f, -0.9f, -0.7f);
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._e;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        return super.func_77659_a(cvzo2, ozlu2, entityPlayer);
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 72000;
    }
}


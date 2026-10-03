/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemShield
extends ItemNpcInterface {
    public ItemShield(int n, EnumNpcToolMaterial enumNpcToolMaterial) {
        super(n);
        this.func_77656_e(enumNpcToolMaterial.getMaxUses());
        this.func_77637_a(CustomItems.tabWeapon);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.6f, 0.6f, 0.6f);
        GL11.glTranslatef(0.0f, 0.0f, -0.26f);
        GL11.glRotatef(-6.0f, 0.0f, 1.0f, 0.0f);
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._d;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        return cvzo2;
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 72000;
    }
}


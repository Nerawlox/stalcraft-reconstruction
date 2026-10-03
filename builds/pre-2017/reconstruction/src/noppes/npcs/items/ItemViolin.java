/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._e;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return super.onItemRightClick(itemStack, world, entityPlayer);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 72000;
    }
}


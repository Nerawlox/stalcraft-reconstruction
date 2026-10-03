/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemShield
extends ItemNpcInterface {
    public ItemShield(int n, EnumNpcToolMaterial enumNpcToolMaterial) {
        super(n);
        this.setMaxDamage(enumNpcToolMaterial.getMaxUses());
        this.setCreativeTab(CustomItems.tabWeapon);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.6f, 0.6f, 0.6f);
        GL11.glTranslatef(0.0f, 0.0f, -0.26f);
        GL11.glRotatef(-6.0f, 0.0f, 1.0f, 0.0f);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._d;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 72000;
    }
}


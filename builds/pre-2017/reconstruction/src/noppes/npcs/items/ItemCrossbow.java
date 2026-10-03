/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemCrossbow
extends ItemNpcInterface {
    public ItemCrossbow(int n) {
        super(n);
        this.setMaxDamage(129);
        this.setCreativeTab(CustomItems.tabWeapon);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
        if (!entityPlayer.worldObj.isRemote && (itemStack._e._f("IsLoaded") == 1 || entityPlayer.capabilities._d)) {
            if (itemStack._e._f("Reloading") == 1 && !entityPlayer.capabilities._d) {
                itemStack._e._a("Reloading", 0);
                return;
            }
            itemStack._a(1, (EntityLivingBase)entityPlayer);
            EntityProjectile entityProjectile = new EntityProjectile(entityPlayer.worldObj, entityPlayer, new ItemStack(Item.arrow, 1, 0), false);
            entityProjectile.damage = 10.0f;
            entityProjectile.setSpeed(20);
            entityProjectile.setHasGravity(true);
            entityProjectile.shoot(2.0f);
            if (!entityPlayer.capabilities._d) {
                entityPlayer.inventory._c(CustomItems.crossbowBolt.itemID);
            }
            entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "random.bow", 0.9f, Item.itemRand.nextFloat() * 0.3f + 0.8f);
            entityPlayer.worldObj.spawnEntityInWorld(entityProjectile);
            itemStack._e._a("IsLoaded", 0);
        }
    }

    @Override
    public void onUsingItemTick(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
        if (!entityPlayer.worldObj.isRemote) {
            int n2 = this.getMaxItemUseDuration(itemStack) - n;
            if (!entityPlayer.capabilities._d && itemStack._e._f("Reloading") == 1 && entityPlayer.inventory._d(CustomItems.crossbowBolt.itemID) && n2 == 20) {
                entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "random.click", 1.0f, 1.0f);
                itemStack._e._a("IsLoaded", 1);
            }
        }
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslatef(0.2f, 0.2f, -0.2f);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (itemStack._e == null) {
            itemStack._e = new NBTTagCompound();
        }
        if (!entityPlayer.capabilities._d && entityPlayer.inventory._d(CustomItems.crossbowBolt.itemID) && itemStack._e._f("IsLoaded") == 0) {
            itemStack._e._a("Reloading", 1);
        }
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return itemStack._e != null && itemStack._e._f("Reloading") != 0 ? EnumAction._d : EnumAction._e;
    }
}


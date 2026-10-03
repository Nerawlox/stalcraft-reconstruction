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

public class ItemMachineGun
extends ItemNpcInterface {
    public ItemMachineGun(int n) {
        super(n);
        this.setMaxDamage(80);
        this.setCreativeTab(CustomItems.tabWeapon);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
        if (!entityPlayer.capabilities._d) {
            int n2 = this.getMaxItemUseDuration(itemStack) - n;
            int n3 = itemStack._e._f("ShotsLeft") - n2 / 6;
            if (itemStack._e._f("Reloading") == 1) {
                n3 = n2 / 3;
                if (n2 > 24) {
                    n3 = 8;
                }
                if (n3 > 1) {
                    itemStack._e._a("ShotsLeft", n3);
                    itemStack._e._a("Reloading", 0);
                }
            } else if (n3 <= 0) {
                itemStack._e._a("Reloading", 1);
                itemStack._a(1, (EntityLivingBase)entityPlayer);
            } else {
                itemStack._e._a("ShotsLeft", n3);
            }
        }
    }

    @Override
    public void onUsingItemTick(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
        int n2;
        if (!entityPlayer.worldObj.isRemote && (n2 = this.getMaxItemUseDuration(itemStack) - n) % 6 == 0) {
            int n3 = itemStack._e._f("ShotsLeft") - n2 / 6;
            if (!entityPlayer.capabilities._d) {
                if (itemStack._e._f("Reloading") == 1 && entityPlayer.inventory._d(CustomItems.bulletBlack.itemID)) {
                    if (n2 > 0 && n2 <= 24) {
                        entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "customnpcs:gun.ak47chamberround", 1.0f, 1.0f);
                    }
                    return;
                }
                if (n3 <= 0 || !entityPlayer.inventory._d(CustomItems.bulletBlack.itemID)) {
                    entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "customnpcs:gun.empty", 1.0f, 1.0f);
                    return;
                }
            }
            EntityProjectile entityProjectile = new EntityProjectile(entityPlayer.worldObj, entityPlayer, new ItemStack(CustomItems.bulletBlack, 1, 0), false);
            entityProjectile.damage = 4.0f;
            entityProjectile.setSpeed(40);
            entityProjectile.shoot(2.0f);
            if (!entityPlayer.capabilities._d) {
                entityPlayer.inventory._c(CustomItems.bulletBlack.itemID);
            }
            entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "customnpcs:gun.pistolshot", 0.9f, Item.itemRand.nextFloat() * 0.3f + 0.8f);
            entityPlayer.worldObj.spawnEntityInWorld(entityProjectile);
        }
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslatef(0.0f, 0.2f, 0.0f);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (itemStack._e == null) {
            itemStack._e = new NBTTagCompound();
        }
        if (!entityPlayer.capabilities._d && !entityPlayer.inventory._d(CustomItems.bulletBlack.itemID)) {
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


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
import noppes.npcs.constants.EnumParticleType;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemMusket
extends ItemNpcInterface {
    public ItemMusket(int n) {
        super(n);
        this.setMaxDamage(129);
        this.setCreativeTab(CustomItems.tabWeapon);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
        if (!entityPlayer.worldObj.isRemote) {
            if (itemStack._e._f("IsLoaded") != 1 && !entityPlayer.capabilities._d) {
                entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "gun.empty", 1.0f, 1.0f);
            } else {
                if (itemStack._e._f("Reloading") == 1 && !entityPlayer.capabilities._d) {
                    itemStack._e._a("Reloading", 0);
                    return;
                }
                itemStack._a(1, (EntityLivingBase)entityPlayer);
                EntityProjectile entityProjectile = new EntityProjectile(entityPlayer.worldObj, entityPlayer, new ItemStack(CustomItems.bulletBlack, 1, 0), false);
                entityProjectile.damage = 16.0f;
                entityProjectile.setSpeed(50);
                entityProjectile.setParticleEffect(EnumParticleType.Smoke);
                entityProjectile.shoot(2.0f);
                if (!entityPlayer.capabilities._d) {
                    entityPlayer.inventory._c(CustomItems.bulletBlack.itemID);
                }
                entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "random.explode", 0.9f, Item.itemRand.nextFloat() * 0.3f + 1.8f);
                entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "ambient.weather.thunder", 2.0f, Item.itemRand.nextFloat() * 0.3f + 1.8f);
                entityPlayer.worldObj.spawnEntityInWorld(entityProjectile);
                itemStack._e._a("IsLoaded", 0);
            }
        }
    }

    @Override
    public void onUsingItemTick(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
        if (!entityPlayer.worldObj.isRemote) {
            int n2 = this.getMaxItemUseDuration(itemStack) - n;
            if (!entityPlayer.capabilities._d && itemStack._e._f("Reloading") == 1 && entityPlayer.inventory._d(CustomItems.bulletBlack.itemID) && n2 == 60) {
                entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "customnpcs:gun.ak47chamberround", 1.0f, 1.0f);
                itemStack._e._a("IsLoaded", 1);
            }
        }
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslatef(0.2f, 0.2f, -0.3f);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (itemStack._e == null) {
            itemStack._e = new NBTTagCompound();
        }
        if (!entityPlayer.capabilities._d && entityPlayer.inventory._d(CustomItems.bulletBlack.itemID) && itemStack._e._f("IsLoaded") == 0) {
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


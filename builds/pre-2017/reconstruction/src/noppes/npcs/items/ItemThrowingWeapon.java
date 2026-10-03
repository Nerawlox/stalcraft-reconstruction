/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.ItemNpcInterface;

public class ItemThrowingWeapon
extends ItemNpcInterface {
    private boolean rotating = false;
    private int damage = 2;
    private boolean dropItem = false;

    public ItemThrowingWeapon(int n) {
        super(n);
        this.setCreativeTab(CustomItems.tabWeapon);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
        if (world.isRemote) {
            entityPlayer.swingItem();
        } else {
            EntityProjectile entityProjectile = new EntityProjectile(world, entityPlayer, new ItemStack(itemStack._a(), 1, itemStack._j()), false);
            entityProjectile.damage = this.damage;
            entityProjectile.canBePickedUp = !entityPlayer.capabilities._d && this.dropItem;
            entityProjectile.setRotating(this.rotating);
            entityProjectile.setIs3D(true);
            entityProjectile.setStickInWall(true);
            entityProjectile.setHasGravity(true);
            entityProjectile.setSpeed(12);
            if (!entityPlayer.capabilities._d) {
                entityPlayer.inventory._c(this.itemID);
            }
            entityProjectile.shoot(1.0f);
            world.playSoundAtEntity(entityPlayer, "customnpcs:misc.swosh", 1.0f, 1.0f);
            world.spawnEntityInWorld(entityProjectile);
        }
    }

    public ItemThrowingWeapon setRotating() {
        this.rotating = true;
        return this;
    }

    public ItemThrowingWeapon setDamage(int n) {
        this.damage = n;
        return this;
    }

    public ItemThrowingWeapon setDropItem() {
        this.dropItem = true;
        return this;
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


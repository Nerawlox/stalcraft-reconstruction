/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.ItemNpcWeaponInterface;
import org.lwjgl.opengl.GL11;

public class ItemKunai
extends ItemNpcWeaponInterface {
    public ItemKunai(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
        if (world.isRemote) {
            entityPlayer.swingItem();
        } else {
            EntityProjectile entityProjectile = new EntityProjectile(world, entityPlayer, itemStack, false);
            entityProjectile.damage = this.func_82803_g();
            entityProjectile.destroyedOnEntityHit = false;
            entityProjectile.canBePickedUp = !entityPlayer.capabilities._d;
            entityProjectile.setIs3D(true);
            entityProjectile.setStickInWall(true);
            entityProjectile.setHasGravity(true);
            entityProjectile.setSpeed(12);
            entityProjectile.shoot(1.0f);
            if (!entityPlayer.capabilities._d) {
                itemStack._a(1, (EntityLivingBase)entityPlayer);
                if (itemStack._b == 0) {
                    return;
                }
                entityPlayer.inventory._a[entityPlayer.inventory._c] = null;
            }
            world.playSoundAtEntity(entityPlayer, "customnpcs:misc.swosh", 1.0f, 1.0f);
            world.spawnEntityInWorld(entityProjectile);
        }
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

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
        GL11.glTranslatef(-0.2f, 0.3f, 0.2f);
    }

    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }
}


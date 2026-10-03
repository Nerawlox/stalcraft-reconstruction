/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemFishingRod
extends Item {
    public Icon _a;

    public ItemFishingRod(int n) {
        super(n);
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (entityPlayer.fishEntity != null) {
            int n = entityPlayer.fishEntity.catchFish();
            itemStack._a(n, (EntityLivingBase)entityPlayer);
            entityPlayer.swingItem();
        } else {
            world.playSoundAtEntity(entityPlayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world.isRemote) {
                world.spawnEntityInWorld(new EntityFishHook(world, entityPlayer));
            }
            entityPlayer.swingItem();
        }
        return itemStack;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b(this.getIconString() + "_uncast");
        this._a = iconRegister._b(this.getIconString() + "_cast");
    }

    public Icon _a() {
        return this._a;
    }
}


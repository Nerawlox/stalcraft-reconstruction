/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemBullet;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemGun
extends ItemNpcInterface {
    private EnumNpcToolMaterial material;

    public ItemGun(int n, EnumNpcToolMaterial enumNpcToolMaterial) {
        super(n);
        this.maxStackSize = 1;
        this.material = enumNpcToolMaterial;
        this.setMaxDamage(enumNpcToolMaterial.getMaxUses());
        this.setCreativeTab(CustomItems.tabWeapon);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
        if (!world.isRemote) {
            if (!this.hasBullet(entityPlayer)) {
                world.playSoundAtEntity(entityPlayer, "customnpcs:gun.empty", 1.0f, 1.0f);
            } else {
                int n2 = this.getMaxItemUseDuration(itemStack) - n;
                if (n2 >= 10) {
                    itemStack._a(1, (EntityLivingBase)entityPlayer);
                    ItemBullet itemBullet = (ItemBullet)this.getBullet(entityPlayer);
                    int n3 = (itemBullet.getBulletDamage() + this.material.getDamageVsEntity() + 1) / 2 + 5;
                    EntityProjectile entityProjectile = new EntityProjectile(world, entityPlayer, new ItemStack(this.getBullet(entityPlayer)), false);
                    entityProjectile.damage = n3;
                    entityProjectile.setSpeed(40);
                    entityProjectile.shoot(this.material.getDamageVsEntity() + 1);
                    if (!entityPlayer.capabilities._d) {
                        entityPlayer.inventory._c(this.getBullet((EntityPlayer)entityPlayer).itemID);
                    }
                    world.playSoundAtEntity(entityPlayer, "customnpcs:gun.pistolshot", 1.0f, Item.itemRand.nextFloat() * 0.3f + 0.8f);
                    world.spawnEntityInWorld(entityProjectile);
                }
            }
        }
    }

    @Override
    public void onUsingItemTick(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
        int n2 = this.getMaxItemUseDuration(itemStack) - n;
        if (n2 == 8 && !entityPlayer.worldObj.isRemote) {
            entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "customnpcs:gun.pistoltrigger", 1.0f, 1.0f / (entityPlayer.worldObj.rand.nextFloat() * 0.4f + 0.8f));
        }
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslatef(0.0f, 0.3f, 0.0f);
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

    private boolean hasBullet(EntityPlayer entityPlayer) {
        Item item = this.getBullet(entityPlayer);
        return item != null && item.itemID >= 0;
    }

    private Item getBullet(EntityPlayer entityPlayer) {
        switch (NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[this.material.ordinal()]) {
            case 1: {
                if (entityPlayer.inventory._d(CustomItems.bulletEmerald.itemID)) {
                    return CustomItems.bulletEmerald;
                }
            }
            case 2: {
                if (entityPlayer.inventory._d(CustomItems.bulletDiamond.itemID)) {
                    return CustomItems.bulletDiamond;
                }
            }
            case 3: {
                if (entityPlayer.inventory._d(CustomItems.bulletIron.itemID)) {
                    return CustomItems.bulletIron;
                }
            }
            case 4: {
                if (entityPlayer.inventory._d(CustomItems.bulletBronze.itemID)) {
                    return CustomItems.bulletBronze;
                }
            }
            case 5: {
                if (entityPlayer.inventory._d(CustomItems.bulletGold.itemID)) {
                    return CustomItems.bulletGold;
                }
            }
            case 6: {
                if (entityPlayer.inventory._d(CustomItems.bulletStone.itemID)) {
                    return CustomItems.bulletStone;
                }
            }
            case 7: {
                if (!entityPlayer.inventory._d(CustomItems.bulletWood.itemID)) break;
                return CustomItems.bulletWood;
            }
        }
        return !entityPlayer.inventory._d(CustomItems.bulletBlack.itemID) && !entityPlayer.capabilities._d ? null : CustomItems.bulletBlack;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._e;
    }

    static class NamelessClass975299564 {
        static final int[] $SwitchMap$noppes$npcs$items$EnumNpcToolMaterial = new int[EnumNpcToolMaterial.values().length];

        NamelessClass975299564() {
        }

        static {
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.EMERALD.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.DIA.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.IRON.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.BRONZE.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.GOLD.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.STONE.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.WOOD.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}


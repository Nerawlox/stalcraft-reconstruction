/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFood
extends Item {
    public final int itemUseDuration = 32;
    public final int healAmount;
    public final float saturationModifier;
    public final boolean isWolfsFavoriteMeat;
    public boolean alwaysEdible;
    public int potionId;
    public int potionDuration;
    public int potionAmplifier;
    public float potionEffectProbability;

    public ItemFood(int n, int n2, float f, boolean bl) {
        super(n);
        this.healAmount = n2;
        this.isWolfsFavoriteMeat = bl;
        this.saturationModifier = f;
        this.setCreativeTab(CreativeTabs.tabFood);
    }

    public ItemFood(int n, int n2, boolean bl) {
        this(n, n2, 0.6f, bl);
    }

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        --itemStack._b;
        entityPlayer.getFoodStats()._a(this);
        world.playSoundAtEntity(entityPlayer, "random.burp", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        this.onFoodEaten(itemStack, world, entityPlayer);
        return itemStack;
    }

    public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote && this.potionId > 0 && world.rand.nextFloat() < this.potionEffectProbability) {
            entityPlayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._b;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (entityPlayer.canEat(this.alwaysEdible)) {
            entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }
        return itemStack;
    }

    public int getHealAmount() {
        return this.healAmount;
    }

    public float getSaturationModifier() {
        return this.saturationModifier;
    }

    public boolean isWolfsFavoriteMeat() {
        return this.isWolfsFavoriteMeat;
    }

    public ItemFood setPotionEffect(int n, int n2, int n3, float f) {
        this.potionId = n;
        this.potionDuration = n2;
        this.potionAmplifier = n3;
        this.potionEffectProbability = f;
        return this;
    }

    public ItemFood setAlwaysEdible() {
        this.alwaysEdible = true;
        return this;
    }
}


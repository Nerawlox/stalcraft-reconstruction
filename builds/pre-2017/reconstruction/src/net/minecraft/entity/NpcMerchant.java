/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class NpcMerchant
implements IMerchant {
    public InventoryMerchant _a;
    public EntityPlayer _b;
    public MerchantRecipeList _c;

    public NpcMerchant(EntityPlayer entityPlayer) {
        this._b = entityPlayer;
        this._a = new InventoryMerchant(entityPlayer, this);
    }

    @Override
    public EntityPlayer getCustomer() {
        return this._b;
    }

    @Override
    public void setCustomer(EntityPlayer entityPlayer) {
    }

    @Override
    public MerchantRecipeList getRecipes(EntityPlayer entityPlayer) {
        return this._c;
    }

    @Override
    public void setRecipes(MerchantRecipeList merchantRecipeList) {
        this._c = merchantRecipeList;
    }

    @Override
    public void useRecipe(MerchantRecipe merchantRecipe) {
    }

    @Override
    public void func_110297_a_(ItemStack itemStack) {
    }
}


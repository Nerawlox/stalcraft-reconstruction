/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSword
extends Item {
    public float weaponDamage;
    public final txfz toolMaterial;

    public ItemSword(int n, txfz txfz2) {
        super(n);
        this.toolMaterial = txfz2;
        this.maxStackSize = 1;
        this.setMaxDamage(txfz2._a());
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.weaponDamage = 4.0f + txfz2._c();
    }

    public float func_82803_g() {
        return this.toolMaterial._c();
    }

    @Override
    public float getStrVsBlock(ItemStack itemStack, Block block) {
        if (block.blockID == Block.web.blockID) {
            return 15.0f;
        }
        Material material = block.blockMaterial;
        if (material == Material._k || material == Material._l || material == Material._v || material == Material._j || material == Material._B) {
            return 1.5f;
        }
        return 1.0f;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        itemStack._a(1, entityLivingBase2);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        if ((double)Block.blocksList[n].getBlockHardness(world, n2, n3, n4) != 0.0) {
            itemStack._a(2, entityLivingBase);
        }
        return true;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._d;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 72000;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        return block.blockID == Block.web.blockID;
    }

    @Override
    public int getItemEnchantability() {
        return this.toolMaterial._e();
    }

    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }

    @Override
    public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStack2) {
        if (this.toolMaterial._f() == itemStack2._d) {
            return true;
        }
        return super.getIsRepairable(itemStack, itemStack2);
    }

    @Override
    public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(sajz._e._a(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0));
        return multimap;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemArmor
extends Item {
    public static final int[] maxDamageArray = new int[]{11, 16, 15, 13};
    public static final String[] field_94606_cu = new String[]{"leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay"};
    public static final String[] field_94603_a = new String[]{"empty_armor_slot_helmet", "empty_armor_slot_chestplate", "empty_armor_slot_leggings", "empty_armor_slot_boots"};
    public static final vmgb field_96605_cw = new pkyq();
    public final int armorType;
    public final int damageReduceAmount;
    public final int renderIndex;
    public final EnumArmorMaterial material;
    @SideOnly(value=Side.CLIENT)
    public Icon field_94605_cw;
    @SideOnly(value=Side.CLIENT)
    public Icon field_94604_cx;

    public ItemArmor(int n, EnumArmorMaterial enumArmorMaterial, int n2, int n3) {
        super(n);
        this.material = enumArmorMaterial;
        this.armorType = n3;
        this.renderIndex = n2;
        this.damageReduceAmount = enumArmorMaterial._b(n3);
        this.setMaxDamage(enumArmorMaterial._a(n3));
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabCombat);
        BlockDispenser._a._a(this, field_96605_cw);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        if (n > 0) {
            return 0xFFFFFF;
        }
        int n2 = this.getColor(itemStack);
        if (n2 < 0) {
            n2 = 0xFFFFFF;
        }
        return n2;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return this.material == EnumArmorMaterial._a;
    }

    @Override
    public int getItemEnchantability() {
        return this.material._a();
    }

    public EnumArmorMaterial getArmorMaterial() {
        return this.material;
    }

    public boolean hasColor(ItemStack itemStack) {
        return this.material != EnumArmorMaterial._a ? false : (!itemStack._p() ? false : (!itemStack._q()._c("display") ? false : itemStack._q()._m("display")._c("color")));
    }

    public int getColor(ItemStack itemStack) {
        if (this.material != EnumArmorMaterial._a) {
            return -1;
        }
        NBTTagCompound nBTTagCompound = itemStack._q();
        if (nBTTagCompound == null) {
            return 10511680;
        }
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("display");
        return nBTTagCompound2 == null ? 10511680 : (nBTTagCompound2._c("color") ? nBTTagCompound2._f("color") : 10511680);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIconFromDamageForRenderPass(int n, int n2) {
        return n2 == 1 ? this.field_94605_cw : super.getIconFromDamageForRenderPass(n, n2);
    }

    public void removeColor(ItemStack itemStack) {
        NBTTagCompound nBTTagCompound;
        NBTTagCompound nBTTagCompound2;
        if (this.material == EnumArmorMaterial._a && (nBTTagCompound2 = itemStack._q()) != null && (nBTTagCompound = nBTTagCompound2._m("display"))._c("color")) {
            nBTTagCompound._p("color");
        }
    }

    public void func_82813_b(ItemStack itemStack, int n) {
        if (this.material != EnumArmorMaterial._a) {
            throw new UnsupportedOperationException("Can't dye non-leather!");
        }
        NBTTagCompound nBTTagCompound = itemStack._q();
        if (nBTTagCompound == null) {
            nBTTagCompound = new NBTTagCompound();
            itemStack._d(nBTTagCompound);
        }
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("display");
        if (!nBTTagCompound._c("display")) {
            nBTTagCompound._a("display", nBTTagCompound2);
        }
        nBTTagCompound2._a("color", n);
    }

    @Override
    public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStack2) {
        return this.material._b() == itemStack2._d ? true : super.getIsRepairable(itemStack, itemStack2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);
        if (this.material == EnumArmorMaterial._a) {
            this.field_94605_cw = iconRegister._b(field_94606_cu[this.armorType]);
        }
        this.field_94604_cx = iconRegister._b(field_94603_a[this.armorType]);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        int n = EntityLiving.getArmorPosition(itemStack) - 1;
        ItemStack itemStack2 = entityPlayer.getCurrentArmor(n);
        if (itemStack2 == null) {
            entityPlayer.setCurrentItemOrArmor(n + 1, itemStack._l());
            itemStack._b = 0;
        }
        return itemStack;
    }

    @SideOnly(value=Side.CLIENT)
    public static Icon func_94602_b(int n) {
        switch (n) {
            case 0: {
                return Item.helmetDiamond.field_94604_cx;
            }
            case 1: {
                return Item.plateDiamond.field_94604_cx;
            }
            case 2: {
                return Item.legsDiamond.field_94604_cx;
            }
            case 3: {
                return Item.bootsDiamond.field_94604_cx;
            }
        }
        return null;
    }

    public static int[] getMaxDamageArray() {
        return maxDamageArray;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;

public class NpcArmor
extends ItemArmor {
    private String texture;

    public NpcArmor(int n, EnumArmorMaterial enumArmorMaterial, int n2, String string) {
        super(n - 26700 + CustomNpcs.ItemStartId, enumArmorMaterial, 0, n2);
        this.texture = string;
        this.setCreativeTab(CustomItems.tabArmor);
    }

    @Override
    public String getArmorTexture(ItemStack itemStack, Entity entity, int n, int n2) {
        return this.armorType == 2 ? "customnpcs:textures/armor/" + this.texture + "_2.png" : "customnpcs:textures/armor/" + this.texture + "_1.png";
    }

    @Override
    public Item setUnlocalizedName(String string) {
        GameRegistry.registerItem(this, string);
        return super.setUnlocalizedName(string);
    }
}


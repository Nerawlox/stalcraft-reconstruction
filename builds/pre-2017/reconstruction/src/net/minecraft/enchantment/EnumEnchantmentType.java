/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.enchantment;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSword;

public enum EnumEnchantmentType {
    _a,
    _b,
    _c,
    _d,
    _e,
    _f,
    _g,
    _h,
    _i;


    public boolean _a(Item item) {
        if (this == _a) {
            return true;
        }
        if (item instanceof ItemArmor) {
            if (this == _b) {
                return true;
            }
            ItemArmor itemArmor = (ItemArmor)item;
            if (itemArmor.armorType == 0) {
                return this == _f;
            }
            if (itemArmor.armorType == 2) {
                return this == _d;
            }
            if (itemArmor.armorType == 1) {
                return this == _e;
            }
            if (itemArmor.armorType == 3) {
                return this == _c;
            }
            return false;
        }
        if (item instanceof ItemSword) {
            return this == _g;
        }
        if (item instanceof focs) {
            return this == _h;
        }
        if (item instanceof ItemBow) {
            return this == _i;
        }
        return false;
    }
}


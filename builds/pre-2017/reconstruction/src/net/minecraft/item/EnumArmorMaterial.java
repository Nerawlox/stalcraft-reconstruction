/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public enum EnumArmorMaterial {
    _a(5, new int[]{1, 3, 2, 1}, 15),
    _b(15, new int[]{2, 5, 4, 1}, 12),
    _c(15, new int[]{2, 6, 5, 2}, 9),
    _d(7, new int[]{2, 5, 3, 1}, 25),
    _e(33, new int[]{3, 8, 6, 3}, 10);

    public int _f;
    public int[] _g;
    public int _h;
    public Item _i = null;

    public EnumArmorMaterial(int n2, int[] nArray, int n3) {
        this._f = n2;
        this._g = nArray;
        this._h = n3;
    }

    public int _a(int n) {
        return ItemArmor.getMaxDamageArray()[n] * this._f;
    }

    public int _b(int n) {
        return this._g[n];
    }

    public int _a() {
        return this._h;
    }

    public int _b() {
        switch (this) {
            case _a: {
                return Item.leather.itemID;
            }
            case _b: {
                return Item.ingotIron.itemID;
            }
            case _d: {
                return Item.ingotGold.itemID;
            }
            case _c: {
                return Item.ingotIron.itemID;
            }
            case _e: {
                return Item.diamond.itemID;
            }
        }
        return this._i == null ? 0 : this._i.itemID;
    }
}


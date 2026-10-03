/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop.data;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.shop.data.ShopEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ShopItem
extends ShopEntry {
    @SerializedName(value="stack")
    public wnce stack;
    @SerializedName(value="previewSlot")
    protected int previewSlot = -1;

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public int _e() {
        if (this.previewSlot != -1) {
            return this.previewSlot;
        }
        ItemStack itemStack = this.stack._a();
        if (itemStack._a() instanceof ItemArmor) {
            return 39 - ((ItemArmor)itemStack._a()).armorType;
        }
        return 0;
    }

    @Override
    public String _a() {
        String string = super._a();
        if (string != null) {
            return string;
        }
        return this.stack._a()._s();
    }

    @Override
    public boolean _d() {
        return this.stack == null || Item.itemsList[this.stack._c()] == null;
    }

    public String toString() {
        return "ShopItem{stack=" + this.stack + ", previewSlot=" + this.previewSlot + ", entryId=" + this.entryId + ", price=" + this.price + ", customName='" + this.customName + '\'' + ", discount=" + this.discount + '}';
    }
}


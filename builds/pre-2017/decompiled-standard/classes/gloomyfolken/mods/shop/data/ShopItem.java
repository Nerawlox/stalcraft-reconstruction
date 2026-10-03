/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop.data;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.shop.data.ShopEntry;

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
        cvzo cvzo2 = this.stack._a();
        if (cvzo2._a() instanceof lpno) {
            return 39 - ((lpno)cvzo2._a()).field_77881_a;
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
        return this.stack == null || tgdv.field_77698_e[this.stack._c()] == null;
    }

    public String toString() {
        return "ShopItem{stack=" + this.stack + ", previewSlot=" + this.previewSlot + ", entryId=" + this.entryId + ", price=" + this.price + ", customName='" + this.customName + '\'' + ", discount=" + this.discount + '}';
    }
}


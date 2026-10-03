/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop.data;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;

public abstract class ShopEntry {
    private static int nextEntryId;
    public final transient int entryId = nextEntryId++;
    @SerializedName(value="price")
    public int price;
    @SerializedName(value="customName")
    public String customName;
    @SerializedName(value="discount")
    public int discount = 0;

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public String _a() {
        return this.customName;
    }

    public float _b() {
        return 1.0f - (float)this.discount / 100.0f;
    }

    public int _c() {
        return (int)((float)this.price * this._b());
    }

    public boolean _d() {
        return false;
    }
}


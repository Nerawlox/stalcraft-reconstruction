/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop.data;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.shop.data.ShopEntry;
import java.util.ArrayList;
import java.util.List;

public class ShopSubCategory {
    @SerializedName(value="name")
    public String name;
    @SerializedName(value="entries")
    public List<ShopEntry> entries = new ArrayList<ShopEntry>();
}


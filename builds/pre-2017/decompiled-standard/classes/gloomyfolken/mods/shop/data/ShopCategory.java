/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop.data;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.shop.data.ShopSubCategory;
import java.util.ArrayList;
import java.util.List;

public class ShopCategory {
    @SerializedName(value="name")
    public String name = "";
    @SerializedName(value="subCategories")
    public List<ShopSubCategory> subCategories = new ArrayList<ShopSubCategory>();
}


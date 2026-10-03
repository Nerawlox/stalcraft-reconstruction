/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop.data;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.shop.data.ShopCategory;
import gloomyfolken.mods.shop.data.ShopEntry;
import gloomyfolken.mods.shop.data.ShopSubCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShopData {
    @SerializedName(value="resizeTabs")
    public boolean resizeTabs;
    @SerializedName(value="scrollableTabPane")
    public boolean scrollableTabPane;
    @SerializedName(value="tabResizeBorder")
    public int tabResizeBorder;
    @SerializedName(value="addFundsLink")
    public String addFundsLink;
    @SerializedName(value="currencyName")
    public String currencyName;
    @SerializedName(value="categories")
    public List<ShopCategory> categories = new ArrayList<ShopCategory>();

    public ShopEntry _a(int n) {
        for (ShopCategory shopCategory : this.categories) {
            for (ShopSubCategory shopSubCategory : shopCategory.subCategories) {
                for (ShopEntry shopEntry : shopSubCategory.entries) {
                    if (shopEntry.entryId != n) continue;
                    return shopEntry;
                }
            }
        }
        return null;
    }

    public void _a() {
        for (ShopCategory shopCategory : this.categories) {
            for (ShopSubCategory shopSubCategory : shopCategory.subCategories) {
                Iterator<ShopEntry> iterator2 = shopSubCategory.entries.iterator();
                while (iterator2.hasNext()) {
                    ShopEntry shopEntry = iterator2.next();
                    if (!shopEntry._d()) continue;
                    Logger.warning("Found invalid item in shop config: " + shopEntry, new Object[0]);
                    iterator2.remove();
                }
            }
        }
    }
}


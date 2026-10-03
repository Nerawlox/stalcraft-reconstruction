/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop.data;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.shop.data.ShopEntry;
import java.util.List;

public class ShopKit
extends ShopEntry {
    @SerializedName(value="stacks")
    public List<wnce> stacks;
}


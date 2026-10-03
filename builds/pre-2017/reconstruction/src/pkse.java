/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class pkse
extends CreativeTabs {
    public pkse(int n, String string) {
        super(n, string);
    }

    @Override
    public int getTabIconItemIndex() {
        return Item.potion.itemID;
    }
}


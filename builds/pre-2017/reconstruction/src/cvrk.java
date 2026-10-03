/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class cvrk
extends CreativeTabs {
    public cvrk(int n, String string) {
        super(n, string);
    }

    @Override
    public int getTabIconItemIndex() {
        return Item.redstone.itemID;
    }
}


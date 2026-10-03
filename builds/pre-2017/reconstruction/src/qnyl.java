/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class qnyl
extends CreativeTabs {
    public qnyl(int n, String string) {
        super(n, string);
    }

    @Override
    public int getTabIconItemIndex() {
        return Item.compass.itemID;
    }
}


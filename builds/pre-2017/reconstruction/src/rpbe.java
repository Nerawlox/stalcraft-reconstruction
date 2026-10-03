/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class rpbe
extends CreativeTabs {
    public rpbe() {
        super("Folken's Mods Tab");
    }

    @Override
    public String getTranslatedTabLabel() {
        return this.getTabLabel();
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public Item getTabIconItem() {
        return Item.arrow;
    }
}


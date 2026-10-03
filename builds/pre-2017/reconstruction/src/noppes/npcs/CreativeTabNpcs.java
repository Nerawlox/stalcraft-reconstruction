/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabNpcs
extends CreativeTabs {
    public int icon;

    public CreativeTabNpcs(String string) {
        super(string);
    }

    @Override
    public int getTabIconItemIndex() {
        return this.icon;
    }
}


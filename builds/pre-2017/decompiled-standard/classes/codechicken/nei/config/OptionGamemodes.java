/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.nei.Image;
import codechicken.nei.LayoutManager;
import codechicken.nei.config.OptionStringSet;

public class OptionGamemodes
extends OptionStringSet {
    public OptionGamemodes(String string) {
        super(string);
        this.options.add("creative");
        this.options.add("creative+");
        this.options.add("adventure");
    }

    @Override
    public void drawIcons() {
        int n = this.buttonX();
        LayoutManager.drawIcon(n + 4, 6, new Image(132, 12, 12, 12));
        LayoutManager.drawIcon((n += 24) + 4, 6, new Image(156, 12, 12, 12));
        LayoutManager.drawIcon((n += 24) + 4, 6, new Image(168, 12, 12, 12));
        n += 24;
    }
}


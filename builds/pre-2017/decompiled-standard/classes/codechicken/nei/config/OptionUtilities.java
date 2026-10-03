/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.nei.Image;
import codechicken.nei.LayoutManager;
import codechicken.nei.config.OptionStringSet;
import codechicken.nei.forge.GuiContainerManager;
import org.lwjgl.opengl.GL11;

public class OptionUtilities
extends OptionStringSet {
    public OptionUtilities(String string) {
        super(string);
        this.options.add("time");
        this.options.add("rain");
        this.options.add("heal");
        this.options.add("delete");
        this.options.add("magnet");
        this.options.add("gamemode");
        this.options.add("enchant");
        this.options.add("potion");
        this.options.add("item");
        this.groups.put("gamemode", "creative");
        this.groups.put("gamemode", "creative+");
        this.groups.put("gamemode", "adventure");
    }

    @Override
    public void drawIcons() {
        int n = this.buttonX();
        LayoutManager.drawIcon(n + 4, 6, new Image(120, 24, 12, 12));
        LayoutManager.drawIcon((n += 24) + 4, 6, new Image(120, 12, 12, 12));
        LayoutManager.drawIcon((n += 24) + 4, 6, new Image(168, 24, 12, 12));
        LayoutManager.drawIcon((n += 24) + 4, 6, new Image(144, 12, 12, 12));
        LayoutManager.drawIcon((n += 24) + 4, 6, new Image(180, 24, 12, 12));
        LayoutManager.drawIcon((n += 24) + 4, 6, new Image(132, 12, 12, 12));
        qnon._c();
        GL11.glEnable(32826);
        cvzo cvzo2 = new cvzo(tgdv.field_77718_z);
        cvzo2._a(zhqo._k, 1);
        GuiContainerManager.drawItem((n += 24) + 2, 4, cvzo2);
        GuiContainerManager.drawItem((n += 24) + 2, 4, new cvzo(tgdv.field_77726_bs));
        GuiContainerManager.drawItem((n += 24) + 2, 4, new cvzo(twgu.field_71981_t));
        n += 24;
    }
}


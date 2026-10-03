/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.CommonUtils;
import codechicken.core.gui.GuiDraw;
import codechicken.nei.ItemList;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.TextField;

public class SearchField
extends TextField {
    long lastclicktime;

    public SearchField(String string) {
        super(string);
    }

    public static boolean searchInventories() {
        return NEIClientConfig.world.nbt._o("searchinventories");
    }

    @Override
    public void drawBox() {
        if (SearchField.searchInventories()) {
            GuiDraw.drawGradientRect(this.x, this.y, this.width, this.height, -256, -4149248);
        } else {
            GuiDraw.drawRect(this.x, this.y, this.width, this.height, -6250336);
        }
        GuiDraw.drawRect(this.x + 1, this.y + 1, this.width - 2, this.height - 2, -16777216);
    }

    @Override
    public boolean handleClick(int n, int n2, int n3) {
        if (n3 == 0) {
            if (this.focused() && System.currentTimeMillis() - this.lastclicktime < 500L) {
                NEIClientConfig.world.nbt._a("searchinventories", !SearchField.searchInventories());
                NEIClientConfig.world.saveNBT();
            }
            this.lastclicktime = System.currentTimeMillis();
        }
        return super.handleClick(n, n2, n3);
    }

    @Override
    public void onTextChange(String string) {
        NEIClientConfig.setSearchExpression(this.text());
        ItemList.updateSearch();
    }

    @Override
    public void lastKeyTyped(int n, char c) {
        if (n == NEIClientConfig.getKeyBinding("gui.search")) {
            this.setFocus(true);
        }
    }

    @Override
    public String filterText(String string) {
        return CommonUtils.filterText(string);
    }
}


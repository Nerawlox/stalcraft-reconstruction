/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.Image;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.Widget;
import java.util.List;

public abstract class Button
extends Widget {
    public String label;
    public Image icon;
    public int state;

    public Button(String string) {
        this.label = string;
    }

    public Button() {
        this.label = "";
    }

    public int contentWidth() {
        return this.getRenderIcon() == null ? GuiDraw.getStringWidth(this.label) : this.getRenderIcon().width;
    }

    @Override
    public void draw(int n, int n2) {
        LayoutManager.getLayoutStyle().drawButton(this, n, n2);
    }

    @Override
    public boolean handleClick(int n, int n2, int n3) {
        if ((n3 == 1 || n3 == 0) && this.onButtonPress(n3 == 1)) {
            NEIClientUtils.mc()._N._a("random.click", 1.0f, 1.0f);
        }
        return true;
    }

    public abstract boolean onButtonPress(boolean var1);

    public Image getRenderIcon() {
        return this.icon;
    }

    @Override
    public List<String> handleTooltip(int n, int n2, List<String> list) {
        if (!this.contains(n, n2)) {
            return list;
        }
        String string = this.getButtonTip();
        if (string != null) {
            list.add(string);
        }
        return list;
    }

    public String getButtonTip() {
        return null;
    }

    public String getRenderLabel() {
        return this.label;
    }
}


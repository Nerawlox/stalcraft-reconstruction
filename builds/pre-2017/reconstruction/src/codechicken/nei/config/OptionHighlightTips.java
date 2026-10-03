/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.nei.api.GuiInfo;
import codechicken.nei.config.GuiHighlightTips;
import codechicken.nei.config.OptionButton;

public class OptionHighlightTips
extends OptionButton {
    public OptionHighlightTips(String string) {
        super(string, null, string, null);
    }

    @Override
    public void copyGlobals() {
        this.copyGlobal(this.name);
        this.copyGlobal(this.name + ".x");
        this.copyGlobal(this.name + ".y");
    }

    @Override
    public boolean onClick(int n) {
        if (this.renderDefault()) {
            return false;
        }
        GuiInfo.switchGui(new GuiHighlightTips(this));
        return true;
    }
}


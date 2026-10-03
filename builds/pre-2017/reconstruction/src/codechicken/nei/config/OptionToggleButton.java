/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.nei.config.OptionButton;

public class OptionToggleButton
extends OptionButton {
    public final boolean prefixed;

    public OptionToggleButton(String string, boolean bl) {
        super(string);
        this.prefixed = bl;
    }

    public OptionToggleButton(String string) {
        this(string, false);
    }

    public boolean state() {
        return this.renderTag().getBooleanValue();
    }

    @Override
    public String getButtonText() {
        return this.translateN(this.name + (this.state() ? ".true" : ".false"), new Object[0]);
    }

    @Override
    public String getPrefix() {
        return this.prefixed ? this.translateN(this.name, new Object[0]) : null;
    }

    @Override
    public boolean onClick(int n) {
        if (this.renderDefault()) {
            return false;
        }
        this.getTag().setBooleanValue(!this.state());
        return true;
    }
}


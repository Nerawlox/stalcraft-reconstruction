/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.nei.config.Option;
import codechicken.nei.config.OptionButton;
import org.lwjgl.input.Keyboard;

public class OptionKeyBind
extends OptionButton {
    private boolean hasFocus = false;

    public OptionKeyBind(String string) {
        super("keys." + string);
    }

    @Override
    public void onMouseClicked(int n, int n2, int n3) {
        this.hasFocus = false;
    }

    @Override
    public void keyTyped(char c, int n) {
        if (this.hasFocus) {
            this.setValue(n);
            this.hasFocus = false;
        }
    }

    @Override
    public boolean onClick(int n) {
        if (this.renderDefault()) {
            return false;
        }
        if (n == 0) {
            this.hasFocus = true;
            return true;
        }
        if (n == 1 && this.getValue() != 0) {
            this.setValue(0);
            return true;
        }
        return false;
    }

    public boolean conflicted() {
        if (this.getValue() == 0) {
            return false;
        }
        for (Option option : this.slot.options) {
            if (!(option instanceof OptionKeyBind) || option == this || ((OptionKeyBind)option).getValue() != this.getValue()) continue;
            return true;
        }
        return false;
    }

    public void setValue(int n) {
        this.getTag().setIntValue(n);
    }

    public int getValue() {
        return this.renderTag().getIntValue();
    }

    @Override
    public String getPrefix() {
        return this.translateN(this.name, new Object[0]);
    }

    @Override
    public String getButtonText() {
        if (this.hasFocus) {
            return "\u00a7f> \u00a7e??? \u00a7f<";
        }
        if (this.conflicted()) {
            return "\u00a7c" + Keyboard.getKeyName(this.getValue());
        }
        return Keyboard.getKeyName(this.getValue());
    }

    @Override
    public int getTextColour(int n, int n2) {
        return -1;
    }
}


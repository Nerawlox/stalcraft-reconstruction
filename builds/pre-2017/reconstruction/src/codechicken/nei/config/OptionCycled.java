/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.nei.config.OptionButton;

public class OptionCycled
extends OptionButton {
    public final int count;
    public final boolean prefixed;

    public OptionCycled(String string, int n, boolean bl) {
        super(string);
        this.count = n;
        this.prefixed = bl;
    }

    public OptionCycled(String string, int n) {
        this(string, n, false);
    }

    public int value() {
        return this.renderTag().getIntValue();
    }

    @Override
    public String getButtonText() {
        return this.translateN(this.name + "." + this.value(), new Object[0]);
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
        return this.cycle();
    }

    public boolean cycle() {
        int n = this.value();
        while (!this.optionValid(n = (n + 1) % this.count)) {
        }
        if (n == this.value()) {
            return false;
        }
        this.getTag().setIntValue(n);
        return true;
    }

    public boolean optionValid(int n) {
        return true;
    }
}


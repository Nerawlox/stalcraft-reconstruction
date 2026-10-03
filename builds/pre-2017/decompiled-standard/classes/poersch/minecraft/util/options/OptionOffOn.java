/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.options;

import java.util.List;
import poersch.minecraft.util.options.Option;

public class OptionOffOn
extends Option<Boolean> {
    private static final String[][] options = new String[][]{{"OFF", "False"}, {"ON", "True"}};

    public OptionOffOn(String string, String string2, String string3, String string4) {
        this(null, string, string2, string3, string4);
    }

    public OptionOffOn(List<Option> list2, String string, String string2, String string3, String string4) {
        super(list2, string, string2, string3 + " (" + options[0][0] + ", " + options[1][0] + ")", string4);
        this.value = false;
        this.initValue(string4);
    }

    @Override
    public void setValue(String string) {
        boolean bl = Option.getAllowedInteger(string, options) == 1;
        this.changed = bl != (Boolean)this.value;
        this.value = bl;
    }

    @Override
    public String getValue() {
        return options[(Boolean)this.value != false ? 1 : 0][0];
    }

    @Override
    public String[] getPossibleValues() {
        return new String[]{options[0][0], options[1][0]};
    }

    @Override
    public void setToNextValue() {
        this.value = (Boolean)this.value == false;
    }
}


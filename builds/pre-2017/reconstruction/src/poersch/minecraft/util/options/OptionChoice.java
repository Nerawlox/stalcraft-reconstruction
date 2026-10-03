/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.options;

import java.util.List;
import poersch.minecraft.util.options.Option;

public class OptionChoice
extends Option<Integer> {
    public final String[][] options;

    public OptionChoice(String string, String string2, String string3, String string4, String[] stringArray) {
        this((List<Option>)null, string, string2, string3, string4, stringArray);
    }

    public OptionChoice(String string, String string2, String string3, String string4, String[][] stringArray) {
        this((List<Option>)null, string, string2, string3, string4, stringArray);
    }

    public OptionChoice(List<Option> list, String string, String string2, String string3, String string4, String[] stringArray) {
        super(list, string, string2, string3 + " (" + OptionChoice.getOptionsAsString(stringArray) + ")", string4);
        this.options = new String[stringArray.length][1];
        for (int i = 0; i < stringArray.length; ++i) {
            this.options[i][0] = stringArray[i];
        }
        this.value = 0;
        this.initValue(string4);
    }

    public OptionChoice(List<Option> list, String string, String string2, String string3, String string4, String[][] stringArray) {
        super(list, string, string2, string3 + " (" + OptionChoice.getOptionsAsString(stringArray) + ")", string4);
        this.options = stringArray;
        this.value = 0;
        this.initValue(string4);
    }

    @Override
    public void setValue(String string) {
        int n = Option.getAllowedInteger(string, this.options);
        this.changed = n != (Integer)this.value;
        this.value = n;
    }

    @Override
    public String getValue() {
        return this.options[(Integer)this.value][0];
    }

    @Override
    public String[] getPossibleValues() {
        String[] stringArray = new String[this.options.length];
        for (int i = 0; i < this.options.length; ++i) {
            stringArray[i] = this.options[i][0];
        }
        return stringArray;
    }

    @Override
    public void setToNextValue() {
        this.value = (Integer)this.value + 1;
        if ((Integer)this.value >= this.options.length) {
            this.value = 0;
        }
    }

    protected static String getOptionsAsString(String[] stringArray) {
        String string = stringArray[0];
        for (int i = 1; i < stringArray.length; ++i) {
            string = string + ", " + stringArray[i];
        }
        return string;
    }

    protected static String getOptionsAsString(String[][] stringArray) {
        String string = stringArray[0][0];
        for (int i = 1; i < stringArray.length; ++i) {
            string = string + ", " + stringArray[i][0];
        }
        return string;
    }
}


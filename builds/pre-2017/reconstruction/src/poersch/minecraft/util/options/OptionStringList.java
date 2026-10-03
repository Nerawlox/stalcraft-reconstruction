/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.options;

import java.util.Arrays;
import java.util.List;
import poersch.minecraft.util.options.Option;

public class OptionStringList
extends Option<String[]> {
    public OptionStringList(String string, String string2, String string3, String string4) {
        this(null, string, string2, string3, string4);
    }

    public OptionStringList(List<Option> list2, String string, String string2, String string3, String string4) {
        super(list2, string, string2, string3, string4);
        this.value = new String[0];
        this.initValue(string4);
    }

    @Override
    public void setValue(String string) {
        Object[] objectArray = OptionStringList.getTokens(string);
        this.changed = !Arrays.equals(objectArray, (Object[])this.value);
        this.value = objectArray;
    }

    @Override
    public String getValue() {
        if (((String[])this.value).length <= 0) {
            return "";
        }
        String string = ((String[])this.value)[0];
        for (int i = 1; i < ((String[])this.value).length; ++i) {
            string = string + ", " + ((String[])this.value)[i];
        }
        return string;
    }

    @Override
    public String[] getPossibleValues() {
        return new String[]{""};
    }

    @Override
    public void setToNextValue() {
    }
}


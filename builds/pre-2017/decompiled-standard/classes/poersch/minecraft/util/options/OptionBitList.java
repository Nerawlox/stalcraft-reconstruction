/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.options;

import java.util.Arrays;
import java.util.List;
import poersch.minecraft.util.options.Option;

public class OptionBitList
extends Option<Boolean[]> {
    protected final boolean defaultBit;
    protected final int size;

    public OptionBitList(String string, String string2, String string3, String string4, boolean bl, int n) {
        this(null, string, string2, string3, string4, bl, n);
    }

    public OptionBitList(List<Option> list, String string, String string2, String string3, String string4, boolean bl, int n) {
        super(list, string, string2, string3, string4);
        this.size = n;
        this.defaultBit = bl;
        this.value = new Boolean[n];
        Arrays.fill((Object[])this.value, (Object)bl);
        this.initValue(string4);
    }

    @Override
    public void setValue(String string) {
        Object[] objectArray = new Boolean[this.size];
        Arrays.fill(objectArray, (Object)this.defaultBit);
        Integer[] integerArray = OptionBitList.getTokensInt(string);
        boolean bl = !this.defaultBit;
        Integer[] integerArray2 = integerArray;
        int n = integerArray.length;
        for (int i = 0; i < n; ++i) {
            Integer n2 = integerArray2[i];
            if (n2 < 0 || n2 >= objectArray.length) continue;
            objectArray[n2.intValue()] = bl;
        }
        this.changed = Arrays.equals(objectArray, (Object[])this.value);
        this.value = objectArray;
    }

    @Override
    public String getValue() {
        String string = "";
        for (int i = 0; i < ((Boolean[])this.value).length; ++i) {
            if (((Boolean[])this.value)[i] == this.defaultBit) continue;
            string = string + ", " + i;
        }
        return string.length() > 2 ? string.substring(2) : "";
    }

    @Override
    public String[] getPossibleValues() {
        return new String[]{"0", "" + (((Boolean[])this.value).length - 1)};
    }

    @Override
    public void setToNextValue() {
    }
}


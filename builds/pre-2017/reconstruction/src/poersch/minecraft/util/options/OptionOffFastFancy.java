/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.options;

import java.util.List;
import poersch.minecraft.util.options.Option;
import poersch.minecraft.util.options.OptionChoice;

public class OptionOffFastFancy
extends OptionChoice {
    public OptionOffFastFancy(String string, String string2, String string3, String string4) {
        this((List<Option>)null, string, string2, string3, string4);
    }

    public OptionOffFastFancy(List<Option> list2, String string, String string2, String string3, String string4) {
        super(list2, string, string2, string3, string4, new String[][]{{"OFF", "False"}, {"Fast", "ON", "True"}, {"Fancy"}});
    }
}


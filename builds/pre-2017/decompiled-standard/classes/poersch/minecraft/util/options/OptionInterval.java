/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.options;

import java.util.List;
import poersch.minecraft.util.options.Option;

public class OptionInterval
extends Option<Float> {
    public final float minValue;
    public final float maxValue;
    public final float defaultValue;

    public OptionInterval(String string, String string2, String string3, String string4) {
        this(null, string, string2, string3, string4);
    }

    public OptionInterval(List<Option> list2, String string, String string2, String string3, String string4) {
        super(list2, string, string2, string3 + " (0.0 - 1.0)", string4);
        this.defaultValue = Option.getAllowedFloat(string4, 0.0f, 1.0f, 0.5f);
        this.minValue = 0.0f;
        this.maxValue = 1.0f;
        this.value = Float.valueOf(this.defaultValue);
    }

    public OptionInterval(String string, String string2, String string3, String string4, float f, float f2) {
        this(null, string, string2, string3, string4, f, f2);
    }

    public OptionInterval(List<Option> list2, String string, String string2, String string3, String string4, float f, float f2) {
        super(list2, string, string2, string3 + " (" + f + " - " + f2 + ")", string4);
        this.defaultValue = Option.getAllowedFloat(string4, f, f2, f + (f2 - f) * 0.5f);
        this.minValue = f;
        this.maxValue = f2;
        this.value = Float.valueOf(this.defaultValue);
    }

    @Override
    public void setValue(String string) {
        float f = Option.getAllowedFloat(string, this.minValue, this.maxValue, this.defaultValue);
        this.changed = f != ((Float)this.value).floatValue();
        this.value = Float.valueOf(f);
    }

    @Override
    public String getValue() {
        return Float.toString(((Float)this.value).floatValue());
    }

    @Override
    public String[] getPossibleValues() {
        return new String[]{"" + this.minValue, "" + this.maxValue};
    }

    @Override
    public void setToNextValue() {
        float f = (this.maxValue - this.minValue) * 0.2f;
        this.value = ((Float)this.value).floatValue() + f > this.maxValue ? Float.valueOf(this.minValue) : Float.valueOf(((Float)this.value).floatValue() + f);
    }
}


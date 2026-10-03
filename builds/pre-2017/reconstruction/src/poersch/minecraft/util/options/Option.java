/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.options;

import java.util.List;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import poersch.minecraft.util.StringHelper;

public abstract class Option<T> {
    protected Property property;
    protected boolean changed = false;
    public final String id;
    public final String name;
    public final String description;
    public final String defaultValue;
    public T value;

    public Option(List<Option> list, String string, String string2, String string3, String string4) {
        this.id = string;
        this.name = string2;
        this.description = string3;
        this.defaultValue = string4;
        if (list != null) {
            list.add(this);
        }
    }

    public void read(Configuration configuration, String string) {
        this.initValue(this.getProperty(configuration, string));
    }

    public void write() {
        if (this.property != null) {
            this.setProperty(this.getValue());
        }
    }

    public boolean gotChanged() {
        if (this.changed) {
            this.changed = false;
            return true;
        }
        return false;
    }

    protected void initValue(String string) {
        this.setValue(string);
        this.changed = false;
    }

    public abstract void setValue(String var1);

    public abstract String getValue();

    public abstract String[] getPossibleValues();

    public abstract void setToNextValue();

    protected String getProperty(Configuration configuration, String string) {
        this.property = configuration.get(string, this.id, this.defaultValue, this.description);
        return this.property.getString();
    }

    protected void setProperty(String string) {
        this.property.set(string);
    }

    public static int getAllowedInteger(String string, String[][] stringArray) {
        string = string.trim();
        string = string.toLowerCase();
        for (int i = 0; i < stringArray.length; ++i) {
            for (int j = 0; j < stringArray[i].length; ++j) {
                if (!string.equals(stringArray[i][j].toLowerCase())) continue;
                return i;
            }
        }
        return 0;
    }

    public static int getAllowedInteger(String string, String[] stringArray) {
        string = string.trim();
        string = string.toLowerCase();
        for (int i = 0; i < stringArray.length; ++i) {
            if (!string.equals(stringArray[i].toLowerCase())) continue;
            return i;
        }
        return 0;
    }

    public static float getAllowedFloat(String string, float f, float f2, float f3) {
        float f4 = new Float(string).floatValue();
        return new Float(f4 >= f && f4 <= f2 ? f4 : f3).floatValue();
    }

    public static String[] getTokens(String string) {
        return StringHelper.splitTrimToArray(string, ',');
    }

    public static Integer[] getTokensInt(String string) {
        return StringHelper.splitTrimIntegerToArray(string, ',');
    }
}


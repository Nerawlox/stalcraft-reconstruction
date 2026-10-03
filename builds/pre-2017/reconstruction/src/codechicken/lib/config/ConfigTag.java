/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.config;

import codechicken.lib.config.ConfigFile;
import codechicken.lib.config.ConfigTagParent;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class ConfigTag
extends ConfigTagParent {
    private static final Pattern patternRGB = Pattern.compile("(\\d+),(\\d+),(\\d+)");
    public ConfigTagParent parent;
    public String name;
    public String qualifiedname;
    public String value;
    public boolean brace;
    public boolean newline;
    public int position = Integer.MAX_VALUE;
    private int IDBase;

    public ConfigTag(ConfigTagParent configTagParent, String string) {
        this.parent = configTagParent;
        this.name = string;
        this.qualifiedname = configTagParent.getNameQualifier() + string;
        this.newline = configTagParent.newlinemode == 2;
        configTagParent.addChild(this);
    }

    @Override
    public String getNameQualifier() {
        return this.qualifiedname + ".";
    }

    @Override
    public void saveConfig() {
        this.parent.saveConfig();
    }

    public ConfigTag onLoaded() {
        return this;
    }

    public void setValue(String string) {
        this.value = string;
        this.saveConfig();
    }

    public void setDefaultValue(String string) {
        if (this.value == null) {
            this.value = string;
            this.saveConfig();
        }
    }

    public void setIntValue(int n) {
        this.setValue(Integer.toString(n));
    }

    public void setBooleanValue(boolean bl) {
        this.setValue(Boolean.toString(bl));
    }

    public void setHexValue(int n) {
        this.setValue("0x" + Long.toString((long)n << 32 >>> 32, 16));
    }

    public String getValue() {
        return this.value;
    }

    public String getValue(String string) {
        this.setDefaultValue(string);
        return this.value;
    }

    public int getIntValue() {
        return Integer.parseInt(this.getValue());
    }

    public int getIntValue(int n) {
        if (this.value == null) {
            this.setIntValue(n);
        }
        try {
            return this.getIntValue();
        }
        catch (NumberFormatException numberFormatException) {
            this.setIntValue(n);
            return this.getIntValue();
        }
    }

    public boolean getBooleanValue() {
        String string = this.getValue();
        if (string != null && (string.equalsIgnoreCase("true") || string.equalsIgnoreCase("yes"))) {
            return true;
        }
        if (string != null && (string.equalsIgnoreCase("false") || string.equalsIgnoreCase("no"))) {
            return false;
        }
        throw new NumberFormatException(this.qualifiedname + ".value=" + string);
    }

    public boolean getBooleanValue(boolean bl) {
        if (this.value == null) {
            this.setBooleanValue(bl);
        }
        try {
            return this.getBooleanValue();
        }
        catch (NumberFormatException numberFormatException) {
            this.setBooleanValue(bl);
            return this.getBooleanValue();
        }
    }

    public int getHexValue() {
        return (int)Long.parseLong(this.getValue().replace("0x", ""), 16);
    }

    public int getHexValue(int n) {
        if (this.value == null) {
            this.setHexValue(n);
        }
        try {
            return this.getHexValue();
        }
        catch (NumberFormatException numberFormatException) {
            this.setHexValue(n);
            return this.getHexValue();
        }
    }

    public void save(PrintWriter printWriter, int n, String string, boolean bl) {
        String string2 = this.qualifiedname.contains(".") && string.length() > 0 ? this.qualifiedname.substring(string.length() + 1) : this.qualifiedname;
        if (this.newline && !bl) {
            ConfigFile.writeLine(printWriter, "", n);
        }
        this.writeComment(printWriter, n);
        if (this.value != null) {
            ConfigFile.writeLine(printWriter, string2 + "=" + this.value, n);
        }
        if (!this.hasChildTags()) {
            return;
        }
        if (this.brace) {
            if (this.value == null) {
                ConfigFile.writeLine(printWriter, string2, n);
            }
            ConfigFile.writeLine(printWriter, "{", n);
            this.saveTagTree(printWriter, n + 1, this.qualifiedname);
            ConfigFile.writeLine(printWriter, "}", n);
        } else {
            this.saveTagTree(printWriter, n, string);
        }
    }

    @Override
    public ConfigTag setComment(String string) {
        super.setComment(string);
        return this;
    }

    @Override
    public ConfigTag setSortMode(int n) {
        super.setSortMode(n);
        return this;
    }

    public ConfigTag setNewLine(boolean bl) {
        this.newline = bl;
        this.saveConfig();
        return this;
    }

    public ConfigTag useBraces() {
        this.brace = true;
        if (this.parent.newlinemode == 1) {
            this.newline = true;
        }
        this.saveConfig();
        return this;
    }

    public ConfigTag setPosition(int n) {
        this.position = n;
        this.saveConfig();
        return this;
    }

    @Override
    public boolean containsTag(String string) {
        return this.getTag(string, false) != null;
    }

    public int getId(String string, int n) {
        return this.getTag(string).getIntValue(n);
    }

    public int getId(String string) {
        int n = this.getId(string, this.IDBase);
        this.IDBase = n + 1;
        return n;
    }

    public int getAcheivementId(String string, int n) {
        return this.getTag(string).getIntValue(n);
    }

    public ConfigTag setBaseID(int n) {
        this.IDBase = n;
        return this;
    }
}


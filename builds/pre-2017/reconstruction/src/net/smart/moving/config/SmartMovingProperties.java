/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import net.smart.properties.Properties;
import net.smart.properties.Property;

public abstract class SmartMovingProperties
extends Properties {
    public static final String Enabled = "enabled";
    public static final String Disabled = "disabled";
    private static final String[] _defaultKeys = new String[1];
    private int toggler = -2;
    private String[] keys = _defaultKeys;
    public boolean enabled;

    protected void load(Properties ... propertiesArray) throws Exception {
        Iterator iterator2;
        List list2 = this.getProperties();
        if (this.toggler != -2) {
            iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                ((Property)iterator2.next()).reset();
            }
        }
        while (list2.size() > 0) {
            iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                if (!((Property)iterator2.next()).load(propertiesArray)) continue;
                iterator2.remove();
            }
        }
        this.toggler = 0;
        this.update();
    }

    protected void save(File file, String string, boolean bl, boolean bl2) throws Exception {
        List list2 = this.getProperties();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        if (bl) {
            this.printHeader(printWriter);
        }
        if (string != null) {
            this.printVersion(printWriter, string, bl2);
        }
        for (int i = 0; i < list2.size(); ++i) {
            if (!((Property)list2.get(i)).print(printWriter, this.keys, string, bl2) || i >= list2.size() - 1) continue;
            printWriter.println();
        }
        printWriter.close();
    }

    protected abstract void printVersion(PrintWriter var1, String var2, boolean var3);

    protected abstract void printHeader(PrintWriter var1);

    public void toggle() {
        int n = this.keys == null ? 0 : this.keys.length;
        ++this.toggler;
        if (this.toggler == n) {
            this.toggler = -1;
        }
        this.update();
    }

    public void setKeys(String[] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            stringArray = _defaultKeys;
        }
        this.keys = stringArray;
        this.toggler = 0;
        this.update();
    }

    public String getKey(int n) {
        return this.keys[n] == null ? Enabled : this.keys[n];
    }

    public String getNextKey(String string) {
        if (string != null && !string.equals(Disabled)) {
            int n;
            for (n = 0; !(n >= this.keys.length || string == null && this.keys[n] == null || string != null && string.equals(this.keys[n])); ++n) {
            }
            return ++n < this.keys.length ? this.keys[n] : Disabled;
        }
        return this.getKey(0);
    }

    public void setCurrentKey(String string) {
        if (string != null && !string.equals(Disabled)) {
            if (this.keys.length == 1 && this.keys[0] == null && string.equals(Enabled)) {
                this.toggler = 0;
            } else {
                this.toggler = 0;
                while (!(this.toggler >= this.keys.length || string == null && this.keys[this.toggler] == null || string != null && string.equals(this.keys[this.toggler]))) {
                    ++this.toggler;
                }
                if (this.toggler == this.keys.length) {
                    this.toggler = -1;
                }
            }
        } else {
            this.toggler = -1;
        }
        this.update();
    }

    public String getCurrentKey() {
        return this.toggler == -1 ? Disabled : this.keys[this.toggler];
    }

    public boolean hasKey(String string) {
        if (Enabled.equals(string)) {
            return this.keys[0] == null;
        }
        if (Disabled.equals(string)) {
            return true;
        }
        for (int i = 0; i < this.keys.length; ++i) {
            if ((string != null || this.keys[i] != null) && (string == null || !string.equals(this.keys[i]))) continue;
            return true;
        }
        return false;
    }

    public int getKeyCount() {
        return this.keys.length;
    }

    protected void update() {
        List list2 = this.getProperties();
        Iterator iterator2 = list2.iterator();
        String string = this.getCurrentKey();
        while (iterator2.hasNext()) {
            ((Property)iterator2.next()).update(string);
        }
        this.enabled = this.toggler != -1;
    }
}


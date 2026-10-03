/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.config;

import codechicken.lib.config.ConfigFile;
import codechicken.lib.config.ConfigTag;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public abstract class ConfigTagParent {
    private TreeMap<String, ConfigTag> childtags = new TreeMap();
    public String comment;
    public int sortMode = 0;
    public int newlinemode = 1;

    public abstract void saveConfig();

    public abstract String getNameQualifier();

    public ConfigTagParent setComment(String string) {
        this.comment = string;
        this.saveConfig();
        return this;
    }

    public ConfigTagParent setSortMode(int n) {
        this.sortMode = n;
        this.saveConfig();
        return this;
    }

    public ConfigTagParent setNewLineMode(int n) {
        this.newlinemode = n;
        for (Map.Entry<String, ConfigTag> entry : this.childtags.entrySet()) {
            ConfigTag configTag = entry.getValue();
            if (this.newlinemode == 0) {
                configTag.newline = false;
                continue;
            }
            if (this.newlinemode == 1) {
                configTag.newline = configTag.brace;
                continue;
            }
            if (this.newlinemode != 2) continue;
            configTag.newline = true;
        }
        this.saveConfig();
        return this;
    }

    public Map<String, ConfigTag> childTagMap() {
        return this.childtags;
    }

    public boolean hasChildTags() {
        return !this.childtags.isEmpty();
    }

    public boolean containsTag(String string) {
        return this.getTag(string, false) != null;
    }

    public ConfigTag getNewTag(String string) {
        return new ConfigTag(this, string);
    }

    public ConfigTag getTag(String string, boolean bl) {
        int n = string.indexOf(".");
        String string2 = n == -1 ? string : string.substring(0, n);
        ConfigTag configTag = this.childtags.get(string2);
        if (configTag == null) {
            if (!bl) {
                return null;
            }
            configTag = this.getNewTag(string2);
            this.saveConfig();
        }
        if (n == -1) {
            return configTag;
        }
        return configTag.getTag(string.substring(n + 1), bl);
    }

    public ConfigTag getTag(String string) {
        return this.getTag(string, true);
    }

    public boolean removeTag(String string) {
        String string2;
        ConfigTag configTag = this.getTag(string, false);
        if (configTag == null) {
            return false;
        }
        int n = string.lastIndexOf(".");
        String string3 = string2 = n == -1 ? string : string.substring(n + 1, string.length());
        if (configTag.parent != null) {
            boolean bl;
            boolean bl2 = bl = configTag.parent.childtags.remove(string2) != null;
            if (bl) {
                this.saveConfig();
            }
            return bl;
        }
        return false;
    }

    public void addChild(ConfigTag configTag) {
        this.childtags.put(configTag.name, configTag);
    }

    public <T extends ConfigTag> ArrayList<T> getSortedTagList() {
        ArrayList<ConfigTag> arrayList = new ArrayList<ConfigTag>(this.childtags.size());
        for (Map.Entry<String, ConfigTag> entry : this.childtags.entrySet()) {
            arrayList.add(entry.getValue());
        }
        Collections.sort(arrayList, new TagOrderComparator(this.sortMode));
        return arrayList;
    }

    public void loadChildren(BufferedReader bufferedReader) {
        String string = "";
        String string2 = "";
        try {
            String string3;
            while ((string3 = ConfigFile.readLine(bufferedReader)) != null) {
                if (string3.startsWith("#")) {
                    if (string == null || string.equals("")) {
                        string = string3.substring(1);
                        continue;
                    }
                    string = string + "\n" + string3.substring(1);
                    continue;
                }
                if (string3.contains("=")) {
                    String string4 = string3.substring(0, string3.indexOf("="));
                    this.getTag(string4).onLoaded().setComment(string).setValue(string3.substring(string3.indexOf("=") + 1));
                    string = "";
                    string2 = string4;
                    continue;
                }
                if (string3.equals("{")) {
                    this.getTag(string2).setComment(string).useBraces().loadChildren(bufferedReader);
                    string = "";
                    string2 = "";
                    continue;
                }
                if (!string3.equals("}")) {
                    string2 = string3;
                    continue;
                }
                break;
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public void saveTagTree(PrintWriter printWriter, int n, String string) {
        boolean bl = true;
        for (ConfigTag configTag : this.getSortedTagList()) {
            configTag.save(printWriter, n, string, bl);
            bl = false;
        }
    }

    public void writeComment(PrintWriter printWriter, int n) {
        if (this.comment != null && !this.comment.equals("")) {
            String[] stringArray = this.comment.split("\n");
            for (int i = 0; i < stringArray.length; ++i) {
                ConfigFile.writeLine(printWriter, "#" + stringArray[i], n);
            }
        }
    }

    public static class TagOrderComparator
    implements Comparator<ConfigTag> {
        int sortMode;

        public TagOrderComparator(int n) {
            this.sortMode = n;
        }

        @Override
        public int compare(ConfigTag configTag, ConfigTag configTag2) {
            if (configTag.position != configTag2.position) {
                return this.compareInt(configTag.position, configTag2.position);
            }
            if (configTag.brace != configTag2.brace) {
                return configTag.brace ? 1 : -1;
            }
            switch (this.sortMode) {
                case 1: {
                    if (configTag.value == configTag2.value) {
                        return 0;
                    }
                    if (configTag.value == null) {
                        return 1;
                    }
                    if (configTag2.value == null) {
                        return -1;
                    }
                    return configTag.value.compareTo(configTag2.value);
                }
            }
            return configTag.name.compareTo(configTag2.name);
        }

        private int compareInt(int n, int n2) {
            return n == n2 ? 0 : (n < n2 ? -1 : 1);
        }
    }
}


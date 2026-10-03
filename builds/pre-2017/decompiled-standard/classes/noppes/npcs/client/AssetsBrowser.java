/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class AssetsBrowser {
    public static final List<String> allFilenames = srxe._a("/assets/customnpcs/");
    public boolean isRoot;
    public HashSet<String> folders = new HashSet();
    public HashSet<String> files = new HashSet();
    private int depth;
    private String folder;
    private String[] extensions;

    public AssetsBrowser(String string, String[] stringArray) {
        this.extensions = stringArray;
        this.setFolder(string);
    }

    public AssetsBrowser(String[] stringArray) {
        this.extensions = stringArray;
    }

    public static String getRoot(String string) {
        String string2;
        String string3 = "minecraft";
        int n = string.indexOf(":");
        if (n > 0) {
            string3 = string.substring(0, n);
            string = string.substring(n + 1);
        }
        if (string.startsWith("/")) {
            string = string.substring(1);
        }
        if ((n = (string2 = "/" + string3 + "/" + string).lastIndexOf("/")) > 0) {
            string2 = string2.substring(0, n);
        }
        return string2;
    }

    public void setFolder(String string) {
        if (!string.endsWith("/")) {
            string = string + "/";
        }
        this.isRoot = string.length() <= 1;
        this.folder = "/assets" + string;
        this.depth = StringUtils.countMatches(this.folder, "/");
        this.getFiles();
    }

    private void getFiles() {
        this.folders.clear();
        this.files.clear();
        for (String string : allFilenames) {
            if (!string.startsWith(this.folder)) continue;
            String string2 = string.substring(this.folder.length());
            int n = string2.indexOf(47);
            if (n >= 0) {
                this.folders.add(string2.substring(0, n));
                continue;
            }
            if (!this.validExtension(string2)) continue;
            this.files.add(string2);
        }
    }

    private boolean validExtension(String string) {
        int n = string.lastIndexOf(".");
        if (n < 0) {
            return false;
        }
        String string2 = string.substring(n + 1);
        for (String string3 : this.extensions) {
            if (!string3.equalsIgnoreCase(string2)) continue;
            return true;
        }
        return false;
    }

    public String getAsset(String string) {
        String[] stringArray = this.folder.split("/");
        if (stringArray.length < 3) {
            return null;
        }
        String string2 = stringArray[2] + ":";
        string2 = string2 + this.folder.substring(string2.length() + 8) + string;
        return string2;
    }
}


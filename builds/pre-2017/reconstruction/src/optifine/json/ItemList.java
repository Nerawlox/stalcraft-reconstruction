/*
 * Decompiled with CFR 0.152.
 */
package optifine.json;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ItemList {
    private String sp = ",";
    List items = new ArrayList();

    public ItemList() {
    }

    public ItemList(String string) {
        this.split(string, this.sp, this.items);
    }

    public ItemList(String string, String string2) {
        this.sp = string;
        this.split(string, string2, this.items);
    }

    public ItemList(String string, String string2, boolean bl) {
        this.split(string, string2, this.items, bl);
    }

    public List getItems() {
        return this.items;
    }

    public String[] getArray() {
        return (String[])this.items.toArray();
    }

    public void split(String string, String string2, List list2, boolean bl) {
        if (string != null && string2 != null) {
            if (bl) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
                while (stringTokenizer.hasMoreTokens()) {
                    list2.add(stringTokenizer.nextToken().trim());
                }
            } else {
                this.split(string, string2, list2);
            }
        }
    }

    public void split(String string, String string2, List list2) {
        if (string != null && string2 != null) {
            int n;
            int n2 = 0;
            boolean bl = false;
            do {
                n = n2;
                if ((n2 = string.indexOf(string2, n2)) == -1) break;
                list2.add(string.substring(n, n2).trim());
            } while ((n2 += string2.length()) != -1);
            list2.add(string.substring(n).trim());
        }
    }

    public void setSP(String string) {
        this.sp = string;
    }

    public void add(int n, String string) {
        if (string != null) {
            this.items.add(n, string.trim());
        }
    }

    public void add(String string) {
        if (string != null) {
            this.items.add(string.trim());
        }
    }

    public void addAll(ItemList itemList) {
        this.items.addAll(itemList.items);
    }

    public void addAll(String string) {
        this.split(string, this.sp, this.items);
    }

    public void addAll(String string, String string2) {
        this.split(string, string2, this.items);
    }

    public void addAll(String string, String string2, boolean bl) {
        this.split(string, string2, this.items, bl);
    }

    public String get(int n) {
        return (String)this.items.get(n);
    }

    public int size() {
        return this.items.size();
    }

    public String toString() {
        return this.toString(this.sp);
    }

    public String toString(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.items.size(); ++i) {
            if (i == 0) {
                stringBuffer.append(this.items.get(i));
                continue;
            }
            stringBuffer.append(string);
            stringBuffer.append(this.items.get(i));
        }
        return stringBuffer.toString();
    }

    public void clear() {
        this.items.clear();
    }

    public void reset() {
        this.sp = ",";
        this.items.clear();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.lib.inventory.ItemKey;
import codechicken.nei.DropDownFile;
import codechicken.nei.ItemList;
import codechicken.nei.ItemVisibilityHash;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import java.util.ArrayList;
import java.util.HashSet;

public class ItemRange {
    public int firstID;
    public int firstDamage = -1;
    public int lastID;
    public int lastDamage = -1;
    public byte state = 0;
    public HashSet<ItemKey> encompassedhash = new HashSet();
    public ArrayList<ItemKey> encompasseditems = new ArrayList();

    public ItemRange(int n) {
        this.firstID = n;
        this.firstDamage = -1;
        this.lastID = n;
        this.lastDamage = -1;
    }

    public ItemRange(int n, int n2, int n3) {
        this.firstID = n;
        this.firstDamage = n2;
        this.lastID = n;
        this.lastDamage = n3;
    }

    public ItemRange(int n, int n2) {
        this.firstID = n;
        this.firstDamage = -1;
        this.lastID = n2;
        this.lastDamage = -1;
    }

    public boolean isItemInRange(int n, int n2) {
        return n >= this.firstID && n <= this.lastID && (this.firstDamage == -1 || n2 >= this.firstDamage && n2 <= this.lastDamage);
    }

    public String toString() {
        if (this.firstID == this.lastID) {
            if (this.firstDamage == -1) {
                return "[" + this.firstID + "]";
            }
            if (this.firstDamage == this.lastDamage) {
                return "[" + this.firstID + ":" + this.firstDamage + "]";
            }
            return "[" + this.firstID + ":" + this.firstDamage + "-" + this.lastDamage + "]";
        }
        return "[" + this.firstID + "-" + this.lastID + "]";
    }

    public ItemRange(String string) {
        string = string.replace(" ", "");
        string = string.replace("\t", "");
        string = string.substring(1, string.length() - 1);
        String[] stringArray = string.split(":");
        if (stringArray.length == 2) {
            String[] stringArray2 = stringArray[1].split("-");
            this.lastID = this.firstID = Integer.parseInt(stringArray[0]);
            this.firstDamage = Integer.parseInt(stringArray2[0]);
            this.lastDamage = stringArray2.length == 2 ? Integer.parseInt(stringArray2[1]) : this.firstDamage;
        } else {
            String[] stringArray3 = stringArray[0].split("-");
            this.firstID = Integer.parseInt(stringArray3[0]);
            this.lastID = stringArray3.length == 2 ? Integer.parseInt(stringArray3[1]) : this.firstID;
        }
    }

    public synchronized void updateState(ItemVisibilityHash itemVisibilityHash) {
        boolean bl = false;
        boolean bl2 = false;
        for (ItemKey itemKey : this.encompasseditems) {
            if (itemVisibilityHash.isItemHidden(itemKey)) {
                if (bl2) {
                    this.state = 1;
                    return;
                }
                bl = true;
                continue;
            }
            if (bl) {
                this.state = 1;
                return;
            }
            bl2 = true;
        }
        this.state = bl2 ? (byte)2 : (byte)0;
    }

    public synchronized void resetHashes() {
        this.encompassedhash.clear();
        this.encompasseditems.clear();
    }

    public synchronized boolean addItemIfInRange(int n, int n2, qoac qoac2) {
        ItemKey itemKey;
        if (this.isItemInRange(n, n2) && this.encompassedhash.add(itemKey = new ItemKey(n, n2, qoac2))) {
            this.encompasseditems.add(itemKey);
            return true;
        }
        return false;
    }

    public void onClick(int n, int n2, boolean bl) {
        ItemVisibilityHash itemVisibilityHash = NEIClientConfig.vishash;
        ItemKey itemKey = this.encompasseditems.get(n);
        if (NEIClientUtils.controlKey()) {
            NEIClientUtils.cheatItem(itemKey.item, n2, 0);
            return;
        }
        if (n2 == 0) {
            if (bl) {
                DropDownFile.dropDownInstance.hideAllItems();
            }
            itemVisibilityHash.unhideItem(itemKey);
        } else if (n2 == 1) {
            itemVisibilityHash.hideItem(itemKey);
        }
        DropDownFile.dropDownInstance.updateState();
        ItemList.updateSearch();
        NEIClientConfig.vishash.save();
    }

    public synchronized void hideAllItems() {
        ItemVisibilityHash itemVisibilityHash = NEIClientConfig.vishash;
        for (ItemKey itemKey : this.encompasseditems) {
            itemVisibilityHash.hideItem(itemKey);
        }
    }

    public synchronized void showAllItems() {
        ItemVisibilityHash itemVisibilityHash = NEIClientConfig.vishash;
        for (ItemKey itemKey : this.encompasseditems) {
            itemVisibilityHash.unhideItem(itemKey);
        }
    }

    public ArrayList<Integer> toIDList() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = this.firstID; i <= this.lastID; ++i) {
            arrayList.add(i);
        }
        return arrayList;
    }
}


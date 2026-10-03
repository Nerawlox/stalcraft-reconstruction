/*
 * Decompiled with CFR 0.152.
 */
package atomicstryker.dynamiclights.client;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ItemConfigHelper {
    private final String SWILDCARD = "*";
    private final int WILDCARD = -1;
    private Map<ItemData, Integer> dataMap = new HashMap<ItemData, Integer>();

    public ItemConfigHelper(String string, int n) {
        for (String string2 : string.split(",")) {
            try {
                String[] stringArray = string2.split("=");
                ItemData itemData = this.fromString(stringArray[0]);
                if (itemData.startID != 0) {
                    this.dataMap.put(itemData, stringArray.length > 1 ? Integer.parseInt(stringArray[1]) : n);
                    continue;
                }
                System.out.println("Failed to match String [" + string2 + "] to a Block or Item, skipping.");
            }
            catch (Exception exception) {
                System.err.println("Error, String [" + string2 + "] is not a valid Entry, skipping.");
                exception.printStackTrace();
            }
        }
    }

    public int retrieveValue(int n, int n2) {
        for (ItemData itemData : this.dataMap.keySet()) {
            if (!itemData.matches(n, n2)) continue;
            return this.dataMap.get(itemData);
        }
        return -1;
    }

    private ItemData fromString(String string) {
        int n;
        int n2;
        String[] stringArray = string.split("-");
        int n3 = stringArray.length;
        int n4 = this.tryFindingItemID(stringArray[0]);
        int n5 = n2 = n3 > 3 ? this.tryFindingItemID(stringArray[1]) : n4;
        int n6 = n3 > 1 ? this.catchWildcard(stringArray[n3 > 3 ? 2 : 1]) : (n = -1);
        int n7 = n3 > 2 ? this.catchWildcard(stringArray[n3 > 3 ? 3 : 2]) : n;
        return new ItemData(n4, n2, n, n7);
    }

    private int tryFindingItemID(String string) {
        try {
            return this.catchWildcard(string);
        }
        catch (NumberFormatException numberFormatException) {
            for (Item object : Item.itemsList) {
                if (object == null || !object.getUnlocalizedName().equals(string)) continue;
                return object.itemID;
            }
            for (Block block : Block.blocksList) {
                if (block == null || !block.getUnlocalizedName().equals(string)) continue;
                return block.blockID;
            }
            return 0;
        }
    }

    private int catchWildcard(String string) {
        if (string.equals("*")) {
            return -1;
        }
        return Integer.parseInt(string);
    }

    private class ItemData
    implements Comparable<ItemData> {
        final int startID;
        final int endID;
        final int startMeta;
        final int endMeta;

        public ItemData(int n, int n2, int n3, int n4) {
            this.startID = n;
            this.endID = n2;
            this.startMeta = n3;
            this.endMeta = n4;
        }

        public String toString() {
            return String.format("%d-%d-%d-%d", this.startID, this.endID, this.startMeta, this.endMeta);
        }

        public boolean matches(int n, int n2) {
            return this.isContained(this.startID, this.endID, n) && this.isContained(this.startMeta, this.endMeta, n2);
        }

        private boolean isContained(int n, int n2, int n3) {
            return !(n != -1 && n3 < n || n2 != -1 && n3 > n2);
        }

        @Override
        public int compareTo(ItemData itemData) {
            return this.startID < itemData.startID ? -1 : (this.startID > itemData.startID ? 1 : 0);
        }

        public boolean equals(Object object) {
            if (object instanceof ItemData) {
                ItemData itemData = (ItemData)object;
                return itemData.startID == this.startID && itemData.endID == this.endID && itemData.startMeta == this.startMeta && itemData.endMeta == this.endMeta;
            }
            return false;
        }

        public int hashCode() {
            return this.startID + this.endID + this.startMeta + this.endMeta;
        }
    }
}


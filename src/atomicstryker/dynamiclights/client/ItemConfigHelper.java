/*
 * Decompiled with CFR 0.152.
 */
package atomicstryker.dynamiclights.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ItemConfigHelper {
    private final String SWILDCARD = "*";
    private final int WILDCARD = -1;
    private Map dataMap = new HashMap();

    public ItemConfigHelper(String configLine, int defaultValue) {
        for (String s2 : configLine.split(",")) {
            try {
                String[] e = s2.split("=");
                ItemData item = this.fromString(e[0]);
                if (item.startID != 0) {
                    this.dataMap.put(item, e.length > 1 ? Integer.parseInt(e[1]) : defaultValue);
                    continue;
                }
                System.out.println("Failed to match String [" + s2 + "] to a Block or Item, skipping.");
            }
            catch (Exception var9) {
                System.err.println("Error, String [" + s2 + "] is not a valid Entry, skipping.");
                var9.printStackTrace();
            }
        }
    }

    public int retrieveValue(int id, int meta) {
        ItemData item;
        Iterator i$ = this.dataMap.keySet().iterator();
        do {
            if (i$.hasNext()) continue;
            return -1;
        } while (!(item = (ItemData)i$.next()).matches(id, meta));
        return (Integer)this.dataMap.get(item);
    }

    private ItemData fromString(String s2) {
        int sm2;
        int eid;
        String[] strings = s2.split("-");
        int len = strings.length;
        int sid = this.tryFindingItemID(strings[0]);
        int n = eid = len > 3 ? this.tryFindingItemID(strings[1]) : sid;
        int n2 = len > 1 ? this.catchWildcard(strings[len > 3 ? 2 : 1]) : (sm2 = -1);
        int em = len > 2 ? this.catchWildcard(strings[len > 3 ? 3 : 2]) : sm2;
        return new ItemData(sid, eid, sm2, em);
    }

    private int tryFindingItemID(String s2) {
        try {
            return this.catchWildcard(s2);
        }
        catch (NumberFormatException var7) {
            for (yc block : yc.g) {
                if (block == null || !block.a().equals(s2)) continue;
                return block.cv;
            }
            for (aqz var9 : aqz.s) {
                if (var9 == null || !var9.a().equals(s2)) continue;
                return var9.cF;
            }
            return 0;
        }
    }

    private int catchWildcard(String s2) {
        return s2.equals("*") ? -1 : Integer.parseInt(s2);
    }

    private class ItemData
    implements Comparable {
        final int startID;
        final int endID;
        final int startMeta;
        final int endMeta;

        public ItemData(int sid, int eid, int sm2, int em) {
            this.startID = sid;
            this.endID = eid;
            this.startMeta = sm2;
            this.endMeta = em;
        }

        public String toString() {
            return String.format("%d-%d-%d-%d", this.startID, this.endID, this.startMeta, this.endMeta);
        }

        public boolean matches(int id, int meta) {
            return this.isContained(this.startID, this.endID, id) && this.isContained(this.startMeta, this.endMeta, meta);
        }

        private boolean isContained(int s2, int e, int i) {
            return !(s2 != -1 && i < s2 || e != -1 && i > e);
        }

        public boolean equals(Object o) {
            if (!(o instanceof ItemData)) {
                return false;
            }
            ItemData i = (ItemData)o;
            return i.startID == this.startID && i.endID == this.endID && i.startMeta == this.startMeta && i.endMeta == this.endMeta;
        }

        public int hashCode() {
            return this.startID + this.endID + this.startMeta + this.endMeta;
        }

        public int compareTo(Object arg0) {
            ItemData i = (ItemData)arg0;
            return this.startID < i.startID ? -1 : (this.startID > i.startID ? 1 : 0);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.lib.inventory.ItemKey;
import codechicken.nei.DropDownFile;
import codechicken.nei.ItemList;
import codechicken.nei.NEIClientConfig;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ItemVisibilityHash {
    private static boolean[] statesSaved = new boolean[7];
    public TreeMap<Integer, IDInfo> hiddenitems;

    public ItemVisibilityHash() {
        try {
            this.loadFromCompound(this.getCurrentSaveCompound());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public qoac getCurrentSaveCompound() {
        qoac qoac2 = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (huhy)qoac2);
        qoac qoac3 = qoac2._m("current");
        qoac2._a("current", qoac3);
        return qoac3;
    }

    public void hideItem(int n, int n2) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            iDInfo = new IDInfo();
            this.hiddenitems.put(n, iDInfo);
        }
        iDInfo.damages.add(n2);
    }

    public void hideItem(int n, qoac qoac2) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            iDInfo = new IDInfo();
            this.hiddenitems.put(n, iDInfo);
        }
        if (!iDInfo.compounds.contains(qoac2)) {
            iDInfo.compounds.add(qoac2);
        }
    }

    public void hideItem(ItemKey itemKey) {
        if (itemKey.item._p()) {
            this.hideItem(itemKey.item._d, itemKey.item._q());
        } else {
            this.hideItem(itemKey.item._d, itemKey.item._j());
        }
    }

    public void unhideItem(int n, int n2) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            return;
        }
        if (n2 == -1) {
            this.hiddenitems.remove(n);
        } else {
            iDInfo.damages.remove(n2);
        }
    }

    public void unhideItem(int n, qoac qoac2) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            return;
        }
        iDInfo.compounds.remove(qoac2);
    }

    public void unhideItem(ItemKey itemKey) {
        if (itemKey.item._p()) {
            this.unhideItem(itemKey.item._d, itemKey.item._q());
        } else {
            this.unhideItem(itemKey.item._d, itemKey.item._j());
        }
    }

    public boolean isItemHidden(int n, int n2) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            return false;
        }
        return iDInfo.damages.contains(n2) || iDInfo.damages.contains(-1);
    }

    public boolean isItemHidden(int n, qoac qoac2) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            return false;
        }
        return iDInfo.compounds.contains(qoac2);
    }

    public boolean isItemHidden(ItemKey itemKey) {
        IDInfo iDInfo = this.hiddenitems.get(itemKey.item._d);
        if (iDInfo == null) {
            return false;
        }
        if (iDInfo.damages.contains(itemKey.item._j()) || iDInfo.damages.contains(-1)) {
            return true;
        }
        if (itemKey.item._p()) {
            return iDInfo.compounds.contains(itemKey.item._q());
        }
        return false;
    }

    private void loadFromCompound(qoac qoac2) {
        this.hiddenitems = new TreeMap();
        for (Object e : qoac2._d()) {
            int n;
            IDInfo iDInfo;
            int n2;
            huhy huhy2;
            if (e instanceof bsyv) {
                huhy2 = (bsyv)e;
                n2 = Integer.parseInt(huhy2._b().substring(1));
                iDInfo = this.hiddenitems.get(n2);
                if (iDInfo == null) {
                    iDInfo = new IDInfo();
                    this.hiddenitems.put(n2, iDInfo);
                }
                for (n = 0; n < ((bsyv)huhy2)._d(); ++n) {
                    qoac qoac3 = (qoac)((bsyv)huhy2)._b(n);
                    qoac3._a("tag");
                    iDInfo.compounds.add(qoac3);
                }
                continue;
            }
            if (!(e instanceof yvxd)) continue;
            huhy2 = (yvxd)e;
            n2 = Integer.parseInt(huhy2._b().substring(1));
            iDInfo = this.hiddenitems.get(n2);
            if (iDInfo == null) {
                iDInfo = new IDInfo();
                this.hiddenitems.put(n2, iDInfo);
            }
            for (n = 0; n < ((yvxd)huhy2)._c.length / 2; ++n) {
                iDInfo.damages.add((((yvxd)huhy2)._c[n * 2] << 8) + ((yvxd)huhy2)._c[n * 2 + 1]);
            }
        }
    }

    public void save() {
        qoac qoac2 = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (huhy)qoac2);
        qoac2._a("current", this.constructSaveCompound());
        NEIClientConfig.global.saveNBT();
    }

    private qoac constructSaveCompound() {
        qoac qoac2 = new qoac();
        for (Map.Entry<Integer, IDInfo> entry : this.hiddenitems.entrySet()) {
            Object object2;
            int n = entry.getKey();
            IDInfo iDInfo = entry.getValue();
            if (iDInfo.compounds.size() > 0) {
                object2 = new bsyv();
                for (qoac qoac3 : iDInfo.compounds) {
                    ((bsyv)object2)._a(qoac3);
                }
                qoac2._a("c" + n, (huhy)object2);
            }
            if (iDInfo.damages.size() <= 0) continue;
            object2 = new byte[iDInfo.damages.size() * 2];
            int n2 = 0;
            for (int n3 : iDInfo.damages) {
                object2[n2 * 2] = (byte)(n3 >> 8);
                object2[n2 * 2 + 1] = (byte)n3;
                ++n2;
            }
            qoac2._a("d" + n, (byte[])object2);
        }
        return qoac2;
    }

    public static void loadStates() {
        qoac qoac2 = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (huhy)qoac2);
        for (int i = 0; i < 7; ++i) {
            qoac qoac3 = qoac2._m("save" + i);
            if (qoac3._d().size() <= 0) continue;
            ItemVisibilityHash.statesSaved[i] = true;
        }
    }

    public void loadState(int n) {
        qoac qoac2 = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (huhy)qoac2);
        this.loadFromCompound(qoac2._m("save" + n));
        DropDownFile.dropDownInstance.updateState();
        ItemList.updateSearch();
        NEIClientConfig.vishash.save();
    }

    public void saveState(int n) {
        qoac qoac2 = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (huhy)qoac2);
        qoac qoac3 = this.getCurrentSaveCompound();
        qoac3._a("saved", true);
        qoac2._a("save" + n, qoac3);
        ItemVisibilityHash.statesSaved[n] = true;
        NEIClientConfig.global.saveNBT();
    }

    public void clearState(int n) {
        qoac qoac2 = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (huhy)qoac2);
        qoac2._a("save" + n, new qoac());
        NEIClientConfig.global.saveNBT();
        ItemVisibilityHash.statesSaved[n] = false;
    }

    public static boolean isStateSaved(int n) {
        return statesSaved[n];
    }

    public static class IDInfo {
        public TreeSet<Integer> damages = new TreeSet();
        public ArrayList<qoac> compounds = new ArrayList();
    }
}


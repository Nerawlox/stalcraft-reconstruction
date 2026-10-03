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
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

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

    public NBTTagCompound getCurrentSaveCompound() {
        NBTTagCompound nBTTagCompound = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (NBTBase)nBTTagCompound);
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("current");
        nBTTagCompound._a("current", nBTTagCompound2);
        return nBTTagCompound2;
    }

    public void hideItem(int n, int n2) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            iDInfo = new IDInfo();
            this.hiddenitems.put(n, iDInfo);
        }
        iDInfo.damages.add(n2);
    }

    public void hideItem(int n, NBTTagCompound nBTTagCompound) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            iDInfo = new IDInfo();
            this.hiddenitems.put(n, iDInfo);
        }
        if (!iDInfo.compounds.contains(nBTTagCompound)) {
            iDInfo.compounds.add(nBTTagCompound);
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

    public void unhideItem(int n, NBTTagCompound nBTTagCompound) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            return;
        }
        iDInfo.compounds.remove(nBTTagCompound);
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

    public boolean isItemHidden(int n, NBTTagCompound nBTTagCompound) {
        IDInfo iDInfo = this.hiddenitems.get(n);
        if (iDInfo == null) {
            return false;
        }
        return iDInfo.compounds.contains(nBTTagCompound);
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

    private void loadFromCompound(NBTTagCompound nBTTagCompound) {
        this.hiddenitems = new TreeMap();
        for (Object e : nBTTagCompound._d()) {
            int n;
            IDInfo iDInfo;
            int n2;
            NBTBase nBTBase;
            if (e instanceof NBTTagList) {
                nBTBase = (NBTTagList)e;
                n2 = Integer.parseInt(nBTBase._b().substring(1));
                iDInfo = this.hiddenitems.get(n2);
                if (iDInfo == null) {
                    iDInfo = new IDInfo();
                    this.hiddenitems.put(n2, iDInfo);
                }
                for (n = 0; n < ((NBTTagList)nBTBase)._d(); ++n) {
                    NBTTagCompound nBTTagCompound2 = (NBTTagCompound)((NBTTagList)nBTBase)._b(n);
                    nBTTagCompound2._a("tag");
                    iDInfo.compounds.add(nBTTagCompound2);
                }
                continue;
            }
            if (!(e instanceof yvxd)) continue;
            nBTBase = (yvxd)e;
            n2 = Integer.parseInt(nBTBase._b().substring(1));
            iDInfo = this.hiddenitems.get(n2);
            if (iDInfo == null) {
                iDInfo = new IDInfo();
                this.hiddenitems.put(n2, iDInfo);
            }
            for (n = 0; n < ((yvxd)nBTBase)._c.length / 2; ++n) {
                iDInfo.damages.add((((yvxd)nBTBase)._c[n * 2] << 8) + ((yvxd)nBTBase)._c[n * 2 + 1]);
            }
        }
    }

    public void save() {
        NBTTagCompound nBTTagCompound = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (NBTBase)nBTTagCompound);
        nBTTagCompound._a("current", this.constructSaveCompound());
        NEIClientConfig.global.saveNBT();
    }

    private NBTTagCompound constructSaveCompound() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        for (Map.Entry<Integer, IDInfo> entry : this.hiddenitems.entrySet()) {
            Object object2;
            int n = entry.getKey();
            IDInfo iDInfo = entry.getValue();
            if (iDInfo.compounds.size() > 0) {
                object2 = new NBTTagList();
                for (NBTTagCompound nBTTagCompound2 : iDInfo.compounds) {
                    ((NBTTagList)object2)._a(nBTTagCompound2);
                }
                nBTTagCompound._a("c" + n, (NBTBase)object2);
            }
            if (iDInfo.damages.size() <= 0) continue;
            object2 = new byte[iDInfo.damages.size() * 2];
            int n2 = 0;
            for (int n3 : iDInfo.damages) {
                object2[n2 * 2] = (byte)(n3 >> 8);
                object2[n2 * 2 + 1] = (byte)n3;
                ++n2;
            }
            nBTTagCompound._a("d" + n, (byte[])object2);
        }
        return nBTTagCompound;
    }

    public static void loadStates() {
        NBTTagCompound nBTTagCompound = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (NBTBase)nBTTagCompound);
        for (int i = 0; i < 7; ++i) {
            NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("save" + i);
            if (nBTTagCompound2._d().size() <= 0) continue;
            ItemVisibilityHash.statesSaved[i] = true;
        }
    }

    public void loadState(int n) {
        NBTTagCompound nBTTagCompound = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (NBTBase)nBTTagCompound);
        this.loadFromCompound(nBTTagCompound._m("save" + n));
        DropDownFile.dropDownInstance.updateState();
        ItemList.updateSearch();
        NEIClientConfig.vishash.save();
    }

    public void saveState(int n) {
        NBTTagCompound nBTTagCompound = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (NBTBase)nBTTagCompound);
        NBTTagCompound nBTTagCompound2 = this.getCurrentSaveCompound();
        nBTTagCompound2._a("saved", true);
        nBTTagCompound._a("save" + n, nBTTagCompound2);
        ItemVisibilityHash.statesSaved[n] = true;
        NEIClientConfig.global.saveNBT();
    }

    public void clearState(int n) {
        NBTTagCompound nBTTagCompound = NEIClientConfig.global.nbt._m("vis");
        NEIClientConfig.global.nbt._a("vis", (NBTBase)nBTTagCompound);
        nBTTagCompound._a("save" + n, new NBTTagCompound());
        NEIClientConfig.global.saveNBT();
        ItemVisibilityHash.statesSaved[n] = false;
    }

    public static boolean isStateSaved(int n) {
        return statesSaved[n];
    }

    public static class IDInfo {
        public TreeSet<Integer> damages = new TreeSet();
        public ArrayList<NBTTagCompound> compounds = new ArrayList();
    }
}


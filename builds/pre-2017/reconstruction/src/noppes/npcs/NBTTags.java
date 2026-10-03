/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import gloomyfolken.mods.core.main.GloomyCore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class NBTTags {
    public static HashMap<Integer, ItemStack> getItemStackList(NBTTagList nBTTagList) {
        HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            short s = nBTTagCompound._e("id");
            if (GloomyCore.config._c._c(s)) {
                int n = (Integer)GloomyCore.config._c._b(s);
                System.out.println("Replacing item id: " + s + " -> " + n);
                nBTTagCompound._a("id", (short)n);
            }
            try {
                hashMap.put(nBTTagCompound._d("Slot") & 0xFF, ItemStack._a(nBTTagCompound));
                continue;
            }
            catch (ClassCastException classCastException) {
                hashMap.put(nBTTagCompound._f("Slot"), ItemStack._a(nBTTagCompound));
            }
        }
        return hashMap;
    }

    public static ItemStack[] getItemStackArray(NBTTagList nBTTagList) {
        ItemStack[] itemStackArray = new ItemStack[nBTTagList._d()];
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            itemStackArray[nBTTagCompound._d((String)"Slot") & 0xFF] = ItemStack._a(nBTTagCompound);
        }
        return itemStackArray;
    }

    public static ArrayList getIntegerArraySet(NBTTagList nBTTagList) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagList nBTTagList2 = (NBTTagList)nBTTagList._b(i);
            int[] nArray = new int[nBTTagList2._d()];
            for (int j = 0; j < nBTTagList2._d(); ++j) {
                NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList2._b(j);
                nArray[j] = nBTTagCompound._f("Slot");
            }
            arrayList.add(nArray);
        }
        return arrayList;
    }

    public static HashMap getBooleanList(NBTTagList nBTTagList) {
        HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            hashMap.put(nBTTagCompound._f("Slot"), nBTTagCompound._o("Boolean"));
        }
        return hashMap;
    }

    public static HashMap getIntegerIntegerMap(NBTTagList nBTTagList) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            hashMap.put(nBTTagCompound._f("Slot"), nBTTagCompound._f("Integer"));
        }
        return hashMap;
    }

    public static HashMap<Integer, Double> getIntegerDoubleMap(NBTTagList nBTTagList) {
        HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            hashMap.put(nBTTagCompound._f("Slot"), nBTTagCompound._i("Double"));
        }
        return hashMap;
    }

    public static HashMap getIntegerLongMap(NBTTagList nBTTagList) {
        HashMap<Integer, Long> hashMap = new HashMap<Integer, Long>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            hashMap.put(nBTTagCompound._f("Slot"), nBTTagCompound._g("Long"));
        }
        return hashMap;
    }

    public static HashSet getIntegerSet(NBTTagList nBTTagList) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTBase nBTBase = nBTTagList._b(i);
            if (nBTBase instanceof hdfw) {
                hashSet.add(((hdfw)nBTBase)._c);
                continue;
            }
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            hashSet.add(nBTTagCompound._f("Integer"));
        }
        return hashSet;
    }

    public static HashMap getStringStringMap(NBTTagList nBTTagList) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            hashMap.put(nBTTagCompound._j("Slot"), nBTTagCompound._j("Value"));
        }
        return hashMap;
    }

    public static HashMap getIntegerStringMap(NBTTagList nBTTagList) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            hashMap.put(nBTTagCompound._f("Slot"), nBTTagCompound._j("Value"));
        }
        return hashMap;
    }

    public static HashMap getStringIntegerMap(NBTTagList nBTTagList) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            hashMap.put(nBTTagCompound._j("Slot"), nBTTagCompound._f("Value"));
        }
        return hashMap;
    }

    public static HashMap getVectorMap(NBTTagList nBTTagList) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            Vector<String> vector = new Vector<String>();
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            NBTTagList nBTTagList2 = nBTTagCompound._n("Values");
            for (int j = 0; j < nBTTagList2._d(); ++j) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList2._b(j);
                vector.add(nBTTagCompound2._j("Value"));
            }
            hashMap.put(nBTTagCompound._j("Key"), vector);
        }
        return hashMap;
    }

    public static int[] getIntArray(NBTTagList nBTTagList) {
        int[] nArray = new int[nBTTagList._d()];
        for (int i = 0; i < nBTTagList._d(); ++i) {
            nArray[i] = ((hdfw)nBTTagList._b((int)i))._c;
        }
        return nArray;
    }

    public static List getStringList(NBTTagList nBTTagList) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            String string = nBTTagCompound._j("Line");
            arrayList.add(string);
        }
        return arrayList;
    }

    public static String[] getStringArray(NBTTagList nBTTagList, int n) {
        String[] stringArray = new String[n];
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            String string = nBTTagCompound._j("Value");
            int n2 = nBTTagCompound._f("Slot");
            stringArray[n2] = string;
        }
        return stringArray;
    }

    public static NBTTagList nbtIntegerArraySet(List list2) {
        NBTTagList nBTTagList = new NBTTagList();
        if (list2 == null) {
            return nBTTagList;
        }
        for (int[] nArray : list2) {
            NBTTagList nBTTagList2 = new NBTTagList();
            int[] nArray2 = nArray;
            int n = nArray.length;
            for (int i = 0; i < n; ++i) {
                int n2 = nArray2[i];
                NBTTagCompound nBTTagCompound = new NBTTagCompound();
                nBTTagCompound._a("Slot", n2);
                nBTTagList2._a(nBTTagCompound);
            }
            nBTTagList._a(nBTTagList2);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtItemStackList(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashMap == null) {
            return nBTTagList;
        }
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            ItemStack itemStack = (ItemStack)hashMap.get(n);
            if (itemStack == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", (byte)n);
            itemStack._b(nBTTagCompound);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtItemStackArray(ItemStack[] itemStackArray) {
        NBTTagList nBTTagList = new NBTTagList();
        if (itemStackArray == null) {
            return nBTTagList;
        }
        for (int i = 0; i < itemStackArray.length; ++i) {
            ItemStack itemStack = itemStackArray[i];
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", (byte)i);
            if (itemStack != null) {
                itemStack._b(nBTTagCompound);
            }
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtBooleanList(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashMap == null) {
            return nBTTagList;
        }
        HashMap hashMap2 = hashMap;
        for (Integer n : hashMap.keySet()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", (int)n);
            nBTTagCompound._a("Boolean", (Boolean)hashMap2.get(n));
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtIntegerIntegerMap(Map map) {
        NBTTagList nBTTagList = new NBTTagList();
        if (map == null) {
            return nBTTagList;
        }
        Iterator iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", n);
            nBTTagCompound._a("Integer", (int)((Integer)map.get(n)));
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtIntegerDoubleMap(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashMap == null) {
            return nBTTagList;
        }
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", n);
            nBTTagCompound._a("Double", (Double)hashMap.get(n));
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtIntegerLongMap(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashMap == null) {
            return nBTTagList;
        }
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", n);
            nBTTagCompound._a("Long", (Long)hashMap.get(n));
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtIntegerSet(HashSet hashSet) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashSet == null) {
            return nBTTagList;
        }
        Iterator iterator2 = hashSet.iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Integer", n);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtVectorMap(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashMap == null) {
            return nBTTagList;
        }
        for (String string : hashMap.keySet()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Key", string);
            NBTTagList nBTTagList2 = new NBTTagList();
            for (String string2 : (Vector)hashMap.get(string)) {
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                nBTTagCompound2._a("Value", string2);
                nBTTagList2._a(nBTTagCompound2);
            }
            nBTTagCompound._a("Values", nBTTagList2);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtStringStringMap(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashMap == null) {
            return nBTTagList;
        }
        for (String string : hashMap.keySet()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", string);
            nBTTagCompound._a("Value", (String)hashMap.get(string));
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtStringIntegerMap(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashMap == null) {
            return nBTTagList;
        }
        for (String string : hashMap.keySet()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", string);
            nBTTagCompound._a("Value", (int)((Integer)hashMap.get(string)));
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTBase nbtIntegerStringMap(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashMap == null) {
            return nBTTagList;
        }
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", n);
            nBTTagCompound._a("Value", (String)hashMap.get(n));
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtStringArray(String[] stringArray) {
        NBTTagList nBTTagList = new NBTTagList();
        if (stringArray == null) {
            return nBTTagList;
        }
        for (int i = 0; i < stringArray.length; ++i) {
            if (stringArray[i] == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Value", stringArray[i]);
            nBTTagCompound._a("Slot", i);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static NBTTagList nbtIntArray(int[] nArray) {
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < nArray.length; ++i) {
            nBTTagList._a(new hdfw(null, nArray[i]));
        }
        return nBTTagList;
    }

    public static NBTTagList nbtStringList(List list2) {
        NBTTagList nBTTagList = new NBTTagList();
        for (String string : list2) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Line", string);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static List<String> nbtDiffLines(NBTTagCompound nBTTagCompound, NBTTagCompound nBTTagCompound2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry entry : nBTTagCompound._c.entrySet()) {
            String string = (String)entry.getKey();
            NBTBase nBTBase = (NBTBase)entry.getValue();
            String string2 = null;
            if (nBTTagCompound2._c(string)) {
                NBTBase nBTBase2 = nBTTagCompound2._b(string);
                if (!NBTTags.areEqual(nBTBase, nBTBase2)) {
                    string2 = "\"" + NBTTags.tagToString(nBTBase2) + "\"";
                }
            } else {
                string2 = "REMOVED";
            }
            if (string2 == null) continue;
            arrayList.add("\"" + string + "\": \"" + NBTTags.tagToString(nBTBase) + "\" -> " + string2 + "");
        }
        return arrayList;
    }

    private static boolean areEqual(NBTBase nBTBase, NBTBase nBTBase2) {
        if (nBTBase2 == null && nBTBase == null) {
            return true;
        }
        if (nBTBase2 == null || nBTBase == null) {
            return false;
        }
        if (nBTBase.getClass() != nBTBase2.getClass()) {
            return false;
        }
        if (nBTBase instanceof NBTTagList && ((NBTTagList)nBTBase)._d() == 0 && ((NBTTagList)nBTBase2)._d() == 0) {
            return true;
        }
        if (nBTBase instanceof NBTTagCompound) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTBase;
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTBase2;
            for (Map.Entry entry : nBTTagCompound._c.entrySet()) {
                if (NBTTags.areEqual((NBTBase)entry.getValue(), nBTTagCompound2._b((String)entry.getKey()))) continue;
                return false;
            }
            return true;
        }
        return nBTBase.equals(nBTBase2);
    }

    private static String tagToString(NBTBase nBTBase) {
        if (nBTBase instanceof NBTTagList) {
            return NBTTags.listToString((NBTTagList)nBTBase);
        }
        if (nBTBase instanceof NBTTagCompound) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTBase;
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry entry : nBTTagCompound._c.entrySet()) {
                stringBuilder.append((String)entry.getKey()).append(":").append(NBTTags.tagToString((NBTBase)entry.getValue()));
            }
            return stringBuilder.toString();
        }
        return nBTBase.toString();
    }

    private static String listToString(NBTTagList nBTTagList) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTBase nBTBase = nBTTagList._b(i);
            if (nBTBase instanceof NBTTagList) {
                stringBuilder.append(NBTTags.listToString((NBTTagList)nBTBase));
            } else {
                stringBuilder.append(nBTBase.toString());
            }
            if (i == nBTTagList._d() - 1) continue;
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}


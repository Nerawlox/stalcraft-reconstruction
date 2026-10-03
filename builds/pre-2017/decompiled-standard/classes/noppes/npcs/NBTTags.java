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

public class NBTTags {
    public static HashMap<Integer, cvzo> getItemStackList(bsyv bsyv2) {
        HashMap<Integer, cvzo> hashMap = new HashMap<Integer, cvzo>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            short s = qoac2._e("id");
            if (GloomyCore.config._c._c(s)) {
                int n = (Integer)GloomyCore.config._c._b(s);
                System.out.println("Replacing item id: " + s + " -> " + n);
                qoac2._a("id", (short)n);
            }
            try {
                hashMap.put(qoac2._d("Slot") & 0xFF, cvzo._a(qoac2));
                continue;
            }
            catch (ClassCastException classCastException) {
                hashMap.put(qoac2._f("Slot"), cvzo._a(qoac2));
            }
        }
        return hashMap;
    }

    public static cvzo[] getItemStackArray(bsyv bsyv2) {
        cvzo[] cvzoArray = new cvzo[bsyv2._d()];
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            cvzoArray[qoac2._d((String)"Slot") & 0xFF] = cvzo._a(qoac2);
        }
        return cvzoArray;
    }

    public static ArrayList getIntegerArraySet(bsyv bsyv2) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            bsyv bsyv3 = (bsyv)bsyv2._b(i);
            int[] nArray = new int[bsyv3._d()];
            for (int j = 0; j < bsyv3._d(); ++j) {
                qoac qoac2 = (qoac)bsyv3._b(j);
                nArray[j] = qoac2._f("Slot");
            }
            arrayList.add(nArray);
        }
        return arrayList;
    }

    public static HashMap getBooleanList(bsyv bsyv2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            hashMap.put(qoac2._f("Slot"), qoac2._o("Boolean"));
        }
        return hashMap;
    }

    public static HashMap getIntegerIntegerMap(bsyv bsyv2) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            hashMap.put(qoac2._f("Slot"), qoac2._f("Integer"));
        }
        return hashMap;
    }

    public static HashMap<Integer, Double> getIntegerDoubleMap(bsyv bsyv2) {
        HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            hashMap.put(qoac2._f("Slot"), qoac2._i("Double"));
        }
        return hashMap;
    }

    public static HashMap getIntegerLongMap(bsyv bsyv2) {
        HashMap<Integer, Long> hashMap = new HashMap<Integer, Long>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            hashMap.put(qoac2._f("Slot"), qoac2._g("Long"));
        }
        return hashMap;
    }

    public static HashSet getIntegerSet(bsyv bsyv2) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            huhy huhy2 = bsyv2._b(i);
            if (huhy2 instanceof hdfw) {
                hashSet.add(((hdfw)huhy2)._c);
                continue;
            }
            qoac qoac2 = (qoac)bsyv2._b(i);
            hashSet.add(qoac2._f("Integer"));
        }
        return hashSet;
    }

    public static HashMap getStringStringMap(bsyv bsyv2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            hashMap.put(qoac2._j("Slot"), qoac2._j("Value"));
        }
        return hashMap;
    }

    public static HashMap getIntegerStringMap(bsyv bsyv2) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            hashMap.put(qoac2._f("Slot"), qoac2._j("Value"));
        }
        return hashMap;
    }

    public static HashMap getStringIntegerMap(bsyv bsyv2) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            hashMap.put(qoac2._j("Slot"), qoac2._f("Value"));
        }
        return hashMap;
    }

    public static HashMap getVectorMap(bsyv bsyv2) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < bsyv2._d(); ++i) {
            Vector<String> vector = new Vector<String>();
            qoac qoac2 = (qoac)bsyv2._b(i);
            bsyv bsyv3 = qoac2._n("Values");
            for (int j = 0; j < bsyv3._d(); ++j) {
                qoac qoac3 = (qoac)bsyv3._b(j);
                vector.add(qoac3._j("Value"));
            }
            hashMap.put(qoac2._j("Key"), vector);
        }
        return hashMap;
    }

    public static int[] getIntArray(bsyv bsyv2) {
        int[] nArray = new int[bsyv2._d()];
        for (int i = 0; i < bsyv2._d(); ++i) {
            nArray[i] = ((hdfw)bsyv2._b((int)i))._c;
        }
        return nArray;
    }

    public static List getStringList(bsyv bsyv2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            String string = qoac2._j("Line");
            arrayList.add(string);
        }
        return arrayList;
    }

    public static String[] getStringArray(bsyv bsyv2, int n) {
        String[] stringArray = new String[n];
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            String string = qoac2._j("Value");
            int n2 = qoac2._f("Slot");
            stringArray[n2] = string;
        }
        return stringArray;
    }

    public static bsyv nbtIntegerArraySet(List list2) {
        bsyv bsyv2 = new bsyv();
        if (list2 == null) {
            return bsyv2;
        }
        for (int[] nArray : list2) {
            bsyv bsyv3 = new bsyv();
            int[] nArray2 = nArray;
            int n = nArray.length;
            for (int i = 0; i < n; ++i) {
                int n2 = nArray2[i];
                qoac qoac2 = new qoac();
                qoac2._a("Slot", n2);
                bsyv3._a(qoac2);
            }
            bsyv2._a(bsyv3);
        }
        return bsyv2;
    }

    public static bsyv nbtItemStackList(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        if (hashMap == null) {
            return bsyv2;
        }
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            cvzo cvzo2 = (cvzo)hashMap.get(n);
            if (cvzo2 == null) continue;
            qoac qoac2 = new qoac();
            qoac2._a("Slot", (byte)n);
            cvzo2._b(qoac2);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtItemStackArray(cvzo[] cvzoArray) {
        bsyv bsyv2 = new bsyv();
        if (cvzoArray == null) {
            return bsyv2;
        }
        for (int i = 0; i < cvzoArray.length; ++i) {
            cvzo cvzo2 = cvzoArray[i];
            qoac qoac2 = new qoac();
            qoac2._a("Slot", (byte)i);
            if (cvzo2 != null) {
                cvzo2._b(qoac2);
            }
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtBooleanList(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        if (hashMap == null) {
            return bsyv2;
        }
        HashMap hashMap2 = hashMap;
        for (Integer n : hashMap.keySet()) {
            qoac qoac2 = new qoac();
            qoac2._a("Slot", (int)n);
            qoac2._a("Boolean", (Boolean)hashMap2.get(n));
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtIntegerIntegerMap(Map map) {
        bsyv bsyv2 = new bsyv();
        if (map == null) {
            return bsyv2;
        }
        Iterator iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac2 = new qoac();
            qoac2._a("Slot", n);
            qoac2._a("Integer", (int)((Integer)map.get(n)));
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtIntegerDoubleMap(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        if (hashMap == null) {
            return bsyv2;
        }
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac2 = new qoac();
            qoac2._a("Slot", n);
            qoac2._a("Double", (Double)hashMap.get(n));
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtIntegerLongMap(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        if (hashMap == null) {
            return bsyv2;
        }
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac2 = new qoac();
            qoac2._a("Slot", n);
            qoac2._a("Long", (Long)hashMap.get(n));
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtIntegerSet(HashSet hashSet) {
        bsyv bsyv2 = new bsyv();
        if (hashSet == null) {
            return bsyv2;
        }
        Iterator iterator2 = hashSet.iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac2 = new qoac();
            qoac2._a("Integer", n);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtVectorMap(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        if (hashMap == null) {
            return bsyv2;
        }
        for (String string : hashMap.keySet()) {
            qoac qoac2 = new qoac();
            qoac2._a("Key", string);
            bsyv bsyv3 = new bsyv();
            for (String string2 : (Vector)hashMap.get(string)) {
                qoac qoac3 = new qoac();
                qoac3._a("Value", string2);
                bsyv3._a(qoac3);
            }
            qoac2._a("Values", bsyv3);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtStringStringMap(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        if (hashMap == null) {
            return bsyv2;
        }
        for (String string : hashMap.keySet()) {
            qoac qoac2 = new qoac();
            qoac2._a("Slot", string);
            qoac2._a("Value", (String)hashMap.get(string));
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtStringIntegerMap(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        if (hashMap == null) {
            return bsyv2;
        }
        for (String string : hashMap.keySet()) {
            qoac qoac2 = new qoac();
            qoac2._a("Slot", string);
            qoac2._a("Value", (int)((Integer)hashMap.get(string)));
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static huhy nbtIntegerStringMap(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        if (hashMap == null) {
            return bsyv2;
        }
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac2 = new qoac();
            qoac2._a("Slot", n);
            qoac2._a("Value", (String)hashMap.get(n));
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtStringArray(String[] stringArray) {
        bsyv bsyv2 = new bsyv();
        if (stringArray == null) {
            return bsyv2;
        }
        for (int i = 0; i < stringArray.length; ++i) {
            if (stringArray[i] == null) continue;
            qoac qoac2 = new qoac();
            qoac2._a("Value", stringArray[i]);
            qoac2._a("Slot", i);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static bsyv nbtIntArray(int[] nArray) {
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < nArray.length; ++i) {
            bsyv2._a(new hdfw(null, nArray[i]));
        }
        return bsyv2;
    }

    public static bsyv nbtStringList(List list2) {
        bsyv bsyv2 = new bsyv();
        for (String string : list2) {
            qoac qoac2 = new qoac();
            qoac2._a("Line", string);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static List<String> nbtDiffLines(qoac qoac2, qoac qoac3) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry entry : qoac2._c.entrySet()) {
            String string = (String)entry.getKey();
            huhy huhy2 = (huhy)entry.getValue();
            String string2 = null;
            if (qoac3._c(string)) {
                huhy huhy3 = qoac3._b(string);
                if (!NBTTags.areEqual(huhy2, huhy3)) {
                    string2 = "\"" + NBTTags.tagToString(huhy3) + "\"";
                }
            } else {
                string2 = "REMOVED";
            }
            if (string2 == null) continue;
            arrayList.add("\"" + string + "\": \"" + NBTTags.tagToString(huhy2) + "\" -> " + string2 + "");
        }
        return arrayList;
    }

    private static boolean areEqual(huhy huhy2, huhy huhy3) {
        if (huhy3 == null && huhy2 == null) {
            return true;
        }
        if (huhy3 == null || huhy2 == null) {
            return false;
        }
        if (huhy2.getClass() != huhy3.getClass()) {
            return false;
        }
        if (huhy2 instanceof bsyv && ((bsyv)huhy2)._d() == 0 && ((bsyv)huhy3)._d() == 0) {
            return true;
        }
        if (huhy2 instanceof qoac) {
            qoac qoac2 = (qoac)huhy2;
            qoac qoac3 = (qoac)huhy3;
            for (Map.Entry entry : qoac2._c.entrySet()) {
                if (NBTTags.areEqual((huhy)entry.getValue(), qoac3._b((String)entry.getKey()))) continue;
                return false;
            }
            return true;
        }
        return huhy2.equals(huhy3);
    }

    private static String tagToString(huhy huhy2) {
        if (huhy2 instanceof bsyv) {
            return NBTTags.listToString((bsyv)huhy2);
        }
        if (huhy2 instanceof qoac) {
            qoac qoac2 = (qoac)huhy2;
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry entry : qoac2._c.entrySet()) {
                stringBuilder.append((String)entry.getKey()).append(":").append(NBTTags.tagToString((huhy)entry.getValue()));
            }
            return stringBuilder.toString();
        }
        return huhy2.toString();
    }

    private static String listToString(bsyv bsyv2) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < bsyv2._d(); ++i) {
            huhy huhy2 = bsyv2._b(i);
            if (huhy2 instanceof bsyv) {
                stringBuilder.append(NBTTags.listToString((bsyv)huhy2));
            } else {
                stringBuilder.append(huhy2.toString());
            }
            if (i == bsyv2._d() - 1) continue;
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.oredict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class OreDictionary {
    private static boolean hasInit = false;
    private static int maxID = 0;
    private static HashMap<String, Integer> oreIDs = new HashMap();
    private static HashMap<Integer, ArrayList<cvzo>> oreStacks = new HashMap();
    public static final int WILDCARD_VALUE = Short.MAX_VALUE;

    public static void initVanillaEntries() {
        cvzo[] cvzoArray;
        if (!hasInit) {
            OreDictionary.registerOre("logWood", new cvzo(twgu.field_71951_J, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("plankWood", new cvzo(twgu.field_71988_x, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("slabWood", new cvzo(twgu.field_72092_bO, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("stairWood", twgu.field_72063_at);
            OreDictionary.registerOre("stairWood", twgu.field_72072_bX);
            OreDictionary.registerOre("stairWood", twgu.field_72070_bY);
            OreDictionary.registerOre("stairWood", twgu.field_72074_bW);
            OreDictionary.registerOre("stickWood", tgdv.field_77669_D);
            OreDictionary.registerOre("treeSapling", new cvzo(twgu.field_71987_y, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("treeLeaves", new cvzo(twgu.field_71952_K, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("oreGold", twgu.field_71941_G);
            OreDictionary.registerOre("oreIron", twgu.field_71949_H);
            OreDictionary.registerOre("oreLapis", twgu.field_71947_N);
            OreDictionary.registerOre("oreDiamond", twgu.field_72073_aw);
            OreDictionary.registerOre("oreRedstone", twgu.field_72047_aN);
            OreDictionary.registerOre("oreEmerald", twgu.field_72068_bR);
            OreDictionary.registerOre("oreQuartz", twgu.field_94342_cr);
            OreDictionary.registerOre("stone", twgu.field_71981_t);
            OreDictionary.registerOre("cobblestone", twgu.field_71978_w);
            OreDictionary.registerOre("record", tgdv.field_77819_bI);
            OreDictionary.registerOre("record", tgdv.field_77797_bJ);
            OreDictionary.registerOre("record", tgdv.field_77799_bK);
            OreDictionary.registerOre("record", tgdv.field_77793_bL);
            OreDictionary.registerOre("record", tgdv.field_77795_bM);
            OreDictionary.registerOre("record", tgdv.field_77805_bN);
            OreDictionary.registerOre("record", tgdv.field_77807_bO);
            OreDictionary.registerOre("record", tgdv.field_77801_bP);
            OreDictionary.registerOre("record", tgdv.field_77803_bQ);
            OreDictionary.registerOre("record", tgdv.field_77783_bR);
            OreDictionary.registerOre("record", tgdv.field_77781_bS);
            OreDictionary.registerOre("record", tgdv.field_85180_cf);
        }
        HashMap<cvzo, String> hashMap = new HashMap<cvzo, String>();
        hashMap.put(new cvzo(tgdv.field_77669_D), "stickWood");
        hashMap.put(new cvzo(twgu.field_71988_x), "plankWood");
        hashMap.put(new cvzo(twgu.field_71988_x, 1, Short.MAX_VALUE), "plankWood");
        hashMap.put(new cvzo(twgu.field_71981_t), "stone");
        hashMap.put(new cvzo(twgu.field_71981_t, 1, Short.MAX_VALUE), "stone");
        hashMap.put(new cvzo(twgu.field_71978_w), "cobblestone");
        hashMap.put(new cvzo(twgu.field_71978_w, 1, Short.MAX_VALUE), "cobblestone");
        String[] stringArray = new String[]{"dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite"};
        for (int i = 0; i < 16; ++i) {
            cvzoArray = new cvzo(tgdv.field_77756_aW, 1, i);
            if (!hasInit) {
                OreDictionary.registerOre(stringArray[i], (cvzo)cvzoArray);
            }
            hashMap.put((cvzo)cvzoArray, stringArray[i]);
        }
        hasInit = true;
        cvzo[] cvzoArray2 = hashMap.keySet().toArray(new cvzo[hashMap.keySet().size()]);
        cvzoArray = new cvzo[]{new cvzo(twgu.field_71948_O), new cvzo(tgdv.field_77743_bc), new cvzo(twgu.field_72007_bm), new cvzo(twgu.field_72079_ak), new cvzo(twgu.field_72057_aH), new cvzo(twgu.field_82515_ce), new cvzo(twgu.field_72063_at), new cvzo(twgu.field_72072_bX), new cvzo(twgu.field_72070_bY), new cvzo(twgu.field_72074_bW)};
        List list2 = igjl._a()._b();
        ArrayList<lpso> arrayList = new ArrayList<lpso>();
        ArrayList<lpso> arrayList2 = new ArrayList<lpso>();
        for (Object e : list2) {
            cvzo cvzo2;
            lpso lpso2;
            if (e instanceof xbtf) {
                lpso2 = (xbtf)e;
                cvzo2 = ((xbtf)lpso2).func_77571_b();
                if (cvzo2 != null && OreDictionary.containsMatch(false, cvzoArray, cvzo2) || !OreDictionary.containsMatch(true, ((xbtf)lpso2)._c, cvzoArray2)) continue;
                arrayList.add(lpso2);
                arrayList2.add(new ShapedOreRecipe((xbtf)lpso2, hashMap));
                continue;
            }
            if (!(e instanceof vmoj) || (cvzo2 = ((vmoj)(lpso2 = (vmoj)e)).func_77571_b()) != null && OreDictionary.containsMatch(false, cvzoArray, cvzo2) || !OreDictionary.containsMatch(true, ((vmoj)lpso2)._b.toArray(new cvzo[((vmoj)lpso2)._b.size()]), cvzoArray2)) continue;
            arrayList.add((lpso)e);
            ShapelessOreRecipe shapelessOreRecipe = new ShapelessOreRecipe((vmoj)lpso2, hashMap);
            arrayList2.add(shapelessOreRecipe);
        }
        list2.removeAll(arrayList);
        list2.addAll(arrayList2);
        if (arrayList.size() > 0) {
            System.out.println("Replaced " + arrayList.size() + " ore recipies");
        }
    }

    public static int getOreID(String string) {
        Integer n = oreIDs.get(string);
        if (n == null) {
            n = maxID++;
            oreIDs.put(string, n);
            oreStacks.put(n, new ArrayList());
        }
        return n;
    }

    public static String getOreName(int n) {
        for (Map.Entry<String, Integer> entry : oreIDs.entrySet()) {
            if (n != entry.getValue()) continue;
            return entry.getKey();
        }
        return "Unknown";
    }

    public static int getOreID(cvzo cvzo2) {
        if (cvzo2 == null) {
            return -1;
        }
        for (Map.Entry<Integer, ArrayList<cvzo>> entry : oreStacks.entrySet()) {
            for (cvzo cvzo3 : entry.getValue()) {
                if (cvzo2._d != cvzo3._d || cvzo3._j() != Short.MAX_VALUE && cvzo2._j() != cvzo3._j()) continue;
                return entry.getKey();
            }
        }
        return -1;
    }

    public static ArrayList<cvzo> getOres(String string) {
        return OreDictionary.getOres(OreDictionary.getOreID(string));
    }

    public static String[] getOreNames() {
        return oreIDs.keySet().toArray(new String[oreIDs.keySet().size()]);
    }

    public static ArrayList<cvzo> getOres(Integer n) {
        ArrayList<cvzo> arrayList = oreStacks.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList();
            oreStacks.put(n, arrayList);
        }
        return arrayList;
    }

    private static boolean containsMatch(boolean bl, cvzo[] cvzoArray, cvzo ... cvzoArray2) {
        for (cvzo cvzo2 : cvzoArray) {
            for (cvzo cvzo3 : cvzoArray2) {
                if (!OreDictionary.itemMatches(cvzo3, cvzo2, bl)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean itemMatches(cvzo cvzo2, cvzo cvzo3, boolean bl) {
        if (cvzo3 == null && cvzo2 != null || cvzo3 != null && cvzo2 == null) {
            return false;
        }
        return cvzo2._d == cvzo3._d && (cvzo2._j() == Short.MAX_VALUE && !bl || cvzo2._j() == cvzo3._j());
    }

    public static void registerOre(String string, tgdv tgdv2) {
        OreDictionary.registerOre(string, new cvzo(tgdv2));
    }

    public static void registerOre(String string, twgu twgu2) {
        OreDictionary.registerOre(string, new cvzo(twgu2));
    }

    public static void registerOre(String string, cvzo cvzo2) {
        OreDictionary.registerOre(string, OreDictionary.getOreID(string), cvzo2);
    }

    public static void registerOre(int n, tgdv tgdv2) {
        OreDictionary.registerOre(n, new cvzo(tgdv2));
    }

    public static void registerOre(int n, twgu twgu2) {
        OreDictionary.registerOre(n, new cvzo(twgu2));
    }

    public static void registerOre(int n, cvzo cvzo2) {
        OreDictionary.registerOre(OreDictionary.getOreName(n), n, cvzo2);
    }

    private static void registerOre(String string, int n, cvzo cvzo2) {
        ArrayList<cvzo> arrayList = OreDictionary.getOres(n);
        cvzo2 = cvzo2._l();
        arrayList.add(cvzo2);
        MinecraftForge.EVENT_BUS.post(new OreRegisterEvent(string, cvzo2));
    }

    static {
        OreDictionary.initVanillaEntries();
    }

    public static class OreRegisterEvent
    extends Event {
        public final String Name;
        public final cvzo Ore;
        private static ListenerList LISTENER_LIST;

        public OreRegisterEvent(String string, cvzo cvzo2) {
            this.Name = string;
            this.Ore = cvzo2;
        }

        public OreRegisterEvent() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }
}


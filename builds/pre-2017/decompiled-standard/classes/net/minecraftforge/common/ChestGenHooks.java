/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.util.iurq;
import net.minecraft.util.piet;
import net.minecraft.util.vjvn;

public class ChestGenHooks {
    public static final String MINESHAFT_CORRIDOR = "mineshaftCorridor";
    public static final String PYRAMID_DESERT_CHEST = "pyramidDesertyChest";
    public static final String PYRAMID_JUNGLE_CHEST = "pyramidJungleChest";
    public static final String PYRAMID_JUNGLE_DISPENSER = "pyramidJungleDispenser";
    public static final String STRONGHOLD_CORRIDOR = "strongholdCorridor";
    public static final String STRONGHOLD_LIBRARY = "strongholdLibrary";
    public static final String STRONGHOLD_CROSSING = "strongholdCrossing";
    public static final String VILLAGE_BLACKSMITH = "villageBlacksmith";
    public static final String BONUS_CHEST = "bonusChest";
    public static final String DUNGEON_CHEST = "dungeonChest";
    private static final HashMap<String, ChestGenHooks> chestInfo = new HashMap();
    private static boolean hasInit = false;
    private String category;
    private int countMin = 0;
    private int countMax = 0;
    ArrayList<vjvn> contents = new ArrayList();

    private static void init() {
        if (hasInit) {
            return;
        }
        hasInit = true;
        ChestGenHooks.addInfo(MINESHAFT_CORRIDOR, mtob._a, 3, 7);
        ChestGenHooks.addInfo(PYRAMID_DESERT_CHEST, qowq._f, 2, 7);
        ChestGenHooks.addInfo(PYRAMID_JUNGLE_CHEST, zipx._i, 2, 7);
        ChestGenHooks.addInfo(PYRAMID_JUNGLE_DISPENSER, zipx._j, 2, 2);
        ChestGenHooks.addInfo(STRONGHOLD_CORRIDOR, oiqc._b, 2, 4);
        ChestGenHooks.addInfo(STRONGHOLD_LIBRARY, cwpq._b, 1, 5);
        ChestGenHooks.addInfo(STRONGHOLD_CROSSING, wqhb._b, 1, 5);
        ChestGenHooks.addInfo(VILLAGE_BLACKSMITH, xtkf._e, 3, 9);
        ChestGenHooks.addInfo(BONUS_CHEST, yfgy.field_73069_S, 10, 10);
        ChestGenHooks.addInfo(DUNGEON_CHEST, grvu._a, 8, 8);
        cvzo cvzo2 = new cvzo(tgdv.field_92105_bW, 1, 0);
        vjvn vjvn2 = new vjvn(cvzo2, 1, 1, 1);
        ChestGenHooks.getInfo(MINESHAFT_CORRIDOR).addItem(vjvn2);
        ChestGenHooks.getInfo(PYRAMID_DESERT_CHEST).addItem(vjvn2);
        ChestGenHooks.getInfo(PYRAMID_JUNGLE_CHEST).addItem(vjvn2);
        ChestGenHooks.getInfo(STRONGHOLD_CORRIDOR).addItem(vjvn2);
        ChestGenHooks.getInfo(STRONGHOLD_LIBRARY).addItem(new vjvn(cvzo2, 1, 5, 2));
        ChestGenHooks.getInfo(STRONGHOLD_CROSSING).addItem(vjvn2);
        ChestGenHooks.getInfo(DUNGEON_CHEST).addItem(vjvn2);
    }

    static void addDungeonLoot(ChestGenHooks chestGenHooks, cvzo cvzo2, int n, int n2, int n3) {
        chestGenHooks.addItem(new vjvn(cvzo2, n2, n3, n));
    }

    private static void addInfo(String string, vjvn[] vjvnArray, int n, int n2) {
        chestInfo.put(string, new ChestGenHooks(string, vjvnArray, n, n2));
    }

    public static ChestGenHooks getInfo(String string) {
        if (!chestInfo.containsKey(string)) {
            chestInfo.put(string, new ChestGenHooks(string));
        }
        return chestInfo.get(string);
    }

    public static cvzo[] generateStacks(Random random, cvzo cvzo2, int n, int n2) {
        cvzo[] cvzoArray;
        int n3 = n + random.nextInt(n2 - n + 1);
        if (cvzo2._a() == null) {
            cvzoArray = new cvzo[]{};
        } else if (n3 > cvzo2._d()) {
            cvzoArray = new cvzo[n3];
            for (int i = 0; i < n3; ++i) {
                cvzoArray[i] = cvzo2._l();
                cvzoArray[i]._b = 1;
            }
        } else {
            cvzoArray = new cvzo[]{cvzo2._l()};
            cvzoArray[0]._b = n3;
        }
        return cvzoArray;
    }

    public static vjvn[] getItems(String string, Random random) {
        return ChestGenHooks.getInfo(string).getItems(random);
    }

    public static int getCount(String string, Random random) {
        return ChestGenHooks.getInfo(string).getCount(random);
    }

    public static void addItem(String string, vjvn vjvn2) {
        ChestGenHooks.getInfo(string).addItem(vjvn2);
    }

    public static void removeItem(String string, cvzo cvzo2) {
        ChestGenHooks.getInfo(string).removeItem(cvzo2);
    }

    public static cvzo getOneItem(String string, Random random) {
        return ChestGenHooks.getInfo(string).getOneItem(random);
    }

    public ChestGenHooks(String string) {
        this.category = string;
    }

    public ChestGenHooks(String string, vjvn[] vjvnArray, int n, int n2) {
        this(string);
        for (vjvn vjvn2 : vjvnArray) {
            this.contents.add(vjvn2);
        }
        this.countMin = n;
        this.countMax = n2;
    }

    public void addItem(vjvn vjvn2) {
        this.contents.add(vjvn2);
    }

    public void removeItem(cvzo cvzo2) {
        Iterator<vjvn> iterator2 = this.contents.iterator();
        while (iterator2.hasNext()) {
            vjvn vjvn2 = iterator2.next();
            if (!cvzo2._b(vjvn2._a) && (cvzo2._j() != Short.MAX_VALUE || cvzo2._d != vjvn2._a._d)) continue;
            iterator2.remove();
        }
    }

    public vjvn[] getItems(Random random) {
        ArrayList<vjvn> arrayList = new ArrayList<vjvn>();
        for (vjvn vjvn2 : this.contents) {
            vjvn vjvn3;
            tgdv tgdv2 = vjvn2._a._a();
            if (tgdv2 == null || (vjvn3 = tgdv2.getChestGenBase(this, random, vjvn2)) == null) continue;
            arrayList.add(vjvn3);
        }
        return arrayList.toArray(new vjvn[arrayList.size()]);
    }

    public int getCount(Random random) {
        return this.countMin < this.countMax ? this.countMin + random.nextInt(this.countMax - this.countMin) : this.countMin;
    }

    public cvzo getOneItem(Random random) {
        piet[] pietArray = this.getItems(random);
        vjvn vjvn2 = (vjvn)iurq._a(random, pietArray);
        cvzo[] cvzoArray = ChestGenHooks.generateStacks(random, vjvn2._a, vjvn2._b, vjvn2._c);
        return cvzoArray.length > 0 ? cvzoArray[0] : null;
    }

    public int getMin() {
        return this.countMin;
    }

    public int getMax() {
        return this.countMax;
    }

    public void setMin(int n) {
        this.countMin = n;
    }

    public void setMax(int n) {
        this.countMax = n;
    }

    static {
        ChestGenHooks.init();
    }
}


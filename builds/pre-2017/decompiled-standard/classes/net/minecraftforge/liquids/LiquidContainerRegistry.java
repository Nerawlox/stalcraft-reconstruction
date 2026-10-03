/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidStack;

@Deprecated
public class LiquidContainerRegistry {
    public static final int BUCKET_VOLUME = 1000;
    public static final cvzo EMPTY_BUCKET = new cvzo(tgdv.field_77788_aw);
    private static Map<List, LiquidContainerData> mapFilledItemFromLiquid = new HashMap<List, LiquidContainerData>();
    private static Map<List, LiquidContainerData> mapLiquidFromFilledItem = new HashMap<List, LiquidContainerData>();
    private static Set<List> setContainerValidation = new HashSet<List>();
    private static Set<List> setLiquidValidation = new HashSet<List>();
    private static ArrayList<LiquidContainerData> liquids = new ArrayList();

    public static void registerLiquid(LiquidContainerData liquidContainerData) {
        mapFilledItemFromLiquid.put(Arrays.asList(liquidContainerData.container._d, liquidContainerData.container._j(), liquidContainerData.stillLiquid.itemID, liquidContainerData.stillLiquid.itemMeta), liquidContainerData);
        mapLiquidFromFilledItem.put(Arrays.asList(liquidContainerData.filled._d, liquidContainerData.filled._j()), liquidContainerData);
        setContainerValidation.add(Arrays.asList(liquidContainerData.container._d, liquidContainerData.container._j()));
        setLiquidValidation.add(Arrays.asList(liquidContainerData.stillLiquid.itemID, liquidContainerData.stillLiquid.itemMeta));
        liquids.add(liquidContainerData);
    }

    public static LiquidStack getLiquidForFilledItem(cvzo cvzo2) {
        if (cvzo2 == null) {
            return null;
        }
        LiquidContainerData liquidContainerData = mapLiquidFromFilledItem.get(Arrays.asList(cvzo2._d, cvzo2._j()));
        return liquidContainerData == null ? null : liquidContainerData.stillLiquid.copy();
    }

    public static cvzo fillLiquidContainer(LiquidStack liquidStack, cvzo cvzo2) {
        if (cvzo2 == null || liquidStack == null) {
            return null;
        }
        LiquidContainerData liquidContainerData = mapFilledItemFromLiquid.get(Arrays.asList(cvzo2._d, cvzo2._j(), liquidStack.itemID, liquidStack.itemMeta));
        if (liquidContainerData != null && liquidStack.amount >= liquidContainerData.stillLiquid.amount) {
            return liquidContainerData.filled._l();
        }
        return null;
    }

    public static boolean containsLiquid(cvzo cvzo2, LiquidStack liquidStack) {
        if (cvzo2 == null || liquidStack == null) {
            return false;
        }
        LiquidContainerData liquidContainerData = mapLiquidFromFilledItem.get(Arrays.asList(cvzo2._d, cvzo2._j()));
        return liquidContainerData != null && liquidContainerData.stillLiquid.isLiquidEqual(liquidStack);
    }

    public static boolean isBucket(cvzo cvzo2) {
        if (cvzo2 == null) {
            return false;
        }
        if (cvzo2._b(EMPTY_BUCKET)) {
            return true;
        }
        LiquidContainerData liquidContainerData = mapLiquidFromFilledItem.get(Arrays.asList(cvzo2._d, cvzo2._j()));
        return liquidContainerData != null && liquidContainerData.container._b(EMPTY_BUCKET);
    }

    public static boolean isContainer(cvzo cvzo2) {
        return LiquidContainerRegistry.isEmptyContainer(cvzo2) || LiquidContainerRegistry.isFilledContainer(cvzo2);
    }

    public static boolean isEmptyContainer(cvzo cvzo2) {
        return cvzo2 != null && setContainerValidation.contains(Arrays.asList(cvzo2._d, cvzo2._j()));
    }

    public static boolean isFilledContainer(cvzo cvzo2) {
        return cvzo2 != null && LiquidContainerRegistry.getLiquidForFilledItem(cvzo2) != null;
    }

    public static boolean isLiquid(cvzo cvzo2) {
        return cvzo2 != null && setLiquidValidation.contains(Arrays.asList(cvzo2._d, cvzo2._j()));
    }

    public static LiquidContainerData[] getRegisteredLiquidContainerData() {
        return liquids.toArray(new LiquidContainerData[liquids.size()]);
    }

    static {
        LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(twgu.field_71943_B, 1000), new cvzo(tgdv.field_77786_ax), new cvzo(tgdv.field_77788_aw)));
        LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(twgu.field_71938_D, 1000), new cvzo(tgdv.field_77775_ay), new cvzo(tgdv.field_77788_aw)));
        LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(twgu.field_71943_B, 1000), new cvzo(tgdv.field_77726_bs), new cvzo(tgdv.field_77729_bt)));
    }
}


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
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidStack;

@Deprecated
public class LiquidContainerRegistry {
    public static final int BUCKET_VOLUME = 1000;
    public static final ItemStack EMPTY_BUCKET = new ItemStack(Item.bucketEmpty);
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

    public static LiquidStack getLiquidForFilledItem(ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        LiquidContainerData liquidContainerData = mapLiquidFromFilledItem.get(Arrays.asList(itemStack._d, itemStack._j()));
        return liquidContainerData == null ? null : liquidContainerData.stillLiquid.copy();
    }

    public static ItemStack fillLiquidContainer(LiquidStack liquidStack, ItemStack itemStack) {
        if (itemStack == null || liquidStack == null) {
            return null;
        }
        LiquidContainerData liquidContainerData = mapFilledItemFromLiquid.get(Arrays.asList(itemStack._d, itemStack._j(), liquidStack.itemID, liquidStack.itemMeta));
        if (liquidContainerData != null && liquidStack.amount >= liquidContainerData.stillLiquid.amount) {
            return liquidContainerData.filled._l();
        }
        return null;
    }

    public static boolean containsLiquid(ItemStack itemStack, LiquidStack liquidStack) {
        if (itemStack == null || liquidStack == null) {
            return false;
        }
        LiquidContainerData liquidContainerData = mapLiquidFromFilledItem.get(Arrays.asList(itemStack._d, itemStack._j()));
        return liquidContainerData != null && liquidContainerData.stillLiquid.isLiquidEqual(liquidStack);
    }

    public static boolean isBucket(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack._b(EMPTY_BUCKET)) {
            return true;
        }
        LiquidContainerData liquidContainerData = mapLiquidFromFilledItem.get(Arrays.asList(itemStack._d, itemStack._j()));
        return liquidContainerData != null && liquidContainerData.container._b(EMPTY_BUCKET);
    }

    public static boolean isContainer(ItemStack itemStack) {
        return LiquidContainerRegistry.isEmptyContainer(itemStack) || LiquidContainerRegistry.isFilledContainer(itemStack);
    }

    public static boolean isEmptyContainer(ItemStack itemStack) {
        return itemStack != null && setContainerValidation.contains(Arrays.asList(itemStack._d, itemStack._j()));
    }

    public static boolean isFilledContainer(ItemStack itemStack) {
        return itemStack != null && LiquidContainerRegistry.getLiquidForFilledItem(itemStack) != null;
    }

    public static boolean isLiquid(ItemStack itemStack) {
        return itemStack != null && setLiquidValidation.contains(Arrays.asList(itemStack._d, itemStack._j()));
    }

    public static LiquidContainerData[] getRegisteredLiquidContainerData() {
        return liquids.toArray(new LiquidContainerData[liquids.size()]);
    }

    static {
        LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(Block.waterStill, 1000), new ItemStack(Item.bucketWater), new ItemStack(Item.bucketEmpty)));
        LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(Block.lavaStill, 1000), new ItemStack(Item.bucketLava), new ItemStack(Item.bucketEmpty)));
        LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(Block.waterStill, 1000), new ItemStack(Item.potion), new ItemStack(Item.glassBottle)));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Throwables;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.io.Files;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.ItemData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class GameData {
    private static Map<Integer, ItemData> idMap = Maps.newHashMap();
    private static CountDownLatch serverValidationLatch;
    private static CountDownLatch clientValidationLatch;
    private static MapDifference<Integer, ItemData> difference;
    private static boolean shouldContinue;
    private static boolean isSaveValid;
    private static ImmutableTable<String, String, Integer> modObjectTable;
    private static Table<String, String, ItemStack> customItemStacks;
    private static Map<String, String> ignoredMods;
    private static boolean validated;

    private static boolean isModIgnoredForIdValidation(String string) {
        if (ignoredMods == null) {
            File file = new File(Loader.instance().getConfigDir(), "fmlIDChecking.properties");
            if (file.exists()) {
                Properties properties = new Properties();
                try {
                    properties.load(new FileInputStream(file));
                    ignoredMods = Maps.fromProperties(properties);
                    if (ignoredMods.size() > 0) {
                        FMLLog.log("fml.ItemTracker", Level.WARNING, "Using non-empty ignored mods configuration file %s", ignoredMods.keySet());
                    }
                }
                catch (Exception exception) {
                    Throwables.propagateIfPossible(exception);
                    FMLLog.log("fml.ItemTracker", Level.SEVERE, exception, "Failed to read ignored ID checker mods properties file", new Object[0]);
                    ignoredMods = ImmutableMap.of();
                }
            } else {
                ignoredMods = ImmutableMap.of();
            }
        }
        return ignoredMods.containsKey(string);
    }

    public static void newItemAdded(Item item) {
        ModContainer modContainer = Loader.instance().activeModContainer();
        if (modContainer == null) {
            modContainer = Loader.instance().getMinecraftModContainer();
            if (Loader.instance().hasReachedState(LoaderState.INITIALIZATION) || validated) {
                FMLLog.severe("It appears something has tried to allocate an Item or Block outside of the preinitialization phase for mods. This will NOT work in 1.7 and beyond!", new Object[0]);
            }
        }
        String string = item.getClass().getName();
        ItemData itemData = new ItemData(item, modContainer);
        if (idMap.containsKey(item.itemID)) {
            ItemData itemData2 = idMap.get(item.itemID);
            FMLLog.log("fml.ItemTracker", Level.INFO, "The mod %s is overwriting existing item at %d (%s from %s) with %s", modContainer.getModId(), itemData2.getItemId(), itemData2.getItemType(), itemData2.getModId(), string);
        }
        idMap.put(item.itemID, itemData);
        if (!"Minecraft".equals(modContainer.getModId())) {
            FMLLog.log("fml.ItemTracker", Level.FINE, "Adding item %s(%d) owned by %s", item.getClass().getName(), item.itemID, modContainer.getModId());
        }
    }

    public static void validateWorldSave(Set<ItemData> set) {
        isSaveValid = true;
        shouldContinue = true;
        if (set == null) {
            serverValidationLatch.countDown();
            try {
                clientValidationLatch.await();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            return;
        }
        Function<ItemData, Integer> function = new Function<ItemData, Integer>(){

            @Override
            public Integer apply(ItemData itemData) {
                return itemData.getItemId();
            }
        };
        ImmutableMap<Integer, ItemData> immutableMap = Maps.uniqueIndex(set, function);
        difference = Maps.difference(immutableMap, idMap);
        FMLLog.log("fml.ItemTracker", Level.FINE, "The difference set is %s", difference);
        if (!difference.entriesDiffering().isEmpty() || !difference.entriesOnlyOnLeft().isEmpty()) {
            FMLLog.log("fml.ItemTracker", Level.SEVERE, "FML has detected item discrepancies", new Object[0]);
            FMLLog.log("fml.ItemTracker", Level.SEVERE, "Missing items : %s", difference.entriesOnlyOnLeft());
            FMLLog.log("fml.ItemTracker", Level.SEVERE, "Mismatched items : %s", difference.entriesDiffering());
            boolean bl = false;
            for (ItemData object : difference.entriesOnlyOnLeft().values()) {
                if (GameData.isModIgnoredForIdValidation(object.getModId())) continue;
                bl = true;
            }
            for (MapDifference.ValueDifference valueDifference : difference.entriesDiffering().values()) {
                if (GameData.isModIgnoredForIdValidation(((ItemData)valueDifference.leftValue()).getModId()) || GameData.isModIgnoredForIdValidation(((ItemData)valueDifference.rightValue()).getModId())) continue;
                bl = true;
            }
            if (!bl) {
                FMLLog.log("fml.ItemTracker", Level.SEVERE, "FML is ignoring these ID discrepancies because of configuration. YOUR GAME WILL NOW PROBABLY CRASH. HOPEFULLY YOU WON'T HAVE CORRUPTED YOUR WORLD. BLAME %s", ignoredMods.keySet());
            }
            isSaveValid = !bl;
            serverValidationLatch.countDown();
        } else {
            isSaveValid = true;
            serverValidationLatch.countDown();
        }
        try {
            clientValidationLatch.await();
            if (!shouldContinue) {
                throw new RuntimeException("This server instance is going to stop abnormally because of a fatal ID mismatch");
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public static void writeItemData(NBTTagList nBTTagList) {
        for (ItemData itemData : idMap.values()) {
            nBTTagList._a(itemData.toNBT());
        }
    }

    public static void initializeServerGate(int n) {
        serverValidationLatch = new CountDownLatch(n - 1);
        clientValidationLatch = new CountDownLatch(n - 1);
    }

    public static MapDifference<Integer, ItemData> gateWorldLoadingForValidation() {
        try {
            serverValidationLatch.await();
            if (!isSaveValid) {
                return difference;
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        difference = null;
        return null;
    }

    public static void releaseGate(boolean bl) {
        shouldContinue = bl;
        clientValidationLatch.countDown();
    }

    public static Set<ItemData> buildWorldItemData(NBTTagList nBTTagList) {
        HashSet<ItemData> hashSet = Sets.newHashSet();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            ItemData itemData = new ItemData(nBTTagCompound);
            hashSet.add(itemData);
        }
        return hashSet;
    }

    static void setName(Item item, String string, String string2) {
        int n = item.itemID;
        ItemData itemData = idMap.get(n);
        itemData.setName(string, string2);
    }

    public static void buildModObjectTable() {
        if (modObjectTable != null) {
            throw new IllegalStateException("Illegal call to buildModObjectTable!");
        }
        Map<Integer, Table.Cell<String, String, Integer>> map = Maps.transformValues(idMap, new Function<ItemData, Table.Cell<String, String, Integer>>(){

            @Override
            public Table.Cell<String, String, Integer> apply(ItemData itemData) {
                if ("Minecraft".equals(itemData.getModId()) || !itemData.isOveridden()) {
                    return null;
                }
                return Tables.immutableCell(itemData.getModId(), itemData.getItemType(), itemData.getItemId());
            }
        });
        ImmutableTable.Builder<String, String, Integer> builder = ImmutableTable.builder();
        for (Table.Cell<String, String, Integer> cell : map.values()) {
            if (cell == null) continue;
            builder.put(cell);
        }
        modObjectTable = builder.build();
    }

    static Item findItem(String string, String string2) {
        if (modObjectTable == null || !modObjectTable.contains(string, string2)) {
            return null;
        }
        return Item.itemsList[(Integer)modObjectTable.get(string, string2)];
    }

    static Block findBlock(String string, String string2) {
        if (modObjectTable == null) {
            return null;
        }
        Integer n = (Integer)modObjectTable.get(string, string2);
        if (n == null || n >= Block.blocksList.length) {
            return null;
        }
        return Block.blocksList[n];
    }

    static ItemStack findItemStack(String string, String string2) {
        Object object;
        ItemStack itemStack = customItemStacks.get(string, string2);
        if (itemStack == null && (object = GameData.findItem(string, string2)) != null) {
            itemStack = new ItemStack((Item)object, 0, 0);
        }
        if (itemStack == null && (object = GameData.findBlock(string, string2)) != null) {
            itemStack = new ItemStack((Block)object, 0, Short.MAX_VALUE);
        }
        return itemStack;
    }

    static void registerCustomItemStack(String string, ItemStack itemStack) {
        customItemStacks.put(Loader.instance().activeModContainer().getModId(), string, itemStack);
    }

    public static void dumpRegistry(File file) {
        if (customItemStacks == null) {
            return;
        }
        if (Boolean.valueOf(System.getProperty("fml.dumpRegistry", "false")).booleanValue()) {
            ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
            for (String object2 : customItemStacks.rowKeySet()) {
                builder.putAll((Object)object2, customItemStacks.row(object2).keySet());
            }
            File file2 = new File(file, "itemStackRegistry.csv");
            Joiner.MapJoiner mapJoiner = Joiner.on("\n").withKeyValueSeparator(",");
            try {
                Files.write(mapJoiner.join(builder.build().entries()), file2, Charsets.UTF_8);
                FMLLog.log(Level.INFO, "Dumped item registry data to %s", file2.getAbsolutePath());
            }
            catch (IOException iOException) {
                FMLLog.log(Level.SEVERE, iOException, "Failed to write registry data to %s", file2.getAbsolutePath());
            }
        }
    }

    static GameRegistry.UniqueIdentifier getUniqueName(Block block) {
        if (block == null) {
            return null;
        }
        ItemData itemData = idMap.get(block.blockID);
        if (itemData == null || !itemData.isOveridden() || customItemStacks.contains(itemData.getModId(), itemData.getItemType())) {
            return null;
        }
        return new GameRegistry.UniqueIdentifier(itemData.getModId(), itemData.getItemType());
    }

    static GameRegistry.UniqueIdentifier getUniqueName(Item item) {
        if (item == null) {
            return null;
        }
        ItemData itemData = idMap.get(item.itemID);
        if (itemData == null || !itemData.isOveridden() || customItemStacks.contains(itemData.getModId(), itemData.getItemType())) {
            return null;
        }
        return new GameRegistry.UniqueIdentifier(itemData.getModId(), itemData.getItemType());
    }

    public static void validateRegistry() {
        for (int i = 0; i < Item.itemsList.length; ++i) {
            if (Item.itemsList[i] == null) continue;
            ItemData itemData = idMap.get(i);
            if (itemData == null) {
                FMLLog.severe("Found completely unknown item of class %s with ID %d, this will NOT work for a 1.7 upgrade", Item.itemsList[i].getClass().getName(), i);
                continue;
            }
            if (itemData.isOveridden() || "Minecraft".equals(itemData.getModId())) continue;
            FMLLog.severe("Found anonymous item of class %s with ID %d owned by mod %s, this item will NOT survive a 1.7 upgrade!", Item.itemsList[i].getClass().getName(), i, itemData.getModId());
        }
        validated = true;
    }

    static {
        shouldContinue = true;
        isSaveValid = true;
        customItemStacks = HashBasedTable.create();
    }
}


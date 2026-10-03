/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.oredict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class OreDictionary {
    private static boolean hasInit = false;
    private static int maxID = 0;
    private static HashMap<String, Integer> oreIDs = new HashMap();
    private static HashMap<Integer, ArrayList<ItemStack>> oreStacks = new HashMap();
    public static final int WILDCARD_VALUE = Short.MAX_VALUE;

    public static void initVanillaEntries() {
        ItemStack[] itemStackArray;
        if (!hasInit) {
            OreDictionary.registerOre("logWood", new ItemStack(Block.wood, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("plankWood", new ItemStack(Block.planks, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("slabWood", new ItemStack(Block.woodSingleSlab, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("stairWood", Block.stairsWoodOak);
            OreDictionary.registerOre("stairWood", Block.stairsWoodBirch);
            OreDictionary.registerOre("stairWood", Block.stairsWoodJungle);
            OreDictionary.registerOre("stairWood", Block.stairsWoodSpruce);
            OreDictionary.registerOre("stickWood", Item.stick);
            OreDictionary.registerOre("treeSapling", new ItemStack(Block.sapling, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("treeLeaves", new ItemStack(Block.leaves, 1, Short.MAX_VALUE));
            OreDictionary.registerOre("oreGold", Block.oreGold);
            OreDictionary.registerOre("oreIron", Block.oreIron);
            OreDictionary.registerOre("oreLapis", Block.oreLapis);
            OreDictionary.registerOre("oreDiamond", Block.oreDiamond);
            OreDictionary.registerOre("oreRedstone", Block.oreRedstone);
            OreDictionary.registerOre("oreEmerald", Block.oreEmerald);
            OreDictionary.registerOre("oreQuartz", Block.oreNetherQuartz);
            OreDictionary.registerOre("stone", Block.stone);
            OreDictionary.registerOre("cobblestone", Block.cobblestone);
            OreDictionary.registerOre("record", Item.record13);
            OreDictionary.registerOre("record", Item.recordCat);
            OreDictionary.registerOre("record", Item.recordBlocks);
            OreDictionary.registerOre("record", Item.recordChirp);
            OreDictionary.registerOre("record", Item.recordFar);
            OreDictionary.registerOre("record", Item.recordMall);
            OreDictionary.registerOre("record", Item.recordMellohi);
            OreDictionary.registerOre("record", Item.recordStal);
            OreDictionary.registerOre("record", Item.recordStrad);
            OreDictionary.registerOre("record", Item.recordWard);
            OreDictionary.registerOre("record", Item.record11);
            OreDictionary.registerOre("record", Item.recordWait);
        }
        HashMap<ItemStack, String> hashMap = new HashMap<ItemStack, String>();
        hashMap.put(new ItemStack(Item.stick), "stickWood");
        hashMap.put(new ItemStack(Block.planks), "plankWood");
        hashMap.put(new ItemStack(Block.planks, 1, Short.MAX_VALUE), "plankWood");
        hashMap.put(new ItemStack(Block.stone), "stone");
        hashMap.put(new ItemStack(Block.stone, 1, Short.MAX_VALUE), "stone");
        hashMap.put(new ItemStack(Block.cobblestone), "cobblestone");
        hashMap.put(new ItemStack(Block.cobblestone, 1, Short.MAX_VALUE), "cobblestone");
        String[] stringArray = new String[]{"dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite"};
        for (int i = 0; i < 16; ++i) {
            itemStackArray = new ItemStack(Item.dyePowder, 1, i);
            if (!hasInit) {
                OreDictionary.registerOre(stringArray[i], (ItemStack)itemStackArray);
            }
            hashMap.put((ItemStack)itemStackArray, stringArray[i]);
        }
        hasInit = true;
        ItemStack[] itemStackArray2 = hashMap.keySet().toArray(new ItemStack[hashMap.keySet().size()]);
        itemStackArray = new ItemStack[]{new ItemStack(Block.blockLapis), new ItemStack(Item.cookie), new ItemStack(Block.stoneBrick), new ItemStack(Block.stoneSingleSlab), new ItemStack(Block.stairsCobblestone), new ItemStack(Block.cobblestoneWall), new ItemStack(Block.stairsWoodOak), new ItemStack(Block.stairsWoodBirch), new ItemStack(Block.stairsWoodJungle), new ItemStack(Block.stairsWoodSpruce)};
        List list2 = CraftingManager._a()._b();
        ArrayList<lpso> arrayList = new ArrayList<lpso>();
        ArrayList<lpso> arrayList2 = new ArrayList<lpso>();
        for (Object e : list2) {
            ItemStack itemStack;
            lpso lpso2;
            if (e instanceof xbtf) {
                lpso2 = (xbtf)e;
                itemStack = ((xbtf)lpso2).getRecipeOutput();
                if (itemStack != null && OreDictionary.containsMatch(false, itemStackArray, itemStack) || !OreDictionary.containsMatch(true, ((xbtf)lpso2)._c, itemStackArray2)) continue;
                arrayList.add(lpso2);
                arrayList2.add(new ShapedOreRecipe((xbtf)lpso2, hashMap));
                continue;
            }
            if (!(e instanceof vmoj) || (itemStack = ((vmoj)(lpso2 = (vmoj)e)).getRecipeOutput()) != null && OreDictionary.containsMatch(false, itemStackArray, itemStack) || !OreDictionary.containsMatch(true, ((vmoj)lpso2)._b.toArray(new ItemStack[((vmoj)lpso2)._b.size()]), itemStackArray2)) continue;
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

    public static int getOreID(ItemStack itemStack) {
        if (itemStack == null) {
            return -1;
        }
        for (Map.Entry<Integer, ArrayList<ItemStack>> entry : oreStacks.entrySet()) {
            for (ItemStack itemStack2 : entry.getValue()) {
                if (itemStack._d != itemStack2._d || itemStack2._j() != Short.MAX_VALUE && itemStack._j() != itemStack2._j()) continue;
                return entry.getKey();
            }
        }
        return -1;
    }

    public static ArrayList<ItemStack> getOres(String string) {
        return OreDictionary.getOres(OreDictionary.getOreID(string));
    }

    public static String[] getOreNames() {
        return oreIDs.keySet().toArray(new String[oreIDs.keySet().size()]);
    }

    public static ArrayList<ItemStack> getOres(Integer n) {
        ArrayList<ItemStack> arrayList = oreStacks.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList();
            oreStacks.put(n, arrayList);
        }
        return arrayList;
    }

    private static boolean containsMatch(boolean bl, ItemStack[] itemStackArray, ItemStack ... itemStackArray2) {
        for (ItemStack itemStack : itemStackArray) {
            for (ItemStack itemStack2 : itemStackArray2) {
                if (!OreDictionary.itemMatches(itemStack2, itemStack, bl)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean itemMatches(ItemStack itemStack, ItemStack itemStack2, boolean bl) {
        if (itemStack2 == null && itemStack != null || itemStack2 != null && itemStack == null) {
            return false;
        }
        return itemStack._d == itemStack2._d && (itemStack._j() == Short.MAX_VALUE && !bl || itemStack._j() == itemStack2._j());
    }

    public static void registerOre(String string, Item item) {
        OreDictionary.registerOre(string, new ItemStack(item));
    }

    public static void registerOre(String string, Block block) {
        OreDictionary.registerOre(string, new ItemStack(block));
    }

    public static void registerOre(String string, ItemStack itemStack) {
        OreDictionary.registerOre(string, OreDictionary.getOreID(string), itemStack);
    }

    public static void registerOre(int n, Item item) {
        OreDictionary.registerOre(n, new ItemStack(item));
    }

    public static void registerOre(int n, Block block) {
        OreDictionary.registerOre(n, new ItemStack(block));
    }

    public static void registerOre(int n, ItemStack itemStack) {
        OreDictionary.registerOre(OreDictionary.getOreName(n), n, itemStack);
    }

    private static void registerOre(String string, int n, ItemStack itemStack) {
        ArrayList<ItemStack> arrayList = OreDictionary.getOres(n);
        itemStack = itemStack._l();
        arrayList.add(itemStack);
        MinecraftForge.EVENT_BUS.post(new OreRegisterEvent(string, itemStack));
    }

    static {
        OreDictionary.initVanillaEntries();
    }

    public static class OreRegisterEvent
    extends Event {
        public final String Name;
        public final ItemStack Ore;
        private static ListenerList LISTENER_LIST;

        public OreRegisterEvent(String string, ItemStack itemStack) {
            this.Name = string;
            this.Ore = itemStack;
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


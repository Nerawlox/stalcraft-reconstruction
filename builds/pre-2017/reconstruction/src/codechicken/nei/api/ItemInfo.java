/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.core.CommonUtils;
import codechicken.lib.inventory.ItemKey;
import codechicken.lib.lang.LangUtil;
import codechicken.nei.InfiniteStackSizeHandler;
import codechicken.nei.InfiniteToolHandler;
import codechicken.nei.MultiItemRange;
import codechicken.nei.PopupInputHandler;
import codechicken.nei.api.API;
import codechicken.nei.api.IHighlightHandler;
import codechicken.nei.api.IInfiniteItemHandler;
import codechicken.nei.config.ArrayDumper;
import codechicken.nei.config.ItemPanelDumper;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.recipe.BrewingRecipeHandler;
import codechicken.nei.recipe.RecipeItemInputHandler;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.jgro;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.zwaw;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.IShearable;

public class ItemInfo {
    public static final HashMap<Layout, ArrayList<IHighlightHandler>> highlightHandlers = new HashMap();
    public static final HashMap<ItemKey, String> fallbackNames = new HashMap();
    public static final HashSet<Integer> excludeIds = new HashSet();
    public static final HashSet<Integer> nonUnlimitedIds = new HashSet();
    public static final HashMap<Integer, ArrayList<int[]>> damageVariants = new HashMap();
    public static final ArrayList<int[]> defaultDamageRange = new ArrayList();
    public static final HashMap<Integer, ArrayList<ItemStack>> itemcompounds = new HashMap();
    public static final LinkedList<IInfiniteItemHandler> infiniteHandlers = new LinkedList();
    public static final HashMap<Integer, ArrayList<IHighlightHandler>> highlightIdentifiers = new HashMap();
    public static final HashSet<Class<? extends Slot>> fastTransferExemptions = new HashSet();
    public static final String[] itemOwners = new String[Item.itemsList.length];

    public static boolean isHidden(int n) {
        return excludeIds.contains(n);
    }

    public static ArrayList<int[]> getItemDamageVariants(int n) {
        ArrayList<int[]> arrayList = damageVariants.get(n);
        return arrayList == null ? defaultDamageRange : arrayList;
    }

    public static String getOverrideName(int n, int n2) {
        ItemKey itemKey = new ItemKey(n, n2);
        return fallbackNames.get(itemKey);
    }

    public static boolean canItemBeUnlimited(int n) {
        return !nonUnlimitedIds.contains(n);
    }

    public static ArrayList<ItemStack> getItemCompounds(int n) {
        return itemcompounds.get(n);
    }

    public static void load(World world) {
        defaultDamageRange.add(new int[]{0, 15});
        ItemInfo.addVanillaBlockProperties();
        ItemInfo.addDefaultDropDowns();
        ItemInfo.searchItems();
        ItemInfo.parseModItems();
        ItemInfo.addSpawnEggs();
        new BrewingRecipeHandler().searchPotions();
        ItemInfo.addInfiniteHandlers();
        ItemInfo.addInputHandlers();
        ItemInfo.addIDDumps();
    }

    private static void addIDDumps() {
        API.addOption(new ArrayDumper<Item>("tools.dump.item"){

            @Override
            public String[] header() {
                return new String[]{"ID", "Block/Item", "Mod", "Unlocalised name", "Class"};
            }

            @Override
            public String[] dump(int n, Item item) {
                Block block = n < Block.blocksList.length ? Block.blocksList[n] : null;
                return new String[]{Integer.toString(n), block != null ? "Block" : "Item", itemOwners[n], block != null ? block.getUnlocalizedName() : item.getUnlocalizedName(), (block != null ? block : item).getClass().getCanonicalName()};
            }

            public Item[] array() {
                return Item.itemsList;
            }
        });
        API.addOption(new ArrayDumper<Potion>("tools.dump.potion"){

            @Override
            public String[] header() {
                return new String[]{"ID", "Unlocalised name", "Class"};
            }

            @Override
            public String[] dump(int n, Potion potion) {
                return new String[]{Integer.toString(n), potion._c(), potion.getClass().getCanonicalName()};
            }

            public Potion[] array() {
                return Potion._a;
            }
        });
        API.addOption(new ArrayDumper<Enchantment>("tools.dump.enchantment"){

            @Override
            public String[] header() {
                return new String[]{"ID", "Unlocalised name", "Type", "Min Level", "Max Level", "Class"};
            }

            @Override
            public String[] dump(int n, Enchantment enchantment) {
                return new String[]{Integer.toString(n), enchantment._d(), enchantment._A.toString(), Integer.toString(enchantment._b()), Integer.toString(enchantment._c()), enchantment.getClass().getCanonicalName()};
            }

            public Enchantment[] array() {
                return Enchantment._a;
            }
        });
        API.addOption(new ArrayDumper<BiomeGenBase>("tools.dump.biome"){

            @Override
            public String[] header() {
                return new String[]{"ID", "Name", "Temperature", "Rainfall", "Spawn Chance", "Min Height", "Max Height", "Types", "Class"};
            }

            @Override
            public String[] dump(int n, BiomeGenBase biomeGenBase) {
                BiomeDictionary.Type[] typeArray = BiomeDictionary.getTypesForBiome(biomeGenBase);
                StringBuilder stringBuilder = new StringBuilder();
                for (BiomeDictionary.Type type : typeArray) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(type.name());
                }
                return new String[]{Integer.toString(n), biomeGenBase._y, Float.toString(biomeGenBase._k()), Float.toString(biomeGenBase._j()), Float.toString(biomeGenBase._g()), Float.toString(biomeGenBase._D), Float.toString(biomeGenBase._E), stringBuilder.toString(), biomeGenBase.getClass().getCanonicalName()};
            }

            public BiomeGenBase[] array() {
                return BiomeGenBase._a;
            }
        });
        API.addOption(new ItemPanelDumper("tools.dump.itempanel"));
    }

    private static void parseModItems() {
        Object object;
        NBTTagList nBTTagList = new NBTTagList();
        GameData.writeItemData(nBTTagList);
        HashMap<String, MultiItemRange> hashMap = new HashMap<String, MultiItemRange>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            Map.Entry entry = new ItemData((NBTTagCompound)nBTTagList._b(i));
            object = (MultiItemRange)hashMap.get(((ItemData)((Object)entry)).getModId());
            if (object == null) {
                object = new MultiItemRange();
                hashMap.put(((ItemData)((Object)entry)).getModId(), (MultiItemRange)object);
            }
            ItemInfo.itemOwners[((ItemData)((Object)entry)).getItemId()] = ((ItemData)((Object)entry)).getModId();
            ((MultiItemRange)object).add(((ItemData)((Object)entry)).getItemId());
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            object = (String)entry.getKey();
            ModContainer modContainer = CommonUtils.findModContainer((String)object);
            Object object2 = modContainer == null ? object : modContainer.getName();
            API.addSetRange("Mod." + (String)object2, (MultiItemRange)entry.getValue());
        }
    }

    private static void addInputHandlers() {
        GuiContainerManager.addInputHandler(new RecipeItemInputHandler());
        GuiContainerManager.addInputHandler(new PopupInputHandler());
    }

    private static void addInfiniteHandlers() {
        API.addInfiniteItemHandler(new InfiniteStackSizeHandler());
        API.addInfiniteItemHandler(new InfiniteToolHandler());
    }

    private static void addVanillaBlockProperties() {
        API.setOverrideName(Block.waterMoving.blockID, 0, "Water Source");
        API.setMaxDamageException(Block.waterMoving.blockID, 0);
        API.setOverrideName(Block.waterStill.blockID, 0, "Water Still");
        API.setMaxDamageException(Block.waterStill.blockID, 0);
        API.setOverrideName(Block.lavaMoving.blockID, 0, "Lava Source");
        API.setMaxDamageException(Block.lavaMoving.blockID, 0);
        API.setOverrideName(Block.lavaStill.blockID, 0, "Lava Still");
        API.setMaxDamageException(Block.lavaStill.blockID, 0);
        API.setOverrideName(Block.silverfish.blockID, 0, "Silverfish Stone");
        API.setOverrideName(Block.endPortal.blockID, 0, "End Portal");
        API.setOverrideName(Block.endPortalFrame.blockID, 0, "End Portal Frame");
        API.hideItem(Block.pistonExtension.blockID);
        API.hideItem(Block.pistonMoving.blockID);
        API.hideItem(Block.melonStem.blockID);
        API.hideItem(Block.pumpkinStem.blockID);
        API.hideItem(Block.bed.blockID);
        API.hideItem(Block.redstoneWire.blockID);
        API.hideItem(Block.crops.blockID);
        API.hideItem(Block.signPost.blockID);
        API.hideItem(Block.doorWood.blockID);
        API.hideItem(Block.signWall.blockID);
        API.hideItem(Block.doorIron.blockID);
        API.hideItem(Block.oreRedstoneGlowing.blockID);
        API.hideItem(Block.torchRedstoneIdle.blockID);
        API.hideItem(Block.reed.blockID);
        API.hideItem(Block.redstoneRepeaterIdle.blockID);
        API.hideItem(Block.redstoneRepeaterActive.blockID);
        API.hideItem(Block.cauldron.blockID);
        API.hideItem(Block.netherStalk.blockID);
        API.hideItem(Block.brewingStand.blockID);
        API.hideItem(Block.furnaceBurning.blockID);
        API.hideItem(Block.redstoneLampActive.blockID);
        API.hideItem(Block.flowerPot.blockID);
        API.hideItem(Block.carrot.blockID);
        API.hideItem(Block.potato.blockID);
        API.hideItem(Block.skull.blockID);
        API.hideItem(Block.tripWire.blockID);
    }

    private static void addDefaultDropDowns() {
        API.addSetRange("Blocks", new MultiItemRange("[0-32000]"){

            @Override
            public void addItemIfInRange(int n, int n2, NBTTagCompound nBTTagCompound) {
                if (n < Block.blocksList.length && Block.blocksList[n] != null && Block.blocksList[n].blockMaterial != Material._a) {
                    super.addItemIfInRange(n, n2, nBTTagCompound);
                }
            }
        });
        API.addSetRange("Items", new MultiItemRange("[0-32000]"){

            @Override
            public void addItemIfInRange(int n, int n2, NBTTagCompound nBTTagCompound) {
                if (n >= Block.blocksList.length || Block.blocksList[n] == null || Block.blocksList[n].blockMaterial == Material._a) {
                    super.addItemIfInRange(n, n2, nBTTagCompound);
                }
            }
        });
        API.addSetRange("Blocks.MobSpawners", new MultiItemRange("[52]"));
    }

    private static void searchItems() {
        MultiItemRange multiItemRange = new MultiItemRange();
        MultiItemRange multiItemRange2 = new MultiItemRange();
        MultiItemRange multiItemRange3 = new MultiItemRange();
        MultiItemRange multiItemRange4 = new MultiItemRange();
        MultiItemRange multiItemRange5 = new MultiItemRange();
        MultiItemRange multiItemRange6 = new MultiItemRange();
        MultiItemRange multiItemRange7 = new MultiItemRange();
        MultiItemRange multiItemRange8 = new MultiItemRange();
        MultiItemRange multiItemRange9 = new MultiItemRange();
        MultiItemRange multiItemRange10 = new MultiItemRange();
        MultiItemRange multiItemRange11 = new MultiItemRange();
        MultiItemRange multiItemRange12 = new MultiItemRange();
        MultiItemRange multiItemRange13 = new MultiItemRange();
        MultiItemRange multiItemRange14 = new MultiItemRange();
        MultiItemRange[] multiItemRangeArray = new MultiItemRange[CreativeTabs.creativeTabArray.length];
        for (CreativeTabs object : CreativeTabs.creativeTabArray) {
            multiItemRangeArray[object.getTabIndex()] = new MultiItemRange();
        }
        for (Item item : Item.itemsList) {
            if (item == null) continue;
            CreativeTabs creativeTabs = item.getCreativeTab();
            if (creativeTabs != null) {
                multiItemRangeArray[creativeTabs.getTabIndex()].add(item);
            }
            if (item.isDamageable()) {
                multiItemRange.add(item);
                if (item instanceof hufu) {
                    multiItemRange2.add(item);
                } else if (item instanceof bsws) {
                    multiItemRange3.add(item);
                } else if (item instanceof bsrw) {
                    multiItemRange4.add(item);
                } else if (item instanceof zhxn) {
                    multiItemRange5.add(item);
                } else if (item instanceof ItemSword) {
                    multiItemRange6.add(item);
                } else if (item instanceof ItemArmor) {
                    switch (((ItemArmor)item).armorType) {
                        case 0: {
                            multiItemRange8.add(item);
                            break;
                        }
                        case 1: {
                            multiItemRange7.add(item);
                            break;
                        }
                        case 2: {
                            multiItemRange9.add(item);
                            break;
                        }
                        case 3: {
                            multiItemRange10.add(item);
                        }
                    }
                } else if (item == Item.arrow || item == Item.bow) {
                    multiItemRange12.add(item);
                } else if (item == Item.fishingRod || item == Item.flintAndSteel || item == Item.shears) {
                    multiItemRange11.add(item);
                }
            }
            if (item instanceof ItemFood) {
                multiItemRange13.add(item);
            }
            if (!item.isPotionIngredient()) continue;
            BrewingRecipeHandler.ingredientIDs.add(item.itemID);
            multiItemRange14.add(item);
        }
        API.addSetRange("Items.Tools.Pickaxes", multiItemRange2);
        API.addSetRange("Items.Tools.Shovels", multiItemRange3);
        API.addSetRange("Items.Tools.Axes", multiItemRange4);
        API.addSetRange("Items.Tools.Hoes", multiItemRange5);
        API.addSetRange("Items.Tools.Other", multiItemRange11);
        API.addSetRange("Items.Weapons.Swords", multiItemRange6);
        API.addSetRange("Items.Weapons.Ranged", multiItemRange12);
        API.addSetRange("Items.Armor.ChestPlates", multiItemRange7);
        API.addSetRange("Items.Armor.Leggings", multiItemRange9);
        API.addSetRange("Items.Armor.Helmets", multiItemRange8);
        API.addSetRange("Items.Armor.Boots", multiItemRange10);
        API.addSetRange("Items.Food", multiItemRange13);
        API.addSetRange("Items.Potions.Ingredients", multiItemRange14);
        for (CreativeTabs creativeTabs : CreativeTabs.creativeTabArray) {
            if (multiItemRangeArray[creativeTabs.getTabIndex()].ranges.size() <= 0) continue;
            API.addSetRange("CreativeTabs." + LangUtil.translateG(creativeTabs.getTranslatedTabLabel(), new Object[0]), multiItemRangeArray[creativeTabs.getTabIndex()]);
        }
    }

    private static void addSpawnEggs() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        try {
            HashMap hashMap = (HashMap)jgro._d;
            arrayList.add((Integer)hashMap.get(EntityMooshroom.class));
            arrayList.add((Integer)hashMap.get(EntitySkeleton.class));
            arrayList.add((Integer)hashMap.get(EntityCreeper.class));
            arrayList.add((Integer)hashMap.get(EntitySlime.class));
            arrayList.add((Integer)hashMap.get(EntityZombie.class));
            arrayList.add((Integer)hashMap.get(EntitySpider.class));
            arrayList.add((Integer)hashMap.get(EntityChicken.class));
            arrayList.add((Integer)hashMap.get(EntityCaveSpider.class));
            arrayList.add((Integer)hashMap.get(EntityCow.class));
            arrayList.add((Integer)hashMap.get(EntityEnderman.class));
            arrayList.add((Integer)hashMap.get(EntityWolf.class));
            arrayList.add((Integer)hashMap.get(EntityPigZombie.class));
            arrayList.add((Integer)hashMap.get(EntitySquid.class));
            arrayList.add((Integer)hashMap.get(EntityGhast.class));
            arrayList.add((Integer)hashMap.get(EntityMagmaCube.class));
            arrayList.add((Integer)hashMap.get(EntitySheep.class));
            arrayList.add((Integer)hashMap.get(EntityBlaze.class));
            arrayList.add((Integer)hashMap.get(EntityVillager.class));
            arrayList.add((Integer)hashMap.get(EntitySilverfish.class));
            arrayList.add((Integer)hashMap.get(EntityPig.class));
            arrayList.add((Integer)hashMap.get(EntityOcelot.class));
            ItemInfo.addEntityEgg(arrayList, (Integer)hashMap.get(EntitySnowman.class), 0xEEFFFF, 16753185);
            ItemInfo.addEntityEgg(arrayList, (Integer)hashMap.get(EntityIronGolem.class), 12960449, 16769484);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        API.setItemDamageVariants(Item.monsterPlacer.itemID, arrayList);
    }

    private static void addEntityEgg(ArrayList<Integer> arrayList, Integer n, int n2, int n3) {
        arrayList.add(n);
        jgro._f.put(n, new zwaw(n, n2, n3));
    }

    public static ArrayList<ItemStack> getIdentifierItems(World world, EntityPlayer entityPlayer, MovingObjectPosition movingObjectPosition) {
        Object object2;
        int n = movingObjectPosition._d;
        int n2 = movingObjectPosition._e;
        int n3 = movingObjectPosition._f;
        Block block = Block.blocksList[world.getBlockId(n, n2, n3)];
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        ArrayList arrayList2 = new ArrayList();
        if (highlightIdentifiers.get(0) != null) {
            arrayList2.addAll(highlightIdentifiers.get(0));
        }
        if (highlightIdentifiers.get(block.blockID) != null) {
            arrayList2.addAll(highlightIdentifiers.get(block.blockID));
        }
        for (Object object2 : arrayList2) {
            ItemStack itemStack = object2.identifyHighlight(world, entityPlayer, movingObjectPosition);
            if (itemStack == null) continue;
            arrayList.add(itemStack);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        ItemStack itemStack = block.getPickBlock(movingObjectPosition, world, n, n2, n3);
        if (itemStack != null) {
            arrayList.add(itemStack);
        }
        try {
            arrayList.addAll(block.getBlockDropped(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0));
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (block instanceof IShearable && (object2 = (IShearable)((Object)block)).isShearable(new ItemStack(Item.shears), world, n, n2, n3)) {
            arrayList.addAll(object2.onSheared(new ItemStack(Item.shears), world, n, n2, n3, 0));
        }
        if (arrayList.size() == 0) {
            arrayList.add(0, new ItemStack(block, 1, world.getBlockMetadata(n, n2, n3)));
        }
        return arrayList;
    }

    public static void registerHighlightHandler(IHighlightHandler iHighlightHandler, Layout ... layoutArray) {
        for (Layout layout : layoutArray) {
            highlightHandlers.get((Object)layout).add(iHighlightHandler);
        }
    }

    public static List<String> getText(ItemStack itemStack, World world, EntityPlayer entityPlayer, MovingObjectPosition movingObjectPosition) {
        List<String> list = new ArrayList<String>();
        for (Layout layout : Layout.values()) {
            for (IHighlightHandler iHighlightHandler : highlightHandlers.get((Object)layout)) {
                list = iHighlightHandler.handleTextData(itemStack, world, entityPlayer, movingObjectPosition, list, layout);
            }
        }
        return list;
    }

    static {
        for (Layout layout : Layout.values()) {
            highlightHandlers.put(layout, new ArrayList());
        }
    }

    public static enum Layout {
        HEADER,
        BODY,
        FOOTER;

    }
}


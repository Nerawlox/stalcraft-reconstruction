/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.IPickupNotifier;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.BlockProxy;
import cpw.mods.fml.common.registry.BlockTracker;
import cpw.mods.fml.common.registry.GameData;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class GameRegistry {
    private static Multimap<ModContainer, BlockProxy> blockRegistry = ArrayListMultimap.create();
    private static Set<IWorldGenerator> worldGenerators = Sets.newHashSet();
    private static List<IFuelHandler> fuelHandlers = Lists.newArrayList();
    private static List<ICraftingHandler> craftingHandlers = Lists.newArrayList();
    private static List<IPickupNotifier> pickupHandlers = Lists.newArrayList();
    private static List<IPlayerTracker> playerTrackers = Lists.newArrayList();

    public static void registerWorldGenerator(IWorldGenerator iWorldGenerator) {
        worldGenerators.add(iWorldGenerator);
    }

    public static void generateWorld(int n, int n2, World world, IChunkProvider iChunkProvider, IChunkProvider iChunkProvider2) {
        long l = world.getSeed();
        Random random = new Random(l);
        long l2 = random.nextLong() >> 3;
        long l3 = random.nextLong() >> 3;
        long l4 = l2 * (long)n + l3 * (long)n2 ^ l;
        for (IWorldGenerator iWorldGenerator : worldGenerators) {
            random.setSeed(l4);
            iWorldGenerator.generate(random, n, n2, world, iChunkProvider, iChunkProvider2);
        }
    }

    public static Object buildBlock(ModContainer modContainer, Class<?> clazz, Mod.Block block) throws Exception {
        Object obj = clazz.getConstructor(Integer.TYPE).newInstance(GameRegistry.findSpareBlockId());
        GameRegistry.registerBlock((Block)obj);
        return obj;
    }

    private static int findSpareBlockId() {
        return BlockTracker.nextBlockId();
    }

    public static void registerItem(Item item, String string) {
        GameRegistry.registerItem(item, string, null);
    }

    public static void registerItem(Item item, String string, String string2) {
        GameData.setName(item, string, string2);
    }

    @Deprecated
    public static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, ItemBlock.class);
    }

    public static void registerBlock(Block block, String string) {
        GameRegistry.registerBlock(block, ItemBlock.class, string);
    }

    @Deprecated
    public static void registerBlock(Block block, Class<? extends ItemBlock> clazz) {
        GameRegistry.registerBlock(block, clazz, null);
    }

    public static void registerBlock(Block block, Class<? extends ItemBlock> clazz, String string) {
        GameRegistry.registerBlock(block, clazz, string, null);
    }

    public static void registerBlock(Block block, Class<? extends ItemBlock> clazz, String string, String string2) {
        if (Loader.instance().isInState(LoaderState.CONSTRUCTING)) {
            FMLLog.warning("The mod %s is attempting to register a block whilst it it being constructed. This is bad modding practice - please use a proper mod lifecycle event.", Loader.instance().activeModContainer());
        }
        try {
            Item item;
            assert (block != null) : "registerBlock: block cannot be null";
            assert (clazz != null) : "registerBlock: itemclass cannot be null";
            int n = block.blockID - 256;
            try {
                Constructor<? extends ItemBlock> constructor = clazz.getConstructor(Integer.TYPE);
                item = constructor.newInstance(n);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Constructor<? extends ItemBlock> constructor = clazz.getConstructor(Integer.TYPE, Block.class);
                item = constructor.newInstance(n, block);
            }
            GameRegistry.registerItem(item, string, string2);
        }
        catch (Exception exception) {
            FMLLog.log(Level.SEVERE, exception, "Caught an exception during block registration", new Object[0]);
            throw new LoaderException(exception);
        }
        blockRegistry.put(Loader.instance().activeModContainer(), block);
    }

    public static void addRecipe(ItemStack itemStack, Object ... objectArray) {
        GameRegistry.addShapedRecipe(itemStack, objectArray);
    }

    public static lpso addShapedRecipe(ItemStack itemStack, Object ... objectArray) {
        return CraftingManager._a()._a(itemStack, objectArray);
    }

    public static void addShapelessRecipe(ItemStack itemStack, Object ... objectArray) {
        CraftingManager._a()._b(itemStack, objectArray);
    }

    public static void addRecipe(lpso lpso2) {
        CraftingManager._a()._b().add(lpso2);
    }

    public static void addSmelting(int n, ItemStack itemStack, float f) {
        yewu._a()._a(n, itemStack, f);
    }

    public static void registerTileEntity(Class<? extends TileEntity> clazz, String string) {
        TileEntity.addMapping(clazz, string);
    }

    public static void registerTileEntityWithAlternatives(Class<? extends TileEntity> clazz, String string, String ... stringArray) {
        TileEntity.addMapping(clazz, string);
        Map map = (Map)ObfuscationReflectionHelper.getPrivateValue(TileEntity.class, null, "field_70326_a", "nameToClassMap", "a");
        for (String string2 : stringArray) {
            if (map.containsKey(string2)) continue;
            map.put(string2, clazz);
        }
    }

    public static void addBiome(BiomeGenBase biomeGenBase) {
        nwix._d._a(biomeGenBase);
    }

    public static void removeBiome(BiomeGenBase biomeGenBase) {
        nwix._d._b(biomeGenBase);
    }

    public static void registerFuelHandler(IFuelHandler iFuelHandler) {
        fuelHandlers.add(iFuelHandler);
    }

    public static int getFuelValue(ItemStack itemStack) {
        int n = 0;
        for (IFuelHandler iFuelHandler : fuelHandlers) {
            n = Math.max(n, iFuelHandler.getBurnTime(itemStack));
        }
        return n;
    }

    public static void registerCraftingHandler(ICraftingHandler iCraftingHandler) {
        craftingHandlers.add(iCraftingHandler);
    }

    public static void onItemCrafted(EntityPlayer entityPlayer, ItemStack itemStack, IInventory iInventory) {
        for (ICraftingHandler iCraftingHandler : craftingHandlers) {
            iCraftingHandler.onCrafting(entityPlayer, itemStack, iInventory);
        }
    }

    public static void onItemSmelted(EntityPlayer entityPlayer, ItemStack itemStack) {
        for (ICraftingHandler iCraftingHandler : craftingHandlers) {
            iCraftingHandler.onSmelting(entityPlayer, itemStack);
        }
    }

    public static void registerPickupHandler(IPickupNotifier iPickupNotifier) {
        pickupHandlers.add(iPickupNotifier);
    }

    public static void onPickupNotification(EntityPlayer entityPlayer, EntityItem entityItem) {
        for (IPickupNotifier iPickupNotifier : pickupHandlers) {
            iPickupNotifier.notifyPickup(entityItem, entityPlayer);
        }
    }

    public static void registerPlayerTracker(IPlayerTracker iPlayerTracker) {
        playerTrackers.add(iPlayerTracker);
    }

    public static void onPlayerLogin(EntityPlayer entityPlayer) {
        for (IPlayerTracker iPlayerTracker : playerTrackers) {
            try {
                iPlayerTracker.onPlayerLogin(entityPlayer);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "A critical error occured handling the onPlayerLogin event with player tracker %s", iPlayerTracker.getClass().getName());
            }
        }
    }

    public static void onPlayerLogout(EntityPlayer entityPlayer) {
        for (IPlayerTracker iPlayerTracker : playerTrackers) {
            try {
                iPlayerTracker.onPlayerLogout(entityPlayer);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "A critical error occured handling the onPlayerLogout event with player tracker %s", iPlayerTracker.getClass().getName());
            }
        }
    }

    public static void onPlayerChangedDimension(EntityPlayer entityPlayer) {
        for (IPlayerTracker iPlayerTracker : playerTrackers) {
            try {
                iPlayerTracker.onPlayerChangedDimension(entityPlayer);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "A critical error occured handling the onPlayerChangedDimension event with player tracker %s", iPlayerTracker.getClass().getName());
            }
        }
    }

    public static void onPlayerRespawn(EntityPlayer entityPlayer) {
        for (IPlayerTracker iPlayerTracker : playerTrackers) {
            try {
                iPlayerTracker.onPlayerRespawn(entityPlayer);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "A critical error occured handling the onPlayerRespawn event with player tracker %s", iPlayerTracker.getClass().getName());
            }
        }
    }

    public static Block findBlock(String string, String string2) {
        return GameData.findBlock(string, string2);
    }

    public static Item findItem(String string, String string2) {
        return GameData.findItem(string, string2);
    }

    public static void registerCustomItemStack(String string, ItemStack itemStack) {
        GameData.registerCustomItemStack(string, itemStack);
    }

    public static ItemStack findItemStack(String string, String string2, int n) {
        ItemStack itemStack = GameData.findItemStack(string, string2);
        if (itemStack != null) {
            ItemStack itemStack2 = itemStack._l();
            itemStack2._b = Math.min(n, itemStack2._d());
            return itemStack2;
        }
        return null;
    }

    public static UniqueIdentifier findUniqueIdentifierFor(Block block) {
        return GameData.getUniqueName(block);
    }

    public static UniqueIdentifier findUniqueIdentifierFor(Item item) {
        return GameData.getUniqueName(item);
    }

    public static class UniqueIdentifier {
        public final String modId;
        public final String name;

        UniqueIdentifier(String string, String string2) {
            this.modId = string;
            this.name = string2;
        }
    }
}


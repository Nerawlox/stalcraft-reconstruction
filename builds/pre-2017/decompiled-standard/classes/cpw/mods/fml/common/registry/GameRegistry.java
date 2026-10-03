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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

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

    public static void generateWorld(int n, int n2, ozlu ozlu2, mccn mccn2, mccn mccn3) {
        long l = ozlu2.func_72905_C();
        Random random = new Random(l);
        long l2 = random.nextLong() >> 3;
        long l3 = random.nextLong() >> 3;
        long l4 = l2 * (long)n + l3 * (long)n2 ^ l;
        for (IWorldGenerator iWorldGenerator : worldGenerators) {
            random.setSeed(l4);
            iWorldGenerator.generate(random, n, n2, ozlu2, mccn2, mccn3);
        }
    }

    public static Object buildBlock(ModContainer modContainer, Class<?> clazz, Mod.Block block) throws Exception {
        Object obj = clazz.getConstructor(Integer.TYPE).newInstance(GameRegistry.findSpareBlockId());
        GameRegistry.registerBlock((twgu)obj);
        return obj;
    }

    private static int findSpareBlockId() {
        return BlockTracker.nextBlockId();
    }

    public static void registerItem(tgdv tgdv2, String string) {
        GameRegistry.registerItem(tgdv2, string, null);
    }

    public static void registerItem(tgdv tgdv2, String string, String string2) {
        GameData.setName(tgdv2, string, string2);
    }

    @Deprecated
    public static void registerBlock(twgu twgu2) {
        GameRegistry.registerBlock(twgu2, mbpd.class);
    }

    public static void registerBlock(twgu twgu2, String string) {
        GameRegistry.registerBlock(twgu2, mbpd.class, string);
    }

    @Deprecated
    public static void registerBlock(twgu twgu2, Class<? extends mbpd> clazz) {
        GameRegistry.registerBlock(twgu2, clazz, null);
    }

    public static void registerBlock(twgu twgu2, Class<? extends mbpd> clazz, String string) {
        GameRegistry.registerBlock(twgu2, clazz, string, null);
    }

    public static void registerBlock(twgu twgu2, Class<? extends mbpd> clazz, String string, String string2) {
        if (Loader.instance().isInState(LoaderState.CONSTRUCTING)) {
            FMLLog.warning("The mod %s is attempting to register a block whilst it it being constructed. This is bad modding practice - please use a proper mod lifecycle event.", Loader.instance().activeModContainer());
        }
        try {
            tgdv tgdv2;
            assert (twgu2 != null) : "registerBlock: block cannot be null";
            assert (clazz != null) : "registerBlock: itemclass cannot be null";
            int n = twgu2.field_71990_ca - 256;
            try {
                Constructor<? extends mbpd> constructor = clazz.getConstructor(Integer.TYPE);
                tgdv2 = constructor.newInstance(n);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Constructor<? extends mbpd> constructor = clazz.getConstructor(Integer.TYPE, twgu.class);
                tgdv2 = constructor.newInstance(n, twgu2);
            }
            GameRegistry.registerItem(tgdv2, string, string2);
        }
        catch (Exception exception) {
            FMLLog.log(Level.SEVERE, exception, "Caught an exception during block registration", new Object[0]);
            throw new LoaderException(exception);
        }
        blockRegistry.put(Loader.instance().activeModContainer(), twgu2);
    }

    public static void addRecipe(cvzo cvzo2, Object ... objectArray) {
        GameRegistry.addShapedRecipe(cvzo2, objectArray);
    }

    public static lpso addShapedRecipe(cvzo cvzo2, Object ... objectArray) {
        return igjl._a()._a(cvzo2, objectArray);
    }

    public static void addShapelessRecipe(cvzo cvzo2, Object ... objectArray) {
        igjl._a()._b(cvzo2, objectArray);
    }

    public static void addRecipe(lpso lpso2) {
        igjl._a()._b().add(lpso2);
    }

    public static void addSmelting(int n, cvzo cvzo2, float f) {
        yewu._a()._a(n, cvzo2, f);
    }

    public static void registerTileEntity(Class<? extends hurg> clazz, String string) {
        hurg.func_70306_a(clazz, string);
    }

    public static void registerTileEntityWithAlternatives(Class<? extends hurg> clazz, String string, String ... stringArray) {
        hurg.func_70306_a(clazz, string);
        Map map = (Map)ObfuscationReflectionHelper.getPrivateValue(hurg.class, null, "field_70326_a", "nameToClassMap", "a");
        for (String string2 : stringArray) {
            if (map.containsKey(string2)) continue;
            map.put(string2, clazz);
        }
    }

    public static void addBiome(foqh foqh2) {
        nwix._d._a(foqh2);
    }

    public static void removeBiome(foqh foqh2) {
        nwix._d._b(foqh2);
    }

    public static void registerFuelHandler(IFuelHandler iFuelHandler) {
        fuelHandlers.add(iFuelHandler);
    }

    public static int getFuelValue(cvzo cvzo2) {
        int n = 0;
        for (IFuelHandler iFuelHandler : fuelHandlers) {
            n = Math.max(n, iFuelHandler.getBurnTime(cvzo2));
        }
        return n;
    }

    public static void registerCraftingHandler(ICraftingHandler iCraftingHandler) {
        craftingHandlers.add(iCraftingHandler);
    }

    public static void onItemCrafted(EntityPlayer entityPlayer, cvzo cvzo2, mssh mssh2) {
        for (ICraftingHandler iCraftingHandler : craftingHandlers) {
            iCraftingHandler.onCrafting(entityPlayer, cvzo2, mssh2);
        }
    }

    public static void onItemSmelted(EntityPlayer entityPlayer, cvzo cvzo2) {
        for (ICraftingHandler iCraftingHandler : craftingHandlers) {
            iCraftingHandler.onSmelting(entityPlayer, cvzo2);
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

    public static twgu findBlock(String string, String string2) {
        return GameData.findBlock(string, string2);
    }

    public static tgdv findItem(String string, String string2) {
        return GameData.findItem(string, string2);
    }

    public static void registerCustomItemStack(String string, cvzo cvzo2) {
        GameData.registerCustomItemStack(string, cvzo2);
    }

    public static cvzo findItemStack(String string, String string2, int n) {
        cvzo cvzo2 = GameData.findItemStack(string, string2);
        if (cvzo2 != null) {
            cvzo cvzo3 = cvzo2._l();
            cvzo3._b = Math.min(n, cvzo3._d());
            return cvzo3;
        }
        return null;
    }

    public static UniqueIdentifier findUniqueIdentifierFor(twgu twgu2) {
        return GameData.getUniqueName(twgu2);
    }

    public static UniqueIdentifier findUniqueIdentifierFor(tgdv tgdv2) {
        return GameData.getUniqueName(tgdv2);
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

